package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.l;
import com.tencent.mm.ag.z;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.chatting.d.m;
import java.util.LinkedList;
import java.util.Set;

public final class j {
    public static void a(Context context, Set<Long> set, z zVar) {
        AppMethodBeat.i(34389);
        if (context == null) {
            Log.w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, context is null");
            AppMethodBeat.o(34389);
        } else if (set == null || set.isEmpty()) {
            Log.w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, select ids is empty");
            AppMethodBeat.o(34389);
        } else {
            context.getString(R.string.zb);
            m.PnZ.add(new a(set, h.a(context, context.getString(R.string.blm), false, (DialogInterface.OnCancelListener) null), zVar));
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(10811, 4, Integer.valueOf(set.size()));
            AppMethodBeat.o(34389);
        }
    }

    /* access modifiers changed from: package-private */
    public static class a implements QueueWorkerThread.ThreadObject {
        private Set<Long> Pgk;
        private q Pgl;
        private z Pgm;

        public a(Set<Long> set, q qVar, z zVar) {
            this.Pgk = set;
            this.Pgl = qVar;
            this.Pgm = zVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean doInBackground() {
            AppMethodBeat.i(34387);
            Set<Long> set = this.Pgk;
            LinkedList linkedList = new LinkedList();
            for (Long l : set) {
                bg.aVF();
                ca Hb = c.aSQ().Hb(l.longValue());
                if (Hb.field_msgId == l.longValue()) {
                    if (Hb.dOQ()) {
                        b.jmd.d(Hb, l.t(Hb));
                    } else {
                        b.jmd.ad(Hb);
                    }
                }
                linkedList.add(l);
                rc rcVar = new rc();
                rcVar.dXF.type = 3;
                rcVar.dXF.msgId = l.longValue();
                EventCenter.instance.publish(rcVar);
            }
            bp.ar(linkedList);
            if (this.Pgm != null) {
                this.Pgm.b(z.a.del);
            }
            AppMethodBeat.o(34387);
            return true;
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean onPostExecute() {
            AppMethodBeat.i(34388);
            if (this.Pgl != null) {
                this.Pgl.dismiss();
                if (this.Pgm != null) {
                    this.Pgm.c(z.a.del);
                }
            }
            AppMethodBeat.o(34388);
            return true;
        }
    }
}
