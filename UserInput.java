import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Color.*;

public class UserInput extends JFrame implements WindowListener, ActionListener, MouseListener {
    JPanel homePanel = new JPanel();
    JPanel userPanel = new JPanel();
    JPanel dataPanel = new JPanel();

    JList scoreDisplay = new JList();
    JButton nextPage = new JButton("Go to activity");
    JButton viewData = new JButton("view patient's scores");
    JPanel displayPanel = new JPanel();

    JLabel instructionsLabel = new JLabel();
    JLabel homeLabel = new JLabel();
    JTextField nameField = new JTextField(40);

    JPanel[] shapePanel = new JPanel[9];

    JButton backButton = new JButton("Back to homepage");
    JButton returnButton = new JButton("Back to homepage");
    JButton doneButton = new JButton("Done");
    JButton restartButton = new JButton("restart");
    JLabel scoreLabel = new JLabel();

    JLabel[] imgDisplay = new JLabel[9];

    ArrayList<Data> scoreTrack = new ArrayList<Data>();
    String userName;

    JPanel[] CorrectPanels = new JPanel[2];

    //score for the user
    int score = 0;

    Color babyBlue = new Color(153, 214, 255);
    Color oceanBlue = new Color(22, 138, 216);
    //constructor
    public UserInput() throws MalformedURLException {
        //super(title);
        setLayout(null);
        addWindowListener(this);

        //home page
        //setting visible to true
        homePanel.setVisible(true);
        homePanel.setSize(800, 600);
        homePanel.setBackground(babyBlue);

        //adding panel to the window
        add(homePanel);
        //adding the button to the panel
        homePanel.add(nextPage);
        homePanel.setLayout(null);

        //set size and location
        nextPage.setSize(200,40);
        nextPage.setLocation(350, 300);

        homePanel.add(nameField);
        nameField.setLocation(350, 200);
        nameField.setSize(100, 30);
        nameField.setVisible(true);

        homePanel.add(homeLabel);
        homeLabel.setText("Please enter the patient's name");
        homeLabel.setSize(200, 40);
        homeLabel.setLocation(350, 150);
        homeLabel.setVisible(true);

        //button to bring to panel that will output data
        homePanel.add(viewData);
        viewData.setSize(200, 40);
        viewData.setLocation(350, 240);
        viewData.setVisible(true);

        //data page
        add(dataPanel);
        dataPanel.setVisible(false);
        //dataPanel.setBackground(red);
        dataPanel.setSize(800, 600);
        dataPanel.setLayout(null);
        dataPanel.setBackground(babyBlue);

        dataPanel.add(returnButton);
        returnButton.setSize(150, 40);
        returnButton.setLocation(10, 400);
        returnButton.setVisible(true);


        //activity page
        add(userPanel);
        userPanel.setVisible(false);
        //userPanel.setBackground(green);
        userPanel.setSize(800, 600);
        userPanel.setLayout(null);
        userPanel.setBackground(babyBlue);

        //back button
        userPanel.add(backButton);
        backButton.setSize(150, 30);

        //done button to output score
        userPanel.add(doneButton);
        doneButton.setSize(100, 30);
        doneButton.setLocation(10, 500);
        doneButton.setVisible(true);

        //button to restart the activity
        userPanel.add(restartButton);
        restartButton.setSize(100, 30);
        restartButton.setLocation(120,500);
        restartButton.setVisible(true);

        userPanel.add(instructionsLabel);
        instructionsLabel.setText("click all the items that look like the item below");
        instructionsLabel.setSize(300, 100);
        instructionsLabel.setLocation(0, 30);
        instructionsLabel.setVisible(true);

        //score label
        userPanel.add(scoreLabel);
        scoreLabel.setVisible(true);
        scoreLabel.setLocation(10, 450);

        //display panel
        userPanel.add(displayPanel);
        displayPanel.setVisible(true);
        displayPanel.setSize(475, 475);
        displayPanel.setLocation(275, 30);

        //creation of images
        URL urlStar = new URL("https://clipart-library.com/img1/921395.png");
        //setting their size
        ImageIcon imgStar = new ImageIcon(new ImageIcon(urlStar).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));

