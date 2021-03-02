package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ewf extends a {
    public SKBuiltinBuffer_t NtO;
    public SKBuiltinBuffer_t NtP;
    public SKBuiltinBuffer_t NtQ;
    public SKBuiltinBuffer_t NtR;
    public SKBuiltinBuffer_t NtS;
    public SKBuiltinBuffer_t NtT;
    public SKBuiltinBuffer_t NtU;
    public SKBuiltinBuffer_t NtV;
    public SKBuiltinBuffer_t NtW;
    public SKBuiltinBuffer_t NtX;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(155542);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NtO != null) {
                aVar.ni(1, this.NtO.computeSize());
                this.NtO.writeFields(aVar);
            }
            if (this.NtP != null) {
                aVar.ni(2, this.NtP.computeSize());
                this.NtP.writeFields(aVar);
            }
            if (this.NtQ != null) {
                aVar.ni(3, this.NtQ.computeSize());
                this.NtQ.writeFields(aVar);
            }
            if (this.NtR != null) {
                aVar.ni(4, this.NtR.computeSize());
                this.NtR.writeFields(aVar);
            }
            if (this.NtS != null) {
                aVar.ni(5, this.NtS.computeSize());
                this.NtS.writeFields(aVar);
            }
            if (this.NtT != null) {
                aVar.ni(6, this.NtT.computeSize());
                this.NtT.writeFields(aVar);
            }
            if (this.NtU != null) {
                aVar.ni(7, this.NtU.computeSize());
                this.NtU.writeFields(aVar);
            }
            if (this.NtV != null) {
                aVar.ni(8, this.NtV.computeSize());
                this.NtV.writeFields(aVar);
            }
            if (this.NtW != null) {
                aVar.ni(9, this.NtW.computeSize());
                this.NtW.writeFields(aVar);
            }
            if (this.NtX != null) {
                aVar.ni(10, this.NtX.computeSize());
                this.NtX.writeFields(aVar);
            }
            AppMethodBeat.o(155542);
            return 0;
        } else if (i2 == 1) {
            int nh = this.NtO != null ? g.a.a.a.nh(1, this.NtO.computeSize()) + 0 : 0;
            if (this.NtP != null) {
                nh += g.a.a.a.nh(2, this.NtP.computeSize());
            }
            if (this.NtQ != null) {
                nh += g.a.a.a.nh(3, this.NtQ.computeSize());
            }
            if (this.NtR != null) {
                nh += g.a.a.a.nh(4, this.NtR.computeSize());
            }
            if (this.NtS != null) {
                nh += g.a.a.a.nh(5, this.NtS.computeSize());
            }
            if (this.NtT != null) {
                nh += g.a.a.a.nh(6, this.NtT.computeSize());
            }
            if (this.NtU != null) {
                nh += g.a.a.a.nh(7, this.NtU.computeSize());
            }
            if (this.NtV != null) {
                nh += g.a.a.a.nh(8, this.NtV.computeSize());
            }
            if (this.NtW != null) {
                nh += g.a.a.a.nh(9, this.NtW.computeSize());
            }
            if (this.NtX != null) {
                nh += g.a.a.a.nh(10, this.NtX.computeSize());
            }
            AppMethodBeat.o(155542);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(155542);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ewf ewf = (ewf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        ewf.NtO = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(155542);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar5, sKBuiltinBuffer_t2, a.getNextFieldNumber(aVar5))) {
                        }
                        ewf.NtP = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(155542);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t3 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t3.populateBuilderWithField(aVar6, sKBuiltinBuffer_t3, a.getNextFieldNumber(aVar6))) {
                        }
                        ewf.NtQ = sKBuiltinBuffer_t3;
                    }
                    AppMethodBeat.o(155542);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t4 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = sKBuiltinBuffer_t4.populateBuilderWithField(aVar7, sKBuiltinBuffer_t4, a.getNextFieldNumber(aVar7))) {
                        }
                        ewf.NtR = sKBuiltinBuffer_t4;
                    }
                    AppMethodBeat.o(155542);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t5 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = sKBuiltinBuffer_t5.populateBuilderWithField(aVar8, sKBuiltinBuffer_t5, a.getNextFieldNumber(aVar8))) {
                        }
                        ewf.NtS = sKBuiltinBuffer_t5;
                    }
                    AppMethodBeat.o(155542);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t6 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = sKBuiltinBuffer_t6.populateBuilderWithField(aVar9, sKBuiltinBuffer_t6, a.getNextFieldNumber(aVar9))) {
                        }
                        ewf.NtT = sKBuiltinBuffer_t6;
                    }
                    AppMethodBeat.o(155542);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t7 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = sKBuiltinBuffer_t7.populateBuilderWithField(aVar10, sKBuiltinBuffer_t7, a.getNextFieldNumber(aVar10))) {
                        }
                        ewf.NtU = sKBuiltinBuffer_t7;
                    }
                    AppMethodBeat.o(155542);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t8 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = sKBuiltinBuffer_t8.populateBuilderWithField(aVar11, sKBuiltinBuffer_t8, a.getNextFieldNumber(aVar11))) {
                        }
                        ewf.NtV = sKBuiltinBuffer_t8;
                    }
                    AppMethodBeat.o(155542);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t9 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = sKBuiltinBuffer_t9.populateBuilderWithField(aVar12, sKBuiltinBuffer_t9, a.getNextFieldNumber(aVar12))) {
                        }
                        ewf.NtW = sKBuiltinBuffer_t9;
                    }
                    AppMethodBeat.o(155542);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t10 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = sKBuiltinBuffer_t10.populateBuilderWithField(aVar13, sKBuiltinBuffer_t10, a.getNextFieldNumber(aVar13))) {
                        }
                        ewf.NtX = sKBuiltinBuffer_t10;
                    }
                    AppMethodBeat.o(155542);
                    return 0;
                default:
                    AppMethodBeat.o(155542);
                    return -1;
            }
        } else {
            AppMethodBeat.o(155542);
            return -1;
        }
    }
}
