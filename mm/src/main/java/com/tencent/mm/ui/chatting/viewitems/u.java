package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.chatting.viewitems.e;

public final class u {
    private static float ppN = 0.1f;

    public static class c extends c implements t.n {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != 939524145) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(233711);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.sx);
                view.setTag(new a().P(view, true));
            }
            AppMethodBeat.o(233711);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            boolean z = false;
            AppMethodBeat.i(233712);
            this.PhN = aVar2;
            a aVar3 = (a) aVar;
            String str2 = caVar.field_content;
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            } else {
                bVar = null;
            }
            if (bVar != null) {
                com.tencent.mm.plugin.game.luggage.f.a aVar4 = (com.tencent.mm.plugin.game.luggage.f.a) bVar.as(com.tencent.mm.plugin.game.luggage.f.a.class);
                if (aVar4 != null) {
                    u.F(aVar3.gyr, aVar4.iconUrl);
                    aVar3.pIN.setText(l.c(aVar2.Pwc.getContext(), aVar4.nickName));
                    if (Util.isNullOrNil(aVar4.desc)) {
                        aVar3.hPW.setVisibility(8);
                    } else {
                        aVar3.hPW.setVisibility(0);
                        aVar3.hPW.setText(l.c(aVar2.Pwc.getContext(), aVar4.desc));
                    }
                    if (Util.isNullOrNil(aVar4.xxN)) {
                        aVar3.PKz.setText(aVar2.Pwc.getMMResources().getString(R.string.dr8));
                    } else {
                        aVar3.PKz.setText(l.c(aVar2.Pwc.getContext(), aVar4.xxN));
                    }
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
                if (caVar.field_status < 2) {
                    z = true;
                }
                b(aVar3, z);
            }
            a(i2, aVar3, caVar, aVar2.gRI(), aVar2.gRM(), aVar2, this);
            AppMethodBeat.o(233712);
        }

        @Override // com.tencent.mm.ui.chatting.t.n
        public final void b(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233713);
            if (caVar.dOQ()) {
                m.aS(caVar);
                bp.Ad(caVar.field_msgId);
                aVar.BN(true);
            }
            AppMethodBeat.o(233713);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            AppMethodBeat.i(233714);
            int i2 = ((bq) view.getTag()).position;
            if (caVar != null) {
                if ((caVar.field_status == 2 || caVar.fQV == 1) && b(caVar, this.PhN) && bnf(caVar.field_talker) && !as.HF(this.PhN.getTalkerUserName())) {
                    mVar.a(i2, 123, view.getContext().getString(R.string.b0i), R.raw.icons_filled_previous);
                }
                mVar.a(i2, 111, view.getContext().getString(R.string.g5c), R.raw.icons_filled_share);
            }
            AppMethodBeat.o(233714);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233715);
            switch (menuItem.getItemId()) {
                case 111:
                    e.b.a(aVar, caVar, a(aVar, caVar));
                    AppMethodBeat.o(233715);
                    return true;
                default:
                    AppMethodBeat.o(233715);
                    return false;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            com.tencent.mm.plugin.game.luggage.f.a aVar2;
            AppMethodBeat.i(233716);
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            if (!(bVar == null || (aVar2 = (com.tencent.mm.plugin.game.luggage.f.a) bVar.as(com.tencent.mm.plugin.game.luggage.f.a.class)) == null || Util.isNullOrNil(aVar2.jumpUrl))) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", aVar2.jumpUrl);
                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            }
            AppMethodBeat.o(233716);
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
            if (z || i2 != 939524145) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(233706);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.rj);
                view.setTag(new a().P(view, false));
            }
            AppMethodBeat.o(233706);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            AppMethodBeat.i(233707);
            this.PhN = aVar2;
            a aVar3 = (a) aVar;
            String str2 = caVar.field_content;
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            } else {
                bVar = null;
            }
            if (bVar != null) {
                com.tencent.mm.plugin.game.luggage.f.a aVar4 = (com.tencent.mm.plugin.game.luggage.f.a) bVar.as(com.tencent.mm.plugin.game.luggage.f.a.class);
                if (aVar4 != null) {
                    u.F(aVar3.gyr, aVar4.iconUrl);
                    aVar3.pIN.setText(l.c(aVar2.Pwc.getContext(), aVar4.nickName));
                    if (Util.isNullOrNil(aVar4.desc)) {
                        aVar3.hPW.setVisibility(8);
                    } else {
                        aVar3.hPW.setVisibility(0);
                        aVar3.hPW.setText(l.c(aVar2.Pwc.getContext(), aVar4.desc));
                    }
                    if (Util.isNullOrNil(aVar4.xxN)) {
                        aVar3.PKz.setText(aVar2.Pwc.getMMResources().getString(R.string.dr8));
                    } else {
                        aVar3.PKz.setText(l.c(aVar2.Pwc.getContext(), aVar4.xxN));
                    }
                }
                aVar3.clickArea.setOnClickListener(d(aVar2));
                aVar3.clickArea.setOnLongClickListener(c(aVar2));
                aVar3.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
                aVar3.clickArea.setTag(new bq(caVar, this.PhN.gRM(), i2, (String) null, (char) 0));
            }
            AppMethodBeat.o(233707);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            AppMethodBeat.i(233708);
            mVar.a(0, 111, view.getContext().getString(R.string.g5c), R.raw.icons_filled_share);
            AppMethodBeat.o(233708);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233709);
            switch (menuItem.getItemId()) {
                case 111:
                    e.b.a(aVar, caVar, a(aVar, caVar));
                    AppMethodBeat.o(233709);
                    return true;
                default:
                    AppMethodBeat.o(233709);
                    return false;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            com.tencent.mm.plugin.game.luggage.f.a aVar2;
            AppMethodBeat.i(233710);
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            if (!(bVar == null || (aVar2 = (com.tencent.mm.plugin.game.luggage.f.a) bVar.as(com.tencent.mm.plugin.game.luggage.f.a.class)) == null || Util.isNullOrNil(aVar2.jumpUrl))) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", aVar2.jumpUrl);
                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            }
            AppMethodBeat.o(233710);
            return false;
        }
    }

    static class a extends c.a {
        TextView PKz;
        ImageView gyr;
        TextView hPW;
        TextView pIN;
        public ImageView tickIV;

        a() {
        }

        public final a P(View view, boolean z) {
            AppMethodBeat.i(233705);
            super.create(view);
            this.gyr = (ImageView) view.findViewById(R.id.dhw);
            this.pIN = (TextView) view.findViewById(R.id.dhz);
            this.hPW = (TextView) view.findViewById(R.id.dhy);
            this.PKz = (TextView) view.findViewById(R.id.di0);
            this.userTV = (TextView) view.findViewById(R.id.ayn);
            if (z) {
                this.uploadingPB = (ProgressBar) view.findViewById(R.id.j0y);
                this.tickIV = (ImageView) view.findViewById(R.id.ayd);
            }
            AppMethodBeat.o(233705);
            return this;
        }
    }

    static /* synthetic */ void F(ImageView imageView, String str) {
        AppMethodBeat.i(233717);
        if (imageView != null) {
            e.a.C1397a aVar = new e.a.C1397a();
            aVar.jbd = true;
            aVar.jbf = true;
            aVar.xZw = ppN;
            com.tencent.mm.plugin.game.e.e.dWR().a(imageView, str, aVar.dWS());
        }
        AppMethodBeat.o(233717);
    }
}
