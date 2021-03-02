package com.tencent.mm.ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.am.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.viewitems.bd;
import com.tencent.mm.ui.chatting.viewitems.c;

public final class az {

    public static class a extends bd.a {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.bd.a, com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || (i2 != 55 && i2 != 57)) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.bd.a, com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37367);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.si);
                view.setTag(new c().hd(view));
            }
            AppMethodBeat.o(37367);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.bd.a, com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            AppMethodBeat.i(37368);
            this.PhN = aVar2;
            c cVar = (c) aVar;
            a.C0256a NS = a.C0256a.NS(caVar.field_content);
            if (NS == null) {
                AppMethodBeat.o(37368);
                return;
            }
            String str2 = NS.dRL;
            a(cVar, aVar2, caVar, str2);
            a(cVar, aVar2, str2, caVar);
            l.a(cVar.PNK.getContext(), com.tencent.mm.am.a.a(NS), (int) cVar.PNK.getTextSize(), 1, (Object) null, "");
            cVar.PNK.setTag(new bq(caVar, aVar2.gRM(), i2, (String) null, (char) 0));
            cVar.PNK.setOnLongClickListener(c(aVar2));
            AppMethodBeat.o(37368);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.chatting.viewitems.bd.a, com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTU() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.bd.a, com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233920);
            if (caVar.gDv()) {
                int i2 = ((bq) view.getTag()).position;
                if (caVar.field_status == 5) {
                    mVar.a(i2, 103, view.getContext().getString(R.string.b1y), R.raw.icons_filled_refresh);
                }
                if (!this.PhN.gRN()) {
                    mVar.a(i2, 100, view.getContext().getString(R.string.b06), R.raw.icons_filled_delete);
                }
            }
            AppMethodBeat.o(233920);
            return true;
        }
    }

    public static class b extends bd.b {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.bd.b, com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || (i2 != 55 && i2 != 57)) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.bd.b, com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            AppMethodBeat.i(37370);
            this.PhN = aVar2;
            bd.f fVar = (bd.f) aVar;
            a.C0256a NS = a.C0256a.NS(caVar.field_content);
            b(fVar, caVar.field_status < 2);
            l.a(fVar.POU.getContext(), com.tencent.mm.am.a.a(NS), (int) fVar.POU.getTextSize(), 1, (Object) null, "");
            fVar.POU.setTag(new bq(caVar, aVar2.gRM(), i2, (String) null, (char) 0));
            fVar.POU.setOnLongClickListener(c(aVar2));
            a(i2, fVar, caVar, aVar2.gRI(), aVar2.gRM(), aVar2, this);
            AppMethodBeat.o(37370);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.bd.b, com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233921);
            if (caVar.gDv()) {
                int i2 = ((bq) view.getTag()).position;
                if (caVar.field_status == 5) {
                    mVar.a(i2, 103, view.getContext().getString(R.string.b1y), R.raw.icons_filled_refresh);
                }
                if (!this.PhN.gRN()) {
                    mVar.a(i2, 100, view.getContext().getString(R.string.b06), R.raw.icons_filled_delete);
                }
            }
            AppMethodBeat.o(233921);
            return true;
        }
    }

    static class c extends c.a {
        TextView PNK;
        View pxo;
        TextView tln;

        c() {
        }

        public final c.a hd(View view) {
            AppMethodBeat.i(37372);
            super.create(view);
            this.timeTV = (TextView) view.findViewById(R.id.ayf);
            this.userTV = (TextView) view.findViewById(R.id.ayn);
            this.PNK = (TextView) view.findViewById(R.id.auk);
            this.tln = (TextView) view.findViewById(R.id.axx);
            this.checkBox = (CheckBox) view.findViewById(R.id.aue);
            this.maskView = view.findViewById(R.id.ax3);
            this.pxo = view.findViewById(R.id.awi);
            AppMethodBeat.o(37372);
            return this;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c.a
        public final View getMainContainerView() {
            return this.pxo;
        }
    }
}
