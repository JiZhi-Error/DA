package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bbz extends a {
    public String LLd;
    public String LLe;
    public String LLf;
    public FinderContact contact;
    public int fansCount;
    public int friendFollowCount;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169047);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.contact != null) {
                aVar.ni(1, this.contact.computeSize());
                this.contact.writeFields(aVar);
            }
            if (this.LLd != null) {
                aVar.e(2, this.LLd);
            }
            if (this.LLe != null) {
                aVar.e(3, this.LLe);
            }
            aVar.aM(4, this.fansCount);
            aVar.aM(5, this.friendFollowCount);
            if (this.LLf != null) {
                aVar.e(6, this.LLf);
            }
            AppMethodBeat.o(169047);
            return 0;
        } else if (i2 == 1) {
            int nh = this.contact != null ? g.a.a.a.nh(1, this.contact.computeSize()) + 0 : 0;
            if (this.LLd != null) {
                nh += g.a.a.b.b.a.f(2, this.LLd);
            }
            if (this.LLe != null) {
                nh += g.a.a.b.b.a.f(3, this.LLe);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.fansCount) + g.a.a.b.b.a.bu(5, this.friendFollowCount);
            if (this.LLf != null) {
                bu += g.a.a.b.b.a.f(6, this.LLf);
            }
            AppMethodBeat.o(169047);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169047);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bbz bbz = (bbz) objArr[1];
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
                        bbz.contact = finderContact;
                    }
                    AppMethodBeat.o(169047);
                    return 0;
                case 2:
                    bbz.LLd = aVar3.UbS.readString();
                    AppMethodBeat.o(169047);
                    return 0;
                case 3:
                    bbz.LLe = aVar3.UbS.readString();
                    AppMethodBeat.o(169047);
                    return 0;
                case 4:
                    bbz.fansCount = aVar3.UbS.zi();
                    AppMethodBeat.o(169047);
                    return 0;
                case 5:
                    bbz.friendFollowCount = aVar3.UbS.zi();
                    AppMethodBeat.o(169047);
                    return 0;
                case 6:
                    bbz.LLf = aVar3.UbS.readString();
                    AppMethodBeat.o(169047);
                    return 0;
                default:
                    AppMethodBeat.o(169047);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169047);
            return -1;
        }
    }
}
