package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.hellhoundlib.b.c;
import java.util.LinkedList;
import java.util.List;

public class PhoneStatusWatcher {
    private static final String TAG = "MicroMsg.PhoneStatusWatcher";
    private static boolean calling;
    private byte _hellAccFlag_;
    private List<PhoneCallListener> phoneCallListeners = new LinkedList();
    private PhoneStateListener phoneStateListener;
    private TelephonyManager tm;

    public interface PhoneCallListener {
        void onPhoneCall(int i2);
    }

    public PhoneStatusWatcher() {
        AppMethodBeat.i(157774);
        AppMethodBeat.o(157774);
    }

    public void addPhoneCallListener(PhoneCallListener phoneCallListener) {
        AppMethodBeat.i(157775);
        this.phoneCallListeners.add(phoneCallListener);
        AppMethodBeat.o(157775);
    }

    public void removePhoneCallListener(PhoneCallListener phoneCallListener) {
        AppMethodBeat.i(230367);
        this.phoneCallListeners.remove(phoneCallListener);
        AppMethodBeat.o(230367);
    }

    public void clearPhoneCallListener() {
        AppMethodBeat.i(157776);
        this.phoneCallListeners.clear();
        AppMethodBeat.o(157776);
    }

    public static boolean isCalling() {
        AppMethodBeat.i(157777);
        Log.i(TAG, "alvinluo isCalling: %b", Boolean.valueOf(calling));
        boolean z = calling;
        AppMethodBeat.o(157777);
        return z;
    }

    public void begin(Context context) {
        AppMethodBeat.i(157778);
        Log.i(TAG, "alvinluo PhoneStatusWatcher begin");
        if (this.tm == null) {
            this.tm = (TelephonyManager) context.getSystemService("phone");
        }
        if (this.phoneStateListener == null) {
            this.phoneStateListener = new PhoneStateListener() {
                /* class com.tencent.mm.sdk.platformtools.PhoneStatusWatcher.AnonymousClass1 */

                public void onCallStateChanged(int i2, String str) {
                    AppMethodBeat.i(157773);
                    Log.i(PhoneStatusWatcher.TAG, "alvinluo onCallStateChanged state: %d, incomingNumber: %s", Integer.valueOf(i2), str);
                    if (PhoneStatusWatcher.this.phoneCallListeners.size() > 0) {
                        for (PhoneCallListener phoneCallListener : (PhoneCallListener[]) PhoneStatusWatcher.this.phoneCallListeners.toArray(new PhoneCallListener[PhoneStatusWatcher.this.phoneCallListeners.size()])) {
                            phoneCallListener.onPhoneCall(i2);
                        }
                    }
                    super.onCallStateChanged(i2, str);
                    switch (i2) {
                        case 0:
                            boolean unused = PhoneStatusWatcher.calling = false;
                            AppMethodBeat.o(157773);
                            return;
                        case 1:
                        case 2:
                            boolean unused2 = PhoneStatusWatcher.calling = true;
                            break;
                    }
                    AppMethodBeat.o(157773);
                }
            };
        }
        TelephonyManager telephonyManager = this.tm;
        a bl = c.a(32, new a()).bl(this.phoneStateListener);
        com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/mm/sdk/platformtools/PhoneStatusWatcher", "begin", "(Landroid/content/Context;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/mm/sdk/platformtools/PhoneStatusWatcher", "begin", "(Landroid/content/Context;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        AppMethodBeat.o(157778);
    }

    public void end() {
        AppMethodBeat.i(157779);
        Log.i(TAG, "alvinluo PhoneStatusWatcher end");
        if (this.tm != null) {
            TelephonyManager telephonyManager = this.tm;
            a bl = c.a(0, new a()).bl(this.phoneStateListener);
            com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/mm/sdk/platformtools/PhoneStatusWatcher", "end", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/mm/sdk/platformtools/PhoneStatusWatcher", "end", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            this.phoneStateListener = null;
        }
        AppMethodBeat.o(157779);
    }
}
