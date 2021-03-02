package kotlin.l.b.a.b.e.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.a.x;
import kotlin.a.y;
import kotlin.g.b.p;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.e.c.a;
import kotlin.l.b.a.b.h.d;
import kotlin.n.n;
import kotlin.t;

public final class g implements c {
    private static final List<String> TCJ;
    private static final Map<String, Integer> TCK;
    public static final a TCL = new a((byte) 0);
    private final Set<Integer> TCH;
    private final a.d TCI;
    private final List<a.d.b> qwH;
    private final String[] strings;

    public g(a.d dVar, String[] strArr) {
        x r;
        p.h(dVar, "types");
        p.h(strArr, "strings");
        AppMethodBeat.i(59249);
        this.TCI = dVar;
        this.strings = strArr;
        List<Integer> list = this.TCI.TCg;
        if (list.isEmpty()) {
            r = x.SXt;
        } else {
            r = j.r((Iterable) list);
        }
        this.TCH = r;
        ArrayList arrayList = new ArrayList();
        List<a.d.b> list2 = this.TCI.TCf;
        arrayList.ensureCapacity(list2.size());
        for (a.d.b bVar : list2) {
            p.g(bVar, "record");
            int i2 = bVar.TCj;
            for (int i3 = 0; i3 < i2; i3++) {
                arrayList.add(bVar);
            }
        }
        arrayList.trimToSize();
        this.qwH = arrayList;
        AppMethodBeat.o(59249);
    }

    @Override // kotlin.l.b.a.b.e.b.c
    public final String getString(int i2) {
        String str;
        AppMethodBeat.i(59246);
        a.d.b bVar = this.qwH.get(i2);
        if (bVar.hIO()) {
            Object obj = bVar.TCl;
            if (obj instanceof String) {
                str = (String) obj;
            } else {
                d dVar = (d) obj;
                String yO = dVar.yO();
                if (dVar.yP()) {
                    bVar.TCl = yO;
                }
                str = yO;
            }
        } else {
            if (bVar.hIN()) {
                int size = TCJ.size();
                int i3 = bVar.TCk;
                if (i3 >= 0 && size > i3) {
                    str = TCJ.get(bVar.TCk);
                }
            }
            str = this.strings[i2];
        }
        if (bVar.TCn.size() >= 2) {
            List<Integer> list = bVar.TCn;
            Integer num = list.get(0);
            Integer num2 = list.get(1);
            p.g(num, "begin");
            if (p.compare(0, num.intValue()) <= 0) {
                int intValue = num.intValue();
                p.g(num2, "end");
                if (p.compare(intValue, num2.intValue()) <= 0 && p.compare(num2.intValue(), str.length()) <= 0) {
                    p.g(str, "string");
                    int intValue2 = num.intValue();
                    int intValue3 = num2.intValue();
                    if (str == null) {
                        t tVar = new t("null cannot be cast to non-null type java.lang.String");
                        AppMethodBeat.o(59246);
                        throw tVar;
                    }
                    str = str.substring(intValue2, intValue3);
                    p.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
            }
        }
        if (bVar.TCp.size() >= 2) {
            List<Integer> list2 = bVar.TCp;
            p.g(str, "string");
            str = n.a(str, (char) list2.get(0).intValue(), (char) list2.get(1).intValue());
        }
        a.d.b.EnumC2336b bVar2 = bVar.TCm;
        if (bVar2 == null) {
            bVar2 = a.d.b.EnumC2336b.NONE;
        }
        switch (h.$EnumSwitchMapping$0[bVar2.ordinal()]) {
            case 2:
                p.g(str, "string");
                str = n.a(str, '$', '.');
                break;
            case 3:
                if (str.length() >= 2) {
                    p.g(str, "string");
                    int length = str.length() - 1;
                    if (str == null) {
                        t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
                        AppMethodBeat.o(59246);
                        throw tVar2;
                    }
                    str = str.substring(1, length);
                    p.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                p.g(str, "string");
                str = n.a(str, '$', '.');
                break;
        }
        p.g(str, "string");
        AppMethodBeat.o(59246);
        return str;
    }

    @Override // kotlin.l.b.a.b.e.b.c
    public final String avl(int i2) {
        AppMethodBeat.i(59247);
        String string = getString(i2);
        AppMethodBeat.o(59247);
        return string;
    }

    @Override // kotlin.l.b.a.b.e.b.c
    public final boolean avm(int i2) {
        AppMethodBeat.i(59248);
        boolean contains = this.TCH.contains(Integer.valueOf(i2));
        AppMethodBeat.o(59248);
        return contains;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(59250);
        List<String> listOf = j.listOf((Object[]) new String[]{"kotlin/Any", "kotlin/Nothing", "kotlin/Unit", "kotlin/Throwable", "kotlin/Number", "kotlin/Byte", "kotlin/Double", "kotlin/Float", "kotlin/Int", "kotlin/Long", "kotlin/Short", "kotlin/Boolean", "kotlin/Char", "kotlin/CharSequence", "kotlin/String", "kotlin/Comparable", "kotlin/Enum", "kotlin/Array", "kotlin/ByteArray", "kotlin/DoubleArray", "kotlin/FloatArray", "kotlin/IntArray", "kotlin/LongArray", "kotlin/ShortArray", "kotlin/BooleanArray", "kotlin/CharArray", "kotlin/Cloneable", "kotlin/Annotation", "kotlin/collections/Iterable", "kotlin/collections/MutableIterable", "kotlin/collections/Collection", "kotlin/collections/MutableCollection", "kotlin/collections/List", "kotlin/collections/MutableList", "kotlin/collections/Set", "kotlin/collections/MutableSet", "kotlin/collections/Map", "kotlin/collections/MutableMap", "kotlin/collections/Map.Entry", "kotlin/collections/MutableMap.MutableEntry", "kotlin/collections/Iterator", "kotlin/collections/MutableIterator", "kotlin/collections/ListIterator", "kotlin/collections/MutableListIterator"});
        TCJ = listOf;
        Iterable s = j.s((Iterable) listOf);
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.k.j.mZ(ae.atJ(j.a(s, 10)), 16));
        for (Object obj : s) {
            linkedHashMap.put(((y) obj).value, Integer.valueOf(((y) obj).index));
        }
        TCK = linkedHashMap;
        AppMethodBeat.o(59250);
    }
}
