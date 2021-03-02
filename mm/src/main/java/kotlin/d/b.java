package kotlin.d;

import com.tencent.rtmp.sharp.jni.QLog;
import kotlin.d.f;
import kotlin.d.f.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u0002H\u00012\b\u0012\u0004\u0012\u0002H\u00030\u0004B8\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012#\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0000¢\u0006\u0002\b\u0010J\u0019\u0010\u0011\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0012\u0010\u0013R+\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lkotlin/coroutines/AbstractCoroutineContextKey;", "B", "Lkotlin/coroutines/CoroutineContext$Element;", QLog.TAG_REPORTLEVEL_USER, "Lkotlin/coroutines/CoroutineContext$Key;", "baseKey", "safeCast", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "element", "(Lkotlin/coroutines/CoroutineContext$Key;Lkotlin/jvm/functions/Function1;)V", "topmostKey", "isSubKey", "", "key", "isSubKey$kotlin_stdlib", "tryCast", "tryCast$kotlin_stdlib", "(Lkotlin/coroutines/CoroutineContext$Element;)Lkotlin/coroutines/CoroutineContext$Element;", "kotlin-stdlib"})
public abstract class b<B extends f.b, E extends B> implements f.c<E> {
    private final kotlin.g.a.b<f.b, E> SXA;
    private final f.c<?> SXz;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: kotlin.d.f$c<?> */
    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.g.a.b<? super kotlin.d.f$b, ? extends E extends B>, kotlin.g.a.b<kotlin.d.f$b, E extends B>, java.lang.Object] */
    public b(f.c<B> cVar, kotlin.g.a.b<? super f.b, ? extends E> bVar) {
        p.h(cVar, "baseKey");
        p.h(bVar, "safeCast");
        this.SXA = bVar;
        this.SXz = cVar instanceof b ? (f.c<B>) ((b) cVar).SXz : cVar;
    }

    public final E a(f.b bVar) {
        p.h(bVar, "element");
        return this.SXA.invoke(bVar);
    }

    public final boolean a(f.c<?> cVar) {
        p.h(cVar, "key");
        return cVar == this || this.SXz == cVar;
    }
}
