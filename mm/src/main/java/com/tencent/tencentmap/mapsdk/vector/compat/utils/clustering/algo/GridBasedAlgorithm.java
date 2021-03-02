package com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo;

import android.support.v4.e.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.a.b;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.a.c;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.Cluster;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterItem;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GridBasedAlgorithm<T extends ClusterItem> implements Algorithm<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Set<T> f2872a = Collections.synchronizedSet(new HashSet());

    public GridBasedAlgorithm() {
        AppMethodBeat.i(199522);
        AppMethodBeat.o(199522);
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.Algorithm
    public void addItem(T t) {
        AppMethodBeat.i(199523);
        this.f2872a.add(t);
        AppMethodBeat.o(199523);
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.Algorithm
    public void addItems(Collection<T> collection) {
        AppMethodBeat.i(199524);
        this.f2872a.addAll(collection);
        AppMethodBeat.o(199524);
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.Algorithm
    public void clearItems() {
        AppMethodBeat.i(199525);
        this.f2872a.clear();
        AppMethodBeat.o(199525);
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.Algorithm
    public void removeItem(T t) {
        AppMethodBeat.i(199526);
        this.f2872a.remove(t);
        AppMethodBeat.o(199526);
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.Algorithm
    public Set<? extends Cluster<T>> getClusters(double d2) {
        AppMethodBeat.i(199527);
        long ceil = (long) Math.ceil((256.0d * Math.pow(2.0d, d2)) / 100.0d);
        c cVar = new c((double) ceil);
        HashSet hashSet = new HashSet();
        g gVar = new g();
        synchronized (this.f2872a) {
            try {
                for (T t : this.f2872a) {
                    b a2 = cVar.a(t.getPosition());
                    long a3 = a(ceil, a2.f2832a, a2.f2833b);
                    StaticCluster staticCluster = (StaticCluster) gVar.get(a3, null);
                    if (staticCluster == null) {
                        staticCluster = new StaticCluster(cVar.a(new b(Math.floor(a2.f2832a) + 0.5d, Math.floor(a2.f2833b) + 0.5d)));
                        gVar.put(a3, staticCluster);
                        hashSet.add(staticCluster);
                    }
                    staticCluster.add(t);
                }
            } finally {
                AppMethodBeat.o(199527);
            }
        }
        return hashSet;
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.Algorithm
    public Collection<T> getItems() {
        return this.f2872a;
    }

    private static long a(long j2, double d2, double d3) {
        AppMethodBeat.i(199528);
        long floor = (long) ((((double) j2) * Math.floor(d2)) + Math.floor(d3));
        AppMethodBeat.o(199528);
        return floor;
    }
}
