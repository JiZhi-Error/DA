package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bji extends dpc {
    public b LTa;
    public long LTb;
    public b LTc;
    public ctc LTd;
    public mo LTe;
    public float LTf = 0.5f;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104368);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(104368);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.bb(2, this.LTb);
            if (this.LTc != null) {
                aVar.c(3, this.LTc);
            }
            if (this.LTd != null) {
                aVar.ni(4, this.LTd.computeSize());
                this.LTd.writeFields(aVar);
            }
            if (this.LTe != null) {
                aVar.ni(5, this.LTe.computeSize());
                this.LTe.writeFields(aVar);
            }
            if (this.LTa != null) {
                aVar.c(6, this.LTa);
            }
            aVar.E(7, this.LTf);
            AppMethodBeat.o(104368);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.LTb);
            if (this.LTc != null) {
                nh += g.a.a.b.b.a.b(3, this.LTc);
            }
            if (this.LTd != null) {
                nh += g.a.a.a.nh(4, this.LTd.computeSize());
            }
            if (this.LTe != null) {
                nh += g.a.a.a.nh(5, this.LTe.computeSize());
            }
            if (this.LTa != null) {
                nh += g.a.a.b.b.a.b(6, this.LTa);
            }
            int fS = nh + g.a.a.b.b.a.fS(7) + 4;
            AppMethodBeat.o(104368);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(104368);
                throw bVar2;
            }
            AppMethodBeat.o(104368);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bji bji = (bji) objArr[1];
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
                        bji.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(104368);
                    return 0;
                case 2:
                    bji.LTb = aVar3.UbS.zl();
                    AppMethodBeat.o(104368);
                    return 0;
                case 3:
                    bji.LTc = aVar3.UbS.hPo();
                    AppMethodBeat.o(104368);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ctc ctc = new ctc();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ctc.populateBuilderWithField(aVar5, ctc, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bji.LTd = ctc;
                    }
                    AppMethodBeat.o(104368);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        mo moVar = new mo();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = moVar.populateBuilderWithField(aVar6, moVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bji.LTe = moVar;
                    }
                    AppMethodBeat.o(104368);
                    return 0;
                case 6:
                    bji.LTa = aVar3.UbS.hPo();
                    AppMethodBeat.o(104368);
                    return 0;
                case 7:
                    bji.LTf = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(104368);
                    return 0;
                default:
                    AppMethodBeat.o(104368);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104368);
            return -1;
        }
    }
}
