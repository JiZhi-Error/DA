package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ena extends dop {
    public int BsF;
    public int BsG;
    public int BsH;
    public SKBuiltinBuffer_t BsI;
    public String Lqx;
    public String izX;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(90777);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BsI == null) {
                b bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(90777);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.izX != null) {
                aVar.e(2, this.izX);
            }
            aVar.aM(3, this.BsF);
            aVar.aM(4, this.BsG);
            aVar.aM(5, this.BsH);
            if (this.BsI != null) {
                aVar.ni(6, this.BsI.computeSize());
                this.BsI.writeFields(aVar);
            }
            if (this.Lqx != null) {
                aVar.e(7, this.Lqx);
            }
            AppMethodBeat.o(90777);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.izX != null) {
                nh += g.a.a.b.b.a.f(2, this.izX);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.BsF) + g.a.a.b.b.a.bu(4, this.BsG) + g.a.a.b.b.a.bu(5, this.BsH);
            if (this.BsI != null) {
                bu += g.a.a.a.nh(6, this.BsI.computeSize());
            }
            if (this.Lqx != null) {
                bu += g.a.a.b.b.a.f(7, this.Lqx);
            }
            AppMethodBeat.o(90777);
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
                AppMethodBeat.o(90777);
                throw bVar2;
            }
            AppMethodBeat.o(90777);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ena ena = (ena) objArr[1];
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
                        ena.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(90777);
                    return 0;
                case 2:
                    ena.izX = aVar3.UbS.readString();
                    AppMethodBeat.o(90777);
                    return 0;
                case 3:
                    ena.BsF = aVar3.UbS.zi();
                    AppMethodBeat.o(90777);
                    return 0;
                case 4:
                    ena.BsG = aVar3.UbS.zi();
                    AppMethodBeat.o(90777);
                    return 0;
                case 5:
                    ena.BsH = aVar3.UbS.zi();
                    AppMethodBeat.o(90777);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        ena.BsI = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(90777);
                    return 0;
                case 7:
                    ena.Lqx = aVar3.UbS.readString();
                    AppMethodBeat.o(90777);
                    return 0;
                default:
                    AppMethodBeat.o(90777);
                    return -1;
            }
        } else {
            AppMethodBeat.o(90777);
            return -1;
        }
    }
}