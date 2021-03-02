package kotlin.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.g.b.k;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.f;
import kotlin.k.j;
import kotlin.m.h;
import kotlin.n.n;
import kotlin.o;
import kotlin.s;

public class t extends s {

    public static final class a implements h<T> {
        final /* synthetic */ Iterable SXo;

        public a(Iterable iterable) {
            this.SXo = iterable;
        }

        @Override // kotlin.m.h
        public final Iterator<T> iterator() {
            AppMethodBeat.i(129234);
            Iterator<T> it = this.SXo.iterator();
            AppMethodBeat.o(129234);
            return it;
        }
    }

    public static final <T> boolean a(Iterable<? extends T> iterable, T t) {
        AppMethodBeat.i(129173);
        p.h(iterable, "$this$contains");
        if (iterable instanceof Collection) {
            boolean contains = ((Collection) iterable).contains(t);
            AppMethodBeat.o(129173);
            return contains;
        } else if (j.b((Iterable) iterable, (Object) t) >= 0) {
            AppMethodBeat.o(129173);
            return true;
        } else {
            AppMethodBeat.o(129173);
            return false;
        }
    }

    public static final <T> T e(Iterable<? extends T> iterable) {
        AppMethodBeat.i(129174);
        p.h(iterable, "$this$first");
        if (iterable instanceof List) {
            T t = (T) j.ks((List) iterable);
            AppMethodBeat.o(129174);
            return t;
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            NoSuchElementException noSuchElementException = new NoSuchElementException("Collection is empty.");
            AppMethodBeat.o(129174);
            throw noSuchElementException;
        }
        T t2 = (T) it.next();
        AppMethodBeat.o(129174);
        return t2;
    }

    public static final <T> T ks(List<? extends T> list) {
        AppMethodBeat.i(129175);
        p.h(list, "$this$first");
        if (list.isEmpty()) {
            NoSuchElementException noSuchElementException = new NoSuchElementException("List is empty.");
            AppMethodBeat.o(129175);
            throw noSuchElementException;
        }
        T t = (T) list.get(0);
        AppMethodBeat.o(129175);
        return t;
    }

    public static final <T> T f(Iterable<? extends T> iterable) {
        AppMethodBeat.i(129176);
        p.h(iterable, "$this$firstOrNull");
        if (!(iterable instanceof List)) {
            Iterator<? extends T> it = iterable.iterator();
            if (!it.hasNext()) {
                AppMethodBeat.o(129176);
                return null;
            }
            T t = (T) it.next();
            AppMethodBeat.o(129176);
            return t;
        } else if (((List) iterable).isEmpty()) {
            AppMethodBeat.o(129176);
            return null;
        } else {
            T t2 = (T) ((List) iterable).get(0);
            AppMethodBeat.o(129176);
            return t2;
        }
    }

    public static final <T> T kt(List<? extends T> list) {
        AppMethodBeat.i(129177);
        p.h(list, "$this$firstOrNull");
        if (list.isEmpty()) {
            AppMethodBeat.o(129177);
            return null;
        }
        T t = (T) list.get(0);
        AppMethodBeat.o(129177);
        return t;
    }

    public static final <T> T L(List<? extends T> list, int i2) {
        AppMethodBeat.i(129178);
        p.h(list, "$this$getOrNull");
        if (i2 < 0 || i2 > j.kq(list)) {
            AppMethodBeat.o(129178);
            return null;
        }
        T t = (T) list.get(i2);
        AppMethodBeat.o(129178);
        return t;
    }

    public static final <T> int b(Iterable<? extends T> iterable, T t) {
        AppMethodBeat.i(129179);
        p.h(iterable, "$this$indexOf");
        if (iterable instanceof List) {
            int indexOf = ((List) iterable).indexOf(t);
            AppMethodBeat.o(129179);
            return indexOf;
        }
        int i2 = 0;
        for (Object obj : iterable) {
            if (i2 < 0) {
                j.hxH();
            }
            if (p.j(t, obj)) {
                AppMethodBeat.o(129179);
                return i2;
            }
            i2++;
        }
        AppMethodBeat.o(129179);
        return -1;
    }

