package com.tencent.mm.plugin.textstatus.k;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.g.b.a.ot;
import com.tencent.mm.g.b.a.ou;
import com.tencent.mm.g.b.a.ov;
import com.tencent.mm.g.b.a.ow;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.secdata.g;
import com.tencent.mm.plugin.secdata.i;
import com.tencent.mm.plugin.textstatus.a.m;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.g.ab;
import com.tencent.mm.plugin.textstatus.g.w;
import com.tencent.mm.plugin.textstatus.g.y;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.n.n;

public final class a {
    public static final a VeA = new a();

    /* renamed from: com.tencent.mm.plugin.textstatus.k.a$a */
    public static final class C1826a<T extends com.tencent.mm.bw.a> implements i<ab> {
        final /* synthetic */ String VeB;
        final /* synthetic */ Long VeC;
        final /* synthetic */ String VeD;
        final /* synthetic */ String VeE;

        C1826a(String str, Long l, String str2, String str3) {
            this.VeB = str;
            this.VeC = l;
            this.VeD = str2;
            this.VeE = str3;
        }

        @Override // com.tencent.mm.plugin.secdata.i
        public final /* synthetic */ void a(int i2, boolean z, ab abVar) {
            AppMethodBeat.i(258415);
            ab abVar2 = abVar;
            Log.i("MicroMsg.TxtStatus.tsReport", "postReport onActionDone " + i2 + ' ' + z + ' ' + this.VeB);
            if (abVar2 != null) {
                a aVar = a.VeA;
                a.b(abVar2, this.VeC, this.VeD, this.VeE);
                AppMethodBeat.o(258415);
                return;
            }
            Log.e("MicroMsg.TxtStatus.tsReport", "postReport: postData is null, " + this.VeB + ", " + this.VeC);
            AppMethodBeat.o(258415);
        }
    }

    static {
        AppMethodBeat.i(258431);
        AppMethodBeat.o(258431);
    }

    private a() {
    }

    public static final /* synthetic */ void b(ab abVar, Long l, String str, String str2) {
        AppMethodBeat.i(258432);
        a(abVar, l, str, str2);
        AppMethodBeat.o(258432);
    }

    public static final /* synthetic */ void c(com.tencent.mm.plugin.report.a aVar) {
        AppMethodBeat.i(258433);
        a(aVar);
        AppMethodBeat.o(258433);
    }

    private static void a(com.tencent.mm.plugin.report.a aVar) {
        AppMethodBeat.i(258418);
        String abW = aVar.abW();
        p.g(abW, "struct.toShowString()");
        Log.i("MicroMsg.TxtStatus.tsReport", "report%s %s", Integer.valueOf(aVar.getId()), n.j(abW, APLogFileUtil.SEPARATOR_LINE, " ", false));
        AppMethodBeat.o(258418);
    }

    public static /* synthetic */ void a(long j2, String str, String str2, int i2) {
        String str3;
        AppMethodBeat.i(258420);
        if ((i2 & 2) != 0) {
            str = "";
        }
        if ((i2 & 4) != 0) {
            y hXs = hXs();
            if (hXs == null || (str3 = hXs.sessionId) == null) {
                str3 = "";
            }
        } else {
            str3 = str2;
        }
        h(j2, str, str3);
        AppMethodBeat.o(258420);
    }

    public static void h(long j2, String str, String str2) {
        AppMethodBeat.i(258419);
        p.h(str, "actionResult");
        p.h(str2, "sessionId");
        ow bwX = new ow().RA(j2).bwY(str).RB(cl.aWz()).bwX(str2);
        bwX.bfK();
        p.g(bwX, LocaleUtil.ITALIAN);
        a(bwX);
        AppMethodBeat.o(258419);
    }

    public static void a(y yVar) {
        AppMethodBeat.i(258421);
        p.h(yVar, "exposedData");
        try {
            ((g) com.tencent.mm.kernel.g.ah(g.class)).updateOnlyMemory(9, "TextStatusCardExposed", yVar);
            AppMethodBeat.o(258421);
        } catch (Throwable th) {
            AppMethodBeat.o(258421);
        }
    }

    public static y hXs() {
        y yVar;
        AppMethodBeat.i(258422);
        try {
            yVar = (y) ((g) com.tencent.mm.kernel.g.ah(g.class)).getOnlyMemory(9, "TextStatusCardExposed");
        } catch (Throwable th) {
            yVar = null;
        }
        AppMethodBeat.o(258422);
        return yVar;
    }

    public static /* synthetic */ void a(long j2, y yVar) {
        AppMethodBeat.i(258424);
        a(j2, "", yVar);
        AppMethodBeat.o(258424);
    }

