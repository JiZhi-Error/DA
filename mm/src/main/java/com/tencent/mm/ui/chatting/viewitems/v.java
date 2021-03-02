package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.b.a.ja;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.cjv;
import com.tencent.mm.protocal.protobuf.cjw;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.d.b.au;
import com.tencent.mm.ui.chatting.d.b.x;
import com.tencent.mm.ui.chatting.l.a;
import com.tencent.mm.ui.chatting.s;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.ui.widget.textview.a;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.smtt.sdk.TbsListener;
import java.util.Iterator;

public final class v {

    public static class b extends c implements NeatTextView.b {
        private static final int PKJ = R.id.ih3;
        private static final int PKK = R.id.awq;
        private static final int PKL = R.id.awp;
        private int PHj = -1;
        private e PKM;
        private com.tencent.mm.ui.chatting.e.a PhN;
        private CharSequence PkM;
        private int hcg = -1;

        private e gUd() {
            AppMethodBeat.i(36944);
            if (this.PKM == null) {
                this.PKM = new e(this.PhN);
            }
            e eVar = this.PKM;
            AppMethodBeat.o(36944);
            return eVar;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || i2 != 805306417) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(36945);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.rk);
                view.setTag(new a().gR(view));
            }
            AppMethodBeat.o(36945);
            return view;
        }

        /* JADX WARNING: Removed duplicated region for block: B:52:0x021e  */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a r15, int r16, final com.tencent.mm.ui.chatting.e.a r17, final com.tencent.mm.storage.ca r18, java.lang.String r19) {
            /*
            // Method dump skipped, instructions count: 1060
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.v.b.a(com.tencent.mm.ui.chatting.viewitems.c$a, int, com.tencent.mm.ui.chatting.e.a, com.tencent.mm.storage.ca, java.lang.String):void");
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            String str;
            int Kp;
            String str2;
            int Kp2;
            AppMethodBeat.i(36948);
            switch (menuItem.getItemId()) {
                case 102:
                    String str3 = k.b.HD(bp.b(aVar.gRL(), caVar.field_content, caVar.field_isSend)).title;
                    ClipboardHelper.setText(str3);
                    com.tencent.mm.plugin.secinforeport.a.a aVar2 = com.tencent.mm.plugin.secinforeport.a.a.INSTANCE;
                    com.tencent.mm.plugin.secinforeport.a.a.q(1, new StringBuilder().append(caVar.field_msgSvrId).toString(), Util.getUTF8ByteLength(str3));
                    AppMethodBeat.o(36948);
                    return false;
                case 111:
                    Intent intent = new Intent(aVar.Pwc.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend));
                    intent.putExtra("Retr_Msg_Type", 2);
                    intent.putExtra("Retr_Msg_Id", caVar.field_msgId);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    aVar.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(36948);
                    return false;
                case 124:
                case 125:
                    ((au) aVar.bh(au.class)).b(menuItem, caVar);
                    break;
                case 141:
                    String str4 = caVar.field_transContent;
                    if (!Util.isNullOrNil(str4)) {
                        ClipboardHelper.setText(str4);
                    }
                    h.cD(aVar.Pwc.getContext(), aVar.Pwc.getContext().getString(R.string.ta));
                    AppMethodBeat.o(36948);
                    return true;
                case TbsListener.ErrorCode.NEEDDOWNLOAD_3 /*{ENCODED_INT: 142}*/:
                    Intent intent2 = new Intent(aVar.Pwc.getContext(), MsgRetransmitUI.class);
                    String str5 = caVar.field_transContent;
                    if (!aVar.gRM() || ((com.tencent.mm.ui.chatting.d.b.d) aVar.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP() || (Kp2 = bp.Kp(str5)) == -1) {
                        str2 = str5;
                    } else {
                        str2 = str5.substring(Kp2 + 1).trim();
                    }
                    if (caVar.gDg()) {
                        intent2.putExtra("Retr_Msg_content", str2);
                        intent2.putExtra("Retr_Msg_Type", 6);
                    } else {
                        intent2.putExtra("Retr_Msg_content", str2);
                        intent2.putExtra("Retr_Msg_Type", 4);
                    }
                    com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, bl2.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    aVar.startActivity((Intent) bl2.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(36948);
                    return true;
                case TbsListener.ErrorCode.NEEDDOWNLOAD_4 /*{ENCODED_INT: 143}*/:
                    cz czVar = new cz();
                    String str6 = caVar.field_transContent;
                    if (!aVar.gRM() || ((com.tencent.mm.ui.chatting.d.b.d) aVar.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP() || (Kp = bp.Kp(str6)) == -1) {
                        str = str6;
                    } else {
                        str = str6.substring(Kp + 1).trim();
                    }
                    com.tencent.mm.pluginsdk.model.h.b(czVar, str, 1);
                    czVar.dFZ.fragment = aVar.Pwc;
                    czVar.dFZ.dGf = 43;
                    if (czVar.dFZ.dGb == null) {
                        Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", " transform text fav failed");
                        break;
                    } else {
                        anh anh = czVar.dFZ.dGb.Lya;
                        if (anh != null) {
                            anh.bhf(caVar.field_talker);
                            anh.bhg(z.aTY());
                            EventCenter.instance.publish(czVar);
                            AppMethodBeat.o(36948);
                            return true;
                        }
                    }
                    break;
                case 151:
                    s.a(aVar, caVar.field_msgId, 2);
                    AppMethodBeat.o(36948);
                    return false;
                default:
                    AppMethodBeat.o(36948);
                    return false;
            }
            AppMethodBeat.o(36948);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        @Override // com.tencent.neattextview.textview.view.NeatTextView.b
        public final boolean gS(View view) {
            AppMethodBeat.i(36949);
            if (v.gQ(view)) {
                Log.i("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "onDoubleTap solitaire fold double click");
                AppMethodBeat.o(36949);
            } else {
                Intent intent = new Intent(view.getContext(), TextPreviewUI.class);
                intent.addFlags(67108864);
                bq bqVar = (bq) view.getTag();
                if (bqVar != null) {
                    CharSequence hiT = ((MMNeat7extView) view).hiT();
                    intent.putExtra("Chat_Msg_Id", bqVar.dTX.field_msgId);
                    intent.putExtra("key_chat_text", hiT);
                    if (this.PhN != null) {
                        intent.putExtra("is_group_chat", this.PhN.gRM());
                    }
                    Context context = view.getContext();
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    com.tencent.mm.ui.base.b.kc(view.getContext());
                }
                AppMethodBeat.o(36949);
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233720);
            if (caVar.fqK != null) {
                caVar.fqK.contains("announcement@all");
            }
            ChattingItemTranslate.a aVar = (ChattingItemTranslate.a) view.getTag();
            int i2 = aVar.position;
            if (aVar.qcr == 1) {
                Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "接龙消息右键菜单");
                if (com.tencent.mm.plugin.groupsolitaire.b.b.ay(caVar)) {
                    mVar.a(i2, 151, this.PhN.Pwc.getMMResources().getString(R.string.dw3), R.raw.icons_filled_continued_form);
                }
                mVar.a(i2, 102, this.PhN.Pwc.getMMResources().getString(R.string.b03), R.raw.icons_filled_copy);
                mVar.a(i2, 111, this.PhN.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
                if (com.tencent.mm.br.c.aZU("favorite")) {
                    mVar.a(i2, 116, this.PhN.Pwc.getMMResources().getString(R.string.fn9), R.raw.icons_filled_favorites);
                }
                if (com.tencent.mm.pluginsdk.model.app.h.ay(this.PhN.Pwc.getContext(), caVar.getType())) {
                    mVar.a(i2, 129, view.getContext().getString(R.string.b0c), R.raw.icons_filled_open);
                }
                if (com.tencent.mm.app.plugin.c.Xn() && (!caVar.gDz() || !caVar.gDI())) {
                    mVar.a(i2, 124, view.getContext().getString(R.string.b0r), R.raw.icons_filled_translate);
                }
                if (!this.PhN.gRN()) {
                    mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
                }
                if (br.B(caVar)) {
                    mVar.clear();
                    if (!this.PhN.gRN()) {
                        mVar.a(i2, 100, view.getContext().getString(R.string.b06), R.raw.icons_filled_delete);
                    }
                }
            } else if (aVar.qcr == 2) {
                Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "翻译消息右键菜单");
                mVar.a(i2, 141, view.getContext().getString(R.string.b03), R.raw.icons_filled_copy);
                mVar.a(i2, TbsListener.ErrorCode.NEEDDOWNLOAD_3, view.getContext().getString(R.string.g5c), R.raw.icons_filled_share);
                if (com.tencent.mm.br.c.aZU("favorite")) {
                    mVar.a(i2, TbsListener.ErrorCode.NEEDDOWNLOAD_4, view.getContext().getString(R.string.fn9), R.raw.icons_filled_favorites);
                }
                if (com.tencent.mm.app.plugin.c.Xn()) {
                    if (caVar.gDz() && caVar.gDI()) {
                        mVar.a(i2, 124, view.getContext().getString(R.string.b0p), R.raw.icons_filled_eyes_off);
                    }
                    if (caVar.gDL()) {
                        mVar.a(i2, 125, view.getContext().getString(R.string.b0h), R.raw.icons_filled_refresh);
                    }
                }
                AppMethodBeat.o(233720);
                return false;
            }
            AppMethodBeat.o(233720);
            return true;
        }
    }

    public static class c extends c implements t.n, NeatTextView.b {
        private static final int PKJ = R.id.ih3;
        private static final int PKK = R.id.awq;
        private static final int PKL = R.id.awp;
        private int PHj = -1;
        private e PKM;
        private com.tencent.mm.ui.chatting.e.a PhN;
        private CharSequence PkM;
        private int hcg = -1;

        private e gUd() {
            AppMethodBeat.i(36956);
            if (this.PKM == null) {
                this.PKM = new e(this.PhN);
            }
            e eVar = this.PKM;
            AppMethodBeat.o(36956);
            return eVar;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != 805306417) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(36957);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.sy);
                view.setTag(new a().gR(view));
            }
            AppMethodBeat.o(36957);
            return view;
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x015c  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x019b  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x01a8  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x01de  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0234  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x025c  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x028d  */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x0308  */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x0320  */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x039f  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x03a2  */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x03b7  */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a r15, int r16, final com.tencent.mm.ui.chatting.e.a r17, final com.tencent.mm.storage.ca r18, java.lang.String r19) {
            /*
            // Method dump skipped, instructions count: 965
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.v.c.a(com.tencent.mm.ui.chatting.viewitems.c$a, int, com.tencent.mm.ui.chatting.e.a, com.tencent.mm.storage.ca, java.lang.String):void");
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            String str;
            int Kp;
            String str2;
            int Kp2;
            AppMethodBeat.i(36960);
            switch (menuItem.getItemId()) {
                case 102:
                    String str3 = k.b.HD(bp.b(aVar.gRL(), caVar.field_content, caVar.field_isSend)).title;
                    ClipboardHelper.setText(str3);
                    com.tencent.mm.plugin.secinforeport.a.a aVar2 = com.tencent.mm.plugin.secinforeport.a.a.INSTANCE;
                    com.tencent.mm.plugin.secinforeport.a.a.q(1, new StringBuilder().append(caVar.field_msgSvrId).toString(), Util.getUTF8ByteLength(str3));
                    AppMethodBeat.o(36960);
                    return false;
                case 103:
                    bK(caVar);
                    break;
                case 111:
                    Intent intent = new Intent(aVar.Pwc.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend));
                    intent.putExtra("Retr_Msg_Type", 2);
                    intent.putExtra("Retr_Msg_Id", caVar.field_msgId);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    aVar.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(36960);
                    return false;
                case 124:
                case 125:
                    ((au) aVar.bh(au.class)).b(menuItem, caVar);
                    break;
                case 141:
                    String str4 = caVar.field_transContent;
                    if (!Util.isNullOrNil(str4)) {
                        ClipboardHelper.setText(str4);
                    }
                    h.cD(aVar.Pwc.getContext(), aVar.Pwc.getContext().getString(R.string.ta));
                    AppMethodBeat.o(36960);
                    return true;
                case TbsListener.ErrorCode.NEEDDOWNLOAD_3 /*{ENCODED_INT: 142}*/:
                    Intent intent2 = new Intent(aVar.Pwc.getContext(), MsgRetransmitUI.class);
                    String str5 = caVar.field_transContent;
                    if (!aVar.gRM() || ((com.tencent.mm.ui.chatting.d.b.d) aVar.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP() || (Kp2 = bp.Kp(str5)) == -1) {
                        str2 = str5;
                    } else {
                        str2 = str5.substring(Kp2 + 1).trim();
                    }
                    if (caVar.gDg()) {
                        intent2.putExtra("Retr_Msg_content", str2);
                        intent2.putExtra("Retr_Msg_Type", 6);
                    } else {
                        intent2.putExtra("Retr_Msg_content", str2);
                        intent2.putExtra("Retr_Msg_Type", 4);
                    }
                    com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, bl2.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    aVar.startActivity((Intent) bl2.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(36960);
                    return true;
                case TbsListener.ErrorCode.NEEDDOWNLOAD_4 /*{ENCODED_INT: 143}*/:
                    cz czVar = new cz();
                    String str6 = caVar.field_transContent;
                    if (!aVar.gRM() || ((com.tencent.mm.ui.chatting.d.b.d) aVar.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP() || (Kp = bp.Kp(str6)) == -1) {
                        str = str6;
                    } else {
                        str = str6.substring(Kp + 1).trim();
                    }
                    com.tencent.mm.pluginsdk.model.h.b(czVar, str, 1);
                    czVar.dFZ.fragment = aVar.Pwc;
                    czVar.dFZ.dGf = 43;
                    if (czVar.dFZ.dGb == null) {
                        Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", " transform text fav failed");
                        break;
                    } else {
                        anh anh = czVar.dFZ.dGb.Lya;
                        if (anh != null) {
                            anh.bhf(caVar.field_talker);
                            anh.bhg(z.aTY());
                            EventCenter.instance.publish(czVar);
                            AppMethodBeat.o(36960);
                            return true;
                        }
                    }
                    break;
                case 151:
                    s.a(aVar, caVar.field_msgId, 2);
                    AppMethodBeat.o(36960);
                    return false;
                default:
                    AppMethodBeat.o(36960);
                    return false;
            }
            AppMethodBeat.o(36960);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.t.n
        public final void b(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233723);
            bK(caVar);
            AppMethodBeat.o(233723);
        }

        private void bK(ca caVar) {
            AppMethodBeat.i(233724);
            if (caVar.gDx()) {
                com.tencent.mm.plugin.groupsolitaire.c.a r = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().r(caVar.field_talker, caVar.fRd, true);
                if (r != null && Util.isEqual(r.field_firstMsgId, caVar.field_msgId)) {
                    r.field_firstMsgId = 0;
                    ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a(r, true);
                }
                Pair<Integer, Long> aS = com.tencent.mm.pluginsdk.model.app.m.aS(caVar);
                if (aS != null) {
                    ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager().Y(caVar.field_msgId, ((Long) aS.second).longValue());
                }
                bp.Ad(caVar.field_msgId);
                this.PhN.BN(true);
            }
            AppMethodBeat.o(233724);
        }

        @Override // com.tencent.neattextview.textview.view.NeatTextView.b
        public final boolean gS(View view) {
            bq bqVar;
            AppMethodBeat.i(36962);
            if (v.gQ(view)) {
                Log.i("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "onDoubleTap solitaire fold double click");
                AppMethodBeat.o(36962);
            } else {
                CharSequence hiT = ((MMNeat7extView) view).hiT();
                Intent intent = new Intent(view.getContext(), TextPreviewUI.class);
                intent.addFlags(67108864);
                intent.putExtra("key_chat_text", hiT);
                if ((view.getTag() instanceof bq) && (bqVar = (bq) view.getTag()) != null) {
                    intent.putExtra("Chat_Msg_Id", bqVar.dTX.field_msgId);
                }
                if (this.PhN != null) {
                    intent.putExtra("is_group_chat", this.PhN.gRM());
                }
                Context context = view.getContext();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.ui.base.b.kc(view.getContext());
                AppMethodBeat.o(36962);
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            boolean z;
            AppMethodBeat.i(233722);
            if (caVar.fqK == null || !caVar.fqK.contains("announcement@all")) {
                z = false;
            } else {
                z = true;
            }
            ChattingItemTranslate.a aVar = (ChattingItemTranslate.a) view.getTag();
            int i2 = aVar.position;
            if (aVar.qcr == 1) {
                Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "接龙消息右键菜单");
                if (com.tencent.mm.plugin.groupsolitaire.b.b.ay(caVar)) {
                    mVar.a(i2, 151, this.PhN.Pwc.getMMResources().getString(R.string.dw3), R.raw.icons_filled_continued_form);
                }
                mVar.a(i2, 102, this.PhN.Pwc.getMMResources().getString(R.string.b03), R.raw.icons_filled_copy);
                mVar.a(i2, 111, this.PhN.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
                if (caVar.field_status == 5) {
                    mVar.a(i2, 103, view.getContext().getString(R.string.b1y), R.raw.icons_filled_refresh);
                }
                if (com.tencent.mm.br.c.aZU("favorite")) {
                    mVar.a(i2, 116, this.PhN.Pwc.getMMResources().getString(R.string.fn9), R.raw.icons_filled_favorites);
                }
                if (com.tencent.mm.pluginsdk.model.app.h.ay(this.PhN.Pwc.getContext(), caVar.getType())) {
                    mVar.a(i2, 129, view.getContext().getString(R.string.b0c), R.raw.icons_filled_open);
                }
                if (!z && !caVar.gAt() && ((caVar.field_status == 2 || caVar.fQV == 1) && b(caVar, this.PhN) && bnf(caVar.field_talker) && !as.HF(this.PhN.getTalkerUserName()))) {
                    mVar.a(i2, 123, view.getContext().getString(R.string.b0i), R.raw.icons_filled_previous);
                }
                if (com.tencent.mm.app.plugin.c.Xn() && (!caVar.gDz() || !caVar.gDI())) {
                    mVar.a(i2, 124, view.getContext().getString(R.string.b0r), R.raw.icons_filled_translate);
                }
                if (!this.PhN.gRN()) {
                    mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
                }
            } else if (aVar.qcr == 2) {
                Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "翻译消息右键菜单");
                mVar.a(i2, 141, view.getContext().getString(R.string.b03), R.raw.icons_filled_copy);
                mVar.a(i2, TbsListener.ErrorCode.NEEDDOWNLOAD_3, view.getContext().getString(R.string.g5c), R.raw.icons_filled_share);
                if (com.tencent.mm.br.c.aZU("favorite")) {
                    mVar.a(i2, TbsListener.ErrorCode.NEEDDOWNLOAD_4, view.getContext().getString(R.string.fn9), R.raw.icons_filled_favorites);
                }
                if (com.tencent.mm.app.plugin.c.Xn()) {
                    if (caVar.gDz() && caVar.gDI()) {
                        mVar.a(i2, 124, view.getContext().getString(R.string.b0p), R.raw.icons_filled_eyes_off);
                    }
                    if (caVar.gDL()) {
                        mVar.a(i2, 125, view.getContext().getString(R.string.b0h), R.raw.icons_filled_refresh);
                    }
                }
                AppMethodBeat.o(233722);
                return false;
            }
            AppMethodBeat.o(233722);
            return true;
        }
    }

    public static void a(Context context, final com.tencent.mm.ui.chatting.e.a aVar, String str, final CharSequence charSequence, final MMNeat7extView mMNeat7extView, final ca caVar, int i2) {
        AppMethodBeat.i(233725);
        if (((x) aVar.bh(x.class)).cd(caVar)) {
            final cjv cjv = caVar.field_solitaireFoldInfo;
            StringBuilder sb = new StringBuilder();
            if (cjv.Mpl != null) {
                Iterator<cjw> it = cjv.Mpl.iterator();
                while (it.hasNext()) {
                    cjw next = it.next();
                    sb.append(Util.nullAs(Util.nullAs(next.Mpp, ""), "")).append(str.substring(next.start, next.end));
                }
            }
            if (!Util.isNullOrNil(sb.toString())) {
                sb.append("\n");
            }
            if (!Util.isNullOrNil(sb.toString()) && cjv.yfC == 1) {
                sb.append("\n");
            }
            a.C2099a aVar2 = com.tencent.mm.ui.chatting.l.a.PEV;
            a.C2099a.a(mMNeat7extView, caVar, aVar.gRM(), aVar.gRI());
            aVar.gRI();
            Bundle cN = bd.cN(caVar);
            t.b.GROUP_CHATTING.br(cN);
            SpannableString a2 = l.a(context, (CharSequence) sb, (int) mMNeat7extView.getTextSize(), i2, false, (Object) cN, l.Krf);
            String string = context.getString(R.string.dw1);
            SpannableString spannableString = new SpannableString(string);
            spannableString.setSpan(new p(i2) {
                /* class com.tencent.mm.ui.chatting.viewitems.v.AnonymousClass1 */

                @Override // com.tencent.mm.pluginsdk.ui.span.p
                public final void onClick(View view) {
                    AppMethodBeat.i(233718);
                    Log.d("MicroMsg.ChattingItemAppMsgGroupSolitatire", "fold click");
                    if (!((x) aVar.bh(x.class)).cd(caVar)) {
                        Log.i("MicroMsg.ChattingItemAppMsgGroupSolitatire", "not fold");
                        AppMethodBeat.o(233718);
                        return;
                    }
                    if (view != null) {
                        view.setTag(R.id.aya, Long.valueOf(System.currentTimeMillis()));
                    }
                    mMNeat7extView.a(charSequence, TextView.BufferType.SPANNABLE);
                    ((x) aVar.bh(x.class)).Nx(((Long) mMNeat7extView.getTag(R.id.awq)).longValue());
                    ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
                    String talkerUserName = aVar.getTalkerUserName();
                    cjv cjv = cjv;
                    ja jaVar = new ja();
                    jaVar.emL = jaVar.x("ChatName", talkerUserName, true);
                    jaVar.eQf = cjv.dTS;
                    jaVar.eQj = jaVar.x("Identifier", cjv.key, true);
                    jaVar.eQs = (long) cjv.Mpm.size();
                    jaVar.eQt = (long) cjv.Mpo;
                    jaVar.bfK();
                    AppMethodBeat.o(233718);
                }
            }, 0, string.length(), 33);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\n");
            if (cjv.Mpm != null) {
                Iterator<cjw> it2 = cjv.Mpm.iterator();
                while (it2.hasNext()) {
                    cjw next2 = it2.next();
                    sb2.append(Util.nullAs(next2.Mpp, "")).append(str.substring(next2.start, next2.end)).append("\n");
                }
            }
            if (cjv.Mpn != null) {
                sb2.append("\n");
                sb2.append(Util.nullAs(cjv.Mpn.Mpp, "")).append(str.substring(cjv.Mpn.start, cjv.Mpn.end));
            }
            charSequence = TextUtils.concat(TextUtils.concat(a2, spannableString), l.a(context, (CharSequence) sb2, (int) mMNeat7extView.getTextSize(), i2, false, (Object) cN, l.Krf));
        }
        mMNeat7extView.a(charSequence, TextView.BufferType.SPANNABLE);
        AppMethodBeat.o(233725);
    }

    public static boolean gQ(View view) {
        AppMethodBeat.i(233726);
        if (view == null) {
            AppMethodBeat.o(233726);
            return false;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis() - ((Long) view.getTag(R.id.aya)).longValue();
            if (currentTimeMillis > 0 && currentTimeMillis < 500) {
                AppMethodBeat.o(233726);
                return true;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatire", "checkSolitaireFoldDoubleClick Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
        }
        AppMethodBeat.o(233726);
        return false;
    }

    static final class a extends c.a {
        a.f PGP;
        protected TextView PHZ;
        protected MMNeat7extView PKD;
        com.tencent.mm.ui.widget.textview.a PKE;
        com.tencent.mm.pluginsdk.ui.span.h PKF;
        a.e PKG;
        ViewStub PKH;
        ChattingItemTranslate PKI;
        View jxm;
        protected ImageView stateIV;
        protected TextView tln;
        com.tencent.mm.ui.widget.b.a wnj;

        a() {
        }

        public final a gR(View view) {
            AppMethodBeat.i(36935);
            super.create(view);
            this.PKD = (MMNeat7extView) view.findViewById(R.id.auk);
            this.uploadingPB = (ProgressBar) view.findViewById(R.id.j0y);
            this.stateIV = (ImageView) view.findViewById(R.id.ayb);
            this.tln = (TextView) view.findViewById(R.id.atq);
            this.PHZ = (TextView) view.findViewById(R.id.at6);
            this.userTV = (TextView) view.findViewById(R.id.ayn);
            this.checkBox = (CheckBox) view.findViewById(R.id.aue);
            this.maskView = view.findViewById(R.id.ax3);
            this.jxm = view.findViewById(R.id.aui);
            this.PKH = (ViewStub) view.findViewById(R.id.iva);
            this.PKF = new com.tencent.mm.pluginsdk.ui.span.h(this.PKD, new o(this.PKD.getContext()));
            AppMethodBeat.o(36935);
            return this;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c.a
        public final View getMainContainerView() {
            return this.PKD;
        }
    }

    /* access modifiers changed from: package-private */
    public static class e extends t.e {
        public e(com.tencent.mm.ui.chatting.e.a aVar) {
            super(aVar);
        }

        @Override // com.tencent.mm.ui.chatting.t.e
        public final void a(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(36964);
            bq bqVar = (bq) view.getTag();
            if (caVar.gDg()) {
                if (this.PhN != null) {
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    com.tencent.mm.br.c.b(this.PhN.Pwc.getContext(), "shake", ".ui.ShakeReportUI", intent);
                }
                AppMethodBeat.o(36964);
                return;
            }
            if (caVar.isText() && (view instanceof MMTextView)) {
                com.tencent.mm.ui.chatting.m.a.a.gTK();
                com.tencent.mm.ui.chatting.m.a.a.a(((MMTextView) view).getText(), bqVar.dTX);
            }
            AppMethodBeat.o(36964);
        }
    }

    static class d implements a.e {
        private com.tencent.mm.ui.widget.textview.a PkL;

        d(com.tencent.mm.ui.widget.textview.a aVar) {
            this.PkL = aVar;
        }

        @Override // com.tencent.mm.ui.widget.textview.a.e
        public final void gUe() {
            AppMethodBeat.i(36963);
            Log.d("OnTouchOutside", "touchOutside");
            this.PkL.hbA();
            this.PkL.QXX = true;
            this.PkL.hcR();
            this.PkL.QXW = true;
            this.PkL.hcS();
            this.PkL.hcU();
            AppMethodBeat.o(36963);
        }
    }
}
