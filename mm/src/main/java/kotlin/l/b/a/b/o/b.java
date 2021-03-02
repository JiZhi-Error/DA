package kotlin.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b {

    /* renamed from: kotlin.l.b.a.b.o.b$b  reason: collision with other inner class name */
    public interface AbstractC2365b<N> {
        Iterable<? extends N> fl(N n);
    }

    public interface c<N, R> {
        void fA(N n);

        boolean fm(N n);

        R hAq();
    }

    public interface d<N> {
        boolean fG(N n);
    }

    private static /* synthetic */ void atM(int i2) {
        AppMethodBeat.i(61355);
        Object[] objArr = new Object[3];
        switch (i2) {
            case 1:
            case 5:
            case 8:
            case 11:
            case 15:
            case 18:
            case 21:
            case 23:
                objArr[0] = "neighbors";
                break;
            case 2:
            case 12:
            case 16:
            case 19:
            case 24:
                objArr[0] = "visited";
                break;
            case 3:
            case 6:
            case 13:
            case 25:
                objArr[0] = "handler";
                break;
            case 4:
            case 7:
            case 17:
            case 20:
            default:
                objArr[0] = "nodes";
                break;
            case 9:
                objArr[0] = "predicate";
                break;
            case 10:
            case 14:
                objArr[0] = "node";
                break;
            case 22:
                objArr[0] = "current";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS";
        switch (i2) {
            case 7:
            case 8:
            case 9:
                objArr[2] = "ifAny";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[2] = "dfsFromNode";
                break;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                objArr[2] = "topologicalOrder";
                break;
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "doDfs";
                break;
            default:
                objArr[2] = "dfs";
                break;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        AppMethodBeat.o(61355);
        throw illegalArgumentException;
    }

    private static <N, R> R a(Collection<N> collection, AbstractC2365b<N> bVar, d<N> dVar, c<N, R> cVar) {
        AppMethodBeat.i(61351);
        if (collection == null) {
            atM(0);
        }
        if (bVar == null) {
            atM(1);
        }
        if (cVar == null) {
            atM(3);
        }
        for (N n : collection) {
            a((Object) n, (AbstractC2365b) bVar, (d) dVar, (c) cVar);
        }
        R hAq = cVar.hAq();
        AppMethodBeat.o(61351);
        return hAq;
    }

    public static <N, R> R a(Collection<N> collection, AbstractC2365b<N> bVar, c<N, R> cVar) {
        AppMethodBeat.i(61352);
        if (collection == null) {
            atM(4);
        }
        if (bVar == null) {
            atM(5);
        }
        R r = (R) a((Collection) collection, (AbstractC2365b) bVar, (d) new e(), (c) cVar);
        AppMethodBeat.o(61352);
        return r;
    }

    public static <N> Boolean a(Collection<N> collection, AbstractC2365b<N> bVar, final kotlin.g.a.b<N, Boolean> bVar2) {
        AppMethodBeat.i(61353);
        if (collection == null) {
            atM(7);
        }
        if (bVar == null) {
            atM(8);
        }
        if (bVar2 == null) {
            atM(9);
        }
        final boolean[] zArr = new boolean[1];
        Boolean bool = (Boolean) a(collection, bVar, new a<N, Boolean>() {
            /* class kotlin.l.b.a.b.o.b.AnonymousClass1 */

            @Override // kotlin.l.b.a.b.o.b.a, kotlin.l.b.a.b.o.b.c
            public final boolean fm(N n) {
                AppMethodBeat.i(61347);
                if (((Boolean) bVar2.invoke(n)).booleanValue()) {
                    zArr[0] = true;
                }
                if (!zArr[0]) {
                    AppMethodBeat.o(61347);
                    return true;
                }
                AppMethodBeat.o(61347);
                return false;
            }

            @Override // kotlin.l.b.a.b.o.b.c
            public final /* synthetic */ Object hAq() {
                AppMethodBeat.i(61348);
                Boolean valueOf = Boolean.valueOf(zArr[0]);
                AppMethodBeat.o(61348);
                return valueOf;
            }
        });
        AppMethodBeat.o(61353);
        return bool;
    }

    private static <N> void a(N n, AbstractC2365b<N> bVar, d<N> dVar, c<N, ?> cVar) {
        AppMethodBeat.i(61354);
        if (n == null) {
            atM(22);
        }
        if (bVar == null) {
            atM(23);
        }
        if (dVar == null) {
            atM(24);
        }
        if (cVar == null) {
            atM(25);
        }
        if (!dVar.fG(n)) {
            AppMethodBeat.o(61354);
        } else if (!cVar.fm(n)) {
            AppMethodBeat.o(61354);
        } else {
            Iterator<? extends N> it = bVar.fl(n).iterator();
            while (it.hasNext()) {
                a(it.next(), bVar, dVar, cVar);
            }
            cVar.fA(n);
            AppMethodBeat.o(61354);
        }
    }

    public static abstract class a<N, R> implements c<N, R> {
        @Override // kotlin.l.b.a.b.o.b.c
        public boolean fm(N n) {
            return true;
        }

        @Override // kotlin.l.b.a.b.o.b.c
        public void fA(N n) {
        }
    }

    public static class e<N> implements d<N> {
        private final Set<N> TRw;

        public e() {
            this(new HashSet());
            AppMethodBeat.i(61349);
            AppMethodBeat.o(61349);
        }

        private e(Set<N> set) {
            this.TRw = set;
        }

        @Override // kotlin.l.b.a.b.o.b.d
        public final boolean fG(N n) {
            AppMethodBeat.i(61350);
            boolean add = this.TRw.add(n);
            AppMethodBeat.o(61350);
            return add;
        }
    }
}
