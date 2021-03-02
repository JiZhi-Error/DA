package kotlin.l.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.b;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.f;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.w;
import kotlin.l.c;
import kotlin.l.o;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001c\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\"\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00058FX\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0003\u0010\b¨\u0006\t"}, hxF = {"jvmErasure", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/KClassifier;", "getJvmErasure", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KClass;", "Lkotlin/reflect/KType;", "jvmErasure$annotations", "(Lkotlin/reflect/KType;)V", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KClass;", "kotlin-reflection"})
public final class a {
    private static b<?> a(o oVar) {
        b<?> a2;
        AppMethodBeat.i(56266);
        p.h(oVar, "$this$jvmErasure");
        c hyn = oVar.hyn();
        if (hyn == null || (a2 = a(hyn)) == null) {
            w wVar = new w("Cannot calculate JVM erasure for type: ".concat(String.valueOf(oVar)));
            AppMethodBeat.o(56266);
            throw wVar;
        }
        AppMethodBeat.o(56266);
        return a2;
    }

    public static final b<?> a(c cVar) {
        T t;
        b<?> a2;
        boolean z;
        AppMethodBeat.i(56267);
        p.h(cVar, "$this$jvmErasure");
        if (cVar instanceof b) {
            b<?> bVar = (b) cVar;
            AppMethodBeat.o(56267);
            return bVar;
        } else if (cVar instanceof kotlin.l.p) {
            List<o> hyo = ((kotlin.l.p) cVar).hyo();
            Iterator<T> it = hyo.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                T next = it.next();
                T t2 = next;
                if (t2 != null) {
                    h hzS = t2.Tbs.hKE().hzS();
                    if (!(hzS instanceof e)) {
                        hzS = null;
                    }
                    e eVar = (e) hzS;
                    if (eVar == null || eVar.hzB() == f.INTERFACE || eVar.hzB() == f.ANNOTATION_CLASS) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (z) {
                        t = next;
                        break;
                    }
                } else {
                    t tVar = new t("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                    AppMethodBeat.o(56267);
                    throw tVar;
                }
            }
            T t3 = t;
            if (t3 == null) {
                t3 = (o) j.kt(hyo);
            }
            if (t3 == null || (a2 = a(t3)) == null) {
                b<?> bp = aa.bp(Object.class);
                AppMethodBeat.o(56267);
                return bp;
            }
            AppMethodBeat.o(56267);
            return a2;
        } else {
            w wVar = new w("Cannot calculate JVM erasure for type: ".concat(String.valueOf(cVar)));
            AppMethodBeat.o(56267);
            throw wVar;
        }
    }
}
