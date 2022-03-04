package com.app.aidlsample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.Nullable;

public class RemoteAidlService extends Service {
    public static final String TAG = "IRemoteAidl";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new AAA();
    }

    private static class AAA extends IRemoteAidl.Stub {
        @Override
        public String search(String key) throws RemoteException {
            Log.i(TAG, "search。Key: " + key + ", Thread: " + Thread.currentThread());
            SystemClock.sleep(2000);
            return "Hello, " + key;
        }
    }
}
