package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bde extends dop {
    public LinkedList<FinderContact> LDz = new LinkedList<>();
    public LinkedList<FinderContact> LKE = new LinkedList<>();
    public SKBuiltinBuffer_t LMX;
    public LinkedList<bbi> LMY = new LinkedList<>();
    public String LMZ;
    public LinkedList<bbi> LNa = new LinkedList<>();
    public String LNb;
    public int VjH;
    public int dML;
    public String finderUsername;
    public int scene;
    public aov uli;

    public bde() {
        AppMethodBeat.i(169060);
        AppMethodBeat.o(169060);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169061);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.dML);
            if (this.LMX != null) {
                aVar.ni(3, this.LMX.computeSize());
                this.LMX.writeFields(aVar);
            }
            aVar.e(4, 8, this.LDz);
            aVar.e(5, 8, this.LKE);
            if (this.finderUsername != null) {
                aVar.e(6, this.finderUsername);
            }
            if (this.uli != null) {
                aVar.ni(7, this.uli.computeSize());
                this.uli.writeFields(aVar);
            }
            aVar.aM(8, this.scene);
            aVar.e(9, 8, this.LMY);
            if (this.LMZ != null) {
                aVar.e(10, this.LMZ);
            }
            aVar.e(11, 8, this.LNa);
            if (this.LNb != null) {
                aVar.e(12, this.LNb);
            }
            aVar.aM(13, this.VjH);
            AppMethodBeat.o(169061);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dML);
            if (this.LMX != null) {
                nh += g.a.a.a.nh(3, this.LMX.computeSize());
            }
            int c2 = nh + g.a.a.a.c(4, 8, this.LDz) + g.a.a.a.c(5, 8, this.LKE);
            if (this.finderUsername != null) {
                c2 += g.a.a.b.b.a.f(6, this.finderUsername);
            }
            if (this.uli != null) {
                c2 += g.a.a.a.nh(7, this.uli.computeSize());
            }
            int bu = c2 + g.a.a.b.b.a.bu(8, this.scene) + g.a.a.a.c(9, 8, this.LMY);
            if (this.LMZ != null) {
                bu += g.a.a.b.b.a.f(10, this.LMZ);
            }
            int c3 = bu + g.a.a.a.c(11, 8, this.LNa);
            if (this.LNb != null) {
                c3 += g.a.a.b.b.a.f(12, this.LNb);
            }
            int bu2 = c3 + g.a.a.b.b.a.bu(13, this.VjH);
            AppMethodBeat.o(169061);
            return bu2;
        } else if (i2 == 2) {
            this.LDz.clear();
            this.LKE.clear();
            this.LMY.clear();
            this.LNa.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169061);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bde bde = (bde) objArr[1];
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
                        bde.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(169061);
                    return 0;
                case 2:
                    bde.dML = aVar3.UbS.zi();
                    AppMethodBeat.o(169061);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        bde.LMX = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(169061);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        FinderContact finderContact = new FinderContact();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = finderContact.populateBuilderWithField(aVar6, finderContact, dop.getNextFieldNumber(aVar6))) {
                        }
                        bde.LDz.add(finderContact);
                    }
                    AppMethodBeat.o(169061);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        FinderContact finderContact2 = new FinderContact();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = finderContact2.populateBuilderWithField(aVar7, finderContact2, dop.getNextFieldNumber(aVar7))) {
                        }
                        bde.LKE.add(finderContact2);
                    }
                    AppMethodBeat.o(169061);
                    return 0;
                case 6:
                    bde.finderUsername = aVar3.UbS.readString();
                    AppMethodBeat.o(169061);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = aov.populateBuilderWithField(aVar8, aov, dop.getNextFieldNumber(aVar8))) {
                        }
                        bde.uli = aov;
                    }
                    AppMethodBeat.o(169061);
                    return 0;
                case 8:
                    bde.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(169061);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        bbi bbi = new bbi();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = bbi.populateBuilderWithField(aVar9, bbi, dop.getNextFieldNumber(aVar9))) {
                        }
                        bde.LMY.add(bbi);
                    }
                    AppMethodBeat.o(169061);
                    return 0;
                case 10:
                    bde.LMZ = aVar3.UbS.readString();
                    AppMethodBeat.o(169061);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        bbi bbi2 = new bbi();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = bbi2.populateBuilderWithField(aVar10, bbi2, dop.getNextFieldNumber(aVar10))) {
                        }
                        bde.LNa.add(bbi2);
                    }
                    AppMethodBeat.o(169061);
                    return 0;
                case 12:
                    bde.LNb = aVar3.UbS.readString();
                    AppMethodBeat.o(169061);
                    return 0;
                case 13:
                    bde.VjH = aVar3.UbS.zi();
                    AppMethodBeat.o(169061);
                    return 0;
                default:
                    AppMethodBeat.o(169061);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169061);
            return -1;
        }
    }
}
