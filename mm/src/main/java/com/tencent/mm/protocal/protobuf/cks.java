package com.tencent.mm.protocal.protobuf;

import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cks extends a {
    public int Lqz;
    public String Mqc;
    public String Mqd;
    public String Mqe;
    public String Mqf;
    public int Mqg;
    public String Mqh;
    public int Mqi;
    public int Mqj;
    public String Mqk;
    public int Mql;
    public int Mqm;
    public String Mqn;
    public int Mqo;
    public int Mqp;
    public String Mqq;
    public String Mqr;
    public String Mqs;
    public String Mqt;
    public String dNI;
    public String qGA;
    public int qGD;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152627);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dNI != null) {
                aVar.e(1, this.dNI);
            }
            if (this.Mqc != null) {
                aVar.e(20, this.Mqc);
            }
            if (this.Mqd != null) {
                aVar.e(21, this.Mqd);
            }
            if (this.Mqe != null) {
                aVar.e(22, this.Mqe);
            }
            if (this.Mqf != null) {
                aVar.e(23, this.Mqf);
            }
            if (this.qGA != null) {
                aVar.e(31, this.qGA);
            }
            aVar.aM(32, this.qGD);
            aVar.aM(33, this.Mqg);
            if (this.Mqh != null) {
                aVar.e(34, this.Mqh);
            }
            aVar.aM(35, this.Mqi);
            aVar.aM(36, this.Mqj);
            if (this.Mqk != null) {
                aVar.e(37, this.Mqk);
            }
            aVar.aM(38, this.Mql);
            aVar.aM(39, this.Mqm);
            if (this.Mqn != null) {
                aVar.e(41, this.Mqn);
            }
            aVar.aM(200, this.Mqo);
            aVar.aM(201, this.Mqp);
            aVar.aM(202, this.Lqz);
            if (this.Mqq != null) {
                aVar.e(203, this.Mqq);
            }
            if (this.Mqr != null) {
                aVar.e(204, this.Mqr);
            }
            if (this.Mqs != null) {
                aVar.e(205, this.Mqs);
            }
            if (this.Mqt != null) {
                aVar.e(206, this.Mqt);
            }
            AppMethodBeat.o(152627);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.dNI != null ? g.a.a.b.b.a.f(1, this.dNI) + 0 : 0;
            if (this.Mqc != null) {
                f2 += g.a.a.b.b.a.f(20, this.Mqc);
            }
            if (this.Mqd != null) {
                f2 += g.a.a.b.b.a.f(21, this.Mqd);
            }
            if (this.Mqe != null) {
                f2 += g.a.a.b.b.a.f(22, this.Mqe);
            }
            if (this.Mqf != null) {
                f2 += g.a.a.b.b.a.f(23, this.Mqf);
            }
            if (this.qGA != null) {
                f2 += g.a.a.b.b.a.f(31, this.qGA);
            }
            int bu = f2 + g.a.a.b.b.a.bu(32, this.qGD) + g.a.a.b.b.a.bu(33, this.Mqg);
            if (this.Mqh != null) {
                bu += g.a.a.b.b.a.f(34, this.Mqh);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(35, this.Mqi) + g.a.a.b.b.a.bu(36, this.Mqj);
            if (this.Mqk != null) {
                bu2 += g.a.a.b.b.a.f(37, this.Mqk);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(38, this.Mql) + g.a.a.b.b.a.bu(39, this.Mqm);
            if (this.Mqn != null) {
                bu3 += g.a.a.b.b.a.f(41, this.Mqn);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(200, this.Mqo) + g.a.a.b.b.a.bu(201, this.Mqp) + g.a.a.b.b.a.bu(202, this.Lqz);
            if (this.Mqq != null) {
                bu4 += g.a.a.b.b.a.f(203, this.Mqq);
            }
            if (this.Mqr != null) {
                bu4 += g.a.a.b.b.a.f(204, this.Mqr);
            }
            if (this.Mqs != null) {
                bu4 += g.a.a.b.b.a.f(205, this.Mqs);
            }
            if (this.Mqt != null) {
                bu4 += g.a.a.b.b.a.f(206, this.Mqt);
            }
            AppMethodBeat.o(152627);
            return bu4;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152627);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cks cks = (cks) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cks.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(152627);
                    return 0;
                case 20:
                    cks.Mqc = aVar3.UbS.readString();
                    AppMethodBeat.o(152627);
                    return 0;
                case 21:
                    cks.Mqd = aVar3.UbS.readString();
                    AppMethodBeat.o(152627);
                    return 0;
                case 22:
                    cks.Mqe = aVar3.UbS.readString();
                    AppMethodBeat.o(152627);
                    return 0;
                case 23:
                    cks.Mqf = aVar3.UbS.readString();
                    AppMethodBeat.o(152627);
                    return 0;
                case 31:
                    cks.qGA = aVar3.UbS.readString();
                    AppMethodBeat.o(152627);
                    return 0;
                case 32:
                    cks.qGD = aVar3.UbS.zi();
                    AppMethodBeat.o(152627);
                    return 0;
                case 33:
                    cks.Mqg = aVar3.UbS.zi();
                    AppMethodBeat.o(152627);
                    return 0;
                case 34:
                    cks.Mqh = aVar3.UbS.readString();
                    AppMethodBeat.o(152627);
                    return 0;
                case 35:
                    cks.Mqi = aVar3.UbS.zi();
                    AppMethodBeat.o(152627);
                    return 0;
                case 36:
                    cks.Mqj = aVar3.UbS.zi();
                    AppMethodBeat.o(152627);
                    return 0;
                case 37:
                    cks.Mqk = aVar3.UbS.readString();
                    AppMethodBeat.o(152627);
                    return 0;
                case 38:
                    cks.Mql = aVar3.UbS.zi();
                    AppMethodBeat.o(152627);
                    return 0;
                case 39:
                    cks.Mqm = aVar3.UbS.zi();
                    AppMethodBeat.o(152627);
                    return 0;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                    cks.Mqn = aVar3.UbS.readString();
                    AppMethodBeat.o(152627);
                    return 0;
                case 200:
                    cks.Mqo = aVar3.UbS.zi();
                    AppMethodBeat.o(152627);
                    return 0;
                case 201:
                    cks.Mqp = aVar3.UbS.zi();
                    AppMethodBeat.o(152627);
                    return 0;
                case 202:
                    cks.Lqz = aVar3.UbS.zi();
                    AppMethodBeat.o(152627);
                    return 0;
                case 203:
                    cks.Mqq = aVar3.UbS.readString();
                    AppMethodBeat.o(152627);
                    return 0;
                case 204:
                    cks.Mqr = aVar3.UbS.readString();
                    AppMethodBeat.o(152627);
                    return 0;
                case 205:
                    cks.Mqs = aVar3.UbS.readString();
                    AppMethodBeat.o(152627);
                    return 0;
                case 206:
                    cks.Mqt = aVar3.UbS.readString();
                    AppMethodBeat.o(152627);
                    return 0;
                default:
                    AppMethodBeat.o(152627);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152627);
            return -1;
        }
    }
}
