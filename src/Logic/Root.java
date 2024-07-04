package Logic;

import com.singularsys.jep.EvaluationException;
import com.singularsys.jep.functions.BinaryFunction;

public class Root extends BinaryFunction {

    /**
     * Sobrescribe el método eval para realizar una operación de potenciación con x e y.
     */
    @Override
    public Object eval(Object x, Object y) throws EvaluationException {
        int x1 = ((Number) x).intValue();
        double y1 = ((Number) y).doubleValue();
        return Math.pow(y1, 1.0 / x1);
    }
}
