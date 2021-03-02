package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.h;
import com.tencent.mm.ag.k;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.kj;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.b.a.no;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.m;
import com.tencent.mm.modelstat.a;
import com.tencent.mm.plugin.appbrand.ac.n;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.protobuf.elo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.j;
import com.tencent.mm.ui.chatting.d.b.m;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.chatting.viewitems.e;
import java.lang.ref.WeakReference;
import java.util.Locale;

public final class aj {

    public static class a extends c {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || i2 != 587202609) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37109);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.rt);
                view.setTag(new d().S(view, true));
            }
            AppMethodBeat.o(37109);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            AppMethodBeat.i(37110);
            this.PhN = aVar2;
            final d dVar = (d) aVar;
            m mVar = (m) aVar2.bh(m.class);
            mVar.bX(caVar);
            mVar.bY(caVar);
            mVar.bZ(caVar);
            String str2 = caVar.field_content;
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            } else {
                Log.e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", Long.valueOf(caVar.field_msgId), str);
                bVar = null;
            }
            bq bqVar = new bq(caVar, aVar2.gRM(), i2, (String) null, (char) 0);
            if (bVar != null) {
                dVar.PHX.setVisibility(8);
                dVar.PHW.setVisibility(8);
                dVar.PIu.setVisibility(8);
                bVar.as(h.class);
                dVar.clickArea.setBackgroundResource(R.drawable.os);
                g gE = com.tencent.mm.pluginsdk.model.app.h.gE(bVar.appId, bVar.appVersion);
                if (gE != null) {
                    b(aVar2, bVar, caVar);
                }
                if (bVar.fQR == null || bVar.fQR.length() == 0) {
                    dVar.PHZ.setVisibility(8);
                } else {
                    dVar.PHZ.setVisibility(0);
                    b(aVar2, dVar.PHZ, bq.bnn(bVar.fQR));
                }
                WxaAttributes Xk = ((q) com.tencent.mm.kernel.g.af(q.class)).Xk(bVar.izi);
                dVar.PIc.setVisibility(0);
                dVar.PHT.setVisibility(8);
                dVar.PIf.setVisibility(0);
                dVar.PId.setVisibility(8);
                dVar.PIs.setText(Xk != null ? Xk.field_nickname : bVar.eah);
                String str3 = Xk != null ? Xk.field_smallHeadURL : bVar.izB;
                com.tencent.mm.av.q.bcV().a(str3, dVar.PIr, d.gvY);
                dVar.PIu.setVisibility(0);
                dVar.PLT.setVisibility(8);
                dVar.PLT.setText(bVar.description);
                dVar.PIy.setText(bVar.title);
                switch (bVar.izz) {
                    case 1:
                        dVar.PIt.setText(R.string.rj);
                        break;
                    case 2:
                        dVar.PIt.setText(R.string.ri);
                        break;
                    default:
                        dVar.PIt.setText(R.string.ko);
                        break;
                }
                com.tencent.mm.av.q.bcV().a(str3, dVar.PIr, d.gvY);
                if (aVar2.gRM()) {
                    dVar.PIb.setVisibility(8);
                } else if (com.tencent.mm.pluginsdk.model.app.h.k(gE)) {
                    dVar.PIb.setVisibility(0);
                    c(aVar2, dVar.PIb, bq.a(bVar, caVar));
                } else {
                    dVar.PIb.setVisibility(8);
                }
                String d2 = com.tencent.mm.av.q.bcR().d(caVar.field_imgPath, false, true);
                dVar.PIv.setImageBitmap(null);
                dVar.PIv.setVisibility(4);
                dVar.PIx.setVisibility(0);
                com.tencent.mm.modelappbrand.a.b.aXY().a(new b.k() {
                    /* class com.tencent.mm.ui.chatting.viewitems.aj.a.AnonymousClass1 */

                    @Override // com.tencent.mm.modelappbrand.a.b.k
                    public final void aYg() {
                    }

                    @Override // com.tencent.mm.modelappbrand.a.b.k
                    public final void I(Bitmap bitmap) {
                        AppMethodBeat.i(37106);
                        if (bitmap == null || bitmap.isRecycled()) {
                            dVar.PIv.setVisibility(4);
                            dVar.PIx.setVisibility(0);
                            AppMethodBeat.o(37106);
                            return;
                        }
                        dVar.PIv.setImageBitmap(bitmap);
                        dVar.PIv.setVisibility(0);
                        dVar.PIx.setVisibility(4);
                        AppMethodBeat.o(37106);
                    }

                    @Override // com.tencent.mm.modelappbrand.a.b.k
                    public final void oD() {
                    }

                    @Override // com.tencent.mm.modelappbrand.a.b.k, com.tencent.mm.modelappbrand.a.c
                    public final String Lb() {
                        AppMethodBeat.i(37107);
                        String format = String.format(Locale.ENGLISH, "CHATTING_ITEM_APPMSG_APPBRAND_COVER[%d %d]", 240, 192);
                        AppMethodBeat.o(37107);
                        return format;
                    }
                }, "file://".concat(String.valueOf(d2)), (b.h) null, ((com.tencent.mm.modelappbrand.k) com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.k.class)).m10do(240, 192));
                dVar.PMb.setVisibility(8);
                dVar.PMb.setTag(Util.nullAs(bVar.izo, ""));
                dVar.PMc.setVisibility(8);
                final com.tencent.mm.ag.a aVar3 = (com.tencent.mm.ag.a) bVar.as(com.tencent.mm.ag.a.class);
                if (aVar3 != null && aVar3.iuT) {
                    String str4 = bVar.izo;
                    com.tencent.mm.ag.a.c Lq = ((com.tencent.mm.modelappbrand.m) com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.m.class)).Lq(str4);
                    aj.a(aVar2, dVar, aVar3, Lq);
                    aj.a(aVar2, dVar, aVar3, bVar, Lq);
                    int i3 = aVar3.iva;
                    if (!(Lq == null || Lq.field_updatePeroid == 0)) {
                        i3 = Lq.field_updatePeroid;
                    }
                    if (i3 > 0) {
                        ((com.tencent.mm.modelappbrand.m) com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.m.class)).a(e.cO(aVar2), bVar.izj, str4, i3, new m.a() {
                            /* class com.tencent.mm.ui.chatting.viewitems.aj.a.AnonymousClass2 */

                            @Override // com.tencent.mm.modelappbrand.m.a
                            public final void a(String str, elo elo) {
                                com.tencent.mm.ag.a.c Lq;
                                AppMethodBeat.i(37108);
                                Log.d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "ShareKey:%s UpdatableMsgInfo:%s", str, elo.content);
                                if (dVar.PMb == null) {
                                    Log.w("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "viewHolder.appbrandUpdateTv is null, return");
                                    AppMethodBeat.o(37108);
                                    return;
                                }
                                String str2 = (String) dVar.PMb.getTag();
                                if (Util.isNullOrNil(str2)) {
                                    Log.w("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "oriShareKey is null, return");
                                    AppMethodBeat.o(37108);
                                    return;
                                }
                                if (str2.equals(str)) {
                                    dVar.PMb.setVisibility(0);
                                    dVar.PMb.setText(elo.content);
                                    dVar.PMb.setTextColor(Util.convertStringToRGB(elo.MXr, dVar.PMb.getCurrentTextColor()));
                                    if (elo.state == 1 && (Lq = ((com.tencent.mm.modelappbrand.m) com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.m.class)).Lq(str)) != null && Lq.field_btnState == 1) {
                                        if (Util.isNullOrNil(aVar3.iuZ)) {
                                            dVar.PMc.setVisibility(8);
                                            AppMethodBeat.o(37108);
                                            return;
                                        }
                                        dVar.PMc.setVisibility(0);
                                        dVar.PMc.setText(aVar3.iuZ);
                                    }
                                }
                                AppMethodBeat.o(37108);
                            }
                        });
                    }
                }
                ((w) com.tencent.mm.kernel.g.af(w.class)).VA(bVar.izi);
            }
            dVar.clickArea.setTag(bqVar);
            dVar.clickArea.setOnClickListener(d(aVar2));
            ad.b G = ad.aVe().G(e.cO(aVar2), true);
            c cVar = (c) G.get(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
            if (cVar == null) {
                cVar = new c();
                G.l(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, cVar);
            }
            cVar.n(aVar2);
            if (this.qoo) {
                dVar.clickArea.setOnLongClickListener(c(aVar2));
                dVar.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
            }
            AppMethodBeat.o(37110);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            AppMethodBeat.i(233814);
            int i2 = ((bq) view.getTag()).position;
            k.b HD = k.b.HD(bp.b(this.PhN.gRM(), caVar.field_content, caVar.field_isSend));
            if (com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.o(HD.appId, false, false)) && !com.tencent.mm.ui.chatting.k.bm(caVar)) {
                if (HD.type == 6) {
                    com.tencent.mm.pluginsdk.model.app.c bdJ = com.tencent.mm.pluginsdk.model.app.m.bdJ(HD.dCK);
                    if ((bdJ == null || !e.b.h(caVar, bdJ.field_fileFullPath)) && !caVar.gDB()) {
                        mVar.a(i2, 111, this.PhN.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
                    }
                } else {
                    mVar.a(i2, 111, this.PhN.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
                }
            }
            ef efVar = new ef();
            efVar.dHy.msgId = caVar.field_msgId;
            EventCenter.instance.publish(efVar);
            if (efVar.dHz.dGX || e.b.a(this.PhN.Pwc.getContext(), HD)) {
                mVar.a(i2, 129, view.getContext().getString(R.string.b0c), R.raw.icons_filled_open);
            }
            if (!this.PhN.gRN()) {
                mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
            }
            AppMethodBeat.o(233814);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37112);
            switch (menuItem.getItemId()) {
                case 111:
                    e.b.a(aVar, caVar, a(aVar, caVar));
                    AppMethodBeat.o(37112);
                    break;
                default:
                    AppMethodBeat.o(37112);
                    break;
            }
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37113);
            com.tencent.mm.modelstat.a.a(caVar, a.EnumC0456a.Click);
            ((com.tencent.mm.plugin.comm.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
            if (caVar.field_content == null) {
                AppMethodBeat.o(37113);
                return false;
            }
            k.b HD = k.b.HD(bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend));
            if (HD == null) {
                AppMethodBeat.o(37113);
                return false;
            }
            g o = com.tencent.mm.pluginsdk.model.app.h.o(HD.appId, false, false);
            if (o != null) {
                a(aVar, HD, d(aVar, caVar), o, caVar.field_msgSvrId, aVar.getTalkerUserName());
            }
            Log.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", HD.izi, HD.izh, HD.izj, HD.url, Integer.valueOf(HD.izz), HD.izl);
            wq wqVar = new wq();
            wqVar.ecI.appId = HD.izj;
            wqVar.ecI.userName = HD.izi;
            wqVar.ecI.ecK = HD.izh;
            wqVar.ecI.ecL = HD.izz;
            wqVar.ecI.ecO = HD.izl;
            wqVar.ecI.appVersion = HD.izA;
            wqVar.ecI.ecP = HD.izz != 0;
            wqVar.ecI.ecR.cyq = aVar.getTalkerUserName();
            wqVar.ecI.ecR.cyr = HD.izo;
            String str = HD.izn;
            if (aVar.gRM()) {
                wqVar.ecI.scene = 1008;
                wqVar.ecI.dCw = aVar.getTalkerUserName() + ":" + a(aVar, caVar) + ":" + str;
            } else {
                wqVar.ecI.scene = 1007;
                wqVar.ecI.dCw = a(aVar, caVar) + ":" + str;
            }
            aj.c(wqVar, HD);
            EventCenter.instance.publish(wqVar);
            aj.a(aVar, HD);
            AppMethodBeat.o(37113);
            return true;
        }
    }

    public static class b extends c implements t.n {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != 587202609) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37117);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.t7);
                view.setTag(new d().S(view, false));
            }
            AppMethodBeat.o(37117);
            return view;
        }

        /* JADX WARNING: Removed duplicated region for block: B:34:0x015b  */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a r11, int r12, com.tencent.mm.ui.chatting.e.a r13, com.tencent.mm.storage.ca r14, java.lang.String r15) {
            /*
            // Method dump skipped, instructions count: 556
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.aj.b.a(com.tencent.mm.ui.chatting.viewitems.c$a, int, com.tencent.mm.ui.chatting.e.a, com.tencent.mm.storage.ca, java.lang.String):void");
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            AppMethodBeat.i(233815);
            int i2 = ((bq) view.getTag()).position;
            if (caVar.field_content == null) {
                AppMethodBeat.o(233815);
            } else {
                k.b HD = k.b.HD(bp.b(this.PhN.gRM(), caVar.field_content, caVar.field_isSend));
                if (HD == null) {
                    AppMethodBeat.o(233815);
                } else {
                    if (com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.o(HD.appId, false, false)) && !com.tencent.mm.ui.chatting.k.bm(caVar)) {
                        mVar.a(i2, 111, this.PhN.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
                    }
                    if ((caVar.field_status == 2 || caVar.fQV == 1) && b(caVar, this.PhN) && bnf(caVar.field_talker)) {
                        mVar.a(i2, 123, view.getContext().getString(R.string.b0i), R.raw.icons_filled_previous);
                    }
                    ef efVar = new ef();
                    efVar.dHy.msgId = caVar.field_msgId;
                    EventCenter.instance.publish(efVar);
                    if (efVar.dHz.dGX || e.b.a(this.PhN.Pwc.getContext(), HD)) {
                        mVar.a(i2, 129, view.getContext().getString(R.string.b0c), R.raw.icons_filled_open);
                    }
                    if (!this.PhN.gRN()) {
                        mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
                    }
                    AppMethodBeat.o(233815);
                }
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37120);
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
                        AppMethodBeat.o(37120);
                        break;
                    } else {
                        AppMethodBeat.o(37120);
                        break;
                    }
                case 111:
                    e.b.a(aVar, caVar, a(aVar, caVar));
                    AppMethodBeat.o(37120);
                    break;
                default:
                    AppMethodBeat.o(37120);
                    break;
            }
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37121);
            ((com.tencent.mm.plugin.comm.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
            view.getTag();
            String str = caVar.field_content;
            if (str == null) {
                AppMethodBeat.o(37121);
                return false;
            }
            k.b HD = k.b.HD(str);
            if (HD == null) {
                AppMethodBeat.o(37121);
                return false;
            }
            g o = com.tencent.mm.pluginsdk.model.app.h.o(HD.appId, true, false);
            if (o != null && !Util.isNullOrNil(o.field_appId)) {
                a(aVar, HD, z.aTY(), o, caVar.field_msgSvrId, aVar.getTalkerUserName());
            }
            wq wqVar = new wq();
            wqVar.ecI.appId = HD.izj;
            wqVar.ecI.userName = HD.izi;
            wqVar.ecI.ecK = HD.izh;
            wqVar.ecI.ecL = HD.izz;
            wqVar.ecI.ecO = HD.izl;
            wqVar.ecI.appVersion = HD.izA;
            wqVar.ecI.ecP = HD.izz != 0;
            String str2 = HD.izn;
            if (aVar.gRM()) {
                wqVar.ecI.scene = 1008;
                wqVar.ecI.dCw = aVar.getTalkerUserName() + ":" + a(aVar, caVar) + ":" + str2;
            } else {
                wqVar.ecI.scene = 1007;
                wqVar.ecI.dCw = a(aVar, caVar) + ":" + str2;
            }
            wqVar.ecI.ecR.cyq = aVar.getTalkerUserName();
            wqVar.ecI.ecR.cyr = HD.izo;
            aj.c(wqVar, HD);
            EventCenter.instance.publish(wqVar);
            aj.a(aVar, HD);
            AppMethodBeat.o(37121);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.t.n
        public final void b(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233816);
            if (caVar.dOQ()) {
                com.tencent.mm.pluginsdk.model.app.m.aS(caVar);
                bp.Ad(caVar.field_msgId);
                aVar.BN(true);
                AppMethodBeat.o(233816);
                return;
            }
            AppMethodBeat.o(233816);
        }
    }

    /* access modifiers changed from: package-private */
    public static class d extends c.a {
        public static final int PLR = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 240);
        public static final int PLS = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 192);
        static com.tencent.mm.av.a.a.c gvY;
        protected ImageView PHT;
        protected ImageView PHW;
        protected ImageView PHX;
        protected TextView PHZ;
        protected ChattingItemFooter PIa;
        protected ImageView PIb;
        protected LinearLayout PIc;
        protected ViewGroup PId;
        protected TextView PIe;
        protected LinearLayout PIf;
        ImageView PIn;
        protected ImageView PIr;
        protected TextView PIs;
        protected TextView PIt;
        protected LinearLayout PIu;
        protected ImageView PIv;
        protected ImageView PIx;
        protected TextView PIy;
        protected TextView PLT;
        protected TextView PMb;
        protected TextView PMc;

        d() {
        }

        static {
            AppMethodBeat.i(37128);
            c.a aVar = new c.a();
            aVar.jbq = R.raw.app_brand_app_default_icon_for_tail;
            aVar.dr(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 20), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 20)).jbd = true;
            gvY = aVar.bdv();
            AppMethodBeat.o(37128);
        }

        public final d S(View view, boolean z) {
            AppMethodBeat.i(37127);
            super.create(view);
            this.PHT = (ImageView) view.findViewById(R.id.atr);
            this.PHW = (ImageView) this.convertView.findViewById(R.id.aup);
            this.PHX = (ImageView) this.convertView.findViewById(R.id.aye);
            this.PHZ = (TextView) view.findViewById(R.id.at6);
            this.PIb = (ImageView) view.findViewById(R.id.atl);
            this.checkBox = (CheckBox) view.findViewById(R.id.aue);
            this.maskView = view.findViewById(R.id.ax3);
            this.userTV = (TextView) view.findViewById(R.id.ayn);
            this.PIa = (ChattingItemFooter) view.findViewById(R.id.d8b);
            this.PIc = (LinearLayout) view.findViewById(R.id.s8);
            this.PId = (ViewGroup) view.findViewById(R.id.equ);
            this.PIe = (TextView) view.findViewById(R.id.eqr);
            this.PIf = (LinearLayout) view.findViewById(R.id.atz);
            this.clickArea = view.findViewById(R.id.auf);
            if (!z) {
                this.PIn = (ImageView) this.convertView.findViewById(R.id.ayd);
                this.uploadingPB = (ProgressBar) this.convertView.findViewById(R.id.j0y);
            }
            this.PIu = (LinearLayout) view.findViewById(R.id.aso);
            this.PIv = (ImageView) view.findViewById(R.id.asp);
            this.PIx = (ImageView) view.findViewById(R.id.c4n);
            this.PIy = (TextView) view.findViewById(R.id.asz);
            this.PLT = (TextView) view.findViewById(R.id.asq);
            this.PMb = (TextView) view.findViewById(R.id.at5);
            this.PIr = (ImageView) view.findViewById(R.id.at1);
            this.PIs = (TextView) view.findViewById(R.id.at3);
            this.PIt = (TextView) view.findViewById(R.id.at2);
            this.PMc = (TextView) view.findViewById(R.id.at4);
            AppMethodBeat.o(37127);
            return this;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c.a
        public final View getMainContainerView() {
            return this.PIf;
        }
    }

    static class e {
        static String cO(Object obj) {
            AppMethodBeat.i(37129);
            String str = "WxaUpdatableMsg#" + n.cO(obj);
            AppMethodBeat.o(37129);
            return str;
        }
    }

    static class c implements com.tencent.mm.ui.m {
        private WeakReference<com.tencent.mm.ui.chatting.e.a> pvS;

        c() {
        }

        /* access modifiers changed from: package-private */
        public final void n(com.tencent.mm.ui.chatting.e.a aVar) {
            AppMethodBeat.i(37123);
            this.pvS = new WeakReference<>(aVar);
            ((j) aVar.bh(j.class)).a(this);
            AppMethodBeat.o(37123);
        }

        @Override // com.tencent.mm.ui.m
        public final void gIk() {
        }

        @Override // com.tencent.mm.ui.m
        public final void gIl() {
        }

        @Override // com.tencent.mm.ui.m
        public final void gIm() {
        }

        @Override // com.tencent.mm.ui.m
        public final void cFx() {
            AppMethodBeat.i(37124);
            ((com.tencent.mm.modelappbrand.m) com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.m.class)).aXM();
            AppMethodBeat.o(37124);
        }

        @Override // com.tencent.mm.ui.m
        public final void cFy() {
            AppMethodBeat.i(37125);
            ((com.tencent.mm.modelappbrand.m) com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.m.class)).aXN();
            AppMethodBeat.o(37125);
        }

        @Override // com.tencent.mm.ui.m
        public final void gIn() {
            AppMethodBeat.i(37126);
            Log.i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExitAnimStart, then detach DynamicPageView.");
            if (this.pvS == null) {
                AppMethodBeat.o(37126);
                return;
            }
            com.tencent.mm.ui.chatting.e.a aVar = this.pvS.get();
            if (aVar != null) {
                ad.aVe().JW(e.cO(aVar));
                ((j) aVar.bh(j.class)).b(this);
                ((com.tencent.mm.modelappbrand.m) com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.m.class)).Lr(e.cO(aVar));
            }
            AppMethodBeat.o(37126);
        }

        @Override // com.tencent.mm.ui.m
        public final void gIo() {
        }
    }

    static /* synthetic */ void a(com.tencent.mm.ui.chatting.e.a aVar, d dVar, com.tencent.mm.ag.a aVar2, com.tencent.mm.ag.a.c cVar) {
        AppMethodBeat.i(37130);
        if (cVar != null && !Util.isNullOrNil(cVar.field_content)) {
            dVar.PMb.setVisibility(0);
            dVar.PMb.setText(cVar.field_content);
            dVar.PMb.setTextColor(Util.convertStringToRGB(cVar.field_contentColor, aVar.Pwc.getContext().getResources().getColor(R.color.a2x)));
            AppMethodBeat.o(37130);
        } else if (!Util.isNullOrNil(aVar2.iuU)) {
            dVar.PMb.setVisibility(0);
            dVar.PMb.setText(aVar2.iuU);
            dVar.PMb.setTextColor(Util.convertStringToRGB(aVar2.iuV, aVar.Pwc.getContext().getResources().getColor(R.color.a2x)));
            AppMethodBeat.o(37130);
        } else {
            dVar.PMb.setVisibility(8);
            AppMethodBeat.o(37130);
        }
    }

    static /* synthetic */ void a(final com.tencent.mm.ui.chatting.e.a aVar, final d dVar, final com.tencent.mm.ag.a aVar2, final k.b bVar, com.tencent.mm.ag.a.c cVar) {
        AppMethodBeat.i(37131);
        if (!(cVar == null || cVar.field_btnState == 0)) {
            if (cVar.field_btnState != 1) {
                if (cVar.field_btnState == 2) {
                    dVar.PMc.setVisibility(0);
                    dVar.PMc.setText(aVar2.iuY);
                    AppMethodBeat.o(37131);
                    return;
                }
                AppMethodBeat.o(37131);
            } else if (cVar.field_msgState != 1) {
                dVar.PMc.setVisibility(0);
                String replace = aVar2.iuW.replace("$button$", aVar2.iuX);
                SpannableString spannableString = new SpannableString(replace);
                final String str = aVar2.iuY;
                spannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a() {
                    /* class com.tencent.mm.ui.chatting.viewitems.aj.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.messenger.a.a
                    public final void onClickImp(View view) {
                        no.c cVar;
                        AppMethodBeat.i(37105);
                        ((com.tencent.mm.modelappbrand.m) com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.m.class)).ao(bVar.izo, 2);
                        dVar.PMc.setText(str);
                        no AM = new no().AJ(bVar.izj).AK(bVar.izh).AL(bVar.izo).AM(aVar.getTalkerUserName());
                        if (aVar.gRM()) {
                            cVar = no.c.YES;
                        } else {
                            cVar = no.c.NO;
                        }
                        AM.fhy = cVar;
                        AM.fhz = no.b.CLICKSUBSCRIBETV;
                        AM.erW = 0;
                        no ajq = AM.AN("").ajq();
                        ajq.fhB = no.d.DEFAULT;
                        ajq.fhD = no.a.mX(aVar2.iuS + 1000);
                        ajq.fhC = no.e.DEFAULT;
                        ajq.bfK();
                        AppMethodBeat.o(37105);
                    }
                }, replace.indexOf(aVar2.iuX), replace.indexOf(aVar2.iuX) + aVar2.iuX.length(), 17);
                dVar.PMc.setMovementMethod(bu.getInstance());
                dVar.PMc.setText(spannableString);
                AppMethodBeat.o(37131);
                return;
            } else if (!Util.isNullOrNil(aVar2.iuZ)) {
                dVar.PMc.setVisibility(0);
                dVar.PMc.setText(aVar2.iuZ);
                AppMethodBeat.o(37131);
                return;
            }
        }
        dVar.PMc.setVisibility(8);
        AppMethodBeat.o(37131);
    }

    static /* synthetic */ void c(wq wqVar, k.b bVar) {
        com.tencent.mm.ag.a aVar;
        AppMethodBeat.i(233817);
        if (!(bVar == null || (aVar = (com.tencent.mm.ag.a) bVar.as(com.tencent.mm.ag.a.class)) == null)) {
            com.tencent.mm.plugin.appbrand.api.j jVar = new com.tencent.mm.plugin.appbrand.api.j();
            jVar.ivg = aVar.ivg;
            wqVar.ecI.edb = jVar.bua();
        }
        AppMethodBeat.o(233817);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0099  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.ui.chatting.e.a r9, com.tencent.mm.ag.k.b r10) {
        /*
        // Method dump skipped, instructions count: 158
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.aj.a(com.tencent.mm.ui.chatting.e.a, com.tencent.mm.ag.k$b):void");
    }
}
