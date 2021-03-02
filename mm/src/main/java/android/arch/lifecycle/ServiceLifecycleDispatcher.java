package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.os.Handler;

public class ServiceLifecycleDispatcher {
    private final LifecycleRegistry dh;
    private DispatchRunnable dp;
    private final Handler mHandler = new Handler();

    public ServiceLifecycleDispatcher(LifecycleOwner lifecycleOwner) {
        this.dh = new LifecycleRegistry(lifecycleOwner);
    }

    private void c(Lifecycle.Event event) {
        if (this.dp != null) {
            this.dp.run();
        }
        this.dp = new DispatchRunnable(this.dh, event);
        this.mHandler.postAtFrontOfQueue(this.dp);
    }

    public void onServicePreSuperOnCreate() {
        c(Lifecycle.Event.ON_CREATE);
    }

    public void onServicePreSuperOnBind() {
        c(Lifecycle.Event.ON_START);
    }

    public void onServicePreSuperOnStart() {
        c(Lifecycle.Event.ON_START);
    }

    public void onServicePreSuperOnDestroy() {
        c(Lifecycle.Event.ON_STOP);
        c(Lifecycle.Event.ON_DESTROY);
    }

    public Lifecycle getLifecycle() {
        return this.dh;
    }

    /* access modifiers changed from: package-private */
    public static class DispatchRunnable implements Runnable {
        private final LifecycleRegistry dh;
        final Lifecycle.Event dq;
        private boolean dr = false;

        DispatchRunnable(LifecycleRegistry lifecycleRegistry, Lifecycle.Event event) {
            this.dh = lifecycleRegistry;
            this.dq = event;
        }

        public void run() {
            if (!this.dr) {
                this.dh.handleLifecycleEvent(this.dq);
                this.dr = true;
            }
        }
    }
}
