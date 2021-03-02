package com.tencent.mm.plugin.sight.decode.ui;

import android.view.View;

public interface a {
    void eVJ();

    int getVideoTotalTime();

    void seek(int i2);

    void setIplaySeekCallback(b bVar);

    void setIsPlay(boolean z);

    void setOnPlayButtonClickListener(View.OnClickListener onClickListener);

    void setVideoTotalTime(int i2);
}
