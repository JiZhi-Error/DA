package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class aqk extends a {
    public String IRp;
    public int LCy;
    public long LCz;
    public int LzC;
    public String ViB;
    public String ViC;
    public int ViD;
    public FinderContact contact;
    public String coverImgUrl;
    public String description;
    public long endTime;
    public String eventName;
    public int tUe;
    public long twd;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209374);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.twd);
            if (this.contact != null) {
                aVar.ni(2, this.contact.computeSize());
                this.contact.writeFields(aVar);
            }
            if (this.eventName != null) {
                aVar.e(3, this.eventName);
            }
            if (this.description != null) {
                aVar.e(4, this.description);
            }
            aVar.aM(5, this.LCy);
            if (this.coverImgUrl != null) {
                aVar.e(6, this.coverImgUrl);
            }
            aVar.bb(7, this.LCz);
            aVar.aM(8, this.LzC);
            aVar.aM(9, this.tUe);
            if (this.IRp != null) {
                aVar.e(10, this.IRp);
            }
            if (this.ViB != null) {
                aVar.e(11, this.ViB);
            }
            if (this.ViC != null) {
                aVar.e(12, this.ViC);
            }
            aVar.aM(13, this.ViD);
            aVar.bb(14, this.endTime);
            AppMethodBeat.o(209374);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.twd) + 0;
            if (this.contact != null) {
                r += g.a.a.a.nh(2, this.contact.computeSize());
            }
            if (this.eventName != null) {
                r += g.a.a.b.b.a.f(3, this.eventName);
            }
            if (this.description != null) {
                r += g.a.a.b.b.a.f(4, this.description);
            }
            int bu = r + g.a.a.b.b.a.bu(5, this.LCy);
            if (this.coverImgUrl != null) {
                bu += g.a.a.b.b.a.f(6, this.coverImgUrl);
            }
            int r2 = bu + g.a.a.b.b.a.r(7, this.LCz) + g.a.a.b.b.a.bu(8, this.LzC) + g.a.a.b.b.a.bu(9, this.tUe);
            if (this.IRp != null) {
                r2 += g.a.a.b.b.a.f(10, this.IRp);
            }
            if (this.ViB != null) {
                r2 += g.a.a.b.b.a.f(11, this.ViB);
            }
            if (this.ViC != null) {
                r2 += g.a.a.b.b.a.f(12, this.ViC);
            }
            int bu2 = r2 + g.a.a.b.b.a.bu(13, this.ViD) + g.a.a.b.b.a.r(14, this.endTime);
            AppMethodBeat.o(209374);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209374);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aqk aqk = (aqk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aqk.twd = aVar3.UbS.zl();
                    AppMethodBeat.o(209374);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        FinderContact finderContact = new FinderContact();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = finderContact.populateBuilderWithField(aVar4, finderContact, a.getNextFieldNumber(aVar4))) {
                        }
                        aqk.contact = finderContact;
                    }
                    AppMethodBeat.o(209374);
                    return 0;
                case 3:
                    aqk.eventName = aVar3.UbS.readString();
                    AppMethodBeat.o(209374);
                    return 0;
                case 4:
                    aqk.description = aVar3.UbS.readString();
                    AppMethodBeat.o(209374);
                    return 0;
                case 5:
                    aqk.LCy = aVar3.UbS.zi();
                    AppMethodBeat.o(209374);
                    return 0;
                case 6:
                    aqk.coverImgUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(209374);
                    return 0;
                case 7:
                    aqk.LCz = aVar3.UbS.zl();
                    AppMethodBeat.o(209374);
                    return 0;
                case 8:
                    aqk.LzC = aVar3.UbS.zi();
                    AppMethodBeat.o(209374);
                    return 0;
                case 9:
                    aqk.tUe = aVar3.UbS.zi();
                    AppMethodBeat.o(209374);
                    return 0;
                case 10:
                    aqk.IRp = aVar3.UbS.readString();
                    AppMethodBeat.o(209374);
                    return 0;
                case 11:
                    aqk.ViB = aVar3.UbS.readString();
                    AppMethodBeat.o(209374);
                    return 0;
                case 12:
                    aqk.ViC = aVar3.UbS.readString();
                    AppMethodBeat.o(209374);
                    return 0;
                case 13:
                    aqk.ViD = aVar3.UbS.zi();
                    AppMethodBeat.o(209374);
                    return 0;
                case 14:
                    aqk.endTime = aVar3.UbS.zl();
                    AppMethodBeat.o(209374);
                    return 0;
                default:
                    AppMethodBeat.o(209374);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209374);
            return -1;
        }
    }
}
