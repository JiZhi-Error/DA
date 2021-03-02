package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aut extends a {
    public long LFA;
    public b LFB;
    public ava LFC;
    public LinkedList<avn> LFD = new LinkedList<>();
    public avn LFE;
    public String LFF;
    public String LFr;
    public avn LFz;
    public long seq;
    public String session_id;
    public int ybm;

    public aut() {
        AppMethodBeat.i(209485);
        AppMethodBeat.o(209485);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209486);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LFz != null) {
                aVar.ni(1, this.LFz.computeSize());
                this.LFz.writeFields(aVar);
            }
            aVar.aM(2, this.ybm);
            if (this.LFr != null) {
                aVar.e(3, this.LFr);
            }
            aVar.bb(4, this.LFA);
            if (this.LFB != null) {
                aVar.c(5, this.LFB);
            }
            if (this.LFC != null) {
                aVar.ni(6, this.LFC.computeSize());
                this.LFC.writeFields(aVar);
            }
            aVar.e(7, 8, this.LFD);
            if (this.session_id != null) {
                aVar.e(51, this.session_id);
            }
            aVar.bb(101, this.seq);
            if (this.LFE != null) {
                aVar.ni(102, this.LFE.computeSize());
                this.LFE.writeFields(aVar);
            }
            if (this.LFF != null) {
                aVar.e(103, this.LFF);
            }
            AppMethodBeat.o(209486);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.LFz != null ? g.a.a.a.nh(1, this.LFz.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.ybm);
            if (this.LFr != null) {
                nh += g.a.a.b.b.a.f(3, this.LFr);
            }
            int r = nh + g.a.a.b.b.a.r(4, this.LFA);
            if (this.LFB != null) {
                r += g.a.a.b.b.a.b(5, this.LFB);
            }
            if (this.LFC != null) {
                r += g.a.a.a.nh(6, this.LFC.computeSize());
            }
            int c2 = r + g.a.a.a.c(7, 8, this.LFD);
            if (this.session_id != null) {
                c2 += g.a.a.b.b.a.f(51, this.session_id);
            }
            int r2 = c2 + g.a.a.b.b.a.r(101, this.seq);
            if (this.LFE != null) {
                r2 += g.a.a.a.nh(102, this.LFE.computeSize());
            }
            if (this.LFF != null) {
                r2 += g.a.a.b.b.a.f(103, this.LFF);
            }
            AppMethodBeat.o(209486);
            return r2;
        } else if (i2 == 2) {
            this.LFD.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209486);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aut aut = (aut) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        avn avn = new avn();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = avn.populateBuilderWithField(aVar4, avn, a.getNextFieldNumber(aVar4))) {
                        }
                        aut.LFz = avn;
                    }
                    AppMethodBeat.o(209486);
                    return 0;
                case 2:
                    aut.ybm = aVar3.UbS.zi();
                    AppMethodBeat.o(209486);
                    return 0;
                case 3:
                    aut.LFr = aVar3.UbS.readString();
                    AppMethodBeat.o(209486);
                    return 0;
                case 4:
                    aut.LFA = aVar3.UbS.zl();
                    AppMethodBeat.o(209486);
                    return 0;
                case 5:
                    aut.LFB = aVar3.UbS.hPo();
                    AppMethodBeat.o(209486);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ava ava = new ava();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ava.populateBuilderWithField(aVar5, ava, a.getNextFieldNumber(aVar5))) {
                        }
                        aut.LFC = ava;
                    }
                    AppMethodBeat.o(209486);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        avn avn2 = new avn();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = avn2.populateBuilderWithField(aVar6, avn2, a.getNextFieldNumber(aVar6))) {
                        }
                        aut.LFD.add(avn2);
                    }
                    AppMethodBeat.o(209486);
                    return 0;
                case 51:
                    aut.session_id = aVar3.UbS.readString();
                    AppMethodBeat.o(209486);
                    return 0;
                case 101:
                    aut.seq = aVar3.UbS.zl();
                    AppMethodBeat.o(209486);
                    return 0;
                case 102:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        avn avn3 = new avn();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = avn3.populateBuilderWithField(aVar7, avn3, a.getNextFieldNumber(aVar7))) {
                        }
                        aut.LFE = avn3;
                    }
                    AppMethodBeat.o(209486);
                    return 0;
                case 103:
                    aut.LFF = aVar3.UbS.readString();
                    AppMethodBeat.o(209486);
                    return 0;
                default:
                    AppMethodBeat.o(209486);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209486);
            return -1;
        }
    }
}
