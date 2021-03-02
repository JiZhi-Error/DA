package com.tencent.mm.vending.b;

import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.h.f;
import com.tencent.mm.vending.h.g;
import java.util.LinkedList;
import junit.framework.Assert;

public abstract class a<_Callback> {
    private LinkedList<b> mQueue;
    protected d mScheduler;
    protected f mSchedulerInvoker;

    public a() {
        this(g.current());
    }

    public a(String str) {
        this(g.boH(str));
    }

    public a(d dVar) {
        this.mQueue = new LinkedList<>();
        Assert.assertNotNull(dVar);
        this.mScheduler = dVar;
        this.mSchedulerInvoker = new f(dVar, null);
    }

    /* access modifiers changed from: protected */
    public synchronized b add(b bVar) {
        if (bVar == null) {
            bVar = null;
        } else {
            this.mQueue.add(bVar);
        }
        return bVar;
    }

    /* access modifiers changed from: protected */
    public synchronized void remove(b bVar) {
        if (bVar != null) {
            this.mQueue.remove(bVar);
        }
    }

    public synchronized LinkedList<b> getQueue() {
        return getQueueImpl();
    }

    /* access modifiers changed from: protected */
    public LinkedList<b> getQueueImpl() {
        return new LinkedList<>(this.mQueue);
    }

    public synchronized int size() {
        return this.mQueue.size();
    }

    public synchronized boolean contains(_Callback _callback) {
        return this.mQueue.contains(new b(_callback, this));
    }
}
