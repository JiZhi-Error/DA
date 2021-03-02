package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ax;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qy;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.qbar.QbarNative;
import com.tencent.qbar.WxQbarNative;
import com.tencent.qbar.a;
import com.tencent.qbar.c;
import com.tencent.qbar.e;
import com.tencent.scanlib.b.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class u {
    public IListener CFM = new IListener<qx>() {
        /* class com.tencent.mm.plugin.scanner.model.u.AnonymousClass1 */

        {
            AppMethodBeat.i(161002);
            this.__eventId = qx.class.getName().hashCode();
            AppMethodBeat.o(161002);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qx qxVar) {
            AppMethodBeat.i(51641);
            boolean h2 = u.this.h(qxVar);
            AppMethodBeat.o(51641);
            return h2;
        }
    };
    public IListener CFN = new IListener<ax>() {
        /* class com.tencent.mm.plugin.scanner.model.u.AnonymousClass2 */

        {
            AppMethodBeat.i(161003);
            this.__eventId = ax.class.getName().hashCode();
            AppMethodBeat.o(161003);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ax axVar) {
            AppMethodBeat.i(51642);
            boolean h2 = u.this.h(axVar);
            AppMethodBeat.o(51642);
            return h2;
        }
    };
    Map<Long, String> CFO = new HashMap();
    e.b CFP = new e.b() {
        /* class com.tencent.mm.plugin.scanner.model.u.AnonymousClass3 */

        @Override // com.tencent.qbar.e.b
        public final void a(final long j2, final e.d dVar) {
            final List<QbarNative.QBarPoint> list;
            final List<WxQbarNative.QBarReportMsg> list2 = null;
            AppMethodBeat.i(240716);
            final List<a.C2180a> list3 = dVar != null ? dVar.CGY : null;
            if (dVar != null) {
                list = dVar.RKj;
            } else {
                list = null;
            }
            if (dVar != null) {
                list2 = dVar.RKk;
            }
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.scanner.model.u.AnonymousClass3.AnonymousClass1 */

                public final void run() {
                    QbarNative.QBarPoint qBarPoint;
                    AppMethodBeat.i(51643);
                    if (list3 == null || list3.isEmpty()) {
                        Log.i("MicroMsg.RecogQBarOfImageFileListener", "%d scan file no result", Long.valueOf(j2));
                        if (u.this.CFO.containsKey(Long.valueOf(j2))) {
                            qy qyVar = new qy();
                            qyVar.dXy.filePath = u.this.CFO.get(Long.valueOf(j2));
                            EventCenter.instance.publish(qyVar);
                            u.this.CFO.remove(Long.valueOf(j2));
                            AppMethodBeat.o(51643);
                            return;
                        }
                    } else {
                        Log.i("MicroMsg.RecogQBarOfImageFileListener", "%d scan file get %d results ", Long.valueOf(j2), Integer.valueOf(list3.size()));
                        qz qzVar = new qz();
                        if (u.this.CFO.containsKey(Long.valueOf(j2))) {
                            qzVar.dXz.filePath = u.this.CFO.get(Long.valueOf(j2));
                            qzVar.dXz.result = ((a.C2180a) list3.get(0)).data;
                            qzVar.dXz.dWl = ((a.C2180a) list3.get(0)).typeName;
                            qzVar.dXz.dFL = e.d.bcV(((a.C2180a) list3.get(0)).typeName);
                            qzVar.dXz.dXx = dVar.dXx;
                            if (!(list == null || list.size() <= 0 || (qBarPoint = (QbarNative.QBarPoint) list.get(0)) == null)) {
                                qzVar.dXz.dXC = (((qBarPoint.x0 + qBarPoint.x1) + qBarPoint.x2) + qBarPoint.x3) / 4.0f;
                                qzVar.dXz.dXD = (qBarPoint.y3 + ((qBarPoint.y0 + qBarPoint.y1) + qBarPoint.y2)) / 4.0f;
                                qzVar.dXz.dXC = Math.max(0.0f, qzVar.dXz.dXC);
                                qzVar.dXz.dXD = Math.max(0.0f, qzVar.dXz.dXD);
                            }
                            if (dVar.RKl != null) {
                                qzVar.dXz.dXA = dVar.RKl.x;
                                qzVar.dXz.dXB = dVar.RKl.y;
                            }
                            if (list2 != null && !list2.isEmpty()) {
                                qzVar.dXz.dFM = ((WxQbarNative.QBarReportMsg) list2.get(0)).qrcodeVersion;
                            }
                            EventCenter.instance.publish(qzVar);
                            u.this.CFO.remove(Long.valueOf(j2));
                        }
                    }
                    AppMethodBeat.o(51643);
                }
            });
            AppMethodBeat.o(240716);
        }
    };

    public u() {
        AppMethodBeat.i(51645);
        AppMethodBeat.o(51645);
    }

    public final boolean h(IEvent iEvent) {
        AppMethodBeat.i(51646);
        if (iEvent == null) {
            AppMethodBeat.o(51646);
        } else if (iEvent instanceof qx) {
            c.RJF.reset();
            c.RJF.aqw(c.RJA);
            qx qxVar = (qx) iEvent;
            this.CFO.put(Long.valueOf(qxVar.dXu.dDZ), qxVar.dXu.filePath);
            e.c cVar = new e.c();
            cVar.dXw = qxVar.dXu.dXw;
            cVar.dXx = qxVar.dXu.dXx;
            com.tencent.qbar.e.hki().a(MMApplicationContext.getContext(), qxVar.dXu.dDZ, qxVar.dXu.filePath, qxVar.dXu.bitmap, this.CFP, new int[]{0}, cVar);
        } else if (iEvent instanceof ax) {
            c.RJF.bUV();
            ax axVar = (ax) iEvent;
            b hlc = b.hlc();
            long j2 = axVar.dDY.dDZ;
            synchronized (hlc.CCt) {
                try {
                    if (hlc.RKc.containsKey(Long.valueOf(j2))) {
                        String str = hlc.RKc.get(Long.valueOf(j2));
                        if (hlc.RKe.containsKey(str)) {
                            hlc.RKe.get(str).remove(Long.valueOf(j2));
                            if (hlc.RKe.get(str).isEmpty()) {
                                hlc.RKe.remove(str);
                            }
                        }
                        hlc.RKc.remove(Long.valueOf(j2));
                        hlc.RKd.remove(Long.valueOf(j2));
                    }
                } finally {
                    AppMethodBeat.o(51646);
                }
            }
            this.CFO.remove(Long.valueOf(axVar.dDY.dDZ));
        }
        return false;
    }
}
