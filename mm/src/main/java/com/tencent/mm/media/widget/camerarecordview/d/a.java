package com.tencent.mm.media.widget.camerarecordview.d;

import android.content.Context;
import com.tencent.mm.media.widget.c.b;
import com.tencent.mm.media.widget.camerarecordview.preview.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH&J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\tH&J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0003H\u0016¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer;", "enableCameraOrientationFit", "", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getContext", "Landroid/content/Context;", "getDaemonVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRecordRenderer", "getRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "getVideoTransPara", "isMute", "useCpuCrop", "useDaemonRecorder", "plugin-mediaeditor_release"})
public interface a extends b {
    boolean Zx();

    boolean aQw();

    boolean aQx();

    boolean aQy();

    e getCameraPreviewView();

    Context getContext();

    VideoTransPara getDaemonVideoTransPara();

    com.tencent.mm.media.widget.camerarecordview.b.a getEncodeConfig();

    com.tencent.mm.media.j.a getPreviewRenderer();

    com.tencent.mm.media.j.a getRecordRenderer();

    b getRecorder();

    VideoTransPara getVideoTransPara();
}
