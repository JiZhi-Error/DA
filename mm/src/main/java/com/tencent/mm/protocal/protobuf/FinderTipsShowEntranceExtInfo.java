package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public class FinderTipsShowEntranceExtInfo extends a {
    public String multi_username;
    public long object_id;
    public String object_nonce_id;
    public String report_ext_info;
    public b tabTipsByPassInfo;
    public int tab_type;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209700);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.object_id);
            if (this.object_nonce_id != null) {
                aVar.e(2, this.object_nonce_id);
            }
            aVar.aM(3, this.tab_type);
            if (this.username != null) {
                aVar.e(4, this.username);
            }
            if (this.multi_username != null) {
                aVar.e(5, this.multi_username);
            }
            if (this.report_ext_info != null) {
                aVar.e(6, this.report_ext_info);
            }
            if (this.tabTipsByPassInfo != null) {
                aVar.c(7, this.tabTipsByPassInfo);
            }
            AppMethodBeat.o(209700);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.object_id) + 0;
            if (this.object_nonce_id != null) {
                r += g.a.a.b.b.a.f(2, this.object_nonce_id);
            }
            int bu = r + g.a.a.b.b.a.bu(3, this.tab_type);
            if (this.username != null) {
                bu += g.a.a.b.b.a.f(4, this.username);
            }
            if (this.multi_username != null) {
                bu += g.a.a.b.b.a.f(5, this.multi_username);
            }
            if (this.report_ext_info != null) {
                bu += g.a.a.b.b.a.f(6, this.report_ext_info);
            }
            if (this.tabTipsByPassInfo != null) {
                bu += g.a.a.b.b.a.b(7, this.tabTipsByPassInfo);
            }
            AppMethodBeat.o(209700);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209700);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            FinderTipsShowEntranceExtInfo finderTipsShowEntranceExtInfo = (FinderTipsShowEntranceExtInfo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    finderTipsShowEntranceExtInfo.object_id = aVar3.UbS.zl();
                    AppMethodBeat.o(209700);
                    return 0;
                case 2:
                    finderTipsShowEntranceExtInfo.object_nonce_id = aVar3.UbS.readString();
                    AppMethodBeat.o(209700);
                    return 0;
                case 3:
                    finderTipsShowEntranceExtInfo.tab_type = aVar3.UbS.zi();
                    AppMethodBeat.o(209700);
                    return 0;
                case 4:
                    finderTipsShowEntranceExtInfo.username = aVar3.UbS.readString();
                    AppMethodBeat.o(209700);
                    return 0;
                case 5:
                    finderTipsShowEntranceExtInfo.multi_username = aVar3.UbS.readString();
                    AppMethodBeat.o(209700);
                    return 0;
                case 6:
                    finderTipsShowEntranceExtInfo.report_ext_info = aVar3.UbS.readString();
                    AppMethodBeat.o(209700);
                    return 0;
                case 7:
                    finderTipsShowEntranceExtInfo.tabTipsByPassInfo = aVar3.UbS.hPo();
                    AppMethodBeat.o(209700);
                    return 0;
                default:
                    AppMethodBeat.o(209700);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209700);
            return -1;
        }
    }
}
