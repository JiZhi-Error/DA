package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\b\u001a \u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0001\u001a\u001f\u0010\t\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0001¢\u0006\u0002\u0010\n\u001a\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0000\u001a,\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0000\u001a\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0010\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a\u001d\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\fH\u0002¢\u0006\u0002\b\u0013\u001a@\u0010\u0014\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u00100\u0015\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0016*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00160\u00150\u0001¨\u0006\u0017"}, hxF = {"Iterable", "", "T", "iterator", "Lkotlin/Function0;", "", "collectionSizeOrDefault", "", BuildConfig.KINDA_DEFAULT, "collectionSizeOrNull", "(Ljava/lang/Iterable;)Ljava/lang/Integer;", "convertToSetForSetOperation", "", "convertToSetForSetOperationWith", "source", "flatten", "", "safeToConvertToSet", "", "safeToConvertToSet$CollectionsKt__IterablesKt", "unzip", "Lkotlin/Pair;", "R", "kotlin-stdlib"}, hxG = 1)
public class m extends l {
    public static final <T> Integer d(Iterable<? extends T> iterable) {
        AppMethodBeat.i(206260);
        p.h(iterable, "$this$collectionSizeOrNull");
        if (iterable instanceof Collection) {
            Integer valueOf = Integer.valueOf(((Collection) iterable).size());
            AppMethodBeat.o(206260);
            return valueOf;
        }
        AppMethodBeat.o(206260);
        return null;
    }

    public static final <T> int a(Iterable<? extends T> iterable, int i2) {
        AppMethodBeat.i(129232);
        p.h(iterable, "$this$collectionSizeOrDefault");
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size();
            AppMethodBeat.o(129232);
            return size;
        }
        AppMethodBeat.o(129232);
        return i2;
    }

    public static final <T> Collection<T> a(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        boolean z;
        AppMethodBeat.i(206261);
        p.h(iterable, "$this$convertToSetForSetOperationWith");
        p.h(iterable2, "source");
        if (iterable instanceof Set) {
            Collection<T> collection = (Collection) iterable;
            AppMethodBeat.o(206261);
            return collection;
        }
        if (iterable instanceof Collection) {
            if (!(iterable2 instanceof Collection) || ((Collection) iterable2).size() >= 2) {
                Collection collection2 = (Collection) iterable;
                if (collection2.size() <= 2 || !(collection2 instanceof ArrayList)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    Collection<T> collection3 = (Collection) iterable;
                    AppMethodBeat.o(206261);
                    return collection3;
                }
            } else {
                Collection<T> collection4 = (Collection) iterable;
                AppMethodBeat.o(206261);
                return collection4;
            }
        }
        HashSet o = j.o(iterable);
        AppMethodBeat.o(206261);
        return o;
    }
}
