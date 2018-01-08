import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener
{
    String input = "";
        
    char operator = 'a';
    
    double numOne= 0, numTwo= 0, answer= 0; //intial values 

    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bAdd, bSubtract, bMultiply, bDecimal, bEqual, bDivide; //buttons for the calculator
    
    JTextField tfExpression;
    JButton bClear;
    JLabel lblWarning;
    
    
    public Calculator()//constructor
    {   
        super( "Calculator" );
        
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        p1.setLayout( new GridLayout( 4, 4, 5, 5 ) ); //rows, columns, padding horiz, padding vert
        
        setSize( 800, 800 ); //width, height
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        //creating number buttons
        b7 = new JButton( new AbstractAction("7") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                input = input.concat( "7" );
                tfExpression.setText( input );
            }
        });
        p1.add( b7 );
        b8 = new JButton( new AbstractAction("8") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                input = input.concat( "8" );
                tfExpression.setText( input );
            }
        });
        p1.add( b8 );
        b9 = new JButton( new AbstractAction("9") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                input = input.concat( "9" );
                tfExpression.setText( input );
            }
        });
        p1.add( b9 );
        bAdd = new JButton( new AbstractAction("+") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                if( operator != 'a' ){
                    lblWarning.setText( "Can't choose operator again!" );
                }
                else{
                    if( numOne == 0)
                        numOne = Double.parseDouble( input );
                    input = "";
                    operator = '+';
                    tfExpression.setText( numOne + " + " + input );
                }
            }
        });
        p1.add( bAdd );
        b4 = new JButton( new AbstractAction("4") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                input = input.concat( "4" );
                tfExpression.setText( input );
            }
        });
        p1.add( b4 );
        b5 = new JButton( new AbstractAction("5") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                input = input.concat( "5" );
                tfExpression.setText( input );
            }
        });
        p1.add( b5 );
        b6 = new JButton( new AbstractAction("6") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                input = input.concat( "6" );
                tfExpression.setText( input );
            }
        });
        p1.add( b6 );
        bSubtract = new JButton( new AbstractAction("-") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                if( operator != 'a' ){
                    lblWarning.setText( "Can't choose operator again!" );
                }
                else{
                    if ( numOne == 0)
                        numOne = Double.parseDouble( input );
                    input = "";
                    operator = '-';
                    tfExpression.setText( numOne + " - " + input );
                }
            }
        });
        p1.add( bSubtract );
        b1 = new JButton( new AbstractAction("1") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                input = input.concat( "1" );
                tfExpression.setText( input );
            }
        });
        p1.add( b1 );
        b2 = new JButton( new AbstractAction("2") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                input = input.concat( "2" );
                tfExpression.setText( input );
            }
        });
        p1.add( b2 );
        b3 = new JButton( new AbstractAction("3") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                input = input.concat( "3" );
                tfExpression.setText( input );
            }
        });
        p1.add( b3 );
        bMultiply = new JButton( new AbstractAction("*") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                if( operator != 'a' ){
                    lblWarning.setText( "Can't choose operator again!" );
                }
                else{
                    if ( numOne == 0)
                        numOne = Double.parseDouble( input );
                    input = "";
                    operator = '*';
                    tfExpression.setText( numOne + " * " + input );
                }
            }
        });
        p1.add( bMultiply );
        b0 = new JButton( new AbstractAction("0") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                input = input.concat( "0" );
                tfExpression.setText( input );
            }
        });
        p1.add( b0 );
        bDecimal = new JButton( new AbstractAction(".") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                input = input.concat( "." );
                tfExpression.setText( input );
            }
        });
        p1.add( bDecimal );
        bEqual = new JButton( new AbstractAction("=") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                numTwo = Double.parseDouble( input );
                
                switch( operator ){
                    case '+':
                        answer = numOne + numTwo;
                        break;
                    case '-':
                        answer = numOne - numTwo;
                        break;
                    case '*':
                        answer = numOne * numTwo;
                        break;
                    case '/':
                        answer = numOne / numTwo;
                        break;
                }
                
                numOne = answer;
                tfExpression.setText( answer + " " );
                
                operator = 'a';
                numTwo = 0;
                input = "";
                
            }
        });
        p1.add( bEqual );
        bDivide = new JButton( new AbstractAction("/") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                if( operator != 'a' ){
                    lblWarning.setText( "Can't choose operator again!" );
                }
                else{
                    if ( numOne == 0)
                        numOne = Double.parseDouble( input );
                    input = "";
                    operator = '/';
                    tfExpression.setText( numOne + " / " + input );
                }
            }
        });
        p1.add( bDivide );
        
        //text box, clear button, and warning message
        tfExpression = new JTextField( input, 20 );//contains, length
        tfExpression.setEditable( false );
        p2.add( tfExpression );
        
        bClear = new JButton( new AbstractAction("clear") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                input = "";
                numOne = 0;
                numTwo = 0;
                tfExpression.setText( input );
            }
        });
        p2.add( bClear );
        
        lblWarning = new JLabel( "", JLabel.RIGHT );
        p2.add( lblWarning );
        
        container.add( p1 );
        container.add( p2 );
        
        add( container );
        
        setVisible( true );
    }
    
    public void actionPerformed( ActionEvent ae )
    {
        
    }
    
    public static void main(String[] args)
    {
        Calculator calc = new Calculator();
    }
}