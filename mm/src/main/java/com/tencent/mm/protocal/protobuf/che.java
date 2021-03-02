package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class che extends dpc {
    public ys MmA;
    public fck MmB;
    public dfy MmC;
    public bh MmD;
    public cxi MmE;
    public cgz Mmz;
    public String dNI;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123625);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(123625);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.Mmz != null) {
                aVar.ni(2, this.Mmz.computeSize());
                this.Mmz.writeFields(aVar);
            }
            if (this.MmA != null) {
                aVar.ni(3, this.MmA.computeSize());
                this.MmA.writeFields(aVar);
            }
            if (this.MmB != null) {
                aVar.ni(4, this.MmB.computeSize());
                this.MmB.writeFields(aVar);
            }
            if (this.MmC != null) {
                aVar.ni(5, this.MmC.computeSize());
                this.MmC.writeFields(aVar);
            }
            if (this.MmD != null) {
                aVar.ni(6, this.MmD.computeSize());
                this.MmD.writeFields(aVar);
            }
            if (this.MmE != null) {
                aVar.ni(7, this.MmE.computeSize());
                this.MmE.writeFields(aVar);
            }
            if (this.dNI != null) {
                aVar.e(8, this.dNI);
            }
            AppMethodBeat.o(123625);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.Mmz != null) {
                nh += g.a.a.a.nh(2, this.Mmz.computeSize());
            }
            if (this.MmA != null) {
                nh += g.a.a.a.nh(3, this.MmA.computeSize());
            }
            if (this.MmB != null) {
                nh += g.a.a.a.nh(4, this.MmB.computeSize());
            }
            if (this.MmC != null) {
                nh += g.a.a.a.nh(5, this.MmC.computeSize());
            }
            if (this.MmD != null) {
                nh += g.a.a.a.nh(6, this.MmD.computeSize());
            }
            if (this.MmE != null) {
                nh += g.a.a.a.nh(7, this.MmE.computeSize());
            }
            if (this.dNI != null) {
                nh += g.a.a.b.b.a.f(8, this.dNI);
            }
            AppMethodBeat.o(123625);
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
                AppMethodBeat.o(123625);
                throw bVar2;
            }
            AppMethodBeat.o(123625);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            che che = (che) objArr[1];
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
                        che.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(123625);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cgz cgz = new cgz();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cgz.populateBuilderWithField(aVar5, cgz, dpc.getNextFieldNumber(aVar5))) {
                        }
                        che.Mmz = cgz;
                    }
                    AppMethodBeat.o(123625);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ys ysVar = new ys();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ysVar.populateBuilderWithField(aVar6, ysVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        che.MmA = ysVar;
                    }
                    AppMethodBeat.o(123625);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        fck fck = new fck();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = fck.populateBuilderWithField(aVar7, fck, dpc.getNextFieldNumber(aVar7))) {
                        }
                        che.MmB = fck;
                    }
                    AppMethodBeat.o(123625);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dfy dfy = new dfy();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dfy.populateBuilderWithField(aVar8, dfy, dpc.getNextFieldNumber(aVar8))) {
                        }
                        che.MmC = dfy;
                    }
                    AppMethodBeat.o(123625);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        bh bhVar = new bh();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = bhVar.populateBuilderWithField(aVar9, bhVar, dpc.getNextFieldNumber(aVar9))) {
                        }
                        che.MmD = bhVar;
                    }
                    AppMethodBeat.o(123625);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        cxi cxi = new cxi();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = cxi.populateBuilderWithField(aVar10, cxi, dpc.getNextFieldNumber(aVar10))) {
                        }
                        che.MmE = cxi;
                    }
                    AppMethodBeat.o(123625);
                    return 0;
                case 8:
                    che.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(123625);
                    return 0;
                default:
                    AppMethodBeat.o(123625);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123625);
            return -1;
        }
    }
}
