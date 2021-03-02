package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ecy extends a {
    public b Ndn;
    public aiq Ndo;
    public aip Ndp;
    public int height;
    public String path;
    public int type;
    public int width;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(201301);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.type);
            if (this.path != null) {
                aVar.e(2, this.path);
            }
            if (this.Ndn != null) {
                aVar.c(3, this.Ndn);
            }
            aVar.aM(4, this.width);
            aVar.aM(5, this.height);
            if (this.Ndo != null) {
                aVar.ni(6, this.Ndo.computeSize());
                this.Ndo.writeFields(aVar);
            }
            if (this.Ndp != null) {
                aVar.ni(7, this.Ndp.computeSize());
                this.Ndp.writeFields(aVar);
            }
            AppMethodBeat.o(201301);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.type) + 0;
            if (this.path != null) {
                bu += g.a.a.b.b.a.f(2, this.path);
            }
            if (this.Ndn != null) {
                bu += g.a.a.b.b.a.b(3, this.Ndn);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.width) + g.a.a.b.b.a.bu(5, this.height);
            if (this.Ndo != null) {
                bu2 += g.a.a.a.nh(6, this.Ndo.computeSize());
            }
            if (this.Ndp != null) {
                bu2 += g.a.a.a.nh(7, this.Ndp.computeSize());
            }
            AppMethodBeat.o(201301);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(201301);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ecy ecy = (ecy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ecy.type = aVar3.UbS.zi();
                    AppMethodBeat.o(201301);
                    return 0;
                case 2:
                    ecy.path = aVar3.UbS.readString();
                    AppMethodBeat.o(201301);
                    return 0;
                case 3:
                    ecy.Ndn = aVar3.UbS.hPo();
                    AppMethodBeat.o(201301);
                    return 0;
                case 4:
                    ecy.width = aVar3.UbS.zi();
                    AppMethodBeat.o(201301);
                    return 0;
                case 5:
                    ecy.height = aVar3.UbS.zi();
                    AppMethodBeat.o(201301);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        aiq aiq = new aiq();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = aiq.populateBuilderWithField(aVar4, aiq, a.getNextFieldNumber(aVar4))) {
                        }
                        ecy.Ndo = aiq;
                    }
                    AppMethodBeat.o(201301);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aip aip = new aip();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aip.populateBuilderWithField(aVar5, aip, a.getNextFieldNumber(aVar5))) {
                        }
                        ecy.Ndp = aip;
                    }
                    AppMethodBeat.o(201301);
                    return 0;
                default:
                    AppMethodBeat.o(201301);
                    return -1;
            }
        } else {
            AppMethodBeat.o(201301);
            return -1;
        }
    }
}
