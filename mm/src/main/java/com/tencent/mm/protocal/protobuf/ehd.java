package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class ehd extends a {
    public int CeB;
    public String CeI;
    public int Cgg;
    public ain Cgj;
    public erc Lce;
    public String text;
    public int textColor;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(140931);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.text == null) {
                b bVar = new b("Not all required fields were included: text");
                AppMethodBeat.o(140931);
                throw bVar;
            } else if (this.Lce == null) {
                b bVar2 = new b("Not all required fields were included: matrix");
                AppMethodBeat.o(140931);
                throw bVar2;
            } else {
                if (this.text != null) {
                    aVar.e(1, this.text);
                }
                aVar.aM(2, this.textColor);
                aVar.aM(3, this.Cgg);
                if (this.Lce != null) {
                    aVar.ni(4, this.Lce.computeSize());
                    this.Lce.writeFields(aVar);
                }
                aVar.aM(5, this.CeB);
                if (this.Cgj != null) {
                    aVar.ni(6, this.Cgj.computeSize());
                    this.Cgj.writeFields(aVar);
                }
                if (this.CeI != null) {
                    aVar.e(7, this.CeI);
                }
                AppMethodBeat.o(140931);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = (this.text != null ? g.a.a.b.b.a.f(1, this.text) + 0 : 0) + g.a.a.b.b.a.bu(2, this.textColor) + g.a.a.b.b.a.bu(3, this.Cgg);
            if (this.Lce != null) {
                f2 += g.a.a.a.nh(4, this.Lce.computeSize());
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.CeB);
            if (this.Cgj != null) {
                bu += g.a.a.a.nh(6, this.Cgj.computeSize());
            }
            if (this.CeI != null) {
                bu += g.a.a.b.b.a.f(7, this.CeI);
            }
            AppMethodBeat.o(140931);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.text == null) {
                b bVar3 = new b("Not all required fields were included: text");
                AppMethodBeat.o(140931);
                throw bVar3;
            } else if (this.Lce == null) {
                b bVar4 = new b("Not all required fields were included: matrix");
                AppMethodBeat.o(140931);
                throw bVar4;
            } else {
                AppMethodBeat.o(140931);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ehd ehd = (ehd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ehd.text = aVar3.UbS.readString();
                    AppMethodBeat.o(140931);
                    return 0;
                case 2:
                    ehd.textColor = aVar3.UbS.zi();
                    AppMethodBeat.o(140931);
                    return 0;
                case 3:
                    ehd.Cgg = aVar3.UbS.zi();
                    AppMethodBeat.o(140931);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        erc erc = new erc();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = erc.populateBuilderWithField(aVar4, erc, a.getNextFieldNumber(aVar4))) {
                        }
                        ehd.Lce = erc;
                    }
                    AppMethodBeat.o(140931);
                    return 0;
                case 5:
                    ehd.CeB = aVar3.UbS.zi();
                    AppMethodBeat.o(140931);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ain ain = new ain();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ain.populateBuilderWithField(aVar5, ain, a.getNextFieldNumber(aVar5))) {
                        }
                        ehd.Cgj = ain;
                    }
                    AppMethodBeat.o(140931);
                    return 0;
                case 7:
                    ehd.CeI = aVar3.UbS.readString();
                    AppMethodBeat.o(140931);
                    return 0;
                default:
                    AppMethodBeat.o(140931);
                    return -1;
            }
        } else {
            AppMethodBeat.o(140931);
            return -1;
        }
    }
}
