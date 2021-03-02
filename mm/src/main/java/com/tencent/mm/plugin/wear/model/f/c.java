package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.g.a.aap;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class c extends d {
    /* access modifiers changed from: protected */
    public abstract void send();

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.f.d
    public final void execute() {
        if (a.fVM().fVW()) {
            aap aap = new aap();
            aap.ehC.dDe = 11;
            EventCenter.instance.publish(aap);
            send();
            return;
        }
        Log.i("MicroMsg.WearBaseSendTask", "can not send message to wear");
    }
}
