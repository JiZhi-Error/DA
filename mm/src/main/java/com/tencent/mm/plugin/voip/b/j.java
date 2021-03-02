package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b/\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0004J\u000e\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0004J\u0006\u0010\u001e\u001a\u00020\bJ\u0006\u0010\u001f\u001a\u00020\bJ\u000e\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0004J\u000e\u0010\"\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010#\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010$\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010%\u001a\u00020\bJ\u0006\u0010&\u001a\u00020\bJ\u0006\u0010'\u001a\u00020\bJ\u000e\u0010(\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0004J\u0006\u0010)\u001a\u00020\bJ\b\u0010*\u001a\u00020\bH\u0007J\u000e\u0010+\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010,\u001a\u00020\bJ\u0006\u0010-\u001a\u00020\bJ\u0006\u0010.\u001a\u00020\bJ\u0006\u0010/\u001a\u00020\bJ\u000e\u00100\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u00101\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u00102\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u00103\u001a\u00020\bJ\u0006\u00104\u001a\u00020\bJ\u000e\u00105\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u00106\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u00067"}, hxF = {"Lcom/tencent/mm/plugin/voip/util/VoipReportHelper;", "", "()V", "ID", "", "TAG", "", "markAddViewFullScreenToRendererCost", "", "data", "markAddViewFullScreenToRendererCostFirst", "markAddViewFullScreenToRendererCostInvite", "markAddViewMiniWindowToRendererCost", "markAddViewMiniWindowToRendererCostFirst", "markAddViewMiniWindowToRendererCostInvite", "markBatteryPropertyCurrentInHW", "markBatteryPropertyCurrentInSW", "markCameraOnError", "markCameraPboSizeHeight", "height", "markCameraPboSizeWidth", "width", "markCameraRendererPerFrameNewFullScreenCost", "cost", "markCameraRendererPerFrameNewFullScreenCostWithFaceBeauty", "markCameraRendererPerFrameNewMiniWindowCost", "markCameraRendererPerFrameNewMiniWindowCostWithFaceBeauty", "markDecodeModeChangeToHW", "count", "markDecodeModeChangeToSW", "markFaceBeautySendDataIlleagel", "markFaceBeautySendDataNull", "markFullScreenPercent", "percent", "markHWEncodeAvgCost", "markHWRendererPerFrameFullScreenCost", "markHWRendererPerFrameMiniWindowCost", "markInitCameraRendererSucc", "markInitServiceRendererSucc", "markMMFaceBeautyAlgoUse", "markMiniWindowsPercent", "markNoFaceBeautyAlgoUse", "markRemovePreviewCallback", "markRenderAvgCost", "markRenderModeChangeAuto", "markRenderModeChangeManual", "markRendererUseSurfaceView", "markRendererUseTextureView", "markSoftEncodeAvgCost", "markSoftRgb2YuvAvgCost", "markTexture2BytearrayAvgCost", "markVoipRendererUseNew", "markYTFaceBeautyAlgoUse", "markYuvRendererPerFrameFullScreenCost", "markYuvRendererPerFrameMiniWindowCost", "plugin-voip_release"})
public final class j {
    public static final j Hhp = new j();

    static {
        AppMethodBeat.i(236142);
        AppMethodBeat.o(236142);
    }

    private j() {
    }

    public static void fKr() {
        AppMethodBeat.i(236101);
        Log.i("MicroMsg.VoipReportHelper", "markVoipRendererUseNew");
        h.INSTANCE.n(1304, 1, 1);
        AppMethodBeat.o(236101);
    }

    public static void fKs() {
        AppMethodBeat.i(236102);
        Log.i("MicroMsg.VoipReportHelper", "markCameraOnError");
        h.INSTANCE.n(1304, 2, 1);
        AppMethodBeat.o(236102);
    }

    public static void fKt() {
        AppMethodBeat.i(236103);
        Log.i("MicroMsg.VoipReportHelper", "markInitCameraRendererSucc");
        h.INSTANCE.n(1304, 3, 1);
        AppMethodBeat.o(236103);
    }

    public static void fKu() {
        AppMethodBeat.i(236104);
        Log.i("MicroMsg.VoipReportHelper", "markInitServiceRendererSucc");
        h.INSTANCE.n(1304, 4, 1);
        AppMethodBeat.o(236104);
    }

    public static void LE(long j2) {
        AppMethodBeat.i(236105);
        Log.i("MicroMsg.VoipReportHelper", "markInitServiceRendererSucc,width=".concat(String.valueOf(j2)));
        h.INSTANCE.n(1304, 5, j2);
        AppMethodBeat.o(236105);
    }

