package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class bgd extends a {
    public String IconUrl;
    public int KWb;
    public bgm LPR;
    public String LPS;
    public String LoI;
    public String Name;
    public String jfi;
    public String xIK;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(42632);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.jfi == null) {
                b bVar = new b("Not all required fields were included: AppId");
                AppMethodBeat.o(42632);
                throw bVar;
            } else if (this.Name == null) {
                b bVar2 = new b("Not all required fields were included: Name");
                AppMethodBeat.o(42632);
                throw bVar2;
            } else if (this.LoI == null) {
                b bVar3 = new b("Not all required fields were included: Remark");
                AppMethodBeat.o(42632);
                throw bVar3;
            } else if (this.IconUrl == null) {
                b bVar4 = new b("Not all required fields were included: IconUrl");
                AppMethodBeat.o(42632);
                throw bVar4;
            } else if (this.LPR == null) {
                b bVar5 = new b("Not all required fields were included: DownloadInfo");
                AppMethodBeat.o(42632);
                throw bVar5;
            } else {
                if (this.jfi != null) {
                    aVar.e(1, this.jfi);
                }
                if (this.Name != null) {
                    aVar.e(2, this.Name);
                }
                if (this.LoI != null) {
                    aVar.e(3, this.LoI);
                }
                if (this.IconUrl != null) {
                    aVar.e(4, this.IconUrl);
                }
                if (this.xIK != null) {
                    aVar.e(5, this.xIK);
                }
                if (this.LPR != null) {
                    aVar.ni(6, this.LPR.computeSize());
                    this.LPR.writeFields(aVar);
                }
                aVar.aM(7, this.KWb);
                if (this.LPS != null) {
                    aVar.e(8, this.LPS);
                }
                AppMethodBeat.o(42632);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.jfi != null ? g.a.a.b.b.a.f(1, this.jfi) + 0 : 0;
            if (this.Name != null) {
                f2 += g.a.a.b.b.a.f(2, this.Name);
            }
            if (this.LoI != null) {
                f2 += g.a.a.b.b.a.f(3, this.LoI);
            }
            if (this.IconUrl != null) {
                f2 += g.a.a.b.b.a.f(4, this.IconUrl);
            }
            if (this.xIK != null) {
                f2 += g.a.a.b.b.a.f(5, this.xIK);
            }
            if (this.LPR != null) {
                f2 += g.a.a.a.nh(6, this.LPR.computeSize());
            }
            int bu = f2 + g.a.a.b.b.a.bu(7, this.KWb);
            if (this.LPS != null) {
                bu += g.a.a.b.b.a.f(8, this.LPS);
            }
            AppMethodBeat.o(42632);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.jfi == null) {
                b bVar6 = new b("Not all required fields were included: AppId");
                AppMethodBeat.o(42632);
                throw bVar6;
            } else if (this.Name == null) {
                b bVar7 = new b("Not all required fields were included: Name");
                AppMethodBeat.o(42632);
                throw bVar7;
            } else if (this.LoI == null) {
                b bVar8 = new b("Not all required fields were included: Remark");
                AppMethodBeat.o(42632);
                throw bVar8;
            } else if (this.IconUrl == null) {
                b bVar9 = new b("Not all required fields were included: IconUrl");
                AppMethodBeat.o(42632);
                throw bVar9;
            } else if (this.LPR == null) {
                b bVar10 = new b("Not all required fields were included: DownloadInfo");
                AppMethodBeat.o(42632);
                throw bVar10;
            } else {
                AppMethodBeat.o(42632);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bgd bgd = (bgd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bgd.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(42632);
                    return 0;
                case 2:
                    bgd.Name = aVar3.UbS.readString();
                    AppMethodBeat.o(42632);
                    return 0;
                case 3:
                    bgd.LoI = aVar3.UbS.readString();
                    AppMethodBeat.o(42632);
                    return 0;
                case 4:
                    bgd.IconUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(42632);
                    return 0;
                case 5:
                    bgd.xIK = aVar3.UbS.readString();
                    AppMethodBeat.o(42632);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        bgm bgm = new bgm();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bgm.populateBuilderWithField(aVar4, bgm, a.getNextFieldNumber(aVar4))) {
                        }
                        bgd.LPR = bgm;
                    }
                    AppMethodBeat.o(42632);
                    return 0;
                case 7:
                    bgd.KWb = aVar3.UbS.zi();
                    AppMethodBeat.o(42632);
                    return 0;
                case 8:
                    bgd.LPS = aVar3.UbS.readString();
                    AppMethodBeat.o(42632);
                    return 0;
                default:
                    AppMethodBeat.o(42632);
                    return -1;
            }
        } else {
            AppMethodBeat.o(42632);
            return -1;
        }
    }
}
