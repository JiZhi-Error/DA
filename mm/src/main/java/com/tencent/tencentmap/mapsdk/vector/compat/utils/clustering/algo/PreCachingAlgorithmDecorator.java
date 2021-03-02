package com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo;

import android.support.v4.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.Cluster;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterItem;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PreCachingAlgorithmDecorator<T extends ClusterItem> implements Algorithm<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Algorithm<T> f2883a;

    /* renamed from: b  reason: collision with root package name */
    private final h<Integer, Set<? extends Cluster<T>>> f2884b = new h<>(5);

    /* renamed from: c  reason: collision with root package name */
    private final ReadWriteLock f2885c = new ReentrantReadWriteLock();

    static /* synthetic */ Set a(PreCachingAlgorithmDecorator preCachingAlgorithmDecorator, int i2) {
        AppMethodBeat.i(199538);
        Set<? extends Cluster<T>> a2 = preCachingAlgorithmDecorator.a(i2);
        AppMethodBeat.o(199538);
        return a2;
    }

    public PreCachingAlgorithmDecorator(Algorithm<T> algorithm) {
        AppMethodBeat.i(199529);
        this.f2883a = algorithm;
        AppMethodBeat.o(199529);
    }

    public Algorithm getAlgorithm() {
        return this.f2883a;
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.Algorithm
    public void addItem(T t) {
        AppMethodBeat.i(199530);
        this.f2883a.addItem(t);
        a();
        AppMethodBeat.o(199530);
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.Algorithm
    public void addItems(Collection<T> collection) {
        AppMethodBeat.i(199531);
        this.f2883a.addItems(collection);
        a();
        AppMethodBeat.o(199531);
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.Algorithm
    public void clearItems() {
        AppMethodBeat.i(199532);
        this.f2883a.clearItems();
        a();
        AppMethodBeat.o(199532);
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.Algorithm
    public void removeItem(T t) {
        AppMethodBeat.i(199533);
        this.f2883a.removeItem(t);
        a();
        AppMethodBeat.o(199533);
    }

    private void a() {
        AppMethodBeat.i(199534);
        this.f2884b.evictAll();
        AppMethodBeat.o(199534);
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.Algorithm
    public Set<? extends Cluster<T>> getClusters(double d2) {
        AppMethodBeat.i(199535);
        int i2 = (int) d2;
        Set<? extends Cluster<T>> a2 = a(i2);
        if (this.f2884b.get(Integer.valueOf(i2 + 1)) == null) {
            new Thread(new PrecacheRunnable(i2 + 1)).start();
        }
        if (this.f2884b.get(Integer.valueOf(i2 - 1)) == null) {
            new Thread(new PrecacheRunnable(i2 - 1)).start();
        }
        AppMethodBeat.o(199535);
        return a2;
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.Algorithm
    public Collection<T> getItems() {
        AppMethodBeat.i(199536);
        Collection<T> items = this.f2883a.getItems();
        AppMethodBeat.o(199536);
        return items;
    }

    private Set<? extends Cluster<T>> a(int i2) {
        AppMethodBeat.i(199537);
        this.f2885c.readLock().lock();
        Set<? extends Cluster<T>> set = this.f2884b.get(Integer.valueOf(i2));
        this.f2885c.readLock().unlock();
        if (set == null) {
            this.f2885c.writeLock().lock();
            set = this.f2884b.get(Integer.valueOf(i2));
            if (set == null) {
                set = this.f2883a.getClusters((double) i2);
                this.f2884b.put(Integer.valueOf(i2), set);
            }
            this.f2885c.writeLock().unlock();
        }
        AppMethodBeat.o(199537);
        return set;
    }

    class PrecacheRunnable implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final int f2887b;

        public PrecacheRunnable(int i2) {
            this.f2887b = i2;
        }

        public void run() {
            AppMethodBeat.i(199539);
            try {
                Thread.sleep((long) ((Math.random() * 500.0d) + 500.0d));
            } catch (InterruptedException e2) {
            }
            PreCachingAlgorithmDecorator.a(PreCachingAlgorithmDecorator.this, this.f2887b);
            AppMethodBeat.o(199539);
        }
    }
}
