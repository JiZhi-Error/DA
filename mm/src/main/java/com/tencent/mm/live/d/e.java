package com.tencent.mm.live.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fe;
import com.tencent.mm.g.b.a.ff;
import com.tencent.mm.g.b.a.fg;
import com.tencent.mm.g.b.a.fh;
import com.tencent.mm.g.b.a.fi;
import com.tencent.mm.g.b.a.fj;
import com.tencent.mm.g.b.a.fk;
import com.tencent.mm.g.b.a.fl;
import com.tencent.mm.g.b.a.fm;
import com.tencent.mm.g.b.a.fo;
import com.tencent.mm.g.b.a.fp;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.core.core.trtc.a.a;
import com.tencent.mm.live.d.b;
import com.tencent.mm.model.z;
import kotlin.g.b.p;

public final class e {
    public static String hTN = "";
    private static fp hTO = new fp();
    public static final e hTP = new e();

    static {
        AppMethodBeat.i(208350);
        AppMethodBeat.o(208350);
    }

    private e() {
    }

    public static final void rj(int i2) {
        AppMethodBeat.i(208337);
        fj fjVar = new fj();
        b.a aVar = b.hTK;
        String aTY = z.aTY();
        p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
        fjVar.nM((long) b.a.ax(aTY, hTN));
        fjVar.sm(hTN);
        fjVar.aga();
        fjVar.nN((long) i2);
        fjVar.bfK();
        AppMethodBeat.o(208337);
    }

    public static /* synthetic */ void a(String str, boolean z, boolean z2, String str2, boolean z3, int i2, int i3) {
        AppMethodBeat.i(208339);
        a(str, z, z2, str2, z3, i2, i3, 0);
        AppMethodBeat.o(208339);
    }

    public static final void a(String str, boolean z, boolean z2, String str2, boolean z3, int i2, int i3, int i4) {
        int i5;
        AppMethodBeat.i(208338);
        p.h(str, "roomId");
        x xVar = x.hJf;
        if (x.aGK()) {
            AppMethodBeat.o(208338);
            return;
        }
        x xVar2 = x.hJf;
        x.eI(false);
        x xVar3 = x.hJf;
        x.eJ(false);
        x xVar4 = x.hJf;
        x.eK(true);
        x xVar5 = x.hJf;
        x.eL(false);
        x xVar6 = x.hJf;
        x.eH(false);
        fg fgVar = new fg();
        fgVar.afY();
        fgVar.se(str);
        fgVar.nu(z ? 1 : 0);
        fgVar.nv(z2 ? 1 : 0);
        fgVar.sf(str2);
        fgVar.nw(z3 ? 1 : 0);
        a aDC = a.aDC();
        p.g(aDC, "ConfigHelper.getInstance()");
        switch (aDC.aDG().hBp) {
            case 0:
                i5 = 2;
                break;
            case 1:
                i5 = 1;
                break;
            default:
                i5 = 0;
                break;
        }
        fgVar.nx((long) i5);
        fgVar.ny((long) i2);
        fgVar.nz((long) i3);
        fgVar.nA((long) i4);
        b.a aVar = b.hTK;
        String aTY = z.aTY();
        p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
        fgVar.nB((long) b.a.ax(aTY, str));
        b.a aVar2 = b.hTK;
        fgVar.nC((long) b.a.Hd(str));
        fgVar.bfK();
        AppMethodBeat.o(208338);
    }

    public static final void a(String str, long j2, String str2, int i2, int i3, int i4, int i5, int i6, boolean z, long j3) {
        AppMethodBeat.i(208340);
        p.h(str, "roomId");
        fe feVar = new fe();
        x xVar = x.hJf;
        x.qW(0);
        x xVar2 = x.hJf;
        x.qU(-1);
        feVar.afX();
        feVar.sb(str);
        feVar.ng(j2);
        feVar.sc(str2);
        feVar.ni((long) i2);
        feVar.nj(i3 <= 0 ? (long) i2 : (long) i3);
        feVar.nm((long) i6);
        feVar.nk((long) i4);
        feVar.nl((long) i5);
        feVar.nn(z ? 1 : 0);
        feVar.np(j3);
        b.a aVar = b.hTK;
        String aTY = z.aTY();
        p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
        feVar.nh((long) b.a.ax(aTY, str));
        b.a aVar2 = b.hTK;
        feVar.no((long) b.a.Hd(str));
        feVar.bfK();
        AppMethodBeat.o(208340);
    }

