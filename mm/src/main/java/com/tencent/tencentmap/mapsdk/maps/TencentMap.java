package com.tencent.tencentmap.mapsdk.maps;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.location.Location;
import android.view.View;
import com.tencent.map.lib.MapLanguage;
import com.tencent.map.sdk.comps.indoor.IIndoor;
import com.tencent.map.sdk.comps.mylocation.IMyLocation;
import com.tencent.tencentmap.mapsdk.maps.TencentMapComponent;
import com.tencent.tencentmap.mapsdk.maps.model.AoiLayer;
import com.tencent.tencentmap.mapsdk.maps.model.AoiLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Arc;
import com.tencent.tencentmap.mapsdk.maps.model.ArcOptions;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.Circle;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayer;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.IOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider;
import com.tencent.tencentmap.mapsdk.maps.model.Polygon;
import com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.maps.model.RestrictBoundsFitMode;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.TrafficEvent;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlayOptions;
import java.util.List;

public interface TencentMap extends IIndoor, IMyLocation {
    public static final int MAP_MODE_NAV = 12;
    public static final int MAP_MODE_NAV_NIGHT = 1013;
    public static final int MAP_MODE_NAV_TRAFFIC = 1009;
    public static final int MAP_MODE_NORMAL = 0;
    public static final int MAP_MODE_NORMAL_TRAFFIC = 5;
    public static final int MAP_TYPE_DARK = 1008;
    public static final int MAP_TYPE_NAVI = 1012;
    public static final int MAP_TYPE_NIGHT = 1013;
    public static final int MAP_TYPE_NONE = -1;
    public static final int MAP_TYPE_NORMAL = 1000;
    public static final int MAP_TYPE_SATELLITE = 1011;
    public static final int MAP_TYPE_TRAFFIC_NAVI = 1009;
    public static final int MAP_TYPE_TRAFFIC_NIGHT = 1010;

