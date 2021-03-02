package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dbt extends a {
    public String AOk;
    public String CiX;
    public String Htm;
    public String Htn;
    public int Htr;
    public String Hts;
    public ejl MGF;
    public cre MGG;
    public cpa MGH;
    public String dDj;
    public long eht;
    public int grV;
    public int state;
    public String ynT;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91618);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.grV);
            aVar.bb(2, this.eht);
            if (this.dDj != null) {
                aVar.e(3, this.dDj);
            }
            if (this.AOk != null) {
                aVar.e(4, this.AOk);
            }
            if (this.Htm != null) {
                aVar.e(5, this.Htm);
            }
            if (this.Htn != null) {
                aVar.e(6, this.Htn);
            }
            if (this.MGF != null) {
                aVar.ni(7, this.MGF.computeSize());
                this.MGF.writeFields(aVar);
            }
            if (this.MGG != null) {
                aVar.ni(8, this.MGG.computeSize());
                this.MGG.writeFields(aVar);
            }
            if (this.MGH != null) {
                aVar.ni(9, this.MGH.computeSize());
                this.MGH.writeFields(aVar);
            }
            aVar.aM(10, this.Htr);
            aVar.aM(11, this.state);
            if (this.ynT != null) {
                aVar.e(12, this.ynT);
            }
            if (this.CiX != null) {
                aVar.e(13, this.CiX);
            }
            if (this.Hts != null) {
                aVar.e(14, this.Hts);
            }
            AppMethodBeat.o(91618);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.grV) + 0 + g.a.a.b.b.a.r(2, this.eht);
            if (this.dDj != null) {
                bu += g.a.a.b.b.a.f(3, this.dDj);
            }
            if (this.AOk != null) {
                bu += g.a.a.b.b.a.f(4, this.AOk);
            }
            if (this.Htm != null) {
                bu += g.a.a.b.b.a.f(5, this.Htm);
            }
            if (this.Htn != null) {
                bu += g.a.a.b.b.a.f(6, this.Htn);
            }
            if (this.MGF != null) {
                bu += g.a.a.a.nh(7, this.MGF.computeSize());
            }
            if (this.MGG != null) {
                bu += g.a.a.a.nh(8, this.MGG.computeSize());
            }
            if (this.MGH != null) {
                bu += g.a.a.a.nh(9, this.MGH.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(10, this.Htr) + g.a.a.b.b.a.bu(11, this.state);
            if (this.ynT != null) {
                bu2 += g.a.a.b.b.a.f(12, this.ynT);
            }
            if (this.CiX != null) {
                bu2 += g.a.a.b.b.a.f(13, this.CiX);
            }
            if (this.Hts != null) {
                bu2 += g.a.a.b.b.a.f(14, this.Hts);
            }
            AppMethodBeat.o(91618);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91618);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dbt dbt = (dbt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dbt.grV = aVar3.UbS.zi();
                    AppMethodBeat.o(91618);
                    return 0;
                case 2:
                    dbt.eht = aVar3.UbS.zl();
                    AppMethodBeat.o(91618);
                    return 0;
                case 3:
                    dbt.dDj = aVar3.UbS.readString();
                    AppMethodBeat.o(91618);
                    return 0;
                case 4:
                    dbt.AOk = aVar3.UbS.readString();
                    AppMethodBeat.o(91618);
                    return 0;
                case 5:
                    dbt.Htm = aVar3.UbS.readString();
                    AppMethodBeat.o(91618);
                    return 0;
                case 6:
                    dbt.Htn = aVar3.UbS.readString();
                    AppMethodBeat.o(91618);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ejl ejl = new ejl();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ejl.populateBuilderWithField(aVar4, ejl, a.getNextFieldNumber(aVar4))) {
                        }
                        dbt.MGF = ejl;
                    }
                    AppMethodBeat.o(91618);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cre cre = new cre();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cre.populateBuilderWithField(aVar5, cre, a.getNextFieldNumber(aVar5))) {
                        }
                        dbt.MGG = cre;
                    }
                    AppMethodBeat.o(91618);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cpa cpa = new cpa();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cpa.populateBuilderWithField(aVar6, cpa, a.getNextFieldNumber(aVar6))) {
                        }
                        dbt.MGH = cpa;
                    }
                    AppMethodBeat.o(91618);
                    return 0;
                case 10:
                    dbt.Htr = aVar3.UbS.zi();
                    AppMethodBeat.o(91618);
                    return 0;
                case 11:
                    dbt.state = aVar3.UbS.zi();
                    AppMethodBeat.o(91618);
                    return 0;
                case 12:
                    dbt.ynT = aVar3.UbS.readString();
                    AppMethodBeat.o(91618);
                    return 0;
                case 13:
                    dbt.CiX = aVar3.UbS.readString();
                    AppMethodBeat.o(91618);
                    return 0;
                case 14:
                    dbt.Hts = aVar3.UbS.readString();
                    AppMethodBeat.o(91618);
                    return 0;
                default:
                    AppMethodBeat.o(91618);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91618);
            return -1;
        }
    }
}
