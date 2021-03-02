package com.tencent.mm.plugin.multitask.ui.bg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ao;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/bg/MultiTaskViewBgParticleColorConfig;", "", "particleColor1", "", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "(IIIII)V", "getBgColor1", "()I", "getBgColor2", "getParticleColor1", "getParticleColor2", "getParticleColor3", "Companion", "plugin-multitask_release"})
public final class a {
    public static final a AdE = new a(-12105913, -13948117, -12105913, -14935012, -11316397);
    public static final a AdF = new a(-11975584, -13948609, -11975584, -15263959, -11120530);
    public static final C1523a AdG = new C1523a((byte) 0);
    public final int gRQ;
    public final int gRR;
    public final int gRS;
    public final int gRT;
    public final int gRU;

    public static final a erA() {
        AppMethodBeat.i(200781);
        a erA = C1523a.erA();
        AppMethodBeat.o(200781);
        return erA;
    }

    private a(int i2, int i3, int i4, int i5, int i6) {
        this.gRQ = i2;
        this.gRR = i3;
        this.gRS = i4;
        this.gRT = i5;
        this.gRU = i6;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/bg/MultiTaskViewBgParticleColorConfig$Companion;", "", "()V", "DARK_MODE_PARTICLE_COLOR_CONFIG", "Lcom/tencent/mm/plugin/multitask/ui/bg/MultiTaskViewBgParticleColorConfig;", "LIGHT_MODE_PARTICLE_COLOR_CONFIG", "getCurrentThemeConfig", "plugin-multitask_release"})
    /* renamed from: com.tencent.mm.plugin.multitask.ui.bg.a$a  reason: collision with other inner class name */
    public static final class C1523a {
        private C1523a() {
        }

        public /* synthetic */ C1523a(byte b2) {
            this();
        }

        public static a erA() {
            AppMethodBeat.i(200779);
            if (ao.isDarkMode()) {
                a aVar = a.AdE;
                AppMethodBeat.o(200779);
                return aVar;
            }
            a aVar2 = a.AdF;
            AppMethodBeat.o(200779);
            return aVar2;
        }
    }

    static {
        AppMethodBeat.i(200780);
        AppMethodBeat.o(200780);
    }
}
