package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.plugin.record.b.u;
import com.tencent.mm.plugin.record.ui.RecordVoiceBaseView;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class e implements h.b {
    private u BIz = new u();
    RecordVoiceBaseView BJl;

    public e() {
        AppMethodBeat.i(28041);
        AppMethodBeat.o(28041);
    }

    @Override // com.tencent.mm.plugin.record.ui.h.b
    public final View createView(Context context) {
        AppMethodBeat.i(28042);
        View inflate = View.inflate(context, R.layout.blp, null);
        ((RecordVoiceBaseView) inflate.findViewById(R.id.j_9)).setVoiceHelper(this.BIz);
        AppMethodBeat.o(28042);
        return inflate;
    }

    @Override // com.tencent.mm.plugin.record.ui.h.b
    public final void a(View view, int i2, b bVar, Object obj) {
        AppMethodBeat.i(28043);
        View findViewById = view.findViewById(R.id.c3g);
        this.BJl = (RecordVoiceBaseView) view.findViewById(R.id.j_9);
        if (bVar.dataType == 0) {
            this.BJl.setVisibility(8);
            findViewById.setVisibility(0);
            AppMethodBeat.o(28043);
            return;
        }
        if (bVar.dataType == 1) {
            findViewById.setVisibility(8);
            this.BJl.setVisibility(0);
            String a2 = com.tencent.mm.plugin.record.b.h.a(bVar);
            hb hbVar = new hb();
            hbVar.dLm.type = 17;
            hbVar.dLm.dLo = bVar.dKT;
            EventCenter.instance.publish(hbVar);
            int i3 = hbVar.dLn.ret;
            if (!s.YS(a2)) {
                if (Util.isNullOrNil(bVar.dKT.KuR)) {
                    findViewById.setVisibility(0);
                    this.BJl.setVisibility(8);
                } else {
                    Log.d("MicroMsg.VoiceViewWrapper", "restart voice %s, url %s", Long.valueOf(bVar.qNT.field_localId), bVar.dKT.KuR);
                    hb hbVar2 = new hb();
                    hbVar2.dLm.type = 16;
                    hbVar2.dLm.dFW = bVar.qNT.field_localId;
                    EventCenter.instance.publish(hbVar2);
                }
            }
            RecordVoiceBaseView recordVoiceBaseView = this.BJl;
            int i4 = bVar.dKT.duration;
            recordVoiceBaseView.path = Util.nullAs(a2, "");
            recordVoiceBaseView.dLt = i3;
            if (recordVoiceBaseView.duration != i4) {
                recordVoiceBaseView.duration = i4;
                recordVoiceBaseView.setText(((int) com.tencent.mm.modelvoice.s.AO((long) i4)) + "''");
            }
        }
        AppMethodBeat.o(28043);
    }

    @Override // com.tencent.mm.plugin.record.ui.h.b
    public final void destroy() {
        AppMethodBeat.i(28044);
        u uVar = this.BIz;
        uVar.stopPlay();
        uVar.cEE();
        u.qUq = null;
        uVar.callbacks.clear();
        AppMethodBeat.o(28044);
    }

    @Override // com.tencent.mm.plugin.record.ui.h.b
    public final void pause() {
        AppMethodBeat.i(28045);
        if (this.BIz != null && this.BIz.callbacks.size() > 0) {
            for (u.a aVar : this.BIz.callbacks) {
                aVar.onFinish();
            }
        }
        AppMethodBeat.o(28045);
    }
}
