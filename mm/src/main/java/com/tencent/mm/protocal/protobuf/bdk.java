package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bdk extends a {
    public int LNj;
    public FinderContact contact;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209698);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.contact != null) {
                aVar.ni(1, this.contact.computeSize());
                this.contact.writeFields(aVar);
            }
            aVar.aM(2, this.LNj);
            AppMethodBeat.o(209698);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.contact != null ? g.a.a.a.nh(1, this.contact.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LNj);
            AppMethodBeat.o(209698);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209698);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bdk bdk = (bdk) objArr[1];
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
                        bdk.contact = finderContact;
                    }
                    AppMethodBeat.o(209698);
                    return 0;
                case 2:
                    bdk.LNj = aVar3.UbS.zi();
                    AppMethodBeat.o(209698);
                    return 0;
                default:
                    AppMethodBeat.o(209698);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209698);
            return -1;
        }
    }
}
