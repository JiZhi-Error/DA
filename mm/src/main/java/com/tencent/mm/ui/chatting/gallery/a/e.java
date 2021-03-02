package com.tencent.mm.ui.chatting.gallery.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.websearch.api.c;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\b\u001a\u00020\u0006H\u0007J\b\u0010\t\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonConfigManager;", "", "()V", "TAG", "", "openImageSearch", "", "showScanCodeButton", "showSearchBubble", "showSearchButton", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "app_release"})
public final class e {
    private static boolean PBR = true;
    private static boolean PBS;
    private static boolean PBT;
    private static boolean PBU;
    public static final e PBV = new e();

    static {
        AppMethodBeat.i(231225);
        AppMethodBeat.o(231225);
    }

    private e() {
    }

    public static final void init() {
        boolean z;
        AppMethodBeat.i(231224);
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_scan_chat_image_button_disable, 0);
        PBR = a2 == 0;
        a ah = g.ah(c.class);
        p.g(ah, "MMKernel.plugin(IPluginWebSearch::class.java)");
        boolean isOpenImageSearch = ((c) ah).isOpenImageSearch();
        PBS = isOpenImageSearch;
        PBT = isOpenImageSearch;
        int a3 = ((b) g.af(b.class)).a(b.a.clicfg_chat_image_show_search_bubble_enable, 0);
        if (!PBS || (a3 != 1 && !BuildInfo.DEBUG && !BuildInfo.IS_FLAVOR_RED)) {
            z = false;
        } else {
            z = true;
        }
        PBU = z;
        Log.i("MicroMsg.ImageScanCodeConfigManager", "ImageScanCodeConfigManager init config: %d, showScanCodeButton: %b, openImageSearch: %b, showSearchButton: %b, showSearchBubbleConfig: %d, showSearchBubble: %b", Integer.valueOf(a2), Boolean.valueOf(PBR), Boolean.valueOf(PBS), Boolean.valueOf(PBT), Integer.valueOf(a3), Boolean.valueOf(PBU));
        AppMethodBeat.o(231224);
    }

    public static final boolean gTr() {
        return PBR;
    }

    public static final boolean gTs() {
        return PBT;
    }

    public static final boolean gTt() {
        return PBU;
    }
}
