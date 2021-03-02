package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dxc extends dop {
    public SKBuiltinBuffer_t BsI;
    public int KIy;
    public float LbD;
    public int Llx;
    public int MWV;
    public float MWW;
    public float MWX;
    public int jeU;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32448);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BsI == null) {
                b bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(32448);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.BsI != null) {
                aVar.ni(2, this.BsI.computeSize());
                this.BsI.writeFields(aVar);
            }
            aVar.aM(3, this.MWV);
            aVar.aM(4, this.jeU);
            aVar.E(5, this.MWW);
            aVar.aM(6, this.Llx);
            aVar.aM(7, this.KIy);
            aVar.E(8, this.MWX);
            aVar.E(9, this.LbD);
            AppMethodBeat.o(32448);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.BsI != null) {
                nh += g.a.a.a.nh(2, this.BsI.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.MWV) + g.a.a.b.b.a.bu(4, this.jeU) + g.a.a.b.b.a.fS(5) + 4 + g.a.a.b.b.a.bu(6, this.Llx) + g.a.a.b.b.a.bu(7, this.KIy) + g.a.a.b.b.a.fS(8) + 4 + g.a.a.b.b.a.fS(9) + 4;
            AppMethodBeat.o(32448);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BsI == null) {
                b bVar2 = new b("Not all required fields were included: Data");
                AppMethodBeat.o(32448);
                throw bVar2;
            }
            AppMethodBeat.o(32448);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dxc dxc = (dxc) objArr[1];
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
                        dxc.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32448);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        dxc.BsI = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(32448);
                    return 0;
                case 3:
                    dxc.MWV = aVar3.UbS.zi();
                    AppMethodBeat.o(32448);
                    return 0;
                case 4:
                    dxc.jeU = aVar3.UbS.zi();
                    AppMethodBeat.o(32448);
                    return 0;
                case 5:
                    dxc.MWW = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(32448);
                    return 0;
                case 6:
                    dxc.Llx = aVar3.UbS.zi();
                    AppMethodBeat.o(32448);
                    return 0;
                case 7:
                    dxc.KIy = aVar3.UbS.zi();
                    AppMethodBeat.o(32448);
                    return 0;
                case 8:
                    dxc.MWX = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(32448);
                    return 0;
                case 9:
                    dxc.LbD = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(32448);
                    return 0;
                default:
                    AppMethodBeat.o(32448);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32448);
            return -1;
        }
    }
}
