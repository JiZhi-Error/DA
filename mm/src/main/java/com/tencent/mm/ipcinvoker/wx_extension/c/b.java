package com.tencent.mm.ipcinvoker.wx_extension.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b {
    private final List<C0357b<a>> hnN;
    private final List<Object> hnO;

    /* synthetic */ b(byte b2) {
        this();
    }

    public static final class a {
        private static b hnP = new b((byte) 0);

        static {
            AppMethodBeat.i(146425);
            AppMethodBeat.o(146425);
        }
    }

    private b() {
        AppMethodBeat.i(146427);
        this.hnN = new LinkedList();
        this.hnO = new LinkedList();
        AppMethodBeat.o(146427);
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(146428);
        if (c(aVar)) {
            AppMethodBeat.o(146428);
            return false;
        }
        synchronized (this.hnN) {
            try {
                this.hnN.add(new C0357b<>(aVar));
                ayp();
            } catch (Throwable th) {
                AppMethodBeat.o(146428);
                throw th;
            }
        }
        AppMethodBeat.o(146428);
        return true;
    }

    public final boolean b(a aVar) {
        boolean remove;
        AppMethodBeat.i(146429);
        if (aVar == null) {
            AppMethodBeat.o(146429);
            return false;
        }
        synchronized (this.hnN) {
            try {
                remove = this.hnN.remove(new C0357b(aVar));
                ayq();
            } finally {
                AppMethodBeat.o(146429);
            }
        }
        return remove;
    }

    public final boolean c(a aVar) {
        a aVar2;
        AppMethodBeat.i(146430);
        if (aVar == null) {
            AppMethodBeat.o(146430);
            return false;
        }
        synchronized (this.hnN) {
            try {
                for (C0357b<a> bVar : this.hnN) {
                    if (!(bVar == null || (aVar2 = (a) bVar.get()) == null || !aVar.equals(aVar2))) {
                        return true;
                    }
                }
                AppMethodBeat.o(146430);
                return false;
            } finally {
                AppMethodBeat.o(146430);
            }
        }
    }

    public final int size() {
        int size;
        AppMethodBeat.i(146431);
        synchronized (this.hnN) {
            try {
                size = this.hnN.size();
            } finally {
                AppMethodBeat.o(146431);
            }
        }
        return size;
    }

    private synchronized void ayp() {
        AppMethodBeat.i(146432);
        Iterator<Object> it = this.hnO.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(146432);
    }

    private synchronized void ayq() {
        AppMethodBeat.i(146433);
        Iterator<Object> it = this.hnO.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(146433);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.ipcinvoker.wx_extension.c.b$b  reason: collision with other inner class name */
    public static class C0357b<T> extends WeakReference<T> {
        public C0357b(T t) {
            super(t);
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(146426);
            if (obj == this) {
                AppMethodBeat.o(146426);
                return true;
            } else if (!(obj instanceof C0357b)) {
                AppMethodBeat.o(146426);
                return false;
            } else {
                Object obj2 = ((C0357b) obj).get();
                Object obj3 = get();
                if (obj2 == obj3 || (obj3 != null && obj3.equals(obj2))) {
                    AppMethodBeat.o(146426);
                    return true;
                }
                AppMethodBeat.o(146426);
                return false;
            }
        }
    }
}
