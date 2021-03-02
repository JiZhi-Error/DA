package kotlin.l.b.a.b.e.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.d;
import kotlin.n.n;
import kotlin.x;

public final class b {
    public static final b TCw = new b();
    private static final Map<String, String> map;

    static final class a extends q implements m<String, String, x> {
        final /* synthetic */ Map TCx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Map map) {
            super(2);
            this.TCx = map;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(String str, String str2) {
            AppMethodBeat.i(59226);
            ow(str, str2);
            x xVar = x.SXb;
            AppMethodBeat.o(59226);
            return xVar;
        }

        public final void ow(String str, String str2) {
            AppMethodBeat.i(59227);
            p.h(str, "kotlinSimpleName");
            p.h(str2, "javaInternalName");
            this.TCx.put("kotlin/".concat(String.valueOf(str)), "L" + str2 + ';');
            AppMethodBeat.o(59227);
        }
    }

    static {
        AppMethodBeat.i(59229);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List listOf = j.listOf((Object[]) new String[]{"Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", QLog.TAG_REPORTLEVEL_DEVELOPER});
        d a2 = kotlin.k.j.a((d) j.r((Collection<?>) listOf), 2);
        int i2 = a2.SYU;
        int i3 = a2.SYV;
        int i4 = a2.lCq;
        if (i4 < 0 ? i2 >= i3 : i2 <= i3) {
            while (true) {
                linkedHashMap.put("kotlin/" + ((String) listOf.get(i2)), listOf.get(i2 + 1));
                linkedHashMap.put("kotlin/" + ((String) listOf.get(i2)) + "Array", "[" + ((String) listOf.get(i2 + 1)));
                if (i2 == i3) {
                    break;
                }
                i2 += i4;
            }
        }
        linkedHashMap.put("kotlin/Unit", "V");
        a aVar = new a(linkedHashMap);
        aVar.ow("Any", "java/lang/Object");
        aVar.ow("Nothing", "java/lang/Void");
        aVar.ow("Annotation", "java/lang/annotation/Annotation");
        for (String str : j.listOf((Object[]) new String[]{"String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum"})) {
            aVar.ow(str, "java/lang/".concat(String.valueOf(str)));
        }
        for (String str2 : j.listOf((Object[]) new String[]{"Iterator", "Collection", "List", "Set", "Map", "ListIterator"})) {
            aVar.ow("collections/".concat(String.valueOf(str2)), "java/util/".concat(String.valueOf(str2)));
            aVar.ow("collections/Mutable".concat(String.valueOf(str2)), "java/util/".concat(String.valueOf(str2)));
        }
        aVar.ow("collections/Iterable", "java/lang/Iterable");
        aVar.ow("collections/MutableIterable", "java/lang/Iterable");
        aVar.ow("collections/Map.Entry", "java/util/Map$Entry");
        aVar.ow("collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i5 = 0; i5 <= 22; i5++) {
            aVar.ow("Function".concat(String.valueOf(i5)), "kotlin/jvm/functions/Function".concat(String.valueOf(i5)));
            aVar.ow("reflect/KFunction".concat(String.valueOf(i5)), "kotlin/reflect/KFunction");
        }
        for (String str3 : j.listOf((Object[]) new String[]{"Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum"})) {
            aVar.ow(str3 + ".Companion", "kotlin/jvm/internal/" + str3 + "CompanionObject");
        }
        map = linkedHashMap;
        AppMethodBeat.o(59229);
    }

    private b() {
    }

    public static final String btW(String str) {
        AppMethodBeat.i(59228);
        p.h(str, "classId");
        String str2 = map.get(str);
        if (str2 == null) {
            str2 = "L" + n.a(str, '.', '$') + ';';
        }
        AppMethodBeat.o(59228);
        return str2;
    }
}
