package com.tencent.mm.ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.c;

public final class o {

    public static class c extends c implements t.n {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != 788529201) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(163333);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.sq);
                view.setTag(new a().K(view, true));
            }
            AppMethodBeat.o(163333);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            AppMethodBeat.i(163334);
            this.PhN = aVar2;
            a aVar3 = (a) aVar;
            String str2 = caVar.field_content;
            k.b bVar = null;
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            }
            if (bVar != null) {
                d dVar = (d) bVar.as(d.class);
                if (dVar != null) {
                    aVar3.PKt.setImageDrawable(ar.m(aVar2.Pwc.getContext(), R.raw.finder_share_icon, aVar2.Pwc.getContext().getResources().getColor(R.color.Orange_100)));
                    aVar3.PKu.setText(R.string.cls);
                    if (Util.isNullOrNil(dVar.desc)) {
                        aVar3.PKv.setVisibility(8);
                    } else {
                        aVar3.PKv.setVisibility(0);
                        aVar3.PKv.setText(l.c(aVar2.Pwc.getContext(), dVar.desc));
                    }
                    aVar3.gvw.setText(l.c(aVar2.Pwc.getContext(), dVar.title));
                }
                aVar3.clickArea.setOnClickListener(d(aVar2));
                aVar3.clickArea.setOnLongClickListener(c(aVar2));
                aVar3.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
                aVar3.clickArea.setTag(new bq(caVar, this.PhN.gRM(), i2, (String) null, (char) 0));
            }
            if (gTW()) {
                b((c.a) aVar3, false);
                if (caVar.field_status != 2 || !b((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class), caVar.field_msgId)) {
                    if (aVar3.tickIV != null) {
                        aVar3.tickIV.setVisibility(8);
                    }
                } else if (aVar3.tickIV != null) {
                    aVar3.tickIV.setVisibility(0);
                }
            } else {
                if (aVar3.tickIV != null) {
                    aVar3.tickIV.setVisibility(8);
                }
                b(aVar3, caVar.field_status < 2);
            }
            a(i2, aVar3, caVar, aVar2.gRI(), aVar2.gRM(), aVar2, this);
            AppMethodBeat.o(163334);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233664);
            int i2 = ((bq) view.getTag()).position;
            if (caVar != null && ((caVar.field_status == 2 || caVar.fQV == 1) && b(caVar, this.PhN) && bnf(caVar.field_talker) && !as.HF(this.PhN.getTalkerUserName()))) {
                mVar.a(i2, 123, view.getContext().getString(R.string.b0i), R.raw.icons_filled_previous);
            }
            AppMethodBeat.o(233664);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.t.n
        public final void b(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233665);
            if (caVar.dOQ()) {
                com.tencent.mm.pluginsdk.model.app.m.aS(caVar);
                bp.Ad(caVar.field_msgId);
                aVar.BN(true);
            }
            AppMethodBeat.o(233665);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            d dVar;
            AppMethodBeat.i(163337);
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            if (!(bVar == null || (dVar = (d) bVar.as(d.class)) == null)) {
                wq wqVar = new wq();
                wqVar.ecI.userName = "gh_4ee148a6ecaa@app";
                wqVar.ecI.appId = "wxdfda2588e999a42d";
                wqVar.ecI.ecK = dVar.tsr;
                EventCenter.instance.publish(wqVar);
            }
            AppMethodBeat.o(163337);
            return false;
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
            if (z || i2 != 788529201) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(163330);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.rc);
                view.setTag(new a().K(view, false));
            }
            AppMethodBeat.o(163330);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            AppMethodBeat.i(163331);
            this.PhN = aVar2;
            a aVar3 = (a) aVar;
            String str2 = caVar.field_content;
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            } else {
                bVar = null;
            }
            if (bVar != null) {
                d dVar = (d) bVar.as(d.class);
                if (dVar != null) {
                    aVar3.PKt.setImageDrawable(ar.m(aVar2.Pwc.getContext(), R.raw.finder_share_icon, aVar2.Pwc.getContext().getResources().getColor(R.color.Orange_100)));
                    aVar3.PKu.setText(R.string.cls);
                    if (Util.isNullOrNil(dVar.desc)) {
                        aVar3.PKv.setVisibility(8);
                    } else {
                        aVar3.PKv.setVisibility(0);
                        aVar3.PKv.setText(l.c(aVar2.Pwc.getContext(), dVar.desc));
                    }
                    aVar3.gvw.setText(l.c(aVar2.Pwc.getContext(), dVar.title));
                }
                aVar3.clickArea.setOnClickListener(d(aVar2));
                aVar3.clickArea.setOnLongClickListener(c(aVar2));
                aVar3.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
                aVar3.clickArea.setTag(new bq(caVar, this.PhN.gRM(), i2, (String) null, (char) 0));
            }
            AppMethodBeat.o(163331);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            d dVar;
            AppMethodBeat.i(163332);
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            if (!(bVar == null || (dVar = (d) bVar.as(d.class)) == null)) {
                wq wqVar = new wq();
                wqVar.ecI.userName = "gh_4ee148a6ecaa@app";
                wqVar.ecI.appId = "wxdfda2588e999a42d";
                wqVar.ecI.ecK = dVar.tsr;
                wqVar.ecI.scene = TXLiteAVCode.EVT_HW_ENCODER_START_SUCC;
                EventCenter.instance.publish(wqVar);
            }
            AppMethodBeat.o(163332);
            return false;
        }
    }

    static class a extends c.a {
        public int PJa;
        ImageView PKt;
        TextView PKu;
        TextView PKv;
        TextView gvw;
        public ImageView tickIV;

        a() {
        }

        public final a K(View view, boolean z) {
            AppMethodBeat.i(163329);
            super.create(view);
            this.PKt = (ImageView) this.convertView.findViewById(R.id.au3);
            this.timeTV = (TextView) this.convertView.findViewById(R.id.ayf);
            this.PKu = (TextView) this.convertView.findViewById(R.id.ayj);
            this.PKv = (TextView) this.convertView.findViewById(R.id.ayo);
            this.gvw = (TextView) this.convertView.findViewById(R.id.axm);
            this.userTV = (TextView) this.convertView.findViewById(R.id.ayn);
            this.clickArea = this.convertView.findViewById(R.id.auf);
            this.maskView = this.convertView.findViewById(R.id.ax3);
            if (z) {
                this.uploadingPB = (ProgressBar) view.findViewById(R.id.j0y);
                this.tickIV = (ImageView) view.findViewById(R.id.ayd);
            }
            this.PJa = c.kl(MMApplicationContext.getContext());
            AppMethodBeat.o(163329);
            return this;
        }
    }
}
