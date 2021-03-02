package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvEditPhotoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditPhotoPluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "plugin-mv_release"})
public final class MusicMvEditPhotoPluginLayout extends EditPhotoPluginLayout {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicMvEditPhotoPluginLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(257525);
        AppMethodBeat.o(257525);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void a(b bVar) {
        AppMethodBeat.i(257524);
        if (bVar != null) {
            Boolean bool = Boolean.TRUE;
            String str = bVar.iql;
            Boolean bool2 = Boolean.TRUE;
            c cVar = c.BXI;
            CaptureDataManager.BOb.a(getContext(), new CaptureDataManager.CaptureVideoNormalModel(bool, "", str, 0L, bool2, c.eKW()));
            AppMethodBeat.o(257524);
            return;
        }
        AppMethodBeat.o(257524);
    }
}
