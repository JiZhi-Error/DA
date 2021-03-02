package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bjh extends dop {
    public SKBuiltinBuffer_t KPW;
    public String KRB;
    public String LSY;
    public int LSZ;
    public b LTa;
    public int Scene;
    public String dNI;
    public int oUv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104367);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.oUv);
            aVar.aM(3, this.Scene);
            if (this.LSY != null) {
                aVar.e(4, this.LSY);
            }
            if (this.KPW != null) {
                aVar.ni(5, this.KPW.computeSize());
                this.KPW.writeFields(aVar);
            }
            aVar.aM(6, this.LSZ);
            if (this.dNI != null) {
                aVar.e(7, this.dNI);
            }
            if (this.KRB != null) {
                aVar.e(8, this.KRB);
            }
            if (this.LTa != null) {
                aVar.c(9, this.LTa);
            }
            AppMethodBeat.o(104367);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.oUv) + g.a.a.b.b.a.bu(3, this.Scene);
            if (this.LSY != null) {
                nh += g.a.a.b.b.a.f(4, this.LSY);
            }
            if (this.KPW != null) {
                nh += g.a.a.a.nh(5, this.KPW.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.LSZ);
            if (this.dNI != null) {
                bu += g.a.a.b.b.a.f(7, this.dNI);
            }
            if (this.KRB != null) {
                bu += g.a.a.b.b.a.f(8, this.KRB);
            }
            if (this.LTa != null) {
                bu += g.a.a.b.b.a.b(9, this.LTa);
            }
            AppMethodBeat.o(104367);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(104367);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bjh bjh = (bjh) objArr[1];
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
                        bjh.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(104367);
                    return 0;
                case 2:
                    bjh.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(104367);
                    return 0;
                case 3:
                    bjh.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(104367);
                    return 0;
                case 4:
                    bjh.LSY = aVar3.UbS.readString();
                    AppMethodBeat.o(104367);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        bjh.KPW = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(104367);
                    return 0;
                case 6:
                    bjh.LSZ = aVar3.UbS.zi();
                    AppMethodBeat.o(104367);
                    return 0;
                case 7:
                    bjh.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(104367);
                    return 0;
                case 8:
                    bjh.KRB = aVar3.UbS.readString();
                    AppMethodBeat.o(104367);
                    return 0;
                case 9:
                    bjh.LTa = aVar3.UbS.hPo();
                    AppMethodBeat.o(104367);
                    return 0;
                default:
                    AppMethodBeat.o(104367);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104367);
            return -1;
        }
    }
}
