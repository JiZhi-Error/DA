package com.tencent.tav.player;

import android.graphics.Bitmap;
import com.tencent.tav.coremedia.CMTime;

public interface OnReadSnapShootListener {
    void onSuccess(Bitmap bitmap, CMTime cMTime);
}