    public static fp aIK() {
        return hTO;
    }

    public static final void a(String str, long j2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, String str2) {
        AppMethodBeat.i(208341);
        x xVar = x.hJf;
        if (x.aGU()) {
            AppMethodBeat.o(208341);
            return;
        }
        x xVar2 = x.hJf;
        x.qX(-1);
        fp fpVar = hTO;
        x xVar3 = x.hJf;
        fpVar.oT((long) x.aGV());
        hTO.sB(str);
        hTO.oU(j2);
        hTO.oV((long) i2);
        hTO.oW(i3 < 0 ? 0 : (long) i3);
        hTO.oX((long) i4);
        hTO.oY((long) i5);
        hTO.oZ((long) i6);
        hTO.pa((long) i7);
        hTO.pb((long) i8);
        hTO.sC(str2);
        hTO.bfK();
        x xVar4 = x.hJf;
        x.eM(true);
        x xVar5 = x.hJf;
        x.qV(0);
        x xVar6 = x.hJf;
        x.qW(0);
        x xVar7 = x.hJf;
        x.qY(0);
        x xVar8 = x.hJf;
        x.qZ(0);
        x xVar9 = x.hJf;
        x.ra(0);
        x xVar10 = x.hJf;
        x.rb(0);
        x xVar11 = x.hJf;
        x.rc(0);
        hTO = new fp();
        AppMethodBeat.o(208341);
    }

    public static /* synthetic */ void a(String str, long j2, String str2, int i2, int i3, int i4) {
        AppMethodBeat.i(208343);
        a(str, j2, str2, i2, i3, "", i4);
        AppMethodBeat.o(208343);
    }

    public static final void a(String str, long j2, String str2, int i2, int i3, String str3, int i4) {
        AppMethodBeat.i(208342);
        p.h(str, "roomId");
        p.h(str2, "anchorName");
        p.h(str3, "audienceUserName");
        fm fmVar = new fm();
        fmVar.sr(str);
        fmVar.ob(j2);
        fmVar.of((long) i3);
        fmVar.oe((long) i2);
        b.a aVar = b.hTK;
        String aTY = z.aTY();
        p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
        fmVar.oc((long) b.a.ay(aTY, str2));
        b.a aVar2 = b.hTK;
        String aTY2 = z.aTY();
        p.g(aTY2, "ConfigStorageLogic.getUsernameFromUserInfo()");
        fmVar.od((long) b.a.ax(aTY2, str));
        fmVar.og(System.currentTimeMillis());
        fmVar.ss(str3);
        fmVar.st(str2);
        fmVar.oh((long) i4);
        fmVar.bfK();
        AppMethodBeat.o(208342);
    }

    public static final void a(String str, long j2, int i2, boolean z, int i3) {
        AppMethodBeat.i(208344);
        p.h(str, "roomId");
        ff ffVar = new ff();
        x xVar = x.hJf;
        x.re(0);
        ffVar.sd(str);
        ffVar.nq(j2);
        ffVar.nr((long) i2);
        ffVar.ns(z ? 1 : 0);
        ffVar.nt((long) i3);
        ffVar.bfK();
        AppMethodBeat.o(208344);
    }

