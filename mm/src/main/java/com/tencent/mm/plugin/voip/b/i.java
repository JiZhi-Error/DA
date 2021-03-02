package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bJ&\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015J\u0016\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015J\u0016\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015J\u001e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015J \u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u001d\u001a\u00020\u000fH\u0002J\u0018\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0006\u0010\u001f\u001a\u00020\u000fJ\u0018\u0010 \u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/voip/util/VoipRendererReportPrev;", "", "()V", "addRendererViewInFullScreenWindowsTimes", "", "addRendererViewInFullScreenWindowsTimesInviteUI", "addRendererViewInMiniScreenWindowsTimes", "addRendererViewInMiniScreenWindowsTimesInviteUI", "changeToHWCount", "changeToSWCount", "mCameraRenderFrameCount", "", "mServiceRenderFrameCount", "mYuvRenderFrameCount", "onDecModeChanged", "", "mode", "onFrameDrawCost", "cost", "type", "isFullScreen", "", "isUseFaceBeauty", "onRendererDrawPerFrameEndAfterAddView", "isInviteUi", "onRendererDrawPerFrameEndAfterAddViewAfterInit", "onRendererViewAdd", "times", "reportCameraYUVRendererCostPerFrame", "reportRendererTypeChangeCount", "reportServiceRendererCostPerFrame", "reportWhileFinish", "reportYUVRendererCostPerFrame", "Companion", "plugin-voip_release"})
public final class i {
    public static final a Hho = new a((byte) 0);
    public long Hha = -1;
    public long Hhb = -1;
    public long Hhe = -1;
    public long Hhf = -1;
    public int Hhi = -1;
    public int Hhj = -1;
    public int Hhk = -1;
    public long Hhm = -1;
    public long Hhn = -1;

    static {
        AppMethodBeat.i(236100);
        AppMethodBeat.o(236100);
    }

    public final void fKp() {
        AppMethodBeat.i(236096);
        f fVar = f.HgY;
        f.fKd();
        fKn();
        AppMethodBeat.o(236096);
    }

    public final void aO(boolean z, boolean z2) {
        AppMethodBeat.i(236097);
        if (z) {
            if (!z2) {
                if (this.Hhe != -1) {
                    f fVar = f.HgY;
                    f.LC(Util.ticksToNow(this.Hhe));
                    this.Hhe = -1;
                }
                AppMethodBeat.o(236097);
                return;
            } else if (this.Hhm != -1) {
                f fVar2 = f.HgY;
                f.LC(Util.ticksToNow(this.Hhm));
                this.Hhm = -1;
                AppMethodBeat.o(236097);
                return;
            }
        } else if (z2) {
            if (this.Hhn != -1) {
                f fVar3 = f.HgY;
                f.LD(Util.ticksToNow(this.Hhn));
                this.Hhn = -1;
                AppMethodBeat.o(236097);
                return;
            }
        } else if (this.Hhf != -1) {
            f fVar4 = f.HgY;
            f.LD(Util.ticksToNow(this.Hhf));
            this.Hhf = -1;
        }
        AppMethodBeat.o(236097);
    }

    public final void aP(boolean z, boolean z2) {
        AppMethodBeat.i(236098);
        if (z) {
            if (!z2) {
                if (this.Hhe != -1) {
                    f fVar = f.HgY;
                    f.Lq(Util.ticksToNow(this.Hhe));
                    this.Hhe = -1;
                }
                AppMethodBeat.o(236098);
                return;
            } else if (this.Hhm != -1) {
                f fVar2 = f.HgY;
                f.LA(Util.ticksToNow(this.Hhm));
                this.Hhm = -1;
                AppMethodBeat.o(236098);
                return;
            }
        } else if (z2) {
            if (this.Hhn != -1) {
                f fVar3 = f.HgY;
                f.LB(Util.ticksToNow(this.Hhn));
                this.Hhn = -1;
                AppMethodBeat.o(236098);
                return;
            }
        } else if (this.Hhf != -1) {
            f fVar4 = f.HgY;
            f.Lr(Util.ticksToNow(this.Hhf));
            this.Hhf = -1;
        }
        AppMethodBeat.o(236098);
    }

    private final void fKn() {
        AppMethodBeat.i(236099);
        this.Hha++;
        this.Hhb++;
        if (this.Hha > 0) {
            f fVar = f.HgY;
            f.Lm(this.Hha);
        }
        if (this.Hhb > 0) {
            f fVar2 = f.HgY;
            f.Ln(this.Hhb);
        }
        this.Hha = -1;
        this.Hhb = -1;
        AppMethodBeat.o(236099);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/voip/util/VoipRendererReportPrev$Companion;", "", "()V", "reportBatteryAverage", "", "data", "", "type", "", "plugin-voip_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void aj(long j2, int i2) {
            AppMethodBeat.i(236095);
            switch (i2) {
                case 0:
                    f fVar = f.HgY;
                    f.Lp(j2);
                    AppMethodBeat.o(236095);
                    return;
                case 1:
                    f fVar2 = f.HgY;
                    f.Lo(j2);
                    break;
            }
            AppMethodBeat.o(236095);
        }
    }
}
