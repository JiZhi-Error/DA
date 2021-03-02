package com.tencent.mm.plugin.appbrand.utils.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.h;
import java.util.concurrent.atomic.AtomicBoolean;

public enum a implements e, h.a {
    INST;
    
    public static final c ohM = new c();
    private final e ohN = new b();
    private final AtomicBoolean ohO = new AtomicBoolean(false);

    private a(String str) {
        AppMethodBeat.i(137924);
        AppMethodBeat.o(137924);
    }

    public static a valueOf(String str) {
        AppMethodBeat.i(137923);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(137923);
        return aVar;
    }

    static {
        AppMethodBeat.i(137930);
        AppMethodBeat.o(137930);
    }

    @Override // com.tencent.mm.plugin.appbrand.utils.a.e
    public final void init(Context context) {
        AppMethodBeat.i(137925);
        if (!this.ohO.getAndSet(true)) {
            this.ohN.init(context);
        }
        AppMethodBeat.o(137925);
    }

    @Override // com.tencent.mm.plugin.appbrand.utils.a.e
    public final void release() {
        AppMethodBeat.i(137926);
        this.ohN.release();
        AppMethodBeat.o(137926);
    }

    @Override // com.tencent.mm.plugin.appbrand.utils.a.e
    public final c bZx() {
        AppMethodBeat.i(137927);
        c bZx = this.ohN.bZx();
        AppMethodBeat.o(137927);
        return bZx;
    }

    @Override // com.tencent.mm.plugin.appbrand.utils.h.a
    public final void er(Context context) {
        AppMethodBeat.i(137928);
        init(context);
        AppMethodBeat.o(137928);
    }

    @Override // com.tencent.mm.plugin.appbrand.utils.h.a
    public final void bZq() {
        AppMethodBeat.i(137929);
        release();
        AppMethodBeat.o(137929);
    }
}
