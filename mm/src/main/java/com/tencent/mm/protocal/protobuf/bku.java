package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bku extends dpc {
    public String LTF;
    public vc LTG;
    public int LTH;
    public dtc LTI;
    public String pTY;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(114023);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(114023);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.pTY != null) {
                aVar.e(2, this.pTY);
            }
            if (this.LTF != null) {
                aVar.e(3, this.LTF);
            }
            if (this.LTG != null) {
                aVar.ni(4, this.LTG.computeSize());
                this.LTG.writeFields(aVar);
            }
            aVar.aM(5, this.LTH);
            if (this.LTI != null) {
                aVar.ni(6, this.LTI.computeSize());
                this.LTI.writeFields(aVar);
            }
            AppMethodBeat.o(114023);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.pTY != null) {
                nh += g.a.a.b.b.a.f(2, this.pTY);
            }
            if (this.LTF != null) {
                nh += g.a.a.b.b.a.f(3, this.LTF);
            }
            if (this.LTG != null) {
                nh += g.a.a.a.nh(4, this.LTG.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.LTH);
            if (this.LTI != null) {
                bu += g.a.a.a.nh(6, this.LTI.computeSize());
            }
            AppMethodBeat.o(114023);
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
                AppMethodBeat.o(114023);
                throw bVar2;
            }
            AppMethodBeat.o(114023);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bku bku = (bku) objArr[1];
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
                        bku.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(114023);
                    return 0;
                case 2:
                    bku.pTY = aVar3.UbS.readString();
                    AppMethodBeat.o(114023);
                    return 0;
                case 3:
                    bku.LTF = aVar3.UbS.readString();
                    AppMethodBeat.o(114023);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        vc vcVar = new vc();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = vcVar.populateBuilderWithField(aVar5, vcVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bku.LTG = vcVar;
                    }
                    AppMethodBeat.o(114023);
                    return 0;
                case 5:
                    bku.LTH = aVar3.UbS.zi();
                    AppMethodBeat.o(114023);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dtc dtc = new dtc();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dtc.populateBuilderWithField(aVar6, dtc, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bku.LTI = dtc;
                    }
                    AppMethodBeat.o(114023);
                    return 0;
                default:
                    AppMethodBeat.o(114023);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114023);
            return -1;
        }
    }
}
