package com.tencent.mm.plugin.k;

import android.graphics.Point;
import android.view.View;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.tencentmap.mapsdk.map.CameraUpdate;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import java.util.Collection;
import java.util.Set;

public interface d {
    void addPinView(View view, double d2, double d3);

    void addView(Object obj, double d2, double d3, String str);

    void animateCamera(CameraUpdate cameraUpdate);

    void clean();

    void destroy();

    void disableDarkMode();

    Circle drawAccuracyCircle(double d2, double d3, double d4);

    void enableDarkMode();

    Collection<Object> getChilds();

    b getIController();

    int getMapCenterX();

    int getMapCenterY();

    Point getPointByGeoPoint(double d2, double d3);

    Set<String> getTags();

    Object getViewByItag(String str);

    e getViewManager();

    int getZoom();

    int getZoomLevel();

    void invalidate();

    void removeView(View view);

    Object removeViewByTag(String str);

    void setBuiltInZoomControls(boolean z);

    void setCanRotate(boolean z);

    void setLogoMargin(int[] iArr);

    void setMapAnchor(float f2, float f3);

    void setMapViewOnTouchListener(View.OnTouchListener onTouchListener);

    void setMarkerClickListener(View view, TencentMap.OnMarkerClickListener onMarkerClickListener);

    void updateLocaitonPinLayout(View view, double d2, double d3);

    void updateMarkerView(View view);

    void zoomToSpan(double d2, double d3, double d4, double d5);
}
