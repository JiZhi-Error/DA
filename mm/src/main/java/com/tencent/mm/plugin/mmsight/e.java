package com.tencent.mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.a.wb;
import com.tencent.mm.model.bd;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.m;
import com.tencent.mm.plugin.mmsight.model.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class e implements bd {
    private n zsS = new n();
    private IListener zsT = new IListener<vq>() {
        /* class com.tencent.mm.plugin.mmsight.e.AnonymousClass1 */

        {
            AppMethodBeat.i(161100);
            this.__eventId = vq.class.getName().hashCode();
            AppMethodBeat.o(161100);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(vq vqVar) {
            AppMethodBeat.i(89315);
            vq vqVar2 = vqVar;
            vqVar2.ebO.result = d.PF(vqVar2.ebN.ebP);
            AppMethodBeat.o(89315);
            return true;
        }
    };
    private IListener zsU = new IListener<wb>() {
        /* class com.tencent.mm.plugin.mmsight.e.AnonymousClass2 */

        {
            AppMethodBeat.i(161101);
            this.__eventId = wb.class.getName().hashCode();
            AppMethodBeat.o(161101);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(wb wbVar) {
            AppMethodBeat.i(89316);
            wb wbVar2 = wbVar;
            if (m.a(wbVar2.eci.ebP, com.tencent.mm.modelcontrol.e.baZ().bbb(), wbVar2.eci.eck, wbVar2.eci.ecm)) {
                wbVar2.eci.ecl.run();
                wbVar2.ecj.result = m.b(wbVar2.eci.ebP, com.tencent.mm.modelcontrol.e.baZ().bbb(), wbVar2.eci.eck, wbVar2.eci.ecm);
            } else {
                wbVar2.ecj.result = 1;
            }
            AppMethodBeat.o(89316);
            return false;
        }
    };

    public e() {
        AppMethodBeat.i(89317);
        AppMethodBeat.o(89317);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(89318);
        o.bho().a(this.zsS);
        EventCenter.instance.add(this.zsU);
        EventCenter.instance.addListener(this.zsT);
        AppMethodBeat.o(89318);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(89319);
        o.bho().b(this.zsS);
        EventCenter.instance.removeListener(this.zsU);
        k.zwi.aRR();
        EventCenter.instance.removeListener(this.zsT);
        AppMethodBeat.o(89319);
    }
}
