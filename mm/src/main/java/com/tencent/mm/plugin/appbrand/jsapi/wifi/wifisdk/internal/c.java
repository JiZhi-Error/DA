package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.MacAddress;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiNetworkSpecifier;
import android.net.wifi.WifiNetworkSuggestion;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J(\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiConnector29Impl;", "", "()V", "TAG", "", com.tencent.mm.plugin.appbrand.jsapi.wifi.a.NAME, "", "context", "Landroid/content/Context;", TPDownloadProxyEnum.USER_SSID, TPDownloadProxyEnum.USER_BSSID, "password", "timeoutMs", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiConnector29Impl$IListener;", "tryKeepConnectedWifi", "IListener", "luggage-commons-jsapi-connectivity-ext_release"})
public final class c {
    public static final c mIv = new c();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiConnector29Impl$IListener;", "", "onConnectFailure", "", "onConnectSuccess", "luggage-commons-jsapi-connectivity-ext_release"})
    public interface a {
        void bLN();

        void bLO();
    }

    static {
        AppMethodBeat.i(215140);
        AppMethodBeat.o(215140);
    }

    private c() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiConnector29Impl$connectWifi$listenerWrapper$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiConnector29Impl$IListener;", "called", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onConnectFailure", "", "onConnectSuccess", "luggage-commons-jsapi-connectivity-ext_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c$c  reason: collision with other inner class name */
    public static final class C0725c implements a {
        private final AtomicBoolean mIB = new AtomicBoolean(false);
        final /* synthetic */ a mIC;

        C0725c(a aVar) {
            this.mIC = aVar;
            AppMethodBeat.i(215138);
            AppMethodBeat.o(215138);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.a
        public final void bLN() {
            AppMethodBeat.i(215136);
            if (this.mIB.compareAndSet(false, true)) {
                this.mIC.bLN();
                AppMethodBeat.o(215136);
                return;
            }
            Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "onConnectSuccess, already call");
            AppMethodBeat.o(215136);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.a
        public final void bLO() {
            AppMethodBeat.i(215137);
            if (this.mIB.compareAndSet(false, true)) {
                this.mIC.bLO();
                AppMethodBeat.o(215137);
                return;
            }
            Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "onConnectFailure, already call");
            AppMethodBeat.o(215137);
        }
    }

