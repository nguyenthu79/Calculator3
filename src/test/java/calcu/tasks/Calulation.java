package calcu.tasks;

import calcu.ui.CalculatorScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class Calulation implements Task {
    String type;
    String Number1;
    String Number2;

   public Calulation(String type, String Nunber1, String Number2){
        this.type=type;
        this.Number1=Nunber1;
        this.Number2=Number2;
    }
    public static CalulationBuilder withOperator(String type){
        return new CalulationBuilder(type);
    }



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(Target.the("number1").located(By.id(Number1_1()))),
                Click.on(Target.the("number1").located(By.id(Number1_2()))),

                Check.whether(type == "Add").andIfSo(
                        Click.on(CalculatorScreen.Add)
                ),
                Check.whether(type == "Sub").andIfSo(
                        Click.on(CalculatorScreen.Sub)
                ),
                Check.whether(type == "Mul").andIfSo(
                        Click.on(CalculatorScreen.Multi)
                ),
                Check.whether(type == "Div").andIfSo(
                        Click.on(CalculatorScreen.Div)
                ),

                Click.on(Target.the("number2").located(By.id(Number2())))
        );
    }

    public static class CalulationBuilder{
        private String type;
        private String Number1;
        private String Number2;
        public CalulationBuilder(String type){
            this.type=type;
        }
        public CalulationBuilder between(String Number1){
            this.Number1=Number1;
            return this;

        }
        public CalulationBuilder and(String Number2){
            this.Number2=Number2;
            return this;
        }
        public Calulation apply(){
            return instrumented(Calulation.class, this.type, this.Number1, this.Number2);
        }

    }


    public String Number1_1(){
        char[] arrayNumber = Number1.toCharArray();
        return CalculatorScreen.number+arrayNumber[0];
    }
    public String Number1_2(){
        char[] arrayNumber = Number1.toCharArray();
        return CalculatorScreen.number+arrayNumber[1];
    }
    public String Number2(){
        return CalculatorScreen.number+Number2;
    }


    }
