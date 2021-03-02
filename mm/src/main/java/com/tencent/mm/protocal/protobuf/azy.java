package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class azy extends a {
    public FinderContact refObjectContact;
    public long refObjectFlag;
    public long refObjectId;
    public String refObjectNonceId;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169027);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(20, this.refObjectFlag);
            aVar.bb(21, this.refObjectId);
            if (this.refObjectContact != null) {
                aVar.ni(22, this.refObjectContact.computeSize());
                this.refObjectContact.writeFields(aVar);
            }
            if (this.refObjectNonceId != null) {
                aVar.e(23, this.refObjectNonceId);
            }
            AppMethodBeat.o(169027);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(20, this.refObjectFlag) + 0 + g.a.a.b.b.a.r(21, this.refObjectId);
            if (this.refObjectContact != null) {
                r += g.a.a.a.nh(22, this.refObjectContact.computeSize());
            }
            if (this.refObjectNonceId != null) {
                r += g.a.a.b.b.a.f(23, this.refObjectNonceId);
            }
            AppMethodBeat.o(169027);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169027);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            azy azy = (azy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 20:
                    azy.refObjectFlag = aVar3.UbS.zl();
                    AppMethodBeat.o(169027);
                    return 0;
                case 21:
                    azy.refObjectId = aVar3.UbS.zl();
                    AppMethodBeat.o(169027);
                    return 0;
                case 22:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        FinderContact finderContact = new FinderContact();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = finderContact.populateBuilderWithField(aVar4, finderContact, a.getNextFieldNumber(aVar4))) {
                        }
                        azy.refObjectContact = finderContact;
                    }
                    AppMethodBeat.o(169027);
                    return 0;
                case 23:
                    azy.refObjectNonceId = aVar3.UbS.readString();
                    AppMethodBeat.o(169027);
                    return 0;
                default:
                    AppMethodBeat.o(169027);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169027);
            return -1;
        }
    }
}
