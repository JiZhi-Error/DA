package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public class ab extends a {
    public long VdK;
    public int VdL;
    public int VdM;
    public String VdX;
    public long VdY;
    public LinkedList<String> VdZ = new LinkedList<>();
    public String Vea;
    public String Veb;
    public long Vec;
    public long Ved;
    public long Vee;
    public long Vef;
    public long Veg;
    public String Veh;
    public String Vei;
    public long Vej;
    public long Vek;
    public long Vel;
    public long Vem;
    public long Ven;
    public long Veo;
    public long Vep;
    public long Veq;
    public long Ver;
    public long Ves;
    public long Vet;
    public long Veu;
    public int Vev;
    public long Vew;
    public long Vex;
    public long Vey;
    public int dRk;
    public int enterScene;
    public long enterTime;
    public String iFo;
    public String iFp;
    public String sessionId;

    public ab() {
        AppMethodBeat.i(259510);
        AppMethodBeat.o(259510);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(259511);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.VdX != null) {
                aVar.e(1, this.VdX);
            }
            aVar.aM(2, this.enterScene);
            aVar.aM(3, this.dRk);
            aVar.bb(4, this.enterTime);
            aVar.bb(5, this.VdY);
            aVar.e(6, 1, this.VdZ);
            if (this.Vea != null) {
                aVar.e(7, this.Vea);
            }
            if (this.Veb != null) {
                aVar.e(8, this.Veb);
            }
            aVar.bb(9, this.Vec);
            aVar.bb(10, this.Ved);
            aVar.bb(11, this.Vee);
            aVar.bb(12, this.Vef);
            aVar.bb(13, this.Veg);
            if (this.Veh != null) {
                aVar.e(14, this.Veh);
            }
            if (this.Vei != null) {
                aVar.e(15, this.Vei);
            }
            if (this.iFo != null) {
                aVar.e(16, this.iFo);
            }
            if (this.iFp != null) {
                aVar.e(17, this.iFp);
            }
            aVar.bb(18, this.Vej);
            aVar.bb(19, this.Vek);
            aVar.bb(20, this.Vel);
            aVar.bb(21, this.Vem);
            aVar.bb(22, this.Ven);
            aVar.bb(23, this.Veo);
            aVar.bb(24, this.Vep);
            aVar.bb(25, this.Veq);
            aVar.bb(26, this.Ver);
            aVar.bb(27, this.Ves);
            aVar.bb(28, this.Vet);
            aVar.bb(29, this.Veu);
            aVar.aM(30, this.Vev);
            aVar.bb(31, this.Vew);
            aVar.bb(32, this.Vex);
            aVar.bb(33, this.Vey);
            if (this.sessionId != null) {
                aVar.e(34, this.sessionId);
            }
            aVar.bb(35, this.VdK);
            aVar.aM(36, this.VdL);
            aVar.aM(37, this.VdM);
            AppMethodBeat.o(259511);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.VdX != null ? g.a.a.b.b.a.f(1, this.VdX) + 0 : 0) + g.a.a.b.b.a.bu(2, this.enterScene) + g.a.a.b.b.a.bu(3, this.dRk) + g.a.a.b.b.a.r(4, this.enterTime) + g.a.a.b.b.a.r(5, this.VdY) + g.a.a.a.c(6, 1, this.VdZ);
            if (this.Vea != null) {
                f2 += g.a.a.b.b.a.f(7, this.Vea);
            }
            if (this.Veb != null) {
                f2 += g.a.a.b.b.a.f(8, this.Veb);
            }
            int r = f2 + g.a.a.b.b.a.r(9, this.Vec) + g.a.a.b.b.a.r(10, this.Ved) + g.a.a.b.b.a.r(11, this.Vee) + g.a.a.b.b.a.r(12, this.Vef) + g.a.a.b.b.a.r(13, this.Veg);
            if (this.Veh != null) {
                r += g.a.a.b.b.a.f(14, this.Veh);
            }
            if (this.Vei != null) {
                r += g.a.a.b.b.a.f(15, this.Vei);
            }
            if (this.iFo != null) {
                r += g.a.a.b.b.a.f(16, this.iFo);
            }
            if (this.iFp != null) {
                r += g.a.a.b.b.a.f(17, this.iFp);
            }
            int r2 = r + g.a.a.b.b.a.r(18, this.Vej) + g.a.a.b.b.a.r(19, this.Vek) + g.a.a.b.b.a.r(20, this.Vel) + g.a.a.b.b.a.r(21, this.Vem) + g.a.a.b.b.a.r(22, this.Ven) + g.a.a.b.b.a.r(23, this.Veo) + g.a.a.b.b.a.r(24, this.Vep) + g.a.a.b.b.a.r(25, this.Veq) + g.a.a.b.b.a.r(26, this.Ver) + g.a.a.b.b.a.r(27, this.Ves) + g.a.a.b.b.a.r(28, this.Vet) + g.a.a.b.b.a.r(29, this.Veu) + g.a.a.b.b.a.bu(30, this.Vev) + g.a.a.b.b.a.r(31, this.Vew) + g.a.a.b.b.a.r(32, this.Vex) + g.a.a.b.b.a.r(33, this.Vey);
            if (this.sessionId != null) {
                r2 += g.a.a.b.b.a.f(34, this.sessionId);
            }
            int r3 = r2 + g.a.a.b.b.a.r(35, this.VdK) + g.a.a.b.b.a.bu(36, this.VdL) + g.a.a.b.b.a.bu(37, this.VdM);
            AppMethodBeat.o(259511);
            return r3;
        } else if (i2 == 2) {
            this.VdZ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(259511);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ab abVar = (ab) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abVar.VdX = aVar3.UbS.readString();
                    AppMethodBeat.o(259511);
                    return 0;
                case 2:
                    abVar.enterScene = aVar3.UbS.zi();
                    AppMethodBeat.o(259511);
                    return 0;
                case 3:
                    abVar.dRk = aVar3.UbS.zi();
                    AppMethodBeat.o(259511);
                    return 0;
                case 4:
                    abVar.enterTime = aVar3.UbS.zl();
                    AppMethodBeat.o(259511);
                    return 0;
                case 5:
                    abVar.VdY = aVar3.UbS.zl();
                    AppMethodBeat.o(259511);
                    return 0;
                case 6:
                    abVar.VdZ.add(aVar3.UbS.readString());
                    AppMethodBeat.o(259511);
                    return 0;
                case 7:
                    abVar.Vea = aVar3.UbS.readString();
                    AppMethodBeat.o(259511);
                    return 0;
                case 8:
                    abVar.Veb = aVar3.UbS.readString();
                    AppMethodBeat.o(259511);
                    return 0;
                case 9:
                    abVar.Vec = aVar3.UbS.zl();
                    AppMethodBeat.o(259511);
                    return 0;
                case 10:
                    abVar.Ved = aVar3.UbS.zl();
                    AppMethodBeat.o(259511);
                    return 0;
                case 11:
                    abVar.Vee = aVar3.UbS.zl();
                    AppMethodBeat.o(259511);
                    return 0;
                case 12:
                    abVar.Vef = aVar3.UbS.zl();
                    AppMethodBeat.o(259511);
                    return 0;
                case 13:
                    abVar.Veg = aVar3.UbS.zl();
                    AppMethodBeat.o(259511);
                    return 0;
                case 14:
                    abVar.Veh = aVar3.UbS.readString();
                    AppMethodBeat.o(259511);
                    return 0;
                case 15:
                    abVar.Vei = aVar3.UbS.readString();
                    AppMethodBeat.o(259511);
                    return 0;
                case 16:
                    abVar.iFo = aVar3.UbS.readString();
                    AppMethodBeat.o(259511);
                    return 0;
                case 17:
                    abVar.iFp = aVar3.UbS.readString();
                    AppMethodBeat.o(259511);
                    return 0;
                case 18:
                    abVar.Vej = aVar3.UbS.zl();
                    AppMethodBeat.o(259511);
                    return 0;
                case 19:
                    abVar.Vek = aVar3.UbS.zl();
                    AppMethodBeat.o(259511);
                    return 0;
                case 20:
                    abVar.Vel = aVar3.UbS.zl();
                    AppMethodBeat.o(259511);
                    return 0;
                case 21:
                    abVar.Vem = aVar3.UbS.zl();
                    AppMethodBeat.o(259511);
                    return 0;
                case 22:
                    abVar.Ven = aVar3.UbS.zl();
                    AppMethodBeat.o(259511);
                    return 0;
                case 23:
                    abVar.Veo = aVar3.UbS.zl();
                    AppMethodBeat.o(259511);
                    return 0;
                case 24:
                    abVar.Vep = aVar3.UbS.zl();
                    AppMethodBeat.o(259511);
                    return 0;
                case 25:
                    abVar.Veq = aVar3.UbS.zl();
                    AppMethodBeat.o(259511);
                    return 0;
                case 26:
                    abVar.Ver = aVar3.UbS.zl();
                    AppMethodBeat.o(259511);
                    return 0;
                case 27:
                    abVar.Ves = aVar3.UbS.zl();
                    AppMethodBeat.o(259511);
                    return 0;
                case 28:
                    abVar.Vet = aVar3.UbS.zl();
                    AppMethodBeat.o(259511);
                    return 0;
                case 29:
                    abVar.Veu = aVar3.UbS.zl();
                    AppMethodBeat.o(259511);
                    return 0;
                case 30:
                    abVar.Vev = aVar3.UbS.zi();
                    AppMethodBeat.o(259511);
                    return 0;
                case 31:
                    abVar.Vew = aVar3.UbS.zl();
                    AppMethodBeat.o(259511);
                    return 0;
                case 32:
                    abVar.Vex = aVar3.UbS.zl();
                    AppMethodBeat.o(259511);
                    return 0;
                case 33:
                    abVar.Vey = aVar3.UbS.zl();
                    AppMethodBeat.o(259511);
                    return 0;
                case 34:
                    abVar.sessionId = aVar3.UbS.readString();
                    AppMethodBeat.o(259511);
                    return 0;
                case 35:
                    abVar.VdK = aVar3.UbS.zl();
                    AppMethodBeat.o(259511);
                    return 0;
                case 36:
                    abVar.VdL = aVar3.UbS.zi();
                    AppMethodBeat.o(259511);
                    return 0;
                case 37:
                    abVar.VdM = aVar3.UbS.zi();
                    AppMethodBeat.o(259511);
                    return 0;
                default:
                    AppMethodBeat.o(259511);
                    return -1;
            }
        } else {
            AppMethodBeat.o(259511);
            return -1;
        }
    }
}
