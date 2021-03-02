package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bmc extends dpc {
    public eig LUW;
    public cma LUX;
    public int pTZ;
    public String pUa;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72484);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72484);
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
            if (this.LUW != null) {
                aVar.ni(4, this.LUW.computeSize());
                this.LUW.writeFields(aVar);
            }
            if (this.LUX != null) {
                aVar.ni(5, this.LUX.computeSize());
                this.LUX.writeFields(aVar);
            }
            AppMethodBeat.o(72484);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            if (this.LUW != null) {
                nh += g.a.a.a.nh(4, this.LUW.computeSize());
            }
            if (this.LUX != null) {
                nh += g.a.a.a.nh(5, this.LUX.computeSize());
            }
            AppMethodBeat.o(72484);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72484);
                throw bVar2;
            }
            AppMethodBeat.o(72484);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bmc bmc = (bmc) objArr[1];
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
                        bmc.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(72484);
                    return 0;
                case 2:
                    bmc.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(72484);
                    return 0;
                case 3:
                    bmc.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(72484);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eig eig = new eig();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eig.populateBuilderWithField(aVar5, eig, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bmc.LUW = eig;
                    }
                    AppMethodBeat.o(72484);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cma cma = new cma();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cma.populateBuilderWithField(aVar6, cma, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bmc.LUX = cma;
                    }
                    AppMethodBeat.o(72484);
                    return 0;
                default:
                    AppMethodBeat.o(72484);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72484);
            return -1;
        }
    }
}
