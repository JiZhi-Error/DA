package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.m;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class ag {

    public static class b extends c {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || i2 != 16777265) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37059);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.rs);
                view.setTag(new a().ha(view));
            }
            AppMethodBeat.o(37059);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            int indexOf;
            AppMethodBeat.i(37060);
            this.PhN = aVar2;
            ((m) aVar2.bh(m.class)).bZ(caVar);
            a aVar3 = (a) aVar;
            String str2 = caVar.field_content;
            if (aVar2.gRM() && (indexOf = caVar.field_content.indexOf(58)) != -1) {
                str2 = caVar.field_content.substring(indexOf + 1);
            }
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            } else {
                bVar = null;
            }
            if (bVar != null && bVar.type == 1) {
                g o = h.o(bVar.appId, true, false);
                String str3 = (o == null || o.field_appName == null || o.field_appName.trim().length() <= 0) ? bVar.appName : o.field_appName;
                if (bVar.appId == null || bVar.appId.length() <= 0 || !h.gp(str3)) {
                    aVar3.tln.setVisibility(8);
                } else {
                    aVar3.tln.setText(aVar2.Pwc.getMMResources().getString(R.string.b2s, h.a(aVar2.Pwc.getContext(), o, str3)));
                    aVar3.tln.setVisibility(0);
                    a(aVar2, (View) aVar3.tln, bVar.appId);
                    a(aVar2, aVar3.tln, bVar.appId);
                }
                if (bVar.fQR == null || bVar.fQR.length() <= 0) {
                    aVar3.PHZ.setVisibility(8);
                } else {
                    b(aVar2, aVar3.PHZ, bq.bnn(bVar.fQR));
                    aVar3.PHZ.setVisibility(0);
                }
                aVar3.PKD.setClickable(true);
                aVar3.PKD.aw(l.a(aVar3.PKD.getContext(), bVar.title, (int) aVar3.PKD.getTextSize(), 1));
            }
            aVar3.PKD.setTag(new bq(caVar, aVar2.gRM(), i2, (String) null, (char) 0));
            bg.aVF();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                aVar3.PKD.setOnLongClickListener(c(aVar2));
                if (bVar != null && bVar.type == 1) {
                    aVar3.PKD.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
                }
            }
            AppMethodBeat.o(37060);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            AppMethodBeat.i(233804);
            int i2 = ((bq) view.getTag()).position;
            mVar.a(i2, 102, this.PhN.Pwc.getMMResources().getString(R.string.b03), R.raw.icons_filled_copy);
            mVar.a(i2, 111, this.PhN.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
            if (com.tencent.mm.br.c.aZU("favorite")) {
                mVar.a(i2, 116, this.PhN.Pwc.getMMResources().getString(R.string.fn9), R.raw.icons_filled_favorites);
            }
            if (br.B(caVar)) {
                mVar.clear();
            }
            if (!this.PhN.gRN()) {
                mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
            }
            AppMethodBeat.o(233804);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, final com.tencent.mm.ui.chatting.e.a aVar, final ca caVar) {
            AppMethodBeat.i(37062);
            switch (menuItem.getItemId()) {
                case 102:
                    String str = k.b.HD(bp.b(aVar.gRL(), caVar.field_content, caVar.field_isSend)).title;
                    ClipboardHelper.setText(str);
                    com.tencent.mm.plugin.secinforeport.a.a aVar2 = com.tencent.mm.plugin.secinforeport.a.a.INSTANCE;
                    com.tencent.mm.plugin.secinforeport.a.a.q(1, new StringBuilder().append(caVar.field_msgSvrId).toString(), Util.getUTF8ByteLength(str));
                    AppMethodBeat.o(37062);
                    break;
                case 111:
                    final String N = br.N(caVar);
                    if (Util.isNullOrNil(N)) {
                        Intent intent = new Intent(aVar.Pwc.getContext(), MsgRetransmitUI.class);
                        intent.putExtra("Retr_Msg_content", bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend));
                        intent.putExtra("Retr_Msg_Type", 2);
                        intent.putExtra("Retr_Msg_Id", caVar.field_msgId);
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        aVar.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    } else {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(17509, 3, N);
                        com.tencent.mm.ui.base.h.a((Context) aVar.Pwc.getContext(), (int) R.string.gh9, (int) R.string.gh_, (int) R.string.zx, (int) R.string.b20, true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.viewitems.ag.b.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(37057);
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", N);
                                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(17509, 1, N);
                                AppMethodBeat.o(37057);
                            }
                        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.viewitems.ag.b.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(37058);
                                Intent intent = new Intent(aVar.Pwc.getContext(), MsgRetransmitUI.class);
                                intent.putExtra("Retr_Msg_content", bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend));
                                intent.putExtra("Retr_Msg_Type", 2);
                                intent.putExtra("Retr_Msg_Id", caVar.field_msgId);
                                com.tencent.mm.ui.chatting.e.a aVar = aVar;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextFrom$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                aVar.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextFrom$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(17509, 2, N);
                                AppMethodBeat.o(37058);
                            }
                        });
                    }
                    AppMethodBeat.o(37062);
                    break;
                default:
                    AppMethodBeat.o(37062);
                    break;
            }
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }
    }

    public static class c extends c implements t.n {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != 16777265) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37063);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.t6);
                view.setTag(new a().ha(view));
            }
            AppMethodBeat.o(37063);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            AppMethodBeat.i(37064);
            a aVar3 = (a) aVar;
            this.PhN = aVar2;
            ((m) aVar2.bh(m.class)).bZ(caVar);
            String str2 = caVar.field_content;
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            } else {
                bVar = null;
            }
            if (bVar != null && bVar.type == 1) {
                aVar3.PKD.aw(l.a(aVar3.PKD.getContext(), bVar.title, (int) aVar3.PKD.getTextSize(), 4));
                aVar3.PKD.setClickable(true);
                g o = h.o(bVar.appId, true, false);
                String str3 = (o == null || o.field_appName == null || o.field_appName.trim().length() <= 0) ? bVar.appName : o.field_appName;
                if (bVar.appId == null || bVar.appId.length() <= 0 || !h.gp(str3)) {
                    aVar3.tln.setVisibility(8);
                } else {
                    aVar3.tln.setText(aVar2.Pwc.getMMResources().getString(R.string.b2s, h.a(aVar2.Pwc.getContext(), o, str3)));
                    aVar3.tln.setVisibility(0);
                    a(aVar2, (View) aVar3.tln, bVar.appId);
                    a(aVar2, aVar3.tln, bVar.appId);
                }
                if (caVar.field_status == 2 || caVar.field_status == 5) {
                    b((c.a) aVar3, false);
                } else {
                    b((c.a) aVar3, true);
                }
                a(i2, aVar3, caVar, aVar2.gRI(), aVar2.gRM(), aVar2, this);
            }
            aVar3.PKD.setTag(new bq(caVar, aVar2.gRM(), i2, (String) null, (char) 0));
            bg.aVF();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                aVar3.PKD.setOnLongClickListener(c(aVar2));
                if (bVar != null && bVar.type == 1) {
                    aVar3.PKD.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
                }
            }
            AppMethodBeat.o(37064);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            AppMethodBeat.i(233805);
            int i2 = ((bq) view.getTag()).position;
            mVar.a(i2, 102, this.PhN.Pwc.getMMResources().getString(R.string.b03), R.raw.icons_filled_copy);
            mVar.a(i2, 111, this.PhN.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
            if (com.tencent.mm.br.c.aZU("favorite")) {
                mVar.a(i2, 116, this.PhN.Pwc.getMMResources().getString(R.string.fn9), R.raw.icons_filled_favorites);
            }
            if (!caVar.gAt() && ((caVar.field_status == 2 || caVar.fQV == 1) && b(caVar, this.PhN) && bnf(caVar.field_talker))) {
                mVar.a(i2, 123, view.getContext().getString(R.string.b0i), R.raw.icons_filled_previous);
            }
            if (!this.PhN.gRN()) {
                mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
            }
            AppMethodBeat.o(233805);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37066);
            switch (menuItem.getItemId()) {
                case 102:
                    String str = k.b.HD(caVar.field_content).title;
                    ClipboardHelper.setText(str);
                    com.tencent.mm.plugin.secinforeport.a.a aVar2 = com.tencent.mm.plugin.secinforeport.a.a.INSTANCE;
                    com.tencent.mm.plugin.secinforeport.a.a.q(1, new StringBuilder().append(caVar.field_msgSvrId).toString(), Util.getUTF8ByteLength(str));
                    AppMethodBeat.o(37066);
                    break;
                case 111:
                    Intent intent = new Intent(aVar.Pwc.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", caVar.field_content);
                    intent.putExtra("Retr_Msg_Type", 2);
                    intent.putExtra("Retr_Msg_Id", caVar.field_msgId);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    aVar.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(37066);
                    break;
                default:
                    AppMethodBeat.o(37066);
                    break;
            }
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.t.n
        public final void b(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233806);
            if (caVar.dOQ()) {
                com.tencent.mm.pluginsdk.model.app.m.aS(caVar);
                bp.Ad(caVar.field_msgId);
                aVar.BN(true);
                AppMethodBeat.o(233806);
                return;
            }
            AppMethodBeat.o(233806);
        }
    }

    static final class a extends c.a {
        protected TextView PHZ;
        protected MMNeat7extView PKD;
        protected ImageView stateIV;
        protected TextView tln;

        a() {
        }

        public final a ha(View view) {
            AppMethodBeat.i(37056);
            super.create(view);
            this.PKD = (MMNeat7extView) view.findViewById(R.id.auk);
            this.uploadingPB = (ProgressBar) view.findViewById(R.id.j0y);
            this.stateIV = (ImageView) view.findViewById(R.id.ayb);
            this.tln = (TextView) view.findViewById(R.id.atq);
            this.PHZ = (TextView) view.findViewById(R.id.at6);
            this.userTV = (TextView) view.findViewById(R.id.ayn);
            this.checkBox = (CheckBox) view.findViewById(R.id.aue);
            this.maskView = view.findViewById(R.id.ax3);
            AppMethodBeat.o(37056);
            return this;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c.a
        public final View getMainContainerView() {
            return this.PKD;
        }
    }
}
