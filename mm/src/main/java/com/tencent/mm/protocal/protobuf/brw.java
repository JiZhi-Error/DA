package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class brw extends dop {
    public double KUt;
    public double KUu;
    public String LPT;
    public SKBuiltinBuffer_t LXm;
    public int LXo;
    public double LYZ;
    public double LZa;
    public int OpCode;
    public int Scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(56249);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.LXm == null) {
                b bVar = new b("Not all required fields were included: Buff");
                AppMethodBeat.o(56249);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.Scene);
            aVar.aM(3, this.OpCode);
            if (this.LPT != null) {
                aVar.e(4, this.LPT);
            }
            if (this.LXm != null) {
                aVar.ni(5, this.LXm.computeSize());
                this.LXm.writeFields(aVar);
            }
            aVar.e(6, this.KUt);
            aVar.e(7, this.KUu);
            aVar.e(8, this.LYZ);
            aVar.e(9, this.LZa);
            aVar.aM(10, this.LXo);
            AppMethodBeat.o(56249);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.Scene) + g.a.a.b.b.a.bu(3, this.OpCode);
            if (this.LPT != null) {
                nh += g.a.a.b.b.a.f(4, this.LPT);
            }
            if (this.LXm != null) {
                nh += g.a.a.a.nh(5, this.LXm.computeSize());
            }
            int fS = nh + g.a.a.b.b.a.fS(6) + 8 + g.a.a.b.b.a.fS(7) + 8 + g.a.a.b.b.a.fS(8) + 8 + g.a.a.b.b.a.fS(9) + 8 + g.a.a.b.b.a.bu(10, this.LXo);
            AppMethodBeat.o(56249);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.LXm == null) {
                b bVar2 = new b("Not all required fields were included: Buff");
                AppMethodBeat.o(56249);
                throw bVar2;
            }
            AppMethodBeat.o(56249);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            brw brw = (brw) objArr[1];
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
                        brw.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(56249);
                    return 0;
                case 2:
                    brw.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(56249);
                    return 0;
                case 3:
                    brw.OpCode = aVar3.UbS.zi();
                    AppMethodBeat.o(56249);
                    return 0;
                case 4:
                    brw.LPT = aVar3.UbS.readString();
                    AppMethodBeat.o(56249);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        brw.LXm = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(56249);
                    return 0;
                case 6:
                    brw.KUt = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(56249);
                    return 0;
                case 7:
                    brw.KUu = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(56249);
                    return 0;
                case 8:
                    brw.LYZ = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(56249);
                    return 0;
                case 9:
                    brw.LZa = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(56249);
                    return 0;
                case 10:
                    brw.LXo = aVar3.UbS.zi();
                    AppMethodBeat.o(56249);
                    return 0;
                default:
                    AppMethodBeat.o(56249);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56249);
            return -1;
        }
    }
}
