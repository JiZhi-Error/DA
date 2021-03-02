package com.tencent.mm.plugin.lite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import com.tencent.liteapp.a;
import com.tencent.liteapp.jsapi.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.b.f;
import com.tencent.mm.plugin.lite.debug.LiteAppDebugIPCCallbackData;
import com.tencent.mm.plugin.lite.debug.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import org.xwalk.core.XWalkEnvironment;

public final class c extends LiteAppCenter implements LiteAppCenter.IWxaLiteAppCallback {
    public static final List<String> yDV = Arrays.asList("wxalitecce81f5fba338df4dd5f74df8229c600", "wxalitea95723728764364c6f996b4bdab3af52");
    private static int yDW = 0;
    private static HashMap<Integer, a> yDX = new HashMap<>();

    static {
        AppMethodBeat.i(198805);
        j.load("mmv8");
        j.load("flutter");
        j.load("wechatlv");
        AppMethodBeat.o(198805);
    }

    public static void init() {
        AppMethodBeat.i(198792);
        setWxaLiteAppCallback(new c());
        AppMethodBeat.o(198792);
    }

    public static int a(a aVar) {
        AppMethodBeat.i(198793);
        yDW++;
        yDX.put(Integer.valueOf(yDW), aVar);
        int i2 = yDW;
        AppMethodBeat.o(198793);
        return i2;
    }

    public static void a(int i2, int i3, int i4, Intent intent) {
        AppMethodBeat.i(198794);
        a aVar = yDX.get(Integer.valueOf(i2));
        if (aVar == null) {
            AppMethodBeat.o(198794);
            return;
        }
        aVar.b(i3, i4, intent);
        yDX.remove(Integer.valueOf(i2));
        AppMethodBeat.o(198794);
    }

