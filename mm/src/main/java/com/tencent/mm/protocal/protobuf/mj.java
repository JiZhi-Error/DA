package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class mj extends dop {
    public SKBuiltinBuffer_t KNX;
    public String KPU;
    public String KPV;
    public SKBuiltinBuffer_t KQA;
    public int KQB;
    public String KQi;
    public int KQu;
    public String KQv;
    public String KQw;
    public String KQx;
    public int KQy;
    public dqi KQz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(155396);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.KQu);
            if (this.KQi != null) {
                aVar.e(3, this.KQi);
            }
            if (this.KQv != null) {
                aVar.e(4, this.KQv);
            }
            if (this.KQw != null) {
                aVar.e(5, this.KQw);
            }
            if (this.KQx != null) {
                aVar.e(6, this.KQx);
            }
            aVar.aM(7, this.KQy);
            if (this.KQz != null) {
                aVar.ni(8, this.KQz.computeSize());
                this.KQz.writeFields(aVar);
            }
            if (this.KQA != null) {
                aVar.ni(9, this.KQA.computeSize());
                this.KQA.writeFields(aVar);
            }
            aVar.aM(10, this.KQB);
            if (this.KPU != null) {
                aVar.e(11, this.KPU);
            }
            if (this.KPV != null) {
                aVar.e(12, this.KPV);
            }
            if (this.KNX != null) {
                aVar.ni(13, this.KNX.computeSize());
                this.KNX.writeFields(aVar);
            }
            AppMethodBeat.o(155396);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KQu);
            if (this.KQi != null) {
                nh += g.a.a.b.b.a.f(3, this.KQi);
            }
            if (this.KQv != null) {
                nh += g.a.a.b.b.a.f(4, this.KQv);
            }
            if (this.KQw != null) {
                nh += g.a.a.b.b.a.f(5, this.KQw);
            }
            if (this.KQx != null) {
                nh += g.a.a.b.b.a.f(6, this.KQx);
            }
            int bu = nh + g.a.a.b.b.a.bu(7, this.KQy);
            if (this.KQz != null) {
                bu += g.a.a.a.nh(8, this.KQz.computeSize());
            }
            if (this.KQA != null) {
                bu += g.a.a.a.nh(9, this.KQA.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(10, this.KQB);
            if (this.KPU != null) {
                bu2 += g.a.a.b.b.a.f(11, this.KPU);
            }
            if (this.KPV != null) {
                bu2 += g.a.a.b.b.a.f(12, this.KPV);
            }
            if (this.KNX != null) {
                bu2 += g.a.a.a.nh(13, this.KNX.computeSize());
            }
            AppMethodBeat.o(155396);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(155396);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            mj mjVar = (mj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        mjVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(155396);
                    return 0;
                case 2:
                    mjVar.KQu = aVar3.UbS.zi();
                    AppMethodBeat.o(155396);
                    return 0;
                case 3:
                    mjVar.KQi = aVar3.UbS.readString();
                    AppMethodBeat.o(155396);
                    return 0;
                case 4:
                    mjVar.KQv = aVar3.UbS.readString();
                    AppMethodBeat.o(155396);
                    return 0;
                case 5:
                    mjVar.KQw = aVar3.UbS.readString();
                    AppMethodBeat.o(155396);
                    return 0;
                case 6:
                    mjVar.KQx = aVar3.UbS.readString();
                    AppMethodBeat.o(155396);
                    return 0;
                case 7:
                    mjVar.KQy = aVar3.UbS.zi();
                    AppMethodBeat.o(155396);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi.populateBuilderWithField(aVar5, dqi, dop.getNextFieldNumber(aVar5))) {
                        }
                        mjVar.KQz = dqi;
                    }
                    AppMethodBeat.o(155396);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t.populateBuilderWithField(aVar6, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar6))) {
                        }
                        mjVar.KQA = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(155396);
                    return 0;
                case 10:
                    mjVar.KQB = aVar3.UbS.zi();
                    AppMethodBeat.o(155396);
                    return 0;
                case 11:
                    mjVar.KPU = aVar3.UbS.readString();
                    AppMethodBeat.o(155396);
                    return 0;
                case 12:
                    mjVar.KPV = aVar3.UbS.readString();
                    AppMethodBeat.o(155396);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar7, sKBuiltinBuffer_t2, dop.getNextFieldNumber(aVar7))) {
                        }
                        mjVar.KNX = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(155396);
                    return 0;
                default:
                    AppMethodBeat.o(155396);
                    return -1;
            }
        } else {
            AppMethodBeat.o(155396);
            return -1;
        }
    }
}
