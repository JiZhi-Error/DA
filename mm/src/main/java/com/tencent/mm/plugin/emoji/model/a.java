package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.protocal.protobuf.EmotionBanner;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;

public final class a {
    public EmotionBannerSet raV;
    public EmotionBanner raW;
    public boolean raX = false;

    public a(EmotionBanner emotionBanner, EmotionBannerSet emotionBannerSet, boolean z) {
        this.raW = emotionBanner;
        this.raV = emotionBannerSet;
        this.raX = z;
    }
}
