package org.jazzteam.polishNotation.userInterface;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InitializationForm {

	private final ActionHandlerForm interfacePolishNotation;
	private JButton zero;
	private JButton sub;
	private JButton mul;
	private JButton div;
	private JButton point;
	private JButton decision;
	private JButton one;
	private JButton two;
	private JButton three;
	private JButton four;
	private JButton five;
	private JButton six;
	private JButton seven;
	private JButton eight;
	private JButton add;
	private JButton nine;
	private JButton backspace;
	private JButton delete;

	public InitializationForm(ActionHandlerForm interfacePolishNotation) {
		this.interfacePolishNotation = interfacePolishNotation;

	}

	public void zero(JPanel contentPane) {
		zero = new JButton("0");
		zero.setFocusable(false);
		zero.setFocusTraversalKeysEnabled(false);
		zero.setFocusPainted(false);
		zero.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				interfacePolishNotation.enteringNumbers(zero.getText());
			}
		});
		zero.setFont(new Font("Tahoma", Font.PLAIN, 10));
		zero.setBounds(94, 285, 90, 30);
		contentPane.add(zero);
	}

	public void pow(JPanel contentPane, final JTextField expression) {
		JButton pow = new JButton("^");
		pow.setFocusable(false);
		pow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				interfacePolishNotation.processingOperands(expression.getText(), "^");
			}
		});
		pow.setFont(new Font("Tahoma", Font.PLAIN, 8));
		pow.setBounds(294, 162, 40, 30);
		contentPane.add(pow);

	}

	public void nine(JPanel contentPane) {
		nine = new JButton("9");
		nine.setFocusable(false);
		nine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				interfacePolishNotation.enteringNumbers(nine.getText());
			}
		});
		nine.setFont(new Font("Tahoma", Font.PLAIN, 10));
		nine.setBounds(194, 162, 40, 30);
		contentPane.add(nine);

	}

	public void add(JPanel contentPane, final JTextField expression) {
		add = new JButton("+");
		add.setFocusable(false);
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				interfacePolishNotation.processingOperands(expression.getText(), "+");
			}
		});
		add.setFont(new Font("Tahoma", Font.PLAIN, 8));
		add.setBounds(244, 162, 40, 30);
		contentPane.add(add);

	}

	public void btnSinx(JPanel contentPane, final JTextField expression) {
		JButton btnSinx = new JButton("sin(x)");
		btnSinx.setFocusable(false);
		btnSinx.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				expression.setText(expression.getText() + "sin(");
				// textField.setText("");
			}
		});
		btnSinx.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSinx.setBounds(10, 244, 65, 30);
		contentPane.add(btnSinx);

	}

	public void eight(JPanel contentPane) {
		eight = new JButton("8");
		eight.setFocusable(false);
		eight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				interfacePolishNotation.enteringNumbers(eight.getText());
			}
		});
		eight.setFont(new Font("Tahoma", Font.PLAIN, 10));
		eight.setBounds(144, 162, 40, 30);
		contentPane.add(eight);

	}

	public void seven(JPanel contentPane) {
		seven = new JButton("7");
		seven.setFocusable(false);
		seven.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				interfacePolishNotation.enteringNumbers(seven.getText());
			}
		});
		seven.setFont(new Font("Tahoma", Font.PLAIN, 10));
		seven.setBounds(94, 162, 40, 30);
		contentPane.add(seven);

	}

	public void six(JPanel contentPane) {
		six = new JButton("6");
		six.setFocusable(false);
		six.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				interfacePolishNotation.enteringNumbers(six.getText());
			}
		});
		six.setFont(new Font("Tahoma", Font.PLAIN, 10));
		six.setBounds(194, 203, 40, 30);
		contentPane.add(six);

	}

	public void five(JPanel contentPane) {
		five = new JButton("5");
		five.setFocusable(false);
		five.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				interfacePolishNotation.enteringNumbers(five.getText());
			}
		});
		five.setFont(new Font("Tahoma", Font.PLAIN, 10));
		five.setBounds(144, 203, 40, 30);
		contentPane.add(five);
	}

	public void four(JPanel contentPane) {
		four = new JButton("4");
		four.setFocusable(false);
		four.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				interfacePolishNotation.enteringNumbers(four.getText());
			}
		});
		four.setFont(new Font("Tahoma", Font.PLAIN, 10));
		four.setBounds(94, 203, 40, 30);
		contentPane.add(four);

	}

	public void three(JPanel contentPane) {
		three = new JButton("3");
		three.setFocusable(false);
		three.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				interfacePolishNotation.enteringNumbers(three.getText());

			}
		});
		three.setFont(new Font("Tahoma", Font.PLAIN, 10));
		three.setBounds(194, 244, 40, 30);
		contentPane.add(three);

	}

	public void two(JPanel contentPane) {
		two = new JButton("2");
		two.setFocusable(false);
		two.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				interfacePolishNotation.enteringNumbers(two.getText());

			}
		});
		two.setFont(new Font("Tahoma", Font.PLAIN, 10));
		two.setBounds(144, 244, 40, 30);
		contentPane.add(two);
	}

	public void one(JPanel contentPane) {
		one = new JButton("1");
		one.setFocusable(false);
		one.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				interfacePolishNotation.enteringNumbers(one.getText());
			}
		});
		one.setFont(new Font("Tahoma", Font.PLAIN, 10));
		one.setBounds(94, 244, 40, 30);
		contentPane.add(one);

	}

	public void decision(JPanel contentPane) {
		decision = new JButton("=");
		decision.setFocusable(false);
		decision.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				interfacePolishNotation.decisionPolishNotation();
			}
		});
		decision.setFont(new Font("Tahoma", Font.PLAIN, 8));
		decision.setBounds(294, 244, 40, 71);
		contentPane.add(decision);

	}

	public void point(JPanel contentPane) {
		point = new JButton(".");
		point.setFocusable(false);
		point.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				interfacePolishNotation.fraction();
			}
		});
		point.setFont(new Font("Tahoma", Font.PLAIN, 10));
		point.setBounds(194, 285, 40, 30);
		contentPane.add(point);
	}

	public void div(JPanel contentPane, final JTextField expression) {
		div = new JButton("/");
		div.setFocusable(false);
		div.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				interfacePolishNotation.processingOperands(expression.getText(), "/");
			}
		});
		div.setFont(new Font("Tahoma", Font.PLAIN, 10));
		div.setBounds(244, 285, 40, 30);
		contentPane.add(div);

	}

	public void mul(JPanel contentPane, final JTextField expression) {
		mul = new JButton("*");
		mul.setFocusable(false);
		mul.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				interfacePolishNotation.processingOperands(expression.getText(), "*");
			}
		});
		mul.setFont(new Font("Tahoma", Font.PLAIN, 10));
		mul.setBounds(244, 244, 40, 30);
		contentPane.add(mul);
	}

	public void sub(JPanel contentPane, final JTextField expression) {
		sub = new JButton("-");
		sub.setFocusable(false);
		sub.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				interfacePolishNotation.processingOperands(expression.getText(), "-");
			}
		});
		sub.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sub.setBounds(244, 203, 40, 30);
		contentPane.add(sub);

	}

	public void sqrt(JPanel contentPane, final JTextField expression, final JTextField textField) {
		JButton sqrt = new JButton("√");
		sqrt.setFocusable(false);
		sqrt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				expression.setText(expression.getText() + "√(");
			}
		});
		sqrt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		sqrt.setBounds(294, 203, 40, 30);
		contentPane.add(sqrt);
	}

	public void btnCosx(JPanel contentPane, final JTextField expression) {
		JButton btnCosx = new JButton("cos(x)");
		btnCosx.setFocusable(false);
		btnCosx.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				expression.setText(expression.getText() + "cos(");
			}
		});
		btnCosx.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCosx.setBounds(10, 285, 65, 30);
		contentPane.add(btnCosx);
	}

	public void backspace(JPanel contentPane, final JTextField textField) {
		backspace = new JButton("<--");
		backspace.setFocusable(false);
		backspace.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText(interfacePolishNotation.removingTheItem(textField.getText()));
			}
		});
		backspace.setFont(new Font("Tahoma", Font.PLAIN, 12));
		backspace.setBounds(10, 162, 65, 30);
		contentPane.add(backspace);
	}

	public void btnLnx(JPanel contentPane, final JTextField expression) {
		JButton btnLnx = new JButton("ln(x)");
		btnLnx.setFocusable(false);
		btnLnx.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				expression.setText(expression.getText() + "ln(");
			}
		});
		btnLnx.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLnx.setBounds(10, 203, 65, 30);
		contentPane.add(btnLnx);

	}

	public void delete(JPanel contentPane, final JTextField expression, final JTextField textField,
			final JLabel strokaSostoania) {
		delete = new JButton("C");
		delete.setFocusable(false);
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				interfacePolishNotation.flag = false;
				expression.setText("");
				strokaSostoania.setText("");
				textField.setText("");

			}
		});
		delete.setBounds(10, 96, 324, 21);
		contentPane.add(delete);

	}

	public void abs(JPanel contentPane, final JTextField textField) {
		JLabel label = new JLabel("Строка состояния:");
		label.setFocusTraversalKeysEnabled(false);
		label.setBounds(104, 315, 132, 15);
		contentPane.add(label);

		JButton abs = new JButton("+-");
		abs.setFocusable(false);
		abs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("")) {
				} else {
					interfacePolishNotation.abs(textField.getText());
				}
			}
		});
		abs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		abs.setBounds(234, 128, 100, 23);
		contentPane.add(abs);
	}

	public void brackets(JPanel contentPane, final JTextField expression, final JTextField textField) {
		JButton button_1 = new JButton("(");
		button_1.setFocusable(false);
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (expression.getText().equals("")) {
					expression.setText("(");
				} else {
					expression.setText(expression.getText() + "(");
				}
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_1.setBounds(10, 128, 100, 23);
		contentPane.add(button_1);

		JButton button_2 = new JButton(")");
		button_2.setFocusable(false);
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				expression.setText(expression.getText() + textField.getText() + ")");
				textField.setText("");
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_2.setBounds(120, 128, 100, 23);
		contentPane.add(button_2);

	}

	public void processingPressing(KeyEvent e) {
		String keyCode = KeyEvent.getKeyText(e.getKeyCode());

		if (keyCode == "Enter") {
			interfacePolishNotation.decisionPolishNotation();
			return;
		} else if (keyCode.equals("NumPad-1") || keyCode.equals("1")) {
			one.doClick();
			return;
		} else if (keyCode.equals("NumPad-2") || keyCode.equals("2")) {
			two.doClick();
			return;
		} else if (keyCode.equals("NumPad-3") || keyCode.equals("3")) {
			three.doClick();
			return;
		} else if (keyCode.equals("NumPad-4") || keyCode.equals("4")) {
			four.doClick();
			return;
		} else if (keyCode.equals("NumPad-5") || keyCode.equals("5")) {
			five.doClick();
			return;
		} else if (keyCode.equals("NumPad-6") || keyCode.equals("6")) {
			six.doClick();
			return;
		} else if (keyCode.equals("NumPad-7") || keyCode.equals("7")) {
			seven.doClick();
			return;
		} else if (keyCode.equals("NumPad-8") || keyCode.equals("8")) {
			eight.doClick();
			return;
		} else if (keyCode.equals("NumPad-9") || keyCode.equals("9")) {
			nine.doClick();
			return;
		} else if (keyCode.equals("NumPad-0") || keyCode.equals("0")) {
			zero.doClick();
			return;
		} else if (keyCode.equals("NumPad .")) {
			point.doClick();
			return;
		} else if (keyCode.equals("Backspace")) {
			backspace.doClick();
			return;
		} else if (keyCode.equals("Delete")) {
			delete.doClick();
			return;
		} else if (keyCode.equals("NumPad +")) {
			add.doClick();
			return;
		} else if (keyCode.equals("NumPad -")) {
			sub.doClick();
			return;
		} else if (keyCode.equals("NumPad *")) {
			mul.doClick();
			return;
		} else if (keyCode.equals("NumPad /")) {
			div.doClick();
			return;
		}
	}

}
