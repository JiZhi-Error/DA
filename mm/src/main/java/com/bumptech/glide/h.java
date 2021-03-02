package com.bumptech.glide;

import android.support.v4.e.l;
import com.bumptech.glide.d.f;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.a.e;
import com.bumptech.glide.load.b.i;
import com.bumptech.glide.load.b.t;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.c.o;
import com.bumptech.glide.load.c.p;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class h {
    private final p aCR = new p(this.aDa);
    public final com.bumptech.glide.d.a aCS = new com.bumptech.glide.d.a();
    private final com.bumptech.glide.d.e aCT = new com.bumptech.glide.d.e();
    public final f aCU = new f();
    public final com.bumptech.glide.load.a.f aCV = new com.bumptech.glide.load.a.f();
    private final com.bumptech.glide.load.d.f.f aCW = new com.bumptech.glide.load.d.f.f();
    private final com.bumptech.glide.d.b aCX = new com.bumptech.glide.d.b();
    private final com.bumptech.glide.d.d aCY = new com.bumptech.glide.d.d();
    private final com.bumptech.glide.d.c aCZ = new com.bumptech.glide.d.c();
    private final l.a<List<Throwable>> aDa = com.bumptech.glide.g.a.a.qy();

    public h() {
        AppMethodBeat.i(76794);
        List asList = Arrays.asList("Gif", "Bitmap", "BitmapDrawable");
        ArrayList arrayList = new ArrayList(asList.size());
        arrayList.addAll(asList);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.aCT.r(arrayList);
        AppMethodBeat.o(76794);
    }

    public final <Data> h a(Class<Data> cls, com.bumptech.glide.load.d<Data> dVar) {
        AppMethodBeat.i(76795);
        this.aCS.b(cls, dVar);
        AppMethodBeat.o(76795);
        return this;
    }

    public final <Data, TResource> h a(Class<Data> cls, Class<TResource> cls2, j<Data, TResource> jVar) {
        AppMethodBeat.i(76796);
        a("legacy_append", cls, cls2, jVar);
        AppMethodBeat.o(76796);
        return this;
    }

    public final <Data, TResource> h a(String str, Class<Data> cls, Class<TResource> cls2, j<Data, TResource> jVar) {
        AppMethodBeat.i(76797);
        this.aCT.a(str, jVar, cls, cls2);
        AppMethodBeat.o(76797);
        return this;
    }

    public final <TResource> h a(Class<TResource> cls, k<TResource> kVar) {
        AppMethodBeat.i(76798);
        this.aCU.b(cls, kVar);
        AppMethodBeat.o(76798);
        return this;
    }

    public final h a(e.a<?> aVar) {
        AppMethodBeat.i(76799);
        this.aCV.b(aVar);
        AppMethodBeat.o(76799);
        return this;
    }

    public final <TResource, Transcode> h a(Class<TResource> cls, Class<Transcode> cls2, com.bumptech.glide.load.d.f.e<TResource, Transcode> eVar) {
        AppMethodBeat.i(76800);
        this.aCW.b(cls, cls2, eVar);
        AppMethodBeat.o(76800);
        return this;
    }

    public final h a(ImageHeaderParser imageHeaderParser) {
        AppMethodBeat.i(204442);
        this.aCX.b(imageHeaderParser);
        AppMethodBeat.o(204442);
        return this;
    }

    public final <Model, Data> h a(Class<Model> cls, Class<Data> cls2, o<Model, Data> oVar) {
        AppMethodBeat.i(76801);
        this.aCR.b(cls, cls2, oVar);
        AppMethodBeat.o(76801);
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: android.support.v4.e.a<com.bumptech.glide.g.i, com.bumptech.glide.load.b.t<?, ?, ?>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <Data, TResource, Transcode> t<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        AppMethodBeat.i(76802);
        t<Data, TResource, Transcode> c2 = this.aCZ.c(cls, cls2, cls3);
        if (com.bumptech.glide.d.c.a(c2)) {
            AppMethodBeat.o(76802);
            return null;
        }
        if (c2 == null) {
            ArrayList arrayList = new ArrayList();
            for (Class cls4 : this.aCT.g(cls, cls2)) {
                for (Class cls5 : this.aCW.d(cls4, cls3)) {
                    arrayList.add(new i(cls, cls4, cls5, this.aCT.f(cls, cls4), this.aCW.c(cls4, cls5), this.aDa));
                }
            }
            c2 = arrayList.isEmpty() ? null : new t<>(cls, cls2, cls3, arrayList, this.aDa);
            com.bumptech.glide.d.c cVar = this.aCZ;
            synchronized (cVar.aMO) {
                try {
                    cVar.aMO.put(new com.bumptech.glide.g.i(cls, cls2, cls3), c2 != null ? c2 : com.bumptech.glide.d.c.aMN);
                } finally {
                    AppMethodBeat.o(76802);
                }
            }
        }
        return c2;
    }

    public final <Model, TResource, Transcode> List<Class<?>> b(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        AppMethodBeat.i(76803);
        List<Class<?>> d2 = this.aCY.d(cls, cls2, cls3);
        if (d2 == null) {
            ArrayList arrayList = new ArrayList();
            for (Class<?> cls4 : this.aCR.r(cls)) {
                for (Class<?> cls5 : this.aCT.g(cls4, cls2)) {
                    if (!this.aCW.d(cls5, cls3).isEmpty() && !arrayList.contains(cls5)) {
                        arrayList.add(cls5);
                    }
                }
            }
            com.bumptech.glide.d.d dVar = this.aCY;
            List<Class<?>> unmodifiableList = Collections.unmodifiableList(arrayList);
            synchronized (dVar.aMR) {
                try {
                    dVar.aMR.put(new com.bumptech.glide.g.i(cls, cls2, cls3), unmodifiableList);
                } finally {
                    AppMethodBeat.o(76803);
                }
            }
            d2 = arrayList;
        }
        return d2;
    }

    public final <Model> List<n<Model, ?>> P(Model model) {
        AppMethodBeat.i(76804);
        List s = this.aCR.s(model.getClass());
        int size = s.size();
        boolean z = true;
        List<n<Model, ?>> emptyList = Collections.emptyList();
        for (int i2 = 0; i2 < size; i2++) {
            n<Model, ?> nVar = (n) s.get(i2);
            if (nVar.X(model)) {
                if (z) {
                    emptyList = new ArrayList<>(size - i2);
                    z = false;
                }
                emptyList.add(nVar);
            }
        }
        if (emptyList.isEmpty()) {
            c cVar = new c(model);
            AppMethodBeat.o(76804);
            throw cVar;
        }
        AppMethodBeat.o(76804);
        return emptyList;
    }

    public final List<ImageHeaderParser> nO() {
        AppMethodBeat.i(76805);
        List<ImageHeaderParser> pV = this.aCX.pV();
        if (pV.isEmpty()) {
            b bVar = new b();
            AppMethodBeat.o(76805);
            throw bVar;
        }
        AppMethodBeat.o(76805);
        return pV;
    }

    public static class c extends a {
        public c(Object obj) {
            super("Failed to find any ModelLoaders for model: ".concat(String.valueOf(obj)));
            AppMethodBeat.i(76790);
            AppMethodBeat.o(76790);
        }

        public c(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
            AppMethodBeat.i(76791);
            AppMethodBeat.o(76791);
        }
    }

    public static class d extends a {
        public d(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
            AppMethodBeat.i(76792);
            AppMethodBeat.o(76792);
        }
    }

    public static class e extends a {
        public e(Class<?> cls) {
            super("Failed to find source encoder for data class: ".concat(String.valueOf(cls)));
            AppMethodBeat.i(76793);
            AppMethodBeat.o(76793);
        }
    }

    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    public static final class b extends a {
        public b() {
            super("Failed to find image header parser.");
        }
    }
}
