package com.tencent.mm.ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView;

public final class ba extends c {
    private bb POI = new bb();
    private ay POJ = new ay();
    private bc POK = new bc();
    private bl POL = new bl();

    interface a {
        void b(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar);
    }

    public ba() {
        AppMethodBeat.i(37376);
        AppMethodBeat.o(37376);
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean gTT() {
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean bM(int i2, boolean z) {
        if (i2 == 10000 || i2 == 10002 || i2 == 570425393 || i2 == 64 || i2 == 603979825) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final View a(LayoutInflater layoutInflater, View view) {
        AppMethodBeat.i(37377);
        if (view == null || view.getTag() == null) {
            view = layoutInflater.inflate(R.layout.sj, (ViewGroup) null);
            b bVar = new b();
            bVar.convertView = view;
            bVar.timeTV = (TextView) view.findViewById(R.id.ayf);
            bVar.noMoreMsgTip = view.findViewById(R.id.axn);
            bVar.POM = (MMNeat7extView) view.findViewById(R.id.auk);
            bVar.POM.setOnTouchListener(new h(bVar.POM, new o(bVar.POM.getContext())));
            view.setTag(bVar);
        }
        AppMethodBeat.o(37377);
        return view;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
        a aVar3;
        AppMethodBeat.i(37378);
        if (caVar.getType() == 10002) {
            aVar3 = this.POJ;
        } else if (caVar.getType() == 570425393) {
            aVar3 = this.POK;
        } else if (caVar.getType() == 603979825) {
            aVar3 = this.POL;
        } else {
            aVar3 = this.POI;
        }
        aVar3.b(aVar, i2, aVar2, caVar);
        AppMethodBeat.o(37378);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean gTU() {
        return false;
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

    final class b extends c.a {
        NeatTextView POM;
        View convertView;

        b() {
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c.a
        public final View getMainContainerView() {
            return null;
        }
    }
}
