package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/util/SecondCutConfig;", "", "()V", "TAG", "", "getEditVideoToSecondCutEntrance", "", "getSecondCutDownloadUrl", "getShareVideoDuration", "", "getSnsToSecondCutEntrance", "plugin-recordvideo_release"})
public final class g {
    public static final g Ciw = new g();

    static {
        AppMethodBeat.i(238001);
        AppMethodBeat.o(238001);
    }

    private g() {
    }

    public static boolean eMO() {
        AppMethodBeat.i(237997);
        boolean a2 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_sns_home_to_ponenix_enable, false);
        Log.i("MicroMsg.SecondCutConfig", "SecondCutEntrance: ".concat(String.valueOf(a2)));
        AppMethodBeat.o(237997);
        return a2;
    }

    public static boolean eMP() {
        AppMethodBeat.i(237998);
        boolean a2 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_sns_edit_to_phoenix_enable, false);
        Log.i("MicroMsg.SecondCutConfig", "EditVideoToSecondCutEntrance: ".concat(String.valueOf(a2)));
        AppMethodBeat.o(237998);
        return a2;
    }

    public static int eMQ() {
        AppMethodBeat.i(237999);
        int a2 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_phoneix_video_duration, 30);
        Log.i("MicroMsg.SecondCutConfig", "ShareVideoDuration: ".concat(String.valueOf(a2)));
        AppMethodBeat.o(237999);
        return a2;
    }

    public static String eMR() {
        AppMethodBeat.i(238000);
        String a2 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_phoneix_download_url, "https://miaojian.weixin.qq.com/download/apps?channel=");
        Log.i("MicroMsg.SecondCutConfig", "SecondCutDownloadUrl: ".concat(String.valueOf(a2)));
        p.g(a2, "url");
        AppMethodBeat.o(238000);
        return a2;
    }
}
