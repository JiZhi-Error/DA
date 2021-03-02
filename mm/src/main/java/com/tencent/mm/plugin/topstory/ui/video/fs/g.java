package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.f;
import com.tencent.mm.plugin.topstory.ui.video.h;

public class g extends h implements a {
    public e GoY;
    public FrameLayout GoZ;

    public g(View view, b bVar) {
        super(view, bVar);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.h
    public final void fU(View view) {
        AppMethodBeat.i(126323);
        this.GoZ = (FrameLayout) view.findViewById(R.id.j6z);
        AppMethodBeat.o(126323);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.h
    public final void wu(boolean z) {
        AppMethodBeat.i(126324);
        super.wu(z);
        this.Gmr.abV(lR());
        if (this.GoY.ay(z, false)) {
            fyy();
            fyx();
        }
        AppMethodBeat.o(126324);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.h
    public void fzj() {
        FrameLayout.LayoutParams layoutParams;
        AppMethodBeat.i(126325);
        if (this.GoY == null) {
            if (this.Gmr.fyL()) {
                this.GoY = new k(this.Gmr.eeF(), this.Gmr, this);
            } else {
                this.GoY = new e(this.Gmr.eeF(), this.Gmr, this);
            }
            this.GoZ.removeAllViews();
            if (this.Gmr.fyL()) {
                layoutParams = new FrameLayout.LayoutParams(this.Gmr.cZM().x, this.Gmr.cZM().y);
            } else {
                layoutParams = new FrameLayout.LayoutParams(this.Gmr.cZM().y, this.Gmr.cZM().x);
            }
            this.GoZ.addView(this.GoY, layoutParams);
        }
        this.GoY.a(this.GjH, fyz());
        AppMethodBeat.o(126325);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.a, com.tencent.mm.plugin.topstory.ui.video.h
    public final int fyz() {
        AppMethodBeat.i(263561);
        int lR = lR();
        AppMethodBeat.o(263561);
        return lR;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.h
    public final View getWowView() {
        AppMethodBeat.i(126327);
        View wowView = this.GoY.getControlBar().getWowView();
        AppMethodBeat.o(126327);
        return wowView;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.h
    public final f fzk() {
        return this.GoY;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.fs.a
    public final void acf(int i2) {
        AppMethodBeat.i(126328);
        a(this.Gmr, this.Gmr.eeF(), this.GoY, i2);
        AppMethodBeat.o(126328);
    }
}