        URL urlCircle = new URL("https://theclearcompany.co.uk/wp-content/uploads/2019/05/circular-shape-silhouette.png\n");
        ImageIcon imgCircle = new ImageIcon(new ImageIcon(urlCircle).getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));

        URL urlTriangle = new URL("https://www.freepnglogos.com/uploads/triangle-png/triangle-pink-png-20.png\n");
        ImageIcon imgTriangle = new ImageIcon(new ImageIcon(urlTriangle).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));

        URL urlRec = new URL("https://clipart-library.com/img/1194665.png\n");
        ImageIcon imgRec = new ImageIcon(new ImageIcon(urlRec).getImage().getScaledInstance(150, 100, Image.SCALE_DEFAULT));


        //creating a 3 by 3 grid layout for the display panel
        GridLayout myLayout = new GridLayout(3,3, 5, 5);
        displayPanel.setLayout(myLayout);
        displayPanel.setBackground(babyBlue);

        for(int i = 0; i < 9; i++)
        {
            //create a new panel
            shapePanel[i] = new JPanel();

            //displayPanel.add(shapePanel[i]);
            shapePanel[i].setVisible(true);
            shapePanel[i].setSize(30,30);
            //shapePanel[i].setBackground(Color.blue);
            shapePanel[i].setBackground(oceanBlue);
        }

        //add labels to label array
        for (int m = 0; m < 9; m++)
        {
            imgDisplay[0] = new JLabel(imgStar);
            if (m<2)
            {
                imgDisplay[m] = new JLabel(imgStar);
            }
            else if (m >= 2 && m < 4){
                imgDisplay[m] = new JLabel(imgCircle);
            }
            else if(m >= 4 && m < 6)
            {
                imgDisplay[m] = new JLabel(imgTriangle);

            }
            else
            {
                imgDisplay[m] = new JLabel(imgRec);

            }
            shapePanel[m].add(imgDisplay[m]);
        }

        CorrectPanels[0] = shapePanel[0];
        CorrectPanels[1] = shapePanel[1];
        shapePanel[0].addMouseListener(this);
        shapePanel[1].addMouseListener(this);

        List<JPanel> panelList = Arrays.asList(shapePanel);
        Collections.shuffle(panelList);

        //add array of panels that have been shuffled tp the display panel
        for (int l = 0; l < 9; l++)
        {
            displayPanel.add(panelList.get(l));
        }

        //add image to panel as example of what the user is looking for
        userPanel.add(imgDisplay[0]);
        imgDisplay[0].setLocation(20, 100);
        imgDisplay[0].setSize(200,200);
        imgDisplay[0].setVisible(true);

        viewData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String[] dataArray = new String[scoreTrack.size()];

                for (int i = 0; i < scoreTrack.size(); i++) {
                    String listEntry = scoreTrack.get(i).name + ": " + scoreTrack.get(i).score;

                    dataArray[i] = listEntry;
                }

                JLabel myLabel = new JLabel("hello");
                dataPanel.add(myLabel);

                scoreDisplay.setListData(dataArray);
                scoreDisplay.setVisible(true);
                scoreDisplay.setSize(300, 300);
                dataPanel.add(scoreDisplay);

                homePanel.setVisible(false);
                dataPanel.setVisible(true);

            }
        });

        //action listener for the next page button that will bring the user to the activity page
        nextPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    homePanel.setVisible(false);
                    userPanel.setVisible(true);
            }
        });

        //action listener for the back button that will bring the user back to the homepage
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homePanel.setVisible(true);
                userPanel.setVisible(false);
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homePanel.setVisible(true);
                dataPanel.setVisible(false);
            }
        });


        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scoreLabel.setVisible(true);
                scoreLabel.setSize(100, 20);
                scoreLabel.setText("Your score is " + score);

                //save the score in a list
                userName = nameField.getText();
                scoreTrack.add(new Data(userName, score));

                CorrectPanels[0].setBackground(green);
                CorrectPanels[1].setBackground(green);

            }
        });

        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                score = 0;
                scoreLabel.setVisible(false);
                CorrectPanels[0].setBackground(oceanBlue);
                CorrectPanels[1].setBackground(oceanBlue);

                List<JPanel> panelList = Arrays.asList(shapePanel);
                Collections.shuffle(panelList);

                for (int l = 0; l < 9; l++)
                {
                    displayPanel.add(panelList.get(l));
                }
            }
        });
    }

    //override for window listeners
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    @Override
    public void windowOpened(WindowEvent e) {

    }

    public void windowClosing(WindowEvent e) {
        dispose();
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    //override for mouse listeners
    @Override
    public void mouseClicked(MouseEvent e) {
        score += 1;

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}



