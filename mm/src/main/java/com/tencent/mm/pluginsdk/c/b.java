package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.g.a.ni;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import java.util.ArrayList;

public abstract class b extends IListener<ni> {
    protected ArrayList<String> JTm = new ArrayList<>(3);

    public abstract void a(int i2, int i3, String str, IEvent iEvent);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public /* synthetic */ boolean callback(ni niVar) {
        ni niVar2 = niVar;
        if (!(niVar2 instanceof ni) || niVar2.dTt.dTu == null || !this.JTm.contains(niVar2.dTt.dTu.getClass().getName())) {
            return false;
        }
        a(niVar2.dTt.errType, niVar2.dTt.errCode, niVar2.dTt.errMsg, niVar2.dTt.dTu);
        return false;
    }

    public b() {
        super(0);
        this.__eventId = ni.class.getName().hashCode();
    }

    public static void a(String str, b bVar) {
        if (!bVar.JTm.contains(str)) {
            bVar.JTm.add(str);
        }
        EventCenter.instance.addListener(bVar);
        e.bdh(str);
    }

    public static void b(String str, b bVar) {
        e.bdi(str);
        EventCenter.instance.removeListener(bVar);
        if (bVar.JTm.contains(str)) {
            bVar.JTm.remove(str);
        }
    }
}
