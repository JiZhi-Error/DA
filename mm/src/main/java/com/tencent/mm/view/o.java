package com.tencent.mm.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.view.b.a;
import com.tencent.mm.view.b.d;

public final class o extends a {
    public o(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.view.a
    public final a hfv() {
        AppMethodBeat.i(9370);
        d dVar = new d(getContext(), getPresenter());
        AppMethodBeat.o(9370);
        return dVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.view.a
    public final com.tencent.mm.view.footer.a hfw() {
        AppMethodBeat.i(9371);
        com.tencent.mm.view.footer.d dVar = new com.tencent.mm.view.footer.d(getContext(), getPresenter());
        AppMethodBeat.o(9371);
        return dVar;
    }

    @Override // com.tencent.mm.view.a
    public final h[] getFeatures() {
        if (this.Riw == null) {
            this.Riw = new h[]{h.DOODLE, h.EMOJI, h.TEXT, h.CROP_VIDEO};
        }
        return this.Riw;
    }
}
