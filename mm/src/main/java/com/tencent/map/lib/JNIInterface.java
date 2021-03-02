package com.tencent.map.lib;

import android.graphics.Rect;
import com.tencent.map.lib.callbacks.TileOverlayCallback;
import com.tencent.map.lib.models.AggregationOverlayInfo;
import com.tencent.map.lib.models.AnnocationText;
import com.tencent.map.lib.models.AnnocationTextResult;
import com.tencent.map.lib.models.CircleInfo;
import com.tencent.map.lib.models.CityTrafficInfo;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.lib.models.GroundOverlayInfo;
import com.tencent.map.lib.models.IntersectionOverlayInfo;
import com.tencent.map.lib.models.MarkerInfo;
import com.tencent.map.lib.models.MaskLayer;
import com.tencent.map.lib.models.PolygonInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.maps.model.TrafficStyle;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatAggregationUnit;
import java.util.ArrayList;

public class JNIInterface implements JNIInterfaceCallback {
    public static final String LIB_NAME = "txmapengine";
    private JNIInterfaceCallback mCallback;

    public static native synchronized void nativeEndProfile();

    public static native synchronized void nativeStartProfile();

    public native int addLineText(long j2, GeoPoint[] geoPointArr, PolylineOptions.Text text);

    public native boolean checkMapLoadFinishedTask(long j2, int i2);

    public native int getIndoorOutlineZoom(long j2, String str);

    public native String getMapEngineRenderStatus(long j2);

    public native long nativeAddAggregationOverlay(long j2, AggregationOverlayInfo aggregationOverlayInfo);

    public native int nativeAddCircle(long j2, CircleInfo circleInfo);

    public native long nativeAddGroundOverlay(long j2, GroundOverlayInfo groundOverlayInfo);

    public native long nativeAddIntersectionOverlay(long j2, IntersectionOverlayInfo intersectionOverlayInfo);

    public native int nativeAddMarker(long j2, String str, double d2, double d3, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2, boolean z3, boolean z4, int i2, int i3);

    public native long nativeAddMarker2(long j2, MarkerInfo markerInfo);

    public native int nativeAddMaskLayer(long j2, MaskLayer maskLayer);

    public native int nativeAddPolygon(long j2, PolygonInfo polygonInfo);

    public native void nativeAddRouteNameSegments(long j2, byte[][] bArr, int i2, GeoPoint[] geoPointArr, int i3);

    public native int nativeAddTileOverlay(long j2, TileOverlayCallback tileOverlayCallback, boolean z);

    public native void nativeBringElementAbove(long j2, int i2, int i3);

    public native void nativeBringElementBelow(long j2, int i2, int i3);

    public native void nativeCheckTrafficBlockCache(long j2, int i2, int i3, int i4, int i5, int i6);

    public native void nativeCheckTrafficBlockCacheForReplay(long j2, int i2, int i3, int i4, int i5, int i6);

    public native int nativeClearCache(long j2);

    public native void nativeClearDownloadURLCache(long j2);

    public native void nativeClearRouteNameSegments(long j2);

    public native AnnocationTextResult nativeCreateAnnotationText(long j2, AnnocationText annocationText);

    public native int nativeCreateOrUpdateLine(long j2, int i2, int[] iArr, int[] iArr2, GeoPoint[] geoPointArr, String str, float f2, int i3, boolean z, boolean z2, boolean z3, int i4, boolean z4, int[] iArr3, int[] iArr4, float f3, int[] iArr5, float f4, int i5, boolean z5);

    public native void nativeDeleteCircle(long j2, int i2);

    public native void nativeDeleteIcons(long j2, int[] iArr, int i2);

    public native void nativeDeleteLine(long j2, long j3, boolean z);

    public native void nativeDeletePolygon(long j2, int i2, int i3);

    public native void nativeDestroyEngine(long j2);

    public native boolean nativeDrawFrame(long j2);

    public native void nativeEnableBaseMap(long j2, boolean z);

    public native void nativeEnableBuilding(long j2, boolean z);

    public native void nativeEnablePOI(long j2, boolean z);

    public native int[] nativeFetchLackedTrafficBlocks(long j2);

