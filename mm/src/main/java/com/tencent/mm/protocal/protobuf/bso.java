package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class bso extends a {
    public int DesignerUin;
    public SKBuiltinBuffer_t ReqBuf;
    public int Scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104810);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.ReqBuf == null) {
                b bVar = new b("Not all required fields were included: ReqBuf");
                AppMethodBeat.o(104810);
                throw bVar;
            }
            aVar.aM(1, this.DesignerUin);
            if (this.ReqBuf != null) {
                aVar.ni(2, this.ReqBuf.computeSize());
                this.ReqBuf.writeFields(aVar);
            }
            aVar.aM(3, this.Scene);
            AppMethodBeat.o(104810);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.DesignerUin) + 0;
            if (this.ReqBuf != null) {
                bu += g.a.a.a.nh(2, this.ReqBuf.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.Scene);
            AppMethodBeat.o(104810);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.ReqBuf == null) {
                b bVar2 = new b("Not all required fields were included: ReqBuf");
                AppMethodBeat.o(104810);
                throw bVar2;
            }
            AppMethodBeat.o(104810);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bso bso = (bso) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bso.DesignerUin = aVar3.UbS.zi();
                    AppMethodBeat.o(104810);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        bso.ReqBuf = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(104810);
                    return 0;
                case 3:
                    bso.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(104810);
                    return 0;
                default:
                    AppMethodBeat.o(104810);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104810);
            return -1;
        }
    }
}
