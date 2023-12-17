package Tester;

import Amazon.AmazonPart2;
import enums.AmazonStates;
import nz.ac.waikato.modeljunit.*;
import nz.ac.waikato.modeljunit.coverage.ActionCoverage;
import nz.ac.waikato.modeljunit.coverage.StateCoverage;
import nz.ac.waikato.modeljunit.coverage.TransitionPairCoverage;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class AmazonTester implements FsmModel {
    private AmazonPart2 SUT = new AmazonPart2();
    private AmazonModel model = new AmazonModel();

    @Override
    public AmazonStates getState() {
        return model.getState();
    }

    @Override
    public void reset(boolean b) {
        if (b) {
            SUT = new AmazonPart2();
            model = new AmazonModel();
        }
    }


    public boolean isSignUpPage() {
        return getState().equals(AmazonStates.SignUpPage);
    }

    public @Action void setSignUpPage() {
        model.goToSignUpPage();
        assertEquals("The model's state does not match the SUT's state after going to the Sign Up page.", isSignUpPage(), true);
    }

    public boolean isLoginPage() {
        return getState().equals(AmazonStates.LoginPage);
    }

    public @Action void setLoginPage() {
        model.logIn();
        assertEquals("The model's state does not match the SUT's state after logging in.", isLoginPage(), true);
    }

    public boolean searchForProduct() {
        return getState().equals(AmazonStates.SearchForProductPage);
    }

    public @Action void setSearchForProduct() {
        model.searchForProduct();
        assertEquals("The model's state does not match the SUT's state after searching for a product.", searchForProduct(), true);
    }

    public boolean clickOnFirstProduct() {
        return getState().equals(AmazonStates.ClickOnFirstProduct);
    }

    public @Action void setClickOnFirstProduct() {
        model.clickOnFirstProduct();
        assertEquals("The model's state does not match the SUT's state after clicking on the first product.", clickOnFirstProduct(), true);
    }

    public boolean shoppingCart() {
        return getState().equals(AmazonStates.ShoppingCartPage);
    }

    public @Action void setShoppingCart() {
        model.addToCart();
        assertEquals("The model's state does not match the SUT's state after adding to the shopping cart.", shoppingCart(), true);
    }


    @Test
    public void AmazonModelRunner() {
        final Tester tester = new GreedyTester(new AmazonTester());
        tester.setRandom(new Random());
        tester.addListener(new StopOnFailureListener());
        tester.addListener("verbose");
        tester.addCoverageMetric(new TransitionPairCoverage());
        tester.addCoverageMetric(new StateCoverage());
        tester.addCoverageMetric(new ActionCoverage());
        tester.generate(10);
        tester.printCoverage();
    }
}
