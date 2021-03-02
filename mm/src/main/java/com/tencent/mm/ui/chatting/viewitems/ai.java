package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
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
import com.tencent.mm.ag.k;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.kj;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.modelappbrand.g;
import com.tencent.mm.modelappbrand.h;
import com.tencent.mm.modelstat.a;
import com.tencent.mm.plugin.appbrand.ac.n;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.service.w;
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
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.lang.ref.WeakReference;

public final class ai {

    public static class a extends c implements h {
        private com.tencent.mm.ui.chatting.e.a PhN;
        private ab lpO = new ac(this);

        public a() {
            AppMethodBeat.i(37084);
            AppMethodBeat.o(37084);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || i2 != 553648177) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37085);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.ru);
                d R = new d().R(view, true);
                View cU = ((g) com.tencent.mm.kernel.g.af(g.class)).cU(view.getContext());
                R.PLV = cU;
                R.PLU.addView(cU, new ViewGroup.LayoutParams(-1, -1));
                view.setTag(R);
            }
            AppMethodBeat.o(37085);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            AppMethodBeat.i(37086);
            this.PhN = aVar2;
            d dVar = (d) aVar;
            String str2 = caVar.field_content;
            m mVar = (m) aVar2.bh(m.class);
            mVar.bX(caVar);
            mVar.bY(caVar);
            mVar.bZ(caVar);
            Log.d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "filling Wxa dynamic from ChattingItem(%s)", str);
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
                bVar.as(com.tencent.mm.ag.h.class);
                dVar.clickArea.setBackgroundResource(R.drawable.os);
                com.tencent.mm.pluginsdk.model.app.g gE = com.tencent.mm.pluginsdk.model.app.h.gE(bVar.appId, bVar.appVersion);
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
                String str3 = Xk != null ? Xk.field_nickname : bVar.eah;
                String str4 = Xk != null ? Xk.field_smallHeadURL : bVar.izB;
                dVar.PIu.setVisibility(0);
                dVar.PLT.setVisibility(8);
                dVar.PIy.setText(bVar.title);
                dVar.PLT.setText(bVar.description);
                dVar.PIs.setText(str3);
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
                com.tencent.mm.av.q.bcV().a(str4, dVar.PIr, d.gvY);
                if (aVar2.gRM()) {
                    dVar.PIb.setVisibility(8);
                } else if (com.tencent.mm.pluginsdk.model.app.h.k(gE)) {
                    dVar.PIb.setVisibility(0);
                    c(aVar2, dVar.PIb, bq.a(bVar, caVar));
                } else {
                    dVar.PIb.setVisibility(8);
                }
                com.tencent.mm.ag.a aVar3 = (com.tencent.mm.ag.a) bVar.as(com.tencent.mm.ag.a.class);
                Bundle bundle = new Bundle();
                bundle.putString("app_id", bVar.izj);
                bundle.putString("msg_id", new StringBuilder().append(caVar.field_msgId).toString());
                bundle.putString("cache_key", aVar3 != null ? aVar3.iuR : null);
                bundle.putString("msg_title", bVar.title);
                bundle.putString("msg_path", bVar.izh);
                bundle.putInt("msg_pkg_type", bVar.izz);
                bundle.putInt("pkg_version", bVar.appVersion);
                bundle.putInt("widget_type", 0);
                bundle.putInt("scene", aVar2.gRM() ? 1008 : 1007);
                bundle.putInt("view_init_width", d.PLR);
                bundle.putInt("view_init_height", d.PLS);
                dVar.PLV.setTag(dVar);
                ((g) com.tencent.mm.kernel.g.af(g.class)).a(n.cO(aVar2), dVar.PLV, bundle, this.lpO);
                ((w) com.tencent.mm.kernel.g.af(w.class)).VA(bVar.izi);
            }
            dVar.clickArea.setTag(bqVar);
            dVar.clickArea.setOnClickListener(d(aVar2));
            ad.b G = ad.aVe().G(n.cO(aVar2), true);
            c cVar = (c) G.get(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
            if (cVar == null) {
                cVar = new c();
                G.l(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, cVar);
            }
            cVar.n(aVar2);
            if (this.qoo) {
                dVar.clickArea.setOnLongClickListener(c(aVar2));
            }
            AppMethodBeat.o(37086);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            AppMethodBeat.i(233811);
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
            if (br.B(caVar)) {
                mVar.clear();
            }
            if (!this.PhN.gRN()) {
                mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
            }
            com.tencent.mm.modelappbrand.n aXI = ((g) com.tencent.mm.kernel.g.af(g.class)).aXI();
            if (aXI.aXO() || aXI.sE(HD.izz)) {
                mVar.add(i2, 133, 0, this.PhN.Pwc.getMMResources().getString(R.string.b0f));
                mVar.add(i2, 132, 0, this.PhN.Pwc.getMMResources().getString(R.string.b0e));
            }
            AppMethodBeat.o(233811);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37088);
            switch (menuItem.getItemId()) {
                case 111:
                    e.b.a(aVar, caVar, a(aVar, caVar));
                    AppMethodBeat.o(37088);
                    break;
                case 132:
                    ((g) com.tencent.mm.kernel.g.af(g.class)).aXI().cV(aVar.Pwc.getContext());
                    AppMethodBeat.o(37088);
                    break;
                case 133:
                    String str = caVar.field_content;
                    k.b bVar = null;
                    if (str != null) {
                        bVar = k.b.HD(str);
                    }
                    if (bVar != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("app_id", bVar.izj);
                        bundle.putString("msg_id", new StringBuilder().append(caVar.field_msgId).toString());
                        bundle.putInt("pkg_type", bVar.izz);
                        bundle.putInt("pkg_version", bVar.izm);
                        ((g) com.tencent.mm.kernel.g.af(g.class)).aXI().d(aVar.Pwc.getContext(), bundle);
                        AppMethodBeat.o(37088);
                        break;
                    } else {
                        AppMethodBeat.o(37088);
                        break;
                    }
                default:
                    AppMethodBeat.o(37088);
                    break;
            }
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37089);
            com.tencent.mm.modelstat.a.a(caVar, a.EnumC0456a.Click);
            ((com.tencent.mm.plugin.comm.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
            if (caVar.field_content == null) {
                AppMethodBeat.o(37089);
                return false;
            }
            k.b HD = k.b.HD(bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend));
            if (HD == null) {
                AppMethodBeat.o(37089);
                return false;
            }
            com.tencent.mm.pluginsdk.model.app.g o = com.tencent.mm.pluginsdk.model.app.h.o(HD.appId, false, false);
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
            EventCenter.instance.publish(wqVar);
            AppMethodBeat.o(37089);
            return true;
        }

        @Override // com.tencent.mm.modelappbrand.h
        public final void L(View view, int i2) {
            AppMethodBeat.i(37090);
            Object tag = view.getTag();
            if (!(tag instanceof d)) {
                AppMethodBeat.o(37090);
                return;
            }
            Log.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "onWidgetStateChanged(%s, state : %d)", Integer.valueOf(view.hashCode()), Integer.valueOf(i2));
            d dVar = (d) tag;
            switch (i2) {
                case 0:
                    dVar.odq.setVisibility(0);
                    dVar.odq.gZh();
                    dVar.puw.setVisibility(4);
                    dVar.PLV.setVisibility(4);
                    AppMethodBeat.o(37090);
                    return;
                case 1:
                    dVar.odq.gZi();
                    dVar.odq.setVisibility(4);
                    dVar.PLV.setVisibility(4);
                    dVar.puw.setVisibility(0);
                    dVar.puw.setImageResource(R.raw.dynamic_page_res_not_found);
                    AppMethodBeat.o(37090);
                    return;
                case 2:
                case 3:
                default:
                    dVar.odq.gZi();
                    dVar.odq.setVisibility(4);
                    dVar.PLV.setVisibility(4);
                    dVar.puw.setVisibility(0);
                    dVar.puw.setImageResource(R.raw.app_brand_share_page_cover_default);
                    AppMethodBeat.o(37090);
                    return;
                case 4:
                    dVar.odq.gZi();
                    dVar.odq.setVisibility(4);
                    dVar.PLV.setVisibility(0);
                    dVar.puw.setVisibility(4);
                    AppMethodBeat.o(37090);
                    return;
            }
        }
    }

    public static class b extends c implements h, t.n {
        private com.tencent.mm.ui.chatting.e.a PhN;
        private ab lpO = new ac(this);

        public b() {
            AppMethodBeat.i(37091);
            AppMethodBeat.o(37091);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != 553648177) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37092);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.t8);
                d R = new d().R(view, false);
                View cU = ((g) com.tencent.mm.kernel.g.af(g.class)).cU(view.getContext());
                R.PLV = cU;
                R.PLU.addView(cU, new ViewGroup.LayoutParams(-1, -1));
                view.setTag(R);
            }
            AppMethodBeat.o(37092);
            return view;
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x00f9  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x012e  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x01f6  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x01f9  */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a r11, int r12, com.tencent.mm.ui.chatting.e.a r13, com.tencent.mm.storage.ca r14, java.lang.String r15) {
            /*
            // Method dump skipped, instructions count: 524
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.ai.b.a(com.tencent.mm.ui.chatting.viewitems.c$a, int, com.tencent.mm.ui.chatting.e.a, com.tencent.mm.storage.ca, java.lang.String):void");
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            AppMethodBeat.i(233812);
            int i2 = ((bq) view.getTag()).position;
            if (caVar.field_content == null) {
                AppMethodBeat.o(233812);
            } else {
                k.b HD = k.b.HD(bp.b(this.PhN.gRM(), caVar.field_content, caVar.field_isSend));
                if (HD == null) {
                    AppMethodBeat.o(233812);
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
                    com.tencent.mm.modelappbrand.n aXI = ((g) com.tencent.mm.kernel.g.af(g.class)).aXI();
                    if (aXI.aXO() || aXI.sE(HD.izz)) {
                        mVar.add(i2, 133, 0, this.PhN.Pwc.getMMResources().getString(R.string.b0f));
                        mVar.add(i2, 132, 0, this.PhN.Pwc.getMMResources().getString(R.string.b0e));
                    }
                    AppMethodBeat.o(233812);
                }
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37095);
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
                        AppMethodBeat.o(37095);
                        break;
                    } else {
                        AppMethodBeat.o(37095);
                        break;
                    }
                case 111:
                    e.b.a(aVar, caVar, a(aVar, caVar));
                    AppMethodBeat.o(37095);
                    break;
                case 132:
                    ((g) com.tencent.mm.kernel.g.af(g.class)).aXI().cV(aVar.Pwc.getContext());
                    AppMethodBeat.o(37095);
                    break;
                case 133:
                    String str2 = caVar.field_content;
                    k.b bVar = null;
                    if (str2 != null) {
                        bVar = k.b.HD(str2);
                    }
                    if (bVar != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("app_id", bVar.izj);
                        bundle.putString("msg_id", new StringBuilder().append(caVar.field_msgId).toString());
                        bundle.putInt("pkg_type", bVar.izz);
                        bundle.putInt("pkg_version", bVar.izm);
                        ((g) com.tencent.mm.kernel.g.af(g.class)).aXI().d(aVar.Pwc.getContext(), bundle);
                        AppMethodBeat.o(37095);
                        break;
                    } else {
                        AppMethodBeat.o(37095);
                        break;
                    }
                default:
                    AppMethodBeat.o(37095);
                    break;
            }
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37096);
            ((com.tencent.mm.plugin.comm.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
            view.getTag();
            String str = caVar.field_content;
            if (str == null) {
                AppMethodBeat.o(37096);
                return false;
            }
            k.b HD = k.b.HD(str);
            if (HD == null) {
                AppMethodBeat.o(37096);
                return false;
            }
            com.tencent.mm.pluginsdk.model.app.g o = com.tencent.mm.pluginsdk.model.app.h.o(HD.appId, true, false);
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
            EventCenter.instance.publish(wqVar);
            AppMethodBeat.o(37096);
            return true;
        }

        @Override // com.tencent.mm.modelappbrand.h
        public final void L(View view, int i2) {
            AppMethodBeat.i(37097);
            Object tag = view.getTag();
            if (!(tag instanceof d)) {
                AppMethodBeat.o(37097);
                return;
            }
            Log.i("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "onWidgetStateChanged(%s, state : %d)", Integer.valueOf(view.hashCode()), Integer.valueOf(i2));
            d dVar = (d) tag;
            switch (i2) {
                case 0:
                    dVar.odq.setVisibility(0);
                    dVar.odq.gZh();
                    dVar.PLV.setVisibility(4);
                    dVar.puw.setVisibility(4);
                    AppMethodBeat.o(37097);
                    return;
                case 1:
                    dVar.odq.gZi();
                    dVar.odq.setVisibility(4);
                    dVar.PLV.setVisibility(4);
                    dVar.puw.setVisibility(0);
                    dVar.puw.setImageResource(R.raw.dynamic_page_res_not_found);
                    AppMethodBeat.o(37097);
                    return;
                case 2:
                case 3:
                default:
                    dVar.odq.gZi();
                    dVar.odq.setVisibility(4);
                    dVar.PLV.setVisibility(4);
                    dVar.puw.setVisibility(0);
                    dVar.puw.setImageResource(R.raw.app_brand_share_page_cover_default);
                    AppMethodBeat.o(37097);
                    return;
                case 4:
                    dVar.odq.gZi();
                    dVar.odq.setVisibility(4);
                    dVar.PLV.setVisibility(0);
                    dVar.puw.setVisibility(4);
                    AppMethodBeat.o(37097);
                    return;
            }
        }

        @Override // com.tencent.mm.ui.chatting.t.n
        public final void b(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233813);
            if (caVar.dOQ()) {
                com.tencent.mm.pluginsdk.model.app.m.aS(caVar);
                bp.Ad(caVar.field_msgId);
                aVar.BN(true);
                AppMethodBeat.o(233813);
                return;
            }
            AppMethodBeat.o(233813);
        }
    }

    static class d extends c.a {
        public static final int PLR = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 240);
        public static final int PLS = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 192);
        static final com.tencent.mm.av.a.a.c gvY;
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
        protected TextView PIy;
        protected TextView PLT;
        protected ViewGroup PLU;
        protected View PLV;
        protected ThreeDotsLoadingView odq;
        protected ImageView puw;

        d() {
        }

        static {
            AppMethodBeat.i(37104);
            c.a aVar = new c.a();
            aVar.jbq = R.raw.app_brand_app_default_icon_for_tail;
            c.a dr = aVar.dr(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 20), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 20));
            dr.iaT = true;
            dr.jbf = true;
            dr.jbd = true;
            gvY = aVar.bdv();
            AppMethodBeat.o(37104);
        }

        public final d R(View view, boolean z) {
            AppMethodBeat.i(37103);
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
            this.odq = (ThreeDotsLoadingView) view.findViewById(R.id.epy);
            this.puw = (ImageView) view.findViewById(R.id.bh7);
            this.PIy = (TextView) view.findViewById(R.id.asz);
            this.PLT = (TextView) view.findViewById(R.id.asq);
            this.PIr = (ImageView) view.findViewById(R.id.at1);
            this.PIs = (TextView) view.findViewById(R.id.at3);
            this.PIt = (TextView) view.findViewById(R.id.at2);
            this.PLU = (ViewGroup) view.findViewById(R.id.bhf);
            AppMethodBeat.o(37103);
            return this;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c.a
        public final View getMainContainerView() {
            return this.PIf;
        }
    }

    static class c implements com.tencent.mm.ui.m {
        private WeakReference<com.tencent.mm.ui.chatting.e.a> pvS;

        c() {
        }

        /* access modifiers changed from: package-private */
        public final void n(com.tencent.mm.ui.chatting.e.a aVar) {
            AppMethodBeat.i(37099);
            this.pvS = new WeakReference<>(aVar);
            ((j) aVar.bh(j.class)).a(this);
            AppMethodBeat.o(37099);
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
            AppMethodBeat.i(37100);
            if (this.pvS == null) {
                AppMethodBeat.o(37100);
                return;
            }
            com.tencent.mm.ui.chatting.e.a aVar = this.pvS.get();
            if (aVar != null) {
                ((g) com.tencent.mm.kernel.g.af(g.class)).aXH().Lo(n.cO(aVar));
            }
            AppMethodBeat.o(37100);
        }

        @Override // com.tencent.mm.ui.m
        public final void cFy() {
            AppMethodBeat.i(37101);
            if (this.pvS == null) {
                AppMethodBeat.o(37101);
                return;
            }
            com.tencent.mm.ui.chatting.e.a aVar = this.pvS.get();
            if (aVar != null) {
                ((g) com.tencent.mm.kernel.g.af(g.class)).aXH().Ln(n.cO(aVar));
            }
            AppMethodBeat.o(37101);
        }

        @Override // com.tencent.mm.ui.m
        public final void gIn() {
            AppMethodBeat.i(37102);
            Log.i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExitAnimStart, then detach DynamicPageView.");
            if (this.pvS == null) {
                AppMethodBeat.o(37102);
                return;
            }
            com.tencent.mm.ui.chatting.e.a aVar = this.pvS.get();
            if (aVar != null) {
                ad.aVe().JW(n.cO(aVar));
                ((j) aVar.bh(j.class)).b(this);
                ((g) com.tencent.mm.kernel.g.af(g.class)).Lp(n.cO(aVar));
            }
            AppMethodBeat.o(37102);
        }

        @Override // com.tencent.mm.ui.m
        public final void gIo() {
        }
    }
}
