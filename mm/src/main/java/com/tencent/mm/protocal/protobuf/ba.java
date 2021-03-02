package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ba extends a {
    public int KDZ;
    public String KEa;
    public String KEb;
    public int KEc;
    public int KEd;
    public String KEe;
    public int KEf;
    public String KEg;
    public String KEh;
    public int KEi;
    public String KEj;
    public String KEk;
    public int KEl;
    public ffh KEm;
    public ffe KEn;
    public String UserName;
    public String ked;
    public int oTW;
    public String oUJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133142);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.UserName != null) {
                aVar.e(1, this.UserName);
            }
            if (this.oUJ != null) {
                aVar.e(2, this.oUJ);
            }
            aVar.aM(3, this.KDZ);
            if (this.KEa != null) {
                aVar.e(4, this.KEa);
            }
            if (this.KEb != null) {
                aVar.e(5, this.KEb);
            }
            if (this.ked != null) {
                aVar.e(6, this.ked);
            }
            aVar.aM(8, this.oTW);
            aVar.aM(9, this.KEc);
            aVar.aM(10, this.KEd);
            if (this.KEe != null) {
                aVar.e(11, this.KEe);
            }
            aVar.aM(12, this.KEf);
            if (this.KEg != null) {
                aVar.e(13, this.KEg);
            }
            if (this.KEh != null) {
                aVar.e(14, this.KEh);
            }
            aVar.aM(15, this.KEi);
            if (this.KEj != null) {
                aVar.e(16, this.KEj);
            }
            if (this.KEk != null) {
                aVar.e(17, this.KEk);
            }
            aVar.aM(18, this.KEl);
            if (this.KEm != null) {
                aVar.ni(19, this.KEm.computeSize());
                this.KEm.writeFields(aVar);
            }
            if (this.KEn != null) {
                aVar.ni(20, this.KEn.computeSize());
                this.KEn.writeFields(aVar);
            }
            AppMethodBeat.o(133142);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.UserName != null ? g.a.a.b.b.a.f(1, this.UserName) + 0 : 0;
            if (this.oUJ != null) {
                f2 += g.a.a.b.b.a.f(2, this.oUJ);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.KDZ);
            if (this.KEa != null) {
                bu += g.a.a.b.b.a.f(4, this.KEa);
            }
            if (this.KEb != null) {
                bu += g.a.a.b.b.a.f(5, this.KEb);
            }
            if (this.ked != null) {
                bu += g.a.a.b.b.a.f(6, this.ked);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.oTW) + g.a.a.b.b.a.bu(9, this.KEc) + g.a.a.b.b.a.bu(10, this.KEd);
            if (this.KEe != null) {
                bu2 += g.a.a.b.b.a.f(11, this.KEe);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(12, this.KEf);
            if (this.KEg != null) {
                bu3 += g.a.a.b.b.a.f(13, this.KEg);
            }
            if (this.KEh != null) {
                bu3 += g.a.a.b.b.a.f(14, this.KEh);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(15, this.KEi);
            if (this.KEj != null) {
                bu4 += g.a.a.b.b.a.f(16, this.KEj);
            }
            if (this.KEk != null) {
                bu4 += g.a.a.b.b.a.f(17, this.KEk);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(18, this.KEl);
            if (this.KEm != null) {
                bu5 += g.a.a.a.nh(19, this.KEm.computeSize());
            }
            if (this.KEn != null) {
                bu5 += g.a.a.a.nh(20, this.KEn.computeSize());
            }
            AppMethodBeat.o(133142);
            return bu5;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(133142);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ba baVar = (ba) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    baVar.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(133142);
                    return 0;
                case 2:
                    baVar.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(133142);
                    return 0;
                case 3:
                    baVar.KDZ = aVar3.UbS.zi();
                    AppMethodBeat.o(133142);
                    return 0;
                case 4:
                    baVar.KEa = aVar3.UbS.readString();
                    AppMethodBeat.o(133142);
                    return 0;
                case 5:
                    baVar.KEb = aVar3.UbS.readString();
                    AppMethodBeat.o(133142);
                    return 0;
                case 6:
                    baVar.ked = aVar3.UbS.readString();
                    AppMethodBeat.o(133142);
                    return 0;
                case 7:
                default:
                    AppMethodBeat.o(133142);
                    return -1;
                case 8:
                    baVar.oTW = aVar3.UbS.zi();
                    AppMethodBeat.o(133142);
                    return 0;
                case 9:
                    baVar.KEc = aVar3.UbS.zi();
                    AppMethodBeat.o(133142);
                    return 0;
                case 10:
                    baVar.KEd = aVar3.UbS.zi();
                    AppMethodBeat.o(133142);
                    return 0;
                case 11:
                    baVar.KEe = aVar3.UbS.readString();
                    AppMethodBeat.o(133142);
                    return 0;
                case 12:
                    baVar.KEf = aVar3.UbS.zi();
                    AppMethodBeat.o(133142);
                    return 0;
                case 13:
                    baVar.KEg = aVar3.UbS.readString();
                    AppMethodBeat.o(133142);
                    return 0;
                case 14:
                    baVar.KEh = aVar3.UbS.readString();
                    AppMethodBeat.o(133142);
                    return 0;
                case 15:
                    baVar.KEi = aVar3.UbS.zi();
                    AppMethodBeat.o(133142);
                    return 0;
                case 16:
                    baVar.KEj = aVar3.UbS.readString();
                    AppMethodBeat.o(133142);
                    return 0;
                case 17:
                    baVar.KEk = aVar3.UbS.readString();
                    AppMethodBeat.o(133142);
                    return 0;
                case 18:
                    baVar.KEl = aVar3.UbS.zi();
                    AppMethodBeat.o(133142);
                    return 0;
                case 19:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ffh ffh = new ffh();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ffh.populateBuilderWithField(aVar4, ffh, a.getNextFieldNumber(aVar4))) {
                        }
                        baVar.KEm = ffh;
                    }
                    AppMethodBeat.o(133142);
                    return 0;
                case 20:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ffe ffe = new ffe();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ffe.populateBuilderWithField(aVar5, ffe, a.getNextFieldNumber(aVar5))) {
                        }
                        baVar.KEn = ffe;
                    }
                    AppMethodBeat.o(133142);
                    return 0;
            }
        } else {
            AppMethodBeat.o(133142);
            return -1;
        }
    }
}
