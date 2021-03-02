package android.arch.b;

import android.arch.b.g;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class d<Key, Value> {
    AtomicBoolean cj = new AtomicBoolean(false);
    CopyOnWriteArrayList<b> dW = new CopyOnWriteArrayList<>();

    public static abstract class a<Key, Value> {
        public abstract d<Key, Value> ar();
    }

    public interface b {
    }

    d() {
    }

    static class c<T> {
        private final g.a<T> dU;
        final int dX;
        private final d dY;
        final Object dZ = new Object();
        Executor ea = null;
        private boolean eb = false;

        c(d dVar, g.a<T> aVar) {
            this.dY = dVar;
            this.dX = 0;
            this.ea = null;
            this.dU = aVar;
        }
    }
}
