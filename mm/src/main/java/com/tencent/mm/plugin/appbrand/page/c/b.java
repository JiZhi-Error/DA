package com.tencent.mm.plugin.appbrand.page.c;

import android.app.Activity;
import com.tencent.luggage.sdk.config.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.c.c;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.ui.y;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.concurrent.atomic.AtomicReference;

public class b implements c {
    protected final ac cxn;
    protected final AtomicReference<c.b> nvY = new AtomicReference<>();

    b(ac acVar) {
        AppMethodBeat.i(135314);
        this.nvY.set(c.b.SHOWN);
        this.cxn = acVar;
        AppMethodBeat.o(135314);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.c.c
    public final c.b Nl() {
        AppMethodBeat.i(135315);
        c.b bVar = this.nvY.get();
        AppMethodBeat.o(135315);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.c.c
    public void Nj() {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.c.c
    public void Nk() {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.c.c
    public void MV() {
        AppMethodBeat.i(135316);
        if (this.cxn.kEb instanceof o) {
            Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(((o) this.cxn.kEb).mContext);
            if (castActivityOrNull == null) {
                AppMethodBeat.o(135316);
                return;
            } else if (((a) this.cxn.av(a.class)).cyh) {
                y.x(castActivityOrNull, true);
                AppMethodBeat.o(135316);
                return;
            } else {
                y.x(castActivityOrNull, false);
            }
        }
        AppMethodBeat.o(135316);
    }
}
