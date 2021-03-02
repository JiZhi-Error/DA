package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public class BDStatusInfo extends a {
    public long favDBSize_;
    public long mmDBSize_;
    public int mmDBTableCount_;
    public long snsDBSize_;
    public LinkedList<TableInfo> tableList_ = new LinkedList<>();

    public BDStatusInfo() {
        AppMethodBeat.i(151532);
        AppMethodBeat.o(151532);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(151533);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.mmDBSize_);
            aVar.bb(2, this.snsDBSize_);
            aVar.aM(3, this.mmDBTableCount_);
            aVar.e(4, 8, this.tableList_);
            aVar.bb(5, this.favDBSize_);
            AppMethodBeat.o(151533);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.mmDBSize_) + 0 + g.a.a.b.b.a.r(2, this.snsDBSize_) + g.a.a.b.b.a.bu(3, this.mmDBTableCount_) + g.a.a.a.c(4, 8, this.tableList_) + g.a.a.b.b.a.r(5, this.favDBSize_);
            AppMethodBeat.o(151533);
            return r;
        } else if (i2 == 2) {
            this.tableList_.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(151533);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            BDStatusInfo bDStatusInfo = (BDStatusInfo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bDStatusInfo.mmDBSize_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151533);
                    return 0;
                case 2:
                    bDStatusInfo.snsDBSize_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151533);
                    return 0;
                case 3:
                    bDStatusInfo.mmDBTableCount_ = aVar3.UbS.zi();
                    AppMethodBeat.o(151533);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        TableInfo tableInfo = new TableInfo();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = tableInfo.populateBuilderWithField(aVar4, tableInfo, a.getNextFieldNumber(aVar4))) {
                        }
                        bDStatusInfo.tableList_.add(tableInfo);
                    }
                    AppMethodBeat.o(151533);
                    return 0;
                case 5:
                    bDStatusInfo.favDBSize_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151533);
                    return 0;
                default:
                    AppMethodBeat.o(151533);
                    return -1;
            }
        } else {
            AppMethodBeat.o(151533);
            return -1;
        }
    }
}