    public static final void a(String str, long j2, String str2, long j3, int i2, int i3, String str3) {
        AppMethodBeat.i(208345);
        p.h(str, "roomId");
        p.h(str2, "micId");
        p.h(str3, "liveUserName");
        long currentTimeMillis = System.currentTimeMillis();
        fl flVar = new fl();
        x xVar = x.hJf;
        x.eN(false);
        flVar.so(str);
        flVar.nT(j2);
        flVar.sq(str2);
        flVar.nU((currentTimeMillis - j3) / 1000);
        flVar.nV((long) i2);
        flVar.nW((long) i3);
        flVar.sp(str3);
        flVar.nY(currentTimeMillis);
        flVar.nX(j3);
        x xVar2 = x.hJf;
        flVar.nZ(x.aHb());
        x xVar3 = x.hJf;
        flVar.oa((long) x.aGr().LIa);
        flVar.bfK();
        AppMethodBeat.o(208345);
    }

    public static final void a(String str, long j2, String str2, int i2, String str3) {
        AppMethodBeat.i(208346);
        p.h(str, "roomId");
        p.h(str3, "liveUserName");
        fh fhVar = new fh();
        fhVar.sg(str);
        fhVar.nD(j2);
        fhVar.si(str3);
        fhVar.afZ();
        fhVar.sh(str2);
        fhVar.nF((long) i2);
        b.a aVar = b.hTK;
        String aTY = z.aTY();
        p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
        fhVar.nE((long) b.a.ax(aTY, str));
        fhVar.bfK();
        AppMethodBeat.o(208346);
    }

    public static final void a(String str, long j2, String str2, String str3, int i2, int i3, int i4) {
        AppMethodBeat.i(208347);
        p.h(str, "roomId");
        p.h(str3, "liveUserName");
        fi fiVar = new fi();
        fiVar.sj(str);
        fiVar.nG(j2);
        b.a aVar = b.hTK;
        String aTY = z.aTY();
        p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
        fiVar.nI((long) b.a.ay(aTY, str3));
        fiVar.nH((long) i2);
        fiVar.sl(str3);
        fiVar.sk(str2);
        fiVar.nK((long) i3);
        fiVar.nL((long) i4);
        b.a aVar2 = b.hTK;
        String aTY2 = z.aTY();
        p.g(aTY2, "ConfigStorageLogic.getUsernameFromUserInfo()");
        fiVar.nJ((long) b.a.ax(aTY2, str));
        fiVar.bfK();
        AppMethodBeat.o(208347);
    }

    public static final void a(String str, long j2, String str2, String str3, long j3, long j4) {
        AppMethodBeat.i(208348);
        p.h(str, "roomId");
        p.h(str3, "liveUserName");
        fo foVar = new fo();
        foVar.sy(str);
        foVar.oO(j2);
        foVar.sz(str2);
        foVar.sA(str3);
        foVar.oR(j3);
        foVar.oS(j4);
        b.a aVar = b.hTK;
        String aTY = z.aTY();
        p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
        foVar.oP((long) b.a.ay(aTY, str3));
        b.a aVar2 = b.hTK;
        String aTY2 = z.aTY();
        p.g(aTY2, "ConfigStorageLogic.getUsernameFromUserInfo()");
        foVar.oQ((long) b.a.ax(aTY2, str));
        foVar.bfK();
        AppMethodBeat.o(208348);
    }

    public static final void b(String str, long j2, String str2, String str3, int i2, int i3, int i4) {
        AppMethodBeat.i(208349);
        p.h(str, "roomId");
        p.h(str2, "micId");
        p.h(str3, "liveUserName");
        fk fkVar = new fk();
        b.a aVar = b.hTK;
        String aTY = z.aTY();
        p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
        fkVar.nP((long) b.a.ay(aTY, str3));
        b.a aVar2 = b.hTK;
        String aTY2 = z.aTY();
        p.g(aTY2, "ConfigStorageLogic.getUsernameFromUserInfo()");
        fkVar.nQ((long) b.a.ax(aTY2, str));
        fkVar.nO(j2);
        fkVar.sn(str2);
        fkVar.nR((long) i2);
        fkVar.nS((long) i3);
        fkVar.ll(i4);
        fkVar.bfK();
        AppMethodBeat.o(208349);
    }
}