    public static final <T> int a(List<? extends T> list, T t) {
        AppMethodBeat.i(206265);
        p.h(list, "$this$indexOf");
        int indexOf = list.indexOf(t);
        AppMethodBeat.o(206265);
        return indexOf;
    }

    public static final <T> T g(Iterable<? extends T> iterable) {
        T t;
        AppMethodBeat.i(129180);
        p.h(iterable, "$this$last");
        if (iterable instanceof List) {
            T t2 = (T) j.ku((List) iterable);
            AppMethodBeat.o(129180);
            return t2;
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            NoSuchElementException noSuchElementException = new NoSuchElementException("Collection is empty.");
            AppMethodBeat.o(129180);
            throw noSuchElementException;
        }
        do {
            t = (T) it.next();
        } while (it.hasNext());
        AppMethodBeat.o(129180);
        return t;
    }

    public static final <T> T ku(List<? extends T> list) {
        AppMethodBeat.i(129181);
        p.h(list, "$this$last");
        if (list.isEmpty()) {
            NoSuchElementException noSuchElementException = new NoSuchElementException("List is empty.");
            AppMethodBeat.o(129181);
            throw noSuchElementException;
        }
        T t = (T) list.get(j.kq(list));
        AppMethodBeat.o(129181);
        return t;
    }

    public static final <T> T h(Iterable<? extends T> iterable) {
        T t;
        AppMethodBeat.i(206266);
        p.h(iterable, "$this$lastOrNull");
        if (!(iterable instanceof List)) {
            Iterator<? extends T> it = iterable.iterator();
            if (!it.hasNext()) {
                AppMethodBeat.o(206266);
                return null;
            }
            do {
                t = (T) it.next();
            } while (it.hasNext());
            AppMethodBeat.o(206266);
            return t;
        } else if (((List) iterable).isEmpty()) {
            AppMethodBeat.o(206266);
            return null;
        } else {
            T t2 = (T) ((List) iterable).get(((List) iterable).size() - 1);
            AppMethodBeat.o(206266);
            return t2;
        }
    }

    public static final <T> T kv(List<? extends T> list) {
        AppMethodBeat.i(129182);
        p.h(list, "$this$lastOrNull");
        if (list.isEmpty()) {
            AppMethodBeat.o(129182);
            return null;
        }
        T t = (T) list.get(list.size() - 1);
        AppMethodBeat.o(129182);
        return t;
    }

