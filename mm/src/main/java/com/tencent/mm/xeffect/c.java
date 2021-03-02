package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J\u0016\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/xeffect/XEffectFileUtils;", "", "()V", "OpenCLCNNLibPath", "", "TAG", "imageLabelName", "checkAssetsMatch", "", "localMd5", "copyAssets", "", "assets", "Landroid/content/res/AssetManager;", "assetsPath", "localPath", "copyModelFiles", "context", "Landroid/content/Context;", "output", "getAssetsMD5", "renderlib_release"})
public final class c {
    public static final c RxL = new c();
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(237042);
        AppMethodBeat.o(237042);
    }

    private c() {
    }

    public static boolean bpD(String str) {
        AppMethodBeat.i(237041);
        p.h(str, "localMd5");
        boolean j2 = p.j("5e445f56169846703c5ad7bf55e3665a", str);
        AppMethodBeat.o(237041);
        return j2;
    }

    public static String his() {
        return "5e445f56169846703c5ad7bf55e3665a";
    }
}
