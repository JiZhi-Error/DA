package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dbg extends a {
    public ehf KEN;
    public ehf KEO;
    public LinkedList<uq> LEy = new LinkedList<>();
    public ccy MGn;
    public cte MGo;

    public dbg() {
        AppMethodBeat.i(91613);
        AppMethodBeat.o(91613);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91614);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MGn != null) {
                aVar.ni(1, this.MGn.computeSize());
                this.MGn.writeFields(aVar);
            }
            if (this.KEN != null) {
                aVar.ni(2, this.KEN.computeSize());
                this.KEN.writeFields(aVar);
            }
            if (this.KEO != null) {
                aVar.ni(3, this.KEO.computeSize());
                this.KEO.writeFields(aVar);
            }
            aVar.e(4, 8, this.LEy);
            if (this.MGo != null) {
                aVar.ni(5, this.MGo.computeSize());
                this.MGo.writeFields(aVar);
            }
            AppMethodBeat.o(91614);
            return 0;
        } else if (i2 == 1) {
            int nh = this.MGn != null ? g.a.a.a.nh(1, this.MGn.computeSize()) + 0 : 0;
            if (this.KEN != null) {
                nh += g.a.a.a.nh(2, this.KEN.computeSize());
            }
            if (this.KEO != null) {
                nh += g.a.a.a.nh(3, this.KEO.computeSize());
            }
            int c2 = nh + g.a.a.a.c(4, 8, this.LEy);
            if (this.MGo != null) {
                c2 += g.a.a.a.nh(5, this.MGo.computeSize());
            }
            AppMethodBeat.o(91614);
            return c2;
        } else if (i2 == 2) {
            this.LEy.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91614);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dbg dbg = (dbg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ccy ccy = new ccy();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ccy.populateBuilderWithField(aVar4, ccy, a.getNextFieldNumber(aVar4))) {
                        }
                        dbg.MGn = ccy;
                    }
                    AppMethodBeat.o(91614);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ehf ehf = new ehf();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ehf.populateBuilderWithField(aVar5, ehf, a.getNextFieldNumber(aVar5))) {
                        }
                        dbg.KEN = ehf;
                    }
                    AppMethodBeat.o(91614);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ehf ehf2 = new ehf();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ehf2.populateBuilderWithField(aVar6, ehf2, a.getNextFieldNumber(aVar6))) {
                        }
                        dbg.KEO = ehf2;
                    }
                    AppMethodBeat.o(91614);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        uq uqVar = new uq();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = uqVar.populateBuilderWithField(aVar7, uqVar, a.getNextFieldNumber(aVar7))) {
                        }
                        dbg.LEy.add(uqVar);
                    }
                    AppMethodBeat.o(91614);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        cte cte = new cte();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = cte.populateBuilderWithField(aVar8, cte, a.getNextFieldNumber(aVar8))) {
                        }
                        dbg.MGo = cte;
                    }
                    AppMethodBeat.o(91614);
                    return 0;
                default:
                    AppMethodBeat.o(91614);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91614);
            return -1;
        }
    }
}
