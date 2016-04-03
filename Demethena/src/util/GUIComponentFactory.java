package util;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class GUIComponentFactory
{
	public static Border emptyBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
	public static Border insideLineBorder = BorderFactory.createCompoundBorder(
			emptyBorder,
			BorderFactory.createLineBorder(Color.BLACK, 2));
}