    public static void a(long j2, String str, y yVar) {
        long j3 = 1;
        AppMethodBeat.i(258423);
        p.h(str, "actionResult");
        p.h(yVar, "exposedData");
        f fVar = f.FXJ;
        com.tencent.mm.plugin.textstatus.f.f.a aTf = f.aTf(yVar.username);
        if (aTf == null) {
            AppMethodBeat.o(258423);
            return;
        }
        ot otVar = new ot();
        otVar.bwB(yVar.sessionId);
        w fvU = aTf.fvU();
        otVar.bwC(fvU.GaI);
        otVar.bwD(aTf.field_StatusID);
        otVar.bwE(aTf.field_IconID);
        otVar.bwF(fvU.Gao);
        otVar.bwG(fvU.Gap);
        otVar.bwH(fvU.Gal);
        otVar.bwI(yVar.VdQ);
        otVar.bwJ(yVar.VdR);
        otVar.QO((long) yVar.VdS);
        otVar.QP((long) yVar.VdT);
        otVar.bwK(yVar.username);
        otVar.QQ(p.j(com.tencent.mm.plugin.auth.a.a.ceA(), yVar.username) ? 1 : 2);
        otVar.QR((long) yVar.VdU);
        if (yVar.VdV <= 0) {
            j3 = 0;
        }
        otVar.QS(j3);
        otVar.QT((long) yVar.VdW);
        otVar.QU(j2);
        otVar.bwL(str);
        otVar.QV(cl.aWz());
        otVar.bfK();
        a(otVar);
        AppMethodBeat.o(258423);
    }

    public static void a(m mVar) {
        AppMethodBeat.i(258425);
        if (mVar != null) {
            ov ovVar = new ov();
            ovVar.bwO(Util.nullAs(mVar.sessionId, ""));
            ovVar.bwP(String.valueOf(mVar.enterTime));
            ovVar.Ra(mVar.VdK);
            ovVar.Rb(mVar.enterTime);
            ovVar.Rc(3);
            ovVar.anN(mVar.VdL);
            ovVar.aqe(mVar.VdM);
            ovVar.Rz(com.tencent.mm.plugin.textstatus.a.p.hXm() ? 0 : 1);
            ovVar.bfK();
            a(ovVar);
            AppMethodBeat.o(258425);
            return;
        }
        Log.e("MicroMsg.TxtStatus.tsReport", "postReportByTextStatusDoWhatActivity: param is null");
        AppMethodBeat.o(258425);
    }

    public static void a(boolean z, ab abVar) {
        AppMethodBeat.i(258426);
        if (abVar == null) {
            Log.e("MicroMsg.TxtStatus.tsReport", "postReportByTextStatusEditActivity: postData is null, ".concat(String.valueOf(z)));
            AppMethodBeat.o(258426);
        } else if (z) {
            ((g) com.tencent.mm.kernel.g.ah(g.class)).updateWithSave(8, "StatusTextPost_" + abVar.VdX, abVar, new b(z, abVar));
            AppMethodBeat.o(258426);
        } else {
            a(abVar, (Long) 3L, "", "");
            AppMethodBeat.o(258426);
        }
    }

    public static /* synthetic */ void c(String str, Long l) {
        AppMethodBeat.i(258428);
        a(str, l, "", "");
        AppMethodBeat.o(258428);
    }

    public static void a(String str, Long l, String str2, String str3) {
        AppMethodBeat.i(258427);
        if (str != null) {
            ((g) com.tencent.mm.kernel.g.ah(g.class)).getWithoutClear(8, "StatusTextPost_".concat(String.valueOf(str)), ab.class, new C1826a(str, l, str2, str3));
            AppMethodBeat.o(258427);
            return;
        }
        Log.i("MicroMsg.TxtStatus.tsReport", "postReport: cliPostID is null");
        AppMethodBeat.o(258427);
    }

    public static final class c implements Runnable {
        final /* synthetic */ ab VeH;
        final /* synthetic */ Long VeI;
        final /* synthetic */ String VeJ;
        final /* synthetic */ String VeK;

        c(ab abVar, Long l, String str, String str2) {
            this.VeH = abVar;
            this.VeI = l;
            this.VeJ = str;
            this.VeK = str2;
        }

