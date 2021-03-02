package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eks extends a {
    public SKBuiltinBuffer_t LRE;
    public String Myy;
    public int NjV;
    public String NjY;
    public int NjZ;
    public int Ret;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152716);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.NjV);
            if (this.NjY != null) {
                aVar.e(2, this.NjY);
            }
            aVar.aM(3, this.Ret);
            if (this.Myy != null) {
                aVar.e(4, this.Myy);
            }
            if (this.LRE != null) {
                aVar.ni(5, this.LRE.computeSize());
                this.LRE.writeFields(aVar);
            }
            aVar.aM(6, this.NjZ);
            AppMethodBeat.o(152716);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.NjV) + 0;
            if (this.NjY != null) {
                bu += g.a.a.b.b.a.f(2, this.NjY);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.Ret);
            if (this.Myy != null) {
                bu2 += g.a.a.b.b.a.f(4, this.Myy);
            }
            if (this.LRE != null) {
                bu2 += g.a.a.a.nh(5, this.LRE.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(6, this.NjZ);
            AppMethodBeat.o(152716);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152716);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eks eks = (eks) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eks.NjV = aVar3.UbS.zi();
                    AppMethodBeat.o(152716);
                    return 0;
                case 2:
                    eks.NjY = aVar3.UbS.readString();
                    AppMethodBeat.o(152716);
                    return 0;
                case 3:
                    eks.Ret = aVar3.UbS.zi();
                    AppMethodBeat.o(152716);
                    return 0;
                case 4:
                    eks.Myy = aVar3.UbS.readString();
                    AppMethodBeat.o(152716);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        eks.LRE = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(152716);
                    return 0;
                case 6:
                    eks.NjZ = aVar3.UbS.zi();
                    AppMethodBeat.o(152716);
                    return 0;
                default:
                    AppMethodBeat.o(152716);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152716);
            return -1;
        }
    }
}
