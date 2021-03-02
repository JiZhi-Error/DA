package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public class TableInfo extends a {
    public long count_;
    public String name_;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(151540);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.name_ == null) {
                b bVar = new b("Not all required fields were included: name_");
                AppMethodBeat.o(151540);
                throw bVar;
            }
            if (this.name_ != null) {
                aVar.e(1, this.name_);
            }
            aVar.bb(2, this.count_);
            AppMethodBeat.o(151540);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.name_ != null ? g.a.a.b.b.a.f(1, this.name_) + 0 : 0) + g.a.a.b.b.a.r(2, this.count_);
            AppMethodBeat.o(151540);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.name_ == null) {
                b bVar2 = new b("Not all required fields were included: name_");
                AppMethodBeat.o(151540);
                throw bVar2;
            }
            AppMethodBeat.o(151540);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            TableInfo tableInfo = (TableInfo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tableInfo.name_ = aVar3.UbS.readString();
                    AppMethodBeat.o(151540);
                    return 0;
                case 2:
                    tableInfo.count_ = aVar3.UbS.zl();
                    AppMethodBeat.o(151540);
                    return 0;
                default:
                    AppMethodBeat.o(151540);
                    return -1;
            }
        } else {
            AppMethodBeat.o(151540);
            return -1;
        }
    }
}
