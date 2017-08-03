package org.jazzteam.polishNotation.userInterface;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.jazzteam.polishNotation.core.DecisionPolishNotation;
import org.jazzteam.polishNotation.core.TranslationPolishNotation;
import org.jazzteam.polishNotation.core.ValidatorPolishNotation;

public class ActionHandlerForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPane;
	private final JTextField textField;
	private final JLabel strokaSostoania;
	private final JTextField expression;
	private final InitializationForm initialization = new InitializationForm(this);
	public Boolean flag = false;
	private DefaultListModel<String> listModel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ActionHandlerForm frame = new ActionHandlerForm();
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}

	public ActionHandlerForm() {
		setFont(new Font("Tahoma", Font.PLAIN, 10));
		setType(Type.POPUP);
		setResizable(false);
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setLocationByPlatform(true);
		setTitle("Калькулятор");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 360);
		contentPane = new JPanel();
		contentPane.setFocusable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Panel panel = new Panel();
		panel.setBackground(UIManager.getColor("PasswordField.selectionBackground"));
		panel.setBounds(10, 10, 324, 60);
		contentPane.add(panel);
		panel.setLayout(null);
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				initialization.processingPressing(e);
			}
		});
		textField.setFont(new Font("Dialog", Font.BOLD, 15));
		textField.setBounds(0, 25, 324, 35);
		panel.add(textField);
		textField.setEditable(false);
		textField.setFocusTraversalKeysEnabled(false);
		textField.setFocusable(true);
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setColumns(10);
		strokaSostoania = new JLabel("");
		strokaSostoania.setBounds(213, 315, 121, 15);
		contentPane.add(strokaSostoania);
		initialization.nine(contentPane);
		initialization.eight(contentPane);
		initialization.seven(contentPane);
		initialization.three(contentPane);
		initialization.two(contentPane);
		initialization.one(contentPane);
		initialization.six(contentPane);
		initialization.five(contentPane);
		initialization.four(contentPane);
		initialization.point(contentPane);
		initialization.zero(contentPane);
		initialization.decision(contentPane);
		initialization.backspace(contentPane, textField);
		expression = new JTextField();
		expression.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String keyCode = KeyEvent.getKeyText(e.getKeyCode());

				if (keyCode == "Enter") {
					decisionPolishNotation();
					return;
				}
			}
		});
		expression.setFocusable(false);
		expression.setEditable(false);
		expression.setFocusTraversalKeysEnabled(false);
		expression.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				expression.setFocusable(true);
				expression.setEditable(true);
			}
		});
		expression.setHorizontalAlignment(SwingConstants.RIGHT);
		expression.setBounds(0, 0, 324, 25);
		panel.add(expression);
		expression.setColumns(10);
		initialization.pow(contentPane, expression);
		initialization.btnSinx(contentPane, expression);
		initialization.add(contentPane, expression);
		initialization.sqrt(contentPane, expression, textField);
		initialization.sub(contentPane, expression);
		initialization.mul(contentPane, expression);
		initialization.div(contentPane, expression);
		initialization.btnCosx(contentPane, expression);
		initialization.btnLnx(contentPane, expression);
		initialization.abs(contentPane, textField);
		initialization.delete(contentPane, expression, textField, strokaSostoania);
		initialization.brackets(contentPane, expression, textField);
		Panel mainPanel = new Panel();
		mainPanel.setBounds(10, 70, 324, 20);
		contentPane.add(mainPanel);
		mainPanel.setLayout(new BorderLayout(5, 5));
		listModel = new DefaultListModel<String>();
		final JList<String> list = new JList<String>(listModel);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					checkException();
					displayResultTheExpression(listModel.get(list.getSelectedIndex()));
				} catch (Exception e1) {

				}

			}
		});
		list.setFont(new Font("Arial", Font.BOLD, 13));
		list.setBounds(10, 70, 325, 20);
		list.setSelectedIndex(0);
		list.setFocusable(false);
		mainPanel.add(new JScrollPane(list));
		contentPane.add(mainPanel);
	}

	protected void displayResultTheExpression(String lineWithExpression) {
		try {
			textField.setText(lineWithExpression.substring(lineWithExpression.indexOf("=") + 1));
		} catch (Exception e) {

		}
	}

	protected void fraction() {
		if (textField.getText().length() == 0) {
			textField.setText("0.");
		} else {
			int numberOfPoints = 0;
			for (int index = 0; index < textField.getText().length(); index++) {
				if (textField.getText().charAt(index) == '.') {
					numberOfPoints++;
				}
			}
			if (numberOfPoints == 0) {
				textField.setText(textField.getText() + ".");
			} else {
				return;
			}
		}
	}

	protected void abs(String lineWithExpression) {

		String lastSign = lastSign(lineWithExpression);
		if (lastSign.equals(")")) {
			textField.setText(lineWithExpression.substring(2, lineWithExpression.length() - 1));
		} else {
			textField.setText("(–" + lineWithExpression + ")");
		}
	}

	private String lastSign(String lineWithExpression) {
		String lastSign;
		try {
			lastSign = lineWithExpression.substring(lineWithExpression.length() - 1, lineWithExpression.length());
		} catch (Exception e) {
			return "";
		}
		return lastSign;
	}

	public void enteringNumbers(String number) {
		checkException();
		if (flag == false) {
			textField.setText(textField.getText() + number);
		} else {
			return;
		}
	}

	private void checkException() {
		if (strokaSostoania.getText().equals("") == false) {
			strokaSostoania.setText("");
			expression.setText("");
		}
	}

	protected void processingOperands(String lineWithExpression, String sign) {
		try {
			flag = false;
			strokaSostoania.setText("");
			String lastSign = lastSign(lineWithExpression);
			if (lastSign.equals("(") != false && textField.getText().equals("") != false) {
				return;
			}
			if (expression.getText().equals("") != false && textField.getText().equals("") != false) {
				return;
			}
			if (lastSign.equals(sign) != false && textField.getText().length() != 0) {
				expression.setText(lineWithExpression + textField.getText() + sign);
				textField.setText("");
				return;
			}
			if (lastSign.equals(sign) != false && textField.getText().length() == 0) {
				lineWithExpression = removingTheItem(lineWithExpression);
				expression.setText(lineWithExpression + sign);
				return;
			}
			if (textField.getText().equals("")) {
				if (expression.getText().charAt(expression.getText().length() - 1) == ')') {
					expression.setText(lineWithExpression + textField.getText() + sign);
					textField.setText("");
					return;
				} else {
					lineWithExpression = removingTheItem(lineWithExpression);
					lineWithExpression += sign;
					expression.setText(lineWithExpression);
					textField.setText("");
					return;
				}
			} else {
				expression.setText(lineWithExpression + textField.getText() + sign);
				textField.setText("");
				return;
			}

		} catch (Exception e) {
			expression.setText(textField.getText() + sign);
			textField.setText("");
		}
	}

	protected void decisionPolishNotation() {
		Double answer;
		flag = true;
		expression.setFocusable(false);
		expression.setEditable(false);
		strokaSostoania.setText("");
		expression.setText(expression.getText() + textField.getText());
		ValidatorPolishNotation validatorPolishNotation = new ValidatorPolishNotation();
		try {
			if (validatorPolishNotation.check(expression.getText()) != false) {
				TranslationPolishNotation translationPolishNotation = new TranslationPolishNotation();
				DecisionPolishNotation decisionPolishNotation = new DecisionPolishNotation();
				try {
					answer = decisionPolishNotation.decisionFunction(translationPolishNotation
							.translateExpressions(expression.getText()));
					if (answer.isNaN() || answer.isInfinite()) {
						throw new ArithmeticException();
					}
					if (answer % 1 == 0) {
						textField.setText(Integer.toString((int) Math.round(answer)));
					} else {
						textField.setText(Double.toString(answer));
					}
					listModel.add(0, expression.getText() + "=" + textField.getText());
				} catch (ArithmeticException e) {
					strokaSostoania.setText(" Arithmetic Exception");
					flag = false;
					textField.setText("");
					return;
				}

				expression.setText("");

			} else {
				throw new Exception();
			}
		} catch (Exception e2) {
			textField.setText("");
			strokaSostoania.setText("  Error line");
			flag = false;
		}

	}

	protected String removingTheItem(String text) {
		flag = false;
		if (text.length() != 0) {
			return text.substring(0, text.length() - 1);
		} else {
			return null;
		}

	}
}