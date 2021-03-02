package com.tencent.mm.plugin.vlog.ui.plugin;

import android.graphics.Rect;
import android.util.Size;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H&J(\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH&J\b\u0010!\u001a\u00020\u000fH&¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewImpl;", "", "currentPlayingTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "getCropChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getCropInView", "Landroid/graphics/Rect;", "getCropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "path", "", "getOperationCallback", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onActiveChange", "", "active", "", "onPreview", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "onUpdate", "playAfterUpdate", "seekToOriginPosition", "seekTo", "", "setMaxVisibleRect", "rect", "Landroid/graphics/RectF;", "setVideoSize", "size", "Landroid/util/Size;", "setVisibleRect", "showVideoLabel", "plugin-vlog_release"})
public interface z {
    void a(Size size);

    void a(ac acVar, boolean z, boolean z2, long j2);

    CropLayout.c fDH();

    WxCropOperationLayout.i fDI();

    void fDK();

    Rect fDa();

    void wH(boolean z);
}
