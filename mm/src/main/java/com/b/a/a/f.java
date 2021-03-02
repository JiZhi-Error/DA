package com.b.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.util.Base64;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {
    private final WifiManager chC;
    private final LocationManager chD;
    final PackageManager chE;
    String chF;
    String chG;
    String chH;
    private int chI = 0;
    private int chJ = 0;
    int chK = 0;
    int chL = 0;
    int chM = 0;
    int chN = 0;
    String imei;
    final Context mContext;
    PackageInfo mPackageInfo;
    final SensorManager mSensorManager;
    private String source = "203";
    private String version = "2.0.1";
    String versionName;

    public f(Context context) {
        AppMethodBeat.i(87881);
        this.mContext = context;
        this.chC = (WifiManager) this.mContext.getSystemService("wifi");
        this.chD = (LocationManager) this.mContext.getSystemService(FirebaseAnalytics.b.LOCATION);
        this.mSensorManager = (SensorManager) this.mContext.getSystemService("sensor");
        this.chE = this.mContext.getPackageManager();
        this.mPackageInfo = new PackageInfo();
        try {
            this.mPackageInfo = this.chE.getPackageInfo(this.mContext.getPackageName(), 0);
            AppMethodBeat.o(87881);
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(87881);
        }
    }

    public final String L(byte[] bArr) {
        int i2;
        boolean z;
        int i3 = 1;
        AppMethodBeat.i(87882);
        HashMap hashMap = new HashMap();
        hashMap.put("version", this.version);
        hashMap.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, cA(this.versionName));
        if (this.chF != null) {
            hashMap.put("app_label", cA(Base64.encodeToString(this.chF.getBytes(), 0)));
        } else {
            hashMap.put("app_label", "");
        }
        if (Ja()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        this.chJ = i2;
        if (this.chC == null || !this.chC.isWifiEnabled()) {
            z = false;
        } else {
            z = true;
        }
        if (!z && !Jb()) {
            i3 = 0;
        }
        this.chI = i3;
        hashMap.put("chips", Integer.toBinaryString(this.chN | 0 | (this.chM << 1) | (this.chL << 2) | (this.chK << 3) | (this.chJ << 4) | (this.chI << 5)));
        hashMap.put("source", this.source);
        hashMap.put(SearchIntents.EXTRA_QUERY, new String(bArr));
        try {
            JSONObject jSONObject = new JSONObject(hashMap);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("model", cA(Base64.encodeToString(this.chG.getBytes(), 0)));
            hashMap2.put("version", cA(this.chH));
            hashMap2.put("imei", cA(this.imei));
            String jSONObject2 = jSONObject.put("attribute", new JSONObject(hashMap2)).toString();
            AppMethodBeat.o(87882);
            return jSONObject2;
        } catch (JSONException e2) {
            AppMethodBeat.o(87882);
            return null;
        }
    }

    private static String cA(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    private boolean Ja() {
        AppMethodBeat.i(87883);
        boolean z = false;
        try {
            z = this.chD.isProviderEnabled("gps");
        } catch (Exception e2) {
        }
        AppMethodBeat.o(87883);
        return z;
    }

    @SuppressLint({"NewApi"})
    private boolean Jb() {
        AppMethodBeat.i(87884);
        boolean z = false;
        if (this.chC != null && !(z = this.chC.isWifiEnabled())) {
            try {
                if (Build.VERSION.SDK_INT >= 18) {
                    z = this.chC.isScanAlwaysAvailable();
                }
            } catch (Error | Exception e2) {
            }
        }
        AppMethodBeat.o(87884);
        return z;
    }
}
