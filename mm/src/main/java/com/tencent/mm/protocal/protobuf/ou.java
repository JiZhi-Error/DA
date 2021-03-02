package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ou extends a {
    public acb KVq;
    public qe KVr;
    public op KVs;
    public qm KVt;
    public qk KVu;
    public ni KVv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124434);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KVq != null) {
                aVar.ni(1, this.KVq.computeSize());
                this.KVq.writeFields(aVar);
            }
            if (this.KVr != null) {
                aVar.ni(2, this.KVr.computeSize());
                this.KVr.writeFields(aVar);
            }
            if (this.KVs != null) {
                aVar.ni(3, this.KVs.computeSize());
                this.KVs.writeFields(aVar);
            }
            if (this.KVt != null) {
                aVar.ni(4, this.KVt.computeSize());
                this.KVt.writeFields(aVar);
            }
            if (this.KVu != null) {
                aVar.ni(5, this.KVu.computeSize());
                this.KVu.writeFields(aVar);
            }
            if (this.KVv != null) {
                aVar.ni(6, this.KVv.computeSize());
                this.KVv.writeFields(aVar);
            }
            AppMethodBeat.o(124434);
            return 0;
        } else if (i2 == 1) {
            int nh = this.KVq != null ? g.a.a.a.nh(1, this.KVq.computeSize()) + 0 : 0;
            if (this.KVr != null) {
                nh += g.a.a.a.nh(2, this.KVr.computeSize());
            }
            if (this.KVs != null) {
                nh += g.a.a.a.nh(3, this.KVs.computeSize());
            }
            if (this.KVt != null) {
                nh += g.a.a.a.nh(4, this.KVt.computeSize());
            }
            if (this.KVu != null) {
                nh += g.a.a.a.nh(5, this.KVu.computeSize());
            }
            if (this.KVv != null) {
                nh += g.a.a.a.nh(6, this.KVv.computeSize());
            }
            AppMethodBeat.o(124434);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124434);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ou ouVar = (ou) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        acb acb = new acb();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = acb.populateBuilderWithField(aVar4, acb, a.getNextFieldNumber(aVar4))) {
                        }
                        ouVar.KVq = acb;
                    }
                    AppMethodBeat.o(124434);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        qe qeVar = new qe();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = qeVar.populateBuilderWithField(aVar5, qeVar, a.getNextFieldNumber(aVar5))) {
                        }
                        ouVar.KVr = qeVar;
                    }
                    AppMethodBeat.o(124434);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        op opVar = new op();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = opVar.populateBuilderWithField(aVar6, opVar, a.getNextFieldNumber(aVar6))) {
                        }
                        ouVar.KVs = opVar;
                    }
                    AppMethodBeat.o(124434);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        qm qmVar = new qm();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = qmVar.populateBuilderWithField(aVar7, qmVar, a.getNextFieldNumber(aVar7))) {
                        }
                        ouVar.KVt = qmVar;
                    }
                    AppMethodBeat.o(124434);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        qk qkVar = new qk();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = qkVar.populateBuilderWithField(aVar8, qkVar, a.getNextFieldNumber(aVar8))) {
                        }
                        ouVar.KVu = qkVar;
                    }
                    AppMethodBeat.o(124434);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        ni niVar = new ni();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = niVar.populateBuilderWithField(aVar9, niVar, a.getNextFieldNumber(aVar9))) {
                        }
                        ouVar.KVv = niVar;
                    }
                    AppMethodBeat.o(124434);
                    return 0;
                default:
                    AppMethodBeat.o(124434);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124434);
            return -1;
        }
    }
}
