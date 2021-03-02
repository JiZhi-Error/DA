package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class drx extends a {
    public SKBuiltinBuffer_t LUY;
    public String LUZ;
    public long LVb;
    public int ReqType;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104834);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LUZ == null) {
                b bVar = new b("Not all required fields were included: KeyWord");
                AppMethodBeat.o(104834);
                throw bVar;
            }
            aVar.aM(1, this.ReqType);
            if (this.LUZ != null) {
                aVar.e(2, this.LUZ);
            }
            if (this.LUY != null) {
                aVar.ni(3, this.LUY.computeSize());
                this.LUY.writeFields(aVar);
            }
            aVar.bb(4, this.LVb);
            AppMethodBeat.o(104834);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.ReqType) + 0;
            if (this.LUZ != null) {
                bu += g.a.a.b.b.a.f(2, this.LUZ);
            }
            if (this.LUY != null) {
                bu += g.a.a.a.nh(3, this.LUY.computeSize());
            }
            int r = bu + g.a.a.b.b.a.r(4, this.LVb);
            AppMethodBeat.o(104834);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.LUZ == null) {
                b bVar2 = new b("Not all required fields were included: KeyWord");
                AppMethodBeat.o(104834);
                throw bVar2;
            }
            AppMethodBeat.o(104834);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            drx drx = (drx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    drx.ReqType = aVar3.UbS.zi();
                    AppMethodBeat.o(104834);
                    return 0;
                case 2:
                    drx.LUZ = aVar3.UbS.readString();
                    AppMethodBeat.o(104834);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        drx.LUY = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(104834);
                    return 0;
                case 4:
                    drx.LVb = aVar3.UbS.zl();
                    AppMethodBeat.o(104834);
                    return 0;
                default:
                    AppMethodBeat.o(104834);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104834);
            return -1;
        }
    }
}