        public final void run() {
            long j2 = 0;
            AppMethodBeat.i(258417);
            ov ovVar = new ov();
            ovVar.bwO(Util.nullAs(this.VeH.sessionId, ""));
            ovVar.Ra(this.VeH.VdK);
            ovVar.bwP(Util.nullAs(this.VeH.VdX, ""));
            ovVar.Rb(this.VeH.enterTime);
            Long l = this.VeI;
            ovVar.Rc(l != null ? l.longValue() : 0);
            ovVar.Rd(cl.aWA());
            ovVar.bwR(Util.nullAs(this.VeJ, ""));
            ovVar.bwS(Util.nullAs(this.VeK, ""));
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.VeH.VdZ.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (sb.length() > 0) {
                    sb.append(";");
                }
                sb.append(next);
            }
            ovVar.bwQ(sb.toString());
            ovVar.bwR(Util.nullAs(this.VeH.Vea, ""));
            ovVar.bwS(Util.nullAs(this.VeH.Veb, ""));
            ovVar.Re(this.VeH.Vec);
            ovVar.Rf(this.VeH.Ved);
            ovVar.Rg(this.VeH.Vee);
            ovVar.Rh(this.VeH.Vef);
            ovVar.Ri(this.VeH.Veg);
            ovVar.bwT(Util.nullAs(this.VeH.Veh, ""));
            ovVar.bwU(Util.nullAs(this.VeH.Vei, ""));
            ovVar.bwV(Util.nullAs(this.VeH.iFo, ""));
            ovVar.bwW(Util.nullAs(this.VeH.iFp, ""));
            ovVar.Rj(this.VeH.Vej);
            ovVar.Rk(this.VeH.Vek);
            ovVar.Rl(this.VeH.Vel);
            ovVar.Rm(this.VeH.Vem);
            ovVar.Rn(this.VeH.Ven);
            ovVar.Ro(this.VeH.Veo);
            ovVar.Rp(this.VeH.Vep);
            ovVar.Rq(this.VeH.Veq);
            ovVar.Rr(this.VeH.Ver);
            ovVar.Rs(this.VeH.Ves);
            ovVar.Rt(this.VeH.Vet);
            ovVar.Ru(this.VeH.Veu);
            ovVar.Rv((long) this.VeH.Vev);
            ovVar.Rw(this.VeH.Vew);
            ovVar.Rx(this.VeH.Vex);
            ovVar.Ry(this.VeH.Vey);
            ovVar.anN(this.VeH.VdL);
            ovVar.aqe(this.VeH.VdM);
            if (!com.tencent.mm.plugin.textstatus.a.p.hXm()) {
                j2 = 1;
            }
            ovVar.Rz(j2);
            ovVar.bfK();
            a aVar = a.VeA;
            a.c(ovVar);
            AppMethodBeat.o(258417);
        }
    }

    private static void a(ab abVar, Long l, String str, String str2) {
        AppMethodBeat.i(258429);
        h.RTc.aX(new c(abVar, l, str, str2));
        AppMethodBeat.o(258429);
    }

    public static void report22210(String str, long j2) {
        long j3;
        boolean z = true;
        long j4 = 2;
        AppMethodBeat.i(258430);
        p.h(str, "userName");
        f fVar = f.FXJ;
        com.tencent.mm.plugin.textstatus.f.f.a aTl = f.fvM().aTl(str);
        if (j2 != 2) {
            if (j2 == 3) {
                if (str.length() != 0) {
                    z = false;
                }
                if (!z) {
                    j3 = 1;
                }
            } else if (j2 == 4) {
                if (!(str.length() == 0)) {
                    j3 = 1;
                }
            } else if (j2 == 5) {
                j3 = 1;
            } else if (j2 == 6) {
                j3 = 1;
            } else if (j2 == 7) {
                j3 = 1;
            } else if (j2 == 8) {
                j3 = 1;
            } else if (j2 == 9) {
                j3 = 2;
            } else if (j2 == 10) {
                j3 = 1;
            }
            j3 = 0;
        } else if (aTl != null) {
            j3 = 1;
        } else {
            j3 = 0;
        }
        ou QW = new ou().bwM(str).QW(j2);
        if (aTl == null) {
            j4 = 1;
        }
        QW.QX(j4).QY(j3).QZ(System.currentTimeMillis()).bwN("").bfK();
        AppMethodBeat.o(258430);
    }

    /* access modifiers changed from: package-private */
    public static final class b<T extends com.tencent.mm.bw.a> implements i<ab> {
        final /* synthetic */ boolean VeF;
        final /* synthetic */ ab VeG;

        b(boolean z, ab abVar) {
            this.VeF = z;
            this.VeG = abVar;
        }

        @Override // com.tencent.mm.plugin.secdata.i
        public final /* synthetic */ void a(int i2, boolean z, ab abVar) {
            AppMethodBeat.i(258416);
            Log.i("MicroMsg.TxtStatus.tsReport", "postReportByTextStatusEditActivity onActionDone " + i2 + ' ' + z + ' ' + this.VeG.VdX);
            AppMethodBeat.o(258416);
        }
    }
}
