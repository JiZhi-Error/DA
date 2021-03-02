package com.d.a.a.a.a;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mapsdk.rastercore.LogHelper;
import com.tencent.mapsdk.rastercore.MapProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.IMapView;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.map.UiSettings;
import com.tencent.tencentmap.mapsdk.maps.MapRenderLayer;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

public final class a implements IMapView {
    private MapRenderLayer SJI;
    private TencentMap mTencentMap;

    public a(Context context, TencentMapOptions tencentMapOptions) {
        com.tencent.tencentmap.mapsdk.maps.TencentMapOptions tencentMapOptions2;
        AppMethodBeat.i(217262);
        LogHelper.v("VecotrMapRenderLayer construct function start");
        if (tencentMapOptions != null) {
            tencentMapOptions2 = new com.tencent.tencentmap.mapsdk.maps.TencentMapOptions();
            tencentMapOptions2.setCustomCacheRootPath(MapProvider.getMapSdkPath());
            if (tencentMapOptions.getExtSurface() != null) {
                tencentMapOptions2.setExtSurface(tencentMapOptions.getExtSurface());
                tencentMapOptions2.setExtSurfaceDimension(tencentMapOptions.getExtSurfaceWidth(), tencentMapOptions.getExtSurfaceHeight());
            }
            tencentMapOptions2.setHandDrawMapEnable(tencentMapOptions.isHandDrawMapEnable());
            tencentMapOptions2.setSubInfo(tencentMapOptions.getSubKey(), tencentMapOptions.getSubId());
            tencentMapOptions2.setMultipleInfoWindowEnable(tencentMapOptions.isMutipleInfowindowEnabled());
        } else {
            tencentMapOptions2 = new com.tencent.tencentmap.mapsdk.maps.TencentMapOptions();
            tencentMapOptions2.setCustomCacheRootPath(MapProvider.getMapSdkPath());
        }
        this.SJI = new MapRenderLayer(context, tencentMapOptions2);
        this.mTencentMap = new i(this.SJI.getMap());
        this.SJI.getMap().getUiSettings().setZoomControlsEnabled(false);
        AppMethodBeat.o(217262);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final View getMapView() {
        return this.SJI;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final TencentMap getMap() {
        return this.mTencentMap;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final UiSettings getUiSettings() {
        AppMethodBeat.i(217263);
        if (this.SJI.getMap() != null) {
            m mVar = new m(this.SJI.getMap().getUiSettings());
            AppMethodBeat.o(217263);
            return mVar;
        }
        AppMethodBeat.o(217263);
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final Projection getProjection() {
        AppMethodBeat.i(217264);
        if (getMap() != null) {
            Projection projection = getMap().getProjection();
            AppMethodBeat.o(217264);
            return projection;
        }
        AppMethodBeat.o(217264);
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final MapController getMapController() {
        return this.mTencentMap;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void addView(View view, MapView.LayoutParams layoutParams) {
        AppMethodBeat.i(217265);
        if (this.SJI.getMap() != null) {
            this.SJI.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(view)).position(l.c(layoutParams.point)));
        }
        AppMethodBeat.o(217265);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(217266);
        if (this.SJI != null) {
            this.SJI.updateViewLayout(view, layoutParams);
        }
        AppMethodBeat.o(217266);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onCreate(Bundle bundle) {
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onStart() {
        AppMethodBeat.i(217267);
        this.SJI.onStart();
        AppMethodBeat.o(217267);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onResume() {
        AppMethodBeat.i(217268);
        this.SJI.onResume();
        AppMethodBeat.o(217268);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onPause() {
        AppMethodBeat.i(217269);
        this.SJI.onPause();
        AppMethodBeat.o(217269);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onStop() {
        AppMethodBeat.i(217270);
        this.SJI.onStop();
        AppMethodBeat.o(217270);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onRestart() {
        AppMethodBeat.i(217271);
        this.SJI.onRestart();
        AppMethodBeat.o(217271);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onDestroyView() {
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onDestroy() {
        AppMethodBeat.i(217272);
        this.SJI.onDestroy();
        AppMethodBeat.o(217272);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onSaveInstanceState(Bundle bundle) {
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onLowMemory() {
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(217273);
        boolean onTouchEvent = this.SJI.onTouchEvent(motionEvent);
        AppMethodBeat.o(217273);
        return onTouchEvent;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(217274);
        if (this.SJI != null) {
            this.SJI.onSizeChanged(i2, i3, i4, i5);
        }
        AppMethodBeat.o(217274);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onSurfaceChanged(Object obj, int i2, int i3) {
        AppMethodBeat.i(217275);
        if (this.SJI != null) {
            this.SJI.onSurfaceChanged(obj, i2, i3);
        }
        AppMethodBeat.o(217275);
    }
}
