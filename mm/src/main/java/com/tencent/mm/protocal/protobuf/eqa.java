package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eqa extends a {
    public String Cyk;
    public int KJS;
    public String LRO;
    public String LRe;
    public String MSG;
    public String NnA;
    public int NnB;
    public SKBuiltinBuffer_t NnC;
    public SKBuiltinBuffer_t NnD;
    public String Nnv;
    public int Nnw;
    public String Nnx;
    public String Nny;
    public int Nnz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152723);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Cyk != null) {
                aVar.e(1, this.Cyk);
            }
            if (this.Nnv != null) {
                aVar.e(2, this.Nnv);
            }
            if (this.LRO != null) {
                aVar.e(3, this.LRO);
            }
            aVar.aM(4, this.Nnw);
            if (this.MSG != null) {
                aVar.e(5, this.MSG);
            }
            if (this.Nnx != null) {
                aVar.e(6, this.Nnx);
            }
            if (this.Nny != null) {
                aVar.e(7, this.Nny);
            }
            aVar.aM(8, this.Nnz);
            if (this.NnA != null) {
                aVar.e(9, this.NnA);
            }
            aVar.aM(10, this.NnB);
            if (this.NnC != null) {
                aVar.ni(11, this.NnC.computeSize());
                this.NnC.writeFields(aVar);
            }
            if (this.LRe != null) {
                aVar.e(12, this.LRe);
            }
            aVar.aM(13, this.KJS);
            if (this.NnD != null) {
                aVar.ni(14, this.NnD.computeSize());
                this.NnD.writeFields(aVar);
            }
            AppMethodBeat.o(152723);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Cyk != null ? g.a.a.b.b.a.f(1, this.Cyk) + 0 : 0;
            if (this.Nnv != null) {
                f2 += g.a.a.b.b.a.f(2, this.Nnv);
            }
            if (this.LRO != null) {
                f2 += g.a.a.b.b.a.f(3, this.LRO);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.Nnw);
            if (this.MSG != null) {
                bu += g.a.a.b.b.a.f(5, this.MSG);
            }
            if (this.Nnx != null) {
                bu += g.a.a.b.b.a.f(6, this.Nnx);
            }
            if (this.Nny != null) {
                bu += g.a.a.b.b.a.f(7, this.Nny);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.Nnz);
            if (this.NnA != null) {
                bu2 += g.a.a.b.b.a.f(9, this.NnA);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(10, this.NnB);
            if (this.NnC != null) {
                bu3 += g.a.a.a.nh(11, this.NnC.computeSize());
            }
            if (this.LRe != null) {
                bu3 += g.a.a.b.b.a.f(12, this.LRe);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(13, this.KJS);
            if (this.NnD != null) {
                bu4 += g.a.a.a.nh(14, this.NnD.computeSize());
            }
            AppMethodBeat.o(152723);
            return bu4;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152723);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eqa eqa = (eqa) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eqa.Cyk = aVar3.UbS.readString();
                    AppMethodBeat.o(152723);
                    return 0;
                case 2:
                    eqa.Nnv = aVar3.UbS.readString();
                    AppMethodBeat.o(152723);
                    return 0;
                case 3:
                    eqa.LRO = aVar3.UbS.readString();
                    AppMethodBeat.o(152723);
                    return 0;
                case 4:
                    eqa.Nnw = aVar3.UbS.zi();
                    AppMethodBeat.o(152723);
                    return 0;
                case 5:
                    eqa.MSG = aVar3.UbS.readString();
                    AppMethodBeat.o(152723);
                    return 0;
                case 6:
                    eqa.Nnx = aVar3.UbS.readString();
                    AppMethodBeat.o(152723);
                    return 0;
                case 7:
                    eqa.Nny = aVar3.UbS.readString();
                    AppMethodBeat.o(152723);
                    return 0;
                case 8:
                    eqa.Nnz = aVar3.UbS.zi();
                    AppMethodBeat.o(152723);
                    return 0;
                case 9:
                    eqa.NnA = aVar3.UbS.readString();
                    AppMethodBeat.o(152723);
                    return 0;
                case 10:
                    eqa.NnB = aVar3.UbS.zi();
                    AppMethodBeat.o(152723);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        eqa.NnC = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(152723);
                    return 0;
                case 12:
                    eqa.LRe = aVar3.UbS.readString();
                    AppMethodBeat.o(152723);
                    return 0;
                case 13:
                    eqa.KJS = aVar3.UbS.zi();
                    AppMethodBeat.o(152723);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar5, sKBuiltinBuffer_t2, a.getNextFieldNumber(aVar5))) {
                        }
                        eqa.NnD = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(152723);
                    return 0;
                default:
                    AppMethodBeat.o(152723);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152723);
            return -1;
        }
    }
}
