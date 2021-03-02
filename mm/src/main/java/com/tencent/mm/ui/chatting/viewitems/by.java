package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.c;

final class by extends c.a {
    TextView jBR;

    by() {
    }

    public final c.a hk(View view) {
        AppMethodBeat.i(37565);
        super.create(view);
        this.timeTV = (TextView) view.findViewById(R.id.ayf);
        this.userTV = (TextView) view.findViewById(R.id.ayn);
        this.jBR = (TextView) view.findViewById(R.id.auk);
        this.checkBox = (CheckBox) view.findViewById(R.id.aue);
        this.maskView = view.findViewById(R.id.ax3);
        AppMethodBeat.o(37565);
        return this;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c.a
    public final View getMainContainerView() {
        return null;
    }
}
