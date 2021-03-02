package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class biq extends dpc {
    public int KCD;
    public String KCE;
    public dyj KCF;
    public int KCN;
    public int KCz;
    public ih wRL;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32220);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32220);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.KCD);
            aVar.aM(3, this.KCN);
            if (this.KCE != null) {
                aVar.e(4, this.KCE);
            }
            if (this.KCF != null) {
                aVar.ni(5, this.KCF.computeSize());
                this.KCF.writeFields(aVar);
            }
            if (this.wRL != null) {
                aVar.ni(6, this.wRL.computeSize());
                this.wRL.writeFields(aVar);
            }
            aVar.aM(7, this.KCz);
            AppMethodBeat.o(32220);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KCD) + g.a.a.b.b.a.bu(3, this.KCN);
            if (this.KCE != null) {
                nh += g.a.a.b.b.a.f(4, this.KCE);
            }
            if (this.KCF != null) {
                nh += g.a.a.a.nh(5, this.KCF.computeSize());
            }
            if (this.wRL != null) {
                nh += g.a.a.a.nh(6, this.wRL.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(7, this.KCz);
            AppMethodBeat.o(32220);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32220);
                throw bVar2;
            }
            AppMethodBeat.o(32220);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            biq biq = (biq) objArr[1];
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
                        biq.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32220);
                    return 0;
                case 2:
                    biq.KCD = aVar3.UbS.zi();
                    AppMethodBeat.o(32220);
                    return 0;
                case 3:
                    biq.KCN = aVar3.UbS.zi();
                    AppMethodBeat.o(32220);
                    return 0;
                case 4:
                    biq.KCE = aVar3.UbS.readString();
                    AppMethodBeat.o(32220);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dyj dyj = new dyj();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dyj.populateBuilderWithField(aVar5, dyj, dpc.getNextFieldNumber(aVar5))) {
                        }
                        biq.KCF = dyj;
                    }
                    AppMethodBeat.o(32220);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ih ihVar = new ih();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ihVar.populateBuilderWithField(aVar6, ihVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        biq.wRL = ihVar;
                    }
                    AppMethodBeat.o(32220);
                    return 0;
                case 7:
                    biq.KCz = aVar3.UbS.zi();
                    AppMethodBeat.o(32220);
                    return 0;
                default:
                    AppMethodBeat.o(32220);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32220);
            return -1;
        }
    }
}
