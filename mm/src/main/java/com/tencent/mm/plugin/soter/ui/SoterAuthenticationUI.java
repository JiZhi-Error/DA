package com.tencent.mm.plugin.soter.ui;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.soter.c.c;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.soter.a.b.b;
import com.tencent.soter.a.g.e;
import com.tencent.soter.a.g.f;
import com.tencent.soter.a.g.g;
import com.tencent.soter.core.c.i;
import java.lang.ref.WeakReference;

public class SoterAuthenticationUI extends AppCompatActivity {
    private static d FhA = null;
    public static a Fir = null;
    private c.a FhR = new c.a() {
        /* class com.tencent.mm.plugin.soter.ui.SoterAuthenticationUI.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.soter.c.c.a
        public final void a(i iVar) {
            AppMethodBeat.i(145972);
            SoterAuthenticationUI.this.Fiq = iVar;
            AppMethodBeat.o(145972);
        }
    };
    private c Fio = null;
    private boolean Fip = false;
    private i Fiq = null;
    private b<com.tencent.soter.a.b.d> Fis = new b<com.tencent.soter.a.b.d>() {
        /* class com.tencent.mm.plugin.soter.ui.SoterAuthenticationUI.AnonymousClass2 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.soter.a.b.e] */
        @Override // com.tencent.soter.a.b.b
        public final /* synthetic */ void a(com.tencent.soter.a.b.d dVar) {
            AppMethodBeat.i(145973);
            Log.i("MicroMsg.SoterAuthenticationUI", "hy: init soter ".concat(String.valueOf(dVar.isSuccess())));
            AppMethodBeat.o(145973);
        }
    };
    private ResultReceiver MU;
    private String appId = null;
    private int fromScene = -1;
    private ProgressDialog qoU = null;
    private int scene = -1;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SoterAuthenticationUI() {
        AppMethodBeat.i(145977);
        AppMethodBeat.o(145977);
    }

    static /* synthetic */ void c(SoterAuthenticationUI soterAuthenticationUI, k kVar) {
        AppMethodBeat.i(145989);
        soterAuthenticationUI.a(kVar);
        AppMethodBeat.o(145989);
    }

    public static class a extends Handler {
        private WeakReference<SoterAuthenticationUI> Fiu;

        /* synthetic */ a(SoterAuthenticationUI soterAuthenticationUI, byte b2) {
            this(soterAuthenticationUI);
        }

        private a(SoterAuthenticationUI soterAuthenticationUI) {
            AppMethodBeat.i(145974);
            this.Fiu = null;
            this.Fiu = new WeakReference<>(soterAuthenticationUI);
            AppMethodBeat.o(145974);
        }

