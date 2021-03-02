package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bmf extends a {
    public int DesignerUin;
    public SKBuiltinBuffer_t LUY;
    public String LUZ;
    public int LVa;
    public long LVb;
    public int Lst;
    public int OpCode;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104784);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.OpCode);
            aVar.aM(2, this.DesignerUin);
            if (this.LUY != null) {
                aVar.ni(3, this.LUY.computeSize());
                this.LUY.writeFields(aVar);
            }
            aVar.aM(4, this.Lst);
            if (this.LUZ != null) {
                aVar.e(5, this.LUZ);
            }
            aVar.aM(6, this.LVa);
            aVar.bb(7, this.LVb);
            AppMethodBeat.o(104784);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.OpCode) + 0 + g.a.a.b.b.a.bu(2, this.DesignerUin);
            if (this.LUY != null) {
                bu += g.a.a.a.nh(3, this.LUY.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.Lst);
            if (this.LUZ != null) {
                bu2 += g.a.a.b.b.a.f(5, this.LUZ);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(6, this.LVa) + g.a.a.b.b.a.r(7, this.LVb);
            AppMethodBeat.o(104784);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(104784);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bmf bmf = (bmf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bmf.OpCode = aVar3.UbS.zi();
                    AppMethodBeat.o(104784);
                    return 0;
                case 2:
                    bmf.DesignerUin = aVar3.UbS.zi();
                    AppMethodBeat.o(104784);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        bmf.LUY = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(104784);
                    return 0;
                case 4:
                    bmf.Lst = aVar3.UbS.zi();
                    AppMethodBeat.o(104784);
                    return 0;
                case 5:
                    bmf.LUZ = aVar3.UbS.readString();
                    AppMethodBeat.o(104784);
                    return 0;
                case 6:
                    bmf.LVa = aVar3.UbS.zi();
                    AppMethodBeat.o(104784);
                    return 0;
                case 7:
                    bmf.LVb = aVar3.UbS.zl();
                    AppMethodBeat.o(104784);
                    return 0;
                default:
                    AppMethodBeat.o(104784);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104784);
            return -1;
        }
    }
}
