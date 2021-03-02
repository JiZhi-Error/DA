package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ajo extends dpc {
    public LinkedList<egs> KGQ = new LinkedList<>();
    public int KMC;
    public LinkedList<egr> KMD = new LinkedList<>();
    public int LsZ;
    public long Lta;
    public int Ltb;
    public int Ltc;
    public int Ltd;

    public ajo() {
        AppMethodBeat.i(32191);
        AppMethodBeat.o(32191);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32192);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32192);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.LsZ);
            aVar.bb(3, this.Lta);
            aVar.aM(4, this.Ltb);
            aVar.aM(5, this.Ltc);
            aVar.e(6, 8, this.KGQ);
            aVar.aM(7, this.Ltd);
            aVar.aM(8, this.KMC);
            aVar.e(9, 8, this.KMD);
            AppMethodBeat.o(32192);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LsZ) + g.a.a.b.b.a.r(3, this.Lta) + g.a.a.b.b.a.bu(4, this.Ltb) + g.a.a.b.b.a.bu(5, this.Ltc) + g.a.a.a.c(6, 8, this.KGQ) + g.a.a.b.b.a.bu(7, this.Ltd) + g.a.a.b.b.a.bu(8, this.KMC) + g.a.a.a.c(9, 8, this.KMD);
            AppMethodBeat.o(32192);
            return nh;
        } else if (i2 == 2) {
            this.KGQ.clear();
            this.KMD.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32192);
                throw bVar2;
            }
            AppMethodBeat.o(32192);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ajo ajo = (ajo) objArr[1];
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
                        ajo.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32192);
                    return 0;
                case 2:
                    ajo.LsZ = aVar3.UbS.zi();
                    AppMethodBeat.o(32192);
                    return 0;
                case 3:
                    ajo.Lta = aVar3.UbS.zl();
                    AppMethodBeat.o(32192);
                    return 0;
                case 4:
                    ajo.Ltb = aVar3.UbS.zi();
                    AppMethodBeat.o(32192);
                    return 0;
                case 5:
                    ajo.Ltc = aVar3.UbS.zi();
                    AppMethodBeat.o(32192);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        egs egs = new egs();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = egs.populateBuilderWithField(aVar5, egs, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ajo.KGQ.add(egs);
                    }
                    AppMethodBeat.o(32192);
                    return 0;
                case 7:
                    ajo.Ltd = aVar3.UbS.zi();
                    AppMethodBeat.o(32192);
                    return 0;
                case 8:
                    ajo.KMC = aVar3.UbS.zi();
                    AppMethodBeat.o(32192);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        egr egr = new egr();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = egr.populateBuilderWithField(aVar6, egr, dpc.getNextFieldNumber(aVar6))) {
                        }
                        ajo.KMD.add(egr);
                    }
                    AppMethodBeat.o(32192);
                    return 0;
                default:
                    AppMethodBeat.o(32192);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32192);
            return -1;
        }
    }
}