    public static void LF(long j2) {
        AppMethodBeat.i(236106);
        Log.i("MicroMsg.VoipReportHelper", "markInitServiceRendererSucc,height=".concat(String.valueOf(j2)));
        h.INSTANCE.n(1304, 6, j2);
        AppMethodBeat.o(236106);
    }

    public static void fKv() {
        AppMethodBeat.i(236107);
        Log.i("MicroMsg.VoipReportHelper", "markRendererUseSurfaceView");
        h.INSTANCE.n(1304, 7, 1);
        AppMethodBeat.o(236107);
    }

    public static void fKw() {
        AppMethodBeat.i(236108);
        Log.i("MicroMsg.VoipReportHelper", "markRendererUseTextureView");
        h.INSTANCE.n(1304, 8, 1);
        AppMethodBeat.o(236108);
    }

    public static void fKx() {
        AppMethodBeat.i(236109);
        Log.i("MicroMsg.VoipReportHelper", "markRenderModeChangeAuto");
        h.INSTANCE.n(1304, 9, 1);
        AppMethodBeat.o(236109);
    }

    public static void fKy() {
        AppMethodBeat.i(236110);
        Log.i("MicroMsg.VoipReportHelper", "markRenderModeChangeManual");
        h.INSTANCE.n(1304, 10, 1);
        AppMethodBeat.o(236110);
    }

    public static void Lm(long j2) {
        AppMethodBeat.i(236111);
        Log.i("MicroMsg.VoipReportHelper", "markDecodeModeChangeToHW,count=".concat(String.valueOf(j2)));
        h.INSTANCE.b(1304, 11, 50, (int) j2, false);
        AppMethodBeat.o(236111);
    }

    public static void Ln(long j2) {
        AppMethodBeat.i(236112);
        Log.i("MicroMsg.VoipReportHelper", "markDecodeModeChangeToSW,count=".concat(String.valueOf(j2)));
        h.INSTANCE.b(1304, 12, 51, (int) j2, false);
        AppMethodBeat.o(236112);
    }

    public static void LG(long j2) {
        AppMethodBeat.i(236113);
        Log.i("MicroMsg.VoipReportHelper", "markFullScreenPercent,percent=".concat(String.valueOf(j2)));
        h.INSTANCE.b(1304, 13, 70, (int) j2, false);
        AppMethodBeat.o(236113);
    }

    public static void LH(long j2) {
        AppMethodBeat.i(236114);
        Log.i("MicroMsg.VoipReportHelper", "markMiniWindowsPercent,percent=".concat(String.valueOf(j2)));
        h.INSTANCE.b(1304, 14, 71, (int) j2, false);
        AppMethodBeat.o(236114);
    }

    public static void fKz() {
        AppMethodBeat.i(236115);
        Log.i("MicroMsg.VoipReportHelper", "markNoFaceBeautyAlgoUse");
        h.INSTANCE.n(1304, 15, 1);
        AppMethodBeat.o(236115);
    }

    public static void fKA() {
        AppMethodBeat.i(236116);
        Log.i("MicroMsg.VoipReportHelper", "markYTFaceBeautyAlgoUse");
        h.INSTANCE.n(1304, 16, 1);
        AppMethodBeat.o(236116);
    }

    public static void fKB() {
        AppMethodBeat.i(236117);
        Log.i("MicroMsg.VoipReportHelper", "markMMFaceBeautyAlgoUse");
        h.INSTANCE.n(1304, 17, 1);
        AppMethodBeat.o(236117);
    }

    public static void fKC() {
        AppMethodBeat.i(236118);
        Log.i("MicroMsg.VoipReportHelper", "markFaceBeautySendDataNull");
        h.INSTANCE.n(1304, 18, 1);
        AppMethodBeat.o(236118);
    }

    public static void fKD() {
        AppMethodBeat.i(236119);
        Log.i("MicroMsg.VoipReportHelper", "markFaceBeautySendDataIlleagel");
        h.INSTANCE.n(1304, 19, 1);
        AppMethodBeat.o(236119);
    }

    public static void Lo(long j2) {
        AppMethodBeat.i(236120);
        Log.i("MicroMsg.VoipReportHelper", "markBatteryPropertyCurrentInHW,data=".concat(String.valueOf(j2)));
        h.INSTANCE.b(1304, 20, 38, (int) j2, false);
        AppMethodBeat.o(236120);
    }

    public static void Lp(long j2) {
        AppMethodBeat.i(236121);
        Log.i("MicroMsg.VoipReportHelper", "markBatteryPropertyCurrentInSW, data=".concat(String.valueOf(j2)));
        h.INSTANCE.b(1304, 21, 39, (int) j2, false);
        AppMethodBeat.o(236121);
    }

