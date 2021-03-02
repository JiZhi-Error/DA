package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class asn extends dop {
    public String LAt;
    public apc LAv;
    public long LDu;
    public int dLS;
    public b lastBuffer;
    public String tvp;
    public aov uli;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168985);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.bb(2, this.LDu);
            if (this.LAt != null) {
                aVar.e(3, this.LAt);
            }
            if (this.lastBuffer != null) {
                aVar.c(4, this.lastBuffer);
            }
            if (this.uli != null) {
                aVar.ni(5, this.uli.computeSize());
                this.uli.writeFields(aVar);
            }
            if (this.tvp != null) {
                aVar.e(6, this.tvp);
            }
            aVar.aM(7, this.dLS);
            if (this.LAv != null) {
                aVar.ni(8, this.LAv.computeSize());
                this.LAv.writeFields(aVar);
            }
            AppMethodBeat.o(168985);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.LDu);
            if (this.LAt != null) {
                nh += g.a.a.b.b.a.f(3, this.LAt);
            }
            if (this.lastBuffer != null) {
                nh += g.a.a.b.b.a.b(4, this.lastBuffer);
            }
            if (this.uli != null) {
                nh += g.a.a.a.nh(5, this.uli.computeSize());
            }
            if (this.tvp != null) {
                nh += g.a.a.b.b.a.f(6, this.tvp);
            }
            int bu = nh + g.a.a.b.b.a.bu(7, this.dLS);
            if (this.LAv != null) {
                bu += g.a.a.a.nh(8, this.LAv.computeSize());
            }
            AppMethodBeat.o(168985);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168985);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            asn asn = (asn) objArr[1];
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
                        asn.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(168985);
                    return 0;
                case 2:
                    asn.LDu = aVar3.UbS.zl();
                    AppMethodBeat.o(168985);
                    return 0;
                case 3:
                    asn.LAt = aVar3.UbS.readString();
                    AppMethodBeat.o(168985);
                    return 0;
                case 4:
                    asn.lastBuffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(168985);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        asn.uli = aov;
                    }
                    AppMethodBeat.o(168985);
                    return 0;
                case 6:
                    asn.tvp = aVar3.UbS.readString();
                    AppMethodBeat.o(168985);
                    return 0;
                case 7:
                    asn.dLS = aVar3.UbS.zi();
                    AppMethodBeat.o(168985);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        apc apc = new apc();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = apc.populateBuilderWithField(aVar6, apc, dop.getNextFieldNumber(aVar6))) {
                        }
                        asn.LAv = apc;
                    }
                    AppMethodBeat.o(168985);
                    return 0;
                default:
                    AppMethodBeat.o(168985);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168985);
            return -1;
        }
    }
}
