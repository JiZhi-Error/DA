package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderLiveTextureView;", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "plugin-finder_release"})
public final class d extends TXCloudVideoView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(254050);
        AppMethodBeat.o(254050);
    }
}
