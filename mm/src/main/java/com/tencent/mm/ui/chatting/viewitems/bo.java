package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.viewitems.c;

final class bo extends c.a {
    public ImageView PIb;
    bp PQu = new bp();
    bv PQv = new bv();
    b PQw = new b();
    LinearLayout pxI;

    bo() {
        AppMethodBeat.i(37552);
        AppMethodBeat.o(37552);
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c.a
    public final View getMainContainerView() {
        return this.pxI;
    }
}
