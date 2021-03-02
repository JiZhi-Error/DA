package com.tencent.mm.plugin.appbrand.jsapi.z;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.support.v4.app.v;
import android.view.View;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.luggage.h.i;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.df;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public class k<C extends d> extends i<C> {
    public static final int CTRL_INDEX = 40;
    public static final String NAME = "getSystemInfo";

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.tencent.mm.plugin.appbrand.jsapi.z.k<C extends com.tencent.mm.plugin.appbrand.d> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.z.i
    public /* bridge */ /* synthetic */ Map a(f fVar) {
        AppMethodBeat.i(147303);
        Map<String, Object> a2 = a((d) fVar);
        AppMethodBeat.o(147303);
        return a2;
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> a(C c2) {
        int i2;
        int i3;
        View m;
        AppMethodBeat.i(147302);
        Map<String, Object> a2 = super.a((f) c2);
        int[] n = ai.n(c2);
        a2.put("windowWidth", Integer.valueOf(g.zB(n[0])));
        a2.put("windowHeight", Integer.valueOf(g.zB(n[1])));
        int[] f2 = ai.f(c2);
        int i4 = f2[0];
        int i5 = f2[1];
        a2.put("screenWidth", Integer.valueOf(g.zB(i4)));
        a2.put("screenHeight", Integer.valueOf(g.zB(i5)));
        a2.put("pixelRatio", Float.valueOf(g.bZk()));
        ac i6 = df.i(c2);
        if (i6 == null || i6.bRj() == null || (i2 = i6.bRj().getDrawnStatusBarHeight()) == 0) {
            c.C0789c statusBar = c2.getWindowAndroid().getStatusBar();
            Log.e("Luggage.FULL.JsApiGetSystemInfoLU", "getIntersectStatusBarHeight with component(%s %s), use windowStatusBar[%s]", c2.getAppId(), c2.getClass().getName(), statusBar);
            if (statusBar != null) {
                i2 = statusBar.height;
            } else {
                i2 = 0;
            }
        }
        a2.put("statusBarHeight", Integer.valueOf(g.zB(i2)));
        a2.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, LocaleUtil.getCurrentLanguage(c2.getContext()));
        a2.put("version", ChannelUtil.formatVersion(null, BuildInfo.CLIENT_VERSION_INT));
        if (!(c2.getRuntime() == null || c2.getRuntime().OT() == null)) {
            a2.put("benchmarkLevel", Integer.valueOf(((AppBrandSysConfigLU) c2.getRuntime().OT()).cyZ));
        }
        int[] iArr = new int[2];
        if (!(c2 instanceof d) || (m = ai.m(c2)) == null) {
            i3 = 0;
        } else {
            m.getLocationOnScreen(iArr);
            i3 = iArr[1];
        }
        Log.v("Luggage.WXA.UIUtil", "getScreenTop: [%d]", Integer.valueOf(i3));
        a2.put("screenTop", Integer.valueOf(g.zB(i3)));
        int i7 = c2.getContext().getResources().getConfiguration().orientation;
        if (2 == i7) {
            a2.put("deviceOrientation", "landscape");
        } else if (1 == i7) {
            a2.put("deviceOrientation", "portrait");
        }
        b bVar = (b) c2.M(b.class);
        a2.put("fontSizeSetting", Integer.valueOf(Math.round((bVar == null ? 1.0f : bVar.bIO()) * 16.0f)));
        Map<? extends String, ? extends Object> hashMap = new HashMap<>();
        Context context = c2.getContext();
        if (context != null) {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager != null) {
                hashMap.put("wifiEnabled", Boolean.valueOf(wifiManager.isWifiEnabled()));
            } else {
                hashMap.put("wifiEnabled", Boolean.FALSE);
            }
            hashMap.put("notificationAuthorized", Boolean.valueOf(v.P(context).areNotificationsEnabled()));
            LocationManager locationManager = (LocationManager) context.getSystemService(FirebaseAnalytics.b.LOCATION);
            if (locationManager != null) {
                hashMap.put("locationEnabled", Boolean.valueOf(locationManager.isProviderEnabled("gps")));
            } else {
                hashMap.put("locationEnabled", Boolean.FALSE);
            }
            try {
                hashMap.put("locationAuthorized", Boolean.valueOf(i.n(context, "android.permission.ACCESS_FINE_LOCATION")));
                hashMap.put("cameraAuthorized", Boolean.valueOf(i.n(context, "android.permission.CAMERA")));
                hashMap.put("microphoneAuthorized", Boolean.valueOf(i.n(context, "android.permission.RECORD_AUDIO")));
            } catch (Exception e2) {
                Log.e("Luggage.FULL.JsApiGetSystemInfoLU", "check permissions exception", e2);
                hashMap.put("locationAuthorized", Boolean.FALSE);
                hashMap.put("cameraAuthorized", Boolean.FALSE);
                hashMap.put("microphoneAuthorized", Boolean.FALSE);
            }
        } else {
            hashMap.put("wifiEnabled", Boolean.FALSE);
            hashMap.put("notificationAuthorized", Boolean.FALSE);
            hashMap.put("locationEnabled", Boolean.FALSE);
            hashMap.put("locationAuthorized", Boolean.FALSE);
            hashMap.put("cameraAuthorized", Boolean.FALSE);
            hashMap.put("microphoneAuthorized", Boolean.FALSE);
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            hashMap.put("bluetoothEnabled", Boolean.valueOf(defaultAdapter.isEnabled()));
        } else {
            hashMap.put("bluetoothEnabled", Boolean.FALSE);
        }
        Log.i("Luggage.FULL.JsApiGetSystemInfoLU", "check permissions:%s", hashMap);
        a2.putAll(hashMap);
        HashMap hashMap2 = new HashMap(6);
        Rect safeAreaInsets = c2.getWindowAndroid().getSafeAreaInsets();
        if (safeAreaInsets != null) {
            int zB = g.zB(safeAreaInsets.left);
            int zB2 = g.zB(safeAreaInsets.top);
            int zB3 = g.zB(Math.min(safeAreaInsets.right, i4));
            int zB4 = g.zB(Math.min(safeAreaInsets.bottom, i5));
            hashMap2.put("left", Integer.valueOf(zB));
            hashMap2.put("top", Integer.valueOf(zB2));
            hashMap2.put("right", Integer.valueOf(zB3));
            hashMap2.put("bottom", Integer.valueOf(zB4));
            hashMap2.put("width", Integer.valueOf(zB3 - zB));
            hashMap2.put("height", Integer.valueOf(zB4 - zB2));
            a2.put("safeArea", hashMap2);
        }
        a(c2, a2);
        AppMethodBeat.o(147302);
        return a2;
    }

    /* access modifiers changed from: protected */
    public void a(C c2, Map<String, Object> map) {
    }
}
