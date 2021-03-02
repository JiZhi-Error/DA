package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ba.f;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.e;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.ad;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;

@a(gRF = e.class)
public class d extends a implements e {
    @Override // com.tencent.mm.ui.chatting.d.b.e
    public final boolean bU(ca caVar) {
        AppMethodBeat.i(35130);
        if (caVar.gDl()) {
            if (!this.dom.getTalkerUserName().equals("medianote")) {
                bg.aVF();
                c.aSM().d(new f(caVar.field_talker, caVar.field_msgSvrId));
            }
            ak.bM(caVar);
            this.dom.BN(true);
            AppMethodBeat.o(35130);
            return true;
        }
        AppMethodBeat.o(35130);
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.e
    public final void gPg() {
        AppMethodBeat.i(35131);
        Intent intent = new Intent(this.dom.Pwc.getContext(), SelectContactUI.class);
        if (as.bjp(this.dom.getTalkerUserName()) || ab.Iy(this.dom.getTalkerUserName())) {
            intent.putExtra("list_attr", u.Q(u.PWW, 1, 16777216));
        } else {
            intent.putExtra("list_attr", u.Q(u.PWW, 1, 2048, 16777216));
        }
        intent.putExtra("list_type", 4);
        intent.putExtra("received_card_name", this.dom.getTalkerUserName());
        intent.putExtra("block_contact", this.dom.getTalkerUserName());
        intent.putExtra("Add_SendCard", true);
        intent.putExtra("titile", this.dom.Pwc.getMMResources().getString(R.string.g4));
        this.dom.Pwc.startActivityForResult(intent, TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM);
        AppMethodBeat.o(35131);
    }

    @Override // com.tencent.mm.ui.l
    public final void onActivityResult(int i2, int i3, Intent intent) {
        String string;
        AppMethodBeat.i(35132);
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM /*{ENCODED_INT: 223}*/:
                if (i3 == -1 && intent != null) {
                    final String stringExtra = intent.getStringExtra("be_send_card_name");
                    if (this.dom.gRM()) {
                        as.bjp(stringExtra);
                    }
                    String displayName = aa.getDisplayName(stringExtra);
                    final String stringExtra2 = intent.getStringExtra("received_card_name");
                    final boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                    o.a aVar = new o.a(this.dom.Pwc.getContext());
                    com.tencent.mm.aj.c.a(stringExtra, true, -1, null);
                    bg.aVF();
                    as bjJ = c.aSN().bjJ(stringExtra);
                    if (ab.rR(bjJ.field_verifyFlag)) {
                        string = this.dom.Pwc.getResources().getString(R.string.vq);
                    } else if (as.bjp(stringExtra)) {
                        string = SelectConversationUI.c(MMApplicationContext.getContext(), bjJ);
                    } else {
                        string = this.dom.Pwc.getResources().getString(R.string.vr);
                    }
                    aVar.ea(stringExtra2).beQ(new StringBuffer(string).append(displayName).toString()).p(Boolean.TRUE).aii(R.string.yq).a(new y.a() {
                        /* class com.tencent.mm.ui.chatting.d.d.AnonymousClass1 */

                        @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
                        public final void a(boolean z, String str, int i2) {
                            AppMethodBeat.i(35129);
                            d.this.dom.hideVKB();
                            if (z) {
                                g.eir().s(stringExtra, stringExtra2, booleanExtra);
                                g.eir().iF(str, stringExtra2);
                            }
                            AppMethodBeat.o(35129);
                        }
                    }).kdo.show();
                }
                AppMethodBeat.o(35132);
                return;
            case TbsListener.ErrorCode.EXCEED_INCR_UPDATE /*{ENCODED_INT: 224}*/:
                if (i3 == -1 && intent != null) {
                    String stringExtra3 = intent.getStringExtra("be_send_card_name");
                    String stringExtra4 = intent.getStringExtra("received_card_name");
                    String stringExtra5 = intent.getStringExtra("custom_send_text");
                    boolean booleanExtra2 = intent.getBooleanExtra("Is_Chatroom", false);
                    Intent intent2 = new Intent(this.dom.Pwc.getContext(), ChattingUI.class);
                    intent2.putExtra("Chat_User", stringExtra4);
                    intent2.putExtra("send_card_username", stringExtra3);
                    intent2.putExtra("send_card_edittext", stringExtra5);
                    intent2.putExtra("Is_Chatroom", booleanExtra2);
                    BaseChattingUIFragment baseChattingUIFragment = this.dom.Pwc;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                    com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, bl.axQ(), "com/tencent/mm/ui/chatting/component/CardComponent", "dealWithRequestCode", "(IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    baseChattingUIFragment.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, "com/tencent/mm/ui/chatting/component/CardComponent", "dealWithRequestCode", "(IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    break;
                }
        }
        AppMethodBeat.o(35132);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIk() {
        AppMethodBeat.i(35133);
        Intent intent = this.dom.Pwc.getContext().getIntent();
        String stringExtra = intent.getStringExtra("Chat_User");
        String stringExtra2 = intent.getStringExtra("send_card_username");
        if (!Util.isNullOrNil(stringExtra2)) {
            boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
            String stringExtra3 = intent.getStringExtra("send_card_edittext");
            if (booleanExtra) {
                String nullAs = Util.nullAs(stringExtra, "");
                String bnD = ad.bnD(stringExtra2);
                o.e Pl = com.tencent.mm.modelmulti.o.Pl(nullAs);
                Pl.toUser = nullAs;
                Pl.content = bnD;
                o.e tD = Pl.tD(as.bjp(stringExtra2) ? 66 : 42);
                tD.cSx = 0;
                tD.jdR = 4;
                tD.bdQ().execute();
            } else {
                ArrayList<String> stringsToList = Util.stringsToList(Util.nullAs(stringExtra, "").split(","));
                String bnD2 = ad.bnD(stringExtra2);
                for (int i2 = 0; i2 < stringsToList.size(); i2++) {
                    String str = stringsToList.get(i2);
                    o.e Pl2 = com.tencent.mm.modelmulti.o.Pl(str);
                    Pl2.toUser = str;
                    Pl2.content = bnD2;
                    o.e tD2 = Pl2.tD(as.bjp(stringExtra2) ? 66 : 42);
                    tD2.cSx = 0;
                    tD2.jdR = 4;
                    tD2.bdQ().execute();
                }
            }
            if (stringExtra3 != null) {
                g.eir().iF(stringExtra3, stringExtra);
            }
        }
        AppMethodBeat.o(35133);
    }
}
