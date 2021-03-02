package com.tencent.mm.plugin.card.sharecard.ui;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;

public final class d implements a {
    private c pXq;

    public d(c cVar) {
        this.pXq = cVar;
    }

    @Override // com.tencent.mm.plugin.card.base.a
    public final void onCreate() {
        AppMethodBeat.i(113080);
        if (this.pXq != null) {
            am.ctQ().add(this.pXq);
        }
        AppMethodBeat.o(113080);
    }

    @Override // com.tencent.mm.plugin.card.base.a
    public final void onDestroy() {
        AppMethodBeat.i(113081);
        if (this.pXq != null) {
            am.ctQ().remove(this.pXq);
            c cVar = this.pXq;
            cVar.pXo.release();
            cVar.pXo = null;
            cVar.ebf();
            ArrayList<IDKey> arrayList = new ArrayList<>();
            IDKey iDKey = new IDKey();
            iDKey.SetID(281);
            iDKey.SetKey(24);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(281);
            iDKey2.SetKey(25);
            iDKey2.SetValue((long) ((int) (cVar.endTime - cVar.beginTime)));
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            h.INSTANCE.b(arrayList, true);
            this.pXq = null;
        }
        AppMethodBeat.o(113081);
    }

    @Override // com.tencent.mm.plugin.card.base.a
    public final void onNotify() {
        AppMethodBeat.i(113082);
        if (this.pXq != null) {
            this.pXq.onNotifyChange(null, null);
        }
        AppMethodBeat.o(113082);
    }

    @Override // com.tencent.mm.plugin.card.base.a
    public final /* synthetic */ b Ed(int i2) {
        AppMethodBeat.i(113083);
        if (this.pXq != null) {
            ShareCardInfo shareCardInfo = (ShareCardInfo) this.pXq.getItem(i2);
            AppMethodBeat.o(113083);
            return shareCardInfo;
        }
        AppMethodBeat.o(113083);
        return null;
    }
}
