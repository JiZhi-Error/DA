package com.tencent.mm.ui.chatting.d;

import android.database.Cursor;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.o;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.service.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.g;
import com.tencent.mm.ui.chatting.d.b.k;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@a(gRF = g.class)
public class f extends a implements g {
    private long PnA;
    private long PnB;
    private long PnC;
    private int PnD;
    private Set<Integer> PnE = new HashSet();
    private String kIg;
    private IListener<o> nRQ = new IListener<o>() {
        /* class com.tencent.mm.ui.chatting.d.f.AnonymousClass1 */

        {
            AppMethodBeat.i(233036);
            this.__eventId = o.class.getName().hashCode();
            AppMethodBeat.o(233036);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(o oVar) {
            AppMethodBeat.i(233037);
            if (f.this.dom != null) {
                f.this.dom.Pwc.getContext().runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.d.f.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(233035);
                        f.this.dom.cmy();
                        AppMethodBeat.o(233035);
                    }
                });
            }
            AppMethodBeat.o(233037);
            return true;
        }
    };
    private int rGT;

    public f() {
        AppMethodBeat.i(233038);
        AppMethodBeat.o(233038);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIl() {
        int i2;
        int i3;
        ca amt;
        AppMethodBeat.i(233039);
        super.gIl();
        if (!gPo()) {
            AppMethodBeat.o(233039);
            return;
        }
        if (((l) com.tencent.mm.kernel.g.af(l.class)).eiy().aEM("appbrand_notify_message") >= 2 && (amt = ((k) this.dom.bh(k.class)).amt(0)) != null && amt.field_isSend == 2) {
            ((k) this.dom.bh(k.class)).amv(1);
        }
        com.tencent.mm.plugin.appbrand.service.g gVar = (com.tencent.mm.plugin.appbrand.service.g) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.g.class);
        if (gVar != null) {
            this.kIg = gVar.bul();
            g.a bum = gVar.bum();
            i3 = bum.dCm;
            i2 = bum.nMs;
        } else {
            i2 = 0;
            i3 = 0;
        }
        a(1, 0, 0, null, 0, i3, Util.currentTicks(), i2);
        AppMethodBeat.o(233039);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIk() {
        AppMethodBeat.i(233040);
        super.gIk();
        if (!gPo()) {
            AppMethodBeat.o(233040);
            return;
        }
        com.tencent.mm.kernel.g.aAf();
        this.rGT = com.tencent.mm.kernel.a.getUin();
        this.PnB = Util.currentTicks();
        this.PnA = System.currentTimeMillis();
        this.PnC = 0;
        this.PnD = 0;
        this.PnE.clear();
        AppMethodBeat.o(233040);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFx() {
        AppMethodBeat.i(233041);
        super.cFx();
        if (!gPo()) {
            AppMethodBeat.o(233041);
            return;
        }
        this.PnB = Util.currentTicks();
        EventCenter.instance.addListener(this.nRQ);
        AppMethodBeat.o(233041);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFy() {
        AppMethodBeat.i(233042);
        super.cFy();
        if (!gPo()) {
            AppMethodBeat.o(233042);
            return;
        }
        this.PnC += Util.ticksToNow(this.PnB) / 1000;
        EventCenter.instance.removeListener(this.nRQ);
        AppMethodBeat.o(233042);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIo() {
        AppMethodBeat.i(233043);
        super.gIo();
        if (!gPo()) {
            AppMethodBeat.o(233043);
            return;
        }
        this.PnC += Util.ticksToNow(this.PnB) / 1000;
        a(8, this.PnC, this.PnE.size(), com.tencent.mm.ag.a.a.HL(com.tencent.mm.ag.a.a.HK(((l) com.tencent.mm.kernel.g.af(l.class)).eiy().aEx("appbrand_notify_message").field_content).title), this.PnD, 0, Util.currentTicks(), 0);
        Cursor ez = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().ez("appbrand_notify_message", -1);
        if (ez == null) {
            Log.e("MicroMsg.ChattingAppBrandNotifyReportComponent", "[buildShowReportParams] cursor is null!");
        } else {
            int i2 = 1;
            while (ez.moveToNext()) {
                try {
                    ca caVar = new ca();
                    caVar.convertFrom(ez);
                    com.tencent.mm.ag.a.a HK = com.tencent.mm.ag.a.a.HK(caVar.field_content);
                    if (caVar.field_isSend == 2) {
                        i2++;
                    } else {
                        if (((this.PnA > Util.safeParseLong(caVar.ean) && this.PnA - Util.safeParseLong(caVar.ean) <= Util.MILLSECONDS_OF_MINUTE) || Util.safeParseLong(caVar.ean) > this.PnA) && this.PnC >= 3) {
                            Log.i("MicroMsg.ChattingAppBrandNotifyReportComponent", "report in time event, msgId:%s", HK.msgId);
                            h.INSTANCE.a(19724, 4, 0, 0, Integer.valueOf(i2), 0, null, 0, 0, 0, HK.appId, null, null, HK.msgId, 0, null, com.tencent.mm.ag.a.a.HL(HK.title), 1, null, null, this.kIg);
                        }
                        i2++;
                    }
                } catch (Throwable th) {
                    ez.close();
                    AppMethodBeat.o(233043);
                    throw th;
                }
            }
            ez.close();
        }
        String mD5String = MD5Util.getMD5String(this.rGT + String.valueOf(System.currentTimeMillis()));
        Cursor ez2 = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().ez("appbrand_notify_message", this.PnD);
        if (ez2 == null) {
            Log.e("MicroMsg.ChattingAppBrandNotifyReportComponent", "[buildShowReportParams] cursor is null!");
        } else {
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            int i3 = 0;
            while (ez2.moveToNext()) {
                try {
                    ca caVar2 = new ca();
                    caVar2.convertFrom(ez2);
                    com.tencent.mm.ag.a.a HK2 = com.tencent.mm.ag.a.a.HK(caVar2.field_content);
                    if (caVar2.field_isSend != 2) {
                        int i4 = i3 + 1;
                        sb.append(String.format(Locale.US, "[%s:%s:%d];", HK2.appId, HK2.msgId, Integer.valueOf(i4)));
                        if (sb.length() > 5000) {
                            Log.i("MicroMsg.ChattingAppBrandNotifyReportComponent", "cut off exposed message");
                            sb.setLength(sb.length() - 1);
                            nh(mD5String, sb.toString());
                            sb.delete(0, sb.length());
                            z = true;
                        }
                        i3 = i4;
                    }
                } catch (Throwable th2) {
                    ez2.close();
                    AppMethodBeat.o(233043);
                    throw th2;
                }
            }
            ez2.close();
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            if (Util.isNullOrNil(sb.toString().trim())) {
                Log.i("MicroMsg.ChattingAppBrandNotifyReportComponent", "empty msg show report content, skip report");
            } else {
                nh(z ? mD5String : null, sb.toString());
            }
        }
        this.PnE.clear();
        this.kIg = null;
        com.tencent.mm.plugin.appbrand.service.g gVar = (com.tencent.mm.plugin.appbrand.service.g) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.g.class);
        if (gVar != null) {
            gVar.clear();
        }
        AppMethodBeat.o(233043);
    }

    @Override // com.tencent.mm.ui.l
    public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        AppMethodBeat.i(233044);
        super.onScroll(absListView, i2, i3, i4);
        if (!gPo()) {
            AppMethodBeat.o(233044);
            return;
        }
        this.PnD = Math.max(this.PnD, i4 - i2);
        AppMethodBeat.o(233044);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.g
    public final void gPn() {
        AppMethodBeat.i(233045);
        if (!gPo()) {
            AppMethodBeat.o(233045);
            return;
        }
        a(10, 0, 0, null, 0, 0, 0, 0);
        AppMethodBeat.o(233045);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.g
    public final void amz(int i2) {
        AppMethodBeat.i(233046);
        if (!gPo()) {
            AppMethodBeat.o(233046);
            return;
        }
        this.PnE.add(Integer.valueOf(Math.max(0, i2)));
        AppMethodBeat.o(233046);
    }

    private void nh(String str, String str2) {
        AppMethodBeat.i(233047);
        h.INSTANCE.a(19724, 2, 0, 0, 0, 0, null, 0, 0, 0, null, null, null, null, 0, null, null, 0, str2, str, this.kIg);
        AppMethodBeat.o(233047);
    }

    private void a(int i2, long j2, int i3, String str, int i4, int i5, long j3, int i6) {
        AppMethodBeat.i(233048);
        Log.d("MicroMsg.ChattingAppBrandNotifyReportComponent", "report notify operate, eventId:%d, stayDuration:%d, opCount:%d, LastMsgContent:%s, readCount:%d, unreadCount:%d, timeStamp:%d, indexInSessionList:%d, appId:%s, pagePath:%s, label:%s", Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), str, Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j3), Integer.valueOf(i6), null, null, null);
        h.INSTANCE.a(19724, 1, Integer.valueOf(i2), Long.valueOf(j2), 0, Integer.valueOf(i3), str, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), null, null, null, null, 0, null, null, 0, null, null, this.kIg);
        AppMethodBeat.o(233048);
    }

    private boolean gPo() {
        AppMethodBeat.i(233049);
        if (Util.isNullOrNil(this.dom.getTalkerUserName())) {
            AppMethodBeat.o(233049);
            return false;
        }
        boolean JC = ab.JC(this.dom.getTalkerUserName());
        AppMethodBeat.o(233049);
        return JC;
    }
}
