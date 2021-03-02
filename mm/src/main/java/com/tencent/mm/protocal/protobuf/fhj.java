package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class fhj extends a {
    public long LDU;
    public String Vjx;
    public FinderContact contact;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(259369);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.contact != null) {
                aVar.ni(1, this.contact.computeSize());
                this.contact.writeFields(aVar);
            }
            if (this.Vjx != null) {
                aVar.e(2, this.Vjx);
            }
            aVar.bb(3, this.LDU);
            AppMethodBeat.o(259369);
            return 0;
        } else if (i2 == 1) {
            int nh = this.contact != null ? g.a.a.a.nh(1, this.contact.computeSize()) + 0 : 0;
            if (this.Vjx != null) {
                nh += g.a.a.b.b.a.f(2, this.Vjx);
            }
            int r = nh + g.a.a.b.b.a.r(3, this.LDU);
            AppMethodBeat.o(259369);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(259369);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fhj fhj = (fhj) objArr[1];
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
                        fhj.contact = finderContact;
                    }
                    AppMethodBeat.o(259369);
                    return 0;
                case 2:
                    fhj.Vjx = aVar3.UbS.readString();
                    AppMethodBeat.o(259369);
                    return 0;
                case 3:
                    fhj.LDU = aVar3.UbS.zl();
                    AppMethodBeat.o(259369);
                    return 0;
                default:
                    AppMethodBeat.o(259369);
                    return -1;
            }
        } else {
            AppMethodBeat.o(259369);
            return -1;
        }
    }
}
