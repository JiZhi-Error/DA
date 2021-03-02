package com.tencent.mm.plugin.websearch.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.as;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class e extends a<a> {
    public List<a> mWl = Collections.emptyList();

    public static class a {
        public String IGC;
        public String desc;
        public String fMb;
        public String nickName;
        public String remark;
        public String userName;
    }

    public e(String str) {
        super(str, Integer.MAX_VALUE);
        AppMethodBeat.i(116562);
        AppMethodBeat.o(116562);
    }

    @Override // com.tencent.mm.plugin.websearch.b.a.a
    public final void ih(List<m> list) {
        AppMethodBeat.i(116563);
        this.mWl = new ArrayList(list.size());
        for (m mVar : list) {
            as Kn = ((l) g.af(l.class)).aSN().Kn(mVar.wVX);
            a aVar = new a();
            aVar.userName = Kn.field_username;
            aVar.IGC = mVar.content;
            aVar.nickName = Kn.field_nickname;
            aVar.remark = Kn.field_conRemark;
            aVar.fMb = Kn.ajx();
            aVar.desc = Kn.fuR;
            this.mWl.add(aVar);
        }
        AppMethodBeat.o(116563);
    }
}
