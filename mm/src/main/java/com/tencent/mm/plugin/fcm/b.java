package com.tencent.mm.plugin.fcm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.firebase.a;
import com.google.firebase.iid.FirebaseInstanceId;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public class b implements i {
    @SuppressLint({"StaticFieldLeak"})
    private static b tnB;
    private static volatile boolean tnC = false;
    private final Context context;
    private int tnD;

    public static b cXf() {
        AppMethodBeat.i(127566);
        if (tnB != null) {
            b bVar = tnB;
            AppMethodBeat.o(127566);
            return bVar;
        }
        synchronized (b.class) {
            try {
                if (tnB != null) {
                    return tnB;
                }
                Context context2 = MMApplicationContext.getContext();
                if (context2 == null) {
                    Log.e("MicroMsg.FCM.FcmRegister", "FCM appcontext null");
                    AppMethodBeat.o(127566);
                    return null;
                }
                b bVar2 = new b(context2);
                tnB = bVar2;
                AppMethodBeat.o(127566);
                return bVar2;
            } finally {
                AppMethodBeat.o(127566);
            }
        }
    }

    private b(Context context2) {
        this.context = context2;
    }

    /* access modifiers changed from: package-private */
    public final boolean cXg() {
        AppMethodBeat.i(192523);
        if (!tnC) {
            synchronized (this) {
                try {
                    if (!tnC) {
                        try {
                            a.al(this.context);
                            com.google.firebase.messaging.a.yz().bLY.yl();
                            tnC = true;
                        } catch (Throwable th) {
                            Log.printErrStackTrace("MicroMsg.FCM.FcmRegister", th, "init fcm sdk fail", new Object[0]);
                            AppMethodBeat.o(192523);
                            return false;
                        }
                    }
                } finally {
                    AppMethodBeat.o(192523);
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean cXh() {
        AppMethodBeat.i(127568);
        try {
            if (Build.VERSION.SDK_INT < 14) {
                Log.w("MicroMsg.FCM.FcmRegister", "device not support FCM reason = version < 14");
                AppMethodBeat.o(127568);
                return false;
            }
            int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.context);
            if (isGooglePlayServicesAvailable != 0) {
                Log.w("MicroMsg.FCM.FcmRegister", "device not support FCM reason = ".concat(String.valueOf(isGooglePlayServicesAvailable)));
                AppMethodBeat.o(127568);
                return false;
            }
            AppMethodBeat.o(127568);
            return true;
        } catch (Throwable th) {
            Log.e("MicroMsg.FCM.FcmRegister", th.toString());
            AppMethodBeat.o(127568);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void cXi() {
        AppMethodBeat.i(127569);
        e.INSTANCE.idkeyStat(901, 18, 1, false);
        String str = null;
        if (cXg()) {
            str = FirebaseInstanceId.yc().getToken();
        }
        if (Util.isNullOrNil(str)) {
            e.INSTANCE.idkeyStat(901, 19, 1, false);
            Log.w("MicroMsg.FCM.FcmRegister", "unreg fail, token is null");
            AppMethodBeat.o(127569);
            return;
        }
        mL(false);
        d dVar = new d(str);
        g.aAi();
        g.aAg().hqi.a(dVar.getType(), this);
        g.aAi();
        g.aAg().hqi.a(dVar, 0);
        e.INSTANCE.idkeyStat(901, 21, 1, false);
        AppMethodBeat.o(127569);
    }

    public final void asA(String str) {
        AppMethodBeat.i(127570);
        Log.i("MicroMsg.FCM.FcmRegister", "register token to svr: %s", str);
        e.INSTANCE.idkeyStat(901, 11, 1, false);
        if (Util.isNullOrNil(str)) {
            e.INSTANCE.idkeyStat(901, 13, 1, false);
            Log.e("MicroMsg.FCM.FcmRegister", "token is null, fail reg");
            AppMethodBeat.o(127570);
        } else if (this.tnD == com.tencent.mm.kernel.a.azs()) {
            e.INSTANCE.idkeyStat(901, 12, 1, false);
            Log.w("MicroMsg.FCM.FcmRegister", "have registered yet.");
            AppMethodBeat.o(127570);
        } else {
            c cVar = new c(str);
            g.aAi();
            g.aAg().hqi.a(cVar.getType(), this);
            g.aAi();
            g.aAg().hqi.a(cVar, 0);
            e.INSTANCE.idkeyStat(901, 14, 1, false);
            AppMethodBeat.o(127570);
        }
    }

    public final boolean cXj() {
        AppMethodBeat.i(127571);
        boolean z = cXk().getBoolean("isRegToSvr", false);
        AppMethodBeat.o(127571);
        return z;
    }

    private void mL(boolean z) {
        AppMethodBeat.i(127572);
        SharedPreferences cXk = cXk();
        Log.i("MicroMsg.FCM.FcmRegister", "Saving regSvrResult: ".concat(String.valueOf(z)));
        SharedPreferences.Editor edit = cXk.edit();
        edit.putBoolean("isRegToSvr", z);
        edit.commit();
        if (z) {
            this.tnD = com.tencent.mm.kernel.a.azs();
            AppMethodBeat.o(127572);
            return;
        }
        this.tnD = 0;
        AppMethodBeat.o(127572);
    }

    private SharedPreferences cXk() {
        AppMethodBeat.i(127573);
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(b.class.getSimpleName(), 0);
        AppMethodBeat.o(127573);
        return sharedPreferences;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z = false;
        AppMethodBeat.i(127574);
        if (qVar == null) {
            AppMethodBeat.o(127574);
        } else if (qVar instanceof c) {
            g.aAi();
            g.aAg().hqi.a(((c) qVar).getType(), this);
            if (i2 == 0 && i3 == 0) {
                Log.i("MicroMsg.FCM.FcmRegister", "NetSceneFcmReg success.");
                e.INSTANCE.idkeyStat(901, 16, 1, false);
                z = true;
            } else {
                Log.i("MicroMsg.FCM.FcmRegister", "NetSceneFcmReg faild.");
                e.INSTANCE.idkeyStat(901, 17, 1, false);
            }
            mL(z);
            AppMethodBeat.o(127574);
        } else {
            if (qVar instanceof d) {
                g.aAi();
                g.aAg().hqi.a(((d) qVar).getType(), this);
                if (i2 == 0 && i3 == 0) {
                    Log.i("MicroMsg.FCM.FcmRegister", "NetSceneFcmUnreg success.");
                    e.INSTANCE.idkeyStat(901, 23, 1, false);
                } else {
                    Log.e("MicroMsg.FCM.FcmRegister", "NetSceneFcmUnreg faild.");
                    e.INSTANCE.idkeyStat(901, 24, 1, false);
                }
                mL(false);
            }
            AppMethodBeat.o(127574);
        }
    }
}