    @Override // com.tencent.mm.plugin.lite.LiteAppCenter.IWxaLiteAppCallback
    public final String[] getAppInfo(String str) {
        return new String[0];
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0026  */
    @Override // com.tencent.mm.plugin.lite.LiteAppCenter.IWxaLiteAppCallback
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void openPage(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15) {
        /*
        // Method dump skipped, instructions count: 255
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.lite.c.openPage(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    @Override // com.tencent.mm.plugin.lite.LiteAppCenter.IWxaLiteAppCallback
    public final String getUin() {
        AppMethodBeat.i(198796);
        String sb = new StringBuilder().append(((long) com.tencent.mm.kernel.a.ayW()) & Util.MAX_32BIT_VALUE).toString();
        AppMethodBeat.o(198796);
        return sb;
    }

    @Override // com.tencent.mm.plugin.lite.LiteAppCenter.IWxaLiteAppCallback
    public final LiteAppCenter.HostInfo getHostInfo() {
        AppMethodBeat.i(198797);
        LiteAppCenter.HostInfo hostInfo = new LiteAppCenter.HostInfo();
        hostInfo.system = "Android";
        hostInfo.systemVersion = "Android " + Build.VERSION.RELEASE;
        hostInfo.appVersion = BuildInfo.CLIENT_VERSION;
        hostInfo.appRevision = BuildInfo.REV;
        hostInfo.appBranch = BuildInfo.BUILD_TAG;
        hostInfo.appBuildJob = BuildInfo.HOSTNAME;
        hostInfo.appBuildTime = BuildInfo.TIME;
        hostInfo.appFlavor = BuildInfo.IS_FLAVOR_RED ? "red" : "release";
        AppMethodBeat.o(198797);
        return hostInfo;
    }

    @Override // com.tencent.mm.plugin.lite.LiteAppCenter.IWxaLiteAppCallback
    public final LiteAppCenter.SystemInfo getSystemInfo() {
        AppMethodBeat.i(198798);
        LiteAppCenter.SystemInfo systemInfo = new LiteAppCenter.SystemInfo();
        Context context = MMApplicationContext.getContext();
        if (!NetStatusUtil.isConnected(context)) {
            systemInfo.networkType = "none";
        } else if (NetStatusUtil.is2G(context)) {
            systemInfo.networkType = "2g";
        } else if (NetStatusUtil.is3G(context)) {
            systemInfo.networkType = "3g";
        } else if (NetStatusUtil.is4G(context)) {
            systemInfo.networkType = "4g";
        } else if (NetStatusUtil.isWifi(context)) {
            systemInfo.networkType = "wifi";
        } else {
            systemInfo.networkType = "unknown";
        }
        float f2 = context.getResources().getDisplayMetrics().density;
        systemInfo.brand = Build.MANUFACTURER;
        systemInfo.model = Build.MODEL;
        systemInfo.language = LocaleUtil.getCurrentLanguage(context);
        systemInfo.platform = "Android";
        systemInfo.system = "Android" + Build.VERSION.RELEASE;
        systemInfo.version = BuildInfo.CLIENT_VERSION;
        systemInfo.pixelRatio = f2;
        systemInfo.navigationBarHeight = ((float) au.aD(context)) / f2;
        systemInfo.statusBarHeight = ((float) au.ay(context)) / f2;
        systemInfo.titleBarHeight = ((float) au.eu(context)) / f2;
        systemInfo.darkMode = ao.isDarkMode();
        AppMethodBeat.o(198798);
        return systemInfo;
    }

    @Override // com.tencent.mm.plugin.lite.LiteAppCenter.IWxaLiteAppCallback
    public final String getUserAgent() {
        String str;
        NetworkInfo activeNetworkInfo;
        int i2 = 0;
        AppMethodBeat.i(198799);
        String str2 = "NoNet";
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) MMApplicationContext.getContext().getSystemService("connectivity");
            if (!(connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null)) {
                switch (activeNetworkInfo.getType()) {
                    case 0:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        str2 = "4G";
                        break;
                    case 1:
                        str2 = "WIFI";
                        break;
                    default:
                        str2 = "OtherNet";
                        break;
                }
            }
            String str3 = "arm32";
            String[] strArr = Build.SUPPORTED_ABIS;
            int length = strArr.length;
            while (true) {
                if (i2 < length) {
                    if (XWalkEnvironment.RUNTIME_ABI_ARM64_STR.equals(strArr[i2])) {
                        str3 = "arm64";
                    } else {
                        i2++;
                    }
                }
            }
            a.C0147a aVar = com.tencent.liteapp.a.cqJ;
            PackageManager packageManager = a.C0147a.getAppContext().getPackageManager();
            a.C0147a aVar2 = com.tencent.liteapp.a.cqJ;
            String str4 = com.tencent.liteapp.a.packageName;
            if (str4 == null) {
                p.btv(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(str4, 0);
            String str5 = packageInfo.versionName;
            int i3 = packageInfo.versionCode;
            Object[] objArr = new Object[10];
            objArr[0] = Build.VERSION.RELEASE;
            objArr[1] = Build.MODEL;
            objArr[2] = Build.ID;
            objArr[3] = str5;
            objArr[4] = Integer.valueOf(i3);
            objArr[5] = BuildInfo.CLIENT_VERSION;
            objArr[6] = str2;
            objArr[7] = LocaleUtil.getApplicationLanguage();
            objArr[8] = str3;
            if (BuildInfo.IS_ARM64) {
                str = "arm64";
            } else {
                str = "arm32";
            }
            objArr[9] = str;
            String format = String.format("Mozilla/5.0 (Linux; Android %s; %s Build/%s; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/66.0.3359.126 MQQBrowser/6.2 TBS/045140 Mobile Safari/537.36 MMWEBID/3371 MicroMessenger/%s.%d(%s) Process/lite NetType/%s Language/%s ABI/%s WeChat/%s", objArr);
            Log.i("MicroMsg.MMWxaLiteAppCenter", "get user agent:".concat(String.valueOf(format)));
            AppMethodBeat.o(198799);
            return format;
        } catch (Exception e2) {
            String property = System.getProperty("http.agent");
            AppMethodBeat.o(198799);
            return property;
        }
    }

    @Override // com.tencent.mm.plugin.lite.LiteAppCenter.IWxaLiteAppCallback
    public final String getOfflineResource(String str, String str2, String str3) {
        AppMethodBeat.i(198800);
        f ecC = f.ecC();
        if (!ecC.yEN.isEmpty()) {
            for (Map.Entry<String, k> entry : ecC.yEN.entrySet()) {
                Bundle bundle = new Bundle();
                bundle.putString("appId", str);
                bundle.putString("tag", str2);
                bundle.putString("url", str3);
                Bundle bundle2 = (Bundle) h.a(entry.getKey(), bundle, entry.getValue().getClass());
                if (!(bundle2 == null || Util.isNullOrNil(bundle2.getString("result")))) {
                    String string = bundle2.getString("result");
                    AppMethodBeat.o(198800);
                    return string;
                }
            }
        }
        AppMethodBeat.o(198800);
        return null;
    }

    @Override // com.tencent.mm.plugin.lite.LiteAppCenter.IWxaLiteAppCallback
    public final void reportKv(int i2, String str) {
        AppMethodBeat.i(198801);
        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(i2, str);
        AppMethodBeat.o(198801);
    }

    @Override // com.tencent.mm.plugin.lite.LiteAppCenter.IWxaLiteAppCallback
    public final void reportIdKey(long j2, long j3, long j4) {
        AppMethodBeat.i(198802);
        com.tencent.mm.plugin.report.service.h.INSTANCE.n(j2, j3, j4);
        AppMethodBeat.o(198802);
    }

    @Override // com.tencent.mm.plugin.lite.LiteAppCenter.IWxaLiteAppCallback
    public final void hideKeyboard() {
        AppMethodBeat.i(198803);
        Activity activity = com.tencent.wxa.c.hrH().SxG.getActivity();
        if (activity instanceof com.tencent.liteapp.ui.a) {
            ((com.tencent.liteapp.ui.a) activity).hideKeyboard();
        }
        AppMethodBeat.o(198803);
    }

    @Override // com.tencent.mm.plugin.lite.LiteAppCenter.IWxaLiteAppCallback
    public final void reloadDebug(String str, String str2) {
        AppMethodBeat.i(198804);
        Bundle bundle = new Bundle();
        bundle.putString("appId", str);
        bundle.putString("qr_url_query_string", str2);
        h.a(MMApplicationContext.getPackageName(), bundle, b.class, new d<LiteAppDebugIPCCallbackData>() {
            /* class com.tencent.mm.plugin.lite.debug.a.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(LiteAppDebugIPCCallbackData liteAppDebugIPCCallbackData) {
                AppMethodBeat.i(198811);
                Log.i("MicroMsg.LiteAppDebug", "IPCInvoker.invokeAsync ret = ".concat(String.valueOf(liteAppDebugIPCCallbackData.cqU)));
                AppMethodBeat.o(198811);
            }
        });
        AppMethodBeat.o(198804);
    }

    @Override // com.tencent.mm.plugin.lite.LiteAppCenter.IWxaLiteAppCallback
    public final String getLiteAppRoot() {
        return ar.NSg;
    }
}
