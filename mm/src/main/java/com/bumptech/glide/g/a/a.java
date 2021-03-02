package com.bumptech.glide.g.a;

import android.support.v4.e.l;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class a {
    private static final d<Object> aOa = new d<Object>() {
        /* class com.bumptech.glide.g.a.a.AnonymousClass1 */

        @Override // com.bumptech.glide.g.a.a.d
        public final void reset(Object obj) {
        }
    };

    /* renamed from: com.bumptech.glide.g.a.a$a  reason: collision with other inner class name */
    public interface AbstractC0066a<T> {
        T oR();
    }

    public interface c {
        b oK();
    }

    public interface d<T> {
        void reset(T t);
    }

    static {
        AppMethodBeat.i(77794);
        AppMethodBeat.o(77794);
    }

    public static <T extends c> l.a<T> a(int i2, AbstractC0066a<T> aVar) {
        AppMethodBeat.i(77790);
        l.a<T> a2 = a(new l.c(i2), aVar, aOa);
        AppMethodBeat.o(77790);
        return a2;
    }

    private static <T> l.a<T> a(l.a<T> aVar, AbstractC0066a<T> aVar2, d<T> dVar) {
        AppMethodBeat.i(77793);
        b bVar = new b(aVar, aVar2, dVar);
        AppMethodBeat.o(77793);
        return bVar;
    }

    /* access modifiers changed from: package-private */
    public static final class b<T> implements l.a<T> {
        private final l.a<T> aGj;
        private final AbstractC0066a<T> aOb;
        private final d<T> aOc;

        b(l.a<T> aVar, AbstractC0066a<T> aVar2, d<T> dVar) {
            this.aGj = aVar;
            this.aOb = aVar2;
            this.aOc = dVar;
        }

        @Override // android.support.v4.e.l.a
        public final T acquire() {
            AppMethodBeat.i(77787);
            T acquire = this.aGj.acquire();
            if (acquire == null) {
                acquire = this.aOb.oR();
                if (Log.isLoggable("FactoryPools", 2)) {
                    new StringBuilder("Created new ").append(acquire.getClass());
                }
            }
            if (acquire instanceof c) {
                acquire.oK().aH(false);
            }
            AppMethodBeat.o(77787);
            return acquire;
        }

        @Override // android.support.v4.e.l.a
        public final boolean release(T t) {
            AppMethodBeat.i(77788);
            if (t instanceof c) {
                t.oK().aH(true);
            }
            this.aOc.reset(t);
            boolean release = this.aGj.release(t);
            AppMethodBeat.o(77788);
            return release;
        }
    }

    public static <T> l.a<List<T>> qy() {
        AppMethodBeat.i(77791);
        l.a<List<T>> a2 = a(new l.c(20), new AbstractC0066a<List<T>>() {
            /* class com.bumptech.glide.g.a.a.AnonymousClass2 */

            @Override // com.bumptech.glide.g.a.a.AbstractC0066a
            public final /* synthetic */ Object oR() {
                AppMethodBeat.i(77785);
                ArrayList arrayList = new ArrayList();
                AppMethodBeat.o(77785);
                return arrayList;
            }
        }, new d<List<T>>() {
            /* class com.bumptech.glide.g.a.a.AnonymousClass3 */

            @Override // com.bumptech.glide.g.a.a.d
            public final /* synthetic */ void reset(Object obj) {
                AppMethodBeat.i(77786);
                ((List) obj).clear();
                AppMethodBeat.o(77786);
            }
        });
        AppMethodBeat.o(77791);
        return a2;
    }
}
