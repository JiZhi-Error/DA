package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class fg extends dop {
    public LinkedList<ff> KIG = new LinkedList<>();
    public ff KIH;

    public fg() {
        AppMethodBeat.i(103182);
        AppMethodBeat.o(103182);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(103183);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 8, this.KIG);
            if (this.KIH != null) {
                aVar.ni(3, this.KIH.computeSize());
                this.KIH.writeFields(aVar);
            }
            AppMethodBeat.o(103183);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.KIG);
            if (this.KIH != null) {
                nh += g.a.a.a.nh(3, this.KIH.computeSize());
            }
            AppMethodBeat.o(103183);
            return nh;
        } else if (i2 == 2) {
            this.KIG.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(103183);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fg fgVar = (fg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        fgVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(103183);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ff ffVar = new ff();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ffVar.populateBuilderWithField(aVar5, ffVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        fgVar.KIG.add(ffVar);
                    }
                    AppMethodBeat.o(103183);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ff ffVar2 = new ff();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ffVar2.populateBuilderWithField(aVar6, ffVar2, dop.getNextFieldNumber(aVar6))) {
                        }
                        fgVar.KIH = ffVar2;
                    }
                    AppMethodBeat.o(103183);
                    return 0;
                default:
                    AppMethodBeat.o(103183);
                    return -1;
            }
        } else {
            AppMethodBeat.o(103183);
            return -1;
        }
    }
}
