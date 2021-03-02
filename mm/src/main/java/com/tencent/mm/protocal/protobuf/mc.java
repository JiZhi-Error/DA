package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class mc extends dpc {
    public int KHa;
    public cat KPD;
    public cau KPE;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32148);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32148);
                throw bVar;
            } else if (this.KPD == null) {
                b bVar2 = new b("Not all required fields were included: HardDevice");
                AppMethodBeat.o(32148);
                throw bVar2;
            } else if (this.KPE == null) {
                b bVar3 = new b("Not all required fields were included: HardDeviceAttr");
                AppMethodBeat.o(32148);
                throw bVar3;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.KPD != null) {
                    aVar.ni(2, this.KPD.computeSize());
                    this.KPD.writeFields(aVar);
                }
                if (this.KPE != null) {
                    aVar.ni(3, this.KPE.computeSize());
                    this.KPE.writeFields(aVar);
                }
                aVar.aM(4, this.KHa);
                AppMethodBeat.o(32148);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.KPD != null) {
                nh += g.a.a.a.nh(2, this.KPD.computeSize());
            }
            if (this.KPE != null) {
                nh += g.a.a.a.nh(3, this.KPE.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.KHa);
            AppMethodBeat.o(32148);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar4 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32148);
                throw bVar4;
            } else if (this.KPD == null) {
                b bVar5 = new b("Not all required fields were included: HardDevice");
                AppMethodBeat.o(32148);
                throw bVar5;
            } else if (this.KPE == null) {
                b bVar6 = new b("Not all required fields were included: HardDeviceAttr");
                AppMethodBeat.o(32148);
                throw bVar6;
            } else {
                AppMethodBeat.o(32148);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            mc mcVar = (mc) objArr[1];
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
                        mcVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32148);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cat cat = new cat();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cat.populateBuilderWithField(aVar5, cat, dpc.getNextFieldNumber(aVar5))) {
                        }
                        mcVar.KPD = cat;
                    }
                    AppMethodBeat.o(32148);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cau cau = new cau();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cau.populateBuilderWithField(aVar6, cau, dpc.getNextFieldNumber(aVar6))) {
                        }
                        mcVar.KPE = cau;
                    }
                    AppMethodBeat.o(32148);
                    return 0;
                case 4:
                    mcVar.KHa = aVar3.UbS.zi();
                    AppMethodBeat.o(32148);
                    return 0;
                default:
                    AppMethodBeat.o(32148);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32148);
            return -1;
        }
    }
}
