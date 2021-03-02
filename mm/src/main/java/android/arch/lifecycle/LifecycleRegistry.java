package android.arch.lifecycle;

import android.arch.a.b.a;
import android.arch.a.b.b;
import android.arch.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

public class LifecycleRegistry extends Lifecycle {
    private a<LifecycleObserver, ObserverWithState> cA = new a<>();
    private Lifecycle.State cB;
    private final WeakReference<LifecycleOwner> cC;
    private int cD = 0;
    private boolean cE = false;
    private boolean cF = false;
    private ArrayList<Lifecycle.State> cG = new ArrayList<>();

    public LifecycleRegistry(LifecycleOwner lifecycleOwner) {
        this.cC = new WeakReference<>(lifecycleOwner);
        this.cB = Lifecycle.State.INITIALIZED;
    }

    public void markState(Lifecycle.State state) {
        a(state);
    }

    public void handleLifecycleEvent(Lifecycle.Event event) {
        a(b(event));
    }

    private void a(Lifecycle.State state) {
        if (this.cB != state) {
            this.cB = state;
            if (this.cE || this.cD != 0) {
                this.cF = true;
                return;
            }
            this.cE = true;
            sync();
            this.cE = false;
        }
    }

    private boolean X() {
        if (this.cA.mSize == 0) {
            return true;
        }
        Lifecycle.State state = this.cA.bQ.getValue().cB;
        Lifecycle.State state2 = this.cA.bR.getValue().cB;
        if (state == state2 && this.cB == state2) {
            return true;
        }
        return false;
    }

    private Lifecycle.State a(LifecycleObserver lifecycleObserver) {
        b.c<K, V> cVar;
        Lifecycle.State state;
        a<LifecycleObserver, ObserverWithState> aVar = this.cA;
        if (aVar.contains(lifecycleObserver)) {
            cVar = aVar.bP.get(lifecycleObserver).bV;
        } else {
            cVar = null;
        }
        Lifecycle.State state2 = cVar != null ? cVar.getValue().cB : null;
        if (!this.cG.isEmpty()) {
            state = this.cG.get(this.cG.size() - 1);
        } else {
            state = null;
        }
        return a(a(this.cB, state2), state);
    }

    @Override // android.arch.lifecycle.Lifecycle
    public void addObserver(LifecycleObserver lifecycleObserver) {
        LifecycleOwner lifecycleOwner;
        ObserverWithState observerWithState = new ObserverWithState(lifecycleObserver, this.cB == Lifecycle.State.DESTROYED ? Lifecycle.State.DESTROYED : Lifecycle.State.INITIALIZED);
        if (this.cA.putIfAbsent(lifecycleObserver, observerWithState) == null && (lifecycleOwner = this.cC.get()) != null) {
            boolean z = this.cD != 0 || this.cE;
            Lifecycle.State a2 = a(lifecycleObserver);
            this.cD++;
            while (observerWithState.cB.compareTo((Enum) a2) < 0 && this.cA.contains(lifecycleObserver)) {
                b(observerWithState.cB);
                observerWithState.a(lifecycleOwner, c(observerWithState.cB));
                Y();
                a2 = a(lifecycleObserver);
            }
            if (!z) {
                sync();
            }
            this.cD--;
        }
    }

    private void Y() {
        this.cG.remove(this.cG.size() - 1);
    }

    private void b(Lifecycle.State state) {
        this.cG.add(state);
    }

    @Override // android.arch.lifecycle.Lifecycle
    public void removeObserver(LifecycleObserver lifecycleObserver) {
        this.cA.remove(lifecycleObserver);
    }

    public int getObserverCount() {
        return this.cA.mSize;
    }

    @Override // android.arch.lifecycle.Lifecycle
    public Lifecycle.State getCurrentState() {
        return this.cB;
    }

    static Lifecycle.State b(Lifecycle.Event event) {
        switch (event) {
            case ON_CREATE:
            case ON_STOP:
                return Lifecycle.State.CREATED;
            case ON_START:
            case ON_PAUSE:
                return Lifecycle.State.STARTED;
            case ON_RESUME:
                return Lifecycle.State.RESUMED;
            case ON_DESTROY:
                return Lifecycle.State.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value ".concat(String.valueOf(event)));
        }
    }

