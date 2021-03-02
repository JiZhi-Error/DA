package com.tencent.mm.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.view.b.a;
import com.tencent.mm.view.b.c;

public final class m extends a {
    public m(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.view.a
    public final a hfv() {
        AppMethodBeat.i(9363);
        c cVar = new c(getContext(), getPresenter());
        AppMethodBeat.o(9363);
        return cVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.view.a
    public final com.tencent.mm.view.footer.a hfw() {
        AppMethodBeat.i(9364);
        com.tencent.mm.view.footer.c cVar = new com.tencent.mm.view.footer.c(getContext(), getPresenter());
        AppMethodBeat.o(9364);
        return cVar;
    }

    @Override // com.tencent.mm.view.a
    public final h[] getFeatures() {
        if (this.Riw == null) {
            this.Riw = new h[]{h.DOODLE, h.EMOJI, h.TEXT, h.MOSAIC, h.CROP_PHOTO};
        }
        return this.Riw;
    }
}
