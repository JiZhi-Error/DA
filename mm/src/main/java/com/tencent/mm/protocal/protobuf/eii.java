package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eii extends a {
    public int GjO;
    public LinkedList<aca> IDO = new LinkedList<>();
    public String IDW;
    public String NhA;
    public LinkedList<String> NhB = new LinkedList<>();
    public beo NhC;
    public LinkedList<eis> Nhy = new LinkedList<>();
    public int Nhz;
    public int channelId;
    public String dDv;
    public String dPI;
    public String dVO;
    public String hes;
    public String nbg;
    public int offset;
    public String sGQ;
    public int scene;
    public String sessionId;
    public String url;
    public String wib;
    public int wwG;

    public eii() {
        AppMethodBeat.i(152996);
        AppMethodBeat.o(152996);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152997);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.hes != null) {
                aVar.e(1, this.hes);
            }
            if (this.sessionId != null) {
                aVar.e(2, this.sessionId);
            }
            if (this.dVO != null) {
                aVar.e(3, this.dVO);
            }
            aVar.aM(4, this.offset);
            if (this.dDv != null) {
                aVar.e(5, this.dDv);
            }
            aVar.aM(6, this.scene);
            if (this.url != null) {
                aVar.e(7, this.url);
            }
            if (this.dPI != null) {
                aVar.e(8, this.dPI);
            }
            aVar.e(9, 8, this.IDO);
            if (this.sGQ != null) {
                aVar.e(10, this.sGQ);
            }
            aVar.e(11, 8, this.Nhy);
            aVar.aM(12, this.GjO);
            aVar.aM(13, this.channelId);
            if (this.IDW != null) {
                aVar.e(14, this.IDW);
            }
            aVar.aM(15, this.Nhz);
            if (this.nbg != null) {
                aVar.e(16, this.nbg);
            }
            if (this.wib != null) {
                aVar.e(17, this.wib);
            }
            if (this.NhA != null) {
                aVar.e(18, this.NhA);
            }
            aVar.e(19, 1, this.NhB);
            aVar.aM(20, this.wwG);
            if (this.NhC != null) {
                aVar.ni(21, this.NhC.computeSize());
                this.NhC.writeFields(aVar);
            }
            AppMethodBeat.o(152997);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.hes != null ? g.a.a.b.b.a.f(1, this.hes) + 0 : 0;
            if (this.sessionId != null) {
                f2 += g.a.a.b.b.a.f(2, this.sessionId);
            }
            if (this.dVO != null) {
                f2 += g.a.a.b.b.a.f(3, this.dVO);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.offset);
            if (this.dDv != null) {
                bu += g.a.a.b.b.a.f(5, this.dDv);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.scene);
            if (this.url != null) {
                bu2 += g.a.a.b.b.a.f(7, this.url);
            }
            if (this.dPI != null) {
                bu2 += g.a.a.b.b.a.f(8, this.dPI);
            }
            int c2 = bu2 + g.a.a.a.c(9, 8, this.IDO);
            if (this.sGQ != null) {
                c2 += g.a.a.b.b.a.f(10, this.sGQ);
            }
            int c3 = c2 + g.a.a.a.c(11, 8, this.Nhy) + g.a.a.b.b.a.bu(12, this.GjO) + g.a.a.b.b.a.bu(13, this.channelId);
            if (this.IDW != null) {
                c3 += g.a.a.b.b.a.f(14, this.IDW);
            }
            int bu3 = c3 + g.a.a.b.b.a.bu(15, this.Nhz);
            if (this.nbg != null) {
                bu3 += g.a.a.b.b.a.f(16, this.nbg);
            }
            if (this.wib != null) {
                bu3 += g.a.a.b.b.a.f(17, this.wib);
            }
            if (this.NhA != null) {
                bu3 += g.a.a.b.b.a.f(18, this.NhA);
            }
            int c4 = bu3 + g.a.a.a.c(19, 1, this.NhB) + g.a.a.b.b.a.bu(20, this.wwG);
            if (this.NhC != null) {
                c4 += g.a.a.a.nh(21, this.NhC.computeSize());
            }
            AppMethodBeat.o(152997);
            return c4;
        } else if (i2 == 2) {
            this.IDO.clear();
            this.Nhy.clear();
            this.NhB.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152997);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eii eii = (eii) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eii.hes = aVar3.UbS.readString();
                    AppMethodBeat.o(152997);
                    return 0;
                case 2:
                    eii.sessionId = aVar3.UbS.readString();
                    AppMethodBeat.o(152997);
                    return 0;
                case 3:
                    eii.dVO = aVar3.UbS.readString();
                    AppMethodBeat.o(152997);
                    return 0;
                case 4:
                    eii.offset = aVar3.UbS.zi();
                    AppMethodBeat.o(152997);
                    return 0;
                case 5:
                    eii.dDv = aVar3.UbS.readString();
                    AppMethodBeat.o(152997);
                    return 0;
                case 6:
                    eii.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(152997);
                    return 0;
                case 7:
                    eii.url = aVar3.UbS.readString();
                    AppMethodBeat.o(152997);
                    return 0;
                case 8:
                    eii.dPI = aVar3.UbS.readString();
                    AppMethodBeat.o(152997);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        aca aca = new aca();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = aca.populateBuilderWithField(aVar4, aca, a.getNextFieldNumber(aVar4))) {
                        }
                        eii.IDO.add(aca);
                    }
                    AppMethodBeat.o(152997);
                    return 0;
                case 10:
                    eii.sGQ = aVar3.UbS.readString();
                    AppMethodBeat.o(152997);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eis eis = new eis();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eis.populateBuilderWithField(aVar5, eis, a.getNextFieldNumber(aVar5))) {
                        }
                        eii.Nhy.add(eis);
                    }
                    AppMethodBeat.o(152997);
                    return 0;
                case 12:
                    eii.GjO = aVar3.UbS.zi();
                    AppMethodBeat.o(152997);
                    return 0;
                case 13:
                    eii.channelId = aVar3.UbS.zi();
                    AppMethodBeat.o(152997);
                    return 0;
                case 14:
                    eii.IDW = aVar3.UbS.readString();
                    AppMethodBeat.o(152997);
                    return 0;
                case 15:
                    eii.Nhz = aVar3.UbS.zi();
                    AppMethodBeat.o(152997);
                    return 0;
                case 16:
                    eii.nbg = aVar3.UbS.readString();
                    AppMethodBeat.o(152997);
                    return 0;
                case 17:
                    eii.wib = aVar3.UbS.readString();
                    AppMethodBeat.o(152997);
                    return 0;
                case 18:
                    eii.NhA = aVar3.UbS.readString();
                    AppMethodBeat.o(152997);
                    return 0;
                case 19:
                    eii.NhB.add(aVar3.UbS.readString());
                    AppMethodBeat.o(152997);
                    return 0;
                case 20:
                    eii.wwG = aVar3.UbS.zi();
                    AppMethodBeat.o(152997);
                    return 0;
                case 21:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        beo beo = new beo();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = beo.populateBuilderWithField(aVar6, beo, a.getNextFieldNumber(aVar6))) {
                        }
                        eii.NhC = beo;
                    }
                    AppMethodBeat.o(152997);
                    return 0;
                default:
                    AppMethodBeat.o(152997);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152997);
            return -1;
        }
    }
}
