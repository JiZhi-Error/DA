package com.tencent.mm.plugin.appbrand.config;

import android.os.SystemClock;
import android.webkit.WebSettings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ag;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0002J\u0014\u0010\u0014\u001a\u00020\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0007R\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/config/AppBrandNetworkConfigUserAgentHelper;", "", "()V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "MMKV_KEY", "", "MMKV_NAME", "TAG", "mMemoryCachedUA", "Ljava/util/concurrent/atomic/AtomicReference;", "getByMMKV", "getByWebkit", "getSystemUserAgent", "setMMKV", "", "ua", "warmUpMemoryCache", "_ua", "luggage-wechat-full-sdk_release"})
public final class j {
    private static final AtomicReference<String> let = new AtomicReference<>();
    public static final j leu = new j();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"getByHeavyInvoke", "", "invoke"})
    public static final class a extends q implements kotlin.g.a.a<String> {
        public static final a lev = new a();

        static {
            AppMethodBeat.i(169546);
            AppMethodBeat.o(169546);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(169544);
            String bAa = bAa();
            AppMethodBeat.o(169544);
            return bAa;
        }

        public static String bAa() {
            String str;
            String str2;
            AppMethodBeat.i(169545);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            j jVar = j.leu;
            String bzY = j.bzY();
            if (bzY == null || (str = bzY.toString()) == null) {
                str = "";
            }
            boolean LB = ag.LB();
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            if (elapsedRealtime2 <= 32 || !LB) {
                Log.i("Luggage.Utils.Profile", "runProfiled:log:" + "Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent try mmkv" + " cost " + elapsedRealtime2 + " ms result:" + str + " isMainThread: " + LB + ' ');
            } else {
                Log.w("Luggage.Utils.Profile", "block main thread and skip " + ((int) (elapsedRealtime2 / 16)) + " frames! runProfiled:log:" + "Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent try mmkv" + " cost " + elapsedRealtime2 + " ms result:" + str + " isMainThread: " + LB + ' ');
            }
            String str3 = bzY;
            if (!(str3 == null || str3.length() == 0)) {
                AppMethodBeat.o(169545);
            } else {
                long elapsedRealtime3 = SystemClock.elapsedRealtime();
                j jVar2 = j.leu;
                bzY = j.bzZ();
                if (bzY == null || (str2 = bzY.toString()) == null) {
                    str2 = "";
                }
                boolean LB2 = ag.LB();
                long elapsedRealtime4 = SystemClock.elapsedRealtime() - elapsedRealtime3;
                if (elapsedRealtime4 <= 32 || !LB2) {
                    Log.i("Luggage.Utils.Profile", "runProfiled:log:" + "Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent by webkit" + " cost " + elapsedRealtime4 + " ms result:" + str2 + " isMainThread: " + LB2 + ' ');
                } else {
                    Log.w("Luggage.Utils.Profile", "block main thread and skip " + ((int) (elapsedRealtime4 / 16)) + " frames! runProfiled:log:" + "Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent by webkit" + " cost " + elapsedRealtime4 + " ms result:" + str2 + " isMainThread: " + LB2 + ' ');
                }
                if (bzY == null) {
                    p.hyc();
                }
                AppMethodBeat.o(169545);
            }
            return bzY;
        }
    }

    static {
        AppMethodBeat.i(169550);
        AppMethodBeat.o(169550);
    }

    private j() {
    }

    public static final /* synthetic */ String bzZ() {
        AppMethodBeat.i(169552);
        String bzX = bzX();
        AppMethodBeat.o(169552);
        return bzX;
    }

    public static final String bzW() {
        AppMethodBeat.i(169547);
        String str = let.get();
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            Log.i("Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper", "getSystemUserAgent by memory cache");
            AppMethodBeat.o(169547);
            return str;
        }
        a aVar = a.lev;
        String bAa = a.bAa();
        let.set(bAa);
        AppMethodBeat.o(169547);
        return bAa;
    }

    public static final String Xb(String str) {
        AppMethodBeat.i(230054);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            str = bzX();
        }
        Log.i("Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper", "warmUpMemoryCache updated value = [ " + str + " ]");
        if (!p.j(str, let.getAndSet(str))) {
            MultiProcessMMKV.getMMKV("AppBrandNetworkConfigUserAgentHelper", 2).encode("UserAgent", str);
        }
        AppMethodBeat.o(230054);
        return str;
    }

    private static String bzX() {
        String property;
        AppMethodBeat.i(169549);
        try {
            property = WebSettings.getDefaultUserAgent(MMApplicationContext.getContext());
            p.g(property, "WebSettings.getDefaultUs…tionContext.getContext())");
        } catch (Throwable th) {
            property = System.getProperty("http.agent");
            if (property == null) {
                property = "";
            }
        }
        AppMethodBeat.o(169549);
        return property;
    }

    public static final /* synthetic */ String bzY() {
        AppMethodBeat.i(169551);
        String decodeString = MultiProcessMMKV.getMMKV("AppBrandNetworkConfigUserAgentHelper", 2).decodeString("UserAgent");
        AppMethodBeat.o(169551);
        return decodeString;
    }
}
