package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.d.b.e;
import com.tencent.mm.ui.chatting.k;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.Map;

public final class am {

    public static class c extends c implements t.n {
        private String PMA;
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || (i2 != 42 && i2 != 66)) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37183);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.t9);
                view.setTag(new a().G(view, false));
            }
            AppMethodBeat.o(37183);
            return view;
        }

        /* JADX WARNING: Removed duplicated region for block: B:35:0x00eb  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0133  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x018e  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x019f  */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a r11, int r12, com.tencent.mm.ui.chatting.e.a r13, com.tencent.mm.storage.ca r14, java.lang.String r15) {
            /*
            // Method dump skipped, instructions count: 431
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.am.c.a(com.tencent.mm.ui.chatting.viewitems.c$a, int, com.tencent.mm.ui.chatting.e.a, com.tencent.mm.storage.ca, java.lang.String):void");
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233823);
            int i2 = ((bq) view.getTag()).position;
            bg.aVF();
            ca.a aEK = com.tencent.mm.model.c.aSQ().aEK(caVar.field_content);
            if (aEK.dkU == null || aEK.dkU.length() <= 0) {
                Log.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
            }
            this.PMA = aEK.dkU;
            boolean rR = ab.rR(aEK.IOs);
            if (((((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_forward_card, 0) == 1) && caVar.getType() != 66 && !as.bjp(this.PhN.getTalkerUserName()) && !as.bjq(this.PhN.getTalkerUserName())) || rR) {
                mVar.a(i2, 118, view.getContext().getString(R.string.g5c), R.raw.icons_filled_share);
            }
            if (!caVar.gAt() && ((caVar.field_status == 2 || caVar.fQV == 1) && caVar.gDl() && b(caVar, this.PhN) && bnf(caVar.field_talker))) {
                mVar.a(i2, 123, view.getContext().getString(R.string.b0i), R.raw.icons_filled_previous);
            }
            if (!this.PhN.gRN()) {
                mVar.a(i2, 100, view.getContext().getString(R.string.b06), R.raw.icons_filled_delete);
            }
            AppMethodBeat.o(233823);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37186);
            switch (menuItem.getItemId()) {
                case 118:
                    Activity context = aVar.Pwc.getContext();
                    if (!k.bs(caVar)) {
                        if (!k.bt(caVar)) {
                            Intent intent = new Intent(aVar.Pwc.getContext(), MsgRetransmitUI.class);
                            intent.putExtra("Retr_Msg_content", bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend));
                            intent.putExtra("Retr_Msg_Type", 8);
                            intent.putExtra("Retr_Msg_Id", caVar.field_msgId);
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            aVar.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(37186);
                            break;
                        } else {
                            h.a(context, context.getString(R.string.dgx), "", context.getString(R.string.j34), (DialogInterface.OnClickListener) null);
                            AppMethodBeat.o(37186);
                            break;
                        }
                    } else {
                        h.a(context, context.getString(R.string.dgw), "", context.getString(R.string.j34), (DialogInterface.OnClickListener) null);
                        AppMethodBeat.o(37186);
                        break;
                    }
                default:
                    AppMethodBeat.o(37186);
                    break;
            }
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37187);
            ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
            bq bqVar = (bq) view.getTag();
            am.a(aVar, bqVar.userName, caVar.field_content, bqVar.Pdm, caVar.field_isSend == 0, caVar);
            AppMethodBeat.o(37187);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.t.n
        public final void b(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233824);
            caVar.unsetOmittedFailResend();
            bg.aVF();
            com.tencent.mm.model.c.aSQ().a(caVar.field_msgId, caVar);
            ((e) aVar.bh(e.class)).bU(caVar);
            AppMethodBeat.o(233824);
        }
    }

    public static class b extends c {
        private String PMA;
        private String PMB;
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || (i2 != 42 && i2 != 66)) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37177);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.rv);
                view.setTag(new a().G(view, true));
            }
            AppMethodBeat.o(37177);
            return view;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean b(com.tencent.mm.ui.chatting.e.a aVar) {
            AppMethodBeat.i(37178);
            boolean gRM = aVar.gRM();
            AppMethodBeat.o(37178);
            return gRM;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            String str2;
            boolean z;
            String str3;
            AppMethodBeat.i(37179);
            this.PhN = aVar2;
            a aVar3 = (a) aVar;
            if (aVar2.gRM()) {
                str2 = bp.Kt(caVar.field_content);
            } else {
                str2 = caVar.field_content;
            }
            bg.aVF();
            ca.a aEK = com.tencent.mm.model.c.aSQ().aEK(str2);
            if (aEK.dkU == null || aEK.dkU.length() <= 0) {
                Log.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
            }
            this.PMA = aEK.dkU;
            this.PMB = "";
            if (!af.isNullOrNil(str2)) {
                Map<String, String> parseXml = XmlParser.parseXml(str2, "msg", null);
                if (parseXml == null) {
                    Log.e("MicroMsg.ChattingItemCardFrom", "null==attrs");
                }
                if (parseXml != null && parseXml.containsKey(".msg.$wechatid")) {
                    this.PMB = parseXml.get(".msg.$wechatid");
                }
            }
            com.tencent.mm.aj.c.ap(this.PMA, aEK.OqJ);
            aVar3.resetChatBubbleWidth(aVar3.clickArea, aVar3.PJa);
            if (ab.rR(aEK.IOs)) {
                aVar3.PKu.setText(R.string.axn);
                aVar3.PKv.setVisibility(8);
                if (d.oD(16)) {
                    aVar3.PKt.setBackground(null);
                } else {
                    aVar3.PKt.setBackgroundDrawable(null);
                }
                E(aVar3.PKt, this.PMA);
            } else {
                aVar3.PKu.setText(R.string.b1_);
                aVar3.PKt.setBackgroundResource(R.drawable.bca);
                D(aVar3.PKt, this.PMA);
            }
            String str4 = this.PMB;
            if (af.isNullOrNil(str4) || as.bjx(str4) || ab.IR(str4)) {
                z = true;
            } else {
                z = false;
            }
            boolean rR = ab.rR(aEK.IOs);
            if (z || rR) {
                str3 = "";
            } else {
                str3 = str4;
            }
            if (!af.isNullOrNil(str3)) {
                aVar3.PKv.setVisibility(0);
                aVar3.PKv.setText(str3);
            } else {
                aVar3.PKv.setVisibility(8);
            }
            aVar3.gvw.setText(l.e((Context) aVar2.Pwc.getContext(), (CharSequence) aEK.nickname, (int) aVar3.gvw.getTextSize()));
            am.a(aVar2, this.PMA, aEK, aVar3);
            aVar3.clickArea.setTag(new bq(caVar, aVar2.gRM(), i2, str, (char) 0));
            aVar3.clickArea.setOnClickListener(d(aVar2));
            aVar3.clickArea.setOnLongClickListener(c(aVar2));
            aVar3.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
            AppMethodBeat.o(37179);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233822);
            int i2 = ((bq) view.getTag()).position;
            bg.aVF();
            ca.a aEK = com.tencent.mm.model.c.aSQ().aEK(caVar.field_content);
            if (aEK.dkU == null || aEK.dkU.length() <= 0) {
                Log.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
            }
            this.PMA = aEK.dkU;
            boolean rR = ab.rR(aEK.IOs);
            if (((((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_forward_card, 0) == 1) && caVar.getType() != 66 && !as.bjp(this.PhN.getTalkerUserName()) && !as.bjq(this.PhN.getTalkerUserName())) || rR) {
                mVar.a(i2, 118, view.getContext().getString(R.string.g5c), R.raw.icons_filled_share);
            }
            if (!this.PhN.gRN()) {
                mVar.a(i2, 100, view.getContext().getString(R.string.b06), R.raw.icons_filled_delete);
            }
            AppMethodBeat.o(233822);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37181);
            switch (menuItem.getItemId()) {
                case 118:
                    Activity context = aVar.Pwc.getContext();
                    bg.aVF();
                    if (ab.rR(com.tencent.mm.model.c.aSQ().aEK(caVar.field_content).IOs) && !WeChatBrands.Business.Entries.SessionOa.checkAvailable(context)) {
                        AppMethodBeat.o(37181);
                        return true;
                    } else if (k.bs(caVar)) {
                        h.a(context, context.getString(R.string.dgw), "", context.getString(R.string.j34), (DialogInterface.OnClickListener) null);
                        AppMethodBeat.o(37181);
                        return false;
                    } else if (k.bt(caVar)) {
                        h.a(context, context.getString(R.string.dgx), "", context.getString(R.string.j34), (DialogInterface.OnClickListener) null);
                        AppMethodBeat.o(37181);
                        return false;
                    } else {
                        Intent intent = new Intent(aVar.Pwc.getContext(), MsgRetransmitUI.class);
                        intent.putExtra("Retr_Msg_content", bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend));
                        intent.putExtra("Retr_Msg_Type", 8);
                        intent.putExtra("Retr_Msg_Id", caVar.field_msgId);
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        aVar.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(37181);
                        return false;
                    }
                default:
                    AppMethodBeat.o(37181);
                    return false;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37182);
            ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
            bq bqVar = (bq) view.getTag();
            am.a(aVar, bqVar.userName, caVar.field_content, bqVar.Pdm, caVar.field_isSend == 0, caVar);
            AppMethodBeat.o(37182);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a extends c.a {
        ImageView PIn;
        public int PJa;
        ImageView PKt;
        TextView PKu;
        TextView PKv;
        TextView gvw;

        a() {
        }

        public final c.a G(View view, boolean z) {
            AppMethodBeat.i(37176);
            super.create(view);
            this.PKt = (ImageView) view.findViewById(R.id.au3);
            this.timeTV = (TextView) view.findViewById(R.id.ayf);
            this.PKu = (TextView) view.findViewById(R.id.ayj);
            this.PKv = (TextView) view.findViewById(R.id.ayo);
            this.gvw = (TextView) view.findViewById(R.id.axm);
            this.userTV = (TextView) view.findViewById(R.id.ayn);
            this.clickArea = view.findViewById(R.id.auf);
            this.checkBox = (CheckBox) view.findViewById(R.id.aue);
            this.maskView = view.findViewById(R.id.ax3);
            if (!z) {
                this.stateIV = (ImageView) view.findViewById(R.id.ayb);
                this.PIn = (ImageView) view.findViewById(R.id.ayd);
                this.uploadingPB = (ProgressBar) view.findViewById(R.id.j0y);
            }
            this.PJa = c.kl(MMApplicationContext.getContext());
            AppMethodBeat.o(37176);
            return this;
        }
    }

    public static void a(com.tencent.mm.ui.chatting.e.a aVar, String str, ca.a aVar2, a aVar3) {
        CharSequence charSequence;
        AppMethodBeat.i(37189);
        if (!as.bjp(str)) {
            AppMethodBeat.o(37189);
            return;
        }
        String a2 = ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).a(aVar2.OqO, "openim_card_type_name", a.EnumC0497a.TYPE_WORDING);
        if (TextUtils.isEmpty(a2)) {
            aVar3.PKu.setText(R.string.b1_);
        } else {
            aVar3.PKu.setText(a2);
        }
        aVar3.PKt.setBackgroundResource(R.drawable.bca);
        c.D(aVar3.PKt, str);
        String str2 = aVar2.OqQ;
        String str3 = aVar2.OqP;
        if (!af.isNullOrNil(str2)) {
            charSequence = ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).a(aVar.Pwc.getContext(), str2, str3, aVar3.PKv.getTextSize());
        } else {
            charSequence = str3;
        }
        if (!TextUtils.isEmpty(charSequence)) {
            aVar3.PKv.setVisibility(0);
            aVar3.PKv.setText(charSequence);
            AppMethodBeat.o(37189);
            return;
        }
        aVar3.PKv.setVisibility(8);
        AppMethodBeat.o(37189);
    }

    public static void a(com.tencent.mm.ui.chatting.e.a aVar, String str, String str2, boolean z, boolean z2, ca caVar) {
        String str3;
        int i2;
        int i3;
        AppMethodBeat.i(37190);
        Log.i("MicroMsg.ChattingItemCard", "dealClickCardMsgEvent, fromUser:%s, groupChat:%s, recv:%s, msgType:%s,msgContent:%s", str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(caVar.getType()), str2);
        if (z && z2) {
            str2 = bp.Kt(str2);
        }
        bg.aVF();
        ca.a aEK = com.tencent.mm.model.c.aSQ().aEK(str2);
        if (aEK == null) {
            AppMethodBeat.o(37190);
            return;
        }
        String str4 = aEK.dkU;
        if ((as.bjp(str4) || ab.Iy(str4)) && !WeChatBrands.Business.Entries.GlobalWeCom.checkAvailable(aVar.Pwc.getContext())) {
            AppMethodBeat.o(37190);
            return;
        }
        Intent intent = new Intent();
        if (!ab.rR(aEK.IOs)) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1430, 0);
            bg.aVF();
            as Kn = com.tencent.mm.model.c.aSN().Kn(str4);
            if (Kn == null || !com.tencent.mm.contact.c.oR(Kn.field_type)) {
                bg.aVF();
                bq aEo = com.tencent.mm.model.c.aSP().aEo(str4);
                if (aEo == null || af.isNullOrNil(aEo.field_username)) {
                    if (aEo == null || af.isNullOrNil(aEo.field_encryptUsername)) {
                        bq bqVar = new bq(str4);
                        bqVar.field_modifyTime = System.currentTimeMillis();
                        bg.aVF();
                        if (!com.tencent.mm.model.c.aSP().replace(bqVar)) {
                            Log.e("MicroMsg.ChattingItemCard", "add friendUser fail, encryptUsername:%s", str4);
                        }
                    }
                    intent.putExtra("force_get_contact", true);
                    Log.i("MicroMsg.ChattingItemCard", "need to get contact to judge if Friend, KForceGetContact is true");
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1430, 3);
                    str3 = str4;
                } else {
                    str3 = aEo.field_username;
                    Log.i("MicroMsg.ChattingItemCard", "find in FriendUser Map, friend:%s", Kn.field_username);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1430, 2);
                }
            } else {
                str3 = Kn.field_username;
                Log.i("MicroMsg.ChattingItemCard", "find in contact, friend:%s", Kn.field_username);
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1430, 1);
            }
        } else if (!WeChatBrands.Business.Entries.SessionOa.checkAvailable(aVar.Pwc.getContext())) {
            AppMethodBeat.o(37190);
            return;
        } else {
            bg.aVF();
            as Kn2 = com.tencent.mm.model.c.aSN().Kn(str4);
            if (Kn2 != null && ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt()) {
                int fvo = ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).fvo();
                if (fvo == 0 && !com.tencent.mm.contact.c.oR(Kn2.field_type)) {
                    ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(aVar.Pwc.getContext());
                    q qVar = (q) g.af(q.class);
                    if (z) {
                        i3 = 2;
                    } else {
                        i3 = 1;
                    }
                    qVar.d(i3, str4, aEK.nickname);
                    AppMethodBeat.o(37190);
                    return;
                } else if (fvo == 2) {
                    ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(aVar.Pwc.getContext());
                    q qVar2 = (q) g.af(q.class);
                    if (z) {
                        i2 = 2;
                    } else {
                        i2 = 1;
                    }
                    qVar2.d(i2, str4, aEK.nickname);
                    AppMethodBeat.o(37190);
                    return;
                }
            }
            str3 = str4;
        }
        intent.putExtra("Contact_User", str3);
        intent.putExtra("Contact_Alias", aEK.fMb);
        intent.putExtra("Contact_Nick", aEK.nickname);
        intent.putExtra("Contact_QuanPin", aEK.kfR);
        intent.putExtra("Contact_PyInitial", aEK.kfQ);
        intent.putExtra("Contact_Uin", aEK.Bge);
        intent.putExtra("Contact_Mobile_MD5", aEK.OqK);
        intent.putExtra("Contact_full_Mobile_MD5", aEK.OqL);
        intent.putExtra("Contact_QQNick", aEK.gDZ());
        intent.putExtra("User_From_Fmessage", false);
        intent.putExtra("Contact_Scene", aEK.scene);
        intent.putExtra("Contact_FMessageCard", true);
        intent.putExtra("Contact_RemarkName", aEK.kfV);
        intent.putExtra("Contact_VUser_Info_Flag", aEK.IOs);
        intent.putExtra("Contact_VUser_Info", aEK.fuN);
        intent.putExtra("Contact_BrandIconURL", aEK.BdC);
        intent.putExtra("Contact_Province", aEK.getProvince());
        intent.putExtra("Contact_City", aEK.getCity());
        intent.putExtra("Contact_Sex", aEK.fuA);
        intent.putExtra("Contact_Signature", aEK.signature);
        intent.putExtra("Contact_ShowUserName", true);
        intent.putExtra("Contact_KSnsIFlag", 0);
        intent.putExtra("Contact_Source_FMessage", 17);
        intent.putExtra("source_from_user_name", str);
        intent.putExtra("source_from_nick_name", aa.Ir(str));
        intent.putExtra(e.d.OyT, aEK.Kpf);
        intent.putExtra("key_add_contact_openim_appid", aEK.OqO);
        intent.putExtra("key_add_contact_custom_detail", aEK.OqR);
        intent.putExtra("key_forward_flag", caVar.gDD());
        intent.putExtra("key_msg_id", caVar.field_msgId);
        if ((aEK.IOs & 8) > 0) {
            if (!af.isNullOrNil(str)) {
                bg.aVF();
                if (com.tencent.mm.model.c.aSN().Kn(str).gBM()) {
                    intent.putExtra("Contact_Scene", 41);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10298, aEK.dkU + ",41");
                }
            }
            intent.putExtra("Contact_Scene", 17);
            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10298, aEK.dkU + ",17");
        }
        if (as.bjp(aEK.dkU) && aEK.scene == 0) {
            intent.putExtra("Contact_Scene", 17);
        }
        if (ab.rR(aEK.IOs)) {
            if (aVar.gRM()) {
                intent.putExtra("preChatTYPE", 2);
            } else {
                intent.putExtra("preChatTYPE", 1);
            }
            intent.putExtra("prePublishId", "msg_" + caVar.field_msgSvrId);
            if (af.isNullOrNil(str)) {
                str = z.aTY();
            }
            intent.putExtra("preUsername", str);
            intent.putExtra("preChatName", caVar.field_talker);
        }
        com.tencent.mm.br.c.b(aVar.Pwc.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        com.tencent.mm.bs.a.aiT(aEK.scene);
        AppMethodBeat.o(37190);
    }
}
