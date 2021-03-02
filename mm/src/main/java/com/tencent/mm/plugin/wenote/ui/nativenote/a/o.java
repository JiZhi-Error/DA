package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class o extends j {
    public ImageView qOQ;
    public MMPinProgressBtn qOR;
    public ImageView qOS;
    private ImageView qOT;

    public o(View view, k kVar) {
        super(view, kVar);
        AppMethodBeat.i(30883);
        this.qOQ = (ImageView) view.findViewById(R.id.i59);
        this.qOR = (MMPinProgressBtn) view.findViewById(R.id.j62);
        this.qOS = (ImageView) view.findViewById(R.id.j6m);
        this.qOQ.setImageResource(R.raw.shortvideo_play_btn);
        this.qOT = (ImageView) view.findViewById(R.id.j5b);
        this.kmg.setVisibility(8);
        this.qOs.setVisibility(8);
        this.qOT.setVisibility(8);
        this.qOw.setTag(this);
        this.qOw.setOnClickListener(this.qOH);
        AppMethodBeat.o(30883);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0093  */
    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a.a, com.tencent.mm.plugin.wenote.ui.nativenote.a.j
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.wenote.model.a.c r8, int r9, int r10) {
        /*
        // Method dump skipped, instructions count: 155
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.ui.nativenote.a.o.a(com.tencent.mm.plugin.wenote.model.a.c, int, int):void");
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a.a
    public final int cCY() {
        return 6;
    }
}
