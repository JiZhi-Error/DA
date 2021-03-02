package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class emy extends dop {
    public int BsF;
    public int BsG;
    public int BsH;
    public SKBuiltinBuffer_t BsI;
    public int KIy;
    public String MD5;
    public String NkS;
    public String UserName;
    public String jfi;
    public int oUv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32484);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BsI == null) {
                b bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(32484);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.jfi != null) {
                aVar.e(2, this.jfi);
            }
            aVar.aM(3, this.KIy);
            if (this.NkS != null) {
                aVar.e(4, this.NkS);
            }
            if (this.UserName != null) {
                aVar.e(5, this.UserName);
            }
            aVar.aM(6, this.BsF);
            aVar.aM(7, this.BsG);
            aVar.aM(8, this.BsH);
            if (this.BsI != null) {
                aVar.ni(9, this.BsI.computeSize());
                this.BsI.writeFields(aVar);
            }
            aVar.aM(10, this.oUv);
            if (this.MD5 != null) {
                aVar.e(11, this.MD5);
            }
            AppMethodBeat.o(32484);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.jfi != null) {
                nh += g.a.a.b.b.a.f(2, this.jfi);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.KIy);
            if (this.NkS != null) {
                bu += g.a.a.b.b.a.f(4, this.NkS);
            }
            if (this.UserName != null) {
                bu += g.a.a.b.b.a.f(5, this.UserName);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.BsF) + g.a.a.b.b.a.bu(7, this.BsG) + g.a.a.b.b.a.bu(8, this.BsH);
            if (this.BsI != null) {
                bu2 += g.a.a.a.nh(9, this.BsI.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(10, this.oUv);
            if (this.MD5 != null) {
                bu3 += g.a.a.b.b.a.f(11, this.MD5);
            }
            AppMethodBeat.o(32484);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BsI == null) {
                b bVar2 = new b("Not all required fields were included: Data");
                AppMethodBeat.o(32484);
                throw bVar2;
            }
            AppMethodBeat.o(32484);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            emy emy = (emy) objArr[1];
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
                        emy.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32484);
                    return 0;
                case 2:
                    emy.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(32484);
                    return 0;
                case 3:
                    emy.KIy = aVar3.UbS.zi();
                    AppMethodBeat.o(32484);
                    return 0;
                case 4:
                    emy.NkS = aVar3.UbS.readString();
                    AppMethodBeat.o(32484);
                    return 0;
                case 5:
                    emy.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(32484);
                    return 0;
                case 6:
                    emy.BsF = aVar3.UbS.zi();
                    AppMethodBeat.o(32484);
                    return 0;
                case 7:
                    emy.BsG = aVar3.UbS.zi();
                    AppMethodBeat.o(32484);
                    return 0;
                case 8:
                    emy.BsH = aVar3.UbS.zi();
                    AppMethodBeat.o(32484);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        emy.BsI = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(32484);
                    return 0;
                case 10:
                    emy.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(32484);
                    return 0;
                case 11:
                    emy.MD5 = aVar3.UbS.readString();
                    AppMethodBeat.o(32484);
                    return 0;
                default:
                    AppMethodBeat.o(32484);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32484);
            return -1;
        }
    }
}
