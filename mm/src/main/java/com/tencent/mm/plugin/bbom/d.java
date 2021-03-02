package com.tencent.mm.plugin.bbom;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.plugin.brandservice.a.a;
import com.tencent.mm.pluginsdk.model.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.s;
import com.tencent.mm.ui.chatting.viewitems.e;
import com.tencent.mm.ui.tools.b;

public final class d implements a {
    @Override // com.tencent.mm.plugin.brandservice.a.a
    public final void a(View view, long j2, String str, String str2, int i2) {
        AppMethodBeat.i(22346);
        e.g gVar = new e.g();
        gVar.msgId = j2;
        gVar.PJs = i2;
        gVar.xml = str2;
        gVar.dRr = str;
        view.setTag(gVar);
        AppMethodBeat.o(22346);
    }

    @Override // com.tencent.mm.plugin.brandservice.a.a
    public final long dq(View view) {
        AppMethodBeat.i(22347);
        s.gA(view);
        if (view.getTag() instanceof e.g) {
            long j2 = ((e.g) view.getTag()).msgId;
            AppMethodBeat.o(22347);
            return j2;
        }
        AppMethodBeat.o(22347);
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x008a, code lost:
        if (r14.contains(r4.Vd()) != false) goto L_0x008c;
     */
    @Override // com.tencent.mm.plugin.brandservice.a.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.ag.v r19, final com.tencent.mm.storage.z r20, int r21, com.tencent.mm.ag.u r22, android.view.View r23, boolean r24, final int r25, final com.tencent.mm.plugin.brandservice.ui.timeline.h r26) {
        /*
        // Method dump skipped, instructions count: 468
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.bbom.d.a(com.tencent.mm.ag.v, com.tencent.mm.storage.z, int, com.tencent.mm.ag.u, android.view.View, boolean, int, com.tencent.mm.plugin.brandservice.ui.timeline.h):void");
    }

    @Override // com.tencent.mm.plugin.brandservice.a.a
    public final void b(c cVar, Activity activity, as asVar) {
        AppMethodBeat.i(22349);
        b.a(cVar, activity, asVar, 3);
        AppMethodBeat.o(22349);
    }

    @Override // com.tencent.mm.plugin.brandservice.a.a
    public final void a(int i2, Context context, String str, String str2, long j2, long j3) {
        AppMethodBeat.i(22350);
        s.a(i2, context, str, str2, j2, j3);
        AppMethodBeat.o(22350);
    }

    @Override // com.tencent.mm.plugin.brandservice.a.a
    public final void a(long j2, int i2, Context context, Activity activity, ca caVar) {
        AppMethodBeat.i(22351);
        s.a(j2, i2, context, (Fragment) null, activity, caVar);
        AppMethodBeat.o(22351);
    }

    @Override // com.tencent.mm.plugin.brandservice.a.a
    public final void a(ca caVar, Context context) {
        AppMethodBeat.i(22353);
        s.a(caVar, context, (com.tencent.mm.ui.chatting.e.a) null);
        AppMethodBeat.o(22353);
    }

    @Override // com.tencent.mm.plugin.brandservice.a.a
    public final void a(View view, String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(231631);
        e.g gVar = new e.g();
        e.h hVar = new e.h();
        gVar.PJr = hVar;
        hVar.title = str2;
        hVar.url = str3;
        hVar.JwO = str;
        hVar.coverUrl = str5;
        hVar.iAA = str4;
        view.setTag(gVar);
        AppMethodBeat.o(231631);
    }

    @Override // com.tencent.mm.plugin.brandservice.a.a
    public final void a(ca caVar, Activity activity) {
        AppMethodBeat.i(22352);
        if (!caVar.dOQ()) {
            cz czVar = new cz();
            h.d(czVar, caVar);
            czVar.dFZ.activity = activity;
            czVar.dFZ.dGf = 43;
            EventCenter.instance.publish(czVar);
            if (czVar.dGa.ret == 0) {
                com.tencent.mm.modelstat.b.jmd.ac(caVar);
            }
        }
        AppMethodBeat.o(22352);
    }

    @Override // com.tencent.mm.plugin.brandservice.a.a
    public final void bCm() {
        AppMethodBeat.i(231632);
        MMAppMgr.Bj(true);
        AppMethodBeat.o(231632);
    }
}
