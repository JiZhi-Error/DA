package com.tencent.mm.plugin.recordvideo.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/biz/MediaGenerateMediaCallback;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "()V", "onEditFinish", "", "forward", "", "reportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "extData", "Landroid/os/Bundle;", "onFinishBtnClick", "context", "Landroid/content/Context;", "finishController", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaGenerated", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "plugin-recordvideo_release"})
public final class a implements CaptureDataManager.b {
    @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
    public final boolean a(Context context, Bundle bundle, CaptureDataManager.a aVar) {
        AppMethodBeat.i(75341);
        p.h(context, "context");
        p.h(bundle, "extData");
        p.h(aVar, "finishController");
        AppMethodBeat.o(75341);
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
    public final void a(Context context, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel, Bundle bundle) {
        AppMethodBeat.i(75342);
        p.h(context, "context");
        p.h(captureVideoNormalModel, "model");
        p.h(bundle, "extData");
        Intent intent = new Intent();
        intent.putExtra("key_extra_data", bundle);
        intent.putExtra("KSEGMENTMEDIAINFO", captureVideoNormalModel);
        ((Activity) context).setResult(-1, intent);
        ((Activity) context).finish();
        AppMethodBeat.o(75342);
    }

    @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
    public final void a(RecordMediaReportInfo recordMediaReportInfo, Bundle bundle) {
        AppMethodBeat.i(237254);
        p.h(recordMediaReportInfo, "reportInfo");
        p.h(bundle, "extData");
        AppMethodBeat.o(237254);
    }
}
