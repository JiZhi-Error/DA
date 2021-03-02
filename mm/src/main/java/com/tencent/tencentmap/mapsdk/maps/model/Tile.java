package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;

public final class Tile {
    public static Tile EMPTY_TILE = new Tile(-1, -1, getNoTileData());
    public final byte[] mData;
    public final int mHeight;
    public final int mWidth;

    static {
        AppMethodBeat.i(181089);
        AppMethodBeat.o(181089);
    }

    public Tile(int i2, int i3, byte[] bArr) {
        this.mWidth = i2;
        this.mHeight = i3;
        this.mData = bArr;
    }

    private static byte[] getNoTileData() {
        AppMethodBeat.i(181088);
        Bitmap createBitmap = Bitmap.createBitmap(256, 256, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawARGB(0, 255, 255, 255);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(181088);
        return byteArray;
    }

    public final byte[] getData() {
        return this.mData;
    }
}
