package com.tencent.kinda.framework.app;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.BioType;
import com.tencent.kinda.gen.KFingerprintService;
import com.tencent.kinda.gen.VoidBinaryI32Callback;
import com.tencent.kinda.gen.VoidBoolCallback;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.kinda.gen.VoidStringCallback;
import com.tencent.kinda.gen.VoidStringStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jd;
import com.tencent.mm.g.a.li;
import com.tencent.mm.g.a.rm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.a.c;
import com.tencent.mm.plugin.fingerprint.b.a.d;
import com.tencent.mm.plugin.fingerprint.b.a.e;
import com.tencent.mm.plugin.fingerprint.b.a.f;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.hn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class KindaFingerprintImpl implements KFingerprintService {
    String TAG = "KindaFingerprintImpl";
    private IListener<li> activetyListener = new IListener<li>() {
        /* class com.tencent.kinda.framework.app.KindaFingerprintImpl.AnonymousClass1 */

        {
            AppMethodBeat.i(160755);
            this.__eventId = li.class.getName().hashCode();
            AppMethodBeat.o(160755);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public /* bridge */ /* synthetic */ boolean callback(li liVar) {
            AppMethodBeat.i(18427);
            boolean callback = callback(liVar);
            AppMethodBeat.o(18427);
            return callback;
        }

        public boolean callback(li liVar) {
            AppMethodBeat.i(18426);
            if (!(liVar == null || KindaFingerprintImpl.this.changePwdCallback == null)) {
                KindaFingerprintImpl.this.changePwdCallback.call(false);
            }
            AppMethodBeat.o(18426);
            return false;
        }
    };
    private VoidBoolCallback changePwdCallback;
    int identify_num = 0;
    a mgr = ((a) g.af(a.class));
    private Dialog tipDialog = null;

    public KindaFingerprintImpl() {
        AppMethodBeat.i(18436);
        AppMethodBeat.o(18436);
    }

    @Override // com.tencent.kinda.gen.KFingerprintService
    public BioType supportBioType() {
        AppMethodBeat.i(18437);
        if (this.mgr != null && this.mgr.dJT() && !this.mgr.dJP() && this.mgr.dJO()) {
            BioType bioType = BioType.FINGERPRINT;
            AppMethodBeat.o(18437);
            return bioType;
        } else if (this.mgr == null || !this.mgr.dKb() || this.mgr.dJQ() || !this.mgr.dJR()) {
            BioType bioType2 = BioType.NONE;
            AppMethodBeat.o(18437);
            return bioType2;
        } else {
            BioType bioType3 = BioType.FACEID;
            AppMethodBeat.o(18437);
            return bioType3;
        }
    }

    @Override // com.tencent.kinda.gen.KFingerprintService
    public void authenticateImpl(String str, String str2, final VoidBinaryI32Callback voidBinaryI32Callback, final VoidCallback voidCallback, final VoidBoolCallback voidBoolCallback, VoidStringCallback voidStringCallback) {
        AppMethodBeat.i(18438);
        if (KindaContext.get() == null) {
            AppMethodBeat.o(18438);
            return;
        }
        p.IML.wFE = str2;
        EventCenter.instance.publish(new rm());
        com.tencent.mm.plugin.soter.d.a.flK();
        Log.i(this.TAG, "req fingerprint auth 2");
        com.tencent.mm.plugin.soter.d.a.flK();
        h.INSTANCE.dN(1104, 38);
        f fVar = new f(str2);
        fVar.dDL = str;
        ((i) g.af(i.class)).a(MMApplicationContext.getContext(), fVar, new d() {
            /* class com.tencent.kinda.framework.app.KindaFingerprintImpl.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.fingerprint.b.a.d
            public void onSuccess(e eVar) {
                AppMethodBeat.i(18428);
                Log.i(KindaFingerprintImpl.this.TAG, "FingerPrint success!, encrypted_pay_info: %s, retry count: ", eVar.wFV.dNR, Integer.valueOf(eVar.retryCount));
                hn hnVar = new hn();
                hnVar.KLw = true;
                hnVar.dNR = eVar.wFV.dNR;
                hnVar.dNS = eVar.wFV.dNS;
                hnVar.Ijz = eVar.retryCount;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("json", eVar.wFV.wFF);
                    jSONObject.put("signature", eVar.wFV.wFG);
                    jSONObject.put("soter_type", t.fQI().fRq());
                    hnVar.KLx = jSONObject.toString();
                } catch (JSONException e2) {
                    Log.printErrStackTrace(KindaFingerprintImpl.this.TAG, e2, "json exception while construct json for soter_req. message: %s", e2.getMessage());
                }
                try {
                    voidBinaryI32Callback.call(hnVar.toByteArray(), eVar.wFV.dNP);
                } catch (IOException e3) {
                    Log.printErrStackTrace(KindaFingerprintImpl.this.TAG, e3, "FingerPrint exception: %s", e3.getMessage());
                }
                h.INSTANCE.dN(1104, 37);
                com.tencent.mm.plugin.soter.d.a.aau(0);
                AppMethodBeat.o(18428);
            }

            @Override // com.tencent.mm.plugin.fingerprint.b.a.d
            public void onFail(e eVar) {
                AppMethodBeat.i(18429);
                com.tencent.mm.plugin.soter.d.a.aau(2);
                c cVar = eVar.wFV;
                if (cVar.errCode == 2005 || cVar.errCode == 2007) {
                    h.INSTANCE.dN(1104, 36);
                }
                if (cVar.errCode == 10308 || cVar.errCode == 2 || cVar.errCode == 1001) {
                    Log.i(KindaFingerprintImpl.this.TAG, "hy: FingerPrintAuthEvent callback, auth | fail max | common err | pipeline exception, should change to pwd!");
                    voidBoolCallback.call(true);
                } else {
                    voidBoolCallback.call(false);
                }
                Log.i(KindaFingerprintImpl.this.TAG, "FingerPrint fail! retry count: " + eVar.retryCount);
                AppMethodBeat.o(18429);
            }

            @Override // com.tencent.mm.plugin.fingerprint.b.a.d
            public void onRetry(e eVar) {
                AppMethodBeat.i(18430);
                com.tencent.mm.plugin.soter.d.a.aau(1);
                voidCallback.call();
                Log.i(KindaFingerprintImpl.this.TAG, "FingerPrint retry! retry count: " + eVar.retryCount);
                AppMethodBeat.o(18430);
            }
        });
        this.changePwdCallback = voidBoolCallback;
        EventCenter.instance.add(this.activetyListener);
        AppMethodBeat.o(18438);
    }

    @Override // com.tencent.kinda.gen.KFingerprintService
    public void releaseService() {
        AppMethodBeat.i(18439);
        EventCenter.instance.publish(new rm());
        EventCenter.instance.removeListener(this.activetyListener);
        AppMethodBeat.o(18439);
    }

    @Override // com.tencent.kinda.gen.KFingerprintService
    public void reGenFpRsaKeyImpl(boolean z, int i2, String str, final VoidStringStringCallback voidStringStringCallback, final VoidCallback voidCallback) {
        AppMethodBeat.i(18440);
        final jd jdVar = new jd();
        jdVar.dNN = null;
        jdVar.dNM.dNO = z;
        if (z) {
            showProgress();
        }
        jdVar.dNM.dNP = i2;
        jdVar.dNM.dNQ = str;
        jdVar.callback = new Runnable() {
            /* class com.tencent.kinda.framework.app.KindaFingerprintImpl.AnonymousClass3 */

            public void run() {
                AppMethodBeat.i(18431);
                Log.i(KindaFingerprintImpl.this.TAG, "GenFingerPrintRsaKeyEvent callback");
                jd.b bVar = jdVar.dNN;
                if (bVar != null && bVar.isSuccess) {
                    Log.i(KindaFingerprintImpl.this.TAG, "GenFingerPrintRsaKeyEvent callback, result.isSuccess is true");
                    KindaFingerprintImpl.this.closeTipDialog();
                    if (voidStringStringCallback != null) {
                        voidStringStringCallback.call(bVar.dNR, bVar.dNS);
                        AppMethodBeat.o(18431);
                        return;
                    }
                } else if (bVar == null || bVar.isSuccess) {
                    Log.i(KindaFingerprintImpl.this.TAG, "GenFingerPrintRsaKeyEvent callback, result == null");
                } else {
                    Log.e(KindaFingerprintImpl.this.TAG, "GenFingerPrintRsaKeyEvent callback, result.isSuccess is false");
                    KindaFingerprintImpl.this.closeTipDialog();
                    if (voidCallback != null) {
                        voidCallback.call();
                        AppMethodBeat.o(18431);
                        return;
                    }
                }
                AppMethodBeat.o(18431);
            }
        };
        EventCenter.instance.asyncPublish(jdVar, Looper.getMainLooper());
        AppMethodBeat.o(18440);
    }

    @Override // com.tencent.kinda.gen.KFingerprintService
    public void showFaceIdAuthDialogImpl(String str, final VoidBinaryI32Callback voidBinaryI32Callback, final VoidCallback voidCallback, final VoidCallback voidCallback2) {
        AppMethodBeat.i(18441);
        Log.i(this.TAG, "showFaceIdAuthDialogImpl begin");
        p.IML.wFE = str;
        h.INSTANCE.a(15817, 3);
        Bundle bundle = new Bundle();
        bundle.putInt("face_auth_scene", 1);
        ((com.tencent.mm.plugin.fingerprint.b.h) g.af(com.tencent.mm.plugin.fingerprint.b.h.class)).a((MMActivity) KindaContext.get(), new com.tencent.mm.plugin.fingerprint.faceid.auth.a() {
            /* class com.tencent.kinda.framework.app.KindaFingerprintImpl.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.fingerprint.faceid.auth.a
            public void onAuthSuccess(int i2, int i3) {
                AppMethodBeat.i(18432);
                Log.i(KindaFingerprintImpl.this.TAG, "face id auth success");
                hn hnVar = new hn();
                hnVar.KLw = true;
                hnVar.dNR = "";
                hnVar.dNS = "";
                hnVar.KLx = ((a) g.af(a.class)).dJS();
                KindaFingerprintImpl kindaFingerprintImpl = KindaFingerprintImpl.this;
                int i4 = kindaFingerprintImpl.identify_num + 1;
                kindaFingerprintImpl.identify_num = i4;
                hnVar.Ijz = i4;
                try {
                    voidBinaryI32Callback.call(hnVar.toByteArray(), i2);
                    AppMethodBeat.o(18432);
                } catch (IOException e2) {
                    AppMethodBeat.o(18432);
                }
            }

            @Override // com.tencent.mm.plugin.fingerprint.faceid.auth.a
            public void onAuthFail(int i2) {
                AppMethodBeat.i(18433);
                Log.i(KindaFingerprintImpl.this.TAG, "face id auth fail: %s, %s", Integer.valueOf(i2), Integer.valueOf(KindaFingerprintImpl.this.identify_num));
                if (voidCallback != null) {
                    voidCallback.call();
                }
                KindaFingerprintImpl.this.identify_num++;
                AppMethodBeat.o(18433);
            }

            @Override // com.tencent.mm.plugin.fingerprint.faceid.auth.a
            public void onAuthCancel() {
                AppMethodBeat.i(18434);
                Log.i(KindaFingerprintImpl.this.TAG, "face id auth cancel");
                if (voidCallback2 != null) {
                    voidCallback2.call();
                }
                AppMethodBeat.o(18434);
            }
        }, bundle);
        AppMethodBeat.o(18441);
    }

    @Override // com.tencent.kinda.gen.KFingerprintService
    public void setNeedChangeAuthKey(boolean z) {
        p.IML.wFM = z;
    }

    @Override // com.tencent.kinda.gen.KFingerprintService
    public boolean isNeedChangeAuthKey() {
        AppMethodBeat.i(18442);
        boolean z = p.IML.wFM || !this.mgr.dKa();
        p.IML.wFM = z;
        AppMethodBeat.o(18442);
        return z;
    }

    @Override // com.tencent.kinda.gen.KFingerprintService
    public void changeAuthKey(boolean z, boolean z2, String str) {
        AppMethodBeat.i(18443);
        Bundle bundle = new Bundle();
        bundle.putString("pwd", str);
        i iVar = (i) g.af(i.class);
        if (iVar.dKo() || iVar.dKn()) {
            if (z2) {
                int i2 = 0;
                if (this.mgr.dJO()) {
                    i2 = 1;
                } else if (this.mgr.dJR()) {
                    i2 = 2;
                }
                bundle.putInt("key_open_biometric_type", i2);
            }
            this.mgr.a(z, z2, bundle);
        }
        AppMethodBeat.o(18443);
    }

    @Override // com.tencent.kinda.gen.KFingerprintService
    public void userCancel() {
        AppMethodBeat.i(18444);
        if (this.mgr == null) {
            AppMethodBeat.o(18444);
            return;
        }
        this.mgr.userCancel();
        AppMethodBeat.o(18444);
    }

    public void showProgress() {
        AppMethodBeat.i(18445);
        if (this.tipDialog == null || !this.tipDialog.isShowing()) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
            }
            if (KindaContext.get() != null) {
                this.tipDialog = com.tencent.mm.wallet_core.ui.h.a(KindaContext.get(), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.kinda.framework.app.KindaFingerprintImpl.AnonymousClass5 */

                    public void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(18435);
                        KindaFingerprintImpl.this.closeTipDialog();
                        AppMethodBeat.o(18435);
                    }
                });
                AppMethodBeat.o(18445);
                return;
            }
            Log.e(this.TAG, "fingerprint loading error! KindaContext return null!!");
        }
        AppMethodBeat.o(18445);
    }

    public void closeTipDialog() {
        AppMethodBeat.i(18446);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        AppMethodBeat.o(18446);
    }
}
