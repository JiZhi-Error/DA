package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.plugin.parent.RecordPluginLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusRecordPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/RecordPluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "generateCallback", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onResume", "plugin-textstatus_release"})
public final class TextStatusRecordPluginLayout extends RecordPluginLayout {
    private CaptureDataManager.b BOa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextStatusRecordPluginLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(258519);
        AppMethodBeat.o(258519);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void a(b bVar) {
        AppMethodBeat.i(258517);
        super.a(bVar);
        CaptureDataManager captureDataManager = CaptureDataManager.BOb;
        p.g(captureDataManager, "CaptureDataManager.INSTANCE");
        this.BOa = captureDataManager.hWJ();
        AppMethodBeat.o(258517);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.RecordPluginLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void onResume() {
        AppMethodBeat.i(258518);
        super.onResume();
        CaptureDataManager.b bVar = this.BOa;
        if (bVar != null) {
            CaptureDataManager.BOb.a(bVar);
            AppMethodBeat.o(258518);
            return;
        }
        AppMethodBeat.o(258518);
    }
}
