package com.tencent.tencentmap.mapsdk.map;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.rastercore.MapProvider;
import com.tencent.mapsdk.rastercore.core.MapContext;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MapView extends FrameLayout implements IMapView {
    private MapProvider mMapProvider;
    private int mMapType;
    private Projection mProjection;
    private UiSettings mUiSettings;
    private IMapView mapView;

    public static class LayoutParams extends ViewGroup.LayoutParams {
        public static final int BOTTOM_CENTER = 81;
        public static final int CENTER = 17;
        public int alignment = 17;
        public int height = 0;
        public LatLng point = null;
        public int width = 0;

        public LayoutParams(int i2, int i3, LatLng latLng, int i4) {
            super(i2, i3);
            this.width = i2;
            this.height = i3;
            this.point = latLng;
            this.alignment = i4;
        }
    }

    public MapView(Context context) {
        this(context, (TencentMapOptions) null);
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(87461);
        this.mMapType = 1;
        init(null);
        AppMethodBeat.o(87461);
    }

    public MapView(Context context, TencentMapOptions tencentMapOptions) {
        super(context);
        AppMethodBeat.i(87462);
        this.mMapType = 1;
        init(tencentMapOptions);
        AppMethodBeat.o(87462);
    }

    private void init(TencentMapOptions tencentMapOptions) {
        AppMethodBeat.i(87463);
        Context context = getContext();
        this.mMapProvider = new MapProvider();
        MapContext.setContext(context.getApplicationContext());
        this.mapView = this.mMapProvider.getMapView(context.getApplicationContext(), tencentMapOptions);
        if (this.mapView != null) {
            addView(this.mapView.getMapView(), new ViewGroup.LayoutParams(-1, -1));
        }
        if (context instanceof MapActivity) {
            ((MapActivity) context).setMapView(this);
        }
        AppMethodBeat.o(87463);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public void addView(View view, LayoutParams layoutParams) {
        AppMethodBeat.i(87464);
        if (this.mapView == null || layoutParams == null) {
            AppMethodBeat.o(87464);
            return;
        }
        this.mapView.addView(view, layoutParams);
        AppMethodBeat.o(87464);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public TencentMap getMap() {
        AppMethodBeat.i(87465);
        if (this.mapView == null) {
            AppMethodBeat.o(87465);
            return null;
        }
        TencentMap map = this.mapView.getMap();
        AppMethodBeat.o(87465);
        return map;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public View getMapView() {
        return this;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(87466);
        if (this.mapView == null) {
            AppMethodBeat.o(87466);
            return;
        }
        this.mapView.onCreate(bundle);
        AppMethodBeat.o(87466);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(87467);
        if (this.mapView != null) {
            boolean onTouchEvent = this.mapView.onTouchEvent(motionEvent);
            AppMethodBeat.o(87467);
            return onTouchEvent;
        }
        boolean onTouchEvent2 = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(87467);
        return onTouchEvent2;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(87468);
        this.mapView.dispatchTouchEvent(motionEvent);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(87468);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public void onStart() {
        AppMethodBeat.i(87469);
        if (this.mapView == null) {
            AppMethodBeat.o(87469);
            return;
        }
        this.mapView.onStart();
        AppMethodBeat.o(87469);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public void onResume() {
        AppMethodBeat.i(87470);
        if (this.mapView == null) {
            AppMethodBeat.o(87470);
            return;
        }
        this.mapView.onResume();
        AppMethodBeat.o(87470);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public void onPause() {
        AppMethodBeat.i(87471);
        if (this.mapView == null) {
            AppMethodBeat.o(87471);
            return;
        }
        this.mapView.onPause();
        AppMethodBeat.o(87471);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public void onStop() {
        AppMethodBeat.i(87472);
        if (this.mapView == null) {
            AppMethodBeat.o(87472);
            return;
        }
        this.mapView.onStop();
        AppMethodBeat.o(87472);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public void onRestart() {
        AppMethodBeat.i(87473);
        if (this.mapView == null) {
            AppMethodBeat.o(87473);
            return;
        }
        this.mapView.onRestart();
        AppMethodBeat.o(87473);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public void onDestroyView() {
        AppMethodBeat.i(87474);
        if (this.mapView == null) {
            AppMethodBeat.o(87474);
            return;
        }
        this.mapView.onDestroyView();
        AppMethodBeat.o(87474);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public void onDestroy() {
        AppMethodBeat.i(87475);
        if (this.mapView == null) {
            AppMethodBeat.o(87475);
            return;
        }
        this.mapView.onDestroy();
        AppMethodBeat.o(87475);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(87476);
        if (this.mapView == null) {
            AppMethodBeat.o(87476);
            return;
        }
        this.mapView.onSaveInstanceState(bundle);
        AppMethodBeat.o(87476);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public void onLowMemory() {
        AppMethodBeat.i(87477);
        if (this.mapView == null) {
            AppMethodBeat.o(87477);
            return;
        }
        this.mapView.onLowMemory();
        AppMethodBeat.o(87477);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public Projection getProjection() {
        AppMethodBeat.i(87478);
        if (this.mapView == null) {
            AppMethodBeat.o(87478);
            return null;
        }
        Projection projection = this.mapView.getMap().getProjection();
        AppMethodBeat.o(87478);
        return projection;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public MapController getMapController() {
        AppMethodBeat.i(87479);
        if (this.mapView == null) {
            AppMethodBeat.o(87479);
            return null;
        }
        MapController mapController = this.mapView.getMapController();
        AppMethodBeat.o(87479);
        return mapController;
    }

    @Deprecated
    public LatLng getMapCenter() {
        AppMethodBeat.i(87480);
        if (this.mapView == null || this.mapView.getMap() == null) {
            AppMethodBeat.o(87480);
            return null;
        }
        LatLng mapCenter = this.mapView.getMap().getMapCenter();
        AppMethodBeat.o(87480);
        return mapCenter;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public UiSettings getUiSettings() {
        AppMethodBeat.i(87481);
        if (this.mapView == null) {
            AppMethodBeat.o(87481);
            return null;
        }
        UiSettings uiSettings = this.mapView.getUiSettings();
        AppMethodBeat.o(87481);
        return uiSettings;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(87482);
        if (this.mapView == null) {
            AppMethodBeat.o(87482);
            return;
        }
        this.mapView.updateViewLayout(view, layoutParams);
        AppMethodBeat.o(87482);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(87483);
        if (this.mapView != null) {
            this.mapView.onSizeChanged(i2, i3, i4, i5);
        }
        AppMethodBeat.o(87483);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.IMapView
    public void onSurfaceChanged(Object obj, int i2, int i3) {
        AppMethodBeat.i(87484);
        if (this.mapView != null) {
            this.mapView.onSurfaceChanged(obj, i2, i3);
        }
        AppMethodBeat.o(87484);
    }
}
