package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.app.d;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.g.a.kj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.card.b.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class j {

    public static class b extends c {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || (i2 != 452984881 && i2 != 520093745)) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(36903);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.rw);
                view.setTag(new a().H(view, true));
            }
            AppMethodBeat.o(36903);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            AppMethodBeat.i(36904);
            this.PhN = aVar2;
            a aVar3 = (a) aVar;
            String str2 = caVar.field_content;
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            } else {
                bVar = null;
            }
            if (!(aVar3 == null || bVar == null)) {
                aVar3.a(aVar2.Pwc.getContext(), bVar, caVar.field_imgPath, this.qoo);
            }
            bq bqVar = new bq(caVar, aVar2.gRM(), i2, (String) null, (char) 0);
            if (aVar.clickArea != null) {
                aVar.clickArea.setTag(bqVar);
                aVar.clickArea.setOnClickListener(d(aVar2));
                if (this.qoo) {
                    aVar.clickArea.setOnLongClickListener(c(aVar2));
                    aVar.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
                }
            }
            AppMethodBeat.o(36904);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233625);
            int i2 = ((bq) view.getTag()).position;
            if (caVar.field_content == null) {
                AppMethodBeat.o(233625);
                return true;
            }
            k.b HD = k.b.HD(bp.b(this.PhN.gRM(), caVar.field_content, caVar.field_isSend));
            if (HD == null) {
                AppMethodBeat.o(233625);
                return true;
            }
            switch (HD.type) {
                case 34:
                    mVar.clear();
                    mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
                    AppMethodBeat.o(233625);
                    return false;
                case 16:
                    if (HD.ixV == 5 || HD.ixV == 6 || HD.ixV == 2) {
                        if (HD.ixV != 2) {
                            mVar.clear();
                        }
                        mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
                        mVar.a(i2, 122, this.PhN.Pwc.getContext().getString(R.string.b0_), R.raw.icons_filled_multiple_choice);
                        AppMethodBeat.o(233625);
                        return false;
                    }
            }
            AppMethodBeat.o(233625);
            return true;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(36906);
            switch (menuItem.getItemId()) {
                case 103:
                    String str = caVar.field_content;
                    if (str != null) {
                        k.b HD = k.b.HD(str);
                        if (HD != null) {
                            switch (HD.type) {
                                case 16:
                                    kj kjVar = new kj();
                                    kjVar.dPt.dPu = HD.dPu;
                                    kjVar.dPt.dFm = caVar.field_msgId;
                                    kjVar.dPt.dPv = caVar.field_talker;
                                    EventCenter.instance.publish(kjVar);
                                    break;
                            }
                        }
                        AppMethodBeat.o(36906);
                        break;
                    } else {
                        AppMethodBeat.o(36906);
                        break;
                    }
                case 111:
                    String b2 = bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend);
                    Intent intent = new Intent(aVar.Pwc.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", b2);
                    k.b HD2 = k.b.HD(b2);
                    if (HD2 == null || 16 != HD2.type) {
                        intent.putExtra("Retr_Msg_Type", 2);
                    } else {
                        intent.putExtra("Retr_Msg_Type", 14);
                    }
                    intent.putExtra("Retr_Msg_Id", caVar.field_msgId);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgCouponCard$ChattingItemAppMsgCouponCardFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    aVar.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgCouponCard$ChattingItemAppMsgCouponCardFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(36906);
                    break;
                default:
                    AppMethodBeat.o(36906);
                    break;
            }
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            String str;
            int i2;
            AppMethodBeat.i(36907);
            if (!WeChatBrands.Business.Entries.SessionCouponCard.checkAvailable(view.getContext())) {
                AppMethodBeat.o(36907);
                return true;
            }
            ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
            String str2 = caVar.field_content;
            if (str2 == null) {
                AppMethodBeat.o(36907);
                return false;
            }
            k.b HD = k.b.HD(str2);
            if (HD == null) {
                AppMethodBeat.o(36907);
                return false;
            }
            switch (HD.type) {
                case 16:
                    if (Util.isNullOrNil(HD.dPu)) {
                        AppMethodBeat.o(36907);
                        return false;
                    }
                    Intent intent = new Intent();
                    intent.setFlags(65536);
                    intent.putExtra("key_card_app_msg", HD.dPu);
                    intent.putExtra("key_from_scene", HD.ixV);
                    com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "card", ".ui.CardDetailUI", intent);
                    c(aVar, caVar);
                    AppMethodBeat.o(36907);
                    return true;
                case 34:
                    h d2 = h.d(HD);
                    if (1 < d2.ver) {
                        String R = q.R(HD.iwH, "message");
                        PackageInfo packageInfo = getPackageInfo(aVar.Pwc.getContext(), HD.appId);
                        if (packageInfo == null) {
                            str = null;
                        } else {
                            str = packageInfo.versionName;
                        }
                        if (packageInfo == null) {
                            i2 = 0;
                        } else {
                            i2 = packageInfo.versionCode;
                        }
                        a(aVar, R, R, str, i2, HD.appId, true, caVar.field_msgId, caVar.field_msgSvrId, caVar);
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("key_from_user_name", a(aVar, caVar));
                        intent2.putExtra("key_biz_uin", d2.ixX);
                        intent2.putExtra("key_order_id", d2.ixY);
                        if (caVar.field_talker != null && !caVar.field_talker.equals("") && ab.Eq(caVar.field_talker)) {
                            intent2.putExtra("key_chatroom_name", caVar.field_talker);
                        }
                        com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "card", ".ui.CardGiftAcceptUI", intent2);
                    }
                    c(aVar, caVar);
                    AppMethodBeat.o(36907);
                    return true;
                default:
                    AppMethodBeat.o(36907);
                    return false;
            }
        }
    }

    public static class c extends c {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || (i2 != 452984881 && i2 != 520093745)) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(36908);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.t_);
                view.setTag(new a().H(view, false));
            }
            AppMethodBeat.o(36908);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            AppMethodBeat.i(36909);
            this.PhN = aVar2;
            a aVar3 = (a) aVar;
            String str2 = caVar.field_content;
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            } else {
                bVar = null;
            }
            if (!(aVar3 == null || bVar == null)) {
                aVar3.a(aVar2.Pwc.getContext(), bVar, caVar.field_imgPath, this.qoo);
            }
            aVar.clickArea.setTag(new bq(caVar, aVar2.gRM(), i2, (String) null, (char) 0));
            aVar.clickArea.setOnClickListener(d(aVar2));
            if (this.qoo) {
                aVar.clickArea.setOnLongClickListener(c(aVar2));
                aVar.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
            }
            AppMethodBeat.o(36909);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233626);
            int i2 = ((bq) view.getTag()).position;
            if (caVar.field_content == null) {
                AppMethodBeat.o(233626);
                return true;
            }
            k.b HD = k.b.HD(bp.b(this.PhN.gRM(), caVar.field_content, caVar.field_isSend));
            if (HD == null) {
                AppMethodBeat.o(233626);
                return true;
            }
            switch (HD.type) {
                case 34:
                    mVar.clear();
                    mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
                    AppMethodBeat.o(233626);
                    return false;
                case 16:
                    if (HD.ixV == 5 || HD.ixV == 6 || HD.ixV == 2) {
                        if (HD.ixV != 2) {
                            mVar.clear();
                        }
                        mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
                        mVar.a(i2, 122, this.PhN.Pwc.getContext().getString(R.string.b0_), R.raw.icons_filled_multiple_choice);
                        AppMethodBeat.o(233626);
                        return false;
                    }
            }
            AppMethodBeat.o(233626);
            return true;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(36911);
            switch (menuItem.getItemId()) {
                case 103:
                    String str = caVar.field_content;
                    if (str != null) {
                        k.b HD = k.b.HD(str);
                        if (HD != null) {
                            switch (HD.type) {
                                case 16:
                                    kj kjVar = new kj();
                                    kjVar.dPt.dPu = HD.dPu;
                                    kjVar.dPt.dFm = caVar.field_msgId;
                                    kjVar.dPt.dPv = caVar.field_talker;
                                    EventCenter.instance.publish(kjVar);
                                    break;
                            }
                        }
                        AppMethodBeat.o(36911);
                        break;
                    } else {
                        AppMethodBeat.o(36911);
                        break;
                    }
                case 111:
                    String b2 = bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend);
                    Intent intent = new Intent(aVar.Pwc.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", b2);
                    k.b HD2 = k.b.HD(b2);
                    if (HD2 == null || 16 != HD2.type) {
                        intent.putExtra("Retr_Msg_Type", 2);
                    } else {
                        intent.putExtra("Retr_Msg_Type", 14);
                    }
                    intent.putExtra("Retr_Msg_Id", caVar.field_msgId);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgCouponCard$ChattingItemAppMsgCouponCardTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    aVar.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgCouponCard$ChattingItemAppMsgCouponCardTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(36911);
                    break;
                default:
                    AppMethodBeat.o(36911);
                    break;
            }
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            String str;
            int i2;
            AppMethodBeat.i(36912);
            ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
            String str2 = caVar.field_content;
            if (str2 == null) {
                AppMethodBeat.o(36912);
                return false;
            }
            k.b HD = k.b.HD(str2);
            if (HD == null) {
                AppMethodBeat.o(36912);
                return false;
            }
            switch (HD.type) {
                case 16:
                    if (Util.isNullOrNil(HD.dPu)) {
                        AppMethodBeat.o(36912);
                        return false;
                    }
                    Intent intent = new Intent();
                    intent.setFlags(65536);
                    intent.putExtra("key_card_app_msg", HD.dPu);
                    intent.putExtra("key_from_scene", HD.ixV);
                    com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "card", ".ui.CardDetailUI", intent);
                    AppMethodBeat.o(36912);
                    return true;
                case 34:
                    h d2 = h.d(HD);
                    if (1 < d2.ver) {
                        String R = q.R(HD.iwH, "message");
                        PackageInfo packageInfo = getPackageInfo(aVar.Pwc.getContext(), HD.appId);
                        if (packageInfo == null) {
                            str = null;
                        } else {
                            str = packageInfo.versionName;
                        }
                        if (packageInfo == null) {
                            i2 = 0;
                        } else {
                            i2 = packageInfo.versionCode;
                        }
                        a(aVar, R, R, str, i2, HD.appId, true, caVar.field_msgId, caVar.field_msgSvrId, caVar);
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("key_from_user_name", a(aVar, caVar));
                        intent2.putExtra("key_biz_uin", d2.ixX);
                        intent2.putExtra("key_order_id", d2.ixY);
                        if (caVar.field_talker != null && !caVar.field_talker.equals("") && ab.Eq(caVar.field_talker)) {
                            intent2.putExtra("key_chatroom_name", caVar.field_talker);
                        }
                        com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "card", ".ui.CardGiftAcceptUI", intent2);
                    }
                    AppMethodBeat.o(36912);
                    return true;
                default:
                    AppMethodBeat.o(36912);
                    return false;
            }
        }
    }

    static class a extends c.a {
        public static final int PJW = (((int) com.tencent.mm.cb.a.getDensity(d.dks.getApplication())) * 64);
        public TextView EVj;
        public MMImageView PHM;
        public boolean PJV;
        public int PJa = 0;
        public TextView jBR;
        public TextView jVO;
        public View lJG;

        a() {
        }

        static {
            AppMethodBeat.i(36902);
            AppMethodBeat.o(36902);
        }

        public final a H(View view, boolean z) {
            AppMethodBeat.i(36900);
            super.create(view);
            this.PJV = z;
            this.timeTV = (TextView) this.convertView.findViewById(R.id.ayf);
            this.checkBox = (CheckBox) view.findViewById(R.id.aue);
            this.maskView = this.convertView.findViewById(R.id.ax3);
            this.userTV = (TextView) this.convertView.findViewById(R.id.ayn);
            this.PHM = (MMImageView) this.convertView.findViewById(R.id.u9);
            this.jVO = (TextView) this.convertView.findViewById(R.id.u_);
            this.jBR = (TextView) this.convertView.findViewById(R.id.u8);
            this.EVj = (TextView) this.convertView.findViewById(R.id.u6);
            this.lJG = this.convertView.findViewById(R.id.u7);
            this.PJa = c.kl(MMApplicationContext.getContext());
            AppMethodBeat.o(36900);
            return this;
        }

        public final void a(final Context context, k.b bVar, String str, boolean z) {
            AppMethodBeat.i(36901);
            resetChatBubbleWidth(this.clickArea, this.PJa);
            switch (bVar.type) {
                case 16:
                    this.jVO.setText(bVar.description);
                    this.jBR.setText(bVar.ixU);
                    this.PHM.setVisibility(0);
                    if (z) {
                        com.tencent.mm.av.a.a bcV = com.tencent.mm.av.q.bcV();
                        String str2 = bVar.thumburl;
                        MMImageView mMImageView = this.PHM;
                        c.a aVar = new c.a();
                        int i2 = PJW;
                        c.a dr = aVar.dr(i2, i2);
                        dr.jbq = R.raw.app_attach_file_icon_webpage;
                        dr.iaT = true;
                        bcV.a(str2, mMImageView, dr.bdv());
                        AppMethodBeat.o(36901);
                        return;
                    }
                    this.PHM.setImageResource(R.drawable.bjm);
                    AppMethodBeat.o(36901);
                    return;
                case 34:
                    if (bVar.title == null || bVar.title.length() <= 0) {
                        this.jVO.setVisibility(8);
                    } else {
                        this.jVO.setVisibility(0);
                        this.jVO.setText(bVar.title);
                        if (!Util.isNullOrNil(bVar.iyd)) {
                            this.jVO.setTextColor(Util.convertStringToRGB(bVar.iyd, context.getResources().getColor(R.color.a2x)));
                        } else {
                            this.jVO.setTextColor(context.getResources().getColor(R.color.a2x));
                        }
                    }
                    this.jBR.setMaxLines(2);
                    this.jBR.setVisibility(0);
                    this.jBR.setText(bVar.description);
                    if (!Util.isNullOrNil(bVar.iye)) {
                        this.jBR.setTextColor(Util.convertStringToRGB(bVar.iye, context.getResources().getColor(R.color.tx)));
                    } else {
                        this.jBR.setTextColor(context.getResources().getColor(R.color.tx));
                    }
                    if (!Util.isNullOrNil(bVar.ixZ)) {
                        this.EVj.setText(bVar.ixZ);
                    } else {
                        this.EVj.setText(R.string.azr);
                    }
                    if (!z) {
                        this.PHM.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.bjm));
                        AppMethodBeat.o(36901);
                        return;
                    } else if (!Util.isNullOrNil(bVar.iyc)) {
                        com.tencent.mm.av.a.a bcV2 = com.tencent.mm.av.q.bcV();
                        String str3 = bVar.thumburl;
                        MMImageView mMImageView2 = this.PHM;
                        c.a aVar2 = new c.a();
                        int i3 = PJW;
                        c.a dr2 = aVar2.dr(i3, i3);
                        dr2.jbq = R.raw.app_attach_file_icon_webpage;
                        dr2.iaT = true;
                        bcV2.a(str3, mMImageView2, dr2.bdv());
                        com.tencent.mm.av.a.a bcV3 = com.tencent.mm.av.q.bcV();
                        String str4 = bVar.iyc;
                        ImageView imageView = new ImageView(context);
                        c.a aVar3 = new c.a();
                        aVar3.jbf = true;
                        bcV3.a(str4, imageView, aVar3.bdv(), new com.tencent.mm.av.a.c.h() {
                            /* class com.tencent.mm.ui.chatting.viewitems.j.a.AnonymousClass1 */

                            @Override // com.tencent.mm.av.a.c.h
                            public final void b(String str, View view) {
                            }

                            @Override // com.tencent.mm.av.a.c.h
                            public final Bitmap a(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                                return null;
                            }

                            @Override // com.tencent.mm.av.a.c.h
                            public final void b(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                                AppMethodBeat.i(36898);
                                if (bVar.bitmap != null) {
                                    final Bitmap bitmap = bVar.bitmap;
                                    a.this.lJG.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                                        /* class com.tencent.mm.ui.chatting.viewitems.j.a.AnonymousClass1.AnonymousClass1 */

                                        public final boolean onPreDraw() {
                                            Bitmap createMaskImage;
                                            AppMethodBeat.i(36897);
                                            a.this.lJG.getViewTreeObserver().removeOnPreDrawListener(this);
                                            int height = a.this.lJG.getHeight();
                                            int width = a.this.lJG.getWidth();
                                            if (height == 0) {
                                                height = com.tencent.mm.cb.a.aG(context, R.dimen.x_);
                                            }
                                            if (width == 0) {
                                                width = com.tencent.mm.cb.a.aG(context, R.dimen.xa);
                                            }
                                            if (a.this.PJV) {
                                                createMaskImage = BitmapUtil.createMaskImage(bitmap, R.drawable.c3c, width, height);
                                            } else {
                                                createMaskImage = BitmapUtil.createMaskImage(bitmap, R.drawable.c3n, width, height);
                                            }
                                            a.this.lJG.setBackgroundDrawable(new BitmapDrawable(createMaskImage));
                                            AppMethodBeat.o(36897);
                                            return true;
                                        }
                                    });
                                }
                                AppMethodBeat.o(36898);
                            }
                        });
                        AppMethodBeat.o(36901);
                        return;
                    } else {
                        final Bitmap a2 = com.tencent.mm.av.q.bcR().a(str, com.tencent.mm.cb.a.getDensity(context), false);
                        if (a2 == null || a2.isRecycled()) {
                            com.tencent.mm.av.a.a bcV4 = com.tencent.mm.av.q.bcV();
                            String str5 = bVar.thumburl;
                            MMImageView mMImageView3 = this.PHM;
                            c.a aVar4 = new c.a();
                            int i4 = PJW;
                            c.a dr3 = aVar4.dr(i4, i4);
                            dr3.jbq = R.raw.app_attach_file_icon_webpage;
                            dr3.iaT = true;
                            bcV4.a(str5, mMImageView3, dr3.bdv());
                        } else {
                            this.PHM.setImageBitmap(BitmapUtil.getRoundedCornerBitmap(a2, false, (float) (a2.getWidth() / 2)));
                        }
                        this.lJG.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                            /* class com.tencent.mm.ui.chatting.viewitems.j.a.AnonymousClass2 */
                            private boolean qCs = false;

                            public final boolean onPreDraw() {
                                Bitmap createMaskImage;
                                AppMethodBeat.i(36899);
                                if (this.qCs) {
                                    a.this.lJG.getViewTreeObserver().removeOnPreDrawListener(this);
                                    AppMethodBeat.o(36899);
                                } else {
                                    a.this.lJG.getViewTreeObserver().removeOnPreDrawListener(this);
                                    this.qCs = true;
                                    int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(context, 24);
                                    Bitmap bitmap = a2;
                                    if (bitmap == null || bitmap.isRecycled()) {
                                        bitmap = BitmapUtil.createColorBitmap(context.getResources().getColor(R.color.iu), fromDPToPix, fromDPToPix);
                                    }
                                    int height = bitmap.getHeight();
                                    if (fromDPToPix <= height) {
                                        height = fromDPToPix;
                                    }
                                    Bitmap fastblur = BitmapUtil.fastblur(BitmapUtil.setContrast(Bitmap.createScaledBitmap(bitmap, height, height, true), 0.9f), 20);
                                    int height2 = a.this.lJG.getHeight();
                                    int width = a.this.lJG.getWidth();
                                    if (height2 == 0) {
                                        height2 = com.tencent.mm.cb.a.aG(context, R.dimen.x_);
                                    }
                                    if (width == 0) {
                                        width = com.tencent.mm.cb.a.aG(context, R.dimen.xa);
                                    }
                                    if (a.this.PJV) {
                                        createMaskImage = BitmapUtil.createMaskImage(fastblur, R.drawable.c3c, width, height2);
                                    } else {
                                        createMaskImage = BitmapUtil.createMaskImage(fastblur, R.drawable.c3n, width, height2);
                                    }
                                    a.this.lJG.setBackgroundDrawable(new BitmapDrawable(createMaskImage));
                                    AppMethodBeat.o(36899);
                                }
                                return true;
                            }
                        });
                        AppMethodBeat.o(36901);
                        return;
                    }
                default:
                    this.jVO.setText(bVar.description);
                    this.jBR.setText(bVar.ixU);
                    this.PHM.setVisibility(0);
                    if (z) {
                        com.tencent.mm.av.a.a bcV5 = com.tencent.mm.av.q.bcV();
                        String R = com.tencent.mm.av.q.bcR().R(str, true);
                        MMImageView mMImageView4 = this.PHM;
                        c.a aVar5 = new c.a();
                        aVar5.jbi = 1;
                        int i5 = PJW;
                        c.a dr4 = aVar5.dr(i5, i5);
                        dr4.jbq = R.raw.app_attach_file_icon_webpage;
                        dr4.iaT = true;
                        bcV5.a(R, mMImageView4, dr4.bdv());
                        AppMethodBeat.o(36901);
                        return;
                    }
                    this.PHM.setImageResource(R.drawable.bjm);
                    AppMethodBeat.o(36901);
                    return;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c.a
        public final View getMainContainerView() {
            return this.convertView;
        }
    }
}
