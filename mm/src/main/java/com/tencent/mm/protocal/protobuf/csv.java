package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class csv extends a {
    public ehf KEN;
    public csx MxT;
    public csw MxU;
    public csw MxV;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91550);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KEN != null) {
                aVar.ni(1, this.KEN.computeSize());
                this.KEN.writeFields(aVar);
            }
            if (this.MxT != null) {
                aVar.ni(2, this.MxT.computeSize());
                this.MxT.writeFields(aVar);
            }
            if (this.MxU != null) {
                aVar.ni(3, this.MxU.computeSize());
                this.MxU.writeFields(aVar);
            }
            if (this.MxV != null) {
                aVar.ni(4, this.MxV.computeSize());
                this.MxV.writeFields(aVar);
            }
            AppMethodBeat.o(91550);
            return 0;
        } else if (i2 == 1) {
            int nh = this.KEN != null ? g.a.a.a.nh(1, this.KEN.computeSize()) + 0 : 0;
            if (this.MxT != null) {
                nh += g.a.a.a.nh(2, this.MxT.computeSize());
            }
            if (this.MxU != null) {
                nh += g.a.a.a.nh(3, this.MxU.computeSize());
            }
            if (this.MxV != null) {
                nh += g.a.a.a.nh(4, this.MxV.computeSize());
            }
            AppMethodBeat.o(91550);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91550);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            csv csv = (csv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ehf ehf = new ehf();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ehf.populateBuilderWithField(aVar4, ehf, a.getNextFieldNumber(aVar4))) {
                        }
                        csv.KEN = ehf;
                    }
                    AppMethodBeat.o(91550);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        csx csx = new csx();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = csx.populateBuilderWithField(aVar5, csx, a.getNextFieldNumber(aVar5))) {
                        }
                        csv.MxT = csx;
                    }
                    AppMethodBeat.o(91550);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        csw csw = new csw();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = csw.populateBuilderWithField(aVar6, csw, a.getNextFieldNumber(aVar6))) {
                        }
                        csv.MxU = csw;
                    }
                    AppMethodBeat.o(91550);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        csw csw2 = new csw();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = csw2.populateBuilderWithField(aVar7, csw2, a.getNextFieldNumber(aVar7))) {
                        }
                        csv.MxV = csw2;
                    }
                    AppMethodBeat.o(91550);
                    return 0;
                default:
                    AppMethodBeat.o(91550);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91550);
            return -1;
        }
    }
}
