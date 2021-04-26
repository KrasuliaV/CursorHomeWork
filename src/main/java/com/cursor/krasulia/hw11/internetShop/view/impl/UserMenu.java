package com.cursor.krasulia.hw11.internetShop.view.impl;

import com.cursor.krasulia.hw11.internetShop.model.Product;
import com.cursor.krasulia.hw11.internetShop.model.Purchase;
import com.cursor.krasulia.hw11.internetShop.model.ShoppingCart;
import com.cursor.krasulia.hw11.internetShop.model.User;
import com.cursor.krasulia.hw11.internetShop.service.ProductService;
import com.cursor.krasulia.hw11.internetShop.service.PurchaseService;
import com.cursor.krasulia.hw11.internetShop.service.impl.ProductServiceImpl;
import com.cursor.krasulia.hw11.internetShop.service.impl.PurchaseServiceImpl;
import com.cursor.krasulia.hw11.internetShop.view.Menu;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Consumer;

public class UserMenu implements Menu {

    public static final String ENTER_RIGHT_OPERATION = "Enter right operation";
    public static final String EMPTY_SHOPPING_CART = "You shopping cart is empty";

    private final ProductService productService;
    private final PurchaseService purchaseService;

    private final String[] userMenuItems = {"1.Products menu", "2.Orders menu", "0.Exit"};
    private final Scanner scanner;
    private volatile ShoppingCart shoppingCart;

    public UserMenu() {
        productService = new ProductServiceImpl();
        purchaseService = new PurchaseServiceImpl();
        scanner = new Scanner(System.in);
    }

    public void showMenu(User user) {
        showItems(userMenuItems);
        threeOperationChooser(user, this::productsSubMenuShow, this::ordersMenuShow, this::showMenu);
    }

    public void productsSubMenuShow(User user) {
        checkOrderForExistence();
        String[] productItems = {"1.Choose product", "2.Order checkout", "0.Exit"};
        showItems(productItems);
        synchronized (shoppingCart) {
            threeOperationChooser(user, this::productChooserMenu, this::checkoutOrder, this::productsSubMenuShow);
        }
    }

    private void productChooserMenu(User user) {
        checkOrderForExistence();
        System.out.println("Enter product number or B(for go to Bucket) or E(for exit from shop)");
        showProductList(productService.getAllProductList());
        synchronized (shoppingCart) {
            while (true) {
                String choice = scanner.next().toUpperCase();
                switch (choice) {
                    case "B":
                        checkoutOrder(user);
                        break;
                    case "E":
                        exit();
                        break;
                    default:
                        if (purchaseService.addProductToShoppingCart(shoppingCart, choice)) {
                            productChooserMenu(user);
                        }
                        System.out.println(ENTER_RIGHT_OPERATION);
                }
            }
        }
    }

    private void checkoutOrder(User user) {
        if (shoppingCart == null) {
            System.out.println(EMPTY_SHOPPING_CART);
            productsSubMenuShow(user);
        } else {
            List<Product> products = shoppingCart.getProductList();
            shoppingCartAction(user, products);
        }
    }

    private void shoppingCartAction(User user, List<Product> products) {
        if (products.isEmpty()) {
            System.out.println(EMPTY_SHOPPING_CART);
            productsSubMenuShow(user);
        } else {
            synchronized (shoppingCart) {
                actionChooserWithShoppingCart(user, products);
            }
        }
    }

    private void actionChooserWithShoppingCart(User user, List<Product> products) {
        showProductList(products);
        System.out.println("Choose operation: Y(confirm shopping cart) or C(for choose product) or E(for exit from shop)");
        switch (scanner.next().toUpperCase(Locale.ROOT)) {
            case "Y":
                confirmation(user);
                break;
            case "C":
                productChooserMenu(user);
                break;
            case "E":
                exit();
                break;
            default:
                System.out.println(ENTER_RIGHT_OPERATION);
                checkoutOrder(user);
        }
    }

    private void confirmation(User user) {
        System.out.println("Do you want delivery to home? Enter Y(for yes) or N(for no)");
        synchronized (shoppingCart) {
            String choice = scanner.next().toUpperCase(Locale.ROOT);
            String address = null;
            switch (choice) {
                case "Y":
                    address = getDeliveryAddress();
                case "N":
                    purchaseService.confirmShoppingCart(shoppingCart, user, address);
                    shoppingCart.getProductList().clear();
                    showMenu(user);
                    break;
                default:
                    System.out.println(ENTER_RIGHT_OPERATION);
                    confirmation(user);
            }
        }
    }

    private String getDeliveryAddress() {
        System.out.println("Enter you address for delivery");
        return scanner.next();
    }

    private void ordersMenuShow(User user) {
        System.out.println("Here you can to peek all your purchases");
        List<Purchase> orderList = user.getPurchases();
        if (orderList.isEmpty()) {
            System.out.println("You don't have some purchase in this perfect shop!");
        } else {
            System.out.println(user.getPurchases());
        }
        showMenu(user);
    }

    private void showProductList(List<Product> productList) {
        productList.stream()
                .map(product -> product.getName() + ", id = " + product.getId() + ", price = " + product.getPrice())
                .forEach(System.out::println);
    }

    private void checkOrderForExistence() {
        if (shoppingCart == null) shoppingCart = new ShoppingCart();
    }

    private void threeOperationChooser(User user, Consumer<User> consumerOne, Consumer<User> consumerTwo, Consumer<User> consumerThree) {
        switch (scanner.next()) {
            case "1":
                consumerOne.accept(user);
                break;
            case "2":
                consumerTwo.accept(user);
                break;
            case "0":
                exit();
                break;
            default:
                System.out.println(ENTER_RIGHT_OPERATION);
                consumerThree.accept(user);
        }
    }

    @Override
    public void exit() {
        new LoginMenu().show();
    }
}
