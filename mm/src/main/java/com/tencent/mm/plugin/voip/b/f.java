package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\bJ\u000e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/voip/util/VoipPrevReportHelper;", "", "()V", "ID", "", "TAG", "", "markAddViewFullScreenToRendererCost", "", "data", "markAddViewFullScreenToRendererCostFirst", "markAddViewFullScreenToRendererCostInvite", "markAddViewMiniWindowToRendererCost", "markAddViewMiniWindowToRendererCostFirst", "markAddViewMiniWindowToRendererCostInvite", "markBatteryPropertyCurrentInHW", "markBatteryPropertyCurrentInSW", "markCameraRendererPerFrameMiniWindowCostWithFaceBeauty", "cost", "markCameraRendererPerFramePrevFullScreenCost", "markCameraRendererPerFramePrevFullScreenCostWithFaceBeauty", "markCameraRendererPerFramePrevMiniWindowCost", "markDecodeModeChangeToHW", "count", "markDecodeModeChangeToSW", "markHWRendererPerFrameFullScreenCost", "markHWRendererPerFrameMiniWindowCost", "markVoipRendererUsePrev", "markYuvRendererPerFrameFullScreenCost", "markYuvRendererPerFrameMiniWindowCost", "plugin-voip_release"})
public final class f {
    public static final f HgY = new f();
    private static final String TAG = TAG;
    private static final long oIi = oIi;

    static {
        AppMethodBeat.i(236069);
        AppMethodBeat.o(236069);
    }

    private f() {
    }

    public static void fKd() {
        AppMethodBeat.i(236050);
        Log.i(TAG, "markVoipRendererUsePrev");
        h.INSTANCE.n(oIi, 0, 1);
        AppMethodBeat.o(236050);
    }

    public static void Lm(long j2) {
        AppMethodBeat.i(236051);
        Log.i(TAG, "markDecodeModeChangeToHW,count=".concat(String.valueOf(j2)));
        h.INSTANCE.b((int) oIi, 1, 41, (int) j2, false);
        AppMethodBeat.o(236051);
    }

    public static void Ln(long j2) {
        AppMethodBeat.i(236052);
        Log.i(TAG, "markDecodeModeChangeToSW,count=".concat(String.valueOf(j2)));
        h.INSTANCE.b((int) oIi, 2, 42, (int) j2, false);
        AppMethodBeat.o(236052);
    }

    public static void Lo(long j2) {
        AppMethodBeat.i(236053);
        Log.i(TAG, "markBatteryPropertyCurrentInHW,data=".concat(String.valueOf(j2)));
        h.INSTANCE.b((int) oIi, 3, 21, (int) j2, false);
        AppMethodBeat.o(236053);
    }

    public static void Lp(long j2) {
        AppMethodBeat.i(236054);
        Log.i(TAG, "markBatteryPropertyCurrentInSW, data=".concat(String.valueOf(j2)));
        h.INSTANCE.b((int) oIi, 4, 22, (int) j2, false);
        AppMethodBeat.o(236054);
    }

    public static void Lq(long j2) {
        AppMethodBeat.i(236055);
        Log.i(TAG, "markAddViewFullScreenToRendererCost, data=".concat(String.valueOf(j2)));
        h.INSTANCE.b((int) oIi, 7, 5, (int) j2, false);
        AppMethodBeat.o(236055);
    }

    public static void Lr(long j2) {
        AppMethodBeat.i(236056);
        Log.i(TAG, "markAddViewMiniWindowToRendererCost, data=".concat(String.valueOf(j2)));
        h.INSTANCE.b((int) oIi, 8, 6, (int) j2, false);
        AppMethodBeat.o(236056);
    }

    public static void Ls(long j2) {
        AppMethodBeat.i(236057);
        Log.i(TAG, "markYuvRendererPerFrameFullScreenCost,cost=".concat(String.valueOf(j2)));
        h.INSTANCE.b((int) oIi, 11, 9, (int) j2, false);
        AppMethodBeat.o(236057);
    }

    public static void Lt(long j2) {
        AppMethodBeat.i(236058);
        Log.i(TAG, "markYuvRendererPerFrameMiniWindowCost,cost=".concat(String.valueOf(j2)));
        h.INSTANCE.b((int) oIi, 12, 10, (int) j2, false);
        AppMethodBeat.o(236058);
    }

    public static void Lu(long j2) {
        AppMethodBeat.i(236059);
        Log.i(TAG, "markHWRendererPerFrameFullScreenCost,cost=".concat(String.valueOf(j2)));
        h.INSTANCE.b((int) oIi, 15, 13, (int) j2, false);
        AppMethodBeat.o(236059);
    }

    public static void Lv(long j2) {
        AppMethodBeat.i(236060);
        Log.i(TAG, "markHWRendererPerFrameMiniWindowCost,cost=".concat(String.valueOf(j2)));
        h.INSTANCE.b((int) oIi, 16, 14, (int) j2, false);
        AppMethodBeat.o(236060);
    }

    public static void Lw(long j2) {
        AppMethodBeat.i(236061);
        Log.i(TAG, "markCameraRendererPerFrameNewFullScreenCost,cost=".concat(String.valueOf(j2)));
        h.INSTANCE.b((int) oIi, 19, 17, (int) j2, false);
        AppMethodBeat.o(236061);
    }

    public static void Lx(long j2) {
        AppMethodBeat.i(236062);
        Log.i(TAG, "markCameraRendererPerFrameNewMiniWindowCost,cost=".concat(String.valueOf(j2)));
        h.INSTANCE.b((int) oIi, 20, 18, (int) j2, false);
        AppMethodBeat.o(236062);
    }

    public static void Ly(long j2) {
        AppMethodBeat.i(236063);
        Log.i(TAG, "markHWRendererPerFrameMiniWindowCostWithFaceBeauty,cost=".concat(String.valueOf(j2)));
        h.INSTANCE.b((int) oIi, 49, 51, (int) j2, false);
        AppMethodBeat.o(236063);
    }

    public static void Lz(long j2) {
        AppMethodBeat.i(236064);
        Log.i(TAG, "markCameraRendererPerFramePrevFullScreenCostWithFaceBeauty,cost=".concat(String.valueOf(j2)));
        h.INSTANCE.b((int) oIi, 50, 52, (int) j2, false);
        AppMethodBeat.o(236064);
    }

    public static void LA(long j2) {
        AppMethodBeat.i(236065);
        Log.i(TAG, "markAddViewFullScreenToRendererCostInvite, data=".concat(String.valueOf(j2)));
        h.INSTANCE.b((int) oIi, 35, 33, (int) j2, false);
        AppMethodBeat.o(236065);
    }

    public static void LB(long j2) {
        AppMethodBeat.i(236066);
        Log.i(TAG, "markAddViewMiniWindowToRendererCostInvite, data=".concat(String.valueOf(j2)));
        h.INSTANCE.b((int) oIi, 36, 34, (int) j2, false);
        AppMethodBeat.o(236066);
    }

    public static void LC(long j2) {
        AppMethodBeat.i(236067);
        Log.i(TAG, "markAddViewFullScreenToRendererCostFirst, data=".concat(String.valueOf(j2)));
        h.INSTANCE.b((int) oIi, 39, 43, (int) j2, false);
        AppMethodBeat.o(236067);
    }

    public static void LD(long j2) {
        AppMethodBeat.i(236068);
        Log.i(TAG, "markAddViewMiniWindowToRendererCostFirst, data=".concat(String.valueOf(j2)));
        h.INSTANCE.b((int) oIi, 40, 44, (int) j2, false);
        AppMethodBeat.o(236068);
    }
}
