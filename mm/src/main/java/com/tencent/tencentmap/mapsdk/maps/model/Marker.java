package com.tencent.tencentmap.mapsdk.maps.model;

import android.content.Context;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Accessible;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Alphable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Anchorable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Animationable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Clickable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Draggable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Removable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Rotatable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Tagable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Visible;

public interface Marker extends Accessible, Alphable, Anchorable, Animationable, Clickable, Draggable, Levelable, Removable, Rotatable, Tagable<Object>, Visible, IOverlay {
    int getDisplayLevel();

    int getHeight(Context context);

    TencentMap.OnMarkerDragListener getOnDragListener();

    MarkerOptions getOptions();

    LatLng getPosition();

    String getSnippet();

    String getTitle();

    int getWidth(Context context);

    void hideInfoWindow();

    boolean isFastLoad();

    boolean isInMapCenterState();

    boolean isInfoWindowAutoOverturn();

    boolean isInfoWindowEnable();

    boolean isInfoWindowShown();

    boolean onTapMapViewBubbleHidden();

    void refreshInfoWindow();

    void setFastLoad(boolean z);

    void setFixingPoint(int i2, int i3);

    void setFixingPointEnable(boolean z);

    void setIcon(BitmapDescriptor bitmapDescriptor);

    void setInMapCenterState(boolean z);

    void setInfoWindowAnchor(float f2, float f3);

    void setInfoWindowEnable(boolean z);

    void setInfoWindowOffset(int i2, int i3);

    void setMarkerOptions(MarkerOptions markerOptions);

    void setOnTapMapViewBubbleHidden(boolean z);

    void setPosition(LatLng latLng);

    void setSnippet(String str);

    void setTitle(String str);

    void showInfoWindow();
}
