package com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo;

import android.content.Context;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.a.a;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.a.b;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.a.c;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.a.d;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.Cluster;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class NonHierarchicalDistanceBasedAlgorithm<T extends ClusterItem> implements Algorithm<T> {

    /* renamed from: f  reason: collision with root package name */
    private static final c f2873f = new c(1.0d);

    /* renamed from: a  reason: collision with root package name */
    private Context f2874a;

    /* renamed from: b  reason: collision with root package name */
    private int f2875b = 35;

    /* renamed from: c  reason: collision with root package name */
    private int f2876c;

    /* renamed from: d  reason: collision with root package name */
    private final Collection<QuadItem<T>> f2877d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final d<QuadItem<T>> f2878e = new d<>(0.0d, 1.0d, 0.0d, 1.0d);

    static {
        AppMethodBeat.i(199517);
        AppMethodBeat.o(199517);
    }

    public NonHierarchicalDistanceBasedAlgorithm(Context context) {
        AppMethodBeat.i(199508);
        this.f2874a = context.getApplicationContext();
        this.f2876c = (int) ((this.f2874a.getResources().getDisplayMetrics().density * ((float) this.f2875b)) + 0.5f);
        AppMethodBeat.o(199508);
    }

    public int getMaxDistanceAtZoom() {
        return this.f2875b;
    }

    public void setMaxDistanceAtZoom(int i2) {
        AppMethodBeat.i(199509);
        this.f2875b = i2;
        this.f2876c = (int) ((this.f2874a.getResources().getDisplayMetrics().density * ((float) this.f2875b)) + 0.5f);
        AppMethodBeat.o(199509);
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.Algorithm
    public void addItem(T t) {
        AppMethodBeat.i(199510);
        QuadItem<T> quadItem = new QuadItem<>(t);
        synchronized (this.f2878e) {
            try {
                this.f2877d.add(quadItem);
                this.f2878e.a(quadItem);
            } finally {
                AppMethodBeat.o(199510);
            }
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.Algorithm
    public void addItems(Collection<T> collection) {
        AppMethodBeat.i(199511);
        for (T t : collection) {
            addItem(t);
        }
        AppMethodBeat.o(199511);
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.Algorithm
    public void clearItems() {
        AppMethodBeat.i(199512);
        synchronized (this.f2878e) {
            try {
                this.f2877d.clear();
                this.f2878e.a();
            } finally {
                AppMethodBeat.o(199512);
            }
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.Algorithm
    public void removeItem(T t) {
        AppMethodBeat.i(199513);
        QuadItem<T> quadItem = new QuadItem<>(t);
        synchronized (this.f2878e) {
            try {
                this.f2877d.remove(quadItem);
                this.f2878e.b(quadItem);
            } finally {
                AppMethodBeat.o(199513);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r16v0, resolved type: com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.StaticCluster */
    /* JADX DEBUG: Multi-variable search result rejected for r6v10, resolved type: com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.StaticCluster */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.Algorithm
    public Set<? extends Cluster<T>> getClusters(double d2) {
        AppMethodBeat.i(199514);
        double pow = (((double) this.f2876c) / Math.pow(2.0d, (double) (((int) d2) + 1))) / 256.0d;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        synchronized (this.f2878e) {
            try {
                for (QuadItem<T> quadItem : this.f2877d) {
                    if (!hashSet.contains(quadItem)) {
                        Collection<QuadItem<T>> a2 = this.f2878e.a(a(quadItem.getPoint(), pow));
                        if (a2.size() == 1) {
                            hashSet2.add(quadItem);
                            hashSet.add(quadItem);
                            hashMap.put(quadItem, Double.valueOf(0.0d));
                        } else {
                            StaticCluster staticCluster = new StaticCluster(((QuadItem) quadItem).f2879a.getPosition());
                            hashSet2.add(staticCluster);
                            for (QuadItem<T> quadItem2 : a2) {
                                Double d3 = (Double) hashMap.get(quadItem2);
                                double a3 = a(quadItem2.getPoint(), quadItem.getPoint());
                                if (d3 != null) {
                                    if (d3.doubleValue() >= a3) {
                                        ((StaticCluster) hashMap2.get(quadItem2)).remove(((QuadItem) quadItem2).f2879a);
                                    }
                                }
                                hashMap.put(quadItem2, Double.valueOf(a3));
                                staticCluster.add(((QuadItem) quadItem2).f2879a);
                                hashMap2.put(quadItem2, staticCluster);
                            }
                            hashSet.addAll(a2);
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(199514);
            }
        }
        return hashSet2;
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.Algorithm
    public Collection<T> getItems() {
        AppMethodBeat.i(199515);
        ArrayList arrayList = new ArrayList();
        synchronized (this.f2878e) {
            try {
                for (QuadItem<T> quadItem : this.f2877d) {
                    arrayList.add(((QuadItem) quadItem).f2879a);
                }
            } finally {
                AppMethodBeat.o(199515);
            }
        }
        return arrayList;
    }

    private double a(b bVar, b bVar2) {
        return ((bVar.f2832a - bVar2.f2832a) * (bVar.f2832a - bVar2.f2832a)) + ((bVar.f2833b - bVar2.f2833b) * (bVar.f2833b - bVar2.f2833b));
    }

    private a a(b bVar, double d2) {
        AppMethodBeat.i(199516);
        double d3 = d2 / 2.0d;
        a aVar = new a(bVar.f2832a - d3, bVar.f2832a + d3, bVar.f2833b - d3, d3 + bVar.f2833b);
        AppMethodBeat.o(199516);
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public static class QuadItem<T extends ClusterItem> implements d.a, Cluster<T> {

        /* renamed from: a  reason: collision with root package name */
        private final T f2879a;

        /* renamed from: b  reason: collision with root package name */
        private final b f2880b;

        /* renamed from: c  reason: collision with root package name */
        private final LatLng f2881c;

        /* renamed from: d  reason: collision with root package name */
        private Set<T> f2882d;

        private QuadItem(T t) {
            AppMethodBeat.i(199518);
            this.f2879a = t;
            this.f2881c = t.getPosition();
            this.f2880b = NonHierarchicalDistanceBasedAlgorithm.f2873f.a(this.f2881c);
            this.f2882d = Collections.singleton(this.f2879a);
            AppMethodBeat.o(199518);
        }

        @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.a.d.a
        public b getPoint() {
            return this.f2880b;
        }

        @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.Cluster
        public LatLng getPosition() {
            return this.f2881c;
        }

        @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.Cluster
        public Set<T> getItems() {
            return this.f2882d;
        }

        @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.Cluster
        public int getSize() {
            return 1;
        }

        public int hashCode() {
            AppMethodBeat.i(199519);
            int hashCode = this.f2879a.hashCode();
            AppMethodBeat.o(199519);
            return hashCode;
        }

        public boolean equals(Object obj) {
            AppMethodBeat.i(199520);
            if (!(obj instanceof QuadItem)) {
                AppMethodBeat.o(199520);
                return false;
            }
            boolean equals = ((QuadItem) obj).f2879a.equals(this.f2879a);
            AppMethodBeat.o(199520);
            return equals;
        }
    }
}
