package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "", "getCropLayout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "getOperationLayout", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "getParentLayout", "Landroid/view/ViewGroup;", "getSceneDescTv", "Landroid/widget/TextView;", "getVideoView", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "tryPlayVideo", "", "plugin-vlog_release"})
public interface aa {
    VideoCompositionPlayView fCU();

    ViewGroup fDf();

    CropLayout fDg();

    void fDh();

    TextView fDi();

    WxCropOperationLayout getOperationLayout();
}
