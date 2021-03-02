package com.tencent.mm.plugin.f.c;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.f.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a extends b {
    private long cacheSize;
    private boolean isStop;
    private LinkedList<String> pQk;
    private List<Runnable> pQl;
    private AbstractC1034a pQm;

    /* renamed from: com.tencent.mm.plugin.f.c.a$a  reason: collision with other inner class name */
    public interface AbstractC1034a {
        void csi();
    }

    @Override // com.tencent.f.i.h, com.tencent.f.i.g
    public final String getKey() {
        return "ScanMsgTask";
    }

    public a(LinkedList<String> linkedList, long j2, List<Runnable> list, AbstractC1034a aVar) {
        AppMethodBeat.i(231650);
        this.pQk = linkedList;
        this.cacheSize = j2;
        this.pQm = aVar;
        this.pQl = list;
        Log.d("MicroMsg.CleanCacheTask", "%d clean cache [%d]", Integer.valueOf(hashCode()), Integer.valueOf(this.pQk.size()));
        AppMethodBeat.o(231650);
    }

    public final void run() {
        AppMethodBeat.i(231651);
        if (this.isStop) {
            AppMethodBeat.o(231651);
            return;
        }
        long currentTicks = Util.currentTicks();
        Iterator<String> it = this.pQk.iterator();
        while (it.hasNext()) {
            s.dy(it.next(), true);
        }
        if (Util.getInt(d.cRY().b("clicfg_clean_delete_oversize_sns_db", AppEventsConstants.EVENT_PARAM_VALUE_NO, false, true), 0) > 0) {
            aj.fbi();
        }
        if (this.pQl != null) {
            for (Runnable runnable : this.pQl) {
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
        Log.d("MicroMsg.CleanCacheTask", "%d clean cache costTime[%d]", Integer.valueOf(hashCode()), Long.valueOf(Util.ticksToNow(currentTicks)));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("0,0,0,0,0,0,0,0,0,0,0,0,").append(this.cacheSize).append(",0,0,0");
        h.INSTANCE.kvStat(14762, stringBuffer.toString());
        if (this.pQm != null) {
            this.pQm.csi();
        }
        AppMethodBeat.o(231651);
    }
}
