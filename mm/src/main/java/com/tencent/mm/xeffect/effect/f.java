package com.tencent.mm.xeffect.effect;

import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/xeffect/effect/EffectLayoutInfo;", "", "centerX", "", "centerY", "scale", "", FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, "(IIFF)V", "getCenterX", "()I", "setCenterX", "(I)V", "getCenterY", "setCenterY", "getRotate", "()F", "setRotate", "(F)V", "getScale", "setScale", "renderlib_release"})
public final class f {
    int centerX;
    int centerY;
    float mat;
    float scale;

    public f(int i2, int i3, float f2, float f3) {
        this.centerX = i2;
        this.centerY = i3;
        this.scale = f2;
        this.mat = f3;
    }

    public /* synthetic */ f() {
        this(0, 0, 1.0f, 0.0f);
    }
}
