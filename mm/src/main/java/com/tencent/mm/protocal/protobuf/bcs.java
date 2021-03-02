package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bcs extends dop {
    public apc LAv;
    public LinkedList<ecq> LEw = new LinkedList<>();
    public long LLM;
    public cnk LLN;
    public String finderUsername;
    public aov uli;

    public bcs() {
        AppMethodBeat.i(169053);
        AppMethodBeat.o(169053);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169054);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 8, this.LEw);
            if (this.finderUsername != null) {
                aVar.e(3, this.finderUsername);
            }
            if (this.uli != null) {
                aVar.ni(4, this.uli.computeSize());
                this.uli.writeFields(aVar);
            }
            if (this.LAv != null) {
                aVar.ni(5, this.LAv.computeSize());
                this.LAv.writeFields(aVar);
            }
            aVar.bb(7, this.LLM);
            if (this.LLN != null) {
                aVar.ni(8, this.LLN.computeSize());
                this.LLN.writeFields(aVar);
            }
            AppMethodBeat.o(169054);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.LEw);
            if (this.finderUsername != null) {
                nh += g.a.a.b.b.a.f(3, this.finderUsername);
            }
            if (this.uli != null) {
                nh += g.a.a.a.nh(4, this.uli.computeSize());
            }
            if (this.LAv != null) {
                nh += g.a.a.a.nh(5, this.LAv.computeSize());
            }
            int r = nh + g.a.a.b.b.a.r(7, this.LLM);
            if (this.LLN != null) {
                r += g.a.a.a.nh(8, this.LLN.computeSize());
            }
            AppMethodBeat.o(169054);
            return r;
        } else if (i2 == 2) {
            this.LEw.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169054);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bcs bcs = (bcs) objArr[1];
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
                        bcs.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(169054);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ecq ecq = new ecq();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ecq.populateBuilderWithField(aVar5, ecq, dop.getNextFieldNumber(aVar5))) {
                        }
                        bcs.LEw.add(ecq);
                    }
                    AppMethodBeat.o(169054);
                    return 0;
                case 3:
                    bcs.finderUsername = aVar3.UbS.readString();
                    AppMethodBeat.o(169054);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = aov.populateBuilderWithField(aVar6, aov, dop.getNextFieldNumber(aVar6))) {
                        }
                        bcs.uli = aov;
                    }
                    AppMethodBeat.o(169054);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        apc apc = new apc();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = apc.populateBuilderWithField(aVar7, apc, dop.getNextFieldNumber(aVar7))) {
                        }
                        bcs.LAv = apc;
                    }
                    AppMethodBeat.o(169054);
                    return 0;
                case 6:
                default:
                    AppMethodBeat.o(169054);
                    return -1;
                case 7:
                    bcs.LLM = aVar3.UbS.zl();
                    AppMethodBeat.o(169054);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        cnk cnk = new cnk();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = cnk.populateBuilderWithField(aVar8, cnk, dop.getNextFieldNumber(aVar8))) {
                        }
                        bcs.LLN = cnk;
                    }
                    AppMethodBeat.o(169054);
                    return 0;
            }
        } else {
            AppMethodBeat.o(169054);
            return -1;
        }
    }
}
