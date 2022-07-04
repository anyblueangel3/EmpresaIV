package empresaiv;

/**
 *
 * @author Ronaldo R. Godoi
 */
public class Util {
    
    public double spaceToDouble(String stringValor) {
        String valor = "";
        int tamanhoString = stringValor.length();
        if(tamanhoString == 0) stringValor = "0.00";
        for(int i = 0; i < stringValor.length(); i++){
            if(stringValor.charAt(i) != ' ') {
                valor = valor + stringValor.charAt(i);
            } 
        }
        if(valor.equals("")) valor = "0.00";
        return Double.parseDouble(valor);
    }
}
