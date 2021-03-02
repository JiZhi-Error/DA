package com.tencent.mm.plugin.appbrand.jsapi.k.a;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.luggage.h.i;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.CustomLayer;
import com.tencent.mapsdk.raster.model.CustomLayerOptions;
import com.tencent.mapsdk.raster.model.IndoorBuilding;
import com.tencent.mapsdk.raster.model.IndoorInfo;
import com.tencent.mapsdk.raster.model.IndoorLevel;
import com.tencent.mapsdk.raster.model.IndoorMapPoi;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.MapPoi;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.OverlayLevel;
import com.tencent.mapsdk.raster.model.Polygon;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.k.ae;
import com.tencent.mm.plugin.appbrand.jsapi.k.k;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tencentmap.mapsdk.map.CameraUpdate;
import com.tencent.tencentmap.mapsdk.map.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlayOptions;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.animation.MarkerTranslateAnimator;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.Cluster;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterItem;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.NonHierarchicalDistanceBasedAlgorithm;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.PreCachingAlgorithmDecorator;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.DefaultClusterRenderer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a implements b {
    private static final String lYC = com.tencent.mm.plugin.appbrand.ac.b.eM("TencentMapSubKey", "E6FBZ-OLSCQ-UIU5C-GWLJ7-ABUPT-V7FJX");
    private static long lZa = 500;
    FrameLayout container;
    Context context;
    private ImageView dKU;
    private b.o lYA;
    private b.s lYB;
    private String lYD;
    private String lYE;
    private int lYF;
    private boolean lYG;
    private boolean lYH;
    private volatile HashMap<String, MarkerTranslateAnimator> lYI = new HashMap<>();
    private volatile HashMap<String, MarkerTranslateAnimator> lYJ = new HashMap<>();
    private volatile ClusterManager<f> lYK;
    private DefaultClusterRenderer<f> lYL;
    private boolean lYM = false;
    private boolean lYN = false;
    SurfaceView lYO;
    private Runnable lYP = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass42 */

        public final void run() {
            AppMethodBeat.i(146485);
            a.this.lYO.setVisibility(4);
            AppMethodBeat.o(146485);
        }
    };
    private b.m lYQ;
    private b.y lYR;
    private b.z lYS;
    private boolean lYT = false;
    private b.w lYU;
    private Runnable lYV;
    private b.x lYW;
    private b.f lYX;
    private Map<String, CustomLayer> lYY = new ConcurrentHashMap();
    private ArrayList<String> lYZ = new ArrayList<>();
    private String lYv;
    protected final SoSoMapView lYw;
    private boolean lYx;
    private b.l lYy;
    private b.p lYz;
    private HashMap<String, GroundOverlay> lZA = new HashMap<>();
    private Queue<Runnable> lZb = new LinkedList();
    private CancelableCallback lZc = new CancelableCallback() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass4 */

        @Override // com.tencent.tencentmap.mapsdk.map.CancelableCallback
        public final void onFinish() {
            AppMethodBeat.i(146462);
            a.this.lZb.poll();
            if (!a.this.lZb.isEmpty()) {
                ((Runnable) a.this.lZb.peek()).run();
            }
            AppMethodBeat.o(146462);
        }

        @Override // com.tencent.tencentmap.mapsdk.map.CancelableCallback
        public final void onCancel() {
            AppMethodBeat.i(146463);
            a.this.lZb.poll();
            if (!a.this.lZb.isEmpty()) {
                ((Runnable) a.this.lZb.peek()).run();
            }
            AppMethodBeat.o(146463);
        }
    };
    public ArrayList<Circle> lZd = new ArrayList<>();
    public ArrayList<b> lZe = new ArrayList<>();
    private Map<String, Polyline> lZf = new ConcurrentHashMap();
    private C0669a lZg = new C0669a();
    private Map<String, g> lZh = new ConcurrentHashMap();
    public ArrayList<c> lZi = new ArrayList<>();
    public ArrayList<Polygon> lZj = new ArrayList<>();
    private boolean lZk;
    private d lZl;
    private a.b lZm = new a.b() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass34 */

        @Override // com.tencent.mm.plugin.appbrand.utils.b.a.b
        public final void a(int i2, String str, final a.C0814a aVar) {
            AppMethodBeat.i(217212);
            if (i2 != 0) {
                Log.e("MicroMsg.DefaultTencentMapView", "errCode:%d, errStr:%s", Integer.valueOf(i2), str);
                AppMethodBeat.o(217212);
                return;
            }
            Log.d("MicroMsg.DefaultTencentMapView", "refresh location latitude = %f, longitude = %f", Double.valueOf(aVar.latitude), Double.valueOf(aVar.longitude));
            if (!a.bHl()) {
                Log.w("MicroMsg.DefaultTencentMapView", "refresh location fail, no perrmission");
                AppMethodBeat.o(217212);
            } else if (!a.this.lZk || a.this.lYx) {
                AppMethodBeat.o(217212);
            } else {
                m.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass34.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(217211);
                        if (a.this.lYw != null) {
                            if (a.this.lZl == null) {
                                a.this.lZl = new d(a.this.context);
                                d dVar = a.this.lZl;
                                SoSoMapView soSoMapView = a.this.lYw;
                                a.C0814a aVar = aVar;
                                MarkerOptions markerOptions = new MarkerOptions();
                                markerOptions.anchor(0.5f, 0.5f);
                                markerOptions.position(new LatLng(aVar.latitude, aVar.longitude));
                                markerOptions.markerView(dVar);
                                markerOptions.zIndex(Integer.MAX_VALUE);
                                markerOptions.flat(true);
                                markerOptions.tag("AnchorPoint");
                                dVar.maj = soSoMapView.getMap().addMarker(markerOptions);
                            }
                            d dVar2 = a.this.lZl;
                            double d2 = aVar.latitude;
                            double d3 = aVar.longitude;
                            String str = aVar.provider;
                            double d4 = aVar.dxQ;
                            if (dVar2.mbj == -1.0d && dVar2.mbk == -1.0d) {
                                dVar2.mbj = d2;
                                dVar2.mbh = d2;
                                dVar2.mbk = d3;
                                dVar2.mbi = d3;
                            } else {
                                dVar2.mbj = dVar2.mbh;
                                dVar2.mbk = dVar2.mbi;
                                dVar2.mbi = d3;
                                dVar2.mbh = d2;
                            }
                            if (!(dVar2.mbj == -1.0d || dVar2.mbk == -1.0d)) {
                                dVar2.mbo = f.a(dVar2.mbk, dVar2.mbj, d3, d2, str, d4);
                            }
                            if (dVar2.mbm == 900.0f || dVar2.mbl == 900.0f) {
                                float h2 = (float) f.h(d2, d3);
                                dVar2.mbl = h2;
                                dVar2.mbm = h2;
                            } else {
                                dVar2.mbm = dVar2.mbl;
                                dVar2.mbl = (float) f.h(d2, d3);
                            }
                            if (dVar2.maj != null) {
                                dVar2.maj.setPosition(new LatLng(d2, d3));
                            }
                        }
                        AppMethodBeat.o(217211);
                    }
                });
                AppMethodBeat.o(217212);
            }
        }
    };
    private final int lZn = 500;
    private AtomicBoolean lZo = new AtomicBoolean(false);
    private AtomicBoolean lZp = new AtomicBoolean(false);
    private b.q lZq;
    private ArrayList<f> lZr = new ArrayList<>();
    private ArrayList<String> lZs = new ArrayList<>();
    private ArrayList<Integer> lZt = new ArrayList<>();
    private AtomicInteger lZu = new AtomicInteger(100);
    private HashMap<Integer, Cluster<f>> lZv = new HashMap<>();
    private HashMap<String, b.v> lZw = new HashMap<>();
    private com.tencent.mm.plugin.appbrand.f.a lZx;
    boolean lZy;
    boolean lZz;
    private long lastCheckTime = 0;
    private int mMapType;

    public static class g extends b.u {
        public Marker maj;
        public Marker maq;
        public ImageView mar;
    }

    static /* synthetic */ void a(a aVar, Marker marker) {
        AppMethodBeat.i(217250);
        aVar.b(marker);
        AppMethodBeat.o(217250);
    }

    static /* synthetic */ void a(a aVar, String str, b.v vVar) {
        AppMethodBeat.i(217258);
        aVar.a(str, vVar, (g) null);
        AppMethodBeat.o(217258);
    }

    static /* synthetic */ CameraUpdate b(TencentMap tencentMap, float f2, float f3, float f4, double d2, double d3) {
        AppMethodBeat.i(217254);
        CameraUpdate a2 = a(tencentMap, f2, f3, f4, d2, d3);
        AppMethodBeat.o(217254);
        return a2;
    }

    static /* synthetic */ void b(float f2, float f3, Bitmap bitmap, ImageView imageView) {
        AppMethodBeat.i(217255);
        a(f2, f3, bitmap, imageView);
        AppMethodBeat.o(217255);
    }

    static /* synthetic */ b.f bHj() {
        AppMethodBeat.i(217253);
        b.f bGS = bGS();
        AppMethodBeat.o(217253);
        return bGS;
    }

    static {
        AppMethodBeat.i(146554);
        AppMethodBeat.o(146554);
    }

    public a(Context context2, String str, Map<String, Object> map) {
        AppMethodBeat.i(146490);
        this.context = context2;
        this.lYv = str;
        this.container = new FrameLayout(context2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.container.setBackgroundColor(0);
        this.container.setLayoutParams(layoutParams);
        this.lYw = new SoSoMapView(context2, P(map));
        this.container.addView(this.lYw, new FrameLayout.LayoutParams(-1, -1));
        this.dKU = new ImageView(context2);
        this.dKU.setScaleType(ImageView.ScaleType.FIT_XY);
        this.container.addView(this.dKU, new ViewGroup.LayoutParams(-1, -1));
        Log.i("MicroMsg.DefaultTencentMapView", "map:%s, init", this);
        this.lYw.getMap().setInfoWindowAdapter(this.lZg);
        this.lYw.getMap().setMapAnchor(0.5f, 0.5f);
        this.lYw.getMap().enableMultipleInfowindow(true);
        this.lYw.getMap().setMapStyle(this.lYF);
        this.lYw.getMap().setMapType(this.lYH ? 1008 : 1000);
        this.lYw.getMap().setHandDrawMapEnable(this.lYG);
        this.lYw.getMap().setOnInfoWindowClickListener(new TencentMap.OnInfoWindowClickListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass1 */

            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener
            public final void onInfoWindowClick(Marker marker) {
                AppMethodBeat.i(146458);
                if (marker == null) {
                    AppMethodBeat.o(146458);
                    return;
                }
                g ZU = a.this.ZU((String) marker.getTag());
                if (ZU == null) {
                    Log.e("MicroMsg.DefaultTencentMapView", "[onInfoWindowClick] map:%s appbrandMarker is null, return", this);
                    AppMethodBeat.o(146458);
                } else if (a.this.lYy == null) {
                    Log.e("MicroMsg.DefaultTencentMapView", "[onInfoWindowClick] map:%s mapCalloutClick is null, return", this);
                    AppMethodBeat.o(146458);
                } else {
                    a.this.lYy.a(ZU);
                    AppMethodBeat.o(146458);
                }
            }
        });
        this.lYw.getMap().setOnMarkerClickListener(new TencentMap.OnMarkerClickListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass9 */

            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener
            public final boolean onMarkerClick(Marker marker) {
                Marker marker2;
                AppMethodBeat.i(146468);
                if (marker == null) {
                    AppMethodBeat.o(146468);
                    return false;
                }
                Log.i("MicroMsg.DefaultTencentMapView", "map:%s markerid:%s, onMarkerClick", this, marker.getTag());
                if (Util.isNullOrNil((String) marker.getTag()) && a.this.lYK != null && ((e) a.this.lYK.getRenderer()).getCluster(marker) != null) {
                    boolean b2 = a.this.b(((e) a.this.lYK.getRenderer()).getCluster(marker));
                    AppMethodBeat.o(146468);
                    return b2;
                } else if (Util.isNullOrNil((String) marker.getTag())) {
                    Log.w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is null, return");
                    AppMethodBeat.o(146468);
                    return false;
                } else if (((String) marker.getTag()).endsWith("AnchorPoint")) {
                    if (!(a.this.lYB == null || a.this.lZl == null)) {
                        Log.w("MicroMsg.DefaultTencentMapView", "click anchor point");
                        a.this.lYB.d(a.this.lZl.getLatitude(), a.this.lZl.getLongitude());
                    }
                    AppMethodBeat.o(146468);
                    return true;
                } else {
                    g ZU = a.this.ZU((String) marker.getTag());
                    if (ZU == null) {
                        Log.e("MicroMsg.DefaultTencentMapView", "[onMarkerClickListener] map:%s appbrandMarker is null, return", this);
                        AppMethodBeat.o(146468);
                        return false;
                    } else if (a.this.lYz == null) {
                        Log.e("MicroMsg.DefaultTencentMapView", "[onMarkerClickListener] map:%s mapCalloutClick is null, return", this);
                        AppMethodBeat.o(146468);
                        return false;
                    } else {
                        if (ZU.maM != null) {
                            if (((String) marker.getTag()).endsWith("#label")) {
                                Log.w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is label marker, do nothing");
                            } else {
                                b.v.a aVar = ZU.maM.maR;
                                if (ZU.maj != null) {
                                    marker2 = ZU.maj;
                                } else {
                                    marker2 = marker;
                                }
                                if (aVar == null || aVar.maY != b.v.a.mbb || marker2 == null) {
                                    if (!(aVar == null || marker2 == null)) {
                                        a.a(a.this, marker2);
                                    }
                                } else if (!marker2.isInfoWindowShown()) {
                                    a.a(a.this, marker2);
                                } else {
                                    marker2.hideInfoWindow();
                                }
                            }
                        }
                        if (ZU.maj != null) {
                            ZU.maj.set2Top();
                        }
                        if (ZU.maq != null) {
                            ZU.maq.set2Top();
                        }
                        if (a.this.lZl != null) {
                            d dVar = a.this.lZl;
                            if (dVar.maj != null) {
                                dVar.maj.set2Top();
                            }
                        }
                        if (ZU.maM.mao > 0) {
                            a.a(a.this, ZU.maM.mao);
                            AppMethodBeat.o(146468);
                            return true;
                        } else if (((String) marker.getTag()).endsWith("#label")) {
                            Log.w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is label marker, return");
                            boolean c2 = a.this.lYA.c(ZU);
                            AppMethodBeat.o(146468);
                            return c2;
                        } else {
                            boolean b3 = a.this.lYz.b(ZU);
                            AppMethodBeat.o(146468);
                            return b3;
                        }
                    }
                }
            }
        });
        this.lYw.getMap().setOnMapClickListener(new TencentMap.OnMapClickListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass20 */

            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener
            public final void onMapClick(LatLng latLng) {
                AppMethodBeat.i(146478);
                for (g gVar : a.this.lZh.values()) {
                    if (!(gVar.maM == null || gVar.maM.maR == null || gVar.maM.maR.maY != b.v.a.mbb || gVar.maj == null || !gVar.maj.isInfoWindowShown())) {
                        gVar.maj.hideInfoWindow();
                    }
                }
                if (a.this.lYQ != null) {
                    a.this.lYQ.e(latLng.getLongitude(), latLng.getLatitude());
                    AppMethodBeat.o(146478);
                    return;
                }
                AppMethodBeat.o(146478);
            }
        });
        this.lYw.getMap().setOnMapLoadedListener(new TencentMap.OnMapLoadedListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass31 */

            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLoadedListener
            public final void onMapLoaded() {
                AppMethodBeat.i(146479);
                if (a.this.lYR != null) {
                    b.y unused = a.this.lYR;
                }
                a.j(a.this);
                a.this.lYN = true;
                if (a.this.lYZ.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(a.this.lYZ);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        a.this.ZR((String) it.next());
                    }
                    a.this.lYZ.clear();
                }
                AppMethodBeat.o(146479);
            }
        });
        this.lYw.getMap().setOnMapPoiClickListener(new TencentMap.OnMapPoiClickListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass39 */

            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapPoiClickListener
            public final void onClicked(MapPoi mapPoi) {
                AppMethodBeat.i(146480);
                if (a.this.lYS != null) {
                    b.t tVar = new b.t();
                    tVar.latitude = mapPoi.getPosition().getLatitude();
                    tVar.longitude = mapPoi.getPosition().getLongitude();
                    tVar.name = mapPoi.getName();
                    if ((mapPoi instanceof IndoorMapPoi) && !Util.isNullOrNil(((IndoorMapPoi) mapPoi).getBuildingId())) {
                        tVar.buildingId = ((IndoorMapPoi) mapPoi).getBuildingId();
                        tVar.floorName = ((IndoorMapPoi) mapPoi).getFloorName();
                    }
                    a.this.lYS.a(tVar);
                }
                AppMethodBeat.o(146480);
            }
        });
        this.lYw.getMap().setOnIndoorStateChangeListener(new TencentMap.OnIndoorStateChangeListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass40 */

            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnIndoorStateChangeListener
            public final boolean onIndoorBuildingFocused() {
                AppMethodBeat.i(146481);
                Log.v("MicroMsg.DefaultTencentMapView", "[onIndoorBuildingFocused]");
                AppMethodBeat.o(146481);
                return true;
            }

            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnIndoorStateChangeListener
            public final boolean onIndoorLevelActivated(IndoorBuilding indoorBuilding) {
                AppMethodBeat.i(146482);
                Log.v("MicroMsg.DefaultTencentMapView", "[onIndoorLevelActivated]indoorBuilding:%s", indoorBuilding);
                if (a.this.lYW != null) {
                    b.f fVar = new b.f();
                    fVar.buildingId = indoorBuilding.getBuidlingId();
                    fVar.buildingName = indoorBuilding.getBuildingName();
                    fVar.maA = new LinkedList();
                    for (IndoorLevel indoorLevel : indoorBuilding.getLevels()) {
                        b.g gVar = new b.g();
                        gVar.floorName = indoorLevel.getName();
                        fVar.maA.add(gVar);
                    }
                    fVar.maB = indoorBuilding.getActiveLevelIndex();
                    a.this.lYX = fVar;
                    a.this.lYW.a(fVar);
                }
                AppMethodBeat.o(146482);
                return true;
            }

            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnIndoorStateChangeListener
            public final boolean onIndoorBuildingDeactivated() {
                AppMethodBeat.i(146483);
                Log.v("MicroMsg.DefaultTencentMapView", "[onIndoorBuildingDeactivated]");
                if (a.this.lYW != null) {
                    b.f bHj = a.bHj();
                    a.this.lYX = bHj;
                    a.this.lYW.a(bHj);
                }
                AppMethodBeat.o(146483);
                return true;
            }
        });
        Log.i("MicroMsg.DefaultTencentMapView", "map:%s onCreate", this);
        this.lYw.onCreate(null);
        onResume();
        AppMethodBeat.o(146490);
    }

    /* access modifiers changed from: protected */
    public TencentMapOptions P(Map<String, Object> map) {
        AppMethodBeat.i(146491);
        TencentMapOptions tencentMapOptions = new TencentMapOptions();
        if (map == null) {
            Log.w("MicroMsg.DefaultTencentMapView", "params is null, return");
            AppMethodBeat.o(146491);
            return tencentMapOptions;
        }
        String a2 = f.a(map, "theme", "normal");
        this.lYG = a2.equals("handDraw");
        this.mMapType = f.a(map, "mapType", 1);
        tencentMapOptions.setMapType(this.mMapType);
        this.lYD = f.a(map, "subKey", "");
        this.lYE = f.a(map, "subId", "");
        this.lYH = f.a(map, "enableDarkMode", 0) == 1;
        if (Util.isNullOrNil(this.lYD)) {
            this.lYD = lYC;
            this.lYE = "";
        } else {
            this.lYH = false;
        }
        tencentMapOptions.setSubInfo(this.lYD, this.lYE);
        this.lYF = f.a(map, "styleId", 0);
        Log.d("MicroMsg.DefaultTencentMapView", "MapReport subId:%s, subKey:%s", this.lYE, this.lYD);
        Log.i("MicroMsg.DefaultTencentMapView", "[createTencentMapOptions]theme:%s isHandDraw:%b, mapType:%d, subId:%s, subKey:%s, styleId:%d enableDarkmode:%b", a2, Boolean.valueOf(this.lYG), Integer.valueOf(this.mMapType), this.lYE, this.lYD, Integer.valueOf(this.lYF), Boolean.valueOf(this.lYH));
        AppMethodBeat.o(146491);
        return tencentMapOptions;
    }

    private static b.f bGS() {
        AppMethodBeat.i(146492);
        b.f fVar = new b.f();
        fVar.buildingId = "";
        fVar.buildingName = "";
        fVar.maA = new LinkedList();
        fVar.maB = -1;
        AppMethodBeat.o(146492);
        return fVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void onResume() {
        AppMethodBeat.i(146493);
        Log.i("MicroMsg.DefaultTencentMapView", "map:%s onResume", this);
        if (this.mMapType == 0) {
            this.dKU.setVisibility(4);
            this.lYw.setVisibility(0);
            this.lYw.onResume();
            bGT();
        } else {
            this.lYw.onResume();
        }
        this.lYx = false;
        if (this.lZk) {
            ((com.tencent.mm.plugin.appbrand.utils.b.a) com.tencent.luggage.a.e.M(com.tencent.mm.plugin.appbrand.utils.b.a.class)).b("gcj02", this.lZm, bHf());
            g.a(this);
        }
        AppMethodBeat.o(146493);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void onPause() {
        AppMethodBeat.i(146494);
        Log.i("MicroMsg.DefaultTencentMapView", "map:%s onPause", this);
        if (this.mMapType == 0) {
            this.dKU.setVisibility(0);
            if (this.lYO == null) {
                this.lYO = getSurfaceView();
            }
            if (this.lYO != null) {
                MMHandlerThread.postToMainThreadDelayed(this.lYP, 100);
            } else {
                Log.e("MicroMsg.DefaultTencentMapView", "hideTencentMap err");
            }
            this.lYw.setVisibility(4);
            this.lYw.getMap().getScreenShot(new TencentMap.OnScreenShotListener() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass41 */

                @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnScreenShotListener
                public final void onMapScreenShot(Bitmap bitmap) {
                    AppMethodBeat.i(146484);
                    if (bitmap != null) {
                        a.this.dKU.setImageBitmap(bitmap);
                    }
                    AppMethodBeat.o(146484);
                }
            });
        } else {
            this.lYw.onPause();
        }
        this.lYx = true;
        if (this.lZk) {
            ((com.tencent.mm.plugin.appbrand.utils.b.a) com.tencent.luggage.a.e.M(com.tencent.mm.plugin.appbrand.utils.b.a.class)).c("gcj02", this.lZm, bHf());
            g.b(this);
        }
        AppMethodBeat.o(146494);
    }

    private SurfaceView getSurfaceView() {
        AppMethodBeat.i(146495);
        if (this.lYO != null) {
            SurfaceView surfaceView = this.lYO;
            AppMethodBeat.o(146495);
            return surfaceView;
        }
        this.lYO = i(this.lYw);
        SurfaceView surfaceView2 = this.lYO;
        AppMethodBeat.o(146495);
        return surfaceView2;
    }

    private void bGT() {
        AppMethodBeat.i(146496);
        if (this.lYO == null) {
            this.lYO = getSurfaceView();
        }
        if (this.lYO != null) {
            MMHandlerThread.removeRunnable(this.lYP);
            this.lYO.setVisibility(0);
            AppMethodBeat.o(146496);
            return;
        }
        Log.e("MicroMsg.DefaultTencentMapView", "showTencentMap err");
        AppMethodBeat.o(146496);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void onDestroy() {
        AppMethodBeat.i(146497);
        Log.i("MicroMsg.DefaultTencentMapView", "map:%s onDestroy", this);
        this.lZp.set(true);
        this.lYw.getMap().setOnMapCameraChangeListener(null);
        bHc();
        bHb();
        bHb();
        bHa();
        bHd();
        bHe();
        for (CustomLayer customLayer : this.lYY.values()) {
            customLayer.remove();
        }
        this.lYY.clear();
        if (this.lYw != null) {
            this.lYw.getMap().setOnMapPoiClickListener(null);
            this.lYw.clean();
            this.lYw.onDestroy();
        }
        if (this.lZl != null) {
            d dVar = this.lZl;
            if (dVar.maj != null) {
                dVar.maj.remove();
                dVar.maj = null;
            }
            this.lZl = null;
        }
        AppMethodBeat.o(146497);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final View getView() {
        return this.container;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void a(b.m mVar) {
        this.lYQ = mVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void a(b.z zVar) {
        this.lYS = zVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final b.ac bGU() {
        AppMethodBeat.i(146498);
        LatLngBounds latLngBounds = this.lYw.getProjection().getVisibleRegion().getLatLngBounds();
        b.j jVar = new b.j();
        jVar.maE = new b.i(latLngBounds.getSouthwest().getLatitude(), latLngBounds.getSouthwest().getLongitude());
        jVar.maF = new b.i(latLngBounds.getNortheast().getLatitude(), latLngBounds.getNortheast().getLongitude());
        b.ad adVar = new b.ad();
        adVar.mbf = jVar;
        b.ac acVar = new b.ac();
        acVar.mbe = adVar;
        AppMethodBeat.o(146498);
        return acVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void a(b.w wVar) {
        AppMethodBeat.i(146499);
        this.lYU = wVar;
        this.lYw.getMap().setTencentMapGestureListener(new TencentMap.TencentMapGestureListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass43 */

            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.TencentMapGestureListener
            public final boolean onDoubleTap(float f2, float f3) {
                return false;
            }

            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.TencentMapGestureListener
            public final boolean onSingleTap(float f2, float f3) {
                return false;
            }

            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.TencentMapGestureListener
            public final boolean onFling(float f2, float f3) {
                return false;
            }

            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.TencentMapGestureListener
            public final boolean onScroll(float f2, float f3) {
                return false;
            }

            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.TencentMapGestureListener
            public final boolean onLongPress(float f2, float f3) {
                return false;
            }

            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.TencentMapGestureListener
            public final boolean onDown(float f2, float f3) {
                AppMethodBeat.i(146486);
                a.this.lYT = true;
                AppMethodBeat.o(146486);
                return false;
            }

            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.TencentMapGestureListener
            public final boolean onUp(float f2, float f3) {
                return false;
            }

            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.TencentMapGestureListener
            public final void onMapStable() {
                AppMethodBeat.i(146487);
                AppMethodBeat.o(146487);
            }
        });
        this.lYw.getMap().setOnMapCameraChangeListener(new TencentMap.OnMapCameraChangeListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass2 */

            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener
            public final void onCameraChange(CameraPosition cameraPosition) {
                AppMethodBeat.i(146459);
                if (a.this.lYU != null) {
                    b.a aVar = new b.a();
                    aVar.mas = new b.i(cameraPosition.getTarget().getLatitude(), cameraPosition.getTarget().getLongitude());
                    aVar.zoom = cameraPosition.getZoom();
                    aVar.mat = cameraPosition.getBearing();
                    aVar.skew = cameraPosition.getSkew();
                    a.this.lYU.a(aVar, a.this.lYT);
                }
                AppMethodBeat.o(146459);
            }

            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener
            public final void onCameraChangeFinish(CameraPosition cameraPosition) {
                AppMethodBeat.i(146460);
                if (a.this.lYU != null) {
                    b.a aVar = new b.a();
                    aVar.mas = new b.i(cameraPosition.getTarget().getLatitude(), cameraPosition.getTarget().getLongitude());
                    aVar.zoom = cameraPosition.getZoom();
                    aVar.mat = cameraPosition.getBearing();
                    aVar.skew = cameraPosition.getSkew();
                    a.this.lYU.b(aVar, a.this.lYT);
                    a.this.lYT = false;
                }
                a.j(a.this);
                AppMethodBeat.o(146460);
            }
        });
        AppMethodBeat.o(146499);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void f(double d2, double d3) {
        AppMethodBeat.i(146500);
        a(d2, d3, -1.0f, -1.0f, -1.0f, true);
        AppMethodBeat.o(146500);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void bGV() {
        AppMethodBeat.i(146501);
        Log.i("MicroMsg.DefaultTencentMapView", "map:%s moveToMapLocation", this);
        this.lYV = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(146461);
                if (a.this.lZl != null && a.this.lZk) {
                    double latitude = a.this.lZl.getLatitude();
                    double longitude = a.this.lZl.getLongitude();
                    a.this.lYw.getIController().animateTo(latitude, longitude);
                    Log.d("MicroMsg.DefaultTencentMapView", "[moveToMapLocation]latitude:%f, longtitude:%f", Double.valueOf(latitude), Double.valueOf(longitude));
                }
                AppMethodBeat.o(146461);
            }
        };
        if (this.lZl != null && this.lZk) {
            this.lYV.run();
            this.lYV = null;
        }
        AppMethodBeat.o(146501);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final float getZoom() {
        AppMethodBeat.i(217223);
        float zoom = this.lYw.getMap().getCameraPosition().getZoom();
        AppMethodBeat.o(217223);
        return zoom;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final float getRotate() {
        AppMethodBeat.i(146503);
        float bearing = this.lYw.getMap().getCameraPosition().getBearing();
        AppMethodBeat.o(146503);
        return bearing;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final float getSkew() {
        AppMethodBeat.i(146504);
        float skew = this.lYw.getMap().getCameraPosition().getSkew();
        AppMethodBeat.o(146504);
        return skew;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void hw(boolean z) {
        AppMethodBeat.i(146505);
        this.lYw.getUiSettings().setZoomGesturesEnabled(z);
        AppMethodBeat.o(146505);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void hx(boolean z) {
        AppMethodBeat.i(146506);
        this.lYw.getUiSettings().setScrollGesturesEnabled(z);
        AppMethodBeat.o(146506);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void hy(boolean z) {
        AppMethodBeat.i(146507);
        this.lYw.getUiSettings().setRotateGesturesEnabled(z);
        AppMethodBeat.o(146507);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void hz(boolean z) {
        AppMethodBeat.i(146508);
        this.lYw.getUiSettings().setCompassEnabled(z);
        AppMethodBeat.o(146508);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void hA(boolean z) {
        AppMethodBeat.i(146510);
        this.lYw.getUiSettings().setTiltGesturesEnabled(z);
        AppMethodBeat.o(146510);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void hB(boolean z) {
        AppMethodBeat.i(146511);
        this.lYw.getMap().setSatelliteEnabled(z);
        AppMethodBeat.o(146511);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void hC(boolean z) {
        AppMethodBeat.i(146512);
        this.lYw.getMap().setTrafficEnabled(z);
        AppMethodBeat.o(146512);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void hD(boolean z) {
        AppMethodBeat.i(146513);
        this.lYw.getMap().setIndoorEnabled(z);
        AppMethodBeat.o(146513);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void a(b.x xVar) {
        this.lYW = xVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void dy(String str, String str2) {
        AppMethodBeat.i(146514);
        this.lYw.getMap().setIndoorFloor(str, str2);
        AppMethodBeat.o(146514);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void setIndoorMaskColor(int i2) {
        AppMethodBeat.i(217224);
        this.lYw.getMap().setIndoorMaskColor(i2);
        AppMethodBeat.o(217224);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final b.f bGW() {
        AppMethodBeat.i(146515);
        if (this.lYX != null) {
            b.f fVar = this.lYX;
            AppMethodBeat.o(146515);
            return fVar;
        }
        b.f bGS = bGS();
        AppMethodBeat.o(146515);
        return bGS;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public void onTouchEvent(MotionEvent motionEvent) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public void onSizeChanged(int i2, int i3) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public void g(SurfaceTexture surfaceTexture) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public boolean bGX() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void c(float f2, float f3, boolean z) {
        AppMethodBeat.i(146516);
        LatLng mapCenter = this.lYw.getMap().getMapCenter();
        this.lYw.setMapAnchor(f2, f3);
        a(mapCenter.getLatitude(), mapCenter.getLongitude(), -1.0f, -1.0f, -1.0f, z);
        AppMethodBeat.o(146516);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void setMapStyle(int i2) {
        AppMethodBeat.i(182813);
        Log.i("MicroMsg.DefaultTencentMapView", "map:%s setMapStyle: %d", this, Integer.valueOf(i2));
        this.lYw.getMap().setMapStyle(i2);
        AppMethodBeat.o(182813);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void ZR(String str) {
        AppMethodBeat.i(182814);
        if (!this.lYN) {
            if (!this.lYZ.contains(str)) {
                this.lYZ.add(str);
            }
            Log.e("MicroMsg.DefaultTencentMapView", "addCustomLayer, wait map loaded callback");
            AppMethodBeat.o(182814);
            return;
        }
        CustomLayer addCustomLayer = this.lYw.getMap().addCustomLayer(new CustomLayerOptions().layerId(str));
        if (addCustomLayer != null) {
            Log.v("MicroMsg.DefaultTencentMapView", "addCustomLayer success, layerId:%s", str);
            CustomLayer remove = this.lYY.remove(str);
            if (remove != null) {
                remove.remove();
            }
            this.lYY.put(str, addCustomLayer);
            AppMethodBeat.o(182814);
            return;
        }
        Log.e("MicroMsg.DefaultTencentMapView", "addCustomLayer fail, layerId:%s", str);
        AppMethodBeat.o(182814);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void ZS(String str) {
        AppMethodBeat.i(182815);
        CustomLayer remove = this.lYY.remove(str);
        if (remove != null) {
            Log.v("MicroMsg.DefaultTencentMapView", "removeCustomLayer success, layerId:%s", str);
            remove.remove();
            AppMethodBeat.o(182815);
            return;
        }
        Log.e("MicroMsg.DefaultTencentMapView", "removeCustomLayer fail, layerId:%s", str);
        AppMethodBeat.o(182815);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void hE(boolean z) {
        AppMethodBeat.i(146517);
        this.lYw.getUiSettings().setIndoorLevelPickerEnabled(z);
        AppMethodBeat.o(146517);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void hF(boolean z) {
        AppMethodBeat.i(146518);
        this.lYw.getUiSettings().setScaleControlsEnabled(z);
        AppMethodBeat.o(146518);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void setPoisEnabled(boolean z) {
        AppMethodBeat.i(217225);
        this.lYw.getMap().setPoisEnabled(z);
        AppMethodBeat.o(217225);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void hG(boolean z) {
        AppMethodBeat.i(217226);
        this.lYw.getMap().showBuilding(z);
        AppMethodBeat.o(217226);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void setBuilding3dEffectEnable(boolean z) {
        AppMethodBeat.i(217227);
        this.lYw.getMap().setBuilding3dEffectEnable(z);
        AppMethodBeat.o(217227);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final b.i bGY() {
        AppMethodBeat.i(146519);
        LatLng mapCenter = this.lYw.getMap().getMapCenter();
        b.i iVar = new b.i(mapCenter.getLatitude(), mapCenter.getLongitude());
        AppMethodBeat.o(146519);
        return iVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void h(List<b.i> list, int i2) {
        AppMethodBeat.i(146520);
        LinkedList linkedList = new LinkedList();
        for (b.i iVar : list) {
            linkedList.add(new LatLng(iVar.latitude, iVar.longitude));
        }
        i(linkedList, i2);
        AppMethodBeat.o(146520);
    }

    private void i(List<LatLng> list, int i2) {
        AppMethodBeat.i(217228);
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(list);
        this.lYT = false;
        this.lYw.getMap().animateCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), i2));
        this.lYV = null;
        AppMethodBeat.o(217228);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void setMaxZoomLevel(int i2) {
        AppMethodBeat.i(217229);
        this.lYw.getMap().setMaxZoomLevel(i2);
        Log.i("MicroMsg.DefaultTencentMapView", "map_scale setMaxZoomLevel:%d", Integer.valueOf(i2));
        AppMethodBeat.o(217229);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void setMinZoomLevel(int i2) {
        AppMethodBeat.i(217230);
        this.lYw.getMap().setMinZoomLevel(i2);
        Log.i("MicroMsg.DefaultTencentMapView", "map_scale setMinZoomLevel:%d", Integer.valueOf(i2));
        AppMethodBeat.o(217230);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void a(double d2, double d3, float f2, float f3, float f4) {
        AppMethodBeat.i(146521);
        a(d2, d3, f2, f3, f4, false);
        AppMethodBeat.o(146521);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void a(final double d2, final double d3, final float f2, final float f3, final float f4, boolean z) {
        AppMethodBeat.i(146522);
        Log.v("MicroMsg.DefaultTencentMapView", "start map:%s latitude:%f longitude:%f scale:%f rotate:%f skew:%f", this, Double.valueOf(d2), Double.valueOf(d3), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4));
        if (f2 == -1.0f && f3 == -1.0f && f4 == -1.0f && d2 == -1.0d && d3 == -1.0d) {
            AppMethodBeat.o(146522);
            return;
        }
        final TencentMap map = this.lYw.getMap();
        if (map != null) {
            if (z) {
                aa(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(146464);
                        CameraUpdate b2 = a.b(map, f2, f3, f4, d2, d3);
                        Log.v("MicroMsg.DefaultTencentMapView", "doing map:%s latitude:%f longitude:%f scale:%f rotate:%f skew:%f", this, Double.valueOf(d2), Double.valueOf(d3), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4));
                        a.this.lYT = false;
                        map.animateCamera(b2, a.lZa, a.this.lZc);
                        AppMethodBeat.o(146464);
                    }
                });
                AppMethodBeat.o(146522);
                return;
            }
            CameraUpdate a2 = a(map, f2, f3, f4, d2, d3);
            this.lYT = false;
            map.moveCamera(a2);
        }
        AppMethodBeat.o(146522);
    }

    private static CameraUpdate a(TencentMap tencentMap, float f2, float f3, float f4, double d2, double d3) {
        AppMethodBeat.i(146523);
        if (f2 == -1.0f && f3 == -1.0f && f4 == -1.0f && d2 != -1.0d && d3 != -1.0d) {
            CameraUpdate newLatLng = CameraUpdateFactory.newLatLng(new LatLng(d2, d3));
            AppMethodBeat.o(146523);
            return newLatLng;
        }
        CameraPosition cameraPosition = tencentMap.getCameraPosition();
        CameraPosition.Builder skew = new CameraPosition.Builder(cameraPosition).bearing(cameraPosition.getBearing()).skew(cameraPosition.getSkew());
        Log.v("MicroMsg.DefaultTencentMapView", "tencentMap.getCameraPosition:%s rotate:%f skew:%f", tencentMap.getCameraPosition(), Float.valueOf(tencentMap.getCameraPosition().getBearing()), Float.valueOf(tencentMap.getCameraPosition().getSkew()));
        if (f2 != -1.0f) {
            skew.zoom(f2);
            Log.i("MicroMsg.DefaultTencentMapView", "map_scale zoom:%f", Float.valueOf(f2));
        }
        if (f3 != -1.0f) {
            skew.bearing(f3);
        }
        if (f4 != -1.0f) {
            skew.skew(f4);
        }
        if (!(d2 == -1.0d || d3 == -1.0d)) {
            skew.target(new LatLng(d2, d3));
        }
        CameraUpdate newCameraPosition = CameraUpdateFactory.newCameraPosition(skew.build());
        AppMethodBeat.o(146523);
        return newCameraPosition;
    }

    private void aa(Runnable runnable) {
        AppMethodBeat.i(146524);
        this.lZb.add(runnable);
        if (this.lZb.size() == 1) {
            runnable.run();
        }
        AppMethodBeat.o(146524);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void bGZ() {
        AppMethodBeat.i(146525);
        synchronized (this.lZd) {
            try {
                Iterator<Circle> it = this.lZd.iterator();
                while (it.hasNext()) {
                    it.next().remove();
                }
                this.lZd.clear();
            } finally {
                AppMethodBeat.o(146525);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void a(b.C0670b bVar) {
        AppMethodBeat.i(146526);
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(new LatLng(bVar.latitude, bVar.longitude));
        circleOptions.radius((double) bVar.radius);
        circleOptions.strokeColor(bVar.strokeColor);
        circleOptions.strokeWidth((float) bVar.strokeWidth);
        circleOptions.fillColor(bVar.fillColor);
        int ZY = ZY(bVar.mau);
        if (ZY >= 0) {
            circleOptions.level(ZY);
        } else {
            circleOptions.level(OverlayLevel.OverlayLevelAboveLabels);
        }
        Circle addCircle = this.lYw.getMap().addCircle(circleOptions);
        synchronized (this.lZd) {
            try {
                this.lZd.add(addCircle);
            } finally {
                AppMethodBeat.o(146526);
            }
        }
    }

    public class b {
        ImageView mai;

        public b(ImageView imageView) {
            this.mai = imageView;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void bHa() {
        AppMethodBeat.i(146527);
        m.runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(146465);
                FrameLayout frameLayout = a.this.container;
                synchronized (a.this.lZe) {
                    try {
                        Iterator<b> it = a.this.lZe.iterator();
                        while (it.hasNext()) {
                            frameLayout.removeView(it.next().mai);
                        }
                        a.this.lZe.clear();
                    } finally {
                        AppMethodBeat.o(146465);
                    }
                }
            }
        });
        AppMethodBeat.o(146527);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final boolean a(b.c cVar, final b.n nVar, com.tencent.mm.plugin.appbrand.f.a aVar) {
        AppMethodBeat.i(146528);
        if (Util.isNullOrNil(cVar.mav)) {
            AppMethodBeat.o(146528);
            return false;
        }
        Bitmap cR = aVar.cR(cVar.mav);
        if (cR == null) {
            AppMethodBeat.o(146528);
            return false;
        }
        final ImageView imageView = new ImageView(this.context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageBitmap(cR);
        int i2 = cVar.left;
        int i3 = cVar.top;
        final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(cVar.width == 0 ? com.tencent.mm.plugin.appbrand.ac.g.zD(cR.getWidth()) : cVar.width, cVar.height == 0 ? com.tencent.mm.plugin.appbrand.ac.g.zD(cR.getHeight()) : cVar.height);
        layoutParams.setMargins(i2, i3, 0, 0);
        final boolean z = cVar.maw;
        final String str = cVar.data;
        imageView.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass7 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(146466);
                if (z) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        imageView.setColorFilter(Color.parseColor("#88888888"));
                    } else if (action == 3 || action == 1) {
                        imageView.clearColorFilter();
                    }
                }
                AppMethodBeat.o(146466);
                return false;
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(146467);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/map/mapsdk/DefaultTencentMapView$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (z && nVar != null) {
                    nVar.ZQ(str);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/map/mapsdk/DefaultTencentMapView$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(146467);
            }
        });
        m.runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(146469);
                a.this.container.addView(imageView, layoutParams);
                synchronized (a.this.lZe) {
                    try {
                        a.this.lZe.add(new b(imageView));
                    } finally {
                        AppMethodBeat.o(146469);
                    }
                }
            }
        });
        AppMethodBeat.o(146528);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void bHb() {
        AppMethodBeat.i(146529);
        for (Polyline polyline : this.lZf.values()) {
            polyline.remove();
        }
        this.lZf.clear();
        AppMethodBeat.o(146529);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final boolean ZT(String str) {
        AppMethodBeat.i(146530);
        Log.i("MicroMsg.DefaultTencentMapView", "map:%s removeLine lineId:%s", this, str);
        Polyline polyline = this.lZf.get(str);
        if (polyline == null) {
            Log.w("MicroMsg.DefaultTencentMapView", "lineId:%s is null", str);
            AppMethodBeat.o(146530);
            return false;
        }
        polyline.remove();
        this.lZf.remove(str);
        AppMethodBeat.o(146530);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void a(b.k kVar, com.tencent.mm.plugin.appbrand.f.a aVar) {
        AppMethodBeat.i(146531);
        PolylineOptions polylineOptions = new PolylineOptions();
        ArrayList arrayList = new ArrayList();
        for (b.i iVar : kVar.maG) {
            arrayList.add(new LatLng(iVar.latitude, iVar.longitude));
        }
        polylineOptions.addAll(arrayList);
        if (kVar.maL != null && kVar.maL.size() > 0) {
            Log.i("MicroMsg.DefaultTencentMapView", "colorList size:%d ", Integer.valueOf(kVar.maL.size()));
            int size = kVar.maL.size();
            int[] iArr = new int[size];
            int[] iArr2 = new int[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = kVar.maL.get(i2).intValue();
                iArr2[i2] = i2;
            }
            polylineOptions.colors(iArr, iArr2);
        } else if (kVar.style != -1) {
            polylineOptions.color(kVar.style);
        } else {
            polylineOptions.color(kVar.color);
        }
        polylineOptions.width((float) kVar.width);
        polylineOptions.setDottedLine(kVar.maH);
        polylineOptions.edgeColor(kVar.borderColor);
        polylineOptions.edgeWidth((float) kVar.rc);
        if (kVar.maI) {
            Bitmap cR = aVar.cR(kVar.maJ);
            polylineOptions.arrowTexture(new BitmapDescriptor(cR));
            if (cR == null) {
                polylineOptions.arrowTexture(new BitmapDescriptor(BitmapFactory.decodeResource(this.context.getResources(), R.drawable.bxu)));
            }
        }
        polylineOptions.zIndex(1.0f);
        if (!Util.isNullOrNil(kVar.buildingId) && !Util.isNullOrNil(kVar.floorName)) {
            polylineOptions.indoorInfo(new IndoorInfo(kVar.buildingId, kVar.floorName));
        }
        polylineOptions.arrowGap((float) kVar.maK);
        int ZY = ZY(kVar.mau);
        if (ZY >= 0) {
            polylineOptions.level(ZY);
        } else {
            polylineOptions.level(OverlayLevel.OverlayLevelAboveRoads);
        }
        polylineOptions.lineCap(true);
        Polyline addPolyline = this.lYw.getMap().addPolyline(polylineOptions);
        if (addPolyline == null) {
            Log.e("MicroMsg.DefaultTencentMapView", "polyline is null, return");
            AppMethodBeat.o(146531);
            return;
        }
        this.lZf.put(Util.nullAs(Util.isNullOrNil(kVar.id) ? new StringBuilder().append(kVar.hashCode()).toString() : kVar.id, kVar.toString()), addPolyline);
        AppMethodBeat.o(146531);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void a(String str, int i2, b.i iVar, boolean z) {
        AppMethodBeat.i(146532);
        Polyline polyline = this.lZf.get(str);
        if (polyline == null) {
            Log.w("MicroMsg.DefaultTencentMapView", "lineId:%s is null", str);
            AppMethodBeat.o(146532);
            return;
        }
        polyline.setEraseable(z);
        polyline.eraseTo(i2, new LatLng(iVar.latitude, iVar.longitude));
        AppMethodBeat.o(146532);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.k.a.a$a  reason: collision with other inner class name */
    public class C0669a implements TencentMap.InfoWindowAdapter {
        public C0669a() {
        }

        @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter
        public final View getInfoWindow(Marker marker) {
            AppMethodBeat.i(146488);
            if (marker == null) {
                AppMethodBeat.o(146488);
                return null;
            } else if (Util.isNullOrNil((String) marker.getTag())) {
                Log.w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is null, return");
                AppMethodBeat.o(146488);
                return null;
            } else if (((String) marker.getTag()).endsWith("#label")) {
                AppMethodBeat.o(146488);
                return null;
            } else {
                g ZU = a.this.ZU((String) marker.getTag());
                if (ZU == null) {
                    Log.e("MicroMsg.DefaultTencentMapView", "[getInfoWindow] appbrandMarker is null, return");
                    AppMethodBeat.o(146488);
                    return null;
                } else if (ZU.maM == null) {
                    Log.e("MicroMsg.DefaultTencentMapView", "[getInfoWindow] appBrandMarker.appBrandMarkerOptions is null, return");
                    AppMethodBeat.o(146488);
                    return null;
                } else {
                    b.v.a aVar = ZU.maM.maR;
                    if (aVar == null) {
                        AppMethodBeat.o(146488);
                        return null;
                    }
                    Object[] objArr = new Object[2];
                    objArr[0] = ZU;
                    objArr[1] = Boolean.valueOf(aVar.view != null);
                    Log.i("MicroMsg.DefaultTencentMapView", "marker:%s calloutStyle.view is %b", objArr);
                    if (aVar.view != null) {
                        if (ZU.mar == null) {
                            ZU.mar = new ImageView(a.this.context);
                        }
                        Bitmap bitmapFromView = BitmapUtil.getBitmapFromView(aVar.view);
                        if (bitmapFromView == null) {
                            Log.e("MicroMsg.DefaultTencentMapView", "marker:%s calloutStyle.view exist but bitmap is null");
                        }
                        ZU.mar.setImageBitmap(bitmapFromView);
                        ImageView imageView = ZU.mar;
                        AppMethodBeat.o(146488);
                        return imageView;
                    }
                    a aVar2 = a.this;
                    com.tencent.mm.plugin.appbrand.widget.e.b bHm = i.bHm();
                    if (bHm == null) {
                        bHm = new com.tencent.mm.plugin.appbrand.widget.e.b(aVar2.context);
                    }
                    bHm.setText("");
                    bHm.setTextSize(12);
                    bHm.setTextColor(com.tencent.mm.plugin.appbrand.widget.e.b.oyv);
                    bHm.setTitlePadding(0);
                    bHm.setGravity("center");
                    int i2 = com.tencent.mm.plugin.appbrand.widget.e.b.oyw;
                    bHm.A(0, 0, i2, i2);
                    bHm.setText(aVar.content);
                    bHm.setTextSize(aVar.maT);
                    bHm.setTextColor(aVar.color);
                    bHm.setTitlePadding(aVar.padding);
                    bHm.setGravity(aVar.kZR);
                    bHm.A(aVar.maU, aVar.rc, aVar.borderColor, aVar.bgColor);
                    AppMethodBeat.o(146488);
                    return bHm;
                }
            }
        }

        @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter
        public final void onInfoWindowDettached(Marker marker, View view) {
            AppMethodBeat.i(146489);
            if (view instanceof com.tencent.mm.plugin.appbrand.widget.e.b) {
                Log.d("MicroMsg.DefaultTencentMapView", "recycler calloutView");
                i.a((com.tencent.mm.plugin.appbrand.widget.e.b) view);
            }
            AppMethodBeat.o(146489);
        }
    }

    public final g ZU(String str) {
        AppMethodBeat.i(146533);
        g gVar = this.lZh.get(str);
        AppMethodBeat.o(146533);
        return gVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void bHc() {
        AppMethodBeat.i(146534);
        Log.i("MicroMsg.DefaultTencentMapView", "map:%s removeAllMarker", this);
        for (g gVar : this.lZh.values()) {
            if (gVar.maj != null) {
                gVar.maj.remove();
            }
            if (gVar.maq != null) {
                if (gVar.maq.getMarkerView() != null && (gVar.maq.getMarkerView() instanceof com.tencent.mm.plugin.appbrand.widget.e.d)) {
                    i.a((com.tencent.mm.plugin.appbrand.widget.e.d) gVar.maq.getMarkerView());
                }
                gVar.maq.remove();
            }
        }
        this.lZh.clear();
        bHi();
        AppMethodBeat.o(146534);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final boolean ZV(String str) {
        AppMethodBeat.i(146535);
        Log.i("MicroMsg.DefaultTencentMapView", "map:%s removeMarker markerId:%s", this, str);
        if (this.lZs.contains(str)) {
            Log.i("MicroMsg.DefaultTencentMapView", "removeMapMarkerClusterGeometry id:%s", str);
            if (this.lYK != null && !TextUtils.isEmpty(str)) {
                Iterator<f> it = this.lZr.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    f next = it.next();
                    if (str.contains(next.id)) {
                        this.lYK.removeItem(next);
                        this.lZr.remove(next);
                        this.lZs.remove(str);
                        if (next.mao > 0) {
                            ZW(new StringBuilder().append(next.mao).toString());
                            this.lZt.remove(Integer.valueOf(next.mao));
                            this.lZv.remove(Integer.valueOf(next.mao));
                        }
                        Log.i("MicroMsg.DefaultTencentMapView", "remove MapMarker ClusterGeometry success id:%s", str);
                        this.lYK.cluster();
                    }
                }
            }
        }
        g gVar = this.lZh.get(str);
        if (gVar == null) {
            Log.w("MicroMsg.DefaultTencentMapView", "marker:%s is null", str);
            AppMethodBeat.o(146535);
            return false;
        }
        if (gVar.maj != null) {
            gVar.maj.remove();
        }
        if (gVar.maq != null) {
            if (gVar.maq.getMarkerView() != null && (gVar.maq.getMarkerView() instanceof com.tencent.mm.plugin.appbrand.widget.e.d)) {
                i.a((com.tencent.mm.plugin.appbrand.widget.e.d) gVar.maq.getMarkerView());
            }
            gVar.maq.remove();
            this.lZh.remove(str + "#label");
        }
        gVar.mar = null;
        this.lZh.remove(str);
        AppMethodBeat.o(146535);
        return true;
    }

    public final boolean ZW(String str) {
        AppMethodBeat.i(217231);
        Log.i("MicroMsg.DefaultTencentMapView", "map:%s removeLabelMarker markerId:%s", this, str);
        g remove = this.lZh.remove(str + "#label");
        if (remove == null) {
            Log.w("MicroMsg.DefaultTencentMapView", "marker:%s is null", str);
            AppMethodBeat.o(217231);
            return false;
        }
        if (remove.maq != null) {
            if (remove.maq.getMarkerView() != null && (remove.maq.getMarkerView() instanceof com.tencent.mm.plugin.appbrand.widget.e.d)) {
                i.a((com.tencent.mm.plugin.appbrand.widget.e.d) remove.maq.getMarkerView());
            }
            remove.maq.remove();
        }
        AppMethodBeat.o(217231);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void a(final String str, final b.v vVar, final com.tencent.mm.plugin.appbrand.f.a aVar) {
        AppMethodBeat.i(146536);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b(str, vVar, aVar);
            AppMethodBeat.o(146536);
            return;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass11 */

            public final void run() {
                AppMethodBeat.i(217192);
                a.this.b(str, vVar, aVar);
                AppMethodBeat.o(217192);
            }
        });
        AppMethodBeat.o(146536);
    }

    public final void b(final String str, b.v vVar, com.tencent.mm.plugin.appbrand.f.a aVar) {
        String str2;
        AppMethodBeat.i(217232);
        Log.i("MicroMsg.DefaultTencentMapView", "map:%s _addMarker markerId:%s", this, str);
        if (this.lZp.get()) {
            Log.e("MicroMsg.DefaultTencentMapView", "map:%s _addMarker markerId:%s fail", this, str);
            AppMethodBeat.o(217232);
            return;
        }
        if (vVar.mao > 0) {
            String sb = new StringBuilder().append(vVar.mao).toString();
            if (this.lZz) {
                Log.i("MicroMsg.DefaultTencentMapView", "cluster item use default style");
                AppMethodBeat.o(217232);
                return;
            }
            c(sb, vVar, aVar);
            str2 = sb;
        } else {
            if (vVar.maN) {
                b.aa aaVar = new b.aa();
                aaVar.mbd = new b.i(vVar.latitude, vVar.longitude);
                aaVar.id = str;
                a(aaVar);
                c(str, vVar, aVar);
            }
            str2 = str;
        }
        g gVar = new g();
        gVar.data = vVar.data;
        gVar.maM = vVar;
        a(str2, gVar);
        if (!vVar.maN && !TextUtils.isEmpty(str)) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(new LatLng(vVar.latitude, vVar.longitude));
            if (!Util.isNullOrNil(vVar.title)) {
                markerOptions.title(vVar.title);
            }
            if (!Util.isNullOrNil(vVar.maQ)) {
                markerOptions.contentDescription(vVar.maQ);
            }
            markerOptions.rotation(vVar.mat);
            markerOptions.alpha(vVar.alpha);
            final FrameLayout frameLayout = (FrameLayout) ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.z3, (ViewGroup) null);
            final ImageView imageView = (ImageView) frameLayout.findViewById(R.id.fa0);
            final float f2 = vVar.maO;
            final float f3 = vVar.maP;
            Bitmap bitmap = null;
            if (aVar != null && !Util.isNullOrNil(vVar.mav)) {
                if (imageView != null) {
                    imageView.setImageBitmap(null);
                }
                bitmap = aVar.a(vVar.mav, (Rect) null, new a.b() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass12 */

                    @Override // com.tencent.mm.plugin.appbrand.f.a.b
                    public final void Q(Bitmap bitmap) {
                        AppMethodBeat.i(217193);
                        if (bitmap != null) {
                            a.b(f2, f3, bitmap, imageView);
                            if (!(a.this.ZU(str) == null || a.this.ZU(str).maj == null)) {
                                Marker marker = a.this.ZU(str).maj;
                                if (marker != null) {
                                    marker.setMarkerView(frameLayout);
                                }
                                Log.v("MicroMsg.DefaultTencentMapView", "setMarkerView");
                            }
                        }
                        AppMethodBeat.o(217193);
                    }
                });
            }
            if (bitmap != null) {
                a(f2, f3, bitmap, imageView);
            } else {
                Log.e("MicroMsg.DefaultTencentMapView", "[addMarker] bitmap is null, use default");
            }
            markerOptions.markerView(frameLayout);
            markerOptions.anchor(vVar.anchorX, vVar.anchorY);
            markerOptions.tag(str2);
            markerOptions.infoWindowHideAnimation(new Animation() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass13 */
            });
            markerOptions.infoWindowShowAnimation(new Animation() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass14 */
            });
            markerOptions.visible(true);
            markerOptions.zIndex(vVar.zIndex + 2);
            markerOptions.level(OverlayLevel.OverlayLevelAboveLabels);
            if (!Util.isNullOrNil(vVar.buildingId) && !Util.isNullOrNil(vVar.floorName)) {
                markerOptions.indoorInfo(new IndoorInfo(vVar.buildingId, vVar.floorName));
            }
            if (vVar.maR != null) {
                markerOptions.infoWindowOffset(vVar.maR.maZ, vVar.maR.mba);
            }
            Marker addMarker = this.lYw.getMap().addMarker(markerOptions);
            gVar.maj = addMarker;
            addMarker.getZIndex();
            if (vVar.maR != null && vVar.maR.maY == b.v.a.mbc) {
                b(gVar.maj);
            }
        }
        if ((!vVar.maN || vVar.mao != 0) && vVar.maS != null) {
            a(str2, vVar, gVar);
        }
        AppMethodBeat.o(217232);
    }

    private void a(String str, b.v vVar, g gVar) {
        AppMethodBeat.i(217233);
        if (ZU(str + "#label") != null) {
            Log.e("MicroMsg.DefaultTencentMapView", "addLabelMarker label is exist, label id:%s", str + "#label");
            AppMethodBeat.o(217233);
        } else if (vVar.maS == null) {
            Log.e("MicroMsg.DefaultTencentMapView", "addLabelMarker labelStyle is null, label id:%s", str + "#label");
            AppMethodBeat.o(217233);
        } else {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(new LatLng(vVar.latitude, vVar.longitude));
            com.tencent.mm.plugin.appbrand.widget.e.d bHn = i.bHn();
            if (bHn == null) {
                bHn = new com.tencent.mm.plugin.appbrand.widget.e.d(this.context);
            }
            bHn.reset();
            bHn.setTextColor(vVar.maS.color);
            bHn.setTextSize(vVar.maS.maT);
            bHn.setText(vVar.maS.content);
            bHn.setTextPadding(vVar.maS.padding);
            bHn.setGravity(vVar.maS.kZR);
            bHn.A(vVar.maS.maU, vVar.maS.rc, vVar.maS.borderColor, vVar.maS.bgColor);
            bHn.setX(vVar.maS.x);
            bHn.setY(vVar.maS.y);
            bHn.eN(vVar.maS.width, vVar.maS.height);
            bHn.measure(0, 0);
            markerOptions.anchor(bHn.getAnchorX(), bHn.getAnchorY());
            markerOptions.markerView(bHn);
            markerOptions.visible(true);
            markerOptions.tag(str + "#label");
            markerOptions.zIndex(vVar.zIndex + 3);
            markerOptions.level(OverlayLevel.OverlayLevelAboveLabels);
            if (!Util.isNullOrNil(vVar.buildingId) && !Util.isNullOrNil(vVar.floorName)) {
                markerOptions.indoorInfo(new IndoorInfo(vVar.buildingId, vVar.floorName));
            }
            Marker addMarker = this.lYw.getMap().addMarker(markerOptions);
            if (gVar == null) {
                gVar = new g();
                gVar.data = vVar.data;
                gVar.maM = vVar;
            }
            gVar.maq = addMarker;
            a(str + "#label", gVar);
            AppMethodBeat.o(217233);
        }
    }

    private void c(String str, b.v vVar, com.tencent.mm.plugin.appbrand.f.a aVar) {
        final Marker marker;
        Marker marker2;
        Marker marker3;
        Bitmap bitmap = null;
        AppMethodBeat.i(217234);
        if (vVar.mao > 0 && this.lZt.contains(Integer.valueOf(vVar.mao))) {
            Cluster<f> cluster = this.lZv.get(Integer.valueOf(vVar.mao));
            if (cluster != null) {
                marker3 = ((e) this.lYK.getRenderer()).getMarker(cluster);
            } else {
                marker3 = null;
            }
            marker = marker3;
        } else if (vVar.maN) {
            f ZX = ZX(str);
            if (ZX != null) {
                marker2 = ((e) this.lYK.getRenderer()).getMarker(ZX);
            } else {
                marker2 = null;
            }
            this.lZw.put(str, vVar);
            if (this.lZx == null) {
                this.lZx = aVar;
            }
            marker = marker2;
        } else {
            marker = null;
        }
        if (marker != null) {
            if (vVar.maN) {
                marker.setPosition(new LatLng(vVar.latitude, vVar.longitude));
            }
            if (!Util.isNullOrNil(vVar.title)) {
                marker.setTitle(vVar.title);
            }
            if (!Util.isNullOrNil(vVar.maQ)) {
                marker.setContentDescription(vVar.maQ);
            }
            marker.setRotation(vVar.mat);
            marker.setAlpha(vVar.alpha);
            final FrameLayout frameLayout = (FrameLayout) ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.z3, (ViewGroup) null);
            final ImageView imageView = (ImageView) frameLayout.findViewById(R.id.fa0);
            final float f2 = vVar.maO;
            final float f3 = vVar.maP;
            if (aVar != null) {
                if (!Util.isNullOrNil(vVar.mav)) {
                    if (imageView != null) {
                        imageView.setImageBitmap(null);
                    }
                    bitmap = aVar.a(vVar.mav, (Rect) null, new a.b() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass15 */

                        @Override // com.tencent.mm.plugin.appbrand.f.a.b
                        public final void Q(Bitmap bitmap) {
                            AppMethodBeat.i(217194);
                            if (bitmap != null) {
                                a.b(f2, f3, bitmap, imageView);
                                if (marker != null) {
                                    Log.v("MicroMsg.DefaultTencentMapView", "setMarkerView");
                                    marker.setMarkerView(frameLayout);
                                }
                            }
                            AppMethodBeat.o(217194);
                        }
                    });
                } else if (imageView != null) {
                    imageView.setImageBitmap(null);
                }
            }
            if (bitmap != null) {
                a(f2, f3, bitmap, imageView);
            } else {
                Log.e("MicroMsg.DefaultTencentMapView", "[addMarker] bitmap is null, use default");
            }
            marker.setMarkerView(frameLayout);
            marker.setAnchor(vVar.anchorX, vVar.anchorY);
            marker.setTag(str);
            marker.setInfoWindowHideAnimation(new Animation() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass16 */
            });
            marker.setInfoWindowShowAnimation(new Animation() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass17 */
            });
            marker.setVisible(true);
            marker.setZIndex((float) (vVar.zIndex + 2));
            marker.setLevel(OverlayLevel.OverlayLevelAboveLabels);
        }
        AppMethodBeat.o(217234);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void a(String str, b.v vVar) {
        AppMethodBeat.i(182816);
        Log.i("MicroMsg.DefaultTencentMapView", "map:%s updateMarker markerId:%s", this, str);
        final g ZU = ZU(str);
        if (ZU != null) {
            if (vVar.maR != null) {
                if (vVar.maR.view != null) {
                    ZU.maM.maR = vVar.maR;
                    if (ZU.maj != null) {
                        ZU.maj.setInfoWindowOffset(vVar.maR.maZ, vVar.maR.mba);
                    }
                    if (ZU.maj != null && vVar.maR.maY == b.v.a.mbc) {
                        b(ZU.maj);
                    } else if (ZU.maj != null) {
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            ZU.maj.refreshInfoWindow();
                        } else {
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass22 */

                                public final void run() {
                                    AppMethodBeat.i(217196);
                                    ZU.maj.refreshInfoWindow();
                                    AppMethodBeat.o(217196);
                                }
                            });
                        }
                    }
                } else {
                    ZU.mar = null;
                }
            }
            if (vVar.maS != null) {
                ZU.maq.remove();
                ZV(str + "#label");
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(new LatLng(vVar.latitude, vVar.longitude));
                com.tencent.mm.plugin.appbrand.widget.e.d bHn = i.bHn();
                if (bHn == null) {
                    bHn = new com.tencent.mm.plugin.appbrand.widget.e.d(this.context);
                }
                bHn.reset();
                bHn.setTextColor(vVar.maS.color);
                bHn.setTextSize(vVar.maS.maT);
                bHn.setText(vVar.maS.content);
                bHn.setTextPadding(vVar.maS.padding);
                bHn.setGravity(vVar.maS.kZR);
                bHn.A(vVar.maS.maU, vVar.maS.rc, vVar.maS.borderColor, vVar.maS.bgColor);
                bHn.setX(vVar.maS.x);
                bHn.setY(vVar.maS.y);
                bHn.eN(vVar.maS.width, vVar.maS.height);
                bHn.measure(0, 0);
                markerOptions.anchor(bHn.getAnchorX(), bHn.getAnchorY());
                markerOptions.markerView(bHn);
                markerOptions.visible(true);
                markerOptions.tag(str + "#label");
                markerOptions.zIndex(vVar.zIndex + 3);
                markerOptions.level(OverlayLevel.OverlayLevelAboveLabels);
                if (!Util.isNullOrNil(vVar.buildingId) && !Util.isNullOrNil(vVar.floorName)) {
                    markerOptions.indoorInfo(new IndoorInfo(vVar.buildingId, vVar.floorName));
                }
                ZU.maq = this.lYw.getMap().addMarker(markerOptions);
                a(str + "#label", ZU);
            }
        }
        AppMethodBeat.o(182816);
    }

    private void b(final Marker marker) {
        AppMethodBeat.i(217235);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            marker.showInfoWindow();
            AppMethodBeat.o(217235);
            return;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass23 */

            public final void run() {
                AppMethodBeat.i(217197);
                marker.showInfoWindow();
                AppMethodBeat.o(217197);
            }
        });
        AppMethodBeat.o(217235);
    }

    private static void a(float f2, float f3, Bitmap bitmap, ImageView imageView) {
        AppMethodBeat.i(146537);
        if (imageView == null) {
            Log.e("MicroMsg.DefaultTencentMapView", "markerIcon is null, err");
            AppMethodBeat.o(146537);
            return;
        }
        if (f2 == 0.0f || f3 == 0.0f) {
            f2 = (float) com.tencent.mm.plugin.appbrand.ac.g.zD(bitmap.getWidth());
            f3 = (float) com.tencent.mm.plugin.appbrand.ac.g.zD(bitmap.getHeight());
        }
        if (f2 <= 0.0f || f3 <= 0.0f || (f2 == ((float) bitmap.getWidth()) && f3 == ((float) bitmap.getHeight()))) {
            imageView.setImageBitmap(bitmap);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            AppMethodBeat.o(146537);
            return;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f2 / ((float) bitmap.getWidth()), f3 / ((float) bitmap.getHeight()));
        imageView.setImageBitmap(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true));
        AppMethodBeat.o(146537);
    }

    private void a(String str, g gVar) {
        AppMethodBeat.i(146538);
        Log.i("MicroMsg.DefaultTencentMapView", "map:%s addMarker markerId:%s", this, str);
        this.lZh.put(str, gVar);
        AppMethodBeat.o(146538);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void a(String str, LinkedList<b.h> linkedList, final b.r rVar) {
        AppMethodBeat.i(146539);
        g ZU = ZU(str);
        if (ZU == null || ZU.maj == null) {
            Log.e("MicroMsg.DefaultTencentMapView", "get marker failed!");
            rVar.hv(false);
            AppMethodBeat.o(146539);
        } else if (linkedList.size() <= 0) {
            Log.e("MicroMsg.DefaultTencentMapView", "keyFrame is empty, err, return");
            rVar.hv(false);
            AppMethodBeat.o(146539);
        } else {
            b.h hVar = linkedList.get(0);
            hVar.maD = ZU.maj.getPosition().getLatitude();
            hVar.maC = ZU.maj.getPosition().getLongitude();
            int size = linkedList.size();
            for (int i2 = 1; i2 < size; i2++) {
                b.h hVar2 = linkedList.get(i2 - 1);
                b.h hVar3 = linkedList.get(i2);
                if (hVar2.mat == 0.0f) {
                    hVar3.maC = hVar2.longitude;
                    hVar3.maD = hVar2.latitude;
                } else {
                    hVar3.maC = ZU.maj.getPosition().getLongitude();
                    hVar3.maD = ZU.maj.getPosition().getLatitude();
                }
            }
            final com.tencent.mm.plugin.appbrand.widget.e.c cVar = new com.tencent.mm.plugin.appbrand.widget.e.c(linkedList, ZU.maj, this.lYw);
            cVar.xc.addListener(new Animator.AnimatorListener() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass24 */

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(217198);
                    Log.d("MicroMsg.DefaultTencentMapView", "MarkerAnimator start");
                    AppMethodBeat.o(217198);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(217199);
                    Log.d("MicroMsg.DefaultTencentMapView", "MarkerAnimator end");
                    if (rVar != null) {
                        rVar.hv(true);
                    }
                    AppMethodBeat.o(217199);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
            m.runOnUiThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass25 */

                public final void run() {
                    AppMethodBeat.i(217200);
                    cVar.xc.start();
                    AppMethodBeat.o(217200);
                }
            });
            if (ZU.maq != null) {
                final com.tencent.mm.plugin.appbrand.widget.e.c cVar2 = new com.tencent.mm.plugin.appbrand.widget.e.c(linkedList, ZU.maq, this.lYw);
                m.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass26 */

                    public final void run() {
                        AppMethodBeat.i(217201);
                        cVar2.xc.start();
                        AppMethodBeat.o(217201);
                    }
                });
            }
            AppMethodBeat.o(146539);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void a(final String str, ArrayList<b.i> arrayList, long j2, boolean z, final b.r rVar) {
        AppMethodBeat.i(217236);
        g ZU = ZU(str);
        if (ZU == null || ZU.maj == null) {
            Log.e("MicroMsg.DefaultTencentMapView", "get marker failed!");
            rVar.hv(false);
            AppMethodBeat.o(217236);
        } else if (arrayList.size() <= 0) {
            Log.e("MicroMsg.DefaultTencentMapView", "keyFrame is empty, err, return");
            rVar.hv(false);
            AppMethodBeat.o(217236);
        } else {
            synchronized (this.lYI) {
                try {
                    if (this.lYI.containsKey(str)) {
                        final MarkerTranslateAnimator markerTranslateAnimator = this.lYI.get(str);
                        m.runOnUiThread(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass27 */

                            public final void run() {
                                AppMethodBeat.i(217202);
                                markerTranslateAnimator.cancelAnimation();
                                AppMethodBeat.o(217202);
                            }
                        });
                    }
                } finally {
                    AppMethodBeat.o(217236);
                }
            }
            LatLng[] latLngArr = new LatLng[arrayList.size()];
            int i2 = 0;
            Iterator<b.i> it = arrayList.iterator();
            while (it.hasNext()) {
                b.i next = it.next();
                latLngArr[i2] = new LatLng(next.latitude, next.longitude);
                i2++;
            }
            final MarkerTranslateAnimator markerTranslateAnimator2 = new MarkerTranslateAnimator(ZU.maj, j2, latLngArr, z);
            markerTranslateAnimator2.addAnimatorListener(new Animator.AnimatorListener() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass28 */

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(217203);
                    Log.i("MicroMsg.DefaultTencentMapView", "MarkerTranslateAnimator onAnimationStart");
                    AppMethodBeat.o(217203);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(217204);
                    Log.i("MicroMsg.DefaultTencentMapView", "MarkerTranslateAnimator onAnimationEnd");
                    if (rVar != null) {
                        rVar.hv(true);
                    }
                    synchronized (a.this.lYI) {
                        try {
                            a.this.lYI.remove(str);
                        } finally {
                            AppMethodBeat.o(217204);
                        }
                    }
                }

                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.i(217205);
                    Log.i("MicroMsg.DefaultTencentMapView", "MarkerTranslateAnimator onAnimationCancel");
                    if (rVar != null) {
                        rVar.bGP();
                    }
                    synchronized (a.this.lYI) {
                        try {
                            a.this.lYI.remove(str);
                        } finally {
                            AppMethodBeat.o(217205);
                        }
                    }
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
            synchronized (this.lYI) {
                try {
                    this.lYI.put(str, markerTranslateAnimator2);
                } finally {
                    AppMethodBeat.o(217236);
                }
            }
            m.runOnUiThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass29 */

                public final void run() {
                    AppMethodBeat.i(217206);
                    Log.d("MicroMsg.DefaultTencentMapView", "MarkerTranslateAnimator start");
                    markerTranslateAnimator2.startAnimation();
                    AppMethodBeat.o(217206);
                }
            });
            if (ZU.maq != null) {
                Log.d("MicroMsg.DefaultTencentMapView", "labelMarker do move animator");
                synchronized (this.lYJ) {
                    try {
                        if (this.lYJ.containsKey(str)) {
                            final MarkerTranslateAnimator markerTranslateAnimator3 = this.lYJ.get(str);
                            m.runOnUiThread(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass30 */

                                public final void run() {
                                    AppMethodBeat.i(217207);
                                    markerTranslateAnimator3.cancelAnimation();
                                    AppMethodBeat.o(217207);
                                }
                            });
                        }
                    } finally {
                        AppMethodBeat.o(217236);
                    }
                }
                final MarkerTranslateAnimator markerTranslateAnimator4 = new MarkerTranslateAnimator(ZU.maq, j2, latLngArr, z);
                markerTranslateAnimator4.addAnimatorListener(new Animator.AnimatorListener() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass32 */

                    public final void onAnimationStart(Animator animator) {
                    }

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(217208);
                        synchronized (a.this.lYJ) {
                            try {
                                a.this.lYJ.remove(str);
                            } finally {
                                AppMethodBeat.o(217208);
                            }
                        }
                    }

                    public final void onAnimationCancel(Animator animator) {
                        AppMethodBeat.i(217209);
                        synchronized (a.this.lYJ) {
                            try {
                                a.this.lYJ.remove(str);
                            } finally {
                                AppMethodBeat.o(217209);
                            }
                        }
                    }

                    public final void onAnimationRepeat(Animator animator) {
                    }
                });
                synchronized (this.lYJ) {
                    try {
                        this.lYJ.put(str, markerTranslateAnimator4);
                    } finally {
                        AppMethodBeat.o(217236);
                    }
                }
                m.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass33 */

                    public final void run() {
                        AppMethodBeat.i(217210);
                        markerTranslateAnimator4.startAnimation();
                        AppMethodBeat.o(217210);
                    }
                });
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void a(b.p pVar) {
        this.lYz = pVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void a(b.l lVar) {
        this.lYy = lVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void a(b.o oVar) {
        this.lYA = oVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void a(b.s sVar) {
        this.lYB = sVar;
    }

    public class c {
        Marker maj;

        public c(Marker marker) {
            this.maj = marker;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void bHd() {
        AppMethodBeat.i(146540);
        synchronized (this.lZi) {
            try {
                Iterator<c> it = this.lZi.iterator();
                while (it.hasNext()) {
                    it.next().maj.remove();
                }
                this.lZi.clear();
            } finally {
                AppMethodBeat.o(146540);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final boolean a(b.d dVar, com.tencent.mm.plugin.appbrand.f.a aVar) {
        AppMethodBeat.i(146541);
        if (Util.isNullOrNil(dVar.mav)) {
            AppMethodBeat.o(146541);
            return false;
        }
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(new LatLng(dVar.latitude, dVar.longitude));
        Bitmap cR = aVar.cR(dVar.mav);
        if (cR != null && !cR.isRecycled()) {
            markerOptions.icon(new BitmapDescriptor(cR));
        }
        markerOptions.rotation(dVar.mat);
        Marker addMarker = this.lYw.getMap().addMarker(markerOptions);
        synchronized (this.lZi) {
            try {
                this.lZi.add(new c(addMarker));
            } catch (Throwable th) {
                AppMethodBeat.o(146541);
                throw th;
            }
        }
        AppMethodBeat.o(146541);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void bHe() {
        AppMethodBeat.i(146542);
        synchronized (this.lZj) {
            try {
                Iterator<Polygon> it = this.lZj.iterator();
                while (it.hasNext()) {
                    it.next().remove();
                }
                this.lZj.clear();
            } finally {
                AppMethodBeat.o(146542);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final boolean a(b.ab abVar) {
        AppMethodBeat.i(146543);
        PolygonOptions polygonOptions = new PolygonOptions();
        ArrayList arrayList = new ArrayList();
        for (b.i iVar : abVar.maG) {
            arrayList.add(new LatLng(iVar.latitude, iVar.longitude));
        }
        polygonOptions.addAll(arrayList);
        polygonOptions.fillColor(abVar.fillColor);
        polygonOptions.strokeColor(abVar.strokeColor);
        polygonOptions.strokeWidth((float) abVar.strokeWidth);
        polygonOptions.zIndex((float) abVar.zIndex);
        int ZY = ZY(abVar.mau);
        if (ZY >= 0) {
            polygonOptions.level(ZY);
        }
        Polygon addPolygon = this.lYw.getMap().addPolygon(polygonOptions);
        synchronized (this.lZj) {
            try {
                this.lZj.add(addPolygon);
            } catch (Throwable th) {
                AppMethodBeat.o(146543);
                throw th;
            }
        }
        AppMethodBeat.o(146543);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void hH(boolean z) {
        AppMethodBeat.i(146544);
        Log.i("MicroMsg.DefaultTencentMapView", "map:%s show location", this);
        this.lZk = z;
        if (z) {
            if (this.lZl != null) {
                d dVar = this.lZl;
                if (dVar.maj != null) {
                    dVar.maj.setVisible(true);
                }
            }
            ((com.tencent.mm.plugin.appbrand.utils.b.a) com.tencent.luggage.a.e.M(com.tencent.mm.plugin.appbrand.utils.b.a.class)).b("gcj02", this.lZm, bHf());
            g.a(this);
            AppMethodBeat.o(146544);
            return;
        }
        if (this.lZl != null) {
            d dVar2 = this.lZl;
            if (dVar2.maj != null) {
                dVar2.maj.setVisible(false);
            }
        }
        ((com.tencent.mm.plugin.appbrand.utils.b.a) com.tencent.luggage.a.e.M(com.tencent.mm.plugin.appbrand.utils.b.a.class)).c("gcj02", this.lZm, bHf());
        g.b(this);
        AppMethodBeat.o(146544);
    }

    private Bundle bHf() {
        AppMethodBeat.i(146545);
        Bundle bundle = new Bundle();
        if (!lYC.equals(this.lYD)) {
            bundle.putString("smallAppKey", Util.nullAsNil(bundle.getString("smallAppKey")) + this.lYD + "#" + this.lYE + ";");
        }
        AppMethodBeat.o(146545);
        return bundle;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.h
    public final void L(float f2, float f3) {
        AppMethodBeat.i(146546);
        if (!this.lZk || this.lYx) {
            AppMethodBeat.o(146546);
            return;
        }
        if (this.lZl != null) {
            this.lZl.L(f2, f3);
        }
        AppMethodBeat.o(146546);
    }

    public String toString() {
        AppMethodBeat.i(146547);
        String str = "DefaultTencentMapView{mapId=" + this.lYv + '}';
        AppMethodBeat.o(146547);
        return str;
    }

    private static SurfaceView i(ViewGroup viewGroup) {
        AppMethodBeat.i(146548);
        while (viewGroup != null && viewGroup.getChildCount() != 0) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt instanceof SurfaceView) {
                    SurfaceView surfaceView = (SurfaceView) childAt;
                    AppMethodBeat.o(146548);
                    return surfaceView;
                } else if (childAt instanceof ViewGroup) {
                    viewGroup = (ViewGroup) childAt;
                }
            }
            AppMethodBeat.o(146548);
            return null;
        }
        AppMethodBeat.o(146548);
        return null;
    }

    /* access modifiers changed from: package-private */
    public static class f implements ClusterItem {
        private String id;
        private LatLng man;
        int mao;

        f(String str, LatLng latLng) {
            this.id = str;
            this.man = latLng;
        }

        @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterItem
        public final LatLng getPosition() {
            return this.man;
        }
    }

    public final boolean b(Cluster<f> cluster) {
        AppMethodBeat.i(217237);
        Log.i("MicroMsg.DefaultTencentMapView", "onClusterClick");
        if (this.lZy) {
            LinkedList linkedList = new LinkedList();
            for (f fVar : cluster.getItems()) {
                linkedList.add(fVar.getPosition());
            }
            i(linkedList, 0);
        }
        if (this.lZq != null) {
            this.lZq.aa(a(cluster, false));
        }
        AppMethodBeat.o(217237);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final boolean bHg() {
        return (this.lYK == null || this.lYL == null) ? false : true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final boolean bHh() {
        return this.lYM;
    }

    private boolean a(b.aa aaVar) {
        AppMethodBeat.i(217239);
        if (this.lYw.getMap() == null) {
            Log.e("MicroMsg.DefaultTencentMapView", "addMapMarkerCluster map is null");
            AppMethodBeat.o(217239);
            return false;
        } else if (!bHg()) {
            Log.e("MicroMsg.DefaultTencentMapView", "addMapMarkerCluster mClusterManager is not initialize");
            AppMethodBeat.o(217239);
            return false;
        } else {
            f b2 = b(aaVar);
            this.lZr.add(b2);
            this.lZs.add(b2.id);
            this.lYK.addItem(b2);
            this.lYK.cluster();
            Log.i("MicroMsg.DefaultTencentMapView", "addMapMarkerCluster mClusterItems:%d， id:%s， latitude:%f, longitude:%f", Integer.valueOf(this.lZr.size()), aaVar.id, Double.valueOf(b2.getPosition().getLatitude()), Double.valueOf(b2.getPosition().getLongitude()));
            AppMethodBeat.o(217239);
            return true;
        }
    }

    private static f b(b.aa aaVar) {
        AppMethodBeat.i(217240);
        f fVar = new f(aaVar.id, new LatLng(aaVar.mbd.latitude, aaVar.mbd.longitude));
        AppMethodBeat.o(217240);
        return fVar;
    }

    private f ZX(String str) {
        AppMethodBeat.i(217241);
        Iterator<f> it = this.lZr.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (str.contains(next.id)) {
                AppMethodBeat.o(217241);
                return next;
            }
        }
        AppMethodBeat.o(217241);
        return null;
    }

    private boolean bHi() {
        AppMethodBeat.i(217242);
        Log.i("MicroMsg.DefaultTencentMapView", "removeAllMapCluster");
        if (this.lYK != null) {
            Iterator<f> it = this.lZr.iterator();
            while (it.hasNext()) {
                this.lYK.removeItem(it.next());
            }
            this.lZs.clear();
            this.lZr.clear();
            this.lYK.cluster();
            this.lZt.clear();
            this.lZw.clear();
            AppMethodBeat.o(217242);
            return true;
        }
        AppMethodBeat.o(217242);
        return false;
    }

    /* access modifiers changed from: package-private */
    public class e extends DefaultClusterRenderer<f> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterItem, com.tencent.mapsdk.raster.model.MarkerOptions] */
        @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.DefaultClusterRenderer
        public final /* synthetic */ void onBeforeClusterItemRendered(f fVar, MarkerOptions markerOptions) {
            AppMethodBeat.i(217222);
            final f fVar2 = fVar;
            super.onBeforeClusterItemRendered(fVar2, markerOptions);
            Log.i("MicroMsg.DefaultTencentMapView", "onBeforeClusterItemRendered");
            if (fVar2.mao > 0 && a.this.lZt.contains(Integer.valueOf(fVar2.mao))) {
                Log.i("MicroMsg.DefaultTencentMapView", "remove clusterId:%d", Integer.valueOf(fVar2.mao));
                a.this.ZW(new StringBuilder().append(fVar2.mao).toString());
                a.this.lZt.remove(Integer.valueOf(fVar2.mao));
                a.this.lZv.remove(Integer.valueOf(fVar2.mao));
                a.this.lYK.cluster();
            }
            fVar2.mao = 0;
            Marker marker = getMarker(fVar2);
            final b.v vVar = (b.v) a.this.lZw.get(fVar2.id);
            a.a(a.this, fVar2.id, markerOptions, vVar, marker);
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.e.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(217220);
                    Marker marker = e.this.getMarker(fVar2);
                    if (fVar2.mao == 0) {
                        a.a(a.this, fVar2.id, vVar);
                        if (vVar.maR != null && vVar.maR.maY == b.v.a.mbc) {
                            a.a(a.this, marker);
                        }
                    }
                    AppMethodBeat.o(217220);
                }
            }, 200);
            AppMethodBeat.o(217222);
        }

        public e(Context context, TencentMap tencentMap, ClusterManager<f> clusterManager) {
            super(context, tencentMap, clusterManager);
        }

        @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.DefaultClusterRenderer
        public final void onBeforeClusterRendered(Cluster<f> cluster, MarkerOptions markerOptions) {
            AppMethodBeat.i(217221);
            super.onBeforeClusterRendered(cluster, markerOptions);
            Log.i("MicroMsg.DefaultTencentMapView", "onBeforeClusterRendered, cluster size:%d", Integer.valueOf(cluster.getItems().size()));
            for (f fVar : cluster.getItems()) {
                if (fVar.mao > 0) {
                    a.this.ZW(new StringBuilder().append(fVar.mao).toString());
                }
                a.this.ZW(fVar.id);
            }
            if (a.this.lZq != null) {
                a.this.lZq.p(a.a(a.this, cluster));
            }
            AppMethodBeat.o(217221);
        }
    }

    class d extends ClusterManager<f> {
        public d(Context context, TencentMap tencentMap) {
            super(context, tencentMap);
        }

        @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager, com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener
        public final void onCameraChange(CameraPosition cameraPosition) {
            AppMethodBeat.i(217218);
            super.onCameraChange(cameraPosition);
            if (a.this.lYU != null) {
                b.a aVar = new b.a();
                aVar.mas = new b.i(cameraPosition.getTarget().getLatitude(), cameraPosition.getTarget().getLongitude());
                aVar.zoom = cameraPosition.getZoom();
                aVar.mat = cameraPosition.getBearing();
                aVar.skew = cameraPosition.getSkew();
                a.this.lYU.a(aVar, a.this.lYT);
            }
            AppMethodBeat.o(217218);
        }

        @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager, com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener
        public final void onCameraChangeFinish(CameraPosition cameraPosition) {
            AppMethodBeat.i(217219);
            super.onCameraChangeFinish(cameraPosition);
            Log.i("MicroMsg.DefaultTencentMapView", "onCameraChangeFinish");
            if (a.this.lYU != null) {
                b.a aVar = new b.a();
                aVar.mas = new b.i(cameraPosition.getTarget().getLatitude(), cameraPosition.getTarget().getLongitude());
                aVar.zoom = cameraPosition.getZoom();
                aVar.mat = cameraPosition.getBearing();
                aVar.skew = cameraPosition.getSkew();
                a.this.lYU.b(aVar, a.this.lYT);
                a.this.lYT = false;
            }
            a.j(a.this);
            if (a.this.lYK != null && a.this.lYK.getAlgorithm().getClusters((double) cameraPosition.getZoom()).size() > 0) {
                Set clusters = ((NonHierarchicalDistanceBasedAlgorithm) ((PreCachingAlgorithmDecorator) a.this.lYK.getAlgorithm()).getAlgorithm()).getClusters((double) cameraPosition.getZoom());
                Log.i("MicroMsg.DefaultTencentMapView", "onCameraChangeFinish cluster size:%d", Integer.valueOf(clusters.size()));
                Iterator it = clusters.iterator();
                while (it.hasNext()) {
                    Log.i("MicroMsg.DefaultTencentMapView", "onCameraChangeFinish cluster item size:%d", Integer.valueOf(((Cluster) it.next()).getItems().size()));
                }
            }
            AppMethodBeat.o(217219);
        }
    }

    private JSONObject a(Cluster<f> cluster, boolean z) {
        AppMethodBeat.i(217243);
        int i2 = 0;
        if (z) {
            try {
                int andIncrement = this.lZu.getAndIncrement();
                this.lZt.add(Integer.valueOf(andIncrement));
                this.lZv.put(Integer.valueOf(andIncrement), cluster);
                for (f fVar : cluster.getItems()) {
                    fVar.mao = andIncrement;
                }
                i2 = andIncrement;
            } catch (Exception | JSONException e2) {
                AppMethodBeat.o(217243);
                return null;
            }
        } else {
            Iterator<f> it = cluster.getItems().iterator();
            if (it.hasNext()) {
                i2 = it.next().mao;
            }
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("clusterId", i2);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("latitude", cluster.getPosition().getLatitude());
        jSONObject2.put("longitude", cluster.getPosition().getLongitude());
        jSONObject.put("center", jSONObject2);
        JSONArray jSONArray = new JSONArray();
        for (f fVar2 : cluster.getItems()) {
            jSONArray.put(fVar2.id);
        }
        jSONObject.put("markerIds", jSONArray);
        AppMethodBeat.o(217243);
        return jSONObject;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final boolean a(final int i2, b.e eVar, com.tencent.mm.plugin.appbrand.f.a aVar) {
        AppMethodBeat.i(217244);
        if (i2 < 0) {
            Log.e("MicroMsg.DefaultTencentMapView", "addGroundOverlay fail, id < 0 or options is null");
            AppMethodBeat.o(217244);
            return false;
        }
        Log.i("MicroMsg.DefaultTencentMapView", "remove GroundOverlay id:%d, first ,and than add again", Integer.valueOf(i2));
        xf(i2);
        Log.i("MicroMsg.DefaultTencentMapView", "addGroundOverlay id:%d", Integer.valueOf(i2));
        final GroundOverlayOptions groundOverlayOptions = new GroundOverlayOptions();
        if (!(eVar.may == null || eVar.maz == null)) {
            com.tencent.tencentmap.mapsdk.maps.model.LatLng latLng = new com.tencent.tencentmap.mapsdk.maps.model.LatLng();
            latLng.longitude = eVar.may.longitude;
            latLng.latitude = eVar.may.latitude;
            com.tencent.tencentmap.mapsdk.maps.model.LatLng latLng2 = new com.tencent.tencentmap.mapsdk.maps.model.LatLng();
            latLng2.longitude = eVar.maz.longitude;
            latLng2.latitude = eVar.maz.latitude;
            groundOverlayOptions.latLngBounds(new com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds(latLng2, latLng));
        }
        groundOverlayOptions.alpha(eVar.alpha);
        groundOverlayOptions.visible(eVar.visible);
        groundOverlayOptions.zIndex(eVar.zIndex);
        if (aVar != null && !TextUtils.isEmpty(eVar.mav)) {
            Bitmap a2 = aVar.a(eVar.mav, (Rect) null, new a.b() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass37 */

                @Override // com.tencent.mm.plugin.appbrand.f.a.b
                public final void Q(Bitmap bitmap) {
                    AppMethodBeat.i(217216);
                    if (bitmap != null) {
                        groundOverlayOptions.bitmap(BitmapDescriptorFactory.fromBitmap(bitmap));
                        GroundOverlay addGroundOverlay = a.this.lYw.getMap().addGroundOverlay(groundOverlayOptions);
                        if (addGroundOverlay == null) {
                            Log.e("MicroMsg.DefaultTencentMapView", "addGroundOverlay fail, groundOverlay is null");
                            AppMethodBeat.o(217216);
                            return;
                        }
                        a.this.lZA.put(new StringBuilder().append(i2).toString(), addGroundOverlay);
                        Log.i("MicroMsg.DefaultTencentMapView", "addGroundOverlay success id:%d", Integer.valueOf(i2));
                        AppMethodBeat.o(217216);
                        return;
                    }
                    Log.e("MicroMsg.DefaultTencentMapView", "groundOverlay load bitmap is null");
                    AppMethodBeat.o(217216);
                }
            });
            if (a2 != null) {
                groundOverlayOptions.bitmap(BitmapDescriptorFactory.fromBitmap(a2));
                GroundOverlay addGroundOverlay = this.lYw.getMap().addGroundOverlay(groundOverlayOptions);
                if (addGroundOverlay == null) {
                    Log.e("MicroMsg.DefaultTencentMapView", "addGroundOverlay fail, groundOverlay is null");
                    AppMethodBeat.o(217244);
                    return false;
                }
                this.lZA.put(String.valueOf(i2), addGroundOverlay);
                Log.i("MicroMsg.DefaultTencentMapView", "addGroundOverlay success id:%d", Integer.valueOf(i2));
            }
        } else if (aVar != null) {
            Log.e("MicroMsg.DefaultTencentMapView", "groundOverlay icon path is null");
            AppMethodBeat.o(217244);
            return false;
        }
        AppMethodBeat.o(217244);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final boolean xf(int i2) {
        AppMethodBeat.i(217245);
        if (!this.lZA.containsKey(String.valueOf(i2))) {
            Log.e("MicroMsg.DefaultTencentMapView", "removeGroundOverlay fail, groundOverlay not exist");
            AppMethodBeat.o(217245);
            return false;
        }
        Log.i("MicroMsg.DefaultTencentMapView", "removeGroundOverlay id:%d", Integer.valueOf(i2));
        GroundOverlay remove = this.lZA.remove(String.valueOf(i2));
        if (remove != null) {
            remove.remove();
            AppMethodBeat.o(217245);
            return true;
        }
        AppMethodBeat.o(217245);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final boolean b(final int i2, b.e eVar, com.tencent.mm.plugin.appbrand.f.a aVar) {
        AppMethodBeat.i(217246);
        if (!this.lZA.containsKey(String.valueOf(i2))) {
            Log.e("MicroMsg.DefaultTencentMapView", "updateGroundOverlay fail, groundOverlay not exist");
            AppMethodBeat.o(217246);
            return false;
        }
        final GroundOverlay groundOverlay = this.lZA.get(String.valueOf(i2));
        if (groundOverlay == null) {
            Log.e("MicroMsg.DefaultTencentMapView", "updateGroundOverlay fail, groundOverlay is null");
            AppMethodBeat.o(217246);
            return false;
        }
        Log.i("MicroMsg.DefaultTencentMapView", "updateGroundOverlay id:%d", Integer.valueOf(i2));
        if (!(eVar.may == null || eVar.maz == null)) {
            com.tencent.tencentmap.mapsdk.maps.model.LatLng latLng = new com.tencent.tencentmap.mapsdk.maps.model.LatLng();
            latLng.longitude = eVar.may.longitude;
            latLng.latitude = eVar.may.latitude;
            com.tencent.tencentmap.mapsdk.maps.model.LatLng latLng2 = new com.tencent.tencentmap.mapsdk.maps.model.LatLng();
            latLng2.longitude = eVar.maz.longitude;
            latLng2.latitude = eVar.maz.latitude;
            groundOverlay.setLatLongBounds(new com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds(latLng2, latLng));
        }
        groundOverlay.setAlpha(eVar.alpha);
        groundOverlay.setVisibility(eVar.visible);
        groundOverlay.setZindex(eVar.zIndex);
        if (aVar != null && !TextUtils.isEmpty(eVar.mav)) {
            Bitmap a2 = aVar.a(eVar.mav, (Rect) null, new a.b() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass38 */

                @Override // com.tencent.mm.plugin.appbrand.f.a.b
                public final void Q(Bitmap bitmap) {
                    AppMethodBeat.i(217217);
                    if (bitmap != null) {
                        groundOverlay.setBitmap(BitmapDescriptorFactory.fromBitmap(bitmap));
                        Log.i("MicroMsg.DefaultTencentMapView", "updateGroundOverlay success id:%d", Integer.valueOf(i2));
                        AppMethodBeat.o(217217);
                        return;
                    }
                    Log.e("MicroMsg.DefaultTencentMapView", "groundOverlay load bitmap is null");
                    AppMethodBeat.o(217217);
                }
            });
            if (a2 != null) {
                groundOverlay.setBitmap(BitmapDescriptorFactory.fromBitmap(a2));
                Log.i("MicroMsg.DefaultTencentMapView", "updateGroundOverlay success id:%d", Integer.valueOf(i2));
            }
        } else if (aVar != null) {
            Log.e("MicroMsg.DefaultTencentMapView", "groundOverlay icon path is null");
            AppMethodBeat.o(217246);
            return false;
        }
        AppMethodBeat.o(217246);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final Point a(b.i iVar) {
        AppMethodBeat.i(217247);
        Log.i("MicroMsg.DefaultTencentMapView", ae.NAME);
        Point screenLocation = this.lYw.getMap().getProjection().toScreenLocation(new LatLng(iVar.latitude, iVar.longitude));
        AppMethodBeat.o(217247);
        return screenLocation;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final b.i e(Point point) {
        AppMethodBeat.i(217248);
        Log.i("MicroMsg.DefaultTencentMapView", k.NAME);
        LatLng fromScreenLocation = this.lYw.getMap().getProjection().fromScreenLocation(point);
        b.i iVar = new b.i(fromScreenLocation.getLatitude(), fromScreenLocation.getLongitude());
        AppMethodBeat.o(217248);
        return iVar;
    }

    private static int ZY(String str) {
        AppMethodBeat.i(217249);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(217249);
            return -1;
        } else if (str.equals("abovelabels")) {
            int i2 = OverlayLevel.OverlayLevelAboveLabels;
            AppMethodBeat.o(217249);
            return i2;
        } else if (str.equals("abovebuildings")) {
            int i3 = OverlayLevel.OverlayLevelAboveBuildings;
            AppMethodBeat.o(217249);
            return i3;
        } else if (str.equals("aboveroads")) {
            int i4 = OverlayLevel.OverlayLevelAboveRoads;
            AppMethodBeat.o(217249);
            return i4;
        } else {
            AppMethodBeat.o(217249);
            return -1;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final boolean a(boolean z, boolean z2, final int i2, final int i3, b.q qVar) {
        boolean z3;
        AppMethodBeat.i(217238);
        if (this.lYw.getMap() == null) {
            z3 = false;
        } else {
            this.lYM = true;
            AnonymousClass36 r0 = new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass36 */

                public final void run() {
                    AppMethodBeat.i(217215);
                    if (a.this.lYK == null) {
                        a.this.lYK = new d(a.this.context, a.this.lYw.getMap());
                    }
                    if (a.this.lYL == null) {
                        a.this.lYL = new e(a.this.context, a.this.lYw.getMap(), a.this.lYK);
                        a.this.lYL.setMinClusterSize(i2);
                        NonHierarchicalDistanceBasedAlgorithm nonHierarchicalDistanceBasedAlgorithm = new NonHierarchicalDistanceBasedAlgorithm(a.this.context);
                        nonHierarchicalDistanceBasedAlgorithm.setMaxDistanceAtZoom(i3);
                        a.this.lYK.setAlgorithm(nonHierarchicalDistanceBasedAlgorithm);
                    } else {
                        a.this.lYL.setMinClusterSize(i2);
                        if (a.this.lYK.getAlgorithm() != null && (a.this.lYK.getAlgorithm() instanceof NonHierarchicalDistanceBasedAlgorithm)) {
                            ((NonHierarchicalDistanceBasedAlgorithm) a.this.lYK.getAlgorithm()).setMaxDistanceAtZoom(i3);
                        }
                    }
                    a.this.lYK.setOnClusterClickListener(new ClusterManager.OnClusterClickListener<f>() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass36.AnonymousClass1 */

                        @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager.OnClusterClickListener
                        public final boolean onClusterClick(Cluster<f> cluster) {
                            AppMethodBeat.i(217214);
                            boolean b2 = a.this.b(cluster);
                            AppMethodBeat.o(217214);
                            return b2;
                        }
                    });
                    a.this.lYK.setOnClusterItemClickListener(new ClusterManager.OnClusterItemClickListener<f>() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass36.AnonymousClass2 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterItem] */
                        @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager.OnClusterItemClickListener
                        public final /* bridge */ /* synthetic */ boolean onClusterItemClick(f fVar) {
                            return false;
                        }
                    });
                    Log.i("MicroMsg.DefaultTencentMapView", "init map marker cluster finish");
                    a.this.lYK.setRenderer(a.this.lYL);
                    a.this.lYK.setClusterEnabled(true);
                    a.this.lYw.getMap().setOnMapCameraChangeListener(a.this.lYK);
                    a.this.lYM = false;
                    AppMethodBeat.o(217215);
                }
            };
            if (Looper.myLooper() == Looper.getMainLooper()) {
                r0.run();
            } else {
                MMHandlerThread.postToMainThread(r0);
            }
            z3 = true;
        }
        if (z3) {
            this.lZq = qVar;
            this.lZy = z2;
            this.lZz = z;
            Log.i("MicroMsg.DefaultTencentMapView", "initMapMarkerCluster zoomOnClick:%b, enableDefaultStyle:%b", Boolean.valueOf(z2), Boolean.valueOf(z));
        }
        AppMethodBeat.o(217238);
        return z3;
    }

    static /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(217251);
        Log.i("MicroMsg.DefaultTencentMapView", "clickClusterLabelMarker");
        Cluster<f> cluster = aVar.lZv.get(Integer.valueOf(i2));
        if (cluster != null) {
            Iterator<f> it = cluster.getItems().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().mao == i2) {
                    if (aVar.lZq != null) {
                        aVar.lZq.aa(aVar.a(cluster, false));
                    }
                }
            }
            if (aVar.lZy) {
                LinkedList linkedList = new LinkedList();
                for (f fVar : cluster.getItems()) {
                    linkedList.add(fVar.getPosition());
                }
                aVar.i(linkedList, 0);
            }
        }
        AppMethodBeat.o(217251);
    }

    static /* synthetic */ void j(a aVar) {
        AppMethodBeat.i(217252);
        if (aVar.mMapType == 0 && aVar.lYw != null && !aVar.lZp.get()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - aVar.lastCheckTime > 500) {
                aVar.lastCheckTime = currentTimeMillis;
                if (aVar.lZo.compareAndSet(false, true)) {
                    Log.v("MicroMsg.DefaultTencentMapView", "updateScreenCapture start");
                    aVar.lYw.getMap().getScreenShot(new TencentMap.OnScreenShotListener() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass35 */

                        @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnScreenShotListener
                        public final void onMapScreenShot(Bitmap bitmap) {
                            AppMethodBeat.i(217213);
                            Log.v("MicroMsg.DefaultTencentMapView", "updateScreenCapture end");
                            if (bitmap != null) {
                                a.this.dKU.setImageBitmap(bitmap);
                            }
                            a.this.lZo.set(false);
                            AppMethodBeat.o(217213);
                        }
                    });
                }
            }
        }
        AppMethodBeat.o(217252);
    }

    static /* synthetic */ boolean bHl() {
        AppMethodBeat.i(217256);
        boolean n = i.n(MMApplicationContext.getContext(), "android.permission.ACCESS_FINE_LOCATION");
        AppMethodBeat.o(217256);
        return n;
    }

    static /* synthetic */ void a(a aVar, String str, MarkerOptions markerOptions, b.v vVar, final Marker marker) {
        Bitmap bitmap;
        AppMethodBeat.i(217257);
        markerOptions.position(new LatLng(vVar.latitude, vVar.longitude));
        if (!Util.isNullOrNil(vVar.title)) {
            markerOptions.title(vVar.title);
        }
        if (!Util.isNullOrNil(vVar.maQ)) {
            markerOptions.contentDescription(vVar.maQ);
        }
        markerOptions.rotation(vVar.mat);
        markerOptions.alpha(vVar.alpha);
        final FrameLayout frameLayout = (FrameLayout) ((LayoutInflater) aVar.context.getSystemService("layout_inflater")).inflate(R.layout.z3, (ViewGroup) null);
        final ImageView imageView = (ImageView) frameLayout.findViewById(R.id.fa0);
        final float f2 = vVar.maO;
        final float f3 = vVar.maP;
        if (aVar.lZx == null || Util.isNullOrNil(vVar.mav)) {
            bitmap = null;
        } else {
            if (imageView != null) {
                imageView.setImageBitmap(null);
            }
            bitmap = aVar.lZx.a(vVar.mav, (Rect) null, new a.b() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass18 */

                @Override // com.tencent.mm.plugin.appbrand.f.a.b
                public final void Q(Bitmap bitmap) {
                    AppMethodBeat.i(217195);
                    if (bitmap != null) {
                        a.b(f2, f3, bitmap, imageView);
                        if (marker != null) {
                            Log.v("MicroMsg.DefaultTencentMapView", "setMarkerView");
                            marker.setMarkerView(frameLayout);
                        }
                    }
                    AppMethodBeat.o(217195);
                }
            });
        }
        if (bitmap != null) {
            a(f2, f3, bitmap, imageView);
        } else {
            Log.e("MicroMsg.DefaultTencentMapView", "[addMarker] bitmap is null, use default");
        }
        markerOptions.markerView(frameLayout);
        markerOptions.anchor(vVar.anchorX, vVar.anchorY);
        markerOptions.tag(str);
        markerOptions.infoWindowHideAnimation(new Animation() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass19 */
        });
        markerOptions.infoWindowShowAnimation(new Animation() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.a.AnonymousClass21 */
        });
        markerOptions.visible(true);
        markerOptions.zIndex(vVar.zIndex + 2);
        markerOptions.level(OverlayLevel.OverlayLevelAboveLabels);
        if (!Util.isNullOrNil(vVar.buildingId) && !Util.isNullOrNil(vVar.floorName)) {
            markerOptions.indoorInfo(new IndoorInfo(vVar.buildingId, vVar.floorName));
        }
        if (vVar.maR != null) {
            markerOptions.infoWindowOffset(vVar.maR.maZ, vVar.maR.mba);
        }
        AppMethodBeat.o(217257);
    }

    static /* synthetic */ JSONArray a(a aVar, Cluster cluster) {
        AppMethodBeat.i(217259);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(aVar.a((Cluster<f>) cluster, true));
        AppMethodBeat.o(217259);
        return jSONArray;
    }
}
