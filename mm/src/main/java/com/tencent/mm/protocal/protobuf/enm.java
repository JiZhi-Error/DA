package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class enm extends dop {
    public SKBuiltinBuffer_t BsI;
    public int KKA;
    public int KKD;
    public int KZk;
    public String Nln;
    public int Nlo;
    public int Nlp;
    public String UserName;
    public int jeU;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(148657);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BsI == null) {
                b bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(148657);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.UserName != null) {
                aVar.e(2, this.UserName);
            }
            if (this.BsI != null) {
                aVar.ni(3, this.BsI.computeSize());
                this.BsI.writeFields(aVar);
            }
            aVar.aM(4, this.KZk);
            if (this.Nln != null) {
                aVar.e(5, this.Nln);
            }
            aVar.aM(6, this.jeU);
            aVar.aM(7, this.Nlo);
            aVar.aM(8, this.KKD);
            aVar.aM(9, this.Nlp);
            aVar.aM(10, this.KKA);
            AppMethodBeat.o(148657);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.UserName != null) {
                nh += g.a.a.b.b.a.f(2, this.UserName);
            }
            if (this.BsI != null) {
                nh += g.a.a.a.nh(3, this.BsI.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.KZk);
            if (this.Nln != null) {
                bu += g.a.a.b.b.a.f(5, this.Nln);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.jeU) + g.a.a.b.b.a.bu(7, this.Nlo) + g.a.a.b.b.a.bu(8, this.KKD) + g.a.a.b.b.a.bu(9, this.Nlp) + g.a.a.b.b.a.bu(10, this.KKA);
            AppMethodBeat.o(148657);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BsI == null) {
                b bVar2 = new b("Not all required fields were included: Data");
                AppMethodBeat.o(148657);
                throw bVar2;
            }
            AppMethodBeat.o(148657);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            enm enm = (enm) objArr[1];
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
                        enm.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(148657);
                    return 0;
                case 2:
                    enm.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(148657);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        enm.BsI = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(148657);
                    return 0;
                case 4:
                    enm.KZk = aVar3.UbS.zi();
                    AppMethodBeat.o(148657);
                    return 0;
                case 5:
                    enm.Nln = aVar3.UbS.readString();
                    AppMethodBeat.o(148657);
                    return 0;
                case 6:
                    enm.jeU = aVar3.UbS.zi();
                    AppMethodBeat.o(148657);
                    return 0;
                case 7:
                    enm.Nlo = aVar3.UbS.zi();
                    AppMethodBeat.o(148657);
                    return 0;
                case 8:
                    enm.KKD = aVar3.UbS.zi();
                    AppMethodBeat.o(148657);
                    return 0;
                case 9:
                    enm.Nlp = aVar3.UbS.zi();
                    AppMethodBeat.o(148657);
                    return 0;
                case 10:
                    enm.KKA = aVar3.UbS.zi();
                    AppMethodBeat.o(148657);
                    return 0;
                default:
                    AppMethodBeat.o(148657);
                    return -1;
            }
        } else {
            AppMethodBeat.o(148657);
            return -1;
        }
    }
}
