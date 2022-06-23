package empresaiv;

/**
 *
 * @author Ronaldo R. Godoi
 */
public class Util {
    
    public double spaceToDouble(String StringValor) {
        String valor = "";
        int tamanhoString = StringValor.length();
        if(tamanhoString == 0) StringValor = "0.00";
        for(int i = 0; i < tamanhoString; i++){
            if(StringValor.charAt(i) != ' ') {
                valor = valor + StringValor.charAt(i);
            } 
        }
        if(valor.equals("")) valor = "0.00";
        return Double.parseDouble(valor);
    }
}
