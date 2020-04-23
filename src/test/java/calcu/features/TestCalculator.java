package calcu.features;

import calcu.questions.CalculationResults;
import calcu.tasks.*;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class TestCalculator {

    Actor anna = Actor.named("Anna");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;
    private Consequence seeThat;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }
    @Test
    public void Add_number1_number2() {

        anna.attemptsTo(
                Calulation.withOperator("Add").between("26").and("1").apply()

        );
        anna.should(
                seeThat(CalculationResults.calculationResult(), equalTo("27"))

        );
    }


    @Test
    public void Sub_number1_and_number2() {

        anna.attemptsTo(
                Calulation.withOperator("Sub").between("26").and("1").apply()

        );
        anna.should(
                seeThat(CalculationResults.calculationResult(), equalTo("25"))

        );
    }
    @Test
    public void Mul_number1_number2() {

        anna.attemptsTo(
                Calulation.withOperator("Mul").between("26").and("1").apply()

        );
        anna.should(
                seeThat(CalculationResults.calculationResult(), equalTo("26"))

        );
    }
    @Test
    public void Div_number1_number2() {

        anna.attemptsTo(
                Calulation.withOperator("Div").between("25").and("5").apply()

        );
        anna.should(
                seeThat(CalculationResults.calculationResult(), equalTo("5"))

        );
    }
    @After
    public void AfterTest(){
        this.herBrowser.quit();
    }

    }




