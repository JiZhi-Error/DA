package com.tencent.mm.plugin.finder.edit;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.activity.a;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/edit/FinderPhotoEditPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditPhotoPluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "operationLayoutPlugin", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "initLogic", "", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "loadCurrentPage", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "plugin-finder_release"})
public final class FinderPhotoEditPluginLayout extends EditPhotoPluginLayout {
    private final WxCropOperationLayout tHl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderPhotoEditPluginLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(165504);
        this.tHl = new WxCropOperationLayout(context);
        this.tHl.setStyle(WxCropOperationLayout.j.RECT_HARD);
        ((ViewGroup) findViewById(R.id.gbe)).addView(this.tHl, new ViewGroup.LayoutParams(-1, -1));
        AppMethodBeat.o(165504);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void a(a aVar, RecordConfigProvider recordConfigProvider) {
        AppMethodBeat.i(165502);
        p.h(aVar, "navigator");
        p.h(recordConfigProvider, "configProvider");
        super.a(aVar, recordConfigProvider);
        Bundle bundle = recordConfigProvider.jkf;
        if (bundle != null) {
            Rect rect = (Rect) bundle.getParcelable("cropRect");
            if (rect != null) {
                this.tHl.getVisibilityRect().set(rect);
                AppMethodBeat.o(165502);
                return;
            }
            AppMethodBeat.o(165502);
            return;
        }
        AppMethodBeat.o(165502);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void a(b bVar) {
        AppMethodBeat.i(165503);
        super.a(bVar);
        com.tencent.mm.bt.b bVar2 = getEditPhotoWrapper().zQp;
        if (bVar2 != null) {
            bVar2.gtf();
        }
        this.tHl.bringToFront();
        AppMethodBeat.o(165503);
    }
}
