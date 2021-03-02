package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;

public class SingleGeneratedAdapterObserver implements GenericLifecycleObserver {
    private final GeneratedAdapter ds;

    SingleGeneratedAdapterObserver(GeneratedAdapter generatedAdapter) {
        this.ds = generatedAdapter;
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.ds.callMethods(lifecycleOwner, event, false, null);
        this.ds.callMethods(lifecycleOwner, event, true, null);
    }
}
