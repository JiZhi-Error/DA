package com.tencent.mm.sdk.storage;

import android.os.Looper;
import com.tencent.f.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public abstract class MStorageEvent<T, E> {
    private static final MMHandler sMainHandler = new MMHandler(Looper.getMainLooper());
    private final HashSet<E> events = new HashSet<>();
    private final Hashtable<T, Object> listeners = new Hashtable<>();
    private int locks = 0;

    /* access modifiers changed from: protected */
    public abstract void processEvent(T t, E e2);

    public void lock() {
        this.locks++;
    }

    public void unlock() {
        this.locks--;
        if (this.locks <= 0) {
            this.locks = 0;
            handleListeners();
        }
    }

    public boolean isLocked() {
        return this.locks > 0;
    }

    public int lockCount() {
        return this.locks;
    }

    public synchronized void add(T t, Looper looper) {
        if (!this.listeners.containsKey(t)) {
            if (looper != null) {
                this.listeners.put(t, new EventHandler(looper));
            } else {
                this.listeners.put(t, new Object());
            }
        }
    }

    public synchronized void add(T t, a aVar) {
        if (!this.listeners.containsKey(t)) {
            if (aVar != null) {
                this.listeners.put(t, new EventHandler(aVar));
            } else {
                this.listeners.put(t, new Object());
            }
        }
    }

    public synchronized void remove(T t) {
        this.listeners.remove(t);
    }

    public synchronized void removeAll() {
        this.listeners.clear();
    }

    private synchronized Vector<T> cloneAll() {
        Vector<T> vector;
        vector = new Vector<>();
        vector.addAll(this.listeners.keySet());
        return vector;
    }

    public boolean event(E e2) {
        boolean add;
        synchronized (this.events) {
            add = this.events.add(e2);
        }
        return add;
    }

    public void doNotify() {
        if (!isLocked()) {
            handleListeners();
        }
    }

    public void handleNotify(List<E> list) {
    }

    private void handleListeners() {
        ArrayList arrayList;
        Vector<T> cloneAll = cloneAll();
        if (cloneAll == null || cloneAll.size() <= 0) {
            this.events.clear();
            return;
        }
        synchronized (this.events) {
            arrayList = new ArrayList(this.events);
            this.events.clear();
        }
        handleNotify(arrayList);
        HashMap hashMap = new HashMap();
        Iterator<T> it = cloneAll.iterator();
        while (it.hasNext()) {
            final T next = it.next();
            Object obj = this.listeners.get(next);
            Iterator<E> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                final E next2 = it2.next();
                if (!(next2 == null || obj == null)) {
                    if (obj instanceof EventHandler) {
                        EventHandler eventHandler = (EventHandler) obj;
                        AnonymousClass1 r8 = new Runnable() {
                            /* class com.tencent.mm.sdk.storage.MStorageEvent.AnonymousClass1 */

                            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.tencent.mm.sdk.storage.MStorageEvent */
                            /* JADX WARN: Multi-variable type inference failed */
                            public void run() {
                                AppMethodBeat.i(158085);
                                MStorageEvent.this.processEvent(next, next2);
                                AppMethodBeat.o(158085);
                            }
                        };
                        if (eventHandler.serial != null) {
                            MMHandler mMHandler = (MMHandler) hashMap.get(eventHandler.serial);
                            if (mMHandler == null) {
                                mMHandler = new MMHandler(eventHandler.serial);
                                hashMap.put(eventHandler.serial, mMHandler);
                            }
                            mMHandler.post(r8);
                        } else if (eventHandler.looper != null) {
                            MMHandler mMHandler2 = (MMHandler) hashMap.get(eventHandler.looper);
                            if (mMHandler2 == null) {
                                mMHandler2 = new MMHandler(eventHandler.looper);
                                hashMap.put(eventHandler.looper, mMHandler2);
                            }
                            mMHandler2.post(r8);
                        } else {
                            sMainHandler.post(r8);
                        }
                    } else {
                        processEvent(next, next2);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public static class EventHandler {
        Looper looper;
        a serial;

        public EventHandler(a aVar) {
            this.serial = aVar;
        }

        public EventHandler(Looper looper2) {
            this.looper = looper2;
        }

        public EventHandler() {
        }
    }
}
