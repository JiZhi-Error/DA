package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bah extends dpc {
    public String KYV;
    public b LDs;
    public eak LJX;
    public FinderContact contact;
    public LinkedList<FinderObject> object = new LinkedList<>();
    public int tUC;

    public bah() {
        AppMethodBeat.i(209629);
        AppMethodBeat.o(209629);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209630);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.object);
            if (this.LDs != null) {
                aVar.c(3, this.LDs);
            }
            aVar.aM(4, this.tUC);
            if (this.LJX != null) {
                aVar.ni(5, this.LJX.computeSize());
                this.LJX.writeFields(aVar);
            }
            if (this.contact != null) {
                aVar.ni(6, this.contact.computeSize());
                this.contact.writeFields(aVar);
            }
            if (this.KYV != null) {
                aVar.e(7, this.KYV);
            }
            AppMethodBeat.o(209630);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.object);
            if (this.LDs != null) {
                nh += g.a.a.b.b.a.b(3, this.LDs);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.tUC);
            if (this.LJX != null) {
                bu += g.a.a.a.nh(5, this.LJX.computeSize());
            }
            if (this.contact != null) {
                bu += g.a.a.a.nh(6, this.contact.computeSize());
            }
            if (this.KYV != null) {
                bu += g.a.a.b.b.a.f(7, this.KYV);
            }
            AppMethodBeat.o(209630);
            return bu;
        } else if (i2 == 2) {
            this.object.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209630);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bah bah = (bah) objArr[1];
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
                        bah.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(209630);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        FinderObject finderObject = new FinderObject();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = finderObject.populateBuilderWithField(aVar5, finderObject, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bah.object.add(finderObject);
                    }
                    AppMethodBeat.o(209630);
                    return 0;
                case 3:
                    bah.LDs = aVar3.UbS.hPo();
                    AppMethodBeat.o(209630);
                    return 0;
                case 4:
                    bah.tUC = aVar3.UbS.zi();
                    AppMethodBeat.o(209630);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        eak eak = new eak();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = eak.populateBuilderWithField(aVar6, eak, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bah.LJX = eak;
                    }
                    AppMethodBeat.o(209630);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        FinderContact finderContact = new FinderContact();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = finderContact.populateBuilderWithField(aVar7, finderContact, dpc.getNextFieldNumber(aVar7))) {
                        }
                        bah.contact = finderContact;
                    }
                    AppMethodBeat.o(209630);
                    return 0;
                case 7:
                    bah.KYV = aVar3.UbS.readString();
                    AppMethodBeat.o(209630);
                    return 0;
                default:
                    AppMethodBeat.o(209630);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209630);
            return -1;
        }
    }
}
