package com.tencent.mm.plugin.wepkg.event;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class c {
    private static ConcurrentLinkedQueue<WeakReference<a>> JMO = new ConcurrentLinkedQueue<>();

    public interface a {
        void exp();
    }

    static {
        AppMethodBeat.i(110644);
        AppMethodBeat.o(110644);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(110640);
        JMO.add(new WeakReference<>(aVar));
        AppMethodBeat.o(110640);
    }

    public static void b(a aVar) {
        AppMethodBeat.i(110641);
        Iterator<WeakReference<a>> it = JMO.iterator();
        while (it.hasNext()) {
            WeakReference<a> next = it.next();
            if (next.get() == aVar) {
                JMO.remove(next);
            }
        }
        AppMethodBeat.o(110641);
    }

    public static void clear() {
        AppMethodBeat.i(110642);
        JMO.clear();
        AppMethodBeat.o(110642);
    }

    public static <T extends Parcelable> void a(T t, final a aVar) {
        AppMethodBeat.i(110643);
        if (MMApplicationContext.isMainProcess()) {
            Iterator<WeakReference<a>> it = JMO.iterator();
            while (it.hasNext()) {
                WeakReference<a> next = it.next();
                if (next.get() != null) {
                    next.get().dt(t);
                }
            }
        }
        ToolsProcessIPCService.a(t, b.class, new d() {
            /* class com.tencent.mm.plugin.wepkg.event.c.AnonymousClass1 */

            @Override // com.tencent.mm.ipcinvoker.d
            public final void bn(Object obj) {
                AppMethodBeat.i(110638);
                if (aVar != null) {
                    aVar.exp();
                }
                AppMethodBeat.o(110638);
            }
        });
        AppMethodBeat.o(110643);
    }

    static class b implements com.tencent.mm.ipcinvoker.b {
        private b() {
        }

        @Override // com.tencent.mm.ipcinvoker.b
        public void invoke(Object obj, d dVar) {
            AppMethodBeat.i(110639);
            Iterator it = c.JMO.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference.get() != null) {
                    ((a) weakReference.get()).dt(obj);
                }
            }
            dVar.bn(null);
            AppMethodBeat.o(110639);
        }
    }
}
