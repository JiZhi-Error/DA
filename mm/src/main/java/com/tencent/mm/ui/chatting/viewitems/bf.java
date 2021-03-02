package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.b.a.gn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.pluginsdk.model.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.a.a;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.d.b.at;
import com.tencent.mm.ui.chatting.d.b.au;
import com.tencent.mm.ui.chatting.d.b.aw;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.bi;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.smtt.sdk.TbsListener;

public final class bf {
    static /* synthetic */ boolean b(int i2, com.tencent.mm.ui.chatting.e.a aVar, ca caVar, at atVar, boolean z) {
        AppMethodBeat.i(233967);
        boolean a2 = a(i2, aVar, caVar, atVar, z);
        AppMethodBeat.o(233967);
        return a2;
    }

    public static final class b extends c implements t.n {
        private int KdF = 3;
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != 34) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37477);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.tj);
                view.setTag(new c().e(view, false, this.Pdm));
            }
            AppMethodBeat.o(37477);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, final com.tencent.mm.ui.chatting.e.a aVar2, final ca caVar, String str) {
            ChattingItemTranslate.c cVar;
            String str2;
            AppMethodBeat.i(37478);
            this.PhN = aVar2;
            c cVar2 = (c) aVar;
            cVar2.PPL.setFromVoice(false);
            cVar2.PPL.setFromGroup(aVar2.gRM());
            k kVar = (k) aVar2.bh(k.class);
            b(kVar, caVar.field_msgId);
            c.a(this, cVar2, caVar, i2, aVar2, false, c(aVar2), this);
            at atVar = (at) aVar2.bh(at.class);
            final String str3 = null;
            ChattingItemTranslate.c cVar3 = ChattingItemTranslate.c.NoTransform;
            if (bf.d(caVar, aVar2)) {
                str3 = atVar.S(caVar.field_msgId, caVar.field_imgPath);
                if (!Util.isNullOrNil(str3)) {
                    cVar = ChattingItemTranslate.c.Transformed;
                }
                cVar = cVar3;
            } else {
                if (atVar.NC(caVar.field_msgId)) {
                    str3 = atVar.S(caVar.field_msgId, caVar.field_imgPath);
                    cVar = atVar.NB(caVar.field_msgId);
                }
                cVar = cVar3;
            }
            if (!Util.isNullOrNil(str3) || cVar != ChattingItemTranslate.c.NoTransform) {
                if (cVar2.PKI == null) {
                    cVar2.PKI = (ChattingItemTranslate) cVar2.PKH.inflate();
                    cVar2.PKI.setMinimumWidth(cVar2.PPI - com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 5));
                    cVar2.PKI.init();
                }
                Context context = cVar2.PNK.getContext();
                int textSize = (int) cVar2.PKI.getContentView().getTextSize();
                if (caVar != null) {
                    str2 = ad.JX(new StringBuilder().append(caVar.field_msgSvrId).toString());
                    ad.b G = ad.aVe().G(str2, true);
                    G.l("prePublishId", "msg_" + caVar.field_msgSvrId);
                    G.l("preUsername", a(this.PhN, caVar));
                    G.l("preChatName", b(this.PhN, caVar));
                } else {
                    str2 = null;
                }
                SpannableString a2 = l.a(context, str3, textSize, 1, (Object) null, str2);
                cVar2.PKI.a(a2, cVar, atVar.NF(caVar.field_msgId), ChattingItemTranslate.b.Voice, caVar.field_msgId, aVar2);
                if (!Util.isNullOrNil(a2) && atVar.NF(caVar.field_msgId)) {
                    atVar.NG(caVar.field_msgId);
                }
                ChattingItemTranslate.a aVar3 = new ChattingItemTranslate.a(caVar, aVar2.gRM(), i2);
                aVar3.qcr = 2;
                cVar2.PKI.setTag(aVar3);
                cVar2.PKI.setOnLongClickListener(c(aVar2));
                cVar2.PKI.setVisibility(0);
                if (!Util.isNullOrNil(str3)) {
                    cVar2.PKI.setOnTouchListener(kVar.gOC());
                    cVar2.PKI.setOnDoubleClickListener(new NeatTextView.b() {
                        /* class com.tencent.mm.ui.chatting.viewitems.bf.b.AnonymousClass1 */

                        @Override // com.tencent.neattextview.textview.view.NeatTextView.b
                        public final boolean gS(View view) {
                            AppMethodBeat.i(37475);
                            c.a(MMApplicationContext.getContext(), str3, aVar2);
                            bf.cQ(caVar);
                            AppMethodBeat.o(37475);
                            return true;
                        }
                    });
                }
            } else if (cVar2.PKI != null) {
                cVar2.PKI.setVisibility(8);
            }
            if (gTW()) {
                if (cVar2.PPR != null) {
                    cVar2.PPR.setVisibility(8);
                }
                if (cVar2.PIn != null) {
                    cVar2.PIn.setVisibility(8);
                }
                if (caVar.field_status == 1 || caVar.field_status == 5) {
                    cVar2.PPS.setBackgroundResource(R.drawable.or);
                    caVar.OqF = true;
                } else {
                    cVar2.PPS.setBackgroundResource(R.drawable.oq);
                    if (cVar2.PIn != null && b(kVar, caVar.field_msgId)) {
                        if (caVar.OqF) {
                            AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
                            alphaAnimation.setDuration(300);
                            cVar2.PPS.startAnimation(alphaAnimation);
                            caVar.OqF = false;
                        }
                        cVar2.PIn.setVisibility(0);
                    }
                }
            } else if (cVar2.PPR != null) {
                cVar2.PPR.setVisibility(0);
                if (caVar.field_status >= 2) {
                    cVar2.PPR.setVisibility(8);
                }
            }
            a(i2, cVar2, caVar, aVar2.gRI(), aVar2.gRM(), aVar2, this);
            AppMethodBeat.o(37478);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            int i2;
            boolean z = false;
            AppMethodBeat.i(233960);
            bg.aVF();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                ChattingItemTranslate.a aVar = (ChattingItemTranslate.a) view.getTag();
                int i3 = aVar.position;
                if (aVar.qcr == 1) {
                    p pVar = new p(caVar.field_content);
                    if (!((pVar.time == 0 && caVar.field_isSend == 0) || (caVar.field_status == 1 && caVar.field_isSend == 1))) {
                        if (((aw) this.PhN.bh(aw.class)).gRz()) {
                            mVar.a(i3, 120, view.getContext().getString(R.string.avy), R.raw.icons_filled_volume_up);
                        } else {
                            mVar.a(i3, 119, view.getContext().getString(R.string.avx), R.raw.icons_filled_ear);
                        }
                    }
                    if (caVar.field_status == 5) {
                        mVar.a(i3, 103, view.getContext().getString(R.string.b1y), R.raw.icons_filled_refresh);
                    }
                    if (com.tencent.mm.br.c.aZU("favorite")) {
                        mVar.a(i3, 116, view.getContext().getString(R.string.fn9), R.raw.icons_filled_favorites);
                    }
                    if (!caVar.gAt() && caVar.gAy() && ((caVar.field_status == 2 || caVar.fQV == 1) && b(caVar, this.PhN) && bnf(caVar.field_talker))) {
                        mVar.a(i3, 123, view.getContext().getString(R.string.b0i), R.raw.icons_filled_previous);
                    }
                    at atVar = (at) this.PhN.bh(at.class);
                    if (bf.d(caVar, this.PhN)) {
                        if (Util.isNullOrNil(atVar.S(caVar.field_msgId, caVar.field_imgPath))) {
                            i2 = R.string.b0s;
                        }
                        i2 = -1;
                    } else {
                        if (!atVar.NC(caVar.field_msgId)) {
                            i2 = R.string.b0s;
                        }
                        i2 = -1;
                    }
                    if (ab.IT(caVar.field_talker) && LocaleUtil.isChineseAppLang() && i2 != -1) {
                        mVar.a(i3, 121, view.getContext().getString(R.string.b0s), R.raw.icons_filled_transfer_text);
                        z = true;
                    }
                    if (!(pVar.time == 0 && caVar.field_isSend == 0) && (!(caVar.field_status == 1 && caVar.field_isSend == 1) && !this.PhN.gRN())) {
                        mVar.a(i3, 100, view.getContext().getString(R.string.b08), R.raw.icons_filled_delete);
                    }
                    if (!z && LocaleUtil.isChineseAppLang() && i2 != -1) {
                        mVar.a(i3, 121, view.getContext().getString(i2), R.raw.icons_filled_transfer_text);
                    }
                    AppMethodBeat.o(233960);
                    return true;
                } else if (aVar.qcr == 2) {
                    at atVar2 = (at) this.PhN.bh(at.class);
                    if (atVar2.NB(caVar.field_msgId) == ChattingItemTranslate.c.Transforming) {
                        mVar.add(i3, 121, 0, R.string.b0o);
                    } else {
                        if (!Util.isNullOrNil(atVar2.S(caVar.field_msgId, caVar.field_imgPath))) {
                            mVar.a(i3, 141, view.getContext().getString(R.string.b03), R.raw.icons_filled_copy);
                            mVar.a(i3, TbsListener.ErrorCode.NEEDDOWNLOAD_3, view.getContext().getString(R.string.g5c), R.raw.icons_filled_share);
                            if (com.tencent.mm.br.c.aZU("favorite")) {
                                mVar.a(i3, TbsListener.ErrorCode.NEEDDOWNLOAD_4, view.getContext().getString(R.string.fn9), R.raw.icons_filled_favorites);
                            }
                        }
                        mVar.a(i3, 121, view.getContext().getString(R.string.b0q), R.raw.icons_filled_eyes_off);
                    }
                    AppMethodBeat.o(233960);
                    return false;
                }
            }
            AppMethodBeat.o(233960);
            return true;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37480);
            at atVar = (at) aVar.bh(at.class);
            switch (menuItem.getItemId()) {
                case 103:
                    ((aw) aVar.bh(aw.class)).cm(caVar);
                    break;
                case 119:
                    ((aw) aVar.bh(aw.class)).BV(true);
                    AppMethodBeat.o(37480);
                    return true;
                case 120:
                    ((aw) aVar.bh(aw.class)).BV(false);
                    AppMethodBeat.o(37480);
                    return true;
                case 121:
                    if (!WeChatBrands.Business.Entries.SessionSpeech2TextSnd.checkAvailable(aVar.Pwc.getContext())) {
                        AppMethodBeat.o(37480);
                        return true;
                    }
                    boolean b2 = bf.b(menuItem.getGroupId(), aVar, caVar, atVar, false);
                    AppMethodBeat.o(37480);
                    return b2;
                case 141:
                    String S = atVar.S(caVar.field_msgId, caVar.field_imgPath);
                    if (!Util.isNullOrNil(S)) {
                        ClipboardHelper.setText(S);
                    }
                    bf.e(8, caVar);
                    AppMethodBeat.o(37480);
                    return true;
                case TbsListener.ErrorCode.NEEDDOWNLOAD_3 /*{ENCODED_INT: 142}*/:
                    Intent intent = new Intent(aVar.Pwc.getContext(), MsgRetransmitUI.class);
                    String S2 = atVar.S(caVar.field_msgId, caVar.field_imgPath);
                    if (caVar.gDg()) {
                        intent.putExtra("Retr_Msg_content", S2);
                        intent.putExtra("Retr_Msg_Type", 6);
                    } else {
                        intent.putExtra("Retr_Msg_content", S2);
                        intent.putExtra("Retr_Msg_Type", 4);
                    }
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    aVar.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    bf.e(9, caVar);
                    AppMethodBeat.o(37480);
                    return true;
                case TbsListener.ErrorCode.NEEDDOWNLOAD_4 /*{ENCODED_INT: 143}*/:
                    String S3 = atVar.S(caVar.field_msgId, caVar.field_imgPath);
                    cz czVar = new cz();
                    h.b(czVar, S3, 1);
                    czVar.dFZ.fragment = aVar.Pwc;
                    czVar.dFZ.dGf = 43;
                    if (czVar.dFZ.dGb != null) {
                        anh anh = czVar.dFZ.dGb.Lya;
                        if (anh != null) {
                            anh.bhf(z.aTY());
                            anh.bhg(caVar.field_talker);
                            EventCenter.instance.publish(czVar);
                        }
                    } else {
                        Log.e("MicroMsg.ChattingItemVoice", "alvinluo transform text fav failed");
                    }
                    bf.e(10, caVar);
                    AppMethodBeat.o(37480);
                    return true;
            }
            AppMethodBeat.o(37480);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.t.n
        public final void b(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233961);
            ((aw) aVar.bh(aw.class)).cm(caVar);
            AppMethodBeat.o(233961);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, final com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37481);
            if (caVar.field_status == 5) {
                Log.i("MicroMsg.ChattingItemVoice", "onItemClick msg(%s) fail", Long.valueOf(caVar.field_msgId));
                AppMethodBeat.o(37481);
            } else {
                if (caVar.gDP()) {
                    ((aw) aVar.bh(aw.class)).a(caVar.field_msgId, view);
                    if (((aw) aVar.bh(aw.class)).NK(caVar.field_msgId)) {
                        Log.i("MicroMsg.ChattingItemVoice", "onCreateContextMenu: voice msg show download animation");
                        AppMethodBeat.o(37481);
                    } else {
                        ca Hb = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(caVar.field_msgId);
                        if (Hb.gDP()) {
                            ((aw) aVar.bh(aw.class)).NJ(Hb.field_msgId);
                            o.bid().run();
                            com.tencent.f.h.RTc.aV(new Runnable() {
                                /* class com.tencent.mm.ui.chatting.viewitems.bf.b.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(233959);
                                    aVar.cmy();
                                    AppMethodBeat.o(233959);
                                }
                            });
                            Log.i("MicroMsg.ChattingItemVoice", "onItemClick voice msg(%s) no finish download!", Long.valueOf(caVar.field_msgId));
                            AppMethodBeat.o(37481);
                        }
                    }
                }
                ((aw) aVar.bh(aw.class)).gRA();
                bq bqVar = (bq) view.getTag();
                com.tencent.mm.modelstat.b.jmd.ae(bqVar.dTX);
                bf.b(aVar, bqVar);
                ((at) aVar.bh(at.class)).amG(2);
                ((au) aVar.bh(au.class)).gRw();
                ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
                AppMethodBeat.o(37481);
            }
            return true;
        }
    }

    public static final class a extends c implements t.n {
        private View.OnClickListener PPE;
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || i2 != 34) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37469);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.s7);
                view.setTag(new c().e(view, true, this.Pdm));
            }
            AppMethodBeat.o(37469);
            return view;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean b(com.tencent.mm.ui.chatting.e.a aVar) {
            AppMethodBeat.i(37470);
            boolean gRM = aVar.gRM();
            AppMethodBeat.o(37470);
            return gRM;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, final int i2, final com.tencent.mm.ui.chatting.e.a aVar2, final ca caVar, String str) {
            ChattingItemTranslate.c cVar;
            int i3;
            String str2;
            AppMethodBeat.i(37471);
            this.PhN = aVar2;
            c cVar2 = (c) aVar;
            cVar2.PPL.setFromVoice(true);
            cVar2.PPL.setFromGroup(aVar2.gRM());
            k kVar = (k) aVar2.bh(k.class);
            b(kVar, caVar.field_msgId);
            c.a(this, cVar2, caVar, i2, aVar2, true, c(aVar2), this);
            final String str3 = null;
            ChattingItemTranslate.c cVar3 = ChattingItemTranslate.c.NoTransform;
            final at atVar = (at) aVar2.bh(at.class);
            if (bf.d(caVar, aVar2)) {
                str3 = atVar.S(caVar.field_msgId, caVar.field_imgPath);
                if (!Util.isNullOrNil(str3)) {
                    cVar = ChattingItemTranslate.c.Transformed;
                }
                cVar = cVar3;
            } else {
                if (atVar.NC(caVar.field_msgId)) {
                    str3 = atVar.S(caVar.field_msgId, caVar.field_imgPath);
                    cVar = atVar.NB(caVar.field_msgId);
                }
                cVar = cVar3;
            }
            if (!Util.isNullOrNil(str3) || cVar != ChattingItemTranslate.c.NoTransform) {
                if (cVar2.PKI == null) {
                    cVar2.PKI = (ChattingItemTranslate) cVar2.PKH.inflate();
                    cVar2.PKI.setMinimumWidth(cVar2.PPI - com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 5));
                    cVar2.PKI.init();
                }
                Context context = cVar2.PNK.getContext();
                int textSize = (int) cVar2.PKI.getContentView().getTextSize();
                if (caVar != null) {
                    str2 = ad.JX(new StringBuilder().append(caVar.field_msgSvrId).toString());
                    ad.b G = ad.aVe().G(str2, true);
                    G.l("prePublishId", "msg_" + caVar.field_msgSvrId);
                    G.l("preUsername", a(this.PhN, caVar));
                    G.l("preChatName", b(this.PhN, caVar));
                } else {
                    str2 = null;
                }
                SpannableString a2 = l.a(context, str3, textSize, 1, (Object) null, str2);
                cVar2.PKI.a(a2, cVar, atVar.NF(caVar.field_msgId), ChattingItemTranslate.b.Voice, caVar.field_msgId, aVar2);
                if (!Util.isNullOrNil(a2) && atVar.NF(caVar.field_msgId)) {
                    atVar.NG(caVar.field_msgId);
                }
                ChattingItemTranslate.a aVar3 = new ChattingItemTranslate.a(caVar, aVar2.gRM(), i2);
                aVar3.qcr = 2;
                cVar2.PKI.setTag(aVar3);
                ChattingItemTranslate chattingItemTranslate = cVar2.PKI;
                if (this.PPE == null) {
                    this.PPE = new View.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.viewitems.bf.a.AnonymousClass4 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(233953);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            ChattingItemTranslate.a aVar = (ChattingItemTranslate.a) ((ChattingItemTranslate) view).getTag();
                            if (((at) a.this.PhN.bh(at.class)).NB(aVar.dTX.field_msgId) == ChattingItemTranslate.c.Transforming) {
                                ((at) a.this.PhN.bh(at.class)).a(aVar.dTX, true, aVar.position, 1);
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(233953);
                        }
                    };
                }
                chattingItemTranslate.setOnClickListener(this.PPE);
                cVar2.PKI.setOnLongClickListener(c(aVar2));
                cVar2.PKI.setVisibility(0);
                if (!Util.isNullOrNil(str3)) {
                    cVar2.PKI.setOnTouchListener(kVar.gOC());
                    cVar2.PKI.setOnDoubleClickListener(new NeatTextView.b() {
                        /* class com.tencent.mm.ui.chatting.viewitems.bf.a.AnonymousClass1 */

                        @Override // com.tencent.neattextview.textview.view.NeatTextView.b
                        public final boolean gS(View view) {
                            AppMethodBeat.i(37466);
                            c.a(MMApplicationContext.getContext(), str3, aVar2);
                            bf.cQ(caVar);
                            AppMethodBeat.o(37466);
                            return true;
                        }
                    });
                }
            } else if (cVar2.PKI != null) {
                cVar2.PKI.setVisibility(8);
            }
            if (ao.isDarkMode() || !((com.tencent.mm.ui.chatting.d.b.c) aVar2.bh(com.tencent.mm.ui.chatting.d.b.c.class)).gPs()) {
                cVar2.PPV.setBackgroundResource(R.drawable.b2h);
            } else {
                cVar2.PPV.setBackgroundResource(R.drawable.b2k);
            }
            cVar2.PPV.setTextSize(0, (float) com.tencent.mm.cb.a.aH(aVar2.Pwc.getContext(), R.dimen.c5));
            if (!((aw) aVar2.bh(aw.class)).NN(caVar.field_msgId)) {
                cVar2.PPU.setVisibility(8);
            } else {
                cVar2.PPU.setVisibility(0);
            }
            cVar2.PPU.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.viewitems.bf.a.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(233951);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("MicroMsg.ChattingItemVoice", "voice fast trans text click");
                    bf.b(i2, aVar2, caVar, atVar, true);
                    a.f(2, caVar);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(233951);
                }
            });
            p pVar = new p(caVar.field_content);
            if (pVar.time == 0) {
                cVar2.stateIV.setVisibility(8);
            } else {
                d gRx = ((aw) aVar2.bh(aw.class)).gRx();
                boolean z = (gRx != null && gRx.Pei == caVar.field_msgId) || s.ai(caVar);
                ImageView imageView = cVar2.stateIV;
                if (z) {
                    i3 = 8;
                } else {
                    i3 = 0;
                }
                imageView.setVisibility(i3);
                int AO = (int) s.AO(pVar.time);
                if (!z) {
                    cVar2.PPK.setContentDescription(String.format(aVar2.Pwc.getContext().getString(R.string.hzb), Integer.valueOf(AO)));
                } else {
                    CharSequence bmF = ((f) aVar2.bh(f.class)).bmF(aVar2.getTalkerUserName());
                    com.tencent.mm.ui.a.a aVar4 = a.C2075a.OLX;
                    TextView textView = cVar2.PPK;
                    if (bmF != null) {
                        bmF.toString();
                    }
                    aVar4.aF(textView, AO);
                }
            }
            String str4 = caVar.fQR;
            if (str4 == null || str4.length() == 0) {
                cVar2.PHZ.setVisibility(8);
                AppMethodBeat.o(37471);
                return;
            }
            cVar2.PHZ.setVisibility(0);
            b(aVar2, cVar2.PHZ, bq.bnn(str4));
            AppMethodBeat.o(37471);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            boolean z;
            int i2;
            boolean z2;
            boolean z3 = false;
            AppMethodBeat.i(233955);
            bg.aVF();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                ChattingItemTranslate.a aVar = (ChattingItemTranslate.a) view.getTag();
                int i3 = aVar.position;
                if (aVar.qcr == 1) {
                    if (!((new p(caVar.field_content).time == 0 && caVar.field_isSend == 0) || (caVar.field_status == 1 && caVar.field_isSend == 1))) {
                        bg.aVF();
                        Boolean bool = (Boolean) com.tencent.mm.model.c.azQ().get(26, (Object) null);
                        if (bool == null) {
                            bool = Boolean.FALSE;
                        }
                        if (bool.booleanValue()) {
                            mVar.a(i3, 120, view.getContext().getString(R.string.avy), R.raw.icons_filled_volume_up);
                        } else {
                            mVar.a(i3, 119, view.getContext().getString(R.string.avx), R.raw.icons_filled_ear);
                        }
                        bg.aVF();
                        as Kn = com.tencent.mm.model.c.aSN().Kn(caVar.field_talker);
                        if (ab.Jf(caVar.field_talker) || ab.JE(caVar.field_talker) || Kn == null || Kn.gBM()) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (com.tencent.mm.br.c.aZU("favorite")) {
                            mVar.a(i3, 116, view.getContext().getString(R.string.fn9), R.raw.icons_filled_favorites);
                        }
                        if (z) {
                            if (ag.bah().sO(2) > 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2 && !this.PhN.gRN()) {
                                mVar.add(i3, 114, 0, view.getContext().getString(R.string.b02));
                            }
                        }
                        at atVar = (at) this.PhN.bh(at.class);
                        if (bf.d(caVar, this.PhN)) {
                            if (Util.isNullOrNil(atVar.S(caVar.field_msgId, caVar.field_imgPath))) {
                                i2 = R.string.b0s;
                            }
                            i2 = -1;
                        } else {
                            if (!atVar.NC(caVar.field_msgId)) {
                                i2 = R.string.b0s;
                            }
                            i2 = -1;
                        }
                        if (ab.IT(caVar.field_talker) && LocaleUtil.isChineseAppLang() && i2 != -1) {
                            mVar.a(i3, 121, view.getContext().getString(i2), R.raw.icons_filled_transfer_text);
                            z3 = true;
                        }
                        if (!this.PhN.gRN()) {
                            mVar.a(i3, 100, view.getContext().getString(R.string.b08), R.raw.icons_filled_delete);
                        }
                        if (!z3 && LocaleUtil.isChineseAppLang() && i2 != -1) {
                            mVar.a(i3, 121, view.getContext().getString(i2), R.raw.icons_filled_transfer_text);
                        }
                    }
                    AppMethodBeat.o(233955);
                    return true;
                } else if (aVar.qcr == 2) {
                    at atVar2 = (at) this.PhN.bh(at.class);
                    if (atVar2.NB(caVar.field_msgId) == ChattingItemTranslate.c.Transforming) {
                        mVar.add(i3, 121, 0, R.string.b0o);
                    } else {
                        if (!Util.isNullOrNil(atVar2.S(caVar.field_msgId, caVar.field_imgPath))) {
                            mVar.a(i3, 141, view.getContext().getString(R.string.b03), R.raw.icons_filled_copy);
                            mVar.a(i3, TbsListener.ErrorCode.NEEDDOWNLOAD_3, view.getContext().getString(R.string.g5c), R.raw.icons_filled_share);
                            if (com.tencent.mm.br.c.aZU("favorite")) {
                                mVar.a(i3, TbsListener.ErrorCode.NEEDDOWNLOAD_4, view.getContext().getString(R.string.fn9), R.raw.icons_filled_favorites);
                            }
                        }
                        mVar.a(i3, 121, view.getContext().getString(R.string.b0q), R.raw.icons_filled_eyes_off);
                    }
                    AppMethodBeat.o(233955);
                    return false;
                }
            }
            AppMethodBeat.o(233955);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37473);
            at atVar = (at) aVar.bh(at.class);
            switch (menuItem.getItemId()) {
                case 100:
                    ((aw) aVar.bh(aw.class)).cl(caVar);
                    ((aw) aVar.bh(aw.class)).gRB();
                    break;
                case 103:
                    ((aw) aVar.bh(aw.class)).cm(caVar);
                    break;
                case 119:
                    ((aw) aVar.bh(aw.class)).BV(true);
                    AppMethodBeat.o(37473);
                    return true;
                case 120:
                    ((aw) aVar.bh(aw.class)).BV(false);
                    AppMethodBeat.o(37473);
                    return true;
                case 121:
                    if (!WeChatBrands.Business.Entries.SessionSpeech2TextSnd.checkAvailable(aVar.Pwc.getContext())) {
                        AppMethodBeat.o(37473);
                        return true;
                    }
                    f(3, caVar);
                    boolean b2 = bf.b(menuItem.getGroupId(), aVar, caVar, atVar, true);
                    AppMethodBeat.o(37473);
                    return b2;
                case 141:
                    String S = atVar.S(caVar.field_msgId, caVar.field_imgPath);
                    if (!Util.isNullOrNil(S)) {
                        ClipboardHelper.setText(S);
                    }
                    bf.e(8, caVar);
                    break;
                case TbsListener.ErrorCode.NEEDDOWNLOAD_3 /*{ENCODED_INT: 142}*/:
                    Intent intent = new Intent(aVar.Pwc.getContext(), MsgRetransmitUI.class);
                    String S2 = atVar.S(caVar.field_msgId, caVar.field_imgPath);
                    if (caVar.gDg()) {
                        intent.putExtra("Retr_Msg_content", S2);
                        intent.putExtra("Retr_Msg_Type", 6);
                    } else {
                        intent.putExtra("Retr_Msg_content", S2);
                        intent.putExtra("Retr_Msg_Type", 4);
                    }
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    aVar.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    bf.e(9, caVar);
                    break;
                case TbsListener.ErrorCode.NEEDDOWNLOAD_4 /*{ENCODED_INT: 143}*/:
                    String S3 = atVar.S(caVar.field_msgId, caVar.field_imgPath);
                    cz czVar = new cz();
                    h.b(czVar, S3, 1);
                    czVar.dFZ.fragment = aVar.Pwc;
                    czVar.dFZ.dGf = 43;
                    if (czVar.dFZ.dGb != null) {
                        anh anh = czVar.dFZ.dGb.Lya;
                        if (anh != null) {
                            anh.bhf(caVar.field_talker);
                            anh.bhg(z.aTY());
                            EventCenter.instance.publish(czVar);
                        }
                    } else {
                        Log.e("MicroMsg.ChattingItemVoice", "alvinluo transform text fav failed");
                    }
                    bf.e(10, caVar);
                    break;
            }
            AppMethodBeat.o(37473);
            return false;
        }

        public static void f(int i2, ca caVar) {
            AppMethodBeat.i(233956);
            if (caVar == null) {
                Log.i("MicroMsg.ChattingItemVoice", "msgInfo is null???");
                AppMethodBeat.o(233956);
                return;
            }
            aW(i2, caVar.field_msgId);
            AppMethodBeat.o(233956);
        }

        public static void aW(int i2, long j2) {
            AppMethodBeat.i(233957);
            if (!bi.gRD()) {
                AppMethodBeat.o(233957);
                return;
            }
            gn gnVar = new gn();
            gnVar.eJR = i2;
            gnVar.up(String.valueOf(j2));
            Log.d("MicroMsg.ChattingItemVoice", "%s", gnVar.abW());
            gnVar.bfK();
            AppMethodBeat.o(233957);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, final com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37474);
            if (caVar.field_status == 5) {
                Log.i("MicroMsg.ChattingItemVoice", "onItemClick msg(%s) fail", Long.valueOf(caVar.field_msgId));
                AppMethodBeat.o(37474);
            } else {
                if (caVar.gDP()) {
                    ((aw) aVar.bh(aw.class)).a(caVar.field_msgId, view);
                    if (((aw) aVar.bh(aw.class)).NK(caVar.field_msgId)) {
                        Log.i("MicroMsg.ChattingItemVoice", "onItemClick: voice msg show download animation");
                        AppMethodBeat.o(37474);
                    } else {
                        ca Hb = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(caVar.field_msgId);
                        if (Hb.gDP()) {
                            ((aw) aVar.bh(aw.class)).NJ(Hb.field_msgId);
                            o.bid().run();
                            com.tencent.f.h.RTc.aV(new Runnable() {
                                /* class com.tencent.mm.ui.chatting.viewitems.bf.a.AnonymousClass3 */

                                public final void run() {
                                    AppMethodBeat.i(233952);
                                    aVar.cmy();
                                    AppMethodBeat.o(233952);
                                }
                            });
                            Log.i("MicroMsg.ChattingItemVoice", "onItemClick voice msg(%s) no finish download!", Long.valueOf(caVar.field_msgId));
                            AppMethodBeat.o(37474);
                        }
                    }
                }
                ((aw) aVar.bh(aw.class)).NL(caVar.field_msgId);
                ((aw) aVar.bh(aw.class)).gRA();
                bq bqVar = (bq) view.getTag();
                com.tencent.mm.modelstat.b.jmd.ae(bqVar.dTX);
                bf.b(aVar, bqVar);
                ((at) aVar.bh(at.class)).amG(2);
                ((au) aVar.bh(au.class)).gRw();
                c(aVar, caVar);
                if (((at) aVar.bh(at.class)).ch(caVar)) {
                    aW(4, caVar.field_msgId);
                }
                AppMethodBeat.o(37474);
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.t.n
        public final void b(View view, final com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233958);
            if (caVar.field_status == 5) {
                ca Hb = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(caVar.field_msgId);
                Hb.gDQ();
                p pVar = new p(Hb.field_content);
                pVar.jsi = false;
                Hb.setContent(pVar.bie());
                Hb.setStatus(3);
                ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(caVar.field_msgId, Hb);
                r AP = o.bib().AP(caVar.field_msgSvrId);
                if (AP.iKP == 0) {
                    AP.status = 5;
                } else {
                    AP.status = 6;
                }
                AP.jsm = System.currentTimeMillis() / 1000;
                AP.jvx = 1;
                AP.cSx = 1048896;
                s.a(AP);
                ((aw) aVar.bh(aw.class)).NJ(caVar.field_msgId);
                o.bid().run();
                com.tencent.f.h.RTc.aV(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.viewitems.bf.a.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(233954);
                        aVar.cmy();
                        AppMethodBeat.o(233954);
                    }
                });
                Log.i("MicroMsg.ChattingItemVoice", "onStateBtnClick voice msg(%s) re-download!", Long.valueOf(caVar.field_msgId));
            }
            AppMethodBeat.o(233958);
        }
    }

    public static final class c extends c.a {
        TextView PHZ;
        ImageView PIn;
        ViewStub PKH;
        ChattingItemTranslate PKI;
        TextView PNK;
        int PPI;
        TextView PPJ;
        TextView PPK;
        AnimImageView PPL;
        FrameLayout PPM;
        FrameLayout PPN;
        ImageView PPO;
        ProgressBar PPP;
        AnimImageView PPQ;
        ProgressBar PPR;
        TextView PPS;
        ImageView PPT;
        RelativeLayout PPU;
        TextView PPV;
        Animation PPW;

        public final c.a e(View view, boolean z, boolean z2) {
            AppMethodBeat.i(37483);
            super.create(view);
            this.timeTV = (TextView) view.findViewById(R.id.ayf);
            this.userTV = (TextView) view.findViewById(R.id.ayn);
            this.PPK = (TextView) view.findViewById(R.id.az0);
            this.checkBox = (CheckBox) view.findViewById(R.id.aue);
            this.maskView = view.findViewById(R.id.ax3);
            this.stateIV = (ImageView) view.findViewById(R.id.ayb);
            this.PNK = (TextView) view.findViewById(R.id.auk);
            this.PPM = (FrameLayout) view.findViewById(R.id.az1);
            this.PPP = (ProgressBar) view.findViewById(R.id.ayx);
            this.PKH = (ViewStub) view.findViewById(R.id.iva);
            this.PPJ = (TextView) view.findViewById(R.id.ayy);
            this.PPL = (AnimImageView) view.findViewById(R.id.ayw);
            this.PPL.setType(1);
            if (z) {
                this.PPL.setFromVoice(true);
                this.PPL.setFromGroup(z2);
                this.PHZ = (TextView) view.findViewById(R.id.at6);
                this.PPQ = (AnimImageView) view.findViewById(R.id.ayz);
                this.PPQ.setFromVoice(true);
                this.PPQ.setFromGroup(z2);
                this.PPQ.setType(0);
                this.PPT = (ImageView) view.findViewById(R.id.ave);
                this.PPU = (RelativeLayout) view.findViewById(R.id.avg);
                this.PPV = (TextView) view.findViewById(R.id.avf);
            } else {
                this.PPN = (FrameLayout) view.findViewById(R.id.az8);
                this.PPO = (ImageView) view.findViewById(R.id.az9);
                this.PPR = (ProgressBar) view.findViewById(R.id.az_);
                this.uploadingPB = (ProgressBar) view.findViewById(R.id.j0y);
                this.PPS = (TextView) view.findViewById(R.id.aza);
                this.PPL.setFromVoice(false);
                this.PPL.setFromGroup(z2);
                this.PIn = (ImageView) view.findViewById(R.id.ayd);
            }
            AppMethodBeat.o(37483);
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0107  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x012c  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0183  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x0197  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x01b3  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x04d9  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x0500  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void a(com.tencent.mm.ui.chatting.viewitems.c r11, com.tencent.mm.ui.chatting.viewitems.bf.c r12, com.tencent.mm.storage.ca r13, int r14, com.tencent.mm.ui.chatting.e.a r15, boolean r16, android.view.View.OnLongClickListener r17, com.tencent.mm.ui.chatting.t.n r18) {
            /*
            // Method dump skipped, instructions count: 1285
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.bf.c.a(com.tencent.mm.ui.chatting.viewitems.c, com.tencent.mm.ui.chatting.viewitems.bf$c, com.tencent.mm.storage.ca, int, com.tencent.mm.ui.chatting.e.a, boolean, android.view.View$OnLongClickListener, com.tencent.mm.ui.chatting.t$n):void");
        }

        static void a(Context context, CharSequence charSequence, com.tencent.mm.ui.chatting.e.a aVar) {
            AppMethodBeat.i(233963);
            Intent intent = new Intent(context, TextPreviewUI.class);
            intent.putExtra("key_chat_text", charSequence);
            if (aVar != null) {
                intent.putExtra("is_group_chat", aVar.gRM());
            }
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$VoiceItemHolder", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$VoiceItemHolder", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.ui.base.b.kc(context);
            AppMethodBeat.o(233963);
        }

        private void gUj() {
            AppMethodBeat.i(37486);
            if (this.PPW != null) {
                this.PPW.cancel();
                this.PPW = null;
            }
            AppMethodBeat.o(37486);
        }

        private static void a(c cVar, int i2, int i3, boolean z) {
            AppMethodBeat.i(37487);
            cVar.stateIV.setVisibility(i3);
            cVar.PNK.setVisibility(i3);
            cVar.PPM.setVisibility(i3);
            if (z) {
                cVar.PPQ.setVisibility(i2);
                cVar.PHZ.setVisibility(i3);
                AppMethodBeat.o(37487);
                return;
            }
            if (cVar.PPS != null) {
                cVar.PPS.setVisibility(i2);
            }
            AppMethodBeat.o(37487);
        }

        private static int Qi(int i2) {
            if (i2 <= 2) {
                return 80;
            }
            if (i2 < 10) {
                return ((i2 - 2) * 9) + 80;
            }
            if (i2 < 60) {
                return (((i2 / 10) + 7) * 9) + 80;
            }
            return 204;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c.a
        public final View getMainContainerView() {
            return this.PPM;
        }
    }

    public static boolean a(com.tencent.mm.ui.chatting.e.a aVar, ca caVar, int i2) {
        boolean z;
        AppMethodBeat.i(233964);
        if (caVar == null) {
            AppMethodBeat.o(233964);
            return false;
        }
        if (caVar.gDP()) {
            if (((aw) aVar.bh(aw.class)).NK(caVar.field_msgId)) {
                Log.i("MicroMsg.ChattingItemVoice", "onCreateContextMenu: voice msg is downloading.(1)");
                z = true;
            } else if (((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(caVar.field_msgId).gDP()) {
                Log.i("MicroMsg.ChattingItemVoice", "onCreateContextMenu: voice msg is downloading.(2)");
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.i("MicroMsg.ChattingItemVoice", "handleNoFinishDownloadVoiceMsg show alert!");
                com.tencent.mm.ui.base.h.a(aVar.Pwc.getContext(), aVar.Pwc.getContext().getString(i2), "", aVar.Pwc.getContext().getString(R.string.j34), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.viewitems.bf.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
            }
        } else {
            z = false;
        }
        AppMethodBeat.o(233964);
        return z;
    }

    public static boolean b(com.tencent.mm.ui.chatting.e.a aVar, ca caVar, int i2) {
        AppMethodBeat.i(233965);
        if (caVar == null || !caVar.gAy() || caVar.field_isSend == 1 || caVar.field_status != 5) {
            AppMethodBeat.o(233965);
            return false;
        }
        Log.i("MicroMsg.ChattingItemVoice", "handleDownloadFailVoiceMsg show alert!");
        com.tencent.mm.ui.base.h.a(aVar.Pwc.getContext(), aVar.Pwc.getContext().getString(i2), "", aVar.Pwc.getContext().getString(R.string.j34), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.viewitems.bf.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(233965);
        return true;
    }

    private static boolean a(final int i2, final com.tencent.mm.ui.chatting.e.a aVar, final ca caVar, final at atVar, final boolean z) {
        AppMethodBeat.i(233966);
        if (a(aVar, caVar, R.string.avw)) {
            AppMethodBeat.o(233966);
        } else if (b(aVar, caVar, R.string.avu)) {
            AppMethodBeat.o(233966);
        } else {
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.ui.chatting.viewitems.bf.AnonymousClass1 */

                public final void run() {
                    int i2;
                    AppMethodBeat.i(37465);
                    com.tencent.mm.ui.chatting.e.a aVar = aVar;
                    ca caVar = caVar;
                    at atVar = (at) aVar.bh(at.class);
                    if (aVar == null || atVar == null) {
                        Log.e("MicroMsg.ChattingItemVoice", "alvinluo ui or ui.transformImp null");
                        AppMethodBeat.o(37465);
                        return;
                    }
                    if (atVar.NH(caVar.field_msgId)) {
                        i2 = 2;
                    } else if (atVar.NC(caVar.field_msgId)) {
                        i2 = 3;
                    } else {
                        i2 = !Util.isNullOrNil(atVar.S(caVar.field_msgId, caVar.field_imgPath)) ? 5 : 1;
                    }
                    Log.i("MicroMsg.ChattingItemVoice", "alvinluo TransformText report clickScene: %d, msgId: %d", Integer.valueOf(i2), Long.valueOf(caVar.field_msgId));
                    gi giVar = new gi();
                    giVar.dKe.dKf = 1;
                    giVar.dKe.scene = i2;
                    giVar.dKe.fileName = caVar.field_imgPath;
                    EventCenter.instance.publish(giVar);
                    AppMethodBeat.o(37465);
                }
            }, "voice_transform_text_report");
            if (atVar.gRs()) {
                com.tencent.mm.ui.base.h.d(aVar.Pwc.getContext(), aVar.Pwc.getContext().getString(R.string.i0j), "", new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.viewitems.bf.AnonymousClass4 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(233950);
                        if (z) {
                            s.ak(caVar);
                        }
                        atVar.gRt();
                        atVar.a(caVar, true, i2, 0);
                        AppMethodBeat.o(233950);
                    }
                });
            } else {
                if (z) {
                    s.ak(caVar);
                }
                atVar.a(caVar, true, i2, 0);
            }
            com.tencent.mm.modelstat.b bVar = com.tencent.mm.modelstat.b.jmd;
            if (bVar.bfZ()) {
                bVar.a(caVar, b.EnumC0457b.voiceToText, 0);
            }
            AppMethodBeat.o(233966);
        }
        return true;
    }

    public static void b(com.tencent.mm.ui.chatting.e.a aVar, bq bqVar) {
        int i2;
        AppMethodBeat.i(37488);
        if (com.tencent.mm.q.a.cC(aVar.Pwc.getContext()) || com.tencent.mm.q.a.cA(aVar.Pwc.getContext()) || com.tencent.mm.q.a.cE(aVar.Pwc.getContext())) {
            Log.d("MicroMsg.ChattingItemVoice", "voip is running, not play voice");
            AppMethodBeat.o(37488);
            return;
        }
        bg.aVF();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
            u.g(aVar.Pwc.getContext(), aVar.Pwc.getContentView());
            AppMethodBeat.o(37488);
            return;
        }
        if (!(bqVar == null || bqVar.dTX == null)) {
            p pVar = new p(bqVar.dTX.field_content);
            if (af.isNullOrNil(bqVar.dTX.field_content) || pVar.time == 0) {
                Toast.makeText(aVar.Pwc.getContext(), (int) R.string.ay3, 0).show();
                AppMethodBeat.o(37488);
                return;
            }
            d gRx = ((aw) aVar.bh(aw.class)).gRx();
            if (!(aVar.bh(k.class) == null || gRx == null)) {
                ca caVar = bqVar.dTX;
                if (((aw) aVar.bh(aw.class)).gRx().Pei != caVar.field_msgId) {
                    at atVar = (at) aVar.bh(at.class);
                    if (atVar.NH(caVar.field_msgId)) {
                        i2 = 7;
                    } else if (atVar.NC(caVar.field_msgId)) {
                        i2 = 6;
                    } else {
                        i2 = 0;
                    }
                    if (i2 != 0) {
                        gi giVar = new gi();
                        giVar.dKe.dKf = 1;
                        giVar.dKe.scene = i2;
                        giVar.dKe.fileName = caVar.field_imgPath;
                        EventCenter.instance.publish(giVar);
                    }
                }
                int i3 = bqVar.position;
                ca caVar2 = bqVar.dTX;
                if (caVar2 == null || !caVar2.gAy()) {
                    AppMethodBeat.o(37488);
                    return;
                }
                p pVar2 = new p(caVar2.field_content);
                if ((pVar2.time == 0 && caVar2.field_isSend == 0) || (caVar2.field_status == 1 && caVar2.field_isSend == 1)) {
                    AppMethodBeat.o(37488);
                    return;
                } else if (!(caVar2.field_isSend == 0 && pVar2.time == -1)) {
                    gRx.gMO();
                    bg.aVF();
                    Boolean bool = (Boolean) com.tencent.mm.model.c.azQ().get(4115, (Object) null);
                    if (bool == null || !bool.booleanValue()) {
                        bg.aVF();
                        com.tencent.mm.model.c.azQ().set(4115, Boolean.TRUE);
                        gRx.gMU();
                        gRx.Pel = u.a(gRx.dom.Pwc.getActivity(), gRx.context.getString(R.string.b14), 4000);
                    }
                    if (!gRx.qUl.isPlaying() || caVar2.field_msgId != gRx.Pei) {
                        gRx.bf(caVar2);
                        if (caVar2.field_isSend == 0 && !s.ai(caVar2)) {
                            gRx.ama(i3 + 1);
                        }
                        gRx.BK(true);
                    } else {
                        gRx.Per = true;
                        gRx.gMT();
                        AppMethodBeat.o(37488);
                        return;
                    }
                }
            }
        }
        AppMethodBeat.o(37488);
    }

    static /* synthetic */ boolean d(ca caVar, com.tencent.mm.ui.chatting.e.a aVar) {
        AppMethodBeat.i(37489);
        boolean NH = ((at) aVar.bh(at.class)).NH(caVar.field_msgId);
        AppMethodBeat.o(37489);
        return NH;
    }

    static /* synthetic */ void cQ(ca caVar) {
        AppMethodBeat.i(37490);
        gi giVar = new gi();
        giVar.dKe.dKf = 3;
        giVar.dKe.scene = 1;
        giVar.dKe.fileName = caVar.field_imgPath;
        EventCenter.instance.publish(giVar);
        AppMethodBeat.o(37490);
    }

    static /* synthetic */ void e(int i2, ca caVar) {
        AppMethodBeat.i(37492);
        Log.i("MicroMsg.ChattingItemVoice", "alvinluo reportTransformTextLongClick type: %d, msgId: %d", Integer.valueOf(i2), Long.valueOf(caVar.field_msgId));
        gi giVar = new gi();
        giVar.dKe.dKf = 2;
        giVar.dKe.scene = i2;
        giVar.dKe.fileName = caVar.field_imgPath;
        EventCenter.instance.publish(giVar);
        AppMethodBeat.o(37492);
    }
}
