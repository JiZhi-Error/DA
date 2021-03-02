package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.bb;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.upload.action.f;
import com.tencent.mm.plugin.finder.upload.action.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;

public final class ag {
    public static final ag uOs = new ag();

    static {
        AppMethodBeat.i(166392);
        AppMethodBeat.o(166392);
    }

    private ag() {
    }

    public static bb a(bbn bbn, String str, int i2) {
        AppMethodBeat.i(248755);
        p.h(bbn, "contextObj");
        p.h(str, "finderUser");
        Log.i("Finder.FinderFollowLogic", "follow event commentScene:" + bbn.tyh + " user:" + str + " opType: " + i2 + " form " + Util.getStack());
        e eVar = e.INSTANCE;
        bb.a aVar = bb.tve;
        eVar.idkeyStat(1278, i2 == bb.tvc ? 5 : 4, 1, false);
        k kVar = k.vfA;
        long j2 = bbn.wyW;
        bb.a aVar2 = bb.tve;
        k.a(bbn, j2, str, i2 == bb.tvc ? 1 : 2);
        bb bbVar = new bb(str, i2, bbn, bbn.wyW);
        AppMethodBeat.o(248755);
        return bbVar;
    }

    public static /* synthetic */ void b(bbn bbn, String str, int i2) {
        AppMethodBeat.i(248757);
        a(bbn, str, i2, false);
        AppMethodBeat.o(248757);
    }

    public static void a(bbn bbn, String str, int i2, boolean z) {
        AppMethodBeat.i(248756);
        p.h(bbn, "contextObj");
        p.h(str, "finderUser");
        Log.i("Finder.FinderFollowLogic", "follow event commentScene:" + bbn.tyh + " user:" + str + " opType: " + i2 + " form " + Util.getStack());
        e eVar = e.INSTANCE;
        bb.a aVar = bb.tve;
        eVar.idkeyStat(1278, i2 == bb.tvc ? 5 : 4, 1, false);
        k kVar = k.vfA;
        long j2 = bbn.wyW;
        bb.a aVar2 = bb.tve;
        k.a(bbn, j2, str, i2 == bb.tvc ? 1 : 2);
        g.a aVar3 = g.vUn;
        g gVar = g.vUm;
        long j3 = bbn.wyW;
        p.h(str, "finderUser");
        p.h(bbn, "contextObj");
        Log.i(g.TAG, "doFollow " + str + ' ' + i2 + ", feedId = " + j3);
        f fVar = new f(str, i2, j3, bbn, z);
        gVar.vTX.put(str, fVar);
        gVar.a((com.tencent.mm.plugin.finder.upload.action.e) fVar);
        AppMethodBeat.o(248756);
    }
}
