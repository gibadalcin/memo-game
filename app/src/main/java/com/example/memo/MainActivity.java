package com.example.memo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11;
    private ImageButton ref_button;
    private final int[] button = new int[12];
    private int type_of_move = 1;
    private final int[] hide_images = new int[2];
    private int int_button;
    public static int imageRepository;
    private Chronometer chronometer;
    private Button btnStart,btnPause;
    long currentTime;
    private MediaPlayer player;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn10 = findViewById(R.id.btn10);
        btn11 = findViewById(R.id.btn11);
        chooseImages();
        chronometer = findViewById(R.id.chronometer);
        btnStart = findViewById(R.id.btnStart);
        btnPause = findViewById(R.id.btnPause);
        Button btnReload = findViewById(R.id.btnReload);
        btnPause.setEnabled(false);

        reload();
        chooseImages();

        btn0.setOnClickListener(v -> {
            if (btn0.isEnabled()) {
                if (btnStart.isEnabled()) {
                    pauseOff();
                }
                ref_button = btn0;
                int_button = button[0];

                if (type_of_move == 1) {
                    selectButton();
                    hide_images[0] = 0;
                    type_of_move++;
                } else if (type_of_move == 2) {
                    selectButton();
                    hide_images[1] = 0;
                    if (corresponds(0)) {
                        imageMatches();
                    }
                    type_of_move++;
                } else if (type_of_move == 3) {
                    redistribute();
                    selectButton();
                    hide_images[0] = 0;
                    type_of_move = 2;
                }
            }
        });

        btn1.setOnClickListener(v -> {
            if (btn1.isEnabled()) {
                if (btnStart.isEnabled()) {
                    pauseOff();
                }

                ref_button = btn1;
                int_button = button[1];

                if (type_of_move == 1) {
                    selectButton();
                    hide_images[0] = 1;
                    type_of_move++;
                } else if (type_of_move == 2) {
                    selectButton();
                    hide_images[1] = 1;
                    if (corresponds(1)) {
                        imageMatches();
                    }
                    type_of_move++;
                } else if (type_of_move == 3) {
                    redistribute();
                    selectButton();
                    hide_images[0] = 1;
                    type_of_move = 2;
                }
            }
        });

        btn2.setOnClickListener(v -> {
            if (btnStart.isEnabled()) {
                pauseOff();
            }

            ref_button = btn2;
            int_button = button[2];

            if (btn2.isEnabled()) {
                if (type_of_move == 1) {
                    selectButton();
                    hide_images[0] = 2;
                    type_of_move++;
                } else if (type_of_move == 2) {
                    selectButton();
                    hide_images[1] = 2;
                    if (corresponds(2)) {
                        imageMatches();
                    }
                    type_of_move++;
                } else if (type_of_move == 3) {
                    redistribute();
                    selectButton();
                    hide_images[0] = 2;
                    type_of_move = 2;
                }
            }
        });

        btn3.setOnClickListener(v -> {
            if (btnStart.isEnabled()) {
                pauseOff();
            }

            ref_button = btn3;
            int_button = button[3];

            if (btn3.isEnabled()) {
                if (type_of_move == 1) {
                    selectButton();
                    hide_images[0] = 3;
                    type_of_move++;
                } else if (type_of_move == 2) {
                    selectButton();
                    hide_images[1] = 3;
                    if (corresponds(3)) {
                        imageMatches();
                    }
                    type_of_move++;
                } else if (type_of_move == 3) {
                    redistribute();
                    selectButton();
                    hide_images[0] = 3;
                    type_of_move = 2;
                }
            }
        });

        btn4.setOnClickListener(v -> {
            if (btnStart.isEnabled()) {
                pauseOff();
            }

            if (btn4.isEnabled()) {
                ref_button = btn4;
                int_button = button[4];

                if (type_of_move == 1) {
                    selectButton();
                    hide_images[0] = 4;
                    type_of_move++;
                } else if (type_of_move == 2) {
                    selectButton();
                    hide_images[1] = 4;
                    if (corresponds(4)) {
                        imageMatches();
                    }
                    type_of_move++;
                } else if (type_of_move == 3) {
                    redistribute();
                    selectButton();
                    hide_images[0] = 4;
                    type_of_move = 2;
                }
            }
        });

        btn5.setOnClickListener(v -> {
            if (btnStart.isEnabled()) {
                pauseOff();
            }

            if (btn5.isEnabled()) {
                ref_button = btn5;
                int_button = button[5];

                if (type_of_move == 1) {
                    selectButton();
                    hide_images[0] = 5;
                    type_of_move++;
                } else if (type_of_move == 2) {
                    selectButton();
                    hide_images[1] = 5;
                    if (corresponds(5)) {
                        imageMatches();
                    }
                    type_of_move++;
                } else if (type_of_move == 3) {
                    redistribute();
                    selectButton();
                    hide_images[0] = 5;
                    type_of_move = 2;
                }
            }
        });

        btn6.setOnClickListener(v -> {
            if (btnStart.isEnabled()) {
                pauseOff();
            }

            ref_button = btn6;
            int_button = button[6];

            if (btn6.isEnabled()) {
                if (type_of_move == 1) {
                    selectButton();
                    hide_images[0] = 6;
                    type_of_move++;
                } else if (type_of_move == 2) {
                    selectButton();
                    hide_images[1] = 6;
                    if (corresponds(6)) {
                        imageMatches();
                    }
                    type_of_move++;
                } else if (type_of_move == 3) {
                    redistribute();
                    selectButton();
                    hide_images[0] = 6;
                    type_of_move = 2;
                }
            }
        });

        btn7.setOnClickListener(v -> {
            if (btnStart.isEnabled()) {
                pauseOff();
            }

            ref_button = btn7;
            int_button = button[7];

            if (btn7.isEnabled()) {
                if (type_of_move == 1) {
                    selectButton();
                    hide_images[0] = 7;
                    type_of_move++;
                } else if (type_of_move == 2) {
                    selectButton();
                    hide_images[1] = 7;
                    if (corresponds(7)) {
                        imageMatches();
                    }
                    type_of_move++;
                } else if (type_of_move == 3) {
                    redistribute();
                    selectButton();
                    hide_images[0] = 7;
                    type_of_move = 2;
                }
            }
        });

        btn8.setOnClickListener(v -> {
            if (btnStart.isEnabled()) {
                pauseOff();
            }

            ref_button = btn8;
            int_button = button[8];

            if (btn8.isEnabled()) {
                if (type_of_move == 1) {
                    selectButton();
                    hide_images[0] = 8;
                    type_of_move++;
                } else if (type_of_move == 2) {
                    selectButton();
                    hide_images[1] = 8;
                    if (corresponds(8)) {
                        imageMatches();
                    }
                    type_of_move++;
                } else if (type_of_move == 3) {
                    redistribute();
                    selectButton();
                    hide_images[0] = 8;
                    type_of_move = 2;
                }
            }
        });

        btn9.setOnClickListener(v -> {
            if (btnStart.isEnabled()) {
                pauseOff();
            }

            ref_button = btn9;
            int_button = button[9];

            if (btn9.isEnabled()) {
                if (type_of_move == 1) {
                    selectButton();
                    hide_images[0] = 9;
                    type_of_move++;
                } else if (type_of_move == 2) {
                    selectButton();
                    hide_images[1] = 9;
                    if (corresponds(9)) {
                        imageMatches();
                    }
                    type_of_move++;
                } else if (type_of_move == 3) {
                    redistribute();
                    selectButton();
                    hide_images[0] = 9;
                    type_of_move = 2;
                }
            }
        });

        btn10.setOnClickListener(v -> {
            if (btnStart.isEnabled()) {
                pauseOff();
            }

            ref_button = btn10;
            int_button = button[10];

            if (btn10.isEnabled()) {
                if (type_of_move == 1) {
                    selectButton();
                    hide_images[0] = 10;
                    type_of_move++;
                } else if (type_of_move == 2) {
                    selectButton();
                    hide_images[1] = 10;
                    if (corresponds(10)) {
                        imageMatches();
                    }
                    type_of_move++;
                } else if (type_of_move == 3) {
                    redistribute();
                    selectButton();
                    hide_images[0] = 10;
                    type_of_move = 2;
                }
            }
        });

        btn11.setOnClickListener(v -> {
            if (btnStart.isEnabled()) {
                pauseOff();
            }

            ref_button = btn11;
            int_button = button[11];

            if (btn11.isEnabled()) {
                if (type_of_move == 1) {
                    selectButton();
                    hide_images[0] = 11;
                    type_of_move++;
                } else if (type_of_move == 2) {
                    selectButton();
                    hide_images[1] = 11;
                    if (corresponds(11)) {
                        imageMatches();
                    }
                    type_of_move++;
                } else if (type_of_move == 3) {
                    redistribute();
                    selectButton();
                    hide_images[0] = 11;
                    type_of_move = 2;
                }
            }
        });

        btnStart.setOnClickListener(v -> pauseOff());

        btnPause.setOnClickListener(v -> pauseOn());

        btnReload.setOnClickListener(v -> reload());
    }

    private void imageMatches() {
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.TOP, -400, 50);
        toast.setDuration(Toast.LENGTH_SHORT);
        ImageView view = new ImageView(getApplicationContext());
        view.setImageResource(R.drawable.russel_dog);
        toast.setView(view);
        toast.show();
        dogVoice();
        hide();
        finalTest();
    }

    protected void dogVoice() {
        release();
        player = MediaPlayer.create(MainActivity.this, R.raw.dog);
        player.start();
    }

    protected void finalVoices(){
        release();
        player = MediaPlayer.create(MainActivity.this, R.raw.voices);
        player.start();
    }

    protected void release() {
        if(player != null) {
            player.release();
        }
    }

    protected void stopVoices() {
        if(player != null) {
            player.stop();
        }
    }

    protected void selectButton() {
        ref_button.setImageResource(int_button);
        ref_button.setEnabled(false);
    }

    protected void hide() {
        hide_images[0] = -1;
        hide_images[1] = -1;
    }

    protected void restartImages() {
        btn0.setEnabled(true);
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
        btn10.setEnabled(true);
        btn11.setEnabled(true);
        btn0.setImageResource(R.drawable.ic_launcher);
        btn1.setImageResource(R.drawable.ic_launcher);
        btn2.setImageResource(R.drawable.ic_launcher);
        btn3.setImageResource(R.drawable.ic_launcher);
        btn4.setImageResource(R.drawable.ic_launcher);
        btn5.setImageResource(R.drawable.ic_launcher);
        btn6.setImageResource(R.drawable.ic_launcher);
        btn7.setImageResource(R.drawable.ic_launcher);
        btn8.setImageResource(R.drawable.ic_launcher);
        btn9.setImageResource(R.drawable.ic_launcher);
        btn10.setImageResource(R.drawable.ic_launcher);
        btn11.setImageResource(R.drawable.ic_launcher);
    }

    protected void chooseImages() {
        restartImages();

        for (int i = 0; i <= 11; i++)
            button[i] = -1;
        Random random = new Random();
        int image = 1;
        while (button[0] == -1 || button[1] == -1 || button[2] == -1 || button[3] == -1 || button[4] == -1 || button[5] == -1 ||
                button[6] == -1 || button[7] == -1 || button[8] == -1 || button[9] == -1 || button[10] == -1 || button[11] == -1) {
            int choose_button = random.nextInt(12);
            if (button[choose_button] == -1) {
                if (imageRepository == 0) {
                    if (image == 1)
                        button[choose_button] = R.drawable.shark;
                    else if (image == 2)
                        button[choose_button] = R.drawable.whale;
                    else if (image == 3)
                        button[choose_button] = R.drawable.turtle;
                    else if (image == 4)
                        button[choose_button] = R.drawable.tuna;
                    else if (image == 5)
                        button[choose_button] = R.drawable.squid;
                    else
                        button[choose_button] = R.drawable.seal;
                    image++;
                    if (image == 7)
                        image = 1;
                } else if (imageRepository == 1) {
                    if (image == 1)
                        button[choose_button] = R.drawable.turkey;
                    else if (image == 2)
                        button[choose_button] = R.drawable.squirrel;
                    else if (image == 3)
                        button[choose_button] = R.drawable.sheep;
                    else if (image == 4)
                        button[choose_button] = R.drawable.rabbit;
                    else if (image == 5)
                        button[choose_button] = R.drawable.pig;
                    else
                        button[choose_button] = R.drawable.puppy;
                    image++;
                    if (image == 7)
                        image = 1;
                } else if (imageRepository == 2) {
                    if (image == 1)
                        button[choose_button] = R.drawable.tropical_fish;
                    else if (image == 2)
                        button[choose_button] = R.drawable.octopus;
                    else if (image == 3)
                        button[choose_button] = R.drawable.lobster;
                    else if (image == 4)
                        button[choose_button] = R.drawable.jellyfish;
                    else if (image == 5)
                        button[choose_button] = R.drawable.crab;
                    else
                        button[choose_button] = R.drawable.dolphin;
                    image++;
                    if (image == 7)
                        image = 1;
                } else if (imageRepository == 3) {
                    if (image == 1)
                        button[choose_button] = R.drawable.pony;
                    else if (image == 2)
                        button[choose_button] = R.drawable.mouse;
                    else if (image == 3)
                        button[choose_button] = R.drawable.kitten;
                    else if (image == 4)
                        button[choose_button] = R.drawable.horse;
                    else if (image == 5)
                        button[choose_button] = R.drawable.cow;
                    else
                        button[choose_button] = R.drawable.donkey;
                    image++;
                    if (image == 7)
                        image = 1;
                } else if (imageRepository == 4) {
                    if (image == 1)
                        button[choose_button] = R.drawable.gold_fish;
                    else if (image == 2)
                        button[choose_button] = R.drawable.fish;
                    else if (image == 3)
                        button[choose_button] = R.drawable.frog;
                    else if (image == 4)
                        button[choose_button] = R.drawable.duck;
                    else if (image == 5)
                        button[choose_button] = R.drawable.parrot;
                    else
                        button[choose_button] = R.drawable.bird;
                    image++;
                    if (image == 7)
                        image = 1;
                } else if (imageRepository == 5) {
                    if (image == 1)
                        button[choose_button] = R.drawable.black_cat;
                    else if (image == 2)
                        button[choose_button] = R.drawable.bulldog;
                    else if (image == 3)
                        button[choose_button] = R.drawable.cardinal;
                    else if (image == 4)
                        button[choose_button] = R.drawable.chicken;
                    else if (image == 5)
                        button[choose_button] = R.drawable.bunny;
                    else
                        button[choose_button] = R.drawable.hamster;
                    image++;
                    if (image == 7)
                        image = 1;
                } else if (imageRepository == 6) {
                    if (image == 1)
                        button[choose_button] = R.drawable.dog;
                    else if (image == 2)
                        button[choose_button] = R.drawable.dachshund;
                    else if (image == 3)
                        button[choose_button] = R.drawable.hamster;
                    else if (image == 4)
                        button[choose_button] = R.drawable.chihuahua;
                    else if (image == 5)
                        button[choose_button] = R.drawable.bunny;
                    else
                        button[choose_button] = R.drawable.cat;
                    image++;
                    if (image == 7)
                        image = 1;
                } else
                    imageRepository = 0;
            }
        }
        type_of_move = 1;
    }

    public boolean corresponds(int button_number) {
        if (button_number != 0 && button[0] == button[button_number] && !btn0.isEnabled())
            return true;
        else if (button_number != 1 && button[1] == button[button_number] && !btn1.isEnabled())
            return true;
        else if (button_number != 2 && button[2] == button[button_number] && !btn2.isEnabled())
            return true;
        else if (button_number != 3 && button[3] == button[button_number] && !btn3.isEnabled())
            return true;
        else if (button_number != 4 && button[4] == button[button_number] && !btn4.isEnabled())
            return true;
        else if (button_number != 5 && button[5] == button[button_number] && !btn5.isEnabled())
            return true;
        else if (button_number != 6 && button[6] == button[button_number] && !btn6.isEnabled())
            return true;
        else if (button_number != 7 && button[7] == button[button_number] && !btn7.isEnabled())
            return true;
        else if (button_number != 8 && button[8] == button[button_number] && !btn8.isEnabled())
            return true;
        else if (button_number != 9 && button[9] == button[button_number] && !btn9.isEnabled())
            return true;
        else if (button_number != 10 && button[10] == button[button_number] && !btn10.isEnabled())
            return true;
        else
            return button_number != 11 && button[11] == button[button_number] && !btn11.isEnabled();
    }

    public void redistribute() {
        if (hide_images[0] == 0 || hide_images[1] == 0) {
            btn0.setEnabled(true);
            btn0.setImageResource(R.drawable.ic_launcher);
        }
        if (hide_images[0] == 1 || hide_images[1] == 1) {
            btn1.setEnabled(true);
            btn1.setImageResource(R.drawable.ic_launcher);
        }
        if (hide_images[0] == 2 || hide_images[1] == 2) {
            btn2.setEnabled(true);
            btn2.setImageResource(R.drawable.ic_launcher);
        }
        if (hide_images[0] == 3 || hide_images[1] == 3) {
            btn3.setEnabled(true);
            btn3.setImageResource(R.drawable.ic_launcher);
        }
        if (hide_images[0] == 4 || hide_images[1] == 4) {
            btn4.setEnabled(true);
            btn4.setImageResource(R.drawable.ic_launcher);
        }
        if (hide_images[0] == 5 || hide_images[1] == 5) {
            btn5.setEnabled(true);
            btn5.setImageResource(R.drawable.ic_launcher);
        }
        if (hide_images[0] == 6 || hide_images[1] == 6) {
            btn6.setEnabled(true);
            btn6.setImageResource(R.drawable.ic_launcher);
        }
        if (hide_images[0] == 7 || hide_images[1] == 7) {
            btn7.setEnabled(true);
            btn7.setImageResource(R.drawable.ic_launcher);
        }
        if (hide_images[0] == 8 || hide_images[1] == 8) {
            btn8.setEnabled(true);
            btn8.setImageResource(R.drawable.ic_launcher);
        }
        if (hide_images[0] == 9 || hide_images[1] == 9) {
            btn9.setEnabled(true);
            btn9.setImageResource(R.drawable.ic_launcher);
        }
        if (hide_images[0] == 10 || hide_images[1] == 10) {
            btn10.setEnabled(true);
            btn10.setImageResource(R.drawable.ic_launcher);
        }
        if (hide_images[0] == 11 || hide_images[1] == 11) {
            btn11.setEnabled(true);
            btn11.setImageResource(R.drawable.ic_launcher);
        }
    }

    protected void pauseOn() {
        btnStart.setEnabled(true);
        btnStart.setBackgroundResource(R.drawable.start);
        btnPause.setEnabled(false);
        btnPause.setBackgroundResource(R.drawable.pause1);
        currentTime = chronometer.getBase() - SystemClock.elapsedRealtime();
        chronometer.stop();
    }

    protected void pauseOff() {
        btnStart.setEnabled(false);
        btnStart.setBackgroundResource(R.drawable.start1);
        btnPause.setEnabled(true);
        btnPause.setBackgroundResource(R.drawable.pause);
        chronometer.setBase(SystemClock.elapsedRealtime() + currentTime);
        chronometer.start();

    }

    protected void reload() {
        btnStart.setEnabled(true);
        btnStart.setBackgroundResource(R.drawable.start);
        btnPause.setEnabled(false);
        btnPause.setBackgroundResource(R.drawable.pause);
        chronometer.stop();
        chronometer.setBase(SystemClock.elapsedRealtime());
        currentTime = 0;
        stopVoices();
        chooseImages();
    }

    protected void finalTest() {
        if (!btn0.isEnabled() && !btn1.isEnabled() && !btn2.isEnabled() &&
                !btn3.isEnabled() && !btn4.isEnabled() && !btn5.isEnabled() &&
                !btn6.isEnabled() && !btn7.isEnabled() && !btn8.isEnabled() &&
                !btn9.isEnabled() && !btn10.isEnabled() && !btn11.isEnabled()) {
            chronometer.stop();
            finalVoices();
            alertBuilder();
            imageRepository++;
        }
    }

    protected void alertBuilder() {
        Intent displaymain = new Intent(MainActivity.this, SplashActivity.class);
        MainActivity.this.startActivity(displaymain);
        MainActivity.this.finish();
        currentTime = chronometer.getBase() - SystemClock.elapsedRealtime();
        SplashActivity.time = currentTime;

        /*AlertDialog.Builder gameAndBuilder = new AlertDialog.Builder(this);
        gameAndBuilder.setCancelable(false);
        gameAndBuilder.setIcon(R.drawable.trophy);
        if(level == 7) {
            gameAndBuilder.setTitle("Parabéns!!!" + " NVL " + level);
            gameAndBuilder.setMessage("Você chegou ao NVL máximo!!\n" + "Deseja jogar novamente?");
            level = 1;
        }else {
            gameAndBuilder.setTitle("Parabéns!!!" + " NVL " + level);
            gameAndBuilder.setMessage("Pronto para o próximo nível?");
        }
        gameAndBuilder.setPositiveButton("Sim", (dialog, id) -> {
            imageRepository++;
            level++;
            chooseImages();
            reload();
        });
        gameAndBuilder.setNegativeButton("Não",
                this::onClick);
        gameAndBuilder.show(); */
    }

   /* private void onClick(DialogInterface dialog, int id) {
        level = 1;
        MainActivity.this.finish();
    }*/

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        alertBuilder();
        imageRepository = 0;
        SplashActivity.level = 0;
    }
}
