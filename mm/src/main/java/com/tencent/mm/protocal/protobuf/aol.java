package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aol extends dop {
    public long DIf;
    public String LAt;
    public int LAu;
    public apc LAv;
    public long LAw;
    public String firstPageMD5;
    public b lastBuffer;
    public String tNK;
    public aov uli;
    public String username;
    public int vkj;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209325);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.username != null) {
                aVar.e(2, this.username);
            }
            aVar.bb(3, this.DIf);
            if (this.firstPageMD5 != null) {
                aVar.e(4, this.firstPageMD5);
            }
            if (this.LAt != null) {
                aVar.e(5, this.LAt);
            }
            aVar.aM(6, this.LAu);
            if (this.uli != null) {
                aVar.ni(7, this.uli.computeSize());
                this.uli.writeFields(aVar);
            }
            if (this.lastBuffer != null) {
                aVar.c(8, this.lastBuffer);
            }
            aVar.aM(9, this.vkj);
            if (this.LAv != null) {
                aVar.ni(10, this.LAv.computeSize());
                this.LAv.writeFields(aVar);
            }
            aVar.bb(11, this.LAw);
            if (this.tNK != null) {
                aVar.e(12, this.tNK);
            }
            AppMethodBeat.o(209325);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.username != null) {
                nh += g.a.a.b.b.a.f(2, this.username);
            }
            int r = nh + g.a.a.b.b.a.r(3, this.DIf);
            if (this.firstPageMD5 != null) {
                r += g.a.a.b.b.a.f(4, this.firstPageMD5);
            }
            if (this.LAt != null) {
                r += g.a.a.b.b.a.f(5, this.LAt);
            }
            int bu = r + g.a.a.b.b.a.bu(6, this.LAu);
            if (this.uli != null) {
                bu += g.a.a.a.nh(7, this.uli.computeSize());
            }
            if (this.lastBuffer != null) {
                bu += g.a.a.b.b.a.b(8, this.lastBuffer);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.vkj);
            if (this.LAv != null) {
                bu2 += g.a.a.a.nh(10, this.LAv.computeSize());
            }
            int r2 = bu2 + g.a.a.b.b.a.r(11, this.LAw);
            if (this.tNK != null) {
                r2 += g.a.a.b.b.a.f(12, this.tNK);
            }
            AppMethodBeat.o(209325);
            return r2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209325);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aol aol = (aol) objArr[1];
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
                        aol.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(209325);
                    return 0;
                case 2:
                    aol.username = aVar3.UbS.readString();
                    AppMethodBeat.o(209325);
                    return 0;
                case 3:
                    aol.DIf = aVar3.UbS.zl();
                    AppMethodBeat.o(209325);
                    return 0;
                case 4:
                    aol.firstPageMD5 = aVar3.UbS.readString();
                    AppMethodBeat.o(209325);
                    return 0;
                case 5:
                    aol.LAt = aVar3.UbS.readString();
                    AppMethodBeat.o(209325);
                    return 0;
                case 6:
                    aol.LAu = aVar3.UbS.zi();
                    AppMethodBeat.o(209325);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        aol.uli = aov;
                    }
                    AppMethodBeat.o(209325);
                    return 0;
                case 8:
                    aol.lastBuffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(209325);
                    return 0;
                case 9:
                    aol.vkj = aVar3.UbS.zi();
                    AppMethodBeat.o(209325);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        apc apc = new apc();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = apc.populateBuilderWithField(aVar6, apc, dop.getNextFieldNumber(aVar6))) {
                        }
                        aol.LAv = apc;
                    }
                    AppMethodBeat.o(209325);
                    return 0;
                case 11:
                    aol.LAw = aVar3.UbS.zl();
                    AppMethodBeat.o(209325);
                    return 0;
                case 12:
                    aol.tNK = aVar3.UbS.readString();
                    AppMethodBeat.o(209325);
                    return 0;
                default:
                    AppMethodBeat.o(209325);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209325);
            return -1;
        }
    }
}
