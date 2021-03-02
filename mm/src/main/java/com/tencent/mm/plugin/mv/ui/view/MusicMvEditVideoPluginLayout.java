package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.gallery.a.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "initLogic", "", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "loadCurrentPage", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-mv_release"})
public final class MusicMvEditVideoPluginLayout extends EditorVideoPluginLayoutNew {
    public static final a AxS = new a((byte) 0);

    static {
        AppMethodBeat.i(257531);
        AppMethodBeat.o(257531);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicMvEditVideoPluginLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(257530);
        AppMethodBeat.o(257530);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvEditVideoPluginLayout$Companion;", "", "()V", "TAG", "", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void a(b bVar) {
        String str;
        AppMethodBeat.i(257527);
        if (bVar != null) {
            c cVar = c.xsz;
            com.tencent.mm.plugin.sight.base.a awl = c.awl(bVar.iqd);
            RecordConfigProvider configProvider = getConfigProvider();
            if (configProvider == null || (str = configProvider.BOA) == null) {
                str = "";
            }
            Log.i("MicroMsg.MusicMvEditVideoPluginLayout", "videoInfo:" + awl + ", path:" + bVar.iqd + ',' + s.YS(bVar.iqd) + ", thumb:" + bVar.iqe + ',' + s.YS(bVar.iqe) + ", outputVideoPath:" + str);
            if (!Util.isNullOrNil(str)) {
                s.nw(bVar.iqd, str);
            }
            Boolean bool = Boolean.TRUE;
            String str2 = bVar.iqe;
            Long valueOf = Long.valueOf((long) awl.videoDuration);
            Boolean bool2 = Boolean.FALSE;
            com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
            CaptureDataManager.BOb.a(getContext(), new CaptureDataManager.CaptureVideoNormalModel(bool, str, str2, valueOf, bool2, com.tencent.mm.plugin.recordvideo.d.c.eKW()));
            AppMethodBeat.o(257527);
            return;
        }
        AppMethodBeat.o(257527);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void a(com.tencent.mm.plugin.recordvideo.activity.a aVar, RecordConfigProvider recordConfigProvider) {
        AppMethodBeat.i(257528);
        p.h(aVar, "navigator");
        p.h(recordConfigProvider, "configProvider");
        super.a(aVar, recordConfigProvider);
        AppMethodBeat.o(257528);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew, com.tencent.mm.plugin.recordvideo.plugin.parent.d
    public final void a(d.c cVar, Bundle bundle) {
        AppMethodBeat.i(257529);
        p.h(cVar, "status");
        switch (d.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                super.a(d.c.BVw, bundle);
                AppMethodBeat.o(257529);
                return;
            default:
                super.a(cVar, bundle);
                AppMethodBeat.o(257529);
                return;
        }
    }
}
