package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.voiceprint.model.d;
import com.tencent.mm.plugin.voiceprint.model.j;
import com.tencent.mm.plugin.voiceprint.model.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class VoiceUnLockUI extends BaseVoicePrintUI implements q.a {
    private q GSD;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29925);
        super.onCreate(bundle);
        this.GSD = new q(this);
        Log.d("MicroMsg.VoicePrintUnLockService", "getVoiceText");
        bg.azz().a(new d(73, ""), 0);
        AppMethodBeat.o(29925);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI
    public final void fEK() {
        AppMethodBeat.i(29926);
        Log.d("MicroMsg.VoiceUnLockUI", "sendVoice, filename:%s", this.GRC);
        if (!Util.isNullOrNil(this.GRC) && !Util.isNullOrNil(this.GSD.GRf)) {
            j jVar = new j(this.GRC, this.GSD.GRg);
            jVar.GQR = true;
            bg.azz().a(jVar, 0);
            this.GRx.setEnabled(false);
            this.GRA.fEU();
        }
        AppMethodBeat.o(29926);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI
    public final void edG() {
        AppMethodBeat.i(29927);
        findViewById(R.id.h6z).setVisibility(8);
        this.GRA.fEU();
        this.GRA.setTitleText(R.string.hzd);
        this.GRA.fEW();
        this.GRx.setEnabled(false);
        AppMethodBeat.o(29927);
    }

    /* access modifiers changed from: protected */
    public void fET() {
        AppMethodBeat.i(29930);
        Intent intent = new Intent();
        intent.putExtra("kscene_type", 73);
        intent.setClass(this, VoicePrintFinishUI.class);
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/voiceprint/ui/VoiceUnLockUI", "onUnlockSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceUnLockUI", "onUnlockSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        AppMethodBeat.o(29930);
    }

    @Override // com.tencent.mm.plugin.voiceprint.model.q.a
    public final void fED() {
        AppMethodBeat.i(29931);
        fEJ();
        AppMethodBeat.o(29931);
    }

    @Override // com.tencent.mm.plugin.voiceprint.model.q.a
    public final void fEF() {
        AppMethodBeat.i(29932);
        acL(R.string.hze);
        AppMethodBeat.o(29932);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI
    public void onDestroy() {
        AppMethodBeat.i(29933);
        super.onDestroy();
        q qVar = this.GSD;
        bg.azz().b(611, qVar);
        bg.azz().b(613, qVar);
        qVar.GRw = null;
        AppMethodBeat.o(29933);
    }

    @Override // com.tencent.mm.plugin.voiceprint.model.q.a
    public final void aUv(String str) {
        AppMethodBeat.i(29928);
        this.GRf = str;
        this.GRA.fEV();
        this.GRA.setTipText(str);
        this.GRA.ekF();
        this.GRx.setEnabled(true);
        AppMethodBeat.o(29928);
    }

    @Override // com.tencent.mm.plugin.voiceprint.model.q.a
    public final void wP(boolean z) {
        AppMethodBeat.i(29929);
        this.GRA.ekF();
        this.GRx.setEnabled(true);
        if (z) {
            Log.d("MicroMsg.VoiceUnLockUI", "unlock success");
            fET();
            AppMethodBeat.o(29929);
            return;
        }
        this.GRA.setErr(R.string.hzc);
        this.GRA.fEX();
        AppMethodBeat.o(29929);
    }
}
