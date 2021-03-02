package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class avn extends a {
    public avi LDK;
    public int LGh;
    public int LGi;
    public int LGj;
    public int Viq;
    public String Vja;
    public FinderContact contact;
    public int hFI;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209507);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.contact != null) {
                aVar.ni(1, this.contact.computeSize());
                this.contact.writeFields(aVar);
            }
            aVar.aM(2, this.hFI);
            aVar.aM(3, this.LGh);
            aVar.aM(4, this.LGi);
            aVar.aM(5, this.LGj);
            if (this.LDK != null) {
                aVar.ni(6, this.LDK.computeSize());
                this.LDK.writeFields(aVar);
            }
            if (this.Vja != null) {
                aVar.e(9, this.Vja);
            }
            aVar.aM(10, this.Viq);
            AppMethodBeat.o(209507);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.contact != null ? g.a.a.a.nh(1, this.contact.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.hFI) + g.a.a.b.b.a.bu(3, this.LGh) + g.a.a.b.b.a.bu(4, this.LGi) + g.a.a.b.b.a.bu(5, this.LGj);
            if (this.LDK != null) {
                nh += g.a.a.a.nh(6, this.LDK.computeSize());
            }
            if (this.Vja != null) {
                nh += g.a.a.b.b.a.f(9, this.Vja);
            }
            int bu = nh + g.a.a.b.b.a.bu(10, this.Viq);
            AppMethodBeat.o(209507);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209507);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            avn avn = (avn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        FinderContact finderContact = new FinderContact();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = finderContact.populateBuilderWithField(aVar4, finderContact, a.getNextFieldNumber(aVar4))) {
                        }
                        avn.contact = finderContact;
                    }
                    AppMethodBeat.o(209507);
                    return 0;
                case 2:
                    avn.hFI = aVar3.UbS.zi();
                    AppMethodBeat.o(209507);
                    return 0;
                case 3:
                    avn.LGh = aVar3.UbS.zi();
                    AppMethodBeat.o(209507);
                    return 0;
                case 4:
                    avn.LGi = aVar3.UbS.zi();
                    AppMethodBeat.o(209507);
                    return 0;
                case 5:
                    avn.LGj = aVar3.UbS.zi();
                    AppMethodBeat.o(209507);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        avi avi = new avi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = avi.populateBuilderWithField(aVar5, avi, a.getNextFieldNumber(aVar5))) {
                        }
                        avn.LDK = avi;
                    }
                    AppMethodBeat.o(209507);
                    return 0;
                case 7:
                case 8:
                default:
                    AppMethodBeat.o(209507);
                    return -1;
                case 9:
                    avn.Vja = aVar3.UbS.readString();
                    AppMethodBeat.o(209507);
                    return 0;
                case 10:
                    avn.Viq = aVar3.UbS.zi();
                    AppMethodBeat.o(209507);
                    return 0;
            }
        } else {
            AppMethodBeat.o(209507);
            return -1;
        }
    }
}
