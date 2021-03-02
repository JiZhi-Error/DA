package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.g.a.me;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import java.util.ArrayList;

public abstract class a extends IListener<me> {
    protected ArrayList<String> JTm = new ArrayList<>(3);

    public abstract void g(IEvent iEvent);

    public a() {
        this.__eventId = me.class.getName().hashCode();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public /* synthetic */ boolean callback(me meVar) {
        me meVar2 = meVar;
        if (!(meVar2 instanceof me) || meVar2.dRE.dRF == null || !this.JTm.contains(meVar2.dRE.dRF.getClass().getName())) {
            return false;
        }
        g(meVar2.dRE.dRF);
        return false;
    }

    public static void a(String str, a aVar) {
        if (!aVar.JTm.contains(str)) {
            aVar.JTm.add(str);
        }
        EventCenter.instance.addListener(aVar);
        e.bdh(str);
    }

    public static void b(String str, a aVar) {
        e.bdi(str);
        EventCenter.instance.removeListener(aVar);
        if (aVar.JTm.contains(str)) {
            aVar.JTm.remove(str);
        }
    }
}