    public native void nativeFromScreenLocation(long j2, byte[] bArr, float f2, float f3, double[] dArr);

    public native float[] nativeGLProjectMatrix();

    public native double[] nativeGLViewMatrix();

    public native float nativeGLViewScaleRatio();

    public native int[] nativeGLViewport();

    public native boolean nativeGenerateTextures(long j2);

    public native String nativeGetActiveIndoorBuildingGUID(long j2);

    public native VectorHeatAggregationUnit nativeGetAggregationUnit(long j2, long j3, LatLng latLng);

    public native String nativeGetBlockRouteInfo(long j2, int i2, int i3);

    public native void nativeGetCenterMapPoint(long j2, GeoPoint geoPoint);

    public native byte[] nativeGetCityName(long j2, GeoPoint geoPoint);

    public native String nativeGetCurIndoorName(long j2, GeoPoint geoPoint);

    public native String nativeGetDataEngineVersion(long j2);

    public native int nativeGetEngineId(long j2);

    public native String nativeGetEngineLogInfo(long j2);

    public native Rect nativeGetIndoorBound(long j2);

    public native int nativeGetIndoorCurrentFloorId(long j2);

    public native String[] nativeGetIndoorFloorNames(long j2);

    public native int nativeGetLanguage(long j2);

    public native String nativeGetMapEngineVersion(long j2);

    public native int nativeGetMapStyle(long j2);

    public native ArrayList nativeGetPoisInScreen(long j2);

    public native float nativeGetRotate(long j2);

    public native double nativeGetScale(long j2);

    public native int nativeGetScaleLevel(long j2);

    public native float nativeGetSkew(long j2);

    public native double nativeGetTargetScale(long j2, Rect rect, Rect rect2);

    public native boolean nativeGetTrafficCityInfo(long j2, String str, CityTrafficInfo cityTrafficInfo);

    public native boolean nativeHasStreetRoad(long j2, String str);

    public native void nativeHideCompass(long j2);

    public native void nativeHideIcons(long j2, int[] iArr, int i2);

    public native void nativeHideStreetRoad(long j2);

    public native void nativeHideTraffic(long j2);

    public native void nativeIndoorBuildingEnabled(long j2, boolean z);

    public native long nativeInitEngine(String str, String str2, String str3, float f2, int i2, float f3, int[] iArr, boolean z, int i3);

    public native int nativeIsCityHasTraffic(long j2, String str);

    @Deprecated
    public native boolean nativeIsMapDrawFinished(long j2);

    public native boolean nativeIsTileOverlayEnabled(long j2);

    public native void nativeLineClearPoint(long j2, long j3, GeoPoint geoPoint, int i2);

    public native void nativeLineInsertPoint(long j2, long j3, GeoPoint geoPoint, int i2);

    public native void nativeLoadBlockRouteCityList(long j2, int[] iArr, int[] iArr2, int i2);

    public native void nativeLockEngine(long j2);

    public native void nativeMapLoadKMLFile(long j2, String str);

    public native void nativeMapSetSatelliteServerFullUrl(long j2, String str);

    public native void nativeMoveBy(long j2, float f2, float f3, boolean z);

    public native boolean nativeNeedDispaly(long j2);

    public native boolean nativeNeedRedraw(long j2);

    public native byte[] nativeOnTap(long j2, float f2, float f3);

    public native boolean nativeOnTapLine(long j2, float f2, float f3);

    public native int nativeQueryCityCodeList(long j2, Rect rect, int i2, int[] iArr, int i3);

    public native int nativeRefreshTrafficData(long j2, byte[] bArr, int i2, boolean z, boolean z2);

    public native void nativeReleaseEngineResource(long j2, boolean z);

    public native void nativeReloadTileOverlay(long j2, int i2);

    public native void nativeRemoveEngineOverlay(long j2);

    public native void nativeRemoveGLVisualizationOverlay(long j2, long j3);

    public native void nativeRemoveMaskLayer(long j2, int i2);

    public native void nativeRemoveTileOverlay(long j2, int i2);

    public native void nativeResetEnginePath(long j2, String str, String str2, String str3);

