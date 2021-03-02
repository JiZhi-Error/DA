package android.arch.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class LifecycleService extends Service implements LifecycleOwner {
    private final ServiceLifecycleDispatcher cJ = new ServiceLifecycleDispatcher(this);

    public void onCreate() {
        this.cJ.onServicePreSuperOnCreate();
        super.onCreate();
    }

    public IBinder onBind(Intent intent) {
        this.cJ.onServicePreSuperOnBind();
        return null;
    }

    public void onStart(Intent intent, int i2) {
        this.cJ.onServicePreSuperOnStart();
        super.onStart(intent, i2);
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        return super.onStartCommand(intent, i2, i3);
    }

    public void onDestroy() {
        this.cJ.onServicePreSuperOnDestroy();
        super.onDestroy();
    }

    @Override // android.arch.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.cJ.getLifecycle();
    }
}
