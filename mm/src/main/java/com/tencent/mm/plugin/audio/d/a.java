package com.tencent.mm.plugin.audio.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\bJM\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/audio/util/AudioReportUtil;", "", "()V", "ID", "", "TAG", "", "markErrorSco", "", "caller", "markIPCallUseScoError", "markMultitalkUseScoError", "markMusicUseScoError", "markOpenVoiceUseScoError", "markSenceRecordUseScoError", "markVoipCSUseScoError", "markVoipUseScoError", "reportAudioStatus", "deviceType", "", "majorClass", "deviceClass", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "deviceName", "deviceAddress", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "plugin-audio_release"})
public final class a {
    private static final long oIi = oIi;
    public static final a oIj = new a();

    static {
        AppMethodBeat.i(224011);
        AppMethodBeat.o(224011);
    }

    private a() {
    }

    public static void a(Integer num, Integer num2, String str, int i2, String str2, String str3) {
        AppMethodBeat.i(224003);
        p.h(str, "caller");
        Log.i("MicroMsg.AudioReportUtil", "report audio device bt status \n deviceType: 4 " + "\n majorClass:" + num + "\n deviceClass:" + num2 + "\n caller:" + str + "\n errorCode:" + i2 + "\n deviceName:" + str2 + "\n deviceAddress:" + str3);
        h.INSTANCE.a(21246, true, true, 4, num, num2, str, Integer.valueOf(i2), str2, str3);
        AppMethodBeat.o(224003);
    }

    public static void cel() {
        AppMethodBeat.i(224004);
        Log.i("MicroMsg.AudioReportUtil", "markVoipUseScoError");
        h.INSTANCE.n(oIi, 0, 1);
        AppMethodBeat.o(224004);
    }

    public static void cem() {
        AppMethodBeat.i(224005);
        Log.i("MicroMsg.AudioReportUtil", "markSenceRecordUseScoError");
        h.INSTANCE.n(oIi, 1, 1);
        AppMethodBeat.o(224005);
    }

    public static void cen() {
        AppMethodBeat.i(224006);
        Log.i("MicroMsg.AudioReportUtil", "markMultitalkUseScoError");
        h.INSTANCE.n(oIi, 2, 1);
        AppMethodBeat.o(224006);
    }

    public static void ceo() {
        AppMethodBeat.i(224007);
        Log.i("MicroMsg.AudioReportUtil", "markOpenVoiceUseScoError");
        h.INSTANCE.n(oIi, 3, 1);
        AppMethodBeat.o(224007);
    }

    public static void cep() {
        AppMethodBeat.i(224008);
        Log.i("MicroMsg.AudioReportUtil", "markIPCallUseScoError");
        h.INSTANCE.n(oIi, 4, 1);
        AppMethodBeat.o(224008);
    }

    public static void ceq() {
        AppMethodBeat.i(224009);
        Log.i("MicroMsg.AudioReportUtil", "markMusicUseScoError");
        h.INSTANCE.n(oIi, 5, 1);
        AppMethodBeat.o(224009);
    }

    public static void cer() {
        AppMethodBeat.i(224010);
        Log.i("MicroMsg.AudioReportUtil", "markVoipCSUseScoError");
        h.INSTANCE.n(oIi, 6, 1);
        AppMethodBeat.o(224010);
    }
}
