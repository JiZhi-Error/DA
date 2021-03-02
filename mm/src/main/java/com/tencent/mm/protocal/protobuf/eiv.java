package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eiv extends a {
    public LinkedList<aca> IDO = new LinkedList<>();
    public LinkedList<eiw> Mub = new LinkedList<>();
    public String NhX;
    public String NhY;
    public String NhZ;
    public String Nia;
    public long Nib;
    public dyi Nid;
    public boolean Nik;
    public String dDv;
    public int offset;
    public String sGQ;
    public int scene;

    public eiv() {
        AppMethodBeat.i(153010);
        AppMethodBeat.o(153010);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153011);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NhX != null) {
                aVar.e(1, this.NhX);
            }
            if (this.NhY != null) {
                aVar.e(2, this.NhY);
            }
            if (this.NhZ != null) {
                aVar.e(3, this.NhZ);
            }
            if (this.Nia != null) {
                aVar.e(4, this.Nia);
            }
            if (this.Nid != null) {
                aVar.ni(5, this.Nid.computeSize());
                this.Nid.writeFields(aVar);
            }
            aVar.bb(6, this.Nib);
            if (this.sGQ != null) {
                aVar.e(7, this.sGQ);
            }
            aVar.aM(8, this.offset);
            aVar.cc(9, this.Nik);
            aVar.aM(10, this.scene);
            if (this.dDv != null) {
                aVar.e(11, this.dDv);
            }
            aVar.e(12, 8, this.Mub);
            aVar.e(13, 8, this.IDO);
            AppMethodBeat.o(153011);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.NhX != null ? g.a.a.b.b.a.f(1, this.NhX) + 0 : 0;
            if (this.NhY != null) {
                f2 += g.a.a.b.b.a.f(2, this.NhY);
            }
            if (this.NhZ != null) {
                f2 += g.a.a.b.b.a.f(3, this.NhZ);
            }
            if (this.Nia != null) {
                f2 += g.a.a.b.b.a.f(4, this.Nia);
            }
            if (this.Nid != null) {
                f2 += g.a.a.a.nh(5, this.Nid.computeSize());
            }
            int r = f2 + g.a.a.b.b.a.r(6, this.Nib);
            if (this.sGQ != null) {
                r += g.a.a.b.b.a.f(7, this.sGQ);
            }
            int bu = r + g.a.a.b.b.a.bu(8, this.offset) + g.a.a.b.b.a.fS(9) + 1 + g.a.a.b.b.a.bu(10, this.scene);
            if (this.dDv != null) {
                bu += g.a.a.b.b.a.f(11, this.dDv);
            }
            int c2 = bu + g.a.a.a.c(12, 8, this.Mub) + g.a.a.a.c(13, 8, this.IDO);
            AppMethodBeat.o(153011);
            return c2;
        } else if (i2 == 2) {
            this.Mub.clear();
            this.IDO.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153011);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eiv eiv = (eiv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eiv.NhX = aVar3.UbS.readString();
                    AppMethodBeat.o(153011);
                    return 0;
                case 2:
                    eiv.NhY = aVar3.UbS.readString();
                    AppMethodBeat.o(153011);
                    return 0;
                case 3:
                    eiv.NhZ = aVar3.UbS.readString();
                    AppMethodBeat.o(153011);
                    return 0;
                case 4:
                    eiv.Nia = aVar3.UbS.readString();
                    AppMethodBeat.o(153011);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dyi dyi = new dyi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dyi.populateBuilderWithField(aVar4, dyi, a.getNextFieldNumber(aVar4))) {
                        }
                        eiv.Nid = dyi;
                    }
                    AppMethodBeat.o(153011);
                    return 0;
                case 6:
                    eiv.Nib = aVar3.UbS.zl();
                    AppMethodBeat.o(153011);
                    return 0;
                case 7:
                    eiv.sGQ = aVar3.UbS.readString();
                    AppMethodBeat.o(153011);
                    return 0;
                case 8:
                    eiv.offset = aVar3.UbS.zi();
                    AppMethodBeat.o(153011);
                    return 0;
                case 9:
                    eiv.Nik = aVar3.UbS.yZ();
                    AppMethodBeat.o(153011);
                    return 0;
                case 10:
                    eiv.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(153011);
                    return 0;
                case 11:
                    eiv.dDv = aVar3.UbS.readString();
                    AppMethodBeat.o(153011);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eiw eiw = new eiw();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eiw.populateBuilderWithField(aVar5, eiw, a.getNextFieldNumber(aVar5))) {
                        }
                        eiv.Mub.add(eiw);
                    }
                    AppMethodBeat.o(153011);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        aca aca = new aca();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = aca.populateBuilderWithField(aVar6, aca, a.getNextFieldNumber(aVar6))) {
                        }
                        eiv.IDO.add(aca);
                    }
                    AppMethodBeat.o(153011);
                    return 0;
                default:
                    AppMethodBeat.o(153011);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153011);
            return -1;
        }
    }
}
