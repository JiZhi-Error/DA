package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.appbrand.jsapi.ce;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voiceprint.model.e;
import com.tencent.mm.plugin.voiceprint.model.n;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.qqmusic.mediaplayer.PlayerException;

public class VoiceLoginUI extends BaseVoicePrintUI implements n.a {
    private n GSa = null;
    private String mRa = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(VoiceLoginUI voiceLoginUI) {
        AppMethodBeat.i(29886);
        voiceLoginUI.goBack();
        AppMethodBeat.o(29886);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29875);
        super.onCreate(bundle);
        h.INSTANCE.a(11557, 1);
        this.mRa = Util.nullAs(getIntent().getStringExtra("Kusername"), (String) null);
        String nullAs = Util.nullAs(getIntent().getStringExtra("Kvertify_key"), (String) null);
        Log.d("MicroMsg.VoiceLoginUI", "summerauth onCreate, username:%s loginTicket==null:%b", this.mRa, Boolean.valueOf(Util.isNullOrNil(nullAs)));
        if (!Util.isNullOrNil(this.mRa) || !Util.isNullOrNil(nullAs)) {
            this.GSa = new n();
            this.GSa.mRa = this.mRa;
            this.GSa.lhR = nullAs;
            this.GSa.GRi = this;
            n nVar = this.GSa;
            if (Util.isNullOrNil(nVar.lhR)) {
                bg.azz().a(new e(nVar.mRa), 0);
            } else {
                nVar.fEE();
            }
            Log.i("MicroMsg.VoiceLoginUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(b.a(this, "android.permission.RECORD_AUDIO", 80, "", "")), Util.getStack(), this);
            setBackBtn(new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.voiceprint.ui.VoiceLoginUI.AnonymousClass1 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(29872);
                    VoiceLoginUI.a(VoiceLoginUI.this);
                    AppMethodBeat.o(29872);
                    return true;
                }
            });
            if (d.oD(23)) {
                getWindow().setStatusBarColor(getResources().getColor(R.color.a2h));
                updataStatusBarIcon(ao.isDarkMode());
            }
            AppMethodBeat.o(29875);
            return;
        }
        Log.e("MicroMsg.VoiceLoginUI", "onCreate error, username and ticket are both null");
        AppMethodBeat.o(29875);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI
    public final void fEK() {
        AppMethodBeat.i(29876);
        Log.d("MicroMsg.VoiceLoginUI", "sendVoice, filename:%s", this.GRC);
        if (!Util.isNullOrNil(this.GRC) && !Util.isNullOrNil(this.GRf)) {
            n nVar = this.GSa;
            com.tencent.mm.plugin.voiceprint.model.h hVar = new com.tencent.mm.plugin.voiceprint.model.h(this.GRC, nVar.GRg, nVar.lhR);
            hVar.GQR = true;
            bg.azz().a(hVar, 0);
            this.GRx.setEnabled(false);
            this.GRA.fEU();
        }
        AppMethodBeat.o(29876);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI
    public final void edG() {
        AppMethodBeat.i(29877);
        findViewById(R.id.h6z).setVisibility(8);
        this.GRA.fEU();
        this.GRA.setTitleText(R.string.hzd);
        this.GRA.fEW();
        this.GRx.setEnabled(false);
        AppMethodBeat.o(29877);
    }

    private void goBack() {
        AppMethodBeat.i(29878);
        setResult(0);
        finish();
        AppMethodBeat.o(29878);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(29879);
        if (i2 == 4) {
            goBack();
            AppMethodBeat.o(29879);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(29879);
        return onKeyDown;
    }

    @Override // com.tencent.mm.plugin.voiceprint.model.n.a
    public final void aUv(String str) {
        AppMethodBeat.i(29880);
        Log.d("MicroMsg.VoiceLoginUI", "onGetText");
        this.GRf = str;
        this.GRA.fEV();
        this.GRA.setTipText(str);
        this.GRA.ekF();
        this.GRx.setEnabled(true);
        AppMethodBeat.o(29880);
    }

    @Override // com.tencent.mm.plugin.voiceprint.model.n.a
    public final void fED() {
        AppMethodBeat.i(29882);
        acL(R.string.hzk);
        AppMethodBeat.o(29882);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI
    public void onDestroy() {
        AppMethodBeat.i(29884);
        super.onDestroy();
        if (this.GSa != null) {
            n nVar = this.GSa;
            bg.azz().b(ce.CTRL_INDEX, nVar);
            bg.azz().b(616, nVar);
            bg.azz().b(617, nVar);
            nVar.GRi = null;
        }
        AppMethodBeat.o(29884);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(29885);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.VoiceLoginUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(29885);
            return;
        }
        Log.i("MicroMsg.VoiceLoginUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.flb), getString(R.string.flp), getString(R.string.e_k), getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.voiceprint.ui.VoiceLoginUI.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(29873);
                            dialogInterface.dismiss();
                            VoiceLoginUI voiceLoginUI = VoiceLoginUI.this;
                            a bl = new a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(voiceLoginUI, bl.axQ(), "com/tencent/mm/plugin/voiceprint/ui/VoiceLoginUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            voiceLoginUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(voiceLoginUI, "com/tencent/mm/plugin/voiceprint/ui/VoiceLoginUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(29873);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.voiceprint.ui.VoiceLoginUI.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(29874);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(29874);
                        }
                    });
                    break;
                } else {
                    fEH();
                    AppMethodBeat.o(29885);
                    return;
                }
        }
        AppMethodBeat.o(29885);
    }

    @Override // com.tencent.mm.plugin.voiceprint.model.n.a
    public final void wO(boolean z) {
        AppMethodBeat.i(29881);
        this.GRA.ekF();
        this.GRx.setEnabled(true);
        if (z) {
            Log.i("MicroMsg.VoiceLoginUI", "login success[%s]", Util.secPrint(this.GSa.kly));
            Intent intent = new Intent();
            intent.putExtra("VoiceLoginAuthPwd", this.GSa.kly);
            setResult(-1, intent);
            finish();
            AppMethodBeat.o(29881);
            return;
        }
        Log.i("MicroMsg.VoiceLoginUI", "login failed");
        this.GRA.setErr(R.string.hzc);
        this.GRA.fEX();
        AppMethodBeat.o(29881);
    }

    @Override // com.tencent.mm.plugin.voiceprint.model.n.a
    public final void fEF() {
        AppMethodBeat.i(29883);
        this.GRx.setEnabled(false);
        this.GRx.setVisibility(4);
        this.GRA.ekF();
        this.GRA.setErr(R.string.hzj);
        this.GRA.fEX();
        AppMethodBeat.o(29883);
    }
}
