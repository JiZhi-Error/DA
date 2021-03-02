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
import com.tencent.tencentmap.mapsdk.maps.TextureMapView;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

public final class j implements IMapView {
    private TextureMapView SKr;
    private TencentMap mTencentMap;

    public j(Context context, TencentMapOptions tencentMapOptions) {
        com.tencent.tencentmap.mapsdk.maps.TencentMapOptions tencentMapOptions2;
        AppMethodBeat.i(217516);
        LogHelper.v("vector MapView construct function start");
        if (tencentMapOptions != null) {
            tencentMapOptions2 = new com.tencent.tencentmap.mapsdk.maps.TencentMapOptions();
            tencentMapOptions2.setCustomCacheRootPath(MapProvider.getMapSdkPath());
            if (tencentMapOptions.getExtSurface() != null) {
                tencentMapOptions2.setExtSurface(tencentMapOptions.getExtSurface());
            }
            tencentMapOptions2.setHandDrawMapEnable(tencentMapOptions.isHandDrawMapEnable());
            tencentMapOptions2.setSubInfo(tencentMapOptions.getSubKey(), tencentMapOptions.getSubId());
            tencentMapOptions2.setMultipleInfoWindowEnable(tencentMapOptions.isMutipleInfowindowEnabled());
        } else {
            tencentMapOptions2 = new com.tencent.tencentmap.mapsdk.maps.TencentMapOptions();
            tencentMapOptions2.setCustomCacheRootPath(MapProvider.getMapSdkPath());
        }
        this.SKr = new TextureMapView(context, tencentMapOptions2);
        this.mTencentMap = new i(this.SKr.getMap());
        this.SKr.getMap().getUiSettings().setZoomControlsEnabled(false);
        AppMethodBeat.o(217516);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final View getMapView() {
        return this.SKr;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final TencentMap getMap() {
        return this.mTencentMap;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final UiSettings getUiSettings() {
        AppMethodBeat.i(217517);
        if (this.SKr.getMap() != null) {
            m mVar = new m(this.SKr.getMap().getUiSettings());
            AppMethodBeat.o(217517);
            return mVar;
        }
        AppMethodBeat.o(217517);
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final Projection getProjection() {
        AppMethodBeat.i(217518);
        if (getMap() != null) {
            Projection projection = getMap().getProjection();
            AppMethodBeat.o(217518);
            return projection;
        }
        AppMethodBeat.o(217518);
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final MapController getMapController() {
        return this.mTencentMap;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void addView(View view, MapView.LayoutParams layoutParams) {
        AppMethodBeat.i(217519);
        if (this.SKr.getMap() != null) {
            this.SKr.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(view)).position(l.c(layoutParams.point)));
        }
        AppMethodBeat.o(217519);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(217520);
        if (this.SKr != null) {
            this.SKr.updateViewLayout(view, layoutParams);
        }
        AppMethodBeat.o(217520);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onCreate(Bundle bundle) {
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onStart() {
        AppMethodBeat.i(217521);
        this.SKr.onStart();
        AppMethodBeat.o(217521);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onResume() {
        AppMethodBeat.i(217522);
        this.SKr.onResume();
        AppMethodBeat.o(217522);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onPause() {
        AppMethodBeat.i(217523);
        this.SKr.onPause();
        AppMethodBeat.o(217523);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onStop() {
        AppMethodBeat.i(217524);
        this.SKr.onStop();
        AppMethodBeat.o(217524);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onRestart() {
        AppMethodBeat.i(217525);
        this.SKr.onRestart();
        AppMethodBeat.o(217525);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onDestroyView() {
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onDestroy() {
        AppMethodBeat.i(217526);
        this.SKr.onDestroy();
        AppMethodBeat.o(217526);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onSaveInstanceState(Bundle bundle) {
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onLowMemory() {
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(217527);
        if (motionEvent.getAction() == 0) {
            AppMethodBeat.o(217527);
            return true;
        }
        AppMethodBeat.o(217527);
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(217528);
        if (this.SKr == null) {
            AppMethodBeat.o(217528);
            return false;
        } else if (this.SKr.dispatchTouchEvent(motionEvent) || this.SKr.onTouchEvent(motionEvent)) {
            AppMethodBeat.o(217528);
            return true;
        } else {
            AppMethodBeat.o(217528);
            return false;
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(217529);
        if (this.SKr != null) {
            this.SKr.onSizeChanged(i2, i3, i4, i5);
        }
        AppMethodBeat.o(217529);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onSurfaceChanged(Object obj, int i2, int i3) {
        AppMethodBeat.i(217530);
        if (this.SKr != null) {
            this.SKr.onSurfaceChanged(obj, i2, i3);
        }
        AppMethodBeat.o(217530);
    }
}
