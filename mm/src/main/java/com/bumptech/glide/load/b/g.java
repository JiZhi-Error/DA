package com.bumptech.glide.load.b;

import com.bumptech.glide.e;
import com.bumptech.glide.load.b.b.a;
import com.bumptech.glide.load.b.h;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.d.b;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class g<Transcode> {
    e aCm;
    Class<Transcode> aDd;
    Object aDf;
    private final List<com.bumptech.glide.load.g> aFK = new ArrayList();
    com.bumptech.glide.load.g aFT;
    i aFV;
    private final List<n.a<?>> aFW = new ArrayList();
    Class<?> aFX;
    h.d aFY;
    Map<Class<?>, l<?>> aFZ;
    private boolean aGa;
    private boolean aGb;
    com.bumptech.glide.g aGc;
    j aGd;
    boolean aGe;
    boolean aGf;
    int height;
    int width;

    g() {
        AppMethodBeat.i(76932);
        AppMethodBeat.o(76932);
    }

    /* access modifiers changed from: package-private */
    public final void clear() {
        AppMethodBeat.i(76933);
        this.aCm = null;
        this.aDf = null;
        this.aFT = null;
        this.aFX = null;
        this.aDd = null;
        this.aFV = null;
        this.aGc = null;
        this.aFZ = null;
        this.aGd = null;
        this.aFW.clear();
        this.aGa = false;
        this.aFK.clear();
        this.aGb = false;
        AppMethodBeat.o(76933);
    }

    /* access modifiers changed from: package-private */
    public final a oz() {
        AppMethodBeat.i(76934);
        a oz = this.aFY.oz();
        AppMethodBeat.o(76934);
        return oz;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Class<?> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    public final boolean l(Class<?> cls) {
        AppMethodBeat.i(76935);
        if (m(cls) != null) {
            AppMethodBeat.o(76935);
            return true;
        }
        AppMethodBeat.o(76935);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final <Data> t<Data, ?, Transcode> m(Class<Data> cls) {
        AppMethodBeat.i(76936);
        t<Data, ?, Transcode> a2 = this.aCm.aCn.a(cls, this.aFX, this.aDd);
        AppMethodBeat.o(76936);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final <Z> l<Z> n(Class<Z> cls) {
        AppMethodBeat.i(76937);
        l<Z> lVar = (l<Z>) this.aFZ.get(cls);
        if (lVar == null) {
            Iterator<Map.Entry<Class<?>, l<?>>> it = this.aFZ.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, l<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    lVar = (l<Z>) next.getValue();
                    break;
                }
            }
        }
        if (lVar != null) {
            AppMethodBeat.o(76937);
            return lVar;
        } else if (!this.aFZ.isEmpty() || !this.aGe) {
            b px = b.px();
            AppMethodBeat.o(76937);
            return px;
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
            AppMethodBeat.o(76937);
            throw illegalArgumentException;
        }
    }

    /* access modifiers changed from: package-private */
    public final List<n<File, ?>> t(File file) {
        AppMethodBeat.i(76938);
        List<n<File, ?>> P = this.aCm.aCn.P(file);
        AppMethodBeat.o(76938);
        return P;
    }

    /* access modifiers changed from: package-private */
    public final List<n.a<?>> oA() {
        AppMethodBeat.i(76939);
        if (!this.aGa) {
            this.aGa = true;
            this.aFW.clear();
            List P = this.aCm.aCn.P(this.aDf);
            int size = P.size();
            for (int i2 = 0; i2 < size; i2++) {
                n.a<?> b2 = ((n) P.get(i2)).b(this.aDf, this.width, this.height, this.aFV);
                if (b2 != null) {
                    this.aFW.add(b2);
                }
            }
        }
        List<n.a<?>> list = this.aFW;
        AppMethodBeat.o(76939);
        return list;
    }

    /* access modifiers changed from: package-private */
    public final List<com.bumptech.glide.load.g> oB() {
        AppMethodBeat.i(76940);
        if (!this.aGb) {
            this.aGb = true;
            this.aFK.clear();
            List<n.a<?>> oA = oA();
            int size = oA.size();
            for (int i2 = 0; i2 < size; i2++) {
                n.a<?> aVar = oA.get(i2);
                if (!this.aFK.contains(aVar.aFO)) {
                    this.aFK.add(aVar.aFO);
                }
                for (int i3 = 0; i3 < aVar.aKg.size(); i3++) {
                    if (!this.aFK.contains(aVar.aKg.get(i3))) {
                        this.aFK.add(aVar.aKg.get(i3));
                    }
                }
            }
        }
        List<com.bumptech.glide.load.g> list = this.aFK;
        AppMethodBeat.o(76940);
        return list;
    }
}
