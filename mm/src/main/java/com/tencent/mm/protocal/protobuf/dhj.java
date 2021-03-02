package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dhj extends dpc {
    public String HuS;
    public int MLH;
    public String MLI;
    public String MLJ;
    public caf MLK;
    public ckj efB;
    public int pTZ;
    public String pUa;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91642);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91642);
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
            aVar.aM(4, this.MLH);
            if (this.MLI != null) {
                aVar.e(5, this.MLI);
            }
            if (this.MLJ != null) {
                aVar.e(6, this.MLJ);
            }
            if (this.MLK != null) {
                aVar.ni(7, this.MLK.computeSize());
                this.MLK.writeFields(aVar);
            }
            if (this.efB != null) {
                aVar.ni(99, this.efB.computeSize());
                this.efB.writeFields(aVar);
            }
            if (this.HuS != null) {
                aVar.e(100, this.HuS);
            }
            AppMethodBeat.o(91642);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.MLH);
            if (this.MLI != null) {
                bu += g.a.a.b.b.a.f(5, this.MLI);
            }
            if (this.MLJ != null) {
                bu += g.a.a.b.b.a.f(6, this.MLJ);
            }
            if (this.MLK != null) {
                bu += g.a.a.a.nh(7, this.MLK.computeSize());
            }
            if (this.efB != null) {
                bu += g.a.a.a.nh(99, this.efB.computeSize());
            }
            if (this.HuS != null) {
                bu += g.a.a.b.b.a.f(100, this.HuS);
            }
            AppMethodBeat.o(91642);
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
                AppMethodBeat.o(91642);
                throw bVar2;
            }
            AppMethodBeat.o(91642);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dhj dhj = (dhj) objArr[1];
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
                        dhj.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91642);
                    return 0;
                case 2:
                    dhj.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(91642);
                    return 0;
                case 3:
                    dhj.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(91642);
                    return 0;
                case 4:
                    dhj.MLH = aVar3.UbS.zi();
                    AppMethodBeat.o(91642);
                    return 0;
                case 5:
                    dhj.MLI = aVar3.UbS.readString();
                    AppMethodBeat.o(91642);
                    return 0;
                case 6:
                    dhj.MLJ = aVar3.UbS.readString();
                    AppMethodBeat.o(91642);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        caf caf = new caf();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = caf.populateBuilderWithField(aVar5, caf, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dhj.MLK = caf;
                    }
                    AppMethodBeat.o(91642);
                    return 0;
                case 99:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ckj ckj = new ckj();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ckj.populateBuilderWithField(aVar6, ckj, dpc.getNextFieldNumber(aVar6))) {
                        }
                        dhj.efB = ckj;
                    }
                    AppMethodBeat.o(91642);
                    return 0;
                case 100:
                    dhj.HuS = aVar3.UbS.readString();
                    AppMethodBeat.o(91642);
                    return 0;
                default:
                    AppMethodBeat.o(91642);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91642);
            return -1;
        }
    }
}
