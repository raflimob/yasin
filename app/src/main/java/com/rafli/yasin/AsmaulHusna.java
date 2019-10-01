package com.rafli.yasin;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class AsmaulHusna extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    FloatingActionButton fsa,fpa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asmaul_husna);

        ImageView back =(ImageView) findViewById(R.id.backasma);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                startActivity(new Intent(AsmaulHusna.this,MainActivity.class));
                finish();
            }
        });

        fpa = (FloatingActionButton) findViewById(R.id.playasma);
        fpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uriw = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.a);

                mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);


                try {
                    mediaPlayer.setDataSource(getApplicationContext(), uriw);


                } catch (IllegalArgumentException e) {
                    Toast.makeText(getApplicationContext(), "You might not set the URI correctly!",
                            Toast.LENGTH_LONG).show();

                } catch (SecurityException e) {
                    Toast.makeText(getApplicationContext(), "You might not set the URI correctly!",
                            Toast.LENGTH_LONG).show();

                } catch (IllegalStateException e) {
                    Toast.makeText(getApplicationContext(), "You might not set the URI correctly!",
                            Toast.LENGTH_LONG).show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                try{
                    mediaPlayer.prepare();
                }catch (IllegalArgumentException e){
                    Toast.makeText(getApplicationContext(), "You might not set the URI correctly!",
                            Toast.LENGTH_LONG).show();
                }
                catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "You might not set the URI correctly!",
                            Toast.LENGTH_LONG).show();
                }
                mediaPlayer.start();


            }

        });

        fsa = (FloatingActionButton) findViewById(R.id.stopasma);
        fsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }


            }
        });
    }
}
