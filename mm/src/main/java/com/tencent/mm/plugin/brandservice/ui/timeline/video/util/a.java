package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.j;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.MMFileSlotManager;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizPlaylistFileMgr;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "playlistManager", "Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "getPlaylistManager", "()Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "isProxyOpen", "", "save", "", "url", "content", "plugin-brandservice_release"})
public final class a {
    public static final String TAG = TAG;
    public static final MMFileSlotManager pKj = new MMFileSlotManager("bizplaylist", 86400);
    public static final a pKk = new a();

    static {
        AppMethodBeat.i(175529);
        AppMethodBeat.o(175529);
    }

    private a() {
    }

    public static boolean cqV() {
        AppMethodBeat.i(175528);
        if (!j.bJE().bJG() || ((b) g.af(b.class)).a(b.a.clicfg_open_biz_native_video_proxy, 0) != 1) {
            AppMethodBeat.o(175528);
            return false;
        }
        AppMethodBeat.o(175528);
        return true;
    }
}
