package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class czk extends a {
    public SKBuiltinBuffer_t MEG;
    public int MEH;
    public SKBuiltinBuffer_t MEI;
    public int uin;
    public int version;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(129972);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.uin);
            aVar.aM(2, this.version);
            if (this.MEG != null) {
                aVar.ni(3, this.MEG.computeSize());
                this.MEG.writeFields(aVar);
            }
            aVar.aM(4, this.MEH);
            if (this.MEI != null) {
                aVar.ni(5, this.MEI.computeSize());
                this.MEI.writeFields(aVar);
            }
            AppMethodBeat.o(129972);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.uin) + 0 + g.a.a.b.b.a.bu(2, this.version);
            if (this.MEG != null) {
                bu += g.a.a.a.nh(3, this.MEG.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.MEH);
            if (this.MEI != null) {
                bu2 += g.a.a.a.nh(5, this.MEI.computeSize());
            }
            AppMethodBeat.o(129972);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(129972);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            czk czk = (czk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    czk.uin = aVar3.UbS.zi();
                    AppMethodBeat.o(129972);
                    return 0;
                case 2:
                    czk.version = aVar3.UbS.zi();
                    AppMethodBeat.o(129972);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        czk.MEG = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(129972);
                    return 0;
                case 4:
                    czk.MEH = aVar3.UbS.zi();
                    AppMethodBeat.o(129972);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar5, sKBuiltinBuffer_t2, a.getNextFieldNumber(aVar5))) {
                        }
                        czk.MEI = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(129972);
                    return 0;
                default:
                    AppMethodBeat.o(129972);
                    return -1;
            }
        } else {
            AppMethodBeat.o(129972);
            return -1;
        }
    }
}
