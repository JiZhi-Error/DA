package com.tencent.mm.plugin.appbrand.task.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/task/preload/AppBrandPreloadDowngradeTestShortcut;", "", "()V", "MMKV_HARD_CODE_LEVEL_TAG", "", "NON_HARD_CODE", "", "hardcodeLevel", "setHardLevel", "", "level", "plugin-appbrand-integration_release"})
public final class a {
    public static final a nQO = new a();

    static {
        AppMethodBeat.i(229448);
        AppMethodBeat.o(229448);
    }

    private a() {
    }

    public static int bWD() {
        AppMethodBeat.i(229446);
        MultiProcessMMKV VQ = f.kIs.VQ();
        if (VQ != null) {
            int i2 = VQ.getInt("AppBrandPreloadDowngradeSwitcher.MMKV_HARD_CODE_LEVEL_TAG", -2);
            AppMethodBeat.o(229446);
            return i2;
        }
        AppMethodBeat.o(229446);
        return -2;
    }

    public static void zo(int i2) {
        AppMethodBeat.i(229447);
        MultiProcessMMKV VQ = f.kIs.VQ();
        if (VQ == null) {
            p.hyc();
        }
        VQ.putInt("AppBrandPreloadDowngradeSwitcher.MMKV_HARD_CODE_LEVEL_TAG", i2);
        AppMethodBeat.o(229447);
    }
}
