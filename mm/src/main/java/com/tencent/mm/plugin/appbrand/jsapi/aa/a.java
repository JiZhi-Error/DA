package com.tencent.mm.plugin.appbrand.jsapi.aa;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.huawei.a.a.a.a;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.HashMap;
import org.json.JSONObject;

public abstract class a extends d<k> {
    /* access modifiers changed from: protected */
    public abstract void a(k kVar, int i2, com.huawei.a.a.a.a aVar, JSONObject jSONObject);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(k kVar, JSONObject jSONObject, int i2) {
        boolean z;
        k kVar2 = kVar;
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(kVar2.getRuntime().mContext);
        if (castActivityOrNull == null) {
            kVar2.i(i2, h("fail:internal error invalid android context", null));
            Log.e("MicroMsg.AppBrandTrafficCardBaseJsApi", "mmActivity is null, invoke fail! with appId[%s] callbackId[%d]", kVar2.getAppId(), Integer.valueOf(i2));
            return;
        }
        String optString = jSONObject.optString("deviceType");
        JSONObject optJSONObject = jSONObject.optJSONObject("deviceData");
        if (TextUtils.isEmpty(optString)) {
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(b.muo.errorCode));
            kVar2.i(i2, n("fail:" + b.muo.errorMsg, hashMap));
            Log.e("MicroMsg.AppBrandTrafficCardBaseJsApi", "deviceType is null, invoke fail: [%s] ! with appId[%s] callbackId[%d]", b.muo.errorMsg, kVar2.getAppId(), Integer.valueOf(i2));
            return;
        }
        String str = Build.BRAND;
        if (!Util.isNullOrNil(optString) && !Util.isNullOrNil(str)) {
            String lowerCase = str.toLowerCase();
            char c2 = 65535;
            switch (optString.hashCode()) {
                case 2141820391:
                    if (optString.equals("HUAWEI")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    if (lowerCase.contains("huawei") || lowerCase.contains("honor")) {
                        z = true;
                        break;
                    }
                default:
                    Log.e("MicroMsg.AppBrandTrafficCardBaseJsApi", "device type not valid with deviceType[%s] device brand[%s]", optString, lowerCase);
                    z = false;
                    break;
            }
        } else {
            z = false;
        }
        if (!z) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", Integer.valueOf(b.muo.errorCode));
            kVar2.i(i2, n("fail:" + b.muo.errorMsg, hashMap2));
            Log.e("MicroMsg.AppBrandTrafficCardBaseJsApi", "deviceType is invalid, invoke fail: [%s] ! with appId[%s] callbackId[%d]", b.muo.errorMsg, kVar2.getAppId(), Integer.valueOf(i2));
        } else if (!a(castActivityOrNull, kVar2, i2, optString, optJSONObject)) {
            kVar2.i(i2, h("fail:null system service", null));
            Log.e("MicroMsg.AppBrandTrafficCardBaseJsApi", "null system service, invoke fail! with deviceType[%s] appId[%s] callbackId[%d]", optString, kVar2.getAppId(), Integer.valueOf(i2));
        }
    }

    private boolean a(Context context, k kVar, int i2, String str, JSONObject jSONObject) {
        boolean z;
        if (context == null || str == null) {
            return false;
        }
        ServiceConnectionC0597a aVar = new ServiceConnectionC0597a(context, kVar, i2, str, jSONObject);
        Intent intent = null;
        char c2 = 65535;
        switch (str.hashCode()) {
            case 2141820391:
                if (str.equals("HUAWEI")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                intent = new Intent("com.huawei.nfc.action.TRANSIT_OPEN_SERVICE");
                intent.setPackage("com.huawei.wallet");
                break;
        }
        if (intent == null) {
            return false;
        }
        try {
            z = context.bindService(intent, aVar, 1);
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrandTrafficCardBaseJsApi", "bind remote service exception [%s]", e2.getMessage());
            z = false;
        }
        return z;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.aa.a$a  reason: collision with other inner class name */
    public class ServiceConnectionC0597a implements ServiceConnection {
        private int csv;
        private Context mContext;
        private String mDeviceType;
        private k mui;
        private JSONObject muj;

        public ServiceConnectionC0597a(Context context, k kVar, int i2, String str, JSONObject jSONObject) {
            this.mContext = context;
            this.mui = kVar;
            this.csv = i2;
            this.mDeviceType = str;
            this.muj = jSONObject;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.i(226993);
            String str = this.mDeviceType;
            char c2 = 65535;
            switch (str.hashCode()) {
                case 2141820391:
                    if (str.equals("HUAWEI")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    final com.huawei.a.a.a.a h2 = a.AbstractBinderC0122a.h(iBinder);
                    h.RTc.aX(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.aa.a.ServiceConnectionC0597a.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(226992);
                            a.this.a(ServiceConnectionC0597a.this.mui, ServiceConnectionC0597a.this.csv, h2, ServiceConnectionC0597a.this.muj);
                            ServiceConnectionC0597a.this.mContext.unbindService(ServiceConnectionC0597a.this);
                            AppMethodBeat.o(226992);
                        }
                    });
                    break;
            }
            AppMethodBeat.o(226993);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }
}
