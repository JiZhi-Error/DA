package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.graphics.Canvas;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.scanner.model.ScanPoint;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u001cJ\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\u0003H&J#\u0010\r\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\nH&¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u0003H&J \u0010\u001a\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0007H&¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView;", "", "draw", "", "canvas", "Landroid/graphics/Canvas;", "isAnimating", "", "onViewSizeChanged", "width", "", "height", "release", "setAnimationDots", "points", "", "Lcom/tencent/mm/plugin/scanner/model/ScanPoint;", "pointCount", "([Lcom/tencent/mm/plugin/scanner/model/ScanPoint;I)V", "setDuration", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "startAnimation", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView$AnimationListener;", "stopAnimation", "updateViewSize", "forceUpdateDotsCenter", "AnimationListener", "plugin-scan_release"})
public interface c {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView$AnimationListener;", "", "onAnimationEnd", "", "dotsGroupView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView;", "onAnimationStart", "plugin-scan_release"})
    public interface a {
        void a(c cVar);
    }

    void A(int i2, int i3, boolean z);

    void a(a aVar);

    void a(ScanPoint[] scanPointArr, int i2);

    void draw(Canvas canvas);

    boolean isAnimating();

    void release();

    void setDuration(long j2);

    void stopAnimation();
}