        @TargetApi(23)
        public final void handleMessage(Message message) {
            AppMethodBeat.i(145975);
            super.handleMessage(message);
            switch (message.what) {
                case 0:
                    Log.i("MicroMsg.SoterAuthenticationUI", "hy: inform ok");
                    k kVar = (k) message.obj;
                    if (this.Fiu == null || this.Fiu.get() == null) {
                        Log.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        AppMethodBeat.o(145975);
                        return;
                    }
                    SoterAuthenticationUI.a(this.Fiu.get(), kVar);
                    AppMethodBeat.o(145975);
                    return;
                case 1:
                    Log.i("MicroMsg.SoterAuthenticationUI", "hy: inform cancel");
                    k kVar2 = (k) message.obj;
                    if (this.Fiu == null || this.Fiu.get() == null) {
                        Log.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        AppMethodBeat.o(145975);
                        return;
                    }
                    SoterAuthenticationUI.b(this.Fiu.get(), kVar2);
                    AppMethodBeat.o(145975);
                    return;
                case 2:
                    Log.i("MicroMsg.SoterAuthenticationUI", "hy: inform fail");
                    k kVar3 = (k) message.obj;
                    if (this.Fiu == null || this.Fiu.get() == null) {
                        Log.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        AppMethodBeat.o(145975);
                        return;
                    }
                    SoterAuthenticationUI.c(this.Fiu.get(), kVar3);
                    AppMethodBeat.o(145975);
                    return;
                case 3:
                    Log.i("MicroMsg.SoterAuthenticationUI", "hy: request permission");
                    if (this.Fiu == null || this.Fiu.get() == null) {
                        Log.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        AppMethodBeat.o(145975);
                        return;
                    }
                    String[] stringArray = message.getData().getStringArray(NativeProtocol.RESULT_ARGS_PERMISSIONS);
                    int i2 = message.getData().getInt("request_code");
                    if (stringArray == null || stringArray.length <= 1) {
                        Log.e("MicroMsg.SoterAuthenticationUI", "hy: permission null");
                        AppMethodBeat.o(145975);
                        return;
                    }
                    SoterAuthenticationUI soterAuthenticationUI = this.Fiu.get();
                    com.tencent.mm.hellhoundlib.b.a bl = com.tencent.mm.hellhoundlib.b.c.a(i2, new com.tencent.mm.hellhoundlib.b.a()).bl(stringArray);
                    com.tencent.mm.hellhoundlib.a.a.a(soterAuthenticationUI, bl.axQ(), "com/tencent/mm/plugin/soter/ui/SoterAuthenticationUI$SoterMpAuthenHandler", "handleMessage", "(Landroid/os/Message;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
                    soterAuthenticationUI.requestPermissions((String[]) bl.pG(0), ((Integer) bl.pG(1)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(soterAuthenticationUI, "com/tencent/mm/plugin/soter/ui/SoterAuthenticationUI$SoterMpAuthenHandler", "handleMessage", "(Landroid/os/Message;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
                    AppMethodBeat.o(145975);
                    return;
                case 4:
                    Log.i("MicroMsg.SoterAuthenticationUI", "hy: show progress");
                    if (this.Fiu == null || this.Fiu.get() == null) {
                        Log.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        AppMethodBeat.o(145975);
                        return;
                    }
                    SoterAuthenticationUI.a(this.Fiu.get());
                    AppMethodBeat.o(145975);
                    return;
                case 5:
                    Log.i("MicroMsg.SoterAuthenticationUI", "hy: dismiss progress");
                    if (this.Fiu == null || this.Fiu.get() == null) {
                        Log.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        AppMethodBeat.o(145975);
                        return;
                    }
                    SoterAuthenticationUI.b(this.Fiu.get());
                    AppMethodBeat.o(145975);
                    return;
                case 6:
                    Log.i("MicroMsg.SoterAuthenticationUI", "hy: show dialog");
                    if (this.Fiu == null || this.Fiu.get() == null) {
                        Log.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        AppMethodBeat.o(145975);
                        return;
                    }
                    d unused = SoterAuthenticationUI.FhA = (d) message.obj;
                    AppMethodBeat.o(145975);
                    return;
                default:
                    Log.e("MicroMsg.SoterAuthenticationUI", "hy: unidentified msg: %d", Integer.valueOf(message.what));
                    AppMethodBeat.o(145975);
                    return;
            }
        }

        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(145976);
            if (aVar.Fiu != null) {
                aVar.Fiu.clear();
            }
            AppMethodBeat.o(145976);
        }
    }

    @Override // android.support.v7.app.AppCompatActivity
    public Resources getResources() {
        AppMethodBeat.i(201780);
        Resources resources = MMApplicationContext.getResources();
        AppMethodBeat.o(201780);
        return resources;
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    @TargetApi(23)
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(145978);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        this.MU = (ResultReceiver) getIntent().getParcelableExtra("Soter_Result_Receiver");
        if (Fir != null) {
            a.a(Fir);
        }
        Fir = new a(this, (byte) 0);
        j jVar = new j();
        k kVar = new k();
        String stringExtra = getIntent().getStringExtra("auth_mode");
        if (Util.isNullOrNil(stringExtra)) {
            Log.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode : null");
            kVar.errCode = 90003;
            kVar.errMsg = "authen mode is null";
        } else {
            try {
                jVar.FhV = Byte.parseByte(Util.nullAs(stringExtra.substring(2), "00"), 16);
                jVar.wFE = getIntent().getStringExtra("challenge");
                jVar.content = getIntent().getStringExtra("auth_content");
                if (!com.tencent.soter.core.a.hlj()) {
                    Log.e("MicroMsg.SoterAuthenticationUI", "hy: not support soter");
                    kVar.errCode = 90001;
                    kVar.errMsg = "not support soter";
                } else if (jVar.FhV <= 0) {
                    Log.e("MicroMsg.SoterAuthenticationUI", "hy: param error: request mode illegal");
                    kVar.errCode = 90003;
                    kVar.errMsg = "resp model error";
                } else if (Util.isNullOrNil(jVar.wFE)) {
                    Log.e("MicroMsg.SoterAuthenticationUI", "hy: param error: challenge null");
                    kVar.errCode = 90004;
                    kVar.errMsg = "challenge is null";
                } else if (jVar.wFE.length() >= 512) {
                    Log.e("MicroMsg.SoterAuthenticationUI", "hy: param error: challenge too long");
                    kVar.errCode = 90004;
                    kVar.errMsg = "challenge is too long. 512 chars at most";
                } else if (Util.isNullOrNil(jVar.content)) {
                    jVar.content = getString(R.string.hci);
                } else if (jVar.content.length() > 42) {
                    Log.e("MicroMsg.SoterAuthenticationUI", "hy: param error: content too long. use default");
                    jVar.content = getString(R.string.hci);
                }
            } catch (IndexOutOfBoundsException | NumberFormatException e2) {
                Log.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode format: %s", stringExtra);
                kVar.errCode = 90003;
                kVar.errMsg = "authen mode is illegal: number format error. found: ".concat(String.valueOf(stringExtra));
            }
        }
        if (kVar.errCode != 0) {
            a(kVar);
            AppMethodBeat.o(145978);
            return;
        }
        this.fromScene = getIntent().getIntExtra("key_soter_fp_luggage_fromscene", 1);
        this.scene = getIntent().getIntExtra("key_soter_fp_luggage_scene", 2048);
        com.tencent.mm.plugin.soter.c.a aVar = com.tencent.mm.plugin.soter.c.a.IML;
        this.Fio = com.tencent.mm.plugin.soter.c.a.a(this, jVar, kVar, Fir);
        if (this.Fio == null) {
            Log.e("MicroMsg.SoterAuthenticationUI", "hy: no corresponding authen mode");
            kVar.errCode = 90003;
            kVar.errMsg = "no corresponding mode";
            a(kVar);
            AppMethodBeat.o(145978);
            return;
        }
        this.Fio.FhQ = null;
        this.Fio.FhP = null;
        this.Fio.mScene = this.scene;
        this.Fio.FhR = this.FhR;
        boolean isInit = com.tencent.soter.a.c.b.hlG().isInit();
        Log.i("MicroMsg.SoterAuthenticationUI", "hy: isInit:".concat(String.valueOf(isInit)));
        if (!isInit) {
            Log.i("MicroMsg.SoterAuthenticationUI", "hy: init scene:" + this.Fio.mScene);
            e eVar = new e.a().U(this.Fio.mScene).RRf;
            g.hlR().aj(new Runnable(getApplicationContext(), eVar, this.Fis) {
                /* class com.tencent.soter.a.a.AnonymousClass1 */
                final /* synthetic */ e RQq;
                final /* synthetic */ b RQr;
                final /* synthetic */ Context val$context;

                {
                    this.val$context = r1;
                    this.RQq = r2;
                    this.RQr = r3;
                }

                public final void run() {
                    AppMethodBeat.i(1);
                    com.tencent.soter.a.g.j jVar = new com.tencent.soter.a.g.j(this.val$context, this.RQq);
                    jVar.RQW = this.RQr;
                    if (!f.hlO().a(jVar, new com.tencent.soter.a.b.d())) {
                        com.tencent.soter.core.c.d.e("Soter.SoterWrapperApi", "soter: add init task failed.", new Object[0]);
                    }
                    AppMethodBeat.o(1);
                }
            });
            this.Fip = true;
        }
        this.appId = getIntent().getStringExtra("key_app_id");
        this.Fio.gA();
        AppMethodBeat.o(145978);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(145979);
        super.onResume();
        if (this.Fio != null) {
            this.Fio.onResume();
        }
        overridePendingTransition(0, 0);
        AppMethodBeat.o(145979);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(145980);
        super.onPause();
        if (this.Fio != null) {
            this.Fio.onPause();
        }
        AppMethodBeat.o(145980);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void finish() {
        AppMethodBeat.i(145981);
        super.finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.o(145981);
    }

    private void a(k kVar) {
        AppMethodBeat.i(145982);
        this.MU.send(1, b(kVar));
        c(kVar);
        finish();
        AppMethodBeat.o(145982);
    }

    private static Bundle b(k kVar) {
        AppMethodBeat.i(145983);
        Bundle bundle = new Bundle();
        bundle.putInt("err_code", kVar.errCode);
        bundle.putString("err_msg", kVar.errMsg);
        bundle.putByte("use_mode", kVar.FhW);
        bundle.putString("result_json", kVar.dZL);
        bundle.putString("result_json_signature", kVar.FhX);
        Log.d("MicroMsg.SoterAuthenticationUI", "hy: dump mp soter result: %s", bundle.toString());
        AppMethodBeat.o(145983);
        return bundle;
    }

    private void c(k kVar) {
        AppMethodBeat.i(145984);
        if (kVar == null) {
            AppMethodBeat.o(145984);
            return;
        }
        if (this.fromScene == 1) {
            com.tencent.mm.plugin.soter.d.i.aB(this.appId, kVar.errCode, Tc(kVar.errCode));
        }
        AppMethodBeat.o(145984);
    }

    private static int Tc(int i2) {
        switch (i2) {
            case 0:
                return 0;
            case 90001:
            case 90002:
            case 90003:
            case 90004:
            case 90006:
            case 90007:
            case 90011:
                return 2;
            case 90008:
            case 90009:
            case 90010:
                return 3;
            default:
                return -1;
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(145985);
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (this.Fio != null) {
            this.Fio.onRequestPermissionsResult(i2, strArr, iArr);
        }
        AppMethodBeat.o(145985);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(145986);
        super.onDestroy();
        if (this.qoU != null && this.qoU.isShowing()) {
            Log.i("MicroMsg.SoterAuthenticationUI", "onDestroy mProgressDialog dismiss!");
            this.qoU.dismiss();
        }
        if (FhA != null && FhA.isShowing()) {
            Log.i("MicroMsg.SoterAuthenticationUI", "onDestroy mAuthenDialog dismiss!");
            FhA.dismiss();
        }
        a.a(Fir);
        if (this.Fip) {
            f.hlO().hlP();
            com.tencent.soter.a.c.b hlG = com.tencent.soter.a.c.b.hlG();
            synchronized (com.tencent.soter.a.c.b.class) {
                try {
                    hlG.isInit = false;
                    hlG.dEI = false;
                    hlG.RQy = new SparseArray<>(10);
                    hlG.RQz = null;
                } finally {
                    AppMethodBeat.o(145986);
                }
            }
            return;
        }
        AppMethodBeat.o(145986);
    }

    static /* synthetic */ void a(SoterAuthenticationUI soterAuthenticationUI, k kVar) {
        AppMethodBeat.i(145987);
        Bundle b2 = b(kVar);
        if (soterAuthenticationUI.Fiq != null) {
            b2.putString("authkey_result_json", soterAuthenticationUI.Fiq.RPQ);
            b2.putString("authkey_result_json_signature", soterAuthenticationUI.Fiq.signature);
        }
        soterAuthenticationUI.MU.send(-1, b2);
        soterAuthenticationUI.c(kVar);
        soterAuthenticationUI.finish();
        AppMethodBeat.o(145987);
    }

    static /* synthetic */ void b(SoterAuthenticationUI soterAuthenticationUI, k kVar) {
        AppMethodBeat.i(145988);
        kVar.errCode = 90008;
        kVar.errMsg = "user cancelled the authentication process";
        soterAuthenticationUI.MU.send(0, b(kVar));
        soterAuthenticationUI.c(kVar);
        soterAuthenticationUI.finish();
        AppMethodBeat.o(145988);
    }

    static /* synthetic */ void a(SoterAuthenticationUI soterAuthenticationUI) {
        AppMethodBeat.i(145990);
        if (soterAuthenticationUI.qoU == null || !soterAuthenticationUI.qoU.isShowing()) {
            soterAuthenticationUI.qoU = ProgressDialog.show(soterAuthenticationUI, "", soterAuthenticationUI.getString(R.string.hch), true, false, null);
        }
        AppMethodBeat.o(145990);
    }

    static /* synthetic */ void b(SoterAuthenticationUI soterAuthenticationUI) {
        AppMethodBeat.i(145991);
        if (soterAuthenticationUI.qoU != null && soterAuthenticationUI.qoU.isShowing()) {
            soterAuthenticationUI.qoU.dismiss();
        }
        AppMethodBeat.o(145991);
    }
}
