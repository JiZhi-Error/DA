package com.tencent.mm.plugin.editor.adapter.a;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class h extends d {
    public ImageView qOQ;
    public MMPinProgressBtn qOR;
    public ImageView qOS;
    private ImageView qOT;

    public h(View view, j jVar) {
        super(view, jVar);
        AppMethodBeat.i(181663);
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
        AppMethodBeat.o(181663);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0096  */
    @Override // com.tencent.mm.plugin.editor.adapter.a.d, com.tencent.mm.plugin.editor.adapter.a.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.editor.model.a.a r9, int r10, int r11) {
        /*
        // Method dump skipped, instructions count: 158
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.editor.adapter.a.h.a(com.tencent.mm.plugin.editor.model.a.a, int, int):void");
    }

    @Override // com.tencent.mm.plugin.editor.adapter.a.a
    public final int cCY() {
        return 6;
    }
}
