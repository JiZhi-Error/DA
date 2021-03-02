package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class c {
    public Lock aIR;
    public Activity activity;
    public BroadcastReceiver broadcastReceiver;
    public WifiManager cnK;
    public boolean connected = false;
    public String dQC;
    public Condition dgF;
    public String ssid;
    public long timeout;
    public boolean wMF = false;

    public interface a {
        void onFail(int i2);

        void onSuccess();
    }

    public c(String str, Activity activity2, String str2) {
        AppMethodBeat.i(24645);
        this.activity = activity2;
        this.timeout = 30000;
        this.ssid = str;
        this.dQC = str2;
        this.aIR = new ReentrantLock();
        this.dgF = this.aIR.newCondition();
        this.cnK = (WifiManager) MMApplicationContext.getContext().getSystemService("wifi");
        AppMethodBeat.o(24645);
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.c$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] wMI = new int[SupplicantState.values().length];

        static {
            AppMethodBeat.i(24644);
            try {
                wMI[SupplicantState.ASSOCIATED.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                wMI[SupplicantState.ASSOCIATING.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                wMI[SupplicantState.AUTHENTICATING.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                wMI[SupplicantState.COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                wMI[SupplicantState.DISCONNECTED.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                wMI[SupplicantState.DORMANT.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
            try {
                wMI[SupplicantState.FOUR_WAY_HANDSHAKE.ordinal()] = 7;
            } catch (NoSuchFieldError e8) {
            }
            try {
                wMI[SupplicantState.GROUP_HANDSHAKE.ordinal()] = 8;
            } catch (NoSuchFieldError e9) {
            }
            try {
                wMI[SupplicantState.INACTIVE.ordinal()] = 9;
            } catch (NoSuchFieldError e10) {
            }
            try {
                wMI[SupplicantState.INTERFACE_DISABLED.ordinal()] = 10;
            } catch (NoSuchFieldError e11) {
            }
            try {
                wMI[SupplicantState.INVALID.ordinal()] = 11;
            } catch (NoSuchFieldError e12) {
            }
            try {
                wMI[SupplicantState.SCANNING.ordinal()] = 12;
            } catch (NoSuchFieldError e13) {
            }
            try {
                wMI[SupplicantState.UNINITIALIZED.ordinal()] = 13;
                AppMethodBeat.o(24644);
            } catch (NoSuchFieldError e14) {
                AppMethodBeat.o(24644);
            }
        }
    }

    public final void dMu() {
        AppMethodBeat.i(24646);
        try {
            this.activity.unregisterReceiver(this.broadcastReceiver);
            AppMethodBeat.o(24646);
        } catch (IllegalArgumentException e2) {
            AppMethodBeat.o(24646);
        }
    }
}
