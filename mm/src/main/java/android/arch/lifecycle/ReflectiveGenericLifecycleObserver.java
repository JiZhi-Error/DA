package android.arch.lifecycle;

import android.arch.lifecycle.ClassesInfoCache;
import android.arch.lifecycle.Lifecycle;

/* access modifiers changed from: package-private */
public class ReflectiveGenericLifecycleObserver implements GenericLifecycleObserver {
    private final Object dm;
    private final ClassesInfoCache.CallbackInfo dn = ClassesInfoCache.cb.c(this.dm.getClass());

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.dm = obj;
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        ClassesInfoCache.CallbackInfo callbackInfo = this.dn;
        Object obj = this.dm;
        ClassesInfoCache.CallbackInfo.a(callbackInfo.ce.get(event), lifecycleOwner, event, obj);
        ClassesInfoCache.CallbackInfo.a(callbackInfo.ce.get(Lifecycle.Event.ON_ANY), lifecycleOwner, event, obj);
    }
}
