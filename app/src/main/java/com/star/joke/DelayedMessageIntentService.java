package com.star.joke;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class DelayedMessageIntentService extends IntentService {

    public static final String TAG = "DelayedMessageIntentService";
    public static final String EXTRA_MESSAGE = "message";

    public DelayedMessageIntentService() {
        super("DelayedMessageIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        synchronized (this) {
            try {
                wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            showText(intent.getStringExtra(EXTRA_MESSAGE));
        }
    }

    private void showText(String text) {
        Log.v(TAG, "The message is: " + text);
    }

}