    public native void nativeSetBlockRouteVisible(long j2, boolean z);

    public native void nativeSetBuilding3DEffect(long j2, boolean z);

    public native void nativeSetBuildingToSpecificFloor(long j2, String str, String str2);

    public native void nativeSetCallback(long j2);

    public native void nativeSetCenter(long j2, GeoPoint geoPoint, boolean z);

    public native void nativeSetCenterMapPointAndScaleLevel(long j2, GeoPoint geoPoint, int i2, boolean z);

    public native void nativeSetCompassImage(long j2, String str);

    public native void nativeSetCompassPosition(long j2, int i2, int i3);

    public native void nativeSetCompassVisible(long j2, boolean z);

    public native void nativeSetDrawCap(long j2, long j3, boolean z);

    public native void nativeSetFlagOfZoomToSpanForLocation(long j2, float f2, float f3, float f4, float f5);

    public native void nativeSetIconsHidden(long j2, int[] iArr, int i2, boolean z);

    public native void nativeSetIndoorActiveScreenArea(long j2, float f2, float f3, float f4, float f5);

    public native void nativeSetIndoorBuildingPickEnabled(long j2, boolean z);

    public native void nativeSetIndoorBuildingStyle(long j2, int i2);

    public native void nativeSetIndoorConfigType(long j2, int i2);

    public native void nativeSetIndoorFloor(long j2, int i2);

    public native void nativeSetIndoorMaskColor(long j2, int i2);

    public native void nativeSetLanguage(long j2, int i2);

    public native void nativeSetLineArrowSpacing(long j2, int i2, float f2);

    public native void nativeSetLineDirectionArrowTextureName(long j2, long j3, String str);

    public native void nativeSetLineDrawArrow(long j2, long j3, boolean z);

    public native void nativeSetLineFootPrintSpacing(long j2, int i2, float f2);

    public native void nativeSetLineSelected(long j2, long j3, boolean z);

    public native void nativeSetLocationCircleColor(long j2, int i2);

    public native void nativeSetLocationCircleHidden(long j2, boolean z);

    public native void nativeSetLocationCompassMarkerHidden(long j2, boolean z);

    public native void nativeSetLocationCompassMarkerImage(long j2, String str);

    public native void nativeSetLocationFollow(long j2, boolean z, boolean z2, boolean z3, boolean z4);

    public native void nativeSetLocationHeading(long j2, float f2);

    public native void nativeSetLocationInfo(long j2, double d2, double d3, float f2, float f3, boolean z);

    public native void nativeSetLocationMarkerHidden(long j2, boolean z);

    public native int nativeSetLocationMarkerImage(long j2, String str, float f2, float f3);

    public native void nativeSetMapParam(long j2, byte[] bArr);

    public native void nativeSetMapStyle(long j2, int i2, boolean z);

    public native void nativeSetMarkerScaleLevelRange(long j2, int i2, int i3, int i4);

    public native void nativeSetMaxScaleLevel(long j2, int i2);

    public native void nativeSetMinScaleLevel(long j2, int i2);

    public native void nativeSetNeedDisplay(long j2, boolean z);

    public native void nativeSetPriority(long j2, int i2, float f2);

    public native void nativeSetRotate(long j2, float f2, boolean z);

    public native void nativeSetSatelliteEnabled(long j2, boolean z);

    public native void nativeSetScale(long j2, double d2, boolean z);

    public native void nativeSetScaleLevel(long j2, int i2, boolean z);

    public native void nativeSetScreenCenterOffset(long j2, float f2, float f3, boolean z);

    public native void nativeSetServerHost(long j2, String str);

    public native void nativeSetShowIndoorBuildingWhiteList(long j2, String[] strArr);

    public native void nativeSetSkew(long j2, float f2, boolean z);

    public native void nativeSetTileOverlayDataLevelRange(long j2, int i2, int i3, int i4);

    public native void nativeSetTileOverlayEnabled(long j2, boolean z);

    public native void nativeSetTileOverlayPriority(long j2, int i2, int i3);

    public native void nativeSetTrafficColor(long j2, int i2, int i3, int i4, int i5);

