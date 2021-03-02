package com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.view.View;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.MarkerManager;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterItem;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.Algorithm;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.NonHierarchicalDistanceBasedAlgorithm;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.PreCachingAlgorithmDecorator;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.ClusterRenderer;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.DefaultClusterRenderer;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ClusterManager<T extends ClusterItem> implements TencentMap.InfoWindowAdapter, TencentMap.OnInfoWindowClickListener, TencentMap.OnMapCameraChangeListener, TencentMap.OnMarkerClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final MarkerManager f2858a;

    /* renamed from: b  reason: collision with root package name */
    private final MarkerManager.Collection f2859b;

    /* renamed from: c  reason: collision with root package name */
    private final MarkerManager.Collection f2860c;

    /* renamed from: d  reason: collision with root package name */
    private Algorithm<T> f2861d;

    /* renamed from: e  reason: collision with root package name */
    private final ReadWriteLock f2862e;

    /* renamed from: f  reason: collision with root package name */
    private ClusterRenderer<T> f2863f;

    /* renamed from: g  reason: collision with root package name */
    private TencentMap f2864g;

    /* renamed from: h  reason: collision with root package name */
    private CameraPosition f2865h;

    /* renamed from: i  reason: collision with root package name */
    private ClusterManager<T>.a f2866i;

    /* renamed from: j  reason: collision with root package name */
    private final ReadWriteLock f2867j;
    private boolean k;
    private OnClusterItemClickListener<T> l;
    private OnClusterInfoWindowClickListener<T> m;
    private ClusterInfoWindowAdapter<T> n;
    private OnClusterItemInfoWindowClickListener<T> o;
    private OnClusterClickListener<T> p;
    private ClusterItemInfoWindowAdapter<T> q;

    public interface ClusterInfoWindowAdapter<T extends ClusterItem> {
        View getInfoContents(Cluster<T> cluster);

        View getInfoWindow(Cluster<T> cluster);

        View getInfoWindowPressState(Cluster<T> cluster);
    }

    public interface ClusterItemInfoWindowAdapter<T extends ClusterItem> {
        View getInfoContents(T t);

        View getInfoWindow(T t);

        View getInfoWindowPressState(T t);
    }

    public interface OnClusterClickListener<T extends ClusterItem> {
        boolean onClusterClick(Cluster<T> cluster);
    }

    public interface OnClusterInfoWindowClickListener<T extends ClusterItem> {
        void onClusterInfoWindowClick(Cluster<T> cluster);
    }

    public interface OnClusterItemClickListener<T extends ClusterItem> {
        boolean onClusterItemClick(T t);
    }

    public interface OnClusterItemInfoWindowClickListener<T extends ClusterItem> {
        void onClusterItemInfoWindowClick(T t);
    }

    public ClusterManager(Context context, TencentMap tencentMap) {
        this(context, tencentMap, new MarkerManager(tencentMap));
        AppMethodBeat.i(199540);
        AppMethodBeat.o(199540);
    }

    private ClusterManager(Context context, TencentMap tencentMap, MarkerManager markerManager) {
        AppMethodBeat.i(199541);
        this.f2862e = new ReentrantReadWriteLock();
        this.f2867j = new ReentrantReadWriteLock();
        this.k = true;
        this.f2864g = tencentMap;
        this.f2858a = markerManager;
        this.f2860c = markerManager.a();
        this.f2859b = markerManager.a();
        this.f2863f = new DefaultClusterRenderer(context, tencentMap, this);
        this.f2861d = new PreCachingAlgorithmDecorator(new NonHierarchicalDistanceBasedAlgorithm(context));
        this.f2866i = new a();
        this.f2863f.onAdd();
        AppMethodBeat.o(199541);
    }

    public MarkerManager.Collection getMarkerCollection() {
        return this.f2859b;
    }

    public MarkerManager.Collection getClusterMarkerCollection() {
        return this.f2860c;
    }

    public MarkerManager getMarkerManager() {
        return this.f2858a;
    }

    public void setRenderer(ClusterRenderer<T> clusterRenderer) {
        AppMethodBeat.i(199542);
        this.f2863f.setOnClusterClickListener(null);
        this.f2863f.setOnClusterItemClickListener(null);
        this.f2860c.a();
        this.f2859b.a();
        this.f2863f.onRemove();
        this.f2863f = clusterRenderer;
        this.f2863f.onAdd();
        this.f2863f.setOnClusterClickListener(this.p);
        this.f2863f.setOnClusterInfoWindowClickListener(this.m);
        this.f2863f.setOnClusterItemClickListener(this.l);
        this.f2863f.setOnClusterItemInfoWindowClickListener(this.o);
        cluster();
        AppMethodBeat.o(199542);
    }

    public void setAlgorithm(Algorithm<T> algorithm) {
        AppMethodBeat.i(199543);
        this.f2862e.writeLock().lock();
        try {
            if (this.f2861d != null) {
                algorithm.addItems(this.f2861d.getItems());
            }
            this.f2861d = new PreCachingAlgorithmDecorator(algorithm);
            this.f2862e.writeLock().unlock();
            cluster();
            AppMethodBeat.o(199543);
        } catch (Throwable th) {
            this.f2862e.writeLock().unlock();
            AppMethodBeat.o(199543);
            throw th;
        }
    }

    public ClusterRenderer<T> getRenderer() {
        return this.f2863f;
    }

    public Algorithm<T> getAlgorithm() {
        return this.f2861d;
    }

    public void clearItems() {
        AppMethodBeat.i(199544);
        this.f2862e.writeLock().lock();
        try {
            this.f2861d.clearItems();
        } finally {
            this.f2862e.writeLock().unlock();
            AppMethodBeat.o(199544);
        }
    }

    public boolean isClusterEnabled() {
        return this.k;
    }

    public void setClusterEnabled(boolean z) {
        AppMethodBeat.i(199545);
        if (this.k ^ z) {
            this.k = z;
            cluster();
        }
        AppMethodBeat.o(199545);
    }

    public void addItems(Collection<T> collection) {
        AppMethodBeat.i(199546);
        this.f2862e.writeLock().lock();
        try {
            this.f2861d.addItems(collection);
        } finally {
            this.f2862e.writeLock().unlock();
            AppMethodBeat.o(199546);
        }
    }

    public void addItem(T t) {
        AppMethodBeat.i(199547);
        this.f2862e.writeLock().lock();
        try {
            this.f2861d.addItem(t);
        } finally {
            this.f2862e.writeLock().unlock();
            AppMethodBeat.o(199547);
        }
    }

    public void removeItem(T t) {
        AppMethodBeat.i(199548);
        this.f2862e.writeLock().lock();
        try {
            this.f2861d.removeItem(t);
        } finally {
            this.f2862e.writeLock().unlock();
            AppMethodBeat.o(199548);
        }
    }

    public void cluster() {
        AppMethodBeat.i(199549);
        this.f2867j.writeLock().lock();
        try {
            this.f2866i.cancel(true);
            this.f2866i = new a();
            if (Build.VERSION.SDK_INT < 11) {
                this.f2866i.execute(Float.valueOf(this.f2864g.getCameraPosition().getZoom()));
            } else {
                this.f2866i.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, Float.valueOf(this.f2864g.getCameraPosition().getZoom()));
            }
        } finally {
            this.f2867j.writeLock().unlock();
            AppMethodBeat.o(199549);
        }
    }

    public void cancel() {
        AppMethodBeat.i(199550);
        clearItems();
        if (!this.f2866i.cancel(true)) {
            this.f2863f.cancel();
        }
        AppMethodBeat.o(199550);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener
    public void onCameraChange(CameraPosition cameraPosition) {
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener
    public void onCameraChangeFinish(CameraPosition cameraPosition) {
        AppMethodBeat.i(199551);
        if (!this.k) {
            AppMethodBeat.o(199551);
            return;
        }
        if (this.f2863f instanceof TencentMap.OnMapCameraChangeListener) {
            ((TencentMap.OnMapCameraChangeListener) this.f2863f).onCameraChangeFinish(cameraPosition);
        }
        CameraPosition cameraPosition2 = this.f2864g.getCameraPosition();
        if (this.f2865h == null || this.f2865h.getZoom() != cameraPosition2.getZoom()) {
            this.f2865h = this.f2864g.getCameraPosition();
            cluster();
            AppMethodBeat.o(199551);
            return;
        }
        AppMethodBeat.o(199551);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        AppMethodBeat.i(199552);
        boolean onMarkerClick = getMarkerManager().onMarkerClick(marker);
        AppMethodBeat.o(199552);
        return onMarkerClick;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener
    public void onInfoWindowClick(Marker marker) {
        AppMethodBeat.i(199553);
        getMarkerManager().onInfoWindowClick(marker);
        AppMethodBeat.o(199553);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter
    public View getInfoWindow(Marker marker) {
        AppMethodBeat.i(199554);
        View infoWindow = getMarkerManager().getInfoWindow(marker);
        AppMethodBeat.o(199554);
        return infoWindow;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter
    public void onInfoWindowDettached(Marker marker, View view) {
    }

    /* access modifiers changed from: package-private */
    public class a extends AsyncTask<Float, Void, Set<? extends Cluster<T>>> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public /* synthetic */ Object doInBackground(Float[] fArr) {
            AppMethodBeat.i(199623);
            Set<? extends Cluster<T>> a2 = a(fArr);
            AppMethodBeat.o(199623);
            return a2;
        }

        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.i(199622);
            a((Set) obj);
            AppMethodBeat.o(199622);
        }

        /* access modifiers changed from: protected */
        public Set<? extends Cluster<T>> a(Float... fArr) {
            AppMethodBeat.i(199620);
            ClusterManager.this.f2862e.readLock().lock();
            try {
                if (!ClusterManager.this.k || fArr == null) {
                    HashSet hashSet = new HashSet();
                    for (T t : ClusterManager.this.f2861d.getItems()) {
                        hashSet.add(new b(t));
                    }
                    return hashSet;
                }
                Set<? extends Cluster<T>> clusters = ClusterManager.this.f2861d.getClusters((double) fArr[0].floatValue());
                ClusterManager.this.f2862e.readLock().unlock();
                AppMethodBeat.o(199620);
                return clusters;
            } finally {
                ClusterManager.this.f2862e.readLock().unlock();
                AppMethodBeat.o(199620);
            }
        }

        /* access modifiers changed from: protected */
        public void a(Set<? extends Cluster<T>> set) {
            AppMethodBeat.i(199621);
            ClusterManager.this.f2863f.onClustersChanged(set);
            AppMethodBeat.o(199621);
        }
    }

    public void setOnClusterClickListener(OnClusterClickListener<T> onClusterClickListener) {
        AppMethodBeat.i(199555);
        this.p = onClusterClickListener;
        this.f2863f.setOnClusterClickListener(onClusterClickListener);
        AppMethodBeat.o(199555);
    }

    public void setOnClusterInfoWindowClickListener(OnClusterInfoWindowClickListener<T> onClusterInfoWindowClickListener) {
        AppMethodBeat.i(199556);
        this.m = onClusterInfoWindowClickListener;
        this.f2863f.setOnClusterInfoWindowClickListener(onClusterInfoWindowClickListener);
        AppMethodBeat.o(199556);
    }

    public void setClusterInfoWindowAdapter(ClusterInfoWindowAdapter<T> clusterInfoWindowAdapter) {
        AppMethodBeat.i(199557);
        this.n = clusterInfoWindowAdapter;
        this.f2863f.setInfoWindowAdapter(clusterInfoWindowAdapter);
        AppMethodBeat.o(199557);
    }

    public void setOnClusterItemClickListener(OnClusterItemClickListener<T> onClusterItemClickListener) {
        AppMethodBeat.i(199558);
        this.l = onClusterItemClickListener;
        this.f2863f.setOnClusterItemClickListener(onClusterItemClickListener);
        AppMethodBeat.o(199558);
    }

    public void setOnClusterItemInfoWindowClickListener(OnClusterItemInfoWindowClickListener<T> onClusterItemInfoWindowClickListener) {
        AppMethodBeat.i(199559);
        this.o = onClusterItemInfoWindowClickListener;
        this.f2863f.setOnClusterItemInfoWindowClickListener(onClusterItemInfoWindowClickListener);
        AppMethodBeat.o(199559);
    }

    public void setClusterItemInfoWindowAdapter(ClusterItemInfoWindowAdapter<T> clusterItemInfoWindowAdapter) {
        AppMethodBeat.i(199560);
        this.q = clusterItemInfoWindowAdapter;
        this.f2863f.setItemInfoWindowAdapter(clusterItemInfoWindowAdapter);
        AppMethodBeat.o(199560);
    }

    /* access modifiers changed from: package-private */
    public class b implements Cluster<T> {

        /* renamed from: b  reason: collision with root package name */
        private T f2870b;

        /* renamed from: c  reason: collision with root package name */
        private Set<T> f2871c = Collections.singleton(this.f2870b);

        public b(T t) {
            AppMethodBeat.i(199561);
            this.f2870b = t;
            AppMethodBeat.o(199561);
        }

        @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.Cluster
        public LatLng getPosition() {
            AppMethodBeat.i(199562);
            LatLng position = this.f2870b.getPosition();
            AppMethodBeat.o(199562);
            return position;
        }

        @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.Cluster
        public Collection<T> getItems() {
            return this.f2871c;
        }

        @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.Cluster
        public int getSize() {
            return 1;
        }
    }
}
