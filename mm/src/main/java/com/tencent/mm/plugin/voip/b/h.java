package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tJ&\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017J\u0016\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017J\u0016\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017J\u001e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017J\u000e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\tJ \u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010 \u001a\u00020\u0011H\u0002J\b\u0010!\u001a\u00020\u0011H\u0002J\u0018\u0010\"\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010#\u001a\u00020\u0011J\u0018\u0010$\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/voip/util/VoipRendererReport;", "", "()V", "addRendererViewInFullScreenWindowsTimes", "", "addRendererViewInFullScreenWindowsTimesInvite", "addRendererViewInMiniScreenWindowsTimes", "addRendererViewInMiniScreenWindowsTimesInvite", "changeToFullScreenCount", "", "changeToHWCount", "changeToMiniScreenCount", "changeToSWCount", "mCameraRenderFrameCount", "mServiceRenderFrameCount", "mYuvRenderFrameCount", "onDecModeChanged", "", "mode", "onFrameDrawCost", "cost", "type", "isFullScreen", "", "isFaceBeauty", "onRendererDrawPerFrameEndAfterAddView", "isInvite", "onRendererDrawPerFrameEndAfterAddViewAfterInit", "onRendererViewAdd", "times", "onWindowTypeChanged", "reportCameraRendererCostPerFrame", "reportRendererTypeChangeCount", "reportRendererWindowTypePercent", "reportServiceRendererCostPerFrame", "reportWhileFinish", "reportYUVRendererCostPerFrame", "Companion", "plugin-voip_release"})
public final class h {
    public static final a Hhl = new a((byte) 0);
    public long Hha = -1;
    public long Hhb = -1;
    private int Hhc = -1;
    private int Hhd = -1;
    public long Hhe = -1;
    public long Hhf = -1;
    public long Hhg = -1;
    public long Hhh = -1;
    public int Hhi = -1;
    public int Hhj = -1;
    public int Hhk = -1;

    static {
        AppMethodBeat.i(236091);
        AppMethodBeat.o(236091);
    }

    public final void adI(int i2) {
        switch (i2) {
            case 0:
                this.Hhd++;
                return;
            case 1:
                this.Hhc++;
                return;
            default:
                return;
        }
    }

    public final void aO(boolean z, boolean z2) {
        AppMethodBeat.i(236086);
        if (z) {
            if (!z2) {
                if (this.Hhe != -1) {
                    j jVar = j.Hhp;
                    j.LC(Util.ticksToNow(this.Hhe));
                    this.Hhe = -1;
                }
                AppMethodBeat.o(236086);
                return;
            } else if (this.Hhg != -1) {
                j jVar2 = j.Hhp;
                j.LC(Util.ticksToNow(this.Hhg));
                this.Hhg = -1;
                AppMethodBeat.o(236086);
                return;
            }
        } else if (z2) {
            if (this.Hhh != -1) {
                j jVar3 = j.Hhp;
                j.LD(Util.ticksToNow(this.Hhh));
                this.Hhh = -1;
                AppMethodBeat.o(236086);
                return;
            }
        } else if (this.Hhf != -1) {
            j jVar4 = j.Hhp;
            j.LD(Util.ticksToNow(this.Hhf));
            this.Hhf = -1;
        }
        AppMethodBeat.o(236086);
    }

    public final void aP(boolean z, boolean z2) {
        AppMethodBeat.i(236087);
        if (z) {
            if (!z2) {
                if (this.Hhe != -1) {
                    j jVar = j.Hhp;
                    j.Lq(Util.ticksToNow(this.Hhe));
                    this.Hhe = -1;
                }
                AppMethodBeat.o(236087);
                return;
            } else if (this.Hhg != -1) {
                j jVar2 = j.Hhp;
                j.LA(Util.ticksToNow(this.Hhg));
                this.Hhg = -1;
                AppMethodBeat.o(236087);
                return;
            }
        } else if (z2) {
            if (this.Hhh != -1) {
                j jVar3 = j.Hhp;
                j.LB(Util.ticksToNow(this.Hhh));
                this.Hhh = -1;
                AppMethodBeat.o(236087);
                return;
            }
        } else if (this.Hhf != -1) {
            j jVar4 = j.Hhp;
            j.Lr(Util.ticksToNow(this.Hhf));
            this.Hhf = -1;
        }
        AppMethodBeat.o(236087);
    }

