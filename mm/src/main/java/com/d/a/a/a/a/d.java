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
import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

public final class d implements IMapView {
    private MapView SJL;
    private TencentMap mTencentMap;

    public d(Context context, TencentMapOptions tencentMapOptions) {
        com.tencent.tencentmap.mapsdk.maps.TencentMapOptions tencentMapOptions2;
        AppMethodBeat.i(217299);
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
        this.SJL = new MapView(context, tencentMapOptions2);
        this.mTencentMap = new i(this.SJL.getMap());
        this.SJL.getMap().getUiSettings().setZoomControlsEnabled(false);
        AppMethodBeat.o(217299);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final View getMapView() {
        return this.SJL;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final TencentMap getMap() {
        return this.mTencentMap;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final UiSettings getUiSettings() {
        AppMethodBeat.i(217300);
        if (this.SJL.getMap() != null) {
            m mVar = new m(this.SJL.getMap().getUiSettings());
            AppMethodBeat.o(217300);
            return mVar;
        }
        AppMethodBeat.o(217300);
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final Projection getProjection() {
        AppMethodBeat.i(217301);
        if (getMap() != null) {
            Projection projection = getMap().getProjection();
            AppMethodBeat.o(217301);
            return projection;
        }
        AppMethodBeat.o(217301);
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final MapController getMapController() {
        return this.mTencentMap;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void addView(View view, MapView.LayoutParams layoutParams) {
        AppMethodBeat.i(217302);
        if (this.SJL.getMap() != null) {
            this.SJL.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(view)).position(l.c(layoutParams.point)));
        }
        AppMethodBeat.o(217302);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(217303);
        if (this.SJL != null) {
            this.SJL.updateViewLayout(view, layoutParams);
        }
        AppMethodBeat.o(217303);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onCreate(Bundle bundle) {
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onStart() {
        AppMethodBeat.i(217304);
        this.SJL.onStart();
        AppMethodBeat.o(217304);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onResume() {
        AppMethodBeat.i(217305);
        this.SJL.onResume();
        AppMethodBeat.o(217305);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onPause() {
        AppMethodBeat.i(217306);
        this.SJL.onPause();
        AppMethodBeat.o(217306);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onStop() {
        AppMethodBeat.i(217307);
        this.SJL.onStop();
        AppMethodBeat.o(217307);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onRestart() {
        AppMethodBeat.i(217308);
        this.SJL.onRestart();
        AppMethodBeat.o(217308);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onDestroyView() {
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onDestroy() {
        AppMethodBeat.i(217309);
        this.SJL.onDestroy();
        if (this.mTencentMap instanceof i) {
            i iVar = (i) this.mTencentMap;
            if (iVar.SJV != null) {
                iVar.SJV.clear();
            }
            if (iVar.SJX != null) {
                iVar.SJX.clear();
            }
            if (iVar.SJZ != null) {
                iVar.SJZ.clear();
            }
            if (iVar.SKb != null) {
                iVar.SKb.clear();
            }
            if (iVar.SKd != null) {
                iVar.SKd.clear();
            }
            if (iVar.SKf != null) {
                iVar.SKf.clear();
            }
            if (iVar.SKh != null) {
                iVar.SKh.clear();
            }
            if (iVar.SKj != null) {
                iVar.SKj.clear();
            }
        }
        AppMethodBeat.o(217309);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onSaveInstanceState(Bundle bundle) {
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onLowMemory() {
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(217310);
        if (motionEvent.getAction() == 0) {
            AppMethodBeat.o(217310);
            return true;
        }
        AppMethodBeat.o(217310);
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(217311);
        if (this.SJL == null) {
            AppMethodBeat.o(217311);
            return false;
        } else if (this.SJL.dispatchTouchEvent(motionEvent) || this.SJL.onTouchEvent(motionEvent)) {
            AppMethodBeat.o(217311);
            return true;
        } else {
            AppMethodBeat.o(217311);
            return false;
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(217312);
        if (this.SJL != null) {
            this.SJL.onSizeChanged(i2, i3, i4, i5);
        }
        AppMethodBeat.o(217312);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public final void onSurfaceChanged(Object obj, int i2, int i3) {
        AppMethodBeat.i(217313);
        if (this.SJL != null) {
            this.SJL.onSurfaceChanged(obj, i2, i3);
        }
        AppMethodBeat.o(217313);
    }
}
