package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.net.Uri;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u00012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0004J\u0006\u00101\u001a\u00020/R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\b\"\u0004\b\u001b\u0010\nR\u001a\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\nR\u001a\u0010\u001f\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001a\u0010\"\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R\u001a\u0010%\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\b\"\u0004\b'\u0010\nR\u001c\u0010(\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR\u001a\u0010+\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0013\"\u0004\b-\u0010\u0015¨\u00063"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPVideoPreviewReport;", "", "()V", "TAG", "", "absolutePosition", "", "getAbsolutePosition", "()I", "setAbsolutePosition", "(I)V", "autoPlayId", "getAutoPlayId", "()Ljava/lang/String;", "setAutoPlayId", "(Ljava/lang/String;)V", "bizUin", "", "getBizUin", "()J", "setBizUin", "(J)V", "bufferDuration", "getBufferDuration", "setBufferDuration", "eventType", "getEventType", "setEventType", "idx", "getIdx", "setIdx", "msgId", "getMsgId", "setMsgId", "playDuration", "getPlayDuration", "setPlayDuration", "sessionId", "getSessionId", "setSessionId", "vid", "getVid", "setVid", "videoDuration", "getVideoDuration", "setVideoDuration", "buildUrl", "", "url", "report", "EVENT", "plugin-brandservice_release"})
public final class o {
    private static int dEb;
    private static int dRq;
    private static int idx;
    private static long msgId;
    private static String pJD = "";
    private static long pLO;
    private static int pLP;
    private static long pLQ;
    private static long pLR;
    public static final o pLS = new o();
    private static long playDuration;
    private static String vid = "";

    static {
        AppMethodBeat.i(195991);
        AppMethodBeat.o(195991);
    }

    private o() {
    }

    public static void setVid(String str) {
        vid = str;
    }

    public static void DT(int i2) {
        pLP = i2;
    }

    public static void DU(int i2) {
        dEb = i2;
    }

    public static void aiU(String str) {
        pJD = str;
    }

    public static void setEventType(int i2) {
        dRq = i2;
    }

    public static void BO(long j2) {
        playDuration = j2;
    }

    public static long crc() {
        return playDuration;
    }

    public static void BP(long j2) {
        pLQ = j2;
    }

    public static void BQ(long j2) {
        pLR = j2;
    }

    public static void aiV(String str) {
        AppMethodBeat.i(195989);
        pLO = 0;
        idx = 0;
        msgId = 0;
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(195989);
            return;
        }
        try {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("__biz");
            if (!Util.isNullOrNil(queryParameter)) {
                byte[] decode = Base64.decode(queryParameter, 0);
                p.g(decode, "byte");
                pLO = Util.getLong(new String(decode, d.UTF_8), 0);
            }
            idx = Util.getInt(parse.getQueryParameter("idx"), 0);
            msgId = Util.getLong(parse.getQueryParameter("mid"), 0);
            AppMethodBeat.o(195989);
        } catch (Exception e2) {
            AppMethodBeat.o(195989);
        }
    }

    public static void report() {
        int i2 = 2;
        AppMethodBeat.i(195990);
        if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
                i2 = 5;
            } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
                i2 = 4;
            } else if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
                i2 = 3;
            } else if (NetStatusUtil.is5G(MMApplicationContext.getContext())) {
                i2 = 6;
            } else if (h.isFreeSimCard()) {
                i2 = 1;
            }
        }
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
        hVar.kvStat(21001, pLO + "," + vid + "," + msgId + "," + idx + "," + pLP + "," + dEb + "," + pJD + "," + dRq + "," + playDuration + "," + pLQ + "," + pLR + "," + i2);
        AppMethodBeat.o(195990);
    }
}
