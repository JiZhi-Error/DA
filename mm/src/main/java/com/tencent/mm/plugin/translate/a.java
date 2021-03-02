package com.tencent.mm.plugin.translate;

import android.os.Looper;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ya;
import com.tencent.mm.g.a.yc;
import com.tencent.mm.g.a.yd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.translate.a.c;
import com.tencent.mm.plugin.translate.a.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import java.util.LinkedList;

public final class a implements bd {
    c Gta = c.b.Gto;
    QueueWorkerThread Gtb = new QueueWorkerThread(5, "ProcessTranslatedMessage", 1, Looper.getMainLooper());
    private c.a Gtc = new c.a() {
        /* class com.tencent.mm.plugin.translate.a.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.translate.a.c.a
        public final void a(final int i2, SparseArray<c.C1840c> sparseArray) {
            AppMethodBeat.i(29732);
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                final c.C1840c valueAt = sparseArray.valueAt(i3);
                if (valueAt != null) {
                    a.this.Gtb.add(new QueueWorkerThread.ThreadObject() {
                        /* class com.tencent.mm.plugin.translate.a.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
                        public final boolean onPostExecute() {
                            AppMethodBeat.i(29730);
                            int i2 = i2 != 0 ? i2 : valueAt.ret;
                            yd ydVar = new yd();
                            ydVar.eey.ret = i2;
                            ydVar.eey.eeq = valueAt.eeq;
                            ydVar.eey.id = valueAt.id;
                            ydVar.eey.eez = valueAt.eez;
                            ydVar.eey.type = valueAt.type;
                            ydVar.eey.source = valueAt.source;
                            ydVar.eey.ecu = valueAt.ecu;
                            ydVar.eey.ees = valueAt.fRc;
                            ydVar.eey.eeA = valueAt.eeA;
                            EventCenter.instance.publish(ydVar);
                            AppMethodBeat.o(29730);
                            return false;
                        }

                        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
                        public final boolean doInBackground() {
                            AppMethodBeat.i(29731);
                            Log.d("MicroMsg.SubCoreTranslate", "finish translated, id: %s", valueAt.id);
                            if (i2 != 0) {
                                Log.e("MicroMsg.SubCoreTranslate", "translate error");
                                AppMethodBeat.o(29731);
                            } else if (valueAt.ret != 0) {
                                Log.e("MicroMsg.SubCoreTranslate", "translate ret not ok : %s", Integer.valueOf(valueAt.ret));
                                AppMethodBeat.o(29731);
                            } else if (Util.isNullOrNil(valueAt.eez)) {
                                Log.e("MicroMsg.SubCoreTranslate", "translate return null");
                                AppMethodBeat.o(29731);
                            } else {
                                if (valueAt.type == 0 || valueAt.type == 1) {
                                    Log.d("MicroMsg.SubCoreTranslate", "we recieved one translated message");
                                    c.C1840c cVar = valueAt;
                                    bg.aVF();
                                    ca Hb = com.tencent.mm.model.c.aSQ().Hb(Util.safeParseLong(cVar.id));
                                    Hb.CB(cVar.eez);
                                    Hb.field_transBrandWording = Util.escapeSqlValue(Util.nullAsNil(cVar.ecu));
                                    Hb.fqQ = true;
                                    Hb.fRc = cVar.fRc;
                                    Hb.fqk = true;
                                    if (cVar.eeA == 1) {
                                        if (Hb.gDz()) {
                                            Hb.nc(Hb.fqJ | 1024);
                                        }
                                    } else if (Hb.gDz()) {
                                        Hb.nc(Hb.fqJ & -1025);
                                    }
                                    ((l) g.af(l.class)).eiy().a(Hb.field_msgId, Hb);
                                }
                                AppMethodBeat.o(29731);
                            }
                            return true;
                        }
                    });
                }
            }
            AppMethodBeat.o(29732);
        }
    };
    private IListener Gtd = new IListener<ya>() {
        /* class com.tencent.mm.plugin.translate.a.AnonymousClass2 */

        {
            AppMethodBeat.i(161459);
            this.__eventId = ya.class.getName().hashCode();
            AppMethodBeat.o(161459);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ya yaVar) {
            AppMethodBeat.i(29734);
            final ya yaVar2 = yaVar;
            Log.d("MicroMsg.SubCoreTranslate", "recieve one translate request");
            a.this.handler.post(new Runnable() {
                /* class com.tencent.mm.plugin.translate.a.AnonymousClass2.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(29733);
                    c cVar = a.this.Gta;
                    String str = yaVar2.eep.eeq;
                    String str2 = yaVar2.eep.id;
                    int i2 = yaVar2.eep.type;
                    String str3 = yaVar2.eep.source;
                    boolean z = yaVar2.eep.eer;
                    byte[] bArr = yaVar2.eep.ees;
                    Log.d("MicroMsg.TranslateServiceManager", "doTranslate msgId : %s, type: %d", str2, Integer.valueOf(i2));
                    if (cVar.aTM(str2)) {
                        Log.d("MicroMsg.TranslateServiceManager", "doTranslate msgId %s is inQueue", str2);
                        AppMethodBeat.o(29733);
                        return;
                    }
                    c.C1840c cVar2 = new c.C1840c(str, str2, i2, str3, bArr);
                    if (z) {
                        ((LinkedList) cVar.Gtm).add(0, cVar2);
                    } else {
                        cVar.Gtm.add(cVar2);
                    }
                    cVar.Gtn.put(cVar2.id, Integer.valueOf(cVar2.Gtp));
                    Log.d("MicroMsg.TranslateServiceManager", "requestCount : %s", Integer.valueOf(cVar.gVP));
                    cVar.fAo();
                    AppMethodBeat.o(29733);
                }
            });
            AppMethodBeat.o(29734);
            return true;
        }
    };
    private IListener Gte = new IListener<yc>() {
        /* class com.tencent.mm.plugin.translate.a.AnonymousClass3 */

        {
            AppMethodBeat.i(161460);
            this.__eventId = yc.class.getName().hashCode();
            AppMethodBeat.o(161460);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(yc ycVar) {
            AppMethodBeat.i(29735);
            yc ycVar2 = ycVar;
            ycVar2.eew.eex = a.this.Gta.aTM(ycVar2.eev.id);
            AppMethodBeat.o(29735);
            return true;
        }
    };
    MMHandler handler = new MMHandler(Looper.getMainLooper());

    public a() {
        AppMethodBeat.i(29736);
        AppMethodBeat.o(29736);
    }

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(29737);
        c cVar = this.Gta;
        c.a aVar = this.Gtc;
        if (aVar != null && !cVar.listeners.contains(aVar)) {
            cVar.listeners.add(aVar);
        }
        EventCenter.instance.addListener(this.Gtd);
        EventCenter.instance.addListener(this.Gte);
        AppMethodBeat.o(29737);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(29738);
        EventCenter.instance.removeListener(this.Gtd);
        EventCenter.instance.removeListener(this.Gte);
        c cVar = this.Gta;
        c.a aVar = this.Gtc;
        if (aVar != null && cVar.listeners.contains(aVar)) {
            cVar.listeners.remove(aVar);
        }
        c cVar2 = this.Gta;
        if (cVar2.Gtl != null) {
            d[] dVarArr = cVar2.Gtl;
            for (d dVar : dVarArr) {
                if (dVar != null) {
                    bg.azz().b(631, dVar);
                    if (dVar.Gtu != null) {
                        dVar.Gtw.stopTimer();
                        bg.azz().a(dVar.Gtu);
                    }
                    dVar.fAp();
                    dVar.Gts = null;
                }
            }
        }
        cVar2.Gtn.clear();
        cVar2.Gtm.clear();
        cVar2.listeners.clear();
        cVar2.gVP = 0;
        AppMethodBeat.o(29738);
    }
}