    public native void nativeSetTrafficStyle(long j2, TrafficStyle trafficStyle);

    public native void nativeSetTurnArrow(long j2, long j3, GeoPoint[] geoPointArr, int i2, int i3);

    public native void nativeSetTurnArrowStyle(long j2, long j3, int i2, int i3);

    public native void nativeSetViewport(long j2, int i2, int i3, int i4, int i5);

    public native void nativeShowStreetRoad(long j2);

    public native void nativeShowTraffic(long j2);

    public native void nativeToScreenLocation(long j2, byte[] bArr, double d2, double d3, float[] fArr);

    public native void nativeUnlockEngine(long j2);

    public native void nativeUpdateAggregationOverlay(long j2, long j3, AggregationOverlayInfo aggregationOverlayInfo);

    public native void nativeUpdateCircle(long j2, int i2, CircleInfo circleInfo);

    public native void nativeUpdateFrame(long j2, double d2);

    public native void nativeUpdateGroundOverlay(long j2, long j3, GroundOverlayInfo groundOverlayInfo);

    public native void nativeUpdateIntersectionOverlay(long j2, IntersectionOverlayInfo intersectionOverlayInfo);

    public native void nativeUpdateMapResource(long j2, String str);

    public native void nativeUpdateMarker(long j2, MarkerInfo markerInfo);

    public native void nativeUpdateMarkerInfo(long j2, int i2, String str, double d2, double d3, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2, boolean z3, boolean z4, int i3, int i4);

    public native void nativeUpdateMaskLayer(long j2, int i2, int i3);

    public native void nativeUpdatePolygon(long j2, int i2, int i3, PolygonInfo polygonInfo);

    public native void nativeWriteMapDataBlock(long j2, String str, byte[] bArr);

    public native void nativeZoomIn(long j2, float f2, float f3);

    public native void nativeZoomOut(long j2);

    public native void nativeZoomToSpan(long j2, Rect rect, Rect rect2, boolean z);

    public native void nativeZoomToSpanForNavigation(long j2, GeoPoint geoPoint, int i2, int i3, boolean z);

    public native void removeLineText(long j2, int i2);

    public native void setLineTextStyle(long j2, int i2, PolylineOptions.Text text);

    public native void setRestrictBounds(long j2, double[] dArr, double[] dArr2, int i2);

    public JNIInterface(JNIInterfaceCallback jNIInterfaceCallback) {
        this.mCallback = jNIInterfaceCallback;
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public Object callback(int i2, int i3, String str, byte[] bArr, Object obj) {
        AppMethodBeat.i(180724);
        if (this.mCallback != null) {
            Object callback = this.mCallback.callback(i2, i3, str, bArr, obj);
            AppMethodBeat.o(180724);
            return callback;
        }
        AppMethodBeat.o(180724);
        return null;
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public void onMapLoaded() {
        AppMethodBeat.i(180725);
        if (this.mCallback != null) {
            this.mCallback.onMapLoaded();
        }
        AppMethodBeat.o(180725);
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public void onMapCameraChangeStopped() {
        AppMethodBeat.i(180726);
        if (this.mCallback != null) {
            this.mCallback.onMapCameraChangeStopped();
        }
        AppMethodBeat.o(180726);
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public void onMapCameraChanged() {
        AppMethodBeat.i(180727);
        if (this.mCallback != null) {
            this.mCallback.onMapCameraChanged();
        }
        AppMethodBeat.o(180727);
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public int callbackGetGLContext() {
        AppMethodBeat.i(180728);
        if (this.mCallback != null) {
            int callbackGetGLContext = this.mCallback.callbackGetGLContext();
            AppMethodBeat.o(180728);
            return callbackGetGLContext;
        }
        AppMethodBeat.o(180728);
        return 0;
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public boolean onJniCallbackRenderMapFrame(int i2) {
        AppMethodBeat.i(193492);
        if (this.mCallback != null) {
            boolean onJniCallbackRenderMapFrame = this.mCallback.onJniCallbackRenderMapFrame(i2);
            AppMethodBeat.o(193492);
            return onJniCallbackRenderMapFrame;
        }
        AppMethodBeat.o(193492);
        return false;
    }
}
