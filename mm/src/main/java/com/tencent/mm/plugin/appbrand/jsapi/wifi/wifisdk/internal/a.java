package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiConfiguration;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class a {
    public boolean mHU = false;
    public BroadcastReceiver mHV = null;
    public String mHX;
    public String mHY;
    public Handler mHandler = null;
    private com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a mIi;
    public Context mIl;
    C0724a mIm = null;
    b mIn = null;
    public WifiConfiguration mIo = null;
    ConnectivityManager mIp;
    private int mIq = 0;
    private final int mIr = 13000;
    public boolean mIs = false;

    private static Object a(C0724a aVar, String str) {
        AppMethodBeat.i(144707);
        Class<?> cls = Class.forName(str);
        Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, aVar);
        AppMethodBeat.o(144707);
        return newProxyInstance;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a$a  reason: collision with other inner class name */
    public class C0724a implements InvocationHandler {
        private final WifiConfiguration mIu;

        public C0724a(WifiConfiguration wifiConfiguration) {
            this.mIu = wifiConfiguration;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            AppMethodBeat.i(144705);
            if (method.getName().compareTo("onSuccess") == 0) {
                Log.i("MicroMsg.WiFiConnector", "connectWifi use ActionListener success");
                AppMethodBeat.o(144705);
            } else {
                if (method.getName().compareTo("onFailure") == 0) {
                    Log.w("MicroMsg.WiFiConnector", "connectWifi use ActionListener fail, fallback to enableNetwork");
                    d.xQ(this.mIu.networkId);
                }
                AppMethodBeat.o(144705);
            }
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements InvocationHandler {
        b() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            AppMethodBeat.i(144706);
            Log.i("MicroMsg.WiFiConnector", "Method:" + method + " getName:" + method.getName() + " ,Args:" + objArr);
            AppMethodBeat.o(144706);
            return null;
        }
    }

    public a(com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a aVar, Context context) {
        AppMethodBeat.i(144708);
        this.mIi = aVar;
        this.mIl = context;
        try {
            this.mIp = (ConnectivityManager) this.mIl.getSystemService("connectivity");
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WiFiConnector", e2, "can not retrieve ConnectivityManager", new Object[0]);
        }
        this.mHandler = new Handler(context.getMainLooper()) {
            /* class com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a.AnonymousClass1 */

            public final void handleMessage(Message message) {
                AppMethodBeat.i(144702);
                if (message == null) {
                    AppMethodBeat.o(144702);
                    return;
                }
                switch (message.what) {
                    case 1:
                        Log.i("MicroMsg.WiFiConnector", "MSG_TIME_OUT");
                        if (!a.this.bLM()) {
                            a.this.abI("fail to connect wifi:time out");
                            Log.i("MicroMsg.wifi_event", "MSG_TIME_OUT FAIL.");
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(144702);
            }
        };
        AppMethodBeat.o(144708);
    }

    private void bLL() {
        AppMethodBeat.i(144709);
        if (this.mHU) {
            this.mIl.unregisterReceiver(this.mHV);
            this.mHU = false;
            Log.i("MicroMsg.WiFiConnector", "stopMonitorWiFiEvent");
        }
        AppMethodBeat.o(144709);
    }

    public final boolean a(WifiConfiguration wifiConfiguration) {
        AppMethodBeat.i(144710);
        if (wifiConfiguration == null || wifiConfiguration.networkId == e.mIE || this.mIp == null) {
            AppMethodBeat.o(144710);
            return false;
        }
        try {
            Class<?> cls = Class.forName("android.net.wifi.WifiManager");
            if (Build.VERSION.SDK_INT < 16) {
                cls.getMethod("asyncConnect", Context.class, Handler.class).invoke(d.chC, this.mIl, this.mHandler);
                cls.getMethod("connectNetwork", Integer.TYPE).invoke(d.chC, Integer.valueOf(wifiConfiguration.networkId));
                AppMethodBeat.o(144710);
                return true;
            } else if (Build.VERSION.SDK_INT == 16) {
                if (this.mIn == null) {
                    this.mIn = new b();
                }
                Object a2 = a(this.mIm, "android.net.wifi.WifiManager$ChannelListener");
                Object invoke = cls.getMethod("initialize", Context.class, Looper.class, Class.forName("android.net.wifi.WifiManager$ChannelListener")).invoke(d.chC, this.mIl, this.mIl.getMainLooper(), a2);
                if (this.mIm == null) {
                    this.mIm = new C0724a(wifiConfiguration);
                }
                Object a3 = a(this.mIm, "android.net.wifi.WifiManager$ActionListener");
                cls.getMethod("connect", Class.forName("android.net.wifi.WifiManager$Channel"), Integer.TYPE, Class.forName("android.net.wifi.WifiManager$ActionListener")).invoke(d.chC, invoke, Integer.valueOf(wifiConfiguration.networkId), a3);
                AppMethodBeat.o(144710);
                return true;
            } else if (Build.VERSION.SDK_INT >= 29) {
                boolean b2 = b(wifiConfiguration);
                AppMethodBeat.o(144710);
                return b2;
            } else {
                if (this.mIm == null) {
                    this.mIm = new C0724a(wifiConfiguration);
                }
                Object a4 = a(this.mIm, "android.net.wifi.WifiManager$ActionListener");
                cls.getMethod("connect", Integer.TYPE, Class.forName("android.net.wifi.WifiManager$ActionListener")).invoke(d.chC, Integer.valueOf(wifiConfiguration.networkId), a4);
                AppMethodBeat.o(144710);
                return true;
            }
        } catch (Exception e2) {
            Log.w("MicroMsg.WiFiConnector", "connectWifi fail since " + e2.toString() + ", try fallback");
            boolean b3 = b(wifiConfiguration);
            AppMethodBeat.o(144710);
            return b3;
        }
    }

    private static boolean b(WifiConfiguration wifiConfiguration) {
        AppMethodBeat.i(215175);
        Log.i("MicroMsg.WiFiConnector", "doConnectWifiFallbackLogic");
        boolean xQ = d.xQ(wifiConfiguration.networkId);
        AppMethodBeat.o(215175);
        return xQ;
    }

    public final boolean bLM() {
        return this.mIq == 3 || this.mIq == 2;
    }

    public final void abI(String str) {
        AppMethodBeat.i(144711);
        if (this.mIo != null) {
            b.xP(this.mIo.networkId);
            q(false, str);
            Log.i("MicroMsg.wifi_event", "cancelConnect, " + e.abJ(this.mIo.SSID) + " networkId:" + this.mIo.networkId);
            Log.i("MicroMsg.WiFiConnector", "cancelConnect");
        }
        AppMethodBeat.o(144711);
    }

    public final void xN(int i2) {
        AppMethodBeat.i(144712);
        if (this.mIq != i2) {
            this.mIq = i2;
            Log.i("MicroMsg.WiFiConnector", "switchState:" + xO(this.mIq));
        }
        AppMethodBeat.o(144712);
    }

    public final void q(boolean z, String str) {
        AppMethodBeat.i(144713);
        Log.i("MicroMsg.WiFiConnector", "finishConnectTask success:".concat(String.valueOf(z)));
        if (!bLM()) {
            if (this.mIi != null) {
                com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a aVar = this.mIi;
                String str2 = this.mHX;
                String str3 = this.mHY;
                if (z) {
                    str = "ok";
                }
                aVar.H(str2, str3, str);
            }
            this.mHandler.removeMessages(1);
            bLL();
            xN(z ? 2 : 3);
            if (!z && this.mIo != null) {
                b.xP(this.mIo.networkId);
            }
        }
        AppMethodBeat.o(144713);
    }

    private static String xO(int i2) {
        switch (i2) {
            case 0:
                return "STATE_NONE";
            case 1:
                return "STATE_CONNECTING";
            case 2:
                return "STATE_CONNECTED";
            case 3:
                return "STATE_FAIL";
            default:
                return "UnknowState";
        }
    }
}
