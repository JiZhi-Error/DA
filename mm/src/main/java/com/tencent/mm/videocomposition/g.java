package com.tencent.mm.videocomposition;

import android.graphics.Bitmap;
import java.util.List;
import kotlin.g.a.m;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 15}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00030\u0005j\u0002`\bH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\u0003H&J6\u0010\u000b\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00030\u0005j\u0002`\bH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H&¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "", "cancel", "", "callback", "Lkotlin/Function2;", "", "Landroid/graphics/Bitmap;", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "time", "destroy", "requestFrames", "times", "", "setSize", "width", "", "height", "video_composition_release"})
public interface g {
    void b(List<Long> list, m<? super Long, ? super Bitmap, x> mVar);

    void cancel(long j2);

    void destroy();

    void setSize(int i2, int i3);
}
