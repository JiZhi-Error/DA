package com.tencent.tencentmap.mapsdk.maps;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Parcelable;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface TencentMapResource {

    @Retention(RetentionPolicy.SOURCE)
    public @interface ResourceFrom {
        public static final int ASSET = -1;
        public static final int FILE = 2;
        public static final int JSON = 3;
        public static final int RAW = 1;
    }

    BitmapDescriptor createBitmapDescriptor(float f2, int i2);

    BitmapDescriptor createBitmapDescriptor(int i2);

    BitmapDescriptor createBitmapDescriptor(int i2, int i3);

    BitmapDescriptor createBitmapDescriptor(Bitmap bitmap, int i2);

    BitmapDescriptor createBitmapDescriptor(Parcelable parcelable, int i2);

    BitmapDescriptor createBitmapDescriptor(String str, int i2);

    MyLocationStyle getDefaultMyLocationStyle();

    int getScreenPixels();

    Typeface getTypeface();
}
