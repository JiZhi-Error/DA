package com.tencent.mm.plugin.vlog.ui.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/FinderVideoCropLocalConfig;", "", "()V", "TAG", "", "isEnable43RatioVideo", "", "()Z", "plugin-vlog_release"})
public final class f {
    public static final f GHk = new f();

    static {
        AppMethodBeat.i(191277);
        AppMethodBeat.o(191277);
    }

    private f() {
    }

    public static boolean fDl() {
        AppMethodBeat.i(191276);
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_finder_video_3_4_ratio_enable, 0);
        int i2 = MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_VIDEO_RATIO_3_4_INT_SYNC", 0);
        Log.i("MicroMsg.FinderVideoCropLocalConfig", "init, isEnable43RatioVideo:" + a2 + ", localConfig:" + i2);
        if (i2 != 0) {
            if (i2 == 1) {
                AppMethodBeat.o(191276);
                return true;
            }
            AppMethodBeat.o(191276);
            return false;
        } else if (a2 == 1) {
            AppMethodBeat.o(191276);
            return true;
        } else {
            AppMethodBeat.o(191276);
            return false;
        }
    }
}