    public static final <T> T i(Iterable<? extends T> iterable) {
        AppMethodBeat.i(129183);
        p.h(iterable, "$this$single");
        if (iterable instanceof List) {
            T t = (T) j.kw((List) iterable);
            AppMethodBeat.o(129183);
            return t;
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            NoSuchElementException noSuchElementException = new NoSuchElementException("Collection is empty.");
            AppMethodBeat.o(129183);
            throw noSuchElementException;
        }
        T t2 = (T) it.next();
        if (it.hasNext()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Collection has more than one element.");
            AppMethodBeat.o(129183);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(129183);
        return t2;
    }

    public static final <T> T kw(List<? extends T> list) {
        AppMethodBeat.i(129184);
        p.h(list, "$this$single");
        switch (list.size()) {
            case 0:
                NoSuchElementException noSuchElementException = new NoSuchElementException("List is empty.");
                AppMethodBeat.o(129184);
                throw noSuchElementException;
            case 1:
                T t = (T) list.get(0);
                AppMethodBeat.o(129184);
                return t;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("List has more than one element.");
                AppMethodBeat.o(129184);
                throw illegalArgumentException;
        }
    }

    public static final <T> T j(Iterable<? extends T> iterable) {
        AppMethodBeat.i(129185);
        p.h(iterable, "$this$singleOrNull");
        if (!(iterable instanceof List)) {
            Iterator<? extends T> it = iterable.iterator();
            if (!it.hasNext()) {
                AppMethodBeat.o(129185);
                return null;
            }
            T t = (T) it.next();
            if (it.hasNext()) {
                AppMethodBeat.o(129185);
                return null;
            }
            AppMethodBeat.o(129185);
            return t;
        } else if (((List) iterable).size() == 1) {
            T t2 = (T) ((List) iterable).get(0);
            AppMethodBeat.o(129185);
            return t2;
        } else {
            AppMethodBeat.o(129185);
            return null;
        }
    }

    public static final <T> T kx(List<? extends T> list) {
        AppMethodBeat.i(129186);
        p.h(list, "$this$singleOrNull");
        if (list.size() == 1) {
            T t = (T) list.get(0);
            AppMethodBeat.o(129186);
            return t;
        }
        AppMethodBeat.o(129186);
        return null;
    }

    public static final <T> List<T> k(Iterable<? extends T> iterable) {
        ArrayList arrayList;
        AppMethodBeat.i(129187);
        p.h(iterable, "$this$drop");
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size() - 1;
            if (size <= 0) {
                v vVar = v.SXr;
                AppMethodBeat.o(129187);
                return vVar;
            } else if (size == 1) {
                List<T> listOf = j.listOf(j.g(iterable));
                AppMethodBeat.o(129187);
                return listOf;
            } else {
                ArrayList arrayList2 = new ArrayList(size);
                if (iterable instanceof List) {
                    if (iterable instanceof RandomAccess) {
                        int size2 = ((Collection) iterable).size();
                        for (int i2 = 1; i2 < size2; i2++) {
                            arrayList2.add(((List) iterable).get(i2));
                        }
                    } else {
                        ListIterator listIterator = ((List) iterable).listIterator(1);
                        while (listIterator.hasNext()) {
                            arrayList2.add(listIterator.next());
                        }
                    }
                    ArrayList arrayList3 = arrayList2;
                    AppMethodBeat.o(129187);
                    return arrayList3;
                }
                arrayList = arrayList2;
            }
        } else {
            arrayList = new ArrayList();
        }
        int i3 = 0;
        for (Object obj : iterable) {
            if (i3 > 0) {
                arrayList.add(obj);
            } else {
                i3++;
            }
        }
        List<T> kr = j.kr(arrayList);
        AppMethodBeat.o(129187);
        return kr;
    }

    public static final <T> List<T> M(List<? extends T> list, int i2) {
        AppMethodBeat.i(206267);
        p.h(list, "$this$dropLast");
        if (!(i2 >= 0)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
            AppMethodBeat.o(206267);
            throw illegalArgumentException;
        }
        List<T> b2 = j.b(list, j.mZ(list.size() - i2, 0));
        AppMethodBeat.o(206267);
        return b2;
    }

    public static final <T> List<T> c(Iterable<? extends T> iterable, kotlin.g.a.b<? super T, Boolean> bVar) {
        AppMethodBeat.i(129189);
        p.h(iterable, "$this$filter");
        p.h(bVar, "predicate");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            if (bVar.invoke(obj).booleanValue()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(129189);
        return arrayList2;
    }

    public static final <T> List<T> l(Iterable<? extends T> iterable) {
        AppMethodBeat.i(129190);
        p.h(iterable, "$this$filterNotNull");
        List<T> list = (List) j.a((Iterable) iterable, (Collection) new ArrayList());
        AppMethodBeat.o(129190);
        return list;
    }

    public static final <C extends Collection<? super T>, T> C a(Iterable<? extends T> iterable, C c2) {
        AppMethodBeat.i(129191);
        p.h(iterable, "$this$filterNotNullTo");
        p.h(c2, "destination");
        for (Object obj : iterable) {
            if (obj != null) {
                c2.add(obj);
            }
        }
        AppMethodBeat.o(129191);
        return c2;
    }

    public static final <T> List<T> a(List<? extends T> list, f fVar) {
        AppMethodBeat.i(206268);
        p.h(list, "$this$slice");
        p.h(fVar, "indices");
        if (fVar.isEmpty()) {
            v vVar = v.SXr;
            AppMethodBeat.o(206268);
            return vVar;
        }
        List<T> p = j.p(list.subList(fVar.SYU, fVar.SYV + 1));
        AppMethodBeat.o(206268);
        return p;
    }

    public static final <T> List<T> b(Iterable<? extends T> iterable, int i2) {
        int i3 = 0;
        AppMethodBeat.i(129192);
        p.h(iterable, "$this$take");
        if (!(i2 >= 0)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
            AppMethodBeat.o(129192);
            throw illegalArgumentException;
        } else if (i2 == 0) {
            v vVar = v.SXr;
            AppMethodBeat.o(129192);
            return vVar;
        } else {
            if (iterable instanceof Collection) {
                if (i2 >= ((Collection) iterable).size()) {
                    List<T> p = j.p(iterable);
                    AppMethodBeat.o(129192);
                    return p;
                } else if (i2 == 1) {
                    List<T> listOf = j.listOf(j.e(iterable));
                    AppMethodBeat.o(129192);
                    return listOf;
                }
            }
            ArrayList arrayList = new ArrayList(i2);
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
                i3++;
                if (i3 == i2) {
                    break;
                }
            }
            List<T> kr = j.kr(arrayList);
            AppMethodBeat.o(129192);
            return kr;
        }
    }

