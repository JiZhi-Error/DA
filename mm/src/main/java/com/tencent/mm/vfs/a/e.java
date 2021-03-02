package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.a.a;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class e<T> implements Iterable<T> {
    private static final a<?> ReX = new a<>((byte) 0);
    private final List<Iterable<? extends T>> ReW;

    private e(List<Iterable<? extends T>> list) {
        this.ReW = list;
    }

    @SafeVarargs
    public e(Iterable<? extends T>... iterableArr) {
        this(Arrays.asList(iterableArr));
        AppMethodBeat.i(187776);
        AppMethodBeat.o(187776);
    }

    static final class a<T> implements a.AbstractC2153a<Iterable<? extends T>, T> {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.vfs.a.a.AbstractC2153a
        public final /* bridge */ /* synthetic */ Iterable eq(Object obj) {
            return (Iterable) obj;
        }
    }

    static {
        AppMethodBeat.i(187778);
        AppMethodBeat.o(187778);
    }

    @Override // java.lang.Iterable
    public final Iterator<T> iterator() {
        AppMethodBeat.i(187777);
        b bVar = new b(this.ReW.iterator(), ReX);
        AppMethodBeat.o(187777);
        return bVar;
    }
}
