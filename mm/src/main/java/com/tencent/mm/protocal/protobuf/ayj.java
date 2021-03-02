package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ayj extends a {
    public cng LIA;
    public FinderContact contact;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209590);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LIA != null) {
                aVar.ni(1, this.LIA.computeSize());
                this.LIA.writeFields(aVar);
            }
            if (this.contact != null) {
                aVar.ni(2, this.contact.computeSize());
                this.contact.writeFields(aVar);
            }
            AppMethodBeat.o(209590);
            return 0;
        } else if (i2 == 1) {
            int nh = this.LIA != null ? g.a.a.a.nh(1, this.LIA.computeSize()) + 0 : 0;
            if (this.contact != null) {
                nh += g.a.a.a.nh(2, this.contact.computeSize());
            }
            AppMethodBeat.o(209590);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209590);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ayj ayj = (ayj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cng cng = new cng();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cng.populateBuilderWithField(aVar4, cng, a.getNextFieldNumber(aVar4))) {
                        }
                        ayj.LIA = cng;
                    }
                    AppMethodBeat.o(209590);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        FinderContact finderContact = new FinderContact();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = finderContact.populateBuilderWithField(aVar5, finderContact, a.getNextFieldNumber(aVar5))) {
                        }
                        ayj.contact = finderContact;
                    }
                    AppMethodBeat.o(209590);
                    return 0;
                default:
                    AppMethodBeat.o(209590);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209590);
            return -1;
        }
    }
}
