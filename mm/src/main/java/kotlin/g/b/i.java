package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0007¢\u0006\u0004\b\t\u0010\n\u001a5\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\t\u0010\f\u001a~\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0014\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u00112(\u0010\u0012\u001a$\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u0013H\b¢\u0006\u0002\u0010\u0014\"\u0018\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"EMPTY", "", "", "[Ljava/lang/Object;", "MAX_SIZE", "", "collectionToArray", "collection", "", "toArray", "(Ljava/util/Collection;)[Ljava/lang/Object;", "a", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "toArrayImpl", "empty", "Lkotlin/Function0;", "alloc", "Lkotlin/Function1;", "trim", "Lkotlin/Function2;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "kotlin-stdlib"})
public final class i {
    private static final Object[] gKK = new Object[0];

    public static final Object[] a(Collection<?> collection, Object[] objArr) {
        Object[] objArr2;
        int i2 = 0;
        AppMethodBeat.i(129342);
        p.h(collection, "collection");
        if (objArr == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(129342);
            throw nullPointerException;
        }
        int size = collection.size();
        if (size == 0) {
            if (objArr.length > 0) {
                objArr[0] = null;
            }
            AppMethodBeat.o(129342);
            return objArr;
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            if (objArr.length > 0) {
                objArr[0] = null;
            }
            AppMethodBeat.o(129342);
            return objArr;
        }
        if (size <= objArr.length) {
            objArr2 = objArr;
        } else {
            Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
            if (newInstance == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                AppMethodBeat.o(129342);
                throw tVar;
            }
            objArr2 = (Object[]) newInstance;
        }
        while (true) {
            int i3 = i2 + 1;
            objArr2[i2] = it.next();
            if (i3 >= objArr2.length) {
                if (!it.hasNext()) {
                    AppMethodBeat.o(129342);
                    return objArr2;
                }
                int i4 = ((i3 * 3) + 1) >>> 1;
                if (i4 <= i3) {
                    if (i3 >= 2147483645) {
                        OutOfMemoryError outOfMemoryError = new OutOfMemoryError();
                        AppMethodBeat.o(129342);
                        throw outOfMemoryError;
                    }
                    i4 = 2147483645;
                }
                objArr2 = Arrays.copyOf(objArr2, i4);
                p.g(objArr2, "Arrays.copyOf(result, newSize)");
                i2 = i3;
            } else if (it.hasNext()) {
                i2 = i3;
            } else if (objArr2 == objArr) {
                objArr[i3] = null;
                AppMethodBeat.o(129342);
                return objArr;
            } else {
                Object[] copyOf = Arrays.copyOf(objArr2, i3);
                p.g(copyOf, "Arrays.copyOf(result, size)");
                AppMethodBeat.o(129342);
                return copyOf;
            }
        }
    }

    public static final Object[] w(Collection<?> collection) {
        AppMethodBeat.i(129341);
        p.h(collection, "collection");
        int size = collection.size();
        if (size == 0) {
            Object[] objArr = gKK;
            AppMethodBeat.o(129341);
            return objArr;
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            Object[] objArr2 = gKK;
            AppMethodBeat.o(129341);
            return objArr2;
        }
        Object[] objArr3 = new Object[size];
        int i2 = 0;
        Object[] objArr4 = objArr3;
        while (true) {
            int i3 = i2 + 1;
            objArr4[i2] = it.next();
            if (i3 >= objArr4.length) {
                if (!it.hasNext()) {
                    AppMethodBeat.o(129341);
                    return objArr4;
                }
                int i4 = ((i3 * 3) + 1) >>> 1;
                if (i4 <= i3) {
                    if (i3 >= 2147483645) {
                        OutOfMemoryError outOfMemoryError = new OutOfMemoryError();
                        AppMethodBeat.o(129341);
                        throw outOfMemoryError;
                    }
                    i4 = 2147483645;
                }
                objArr4 = Arrays.copyOf(objArr4, i4);
                p.g(objArr4, "Arrays.copyOf(result, newSize)");
                i2 = i3;
            } else if (!it.hasNext()) {
                Object[] copyOf = Arrays.copyOf(objArr4, i3);
                p.g(copyOf, "Arrays.copyOf(result, size)");
                AppMethodBeat.o(129341);
                return copyOf;
            } else {
                i2 = i3;
            }
        }
    }
}
