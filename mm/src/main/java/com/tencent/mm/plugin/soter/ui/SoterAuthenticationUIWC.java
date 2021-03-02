package com.tencent.mm.plugin.soter.ui;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.soter.b.e;
import com.tencent.mm.plugin.soter.b.f;
import com.tencent.mm.plugin.soter.c.c;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.plugin.soter.d.l;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.soter.a.b.b;
import java.lang.ref.WeakReference;

@com.tencent.mm.ui.base.a(7)
public class SoterAuthenticationUIWC extends MMActivity {
    private static d FhA = null;
    public static a Fiv = null;
    private c Fio = null;
    private b<com.tencent.soter.a.b.d> Fis = new b<com.tencent.soter.a.b.d>() {
        /* class com.tencent.mm.plugin.soter.ui.SoterAuthenticationUIWC.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.soter.a.b.e] */
        @Override // com.tencent.soter.a.b.b
        public final /* bridge */ /* synthetic */ void a(com.tencent.soter.a.b.d dVar) {
        }
    };
    private String appId = null;
    private int fromScene = -1;
    private ProgressDialog qoU = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SoterAuthenticationUIWC() {
        AppMethodBeat.i(130891);
        AppMethodBeat.o(130891);
    }

    static /* synthetic */ void c(SoterAuthenticationUIWC soterAuthenticationUIWC, k kVar) {
        AppMethodBeat.i(130902);
        soterAuthenticationUIWC.a(kVar);
        AppMethodBeat.o(130902);
    }

    public static class a extends Handler {
        private WeakReference<SoterAuthenticationUIWC> Fiu;

        /* synthetic */ a(SoterAuthenticationUIWC soterAuthenticationUIWC, byte b2) {
            this(soterAuthenticationUIWC);
        }

        private a(SoterAuthenticationUIWC soterAuthenticationUIWC) {
            AppMethodBeat.i(130888);
            this.Fiu = null;
            this.Fiu = new WeakReference<>(soterAuthenticationUIWC);
            AppMethodBeat.o(130888);
        }

