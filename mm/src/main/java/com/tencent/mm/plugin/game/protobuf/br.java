package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class br extends dop {
    public String keh;
    public LinkedList<String> xLF = new LinkedList<>();
    public ac xLG;
    public int xLH;
    public boolean xLI;
    public String xLl;
    public int xLm;

    public br() {
        AppMethodBeat.i(41771);
        AppMethodBeat.o(41771);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41772);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.xLl == null) {
                b bVar = new b("Not all required fields were included: Lang");
                AppMethodBeat.o(41772);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.xLl != null) {
                aVar.e(2, this.xLl);
            }
            aVar.e(3, 1, this.xLF);
            if (this.keh != null) {
                aVar.e(4, this.keh);
            }
            if (this.xLG != null) {
                aVar.ni(5, this.xLG.computeSize());
                this.xLG.writeFields(aVar);
            }
            aVar.aM(6, this.xLH);
            aVar.cc(7, this.xLI);
            aVar.aM(8, this.xLm);
            AppMethodBeat.o(41772);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.xLl != null) {
                nh += g.a.a.b.b.a.f(2, this.xLl);
            }
            int c2 = nh + g.a.a.a.c(3, 1, this.xLF);
            if (this.keh != null) {
                c2 += g.a.a.b.b.a.f(4, this.keh);
            }
            if (this.xLG != null) {
                c2 += g.a.a.a.nh(5, this.xLG.computeSize());
            }
            int bu = c2 + g.a.a.b.b.a.bu(6, this.xLH) + g.a.a.b.b.a.fS(7) + 1 + g.a.a.b.b.a.bu(8, this.xLm);
            AppMethodBeat.o(41772);
            return bu;
        } else if (i2 == 2) {
            this.xLF.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.xLl == null) {
                b bVar2 = new b("Not all required fields were included: Lang");
                AppMethodBeat.o(41772);
                throw bVar2;
            }
            AppMethodBeat.o(41772);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            br brVar = (br) objArr[1];
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
                        brVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(41772);
                    return 0;
                case 2:
                    brVar.xLl = aVar3.UbS.readString();
                    AppMethodBeat.o(41772);
                    return 0;
                case 3:
                    brVar.xLF.add(aVar3.UbS.readString());
                    AppMethodBeat.o(41772);
                    return 0;
                case 4:
                    brVar.keh = aVar3.UbS.readString();
                    AppMethodBeat.o(41772);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ac acVar = new ac();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = acVar.populateBuilderWithField(aVar5, acVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        brVar.xLG = acVar;
                    }
                    AppMethodBeat.o(41772);
                    return 0;
                case 6:
                    brVar.xLH = aVar3.UbS.zi();
                    AppMethodBeat.o(41772);
                    return 0;
                case 7:
                    brVar.xLI = aVar3.UbS.yZ();
                    AppMethodBeat.o(41772);
                    return 0;
                case 8:
                    brVar.xLm = aVar3.UbS.zi();
                    AppMethodBeat.o(41772);
                    return 0;
                default:
                    AppMethodBeat.o(41772);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41772);
            return -1;
        }
    }
}
