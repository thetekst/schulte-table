package ru.msk.tkachenko.dmitry.schultetable;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dmitry tkachenko on 2/21/17.
 *
 * @author Dmitry Tkachenko
 * @version 1.0
 */
public class CustomButton extends JButton {

    public CustomButton(String text) {
        super(text);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 11));
    }
}
