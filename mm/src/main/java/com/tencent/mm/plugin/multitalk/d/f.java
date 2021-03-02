package com.tencent.mm.plugin.multitalk.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\bJ\u0006\u0010\u0011\u001a\u00020\bJ\u0006\u0010\u0012\u001a\u00020\bJ\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\bJZ\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u001bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/multitalk/utils/ScreenProjectReportHelper;", "", "()V", "ID", "", "TAG", "", "markClickBlackBoard", "", "markClickDoodle", "markClickFileScreenProject", "markClickIconFlipPage", "markClickMute", "markClickScreenHide", "markClickSpeakerOn", "markClickStopProject", "markClickThumb", "markClickThumbFlipPage", "markExitDuringProfileUI", "markExitProject", "markScrollFlipPage", "markStartProjectDuringProfileUI", "reportScreenProjectDone", "fileExt", "fileSize", DownloadInfo.FILENAME, "totalPages", "", "cost", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "avgTransCost", "avgDoodleTransCost", "avgXWebTransCost", "avgFps", "plugin-multitalk_release"})
public final class f {
    private static final long oIi = oIi;
    public static final f zZd = new f();

    static {
        AppMethodBeat.i(240122);
        AppMethodBeat.o(240122);
    }

    private f() {
    }

    public static void a(String str, long j2, String str2, int i2, long j3, int i3, long j4, long j5, long j6, int i4) {
        AppMethodBeat.i(240108);
        Log.i("MicroMsg.ScreenProjectReportHelper", "reportScreenProjectDone,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", str, Long.valueOf(j2), str2, Integer.valueOf(i2), Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Integer.valueOf(i4));
        h.INSTANCE.a(21350, str, Long.valueOf(j2), str2, Integer.valueOf(i2), Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Integer.valueOf(i4));
        AppMethodBeat.o(240108);
    }

    public static void eqj() {
        AppMethodBeat.i(240109);
        Log.i("MicroMsg.ScreenProjectReportHelper", "markClickFileScreenProject");
        h.INSTANCE.n(oIi, 0, 1);
        AppMethodBeat.o(240109);
    }

    public static void eqk() {
        AppMethodBeat.i(240110);
        Log.i("MicroMsg.ScreenProjectReportHelper", "markClickBlackBoard");
        h.INSTANCE.n(oIi, 1, 1);
        AppMethodBeat.o(240110);
    }

    public static void eql() {
        AppMethodBeat.i(240111);
        Log.i("MicroMsg.ScreenProjectReportHelper", "markExitDuringProfileUI");
        h.INSTANCE.n(oIi, 2, 1);
        AppMethodBeat.o(240111);
    }

    public static void eqm() {
        AppMethodBeat.i(240112);
        Log.i("MicroMsg.ScreenProjectReportHelper", "markStartProjectDuringProfileUI");
        h.INSTANCE.n(oIi, 3, 1);
        AppMethodBeat.o(240112);
    }

    public static void eqn() {
        AppMethodBeat.i(240113);
        Log.i("MicroMsg.ScreenProjectReportHelper", "markExitProject");
        h.INSTANCE.n(oIi, 4, 1);
        AppMethodBeat.o(240113);
    }

    public static void eqo() {
        AppMethodBeat.i(240114);
        Log.i("MicroMsg.ScreenProjectReportHelper", "markClickStopProject");
        h.INSTANCE.n(oIi, 5, 1);
        AppMethodBeat.o(240114);
    }

    public static void eqp() {
        AppMethodBeat.i(240115);
        Log.i("MicroMsg.ScreenProjectReportHelper", "markClickDoodle");
        h.INSTANCE.n(oIi, 6, 1);
        AppMethodBeat.o(240115);
    }

    public static void eqq() {
        AppMethodBeat.i(240116);
        Log.i("MicroMsg.ScreenProjectReportHelper", "markClickMute");
        h.INSTANCE.n(oIi, 7, 1);
        AppMethodBeat.o(240116);
    }

    public static void eqr() {
        AppMethodBeat.i(240117);
        Log.i("MicroMsg.ScreenProjectReportHelper", "markClickSpeakerOn");
        h.INSTANCE.n(oIi, 8, 1);
        AppMethodBeat.o(240117);
    }

    public static void eqs() {
        AppMethodBeat.i(240118);
        Log.i("MicroMsg.ScreenProjectReportHelper", "markClickThumb");
        h.INSTANCE.n(oIi, 10, 1);
        AppMethodBeat.o(240118);
    }

    public static void eqt() {
        AppMethodBeat.i(240119);
        Log.i("MicroMsg.ScreenProjectReportHelper", "markClickThumbFlipPage");
        h.INSTANCE.n(oIi, 11, 1);
        AppMethodBeat.o(240119);
    }

    public static void equ() {
        AppMethodBeat.i(240120);
        Log.i("MicroMsg.ScreenProjectReportHelper", "markScrollFlipPage");
        h.INSTANCE.n(oIi, 12, 1);
        AppMethodBeat.o(240120);
    }

    public static void eqv() {
        AppMethodBeat.i(240121);
        Log.i("MicroMsg.ScreenProjectReportHelper", "markClickIconFlipPage");
        h.INSTANCE.n(oIi, 13, 1);
        AppMethodBeat.o(240121);
    }
}
