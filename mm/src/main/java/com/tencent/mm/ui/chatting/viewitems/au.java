package com.tencent.mm.ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.viewitems.c;

public final class au extends c {
    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean gTT() {
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean bM(int i2, boolean z) {
        if (i2 == -1879048176) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final View a(LayoutInflater layoutInflater, View view) {
        AppMethodBeat.i(37316);
        if (view == null || view.getTag() == null) {
            view = new an(layoutInflater, R.layout.sd);
            view.setTag(new a().hg(view));
        }
        AppMethodBeat.o(37316);
        return view;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
        boolean z;
        k.b bVar;
        AppMethodBeat.i(37317);
        a aVar3 = (a) aVar;
        k GL = ao.gnf().GL(caVar.field_msgId);
        String str2 = caVar.field_content;
        if (GL == null || str2 == null) {
            Object[] objArr = new Object[4];
            if (GL == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = str2;
            objArr[2] = Long.valueOf(caVar.field_msgId);
            objArr[3] = str;
            Log.e("MicroMsg.ChattingItemHardDeviceMsgPush", "amessage:%b, %s, %d, %s", objArr);
            bVar = null;
        } else {
            bVar = k.b.aD(str2, caVar.field_reserved);
        }
        bq bqVar = new bq(caVar, aVar2.gRM(), i2, (String) null, (char) 0);
        if (bVar != null && (bVar.dDG == 3 || bVar.ixF == 3)) {
            aVar3.keC.setImageResource(R.drawable.bg5);
            aVar3.POc.setText(bVar.ixK);
        }
        aVar.clickArea.setOnLongClickListener(c(aVar2));
        aVar.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
        aVar.clickArea.setTag(bqVar);
        AppMethodBeat.o(37317);
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean a(m mVar, View view, ca caVar) {
        AppMethodBeat.i(233909);
        mVar.a(((bq) view.getTag()).position, 100, view.getContext().getString(R.string.b06), R.raw.icons_filled_delete);
        AppMethodBeat.o(233909);
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
        AppMethodBeat.i(37319);
        menuItem.getItemId();
        AppMethodBeat.o(37319);
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
        return false;
    }

    final class a extends c.a {
        protected TextView POc;
        protected ImageView keC;

        a() {
        }

        public final a hg(View view) {
            AppMethodBeat.i(37315);
            super.create(view);
            this.checkBox = (CheckBox) view.findViewById(R.id.aue);
            this.keC = (ImageView) view.findViewById(R.id.gma);
            this.POc = (TextView) view.findViewById(R.id.iol);
            AppMethodBeat.o(37315);
            return this;
        }
    }
}
