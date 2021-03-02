package com.tencent.mm.plugin.festival.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.od;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u000bH\u0002J\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u0017\u001a\u00020\u000eJ\u0006\u0010\u0018\u001a\u00020\u000eJ\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0006H\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0002J\u0006\u0010\u001c\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/report/FestivalLiveReporter;", "", "()V", "commentCnt", "", "exitType", "", "fromScene", "isSlide", "likeCnt", "sessionId", "", "wishCount", "addLikeCount", "", "count", "enterLive", "scene", "exitLive", "isToFloatBall", "", "genSessionId", "getCurrentSessionId", "incCommentCnt", "incWishCount", "reportAct", "type", "reset", "useFairyWand", "plugin-festival_release"})
public final class b {
    private static long UzT;
    private static long UzU;
    private static int UzV = 2;
    private static long UzW;
    public static final b UzX = new b();
    private static int fromScene = -1;
    public static int gmJ = -1;
    private static String sessionId;

    static {
        AppMethodBeat.i(263165);
        AppMethodBeat.o(263165);
    }

    private b() {
    }

    public static String hRV() {
        return sessionId;
    }

    public static void hRW() {
        UzT++;
    }

    public static void hRX() {
        UzV = 1;
    }

    public static void awG(int i2) {
        UzW += (long) i2;
    }

    public static void hRY() {
        UzU++;
    }

    public static void awH(int i2) {
        AppMethodBeat.i(263164);
        od odVar = new od();
        odVar.PA(Util.nowSecond());
        odVar.fL(sessionId);
        odVar.Jp(i2);
        odVar.Jr(fromScene);
        odVar.PB(UzT);
        odVar.PC(UzU);
        odVar.LV(UzV);
        odVar.PD(UzW);
        odVar.MQ(gmJ);
        odVar.bfK();
        AppMethodBeat.o(263164);
    }

    public static void awF(int i2) {
        AppMethodBeat.i(263163);
        sessionId = null;
        UzT = 0;
        fromScene = -1;
        UzU = 0;
        UzV = 2;
        UzW = 0;
        gmJ = -1;
        StringBuilder sb = new StringBuilder();
        p.g(g.aAf(), "account()");
        String mD5String = MD5Util.getMD5String(sb.append(a.ayV()).append('_').append(System.currentTimeMillis()).toString());
        p.g(mD5String, "MD5Util.getMD5String(\"${…em.currentTimeMillis()}\")");
        sessionId = mD5String;
        fromScene = i2;
        awH(1);
        AppMethodBeat.o(263163);
    }
}
