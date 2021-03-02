package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eoy extends a {
    public LinkedList<FinderObject> LCW = new LinkedList<>();
    public int LNG;
    public int LNI;
    public aso LNJ;
    public FinderContact contact;

    public eoy() {
        AppMethodBeat.i(209822);
        AppMethodBeat.o(209822);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209823);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.contact != null) {
                aVar.ni(1, this.contact.computeSize());
                this.contact.writeFields(aVar);
            }
            aVar.aM(2, this.LNG);
            aVar.e(3, 8, this.LCW);
            aVar.aM(6, this.LNI);
            if (this.LNJ != null) {
                aVar.ni(7, this.LNJ.computeSize());
                this.LNJ.writeFields(aVar);
            }
            AppMethodBeat.o(209823);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.contact != null ? g.a.a.a.nh(1, this.contact.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LNG) + g.a.a.a.c(3, 8, this.LCW) + g.a.a.b.b.a.bu(6, this.LNI);
            if (this.LNJ != null) {
                nh += g.a.a.a.nh(7, this.LNJ.computeSize());
            }
            AppMethodBeat.o(209823);
            return nh;
        } else if (i2 == 2) {
            this.LCW.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209823);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eoy eoy = (eoy) objArr[1];
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
                        eoy.contact = finderContact;
                    }
                    AppMethodBeat.o(209823);
                    return 0;
                case 2:
                    eoy.LNG = aVar3.UbS.zi();
                    AppMethodBeat.o(209823);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        FinderObject finderObject = new FinderObject();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = finderObject.populateBuilderWithField(aVar5, finderObject, a.getNextFieldNumber(aVar5))) {
                        }
                        eoy.LCW.add(finderObject);
                    }
                    AppMethodBeat.o(209823);
                    return 0;
                case 4:
                case 5:
                default:
                    AppMethodBeat.o(209823);
                    return -1;
                case 6:
                    eoy.LNI = aVar3.UbS.zi();
                    AppMethodBeat.o(209823);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        aso aso = new aso();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = aso.populateBuilderWithField(aVar6, aso, a.getNextFieldNumber(aVar6))) {
                        }
                        eoy.LNJ = aso;
                    }
                    AppMethodBeat.o(209823);
                    return 0;
            }
        } else {
            AppMethodBeat.o(209823);
            return -1;
        }
    }
}
