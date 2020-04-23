package calcu.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.security.PublicKey;

public class CalculatorScreen {

    public static String number="com.google.android.calculator:id/digit_";

    public static final Target Add = Target.the("#Add")
            .located(By.id("com.google.android.calculator:id/op_add"));

    public static final Target Sub= Target.the("#Sub")
            .located(By.id("com.google.android.calculator:id/op_sub"));

    public static final Target Multi = Target.the("#Multi")
            .located(By.id("com.google.android.calculator:id/op_mul"));

    public static final Target Div = Target.the("#Div")
            .located(By.id("com.google.android.calculator:id/op_div"));

    public static final Target Result =Target.the("Result")
            .located(By.id("com.google.android.calculator:id/result_preview"));


    public static final Target Clean = Target.the("Clean")
            .located(By.id("com.google.android.calculator:id/del"));




}
