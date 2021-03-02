package com.tencent.tmediacodec.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmediacodec.b.f;
import com.tencent.tmediacodec.g.b;
import com.tencent.tmediacodec.g.e;

public final class a {
    private final b Smr = new b(2, "keep");
    private final b Sms = new b(Integer.MAX_VALUE, "running");

    public final void f(final f fVar) {
        AppMethodBeat.i(190147);
        if (b.isLogEnable()) {
            "transToRunning codecWrapper:".concat(String.valueOf(fVar));
            b.bqQ("CodecWrapperManager");
        }
        this.Smr.l(fVar);
        this.Sms.j(fVar);
        e.bb(new Runnable() {
            /* class com.tencent.tmediacodec.c.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(190145);
                com.tencent.tmediacodec.a.a aVar = fVar.SlK;
                if (aVar != null) {
                    aVar.onTransToRunningPool();
                }
                AppMethodBeat.o(190145);
            }
        });
        AppMethodBeat.o(190147);
    }

    public final void g(f fVar) {
        AppMethodBeat.i(190148);
        if (b.isLogEnable()) {
            "removeFromRunning codecWrapper:".concat(String.valueOf(fVar));
            b.bqQ("CodecWrapperManager");
        }
        this.Sms.l(fVar);
        AppMethodBeat.o(190148);
    }

    public final void h(f fVar) {
        AppMethodBeat.i(190149);
        if (b.isLogEnable()) {
            "transTokeep codecWrapper:".concat(String.valueOf(fVar));
            b.bqQ("CodecWrapperManager");
        }
        this.Sms.l(fVar);
        this.Smr.j(fVar);
        com.tencent.tmediacodec.a.a aVar = fVar.SlK;
        if (aVar != null) {
            aVar.onTransToKeepPool();
        }
        AppMethodBeat.o(190149);
    }

    public final f c(com.tencent.tmediacodec.b.e eVar) {
        AppMethodBeat.i(190150);
        f d2 = this.Smr.d(eVar);
        if (b.isLogEnable()) {
            "obtainCodecWrapper codecWrapper:".concat(String.valueOf(d2));
            b.bqQ("CodecWrapperManager");
        }
        AppMethodBeat.o(190150);
        return d2;
    }

    public final void hpB() {
        AppMethodBeat.i(190151);
        if (b.isLogEnable()) {
            b.bqR("CodecWrapperManager");
        }
        this.Sms.clear();
        this.Smr.clear();
        AppMethodBeat.o(190151);
    }

    public final String hpC() {
        AppMethodBeat.i(190152);
        String str = "runningPool:" + this.Sms + " keepPool:" + this.Smr;
        AppMethodBeat.o(190152);
        return str;
    }

    public a() {
        AppMethodBeat.i(190153);
        this.Smr.Smv = new c() {
            /* class com.tencent.tmediacodec.c.a.AnonymousClass2 */

            @Override // com.tencent.tmediacodec.c.c
            public final void i(f fVar) {
                AppMethodBeat.i(190146);
                if (b.isLogEnable()) {
                    "onErase codecWrapper:".concat(String.valueOf(fVar));
                    b.bqQ("CodecWrapperManager");
                }
                fVar.recycle();
                AppMethodBeat.o(190146);
            }
        };
        AppMethodBeat.o(190153);
    }
}
