package com.tencent.mapsdk.raster.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class BitmapDescriptor implements Cloneable {

    /* renamed from: h  reason: collision with root package name */
    int f1453h = 0;
    Bitmap mBitmap;
    int w = 0;

    public BitmapDescriptor(Bitmap bitmap) {
        AppMethodBeat.i(87553);
        if (bitmap != null) {
            this.w = bitmap.getWidth();
            this.f1453h = bitmap.getHeight();
            this.mBitmap = bitmap;
        }
        AppMethodBeat.o(87553);
    }

    private BitmapDescriptor(Bitmap bitmap, int i2, int i3) {
        this.w = i2;
        this.f1453h = i3;
        this.mBitmap = bitmap;
    }

    @Override // java.lang.Object
    public final BitmapDescriptor clone() {
        AppMethodBeat.i(87554);
        BitmapDescriptor bitmapDescriptor = new BitmapDescriptor(Bitmap.createBitmap(this.mBitmap), this.w, this.f1453h);
        AppMethodBeat.o(87554);
        return bitmapDescriptor;
    }

    public final Bitmap getBitmap() {
        return this.mBitmap;
    }

    public final int getWidth() {
        return this.w;
    }

    public final int getHeight() {
        return this.f1453h;
    }
}
