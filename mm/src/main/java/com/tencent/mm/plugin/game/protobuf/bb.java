package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bb extends a {
    public ab xKX;
    public ck xKY;
    public dk xKZ;
    public boolean xLa;
    public cb xLb;
    public k xLc;
    public z xLd;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256637);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xKX != null) {
                aVar.ni(1, this.xKX.computeSize());
                this.xKX.writeFields(aVar);
            }
            if (this.xKY != null) {
                aVar.ni(2, this.xKY.computeSize());
                this.xKY.writeFields(aVar);
            }
            if (this.xKZ != null) {
                aVar.ni(3, this.xKZ.computeSize());
                this.xKZ.writeFields(aVar);
            }
            aVar.cc(4, this.xLa);
            if (this.xLb != null) {
                aVar.ni(5, this.xLb.computeSize());
                this.xLb.writeFields(aVar);
            }
            if (this.xLc != null) {
                aVar.ni(6, this.xLc.computeSize());
                this.xLc.writeFields(aVar);
            }
            if (this.xLd != null) {
                aVar.ni(7, this.xLd.computeSize());
                this.xLd.writeFields(aVar);
            }
            AppMethodBeat.o(256637);
            return 0;
        } else if (i2 == 1) {
            int nh = this.xKX != null ? g.a.a.a.nh(1, this.xKX.computeSize()) + 0 : 0;
            if (this.xKY != null) {
                nh += g.a.a.a.nh(2, this.xKY.computeSize());
            }
            if (this.xKZ != null) {
                nh += g.a.a.a.nh(3, this.xKZ.computeSize());
            }
            int fS = nh + g.a.a.b.b.a.fS(4) + 1;
            if (this.xLb != null) {
                fS += g.a.a.a.nh(5, this.xLb.computeSize());
            }
            if (this.xLc != null) {
                fS += g.a.a.a.nh(6, this.xLc.computeSize());
            }
            if (this.xLd != null) {
                fS += g.a.a.a.nh(7, this.xLd.computeSize());
            }
            AppMethodBeat.o(256637);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(256637);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bb bbVar = (bb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ab abVar = new ab();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = abVar.populateBuilderWithField(aVar4, abVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bbVar.xKX = abVar;
                    }
                    AppMethodBeat.o(256637);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ck ckVar = new ck();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ckVar.populateBuilderWithField(aVar5, ckVar, a.getNextFieldNumber(aVar5))) {
                        }
                        bbVar.xKY = ckVar;
                    }
                    AppMethodBeat.o(256637);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dk dkVar = new dk();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dkVar.populateBuilderWithField(aVar6, dkVar, a.getNextFieldNumber(aVar6))) {
                        }
                        bbVar.xKZ = dkVar;
                    }
                    AppMethodBeat.o(256637);
                    return 0;
                case 4:
                    bbVar.xLa = aVar3.UbS.yZ();
                    AppMethodBeat.o(256637);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        cb cbVar = new cb();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = cbVar.populateBuilderWithField(aVar7, cbVar, a.getNextFieldNumber(aVar7))) {
                        }
                        bbVar.xLb = cbVar;
                    }
                    AppMethodBeat.o(256637);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        k kVar = new k();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = kVar.populateBuilderWithField(aVar8, kVar, a.getNextFieldNumber(aVar8))) {
                        }
                        bbVar.xLc = kVar;
                    }
                    AppMethodBeat.o(256637);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        z zVar = new z();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = zVar.populateBuilderWithField(aVar9, zVar, a.getNextFieldNumber(aVar9))) {
                        }
                        bbVar.xLd = zVar;
                    }
                    AppMethodBeat.o(256637);
                    return 0;
                default:
                    AppMethodBeat.o(256637);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256637);
            return -1;
        }
    }
}
