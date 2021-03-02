package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Rect;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Animationable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Clickable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Removable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Tagable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Visible;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import java.util.List;

public interface Polyline extends Animationable, Clickable, Levelable, Removable, Tagable<Object>, Visible, IOverlay {
    @Deprecated
    public static final int DARK_BLUE = 6;
    @Deprecated
    public static final int DASHED = 33;
    @Deprecated
    public static final int GREEN = 4;
    @Deprecated
    public static final int GREY = 0;
    @Deprecated
    public static final int LIGHT_BLUE = 1;
    @Deprecated
    public static final int RED = 2;
    @Deprecated
    public static final int WHITE_BLUE = 19;
    @Deprecated
    public static final int YELLOW = 3;

    void addTurnArrow(int i2, int i3);

    void appendPoint(LatLng... latLngArr);

    void appendPoints(List<LatLng> list);

    void cleanTurnArrow();

    void eraseTo(int i2, LatLng latLng);

    int getColor();

    int[][] getColors();

    List<Integer> getPattern();

    List<LatLng> getPoints();

    PolylineOptions getPolylineOptions();

    PolylineOptions.Text getText();

    Rect getVisibleRect();

    float getWidth();

    boolean isAboveMaskLayer();

    void pattern(List<Integer> list);

    void setAboveMaskLayer(boolean z);

    void setArrow(boolean z);

    void setColor(int i2);

    void setColorTexture(BitmapDescriptor bitmapDescriptor);

    void setColorTexture(String str);

    void setColors(int[] iArr, int[] iArr2);

    void setEraseable(boolean z);

    void setPoints(List<LatLng> list);

    void setPolylineOptions(PolylineOptions polylineOptions);

    void setText(PolylineOptions.Text text);

    void setWidth(float f2);

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Animationable
    void startAnimation(Animation animation);
}
