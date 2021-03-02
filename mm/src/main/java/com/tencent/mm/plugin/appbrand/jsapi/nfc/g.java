package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.HCEService;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g extends JsApiAppBrandNFCBase {
    public static final int CTRL_INDEX = 352;
    public static final String NAME = "startHCE";
    ResultReceiver MU;
    private JSONObject csi;
    private int csv = -1;
    boolean isFinished = false;
    f kSY = null;
    Activity mContext = null;
    final Object mLock = new Object();
    long mStartTime = -1;
    Timer mTimer;
    private Class<?> mhd = null;
    Application.ActivityLifecycleCallbacks mhe = null;
    private int mhf;
    private ResultReceiver mhg = new JsApiNFCStartHCE$6(this, MMHandler.createFreeHandler(Looper.getMainLooper()));

    public g(Class<?> cls) {
        AppMethodBeat.i(136114);
        this.mhd = cls;
        AppMethodBeat.o(136114);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(136115);
        Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo appbrand start HCE, data: %s", jSONObject.toString());
        this.kSY = fVar;
        this.csv = i2;
        this.csi = jSONObject;
        synchronized (this.mLock) {
            try {
                this.isFinished = false;
            } catch (Throwable th) {
                AppMethodBeat.o(136115);
                throw th;
            }
        }
        if (this.mhd == null) {
            ZA(h("fail: HostApduService is nil", null));
            AppMethodBeat.o(136115);
            return;
        }
        this.mhf = this.csi.optInt("time_limit", 1500);
        a(new JsApiAppBrandNFCBase.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.nfc.g.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase.a
            public final void A(int i2, String str) {
                AppMethodBeat.i(136107);
                HashMap hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(i2));
                if (i2 == 0) {
                    g gVar = g.this;
                    if (!(gVar.kSY.getContext() instanceof Activity)) {
                        gVar.ZA(gVar.h("fail: unknown error", null));
                        AppMethodBeat.o(136107);
                        return;
                    }
                    gVar.mContext = (Activity) gVar.kSY.getContext();
                    gVar.mhe = new Application.ActivityLifecycleCallbacks() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.nfc.g.AnonymousClass2 */
                        private boolean isPaused = false;

                        public final void onActivityCreated(Activity activity, Bundle bundle) {
                        }

                        public final void onActivityStarted(Activity activity) {
                        }

                        public final void onActivityResumed(Activity activity) {
                            AppMethodBeat.i(136108);
                            Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onActivityResumed");
                            if (this.isPaused) {
                                Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo onActivityResumed isPaused and do checLogic");
                                this.isPaused = false;
                                a.mht.bHM();
                            }
                            AppMethodBeat.o(136108);
                        }

                        public final void onActivityPaused(Activity activity) {
                            AppMethodBeat.i(136109);
                            Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onActivityPaused");
                            a.mht.dismissDialog();
                            this.isPaused = true;
                            AppMethodBeat.o(136109);
                        }

                        public final void onActivityStopped(Activity activity) {
                        }

                        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                        }

                        public final void onActivityDestroyed(Activity activity) {
                        }
                    };
                    gVar.mContext.getApplication().registerActivityLifecycleCallbacks(gVar.mhe);
                    gVar.MU = new JsApiNFCStartHCE$3(gVar, MMHandler.createFreeHandler(Looper.getMainLooper()));
                    a.mht.a(gVar.mContext, gVar.MU);
                    a.mht.resetStatus();
                    a.mht.b(new ComponentName(gVar.mContext, HCEService.class.getCanonicalName()));
                    a.mht.bHM();
                    AppMethodBeat.o(136107);
                    return;
                }
                c.R(g.this.kSY.getAppId(), i2, -1);
                g.this.ZA(g.this.n("fail: ".concat(String.valueOf(str)), hashMap));
                AppMethodBeat.o(136107);
            }
        });
        AppMethodBeat.o(136115);
    }

    /* access modifiers changed from: package-private */
    public final void ZA(String str) {
        AppMethodBeat.i(136116);
        Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE callback result: %s", str);
        if (this.kSY != null) {
            this.kSY.i(this.csv, str);
        }
        if (!(this.mContext == null || this.mhe == null)) {
            Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE callback unregister lifecycle callback");
            this.mContext.getApplication().unregisterActivityLifecycleCallbacks(this.mhe);
        }
        AppMethodBeat.o(136116);
    }

    /* access modifiers changed from: package-private */
    public final void onSuccess() {
        AppMethodBeat.i(136117);
        HashMap hashMap = new HashMap();
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = this.csi.getJSONArray("aid_list");
            int length = jSONArray.length();
            Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo mData: %s, aidList: %s, length: %d", this.csi.toString(), jSONArray.toString(), Integer.valueOf(length));
            for (int i2 = 0; i2 < length; i2++) {
                arrayList.add(jSONArray.get(i2).toString());
            }
            h.a(this.kSY.getAppId(), new h.c() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.nfc.g.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.appbrand.h.c
                public final void onDestroy() {
                    AppMethodBeat.i(136111);
                    Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo AppBrandLifeCycle onDestroy");
                    HCEEventLogic.hI(true);
                    AppMethodBeat.o(136111);
                }
            });
            Intent intent = new Intent(this.mContext, this.mhd);
            intent.putExtra("HCE_Result_Receiver", this.mhg);
            intent.putExtra("key_appid", this.kSY.getAppId());
            intent.putExtra("key_time_limit", this.mhf);
            intent.putStringArrayListExtra("key_aid_list", arrayList);
            HCEEventLogic.hI(false);
            this.mContext.startService(intent);
            this.mStartTime = System.currentTimeMillis();
            AnonymousClass4 r0 = new TimerTask() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.nfc.g.AnonymousClass4 */

                public final void run() {
                    boolean z;
                    AppMethodBeat.i(136112);
                    g gVar = g.this;
                    synchronized (gVar.mLock) {
                        try {
                            z = gVar.isFinished;
                            if (!z) {
                                gVar.isFinished = true;
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.o(136112);
                            throw th;
                        }
                    }
                    if (z) {
                        Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has finished, return");
                        AppMethodBeat.o(136112);
                    } else if (HCEEventLogic.bHI()) {
                        Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has stop, return");
                        AppMethodBeat.o(136112);
                    } else {
                        Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo start HCEService overtime, expect time limit: %d seconds", 10);
                        HCEEventLogic.hI(true);
                        if (gVar.kSY != null) {
                            c.R(gVar.kSY.getAppId(), 13007, -2);
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("errCode", 13007);
                        gVar.ZA(gVar.n("fail: start HCEService failed", hashMap));
                        AppMethodBeat.o(136112);
                    }
                }
            };
            this.mTimer = new Timer();
            this.mTimer.schedule(r0, 10000);
            AppMethodBeat.o(136117);
        } catch (Exception e2) {
            hashMap.put("errCode", 13003);
            ZA(n("fail: aid_list invalid", hashMap));
            c.R(this.kSY.getAppId(), 13003, -1);
            AppMethodBeat.o(136117);
        }
    }
}
