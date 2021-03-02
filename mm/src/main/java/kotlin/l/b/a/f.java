package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.b.a.c.a;
import kotlin.l.b.a.c.b;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\b\b\u0000\u0010\t*\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\u0000\"*\u0010\u0000\u001a\u001e\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u00040\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"K_CLASS_CACHE", "Lkotlin/reflect/jvm/internal/pcollections/HashPMap;", "", "kotlin.jvm.PlatformType", "", "clearKClassCache", "", "getOrCreateKotlinClass", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "jClass", "Ljava/lang/Class;", "kotlin-reflection"})
public final class f {
    private static b<String, Object> SZU;

    static {
        AppMethodBeat.i(56305);
        b<String, Object> hMb = b.hMb();
        p.g(hMb, "HashPMap.empty<String, Any>()");
        SZU = hMb;
        AppMethodBeat.o(56305);
    }

    public static final <T> g<T> bq(Class<T> cls) {
        V v;
        Class<T> cls2 = null;
        AppMethodBeat.i(56304);
        p.h(cls, "jClass");
        String name = cls.getName();
        a<E> avQ = SZU.avQ(name.hashCode());
        while (true) {
            if (avQ == null || avQ.size <= 0) {
                v = null;
            } else {
                E e2 = avQ.first;
                if (e2.key.equals(name)) {
                    v = e2.value;
                    break;
                }
                avQ = avQ.TSj;
            }
        }
        if (v instanceof WeakReference) {
            g<T> gVar = (g) v.get();
            if (gVar != null) {
                cls2 = gVar.SYp;
            }
            if (p.j(cls2, cls)) {
                AppMethodBeat.o(56304);
                return gVar;
            }
        } else if (v != null) {
            for (WeakReference weakReference : (WeakReference[]) v) {
                g<T> gVar2 = (g) weakReference.get();
                if (p.j(gVar2 != null ? gVar2.SYp : null, cls)) {
                    AppMethodBeat.o(56304);
                    return gVar2;
                }
            }
            int length = ((Object[]) v).length;
            WeakReference[] weakReferenceArr = new WeakReference[(length + 1)];
            System.arraycopy(v, 0, weakReferenceArr, 0, length);
            g<T> gVar3 = new g<>(cls);
            weakReferenceArr[length] = new WeakReference(gVar3);
            b<String, Object> X = SZU.X(name, weakReferenceArr);
            p.g(X, "K_CLASS_CACHE.plus(name, newArray)");
            SZU = X;
            AppMethodBeat.o(56304);
            return gVar3;
        }
        g<T> gVar4 = new g<>(cls);
        b<String, Object> X2 = SZU.X(name, new WeakReference(gVar4));
        p.g(X2, "K_CLASS_CACHE.plus(name, WeakReference(newKClass))");
        SZU = X2;
        AppMethodBeat.o(56304);
        return gVar4;
    }
}
