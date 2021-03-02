package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class jk extends a {
    public SKBuiltinBuffer_t KLe;
    public SKBuiltinBuffer_t KLf;
    public String KLk;
    public SKBuiltinBuffer_t KNX;
    public ewr KNY;
    public fca KNZ;
    public int KOa;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133155);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KNX != null) {
                aVar.ni(1, this.KNX.computeSize());
                this.KNX.writeFields(aVar);
            }
            if (this.KNY != null) {
                aVar.ni(2, this.KNY.computeSize());
                this.KNY.writeFields(aVar);
            }
            if (this.KNZ != null) {
                aVar.ni(3, this.KNZ.computeSize());
                this.KNZ.writeFields(aVar);
            }
            if (this.KLe != null) {
                aVar.ni(4, this.KLe.computeSize());
                this.KLe.writeFields(aVar);
            }
            if (this.KLf != null) {
                aVar.ni(5, this.KLf.computeSize());
                this.KLf.writeFields(aVar);
            }
            aVar.aM(6, this.KOa);
            if (this.KLk != null) {
                aVar.e(7, this.KLk);
            }
            AppMethodBeat.o(133155);
            return 0;
        } else if (i2 == 1) {
            int nh = this.KNX != null ? g.a.a.a.nh(1, this.KNX.computeSize()) + 0 : 0;
            if (this.KNY != null) {
                nh += g.a.a.a.nh(2, this.KNY.computeSize());
            }
            if (this.KNZ != null) {
                nh += g.a.a.a.nh(3, this.KNZ.computeSize());
            }
            if (this.KLe != null) {
                nh += g.a.a.a.nh(4, this.KLe.computeSize());
            }
            if (this.KLf != null) {
                nh += g.a.a.a.nh(5, this.KLf.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.KOa);
            if (this.KLk != null) {
                bu += g.a.a.b.b.a.f(7, this.KLk);
            }
            AppMethodBeat.o(133155);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(133155);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            jk jkVar = (jk) objArr[1];
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
                        jkVar.KNX = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(133155);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ewr ewr = new ewr();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ewr.populateBuilderWithField(aVar5, ewr, a.getNextFieldNumber(aVar5))) {
                        }
                        jkVar.KNY = ewr;
                    }
                    AppMethodBeat.o(133155);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        fca fca = new fca();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = fca.populateBuilderWithField(aVar6, fca, a.getNextFieldNumber(aVar6))) {
                        }
                        jkVar.KNZ = fca;
                    }
                    AppMethodBeat.o(133155);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar7, sKBuiltinBuffer_t2, a.getNextFieldNumber(aVar7))) {
                        }
                        jkVar.KLe = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(133155);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t3 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = sKBuiltinBuffer_t3.populateBuilderWithField(aVar8, sKBuiltinBuffer_t3, a.getNextFieldNumber(aVar8))) {
                        }
                        jkVar.KLf = sKBuiltinBuffer_t3;
                    }
                    AppMethodBeat.o(133155);
                    return 0;
                case 6:
                    jkVar.KOa = aVar3.UbS.zi();
                    AppMethodBeat.o(133155);
                    return 0;
                case 7:
                    jkVar.KLk = aVar3.UbS.readString();
                    AppMethodBeat.o(133155);
                    return 0;
                default:
                    AppMethodBeat.o(133155);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133155);
            return -1;
        }
    }
}
