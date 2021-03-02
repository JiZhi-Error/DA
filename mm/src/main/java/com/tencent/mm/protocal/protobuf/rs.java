package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class rs extends a {
    public String Desc;
    public rv KZb;
    public rw KZc;
    public rp KZd;
    public String ThumbUrl;
    public String Title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117840);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title == null) {
                b bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(117840);
                throw bVar;
            } else if (this.Desc == null) {
                b bVar2 = new b("Not all required fields were included: Desc");
                AppMethodBeat.o(117840);
                throw bVar2;
            } else if (this.ThumbUrl == null) {
                b bVar3 = new b("Not all required fields were included: ThumbUrl");
                AppMethodBeat.o(117840);
                throw bVar3;
            } else if (this.KZb == null) {
                b bVar4 = new b("Not all required fields were included: DetailInfo");
                AppMethodBeat.o(117840);
                throw bVar4;
            } else if (this.KZd == null) {
                b bVar5 = new b("Not all required fields were included: ActionInfo");
                AppMethodBeat.o(117840);
                throw bVar5;
            } else {
                if (this.Title != null) {
                    aVar.e(1, this.Title);
                }
                if (this.Desc != null) {
                    aVar.e(2, this.Desc);
                }
                if (this.ThumbUrl != null) {
                    aVar.e(3, this.ThumbUrl);
                }
                if (this.KZb != null) {
                    aVar.ni(4, this.KZb.computeSize());
                    this.KZb.writeFields(aVar);
                }
                if (this.KZc != null) {
                    aVar.ni(5, this.KZc.computeSize());
                    this.KZc.writeFields(aVar);
                }
                if (this.KZd != null) {
                    aVar.ni(6, this.KZd.computeSize());
                    this.KZd.writeFields(aVar);
                }
                AppMethodBeat.o(117840);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0;
            if (this.Desc != null) {
                f2 += g.a.a.b.b.a.f(2, this.Desc);
            }
            if (this.ThumbUrl != null) {
                f2 += g.a.a.b.b.a.f(3, this.ThumbUrl);
            }
            if (this.KZb != null) {
                f2 += g.a.a.a.nh(4, this.KZb.computeSize());
            }
            if (this.KZc != null) {
                f2 += g.a.a.a.nh(5, this.KZc.computeSize());
            }
            if (this.KZd != null) {
                f2 += g.a.a.a.nh(6, this.KZd.computeSize());
            }
            AppMethodBeat.o(117840);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Title == null) {
                b bVar6 = new b("Not all required fields were included: Title");
                AppMethodBeat.o(117840);
                throw bVar6;
            } else if (this.Desc == null) {
                b bVar7 = new b("Not all required fields were included: Desc");
                AppMethodBeat.o(117840);
                throw bVar7;
            } else if (this.ThumbUrl == null) {
                b bVar8 = new b("Not all required fields were included: ThumbUrl");
                AppMethodBeat.o(117840);
                throw bVar8;
            } else if (this.KZb == null) {
                b bVar9 = new b("Not all required fields were included: DetailInfo");
                AppMethodBeat.o(117840);
                throw bVar9;
            } else if (this.KZd == null) {
                b bVar10 = new b("Not all required fields were included: ActionInfo");
                AppMethodBeat.o(117840);
                throw bVar10;
            } else {
                AppMethodBeat.o(117840);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            rs rsVar = (rs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    rsVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(117840);
                    return 0;
                case 2:
                    rsVar.Desc = aVar3.UbS.readString();
                    AppMethodBeat.o(117840);
                    return 0;
                case 3:
                    rsVar.ThumbUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(117840);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        rv rvVar = new rv();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = rvVar.populateBuilderWithField(aVar4, rvVar, a.getNextFieldNumber(aVar4))) {
                        }
                        rsVar.KZb = rvVar;
                    }
                    AppMethodBeat.o(117840);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        rw rwVar = new rw();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = rwVar.populateBuilderWithField(aVar5, rwVar, a.getNextFieldNumber(aVar5))) {
                        }
                        rsVar.KZc = rwVar;
                    }
                    AppMethodBeat.o(117840);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        rp rpVar = new rp();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = rpVar.populateBuilderWithField(aVar6, rpVar, a.getNextFieldNumber(aVar6))) {
                        }
                        rsVar.KZd = rpVar;
                    }
                    AppMethodBeat.o(117840);
                    return 0;
                default:
                    AppMethodBeat.o(117840);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117840);
            return -1;
        }
    }
}
