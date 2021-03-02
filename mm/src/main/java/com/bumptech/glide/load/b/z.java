package com.bumptech.glide.load.b;

import android.util.Log;
import com.bumptech.glide.h;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.b.f;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

/* access modifiers changed from: package-private */
public final class z implements d.a<Object>, f, f.a {
    private final g<?> aFL;
    private final f.a aFM;
    private volatile n.a<?> aFR;
    private int aIf;
    private c aIg;
    private Object aIh;
    private d aIi;

    z(g<?> gVar, f.a aVar) {
        this.aFL = gVar;
        this.aFM = aVar;
    }

    @Override // com.bumptech.glide.load.b.f
    public final boolean ow() {
        boolean z;
        AppMethodBeat.i(77059);
        if (this.aIh != null) {
            Object obj = this.aIh;
            this.aIh = null;
            long qt = com.bumptech.glide.g.f.qt();
            try {
                com.bumptech.glide.load.d v = this.aFL.aCm.aCn.aCS.v(obj.getClass());
                if (v != null) {
                    e eVar = new e(v, obj, this.aFL.aFV);
                    this.aIi = new d(this.aFR.aFO, this.aFL.aFT);
                    this.aFL.oz().a(this.aIi, eVar);
                    if (Log.isLoggable("SourceGenerator", 2)) {
                        new StringBuilder("Finished encoding source to cache, key: ").append(this.aIi).append(", data: ").append(obj).append(", encoder: ").append(v).append(", duration: ").append(com.bumptech.glide.g.f.p(qt));
                    }
                    this.aFR.aKh.cleanup();
                    this.aIg = new c(Collections.singletonList(this.aFR.aFO), this.aFL, this);
                } else {
                    h.e eVar2 = new h.e(obj.getClass());
                    AppMethodBeat.o(77059);
                    throw eVar2;
                }
            } catch (Throwable th) {
                this.aFR.aKh.cleanup();
                AppMethodBeat.o(77059);
                throw th;
            }
        }
        if (this.aIg == null || !this.aIg.ow()) {
            this.aIg = null;
            this.aFR = null;
            boolean z2 = false;
            while (!z2) {
                if (this.aIf < this.aFL.oA().size()) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    break;
                }
                List<n.a<?>> oA = this.aFL.oA();
                int i2 = this.aIf;
                this.aIf = i2 + 1;
                this.aFR = oA.get(i2);
                if (this.aFR != null && (this.aFL.aGd.a(this.aFR.aKh.ot()) || this.aFL.l(this.aFR.aKh.os()))) {
                    this.aFR.aKh.a(this.aFL.aGc, this);
                    z2 = true;
                }
            }
            AppMethodBeat.o(77059);
            return z2;
        }
        AppMethodBeat.o(77059);
        return true;
    }

    @Override // com.bumptech.glide.load.b.f
    public final void cancel() {
        AppMethodBeat.i(77060);
        n.a<?> aVar = this.aFR;
        if (aVar != null) {
            aVar.aKh.cancel();
        }
        AppMethodBeat.o(77060);
    }

    @Override // com.bumptech.glide.load.a.d.a
    public final void S(Object obj) {
        AppMethodBeat.i(77061);
        j jVar = this.aFL.aGd;
        if (obj == null || !jVar.a(this.aFR.aKh.ot())) {
            this.aFM.a(this.aFR.aFO, obj, this.aFR.aKh, this.aFR.aKh.ot(), this.aIi);
            AppMethodBeat.o(77061);
            return;
        }
        this.aIh = obj;
        this.aFM.oy();
        AppMethodBeat.o(77061);
    }

    @Override // com.bumptech.glide.load.a.d.a
    public final void e(Exception exc) {
        AppMethodBeat.i(77062);
        this.aFM.a(this.aIi, exc, this.aFR.aKh, this.aFR.aKh.ot());
        AppMethodBeat.o(77062);
    }

    @Override // com.bumptech.glide.load.b.f.a
    public final void oy() {
        AppMethodBeat.i(77063);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(77063);
        throw unsupportedOperationException;
    }

    @Override // com.bumptech.glide.load.b.f.a
    public final void a(g gVar, Object obj, d<?> dVar, a aVar, g gVar2) {
        AppMethodBeat.i(77064);
        this.aFM.a(gVar, obj, dVar, this.aFR.aKh.ot(), gVar);
        AppMethodBeat.o(77064);
    }

    @Override // com.bumptech.glide.load.b.f.a
    public final void a(g gVar, Exception exc, d<?> dVar, a aVar) {
        AppMethodBeat.i(77065);
        this.aFM.a(gVar, exc, dVar, this.aFR.aKh.ot());
        AppMethodBeat.o(77065);
    }
}
