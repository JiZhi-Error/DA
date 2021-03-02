package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dhl extends dpc {
    public String HuS;
    public String MIm;
    public String MIn;
    public ay MLL;
    public ehj MLM;
    public ddf MLN;
    public String MLO;
    public int pTZ;
    public String pUa;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72565);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72565);
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
            if (this.MIm != null) {
                aVar.e(4, this.MIm);
            }
            if (this.MIn != null) {
                aVar.e(5, this.MIn);
            }
            if (this.MLL != null) {
                aVar.ni(6, this.MLL.computeSize());
                this.MLL.writeFields(aVar);
            }
            if (this.MLM != null) {
                aVar.ni(7, this.MLM.computeSize());
                this.MLM.writeFields(aVar);
            }
            if (this.MLN != null) {
                aVar.ni(8, this.MLN.computeSize());
                this.MLN.writeFields(aVar);
            }
            if (this.MLO != null) {
                aVar.e(9, this.MLO);
            }
            if (this.HuS != null) {
                aVar.e(100, this.HuS);
            }
            AppMethodBeat.o(72565);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            if (this.MIm != null) {
                nh += g.a.a.b.b.a.f(4, this.MIm);
            }
            if (this.MIn != null) {
                nh += g.a.a.b.b.a.f(5, this.MIn);
            }
            if (this.MLL != null) {
                nh += g.a.a.a.nh(6, this.MLL.computeSize());
            }
            if (this.MLM != null) {
                nh += g.a.a.a.nh(7, this.MLM.computeSize());
            }
            if (this.MLN != null) {
                nh += g.a.a.a.nh(8, this.MLN.computeSize());
            }
            if (this.MLO != null) {
                nh += g.a.a.b.b.a.f(9, this.MLO);
            }
            if (this.HuS != null) {
                nh += g.a.a.b.b.a.f(100, this.HuS);
            }
            AppMethodBeat.o(72565);
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
                AppMethodBeat.o(72565);
                throw bVar2;
            }
            AppMethodBeat.o(72565);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dhl dhl = (dhl) objArr[1];
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
                        dhl.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(72565);
                    return 0;
                case 2:
                    dhl.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(72565);
                    return 0;
                case 3:
                    dhl.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(72565);
                    return 0;
                case 4:
                    dhl.MIm = aVar3.UbS.readString();
                    AppMethodBeat.o(72565);
                    return 0;
                case 5:
                    dhl.MIn = aVar3.UbS.readString();
                    AppMethodBeat.o(72565);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ay ayVar = new ay();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ayVar.populateBuilderWithField(aVar5, ayVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dhl.MLL = ayVar;
                    }
                    AppMethodBeat.o(72565);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ehj ehj = new ehj();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ehj.populateBuilderWithField(aVar6, ehj, dpc.getNextFieldNumber(aVar6))) {
                        }
                        dhl.MLM = ehj;
                    }
                    AppMethodBeat.o(72565);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        ddf ddf = new ddf();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = ddf.populateBuilderWithField(aVar7, ddf, dpc.getNextFieldNumber(aVar7))) {
                        }
                        dhl.MLN = ddf;
                    }
                    AppMethodBeat.o(72565);
                    return 0;
                case 9:
                    dhl.MLO = aVar3.UbS.readString();
                    AppMethodBeat.o(72565);
                    return 0;
                case 100:
                    dhl.HuS = aVar3.UbS.readString();
                    AppMethodBeat.o(72565);
                    return 0;
                default:
                    AppMethodBeat.o(72565);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72565);
            return -1;
        }
    }
}