    private static Lifecycle.Event c(Lifecycle.State state) {
        switch (state) {
            case INITIALIZED:
            case DESTROYED:
                return Lifecycle.Event.ON_CREATE;
            case CREATED:
                return Lifecycle.Event.ON_START;
            case STARTED:
                return Lifecycle.Event.ON_RESUME;
            case RESUMED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value ".concat(String.valueOf(state)));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: android.arch.a.b.a<android.arch.lifecycle.LifecycleObserver, android.arch.lifecycle.LifecycleRegistry$ObserverWithState> */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(LifecycleOwner lifecycleOwner) {
        b<K, V>.d V = this.cA.V();
        while (V.hasNext() && !this.cF) {
            Map.Entry entry = (Map.Entry) V.next();
            ObserverWithState observerWithState = (ObserverWithState) entry.getValue();
            while (observerWithState.cB.compareTo((Enum) this.cB) < 0 && !this.cF && this.cA.contains(entry.getKey())) {
                b(observerWithState.cB);
                observerWithState.a(lifecycleOwner, c(observerWithState.cB));
                Y();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: android.arch.a.b.a<android.arch.lifecycle.LifecycleObserver, android.arch.lifecycle.LifecycleRegistry$ObserverWithState> */
    /* JADX WARN: Multi-variable type inference failed */
    private void b(LifecycleOwner lifecycleOwner) {
        Lifecycle.Event event;
        a<LifecycleObserver, ObserverWithState> aVar = this.cA;
        b.C0001b bVar = new b.C0001b(aVar.bR, aVar.bQ);
        aVar.bS.put(bVar, Boolean.FALSE);
        while (bVar.hasNext() && !this.cF) {
            Map.Entry entry = (Map.Entry) bVar.next();
            ObserverWithState observerWithState = (ObserverWithState) entry.getValue();
            while (observerWithState.cB.compareTo((Enum) this.cB) > 0 && !this.cF && this.cA.contains(entry.getKey())) {
                Lifecycle.State state = observerWithState.cB;
                switch (state) {
                    case INITIALIZED:
                        throw new IllegalArgumentException();
                    case CREATED:
                        event = Lifecycle.Event.ON_DESTROY;
                        break;
                    case STARTED:
                        event = Lifecycle.Event.ON_STOP;
                        break;
                    case RESUMED:
                        event = Lifecycle.Event.ON_PAUSE;
                        break;
                    case DESTROYED:
                        throw new IllegalArgumentException();
                    default:
                        throw new IllegalArgumentException("Unexpected state value ".concat(String.valueOf(state)));
                }
                b(b(event));
                observerWithState.a(lifecycleOwner, event);
                Y();
            }
        }
    }

    private void sync() {
        LifecycleOwner lifecycleOwner = this.cC.get();
        if (lifecycleOwner != null) {
            while (!X()) {
                this.cF = false;
                if (this.cB.compareTo((Enum) this.cA.bQ.getValue().cB) < 0) {
                    b(lifecycleOwner);
                }
                b.c<K, V> cVar = this.cA.bR;
                if (!this.cF && cVar != null && this.cB.compareTo((Enum) cVar.getValue().cB) > 0) {
                    a(lifecycleOwner);
                }
            }
            this.cF = false;
        }
    }

    static Lifecycle.State a(Lifecycle.State state, Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    /* access modifiers changed from: package-private */
    public static class ObserverWithState {
        Lifecycle.State cB;
        GenericLifecycleObserver cI;

        ObserverWithState(LifecycleObserver lifecycleObserver, Lifecycle.State state) {
            this.cI = Lifecycling.e(lifecycleObserver);
            this.cB = state;
        }

        /* access modifiers changed from: package-private */
        public final void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Lifecycle.State b2 = LifecycleRegistry.b(event);
            this.cB = LifecycleRegistry.a(this.cB, b2);
            this.cI.onStateChanged(lifecycleOwner, event);
            this.cB = b2;
        }
    }
}
