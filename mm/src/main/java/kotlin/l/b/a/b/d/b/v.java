package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.a.b.c;
import kotlin.l.b.a.b.b.e;
import kotlin.t;

public final class v {
    public static final v TvS = new v();

    static final class a extends q implements b<String, String> {
        public static final a TvT = new a();

        static {
            AppMethodBeat.i(58250);
            AppMethodBeat.o(58250);
        }

        a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(String str) {
            AppMethodBeat.i(58249);
            String str2 = str;
            p.h(str2, LocaleUtil.ITALIAN);
            v vVar = v.TvS;
            String btV = v.btV(str2);
            AppMethodBeat.o(58249);
            return btV;
        }
    }

    static {
        AppMethodBeat.i(58262);
        AppMethodBeat.o(58262);
    }

    private v() {
    }

    public static final /* synthetic */ String btV(String str) {
        AppMethodBeat.i(58263);
        String btU = btU(str);
        AppMethodBeat.o(58263);
        return btU;
    }

    public static String btR(String str) {
        AppMethodBeat.i(58251);
        p.h(str, "name");
        String concat = "java/lang/".concat(String.valueOf(str));
        AppMethodBeat.o(58251);
        return concat;
    }

    public static String btS(String str) {
        AppMethodBeat.i(58252);
        p.h(str, "name");
        String concat = "java/util/".concat(String.valueOf(str));
        AppMethodBeat.o(58252);
        return concat;
    }

    public static String btT(String str) {
        AppMethodBeat.i(58253);
        p.h(str, "name");
        String concat = "java/util/function/".concat(String.valueOf(str));
        AppMethodBeat.o(58253);
        return concat;
    }

    public static LinkedHashSet<String> r(String str, String... strArr) {
        AppMethodBeat.i(58255);
        p.h(str, "name");
        p.h(strArr, "signatures");
        LinkedHashSet<String> t = t(btR(str), (String[]) Arrays.copyOf(strArr, strArr.length));
        AppMethodBeat.o(58255);
        return t;
    }

    public static LinkedHashSet<String> s(String str, String... strArr) {
        AppMethodBeat.i(58256);
        p.h(str, "name");
        p.h(strArr, "signatures");
        LinkedHashSet<String> t = t(btS(str), (String[]) Arrays.copyOf(strArr, strArr.length));
        AppMethodBeat.o(58256);
        return t;
    }

    private static LinkedHashSet<String> t(String str, String... strArr) {
        AppMethodBeat.i(58257);
        p.h(str, "internalName");
        p.h(strArr, "signatures");
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            linkedHashSet.add(str + '.' + strArr[i2]);
        }
        LinkedHashSet<String> linkedHashSet2 = linkedHashSet;
        AppMethodBeat.o(58257);
        return linkedHashSet2;
    }

    public static String a(e eVar, String str) {
        String a2;
        AppMethodBeat.i(58258);
        p.h(eVar, "classDescriptor");
        p.h(str, "jvmDescriptor");
        p.h(eVar, "$this$internalName");
        c cVar = c.TfZ;
        kotlin.l.b.a.b.f.c hJe = kotlin.l.b.a.b.j.d.a.o(eVar).hJe();
        p.g(hJe, "fqNameSafe.toUnsafe()");
        kotlin.l.b.a.b.f.a c2 = c.c(hJe);
        if (c2 != null) {
            kotlin.l.b.a.b.j.e.c e2 = kotlin.l.b.a.b.j.e.c.e(c2);
            p.g(e2, "JvmClassName.byClassId(it)");
            a2 = e2.hKI();
            p.g(a2, "JvmClassName.byClassId(it).internalName");
        } else {
            a2 = aa.a(eVar, x.TvU);
        }
        String ov = ov(a2, str);
        AppMethodBeat.o(58258);
        return ov;
    }

    public static String ov(String str, String str2) {
        AppMethodBeat.i(58259);
        p.h(str, "internalName");
        p.h(str2, "jvmDescriptor");
        String str3 = str + '.' + str2;
        AppMethodBeat.o(58259);
        return str3;
    }

    public static String e(String str, List<String> list, String str2) {
        AppMethodBeat.i(58260);
        p.h(str, "name");
        p.h(list, "parameters");
        p.h(str2, "ret");
        String str3 = str + '(' + j.a(list, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, a.TvT, 30) + ')' + btU(str2);
        AppMethodBeat.o(58260);
        return str3;
    }

    private static String btU(String str) {
        AppMethodBeat.i(58261);
        if (str.length() > 1) {
            String str2 = "L" + str + ';';
            AppMethodBeat.o(58261);
            return str2;
        }
        AppMethodBeat.o(58261);
        return str;
    }

    public static String[] aj(String... strArr) {
        AppMethodBeat.i(58254);
        p.h(strArr, "signatures");
        ArrayList arrayList = new ArrayList(strArr.length);
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            arrayList.add("<init>(" + strArr[i2] + ")V");
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(58254);
            throw tVar;
        }
        String[] strArr2 = (String[]) array;
        AppMethodBeat.o(58254);
        return strArr2;
    }
}
