package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ni;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class c<T extends IEvent> extends IListener<T> implements i {
    private static HashMap<q, IEvent> JTo = new HashMap<>();
    private static HashMap<IEvent, c<? extends IEvent>> bGH = new HashMap<>();
    private int JTn = 0;

    public abstract q a(T t);

    public abstract IEvent a(int i2, q qVar, T t);

    public abstract int alY();

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.tencent.mm.pluginsdk.c.c<T extends com.tencent.mm.sdk.event.IEvent> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        IEvent remove;
        if (alY() == qVar.getType() && (remove = JTo.remove(qVar)) != null) {
            ni niVar = new ni();
            niVar.dTt.dTu = a(i3, qVar, remove);
            niVar.dTt.errType = i2;
            niVar.dTt.errCode = i3;
            niVar.dTt.errMsg = str;
            EventCenter.instance.publish(niVar);
        }
    }

    public static void j(IEvent iEvent) {
        q qVar;
        Iterator<Map.Entry<q, IEvent>> it = JTo.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                qVar = null;
                break;
            }
            Map.Entry<q, IEvent> next = it.next();
            if (next.getValue() == iEvent) {
                qVar = next.getKey();
                break;
            }
        }
        if (qVar != null) {
            g.azz().a(qVar);
            JTo.remove(qVar);
        }
    }

    public final void gmc() {
        if (this.JTn == 0) {
            g.azz().a(alY(), this);
        }
        this.JTn++;
    }

    public final void ecc() {
        if (this.JTn != 0) {
            this.JTn--;
            if (this.JTn == 0) {
                g.azz().b(alY(), this);
            }
        }
    }

    public final void k(T t) {
        q a2 = a(t);
        g.azz().a(a2, 0);
        JTo.put(a2, t);
    }
}
