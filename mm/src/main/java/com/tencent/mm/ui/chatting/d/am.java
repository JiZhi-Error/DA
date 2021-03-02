package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.plugin.appbrand.jsapi.k.g;
import com.tencent.mm.protocal.protobuf.crk;
import com.tencent.mm.protocal.protobuf.dmn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.AllRemindMsgUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.af;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.view.c;
import com.tencent.mm.ui.widget.snackbar.a;
import com.tencent.mm.ui.z;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.IOException;

@a(gRF = af.class)
public class am extends a implements i, af {
    static /* synthetic */ void a(am amVar, ca caVar) {
        AppMethodBeat.i(35499);
        amVar.bQ(caVar);
        AppMethodBeat.o(35499);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        AppMethodBeat.i(35493);
        bg.azz().a(525, this);
        AppMethodBeat.o(35493);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(35494);
        bg.azz().b(525, this);
        AppMethodBeat.o(35494);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(35495);
        super.gOK();
        bg.azz().b(525, this);
        AppMethodBeat.o(35495);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.af
    public final void h(MenuItem menuItem) {
        AppMethodBeat.i(35496);
        final ca amt = ((k) this.dom.bh(k.class)).amt(menuItem.getGroupId());
        if (amt == null) {
            Log.e("MicroMsg.ChattingUI.MsgRemindComponent", "context item select failed, null msg");
            AppMethodBeat.o(35496);
            return;
        }
        switch (menuItem.getItemId()) {
            case g.CTRL_INDEX:
                bg.aVF();
                if (!((Boolean) c.azQ().get(ar.a.USERINFO_POSITION_REMIND_MSG_TIP_IN_BOOLEAN, Boolean.TRUE)).booleanValue()) {
                    bQ(amt);
                    break;
                } else {
                    h.d(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(R.string.g1d), this.dom.Pwc.getMMResources().getString(R.string.g1e), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.d.am.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(35490);
                            am.a(am.this, amt);
                            AppMethodBeat.o(35490);
                        }
                    });
                    bg.aVF();
                    c.azQ().set(ar.a.USERINFO_POSITION_REMIND_MSG_TIP_IN_BOOLEAN, Boolean.FALSE);
                    AppMethodBeat.o(35496);
                    return;
                }
        }
        AppMethodBeat.o(35496);
    }

    private void bQ(final ca caVar) {
        AppMethodBeat.i(35497);
        final com.tencent.mm.ui.chatting.view.c cVar = new com.tencent.mm.ui.chatting.view.c(this.dom.Pwc.getContext());
        cVar.PGz = new c.a() {
            /* class com.tencent.mm.ui.chatting.d.am.AnonymousClass2 */

            @Override // com.tencent.mm.ui.chatting.view.c.a
            public final void Nt(long j2) {
                AppMethodBeat.i(35491);
                cVar.hide();
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(795, 1, 1, false);
                if (!NetUtil.isConnected(am.this.dom.Pwc.getContext())) {
                    h.c(am.this.dom.Pwc.getContext(), am.this.dom.Pwc.getMMResources().getString(R.string.fbd), am.this.dom.Pwc.getMMResources().getString(R.string.g1a), true);
                    AppMethodBeat.o(35491);
                    return;
                }
                dmn dmn = new dmn();
                dmn.rBX = (int) (j2 / 1000);
                dmn.oUv = 1;
                dmn.MJT = 1;
                try {
                    crk crk = new crk();
                    crk.UserName = am.this.dom.getTalkerUserName();
                    crk.Brn = caVar.field_msgSvrId;
                    crk.Title = am.b(am.this, caVar);
                    dmn.Lqr = new b(crk.toByteArray());
                } catch (IOException e2) {
                    Log.e("MicroMsg.ChattingUI.MsgRemindComponent", "[onOk] %s", e2.toString());
                }
                bg.azz().a(new z(1, dmn), 0);
                AppMethodBeat.o(35491);
            }

            @Override // com.tencent.mm.ui.chatting.view.c.a
            public final void onCancel() {
                AppMethodBeat.i(35492);
                cVar.hide();
                AppMethodBeat.o(35492);
            }
        };
        cVar.show();
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(795, 0, 1, false);
        AppMethodBeat.o(35497);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        AppMethodBeat.i(35498);
        Log.i("MicroMsg.ChattingUI.MsgRemindComponent", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str + " sceneType:" + qVar.getType());
        this.dom.dismissDialog();
        if (!this.dom.cQp) {
            Log.i("MicroMsg.ChattingUI.MsgRemindComponent", "onSceneEnd fragment not foreground, return");
            AppMethodBeat.o(35498);
        } else if (!Util.isTopActivity(this.dom.Pwc.getContext())) {
            AppMethodBeat.o(35498);
        } else {
            Activity context = this.dom.Pwc.getContext();
            if (z.a.a(context, i2, i3, str, 7)) {
                z = true;
            } else if (com.tencent.mm.plugin.account.ui.a.a(context, i2, i3, new Intent().setClass(context, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(35498);
            } else if (i2 == 0 && i3 == 0) {
                switch (qVar.getType()) {
                    case 525:
                        Log.i("MicroMsg.ChattingUI.MsgRemindComponent", "set msg remind!");
                        com.tencent.mm.ui.widget.snackbar.b.a(this.dom.Pwc.getContext(), this.dom.Pwc.getContentView(), this.dom.Pwc.getMMResources().getString(R.string.dzm), "", (a.b) null);
                        AppMethodBeat.o(35498);
                        return;
                    default:
                        AppMethodBeat.o(35498);
                        return;
                }
            } else {
                if (qVar.getType() == 525) {
                    Log.e("MicroMsg.ChattingUI.MsgRemindComponent", "[setMsgRemind] scene type:%s errCode:%s, errType:%s, errMsg:%s", 525, Integer.valueOf(i3), Integer.valueOf(i2), Util.nullAsNil(str));
                    Activity context2 = this.dom.Pwc.getContext();
                    if (Util.isNullOrNil(str)) {
                        str = this.dom.Pwc.getMMResources().getString(R.string.g1_);
                    }
                    h.c(context2, str, this.dom.Pwc.getMMResources().getString(R.string.g1a), true);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(795, 4, 1, false);
                }
                AppMethodBeat.o(35498);
            }
        }
    }

    static /* synthetic */ String b(am amVar, ca caVar) {
        k.b aD;
        AppMethodBeat.i(35500);
        if (caVar.isText() || caVar.gDq()) {
            String str = caVar.field_content;
            int Kp = bp.Kp(str);
            if (Kp != -1) {
                str = str.substring(Kp + 1).trim();
            }
            AppMethodBeat.o(35500);
            return str;
        }
        if (caVar.gDx() || caVar.gDy()) {
            String str2 = caVar.field_content;
            int indexOf = caVar.field_content.indexOf(58);
            if (indexOf != -1) {
                str2 = caVar.field_content.substring(indexOf + 1);
            }
            if (!(str2 == null || (aD = k.b.aD(str2, caVar.field_reserved)) == null || (aD.type != 53 && aD.type != 57))) {
                String str3 = aD.title;
                AppMethodBeat.o(35500);
                return str3;
            }
        }
        Activity context = amVar.dom.Pwc.getContext();
        int type = caVar.getType();
        String str4 = caVar.field_content;
        amVar.dom.getTalkerUserName();
        String a2 = AllRemindMsgUI.a(context, type, str4, caVar.field_isSend);
        Log.i("MicroMsg.ChattingUI.MsgRemindComponent", "[getRemindTitle] msgId:%s type:%s title:%s", Long.valueOf(caVar.field_msgId), Integer.valueOf(caVar.getType()), a2);
        AppMethodBeat.o(35500);
        return a2;
    }
}
