package org.extra.tools;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScreenBroadcastReceiver extends BroadcastReceiver {
    private a Uia;

    public interface a {
        void onScreenOff();

        void onScreenOn();
    }

    public ScreenBroadcastReceiver(a aVar) {
        this.Uia = aVar;
    }

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(236826);
        String action = intent.getAction();
        if ("android.intent.action.SCREEN_ON".equals(action)) {
            this.Uia.onScreenOn();
            AppMethodBeat.o(236826);
            return;
        }
        if ("android.intent.action.SCREEN_OFF".equals(action)) {
            this.Uia.onScreenOff();
        }
        AppMethodBeat.o(236826);
    }

    public static Context getApplicationContext() {
        Context context;
        AppMethodBeat.i(236827);
        try {
            context = ((Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext();
        } catch (Exception e2) {
            context = null;
        }
        AppMethodBeat.o(236827);
        return context;
    }
}
