package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.l;
import kotlin.m.i;
import kotlinx.coroutines.ce;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lkotlinx/coroutines/internal/MainDispatcherLoader;", "", "()V", "FAST_SERVICE_LOADER_ENABLED", "", "dispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "loadMainDispatcher", "kotlinx-coroutines-core"})
public final class n {
    private static final boolean TVZ = x.buD("kotlinx.coroutines.fast.service.loader");
    public static final ce TWa = hNO();
    public static final n TWb = new n();

    static {
        AppMethodBeat.i(192470);
        AppMethodBeat.o(192470);
    }

    private n() {
    }

    private static ce hNO() {
        p b2;
        List<MainDispatcherFactory> c2;
        T t;
        AppMethodBeat.i(192469);
        try {
            if (TVZ) {
                g gVar = g.TVK;
                c2 = g.hNF();
            } else {
                c2 = i.c(i.d(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator()));
            }
            Iterator<T> it = c2.iterator();
            if (it.hasNext()) {
                T next = it.next();
                if (it.hasNext()) {
                    int loadPriority = next.getLoadPriority();
                    T t2 = next;
                    while (true) {
                        T next2 = it.next();
                        int loadPriority2 = next2.getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            t = next2;
                        } else {
                            loadPriority2 = loadPriority;
                            t = t2;
                        }
                        if (!it.hasNext()) {
                            break;
                        }
                        loadPriority = loadPriority2;
                        t2 = t;
                    }
                } else {
                    t = next;
                }
            } else {
                t = null;
            }
            T t3 = t;
            if (t3 == null || (b2 = o.a(t3, c2)) == null) {
                b2 = o.b(null, 3);
            }
        } catch (Throwable th) {
            b2 = o.b(th, 2);
        }
        AppMethodBeat.o(192469);
        return b2;
    }
}
