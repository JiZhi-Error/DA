package com.tencent.thumbplayer.utils;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class TPNetworkChangeMonitor extends BroadcastReceiver {
    private static int Sfm = 0;
    private static String Sfn = "unknown";
    private static int Sfo = 0;
    private static int Sfp = Sfm;
    private static String Sfq;
    private HandlerThread Sfr;
    private ArrayList<b> mListeners;

    public interface b {
        void my(int i2, int i3);
    }

    /* synthetic */ TPNetworkChangeMonitor(byte b2) {
        this();
    }

    private TPNetworkChangeMonitor() {
        AppMethodBeat.i(189646);
        this.mListeners = null;
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        AppMethodBeat.o(189646);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private static TPNetworkChangeMonitor Sfs = new TPNetworkChangeMonitor((byte) 0);

        static {
            AppMethodBeat.i(189645);
            AppMethodBeat.o(189645);
        }
    }

    public static TPNetworkChangeMonitor hop() {
        AppMethodBeat.i(189647);
        TPNetworkChangeMonitor tPNetworkChangeMonitor = a.Sfs;
        AppMethodBeat.o(189647);
        return tPNetworkChangeMonitor;
    }

    public final synchronized void init(Context context) {
        AppMethodBeat.i(189648);
        b.e(context, "context can not be null!");
        if (this.Sfr == null) {
            this.Sfr = new HandlerThread("TP_NetInform");
            this.Sfr.start();
        }
        a(context, new Handler(this.Sfr.getLooper()));
        lj(context);
        AppMethodBeat.o(189648);
    }

    private synchronized void a(Context context, Handler handler) {
        AppMethodBeat.i(189649);
        if (context != null) {
            context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, handler);
        }
        AppMethodBeat.o(189649);
    }

    public void onReceive(Context context, Intent intent) {
        boolean z;
        AppMethodBeat.i(189650);
        StringBuilder sb = new StringBuilder("onReceive broadcast action and update net status,onReceive broadcast in ");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            z = true;
        } else {
            z = false;
        }
        g.d("TPNetworkChangeMonitor", sb.append(z ? "main" : "work").append(" thread.").toString());
        lj(context);
        AppMethodBeat.o(189650);
    }

    @SuppressLint({"MissingPermission"})
    private void lj(Context context) {
        ConnectivityManager connectivityManager;
        AppMethodBeat.i(189651);
        if (context != null) {
            try {
                connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            } catch (Exception e2) {
                AppMethodBeat.o(189651);
                return;
            }
        } else {
            connectivityManager = null;
        }
        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                if (a(networkInfo)) {
                    Sfm = 3;
                } else if (a(networkInfo2)) {
                    Sfm = 2;
                    networkInfo = networkInfo2;
                } else {
                    Sfm = 1;
                    networkInfo = activeNetworkInfo;
                }
            } else if (a(activeNetworkInfo)) {
                Sfm = a(networkInfo) ? 3 : 2;
                networkInfo = activeNetworkInfo;
            } else {
                Sfm = 1;
                networkInfo = activeNetworkInfo;
            }
            switch (Sfm) {
                case 1:
                    Sfo = 0;
                    break;
                case 2:
                    Sfo = 1;
                    break;
                case 3:
                    Sfo = b(networkInfo);
                    break;
            }
            Sfn = c(networkInfo);
            if (Sfp == 0) {
                Sfp = Sfm;
                Sfq = Sfn;
            }
            hor();
            hoq();
        }
        AppMethodBeat.o(189651);
    }

    private synchronized void hoq() {
        AppMethodBeat.i(189652);
        boolean z = Sfm != Sfp || !TextUtils.equals(Sfn, Sfq);
        g.i("TPNetworkChangeMonitor", "notifyIfNetChanged, isNetChanged: " + z + ",  mListeners:  " + this.mListeners);
        g.i("TPNetworkChangeMonitor", "onNetworkStatusChanged oldNetStatus: " + Sfp + ", netStatus: " + Sfm + ", mobileNetSubType" + Sfo);
        if (z) {
            Iterator<b> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().my(Sfp, Sfm);
            }
            Sfp = Sfm;
            Sfq = Sfn;
        }
        AppMethodBeat.o(189652);
    }

    private static boolean a(NetworkInfo networkInfo) {
        AppMethodBeat.i(189653);
        if (networkInfo == null || (!networkInfo.isConnected() && !networkInfo.isConnectedOrConnecting())) {
            AppMethodBeat.o(189653);
            return false;
        }
        AppMethodBeat.o(189653);
        return true;
    }

    private static void hor() {
        AppMethodBeat.i(189654);
        g.d("TPNetworkChangeMonitor", "-->updateNetStatus(), mNetStatus=" + Sfm + "[wifi: 2, mobile: 3], lastNetStatus=" + Sfp + ", mDetailNetworkType=" + Sfn + ", mobileNetSubType=" + Sfo + "[2G:2 3G:3 4G:4], currentDetailNetType=" + Sfn + ", lastDetailNetType=" + Sfq);
        AppMethodBeat.o(189654);
    }

    public final synchronized void a(b bVar) {
        AppMethodBeat.i(189655);
        if (this.mListeners != null && !this.mListeners.contains(bVar)) {
            this.mListeners.add(bVar);
            g.d("TPNetworkChangeMonitor", "add onNetStatus change listener: " + bVar + ", mListeners: " + this.mListeners.size());
        }
        AppMethodBeat.o(189655);
    }

    public final synchronized void b(b bVar) {
        AppMethodBeat.i(189656);
        if (this.mListeners != null) {
            this.mListeners.remove(bVar);
            g.d("TPNetworkChangeMonitor", "remove netStatusChangeListener, listener: " + bVar + ", mListeners: " + this.mListeners.size());
        }
        AppMethodBeat.o(189656);
    }

    private static int b(NetworkInfo networkInfo) {
        int i2 = 0;
        AppMethodBeat.i(189657);
        if (networkInfo != null) {
            switch (networkInfo.getSubtype()) {
                case 0:
                    break;
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    i2 = 2;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    i2 = 3;
                    break;
                case 13:
                    i2 = 4;
                    break;
                default:
                    i2 = 3;
                    break;
            }
        }
        AppMethodBeat.o(189657);
        return i2;
    }

    private static String c(NetworkInfo networkInfo) {
        String str;
        String str2 = null;
        AppMethodBeat.i(189658);
        String typeName = networkInfo != null ? networkInfo.getTypeName() : null;
        g.d("TPNetworkChangeMonitor", "getDetailNetworkType, typeName: ".concat(String.valueOf(typeName)));
        if (typeName != null) {
            if (!typeName.toLowerCase(Locale.getDefault()).equals("wifi")) {
                String extraInfo = networkInfo.getExtraInfo();
                if (extraInfo != null) {
                    str2 = extraInfo.toLowerCase(Locale.getDefault());
                }
                if (str2 != null) {
                    if (str2.startsWith("cmwap")) {
                        str = "cmwap";
                    } else if (str2.startsWith("cmnet") || str2.startsWith("epc.tmobile.com")) {
                        str = "cmnet";
                    } else if (str2.startsWith("uniwap")) {
                        str = "uniwap";
                    } else if (str2.startsWith("uninet")) {
                        str = "uninet";
                    } else if (str2.startsWith("wap")) {
                        str = "wap";
                    } else if (str2.startsWith("net")) {
                        str = "net";
                    } else if (str2.startsWith("ctwap")) {
                        str = "ctwap";
                    } else if (str2.startsWith("ctnet")) {
                        str = "ctnet";
                    } else if (str2.startsWith("3gwap")) {
                        str = "3gwap";
                    } else if (str2.startsWith("3gnet")) {
                        str = "3gnet";
                    } else if (str2.startsWith("#777")) {
                        String defaultHost = Proxy.getDefaultHost();
                        if (defaultHost == null || defaultHost.length() <= 0) {
                            str = "ctnet";
                        } else {
                            str = "ctwap";
                        }
                    } else {
                        str = "unknown";
                    }
                }
            } else {
                str = "wifi";
            }
            AppMethodBeat.o(189658);
            return str;
        }
        str = "unknown";
        AppMethodBeat.o(189658);
        return str;
    }

    public static int aYS() {
        return Sfm;
    }
}
