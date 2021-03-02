package com.tencent.mm.sdk.event;

import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.b.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class IListener<T extends IEvent> {
    protected int __eventId;
    private b<IListener> mCallbackProperty;
    private final int priority;

    public abstract boolean callback(T t);

    public IListener() {
        this(0);
    }

    public IListener(int i2) {
        this.__eventId = 0;
        this.priority = i2;
    }

    /* access modifiers changed from: package-private */
    public int getPriority() {
        return this.priority;
    }

    /* access modifiers changed from: package-private */
    public int __getEventID() {
        if (this.__eventId == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            Type genericSuperclass = getClass().getGenericSuperclass();
            if (!(genericSuperclass instanceof ParameterizedType)) {
                genericSuperclass = getClass().getSuperclass().getGenericSuperclass();
            }
            Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
            this.__eventId = ((Class) type).getName().hashCode();
            Log.v("IListener", "genEventID, %s<%s>, useTime:%d", getClass().getName(), type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        return this.__eventId;
    }

    public synchronized b<IListener> alive() {
        if (this.mCallbackProperty == null) {
            ListenerInstanceMonitor.markInstanceRegistered(this);
            this.mCallbackProperty = EventCenter.instance.add(this);
        }
        return this.mCallbackProperty;
    }

    public synchronized void dead() {
        if (this.mCallbackProperty != null) {
            ListenerInstanceMonitor.markInstanceUnregistered(this.mCallbackProperty.QZG);
            this.mCallbackProperty.dead();
            this.mCallbackProperty = null;
        }
    }
}
