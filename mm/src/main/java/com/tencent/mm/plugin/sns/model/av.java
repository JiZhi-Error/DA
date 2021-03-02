package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.j.l;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.ebe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class av implements i {
    public List<Long> DNj = new ArrayList();
    public l DNk = null;
    public int DNl = 50;
    private final String TAG = "MicroMsg.SnsUnreadPreloader";
    private boolean readyForDisplay = false;

    public av() {
        AppMethodBeat.i(202787);
        AppMethodBeat.o(202787);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        SnsObject peekLast;
        AppMethodBeat.i(202788);
        if (aj.faZ().DNn && (qVar instanceof z)) {
            ebe ebe = (ebe) ((z) qVar).rr.iLL.iLR;
            boolean fak = ((z) qVar).fak();
            Log.i("MicroMsg.SnsUnreadPreloader", "errType:%s, errCode:%s, isForUnreadPreload:%s", Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(fak));
            if (fak && ebe != null && !Util.isNullOrNil(ebe.KOH) && !Util.isNullOrNil(this.DNj) && (peekLast = ebe.KOH.peekLast()) != null) {
                ArrayList arrayList = new ArrayList();
                Iterator<SnsObject> it = ebe.KOH.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(it.next().Id));
                }
                this.DNj.removeAll(arrayList);
                if (this.DNj.isEmpty() || peekLast.Id < this.DNj.get(this.DNj.size() - 1).longValue()) {
                    Log.i("MicroMsg.SnsUnreadPreloader", "finish preload unread fault");
                    this.DNk.state = 1;
                    this.DNj.clear();
                    AppMethodBeat.o(202788);
                    return;
                } else if (this.DNk.DSd > this.DNl) {
                    Log.i("MicroMsg.SnsUnreadPreloader", "drop preload unread fault, too many times!!");
                    this.DNk.state = 3;
                    this.DNj.clear();
                    AppMethodBeat.o(202788);
                    return;
                } else {
                    this.DNk.DSd++;
                    Log.i("MicroMsg.SnsUnreadPreloader", "continue preload unread fault, maxId:%s, preloadCount:%s, unreadItem:%s", this.DNj.get(0), Integer.valueOf(this.DNk.DSd), this.DNk);
                    g.aAg().hqi.a(new z(this.DNj.get(0).longValue() + 1, 0, 2), 0);
                }
            }
        }
        AppMethodBeat.o(202788);
    }
}
