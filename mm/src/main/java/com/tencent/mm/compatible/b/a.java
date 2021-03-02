package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a {
    public static void a(AudioManager audioManager, int i2, int i3) {
        AppMethodBeat.i(155545);
        if (d.oD(24)) {
            Log.i("MicroMsg.AudioAdaptNHelp", "adjustStreamVolume()");
            try {
                audioManager.adjustStreamVolume(i2, i3, 5);
                AppMethodBeat.o(155545);
            } catch (Exception e2) {
                Log.e("MicroMsg.AudioAdaptNHelp", "adjustStreamVolume() Exception: %s", e2.getMessage());
                requestPermission();
                AppMethodBeat.o(155545);
            }
        } else {
            audioManager.adjustStreamVolume(i2, i3, 5);
            AppMethodBeat.o(155545);
        }
    }

    public static void a(AudioManager audioManager, int i2, int i3, int i4) {
        AppMethodBeat.i(214357);
        if (d.oD(24)) {
            Log.i("MicroMsg.AudioAdaptNHelp", "setStreamVolume()");
            try {
                audioManager.setStreamVolume(i2, i3, 0);
                AppMethodBeat.o(214357);
            } catch (Exception e2) {
                Log.e("MicroMsg.AudioAdaptNHelp", "setStreamVolume() Exception:%s", e2.getMessage());
                requestPermission();
                AppMethodBeat.o(214357);
            }
        } else {
            audioManager.setStreamVolume(i2, i3, 0);
            AppMethodBeat.o(214357);
        }
    }

    @TargetApi(26)
    private static void requestPermission() {
        AppMethodBeat.i(155547);
        if (Build.VERSION.SDK_INT >= 23) {
            boolean isNotificationPolicyAccessGranted = ((NotificationManager) MMApplicationContext.getContext().getSystemService("notification")).isNotificationPolicyAccessGranted();
            Log.i("MicroMsg.AudioAdaptNHelp", "requestPermission() result:%s", Boolean.valueOf(isNotificationPolicyAccessGranted));
            if (!isNotificationPolicyAccessGranted) {
                try {
                    Intent intent = new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS");
                    intent.putExtra("android.provider.extra.APP_PACKAGE", MMApplicationContext.getPackageName());
                    Context context = MMApplicationContext.getContext();
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/compatible/audio/AudioAdaptNHelp", "requestPermission", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/compatible/audio/AudioAdaptNHelp", "requestPermission", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(155547);
                    return;
                } catch (Exception e2) {
                    Log.e("MicroMsg.AudioAdaptNHelp", "requestPermission() Exception:%s", e2.getMessage());
                }
            }
        }
        AppMethodBeat.o(155547);
    }
}
