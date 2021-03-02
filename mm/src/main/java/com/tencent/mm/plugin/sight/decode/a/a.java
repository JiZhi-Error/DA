package com.tencent.mm.plugin.sight.decode.a;

import android.graphics.Bitmap;

public interface a {
    void clear();

    void e(String str, boolean z, int i2);

    void eVw();

    Object getTagObject();

    String getVideoPath();

    void im(int i2, int i3);

    void setCanPlay(boolean z);

    void setDrawableWidth(int i2);

    void setForceRecordState(boolean z);

    void setPosition(int i2);

    void setThumbBmp(Bitmap bitmap);
}
