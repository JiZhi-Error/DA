package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ell extends dpc {
    public ctc NkA;
    public ig NkB;
    public int Nkx;
    public hk Nky;
    public ba Nkz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133205);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(133205);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.Nkx);
            if (this.Nky != null) {
                aVar.ni(3, this.Nky.computeSize());
                this.Nky.writeFields(aVar);
            }
            if (this.Nkz != null) {
                aVar.ni(4, this.Nkz.computeSize());
                this.Nkz.writeFields(aVar);
            }
            if (this.NkA != null) {
                aVar.ni(5, this.NkA.computeSize());
                this.NkA.writeFields(aVar);
            }
            if (this.NkB != null) {
                aVar.ni(6, this.NkB.computeSize());
                this.NkB.writeFields(aVar);
            }
            AppMethodBeat.o(133205);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.Nkx);
            if (this.Nky != null) {
                nh += g.a.a.a.nh(3, this.Nky.computeSize());
            }
            if (this.Nkz != null) {
                nh += g.a.a.a.nh(4, this.Nkz.computeSize());
            }
            if (this.NkA != null) {
                nh += g.a.a.a.nh(5, this.NkA.computeSize());
            }
            if (this.NkB != null) {
                nh += g.a.a.a.nh(6, this.NkB.computeSize());
            }
            AppMethodBeat.o(133205);
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
                AppMethodBeat.o(133205);
                throw bVar2;
            }
            AppMethodBeat.o(133205);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ell ell = (ell) objArr[1];
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
                        ell.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(133205);
                    return 0;
                case 2:
                    ell.Nkx = aVar3.UbS.zi();
                    AppMethodBeat.o(133205);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        hk hkVar = new hk();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = hkVar.populateBuilderWithField(aVar5, hkVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ell.Nky = hkVar;
                    }
                    AppMethodBeat.o(133205);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ba baVar = new ba();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = baVar.populateBuilderWithField(aVar6, baVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        ell.Nkz = baVar;
                    }
                    AppMethodBeat.o(133205);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        ctc ctc = new ctc();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = ctc.populateBuilderWithField(aVar7, ctc, dpc.getNextFieldNumber(aVar7))) {
                        }
                        ell.NkA = ctc;
                    }
                    AppMethodBeat.o(133205);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        ig igVar = new ig();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = igVar.populateBuilderWithField(aVar8, igVar, dpc.getNextFieldNumber(aVar8))) {
                        }
                        ell.NkB = igVar;
                    }
                    AppMethodBeat.o(133205);
                    return 0;
                default:
                    AppMethodBeat.o(133205);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133205);
            return -1;
        }
    }
}
