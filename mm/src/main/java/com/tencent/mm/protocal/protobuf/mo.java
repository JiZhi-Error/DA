package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class mo extends a {
    public tc KQK;
    public tc KQL;
    public tc KQM;
    public SKBuiltinBuffer_t KQN;
    public SKBuiltinBuffer_t KQO;
    public tc KQP;
    public int KQQ;
    public tb KQR;
    public tb KQS;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104359);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KQK != null) {
                aVar.ni(1, this.KQK.computeSize());
                this.KQK.writeFields(aVar);
            }
            if (this.KQL != null) {
                aVar.ni(2, this.KQL.computeSize());
                this.KQL.writeFields(aVar);
            }
            if (this.KQM != null) {
                aVar.ni(4, this.KQM.computeSize());
                this.KQM.writeFields(aVar);
            }
            if (this.KQN != null) {
                aVar.ni(5, this.KQN.computeSize());
                this.KQN.writeFields(aVar);
            }
            if (this.KQO != null) {
                aVar.ni(6, this.KQO.computeSize());
                this.KQO.writeFields(aVar);
            }
            if (this.KQP != null) {
                aVar.ni(7, this.KQP.computeSize());
                this.KQP.writeFields(aVar);
            }
            aVar.aM(8, this.KQQ);
            if (this.KQR != null) {
                aVar.ni(9, this.KQR.computeSize());
                this.KQR.writeFields(aVar);
            }
            if (this.KQS != null) {
                aVar.ni(10, this.KQS.computeSize());
                this.KQS.writeFields(aVar);
            }
            AppMethodBeat.o(104359);
            return 0;
        } else if (i2 == 1) {
            int nh = this.KQK != null ? g.a.a.a.nh(1, this.KQK.computeSize()) + 0 : 0;
            if (this.KQL != null) {
                nh += g.a.a.a.nh(2, this.KQL.computeSize());
            }
            if (this.KQM != null) {
                nh += g.a.a.a.nh(4, this.KQM.computeSize());
            }
            if (this.KQN != null) {
                nh += g.a.a.a.nh(5, this.KQN.computeSize());
            }
            if (this.KQO != null) {
                nh += g.a.a.a.nh(6, this.KQO.computeSize());
            }
            if (this.KQP != null) {
                nh += g.a.a.a.nh(7, this.KQP.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(8, this.KQQ);
            if (this.KQR != null) {
                bu += g.a.a.a.nh(9, this.KQR.computeSize());
            }
            if (this.KQS != null) {
                bu += g.a.a.a.nh(10, this.KQS.computeSize());
            }
            AppMethodBeat.o(104359);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(104359);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            mo moVar = (mo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        tc tcVar = new tc();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = tcVar.populateBuilderWithField(aVar4, tcVar, a.getNextFieldNumber(aVar4))) {
                        }
                        moVar.KQK = tcVar;
                    }
                    AppMethodBeat.o(104359);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        tc tcVar2 = new tc();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = tcVar2.populateBuilderWithField(aVar5, tcVar2, a.getNextFieldNumber(aVar5))) {
                        }
                        moVar.KQL = tcVar2;
                    }
                    AppMethodBeat.o(104359);
                    return 0;
                case 3:
                default:
                    AppMethodBeat.o(104359);
                    return -1;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        tc tcVar3 = new tc();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = tcVar3.populateBuilderWithField(aVar6, tcVar3, a.getNextFieldNumber(aVar6))) {
                        }
                        moVar.KQM = tcVar3;
                    }
                    AppMethodBeat.o(104359);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = sKBuiltinBuffer_t.populateBuilderWithField(aVar7, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar7))) {
                        }
                        moVar.KQN = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(104359);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar8, sKBuiltinBuffer_t2, a.getNextFieldNumber(aVar8))) {
                        }
                        moVar.KQO = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(104359);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        tc tcVar4 = new tc();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = tcVar4.populateBuilderWithField(aVar9, tcVar4, a.getNextFieldNumber(aVar9))) {
                        }
                        moVar.KQP = tcVar4;
                    }
                    AppMethodBeat.o(104359);
                    return 0;
                case 8:
                    moVar.KQQ = aVar3.UbS.zi();
                    AppMethodBeat.o(104359);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        tb tbVar = new tb();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = tbVar.populateBuilderWithField(aVar10, tbVar, a.getNextFieldNumber(aVar10))) {
                        }
                        moVar.KQR = tbVar;
                    }
                    AppMethodBeat.o(104359);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        tb tbVar2 = new tb();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = tbVar2.populateBuilderWithField(aVar11, tbVar2, a.getNextFieldNumber(aVar11))) {
                        }
                        moVar.KQS = tbVar2;
                    }
                    AppMethodBeat.o(104359);
                    return 0;
            }
        } else {
            AppMethodBeat.o(104359);
            return -1;
        }
    }
}
