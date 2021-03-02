package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;

class FullLifecycleObserverAdapter implements GenericLifecycleObserver {
    private final FullLifecycleObserver co;

    FullLifecycleObserverAdapter(FullLifecycleObserver fullLifecycleObserver) {
        this.co = fullLifecycleObserver;
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        switch (event) {
            case ON_CREATE:
                this.co.onCreate(lifecycleOwner);
                return;
            case ON_START:
                this.co.onStart(lifecycleOwner);
                return;
            case ON_RESUME:
                this.co.onResume(lifecycleOwner);
                return;
            case ON_PAUSE:
                this.co.onPause(lifecycleOwner);
                return;
            case ON_STOP:
                this.co.onStop(lifecycleOwner);
                return;
            case ON_DESTROY:
                this.co.onDestroy(lifecycleOwner);
                return;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
