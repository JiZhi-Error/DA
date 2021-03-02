package com.tencent.mm.plugin.appbrand.jsapi.z;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tav.core.ExportErrorStatus;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class f extends d {
    public static final int CTRL_INDEX = 39;
    public static final String NAME = "getNetworkType";
    private final AtomicBoolean mtA = new AtomicBoolean(false);
    private Method mtB = null;
    volatile int mtC = Integer.MAX_VALUE;
    private final AtomicBoolean mtD = new AtomicBoolean(false);
    final b mtE = new b(this, (byte) 0);

    /* access modifiers changed from: package-private */
    public interface a {
        void xp(int i2);
    }

    public f() {
        AppMethodBeat.i(193712);
        AppMethodBeat.o(193712);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(137664);
        final HashMap hashMap = new HashMap();
        c D = D(fVar);
        Log.i("MicroMsg.JsApiGetNetworkType", "invoke appId:%s, networkType:%s", fVar.getAppId(), D);
        hashMap.put("networkType", D.value);
        switch (D) {
            case Mobile_2g:
            case Mobile_3g:
            case Mobile_4g:
            case Mobile_5g:
                AnonymousClass1 r1 = new a() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.z.f.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.z.f.a
                    public final void xp(int i2) {
                        AppMethodBeat.i(193705);
                        Log.i("MicroMsg.JsApiGetNetworkType", "onGetSignalStrength, dbm: ".concat(String.valueOf(i2)));
                        if (Integer.MAX_VALUE != i2) {
                            hashMap.put("signalStrength", Integer.valueOf(i2));
                        }
                        fVar.i(i2, f.this.n("ok", hashMap));
                        AppMethodBeat.o(193705);
                    }
                };
                if (!this.mtD.getAndSet(true)) {
                    h.RTc.aV(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.z.f.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(193707);
                            TelephonyManager telephonyManager = (TelephonyManager) fVar.getContext().getApplicationContext().getSystemService("phone");
                            com.tencent.mm.hellhoundlib.b.a bl = com.tencent.mm.hellhoundlib.b.c.a(256, new com.tencent.mm.hellhoundlib.b.a()).bl(f.this.mtE.bIQ());
                            com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType$3", "run", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
                            telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
                            com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType$3", "run", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
                            AppMethodBeat.o(193707);
                        }
                    });
                }
                if (this.mtE.bIR()) {
                    r1.xp(this.mtC);
                    AppMethodBeat.o(137664);
                    return;
                }
                this.mtE.a(r1);
                AppMethodBeat.o(137664);
                return;
            case Wifi:
                AnonymousClass2 r12 = new a() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.z.f.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.z.f.a
                    public final void xp(int i2) {
                        AppMethodBeat.i(193706);
                        Log.i("MicroMsg.JsApiGetNetworkType", "onGetSignalStrength, dbm: ".concat(String.valueOf(i2)));
                        if (Integer.MAX_VALUE != i2) {
                            hashMap.put("signalStrength", Integer.valueOf(i2));
                        }
                        fVar.i(i2, f.this.n("ok", hashMap));
                        AppMethodBeat.o(193706);
                    }
                };
                WifiInfo connectionInfo = ((WifiManager) fVar.getContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo == null || connectionInfo.getBSSID() == null) {
                    Log.w("MicroMsg.JsApiGetNetworkType", "getWifiSignalStrength, getConnectionInfo is invalid");
                    r12.xp(Integer.MAX_VALUE);
                    AppMethodBeat.o(137664);
                    return;
                }
                r12.xp(connectionInfo.getRssi());
                AppMethodBeat.o(137664);
                return;
            case None:
            case mtR:
                fVar.i(i2, n("ok", hashMap));
                break;
        }
        AppMethodBeat.o(137664);
    }

    /* access modifiers changed from: protected */
    public c D(com.tencent.mm.plugin.appbrand.jsapi.f fVar) {
        AppMethodBeat.i(137665);
        c dS = dS(fVar.getContext());
        AppMethodBeat.o(137665);
        return dS;
    }

    public enum c {
        None("none"),
        Mobile_2g("2g"),
        Mobile_3g("3g"),
        Mobile_4g("4g"),
        Mobile_5g("5g"),
        Wifi("wifi"),
        mtR("unknown");
        
        public final String value;

        public static c valueOf(String str) {
            AppMethodBeat.i(137662);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(137662);
            return cVar;
        }

        static {
            AppMethodBeat.i(137663);
            AppMethodBeat.o(137663);
        }

        private c(String str) {
            this.value = str;
        }
    }

    public static c dS(Context context) {
        AppMethodBeat.i(137666);
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                c cVar = c.mtR;
                AppMethodBeat.o(137666);
                return cVar;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                c cVar2 = c.None;
                AppMethodBeat.o(137666);
                return cVar2;
            } else if (activeNetworkInfo.getType() == 1) {
                c cVar3 = c.Wifi;
                AppMethodBeat.o(137666);
                return cVar3;
            } else if (activeNetworkInfo.getSubtype() == 2 || activeNetworkInfo.getSubtype() == 1 || activeNetworkInfo.getSubtype() == 4) {
                c cVar4 = c.Mobile_2g;
                AppMethodBeat.o(137666);
                return cVar4;
            } else if (activeNetworkInfo.getSubtype() >= 5 && activeNetworkInfo.getSubtype() < 13) {
                c cVar5 = c.Mobile_3g;
                AppMethodBeat.o(137666);
                return cVar5;
            } else if (activeNetworkInfo.getSubtype() < 13 || activeNetworkInfo.getSubtype() >= 20) {
                if (activeNetworkInfo.getSubtype() >= 20) {
                    c cVar6 = c.Mobile_5g;
                    AppMethodBeat.o(137666);
                    return cVar6;
                }
                c cVar7 = c.mtR;
                AppMethodBeat.o(137666);
                return cVar7;
            } else {
                c cVar8 = c.Mobile_4g;
                AppMethodBeat.o(137666);
                return cVar8;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.JsApiGetNetworkType", e2, "", new Object[0]);
        }
    }

    class b {
        private PhoneStateListener mtH;
        boolean mtI;
        List<a> mtJ;

        private b() {
            this.mtH = null;
            this.mtI = false;
            this.mtJ = null;
        }

        /* synthetic */ b(f fVar, byte b2) {
            this();
        }

        public final synchronized PhoneStateListener bIQ() {
            PhoneStateListener phoneStateListener;
            AppMethodBeat.i(193710);
            if (this.mtH == null) {
                this.mtH = new PhoneStateListener() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.z.f.b.AnonymousClass1 */

                    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
                        AppMethodBeat.i(193709);
                        super.onSignalStrengthsChanged(signalStrength);
                        int a2 = f.this.a(signalStrength);
                        Log.i("MicroMsg.JsApiGetNetworkType", "onSignalStrengthsChanged, dbm: ".concat(String.valueOf(a2)));
                        f.this.mtC = a2;
                        synchronized (b.this) {
                            try {
                                if (!b.this.mtI) {
                                    b.this.mtI = true;
                                    if (b.this.mtJ != null) {
                                        for (a aVar : b.this.mtJ) {
                                            aVar.xp(a2);
                                        }
                                        b.this.mtJ.clear();
                                        b.this.mtJ = null;
                                    }
                                }
                            } finally {
                                AppMethodBeat.o(193709);
                            }
                        }
                    }
                };
            }
            phoneStateListener = this.mtH;
            AppMethodBeat.o(193710);
            return phoneStateListener;
        }

        public final synchronized boolean bIR() {
            return this.mtI;
        }

        public final synchronized void a(a aVar) {
            AppMethodBeat.i(193711);
            if (this.mtJ == null) {
                this.mtJ = new ArrayList();
            }
            this.mtJ.add(aVar);
            AppMethodBeat.o(193711);
        }
    }

    /* access modifiers changed from: package-private */
    public final int a(SignalStrength signalStrength) {
        AppMethodBeat.i(193713);
        Method bIP = bIP();
        if (bIP == null) {
            int b2 = b(signalStrength);
            AppMethodBeat.o(193713);
            return b2;
        }
        try {
            int intValue = ((Integer) bIP.invoke(signalStrength, new Object[0])).intValue();
            AppMethodBeat.o(193713);
            return intValue;
        } catch (Exception e2) {
            Log.w("MicroMsg.JsApiGetNetworkType", "getDbm, reflect getDbm fail since ".concat(String.valueOf(e2)));
            int b3 = b(signalStrength);
            AppMethodBeat.o(193713);
            return b3;
        }
    }

    private Method bIP() {
        AppMethodBeat.i(193714);
        if (!this.mtA.getAndSet(true)) {
            try {
                this.mtB = SignalStrength.class.getMethod("getDbm", new Class[0]);
            } catch (Exception e2) {
                Log.w("MicroMsg.JsApiGetNetworkType", "getGetDbmMethod, reflect getDbm fail since ".concat(String.valueOf(e2)));
                this.mtB = null;
            }
        }
        Method method = this.mtB;
        AppMethodBeat.o(193714);
        return method;
    }

    private static int b(SignalStrength signalStrength) {
        int cdmaDbm;
        AppMethodBeat.i(193715);
        if (signalStrength.isGsm()) {
            cdmaDbm = c(signalStrength);
        } else {
            cdmaDbm = signalStrength.getCdmaDbm();
        }
        Log.i("MicroMsg.JsApiGetNetworkType", "getDbmFallback, dBm: ".concat(String.valueOf(cdmaDbm)));
        AppMethodBeat.o(193715);
        return cdmaDbm;
    }

    private static int c(SignalStrength signalStrength) {
        int i2 = -1;
        AppMethodBeat.i(193716);
        int gsmSignalStrength = signalStrength.getGsmSignalStrength();
        if ((gsmSignalStrength == 99 ? -1 : gsmSignalStrength) != -1) {
            i2 = (gsmSignalStrength * 2) + ExportErrorStatus.APPEND_VIDEO_SAMPLE_SWAP_BUFFERS;
        }
        AppMethodBeat.o(193716);
        return i2;
    }
}