    public static void Lq(long j2) {
        AppMethodBeat.i(236122);
        Log.i("MicroMsg.VoipReportHelper", "markAddViewFullScreenToRendererCost, data=".concat(String.valueOf(j2)));
        h.INSTANCE.b(1304, 24, 22, (int) j2, false);
        AppMethodBeat.o(236122);
    }

    public static void Lr(long j2) {
        AppMethodBeat.i(236123);
        Log.i("MicroMsg.VoipReportHelper", "markAddViewMiniWindowToRendererCost, data=".concat(String.valueOf(j2)));
        h.INSTANCE.b(1304, 25, 23, (int) j2, false);
        AppMethodBeat.o(236123);
    }

    public static void Ls(long j2) {
        AppMethodBeat.i(236124);
        Log.i("MicroMsg.VoipReportHelper", "markYuvRendererPerFrameFullScreenCost,cost=".concat(String.valueOf(j2)));
        h.INSTANCE.b(1304, 28, 26, (int) j2, false);
        AppMethodBeat.o(236124);
    }

    public static void Lt(long j2) {
        AppMethodBeat.i(236125);
        Log.i("MicroMsg.VoipReportHelper", "markYuvRendererPerFrameMiniWindowCost,cost=".concat(String.valueOf(j2)));
        h.INSTANCE.b(1304, 29, 27, (int) j2, false);
        AppMethodBeat.o(236125);
    }

    public static void Lu(long j2) {
        AppMethodBeat.i(236126);
        Log.i("MicroMsg.VoipReportHelper", "markHWRendererPerFrameFullScreenCost,cost=".concat(String.valueOf(j2)));
        h.INSTANCE.b(1304, 32, 30, (int) j2, false);
        AppMethodBeat.o(236126);
    }

    public static void Lv(long j2) {
        AppMethodBeat.i(236127);
        Log.i("MicroMsg.VoipReportHelper", "markHWRendererPerFrameMiniWindowCost,cost=".concat(String.valueOf(j2)));
        h.INSTANCE.b(1304, 33, 31, (int) j2, false);
        AppMethodBeat.o(236127);
    }

    public static void LI(long j2) {
        AppMethodBeat.i(236128);
        Log.i("MicroMsg.VoipReportHelper", "markCameraRendererPerFrameNewFullScreenCost,cost=".concat(String.valueOf(j2)));
        h.INSTANCE.b(1304, 36, 34, (int) j2, false);
        AppMethodBeat.o(236128);
    }

    public static void LJ(long j2) {
        AppMethodBeat.i(236129);
        Log.i("MicroMsg.VoipReportHelper", "markCameraRendererPerFrameNewMiniWindowCost,cost=".concat(String.valueOf(j2)));
        h.INSTANCE.b(1304, 37, 35, (int) j2, false);
        AppMethodBeat.o(236129);
    }

    public static void LK(long j2) {
        AppMethodBeat.i(236130);
        Log.i("MicroMsg.VoipReportHelper", "markCameraRendererPerFrameNewFullScreenCostWithFaceBeauty,cost=".concat(String.valueOf(j2)));
        h.INSTANCE.b(1304, 72, 74, (int) j2, false);
        AppMethodBeat.o(236130);
    }

    public static void LL(long j2) {
        AppMethodBeat.i(236131);
        Log.i("MicroMsg.VoipReportHelper", "markCameraRendererPerFrameNewMiniWindowCostWithFaceBeauty,cost=".concat(String.valueOf(j2)));
        h.INSTANCE.b(1304, 73, 75, (int) j2, false);
        AppMethodBeat.o(236131);
    }

    public static void LA(long j2) {
        AppMethodBeat.i(236132);
        Log.i("MicroMsg.VoipReportHelper", "markAddViewFullScreenToRendererCostInvite, data=".concat(String.valueOf(j2)));
        h.INSTANCE.b(1304, 42, 40, (int) j2, false);
        AppMethodBeat.o(236132);
    }

    public static void LB(long j2) {
        AppMethodBeat.i(236133);
        Log.i("MicroMsg.VoipReportHelper", "markAddViewMiniWindowToRendererCostInvite, data=".concat(String.valueOf(j2)));
        h.INSTANCE.b(1304, 43, 41, (int) j2, false);
        AppMethodBeat.o(236133);
    }

    public static void LC(long j2) {
        AppMethodBeat.i(236134);
        Log.i("MicroMsg.VoipReportHelper", "markAddViewFullScreenToRendererCostFirst, data=".concat(String.valueOf(j2)));
        h.INSTANCE.b(1304, 48, 52, (int) j2, false);
        AppMethodBeat.o(236134);
    }

