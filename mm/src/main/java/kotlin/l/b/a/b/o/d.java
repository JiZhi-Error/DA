package kotlin.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.x;

public final class d {
    private static final kotlin.g.a.b<Object, x> TRA = c.TRF;
    private static final m<Object, Object, x> TRB = C2366d.TRG;
    private static final q<Object, Object, Object, x> TRC = e.TRH;
    private static final kotlin.g.a.b<Object, Object> TRx = f.TRI;
    private static final kotlin.g.a.b<Object, Boolean> TRy = b.TRE;
    private static final kotlin.g.a.b<Object, Object> TRz = a.TRD;

    static final class a extends kotlin.g.b.q implements kotlin.g.a.b {
        public static final a TRD = new a();

        static {
            AppMethodBeat.i(61357);
            AppMethodBeat.o(61357);
        }

        a() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return null;
        }
    }

    static final class b extends kotlin.g.b.q implements kotlin.g.a.b<Object, Boolean> {
        public static final b TRE = new b();

        static {
            AppMethodBeat.i(61358);
            AppMethodBeat.o(61358);
        }

        b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.b
        public final /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
            return Boolean.TRUE;
        }
    }

    static final class c extends kotlin.g.b.q implements kotlin.g.a.b<Object, x> {
        public static final c TRF = new c();

        static {
            AppMethodBeat.i(61359);
            AppMethodBeat.o(61359);
        }

        c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.b
        public final /* bridge */ /* synthetic */ x invoke(Object obj) {
            return x.SXb;
        }
    }

    /* renamed from: kotlin.l.b.a.b.o.d$d  reason: collision with other inner class name */
    static final class C2366d extends kotlin.g.b.q implements m<Object, Object, x> {
        public static final C2366d TRG = new C2366d();

        static {
            AppMethodBeat.i(61360);
            AppMethodBeat.o(61360);
        }

        C2366d() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.m
        public final /* bridge */ /* synthetic */ x invoke(Object obj, Object obj2) {
            return x.SXb;
        }
    }

    static final class e extends kotlin.g.b.q implements q<Object, Object, Object, x> {
        public static final e TRH = new e();

        static {
            AppMethodBeat.i(61361);
            AppMethodBeat.o(61361);
        }

        e() {
            super(3);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.q
        public final /* bridge */ /* synthetic */ x d(Object obj, Object obj2, Object obj3) {
            return x.SXb;
        }
    }

    static final class f extends kotlin.g.b.q implements kotlin.g.a.b<Object, Object> {
        public static final f TRI = new f();

        static {
            AppMethodBeat.i(61362);
            AppMethodBeat.o(61362);
        }

        f() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final Object invoke(Object obj) {
            return obj;
        }
    }

    public static final <T> kotlin.g.a.b<T, Boolean> hLR() {
        return (kotlin.g.a.b<T, Boolean>) TRy;
    }

    public static final q<Object, Object, Object, x> hLS() {
        return TRC;
    }
}
