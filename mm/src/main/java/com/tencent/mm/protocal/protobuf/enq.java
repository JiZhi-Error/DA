package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class enq extends dop {
    public int BsF;
    public int BsG;
    public int BsH;
    public SKBuiltinBuffer_t BsI;
    public dqi Nlu;
    public dqi Nlv;
    public int Nlw;
    public int Nlx;
    public int Nly;
    public int Nlz;
    public int xuT;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(148659);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.Nlu == null) {
                b bVar = new b("Not all required fields were included: ClientMediaId");
                AppMethodBeat.o(148659);
                throw bVar;
            } else if (this.Nlv == null) {
                b bVar2 = new b("Not all required fields were included: DataMD5");
                AppMethodBeat.o(148659);
                throw bVar2;
            } else if (this.BsI == null) {
                b bVar3 = new b("Not all required fields were included: Data");
                AppMethodBeat.o(148659);
                throw bVar3;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.Nlu != null) {
                    aVar.ni(2, this.Nlu.computeSize());
                    this.Nlu.writeFields(aVar);
                }
                if (this.Nlv != null) {
                    aVar.ni(3, this.Nlv.computeSize());
                    this.Nlv.writeFields(aVar);
                }
                aVar.aM(4, this.BsF);
                aVar.aM(5, this.BsG);
                aVar.aM(6, this.BsH);
                if (this.BsI != null) {
                    aVar.ni(7, this.BsI.computeSize());
                    this.BsI.writeFields(aVar);
                }
                aVar.aM(8, this.xuT);
                aVar.aM(9, this.Nlw);
                aVar.aM(10, this.Nlx);
                aVar.aM(11, this.Nly);
                aVar.aM(12, this.Nlz);
                AppMethodBeat.o(148659);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.Nlu != null) {
                nh += g.a.a.a.nh(2, this.Nlu.computeSize());
            }
            if (this.Nlv != null) {
                nh += g.a.a.a.nh(3, this.Nlv.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.BsF) + g.a.a.b.b.a.bu(5, this.BsG) + g.a.a.b.b.a.bu(6, this.BsH);
            if (this.BsI != null) {
                bu += g.a.a.a.nh(7, this.BsI.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.xuT) + g.a.a.b.b.a.bu(9, this.Nlw) + g.a.a.b.b.a.bu(10, this.Nlx) + g.a.a.b.b.a.bu(11, this.Nly) + g.a.a.b.b.a.bu(12, this.Nlz);
            AppMethodBeat.o(148659);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Nlu == null) {
                b bVar4 = new b("Not all required fields were included: ClientMediaId");
                AppMethodBeat.o(148659);
                throw bVar4;
            } else if (this.Nlv == null) {
                b bVar5 = new b("Not all required fields were included: DataMD5");
                AppMethodBeat.o(148659);
                throw bVar5;
            } else if (this.BsI == null) {
                b bVar6 = new b("Not all required fields were included: Data");
                AppMethodBeat.o(148659);
                throw bVar6;
            } else {
                AppMethodBeat.o(148659);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            enq enq = (enq) objArr[1];
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
                        enq.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(148659);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi.populateBuilderWithField(aVar5, dqi, dop.getNextFieldNumber(aVar5))) {
                        }
                        enq.Nlu = dqi;
                    }
                    AppMethodBeat.o(148659);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi2.populateBuilderWithField(aVar6, dqi2, dop.getNextFieldNumber(aVar6))) {
                        }
                        enq.Nlv = dqi2;
                    }
                    AppMethodBeat.o(148659);
                    return 0;
                case 4:
                    enq.BsF = aVar3.UbS.zi();
                    AppMethodBeat.o(148659);
                    return 0;
                case 5:
                    enq.BsG = aVar3.UbS.zi();
                    AppMethodBeat.o(148659);
                    return 0;
                case 6:
                    enq.BsH = aVar3.UbS.zi();
                    AppMethodBeat.o(148659);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = sKBuiltinBuffer_t.populateBuilderWithField(aVar7, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar7))) {
                        }
                        enq.BsI = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(148659);
                    return 0;
                case 8:
                    enq.xuT = aVar3.UbS.zi();
                    AppMethodBeat.o(148659);
                    return 0;
                case 9:
                    enq.Nlw = aVar3.UbS.zi();
                    AppMethodBeat.o(148659);
                    return 0;
                case 10:
                    enq.Nlx = aVar3.UbS.zi();
                    AppMethodBeat.o(148659);
                    return 0;
                case 11:
                    enq.Nly = aVar3.UbS.zi();
                    AppMethodBeat.o(148659);
                    return 0;
                case 12:
                    enq.Nlz = aVar3.UbS.zi();
                    AppMethodBeat.o(148659);
                    return 0;
                default:
                    AppMethodBeat.o(148659);
                    return -1;
            }
        } else {
            AppMethodBeat.o(148659);
            return -1;
        }
    }
}