    public static void LD(long j2) {
        AppMethodBeat.i(236135);
        Log.i("MicroMsg.VoipReportHelper", "markAddViewMiniWindowToRendererCostFirst, data=".concat(String.valueOf(j2)));
        h.INSTANCE.b(1304, 49, 53, (int) j2, false);
        AppMethodBeat.o(236135);
    }

    public static void LM(long j2) {
        AppMethodBeat.i(236136);
        g gVar = g.HgZ;
        if (!g.fKi()) {
            Log.i("MicroMsg.VoipReportHelper", "markSoftRgb2YuvAvgCost, cpu trans cost=".concat(String.valueOf(j2)));
            h.INSTANCE.b(1304, 78, 79, (int) j2, false);
            AppMethodBeat.o(236136);
            return;
        }
        Log.i("MicroMsg.VoipReportHelper", "markSoftRgb2YuvAvgCost, gpu trans cost=".concat(String.valueOf(j2)));
        h.INSTANCE.b(1304, 81, 82, (int) j2, false);
        AppMethodBeat.o(236136);
    }

    public static void LN(long j2) {
        AppMethodBeat.i(236137);
        g gVar = g.HgZ;
        if (g.fKj()) {
            Log.i("MicroMsg.VoipReportHelper", "markSoftEncodeAvgCost, gpu crop trans cost=".concat(String.valueOf(j2)));
            h.INSTANCE.b(1304, 111, 112, (int) j2, false);
            AppMethodBeat.o(236137);
            return;
        }
        g gVar2 = g.HgZ;
        if (!g.fKi()) {
            Log.i("MicroMsg.VoipReportHelper", "markSoftEncodeAvgCost, cpu trans cost=".concat(String.valueOf(j2)));
            h.INSTANCE.b(1304, 84, 85, (int) j2, false);
            AppMethodBeat.o(236137);
            return;
        }
        Log.i("MicroMsg.VoipReportHelper", "markSoftEncodeAvgCost, gpu trans cost=".concat(String.valueOf(j2)));
        h.INSTANCE.b(1304, 87, 88, (int) j2, false);
        AppMethodBeat.o(236137);
    }

    public static void LO(long j2) {
        AppMethodBeat.i(236138);
        g gVar = g.HgZ;
        if (g.fKj()) {
            Log.i("MicroMsg.VoipReportHelper", "markHWEncodeAvgCost, gpu crop trans cost=".concat(String.valueOf(j2)));
            h.INSTANCE.b(1304, 108, 109, (int) j2, false);
            AppMethodBeat.o(236138);
            return;
        }
        g gVar2 = g.HgZ;
        if (!g.fKi()) {
            Log.i("MicroMsg.VoipReportHelper", "markHWEncodeAvgCost, cpu trans cost=".concat(String.valueOf(j2)));
            h.INSTANCE.b(1304, 90, 91, (int) j2, false);
            AppMethodBeat.o(236138);
            return;
        }
        Log.i("MicroMsg.VoipReportHelper", "markHWEncodeAvgCost, gpu trans cost=".concat(String.valueOf(j2)));
        h.INSTANCE.b(1304, 93, 94, (int) j2, false);
        AppMethodBeat.o(236138);
    }

    public static void LP(long j2) {
        AppMethodBeat.i(236139);
        g gVar = g.HgZ;
        if (!g.fKi()) {
            Log.i("MicroMsg.VoipReportHelper", "markRenderAvgCost, cpu trans cost=".concat(String.valueOf(j2)));
            h.INSTANCE.b(1304, 96, 97, (int) j2, false);
            AppMethodBeat.o(236139);
            return;
        }
        Log.i("MicroMsg.VoipReportHelper", "markRenderAvgCost, gpu trans cost=".concat(String.valueOf(j2)));
        h.INSTANCE.b(1304, 99, 100, (int) j2, false);
        AppMethodBeat.o(236139);
    }

    public static void LQ(long j2) {
        AppMethodBeat.i(236140);
        g gVar = g.HgZ;
        if (!g.fKi()) {
            Log.i("MicroMsg.VoipReportHelper", "markTexture2BytearrayAvgCost, cpu trans cost=".concat(String.valueOf(j2)));
            h.INSTANCE.b(1304, 102, 103, (int) j2, false);
            AppMethodBeat.o(236140);
            return;
        }
        Log.i("MicroMsg.VoipReportHelper", "markTexture2BytearrayAvgCost, gpu trans cost=".concat(String.valueOf(j2)));
        h.INSTANCE.b(1304, 105, 106, (int) j2, false);
        AppMethodBeat.o(236140);
    }

    public static final void fKE() {
        AppMethodBeat.i(236141);
        Log.i("MicroMsg.VoipReportHelper", "markRemovePreviewCallback");
        h.INSTANCE.n(1304, 114, 1);
        AppMethodBeat.o(236141);
    }
}
