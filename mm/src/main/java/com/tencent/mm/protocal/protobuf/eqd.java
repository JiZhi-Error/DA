package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class eqd extends dop {
    public SKBuiltinBuffer_t KLP;
    public SKBuiltinBuffer_t KLQ;
    public int KMz;
    public String MbK;
    public int NnF;
    public LinkedList<eqa> NnG = new LinkedList<>();
    public int NnH;
    public LinkedList<Integer> NnI = new LinkedList<>();
    public int NnJ;
    public LinkedList<eqc> NnK = new LinkedList<>();
    public int NnL;

    public eqd() {
        AppMethodBeat.i(152726);
        AppMethodBeat.o(152726);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152727);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.KMz);
            aVar.aM(3, this.NnF);
            aVar.e(4, 8, this.NnG);
            if (this.MbK != null) {
                aVar.e(5, this.MbK);
            }
            aVar.aM(6, this.NnH);
            aVar.f(7, 2, this.NnI);
            aVar.aM(8, this.NnJ);
            aVar.e(9, 8, this.NnK);
            if (this.KLP != null) {
                aVar.ni(10, this.KLP.computeSize());
                this.KLP.writeFields(aVar);
            }
            if (this.KLQ != null) {
                aVar.ni(11, this.KLQ.computeSize());
                this.KLQ.writeFields(aVar);
            }
            aVar.aM(12, this.NnL);
            AppMethodBeat.o(152727);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KMz) + g.a.a.b.b.a.bu(3, this.NnF) + g.a.a.a.c(4, 8, this.NnG);
            if (this.MbK != null) {
                nh += g.a.a.b.b.a.f(5, this.MbK);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.NnH) + g.a.a.a.d(7, 2, this.NnI) + g.a.a.b.b.a.bu(8, this.NnJ) + g.a.a.a.c(9, 8, this.NnK);
            if (this.KLP != null) {
                bu += g.a.a.a.nh(10, this.KLP.computeSize());
            }
            if (this.KLQ != null) {
                bu += g.a.a.a.nh(11, this.KLQ.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(12, this.NnL);
            AppMethodBeat.o(152727);
            return bu2;
        } else if (i2 == 2) {
            this.NnG.clear();
            this.NnI.clear();
            this.NnK.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152727);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eqd eqd = (eqd) objArr[1];
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
                        eqd.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(152727);
                    return 0;
                case 2:
                    eqd.KMz = aVar3.UbS.zi();
                    AppMethodBeat.o(152727);
                    return 0;
                case 3:
                    eqd.NnF = aVar3.UbS.zi();
                    AppMethodBeat.o(152727);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eqa eqa = new eqa();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eqa.populateBuilderWithField(aVar5, eqa, dop.getNextFieldNumber(aVar5))) {
                        }
                        eqd.NnG.add(eqa);
                    }
                    AppMethodBeat.o(152727);
                    return 0;
                case 5:
                    eqd.MbK = aVar3.UbS.readString();
                    AppMethodBeat.o(152727);
                    return 0;
                case 6:
                    eqd.NnH = aVar3.UbS.zi();
                    AppMethodBeat.o(152727);
                    return 0;
                case 7:
                    eqd.NnI = new g.a.a.a.a(aVar3.UbS.hPo().zy, unknownTagHandler).UbS.hPm();
                    AppMethodBeat.o(152727);
                    return 0;
                case 8:
                    eqd.NnJ = aVar3.UbS.zi();
                    AppMethodBeat.o(152727);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        eqc eqc = new eqc();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = eqc.populateBuilderWithField(aVar6, eqc, dop.getNextFieldNumber(aVar6))) {
                        }
                        eqd.NnK.add(eqc);
                    }
                    AppMethodBeat.o(152727);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = sKBuiltinBuffer_t.populateBuilderWithField(aVar7, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar7))) {
                        }
                        eqd.KLP = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(152727);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar8, sKBuiltinBuffer_t2, dop.getNextFieldNumber(aVar8))) {
                        }
                        eqd.KLQ = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(152727);
                    return 0;
                case 12:
                    eqd.NnL = aVar3.UbS.zi();
                    AppMethodBeat.o(152727);
                    return 0;
                default:
                    AppMethodBeat.o(152727);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152727);
            return -1;
        }
    }
}
