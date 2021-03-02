package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.c;

final class bx extends c.a {
    protected ImageView PRJ;
    protected TextView jBR;

    bx() {
    }

    public final bx hj(View view) {
        AppMethodBeat.i(37564);
        super.create(view);
        this.jBR = (TextView) view.findViewById(R.id.at9);
        this.PRJ = (ImageView) view.findViewById(R.id.att);
        this.checkBox = (CheckBox) view.findViewById(R.id.aue);
        this.maskView = view.findViewById(R.id.ax3);
        AppMethodBeat.o(37564);
        return this;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c.a
    public final View getMainContainerView() {
        return null;
    }
}
