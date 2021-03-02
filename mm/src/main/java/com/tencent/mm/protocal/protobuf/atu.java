package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class atu extends dop {
    public apc LAv;
    public aov LCA;
    public b LDs;
    public eiz LEE;
    public b LEF;
    public int dLS;
    public String dST;
    public float dTj;
    public int fromType;
    public float latitude;
    public int tTH;
    public String tTQ;
    public long trn;
    public int tvC;
    public bcc tvs;
    public long twp;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168990);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.LCA != null) {
                aVar.ni(2, this.LCA.computeSize());
                this.LCA.writeFields(aVar);
            }
            if (this.LDs != null) {
                aVar.c(3, this.LDs);
            }
            aVar.aM(4, this.tvC);
            if (this.dST != null) {
                aVar.e(5, this.dST);
            }
            aVar.E(6, this.dTj);
            aVar.E(7, this.latitude);
            aVar.bb(8, this.trn);
            aVar.aM(9, this.dLS);
            if (this.LEE != null) {
                aVar.ni(10, this.LEE.computeSize());
                this.LEE.writeFields(aVar);
            }
            if (this.tvs != null) {
                aVar.ni(11, this.tvs.computeSize());
                this.tvs.writeFields(aVar);
            }
            aVar.aM(12, this.fromType);
            if (this.LAv != null) {
                aVar.ni(13, this.LAv.computeSize());
                this.LAv.writeFields(aVar);
            }
            aVar.bb(14, this.twp);
            if (this.LEF != null) {
                aVar.c(15, this.LEF);
            }
            if (this.tTQ != null) {
                aVar.e(16, this.tTQ);
            }
            aVar.aM(17, this.tTH);
            AppMethodBeat.o(168990);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LCA != null) {
                nh += g.a.a.a.nh(2, this.LCA.computeSize());
            }
            if (this.LDs != null) {
                nh += g.a.a.b.b.a.b(3, this.LDs);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.tvC);
            if (this.dST != null) {
                bu += g.a.a.b.b.a.f(5, this.dST);
            }
            int fS = bu + g.a.a.b.b.a.fS(6) + 4 + g.a.a.b.b.a.fS(7) + 4 + g.a.a.b.b.a.r(8, this.trn) + g.a.a.b.b.a.bu(9, this.dLS);
            if (this.LEE != null) {
                fS += g.a.a.a.nh(10, this.LEE.computeSize());
            }
            if (this.tvs != null) {
                fS += g.a.a.a.nh(11, this.tvs.computeSize());
            }
            int bu2 = fS + g.a.a.b.b.a.bu(12, this.fromType);
            if (this.LAv != null) {
                bu2 += g.a.a.a.nh(13, this.LAv.computeSize());
            }
            int r = bu2 + g.a.a.b.b.a.r(14, this.twp);
            if (this.LEF != null) {
                r += g.a.a.b.b.a.b(15, this.LEF);
            }
            if (this.tTQ != null) {
                r += g.a.a.b.b.a.f(16, this.tTQ);
            }
            int bu3 = r + g.a.a.b.b.a.bu(17, this.tTH);
            AppMethodBeat.o(168990);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168990);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            atu atu = (atu) objArr[1];
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
                        atu.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(168990);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        atu.LCA = aov;
                    }
                    AppMethodBeat.o(168990);
                    return 0;
                case 3:
                    atu.LDs = aVar3.UbS.hPo();
                    AppMethodBeat.o(168990);
                    return 0;
                case 4:
                    atu.tvC = aVar3.UbS.zi();
                    AppMethodBeat.o(168990);
                    return 0;
                case 5:
                    atu.dST = aVar3.UbS.readString();
                    AppMethodBeat.o(168990);
                    return 0;
                case 6:
                    atu.dTj = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(168990);
                    return 0;
                case 7:
                    atu.latitude = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(168990);
                    return 0;
                case 8:
                    atu.trn = aVar3.UbS.zl();
                    AppMethodBeat.o(168990);
                    return 0;
                case 9:
                    atu.dLS = aVar3.UbS.zi();
                    AppMethodBeat.o(168990);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        eiz eiz = new eiz();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = eiz.populateBuilderWithField(aVar6, eiz, dop.getNextFieldNumber(aVar6))) {
                        }
                        atu.LEE = eiz;
                    }
                    AppMethodBeat.o(168990);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        bcc bcc = new bcc();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = bcc.populateBuilderWithField(aVar7, bcc, dop.getNextFieldNumber(aVar7))) {
                        }
                        atu.tvs = bcc;
                    }
                    AppMethodBeat.o(168990);
                    return 0;
                case 12:
                    atu.fromType = aVar3.UbS.zi();
                    AppMethodBeat.o(168990);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        apc apc = new apc();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = apc.populateBuilderWithField(aVar8, apc, dop.getNextFieldNumber(aVar8))) {
                        }
                        atu.LAv = apc;
                    }
                    AppMethodBeat.o(168990);
                    return 0;
                case 14:
                    atu.twp = aVar3.UbS.zl();
                    AppMethodBeat.o(168990);
                    return 0;
                case 15:
                    atu.LEF = aVar3.UbS.hPo();
                    AppMethodBeat.o(168990);
                    return 0;
                case 16:
                    atu.tTQ = aVar3.UbS.readString();
                    AppMethodBeat.o(168990);
                    return 0;
                case 17:
                    atu.tTH = aVar3.UbS.zi();
                    AppMethodBeat.o(168990);
                    return 0;
                default:
                    AppMethodBeat.o(168990);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168990);
            return -1;
        }
    }
}
