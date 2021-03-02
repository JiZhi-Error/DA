package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class aqr extends a {
    public int cSx;
    public FinderContact contact;
    public boolean dJM;
    public String dMj;
    public int displayFlag;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168954);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.contact != null) {
                aVar.ni(1, this.contact.computeSize());
                this.contact.writeFields(aVar);
            }
            aVar.aM(2, this.cSx);
            if (this.dMj != null) {
                aVar.e(3, this.dMj);
            }
            aVar.cc(4, this.dJM);
            aVar.aM(5, this.displayFlag);
            if (this.username != null) {
                aVar.e(6, this.username);
            }
            AppMethodBeat.o(168954);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.contact != null ? g.a.a.a.nh(1, this.contact.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.cSx);
            if (this.dMj != null) {
                nh += g.a.a.b.b.a.f(3, this.dMj);
            }
            int fS = nh + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.bu(5, this.displayFlag);
            if (this.username != null) {
                fS += g.a.a.b.b.a.f(6, this.username);
            }
            AppMethodBeat.o(168954);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168954);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aqr aqr = (aqr) objArr[1];
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
                        aqr.contact = finderContact;
                    }
                    AppMethodBeat.o(168954);
                    return 0;
                case 2:
                    aqr.cSx = aVar3.UbS.zi();
                    AppMethodBeat.o(168954);
                    return 0;
                case 3:
                    aqr.dMj = aVar3.UbS.readString();
                    AppMethodBeat.o(168954);
                    return 0;
                case 4:
                    aqr.dJM = aVar3.UbS.yZ();
                    AppMethodBeat.o(168954);
                    return 0;
                case 5:
                    aqr.displayFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(168954);
                    return 0;
                case 6:
                    aqr.username = aVar3.UbS.readString();
                    AppMethodBeat.o(168954);
                    return 0;
                default:
                    AppMethodBeat.o(168954);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168954);
            return -1;
        }
    }
}
