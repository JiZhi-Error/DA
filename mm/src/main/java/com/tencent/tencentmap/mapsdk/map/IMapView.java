package com.tencent.tencentmap.mapsdk.map;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.tencentmap.mapsdk.map.MapView;

public interface IMapView {
    void addView(View view, MapView.LayoutParams layoutParams);

    boolean dispatchTouchEvent(MotionEvent motionEvent);

    TencentMap getMap();

    @Deprecated
    MapController getMapController();

    View getMapView();

    Projection getProjection();

    UiSettings getUiSettings();

    void onCreate(Bundle bundle);

    void onDestroy();

    void onDestroyView();

    void onLowMemory();

    void onPause();

    void onRestart();

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void onSizeChanged(int i2, int i3, int i4, int i5);

    void onStart();

    void onStop();

    void onSurfaceChanged(Object obj, int i2, int i3);

    boolean onTouchEvent(MotionEvent motionEvent);

    void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams);
}