    private final void fKn() {
        AppMethodBeat.i(236088);
        this.Hha++;
        this.Hhb++;
        if (this.Hha > 0) {
            j jVar = j.Hhp;
            j.Lm(this.Hha);
        }
        if (this.Hhb > 0) {
            j jVar2 = j.Hhp;
            j.Ln(this.Hhb);
        }
        this.Hha = -1;
        this.Hhb = -1;
        AppMethodBeat.o(236088);
    }

    private final void fKo() {
        AppMethodBeat.i(236089);
        this.Hhc++;
        this.Hhd++;
        int i2 = this.Hhc + this.Hhd;
        if (i2 != 0) {
            if (this.Hhc > 0) {
                j jVar = j.Hhp;
                j.LG((long) ((this.Hhc * 100) / i2));
            }
            if (this.Hhd > 0) {
                j jVar2 = j.Hhp;
                j.LH((long) ((this.Hhd * 100) / i2));
            }
        }
        this.Hhc = -1;
        this.Hhd = -1;
        AppMethodBeat.o(236089);
    }

    public final void fKp() {
        AppMethodBeat.i(236090);
        j jVar = j.Hhp;
        j.fKr();
        fKn();
        fKo();
        AppMethodBeat.o(236090);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0007J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000eH\u0007J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/voip/util/VoipRendererReport$Companion;", "", "()V", "reportBatteryAverage", "", "data", "", "type", "", "reportCameraOnError", "reportFaceBeautyAlgoException", "reportFaceBeautyUse", "reportNewRendererInitSucc", "isCamera", "", "reportPboSizeInit", "width", "height", "reportRendererModeChanged", "isManual", "reportRendererUse", "plugin-voip_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void xt(boolean z) {
            AppMethodBeat.i(236081);
            if (z) {
                j jVar = j.Hhp;
                j.fKt();
                AppMethodBeat.o(236081);
                return;
            }
            j jVar2 = j.Hhp;
            j.fKu();
            AppMethodBeat.o(236081);
        }

        public static void aA(long j2, long j3) {
            AppMethodBeat.i(236082);
            j jVar = j.Hhp;
            j.LE(j2);
            j jVar2 = j.Hhp;
            j.LF(j3);
            AppMethodBeat.o(236082);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public static void adK(int i2) {
            AppMethodBeat.i(236083);
            switch (i2) {
                case 0:
                    j jVar = j.Hhp;
                    j.fKz();
                    AppMethodBeat.o(236083);
                    return;
                case 1:
                    j jVar2 = j.Hhp;
                    j.fKA();
                    AppMethodBeat.o(236083);
                    return;
                case 2:
                    j jVar3 = j.Hhp;
                    j.fKB();
                    break;
            }
            AppMethodBeat.o(236083);
        }

        public static void adL(int i2) {
            AppMethodBeat.i(236084);
            switch (i2) {
                case 0:
                    j jVar = j.Hhp;
                    j.fKC();
                    AppMethodBeat.o(236084);
                    return;
                case 1:
                    j jVar2 = j.Hhp;
                    j.fKD();
                    break;
            }
            AppMethodBeat.o(236084);
        }

        public static void aj(long j2, int i2) {
            AppMethodBeat.i(236085);
            switch (i2) {
                case 0:
                    j jVar = j.Hhp;
                    j.Lp(j2);
                    AppMethodBeat.o(236085);
                    return;
                case 1:
                    j jVar2 = j.Hhp;
                    j.Lo(j2);
                    break;
            }
            AppMethodBeat.o(236085);
        }
    }

    public static final void fKq() {
        AppMethodBeat.i(236092);
        j jVar = j.Hhp;
        j.fKs();
        AppMethodBeat.o(236092);
    }

    public static final void adJ(int i2) {
        AppMethodBeat.i(236093);
        switch (i2) {
            case 0:
                j jVar = j.Hhp;
                j.fKv();
                AppMethodBeat.o(236093);
                return;
            case 1:
                j jVar2 = j.Hhp;
                j.fKw();
                break;
        }
        AppMethodBeat.o(236093);
    }

    public static final void xs(boolean z) {
        AppMethodBeat.i(236094);
        if (z) {
            j jVar = j.Hhp;
            j.fKy();
            AppMethodBeat.o(236094);
            return;
        }
        j jVar2 = j.Hhp;
        j.fKx();
        AppMethodBeat.o(236094);
    }
}
