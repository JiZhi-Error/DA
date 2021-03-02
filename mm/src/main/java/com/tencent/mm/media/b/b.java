package com.tencent.mm.media.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/media/config/CodecConfigFlag;", "", "()V", "useSupportedEncoder", "", "getUseSupportedEncoder", "()Z", "setUseSupportedEncoder", "(Z)V", "plugin-mediaeditor_release"})
public final class b {
    private static boolean idy;
    public static final b idz = new b();

    static {
        AppMethodBeat.i(93517);
        AppMethodBeat.o(93517);
    }

    private b() {
    }

    public static boolean aLP() {
        return idy;
    }

    public static void eT(boolean z) {
        idy = z;
    }
}
