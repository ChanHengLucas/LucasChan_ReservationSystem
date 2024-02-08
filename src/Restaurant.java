import java.sql.SQLOutput;
import java.util.ArrayList;
import javax.management.modelmbean.ModelMBeanOperationInfo;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Restaurant {

    // textfield for adding new reservations manually
    private ArrayList<Reservation> guestList = new ArrayList<>(25);

    // 1) How do I make it so guest list contains 3 integers (nPeople, timeFor, timeMade)
    // 1.5) What is the type "Reservation" and what types of variables is guest list supposed to contain
    // 2) How do I make it sort the first or second or third integer of the variables stored in guest list

    public Restaurant(){
        addReservation(); // only ran once
        displayReservations();
    }

    public void displayReservations(){

        int nOfReservations = 25; // number of res

        for (int i = 0; i < nOfReservations; i++){
//            guestList.add(nPeopleList.get(i), timeForList.get(i), timeMadeList.get(i));

        }

        // guestList size

        for (int i = 0; i < guestList.size(); i++){
            guestList.get(i).printInfo();
        }
    } // might not need anymore after GUI exists

    public String getReservations(){
        String reservationString = "";
        // loop through guestList, adding one line per reservation to string
        for (int i = 0; i < guestList.size(); i++){
            reservationString += guestList.get(i).printInfo() + "\n";
        }
        System.out.println(reservationString);
        return reservationString;
    }

    public void addReservation(){
        for (int i = 0; i < 25; i++) {
            guestList.add(new Reservation());
        }
        sortByTimeFor(); // default = sort by time for
//        System.out.println(guestList.get(0).getNPeople());
    }

    public void sortByNPeople(){
        Reservation temp;
        boolean stop = true;
        for (int i = 0; i < guestList.size(); i++){
            for (int j = 0; j < guestList.size(); j++) {
                while (j != 0 && guestList.get(j).getNPeople() < guestList.get(j-1).getNPeople()){
                    stop = false;
                    temp = guestList.get(j-1);
                    guestList.set(j-1, guestList.get(j));
                    guestList.set(j, temp);
                }
            }
            if (stop == true){
                break;
            }
//            for (int k = 0; k < nPeopleList.size(); k++){
//                System.out.print(nPeopleList.get(k) + " ");
//            }
//            System.out.println();
        }
    }

    public void sortByTimeFor(){

            Reservation temp;
            boolean stop = true;
            for (int i = 0; i < guestList.size(); i++){
                for (int j = 0; j < guestList.size(); j++) {
                    while (j != 0 && guestList.get(j).getTimeFor() < guestList.get(j-1).getTimeFor()){
                        stop = false;
                        temp = guestList.get(j-1);
                        guestList.set(j-1, guestList.get(j));
                        guestList.set(j, temp);
                    }
                }
                if (stop == true){
                    break;
                }
//            for (int k = 0; k < nPeopleList.size(); k++){
//                System.out.print(nPeopleList.get(k) + " ");
//            }
//            System.out.println();
            }
    }

    public void sortByTimeMade(){

        Reservation temp;
        boolean stop = true;
        for (int i = 0; i < guestList.size(); i++){
            for (int j = 0; j < guestList.size(); j++) {
                while (j != 0 && guestList.get(j).getTimeMade() < guestList.get(j-1).getTimeMade()){
                    stop = false;
                    temp = guestList.get(j-1);
                    guestList.set(j-1, guestList.get(j));
                    guestList.set(j, temp);
                }
            }
            if (stop == true){
                break;
            }
//            for (int k = 0; k < nPeopleList.size(); k++){
//                System.out.print(nPeopleList.get(k) + " ");
//            }
//            System.out.println();
        }
    }

    public static class RestaurantGUI implements ActionListener {
        private JFrame mainFrame;
        private JPanel mainPanel;
        private JPanel northPanel;
        private JPanel southPanel;
        private JButton buttonPeople;
        private JButton buttonTimeFor;
        private JButton buttonTimeMade;
        private JButton buttonAdd;
        private JTextArea reservationList;

        private JTextField inputText;

        Restaurant Mooo = new Restaurant();


        public RestaurantGUI() {

            mainFrame = new JFrame();
            mainPanel = new JPanel(new BorderLayout());
            northPanel = new JPanel();
            southPanel = new JPanel();
            buttonPeople = new JButton("Sort by People");
            buttonPeople.addActionListener(this);
            buttonTimeFor = new JButton("Sort by Time For");
            buttonTimeFor.addActionListener(this);
            buttonTimeMade = new JButton("Sort by Time Made");
            buttonTimeMade.addActionListener(this);
            buttonAdd = new JButton("+");
            reservationList = new JTextArea();
            inputText = new JTextField();

            mainFrame.setSize(1800, 900);
            int borderSize = 50;

            mainFrame.add(mainPanel);
            mainPanel.add(northPanel, BorderLayout.NORTH);
            mainPanel.add(southPanel, BorderLayout.SOUTH);

            northPanel.setLayout(new GridLayout(1,3));
            northPanel.add(buttonPeople);
            northPanel.add(buttonTimeFor);
            northPanel.add(buttonTimeMade);

            mainPanel.add(reservationList, BorderLayout.CENTER);

            southPanel.setLayout(new FlowLayout());
            southPanel.add(buttonAdd);
            southPanel.add(inputText);

            mainFrame.setVisible(true);

        }

        public void convertToString(ArrayList<Reservation> guestList){
            for (int i = 0; i < guestList.size(); i++){
                guestList.get(i).printInfo();
            }
        }

        public void actionPerformed(ActionEvent e){

            Object buttonClicked = e.getSource();

            if (buttonClicked == buttonPeople) {
                System.out.println("Sort by People");
//                reservationList.setText(reservationList.getText());
                Mooo.sortByNPeople();
                reservationList.setText(Mooo.getReservations());
            }

            if (buttonClicked == buttonTimeFor) {
                System.out.println("Sort by Time For");
                reservationList.setText(reservationList.getText());
                Mooo.sortByTimeFor();
                reservationList.setText(Mooo.getReservations());
            }

            if (buttonClicked == buttonTimeMade) {
                System.out.println("Sort by Time Made");
                reservationList.setText(reservationList.getText());
                Mooo.sortByTimeMade();
                reservationList.setText(Mooo.getReservations());
            }

            if (buttonClicked == buttonAdd) {
//                reservationList.add();
                System.out.println("button clicked");
                String nPeople = inputText.getText();
                System.out.println("new reservation for " + Integer.parseInt(nPeople) + " people");
            }
        }
    }


    public static void main(String[] args) {

//        int nOfReservations = 25;
//        int nPeople;

        RestaurantGUI GUI = new RestaurantGUI();
    }
}




