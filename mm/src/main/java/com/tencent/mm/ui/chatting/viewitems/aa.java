package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
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
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.d.b.au;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate;
import com.tencent.mm.ui.chatting.viewitems.aq;
import com.tencent.mm.ui.chatting.viewitems.av;
import com.tencent.mm.ui.chatting.viewitems.aw;
import com.tencent.mm.ui.chatting.viewitems.be;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.chatting.viewitems.e;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.ui.widget.textview.a;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.smtt.sdk.TbsListener;

public final class aa {

    public static class b extends c implements NeatTextView.b {
        private static final int PKJ = R.id.ih3;
        private static final int PKK = R.id.awq;
        private static final int PKL = R.id.awp;
        private int PHj = -1;
        private f PLc;
        private com.tencent.mm.ui.chatting.e.a PhN;
        private CharSequence PkM;
        private int hcg = -1;

        private f gUf() {
            AppMethodBeat.i(37012);
            if (this.PLc == null) {
                this.PLc = new f(this.PhN);
            }
            f fVar = this.PLc;
            AppMethodBeat.o(37012);
            return fVar;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || i2 != 822083633) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37013);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.ro);
                view.setTag(new a().gW(view));
            }
            AppMethodBeat.o(37013);
            return view;
        }

        /* JADX WARNING: Removed duplicated region for block: B:42:0x021a  */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a r15, int r16, final com.tencent.mm.ui.chatting.e.a r17, final com.tencent.mm.storage.ca r18, java.lang.String r19) {
            /*
            // Method dump skipped, instructions count: 1157
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.aa.b.a(com.tencent.mm.ui.chatting.viewitems.c$a, int, com.tencent.mm.ui.chatting.e.a, com.tencent.mm.storage.ca, java.lang.String):void");
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233752);
            ChattingItemTranslate.a aVar = (ChattingItemTranslate.a) view.getTag();
            int i2 = aVar.position;
            if (aVar.qcr == 1) {
                mVar.a(i2, 102, this.PhN.Pwc.getMMResources().getString(R.string.b03), R.raw.icons_filled_copy);
                mVar.a(i2, 111, this.PhN.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
                if (com.tencent.mm.br.c.aZU("favorite")) {
                    mVar.a(i2, 116, this.PhN.Pwc.getMMResources().getString(R.string.fn9), R.raw.icons_filled_favorites);
                }
                if (h.ay(this.PhN.Pwc.getContext(), caVar.getType())) {
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
                Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", "翻译消息右键菜单");
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
                AppMethodBeat.o(233752);
                return false;
            }
            AppMethodBeat.o(233752);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            String str;
            int Kp;
            String str2;
            int Kp2;
            AppMethodBeat.i(37016);
            switch (menuItem.getItemId()) {
                case 102:
                    String str3 = k.b.HD(bp.b(aVar.gRL(), caVar.field_content, caVar.field_isSend)).title;
                    ClipboardHelper.setText(str3);
                    com.tencent.mm.plugin.secinforeport.a.a aVar2 = com.tencent.mm.plugin.secinforeport.a.a.INSTANCE;
                    com.tencent.mm.plugin.secinforeport.a.a.q(1, new StringBuilder().append(caVar.field_msgSvrId).toString(), Util.getUTF8ByteLength(str3));
                    AppMethodBeat.o(37016);
                    return false;
                case 111:
                    Intent intent = new Intent(aVar.Pwc.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend));
                    intent.putExtra("Retr_Msg_Type", 2);
                    intent.putExtra("Retr_Msg_Id", caVar.field_msgId);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    aVar.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(37016);
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
                    com.tencent.mm.ui.base.h.cD(aVar.Pwc.getContext(), aVar.Pwc.getContext().getString(R.string.ta));
                    AppMethodBeat.o(37016);
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
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, bl2.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    aVar.startActivity((Intent) bl2.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(37016);
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
                        Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", " transform text fav failed");
                        break;
                    } else {
                        anh anh = czVar.dFZ.dGb.Lya;
                        if (anh != null) {
                            anh.bhf(caVar.field_talker);
                            anh.bhg(z.aTY());
                            EventCenter.instance.publish(czVar);
                            AppMethodBeat.o(37016);
                            return true;
                        }
                    }
                    break;
                default:
                    AppMethodBeat.o(37016);
                    return false;
            }
            AppMethodBeat.o(37016);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        @Override // com.tencent.neattextview.textview.view.NeatTextView.b
        public final boolean gS(View view) {
            AppMethodBeat.i(37017);
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
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.ui.base.b.kc(view.getContext());
            }
            AppMethodBeat.o(37017);
            return true;
        }
    }

    public static class c extends c implements t.n, NeatTextView.b {
        private static final int PKJ = R.id.ih3;
        private static final int PKK = R.id.awq;
        private static final int PKL = R.id.awp;
        private int PHj = -1;
        private f PLc;
        private com.tencent.mm.ui.chatting.e.a PhN;
        private CharSequence PkM;
        private int hcg = -1;

        private f gUf() {
            AppMethodBeat.i(37025);
            if (this.PLc == null) {
                this.PLc = new f(this.PhN);
            }
            f fVar = this.PLc;
            AppMethodBeat.o(37025);
            return fVar;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != 822083633) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37026);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.t2);
                view.setTag(new a().gW(view));
            }
            AppMethodBeat.o(37026);
            return view;
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x019b  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x01e7  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x01f4  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x022a  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x0280  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x02a8  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x02d4  */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x034c  */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x0364  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x0458  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x045b  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x0471  */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a r15, int r16, final com.tencent.mm.ui.chatting.e.a r17, final com.tencent.mm.storage.ca r18, java.lang.String r19) {
            /*
            // Method dump skipped, instructions count: 1154
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.aa.c.a(com.tencent.mm.ui.chatting.viewitems.c$a, int, com.tencent.mm.ui.chatting.e.a, com.tencent.mm.storage.ca, java.lang.String):void");
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            String str;
            int Kp;
            String str2;
            int Kp2;
            AppMethodBeat.i(37030);
            switch (menuItem.getItemId()) {
                case 102:
                    String str3 = k.b.HD(bp.b(aVar.gRL(), caVar.field_content, caVar.field_isSend)).title;
                    ClipboardHelper.setText(str3);
                    com.tencent.mm.plugin.secinforeport.a.a aVar2 = com.tencent.mm.plugin.secinforeport.a.a.INSTANCE;
                    com.tencent.mm.plugin.secinforeport.a.a.q(1, new StringBuilder().append(caVar.field_msgSvrId).toString(), Util.getUTF8ByteLength(str3));
                    AppMethodBeat.o(37030);
                    return false;
                case 103:
                    cM(caVar);
                    break;
                case 111:
                    Intent intent = new Intent(aVar.Pwc.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend));
                    intent.putExtra("Retr_Msg_Type", 2);
                    intent.putExtra("Retr_Msg_Id", caVar.field_msgId);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    aVar.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(37030);
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
                    com.tencent.mm.ui.base.h.cD(aVar.Pwc.getContext(), aVar.Pwc.getContext().getString(R.string.ta));
                    AppMethodBeat.o(37030);
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
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, bl2.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    aVar.startActivity((Intent) bl2.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(37030);
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
                        Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", " transform text fav failed");
                        break;
                    } else {
                        anh anh = czVar.dFZ.dGb.Lya;
                        if (anh != null) {
                            anh.bhf(caVar.field_talker);
                            anh.bhg(z.aTY());
                            EventCenter.instance.publish(czVar);
                            AppMethodBeat.o(37030);
                            return true;
                        }
                    }
                    break;
                default:
                    AppMethodBeat.o(37030);
                    return false;
            }
            AppMethodBeat.o(37030);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.t.n
        public final void b(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233755);
            cM(caVar);
            AppMethodBeat.o(233755);
        }

        @Override // com.tencent.neattextview.textview.view.NeatTextView.b
        public final boolean gS(View view) {
            bq bqVar;
            AppMethodBeat.i(37032);
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
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.ui.base.b.kc(view.getContext());
            AppMethodBeat.o(37032);
            return true;
        }

        private void cM(ca caVar) {
            boolean z;
            AppMethodBeat.i(233756);
            if (caVar.gDy()) {
                com.tencent.mm.plugin.msgquote.a.b Hl = ((com.tencent.mm.plugin.msgquote.a) g.ah(com.tencent.mm.plugin.msgquote.a.class)).getMsgQuoteStorage().Hl(caVar.field_msgId);
                Pair<Integer, Long> aS = com.tencent.mm.pluginsdk.model.app.m.aS(caVar);
                if (aS != null) {
                    if (Hl != null) {
                        Hl.field_msgId = ((Long) aS.second).longValue();
                        z = ((com.tencent.mm.plugin.msgquote.a) g.ah(com.tencent.mm.plugin.msgquote.a.class)).getMsgQuoteStorage().a(Hl);
                    } else {
                        Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "resendQuoteMsg() msgQute is null!");
                        z = false;
                    }
                    Log.i("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "resendQuoteMsg result:%s msgId:%s result:%s", aS.first, aS.second, Boolean.valueOf(z));
                }
                bp.Ad(caVar.field_msgId);
                this.PhN.BN(true);
                AppMethodBeat.o(233756);
                return;
            }
            AppMethodBeat.o(233756);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            boolean z;
            AppMethodBeat.i(233754);
            if (caVar.fqK == null || !caVar.fqK.contains("announcement@all")) {
                z = false;
            } else {
                z = true;
            }
            ChattingItemTranslate.a aVar = (ChattingItemTranslate.a) view.getTag();
            int i2 = aVar.position;
            if (aVar.qcr == 1) {
                mVar.a(i2, 102, this.PhN.Pwc.getMMResources().getString(R.string.b03), R.raw.icons_filled_copy);
                mVar.a(i2, 111, this.PhN.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
                if (caVar.field_status == 5) {
                    mVar.a(i2, 103, view.getContext().getString(R.string.b1y), R.raw.icons_filled_refresh);
                }
                if (com.tencent.mm.br.c.aZU("favorite")) {
                    mVar.a(i2, 116, this.PhN.Pwc.getMMResources().getString(R.string.fn9), R.raw.icons_filled_favorites);
                }
                if (h.ay(this.PhN.Pwc.getContext(), caVar.getType())) {
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
                Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "翻译消息右键菜单");
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
                AppMethodBeat.o(233754);
                return false;
            }
            AppMethodBeat.o(233754);
            return true;
        }
    }

    public static final class a extends c.a {
        a.f PGP;
        protected TextView PHZ;
        protected MMNeat7extView PKD;
        com.tencent.mm.ui.widget.textview.a PKE;
        com.tencent.mm.pluginsdk.ui.span.h PKF;
        a.e PKG;
        ViewStub PKH;
        ChattingItemTranslate PKI;
        View PLb;
        public View jxm;
        protected ImageView stateIV;
        protected TextView tln;
        com.tencent.mm.ui.widget.b.a wnj;

        public final a gW(View view) {
            AppMethodBeat.i(37002);
            super.create(view);
            this.PKD = (MMNeat7extView) view.findViewById(R.id.auk);
            this.uploadingPB = (ProgressBar) view.findViewById(R.id.j0y);
            this.stateIV = (ImageView) view.findViewById(R.id.ayb);
            this.tln = (TextView) view.findViewById(R.id.atq);
            this.PHZ = (TextView) view.findViewById(R.id.at6);
            this.userTV = (TextView) view.findViewById(R.id.ayn);
            this.checkBox = (CheckBox) view.findViewById(R.id.aue);
            this.maskView = view.findViewById(R.id.ax3);
            this.clickArea = view.findViewById(R.id.gpt);
            this.PLb = view.findViewById(R.id.gpu);
            this.jxm = view.findViewById(R.id.aui);
            this.PKH = (ViewStub) view.findViewById(R.id.iva);
            this.PKF = new com.tencent.mm.pluginsdk.ui.span.h(this.PKD, new o(this.PKD.getContext()));
            AppMethodBeat.o(37002);
            return this;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c.a
        public final View getMainContainerView() {
            return this.PKD;
        }
    }

    /* access modifiers changed from: package-private */
    public static class f extends t.e {
        public f(com.tencent.mm.ui.chatting.e.a aVar) {
            super(aVar);
        }

        @Override // com.tencent.mm.ui.chatting.t.e
        public final void a(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37035);
            bq bqVar = (bq) view.getTag();
            if (caVar.gDg()) {
                if (this.PhN != null) {
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    com.tencent.mm.br.c.b(this.PhN.Pwc.getContext(), "shake", ".ui.ShakeReportUI", intent);
                }
                AppMethodBeat.o(37035);
                return;
            }
            if (caVar.isText() && (view instanceof MMTextView)) {
                com.tencent.mm.ui.chatting.m.a.a.gTK();
                com.tencent.mm.ui.chatting.m.a.a.a(((MMTextView) view).getText(), bqVar.dTX);
            }
            AppMethodBeat.o(37035);
        }
    }

    static class d implements a.e {
        private com.tencent.mm.ui.widget.textview.a PkL;

        d(com.tencent.mm.ui.widget.textview.a aVar) {
            this.PkL = aVar;
        }

        @Override // com.tencent.mm.ui.widget.textview.a.e
        public final void gUe() {
            AppMethodBeat.i(37033);
            Log.d("OnTouchOutside", "touchOutside");
            this.PkL.hbA();
            this.PkL.QXX = true;
            this.PkL.hcR();
            this.PkL.QXW = true;
            this.PkL.hcS();
            this.PkL.hcU();
            AppMethodBeat.o(37033);
        }
    }

    static class e {
        public static void a(com.tencent.mm.ui.chatting.e.a aVar, c cVar, View view, long j2, MsgQuoteItem msgQuoteItem, boolean z) {
            ca caVar;
            int indexOf;
            AppMethodBeat.i(37034);
            if (msgQuoteItem == null) {
                Log.e("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "msgQuoteItem is null!");
                AppMethodBeat.o(37034);
                return;
            }
            ca Hb = ((l) g.af(l.class)).eiy().Hb(j2);
            Log.i("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "handleQuoteMsgClick msgId:%s msgSvrId:%s MsgQuoteItem(type:%s svrid:%s content:%s)", Long.valueOf(j2), Long.valueOf(Hb.field_msgSvrId), Integer.valueOf(msgQuoteItem.type), Long.valueOf(msgQuoteItem.zFI), Util.secPrint(msgQuoteItem.content));
            if (Util.isNullOrNil(msgQuoteItem.zFJ)) {
                Log.e("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "msgQuoteItem.fromusr is null!(1)");
                k.b bVar = null;
                String str = Hb.field_content;
                if (aVar.gRM() && (indexOf = Hb.field_content.indexOf(58)) != -1) {
                    str = Hb.field_content.substring(indexOf + 1);
                }
                if (str != null) {
                    bVar = k.b.aD(str, Hb.field_reserved);
                }
                msgQuoteItem = bVar.izy;
            }
            if (Util.isNullOrNil(msgQuoteItem.zFJ)) {
                Log.e("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "msgQuoteItem.fromusr is null!(2)");
                AppMethodBeat.o(37034);
                return;
            }
            ca aJ = ((l) g.af(l.class)).eiy().aJ(msgQuoteItem.zFJ, msgQuoteItem.zFI);
            if (aJ.field_msgId == 0) {
                ca caVar2 = new ca();
                caVar2.setType(msgQuoteItem.type);
                caVar2.yF(msgQuoteItem.zFI);
                caVar2.Cy(msgQuoteItem.zFJ);
                caVar2.BB(msgQuoteItem.zFM);
                caVar2.setContent(msgQuoteItem.content);
                if (Util.isEqual(msgQuoteItem.zFK, z.aTY())) {
                    caVar2.nv(1);
                }
                caVar = caVar2;
            } else {
                caVar = aJ;
            }
            switch (msgQuoteItem.type) {
                case 1:
                case 11:
                case 21:
                case 31:
                case 36:
                case 301989937:
                    Intent intent = new Intent(aVar.Pwc.getContext(), TextPreviewUI.class);
                    intent.addFlags(67108864);
                    intent.putExtra("key_chat_text", msgQuoteItem.content);
                    intent.putExtra("Chat_Msg_Id", caVar.field_msgId);
                    intent.putExtra("key_msg_type", 1);
                    intent.putExtra("is_group_chat", aVar.gRM());
                    Activity context = aVar.Pwc.getContext();
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    com.tencent.mm.ui.base.b.kc(aVar.Pwc.getContext());
                    break;
                case 3:
                case 13:
                case 23:
                case 33:
                case 39:
                case 268435505:
                    if (caVar.field_msgId != 0) {
                        new av.c(aVar, cVar, caVar, view);
                        break;
                    } else {
                        Intent intent2 = new Intent();
                        intent2.setClassName(aVar.Pwc.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
                        intent2.putExtra("clean_view_type", 1);
                        com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                        com.tencent.mm.hellhoundlib.a.a.a(aVar, bl2.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        aVar.startActivity((Intent) bl2.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        break;
                    }
                case 43:
                case 44:
                case 62:
                    if (caVar.field_msgId != 0) {
                        new be.c(aVar, caVar, view);
                        break;
                    } else {
                        Intent intent3 = new Intent();
                        intent3.setClassName(aVar.Pwc.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
                        intent3.putExtra("clean_view_type", 0);
                        com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
                        com.tencent.mm.hellhoundlib.a.a.a(aVar, bl3.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        aVar.startActivity((Intent) bl3.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        break;
                    }
                case 47:
                    bi mU = bi.mU(msgQuoteItem.zFJ, caVar.field_content);
                    if (mU != null) {
                        caVar.Cz(mU.md5);
                    }
                    new aq.d(aVar, caVar);
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                    new aw.c(aVar, caVar);
                    break;
                case 49:
                case 805306417:
                case 822083633:
                    k.b HD = k.b.HD(caVar.field_content);
                    if (HD != null) {
                        boolean z2 = false;
                        switch (HD.type) {
                            case 1:
                                break;
                            case 3:
                            case 4:
                            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
                                if (!aI(caVar)) {
                                    e.d.a(HD, aVar, cVar, caVar);
                                    break;
                                } else {
                                    e.C2107e.f(HD, aVar, cVar, caVar);
                                    break;
                                }
                            case 5:
                                if (!aI(caVar)) {
                                    e.d.e(HD, aVar, cVar, caVar);
                                    break;
                                } else {
                                    e.C2107e.j(HD, aVar, cVar, caVar);
                                    break;
                                }
                            case 6:
                                if (z) {
                                    Intent intent4 = new Intent();
                                    intent4.setClassName(aVar.Pwc.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                                    intent4.putExtra("scene", 2);
                                    intent4.putExtra("app_msg_id", caVar.field_msgId);
                                    intent4.putExtra("key_msg_type", 1);
                                    intent4.putExtra("msg_type", 1);
                                    intent4.putExtra("key_quoted_msg", msgQuoteItem);
                                    com.tencent.mm.hellhoundlib.b.a bl4 = new com.tencent.mm.hellhoundlib.b.a().bl(intent4);
                                    com.tencent.mm.hellhoundlib.a.a.a(aVar, bl4.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    aVar.startActivity((Intent) bl4.pG(0));
                                    com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    break;
                                } else {
                                    u.g(aVar.Pwc.getContext(), aVar.Pwc.getContentView());
                                    AppMethodBeat.o(37034);
                                    return;
                                }
                            case 24:
                                e.a(HD, aVar, caVar);
                                break;
                            case 33:
                            case 44:
                                if (!aI(caVar)) {
                                    if (!e.d.d(HD, aVar, cVar, caVar)) {
                                        z2 = true;
                                        break;
                                    }
                                } else if (!e.C2107e.g(HD, aVar, cVar, caVar)) {
                                    z2 = true;
                                    break;
                                }
                                break;
                            case 36:
                                if (!aI(caVar)) {
                                    e.d.b(HD, aVar, cVar, caVar);
                                    break;
                                } else {
                                    e.C2107e.b(HD, aVar, cVar, caVar);
                                    break;
                                }
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                                if (!aI(caVar)) {
                                    if (!e.d.c(HD, aVar, cVar, caVar)) {
                                        z2 = true;
                                        break;
                                    }
                                } else {
                                    e.C2107e.h(HD, aVar, cVar, caVar);
                                    break;
                                }
                                break;
                            case 53:
                            case n.CTRL_INDEX:
                                Intent intent5 = new Intent(aVar.Pwc.getContext(), TextPreviewUI.class);
                                intent5.addFlags(67108864);
                                intent5.putExtra("key_chat_text", HD.title);
                                intent5.putExtra("Chat_Msg_Id", caVar.field_msgId);
                                intent5.putExtra("key_msg_type", 1);
                                intent5.putExtra("is_group_chat", aVar.gRM());
                                Activity context2 = aVar.Pwc.getContext();
                                com.tencent.mm.hellhoundlib.b.a bl5 = new com.tencent.mm.hellhoundlib.b.a().bl(intent5);
                                com.tencent.mm.hellhoundlib.a.a.a(context2, bl5.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                context2.startActivity((Intent) bl5.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                com.tencent.mm.ui.base.b.kc(aVar.Pwc.getContext());
                                break;
                            default:
                                if (!aI(caVar)) {
                                    z2 = true;
                                    break;
                                }
                                break;
                        }
                        com.tencent.mm.plugin.msgquote.model.b.b(1, msgQuoteItem.zFI, 49, (long) HD.type);
                        if (!aI(caVar)) {
                            if (z2) {
                                e.d.e(HD, aVar, cVar, caVar);
                                break;
                            }
                        } else if (z2) {
                            e.C2107e.i(HD, aVar, cVar, caVar);
                            break;
                        }
                    }
                    break;
            }
            if (!(msgQuoteItem.type == 49 || msgQuoteItem.type == 805306417 || msgQuoteItem.type == 822083633)) {
                com.tencent.mm.plugin.msgquote.model.b.b(1, msgQuoteItem.zFI, (long) msgQuoteItem.type, 0);
            }
            AppMethodBeat.o(37034);
        }

        private static boolean aI(ca caVar) {
            if (caVar.field_isSend == 1) {
                return true;
            }
            return false;
        }
    }
}
