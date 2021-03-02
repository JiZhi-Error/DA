package com.tencent.thumbplayer.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class e {
    private static CopyOnWriteArrayList<a> Sfj = new CopyOnWriteArrayList<>();

    public interface a {
        void d(int i2, int i3, int i4, Object obj);
    }

    static {
        AppMethodBeat.i(189633);
        AppMethodBeat.o(189633);
    }

    public static synchronized void a(a aVar) {
        synchronized (e.class) {
            AppMethodBeat.i(189630);
            if (Sfj != null && !Sfj.contains(aVar)) {
                Sfj.add(aVar);
                g.i("TPGlobalEventNofication", "add onNetStatus change listener: " + aVar + ", mListeners: " + Sfj.size());
            }
            AppMethodBeat.o(189630);
        }
    }

    public static synchronized void b(a aVar) {
        synchronized (e.class) {
            AppMethodBeat.i(189631);
            if (Sfj != null) {
                Sfj.remove(aVar);
                g.i("TPGlobalEventNofication", "remove netStatusChangeListener, listener: " + aVar + ", mListeners: " + Sfj.size());
            }
            AppMethodBeat.o(189631);
        }
    }

    public static synchronized void g(int i2, int i3, int i4, Object obj) {
        synchronized (e.class) {
            AppMethodBeat.i(189632);
            Iterator<a> it = Sfj.iterator();
            while (it.hasNext()) {
                it.next().d(i2, i3, i4, obj);
            }
            AppMethodBeat.o(189632);
        }
    }
}
