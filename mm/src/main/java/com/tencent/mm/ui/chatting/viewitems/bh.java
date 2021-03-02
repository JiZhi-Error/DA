package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.subapp.d.e;
import com.tencent.mm.plugin.subapp.d.h;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.d.b.aw;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsListener;

public final class bh extends c {
    private a PhN;
    private i onSceneEndCallback;

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean gTT() {
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean bM(int i2, boolean z) {
        if (i2 == -1879048190) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final View a(LayoutInflater layoutInflater, View view) {
        AppMethodBeat.i(37506);
        if (view == null || view.getTag() == null) {
            view = new an(layoutInflater, R.layout.tq);
            view.setTag(new bx().hj(view));
        }
        AppMethodBeat.o(37506);
        return view;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final String a(a aVar, ca caVar) {
        AppMethodBeat.i(37507);
        String talkerUserName = aVar.getTalkerUserName();
        AppMethodBeat.o(37507);
        return talkerUserName;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean b(a aVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final void a(c.a aVar, final int i2, a aVar2, final ca caVar, String str) {
        boolean z;
        AppMethodBeat.i(37508);
        bx bxVar = (bx) aVar;
        this.PhN = aVar2;
        k GL = ao.gnf().GL(caVar.field_msgId);
        String str2 = caVar.field_content;
        k.b bVar = null;
        if (!(GL == null || str2 == null)) {
            bVar = k.b.aD(str2, caVar.field_reserved);
        }
        e aSK = e.aSK(str2);
        if (!(aSK == null || aSK.FJX == 0)) {
            try {
                String az = f.az(aVar2.Pwc.getContext(), aSK.FJX);
                String str3 = "";
                if (az != null && az.length() > 0) {
                    String[] split = az.split(";");
                    str3 = str3 + split[0].replace(" ", "");
                    if (split.length > 1) {
                        str3 = str3 + split[1];
                    }
                }
                if (!(bVar == null || bVar.description == null)) {
                    str3 = str3 + " " + bVar.description;
                }
                bxVar.jBR.setText(str3);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindRemind", e2, "", new Object[0]);
            }
        }
        Log.d("MicroMsg.ChattingItemVoiceRemindRemind", "content remind " + caVar.field_content);
        if (Util.isNullOrNil(caVar.field_imgPath) && aSK.FKd > 0) {
            bg.aVF();
            ca aJ = com.tencent.mm.model.c.aSQ().aJ(caVar.field_talker, (long) aSK.FKd);
            if (!Util.isNullOrNil(aJ.field_imgPath)) {
                String Qv = com.tencent.mm.plugin.subapp.d.k.Qv(z.aTY());
                if (s.nw(h.cz(aJ.field_imgPath, false), h.cz(Qv, false)) >= 0) {
                    caVar.Cz(Qv);
                    bg.aVF();
                    com.tencent.mm.model.c.aSQ().a(caVar.field_msgId, caVar);
                }
            }
        }
        if (Util.isNullOrNil(caVar.field_imgPath) && aSK != null && aSK.dCK != null && aSK.dCK.length() > 0 && aSK.iwI > 0 && this.onSceneEndCallback == null) {
            String Qv2 = com.tencent.mm.plugin.subapp.d.k.Qv(z.aTY());
            String cz = h.cz(Qv2, false);
            if (Util.isNullOrNil(caVar.field_imgPath)) {
                caVar.Cz(Qv2);
                bg.aVF();
                com.tencent.mm.model.c.aSQ().a(caVar.field_msgId, caVar);
                Log.d("MicroMsg.ChattingItemVoiceRemindRemind", "content.attachid " + bVar.dCK);
                com.tencent.mm.pluginsdk.model.app.c a2 = m.a(cz, caVar.field_msgId, bVar.sdkVer, bVar.appId, bVar.dCK, bVar.iwI);
                Log.d("MicroMsg.ChattingItemVoiceRemindRemind", "ainfo.field_mediaSvrId " + a2.field_mediaSvrId);
                if (a2.field_mediaSvrId != null) {
                    t azz = bg.azz();
                    AnonymousClass1 r3 = new i() {
                        /* class com.tencent.mm.ui.chatting.viewitems.bh.AnonymousClass1 */

                        @Override // com.tencent.mm.ak.i
                        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                            AppMethodBeat.i(37504);
                            Log.d("MicroMsg.ChattingItemVoiceRemindRemind", "errType " + i2 + " errCode " + i3 + "  scene " + qVar.getType());
                            bg.azz().b(TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, bh.this.onSceneEndCallback);
                            bh.this.onSceneEndCallback = null;
                            AppMethodBeat.o(37504);
                        }
                    };
                    this.onSceneEndCallback = r3;
                    azz.a(TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, r3);
                    Log.d("MicroMsg.ChattingItemVoiceRemindRemind", "doscene");
                    bg.azz().a(new com.tencent.mm.plugin.record.b.f(a2), 0);
                }
            }
        }
        bxVar.PRJ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.viewitems.bh.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(37505);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (Util.isNullOrNil(caVar.field_imgPath)) {
                    Log.d("MicroMsg.ChattingItemVoiceRemindRemind", "filename is null");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(37505);
                    return;
                }
                d gRx = ((aw) bh.this.PhN.bh(aw.class)).gRx();
                int i2 = i2;
                ca caVar = caVar;
                if (caVar != null) {
                    gRx.gMO();
                    bg.aVF();
                    Boolean bool = (Boolean) com.tencent.mm.model.c.azQ().get(4115, (Object) null);
                    if (bool == null || !bool.booleanValue()) {
                        bg.aVF();
                        com.tencent.mm.model.c.azQ().set(4115, Boolean.TRUE);
                        gRx.gMU();
                        gRx.Pel = u.a(gRx.dom.Pwc.getActivity(), gRx.context.getString(R.string.b14), 4000);
                    }
                    if (!gRx.qUl.isPlaying() || caVar.field_msgId != gRx.Pei) {
                        gRx.bf(caVar);
                        if (caVar.field_isSend == 0 && !com.tencent.mm.modelvoice.s.ai(caVar)) {
                            gRx.ama(i2 + 1);
                        }
                        gRx.BK(true);
                    } else {
                        gRx.gMT();
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37505);
            }
        });
        long j2 = caVar.field_msgId;
        d gRx = ((aw) this.PhN.bh(aw.class)).gRx();
        if (!gRx.isPlaying() || gRx.Pei != j2) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            bxVar.PRJ.setImageResource(R.drawable.alq);
        } else {
            bxVar.PRJ.setImageResource(R.drawable.am5);
        }
        bxVar.clickArea.setTag(new bq(caVar, aVar2.gRM(), i2, (String) null, (char) 0));
        bg.aVF();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            bxVar.clickArea.setOnLongClickListener(c(aVar2));
        }
        AppMethodBeat.o(37508);
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
        AppMethodBeat.i(233969);
        int i2 = ((bq) view.getTag()).position;
        int bdI = m.bdI(bp.b(this.PhN.gRM(), caVar.field_content, caVar.field_isSend));
        k.b HD = k.b.HD(bp.b(this.PhN.gRM(), caVar.field_content, caVar.field_isSend));
        if (HD.iwI <= 0 || (HD.iwI > 0 && bdI >= 100)) {
            mVar.a(i2, 111, this.PhN.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
        }
        if (!this.PhN.gRN()) {
            mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
        }
        AppMethodBeat.o(233969);
        return true;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean a(MenuItem menuItem, a aVar, ca caVar) {
        AppMethodBeat.i(37510);
        switch (menuItem.getItemId()) {
            case 111:
                Intent intent = new Intent(aVar.Pwc.getContext(), MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_content", bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend));
                intent.putExtra("Retr_Msg_Type", 2);
                intent.putExtra("Retr_Msg_Id", caVar.field_msgId);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                aVar.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(37510);
                break;
            default:
                AppMethodBeat.o(37510);
                break;
        }
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean c(View view, a aVar, ca caVar) {
        return true;
    }
}
