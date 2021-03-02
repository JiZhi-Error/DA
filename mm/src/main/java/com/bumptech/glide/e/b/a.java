package com.bumptech.glide.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a<R> implements b<R> {
    static final a<?> aNH = new a<>();
    private static final c<?> aNI = new C0064a();

    static {
        AppMethodBeat.i(77704);
        AppMethodBeat.o(77704);
    }

    /* renamed from: com.bumptech.glide.e.b.a$a  reason: collision with other inner class name */
    public static class C0064a<R> implements c<R> {
        @Override // com.bumptech.glide.e.b.c
        public final b<R> qp() {
            return a.aNH;
        }
    }

    public static <R> c<R> qo() {
        return (c<R>) aNI;
    }
}
