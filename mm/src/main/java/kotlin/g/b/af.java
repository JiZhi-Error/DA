package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.a.a;
import kotlin.g.b.a.b;
import kotlin.g.b.a.c;
import kotlin.g.b.a.e;
import kotlin.g.b.a.f;
import kotlin.g.b.a.g;

public class af {
    private static <T extends Throwable> T r(T t) {
        AppMethodBeat.i(128962);
        T t2 = (T) p.c(t, af.class.getName());
        AppMethodBeat.o(128962);
        return t2;
    }

    private static void i(Object obj, String str) {
        AppMethodBeat.i(128963);
        ClassCastException classCastException = (ClassCastException) r(new ClassCastException((obj == null ? BuildConfig.COMMAND : obj.getClass().getName()) + " cannot be cast to " + str));
        AppMethodBeat.o(128963);
        throw classCastException;
    }

    public static Iterable eT(Object obj) {
        AppMethodBeat.i(128964);
        if ((obj instanceof a) && !(obj instanceof c)) {
            i(obj, "kotlin.collections.MutableIterable");
        }
        Iterable eU = eU(obj);
        AppMethodBeat.o(128964);
        return eU;
    }

    private static Iterable eU(Object obj) {
        AppMethodBeat.i(128965);
        try {
            Iterable iterable = (Iterable) obj;
            AppMethodBeat.o(128965);
            return iterable;
        } catch (ClassCastException e2) {
            ClassCastException classCastException = (ClassCastException) r(e2);
            AppMethodBeat.o(128965);
            throw classCastException;
        }
    }

    public static Collection eV(Object obj) {
        AppMethodBeat.i(128966);
        if ((obj instanceof a) && !(obj instanceof b)) {
            i(obj, "kotlin.collections.MutableCollection");
        }
        Collection eW = eW(obj);
        AppMethodBeat.o(128966);
        return eW;
    }

    private static Collection eW(Object obj) {
        AppMethodBeat.i(128967);
        try {
            Collection collection = (Collection) obj;
            AppMethodBeat.o(128967);
            return collection;
        } catch (ClassCastException e2) {
            ClassCastException classCastException = (ClassCastException) r(e2);
            AppMethodBeat.o(128967);
            throw classCastException;
        }
    }

    public static boolean eX(Object obj) {
        return (obj instanceof List) && (!(obj instanceof a) || (obj instanceof e));
    }

    public static List eY(Object obj) {
        AppMethodBeat.i(206188);
        if ((obj instanceof a) && !(obj instanceof e)) {
            i(obj, "kotlin.collections.MutableList");
        }
        List eZ = eZ(obj);
        AppMethodBeat.o(206188);
        return eZ;
    }

    private static List eZ(Object obj) {
        AppMethodBeat.i(206189);
        try {
            List list = (List) obj;
            AppMethodBeat.o(206189);
            return list;
        } catch (ClassCastException e2) {
            ClassCastException classCastException = (ClassCastException) r(e2);
            AppMethodBeat.o(206189);
            throw classCastException;
        }
    }

    public static boolean fa(Object obj) {
        return (obj instanceof Set) && (!(obj instanceof a) || (obj instanceof g));
    }

    public static Set fb(Object obj) {
        AppMethodBeat.i(128968);
        if ((obj instanceof a) && !(obj instanceof g)) {
            i(obj, "kotlin.collections.MutableSet");
        }
        Set fc = fc(obj);
        AppMethodBeat.o(128968);
        return fc;
    }

    private static Set fc(Object obj) {
        AppMethodBeat.i(128969);
        try {
            Set set = (Set) obj;
            AppMethodBeat.o(128969);
            return set;
        } catch (ClassCastException e2) {
            ClassCastException classCastException = (ClassCastException) r(e2);
            AppMethodBeat.o(128969);
            throw classCastException;
        }
    }

    public static Map fd(Object obj) {
        AppMethodBeat.i(177350);
        if ((obj instanceof a) && !(obj instanceof f)) {
            i(obj, "kotlin.collections.MutableMap");
        }
        Map fe = fe(obj);
        AppMethodBeat.o(177350);
        return fe;
    }

    private static Map fe(Object obj) {
        AppMethodBeat.i(177351);
        try {
            Map map = (Map) obj;
            AppMethodBeat.o(177351);
            return map;
        } catch (ClassCastException e2) {
            ClassCastException classCastException = (ClassCastException) r(e2);
            AppMethodBeat.o(177351);
            throw classCastException;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object r(java.lang.Object r4, int r5) {
        /*
        // Method dump skipped, instructions count: 214
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.g.b.af.r(java.lang.Object, int):java.lang.Object");
    }
}
