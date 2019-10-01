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

public class Yasin extends AppCompatActivity {

    FloatingActionButton fp,ps;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yasin);

        fp=(FloatingActionButton)findViewById(R.id.playyasin);
        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("android.resource://"+getPackageName() + "/"+R.raw.y);
                mp = new MediaPlayer();
                mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try{
                    mp.setDataSource(getApplicationContext(),uri);


                }catch (IllegalArgumentException e){
                    Toast.makeText(getApplicationContext(), "You might not set the URI correctly!",
                            Toast.LENGTH_LONG).show();

                } catch (SecurityException e){
                    Toast.makeText(getApplicationContext(), "You might not set the URI correctly!",
                            Toast.LENGTH_LONG).show();

                }catch (IllegalStateException e){
                    Toast.makeText(getApplicationContext(), "You might not set the URI correctly!",
                            Toast.LENGTH_LONG).show();

                }catch (IOException e){
                    e.printStackTrace();
                }
                try{
                    mp.prepare();
                }catch (IllegalArgumentException e){
                    Toast.makeText(getApplicationContext(), "You might not set the URI correctly!",
                            Toast.LENGTH_LONG).show();
                }
                catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "You might not set the URI correctly!",
                            Toast.LENGTH_LONG).show();
                }
                mp.start();

            }
        });
        ps = (FloatingActionButton)findViewById(R.id.stopyasin);
        ps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp != null && mp.isPlaying() ){
                    mp.stop();

                }
            }
        });

        ImageView back =(ImageView) findViewById(R.id.backyasin);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp != null && mp.isPlaying() ){
                    mp.stop();

                }
                startActivity(new Intent(Yasin.this,MainActivity.class));
                finish();
            }
        });
    }

}
