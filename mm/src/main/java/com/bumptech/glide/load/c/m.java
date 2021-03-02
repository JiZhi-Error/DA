package com.bumptech.glide.load.c;

import com.bumptech.glide.g.g;
import com.bumptech.glide.g.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Queue;

public final class m<A, B> {
    public final g<a<A>, B> aKd;

    public m() {
        this(250);
    }

    public m(long j2) {
        AppMethodBeat.i(77265);
        this.aKd = new g<a<A>, B>(j2) {
            /* class com.bumptech.glide.load.c.m.AnonymousClass1 */

            @Override // com.bumptech.glide.g.g
            public final /* synthetic */ void g(Object obj, Object obj2) {
                AppMethodBeat.i(77259);
                ((a) obj).release();
                AppMethodBeat.o(77259);
            }
        };
        AppMethodBeat.o(77265);
    }

    public final B Y(A a2) {
        AppMethodBeat.i(77266);
        a<A> Z = a.Z(a2);
        B b2 = this.aKd.get(Z);
        Z.release();
        AppMethodBeat.o(77266);
        return b2;
    }

    public static final class a<A> {
        private static final Queue<a<?>> aKf = k.ds(0);
        private A aDf;
        private int height;
        private int width;

        static {
            AppMethodBeat.i(77264);
            AppMethodBeat.o(77264);
        }

        public static <A> a<A> Z(A a2) {
            a<A> aVar;
            AppMethodBeat.i(77260);
            synchronized (aKf) {
                try {
                    aVar = (a<A>) aKf.poll();
                } catch (Throwable th) {
                    AppMethodBeat.o(77260);
                    throw th;
                }
            }
            if (aVar == null) {
                aVar = new a<>();
            }
            ((a) aVar).aDf = a2;
            ((a) aVar).width = 0;
            ((a) aVar).height = 0;
            AppMethodBeat.o(77260);
            return aVar;
        }

        private a() {
        }

        public final void release() {
            AppMethodBeat.i(77261);
            synchronized (aKf) {
                try {
                    aKf.offer(this);
                } finally {
                    AppMethodBeat.o(77261);
                }
            }
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(77262);
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.width == aVar.width && this.height == aVar.height && this.aDf.equals(aVar.aDf)) {
                    AppMethodBeat.o(77262);
                    return true;
                }
                AppMethodBeat.o(77262);
                return false;
            }
            AppMethodBeat.o(77262);
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.i(77263);
            int hashCode = (((this.height * 31) + this.width) * 31) + this.aDf.hashCode();
            AppMethodBeat.o(77263);
            return hashCode;
        }
    }
}
