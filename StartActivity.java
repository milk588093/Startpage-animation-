/*------------------------------------------------------------------------------------------------------------*
 *                                                                                                            *
 * Copyright      2021 Sightour Inc.                                                                          *
 *                                                                                                            *
 *------------------------------------------------------------------------------------------------------------*
 * PROJECT     :  ZenShot                                                                                     *
 * BINARY NAME :                                                                                              *
 * FILE NAME   :  StartActivity.java                                                                           *
 * CREATED BY  :  Leo Zeng <leozeng@sightour.com>                                                           *
 * CREATED DATE:  01/27/21 (MM/DD/YY)                                                                         *
 * DESCRIPTION :  StartPage.                                                                              *
 *------------------------------------------------------------------------------------------------------------*/
package com.asus.zenshot;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class StartActivity extends AppCompatActivity
{
    Handler mainHandler;
    ImageView mImageView ;
    int[] arr3= {
             R.drawable.a1, R.drawable.a2,
            R.drawable.a3, R.drawable.a4,
            R.drawable.a5, R.drawable.a6,
            R.drawable.a7, R.drawable.a8,
            R.drawable.a9, R.drawable.a10,
            R.drawable.a11, R.drawable.a12,
            R.drawable.a13, R.drawable.a14,
            R.drawable.a15, R.drawable.a16,
            R.drawable.a17, R.drawable.a18,
            R.drawable.a19, R.drawable.a20,
            R.drawable.a21, R.drawable.a22,
            R.drawable.a23, R.drawable.a24,
            R.drawable.a25, R.drawable.a26,
            R.drawable.a27, R.drawable.a28,
            R.drawable.a29, R.drawable.a30,
            R.drawable.a31, R.drawable.a32,
            R.drawable.a33,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        mImageView = (ImageView) findViewById(R.id.imageView2); //this is your imageView
        final Timer timer = new Timer();
        mainHandler = new Handler(Looper.getMainLooper());
        final TimerTask  task = new TimerTask () {
            int i = 0;
            public void run() {
                mainHandler.post(new Runnable()
                {
                    @Override
                    public void run() {
                        if (i < arr3.length) {
                            mImageView.setImageResource(arr3[i]);
                            i++;
                            if(i ==arr3.length) {
                                   Timer timer2=new Timer();
                                   timer2.schedule(new TimerTask() {
                                       public void run() {
                                           showMainActivity();
                                           this.cancel();
                                       }
                                           },41);
                            }
                        }
                    }
                });
            }
        };
        timer.schedule (task, 0, 41);




       /* int duration = 47;
        int totalDuration = 47* arr3.length;
        new CountDownTimer(totalDuration ,duration)
        {
            int i = 0;
            @Override
            public void onTick(long l)
            {
                if (i < arr3.length){
                 mImageView.setImageResource(arr3[i]);
                    i++;
                    Log.d("aaa", "i = " + i);
                    }
            }
            @Override
            public void onFinish()
            {   Log.d("aaa", "showMainActivity()" );
               showMainActivity();
            }
        }.start();*/
    }

  public void showMainActivity()
    {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);

    }

}