    public interface AsyncOperateCallback<T> {
        void onOperateFinished(T t);
    }

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);

        void onCameraChangeFinished(CameraPosition cameraPosition);
    }

    public interface OnCompassClickedListener {
        void onCompassClicked();
    }

    public interface OnDismissCallback {
        void onDismiss();

        void onNotify();
    }

    public interface OnIndoorStateChangeListener {
        boolean onIndoorBuildingDeactivated();

        boolean onIndoorBuildingFocused();

        boolean onIndoorLevelActivated(IndoorBuilding indoorBuilding);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);

        void onInfoWindowClickLocation(int i2, int i3, int i4, int i5);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMapPoiClickListener {
        void onClicked(MapPoi mapPoi);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public interface OnMyLocationClickListener {
        boolean onMyLocationClicked(LatLng latLng);
    }

    public interface OnPolylineClickListener {
        void onPolylineClick(Polyline polyline, LatLng latLng);
    }

    public interface OnTrafficEventClickListener {
        void onTrafficEventClicked(TrafficEvent trafficEvent);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    AoiLayer addAoiLayer(String str, AoiLayerOptions aoiLayerOptions, AoiLayer.OnAoiLayerLoadListener onAoiLayerLoadListener);

    Arc addArc(ArcOptions arcOptions);

    Circle addCircle(CircleOptions circleOptions);

    CustomLayer addCustomLayer(CustomLayerOptions customLayerOptions);

    GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions);

    Marker addMarker(MarkerOptions markerOptions);

    void addOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback);

    Polygon addPolygon(PolygonOptions polygonOptions);

    Polyline addPolyline(PolylineOptions polylineOptions);

    void addTencentMapGestureListener(TencentMapGestureListener tencentMapGestureListener);

    TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions);

    VectorHeatOverlay addVectorHeatOverlay(VectorHeatOverlayOptions vectorHeatOverlayOptions);

    void animateCamera(CameraUpdate cameraUpdate);

    void animateCamera(CameraUpdate cameraUpdate, long j2, CancelableCallback cancelableCallback);

    void animateCamera(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback);

    CameraPosition calculateZoomToSpanLevel(List<IOverlay> list, List<LatLng> list2, int i2, int i3, int i4, int i5);

    void clear();

    void clearAllOverlays();

    void clearCache();

    void enableMultipleInfowindow(boolean z);

    List<LatLng> getBounderPoints(Marker marker);

    CameraPosition getCameraPosition();

    String getCityName(LatLng latLng);

    String getDebugError();

    MapLanguage getLanguage();

    <T extends TencentMapComponent.Component> T getMapComponent(Class<T> cls);

    TencentMapContext getMapContext();

    int getMapHeight();

    Rect getMapPadding();

    int getMapStyle();

    int getMapType();

    int getMapWidth();

    float getMaxZoomLevel();

    float getMinZoomLevel();

    Projection getProjection();

    UiSettings getUiSettings();

    String getVersion();

    float getZoomToSpanLevel(LatLng latLng, LatLng latLng2);

    boolean isBlockRouteEnabled();

    boolean isDestroyed();

    boolean isHandDrawMapEnable();

    boolean isSateLiteEnable();

    boolean isTrafficEnabled();

    void loadKMLFile(String str);

    void moveCamera(CameraUpdate cameraUpdate);

    void removeOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback);

    void removeTencentMapGestureListener(TencentMapGestureListener tencentMapGestureListener);

    void setBaseMapEnabled(boolean z);

    void setBlockRouteEnabled(boolean z);

    void setBuilding3dEffectEnable(boolean z);

    void setBuildingEnable(boolean z);

    void setCameraCenterProportion(float f2, float f3);

    void setCameraCenterProportion(float f2, float f3, boolean z);

    void setCustomRender(CustomRender customRender);

    void setDrawPillarWith2DStyle(boolean z);

    void setForeignLanguage(Language language);

    void setHandDrawMapEnable(boolean z);

    void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter);

    void setMapCenterAndScale(float f2, float f3, float f4);

    void setMapFrameRate(float f2);

    void setMapStyle(int i2);

    void setMapType(int i2);

    void setMaxZoomLevel(int i2);

    void setMinZoomLevel(int i2);

    @Override // com.tencent.map.sdk.comps.mylocation.IMyLocation
    void setMyLocationStyle(MyLocationStyle myLocationStyle);

    void setOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener);

    void setOnCompassClickedListener(OnCompassClickedListener onCompassClickedListener);

    void setOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener);

    void setOnMapClickListener(OnMapClickListener onMapClickListener);

    void setOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback);

    void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener);

    void setOnMapPoiClickListener(OnMapPoiClickListener onMapPoiClickListener);

    void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener);

    void setOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener);

    void setOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener);

    void setOnTapMapViewInfoWindowHidden(boolean z);

    void setOnTrafficEventClickListener(OnTrafficEventClickListener onTrafficEventClickListener);

    void setOverSeaTileProvider(OverSeaTileProvider overSeaTileProvider);

    void setPadding(int i2, int i3, int i4, int i5);

    void setPadding(int i2, int i3, int i4, int i5, boolean z);

    void setPointToCenter(int i2, int i3);

    void setPoisEnabled(boolean z);

    void setRestrictBounds(LatLngBounds latLngBounds, RestrictBoundsFitMode restrictBoundsFitMode);

    void setSatelliteEnabled(boolean z);

    void setTencentMapGestureListener(TencentMapGestureListener tencentMapGestureListener);

    void setTrafficEnabled(boolean z);

    void showBuilding(boolean z);

    void snapshot(SnapshotReadyCallback snapshotReadyCallback);

    void snapshot(SnapshotReadyCallback snapshotReadyCallback, Bitmap.Config config);

    void snapshot(SnapshotReadyCallback snapshotReadyCallback, Bitmap.Config config, int i2);

    void stopAnimation();
}
