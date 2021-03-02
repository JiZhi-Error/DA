package com.bumptech.glide.load.c;

import com.bumptech.glide.g;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v<Model> implements n<Model, Model> {
    private static final v<?> aKz = new v<>();

    static {
        AppMethodBeat.i(77313);
        AppMethodBeat.o(77313);
    }

    public static <T> v<T> pv() {
        return (v<T>) aKz;
    }

    @Override // com.bumptech.glide.load.c.n
    public final n.a<Model> b(Model model, int i2, int i3, i iVar) {
        AppMethodBeat.i(77312);
        n.a<Model> aVar = new n.a<>(new com.bumptech.glide.f.b(model), new b(model));
        AppMethodBeat.o(77312);
        return aVar;
    }

    @Override // com.bumptech.glide.load.c.n
    public final boolean X(Model model) {
        return true;
    }

    static class b<Model> implements d<Model> {
        private final Model aKB;

        b(Model model) {
            this.aKB = model;
        }

        @Override // com.bumptech.glide.load.a.d
        public final void a(g gVar, d.a<? super Model> aVar) {
            AppMethodBeat.i(77310);
            aVar.S(this.aKB);
            AppMethodBeat.o(77310);
        }

        @Override // com.bumptech.glide.load.a.d
        public final void cleanup() {
        }

        @Override // com.bumptech.glide.load.a.d
        public final void cancel() {
        }

        @Override // com.bumptech.glide.load.a.d
        public final Class<Model> os() {
            AppMethodBeat.i(77311);
            Class<Model> cls = (Class<Model>) this.aKB.getClass();
            AppMethodBeat.o(77311);
            return cls;
        }

        @Override // com.bumptech.glide.load.a.d
        public final com.bumptech.glide.load.a ot() {
            return com.bumptech.glide.load.a.LOCAL;
        }
    }

    public static class a<Model> implements o<Model, Model> {
        private static final a<?> aKA = new a<>();

        static {
            AppMethodBeat.i(77309);
            AppMethodBeat.o(77309);
        }

        public static <T> a<T> pw() {
            return (a<T>) aKA;
        }

        @Override // com.bumptech.glide.load.c.o
        public final n<Model, Model> a(r rVar) {
            AppMethodBeat.i(77308);
            v pv = v.pv();
            AppMethodBeat.o(77308);
            return pv;
        }
    }
}
