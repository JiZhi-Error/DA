package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.b;

public final class j extends g {
    public j(View view, b bVar) {
        super(view, bVar);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.fs.g, com.tencent.mm.plugin.topstory.ui.video.h
    public final void fzj() {
        AppMethodBeat.i(126398);
        if (this.GoY == null) {
            this.GoY = new k(this.Gmr.eeF(), this.Gmr, this);
            this.GoZ.removeAllViews();
            this.GoZ.addView(this.GoY, new FrameLayout.LayoutParams(this.Gmr.cZM().x, this.Gmr.cZM().y));
        }
        this.GoY.a(this.GjH, fyz());
        AppMethodBeat.o(126398);
    }
}
