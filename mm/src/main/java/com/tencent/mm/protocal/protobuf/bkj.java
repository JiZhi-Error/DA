package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bkj extends dop {
    public String KDf;
    public String KDg;
    public int KDh;
    public eck KDj;
    public String LTz;
    public String eaO;
    public String eaP;
    public int eaQ;
    public String pPy;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(114010);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.eaO == null) {
                b bVar = new b("Not all required fields were included: card_id");
                AppMethodBeat.o(114010);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.eaO != null) {
                aVar.e(2, this.eaO);
            }
            aVar.aM(3, this.eaQ);
            if (this.pPy != null) {
                aVar.e(4, this.pPy);
            }
            if (this.eaP != null) {
                aVar.e(5, this.eaP);
            }
            if (this.KDf != null) {
                aVar.e(6, this.KDf);
            }
            if (this.KDg != null) {
                aVar.e(7, this.KDg);
            }
            aVar.aM(8, this.KDh);
            if (this.LTz != null) {
                aVar.e(9, this.LTz);
            }
            if (this.KDj != null) {
                aVar.ni(10, this.KDj.computeSize());
                this.KDj.writeFields(aVar);
            }
            AppMethodBeat.o(114010);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.eaO != null) {
                nh += g.a.a.b.b.a.f(2, this.eaO);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.eaQ);
            if (this.pPy != null) {
                bu += g.a.a.b.b.a.f(4, this.pPy);
            }
            if (this.eaP != null) {
                bu += g.a.a.b.b.a.f(5, this.eaP);
            }
            if (this.KDf != null) {
                bu += g.a.a.b.b.a.f(6, this.KDf);
            }
            if (this.KDg != null) {
                bu += g.a.a.b.b.a.f(7, this.KDg);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.KDh);
            if (this.LTz != null) {
                bu2 += g.a.a.b.b.a.f(9, this.LTz);
            }
            if (this.KDj != null) {
                bu2 += g.a.a.a.nh(10, this.KDj.computeSize());
            }
            AppMethodBeat.o(114010);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.eaO == null) {
                b bVar2 = new b("Not all required fields were included: card_id");
                AppMethodBeat.o(114010);
                throw bVar2;
            }
            AppMethodBeat.o(114010);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bkj bkj = (bkj) objArr[1];
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
                        bkj.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(114010);
                    return 0;
                case 2:
                    bkj.eaO = aVar3.UbS.readString();
                    AppMethodBeat.o(114010);
                    return 0;
                case 3:
                    bkj.eaQ = aVar3.UbS.zi();
                    AppMethodBeat.o(114010);
                    return 0;
                case 4:
                    bkj.pPy = aVar3.UbS.readString();
                    AppMethodBeat.o(114010);
                    return 0;
                case 5:
                    bkj.eaP = aVar3.UbS.readString();
                    AppMethodBeat.o(114010);
                    return 0;
                case 6:
                    bkj.KDf = aVar3.UbS.readString();
                    AppMethodBeat.o(114010);
                    return 0;
                case 7:
                    bkj.KDg = aVar3.UbS.readString();
                    AppMethodBeat.o(114010);
                    return 0;
                case 8:
                    bkj.KDh = aVar3.UbS.zi();
                    AppMethodBeat.o(114010);
                    return 0;
                case 9:
                    bkj.LTz = aVar3.UbS.readString();
                    AppMethodBeat.o(114010);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eck eck = new eck();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eck.populateBuilderWithField(aVar5, eck, dop.getNextFieldNumber(aVar5))) {
                        }
                        bkj.KDj = eck;
                    }
                    AppMethodBeat.o(114010);
                    return 0;
                default:
                    AppMethodBeat.o(114010);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114010);
            return -1;
        }
    }
}