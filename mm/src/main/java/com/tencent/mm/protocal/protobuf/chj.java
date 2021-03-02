package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class chj extends a {
    public String AAG;
    public float AAH;
    public int AAI;
    public LinkedList<Integer> AAJ = new LinkedList<>();
    public int AAK;
    public LinkedList<dqi> AAL = new LinkedList<>();
    public float AAM;
    public String AAN;
    public SKBuiltinBuffer_t AAO;
    public String MmT;
    public SKBuiltinBuffer_t MmU;
    public int MmV;
    public int MmW;
    public String Title;
    public int oUv;

    public chj() {
        AppMethodBeat.i(116338);
        AppMethodBeat.o(116338);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(116339);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.AAG != null) {
                aVar.e(1, this.AAG);
            }
            if (this.Title != null) {
                aVar.e(2, this.Title);
            }
            aVar.E(3, this.AAH);
            aVar.aM(4, this.AAI);
            aVar.f(5, 2, this.AAJ);
            aVar.aM(6, this.AAK);
            aVar.e(7, 8, this.AAL);
            aVar.E(8, this.AAM);
            if (this.AAN != null) {
                aVar.e(9, this.AAN);
            }
            aVar.aM(10, this.oUv);
            if (this.AAO != null) {
                aVar.ni(11, this.AAO.computeSize());
                this.AAO.writeFields(aVar);
            }
            if (this.MmT != null) {
                aVar.e(12, this.MmT);
            }
            if (this.MmU != null) {
                aVar.ni(13, this.MmU.computeSize());
                this.MmU.writeFields(aVar);
            }
            aVar.aM(14, this.MmV);
            aVar.aM(15, this.MmW);
            AppMethodBeat.o(116339);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.AAG != null ? g.a.a.b.b.a.f(1, this.AAG) + 0 : 0;
            if (this.Title != null) {
                f2 += g.a.a.b.b.a.f(2, this.Title);
            }
            int fS = f2 + g.a.a.b.b.a.fS(3) + 4 + g.a.a.b.b.a.bu(4, this.AAI) + g.a.a.a.d(5, 2, this.AAJ) + g.a.a.b.b.a.bu(6, this.AAK) + g.a.a.a.c(7, 8, this.AAL) + g.a.a.b.b.a.fS(8) + 4;
            if (this.AAN != null) {
                fS += g.a.a.b.b.a.f(9, this.AAN);
            }
            int bu = fS + g.a.a.b.b.a.bu(10, this.oUv);
            if (this.AAO != null) {
                bu += g.a.a.a.nh(11, this.AAO.computeSize());
            }
            if (this.MmT != null) {
                bu += g.a.a.b.b.a.f(12, this.MmT);
            }
            if (this.MmU != null) {
                bu += g.a.a.a.nh(13, this.MmU.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(14, this.MmV) + g.a.a.b.b.a.bu(15, this.MmW);
            AppMethodBeat.o(116339);
            return bu2;
        } else if (i2 == 2) {
            this.AAJ.clear();
            this.AAL.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(116339);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            chj chj = (chj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    chj.AAG = aVar3.UbS.readString();
                    AppMethodBeat.o(116339);
                    return 0;
                case 2:
                    chj.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(116339);
                    return 0;
                case 3:
                    chj.AAH = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(116339);
                    return 0;
                case 4:
                    chj.AAI = aVar3.UbS.zi();
                    AppMethodBeat.o(116339);
                    return 0;
                case 5:
                    chj.AAJ = new g.a.a.a.a(aVar3.UbS.hPo().zy, unknownTagHandler).UbS.hPm();
                    AppMethodBeat.o(116339);
                    return 0;
                case 6:
                    chj.AAK = aVar3.UbS.zi();
                    AppMethodBeat.o(116339);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqi.populateBuilderWithField(aVar4, dqi, a.getNextFieldNumber(aVar4))) {
                        }
                        chj.AAL.add(dqi);
                    }
                    AppMethodBeat.o(116339);
                    return 0;
                case 8:
                    chj.AAM = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(116339);
                    return 0;
                case 9:
                    chj.AAN = aVar3.UbS.readString();
                    AppMethodBeat.o(116339);
                    return 0;
                case 10:
                    chj.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(116339);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar5))) {
                        }
                        chj.AAO = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(116339);
                    return 0;
                case 12:
                    chj.MmT = aVar3.UbS.readString();
                    AppMethodBeat.o(116339);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar6, sKBuiltinBuffer_t2, a.getNextFieldNumber(aVar6))) {
                        }
                        chj.MmU = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(116339);
                    return 0;
                case 14:
                    chj.MmV = aVar3.UbS.zi();
                    AppMethodBeat.o(116339);
                    return 0;
                case 15:
                    chj.MmW = aVar3.UbS.zi();
                    AppMethodBeat.o(116339);
                    return 0;
                default:
                    AppMethodBeat.o(116339);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116339);
            return -1;
        }
    }
}
