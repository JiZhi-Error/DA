package com.tencent.rtmp.a;

import android.graphics.Bitmap;
import java.util.List;

public interface a {
    Bitmap getThumbnail(float f2);

    void release();

    void setVTTUrlAndImageUrls(String str, List<String> list);
}
