package com.tencent.mm.plugin.sns.k;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vz;
import com.tencent.mm.g.b.a.fs;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class d {
    private static d DUK = null;
    public HashMap<Integer, a> DUL;
    private IListener<vz> gmC;

    private d() {
        AppMethodBeat.i(96205);
        this.DUL = null;
        this.gmC = new IListener<vz>() {
            /* class com.tencent.mm.plugin.sns.k.d.AnonymousClass1 */

            {
                AppMethodBeat.i(160682);
                this.__eventId = vz.class.getName().hashCode();
                AppMethodBeat.o(160682);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(vz vzVar) {
                AppMethodBeat.i(96204);
                final vz vzVar2 = vzVar;
                h.RTc.aX(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.k.d.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(96203);
                        d.a(d.this, vzVar2.ecd.ece, vzVar2.ecd.ecg);
                        AppMethodBeat.o(96203);
                    }
                });
                AppMethodBeat.o(96204);
                return false;
            }
        };
        this.DUL = new HashMap<>();
        EventCenter.instance.add(this.gmC);
        AppMethodBeat.o(96205);
    }

    public static d fcs() {
        AppMethodBeat.i(96206);
        if (DUK == null) {
            DUK = new d();
        }
        d dVar = DUK;
        AppMethodBeat.o(96206);
        return dVar;
    }

    public class a {
        String content = "";
        int mediaType = 0;

        public a(int i2, String str) {
            this.content = str;
            this.mediaType = i2;
        }
    }

    static /* synthetic */ void a(d dVar, long j2, HashMap hashMap) {
        int i2;
        AppMethodBeat.i(96207);
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Integer num : hashMap.keySet()) {
                int intValue = num.intValue();
                a remove = dVar.DUL.remove(Integer.valueOf(intValue));
                if (remove != null && !Util.isNullOrNil(remove.content)) {
                    try {
                        i2 = ((Integer) hashMap.get(Integer.valueOf(intValue))).intValue() == 1 ? 1 : 2;
                    } catch (Exception e2) {
                        i2 = 0;
                    }
                    fs fsVar = new fs(remove.content);
                    fsVar.sJ(r.Jb(j2));
                    fsVar.eHk = (long) i2;
                    fsVar.eHu = (long) remove.mediaType;
                    fsVar.bfK();
                    Log.i("MicroMsg.SnsPostReportLogic", "report sns image exif [%s]", fsVar.abW());
                }
            }
        }
        AppMethodBeat.o(96207);
    }
}
