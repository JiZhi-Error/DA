package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.account.ui.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.z;
import java.util.List;

public class bg extends a implements i, MStorage.IOnStorageChange, MStorageEx.IOnStorageChange, af {
    private static boolean Pvh;

    static {
        boolean z;
        AppMethodBeat.i(233222);
        if (((b) g.af(b.class)).a(b.a.clicfg_verfy_user_component_reset_banner, 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        Pvh = z;
        AppMethodBeat.o(233222);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        AppMethodBeat.i(35743);
        com.tencent.mm.model.bg.azz().a(137, this);
        com.tencent.mm.model.bg.aVF();
        c.aSN().add(this);
        AppMethodBeat.o(35743);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(35744);
        com.tencent.mm.model.bg.azz().b(137, this);
        if (com.tencent.mm.model.bg.aAc()) {
            com.tencent.mm.model.bg.aVF();
            c.aSN().remove(this);
        }
        AppMethodBeat.o(35744);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(35745);
        super.gOK();
        com.tencent.mm.model.bg.azz().b(137, this);
        if (com.tencent.mm.model.bg.aAc()) {
            com.tencent.mm.model.bg.aVF();
            c.aSN().remove(this);
        }
        AppMethodBeat.o(35745);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z = true;
        AppMethodBeat.i(35746);
        Log.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str + " sceneType:" + qVar.getType());
        this.dom.dismissDialog();
        if (!this.dom.cQp) {
            Log.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd fragment not foreground, return");
            AppMethodBeat.o(35746);
        } else if (!Util.isTopActivity(this.dom.Pwc.getContext())) {
            AppMethodBeat.o(35746);
        } else {
            Activity context = this.dom.Pwc.getContext();
            if (!z.a.a(context, i2, i3, str, 7) && !a.a(context, i2, i3, new Intent().setClass(context, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str)) {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(35746);
                return;
            }
            if (i2 == 0 && i3 == 0) {
                switch (qVar.getType()) {
                    case 137:
                        List<String> list = ((p) qVar).JVj;
                        if (list == null || list.contains(this.dom.GUe.field_username)) {
                            as asVar = this.dom.GUe;
                            com.tencent.mm.model.bg.aVF();
                            as Kn = c.aSN().Kn(asVar.field_username);
                            if (Kn == null || ((int) Kn.gMZ) == 0) {
                                com.tencent.mm.model.bg.aVF();
                                if (!c.aSN().ao(asVar)) {
                                    Log.e("MicroMsg.ChattingUI.ChattingLogic", "insert contact failed, username = " + asVar.field_username);
                                    Kn = null;
                                } else {
                                    com.tencent.mm.model.bg.aVF();
                                    Kn = c.aSN().Kn(asVar.field_username);
                                }
                            }
                            if (Kn != null) {
                                ab.B(Kn);
                                break;
                            }
                        }
                        break;
                }
            }
            AppMethodBeat.o(35746);
        }
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(35747);
        if (!this.dom.cQp) {
            Log.i("MicroMsg.ChattingUI.VerifyUserComponent", "onNotifyChange fragment not foreground, return");
            AppMethodBeat.o(35747);
            return;
        }
        Log.i("MicroMsg.ChattingUI.VerifyUserComponent", "onNotifyChange " + i2 + ", needResetBanner = " + Pvh);
        com.tencent.mm.model.bg.aVF();
        as Kn = c.aSN().Kn(this.dom.getTalkerUserName());
        if (!(Kn == null || ((int) Kn.gMZ) == 0)) {
            if (Util.isNullOrNil(Kn.field_nickname)) {
                Kn.setNickname(this.dom.GUe.field_nickname);
            }
            this.dom.aw(Kn);
            ((aa) this.dom.bh(aa.class)).gPx();
            ((aa) this.dom.bh(aa.class)).BR(Pvh);
            this.dom.cmy();
        }
        AppMethodBeat.o(35747);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(35748);
        onNotifyChange(0, null, null);
        AppMethodBeat.o(35748);
    }
}
