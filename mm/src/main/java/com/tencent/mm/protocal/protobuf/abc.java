package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class abc extends dpc {
    public String HuS;
    public ckj efB;
    public int pTZ;
    public String pUa;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91421);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91421);
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
            if (this.efB != null) {
                aVar.ni(99, this.efB.computeSize());
                this.efB.writeFields(aVar);
            }
            if (this.HuS != null) {
                aVar.e(100, this.HuS);
            }
            AppMethodBeat.o(91421);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            if (this.efB != null) {
                nh += g.a.a.a.nh(99, this.efB.computeSize());
            }
            if (this.HuS != null) {
                nh += g.a.a.b.b.a.f(100, this.HuS);
            }
            AppMethodBeat.o(91421);
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
                AppMethodBeat.o(91421);
                throw bVar2;
            }
            AppMethodBeat.o(91421);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            abc abc = (abc) objArr[1];
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
                        abc.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91421);
                    return 0;
                case 2:
                    abc.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(91421);
                    return 0;
                case 3:
                    abc.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(91421);
                    return 0;
                case 99:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ckj ckj = new ckj();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ckj.populateBuilderWithField(aVar5, ckj, dpc.getNextFieldNumber(aVar5))) {
                        }
                        abc.efB = ckj;
                    }
                    AppMethodBeat.o(91421);
                    return 0;
                case 100:
                    abc.HuS = aVar3.UbS.readString();
                    AppMethodBeat.o(91421);
                    return 0;
                default:
                    AppMethodBeat.o(91421);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91421);
            return -1;
        }
    }
}
