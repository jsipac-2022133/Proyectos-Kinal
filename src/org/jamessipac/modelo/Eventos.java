package org.jamessipac.modelo;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 * Eventos represetna la clase en la contiene los metodos para evitar que el
 * usuario escriba datos en campos incorrectos
 *
 * @author James Sipac
 * @since 10 de septiembre de 2022
 */
public class Eventos {

    /**
     * Este metodo sirve para que el usuario solo pueda es cribir texto
     * @param evt No nos dejara escribir numeros
     */    
    public void textKeyPress(KeyEvent evt) {
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && (car != (char) KeyEvent.VK_BACK_SPACE) && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }
    /**
     * Este metodo sirve para que el usuario solo pueda escribir numeros
     * @param evt No nos dejara escribir letras
     */
    public void numberKeyPress(KeyEvent evt) {
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }
    /**
     * Este metodo sirve para que el usuario solo pueda escribir numeros, incluidos los numeros decimales
     * @param evt No nos dejara escribir letras
     * @param textField Parametro para asignar a cierto campo este metodo
     */
    public void numberDecimalKeyPress(KeyEvent evt, JTextField textField) {
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && textField.getText().contains(".") && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        } else if ((car < '0' || car > '9') && (car != '.') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }
}
