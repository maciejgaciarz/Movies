package com.learning.mgaciarz.movies;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.Iterator;
import java.util.Set;

public class IntentDebug {

    public void dumpIntent(Intent i, String LOG_TAG){

        Bundle bun = i.getExtras();
        if (bun != null) {
            Set<String> keys = bun.keySet();
            Iterator<String> it = keys.iterator();
            Log.e(LOG_TAG,"Dumping Intent start");
            while (it.hasNext()) {
                String key = it.next();
                Log.e(LOG_TAG,"[" + key + "=" + bun.get(key)+"]");
            }
            Log.e(LOG_TAG,"Dumping Intent end");
        }
    }
}
