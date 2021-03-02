package com.tencent.mm.plugin.exdevice.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ej;
import com.tencent.mm.g.a.ek;
import com.tencent.mm.g.a.em;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import java.util.HashMap;
import org.json.JSONObject;

public final class ExdeviceWCLanSDKUtil {
    Context mContext;
    BroadcastReceiver mReceiver;
    j.a rAa;
    j.a rAb;
    HashMap<String, String> rAc;
    boolean rAd;
    boolean rAe;
    boolean rAf;
    int rAg;
    HashMap<String, byte[]> rzF;
    HashMap<String, Boolean> rzH;
    j.a rzI;
    j.a rzK;
    private int rzY;
    private int rzZ;

    public ExdeviceWCLanSDKUtil() {
        AppMethodBeat.i(23359);
        this.rzY = 0;
        this.rzZ = 0;
        this.rzF = new HashMap<>();
        this.rzH = new HashMap<>();
        this.rAc = new HashMap<>();
        this.mContext = null;
        this.rAd = false;
        this.rAe = false;
        this.rAf = false;
        this.rAd = true;
        this.rAe = true;
        this.rzF.clear();
        this.rzH.clear();
        this.rAc.clear();
        this.mContext = MMApplicationContext.getContext();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        if (this.mReceiver == null) {
            this.mReceiver = new LanStateChangeReceiver();
        }
        this.mContext.registerReceiver(this.mReceiver, intentFilter);
        this.rAa = new j.a() {
            /* class com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil.AnonymousClass1 */

            /* JADX WARNING: Removed duplicated region for block: B:23:0x008b A[ADDED_TO_REGION] */
            @Override // com.tencent.mm.plugin.exdevice.model.j.a
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void h(int r8, java.lang.Object... r9) {
                /*
                // Method dump skipped, instructions count: 189
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil.AnonymousClass1.h(int, java.lang.Object[]):void");
            }
        };
        this.rzI = new j.a() {
            /* class com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil.AnonymousClass2 */

            /* JADX WARNING: Removed duplicated region for block: B:18:0x0042 A[ADDED_TO_REGION] */
            @Override // com.tencent.mm.plugin.exdevice.model.j.a
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void h(int r11, java.lang.Object... r12) {
                /*
                // Method dump skipped, instructions count: 245
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil.AnonymousClass2.h(int, java.lang.Object[]):void");
            }
        };
        this.rzK = new j.a() {
            /* class com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil.AnonymousClass3 */

            /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x0065  */
            /* JADX WARNING: Removed duplicated region for block: B:28:0x00a5  */
            @Override // com.tencent.mm.plugin.exdevice.model.j.a
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void h(int r12, java.lang.Object... r13) {
                /*
                // Method dump skipped, instructions count: 196
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil.AnonymousClass3.h(int, java.lang.Object[]):void");
            }
        };
        this.rAb = new j.a() {
            /* class com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.exdevice.model.j.a
            public final void h(int i2, Object... objArr) {
                String str;
                Exception e2;
                String str2;
                AppMethodBeat.i(23356);
                if (i2 != 16 || objArr == null || objArr.length < 2 || !(objArr[0] instanceof String) || !(objArr[1] instanceof byte[])) {
                    AppMethodBeat.o(23356);
                    return;
                }
                String str3 = (String) objArr[0];
                byte[] bArr = (byte[]) objArr[1];
                try {
                    JSONObject jSONObject = new JSONObject(new String(str3));
                    str = jSONObject.getString("deviceType");
                    try {
                        str2 = jSONObject.getString("deviceId");
                    } catch (Exception e3) {
                        e2 = e3;
                        Log.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e2, "", new Object[0]);
                        Log.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in receive notify callback");
                        str2 = null;
                        Log.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "receive data = ".concat(String.valueOf(new String(bArr))));
                        ek ekVar = new ek();
                        ekVar.dHP.dGL = str2;
                        ekVar.dHP.data = bArr;
                        ekVar.dHP.brandName = str;
                        EventCenter.instance.publish(ekVar);
                        AppMethodBeat.o(23356);
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    str = null;
                    Log.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e2, "", new Object[0]);
                    Log.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in receive notify callback");
                    str2 = null;
                    Log.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "receive data = ".concat(String.valueOf(new String(bArr))));
                    ek ekVar2 = new ek();
                    ekVar2.dHP.dGL = str2;
                    ekVar2.dHP.data = bArr;
                    ekVar2.dHP.brandName = str;
                    EventCenter.instance.publish(ekVar2);
                    AppMethodBeat.o(23356);
                }
                Log.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "receive data = ".concat(String.valueOf(new String(bArr))));
                ek ekVar22 = new ek();
                ekVar22.dHP.dGL = str2;
                ekVar22.dHP.data = bArr;
                ekVar22.dHP.brandName = str;
                EventCenter.instance.publish(ekVar22);
                AppMethodBeat.o(23356);
            }
        };
        AppMethodBeat.o(23359);
    }

    public final boolean t(boolean z, String str) {
        AppMethodBeat.i(23360);
        if (str == null || !this.rzF.containsKey(str)) {
            Log.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in openOrCloseDevice");
            AppMethodBeat.o(23360);
            return false;
        }
        byte[] bArr = this.rzF.get(str);
        try {
            JSONObject jSONObject = new JSONObject();
            if (z) {
                Log.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "open device!");
                jSONObject.put("cmd", WeChatBrands.Business.GROUP_OPEN);
            } else {
                Log.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "close device!");
                jSONObject.put("cmd", "close");
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("wxmsg_jsapi", jSONObject);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("services", jSONObject2);
            this.rzZ = Java2CExDevice.useWCLanDeviceService(bArr, jSONObject3.toString().getBytes());
            if (this.rzZ != 0) {
                Log.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "get openOrCloseDevice mCallBackCmdId =" + this.rzZ);
            } else {
                Log.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "openOrCloseDevice error!");
            }
            AppMethodBeat.o(23360);
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e2, "", new Object[0]);
            Log.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON encode failed in openOrCloseDevice");
            AppMethodBeat.o(23360);
            return false;
        }
    }

    public final boolean aR(String str, boolean z) {
        AppMethodBeat.i(23361);
        if (str == null || !this.rzF.containsKey(str)) {
            Log.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in connectWCLanDevice");
            AppMethodBeat.o(23361);
            return false;
        }
        byte[] bArr = this.rzF.get(str);
        this.rAf = true;
        if (z) {
            try {
                String string = new JSONObject(new String(bArr)).getString("deviceType");
                Log.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "connectWCLanDevice deviceId: ".concat(String.valueOf(str)));
                if (Java2CExDevice.connectWCLanDevice(bArr, false) != 0) {
                    Log.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "connectWCLanDevice error!");
                    AppMethodBeat.o(23361);
                    return false;
                }
                ej ejVar = new ej();
                ejVar.dHN.dGL = str;
                ejVar.dHN.dHO = 1;
                ejVar.dHN.brandName = string;
                EventCenter.instance.publish(ejVar);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e2, "", new Object[0]);
                Log.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in connectWCLanDevice!");
                AppMethodBeat.o(23361);
                return false;
            }
        } else {
            t(false, str);
            Log.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "disconnectWCLanDevice...");
            Java2CExDevice.disconnectWCLanDevice(bArr);
        }
        AppMethodBeat.o(23361);
        return true;
    }

    public final boolean ga(String str, String str2) {
        boolean z;
        AppMethodBeat.i(23362);
        if (!anw(str)) {
            Log.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceId " + str + " not connected!");
            AppMethodBeat.o(23362);
            return false;
        } else if (str == null || !this.rzF.containsKey(str)) {
            Log.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in useWCLanDeviceService");
            AppMethodBeat.o(23362);
            return false;
        } else {
            byte[] bArr = this.rzF.get(str);
            this.rzY = 0;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("data", str2);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("wxmsg_jsapi", jSONObject);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("services", jSONObject2);
                this.rzY = Java2CExDevice.useWCLanDeviceService(bArr, jSONObject3.toString().getBytes());
                if (this.rzY != 0) {
                    z = true;
                    Log.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "get useWCLanDeviceService mCallBackCmdId =" + this.rzY);
                } else {
                    Log.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "useWCLanDeviceService error!");
                    z = false;
                }
                AppMethodBeat.o(23362);
                return z;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e2, "", new Object[0]);
                Log.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON encode failed in useWCLanDeviceService");
                AppMethodBeat.o(23362);
                return false;
            }
        }
    }

    public final boolean anw(String str) {
        AppMethodBeat.i(23363);
        if (str == null || !this.rzH.containsKey(str)) {
            AppMethodBeat.o(23363);
            return false;
        }
        boolean booleanValue = this.rzH.get(str).booleanValue();
        AppMethodBeat.o(23363);
        return booleanValue;
    }

    public class LanStateChangeReceiver extends BroadcastReceiver {
        public LanStateChangeReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            Parcelable parcelableExtra;
            AppMethodBeat.i(23358);
            if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction()) && (parcelableExtra = intent.getParcelableExtra("networkInfo")) != null) {
                boolean z = ((NetworkInfo) parcelableExtra).getState() == NetworkInfo.State.CONNECTED;
                Log.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "isConnected =".concat(String.valueOf(z)));
                if (ExdeviceWCLanSDKUtil.this.rAe || ExdeviceWCLanSDKUtil.this.rAd != z) {
                    em emVar = new em();
                    emVar.dHS.dHT = z;
                    EventCenter.instance.publish(emVar);
                    ExdeviceWCLanSDKUtil.this.rAe = false;
                    ExdeviceWCLanSDKUtil.this.rAd = z;
                }
            }
            AppMethodBeat.o(23358);
        }
    }
}
