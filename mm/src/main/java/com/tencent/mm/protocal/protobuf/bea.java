package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bea extends dpc {
    public LinkedList<FinderObject> LCW = new LinkedList<>();
    public int LNG;
    public int LNH;
    public int LNI;
    public aso LNJ;
    public FinderContact contact;

    public bea() {
        AppMethodBeat.i(209711);
        AppMethodBeat.o(209711);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209712);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.contact != null) {
                aVar.ni(2, this.contact.computeSize());
                this.contact.writeFields(aVar);
            }
            aVar.aM(3, this.LNG);
            aVar.e(4, 8, this.LCW);
            aVar.aM(5, this.LNH);
            aVar.aM(6, this.LNI);
            if (this.LNJ != null) {
                aVar.ni(7, this.LNJ.computeSize());
                this.LNJ.writeFields(aVar);
            }
            AppMethodBeat.o(209712);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.contact != null) {
                nh += g.a.a.a.nh(2, this.contact.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.LNG) + g.a.a.a.c(4, 8, this.LCW) + g.a.a.b.b.a.bu(5, this.LNH) + g.a.a.b.b.a.bu(6, this.LNI);
            if (this.LNJ != null) {
                bu += g.a.a.a.nh(7, this.LNJ.computeSize());
            }
            AppMethodBeat.o(209712);
            return bu;
        } else if (i2 == 2) {
            this.LCW.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209712);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bea bea = (bea) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        BaseResponse baseResponse = new BaseResponse();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, dpc.getNextFieldNumber(aVar4))) {
                        }
                        bea.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(209712);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        FinderContact finderContact = new FinderContact();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = finderContact.populateBuilderWithField(aVar5, finderContact, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bea.contact = finderContact;
                    }
                    AppMethodBeat.o(209712);
                    return 0;
                case 3:
                    bea.LNG = aVar3.UbS.zi();
                    AppMethodBeat.o(209712);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        FinderObject finderObject = new FinderObject();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = finderObject.populateBuilderWithField(aVar6, finderObject, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bea.LCW.add(finderObject);
                    }
                    AppMethodBeat.o(209712);
                    return 0;
                case 5:
                    bea.LNH = aVar3.UbS.zi();
                    AppMethodBeat.o(209712);
                    return 0;
                case 6:
                    bea.LNI = aVar3.UbS.zi();
                    AppMethodBeat.o(209712);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        aso aso = new aso();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = aso.populateBuilderWithField(aVar7, aso, dpc.getNextFieldNumber(aVar7))) {
                        }
                        bea.LNJ = aso;
                    }
                    AppMethodBeat.o(209712);
                    return 0;
                default:
                    AppMethodBeat.o(209712);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209712);
            return -1;
        }
    }
}