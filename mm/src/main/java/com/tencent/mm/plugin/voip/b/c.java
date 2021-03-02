package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000bJ\u0016\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/voip/util/VoIPEncoderInfo;", "", "()V", "ENCODER_DEFAULT", "", "ENCODER_HW", "ENCODER_SOFT", "encodeH", "encodeW", "encoderType", "useGpuCrop", "", "getUseGpuCrop", "()Z", "setUseGpuCrop", "(Z)V", "clear", "", "setType", "isSoft", "setWH", "w", "h", "plugin-voip_release"})
public final class c {
    private static boolean HdC = g.fKj();
    public static int HgN;
    public static int HgO;
    public static int HgP;
    public static final c HgQ = new c();

    static {
        AppMethodBeat.i(236034);
        g gVar = g.HgZ;
        AppMethodBeat.o(236034);
    }

    private c() {
    }

    public static void ec(int i2, int i3) {
        HgN = i2;
        HgO = i3;
    }

    public static void xr(boolean z) {
        if (z) {
            HgP = 1;
        } else {
            HgP = 2;
        }
    }

    public static void clear() {
        AppMethodBeat.i(236033);
        HgP = 0;
        HgN = 0;
        HgO = 0;
        g gVar = g.HgZ;
        HdC = g.fKj();
        AppMethodBeat.o(236033);
    }
}
