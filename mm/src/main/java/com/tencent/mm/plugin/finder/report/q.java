package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ea;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.storage.data.l;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001dJ\\\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\u001d2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001d2\b\b\u0002\u0010#\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FinderSnsPostReporter;", "", "()V", "SCENE_ENTRANCE_CLICK", "", "SCENE_ENTRANCE_EXPOSE", "SCENE_NO_ACCOUNT_EXIT", "SCENE_NO_ACCOUNT_OK", "SCENE_NO_POST_EXIT", "SCENE_NO_POST_OK", "SCENE_SELECT_EXIT", "SCENE_SELECT_FEED", "SCENE_SNS_POST_CANCEL", "SCENE_SNS_POST_SUCCESS", "reportSessionID", "", "getReportSessionID", "()Ljava/lang/String;", "setReportSessionID", "(Ljava/lang/String;)V", "report20747", "", "sessionID", "scene", "wording", "haveFinderAccount", "", "havePostFinder", "feedId", "", "shootEntranceEndType", "entranceExposeMaxTimes", "entranceExposedTimes", "snsId", "timeStamp", "exposeType", "plugin-finder_release"})
public final class q {
    private static String vgD;
    public static final q vgE = new q();

    static {
        AppMethodBeat.i(250755);
        AppMethodBeat.o(250755);
    }

    private q() {
    }

    public static String dot() {
        return vgD;
    }

    public static /* synthetic */ void a(String str, int i2, String str2, boolean z, boolean z2, long j2, int i3) {
        AppMethodBeat.i(250753);
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        if ((i3 & 8) != 0) {
            z = true;
        }
        if ((i3 & 16) != 0) {
            z2 = true;
        }
        if ((i3 & 32) != 0) {
            j2 = 0;
        }
        p.h(str, "sessionID");
        p.h(str2, "wording");
        ea eaVar = new ea();
        String str3 = vgD;
        if (str3 != null) {
            str = str3;
        }
        eaVar.qm(str);
        vgD = null;
        eaVar.lg((long) i2);
        eaVar.lh(cl.aWA());
        k kVar = k.vfA;
        eaVar.qo(k.Fg(j2));
        eaVar.lj(z ? 1 : 0);
        eaVar.lk(z2 ? 1 : 0);
        eaVar.qp(str2);
        eaVar.bfK();
        k kVar2 = k.vfA;
        k.a(eaVar);
        AppMethodBeat.o(250753);
    }

    public static void a(String str, int i2, String str2, int i3, int i4, int i5, long j2, long j3, long j4, int i6) {
        ea eaVar;
        long j5;
        AppMethodBeat.i(250754);
        p.h(str, "sessionID");
        p.h(str2, "wording");
        if (i2 == 2) {
            vgD = str;
        }
        ea eaVar2 = new ea();
        eaVar2.qm(str);
        eaVar2.lg((long) i2);
        eaVar2.lh(j4);
        eaVar2.li((long) i3);
        k kVar = k.vfA;
        eaVar2.qo(k.Fg(j3));
        k kVar2 = k.vfA;
        eaVar2.qn(k.Fg(j2));
        String aUg = z.aUg();
        eaVar2.ll((long) i4);
        eaVar2.lm((long) i5);
        eaVar2.lj(Util.isNullOrNil(aUg) ? 0 : 1);
        if (eaVar2.afk() == 1) {
            l.a aVar = com.tencent.mm.plugin.finder.storage.data.l.vGw;
            p.g(aUg, ch.COL_USERNAME);
            if (!aVar.dG(aUg, 1).isEmpty()) {
                j5 = 1;
                eaVar = eaVar2;
                eaVar.lk(j5);
                eaVar2.qp(str2);
                eaVar2.ln((long) i6);
                eaVar2.bfK();
                k kVar3 = k.vfA;
                k.a(eaVar2);
                AppMethodBeat.o(250754);
            }
        }
        eaVar = eaVar2;
        j5 = 0;
        eaVar.lk(j5);
        eaVar2.qp(str2);
        eaVar2.ln((long) i6);
        eaVar2.bfK();
        k kVar32 = k.vfA;
        k.a(eaVar2);
        AppMethodBeat.o(250754);
    }
}
