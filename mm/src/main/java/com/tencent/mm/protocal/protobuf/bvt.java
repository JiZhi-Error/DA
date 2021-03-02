package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bvt extends dop {
    public String KLN;
    public SKBuiltinBuffer_t KPW;
    public int LtW;
    public String MbG;
    public String MbH;
    public String MbI;
    public String MbJ;
    public String MbK;
    public String oUJ;
    public String rBI;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(155417);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.KPW == null) {
                b bVar = new b("Not all required fields were included: RandomEncryKey");
                AppMethodBeat.o(155417);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KPW != null) {
                aVar.ni(2, this.KPW.computeSize());
                this.KPW.writeFields(aVar);
            }
            if (this.MbG != null) {
                aVar.e(3, this.MbG);
            }
            if (this.MbH != null) {
                aVar.e(4, this.MbH);
            }
            if (this.oUJ != null) {
                aVar.e(5, this.oUJ);
            }
            if (this.MbI != null) {
                aVar.e(6, this.MbI);
            }
            if (this.MbJ != null) {
                aVar.e(7, this.MbJ);
            }
            if (this.MbK != null) {
                aVar.e(8, this.MbK);
            }
            aVar.aM(9, this.LtW);
            if (this.rBI != null) {
                aVar.e(10, this.rBI);
            }
            if (this.KLN != null) {
                aVar.e(11, this.KLN);
            }
            AppMethodBeat.o(155417);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KPW != null) {
                nh += g.a.a.a.nh(2, this.KPW.computeSize());
            }
            if (this.MbG != null) {
                nh += g.a.a.b.b.a.f(3, this.MbG);
            }
            if (this.MbH != null) {
                nh += g.a.a.b.b.a.f(4, this.MbH);
            }
            if (this.oUJ != null) {
                nh += g.a.a.b.b.a.f(5, this.oUJ);
            }
            if (this.MbI != null) {
                nh += g.a.a.b.b.a.f(6, this.MbI);
            }
            if (this.MbJ != null) {
                nh += g.a.a.b.b.a.f(7, this.MbJ);
            }
            if (this.MbK != null) {
                nh += g.a.a.b.b.a.f(8, this.MbK);
            }
            int bu = nh + g.a.a.b.b.a.bu(9, this.LtW);
            if (this.rBI != null) {
                bu += g.a.a.b.b.a.f(10, this.rBI);
            }
            if (this.KLN != null) {
                bu += g.a.a.b.b.a.f(11, this.KLN);
            }
            AppMethodBeat.o(155417);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KPW == null) {
                b bVar2 = new b("Not all required fields were included: RandomEncryKey");
                AppMethodBeat.o(155417);
                throw bVar2;
            }
            AppMethodBeat.o(155417);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bvt bvt = (bvt) objArr[1];
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
                        bvt.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(155417);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        bvt.KPW = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(155417);
                    return 0;
                case 3:
                    bvt.MbG = aVar3.UbS.readString();
                    AppMethodBeat.o(155417);
                    return 0;
                case 4:
                    bvt.MbH = aVar3.UbS.readString();
                    AppMethodBeat.o(155417);
                    return 0;
                case 5:
                    bvt.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(155417);
                    return 0;
                case 6:
                    bvt.MbI = aVar3.UbS.readString();
                    AppMethodBeat.o(155417);
                    return 0;
                case 7:
                    bvt.MbJ = aVar3.UbS.readString();
                    AppMethodBeat.o(155417);
                    return 0;
                case 8:
                    bvt.MbK = aVar3.UbS.readString();
                    AppMethodBeat.o(155417);
                    return 0;
                case 9:
                    bvt.LtW = aVar3.UbS.zi();
                    AppMethodBeat.o(155417);
                    return 0;
                case 10:
                    bvt.rBI = aVar3.UbS.readString();
                    AppMethodBeat.o(155417);
                    return 0;
                case 11:
                    bvt.KLN = aVar3.UbS.readString();
                    AppMethodBeat.o(155417);
                    return 0;
                default:
                    AppMethodBeat.o(155417);
                    return -1;
            }
        } else {
            AppMethodBeat.o(155417);
            return -1;
        }
    }
}
