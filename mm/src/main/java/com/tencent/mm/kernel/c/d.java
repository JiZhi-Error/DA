package com.tencent.mm.kernel.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Modifier;
import java.util.concurrent.ConcurrentHashMap;

public class d {
    private static final d htF = new d();
    private ConcurrentHashMap<Class<? extends a>, c> htD = new ConcurrentHashMap<>();
    private a htE = null;

    public interface a {
        void a(Class<? extends a> cls, a aVar);

        void a(Class<? extends a> cls, c cVar);

        void b(Class<? extends a> cls, c cVar);
    }

    public d() {
        AppMethodBeat.i(157484);
        AppMethodBeat.o(157484);
    }

    static {
        AppMethodBeat.i(157489);
        AppMethodBeat.o(157489);
    }

    public void a(a aVar) {
        this.htE = aVar;
    }

    public final <T extends a> T ap(Class<T> cls) {
        boolean z;
        T t;
        AppMethodBeat.i(157485);
        c cVar = this.htD.get(cls);
        if (cls.isInterface() || !Modifier.isAbstract(cls.getModifiers())) {
            z = false;
        } else {
            Log.w("MicroMsg.ServiceHub", "Did you call service by using the service implementation class ?? Use interface class instead!! Carl is warning u!");
            z = true;
        }
        if (cVar != null) {
            t = (T) cVar.aBe();
        } else {
            Log.e("MicroMsg.ServiceHub", "Service(%s) not found!!! ", cls);
            if (z) {
                Log.e("MicroMsg.ServiceHub", "This error must cause by using implementation class to call service! Use interface instead! Understand?");
            }
            t = null;
        }
        if (this.htE != null) {
            this.htE.a(cls, t);
        }
        AppMethodBeat.o(157485);
        return t;
    }

    public final <T extends a, N extends T> void b(Class<T> cls, N n) {
        AppMethodBeat.i(157486);
        c(cls, new e(n));
        AppMethodBeat.o(157486);
    }

    public final <T extends a, N extends T> void c(Class<T> cls, c<N> cVar) {
        AppMethodBeat.i(157487);
        this.htD.put(cls, cVar);
        if (cVar instanceof b) {
            ((b) cVar).aBc();
        }
        if (this.htE != null) {
            this.htE.a(cls, cVar);
        }
        Log.i("MicroMsg.ServiceHub", "register service %s %s", cls, cVar);
        AppMethodBeat.o(157487);
    }

    public final void ag(Class<? extends a> cls) {
        AppMethodBeat.i(157488);
        c remove = this.htD.remove(cls);
        if (remove instanceof b) {
            ((b) remove).aBd();
        }
        if (this.htE != null) {
            this.htE.b(cls, remove);
        }
        AppMethodBeat.o(157488);
    }
}
