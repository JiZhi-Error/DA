package com.bumptech.glide.load.a;

import com.bumptech.glide.g.j;
import com.bumptech.glide.load.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class f {
    private static final e.a<?> aFd = new e.a<Object>() {
        /* class com.bumptech.glide.load.a.f.AnonymousClass1 */

        @Override // com.bumptech.glide.load.a.e.a
        public final e<Object> T(Object obj) {
            AppMethodBeat.i(76873);
            a aVar = new a(obj);
            AppMethodBeat.o(76873);
            return aVar;
        }

        @Override // com.bumptech.glide.load.a.e.a
        public final Class<Object> os() {
            AppMethodBeat.i(76874);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Not implemented");
            AppMethodBeat.o(76874);
            throw unsupportedOperationException;
        }
    };
    private final Map<Class<?>, e.a<?>> aFc = new HashMap();

    public f() {
        AppMethodBeat.i(76875);
        AppMethodBeat.o(76875);
    }

    static {
        AppMethodBeat.i(76878);
        AppMethodBeat.o(76878);
    }

    public final synchronized void b(e.a<?> aVar) {
        AppMethodBeat.i(76876);
        this.aFc.put(aVar.os(), aVar);
        AppMethodBeat.o(76876);
    }

    static final class a implements e<Object> {
        private final Object data;

        a(Object obj) {
            this.data = obj;
        }

        @Override // com.bumptech.glide.load.a.e
        public final Object ov() {
            return this.data;
        }

        @Override // com.bumptech.glide.load.a.e
        public final void cleanup() {
        }
    }

    public final synchronized <T> e<T> T(T t) {
        e<T> eVar;
        AppMethodBeat.i(76877);
        j.checkNotNull(t, "Argument must not be null");
        e.a<?> aVar = this.aFc.get(t.getClass());
        if (aVar == null) {
            Iterator<e.a<?>> it = this.aFc.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e.a<?> next = it.next();
                if (next.os().isAssignableFrom(t.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = aFd;
        }
        eVar = (e<T>) aVar.T(t);
        AppMethodBeat.o(76877);
        return eVar;
    }
}
