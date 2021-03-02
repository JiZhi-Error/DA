package com.tencent.mm.ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.viewitems.c;

public final class bk {

    static abstract class a extends c {
        a() {
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean b(com.tencent.mm.ui.chatting.e.a aVar) {
            return false;
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

    public static class c extends c {
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (i2 == -1879048188) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37546);
            if (view == null || view.getTag() == null) {
                view = layoutInflater.inflate(R.layout.ts, (ViewGroup) null);
                view.setTag(new d().hd(view));
            }
            AppMethodBeat.o(37546);
            return view;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTU() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            AppMethodBeat.i(37547);
            aVar.timeTV.setVisibility(0);
            aVar.timeTV.setText(f.u(aVar2.Pwc.getContext(), caVar.field_createTime));
            AppMethodBeat.o(37547);
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

    public static class b extends a {
        @Override // com.tencent.mm.ui.chatting.viewitems.c, com.tencent.mm.ui.chatting.viewitems.bk.a
        public final /* bridge */ /* synthetic */ String a(com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37545);
            String a2 = super.a(aVar, caVar);
            AppMethodBeat.o(37545);
            return a2;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c, com.tencent.mm.ui.chatting.viewitems.bk.a
        public final /* bridge */ /* synthetic */ boolean gTT() {
            AppMethodBeat.i(37544);
            boolean gTT = super.gTT();
            AppMethodBeat.o(37544);
            return gTT;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (i2 == -1879048187) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37542);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.s8);
                view.setTag(new d().hd(view));
            }
            AppMethodBeat.o(37542);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            AppMethodBeat.i(37543);
            d dVar = (d) aVar;
            c.View$OnLongClickListenerC2106c c2 = c(aVar2);
            if (dVar != null) {
                dVar.clickArea.setTag(new bq(caVar, aVar2.gRM(), i2, (String) null, (char) 0));
                dVar.clickArea.setOnLongClickListener(c2);
                dVar.clickArea.setOnTouchListener(((k) aVar2.bh(k.class)).gOC());
            }
            AppMethodBeat.o(37543);
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

    static class d extends c.a {
        TextView PNK;

        d() {
        }

        public final c.a hd(View view) {
            AppMethodBeat.i(37548);
            super.create(view);
            this.timeTV = (TextView) view.findViewById(R.id.ayf);
            this.PNK = (TextView) view.findViewById(R.id.azd);
            this.clickArea = view.findViewById(R.id.auf);
            this.stateIV = (ImageView) view.findViewById(R.id.ayb);
            this.checkBox = (CheckBox) view.findViewById(R.id.aue);
            this.maskView = view.findViewById(R.id.ax3);
            AppMethodBeat.o(37548);
            return this;
        }
    }
}
