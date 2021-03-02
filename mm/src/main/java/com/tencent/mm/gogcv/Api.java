package com.tencent.mm.gogcv;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Api {
    public native byte[] checkImage(Bitmap bitmap);

    public native byte[] checkVideo(Bitmap[] bitmapArr);

    public native boolean init(String str);

    public native void release();

    public static Bitmap[] a(String str, float[] fArr) {
        AppMethodBeat.i(190311);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
        Bitmap[] bitmapArr = new Bitmap[fArr.length];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            bitmapArr[i2] = mediaMetadataRetriever.getFrameAtTime((long) (((float) ((parseLong - 1) * 1000)) * fArr[i2]), 2);
        }
        mediaMetadataRetriever.release();
        AppMethodBeat.o(190311);
        return bitmapArr;
    }
}