    public static void a(Context context, String str, String str2, String str3, a aVar) {
        boolean z;
        Context applicationContext;
        ConnectivityManager connectivityManager = null;
        AppMethodBeat.i(215139);
        p.h(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "connectWifi, ssid: " + str + ", bssid: " + str2 + ", timeoutMs: 13000");
        C0725c cVar = new C0725c(aVar);
        Object systemService = (context == null || (applicationContext = context.getApplicationContext()) == null) ? null : applicationContext.getSystemService("connectivity");
        if (systemService instanceof ConnectivityManager) {
            connectivityManager = systemService;
        }
        ConnectivityManager connectivityManager2 = connectivityManager;
        if (connectivityManager2 == null) {
            Log.w("MicroMsg.AppBrand.WifiConnector29Impl", "connectWifi, connectivityManager is null");
            cVar.bLO();
            AppMethodBeat.o(215139);
        } else if (str == null || str2 == null || str3 == null) {
            Log.w("MicroMsg.AppBrand.WifiConnector29Impl", "connectWifi, connect params illegal");
            cVar.bLO();
            AppMethodBeat.o(215139);
        } else {
            try {
                WifiNetworkSpecifier.Builder builder = new WifiNetworkSpecifier.Builder();
                builder.setSsid(str);
                try {
                    if (str2.length() > 0) {
                        builder.setBssid(MacAddress.fromString(str2));
                    }
                } catch (Exception e2) {
                }
                if (str3.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    builder.setWpa2Passphrase(str3);
                }
                WifiNetworkSpecifier build = builder.build();
                p.g(build, "try {\n                Wi…     return\n            }");
                try {
                    connectivityManager2.requestNetwork(new NetworkRequest.Builder().addTransportType(1).setNetworkSpecifier(build).build(), new b(cVar, connectivityManager2, context, str, str2, str3));
                    AppMethodBeat.o(215139);
                } catch (Exception e3) {
                    Log.w("MicroMsg.AppBrand.WifiConnector29Impl", "connectWifi, fail since ".concat(String.valueOf(e3)));
                    cVar.bLO();
                    AppMethodBeat.o(215139);
                }
            } catch (Exception e4) {
                Log.w("MicroMsg.AppBrand.WifiConnector29Impl", "connectWifi, build network specifier fail since ".concat(String.valueOf(e4)));
                cVar.bLO();
                AppMethodBeat.o(215139);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiConnector29Impl$connectWifi$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", TencentLocation.NETWORK_PROVIDER, "Landroid/net/Network;", "onLost", "onUnavailable", "luggage-commons-jsapi-connectivity-ext_release"})
    public static final class b extends ConnectivityManager.NetworkCallback {
        final /* synthetic */ Context $context;
        final /* synthetic */ String mIA;
        final /* synthetic */ C0725c mIw;
        final /* synthetic */ ConnectivityManager mIx;
        final /* synthetic */ String mIy;
        final /* synthetic */ String mIz;

        b(C0725c cVar, ConnectivityManager connectivityManager, Context context, String str, String str2, String str3) {
            this.mIw = cVar;
            this.mIx = connectivityManager;
            this.$context = context;
            this.mIy = str;
            this.mIz = str2;
            this.mIA = str3;
        }

        public final void onAvailable(Network network) {
            AppMethodBeat.i(215133);
            p.h(network, TencentLocation.NETWORK_PROVIDER);
            super.onAvailable(network);
            Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "onAvailable, network: ".concat(String.valueOf(network)));
            this.mIw.bLN();
            Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "onAvailable, success: ".concat(String.valueOf(this.mIx.bindProcessToNetwork(network))));
            c cVar = c.mIv;
            c.d(this.$context, this.mIy, this.mIz, this.mIA);
            AppMethodBeat.o(215133);
        }

        public final void onUnavailable() {
            AppMethodBeat.i(215134);
            super.onUnavailable();
            Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "onUnavailable");
            this.mIw.bLO();
            AppMethodBeat.o(215134);
        }

        public final void onLost(Network network) {
            AppMethodBeat.i(215135);
            p.h(network, TencentLocation.NETWORK_PROVIDER);
            super.onLost(network);
            Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "onLost, network: ".concat(String.valueOf(network)));
            this.mIw.bLO();
            this.mIx.bindProcessToNetwork(null);
            this.mIx.unregisterNetworkCallback(this);
            AppMethodBeat.o(215135);
        }
    }

    public static final /* synthetic */ void d(Context context, String str, String str2, String str3) {
        boolean z;
        AppMethodBeat.i(215141);
        Context applicationContext = context.getApplicationContext();
        Object systemService = applicationContext != null ? applicationContext.getSystemService("wifi") : null;
        if (!(systemService instanceof WifiManager)) {
            systemService = null;
        }
        WifiManager wifiManager = (WifiManager) systemService;
        if (wifiManager == null) {
            AppMethodBeat.o(215141);
            return;
        }
        WifiNetworkSuggestion.Builder builder = new WifiNetworkSuggestion.Builder();
        builder.setSsid(str);
        if (str2.length() > 0) {
            builder.setBssid(MacAddress.fromString(str2));
        }
        if (str3.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            builder.setWpa2Passphrase(str3);
        }
        WifiNetworkSuggestion build = builder.build();
        p.g(build, "WifiNetworkSuggestion.Bu…\n                .build()");
        try {
            Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "tryKeepConnectedWifi, status: ".concat(String.valueOf(wifiManager.addNetworkSuggestions(j.listOf(build)))));
            AppMethodBeat.o(215141);
        } catch (Exception e2) {
            Log.i("MicroMsg.AppBrand.WifiConnector29Impl", "tryKeepConnectedWifi, addNetworkSuggestions fail, e: ".concat(String.valueOf(e2)));
            AppMethodBeat.o(215141);
        }
    }
}
