package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.app.ActivityManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class n {
    static boolean a(Configuration configuration, Configuration configuration2) {
        if (configuration != null && configuration2 != null && configuration.screenWidthDp == configuration2.screenWidthDp && configuration.screenHeightDp == configuration2.screenHeightDp && configuration.smallestScreenWidthDp == configuration2.smallestScreenWidthDp) {
            return false;
        }
        return true;
    }

    static ActivityManager.TaskDescription a(c.a aVar) {
        AppMethodBeat.i(176758);
        int i2 = aVar.colorPrimary;
        int rgb = Color.rgb(Color.red(i2), Color.green(i2), Color.blue(i2));
        if (aVar.noe <= 0) {
            ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription(aVar.label, aVar.nEk, rgb);
            AppMethodBeat.o(176758);
            return taskDescription;
        } else if (Build.VERSION.SDK_INT >= 28) {
            ActivityManager.TaskDescription taskDescription2 = new ActivityManager.TaskDescription(aVar.label, aVar.noe, rgb);
            AppMethodBeat.o(176758);
            return taskDescription2;
        } else {
            try {
                ActivityManager.TaskDescription taskDescription3 = new ActivityManager.TaskDescription(aVar.label, MMBitmapFactory.decodeResource(MMApplicationContext.getResources(), aVar.noe), rgb);
                AppMethodBeat.o(176758);
                return taskDescription3;
            } catch (Exception e2) {
                Log.e("Luggage.WXA.WindowAndroidActivityFactory", "decode bitmap failed e=%s", e2);
                ActivityManager.TaskDescription taskDescription4 = new ActivityManager.TaskDescription(aVar.label, (Bitmap) null, rgb);
                AppMethodBeat.o(176758);
                return taskDescription4;
            }
        }
    }
}
