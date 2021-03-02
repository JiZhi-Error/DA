package com.tencent.mm.plugin.location_soso.api;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.k.b;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.plugin.k.e;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tencentmap.mapsdk.map.CameraUpdate;
import com.tencent.tencentmap.mapsdk.map.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.map.UiSettings;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class SoSoMapView extends MapView implements d {
    public static final String TAG = "MicroMsg.SoSoMapView";
    private boolean firstanim = true;
    private b iController;
    private ViewManager mViewManager;
    private HashMap<String, Object> tagsView = new HashMap<>();

    public SoSoMapView(Context context) {
        super(context);
        AppMethodBeat.i(146626);
        init();
        AppMethodBeat.o(146626);
    }

    public SoSoMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(146627);
        init();
        AppMethodBeat.o(146627);
    }

    public SoSoMapView(Context context, TencentMapOptions tencentMapOptions) {
        super(context, tencentMapOptions);
        AppMethodBeat.i(146628);
        init();
        AppMethodBeat.o(146628);
    }

    public MapController getController() {
        AppMethodBeat.i(146629);
        MapController mapController = getMapController();
        AppMethodBeat.o(146629);
        return mapController;
    }

    private void setEnableForeignMap(boolean z) {
        AppMethodBeat.i(146630);
        try {
            Method declaredMethod = MapView.class.getDeclaredMethod("setForeignEnabled", Boolean.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, Boolean.valueOf(z));
            AppMethodBeat.o(146630);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(146630);
        }
    }

    private void init() {
        AppMethodBeat.i(146631);
        this.mViewManager = new ViewManager(getMap());
        getMap().set3DEnable(true);
        this.iController = new b() {
            /* class com.tencent.mm.plugin.location_soso.api.SoSoMapView.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.k.b
            public void setZoom(int i2) {
                AppMethodBeat.i(146621);
                Log.d(SoSoMapView.TAG, "set Zoom %d", Integer.valueOf(i2));
                SoSoMapView.this.getMap().moveCamera(CameraUpdateFactory.zoomTo((float) i2));
                AppMethodBeat.o(146621);
            }

            @Override // com.tencent.mm.plugin.k.b
            public void animateTo(double d2, double d3, int i2) {
                AppMethodBeat.i(146622);
                Log.d(SoSoMapView.TAG, "animteTo slat:" + d2 + " slong:" + d3 + " zoom:" + i2);
                if (SoSoMapView.this.firstanim) {
                    SoSoMapView.this.getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(d2, d3), (float) i2));
                } else {
                    SoSoMapView.this.getMap().animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(d2, d3), (float) i2));
                }
                SoSoMapView.this.firstanim = false;
                AppMethodBeat.o(146622);
            }

            @Override // com.tencent.mm.plugin.k.b
            public void animateTo(double d2, double d3) {
                AppMethodBeat.i(146623);
                Log.d(SoSoMapView.TAG, "animteTo slat:" + d2 + " slong:" + d3);
                if (SoSoMapView.this.firstanim) {
                    SoSoMapView.this.getMap().moveCamera(CameraUpdateFactory.newLatLng(new LatLng(d2, d3)));
                } else {
                    SoSoMapView.this.getMap().animateCamera(CameraUpdateFactory.newLatLng(new LatLng(d2, d3)));
                }
                SoSoMapView.this.firstanim = false;
                AppMethodBeat.o(146623);
            }

            @Override // com.tencent.mm.plugin.k.b
            public void setCenter(double d2, double d3) {
                AppMethodBeat.i(146624);
                SoSoMapView.this.getMap().moveCamera(CameraUpdateFactory.newLatLng(new LatLng(d2, d3)));
                AppMethodBeat.o(146624);
            }

            public void offsetCenter(double d2, double d3) {
                AppMethodBeat.i(146625);
                setCenter((((double) SoSoMapView.this.getMapCenterX()) / 1000000.0d) + d2, (((double) SoSoMapView.this.getMapCenterY()) / 1000000.0d) + d3);
                AppMethodBeat.o(146625);
            }
        };
        AppMethodBeat.o(146631);
    }

    public void addView(View view, double d2, double d3) {
        AppMethodBeat.i(146632);
        this.mViewManager.addView(view, d2, d3);
        AppMethodBeat.o(146632);
    }

    @Override // com.tencent.mm.plugin.k.d
    public void addPinView(View view, double d2, double d3) {
        AppMethodBeat.i(146633);
        this.mViewManager.addPinView(view, d2, d3);
        AppMethodBeat.o(146633);
    }

    @Override // com.tencent.mm.plugin.k.d
    public b getIController() {
        return this.iController;
    }

    @Override // com.tencent.mm.plugin.k.d
    public int getZoomLevel() {
        AppMethodBeat.i(146634);
        TencentMap map = getMap();
        if (map == null) {
            AppMethodBeat.o(146634);
            return 16;
        }
        int zoomLevel = map.getZoomLevel();
        AppMethodBeat.o(146634);
        return zoomLevel;
    }

    @Override // com.tencent.mm.plugin.k.d
    public void setLogoMargin(int[] iArr) {
        AppMethodBeat.i(146635);
        UiSettings uiSettings = getUiSettings();
        if (uiSettings != null) {
            uiSettings.setLogoPosition(1, iArr);
        }
        AppMethodBeat.o(146635);
    }

    @Override // com.tencent.mm.plugin.k.d
    public void setBuiltInZoomControls(boolean z) {
    }

    public void addNullView(View view) {
        AppMethodBeat.i(146636);
        Log.d(TAG, "addNullView ");
        addView(view);
        AppMethodBeat.o(146636);
    }

    @Override // com.tencent.mm.plugin.k.d
    public int getMapCenterX() {
        AppMethodBeat.i(146637);
        if (getMapCenter() != null) {
            int latitude = (int) (getMapCenter().getLatitude() * 1000000.0d);
            AppMethodBeat.o(146637);
            return latitude;
        }
        AppMethodBeat.o(146637);
        return 0;
    }

    @Override // com.tencent.mm.plugin.k.d
    public int getMapCenterY() {
        AppMethodBeat.i(146638);
        if (getMapCenter() != null) {
            int longitude = (int) (getMapCenter().getLongitude() * 1000000.0d);
            AppMethodBeat.o(146638);
            return longitude;
        }
        AppMethodBeat.o(146638);
        return 0;
    }

    public void updateViewLayout(View view, double d2, double d3) {
        AppMethodBeat.i(146639);
        this.mViewManager.updateViewLayout(view, d2, d3, false);
        AppMethodBeat.o(146639);
    }

    public void addOverlay(Object obj) {
    }

    public void requestMapFocus() {
        AppMethodBeat.i(146640);
        requestFocus();
        AppMethodBeat.o(146640);
    }

    @Override // com.tencent.mm.plugin.k.d
    public void addView(Object obj, double d2, double d3, String str) {
        AppMethodBeat.i(146641);
        this.tagsView.put(str, obj);
        AppMethodBeat.o(146641);
    }

    @Override // com.tencent.mm.plugin.k.d
    public Object getViewByItag(String str) {
        AppMethodBeat.i(146642);
        if (this.tagsView.containsKey(str)) {
            Object obj = this.tagsView.get(str);
            AppMethodBeat.o(146642);
            return obj;
        }
        AppMethodBeat.o(146642);
        return null;
    }

    @Override // com.tencent.mm.plugin.k.d
    public Collection<Object> getChilds() {
        AppMethodBeat.i(146643);
        Collection<Object> values = this.tagsView.values();
        AppMethodBeat.o(146643);
        return values;
    }

    @Override // com.tencent.mm.plugin.k.d
    public void removeView(View view) {
        AppMethodBeat.i(146644);
        this.mViewManager.removeView(view);
        for (String str : this.tagsView.keySet()) {
            if (this.tagsView.get(str).equals(view)) {
                this.tagsView.remove(str);
                AppMethodBeat.o(146644);
                return;
            }
        }
        AppMethodBeat.o(146644);
    }

    @Override // com.tencent.mm.plugin.k.d
    public Set<String> getTags() {
        AppMethodBeat.i(146645);
        Set<String> keySet = this.tagsView.keySet();
        AppMethodBeat.o(146645);
        return keySet;
    }

    @Override // com.tencent.mm.plugin.k.d
    public Object removeViewByTag(String str) {
        AppMethodBeat.i(146646);
        Object obj = this.tagsView.get(str);
        if (obj instanceof View) {
            removeView((View) obj);
        }
        AppMethodBeat.o(146646);
        return obj;
    }

    @Override // com.tencent.mm.plugin.k.d
    public void clean() {
        AppMethodBeat.i(146647);
        this.tagsView.clear();
        this.mViewManager.destroy();
        AppMethodBeat.o(146647);
    }

    public void addLocationPin(View view) {
        AppMethodBeat.i(146648);
        addView(view, 0.0d, 0.0d);
        AppMethodBeat.o(146648);
    }

    @Override // com.tencent.mm.plugin.k.d
    public void zoomToSpan(double d2, double d3, double d4, double d5) {
        AppMethodBeat.i(146649);
        getIController().setCenter(d2, d3);
        Log.d(TAG, "zoomToSpan " + ((int) (1000000.0d * d4)) + " " + ((int) (1000000.0d * d5)) + "  " + (1000000.0d * d2) + " " + (1000000.0d * d3));
        if (d4 == 0.0d || d5 == 0.0d) {
            AppMethodBeat.o(146649);
            return;
        }
        if (getController() != null) {
            getController().zoomToSpan(d4, d5);
        }
        AppMethodBeat.o(146649);
    }

    @Override // com.tencent.mm.plugin.k.d
    public void updateLocaitonPinLayout(View view, double d2, double d3) {
        AppMethodBeat.i(146650);
        Log.d(TAG, "updateLocationPinLayout");
        updateLocaitonPinLayout(view, d2, d3, false);
        AppMethodBeat.o(146650);
    }

    public void updateLocaitonPinLayout(View view, double d2, double d3, boolean z) {
        AppMethodBeat.i(146651);
        this.mViewManager.updateLocationPinLayout(view, d2, d3, z);
        AppMethodBeat.o(146651);
    }

    @Override // com.tencent.mm.plugin.k.d
    public int getZoom() {
        AppMethodBeat.i(146652);
        int zoomLevel = getZoomLevel();
        AppMethodBeat.o(146652);
        return zoomLevel;
    }

    @Override // com.tencent.mm.plugin.k.d
    public void setMapViewOnTouchListener(View.OnTouchListener onTouchListener) {
        AppMethodBeat.i(146653);
        setOnTouchListener(onTouchListener);
        AppMethodBeat.o(146653);
    }

    @Override // com.tencent.mm.plugin.k.d
    public Point getPointByGeoPoint(double d2, double d3) {
        AppMethodBeat.i(146654);
        Point point = new Point();
        getProjection().toPixels(new GeoPoint((int) (d2 * 1000000.0d), (int) (d3 * 1000000.0d)), point);
        AppMethodBeat.o(146654);
        return point;
    }

    public void addAnimTrackView(View view, double d2, double d3, String str) {
        AppMethodBeat.i(146655);
        this.tagsView.put(str, view);
        new GeoPoint((int) (d2 * 1000000.0d), (int) (d3 * 1000000.0d));
        AppMethodBeat.o(146655);
    }

    public void updateAnimViewLayout(View view, double d2, double d3) {
        AppMethodBeat.i(146656);
        new GeoPoint((int) (d2 * 1000000.0d), (int) (d3 * 1000000.0d));
        AppMethodBeat.o(146656);
    }

    public float metersToEquatorPixels(double d2) {
        AppMethodBeat.i(146657);
        float metersToEquatorPixels = getProjection().metersToEquatorPixels((float) d2);
        AppMethodBeat.o(146657);
        return metersToEquatorPixels;
    }

    @Override // com.tencent.mm.plugin.k.d
    public e getViewManager() {
        return this.mViewManager;
    }

    @Override // com.tencent.mm.plugin.k.d
    public void destroy() {
        AppMethodBeat.i(146658);
        this.mViewManager.destroy();
        AppMethodBeat.o(146658);
    }

    @Override // com.tencent.mm.plugin.k.d
    public void setMapAnchor(float f2, float f3) {
        AppMethodBeat.i(146659);
        getMap().setMapAnchor(f2, f3);
        AppMethodBeat.o(146659);
    }

    public void addView(View view, double d2, double d3, int i2) {
        AppMethodBeat.i(146660);
        new GeoPoint((int) (1000000.0d * d2), (int) (1000000.0d * d3));
        if (i2 == -2) {
            addView(view, new MapView.LayoutParams(-2, -2, new LatLng(d2, d3), 17));
            AppMethodBeat.o(146660);
        } else if (i2 == -1) {
            addView(view, new MapView.LayoutParams(-1, -1, new LatLng(d2, d3), 17));
            AppMethodBeat.o(146660);
        } else {
            addView(view, new MapView.LayoutParams(i2, i2, new LatLng(d2, d3), 17));
            AppMethodBeat.o(146660);
        }
    }

    public void updateViewLayout(View view, double d2, double d3, int i2) {
        AppMethodBeat.i(146661);
        new GeoPoint((int) (d2 * 1000000.0d), (int) (d3 * 1000000.0d));
        AppMethodBeat.o(146661);
    }

    @Override // com.tencent.mm.plugin.k.d
    public void setMarkerClickListener(View view, TencentMap.OnMarkerClickListener onMarkerClickListener) {
        AppMethodBeat.i(146662);
        this.mViewManager.setMarkerClick(view, onMarkerClickListener);
        AppMethodBeat.o(146662);
    }

    @Override // com.tencent.mm.plugin.k.d
    public void updateMarkerView(View view) {
        AppMethodBeat.i(146663);
        this.mViewManager.updateMarkerView(view);
        AppMethodBeat.o(146663);
    }

    @Override // com.tencent.mm.plugin.k.d
    public Circle drawAccuracyCircle(double d2, double d3, double d4) {
        AppMethodBeat.i(146664);
        Circle drawAccuracyCircle = this.mViewManager.drawAccuracyCircle(d2, d3, d4);
        AppMethodBeat.o(146664);
        return drawAccuracyCircle;
    }

    @Override // com.tencent.mm.plugin.k.d
    public void animateCamera(CameraUpdate cameraUpdate) {
        AppMethodBeat.i(146665);
        this.mViewManager.animateCamera(cameraUpdate);
        AppMethodBeat.o(146665);
    }

    @Override // com.tencent.mm.plugin.k.d
    public void setCanRotate(boolean z) {
        AppMethodBeat.i(146666);
        UiSettings uiSettings = getUiSettings();
        if (uiSettings != null) {
            uiSettings.setRotateGesturesEnabled(z);
        }
        AppMethodBeat.o(146666);
    }

    @Override // com.tencent.mm.plugin.k.d
    public void enableDarkMode() {
        AppMethodBeat.i(182827);
        this.mViewManager.enableDarkMode();
        AppMethodBeat.o(182827);
    }

    @Override // com.tencent.mm.plugin.k.d
    public void disableDarkMode() {
        AppMethodBeat.i(182828);
        this.mViewManager.disableDarkMode();
        AppMethodBeat.o(182828);
    }
}
