package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class x {

    public static class b extends c {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || i2 != 704643121) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(36985);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.rm);
                view.setTag(new a().gU(view));
            }
            AppMethodBeat.o(36985);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            AppMethodBeat.i(36986);
            this.PhN = aVar2;
            a.a((a) aVar, i2, aVar2, caVar, this);
            AppMethodBeat.o(36986);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233730);
            int i2 = ((bq) view.getTag()).position;
            if (caVar != null) {
                mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
            }
            AppMethodBeat.o(233730);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
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
            if (!z || i2 != 704643121) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(36988);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.t0);
                view.setTag(new a().gU(view));
            }
            AppMethodBeat.o(36988);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            AppMethodBeat.i(36989);
            this.PhN = aVar2;
            a.a((a) aVar, i2, aVar2, caVar, this);
            AppMethodBeat.o(36989);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233731);
            mVar.a(((bq) view.getTag()).position, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
            AppMethodBeat.o(233731);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }
    }

    static class a extends c.a {
        private MMNeat7extView PKY;

        a() {
        }

        public final a gU(View view) {
            AppMethodBeat.i(36983);
            super.create(view);
            this.PKY = (MMNeat7extView) view.findViewById(R.id.auk);
            this.PKY.setOnTouchListener(new h(this.PKY, new o(this.PKY.getContext())));
            this.checkBox = (CheckBox) view.findViewById(R.id.aue);
            this.maskView = view.findViewById(R.id.ax3);
            this.uploadingPB = (ProgressBar) view.findViewById(R.id.j0y);
            AppMethodBeat.o(36983);
            return this;
        }

        public static void a(a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, c cVar) {
            int indexOf;
            AppMethodBeat.i(36984);
            k.b bVar = null;
            String str = caVar.field_content;
            if (aVar2.gRM() && (indexOf = caVar.field_content.indexOf(58)) != -1) {
                str = caVar.field_content.substring(indexOf + 1);
            }
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            if (bVar != null && bVar.type == 47) {
                String str2 = bVar.content;
                Bundle bundle = new Bundle();
                bundle.putString("rawUrl", bVar.url);
                bundle.putString("sender_name", caVar.field_talker);
                aVar.PKY.a(l.a(MMApplicationContext.getContext(), (CharSequence) str2, (int) aVar.PKY.getTextSize(), 4, (Object) bundle, true), TextView.BufferType.SPANNABLE);
                aVar.PKY.setTag(new bq(caVar, aVar2.gRM(), i2, caVar.field_talker, (char) 0));
                bg.aVF();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                    aVar.PKY.setOnLongClickListener(cVar.c(aVar2));
                }
            }
            AppMethodBeat.o(36984);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c.a
        public final View getMainContainerView() {
            return this.PKY;
        }
    }
}
