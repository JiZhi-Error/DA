package com.tencent.mm.plugin.appbrand.widget.desktop;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ao;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewBgParticleColorConfig;", "", "particleColor1", "", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "(IIIII)V", "getBgColor1", "()I", "getBgColor2", "getParticleColor1", "getParticleColor2", "getParticleColor3", "Companion", "plugin-appbrand-integration_release"})
public final class c {
    public static final c ooq = new c(-12105913, -13948117, -12105913, -14935012, -11316397);
    public static final c oor = new c(-11975584, -13948609, -11975584, -15263959, -11120530);
    public static final a oos = new a((byte) 0);
    private final int gRQ;
    private final int gRR;
    private final int gRS;
    final int gRT;
    private final int gRU;

    private c(int i2, int i3, int i4, int i5, int i6) {
        this.gRQ = i2;
        this.gRR = i3;
        this.gRS = i4;
        this.gRT = i5;
        this.gRU = i6;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewBgParticleColorConfig$Companion;", "", "()V", "DARK_MODE_PARTICLE_COLOR_CONFIG", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewBgParticleColorConfig;", "LIGHT_MODE_PARTICLE_COLOR_CONFIG", "getCurrentThemeConfig", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(229616);
        AppMethodBeat.o(229616);
    }

    public static final c caE() {
        AppMethodBeat.i(229617);
        if (ao.isDarkMode()) {
            c cVar = ooq;
            AppMethodBeat.o(229617);
            return cVar;
        }
        c cVar2 = oor;
        AppMethodBeat.o(229617);
        return cVar2;
    }
}
