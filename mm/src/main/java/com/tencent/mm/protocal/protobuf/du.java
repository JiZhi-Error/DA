package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class du extends a {
    public int Coi;
    public String CpJ;
    public String KHM;
    public String KHN;
    public String KHO;
    public anr KHP;
    public int KHQ;
    public int channel;
    public String jTz;
    public int scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91349);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KHM == null) {
                b bVar = new b("Not all required fields were included: f2f_id");
                AppMethodBeat.o(91349);
                throw bVar;
            } else if (this.KHO == null) {
                b bVar2 = new b("Not all required fields were included: payok_checksign");
                AppMethodBeat.o(91349);
                throw bVar2;
            } else {
                if (this.KHM != null) {
                    aVar.e(1, this.KHM);
                }
                if (this.KHN != null) {
                    aVar.e(2, this.KHN);
                }
                aVar.aM(3, this.channel);
                aVar.aM(4, this.Coi);
                aVar.aM(5, this.scene);
                if (this.KHO != null) {
                    aVar.e(6, this.KHO);
                }
                if (this.KHP != null) {
                    aVar.ni(7, this.KHP.computeSize());
                    this.KHP.writeFields(aVar);
                }
                if (this.jTz != null) {
                    aVar.e(8, this.jTz);
                }
                if (this.CpJ != null) {
                    aVar.e(9, this.CpJ);
                }
                aVar.aM(10, this.KHQ);
                AppMethodBeat.o(91349);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.KHM != null ? g.a.a.b.b.a.f(1, this.KHM) + 0 : 0;
            if (this.KHN != null) {
                f2 += g.a.a.b.b.a.f(2, this.KHN);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.channel) + g.a.a.b.b.a.bu(4, this.Coi) + g.a.a.b.b.a.bu(5, this.scene);
            if (this.KHO != null) {
                bu += g.a.a.b.b.a.f(6, this.KHO);
            }
            if (this.KHP != null) {
                bu += g.a.a.a.nh(7, this.KHP.computeSize());
            }
            if (this.jTz != null) {
                bu += g.a.a.b.b.a.f(8, this.jTz);
            }
            if (this.CpJ != null) {
                bu += g.a.a.b.b.a.f(9, this.CpJ);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(10, this.KHQ);
            AppMethodBeat.o(91349);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KHM == null) {
                b bVar3 = new b("Not all required fields were included: f2f_id");
                AppMethodBeat.o(91349);
                throw bVar3;
            } else if (this.KHO == null) {
                b bVar4 = new b("Not all required fields were included: payok_checksign");
                AppMethodBeat.o(91349);
                throw bVar4;
            } else {
                AppMethodBeat.o(91349);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            du duVar = (du) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    duVar.KHM = aVar3.UbS.readString();
                    AppMethodBeat.o(91349);
                    return 0;
                case 2:
                    duVar.KHN = aVar3.UbS.readString();
                    AppMethodBeat.o(91349);
                    return 0;
                case 3:
                    duVar.channel = aVar3.UbS.zi();
                    AppMethodBeat.o(91349);
                    return 0;
                case 4:
                    duVar.Coi = aVar3.UbS.zi();
                    AppMethodBeat.o(91349);
                    return 0;
                case 5:
                    duVar.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(91349);
                    return 0;
                case 6:
                    duVar.KHO = aVar3.UbS.readString();
                    AppMethodBeat.o(91349);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        anr anr = new anr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = anr.populateBuilderWithField(aVar4, anr, a.getNextFieldNumber(aVar4))) {
                        }
                        duVar.KHP = anr;
                    }
                    AppMethodBeat.o(91349);
                    return 0;
                case 8:
                    duVar.jTz = aVar3.UbS.readString();
                    AppMethodBeat.o(91349);
                    return 0;
                case 9:
                    duVar.CpJ = aVar3.UbS.readString();
                    AppMethodBeat.o(91349);
                    return 0;
                case 10:
                    duVar.KHQ = aVar3.UbS.zi();
                    AppMethodBeat.o(91349);
                    return 0;
                default:
                    AppMethodBeat.o(91349);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91349);
            return -1;
        }
    }
}
