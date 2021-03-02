package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bg;
import com.tencent.mm.g.a.e;
import com.tencent.mm.g.a.vv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.sns.model.b.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Date;

public final class as {
    long DMH = 0;
    private boolean DMI = false;
    int DMJ = 0;
    int DMK = 1440;
    IListener<vv> DML = new IListener<vv>() {
        /* class com.tencent.mm.plugin.sns.model.as.AnonymousClass1 */

        {
            AppMethodBeat.i(160674);
            this.__eventId = vv.class.getName().hashCode();
            AppMethodBeat.o(160674);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(vv vvVar) {
            AppMethodBeat.i(95924);
            boolean fbz = fbz();
            AppMethodBeat.o(95924);
            return fbz;
        }

        private boolean fbz() {
            AppMethodBeat.i(95923);
            as asVar = as.this;
            try {
                if (asVar.fby()) {
                    Date date = new Date();
                    int minutes = date.getMinutes() + (date.getHours() * 60);
                    if (minutes >= asVar.DMJ && minutes <= asVar.DMK) {
                        Log.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  %d in [%d, %d]", Integer.valueOf(minutes), Integer.valueOf(asVar.DMJ), Integer.valueOf(asVar.DMK));
                        AppMethodBeat.o(95923);
                        return false;
                    }
                }
            } catch (Exception e2) {
            }
            int i2 = h.aqJ().getInt("SnsImgPreLoadingSmallImage", 1);
            int i3 = h.aqJ().getInt("SnsImgPreLoadingBigImage", 1);
            int fcj = a.fcj();
            int fci = a.fci();
            Log.i("MicroMsg.SnsPreTimelineService", " preloadingSamllImage %d preloadingBigImage %d preloadingVideo %d preloadingInterval %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(fcj), Integer.valueOf(fci));
            if (i2 > 0 || i3 > 0 || fcj > 0) {
                if (fci <= 0) {
                    fci = 1200;
                }
                if (asVar.jre || asVar.jrf || Util.secondsToNow(asVar.DMH) < ((long) fci)) {
                    Log.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  isInChatting:%b, isInSnsTimeline:%b", Boolean.valueOf(asVar.jre), Boolean.valueOf(asVar.jrf));
                } else if (!z.aPa("@__weixintimtline")) {
                    Log.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked: doing timeline");
                } else {
                    g.aAi();
                    if (!g.aAg().hqi.a(new u(), 0)) {
                        Log.i("MicroMsg.SnsPreTimelineService", "newObjectSync triggered");
                        z.aPb("@__weixintimtline");
                    }
                    asVar.DMH = Util.nowSecond();
                }
            }
            AppMethodBeat.o(95923);
            return false;
        }
    };
    IListener DMM = new IListener<e>() {
        /* class com.tencent.mm.plugin.sns.model.as.AnonymousClass2 */

        {
            AppMethodBeat.i(160675);
            this.__eventId = e.class.getName().hashCode();
            AppMethodBeat.o(160675);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(e eVar) {
            AppMethodBeat.i(95925);
            e eVar2 = eVar;
            if ("SnsTimeLineUI".equals(eVar2.dBR.className)) {
                as.this.jrf = eVar2.dBR.active;
                Log.i("MicroMsg.SnsPreTimelineService", "set isInSnsTimeline:%b", Boolean.valueOf(as.this.jrf));
            }
            AppMethodBeat.o(95925);
            return false;
        }
    };
    IListener DMN = new IListener<bg>() {
        /* class com.tencent.mm.plugin.sns.model.as.AnonymousClass3 */

        {
            AppMethodBeat.i(160676);
            this.__eventId = bg.class.getName().hashCode();
            AppMethodBeat.o(160676);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bg bgVar) {
            AppMethodBeat.i(95926);
            as.this.jre = bgVar.dEu.dEv;
            Log.i("MicroMsg.SnsPreTimelineService", "set isInChatting:%b", Boolean.valueOf(as.this.jre));
            AppMethodBeat.o(95926);
            return false;
        }
    };
    boolean jre = false;
    boolean jrf = false;

    as() {
        AppMethodBeat.i(95927);
        AppMethodBeat.o(95927);
    }

    /* access modifiers changed from: package-private */
    public final boolean fby() {
        AppMethodBeat.i(95928);
        String value = h.aqJ().getValue("SnsImgPreLoadingTimeLimit");
        Log.i("MicroMsg.SnsPreTimelineService", "preloadLimit:%s", value);
        if (Util.isNullOrNil(value)) {
            AppMethodBeat.o(95928);
            return false;
        }
        try {
            String[] split = value.split("-");
            String[] split2 = split[0].split(":");
            this.DMJ = Util.safeParseInt(split2[1]) + (Util.safeParseInt(split2[0]) * 60);
            String[] split3 = split[1].split(":");
            this.DMK = Util.safeParseInt(split3[1]) + (Util.safeParseInt(split3[0]) * 60);
            Log.d("MicroMsg.SnsPreTimelineService", "preloadLimit:%d-%d", Integer.valueOf(this.DMJ), Integer.valueOf(this.DMK));
            AppMethodBeat.o(95928);
            return true;
        } catch (Exception e2) {
            AppMethodBeat.o(95928);
            return false;
        }
    }
}
