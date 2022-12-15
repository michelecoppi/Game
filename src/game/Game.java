package game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import javax.sound.sampled.*;

/**
 *
 * @author michele2306
 */
public class Game extends JPanel implements KeyListener {

    private static Personaggio personaggio;
    private static int width = 400;
    private static int heigth = 400;
    private String soundName = "audio/dig.wav";

    static Ostacoli muroSopra = new Ostacoli(0, 0, 400, 10);
    static Ostacoli muroSotto = new Ostacoli(0, 353, 400, 10);
    static Ostacoli muroDestro = new Ostacoli(376, 0, 10, 400);
    static Ostacoli muroSinistro = new Ostacoli(0, 0, 10, 400);
    static Traguardo traguardo = new Traguardo(100, 100);
    long startTime = System.currentTimeMillis();

    static ArrayList<Integer> posizioni = new ArrayList<>();
    static ArrayList<Ostacoli> nuovoArray = new ArrayList<>();
    static int z = 0;

    public Game() {
        personaggio = new Personaggio(10, 10, 10);

    }

    //public void start() {
    // Inizializza lo stato del gioco (ad esempio, il giocatore, i nemici, etc.)
    // Esegui il loop del gioco finché il gioco non è finito
    //while (true) {
    // Gestisci l'input del giocatore (ad esempio, le azioni del giocatore)
    // Aggiorna lo stato del gioco in base all'input del giocatore
    // Rendi il gioco sullo schermo (ad esempio, disegna il giocatore, i nemici, etc.)
    //}
    //}
    // Questo è il metodo main(), il punto di ingresso della tua applicazione
    public static void main(String[] args) {
        int[][] array = creaSchema();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 1) {
                    nuovoArray.add(new Ostacoli(posizioni.get(z), posizioni.get(z + 1)));
                    z = z + 2;
                }
            }
        }

        JFrame frame = new JFrame();
        Game game = new Game();
        for (int i = 0; i < nuovoArray.size(); i++) {
            frame.add(nuovoArray.get(i));
        }
        frame.add(personaggio);
        frame.add(muroSopra);
        frame.add(muroSotto);
        frame.add(muroDestro);
        frame.add(muroSinistro);
        frame.add(traguardo);
        frame.add(game);
        frame.addKeyListener(game);
        frame.setSize(width, heigth);
        frame.setLocation(450, 150);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Rectangle rettangolo=frame.getBounds();
        // System.out.println(frame.getHeight());
        // System.out.println(frame.getWidth());
        //game.start();

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP) {
           
            boolean move = true;
            for (int i = 0; i < nuovoArray.size(); i++) {
                if (nuovoArray.get(i).checkCollisionTop(personaggio)) {
                    move = false;
                    break;
                }

            }
            if (move == true) {
                personaggio.moveUp();
            }

        } else if (keyCode == KeyEvent.VK_DOWN) {
            boolean move = true;
            for (int i = 0; i < nuovoArray.size(); i++) {
                if (nuovoArray.get(i).checkCollisionBottom(personaggio)) {
                    move = false;
                    break;
                }

            }
            if (move == true) {
                personaggio.moveDown();
            }
        } else if (keyCode == KeyEvent.VK_LEFT) {
            boolean move = true;
            for (int i = 0; i < nuovoArray.size(); i++) {
                if (nuovoArray.get(i).checkCollisionLeft(personaggio)) {
                    move = false;
                    break;
                }

            }
            if (move == true) {
                personaggio.moveLeft();
            }
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            boolean move = true;
            for (int i = 0; i < nuovoArray.size(); i++) {
                if (nuovoArray.get(i).checkCollisionRight(personaggio)) {
                    move = false;
                    break;
                }

            }
            if (move == true) {
                personaggio.moveRight();
            }
        } else if (keyCode == KeyEvent.VK_C) {
            Random random = new Random();
            personaggio.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));

        }

        if (personaggio.getBounds().intersects(traguardo.getBounds())) {
            // If the player has reached the end point, display a victory message and exit the game
            long elapsedTime = System.currentTimeMillis() - startTime;
            double elapsedTimeInSeconds = elapsedTime / 1000.0;
            //int scelta = JOptionPane.showConfirmDialog(this, "Congratulazioni, sei fuggito da Catanzaro!\n Tempo totale: " + elapsedTimeInSeconds + " secondi"+"\nVuoi rigiocare?",);
            int scelta = JOptionPane.showConfirmDialog(this, "Congratulazioni, sei fuggito da Catanzaro!\n Tempo totale: " + elapsedTimeInSeconds + " secondi" + "\nVuoi rigiocare?", "Fine gioco", JOptionPane.YES_NO_OPTION);
            if (scelta == JOptionPane.YES_OPTION) {
                startTime = System.currentTimeMillis();
                personaggio.setX(10);
                personaggio.setY(10);
            } else if (scelta == JOptionPane.NO_OPTION) {
                System.exit(0);
            } else if (scelta == JOptionPane.CLOSED_OPTION) {
                startTime = System.currentTimeMillis();
                personaggio.setX(10);
                personaggio.setY(10);
            }

        }
        repaint();
        //repaint(new Rectangle(500,500));

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        personaggio.drawCharachter(g);

        muroDestro.draw(g);
        muroSinistro.draw(g);
        muroSotto.draw(g);
        muroSopra.draw(g);
        traguardo.draw(g);
        for (int i = 0; i < nuovoArray.size(); i++) {
            nuovoArray.get(i).draw(g);
        }

    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        int keyCode = ke.getKeyCode();
        if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName));
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                Control[] controls = clip.getControls();

                for (Control control : controls) {
                    if (control.getType() == FloatControl.Type.VOLUME) {
                        FloatControl volumeControl = (FloatControl) control;
                        volumeControl.setValue(0.1f);
                        break;
                    }

                    clip.start();

                }

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }

        }
    }

    static public int[][] creaSchema() {
        int[][] array = new int[37][35];

        double randomNumber = 0;

        for (int i = 0; i < array.length; i++) {
            // Itero sugli elementi dell'array interno
            for (int j = 0; j < array[i].length; j++) {
                randomNumber = Math.random() * 2 - 1;
// Arrotondo il numero casuale a un intero
                int randomInt = (int) Math.round(randomNumber);
                randomInt = Math.abs(randomInt);
                if(i==0 && j==0){
                randomInt=0;
                }
                array[i][j] = randomInt;
                if (randomInt == 1) {
                    posizioni.add(((i+1) * 10));
                    posizioni.add(((j+1) * 10));
                }
            }
        }
        
        return array;
    }

}
