package com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.BitmapDescriptorFactory;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.MarkerManager;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.a.b;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.a.c;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.a.e;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.Cluster;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterItem;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.Algorithm;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.NonHierarchicalDistanceBasedAlgorithm;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.PreCachingAlgorithmDecorator;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.ui.IconGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DefaultClusterRenderer<T extends ClusterItem> implements ClusterRenderer<T> {

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f2890b = (Build.VERSION.SDK_INT >= 11);

    /* renamed from: g  reason: collision with root package name */
    private static volatile boolean f2891g = false;
    private static final TimeInterpolator z = new DecelerateInterpolator();

    /* renamed from: a  reason: collision with root package name */
    protected double f2892a;

    /* renamed from: c  reason: collision with root package name */
    private final TencentMap f2893c;

    /* renamed from: d  reason: collision with root package name */
    private final IconGenerator f2894d;

    /* renamed from: e  reason: collision with root package name */
    private final ClusterManager<T> f2895e;

    /* renamed from: f  reason: collision with root package name */
    private final float f2896f;

    /* renamed from: h  reason: collision with root package name */
    private int[] f2897h = {10, 20, 50, 100, 200, 500, 1000};

    /* renamed from: i  reason: collision with root package name */
    private ShapeDrawable f2898i;

    /* renamed from: j  reason: collision with root package name */
    private Set<MarkerWithPosition> f2899j = Collections.newSetFromMap(new ConcurrentHashMap());
    private SparseArray<BitmapDescriptor> k = new SparseArray<>();
    private MarkerCache<T> l = new MarkerCache<>();
    private int m = 4;
    private Set<? extends Cluster<T>> n;
    private boolean o = true;
    private Map<Marker, Cluster<T>> p = new HashMap();
    private Map<Cluster<T>, Marker> q = new HashMap();
    private float r;
    private final DefaultClusterRenderer<T>.ViewModifier s = new ViewModifier();
    private ClusterManager.OnClusterClickListener<T> t;
    private ClusterManager.OnClusterInfoWindowClickListener<T> u;
    private ClusterManager.ClusterInfoWindowAdapter<T> v;
    private ClusterManager.OnClusterItemClickListener<T> w;
    private ClusterManager.OnClusterItemInfoWindowClickListener<T> x;
    private ClusterManager.ClusterItemInfoWindowAdapter<T> y;

    static /* synthetic */ b a(List list, b bVar, double d2) {
        AppMethodBeat.i(199599);
        b b2 = b(list, bVar, d2);
        AppMethodBeat.o(199599);
        return b2;
    }

    static {
        AppMethodBeat.i(199600);
        AppMethodBeat.o(199600);
    }

    public DefaultClusterRenderer(Context context, TencentMap tencentMap, ClusterManager<T> clusterManager) {
        Algorithm algorithm;
        AppMethodBeat.i(199581);
        this.f2893c = tencentMap;
        this.f2896f = context.getResources().getDisplayMetrics().density;
        this.f2894d = new IconGenerator(context);
        this.f2894d.setContentView(a(context));
        this.f2894d.setTextAppearance(16973886, -1118482, 16.0f, 1);
        this.f2894d.setBackground(d());
        this.f2895e = clusterManager;
        if (clusterManager.getAlgorithm() instanceof PreCachingAlgorithmDecorator) {
            algorithm = ((PreCachingAlgorithmDecorator) clusterManager.getAlgorithm()).getAlgorithm();
        } else {
            algorithm = clusterManager.getAlgorithm();
        }
        if (algorithm instanceof NonHierarchicalDistanceBasedAlgorithm) {
            this.f2892a = (((double) ((NonHierarchicalDistanceBasedAlgorithm) algorithm).getMaxDistanceAtZoom()) + 0.5d) * ((double) this.f2896f);
            AppMethodBeat.o(199581);
            return;
        }
        this.f2892a = (double) (35.0f * this.f2896f);
        AppMethodBeat.o(199581);
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.ClusterRenderer
    public void onAdd() {
        AppMethodBeat.i(199582);
        this.f2895e.getMarkerCollection().a(new TencentMap.OnMarkerClickListener() {
            /* class com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.DefaultClusterRenderer.AnonymousClass1 */

            /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager$OnClusterItemClickListener */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener
            public boolean onMarkerClick(Marker marker) {
                AppMethodBeat.i(199603);
                ClusterItem clusterItem = (ClusterItem) DefaultClusterRenderer.this.l.get(marker);
                if (DefaultClusterRenderer.this.w == null || clusterItem == null || !DefaultClusterRenderer.this.w.onClusterItemClick(clusterItem)) {
                    AppMethodBeat.o(199603);
                    return false;
                }
                AppMethodBeat.o(199603);
                return true;
            }
        });
        this.f2895e.getMarkerCollection().a(new TencentMap.OnInfoWindowClickListener() {
            /* class com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.DefaultClusterRenderer.AnonymousClass2 */

            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager$OnClusterItemInfoWindowClickListener */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener
            public void onInfoWindowClick(Marker marker) {
                AppMethodBeat.i(199614);
                if (DefaultClusterRenderer.this.x != null) {
                    DefaultClusterRenderer.this.x.onClusterItemInfoWindowClick((ClusterItem) DefaultClusterRenderer.this.l.get(marker));
                }
                AppMethodBeat.o(199614);
            }
        });
        this.f2895e.getMarkerCollection().a(new TencentMap.InfoWindowAdapter() {
            /* class com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.DefaultClusterRenderer.AnonymousClass3 */

            /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager$ClusterItemInfoWindowAdapter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter
            public View getInfoWindow(Marker marker) {
                AppMethodBeat.i(199606);
                ClusterItem clusterItem = (ClusterItem) DefaultClusterRenderer.this.l.get(marker);
                if (DefaultClusterRenderer.this.y == null || clusterItem == null) {
                    AppMethodBeat.o(199606);
                    return null;
                }
                View infoWindow = DefaultClusterRenderer.this.y.getInfoWindow(clusterItem);
                AppMethodBeat.o(199606);
                return infoWindow;
            }

            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter
            public void onInfoWindowDettached(Marker marker, View view) {
            }
        });
        this.f2895e.getClusterMarkerCollection().a(new TencentMap.OnMarkerClickListener() {
            /* class com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.DefaultClusterRenderer.AnonymousClass4 */

            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener
            public boolean onMarkerClick(Marker marker) {
                AppMethodBeat.i(199612);
                Cluster<T> cluster = (Cluster) DefaultClusterRenderer.this.p.get(marker);
                if (DefaultClusterRenderer.this.t == null || cluster == null || !DefaultClusterRenderer.this.t.onClusterClick(cluster)) {
                    AppMethodBeat.o(199612);
                    return false;
                }
                AppMethodBeat.o(199612);
                return true;
            }
        });
        this.f2895e.getClusterMarkerCollection().a(new TencentMap.OnInfoWindowClickListener() {
            /* class com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.DefaultClusterRenderer.AnonymousClass5 */

            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener
            public void onInfoWindowClick(Marker marker) {
                AppMethodBeat.i(199602);
                if (DefaultClusterRenderer.this.u != null) {
                    DefaultClusterRenderer.this.u.onClusterInfoWindowClick((Cluster) DefaultClusterRenderer.this.p.get(marker));
                }
                AppMethodBeat.o(199602);
            }
        });
        this.f2895e.getClusterMarkerCollection().a(new TencentMap.InfoWindowAdapter() {
            /* class com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.DefaultClusterRenderer.AnonymousClass6 */

            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter
            public View getInfoWindow(Marker marker) {
                AppMethodBeat.i(199613);
                Cluster<T> cluster = (Cluster) DefaultClusterRenderer.this.p.get(marker);
                if (DefaultClusterRenderer.this.v == null || cluster == null) {
                    AppMethodBeat.o(199613);
                    return null;
                }
                View infoWindow = DefaultClusterRenderer.this.v.getInfoWindow(cluster);
                AppMethodBeat.o(199613);
                return infoWindow;
            }

            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter
            public void onInfoWindowDettached(Marker marker, View view) {
            }
        });
        AppMethodBeat.o(199582);
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.ClusterRenderer
    public void onRemove() {
        AppMethodBeat.i(199583);
        this.f2895e.getMarkerCollection().a((TencentMap.OnMarkerClickListener) null);
        this.f2895e.getClusterMarkerCollection().a((TencentMap.OnMarkerClickListener) null);
        AppMethodBeat.o(199583);
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.ClusterRenderer
    public void cancel() {
        AppMethodBeat.i(199584);
        f2891g = true;
        onRemove();
        AppMethodBeat.o(199584);
    }

    private LayerDrawable d() {
        AppMethodBeat.i(199585);
        this.f2898i = new ShapeDrawable(new OvalShape());
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(-2130706433);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable, this.f2898i});
        int i2 = (int) (this.f2896f * 3.0f);
        layerDrawable.setLayerInset(1, i2, i2, i2, i2);
        AppMethodBeat.o(199585);
        return layerDrawable;
    }

    private e a(Context context) {
        AppMethodBeat.i(199586);
        e eVar = new e(context);
        eVar.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        eVar.setId(IconGenerator.SQUARE_TEXT_VIEW_ID);
        int i2 = (int) (12.0f * this.f2896f);
        eVar.setPadding(i2, i2, i2, i2);
        AppMethodBeat.o(199586);
        return eVar;
    }

    public int getColor(int i2) {
        AppMethodBeat.i(199587);
        float min = Math.min((float) i2, 300.0f);
        int HSVToColor = Color.HSVToColor(new float[]{(((300.0f - min) * (300.0f - min)) / 90000.0f) * 220.0f, 1.0f, 0.6f});
        AppMethodBeat.o(199587);
        return HSVToColor;
    }

    /* access modifiers changed from: protected */
    public String a(int i2) {
        AppMethodBeat.i(199588);
        if (this.f2897h == null) {
            String valueOf = String.valueOf(i2);
            AppMethodBeat.o(199588);
            return valueOf;
        } else if (i2 < this.f2897h[0]) {
            String valueOf2 = String.valueOf(i2);
            AppMethodBeat.o(199588);
            return valueOf2;
        } else {
            String str = String.valueOf(i2) + "+";
            AppMethodBeat.o(199588);
            return str;
        }
    }

    public int getBucket(Cluster<T> cluster) {
        AppMethodBeat.i(199589);
        int size = cluster.getSize();
        if (this.f2897h == null) {
            AppMethodBeat.o(199589);
            return size;
        } else if (size <= this.f2897h[0]) {
            AppMethodBeat.o(199589);
            return size;
        } else {
            for (int i2 = 0; i2 < this.f2897h.length - 1; i2++) {
                if (size < this.f2897h[i2 + 1]) {
                    int i3 = this.f2897h[i2];
                    AppMethodBeat.o(199589);
                    return i3;
                }
            }
            int i4 = this.f2897h[this.f2897h.length - 1];
            AppMethodBeat.o(199589);
            return i4;
        }
    }

    public void setBuckets(int[] iArr) {
        this.f2897h = iArr;
    }

    public int[] getBuckets() {
        return this.f2897h;
    }

    public int getMinClusterSize() {
        return this.m;
    }

    public void setMinClusterSize(int i2) {
        AppMethodBeat.i(199590);
        this.m = i2;
        if (this.f2895e != null) {
            this.o = true;
            this.f2895e.cluster();
        }
        AppMethodBeat.o(199590);
    }

    @SuppressLint({"HandlerLeak"})
    class ViewModifier extends Handler {

        /* renamed from: b  reason: collision with root package name */
        private boolean f2938b;

        /* renamed from: c  reason: collision with root package name */
        private DefaultClusterRenderer<T>.RenderTask f2939c;

        private ViewModifier() {
            this.f2938b = false;
            this.f2939c = null;
        }

        public void handleMessage(Message message) {
            DefaultClusterRenderer<T>.RenderTask renderTask;
            AppMethodBeat.i(199579);
            if (message.what == 1) {
                this.f2938b = false;
                if (this.f2939c != null) {
                    sendEmptyMessage(0);
                }
                AppMethodBeat.o(199579);
                return;
            }
            removeMessages(0);
            if (this.f2938b) {
                AppMethodBeat.o(199579);
            } else if (this.f2939c == null) {
                AppMethodBeat.o(199579);
            } else {
                Projection projection = DefaultClusterRenderer.this.f2893c.getProjection();
                if (projection == null) {
                    AppMethodBeat.o(199579);
                    return;
                }
                synchronized (this) {
                    try {
                        renderTask = this.f2939c;
                        this.f2939c = null;
                        this.f2938b = true;
                    } catch (Throwable th) {
                        AppMethodBeat.o(199579);
                        throw th;
                    }
                }
                renderTask.setCallback(new Runnable() {
                    /* class com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.DefaultClusterRenderer.ViewModifier.AnonymousClass1 */

                    public void run() {
                        AppMethodBeat.i(199601);
                        ViewModifier.this.sendEmptyMessage(1);
                        AppMethodBeat.o(199601);
                    }
                });
                renderTask.setProjection(projection);
                try {
                    renderTask.setMapZoom(DefaultClusterRenderer.this.f2893c.getCameraPosition().getZoom());
                    new Thread(renderTask).start();
                    AppMethodBeat.o(199579);
                } catch (NullPointerException e2) {
                    boolean unused = DefaultClusterRenderer.f2891g;
                    AppMethodBeat.o(199579);
                }
            }
        }

        public void queue(Set<? extends Cluster<T>> set) {
            AppMethodBeat.i(199580);
            synchronized (this) {
                try {
                    this.f2939c = new RenderTask(set, DefaultClusterRenderer.this.f2892a);
                } catch (Throwable th) {
                    AppMethodBeat.o(199580);
                    throw th;
                }
            }
            sendEmptyMessage(0);
            AppMethodBeat.o(199580);
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(Cluster<T> cluster) {
        AppMethodBeat.i(199591);
        if (cluster.getSize() > this.m) {
            AppMethodBeat.o(199591);
            return true;
        }
        AppMethodBeat.o(199591);
        return false;
    }

    /* access modifiers changed from: package-private */
    public class RenderTask implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final Set<? extends Cluster<T>> f2930a;

        /* renamed from: c  reason: collision with root package name */
        private Runnable f2932c;

        /* renamed from: d  reason: collision with root package name */
        private Projection f2933d;

        /* renamed from: e  reason: collision with root package name */
        private c f2934e;

        /* renamed from: f  reason: collision with root package name */
        private float f2935f;

        /* renamed from: g  reason: collision with root package name */
        private double f2936g;

        private RenderTask(Set<? extends Cluster<T>> set, double d2) {
            this.f2930a = set;
            this.f2936g = d2;
        }

        public void setCallback(Runnable runnable) {
            this.f2932c = runnable;
        }

        public void setProjection(Projection projection) {
            this.f2933d = projection;
        }

        public void setMapZoom(float f2) {
            AppMethodBeat.i(199604);
            this.f2935f = f2;
            this.f2934e = new c(256.0d * Math.pow(2.0d, (double) (Math.min(f2, DefaultClusterRenderer.this.r) - 1.0f)));
            AppMethodBeat.o(199604);
        }

        @SuppressLint({"NewApi"})
        public void run() {
            ArrayList arrayList;
            ArrayList arrayList2;
            Marker marker;
            AppMethodBeat.i(199605);
            if (!this.f2930a.equals(DefaultClusterRenderer.this.n) || DefaultClusterRenderer.this.o) {
                if (DefaultClusterRenderer.this.o) {
                    DefaultClusterRenderer.this.o = false;
                }
                MarkerModifier markerModifier = new MarkerModifier();
                float f2 = this.f2935f;
                boolean z = f2 > DefaultClusterRenderer.this.r;
                float f3 = f2 - DefaultClusterRenderer.this.r;
                Set<MarkerWithPosition> set = DefaultClusterRenderer.this.f2899j;
                LatLngBounds latLngBounds = this.f2933d.getVisibleRegion().getLatLngBounds();
                if (DefaultClusterRenderer.this.n == null || !DefaultClusterRenderer.f2890b) {
                    arrayList = null;
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    for (Cluster<T> cluster : DefaultClusterRenderer.this.n) {
                        if (DefaultClusterRenderer.this.a(cluster) && latLngBounds.contains(cluster.getPosition())) {
                            arrayList3.add(this.f2934e.a(cluster.getPosition()));
                        }
                    }
                    arrayList = arrayList3;
                }
                Set newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
                Iterator<? extends Cluster<T>> it = this.f2930a.iterator();
                while (it.hasNext()) {
                    Cluster<T> cluster2 = (Cluster) it.next();
                    if (DefaultClusterRenderer.this.n == null || !DefaultClusterRenderer.this.n.contains(cluster2) || !DefaultClusterRenderer.this.a(cluster2) || (marker = (Marker) DefaultClusterRenderer.this.q.get(cluster2)) == null) {
                        boolean contains = latLngBounds.contains(cluster2.getPosition());
                        if (!z || !contains || !DefaultClusterRenderer.f2890b) {
                            markerModifier.add(contains, new CreateMarkerTask(cluster2, newSetFromMap, null));
                        } else {
                            b a2 = DefaultClusterRenderer.a(arrayList, this.f2934e.a(cluster2.getPosition()), this.f2936g);
                            if (a2 != null) {
                                markerModifier.add(true, new CreateMarkerTask(cluster2, newSetFromMap, this.f2934e.a(a2)));
                            } else {
                                markerModifier.add(true, new CreateMarkerTask(cluster2, newSetFromMap, null));
                            }
                        }
                    } else {
                        newSetFromMap.add(new MarkerWithPosition(marker));
                    }
                }
                markerModifier.waitUntilFree();
                set.removeAll(newSetFromMap);
                if (DefaultClusterRenderer.f2890b) {
                    arrayList2 = new ArrayList();
                    Iterator<? extends Cluster<T>> it2 = this.f2930a.iterator();
                    while (it2.hasNext()) {
                        Cluster<T> cluster3 = (Cluster) it2.next();
                        if (DefaultClusterRenderer.this.a(cluster3) && latLngBounds.contains(cluster3.getPosition())) {
                            arrayList2.add(this.f2934e.a(cluster3.getPosition()));
                        }
                    }
                } else {
                    arrayList2 = null;
                }
                for (MarkerWithPosition markerWithPosition : set) {
                    boolean contains2 = latLngBounds.contains(markerWithPosition.f2929b);
                    if (z || f3 <= -3.0f || !contains2 || !DefaultClusterRenderer.f2890b) {
                        markerModifier.remove(contains2, markerWithPosition.f2928a);
                    } else {
                        b a3 = DefaultClusterRenderer.a(arrayList2, this.f2934e.a(markerWithPosition.f2929b), this.f2936g);
                        if (a3 != null) {
                            markerModifier.animateThenRemove(markerWithPosition, markerWithPosition.f2929b, this.f2934e.a(a3));
                        } else {
                            markerModifier.remove(true, markerWithPosition.f2928a);
                        }
                    }
                }
                markerModifier.waitUntilFree();
                DefaultClusterRenderer.this.f2899j = newSetFromMap;
                DefaultClusterRenderer.this.n = this.f2930a;
                DefaultClusterRenderer.this.r = f2;
                this.f2932c.run();
                AppMethodBeat.o(199605);
                return;
            }
            this.f2932c.run();
            AppMethodBeat.o(199605);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.ClusterRenderer
    public void onClustersChanged(Set<? extends Cluster<T>> set) {
        AppMethodBeat.i(199592);
        this.s.queue(set);
        AppMethodBeat.o(199592);
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.ClusterRenderer
    public void setOnClusterClickListener(ClusterManager.OnClusterClickListener<T> onClusterClickListener) {
        this.t = onClusterClickListener;
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.ClusterRenderer
    public void setOnClusterInfoWindowClickListener(ClusterManager.OnClusterInfoWindowClickListener<T> onClusterInfoWindowClickListener) {
        this.u = onClusterInfoWindowClickListener;
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.ClusterRenderer
    public void setInfoWindowAdapter(ClusterManager.ClusterInfoWindowAdapter clusterInfoWindowAdapter) {
        this.v = clusterInfoWindowAdapter;
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.ClusterRenderer
    public void setOnClusterItemClickListener(ClusterManager.OnClusterItemClickListener<T> onClusterItemClickListener) {
        this.w = onClusterItemClickListener;
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.ClusterRenderer
    public void setOnClusterItemInfoWindowClickListener(ClusterManager.OnClusterItemInfoWindowClickListener<T> onClusterItemInfoWindowClickListener) {
        this.x = onClusterItemInfoWindowClickListener;
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.ClusterRenderer
    public void setItemInfoWindowAdapter(ClusterManager.ClusterItemInfoWindowAdapter clusterItemInfoWindowAdapter) {
        this.y = clusterItemInfoWindowAdapter;
    }

    private static double a(b bVar, b bVar2) {
        return ((bVar.f2832a - bVar2.f2832a) * (bVar.f2832a - bVar2.f2832a)) + ((bVar.f2833b - bVar2.f2833b) * (bVar.f2833b - bVar2.f2833b));
    }

    private static b b(List<b> list, b bVar, double d2) {
        b bVar2 = null;
        AppMethodBeat.i(199593);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(199593);
        } else {
            double d3 = d2 * d2;
            for (b bVar3 : list) {
                double a2 = a(bVar3, bVar);
                if (a2 >= d3) {
                    a2 = d3;
                    bVar3 = bVar2;
                }
                d3 = a2;
                bVar2 = bVar3;
            }
            AppMethodBeat.o(199593);
        }
        return bVar2;
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"HandlerLeak"})
    public class MarkerModifier extends Handler implements MessageQueue.IdleHandler {

        /* renamed from: b  reason: collision with root package name */
        private final Lock f2920b;

        /* renamed from: c  reason: collision with root package name */
        private final Condition f2921c;

        /* renamed from: d  reason: collision with root package name */
        private Queue<DefaultClusterRenderer<T>.CreateMarkerTask> f2922d;

        /* renamed from: e  reason: collision with root package name */
        private Queue<DefaultClusterRenderer<T>.CreateMarkerTask> f2923e;

        /* renamed from: f  reason: collision with root package name */
        private Queue<Marker> f2924f;

        /* renamed from: g  reason: collision with root package name */
        private Queue<Marker> f2925g;

        /* renamed from: h  reason: collision with root package name */
        private Queue<DefaultClusterRenderer<T>.AnimationTask> f2926h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f2927i;

        private MarkerModifier() {
            super(Looper.getMainLooper());
            AppMethodBeat.i(199563);
            this.f2920b = new ReentrantLock();
            this.f2921c = this.f2920b.newCondition();
            this.f2922d = new LinkedList();
            this.f2923e = new LinkedList();
            this.f2924f = new LinkedList();
            this.f2925g = new LinkedList();
            this.f2926h = new LinkedList();
            AppMethodBeat.o(199563);
        }

        public void add(boolean z, DefaultClusterRenderer<T>.CreateMarkerTask createMarkerTask) {
            AppMethodBeat.i(199564);
            this.f2920b.lock();
            sendEmptyMessage(0);
            if (z) {
                this.f2923e.add(createMarkerTask);
            } else {
                this.f2922d.add(createMarkerTask);
            }
            this.f2920b.unlock();
            AppMethodBeat.o(199564);
        }

        public void remove(boolean z, Marker marker) {
            AppMethodBeat.i(199565);
            this.f2920b.lock();
            sendEmptyMessage(0);
            if (z) {
                this.f2925g.add(marker);
            } else {
                this.f2924f.add(marker);
            }
            this.f2920b.unlock();
            AppMethodBeat.o(199565);
        }

        public void animate(MarkerWithPosition markerWithPosition, LatLng latLng, LatLng latLng2) {
            AppMethodBeat.i(199566);
            this.f2920b.lock();
            this.f2926h.add(new AnimationTask(markerWithPosition, latLng, latLng2));
            this.f2920b.unlock();
            AppMethodBeat.o(199566);
        }

        @TargetApi(11)
        public void animateThenRemove(MarkerWithPosition markerWithPosition, LatLng latLng, LatLng latLng2) {
            AppMethodBeat.i(199567);
            this.f2920b.lock();
            DefaultClusterRenderer<T>.AnimationTask animationTask = new AnimationTask(markerWithPosition, latLng, latLng2);
            animationTask.removeOnAnimationComplete(DefaultClusterRenderer.this.f2895e.getMarkerManager());
            this.f2926h.add(animationTask);
            this.f2920b.unlock();
            AppMethodBeat.o(199567);
        }

        public void handleMessage(Message message) {
            AppMethodBeat.i(199568);
            if (!this.f2927i) {
                Looper.myQueue().addIdleHandler(this);
                this.f2927i = true;
            }
            removeMessages(0);
            this.f2920b.lock();
            for (int i2 = 0; i2 < 10; i2++) {
                try {
                    a();
                } catch (Throwable th) {
                    this.f2920b.unlock();
                    AppMethodBeat.o(199568);
                    throw th;
                }
            }
            if (!isBusy()) {
                this.f2927i = false;
                Looper.myQueue().removeIdleHandler(this);
                this.f2921c.signalAll();
            } else {
                sendEmptyMessageDelayed(0, 10);
            }
            this.f2920b.unlock();
            AppMethodBeat.o(199568);
        }

        @TargetApi(11)
        private void a() {
            AppMethodBeat.i(199569);
            try {
                if (!this.f2925g.isEmpty()) {
                    a(this.f2925g.poll());
                    AppMethodBeat.o(199569);
                } else if (!this.f2926h.isEmpty()) {
                    this.f2926h.poll().perform();
                    AppMethodBeat.o(199569);
                } else if (!this.f2923e.isEmpty()) {
                    CreateMarkerTask.a(this.f2923e.poll(), this);
                    AppMethodBeat.o(199569);
                } else if (!this.f2922d.isEmpty()) {
                    CreateMarkerTask.a(this.f2922d.poll(), this);
                    AppMethodBeat.o(199569);
                } else {
                    if (!this.f2924f.isEmpty()) {
                        a(this.f2924f.poll());
                    }
                    AppMethodBeat.o(199569);
                }
            } catch (NullPointerException e2) {
                if (DefaultClusterRenderer.f2891g) {
                    cancel();
                }
                AppMethodBeat.o(199569);
            }
        }

        private void a(Marker marker) {
            AppMethodBeat.i(199570);
            DefaultClusterRenderer.this.q.remove((Cluster) DefaultClusterRenderer.this.p.get(marker));
            DefaultClusterRenderer.this.l.remove(marker);
            DefaultClusterRenderer.this.p.remove(marker);
            DefaultClusterRenderer.this.f2895e.getMarkerManager().a(marker);
            AppMethodBeat.o(199570);
        }

        public boolean isBusy() {
            AppMethodBeat.i(199571);
            try {
                this.f2920b.lock();
                return !this.f2922d.isEmpty() || !this.f2923e.isEmpty() || !this.f2925g.isEmpty() || !this.f2924f.isEmpty() || !this.f2926h.isEmpty();
            } finally {
                this.f2920b.unlock();
                AppMethodBeat.o(199571);
            }
        }

        public void waitUntilFree() {
            AppMethodBeat.i(199572);
            while (isBusy()) {
                sendEmptyMessage(0);
                this.f2920b.lock();
                try {
                    if (isBusy()) {
                        this.f2921c.await();
                    }
                    this.f2920b.unlock();
                } catch (InterruptedException e2) {
                    RuntimeException runtimeException = new RuntimeException(e2);
                    AppMethodBeat.o(199572);
                    throw runtimeException;
                } catch (Throwable th) {
                    this.f2920b.unlock();
                    AppMethodBeat.o(199572);
                    throw th;
                }
            }
            AppMethodBeat.o(199572);
        }

        public boolean queueIdle() {
            AppMethodBeat.i(199573);
            sendEmptyMessage(0);
            AppMethodBeat.o(199573);
            return true;
        }

        public void cancel() {
            AppMethodBeat.i(199574);
            this.f2923e.clear();
            this.f2926h.clear();
            this.f2922d.clear();
            this.f2925g.clear();
            this.f2924f.clear();
            AppMethodBeat.o(199574);
        }
    }

    /* access modifiers changed from: package-private */
    public static class MarkerCache<T> {

        /* renamed from: a  reason: collision with root package name */
        private Map<T, Marker> f2917a;

        /* renamed from: b  reason: collision with root package name */
        private Map<Marker, T> f2918b;

        private MarkerCache() {
            AppMethodBeat.i(199607);
            this.f2917a = new HashMap();
            this.f2918b = new HashMap();
            AppMethodBeat.o(199607);
        }

        public Marker get(T t) {
            AppMethodBeat.i(199608);
            Marker marker = this.f2917a.get(t);
            AppMethodBeat.o(199608);
            return marker;
        }

        public T get(Marker marker) {
            AppMethodBeat.i(199609);
            T t = this.f2918b.get(marker);
            AppMethodBeat.o(199609);
            return t;
        }

        public void put(T t, Marker marker) {
            AppMethodBeat.i(199610);
            this.f2917a.put(t, marker);
            this.f2918b.put(marker, t);
            AppMethodBeat.o(199610);
        }

        public void remove(Marker marker) {
            AppMethodBeat.i(199611);
            T t = this.f2918b.get(marker);
            this.f2918b.remove(marker);
            this.f2917a.remove(t);
            AppMethodBeat.o(199611);
        }
    }

    public void onBeforeClusterItemRendered(T t2, MarkerOptions markerOptions) {
    }

    public void onBeforeClusterRendered(Cluster<T> cluster, MarkerOptions markerOptions) {
        AppMethodBeat.i(199594);
        int bucket = getBucket(cluster);
        BitmapDescriptor bitmapDescriptor = this.k.get(bucket);
        if (bitmapDescriptor == null) {
            this.f2898i.getPaint().setColor(getColor(bucket));
            bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(this.f2894d.makeIcon(a(bucket)));
            this.k.put(bucket, bitmapDescriptor);
        }
        markerOptions.icon(bitmapDescriptor);
        AppMethodBeat.o(199594);
    }

    /* access modifiers changed from: protected */
    public void a(Cluster<T> cluster, Marker marker) {
    }

    /* access modifiers changed from: protected */
    public void a(T t2, Marker marker) {
    }

    public Marker getMarker(T t2) {
        AppMethodBeat.i(199595);
        Marker marker = this.l.get(t2);
        AppMethodBeat.o(199595);
        return marker;
    }

    public T getClusterItem(Marker marker) {
        AppMethodBeat.i(199596);
        T t2 = this.l.get(marker);
        AppMethodBeat.o(199596);
        return t2;
    }

    public Marker getMarker(Cluster<T> cluster) {
        AppMethodBeat.i(199597);
        Marker marker = this.q.get(cluster);
        AppMethodBeat.o(199597);
        return marker;
    }

    public Cluster<T> getCluster(Marker marker) {
        AppMethodBeat.i(199598);
        Cluster<T> cluster = this.p.get(marker);
        AppMethodBeat.o(199598);
        return cluster;
    }

    /* access modifiers changed from: package-private */
    public class CreateMarkerTask {

        /* renamed from: b  reason: collision with root package name */
        private final Cluster<T> f2914b;

        /* renamed from: c  reason: collision with root package name */
        private final Set<MarkerWithPosition> f2915c;

        /* renamed from: d  reason: collision with root package name */
        private final LatLng f2916d;

        static /* synthetic */ void a(CreateMarkerTask createMarkerTask, MarkerModifier markerModifier) {
            AppMethodBeat.i(199619);
            createMarkerTask.a(markerModifier);
            AppMethodBeat.o(199619);
        }

        public CreateMarkerTask(Cluster<T> cluster, Set<MarkerWithPosition> set, LatLng latLng) {
            this.f2914b = cluster;
            this.f2915c = set;
            this.f2916d = latLng;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.DefaultClusterRenderer */
        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.DefaultClusterRenderer */
        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.DefaultClusterRenderer */
        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.DefaultClusterRenderer */
        /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.DefaultClusterRenderer */
        /* JADX WARN: Multi-variable type inference failed */
        private void a(DefaultClusterRenderer<T>.MarkerModifier markerModifier) {
            MarkerWithPosition markerWithPosition;
            AppMethodBeat.i(199618);
            if (!DefaultClusterRenderer.this.a(this.f2914b)) {
                for (T t : this.f2914b.getItems()) {
                    Marker marker = DefaultClusterRenderer.this.l.get((Object) t);
                    if (marker == null) {
                        MarkerOptions anchor = new MarkerOptions().position(t.getPosition()).anchor(0.5f, 0.5f);
                        if (this.f2916d != null) {
                            anchor.position(this.f2916d);
                        }
                        DefaultClusterRenderer.this.onBeforeClusterItemRendered(t, anchor);
                        marker = DefaultClusterRenderer.this.f2895e.getMarkerCollection().a(anchor);
                        markerWithPosition = new MarkerWithPosition(marker);
                        DefaultClusterRenderer.this.l.put(t, marker);
                        if (this.f2916d != null) {
                            markerModifier.animate(markerWithPosition, this.f2916d, t.getPosition());
                        }
                    } else {
                        markerWithPosition = new MarkerWithPosition(marker);
                    }
                    DefaultClusterRenderer.this.a((ClusterItem) t, marker);
                    this.f2915c.add(markerWithPosition);
                }
                AppMethodBeat.o(199618);
                return;
            }
            MarkerOptions anchor2 = new MarkerOptions().position(this.f2916d == null ? this.f2914b.getPosition() : this.f2916d).anchor(0.5f, 0.5f);
            DefaultClusterRenderer.this.onBeforeClusterRendered(this.f2914b, anchor2);
            Marker a2 = DefaultClusterRenderer.this.f2895e.getClusterMarkerCollection().a(anchor2);
            DefaultClusterRenderer.this.p.put(a2, this.f2914b);
            DefaultClusterRenderer.this.q.put(this.f2914b, a2);
            MarkerWithPosition markerWithPosition2 = new MarkerWithPosition(a2);
            if (this.f2916d != null) {
                markerModifier.animate(markerWithPosition2, this.f2916d, this.f2914b.getPosition());
            }
            DefaultClusterRenderer.this.a(this.f2914b, a2);
            this.f2915c.add(markerWithPosition2);
            AppMethodBeat.o(199618);
        }
    }

    /* access modifiers changed from: package-private */
    public static class MarkerWithPosition {

        /* renamed from: a  reason: collision with root package name */
        private final Marker f2928a;

        /* renamed from: b  reason: collision with root package name */
        private LatLng f2929b;

        private MarkerWithPosition(Marker marker) {
            AppMethodBeat.i(199615);
            this.f2928a = marker;
            this.f2929b = marker.getPosition();
            AppMethodBeat.o(199615);
        }

        public boolean equals(Object obj) {
            AppMethodBeat.i(199616);
            if (obj instanceof MarkerWithPosition) {
                boolean equals = this.f2928a.equals(((MarkerWithPosition) obj).f2928a);
                AppMethodBeat.o(199616);
                return equals;
            }
            AppMethodBeat.o(199616);
            return false;
        }

        public int hashCode() {
            AppMethodBeat.i(199617);
            int hashCode = this.f2928a.hashCode();
            AppMethodBeat.o(199617);
            return hashCode;
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(12)
    public class AnimationTask extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        private final MarkerWithPosition f2907b;

        /* renamed from: c  reason: collision with root package name */
        private final Marker f2908c;

        /* renamed from: d  reason: collision with root package name */
        private final LatLng f2909d;

        /* renamed from: e  reason: collision with root package name */
        private final LatLng f2910e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f2911f;

        /* renamed from: g  reason: collision with root package name */
        private MarkerManager f2912g;

        private AnimationTask(MarkerWithPosition markerWithPosition, LatLng latLng, LatLng latLng2) {
            AppMethodBeat.i(199575);
            this.f2907b = markerWithPosition;
            this.f2908c = markerWithPosition.f2928a;
            this.f2909d = latLng;
            this.f2910e = latLng2;
            AppMethodBeat.o(199575);
        }

        public void perform() {
            AppMethodBeat.i(199576);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setInterpolator(DefaultClusterRenderer.z);
            ofFloat.addUpdateListener(this);
            ofFloat.addListener(this);
            ofFloat.start();
            AppMethodBeat.o(199576);
        }

        public void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(199577);
            if (this.f2911f) {
                DefaultClusterRenderer.this.q.remove((Cluster) DefaultClusterRenderer.this.p.get(this.f2908c));
                DefaultClusterRenderer.this.l.remove(this.f2908c);
                DefaultClusterRenderer.this.p.remove(this.f2908c);
                this.f2912g.a(this.f2908c);
            }
            this.f2907b.f2929b = this.f2910e;
            AppMethodBeat.o(199577);
        }

        public void removeOnAnimationComplete(MarkerManager markerManager) {
            this.f2912g = markerManager;
            this.f2911f = true;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(199578);
            float animatedFraction = valueAnimator.getAnimatedFraction();
            double latitude = this.f2909d.getLatitude() + ((this.f2910e.getLatitude() - this.f2909d.getLatitude()) * ((double) animatedFraction));
            double longitude = this.f2910e.getLongitude() - this.f2909d.getLongitude();
            if (Math.abs(longitude) > 180.0d) {
                longitude -= Math.signum(longitude) * 360.0d;
            }
            this.f2908c.setPosition(new LatLng(latitude, (longitude * ((double) animatedFraction)) + this.f2909d.getLongitude()));
            AppMethodBeat.o(199578);
        }
    }
}