        @TargetApi(23)
        public final void handleMessage(Message message) {
            AppMethodBeat.i(130889);
            super.handleMessage(message);
            switch (message.what) {
                case 0:
                    Log.i("MicroMsg.SoterAuthenticationUIWC", "hy: inform ok");
                    k kVar = (k) message.obj;
                    if (this.Fiu == null || this.Fiu.get() == null) {
                        Log.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
                        AppMethodBeat.o(130889);
                        return;
                    }
                    SoterAuthenticationUIWC.a(this.Fiu.get(), kVar);
                    AppMethodBeat.o(130889);
                    return;
                case 1:
                    Log.i("MicroMsg.SoterAuthenticationUIWC", "hy: inform cancel");
                    k kVar2 = (k) message.obj;
                    if (this.Fiu == null || this.Fiu.get() == null) {
                        Log.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
                        AppMethodBeat.o(130889);
                        return;
                    }
                    SoterAuthenticationUIWC.b(this.Fiu.get(), kVar2);
                    AppMethodBeat.o(130889);
                    return;
                case 2:
                    Log.i("MicroMsg.SoterAuthenticationUIWC", "hy: inform fail");
                    k kVar3 = (k) message.obj;
                    if (this.Fiu == null || this.Fiu.get() == null) {
                        Log.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
                        AppMethodBeat.o(130889);
                        return;
                    }
                    SoterAuthenticationUIWC.c(this.Fiu.get(), kVar3);
                    AppMethodBeat.o(130889);
                    return;
                case 3:
                    Log.i("MicroMsg.SoterAuthenticationUIWC", "hy: request permission");
                    if (this.Fiu == null || this.Fiu.get() == null) {
                        Log.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
                        AppMethodBeat.o(130889);
                        return;
                    }
                    String[] stringArray = message.getData().getStringArray(NativeProtocol.RESULT_ARGS_PERMISSIONS);
                    int i2 = message.getData().getInt("request_code");
                    if (stringArray == null || stringArray.length <= 1) {
                        Log.e("MicroMsg.SoterAuthenticationUIWC", "hy: permission null");
                        AppMethodBeat.o(130889);
                        return;
                    }
                    SoterAuthenticationUIWC soterAuthenticationUIWC = this.Fiu.get();
                    com.tencent.mm.hellhoundlib.b.a bl = com.tencent.mm.hellhoundlib.b.c.a(i2, new com.tencent.mm.hellhoundlib.b.a()).bl(stringArray);
                    com.tencent.mm.hellhoundlib.a.a.a(soterAuthenticationUIWC, bl.axQ(), "com/tencent/mm/plugin/soter/ui/SoterAuthenticationUIWC$SoterMpAuthenHandler", "handleMessage", "(Landroid/os/Message;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
                    soterAuthenticationUIWC.requestPermissions((String[]) bl.pG(0), ((Integer) bl.pG(1)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(soterAuthenticationUIWC, "com/tencent/mm/plugin/soter/ui/SoterAuthenticationUIWC$SoterMpAuthenHandler", "handleMessage", "(Landroid/os/Message;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
                    AppMethodBeat.o(130889);
                    return;
                case 4:
                    Log.i("MicroMsg.SoterAuthenticationUIWC", "hy: show progress");
                    if (this.Fiu == null || this.Fiu.get() == null) {
                        Log.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
                        AppMethodBeat.o(130889);
                        return;
                    }
                    SoterAuthenticationUIWC.a(this.Fiu.get());
                    AppMethodBeat.o(130889);
                    return;
                case 5:
                    Log.i("MicroMsg.SoterAuthenticationUIWC", "hy: dismiss progress");
                    if (this.Fiu == null || this.Fiu.get() == null) {
                        Log.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
                        AppMethodBeat.o(130889);
                        return;
                    }
                    SoterAuthenticationUIWC.b(this.Fiu.get());
                    AppMethodBeat.o(130889);
                    return;
                case 6:
                    Log.i("MicroMsg.SoterAuthenticationUIWC", "hy: show dialog");
                    if (this.Fiu == null || this.Fiu.get() == null) {
                        Log.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
                        AppMethodBeat.o(130889);
                        return;
                    }
                    d unused = SoterAuthenticationUIWC.FhA = (d) message.obj;
                    AppMethodBeat.o(130889);
                    return;
                default:
                    Log.e("MicroMsg.SoterAuthenticationUIWC", "hy: unidentified msg: %d", Integer.valueOf(message.what));
                    AppMethodBeat.o(130889);
                    return;
            }
        }

        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(130890);
            if (aVar.Fiu != null) {
                aVar.Fiu.clear();
            }
            AppMethodBeat.o(130890);
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    @TargetApi(23)
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(130892);
        super.onCreate(bundle);
        if (26 != Build.VERSION.SDK_INT) {
            setRequestedOrientation(1);
        }
        if (Fiv != null) {
            a.a(Fiv);
        }
        Fiv = new a(this, (byte) 0);
        j jVar = new j();
        k kVar = new k();
        String stringExtra = getIntent().getStringExtra("auth_mode");
        if (Util.isNullOrNil(stringExtra)) {
            Log.e("MicroMsg.SoterAuthenticationUIWC", "hy: error authen mode : null");
            kVar.errCode = 90003;
            kVar.errMsg = "authen mode is null";
        } else {
            try {
                jVar.FhV = Byte.parseByte(Util.nullAs(stringExtra.substring(2), "00"), 16);
                jVar.wFE = getIntent().getStringExtra("challenge");
                jVar.content = getIntent().getStringExtra("auth_content");
                if (!m.flS()) {
                    Log.e("MicroMsg.SoterAuthenticationUIWC", "hy: not support soter");
                    kVar.errCode = 90001;
                    kVar.errMsg = "not support soter";
                } else if (jVar.FhV <= 0) {
                    Log.e("MicroMsg.SoterAuthenticationUIWC", "hy: param error: request mode illegal");
                    kVar.errCode = 90003;
                    kVar.errMsg = "resp model error";
                } else if (Util.isNullOrNil(jVar.wFE)) {
                    Log.e("MicroMsg.SoterAuthenticationUIWC", "hy: param error: challenge null");
                    kVar.errCode = 90004;
                    kVar.errMsg = "challenge is null";
                } else if (jVar.wFE.length() >= 512) {
                    Log.e("MicroMsg.SoterAuthenticationUIWC", "hy: param error: challenge too long");
                    kVar.errCode = 90004;
                    kVar.errMsg = "challenge is too long. 512 chars at most";
                } else if (Util.isNullOrNil(jVar.content)) {
                    jVar.content = getString(R.string.hci);
                } else if (jVar.content.length() > 42) {
                    Log.e("MicroMsg.SoterAuthenticationUIWC", "hy: param error: content too long. use default");
                    jVar.content = getString(R.string.hci);
                }
            } catch (IndexOutOfBoundsException | NumberFormatException e2) {
                Log.e("MicroMsg.SoterAuthenticationUIWC", "hy: error authen mode format: %s", stringExtra);
                kVar.errCode = 90003;
                kVar.errMsg = "authen mode is illegal: number format error. found: ".concat(String.valueOf(stringExtra));
            }
        }
        if (kVar.errCode != 0) {
            a(kVar);
            AppMethodBeat.o(130892);
            return;
        }
        this.fromScene = getIntent().getIntExtra("key_soter_fp_mp_scene", 0);
        com.tencent.mm.plugin.soter.c.a aVar = com.tencent.mm.plugin.soter.c.a.IML;
        this.Fio = com.tencent.mm.plugin.soter.c.a.a(this, jVar, kVar, Fiv);
        if (this.Fio == null) {
            Log.e("MicroMsg.SoterAuthenticationUIWC", "hy: no corresponding authen mode");
            kVar.errCode = 90003;
            kVar.errMsg = "no corresponding mode";
            a(kVar);
            AppMethodBeat.o(130892);
            return;
        }
        this.Fio.FhQ = new f();
        this.Fio.FhP = new e();
        this.Fio.mScene = 2;
        this.appId = getIntent().getStringExtra("key_app_id");
        this.Fio.gA();
        AppMethodBeat.o(130892);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(130893);
        super.onResume();
        if (this.Fio != null) {
            this.Fio.onResume();
        }
        AppMethodBeat.o(130893);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(130894);
        super.onPause();
        if (this.Fio != null) {
            this.Fio.onPause();
        }
        AppMethodBeat.o(130894);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    private void a(k kVar) {
        AppMethodBeat.i(130895);
        setResult(1, d(kVar));
        c(kVar);
        finish();
        AppMethodBeat.o(130895);
    }

    private static Intent d(k kVar) {
        AppMethodBeat.i(130896);
        Bundle bundle = new Bundle();
        bundle.putInt("err_code", kVar.errCode);
        bundle.putString("err_msg", kVar.errMsg);
        bundle.putByte("use_mode", kVar.FhW);
        bundle.putString("result_json", kVar.dZL);
        bundle.putString("result_json_signature", kVar.FhX);
        Log.d("MicroMsg.SoterAuthenticationUIWC", "hy: dump mp soter result: %s", bundle.toString());
        Intent intent = new Intent();
        intent.putExtras(bundle);
        AppMethodBeat.o(130896);
        return intent;
    }

    private void c(k kVar) {
        AppMethodBeat.i(130897);
        if (kVar == null) {
            AppMethodBeat.o(130897);
            return;
        }
        if (this.fromScene == 0) {
            int Tc = Tc(kVar.errCode);
            l lVar = l.INSTANCE;
            l.r("requireSoterBiometricAuthentication", this.appId, Tc, kVar.errCode);
        }
        AppMethodBeat.o(130897);
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

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(130898);
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (this.Fio != null) {
            this.Fio.onRequestPermissionsResult(i2, strArr, iArr);
        }
        AppMethodBeat.o(130898);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(130899);
        super.onDestroy();
        if (this.qoU != null && this.qoU.isShowing()) {
            Log.i("MicroMsg.SoterAuthenticationUIWC", "onDestroy mProgressDialog dismiss!");
            this.qoU.dismiss();
        }
        if (FhA != null && FhA.isShowing()) {
            Log.i("MicroMsg.SoterAuthenticationUIWC", "onDestroy mAuthenDialog dismiss!");
            FhA.dismiss();
        }
        a.a(Fiv);
        AppMethodBeat.o(130899);
    }

    static /* synthetic */ void a(SoterAuthenticationUIWC soterAuthenticationUIWC, k kVar) {
        AppMethodBeat.i(130900);
        soterAuthenticationUIWC.setResult(-1, d(kVar));
        soterAuthenticationUIWC.c(kVar);
        soterAuthenticationUIWC.finish();
        AppMethodBeat.o(130900);
    }

    static /* synthetic */ void b(SoterAuthenticationUIWC soterAuthenticationUIWC, k kVar) {
        AppMethodBeat.i(130901);
        kVar.errCode = 90008;
        kVar.errMsg = "user cancelled the authentication process";
        soterAuthenticationUIWC.setResult(0, d(kVar));
        soterAuthenticationUIWC.c(kVar);
        soterAuthenticationUIWC.finish();
        AppMethodBeat.o(130901);
    }

    static /* synthetic */ void a(SoterAuthenticationUIWC soterAuthenticationUIWC) {
        AppMethodBeat.i(130903);
        if (soterAuthenticationUIWC.qoU == null || !soterAuthenticationUIWC.qoU.isShowing()) {
            soterAuthenticationUIWC.qoU = com.tencent.mm.ui.widget.a.j.b(soterAuthenticationUIWC, soterAuthenticationUIWC.getString(R.string.hch), false, null);
            soterAuthenticationUIWC.qoU.show();
        }
        AppMethodBeat.o(130903);
    }

    static /* synthetic */ void b(SoterAuthenticationUIWC soterAuthenticationUIWC) {
        AppMethodBeat.i(130904);
        if (soterAuthenticationUIWC.qoU != null && soterAuthenticationUIWC.qoU.isShowing()) {
            soterAuthenticationUIWC.qoU.dismiss();
        }
        AppMethodBeat.o(130904);
    }
}
