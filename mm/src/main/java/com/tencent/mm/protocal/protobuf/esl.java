package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class esl extends dop {
    public SKBuiltinBuffer_t BsI;
    public int KXP;
    public int KZk;
    public dqi MRM;
    public String Nln;
    public int Nlp;
    public int NpB;
    public LinkedList<dqi> NpC = new LinkedList<>();
    public int NpD;
    public int Scene;
    public int jeU;

    public esl() {
        AppMethodBeat.i(148668);
        AppMethodBeat.o(148668);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(148669);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BsI == null) {
                b bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(148669);
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
            aVar.aM(3, this.KZk);
            if (this.Nln != null) {
                aVar.e(4, this.Nln);
            }
            aVar.aM(5, this.jeU);
            aVar.aM(6, this.Nlp);
            aVar.aM(7, this.KXP);
            aVar.aM(8, this.NpB);
            aVar.e(9, 8, this.NpC);
            if (this.MRM != null) {
                aVar.ni(10, this.MRM.computeSize());
                this.MRM.writeFields(aVar);
            }
            aVar.aM(11, this.NpD);
            aVar.aM(12, this.Scene);
            AppMethodBeat.o(148669);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.BsI != null) {
                nh += g.a.a.a.nh(2, this.BsI.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.KZk);
            if (this.Nln != null) {
                bu += g.a.a.b.b.a.f(4, this.Nln);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.jeU) + g.a.a.b.b.a.bu(6, this.Nlp) + g.a.a.b.b.a.bu(7, this.KXP) + g.a.a.b.b.a.bu(8, this.NpB) + g.a.a.a.c(9, 8, this.NpC);
            if (this.MRM != null) {
                bu2 += g.a.a.a.nh(10, this.MRM.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(11, this.NpD) + g.a.a.b.b.a.bu(12, this.Scene);
            AppMethodBeat.o(148669);
            return bu3;
        } else if (i2 == 2) {
            this.NpC.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BsI == null) {
                b bVar2 = new b("Not all required fields were included: Data");
                AppMethodBeat.o(148669);
                throw bVar2;
            }
            AppMethodBeat.o(148669);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            esl esl = (esl) objArr[1];
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
                        esl.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(148669);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        esl.BsI = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(148669);
                    return 0;
                case 3:
                    esl.KZk = aVar3.UbS.zi();
                    AppMethodBeat.o(148669);
                    return 0;
                case 4:
                    esl.Nln = aVar3.UbS.readString();
                    AppMethodBeat.o(148669);
                    return 0;
                case 5:
                    esl.jeU = aVar3.UbS.zi();
                    AppMethodBeat.o(148669);
                    return 0;
                case 6:
                    esl.Nlp = aVar3.UbS.zi();
                    AppMethodBeat.o(148669);
                    return 0;
                case 7:
                    esl.KXP = aVar3.UbS.zi();
                    AppMethodBeat.o(148669);
                    return 0;
                case 8:
                    esl.NpB = aVar3.UbS.zi();
                    AppMethodBeat.o(148669);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi.populateBuilderWithField(aVar6, dqi, dop.getNextFieldNumber(aVar6))) {
                        }
                        esl.NpC.add(dqi);
                    }
                    AppMethodBeat.o(148669);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dqi2.populateBuilderWithField(aVar7, dqi2, dop.getNextFieldNumber(aVar7))) {
                        }
                        esl.MRM = dqi2;
                    }
                    AppMethodBeat.o(148669);
                    return 0;
                case 11:
                    esl.NpD = aVar3.UbS.zi();
                    AppMethodBeat.o(148669);
                    return 0;
                case 12:
                    esl.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(148669);
                    return 0;
                default:
                    AppMethodBeat.o(148669);
                    return -1;
            }
        } else {
            AppMethodBeat.o(148669);
            return -1;
        }
    }
}
