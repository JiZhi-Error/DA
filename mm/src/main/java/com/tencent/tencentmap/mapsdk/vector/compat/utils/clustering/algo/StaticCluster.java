package com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.Cluster;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StaticCluster<T extends ClusterItem> implements Cluster<T> {

    /* renamed from: a  reason: collision with root package name */
    private final LatLng f2888a;

    /* renamed from: b  reason: collision with root package name */
    private final List<T> f2889b = new ArrayList();

    public StaticCluster(LatLng latLng) {
        AppMethodBeat.i(199502);
        this.f2888a = latLng;
        AppMethodBeat.o(199502);
    }

    public boolean add(T t) {
        AppMethodBeat.i(199503);
        boolean add = this.f2889b.add(t);
        AppMethodBeat.o(199503);
        return add;
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.Cluster
    public LatLng getPosition() {
        return this.f2888a;
    }

    public boolean remove(T t) {
        AppMethodBeat.i(199504);
        boolean remove = this.f2889b.remove(t);
        AppMethodBeat.o(199504);
        return remove;
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.Cluster
    public Collection<T> getItems() {
        return this.f2889b;
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.Cluster
    public int getSize() {
        AppMethodBeat.i(199505);
        int size = this.f2889b.size();
        AppMethodBeat.o(199505);
        return size;
    }

    public String toString() {
        AppMethodBeat.i(199506);
        String str = "StaticCluster{mCenter=" + this.f2888a + ", mItems.size=" + this.f2889b.size() + '}';
        AppMethodBeat.o(199506);
        return str;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(199507);
        if (!(obj instanceof StaticCluster)) {
            AppMethodBeat.o(199507);
            return false;
        } else if (!((StaticCluster) obj).f2888a.equals(this.f2888a) || !((StaticCluster) obj).f2889b.equals(this.f2889b)) {
            AppMethodBeat.o(199507);
            return false;
        } else {
            AppMethodBeat.o(199507);
            return true;
        }
    }
}
