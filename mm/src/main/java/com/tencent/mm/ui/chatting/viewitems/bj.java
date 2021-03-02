package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.a.zi;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.c;

public final class bj {

    static abstract class a extends c {
        protected h PQk;

        a() {
        }

        /* access modifiers changed from: protected */
        public final h o(com.tencent.mm.ui.chatting.e.a aVar) {
            if (this.PQk == null) {
                this.PQk = new h(aVar);
            }
            return this.PQk;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public String a(com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return aVar.getTalkerUserName();
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public boolean gTT() {
            return false;
        }
    }

    static abstract class b extends c {
        protected h PQk;

        b() {
        }

        /* access modifiers changed from: protected */
        public final h o(com.tencent.mm.ui.chatting.e.a aVar) {
            if (this.PQk == null) {
                this.PQk = new h(aVar);
            }
            return this.PQk;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public boolean gTT() {
            return true;
        }
    }

    public static class e extends b {
        @Override // com.tencent.mm.ui.chatting.viewitems.c, com.tencent.mm.ui.chatting.viewitems.bj.b
        public final /* bridge */ /* synthetic */ boolean gTT() {
            AppMethodBeat.i(37527);
            boolean gTT = super.gTT();
            AppMethodBeat.o(37527);
            return gTT;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != 53) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37525);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.tl);
                view.setTag(new i().hd(view));
            }
            AppMethodBeat.o(37525);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            AppMethodBeat.i(37526);
            i.a((i) aVar, caVar, false, i2, aVar2, o(aVar2), c(aVar2));
            AppMethodBeat.o(37526);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }
    }

    public static class f extends c {
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (i2 == 52) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37528);
            if (view == null || view.getTag() == null) {
                view = layoutInflater.inflate(R.layout.ts, (ViewGroup) null);
                view.setTag(new i().hd(view));
            }
            AppMethodBeat.o(37528);
            return view;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTU() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            AppMethodBeat.i(37529);
            aVar.timeTV.setVisibility(0);
            aVar.timeTV.setText(com.tencent.mm.pluginsdk.i.f.t(aVar2.Pwc.getContext(), caVar.field_createTime));
            AppMethodBeat.o(37529);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTV() {
            return false;
        }
    }

    public static class g extends b {
        @Override // com.tencent.mm.ui.chatting.viewitems.c, com.tencent.mm.ui.chatting.viewitems.bj.b
        public final /* bridge */ /* synthetic */ boolean gTT() {
            AppMethodBeat.i(37532);
            boolean gTT = super.gTT();
            AppMethodBeat.o(37532);
            return gTT;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != 50) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37530);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.tk);
                view.setTag(new i().hd(view));
            }
            AppMethodBeat.o(37530);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            AppMethodBeat.i(37531);
            i.a((i) aVar, caVar, false, i2, aVar2, o(aVar2), c(aVar2));
            AppMethodBeat.o(37531);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTV() {
            return false;
        }
    }

    public static class c extends a {
        @Override // com.tencent.mm.ui.chatting.viewitems.c, com.tencent.mm.ui.chatting.viewitems.bj.a
        public final /* bridge */ /* synthetic */ String a(com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37520);
            String a2 = super.a(aVar, caVar);
            AppMethodBeat.o(37520);
            return a2;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c, com.tencent.mm.ui.chatting.viewitems.bj.a
        public final /* bridge */ /* synthetic */ boolean gTT() {
            AppMethodBeat.i(37519);
            boolean gTT = super.gTT();
            AppMethodBeat.o(37519);
            return gTT;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || i2 != 50) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37517);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.s8);
                view.setTag(new i().hd(view));
            }
            AppMethodBeat.o(37517);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            AppMethodBeat.i(37518);
            i.a((i) aVar, caVar, true, i2, aVar2, o(aVar2), c(aVar2));
            AppMethodBeat.o(37518);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }
    }

    public static class d extends a {
        @Override // com.tencent.mm.ui.chatting.viewitems.c, com.tencent.mm.ui.chatting.viewitems.bj.a
        public final /* bridge */ /* synthetic */ String a(com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37524);
            String a2 = super.a(aVar, caVar);
            AppMethodBeat.o(37524);
            return a2;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c, com.tencent.mm.ui.chatting.viewitems.bj.a
        public final /* bridge */ /* synthetic */ boolean gTT() {
            AppMethodBeat.i(37523);
            boolean gTT = super.gTT();
            AppMethodBeat.o(37523);
            return gTT;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || i2 != 53) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37521);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.s9);
                view.setTag(new i().hd(view));
            }
            AppMethodBeat.o(37521);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            AppMethodBeat.i(37522);
            i.a((i) aVar, caVar, true, i2, aVar2, o(aVar2), c(aVar2));
            AppMethodBeat.o(37522);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }
    }

    static final class i extends c.a {
        TextView PNK;
        View PQn = null;

        i() {
        }

        public final c.a hd(View view) {
            AppMethodBeat.i(37538);
            super.create(view);
            this.timeTV = (TextView) view.findViewById(R.id.ayf);
            this.PNK = (TextView) view.findViewById(R.id.azd);
            this.clickArea = view.findViewById(R.id.auf);
            this.PQn = view.findViewById(R.id.azc);
            this.stateIV = (ImageView) view.findViewById(R.id.ayb);
            this.checkBox = (CheckBox) view.findViewById(R.id.aue);
            this.maskView = view.findViewById(R.id.ax3);
            AppMethodBeat.o(37538);
            return this;
        }

        public static void a(i iVar, ca caVar, boolean z, int i2, com.tencent.mm.ui.chatting.e.a aVar, h hVar, View.OnLongClickListener onLongClickListener) {
            AppMethodBeat.i(37539);
            if (iVar == null) {
                AppMethodBeat.o(37539);
                return;
            }
            if (iVar.stateIV != null) {
                iVar.stateIV.setVisibility(caVar.field_status == 6 ? 8 : 0);
            }
            iVar.clickArea.setTag(new bq(caVar, aVar.gRM(), i2, (String) null, (char) 0));
            iVar.clickArea.setOnClickListener(hVar);
            iVar.clickArea.setOnLongClickListener(onLongClickListener);
            iVar.clickArea.setOnTouchListener(((k) aVar.bh(k.class)).gOC());
            String str = caVar.fqK;
            if (!Util.isNullOrNil(str)) {
                iVar.PNK.setText(str);
            } else if (z) {
                iVar.PNK.setText(R.string.i14);
            } else {
                iVar.PNK.setText(R.string.i15);
            }
            if (iVar.PQn == null) {
                AppMethodBeat.o(37539);
            } else if (!caVar.field_content.equals(ca.OqB) && !En(caVar.field_content)) {
                if (caVar.field_content.equals(ca.OqC) || Em(caVar.field_content)) {
                    if (z) {
                        iVar.PQn.setBackground(ar.e(aVar.Pwc.getContext().getDrawable(R.raw.voip_videocall), aVar.Pwc.getContext().getResources().getColor(R.color.FG_0)));
                        AppMethodBeat.o(37539);
                        return;
                    }
                    iVar.PQn.setBackgroundResource(R.raw.voip_videocall_to);
                }
                AppMethodBeat.o(37539);
            } else if (z) {
                iVar.PQn.setBackground(ar.e(aVar.Pwc.getContext().getDrawable(R.raw.voip_voicecall), aVar.Pwc.getContext().getResources().getColor(R.color.FG_0)));
                AppMethodBeat.o(37539);
            } else {
                iVar.PQn.setBackgroundResource(R.raw.voip_voicecall);
                AppMethodBeat.o(37539);
            }
        }

        private static boolean En(String str) {
            AppMethodBeat.i(37540);
            zj zjVar = new zj();
            zjVar.efx.dKy = 1;
            zjVar.efx.content = str;
            EventCenter.instance.publish(zjVar);
            if (zjVar.efy.type == 3) {
                AppMethodBeat.o(37540);
                return true;
            }
            AppMethodBeat.o(37540);
            return false;
        }

        private static boolean Em(String str) {
            AppMethodBeat.i(37541);
            zj zjVar = new zj();
            zjVar.efx.dKy = 1;
            zjVar.efx.content = str;
            EventCenter.instance.publish(zjVar);
            if (zjVar.efy.type == 2) {
                AppMethodBeat.o(37541);
                return true;
            }
            AppMethodBeat.o(37541);
            return false;
        }
    }

    public static class h extends t.e {
        static /* synthetic */ void a(h hVar, bq bqVar) {
            AppMethodBeat.i(37537);
            hVar.c(bqVar);
            AppMethodBeat.o(37537);
        }

        public h(com.tencent.mm.ui.chatting.e.a aVar) {
            super(aVar);
        }

        @Override // com.tencent.mm.ui.chatting.t.e
        public final void a(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            boolean z;
            boolean z2;
            AppMethodBeat.i(37535);
            final bq bqVar = (bq) view.getTag();
            String str = caVar.field_content;
            zj zjVar = new zj();
            zjVar.efx.dKy = 1;
            zjVar.efx.content = str;
            EventCenter.instance.publish(zjVar);
            if (zjVar.efy.type == 2) {
                z = true;
            } else {
                z = false;
            }
            if (!z && !caVar.field_content.equals(ca.OqC)) {
                String str2 = caVar.field_content;
                zj zjVar2 = new zj();
                zjVar2.efx.dKy = 1;
                zjVar2.efx.content = str2;
                EventCenter.instance.publish(zjVar2);
                if (zjVar2.efy.type == 3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if ((z2 || caVar.field_content.equals(ca.OqB)) && !com.tencent.mm.q.a.cA(this.PhN.Pwc.getContext()) && !com.tencent.mm.q.a.cB(this.PhN.Pwc.getContext()) && !com.tencent.mm.q.a.cE(this.PhN.Pwc.getContext())) {
                    zi ziVar = new zi();
                    EventCenter.instance.publish(ziVar);
                    if (bqVar.dTX.field_talker.equals(ziVar.efv.talker) || (!ziVar.efv.dCH && !ziVar.efv.dCI)) {
                        bqVar.dTX.setStatus(6);
                        bg.aVF();
                        com.tencent.mm.model.c.aSQ().a(bqVar.dTX.field_msgId, bqVar.dTX);
                        ((u) this.PhN.bh(u.class)).gPS();
                        zj zjVar3 = new zj();
                        zjVar3.efx.dKy = 5;
                        zjVar3.efx.talker = bqVar.dTX.field_talker;
                        zjVar3.efx.context = this.PhN.Pwc.getContext();
                        zjVar3.efx.eft = 4;
                        EventCenter.instance.publish(zjVar3);
                        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                        Object[] objArr = new Object[3];
                        objArr[0] = 3;
                        objArr[1] = 2;
                        objArr[2] = Integer.valueOf((bqVar.dTX.fqK == null || bqVar.dTX.fqK.length() <= 0) ? 1 : 3);
                        hVar.a(11033, objArr);
                    } else {
                        Toast.makeText(this.PhN.Pwc.getContext(), ziVar.efv.efw ? R.string.an0 : R.string.an1, 0).show();
                        Log.i("MicroMsg.VoipClickListener", "voip is running, can't do this");
                    }
                }
            } else if (!com.tencent.mm.q.a.cA(this.PhN.Pwc.getContext()) && !com.tencent.mm.q.a.cB(this.PhN.Pwc.getContext()) && !com.tencent.mm.q.a.cE(this.PhN.Pwc.getContext()) && !com.tencent.mm.q.a.p(this.PhN.Pwc.getContext(), true)) {
                zi ziVar2 = new zi();
                EventCenter.instance.publish(ziVar2);
                if (bqVar.dTX.field_talker.equals(ziVar2.efv.talker) || (!ziVar2.efv.dCH && !ziVar2.efv.dCI)) {
                    xq xqVar = new xq();
                    xqVar.edR.edT = true;
                    EventCenter.instance.publish(xqVar);
                    String str3 = xqVar.edS.edV;
                    if (!af.isNullOrNil(str3)) {
                        Log.v("MicroMsg.VoipClickListener", "Talkroom is on: ".concat(String.valueOf(str3)));
                        com.tencent.mm.ui.base.h.c(this.PhN.Pwc.getContext(), this.PhN.Pwc.getContext().getString(R.string.hke), "", this.PhN.Pwc.getContext().getString(R.string.x_), this.PhN.Pwc.getContext().getString(R.string.sz), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.viewitems.bj.h.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(37533);
                                xq xqVar = new xq();
                                xqVar.edR.edU = true;
                                EventCenter.instance.publish(xqVar);
                                fo foVar = new fo();
                                foVar.dIN.username = com.tencent.mm.bi.d.jpB.bgL();
                                EventCenter.instance.publish(foVar);
                                h.a(h.this, bqVar);
                                dialogInterface.dismiss();
                                AppMethodBeat.o(37533);
                            }
                        }, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.viewitems.bj.h.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(37534);
                                dialogInterface.dismiss();
                                AppMethodBeat.o(37534);
                            }
                        });
                    } else {
                        c(bqVar);
                    }
                } else {
                    Toast.makeText(this.PhN.Pwc.getContext(), ziVar2.efv.efw ? R.string.an0 : R.string.an1, 0).show();
                    Log.i("MicroMsg.VoipClickListener", "voip is running, can't do this");
                }
            }
            ((com.tencent.mm.plugin.comm.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
            AppMethodBeat.o(37535);
        }

        private void c(bq bqVar) {
            int i2;
            AppMethodBeat.i(177732);
            bqVar.dTX.setStatus(6);
            bg.aVF();
            com.tencent.mm.model.c.aSQ().a(bqVar.dTX.field_msgId, bqVar.dTX);
            ((u) this.PhN.bh(u.class)).gPS();
            zj zjVar = new zj();
            zjVar.efx.dKy = 5;
            zjVar.efx.talker = bqVar.dTX.field_talker;
            zjVar.efx.context = this.PhN.Pwc.getContext();
            zjVar.efx.eft = 2;
            EventCenter.instance.publish(zjVar);
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr = new Object[3];
            objArr[0] = 3;
            objArr[1] = 1;
            if (bqVar.dTX.fqK == null || bqVar.dTX.fqK.length() <= 0) {
                i2 = 1;
            } else {
                i2 = 3;
            }
            objArr[2] = Integer.valueOf(i2);
            hVar.a(11033, objArr);
            AppMethodBeat.o(177732);
        }
    }
}
