package com.tencent.mm.plugin.finder.edit;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.vlog.ui.MultiVideoPluginLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/edit/FinderCoverEditPluginLayout;", "Lcom/tencent/mm/plugin/vlog/ui/MultiVideoPluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setupImageEditPlugins", "", "selectFirst", "", "plugin-finder_release"})
public final class FinderCoverEditPluginLayout extends MultiVideoPluginLayout {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderCoverEditPluginLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(243394);
        AppMethodBeat.o(243394);
    }

    @Override // com.tencent.mm.plugin.vlog.ui.MultiVideoPluginLayout
    public final void setupImageEditPlugins(boolean z) {
        AppMethodBeat.i(243393);
        super.setupImageEditPlugins(z);
        getMultiPreviewPlugin().GHe.setStyle(WxCropOperationLayout.j.RECT_HARD);
        setCurrentStyle(WxCropOperationLayout.j.RECT_HARD);
        AppMethodBeat.o(243393);
    }
}
