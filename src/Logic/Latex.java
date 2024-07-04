package Logic;

import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

import java.awt.*;

public class Latex {

    public Latex(){
    }

    /**
     * Crea un icono de TeX a partir de una fórmula en LaTeX.
     */
    public TeXIcon iconEnLatex(String latex){
        TeXFormula formula = new TeXFormula(latex);
        return formula.createTeXIcon(Font.BOLD,25,3);
    }
}
