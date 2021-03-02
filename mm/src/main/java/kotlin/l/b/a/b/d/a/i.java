package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.f.b;

public final class i {
    private static final HashMap<b, b> ToY = new HashMap<>();
    public static final i ToZ = new i();

    static {
        AppMethodBeat.i(57579);
        b bVar = g.TcO.TdO;
        p.g(bVar, "FQ_NAMES.mutableList");
        a(bVar, ai("java.util.ArrayList", "java.util.LinkedList"));
        b bVar2 = g.TcO.TdQ;
        p.g(bVar2, "FQ_NAMES.mutableSet");
        a(bVar2, ai("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        b bVar3 = g.TcO.TdR;
        p.g(bVar3, "FQ_NAMES.mutableMap");
        a(bVar3, ai("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        a(new b("java.util.function.Function"), ai("java.util.function.UnaryOperator"));
        a(new b("java.util.function.BiFunction"), ai("java.util.function.BinaryOperator"));
        AppMethodBeat.o(57579);
    }

    private i() {
    }

    public static b m(b bVar) {
        AppMethodBeat.i(57576);
        p.h(bVar, "classFqName");
        b bVar2 = ToY.get(bVar);
        AppMethodBeat.o(57576);
        return bVar2;
    }

    private static void a(b bVar, List<b> list) {
        AppMethodBeat.i(57577);
        HashMap<b, b> hashMap = ToY;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            hashMap.put(it.next(), bVar);
        }
        AppMethodBeat.o(57577);
    }

    private static List<b> ai(String... strArr) {
        AppMethodBeat.i(57578);
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(new b(str));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(57578);
        return arrayList2;
    }
}
