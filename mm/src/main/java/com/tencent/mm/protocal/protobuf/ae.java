package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ae extends dop {
    public String KCA;
    public String KCt;
    public String KCu;
    public String KCv;
    public LinkedList<ei> KCw = new LinkedList<>();
    public int KCx;
    public String KCy;
    public int KCz;
    public int OpCode;
    public String SSID;
    public String URL;

    public ae() {
        AppMethodBeat.i(32095);
        AppMethodBeat.o(32095);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32096);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.URL != null) {
                aVar.e(2, this.URL);
            }
            if (this.SSID != null) {
                aVar.e(3, this.SSID);
            }
            if (this.KCt != null) {
                aVar.e(4, this.KCt);
            }
            if (this.KCu != null) {
                aVar.e(5, this.KCu);
            }
            if (this.KCv != null) {
                aVar.e(6, this.KCv);
            }
            aVar.aM(7, this.OpCode);
            aVar.e(8, 8, this.KCw);
            aVar.aM(9, this.KCx);
            if (this.KCy != null) {
                aVar.e(10, this.KCy);
            }
            aVar.aM(11, this.KCz);
            if (this.KCA != null) {
                aVar.e(12, this.KCA);
            }
            AppMethodBeat.o(32096);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.URL != null) {
                nh += g.a.a.b.b.a.f(2, this.URL);
            }
            if (this.SSID != null) {
                nh += g.a.a.b.b.a.f(3, this.SSID);
            }
            if (this.KCt != null) {
                nh += g.a.a.b.b.a.f(4, this.KCt);
            }
            if (this.KCu != null) {
                nh += g.a.a.b.b.a.f(5, this.KCu);
            }
            if (this.KCv != null) {
                nh += g.a.a.b.b.a.f(6, this.KCv);
            }
            int bu = nh + g.a.a.b.b.a.bu(7, this.OpCode) + g.a.a.a.c(8, 8, this.KCw) + g.a.a.b.b.a.bu(9, this.KCx);
            if (this.KCy != null) {
                bu += g.a.a.b.b.a.f(10, this.KCy);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(11, this.KCz);
            if (this.KCA != null) {
                bu2 += g.a.a.b.b.a.f(12, this.KCA);
            }
            AppMethodBeat.o(32096);
            return bu2;
        } else if (i2 == 2) {
            this.KCw.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32096);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ae aeVar = (ae) objArr[1];
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
                        aeVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32096);
                    return 0;
                case 2:
                    aeVar.URL = aVar3.UbS.readString();
                    AppMethodBeat.o(32096);
                    return 0;
                case 3:
                    aeVar.SSID = aVar3.UbS.readString();
                    AppMethodBeat.o(32096);
                    return 0;
                case 4:
                    aeVar.KCt = aVar3.UbS.readString();
                    AppMethodBeat.o(32096);
                    return 0;
                case 5:
                    aeVar.KCu = aVar3.UbS.readString();
                    AppMethodBeat.o(32096);
                    return 0;
                case 6:
                    aeVar.KCv = aVar3.UbS.readString();
                    AppMethodBeat.o(32096);
                    return 0;
                case 7:
                    aeVar.OpCode = aVar3.UbS.zi();
                    AppMethodBeat.o(32096);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ei eiVar = new ei();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eiVar.populateBuilderWithField(aVar5, eiVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        aeVar.KCw.add(eiVar);
                    }
                    AppMethodBeat.o(32096);
                    return 0;
                case 9:
                    aeVar.KCx = aVar3.UbS.zi();
                    AppMethodBeat.o(32096);
                    return 0;
                case 10:
                    aeVar.KCy = aVar3.UbS.readString();
                    AppMethodBeat.o(32096);
                    return 0;
                case 11:
                    aeVar.KCz = aVar3.UbS.zi();
                    AppMethodBeat.o(32096);
                    return 0;
                case 12:
                    aeVar.KCA = aVar3.UbS.readString();
                    AppMethodBeat.o(32096);
                    return 0;
                default:
                    AppMethodBeat.o(32096);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32096);
            return -1;
        }
    }
}
