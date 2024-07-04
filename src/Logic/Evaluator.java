package Logic;

import com.singularsys.jep.EvaluationException;
import com.singularsys.jep.Jep;
import com.singularsys.jep.ParseException;
import com.singularsys.jep.misc.functions.Factorial;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Evaluator {
    private final Jep jep;

    public Evaluator(){
        jep = new Jep();
        jep.setAllowUndeclared(true);
        jep.setAllowAssignment(true);
        jep.addStandardConstants();
        jep.setImplicitMul(true);
        jep.addFunction("fact", new Factorial());
        jep.addFunction("raiz", new Root());
    }

    /**
     * Reemplaza las funciones trigonométricas (cos, sin, tan, acos) en la cadena de entrada con sus equivalentes en radianes.
     */
    private String replaceTrigFunctions(String input) {
        String patternString = "(cos|sin|tan|acos)\\((\\d+(\\.\\d+)?)\\)";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(input);

        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            String function = matcher.group(1);
            String value = matcher.group(2);
            String replacement = String.format("%s(%s * pi / 180)", function, value);
            matcher.appendReplacement(result, replacement);
        }
        matcher.appendTail(result);

        return result.toString();
    }

    /**
     * Calcula el resultado de una expresión.
     */
    // Método para calcular una expresión matemática, con soporte para grados y radianes.
    public Object calculateExpression(String expression, boolean isRad) throws ParseException, EvaluationException {

        // Reemplaza las funciones trigonométricas de grados por su equivalente en radianes.
        String inGrade = replaceTrigFunctions(expression);

        // Si el cálculo se debe hacer en radianes, no realiza la conversión y usa la expresión original.
        if (isRad) {
            inGrade = expression;
        }

        // Reemplaza "EE" por "*10^" en la expresión para manejar notación científica.
        String replaceEE = inGrade.replace("EE", "*10^");

        // Reemplaza "%" por "*1/100" en la expresión para manejar porcentajes.
        String replacePercentage = replaceEE.replace("%", "*1/100");

        // Analiza (parse) la expresión modificada usando Jep.
        jep.parse(replacePercentage);

        // Evalúa la expresión y devuelve el resultado.
        return jep.evaluate();
    }

}

