package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import rx.d;
import rx.internal.a.h;
import rx.internal.util.j;

public enum c {
    ;
    
    public static final e UmY = new e();
    public static final C2394c UmZ = new C2394c();
    public static final g Una = new g();
    static final f Unb = new f();
    public static final d Unc = new d();
    static final b Und = new b();
    public static final rx.b.b<Throwable> Une = new a();
    public static final d.b<Boolean, Object> Unf = new h(j.a.INSTANCE);

    static {
        AppMethodBeat.i(90218);
        AppMethodBeat.o(90218);
    }

    public static c valueOf(String str) {
        AppMethodBeat.i(90217);
        c cVar = (c) Enum.valueOf(c.class, str);
        AppMethodBeat.o(90217);
        return cVar;
    }

    public static final class d implements rx.b.f<Integer, Object, Integer> {
        d() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // rx.b.f
        public final /* synthetic */ Integer ab(Integer num, Object obj) {
            AppMethodBeat.i(90211);
            Integer valueOf = Integer.valueOf(num.intValue() + 1);
            AppMethodBeat.o(90211);
            return valueOf;
        }
    }

    public static final class e implements rx.b.f<Long, Object, Long> {
        e() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // rx.b.f
        public final /* synthetic */ Long ab(Long l, Object obj) {
            AppMethodBeat.i(90212);
            Long valueOf = Long.valueOf(l.longValue() + 1);
            AppMethodBeat.o(90212);
            return valueOf;
        }
    }

    /* renamed from: rx.internal.util.c$c  reason: collision with other inner class name */
    public static final class C2394c implements rx.b.f<Object, Object, Boolean> {
        C2394c() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // rx.b.f
        public final /* synthetic */ Boolean ab(Object obj, Object obj2) {
            boolean z;
            AppMethodBeat.i(90213);
            if (obj == obj2 || (obj != null && obj.equals(obj2))) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(90213);
            return valueOf;
        }
    }

    public static final class g implements rx.b.e<List<? extends rx.d<?>>, rx.d<?>[]> {
        g() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // rx.b.e
        public final /* synthetic */ rx.d<?>[] call(List<? extends rx.d<?>> list) {
            AppMethodBeat.i(90214);
            List<? extends rx.d<?>> list2 = list;
            rx.d[] dVarArr = (rx.d[]) list2.toArray(new rx.d[list2.size()]);
            AppMethodBeat.o(90214);
            return dVarArr;
        }
    }

    static final class f implements rx.b.e<Object, Void> {
        f() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // rx.b.e
        public final /* bridge */ /* synthetic */ Void call(Object obj) {
            return null;
        }
    }

    static final class b implements rx.b.e<rx.c<?>, Throwable> {
        b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // rx.b.e
        public final /* bridge */ /* synthetic */ Throwable call(rx.c<?> cVar) {
            return cVar.throwable;
        }
    }

    static final class a implements rx.b.b<Throwable> {
        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // rx.b.b
        public final /* synthetic */ void cA(Throwable th) {
            AppMethodBeat.i(90215);
            rx.a.f fVar = new rx.a.f(th);
            AppMethodBeat.o(90215);
            throw fVar;
        }
    }
}
