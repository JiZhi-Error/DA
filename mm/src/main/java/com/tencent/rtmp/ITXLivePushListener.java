package com.tencent.rtmp;

import android.os.Bundle;

public interface ITXLivePushListener {
    void onNetStatus(Bundle bundle);

    void onPushEvent(int i2, Bundle bundle);
}
