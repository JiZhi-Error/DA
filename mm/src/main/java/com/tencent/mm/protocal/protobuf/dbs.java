package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dbs extends dpc {
    public long Hth;
    public String Hti;
    public String Htk;
    public String Htl;
    public LinkedList<dbt> MGC = new LinkedList<>();
    public jh MGD;
    public int MGE;
    public int pTZ;
    public String pUa;

    public dbs() {
        AppMethodBeat.i(91616);
        AppMethodBeat.o(91616);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91617);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91617);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.pTZ);
            if (this.pUa != null) {
                aVar.e(3, this.pUa);
            }
            aVar.e(4, 8, this.MGC);
            aVar.bb(5, this.Hth);
            if (this.Hti != null) {
                aVar.e(6, this.Hti);
            }
            if (this.MGD != null) {
                aVar.ni(7, this.MGD.computeSize());
                this.MGD.writeFields(aVar);
            }
            if (this.Htk != null) {
                aVar.e(8, this.Htk);
            }
            if (this.Htl != null) {
                aVar.e(9, this.Htl);
            }
            aVar.aM(10, this.MGE);
            AppMethodBeat.o(91617);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            int c2 = nh + g.a.a.a.c(4, 8, this.MGC) + g.a.a.b.b.a.r(5, this.Hth);
            if (this.Hti != null) {
                c2 += g.a.a.b.b.a.f(6, this.Hti);
            }
            if (this.MGD != null) {
                c2 += g.a.a.a.nh(7, this.MGD.computeSize());
            }
            if (this.Htk != null) {
                c2 += g.a.a.b.b.a.f(8, this.Htk);
            }
            if (this.Htl != null) {
                c2 += g.a.a.b.b.a.f(9, this.Htl);
            }
            int bu = c2 + g.a.a.b.b.a.bu(10, this.MGE);
            AppMethodBeat.o(91617);
            return bu;
        } else if (i2 == 2) {
            this.MGC.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91617);
                throw bVar2;
            }
            AppMethodBeat.o(91617);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dbs dbs = (dbs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        BaseResponse baseResponse = new BaseResponse();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, dpc.getNextFieldNumber(aVar4))) {
                        }
                        dbs.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91617);
                    return 0;
                case 2:
                    dbs.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(91617);
                    return 0;
                case 3:
                    dbs.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(91617);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dbt dbt = new dbt();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dbt.populateBuilderWithField(aVar5, dbt, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dbs.MGC.add(dbt);
                    }
                    AppMethodBeat.o(91617);
                    return 0;
                case 5:
                    dbs.Hth = aVar3.UbS.zl();
                    AppMethodBeat.o(91617);
                    return 0;
                case 6:
                    dbs.Hti = aVar3.UbS.readString();
                    AppMethodBeat.o(91617);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        jh jhVar = new jh();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = jhVar.populateBuilderWithField(aVar6, jhVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        dbs.MGD = jhVar;
                    }
                    AppMethodBeat.o(91617);
                    return 0;
                case 8:
                    dbs.Htk = aVar3.UbS.readString();
                    AppMethodBeat.o(91617);
                    return 0;
                case 9:
                    dbs.Htl = aVar3.UbS.readString();
                    AppMethodBeat.o(91617);
                    return 0;
                case 10:
                    dbs.MGE = aVar3.UbS.zi();
                    AppMethodBeat.o(91617);
                    return 0;
                default:
                    AppMethodBeat.o(91617);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91617);
            return -1;
        }
    }
}
