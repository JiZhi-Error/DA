package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class eps extends dop {
    public SKBuiltinBuffer_t KNX;
    public SKBuiltinBuffer_t KQA;
    public String KQv;
    public dqi KQz;
    public int MWU;
    public dqi Mdj;
    public String Nnm;
    public dqi Nnn;
    public int OpCode;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(43133);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.OpCode);
            if (this.Nnm != null) {
                aVar.e(3, this.Nnm);
            }
            if (this.KQv != null) {
                aVar.e(4, this.KQv);
            }
            if (this.Mdj != null) {
                aVar.ni(5, this.Mdj.computeSize());
                this.Mdj.writeFields(aVar);
            }
            if (this.Nnn != null) {
                aVar.ni(6, this.Nnn.computeSize());
                this.Nnn.writeFields(aVar);
            }
            if (this.KQz != null) {
                aVar.ni(7, this.KQz.computeSize());
                this.KQz.writeFields(aVar);
            }
            if (this.KQA != null) {
                aVar.ni(8, this.KQA.computeSize());
                this.KQA.writeFields(aVar);
            }
            aVar.aM(9, this.MWU);
            if (this.KNX != null) {
                aVar.ni(10, this.KNX.computeSize());
                this.KNX.writeFields(aVar);
            }
            AppMethodBeat.o(43133);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.OpCode);
            if (this.Nnm != null) {
                nh += g.a.a.b.b.a.f(3, this.Nnm);
            }
            if (this.KQv != null) {
                nh += g.a.a.b.b.a.f(4, this.KQv);
            }
            if (this.Mdj != null) {
                nh += g.a.a.a.nh(5, this.Mdj.computeSize());
            }
            if (this.Nnn != null) {
                nh += g.a.a.a.nh(6, this.Nnn.computeSize());
            }
            if (this.KQz != null) {
                nh += g.a.a.a.nh(7, this.KQz.computeSize());
            }
            if (this.KQA != null) {
                nh += g.a.a.a.nh(8, this.KQA.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(9, this.MWU);
            if (this.KNX != null) {
                bu += g.a.a.a.nh(10, this.KNX.computeSize());
            }
            AppMethodBeat.o(43133);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(43133);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eps eps = (eps) objArr[1];
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
                        eps.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(43133);
                    return 0;
                case 2:
                    eps.OpCode = aVar3.UbS.zi();
                    AppMethodBeat.o(43133);
                    return 0;
                case 3:
                    eps.Nnm = aVar3.UbS.readString();
                    AppMethodBeat.o(43133);
                    return 0;
                case 4:
                    eps.KQv = aVar3.UbS.readString();
                    AppMethodBeat.o(43133);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi.populateBuilderWithField(aVar5, dqi, dop.getNextFieldNumber(aVar5))) {
                        }
                        eps.Mdj = dqi;
                    }
                    AppMethodBeat.o(43133);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi2.populateBuilderWithField(aVar6, dqi2, dop.getNextFieldNumber(aVar6))) {
                        }
                        eps.Nnn = dqi2;
                    }
                    AppMethodBeat.o(43133);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dqi dqi3 = new dqi();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dqi3.populateBuilderWithField(aVar7, dqi3, dop.getNextFieldNumber(aVar7))) {
                        }
                        eps.KQz = dqi3;
                    }
                    AppMethodBeat.o(43133);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = sKBuiltinBuffer_t.populateBuilderWithField(aVar8, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar8))) {
                        }
                        eps.KQA = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(43133);
                    return 0;
                case 9:
                    eps.MWU = aVar3.UbS.zi();
                    AppMethodBeat.o(43133);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar9, sKBuiltinBuffer_t2, dop.getNextFieldNumber(aVar9))) {
                        }
                        eps.KNX = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(43133);
                    return 0;
                default:
                    AppMethodBeat.o(43133);
                    return -1;
            }
        } else {
            AppMethodBeat.o(43133);
            return -1;
        }
    }
}
