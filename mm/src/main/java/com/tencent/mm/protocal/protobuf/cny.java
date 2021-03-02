package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cny extends dop {
    public String LOd;
    public cnh MtV;
    public b Muo;
    public cnk Mup;
    public float dTj;
    public String dkU;
    public String dkV;
    public b lastBuffer;
    public float latitude;
    public int scene;
    public long twJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209755);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.MtV != null) {
                aVar.ni(2, this.MtV.computeSize());
                this.MtV.writeFields(aVar);
            }
            if (this.lastBuffer != null) {
                aVar.c(3, this.lastBuffer);
            }
            aVar.bb(4, this.twJ);
            aVar.E(6, this.dTj);
            aVar.E(7, this.latitude);
            if (this.LOd != null) {
                aVar.e(8, this.LOd);
            }
            aVar.aM(10, this.scene);
            if (this.dkU != null) {
                aVar.e(13, this.dkU);
            }
            if (this.dkV != null) {
                aVar.e(14, this.dkV);
            }
            if (this.Muo != null) {
                aVar.c(15, this.Muo);
            }
            if (this.Mup != null) {
                aVar.ni(16, this.Mup.computeSize());
                this.Mup.writeFields(aVar);
            }
            AppMethodBeat.o(209755);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.MtV != null) {
                nh += g.a.a.a.nh(2, this.MtV.computeSize());
            }
            if (this.lastBuffer != null) {
                nh += g.a.a.b.b.a.b(3, this.lastBuffer);
            }
            int r = nh + g.a.a.b.b.a.r(4, this.twJ) + g.a.a.b.b.a.fS(6) + 4 + g.a.a.b.b.a.fS(7) + 4;
            if (this.LOd != null) {
                r += g.a.a.b.b.a.f(8, this.LOd);
            }
            int bu = r + g.a.a.b.b.a.bu(10, this.scene);
            if (this.dkU != null) {
                bu += g.a.a.b.b.a.f(13, this.dkU);
            }
            if (this.dkV != null) {
                bu += g.a.a.b.b.a.f(14, this.dkV);
            }
            if (this.Muo != null) {
                bu += g.a.a.b.b.a.b(15, this.Muo);
            }
            if (this.Mup != null) {
                bu += g.a.a.a.nh(16, this.Mup.computeSize());
            }
            AppMethodBeat.o(209755);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209755);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cny cny = (cny) objArr[1];
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
                        cny.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(209755);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cnh cnh = new cnh();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cnh.populateBuilderWithField(aVar5, cnh, dop.getNextFieldNumber(aVar5))) {
                        }
                        cny.MtV = cnh;
                    }
                    AppMethodBeat.o(209755);
                    return 0;
                case 3:
                    cny.lastBuffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(209755);
                    return 0;
                case 4:
                    cny.twJ = aVar3.UbS.zl();
                    AppMethodBeat.o(209755);
                    return 0;
                case 5:
                case 9:
                case 11:
                case 12:
                default:
                    AppMethodBeat.o(209755);
                    return -1;
                case 6:
                    cny.dTj = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209755);
                    return 0;
                case 7:
                    cny.latitude = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209755);
                    return 0;
                case 8:
                    cny.LOd = aVar3.UbS.readString();
                    AppMethodBeat.o(209755);
                    return 0;
                case 10:
                    cny.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(209755);
                    return 0;
                case 13:
                    cny.dkU = aVar3.UbS.readString();
                    AppMethodBeat.o(209755);
                    return 0;
                case 14:
                    cny.dkV = aVar3.UbS.readString();
                    AppMethodBeat.o(209755);
                    return 0;
                case 15:
                    cny.Muo = aVar3.UbS.hPo();
                    AppMethodBeat.o(209755);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cnk cnk = new cnk();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cnk.populateBuilderWithField(aVar6, cnk, dop.getNextFieldNumber(aVar6))) {
                        }
                        cny.Mup = cnk;
                    }
                    AppMethodBeat.o(209755);
                    return 0;
            }
        } else {
            AppMethodBeat.o(209755);
            return -1;
        }
    }
}
