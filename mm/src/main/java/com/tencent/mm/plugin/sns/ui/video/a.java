package com.tencent.mm.plugin.sns.ui.video;

import android.graphics.Rect;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;

public interface a {
    void a(BaseTimeLineItem.BaseViewHolder baseViewHolder, int i2);

    Rect getDisplayRect();

    void onUIPause();

    void pause();

    void stop();
}
