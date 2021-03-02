package android.arch.lifecycle;

import android.arch.a.a.a;
import android.arch.a.b.b;
import android.arch.lifecycle.Lifecycle;
import java.util.Iterator;
import java.util.Map;

public abstract class LiveData<T> {
    private static final Object cN = new Object();
    private final Object cM = new Object();
    private b<Observer<T>, LiveData<T>.ObserverWrapper> cO = new b<>();
    private int cP = 0;
    private volatile Object cQ = cN;
    int cR = -1;
    private boolean cS;
    private boolean cT;
    private final Runnable cU = new Runnable() {
        /* class android.arch.lifecycle.LiveData.AnonymousClass1 */

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: android.arch.lifecycle.LiveData */
        /* JADX WARN: Multi-variable type inference failed */
        public void run() {
            Object obj;
            synchronized (LiveData.this.cM) {
                obj = LiveData.this.cQ;
                LiveData.this.cQ = LiveData.cN;
            }
            LiveData.this.setValue(obj);
        }
    };
    private volatile Object mData = cN;

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: android.arch.lifecycle.Observer<T> */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(LiveData<T>.ObserverWrapper observerWrapper) {
        if (observerWrapper.mActive) {
            if (!observerWrapper.ac()) {
                observerWrapper.l(false);
            } else if (observerWrapper.cY < this.cR) {
                observerWrapper.cY = this.cR;
                observerWrapper.cX.onChanged(this.mData);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(LiveData<T>.ObserverWrapper observerWrapper) {
        if (this.cS) {
            this.cT = true;
            return;
        }
        this.cS = true;
        do {
            this.cT = false;
            if (observerWrapper == null) {
                b<K, V>.d V = this.cO.V();
                while (V.hasNext()) {
                    a((ObserverWrapper) ((Map.Entry) V.next()).getValue());
                    if (this.cT) {
                        break;
                    }
                }
            } else {
                a(observerWrapper);
                observerWrapper = null;
            }
        } while (this.cT);
        this.cS = false;
    }

    public void observe(LifecycleOwner lifecycleOwner, Observer<T> observer) {
        if (lifecycleOwner.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(lifecycleOwner, observer);
            LiveData<T>.ObserverWrapper putIfAbsent = this.cO.putIfAbsent(observer, lifecycleBoundObserver);
            if (putIfAbsent != null && !putIfAbsent.c(lifecycleOwner)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (putIfAbsent == null) {
                lifecycleOwner.getLifecycle().addObserver(lifecycleBoundObserver);
            }
        }
    }

    public void observeForever(Observer<T> observer) {
        AlwaysActiveObserver alwaysActiveObserver = new AlwaysActiveObserver(observer);
        LiveData<T>.ObserverWrapper putIfAbsent = this.cO.putIfAbsent(observer, alwaysActiveObserver);
        if (putIfAbsent != null && (putIfAbsent instanceof LifecycleBoundObserver)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (putIfAbsent == null) {
            alwaysActiveObserver.l(true);
        }
    }

    public void removeObserver(Observer<T> observer) {
        h("removeObserver");
        LiveData<T>.ObserverWrapper remove = this.cO.remove(observer);
        if (remove != null) {
            remove.ae();
            remove.l(false);
        }
    }

    public void removeObservers(LifecycleOwner lifecycleOwner) {
        h("removeObservers");
        Iterator<Map.Entry<Observer<T>, LiveData<T>.ObserverWrapper>> it = this.cO.iterator();
        while (it.hasNext()) {
            Map.Entry<Observer<T>, LiveData<T>.ObserverWrapper> next = it.next();
            if (next.getValue().c(lifecycleOwner)) {
                removeObserver(next.getKey());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void postValue(T t) {
        boolean z;
        synchronized (this.cM) {
            z = this.cQ == cN;
            this.cQ = t;
        }
        if (z) {
            a.S().postToMainThread(this.cU);
        }
    }

    /* access modifiers changed from: protected */
    public void setValue(T t) {
        h("setValue");
        this.cR++;
        this.mData = t;
        b((LiveData<T>.ObserverWrapper) null);
    }

    public T getValue() {
        T t = (T) this.mData;
        if (t != cN) {
            return t;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onActive() {
    }

    /* access modifiers changed from: protected */
    public void Z() {
    }

    public boolean hasObservers() {
        return this.cO.mSize > 0;
    }

    public boolean hasActiveObservers() {
        return this.cP > 0;
    }

    class LifecycleBoundObserver extends LiveData<T>.ObserverWrapper implements GenericLifecycleObserver {
        final LifecycleOwner cW;

        LifecycleBoundObserver(LifecycleOwner lifecycleOwner, Observer<T> observer) {
            super(observer);
            this.cW = lifecycleOwner;
        }

        /* access modifiers changed from: package-private */
        @Override // android.arch.lifecycle.LiveData.ObserverWrapper
        public final boolean ac() {
            return this.cW.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
        }

        @Override // android.arch.lifecycle.GenericLifecycleObserver
        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (this.cW.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
                LiveData.this.removeObserver(this.cX);
            } else {
                l(ac());
            }
        }

        /* access modifiers changed from: package-private */
        @Override // android.arch.lifecycle.LiveData.ObserverWrapper
        public final boolean c(LifecycleOwner lifecycleOwner) {
            return this.cW == lifecycleOwner;
        }

        /* access modifiers changed from: package-private */
        @Override // android.arch.lifecycle.LiveData.ObserverWrapper
        public final void ae() {
            this.cW.getLifecycle().removeObserver(this);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract class ObserverWrapper {
        final Observer<T> cX;
        int cY = -1;
        boolean mActive;

        /* access modifiers changed from: package-private */
        public abstract boolean ac();

        ObserverWrapper(Observer<T> observer) {
            this.cX = observer;
        }

        /* access modifiers changed from: package-private */
        public boolean c(LifecycleOwner lifecycleOwner) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void ae() {
        }

        /* access modifiers changed from: package-private */
        public final void l(boolean z) {
            int i2 = 1;
            if (z != this.mActive) {
                this.mActive = z;
                boolean z2 = LiveData.this.cP == 0;
                LiveData liveData = LiveData.this;
                int i3 = liveData.cP;
                if (!this.mActive) {
                    i2 = -1;
                }
                liveData.cP = i2 + i3;
                if (z2 && this.mActive) {
                    LiveData.this.onActive();
                }
                if (LiveData.this.cP == 0 && !this.mActive) {
                    LiveData.this.Z();
                }
                if (this.mActive) {
                    LiveData.this.b((LiveData) this);
                }
            }
        }
    }

    class AlwaysActiveObserver extends LiveData<T>.ObserverWrapper {
        AlwaysActiveObserver(Observer<T> observer) {
            super(observer);
        }

        /* access modifiers changed from: package-private */
        @Override // android.arch.lifecycle.LiveData.ObserverWrapper
        public final boolean ac() {
            return true;
        }
    }

    private static void h(String str) {
        if (!a.S().bK.isMainThread()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
        }
    }
}
