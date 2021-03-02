package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class fd extends a {
    public int CreateTime;
    public String KHq;
    public SKBuiltinBuffer_t KIA;
    public int KIB;
    public String KIC;
    public String KID;
    public String KIE;
    public int KIF;
    public int KIy;
    public String KIz;
    public String iAc;
    public String jfi;
    public int oUv;
    public String xNG;
    public String xNH;
    public int xub;
    public String xuk;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32116);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xNH != null) {
                aVar.e(1, this.xNH);
            }
            if (this.jfi != null) {
                aVar.e(2, this.jfi);
            }
            aVar.aM(3, this.KIy);
            if (this.xNG != null) {
                aVar.e(4, this.xNG);
            }
            aVar.aM(5, this.oUv);
            if (this.iAc != null) {
                aVar.e(6, this.iAc);
            }
            aVar.aM(7, this.CreateTime);
            if (this.KIz != null) {
                aVar.e(8, this.KIz);
            }
            if (this.KIA != null) {
                aVar.ni(9, this.KIA.computeSize());
                this.KIA.writeFields(aVar);
            }
            aVar.aM(10, this.xub);
            aVar.aM(11, this.KIB);
            if (this.KHq != null) {
                aVar.e(12, this.KHq);
            }
            if (this.KIC != null) {
                aVar.e(13, this.KIC);
            }
            if (this.KID != null) {
                aVar.e(14, this.KID);
            }
            if (this.KIE != null) {
                aVar.e(15, this.KIE);
            }
            aVar.aM(16, this.KIF);
            if (this.xuk != null) {
                aVar.e(17, this.xuk);
            }
            AppMethodBeat.o(32116);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xNH != null ? g.a.a.b.b.a.f(1, this.xNH) + 0 : 0;
            if (this.jfi != null) {
                f2 += g.a.a.b.b.a.f(2, this.jfi);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.KIy);
            if (this.xNG != null) {
                bu += g.a.a.b.b.a.f(4, this.xNG);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.oUv);
            if (this.iAc != null) {
                bu2 += g.a.a.b.b.a.f(6, this.iAc);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(7, this.CreateTime);
            if (this.KIz != null) {
                bu3 += g.a.a.b.b.a.f(8, this.KIz);
            }
            if (this.KIA != null) {
                bu3 += g.a.a.a.nh(9, this.KIA.computeSize());
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(10, this.xub) + g.a.a.b.b.a.bu(11, this.KIB);
            if (this.KHq != null) {
                bu4 += g.a.a.b.b.a.f(12, this.KHq);
            }
            if (this.KIC != null) {
                bu4 += g.a.a.b.b.a.f(13, this.KIC);
            }
            if (this.KID != null) {
                bu4 += g.a.a.b.b.a.f(14, this.KID);
            }
            if (this.KIE != null) {
                bu4 += g.a.a.b.b.a.f(15, this.KIE);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(16, this.KIF);
            if (this.xuk != null) {
                bu5 += g.a.a.b.b.a.f(17, this.xuk);
            }
            AppMethodBeat.o(32116);
            return bu5;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32116);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fd fdVar = (fd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    fdVar.xNH = aVar3.UbS.readString();
                    AppMethodBeat.o(32116);
                    return 0;
                case 2:
                    fdVar.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(32116);
                    return 0;
                case 3:
                    fdVar.KIy = aVar3.UbS.zi();
                    AppMethodBeat.o(32116);
                    return 0;
                case 4:
                    fdVar.xNG = aVar3.UbS.readString();
                    AppMethodBeat.o(32116);
                    return 0;
                case 5:
                    fdVar.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(32116);
                    return 0;
                case 6:
                    fdVar.iAc = aVar3.UbS.readString();
                    AppMethodBeat.o(32116);
                    return 0;
                case 7:
                    fdVar.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(32116);
                    return 0;
                case 8:
                    fdVar.KIz = aVar3.UbS.readString();
                    AppMethodBeat.o(32116);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        fdVar.KIA = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(32116);
                    return 0;
                case 10:
                    fdVar.xub = aVar3.UbS.zi();
                    AppMethodBeat.o(32116);
                    return 0;
                case 11:
                    fdVar.KIB = aVar3.UbS.zi();
                    AppMethodBeat.o(32116);
                    return 0;
                case 12:
                    fdVar.KHq = aVar3.UbS.readString();
                    AppMethodBeat.o(32116);
                    return 0;
                case 13:
                    fdVar.KIC = aVar3.UbS.readString();
                    AppMethodBeat.o(32116);
                    return 0;
                case 14:
                    fdVar.KID = aVar3.UbS.readString();
                    AppMethodBeat.o(32116);
                    return 0;
                case 15:
                    fdVar.KIE = aVar3.UbS.readString();
                    AppMethodBeat.o(32116);
                    return 0;
                case 16:
                    fdVar.KIF = aVar3.UbS.zi();
                    AppMethodBeat.o(32116);
                    return 0;
                case 17:
                    fdVar.xuk = aVar3.UbS.readString();
                    AppMethodBeat.o(32116);
                    return 0;
                default:
                    AppMethodBeat.o(32116);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32116);
            return -1;
        }
    }
}
