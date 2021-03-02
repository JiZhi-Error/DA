package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class aiz extends a {
    public int BsF;
    public int BsG;
    public String KHq;
    public String LbN;
    public String LsA;
    public String LsB;
    public int LsC;
    public SKBuiltinBuffer_t Lsy;
    public String Lsz;
    public String MD5;
    public int oUv;
    public String xNG;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(109446);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Lsy == null) {
                b bVar = new b("Not all required fields were included: EmojiBuffer");
                AppMethodBeat.o(109446);
                throw bVar;
            }
            if (this.MD5 != null) {
                aVar.e(1, this.MD5);
            }
            aVar.aM(2, this.BsG);
            aVar.aM(3, this.BsF);
            if (this.Lsy != null) {
                aVar.ni(4, this.Lsy.computeSize());
                this.Lsy.writeFields(aVar);
            }
            aVar.aM(5, this.oUv);
            if (this.xNG != null) {
                aVar.e(6, this.xNG);
            }
            if (this.Lsz != null) {
                aVar.e(7, this.Lsz);
            }
            if (this.LsA != null) {
                aVar.e(8, this.LsA);
            }
            if (this.LsB != null) {
                aVar.e(9, this.LsB);
            }
            if (this.KHq != null) {
                aVar.e(10, this.KHq);
            }
            aVar.aM(11, this.LsC);
            if (this.LbN != null) {
                aVar.e(12, this.LbN);
            }
            AppMethodBeat.o(109446);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.MD5 != null ? g.a.a.b.b.a.f(1, this.MD5) + 0 : 0) + g.a.a.b.b.a.bu(2, this.BsG) + g.a.a.b.b.a.bu(3, this.BsF);
            if (this.Lsy != null) {
                f2 += g.a.a.a.nh(4, this.Lsy.computeSize());
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.oUv);
            if (this.xNG != null) {
                bu += g.a.a.b.b.a.f(6, this.xNG);
            }
            if (this.Lsz != null) {
                bu += g.a.a.b.b.a.f(7, this.Lsz);
            }
            if (this.LsA != null) {
                bu += g.a.a.b.b.a.f(8, this.LsA);
            }
            if (this.LsB != null) {
                bu += g.a.a.b.b.a.f(9, this.LsB);
            }
            if (this.KHq != null) {
                bu += g.a.a.b.b.a.f(10, this.KHq);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(11, this.LsC);
            if (this.LbN != null) {
                bu2 += g.a.a.b.b.a.f(12, this.LbN);
            }
            AppMethodBeat.o(109446);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Lsy == null) {
                b bVar2 = new b("Not all required fields were included: EmojiBuffer");
                AppMethodBeat.o(109446);
                throw bVar2;
            }
            AppMethodBeat.o(109446);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aiz aiz = (aiz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aiz.MD5 = aVar3.UbS.readString();
                    AppMethodBeat.o(109446);
                    return 0;
                case 2:
                    aiz.BsG = aVar3.UbS.zi();
                    AppMethodBeat.o(109446);
                    return 0;
                case 3:
                    aiz.BsF = aVar3.UbS.zi();
                    AppMethodBeat.o(109446);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        aiz.Lsy = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(109446);
                    return 0;
                case 5:
                    aiz.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(109446);
                    return 0;
                case 6:
                    aiz.xNG = aVar3.UbS.readString();
                    AppMethodBeat.o(109446);
                    return 0;
                case 7:
                    aiz.Lsz = aVar3.UbS.readString();
                    AppMethodBeat.o(109446);
                    return 0;
                case 8:
                    aiz.LsA = aVar3.UbS.readString();
                    AppMethodBeat.o(109446);
                    return 0;
                case 9:
                    aiz.LsB = aVar3.UbS.readString();
                    AppMethodBeat.o(109446);
                    return 0;
                case 10:
                    aiz.KHq = aVar3.UbS.readString();
                    AppMethodBeat.o(109446);
                    return 0;
                case 11:
                    aiz.LsC = aVar3.UbS.zi();
                    AppMethodBeat.o(109446);
                    return 0;
                case 12:
                    aiz.LbN = aVar3.UbS.readString();
                    AppMethodBeat.o(109446);
                    return 0;
                default:
                    AppMethodBeat.o(109446);
                    return -1;
            }
        } else {
            AppMethodBeat.o(109446);
            return -1;
        }
    }
}