    public static final <T> List<T> N(List<? extends T> list, int i2) {
        AppMethodBeat.i(129193);
        p.h(list, "$this$takeLast");
        if (!(i2 >= 0)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
            AppMethodBeat.o(129193);
            throw illegalArgumentException;
        } else if (i2 == 0) {
            v vVar = v.SXr;
            AppMethodBeat.o(129193);
            return vVar;
        } else {
            int size = list.size();
            if (i2 >= size) {
                List<T> p = j.p(list);
                AppMethodBeat.o(129193);
                return p;
            } else if (i2 == 1) {
                List<T> listOf = j.listOf(j.ku(list));
                AppMethodBeat.o(129193);
                return listOf;
            } else {
                ArrayList arrayList = new ArrayList(i2);
                if (list instanceof RandomAccess) {
                    for (int i3 = size - i2; i3 < size; i3++) {
                        arrayList.add(list.get(i3));
                    }
                } else {
                    ListIterator<? extends T> listIterator = list.listIterator(size - i2);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                ArrayList arrayList2 = arrayList;
                AppMethodBeat.o(129193);
                return arrayList2;
            }
        }
    }

    public static final <T> List<T> m(Iterable<? extends T> iterable) {
        AppMethodBeat.i(129194);
        p.h(iterable, "$this$reversed");
        if (!(iterable instanceof Collection) || ((Collection) iterable).size() > 1) {
            List<T> q = j.q(iterable);
            j.reverse(q);
            AppMethodBeat.o(129194);
            return q;
        }
        List<T> p = j.p(iterable);
        AppMethodBeat.o(129194);
        return p;
    }

    public static final <T extends Comparable<? super T>> List<T> n(Iterable<? extends T> iterable) {
        AppMethodBeat.i(129195);
        p.h(iterable, "$this$sorted");
        if (!(iterable instanceof Collection)) {
            List<T> q = j.q(iterable);
            j.sort(q);
            AppMethodBeat.o(129195);
            return q;
        } else if (((Collection) iterable).size() <= 1) {
            List<T> p = j.p(iterable);
            AppMethodBeat.o(129195);
            return p;
        } else {
            Object[] array = ((Collection) iterable).toArray(new Comparable[0]);
            if (array == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.o(129195);
                throw tVar;
            } else if (array == null) {
                kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.o(129195);
                throw tVar2;
            } else {
                Comparable[] comparableArr = (Comparable[]) array;
                if (comparableArr == null) {
                    kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                    AppMethodBeat.o(129195);
                    throw tVar3;
                }
                e.sort(comparableArr);
                List<T> asList = e.asList(comparableArr);
                AppMethodBeat.o(129195);
                return asList;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: java.util.Collection */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> a(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        AppMethodBeat.i(129196);
        p.h(iterable, "$this$sortedWith");
        p.h(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List<T> q = j.q(iterable);
            j.a((List) q, (Comparator) comparator);
            AppMethodBeat.o(129196);
            return q;
        } else if (((Collection) iterable).size() <= 1) {
            List<T> p = j.p(iterable);
            AppMethodBeat.o(129196);
            return p;
        } else {
            Object[] array = ((Collection) iterable).toArray(new Object[0]);
            if (array == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.o(129196);
                throw tVar;
            } else if (array == null) {
                kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.o(129196);
                throw tVar2;
            } else {
                e.a(array, comparator);
                List<T> asList = e.asList(array);
                AppMethodBeat.o(129196);
                return asList;
            }
        }
    }

    public static final boolean[] s(Collection<Boolean> collection) {
        AppMethodBeat.i(206269);
        p.h(collection, "$this$toBooleanArray");
        boolean[] zArr = new boolean[collection.size()];
        int i2 = 0;
        for (Boolean bool : collection) {
            i2++;
            zArr[i2] = bool.booleanValue();
        }
        AppMethodBeat.o(206269);
        return zArr;
    }

    public static final float[] t(Collection<Float> collection) {
        AppMethodBeat.i(168695);
        p.h(collection, "$this$toFloatArray");
        float[] fArr = new float[collection.size()];
        int i2 = 0;
        for (Float f2 : collection) {
            i2++;
            fArr[i2] = f2.floatValue();
        }
        AppMethodBeat.o(168695);
        return fArr;
    }

    public static final int[] u(Collection<Integer> collection) {
        AppMethodBeat.i(129197);
        p.h(collection, "$this$toIntArray");
        int[] iArr = new int[collection.size()];
        int i2 = 0;
        for (Integer num : collection) {
            i2++;
            iArr[i2] = num.intValue();
        }
        AppMethodBeat.o(129197);
        return iArr;
    }

    public static final long[] toLongArray(Collection<Long> collection) {
        AppMethodBeat.i(206270);
        p.h(collection, "$this$toLongArray");
        long[] jArr = new long[collection.size()];
        int i2 = 0;
        for (Long l : collection) {
            i2++;
            jArr[i2] = l.longValue();
        }
        AppMethodBeat.o(206270);
        return jArr;
    }

    public static final class b extends q implements kotlin.g.a.b {
        final /* synthetic */ int puW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i2) {
            super(1);
            this.puW = i2;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Object invoke(Object obj) {
            AppMethodBeat.i(129228);
            ((Number) obj).intValue();
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("Collection doesn't contain element at index " + this.puW + '.');
            AppMethodBeat.o(129228);
            throw indexOutOfBoundsException;
        }
    }

    public static final <T, C extends Collection<? super T>> C b(Iterable<? extends T> iterable, C c2) {
        AppMethodBeat.i(129198);
        p.h(iterable, "$this$toCollection");
        p.h(c2, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c2.add(it.next());
        }
        AppMethodBeat.o(129198);
        return c2;
    }

    public static final <T> HashSet<T> o(Iterable<? extends T> iterable) {
        AppMethodBeat.i(183772);
        p.h(iterable, "$this$toHashSet");
        HashSet<T> hashSet = (HashSet) j.b((Iterable) iterable, (Collection) new HashSet(ae.atJ(j.a(iterable, 12))));
        AppMethodBeat.o(183772);
        return hashSet;
    }

    public static final <T> List<T> p(Iterable<? extends T> iterable) {
        AppMethodBeat.i(129199);
        p.h(iterable, "$this$toList");
        if (iterable instanceof Collection) {
            switch (((Collection) iterable).size()) {
                case 0:
                    v vVar = v.SXr;
                    AppMethodBeat.o(129199);
                    return vVar;
                case 1:
                    List<T> listOf = j.listOf(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
                    AppMethodBeat.o(129199);
                    return listOf;
                default:
                    List<T> v = j.v((Collection) iterable);
                    AppMethodBeat.o(129199);
                    return v;
            }
        } else {
            List<T> kr = j.kr(j.q(iterable));
            AppMethodBeat.o(129199);
            return kr;
        }
    }

    public static final <T> List<T> q(Iterable<? extends T> iterable) {
        AppMethodBeat.i(129200);
        p.h(iterable, "$this$toMutableList");
        if (iterable instanceof Collection) {
            List<T> v = j.v((Collection) iterable);
            AppMethodBeat.o(129200);
            return v;
        }
        List<T> list = (List) j.b((Iterable) iterable, (Collection) new ArrayList());
        AppMethodBeat.o(129200);
        return list;
    }

    public static final <T> List<T> v(Collection<? extends T> collection) {
        AppMethodBeat.i(129201);
        p.h(collection, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(collection);
        AppMethodBeat.o(129201);
        return arrayList;
    }

    public static final <T> Set<T> r(Iterable<? extends T> iterable) {
        AppMethodBeat.i(129202);
        p.h(iterable, "$this$toSet");
        if (iterable instanceof Collection) {
            switch (((Collection) iterable).size()) {
                case 0:
                    x xVar = x.SXt;
                    AppMethodBeat.o(129202);
                    return xVar;
                case 1:
                    Set<T> of = ak.setOf(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
                    AppMethodBeat.o(129202);
                    return of;
                default:
                    Set<T> set = (Set) j.b((Iterable) iterable, (Collection) new LinkedHashSet(ae.atJ(((Collection) iterable).size())));
                    AppMethodBeat.o(129202);
                    return set;
            }
        } else {
            Set<T> C = ak.C((Set) j.b((Iterable) iterable, (Collection) new LinkedHashSet()));
            AppMethodBeat.o(129202);
            return C;
        }
    }

    public static final <T, R> List<R> d(Iterable<? extends T> iterable, kotlin.g.a.b<? super T, ? extends R> bVar) {
        AppMethodBeat.i(129203);
        p.h(iterable, "$this$map");
        p.h(bVar, "transform");
        ArrayList arrayList = new ArrayList(j.a(iterable, 10));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(bVar.invoke((Object) it.next()));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(129203);
        return arrayList2;
    }

    public static final <T> Iterable<y<T>> s(Iterable<? extends T> iterable) {
        AppMethodBeat.i(129204);
        p.h(iterable, "$this$withIndex");
        z zVar = new z(new c(iterable));
        AppMethodBeat.o(129204);
        return zVar;
    }

    public static final <T> List<T> t(Iterable<? extends T> iterable) {
        AppMethodBeat.i(129205);
        p.h(iterable, "$this$distinct");
        List<T> p = j.p(j.u(iterable));
        AppMethodBeat.o(129205);
        return p;
    }

    public static final <T> Set<T> u(Iterable<? extends T> iterable) {
        AppMethodBeat.i(129206);
        p.h(iterable, "$this$toMutableSet");
        if (iterable instanceof Collection) {
            LinkedHashSet linkedHashSet = new LinkedHashSet((Collection) iterable);
            AppMethodBeat.o(129206);
            return linkedHashSet;
        }
        Set<T> set = (Set) j.b((Iterable) iterable, (Collection) new LinkedHashSet());
        AppMethodBeat.o(129206);
        return set;
    }

    public static final <T> Set<T> b(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        AppMethodBeat.i(129207);
        p.h(iterable, "$this$union");
        p.h(iterable2, FacebookRequestErrorClassification.KEY_OTHER);
        Set<T> u = j.u(iterable);
        j.a((Collection) u, (Iterable) iterable2);
        AppMethodBeat.o(129207);
        return u;
    }

    public static final Float v(Iterable<Float> iterable) {
        AppMethodBeat.i(206271);
        p.h(iterable, "$this$max");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            AppMethodBeat.o(206271);
            return null;
        }
        float floatValue = it.next().floatValue();
        if (Float.isNaN(floatValue)) {
            Float valueOf = Float.valueOf(floatValue);
            AppMethodBeat.o(206271);
            return valueOf;
        }
        while (it.hasNext()) {
            floatValue = it.next().floatValue();
            if (Float.isNaN(floatValue)) {
                Float valueOf2 = Float.valueOf(floatValue);
                AppMethodBeat.o(206271);
                return valueOf2;
            } else if (floatValue >= floatValue) {
                floatValue = floatValue;
            }
        }
        Float valueOf3 = Float.valueOf(floatValue);
        AppMethodBeat.o(206271);
        return valueOf3;
    }

    public static final <T extends Comparable<? super T>> T w(Iterable<? extends T> iterable) {
        AppMethodBeat.i(129208);
        p.h(iterable, "$this$max");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            AppMethodBeat.o(129208);
            return null;
        }
        T t = (T) ((Comparable) it.next());
        while (it.hasNext()) {
            t = (Comparable) it.next();
            if (t.compareTo(t) >= 0) {
                t = t;
            }
        }
        AppMethodBeat.o(129208);
        return t;
    }

    public static final Float x(Iterable<Float> iterable) {
        AppMethodBeat.i(206272);
        p.h(iterable, "$this$min");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            AppMethodBeat.o(206272);
            return null;
        }
        float floatValue = it.next().floatValue();
        if (Float.isNaN(floatValue)) {
            Float valueOf = Float.valueOf(floatValue);
            AppMethodBeat.o(206272);
            return valueOf;
        }
        while (it.hasNext()) {
            floatValue = it.next().floatValue();
            if (Float.isNaN(floatValue)) {
                Float valueOf2 = Float.valueOf(floatValue);
                AppMethodBeat.o(206272);
                return valueOf2;
            } else if (floatValue <= floatValue) {
                floatValue = floatValue;
            }
        }
        Float valueOf3 = Float.valueOf(floatValue);
        AppMethodBeat.o(206272);
        return valueOf3;
    }

    public static final <T extends Comparable<? super T>> T y(Iterable<? extends T> iterable) {
        AppMethodBeat.i(129209);
        p.h(iterable, "$this$min");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            AppMethodBeat.o(129209);
            return null;
        }
        T t = (T) ((Comparable) it.next());
        while (it.hasNext()) {
            t = (Comparable) it.next();
            if (t.compareTo(t) <= 0) {
                t = t;
            }
        }
        AppMethodBeat.o(129209);
        return t;
    }

    public static final <T> List<T> c(Iterable<? extends T> iterable, T t) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(129210);
        p.h(iterable, "$this$minus");
        ArrayList arrayList = new ArrayList(j.a(iterable, 10));
        boolean z3 = false;
        for (Object obj : iterable) {
            if (z3 || !p.j(obj, t)) {
                z = true;
                z2 = z3;
            } else {
                z = false;
                z2 = true;
            }
            if (z) {
                arrayList.add(obj);
                z3 = z2;
            } else {
                z3 = z2;
            }
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(129210);
        return arrayList2;
    }

    public static final <T> List<T> d(Iterable<? extends T> iterable, T t) {
        AppMethodBeat.i(129211);
        p.h(iterable, "$this$plus");
        if (iterable instanceof Collection) {
            List<T> b2 = j.b((Collection) iterable, (Object) t);
            AppMethodBeat.o(129211);
            return b2;
        }
        ArrayList arrayList = new ArrayList();
        j.a((Collection) arrayList, (Iterable) iterable);
        arrayList.add(t);
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(129211);
        return arrayList2;
    }

    public static final <T> List<T> b(Collection<? extends T> collection, T t) {
        AppMethodBeat.i(129212);
        p.h(collection, "$this$plus");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t);
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(129212);
        return arrayList2;
    }

    public static final <T> List<T> b(Collection<? extends T> collection, Iterable<? extends T> iterable) {
        AppMethodBeat.i(129213);
        p.h(collection, "$this$plus");
        p.h(iterable, MessengerShareContentUtility.ELEMENTS);
        if (iterable instanceof Collection) {
            ArrayList arrayList = new ArrayList(((Collection) iterable).size() + collection.size());
            arrayList.addAll(collection);
            arrayList.addAll((Collection) iterable);
            ArrayList arrayList2 = arrayList;
            AppMethodBeat.o(129213);
            return arrayList2;
        }
        ArrayList arrayList3 = new ArrayList(collection);
        j.a((Collection) arrayList3, (Iterable) iterable);
        ArrayList arrayList4 = arrayList3;
        AppMethodBeat.o(129213);
        return arrayList4;
    }

    static final class c extends q implements kotlin.g.a.a<Iterator<? extends T>> {
        final /* synthetic */ Iterable SXp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Iterable iterable) {
            super(0);
            this.SXp = iterable;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(129061);
            Iterator it = this.SXp.iterator();
            AppMethodBeat.o(129061);
            return it;
        }
    }

    public static /* synthetic */ Appendable a(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, kotlin.g.a.b bVar, int i3) {
        AppMethodBeat.i(129216);
        Appendable a2 = j.a(iterable, appendable, (i3 & 2) != 0 ? ", " : charSequence, (i3 & 4) != 0 ? "" : charSequence2, (i3 & 8) != 0 ? "" : charSequence3, (i3 & 16) != 0 ? -1 : i2, (i3 & 32) != 0 ? "..." : charSequence4, (i3 & 64) != 0 ? null : bVar);
        AppMethodBeat.o(129216);
        return a2;
    }

    public static final <T, A extends Appendable> A a(Iterable<? extends T> iterable, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, kotlin.g.a.b<? super T, ? extends CharSequence> bVar) {
        AppMethodBeat.i(129215);
        p.h(iterable, "$this$joinTo");
        p.h(a2, "buffer");
        p.h(charSequence, "separator");
        p.h(charSequence2, "prefix");
        p.h(charSequence3, "postfix");
        p.h(charSequence4, "truncated");
        a2.append(charSequence2);
        int i3 = 0;
        for (Object obj : iterable) {
            i3++;
            if (i3 > 1) {
                a2.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            n.a(a2, obj, bVar);
        }
        if (i2 >= 0 && i3 > i2) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        AppMethodBeat.o(129215);
        return a2;
    }

    public static /* synthetic */ String a(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, kotlin.g.a.b bVar, int i3) {
        AppMethodBeat.i(129218);
        String a2 = j.a(iterable, (i3 & 1) != 0 ? ", " : charSequence, (i3 & 2) != 0 ? "" : charSequence2, (i3 & 4) != 0 ? "" : charSequence3, (i3 & 8) != 0 ? -1 : i2, (i3 & 16) != 0 ? "..." : charSequence4, (i3 & 32) != 0 ? null : bVar);
        AppMethodBeat.o(129218);
        return a2;
    }

    public static final <T> String a(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, kotlin.g.a.b<? super T, ? extends CharSequence> bVar) {
        AppMethodBeat.i(129217);
        p.h(iterable, "$this$joinToString");
        p.h(charSequence, "separator");
        p.h(charSequence2, "prefix");
        p.h(charSequence3, "postfix");
        p.h(charSequence4, "truncated");
        String sb = ((StringBuilder) j.a(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, bVar)).toString();
        p.g(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        AppMethodBeat.o(129217);
        return sb;
    }

    public static final <T> h<T> z(Iterable<? extends T> iterable) {
        AppMethodBeat.i(129219);
        p.h(iterable, "$this$asSequence");
        a aVar = new a(iterable);
        AppMethodBeat.o(129219);
        return aVar;
    }

    public static final double A(Iterable<Integer> iterable) {
        AppMethodBeat.i(129220);
        p.h(iterable, "$this$average");
        double d2 = 0.0d;
        int i2 = 0;
        for (Integer num : iterable) {
            d2 += (double) num.intValue();
            i2++;
            if (i2 < 0) {
                j.hxI();
            }
        }
        if (i2 == 0) {
            k kVar = k.SYw;
            double hxY = k.hxY();
            AppMethodBeat.o(129220);
            return hxY;
        }
        double d3 = d2 / ((double) i2);
        AppMethodBeat.o(129220);
        return d3;
    }

    public static final int B(Iterable<Integer> iterable) {
        AppMethodBeat.i(129221);
        p.h(iterable, "$this$sum");
        int i2 = 0;
        for (Integer num : iterable) {
            i2 = num.intValue() + i2;
        }
        AppMethodBeat.o(129221);
        return i2;
    }

    public static final long C(Iterable<Long> iterable) {
        AppMethodBeat.i(129222);
        p.h(iterable, "$this$sum");
        long j2 = 0;
        for (Long l : iterable) {
            j2 = l.longValue() + j2;
        }
        AppMethodBeat.o(129222);
        return j2;
    }

    public static final float D(Iterable<Float> iterable) {
        AppMethodBeat.i(168696);
        p.h(iterable, "$this$sum");
        float f2 = 0.0f;
        for (Float f3 : iterable) {
            f2 = f3.floatValue() + f2;
        }
        AppMethodBeat.o(168696);
        return f2;
    }

    public static final <T, R> List<o<T, R>> c(Iterable<? extends T> iterable, Iterable<? extends R> iterable2) {
        AppMethodBeat.i(129214);
        p.h(iterable, "$this$zip");
        p.h(iterable2, FacebookRequestErrorClassification.KEY_OTHER);
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(j.a(iterable, 10), j.a(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(s.U(it.next(), it2.next()));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(129214);
        return arrayList2;
    }
}
