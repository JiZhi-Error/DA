package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ekr extends a {
    public SKBuiltinBuffer_t LRE;
    public int NjV;
    public String NjW;
    public String NjX;
    public int Scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152715);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.NjV);
            if (this.NjW != null) {
                aVar.e(2, this.NjW);
            }
            if (this.NjX != null) {
                aVar.e(3, this.NjX);
            }
            aVar.aM(4, this.Scene);
            if (this.LRE != null) {
                aVar.ni(5, this.LRE.computeSize());
                this.LRE.writeFields(aVar);
            }
            AppMethodBeat.o(152715);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.NjV) + 0;
            if (this.NjW != null) {
                bu += g.a.a.b.b.a.f(2, this.NjW);
            }
            if (this.NjX != null) {
                bu += g.a.a.b.b.a.f(3, this.NjX);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.Scene);
            if (this.LRE != null) {
                bu2 += g.a.a.a.nh(5, this.LRE.computeSize());
            }
            AppMethodBeat.o(152715);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152715);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ekr ekr = (ekr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ekr.NjV = aVar3.UbS.zi();
                    AppMethodBeat.o(152715);
                    return 0;
                case 2:
                    ekr.NjW = aVar3.UbS.readString();
                    AppMethodBeat.o(152715);
                    return 0;
                case 3:
                    ekr.NjX = aVar3.UbS.readString();
                    AppMethodBeat.o(152715);
                    return 0;
                case 4:
                    ekr.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(152715);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        ekr.LRE = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(152715);
                    return 0;
                default:
                    AppMethodBeat.o(152715);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152715);
            return -1;
        }
    }
}
