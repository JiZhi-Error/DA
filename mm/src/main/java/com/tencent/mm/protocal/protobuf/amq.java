package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class amq extends a {
    public String LxL;
    public LinkedList<String> LxM = new LinkedList<>();
    public String appId;
    public String dCl;
    public String dRL;
    public anb dXI;
    public String desc;
    public String title;
    public int type;

    public amq() {
        AppMethodBeat.i(127463);
        AppMethodBeat.o(127463);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127464);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            if (this.dRL != null) {
                aVar.e(3, this.dRL);
            }
            if (this.LxL != null) {
                aVar.e(4, this.LxL);
            }
            if (this.appId != null) {
                aVar.e(5, this.appId);
            }
            if (this.dCl != null) {
                aVar.e(6, this.dCl);
            }
            aVar.e(7, 1, this.LxM);
            aVar.aM(8, this.type);
            if (this.dXI != null) {
                aVar.ni(9, this.dXI.computeSize());
                this.dXI.writeFields(aVar);
            }
            AppMethodBeat.o(127464);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.desc != null) {
                f2 += g.a.a.b.b.a.f(2, this.desc);
            }
            if (this.dRL != null) {
                f2 += g.a.a.b.b.a.f(3, this.dRL);
            }
            if (this.LxL != null) {
                f2 += g.a.a.b.b.a.f(4, this.LxL);
            }
            if (this.appId != null) {
                f2 += g.a.a.b.b.a.f(5, this.appId);
            }
            if (this.dCl != null) {
                f2 += g.a.a.b.b.a.f(6, this.dCl);
            }
            int c2 = f2 + g.a.a.a.c(7, 1, this.LxM) + g.a.a.b.b.a.bu(8, this.type);
            if (this.dXI != null) {
                c2 += g.a.a.a.nh(9, this.dXI.computeSize());
            }
            AppMethodBeat.o(127464);
            return c2;
        } else if (i2 == 2) {
            this.LxM.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127464);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            amq amq = (amq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    amq.title = aVar3.UbS.readString();
                    AppMethodBeat.o(127464);
                    return 0;
                case 2:
                    amq.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(127464);
                    return 0;
                case 3:
                    amq.dRL = aVar3.UbS.readString();
                    AppMethodBeat.o(127464);
                    return 0;
                case 4:
                    amq.LxL = aVar3.UbS.readString();
                    AppMethodBeat.o(127464);
                    return 0;
                case 5:
                    amq.appId = aVar3.UbS.readString();
                    AppMethodBeat.o(127464);
                    return 0;
                case 6:
                    amq.dCl = aVar3.UbS.readString();
                    AppMethodBeat.o(127464);
                    return 0;
                case 7:
                    amq.LxM.add(aVar3.UbS.readString());
                    AppMethodBeat.o(127464);
                    return 0;
                case 8:
                    amq.type = aVar3.UbS.zi();
                    AppMethodBeat.o(127464);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        anb anb = new anb();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = anb.populateBuilderWithField(aVar4, anb, a.getNextFieldNumber(aVar4))) {
                        }
                        amq.dXI = anb;
                    }
                    AppMethodBeat.o(127464);
                    return 0;
                default:
                    AppMethodBeat.o(127464);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127464);
            return -1;
        }
    }
}
