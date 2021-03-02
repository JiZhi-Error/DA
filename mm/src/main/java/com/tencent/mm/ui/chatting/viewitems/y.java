package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.bi.d;
import com.tencent.mm.model.bp;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.d.b.as;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class y {

    public static class c extends c {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != -1879048186) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(36997);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.t1);
                view.setTag(new a().gV(view));
            }
            AppMethodBeat.o(36997);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            AppMethodBeat.i(36998);
            a aVar3 = (a) aVar;
            this.PhN = aVar2;
            String str2 = caVar.field_content;
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            } else {
                bVar = null;
            }
            if (bVar != null) {
                aVar3.clickArea.setTag(new bq(caVar, aVar2.gRM(), i2, (String) null, (char) 0));
                aVar3.clickArea.setOnClickListener(d(aVar2));
                if (this.qoo) {
                    aVar3.clickArea.setOnLongClickListener(c(aVar2));
                    aVar3.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
                }
                aVar3.PKZ.setText(bVar.title);
            }
            if (d.jpA == null || !d.jpA.PZ(aVar2.getTalkerUserName())) {
                aVar3.PKZ.setTextColor(aVar2.Pwc.getContext().getResources().getColor(R.color.jf));
                aVar3.PLa.setAlpha(0.3f);
                aVar3.clickArea.setClickable(false);
                aVar3.clickArea.setEnabled(false);
                AppMethodBeat.o(36998);
                return;
            }
            aVar3.PKZ.setTextColor(aVar2.Pwc.getContext().getResources().getColor(R.color.jg));
            aVar3.PLa.setAlpha(1.0f);
            aVar3.clickArea.setClickable(true);
            aVar3.clickArea.setEnabled(true);
            AppMethodBeat.o(36998);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233733);
            int i2 = ((bq) view.getTag()).position;
            com.tencent.mm.pluginsdk.model.app.m.bdI(bp.b(this.PhN.gRM(), caVar.field_content, caVar.field_isSend));
            k.b HD = k.b.HD(bp.b(this.PhN.gRM(), caVar.field_content, caVar.field_isSend));
            g o = h.o(HD.appId, false, false);
            if (com.tencent.mm.br.c.aZU("favorite") && (o == null || !o.NA())) {
                switch (HD.type) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 10:
                    case 13:
                    case 20:
                        mVar.add(i2, 116, 0, view.getContext().getString(R.string.fn9));
                        break;
                }
            }
            if (!caVar.gAt() && caVar.dOS() && ((caVar.field_status == 2 || caVar.fQV == 1) && b(caVar, this.PhN) && bnf(caVar.field_talker))) {
                mVar.a(i2, 123, view.getContext().getString(R.string.b0i), R.raw.icons_filled_previous);
            }
            if (!this.PhN.gRN()) {
                mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
            }
            AppMethodBeat.o(233733);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37000);
            switch (menuItem.getItemId()) {
                case 111:
                    Intent intent = new Intent(aVar.Pwc.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend));
                    intent.putExtra("Retr_Msg_Type", 2);
                    intent.putExtra("Retr_Msg_Id", caVar.field_msgId);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    aVar.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(37000);
                    break;
                default:
                    AppMethodBeat.o(37000);
                    break;
            }
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37001);
            ((com.tencent.mm.plugin.comm.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
            aVar.getTalkerUserName();
            ((as) aVar.bh(as.class)).dq("fromMessage", true);
            AppMethodBeat.o(37001);
            return true;
        }
    }

    public static class b extends c {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || i2 != -1879048186) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(36992);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.rn);
                view.setTag(new a().gV(view));
            }
            AppMethodBeat.o(36992);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            String str2;
            boolean z;
            k.b bVar;
            int indexOf;
            AppMethodBeat.i(36993);
            a aVar3 = (a) aVar;
            this.PhN = aVar2;
            k GL = ao.gnf().GL(caVar.field_msgId);
            String str3 = caVar.field_content;
            if (!aVar2.gRM() || (indexOf = caVar.field_content.indexOf(58)) == -1) {
                str2 = str3;
            } else {
                str2 = caVar.field_content.substring(indexOf + 1);
            }
            if (GL == null || str2 == null) {
                Object[] objArr = new Object[4];
                if (GL == null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                objArr[1] = str2;
                objArr[2] = Long.valueOf(caVar.field_msgId);
                objArr[3] = str;
                Log.e("MicroMsg.ChattingItemAppMsgLocationShareFrom", "amessage:%b, %s, %s", objArr);
                bVar = null;
            } else {
                bVar = k.b.aD(str2, caVar.field_reserved);
            }
            if (bVar != null) {
                aVar3.PKZ.setText(bVar.title);
                aVar3.clickArea.setTag(new bq(caVar, aVar2.gRM(), i2, (String) null, (char) 0));
                aVar3.clickArea.setOnClickListener(d(aVar2));
                if (this.qoo) {
                    aVar3.clickArea.setOnLongClickListener(c(aVar2));
                    aVar3.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
                }
            }
            if (d.jpA == null || !d.jpA.PZ(aVar2.getTalkerUserName())) {
                aVar3.PKZ.setTextColor(aVar2.Pwc.getContext().getResources().getColor(R.color.m5));
                aVar3.PLa.setAlpha(0.3f);
                aVar3.clickArea.setClickable(false);
                aVar3.clickArea.setEnabled(false);
                AppMethodBeat.o(36993);
                return;
            }
            aVar3.PKZ.setTextColor(aVar2.Pwc.getContext().getResources().getColor(R.color.a2x));
            aVar3.PLa.setAlpha(1.0f);
            aVar3.clickArea.setClickable(true);
            aVar3.clickArea.setEnabled(true);
            AppMethodBeat.o(36993);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233732);
            int i2 = ((bq) view.getTag()).position;
            com.tencent.mm.pluginsdk.model.app.m.bdI(bp.b(this.PhN.gRM(), caVar.field_content, caVar.field_isSend));
            k.b HD = k.b.HD(bp.b(this.PhN.gRM(), caVar.field_content, caVar.field_isSend));
            g o = h.o(HD.appId, false, false);
            if (com.tencent.mm.br.c.aZU("favorite") && (o == null || !o.NA())) {
                switch (HD.type) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 10:
                    case 13:
                    case 20:
                        mVar.a(i2, 116, view.getContext().getString(R.string.fn9), R.raw.icons_filled_favorites);
                        break;
                }
            }
            if (!this.PhN.gRN()) {
                mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
            }
            AppMethodBeat.o(233732);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(36995);
            switch (menuItem.getItemId()) {
                case 111:
                    Intent intent = new Intent(aVar.Pwc.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend));
                    intent.putExtra("Retr_Msg_Type", 2);
                    intent.putExtra("Retr_Msg_Id", caVar.field_msgId);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    aVar.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(36995);
                    break;
                default:
                    AppMethodBeat.o(36995);
                    break;
            }
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(36996);
            if (com.tencent.mm.q.a.cC(view.getContext()) || com.tencent.mm.q.a.cA(view.getContext()) || com.tencent.mm.q.a.cE(aVar.Pwc.getContext())) {
                Log.d("MicroMsg.ChattingItemAppMsgLocationShareFrom", "voip is running, cann't start share location");
                AppMethodBeat.o(36996);
                return false;
            }
            ((com.tencent.mm.plugin.comm.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
            aVar.getTalkerUserName();
            ((as) aVar.bh(as.class)).dq("fromMessage", true);
            AppMethodBeat.o(36996);
            return true;
        }
    }

    static class a extends c.a {
        protected TextView PKZ;
        protected ImageView PLa;

        a() {
        }

        public final a gV(View view) {
            AppMethodBeat.i(36991);
            super.create(view);
            this.PKZ = (TextView) view.findViewById(R.id.eqr);
            this.userTV = (TextView) view.findViewById(R.id.ayn);
            this.PLa = (ImageView) view.findViewById(R.id.eqs);
            this.checkBox = (CheckBox) view.findViewById(R.id.aue);
            this.maskView = view.findViewById(R.id.ax3);
            AppMethodBeat.o(36991);
            return this;
        }
    }
}
