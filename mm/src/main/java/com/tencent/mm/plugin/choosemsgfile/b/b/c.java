package com.tencent.mm.plugin.choosemsgfile.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;

public class c extends a<l> {
    private final long qnI;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int, com.tencent.mm.plugin.choosemsgfile.b.b.a] */
    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a
    public /* bridge */ /* synthetic */ void a(l lVar, int i2, a aVar) {
        AppMethodBeat.i(162326);
        a(lVar, i2, aVar);
        AppMethodBeat.o(162326);
    }

    public c(g gVar, long j2) {
        super(gVar);
        this.qnI = j2;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a
    public final long getTimeStamp() {
        return this.qnI;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a
    public final int getType() {
        return 0;
    }

    public void a(l lVar, int i2, a aVar) {
        AppMethodBeat.i(162325);
        if (i2 == this.qnE.getItemCount() - 1 || com.tencent.mm.plugin.choosemsgfile.b.d.c.Cd(this.qnE.EM(i2 + 1).getTimeStamp()) != com.tencent.mm.plugin.choosemsgfile.b.d.c.Cd(this.qnI)) {
            lVar.jUO.setVisibility(8);
            AppMethodBeat.o(162325);
            return;
        }
        lVar.jUO.setVisibility(0);
        lVar.jUO.setText(com.tencent.mm.plugin.choosemsgfile.b.d.c.Cc(this.qnI));
        if (this.qnE.cyD()) {
            lVar.qoa.setVisibility(0);
            AppMethodBeat.o(162325);
            return;
        }
        lVar.qoa.setVisibility(8);
        AppMethodBeat.o(162325);
    }
}
