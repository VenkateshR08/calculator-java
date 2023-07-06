import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Calculator implements ActionListener {
	
	JLabel displayLabel;
	JButton sevenButton, eightButton, nineButton, fourButton, fiveButton, sixButton;
	JButton oneButton, twoButton, threeButton, dotButton, zeroButton, equalButton;
	JButton divButton, multiButton, subButton, addButton, clearButton;
	
	boolean isOperatorClicked = false;
	String oldValue = "";
	String operator = "";
	
	public Calculator() {
		JFrame jf = new JFrame("Calculator");
		jf.setLayout(null);
		jf.setSize(450, 580);
		jf.setLocation(350, 150);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		displayLabel = new JLabel();
		displayLabel.setFont(new Font("Serif", Font.PLAIN, 50));
		displayLabel.setBounds(30, 30, 380, 80);
		displayLabel.setBackground(Color.black);
		displayLabel.setOpaque(true);
		displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		displayLabel.setForeground(Color.white);
		
		
		jf.add(displayLabel);
		
		sevenButton = new JButton("7");
		sevenButton.setBounds(30, 130, 80, 80);
		sevenButton.addActionListener(this);
		jf.add(sevenButton);
		
		eightButton = new JButton("8");
		eightButton.setBounds(130, 130, 80, 80);
		eightButton.addActionListener(this);
		jf.add(eightButton);
		
		nineButton = new JButton("9");
		nineButton.setBounds(230, 130, 80, 80);
		nineButton.addActionListener(this);
		jf.add(nineButton);
		
		fourButton = new JButton("4");
		fourButton.setBounds(30, 230, 80, 80);
		fourButton.addActionListener(this);
		jf.add(fourButton);
		
		fiveButton = new JButton("5");
		fiveButton.setBounds(130, 230, 80, 80);
		fiveButton.addActionListener(this);
		jf.add(fiveButton);
		
		sixButton = new JButton("6");
		sixButton.setBounds(230, 230, 80, 80);
		sixButton.addActionListener(this);
		jf.add(sixButton);
		
		oneButton = new JButton("1");
		oneButton.setBounds(30, 330, 80, 80);
		oneButton.addActionListener(this);
		jf.add(oneButton);
		
		twoButton = new JButton("2");
		twoButton.setBounds(130, 330, 80, 80);
		twoButton.addActionListener(this);
		jf.add(twoButton);
		
		threeButton = new JButton("3");
		threeButton.setBounds(230, 330, 80, 80);
		threeButton.addActionListener(this);
		jf.add(threeButton);
		
		dotButton = new JButton(".");
		dotButton.setBounds(30, 430, 80, 80);
		dotButton.addActionListener(this);
		jf.add(dotButton);
		
		zeroButton = new JButton("0");
		zeroButton.setBounds(130, 430, 80, 80);
		zeroButton.addActionListener(this);
		jf.add(zeroButton);
		
		equalButton = new JButton("=");
		equalButton.setBounds(230, 430, 80, 80);
		equalButton.addActionListener(this);
		jf.add(equalButton);
		
		divButton = new JButton("/");
		divButton.setBounds(330, 170, 80, 40);
		divButton.addActionListener(this);
		jf.add(divButton);
		
		clearButton = new JButton("Clear");
		clearButton.setBounds(330, 130, 80, 40);
		clearButton.addActionListener(this);
		jf.add(clearButton);
		
		multiButton = new JButton("X");
		multiButton.setBounds(330, 230, 80, 80);
		multiButton.addActionListener(this);
		jf.add(multiButton);
		
		subButton = new JButton("-");
		subButton.setBounds(330, 330, 80, 80);
		subButton.addActionListener(this);
		jf.add(subButton);
		
		addButton = new JButton("+");
		addButton.setBounds(330, 430, 80, 80);
		addButton.addActionListener(this);
		jf.add(addButton);
		
	}

	public static void main(String args[]){
		new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.matches("[0-9]")) {
			if (isOperatorClicked) {
				displayLabel.setText(command);
				isOperatorClicked = false;
			} else {
				displayLabel.setText(displayLabel.getText() + command);
			}
		} else if (command.equals(".")) {
			if (isOperatorClicked) {
				displayLabel.setText("0.");
				isOperatorClicked = false;
			} else if (!displayLabel.getText().contains(".")) {
				displayLabel.setText(displayLabel.getText() + ".");
			}
		} else if ("/X-+".contains(command)) {
			if (!isOperatorClicked) {
				isOperatorClicked = true;
				oldValue = displayLabel.getText();
				operator = command;
			}
		} else if (command.equals("=")) {
			double num2 = Double.parseDouble(displayLabel.getText());
			double result = 0.0;
			switch (operator) {
				case "+":
					result = Double.parseDouble(oldValue) + num2;
					break;
				case "-":
					result = Double.parseDouble(oldValue) - num2;
					break;
				case "X":
					result = Double.parseDouble(oldValue) * num2;
					break;
				case "/":
					if (num2 == 0) {
						displayLabel.setText("Error: Cannot divide by zero.");
						return;
					}
					result = Double.parseDouble(oldValue) / num2;
					break;
			}
			displayLabel.setText(String.valueOf(result));
			isOperatorClicked = true;
		} else if (command.equals("Clear")) {
			displayLabel.setText("");
			isOperatorClicked = false;
			oldValue = "";
			operator = "";
		}
	}
}