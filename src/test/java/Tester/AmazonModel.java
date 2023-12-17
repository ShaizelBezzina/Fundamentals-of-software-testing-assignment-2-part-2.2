package Tester;

import enums.AmazonStates;

public class AmazonModel {
    private AmazonStates state;

    public AmazonModel() {
        this.state = AmazonStates.AmazonMainPage;
    }

    public AmazonStates getState() {
        return state;
    }

    public void setState(AmazonStates newState) {
        this.state = newState;
    }

    // Transition methods

    // Simulate going to the Sign Up page
    public void goToSignUpPage() {
        state = AmazonStates.SignUpPage;
    }

    // Simulate logging in
    public void logIn() {
        state = AmazonStates.LoginPage;
    }

    // Simulate searching for a product
    public void searchForProduct() {
        state = AmazonStates.SearchForProductPage;
    }

    // Simulate clicking on the first product
    public void clickOnFirstProduct() {
        state = AmazonStates.ClickOnFirstProduct;
    }

    // Simulate adding a product to the shopping cart
    public void addToCart() {
        state = AmazonStates.ShoppingCartPage;
    }

    // Simulate providing shipping information
    public void provideShippingInfo() {
        state = AmazonStates.ShippingInfoPage;
    }

    // Simulate providing payment information
    public void providePaymentInfo() {
        state = AmazonStates.PaymentInfoPage;
    }

    // Simulate confirming the order
    public void confirmOrder() {
        state = AmazonStates.OrderConfirmationPage;
    }

    // Other utility methods

    // Check if the current state is the Sign Up page
    public boolean isSignUpPage() {
        return state == AmazonStates.SignUpPage;
    }

    // Check if the current state is the Login page
    public boolean isLoginPage() {
        return state == AmazonStates.LoginPage;
    }

    // Add similar methods for other states...

    // Example: Check if the current state is the Order Confirmation page
    public boolean isOrderConfirmationPage() {
        return state == AmazonStates.OrderConfirmationPage;
    }
}