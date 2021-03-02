package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eit extends a {
    public LinkedList<aca> IDO = new LinkedList<>();
    public String NhX;
    public String NhY;
    public String NhZ;
    public String Nia;
    public long Nib;
    public eiw Nic;
    public dyi Nid;
    public boolean Nie;
    public LinkedList<eiw> Nif = new LinkedList<>();
    public int Nig;
    public int Nih;
    public String Nii;
    public int Nij;
    public boolean Nik;
    public String dDv;
    public boolean guh;
    public String hes;
    public int offset;
    public String sGQ;
    public int scene;

    public eit() {
        AppMethodBeat.i(153006);
        AppMethodBeat.o(153006);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153007);
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
            aVar.bb(5, this.Nib);
            aVar.aM(6, this.scene);
            if (this.hes != null) {
                aVar.e(7, this.hes);
            }
            if (this.dDv != null) {
                aVar.e(8, this.dDv);
            }
            if (this.Nic != null) {
                aVar.ni(9, this.Nic.computeSize());
                this.Nic.writeFields(aVar);
            }
            if (this.Nid != null) {
                aVar.ni(10, this.Nid.computeSize());
                this.Nid.writeFields(aVar);
            }
            aVar.e(11, 8, this.IDO);
            if (this.sGQ != null) {
                aVar.e(12, this.sGQ);
            }
            aVar.aM(13, this.offset);
            aVar.cc(14, this.Nie);
            aVar.e(15, 8, this.Nif);
            aVar.aM(16, this.Nig);
            aVar.aM(17, this.Nih);
            aVar.cc(18, this.guh);
            if (this.Nii != null) {
                aVar.e(19, this.Nii);
            }
            aVar.aM(20, this.Nij);
            aVar.cc(21, this.Nik);
            AppMethodBeat.o(153007);
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
            int r = f2 + g.a.a.b.b.a.r(5, this.Nib) + g.a.a.b.b.a.bu(6, this.scene);
            if (this.hes != null) {
                r += g.a.a.b.b.a.f(7, this.hes);
            }
            if (this.dDv != null) {
                r += g.a.a.b.b.a.f(8, this.dDv);
            }
            if (this.Nic != null) {
                r += g.a.a.a.nh(9, this.Nic.computeSize());
            }
            if (this.Nid != null) {
                r += g.a.a.a.nh(10, this.Nid.computeSize());
            }
            int c2 = r + g.a.a.a.c(11, 8, this.IDO);
            if (this.sGQ != null) {
                c2 += g.a.a.b.b.a.f(12, this.sGQ);
            }
            int bu = c2 + g.a.a.b.b.a.bu(13, this.offset) + g.a.a.b.b.a.fS(14) + 1 + g.a.a.a.c(15, 8, this.Nif) + g.a.a.b.b.a.bu(16, this.Nig) + g.a.a.b.b.a.bu(17, this.Nih) + g.a.a.b.b.a.fS(18) + 1;
            if (this.Nii != null) {
                bu += g.a.a.b.b.a.f(19, this.Nii);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(20, this.Nij) + g.a.a.b.b.a.fS(21) + 1;
            AppMethodBeat.o(153007);
            return bu2;
        } else if (i2 == 2) {
            this.IDO.clear();
            this.Nif.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153007);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eit eit = (eit) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eit.NhX = aVar3.UbS.readString();
                    AppMethodBeat.o(153007);
                    return 0;
                case 2:
                    eit.NhY = aVar3.UbS.readString();
                    AppMethodBeat.o(153007);
                    return 0;
                case 3:
                    eit.NhZ = aVar3.UbS.readString();
                    AppMethodBeat.o(153007);
                    return 0;
                case 4:
                    eit.Nia = aVar3.UbS.readString();
                    AppMethodBeat.o(153007);
                    return 0;
                case 5:
                    eit.Nib = aVar3.UbS.zl();
                    AppMethodBeat.o(153007);
                    return 0;
                case 6:
                    eit.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(153007);
                    return 0;
                case 7:
                    eit.hes = aVar3.UbS.readString();
                    AppMethodBeat.o(153007);
                    return 0;
                case 8:
                    eit.dDv = aVar3.UbS.readString();
                    AppMethodBeat.o(153007);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eiw eiw = new eiw();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eiw.populateBuilderWithField(aVar4, eiw, a.getNextFieldNumber(aVar4))) {
                        }
                        eit.Nic = eiw;
                    }
                    AppMethodBeat.o(153007);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dyi dyi = new dyi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dyi.populateBuilderWithField(aVar5, dyi, a.getNextFieldNumber(aVar5))) {
                        }
                        eit.Nid = dyi;
                    }
                    AppMethodBeat.o(153007);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        aca aca = new aca();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = aca.populateBuilderWithField(aVar6, aca, a.getNextFieldNumber(aVar6))) {
                        }
                        eit.IDO.add(aca);
                    }
                    AppMethodBeat.o(153007);
                    return 0;
                case 12:
                    eit.sGQ = aVar3.UbS.readString();
                    AppMethodBeat.o(153007);
                    return 0;
                case 13:
                    eit.offset = aVar3.UbS.zi();
                    AppMethodBeat.o(153007);
                    return 0;
                case 14:
                    eit.Nie = aVar3.UbS.yZ();
                    AppMethodBeat.o(153007);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        eiw eiw2 = new eiw();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = eiw2.populateBuilderWithField(aVar7, eiw2, a.getNextFieldNumber(aVar7))) {
                        }
                        eit.Nif.add(eiw2);
                    }
                    AppMethodBeat.o(153007);
                    return 0;
                case 16:
                    eit.Nig = aVar3.UbS.zi();
                    AppMethodBeat.o(153007);
                    return 0;
                case 17:
                    eit.Nih = aVar3.UbS.zi();
                    AppMethodBeat.o(153007);
                    return 0;
                case 18:
                    eit.guh = aVar3.UbS.yZ();
                    AppMethodBeat.o(153007);
                    return 0;
                case 19:
                    eit.Nii = aVar3.UbS.readString();
                    AppMethodBeat.o(153007);
                    return 0;
                case 20:
                    eit.Nij = aVar3.UbS.zi();
                    AppMethodBeat.o(153007);
                    return 0;
                case 21:
                    eit.Nik = aVar3.UbS.yZ();
                    AppMethodBeat.o(153007);
                    return 0;
                default:
                    AppMethodBeat.o(153007);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153007);
            return -1;
        }
    }
}
