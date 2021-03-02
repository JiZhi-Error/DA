package com.tencent.mm.plugin.festival.model.a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.b.a.og;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fJ\b\u0010\u0012\u001a\u00020\rH\u0002J\u0006\u0010\u0013\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u000fJ\u0006\u0010\u0015\u001a\u00020\u000fJ\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u000fH\u0002J\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\rJ\u0006\u0010\u001c\u001a\u00020\u000fJ\u0006\u0010\u001d\u001a\u00020\u000fJ\u0006\u0010\u001e\u001a\u00020\u000fJ\u0006\u0010\u001f\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/festival/model/report/FestivalPostReporter;", "", "()V", "commExpo", "", "isDonate", "label", "Ljava/lang/StringBuilder;", "openRules", "pos", "Landroid/graphics/Point;", "setStatusAct", "wishSessionId", "", "cancelSetStatus", "", "clickFuBug", "enterStarrySky", "genWishSessionId", "notShowSetStatus", "openActRules", "postWish", "reportAct", "actType", "reset", "selectPosInStarrySky", "selectTopics", "topics", "setStatus", "showDonation", "showTopicPanel", "startPostWish", "plugin-festival_release"})
public final class e {
    public static String UAh;
    public static Point UAi;
    private static final StringBuilder UAj = new StringBuilder();
    private static int UAk = 2;
    private static int UAl = 2;
    private static int UAm = 2;
    private static int UAn = 2;
    public static final e UAo = new e();

    static {
        AppMethodBeat.i(263182);
        AppMethodBeat.o(263182);
    }

    private e() {
    }

    public static void gUu() {
        AppMethodBeat.i(263176);
        UAl = 1;
        awH(5);
        AppMethodBeat.o(263176);
    }

    public static void hRZ() {
        UAl = 3;
    }

    public static void hSa() {
        UAl = 2;
    }

    public static void bxx(String str) {
        AppMethodBeat.i(263177);
        p.h(str, "topics");
        UAj.append(str).append(";");
        AppMethodBeat.o(263177);
    }

    public static void hSb() {
        UAk = 1;
    }

    public static void hSc() {
        UAm = 1;
    }

    public static void hSd() {
        UAn = 1;
    }

    public static void awH(int i2) {
        og ogVar;
        String str;
        String str2;
        AppMethodBeat.i(263178);
        og ogVar2 = new og();
        ogVar2.PG(Util.nowSecond());
        b bVar = b.UzX;
        ogVar2.VN(b.hRV());
        ogVar2.VO(UAh);
        ogVar2.abw(i2);
        Point point = UAi;
        if (point == null || ("(" + point.x + '|' + point.y + ')') == null) {
            str = "";
            ogVar = ogVar2;
        } else {
            str = str2;
            ogVar = ogVar2;
        }
        ogVar.VP(str);
        ogVar2.VS(q.encode(Util.nullAsNil(UAj.toString())));
        ogVar2.abA(UAk);
        ogVar2.abB(UAl);
        ogVar2.abC(UAm);
        ogVar2.abD(UAn);
        ogVar2.bfK();
        AppMethodBeat.o(263178);
    }

    public static String hSe() {
        AppMethodBeat.i(263179);
        StringBuilder sb = new StringBuilder("wish_");
        p.g(g.aAf(), "MMKernel.account()");
        String mD5String = MD5Util.getMD5String(sb.append(a.ayV()).append('_').append(System.currentTimeMillis()).toString());
        p.g(mD5String, "MD5Util.getMD5String(\"wi…em.currentTimeMillis()}\")");
        AppMethodBeat.o(263179);
        return mD5String;
    }

    public static void reset() {
        AppMethodBeat.i(263180);
        UAh = null;
        UAi = null;
        n.h(UAj);
        UAk = 2;
        UAl = 2;
        UAm = 2;
        UAn = 2;
        AppMethodBeat.o(263180);
    }

    public static void hSf() {
        AppMethodBeat.i(263181);
        og ogVar = new og();
        ogVar.PG(Util.nowSecond());
        b bVar = b.UzX;
        ogVar.VN(b.hRV());
        ogVar.abw(6);
        ogVar.bfK();
        AppMethodBeat.o(263181);
    }
}
