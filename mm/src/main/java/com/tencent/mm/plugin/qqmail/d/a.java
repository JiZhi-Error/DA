package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.am;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;

public final class a extends IListener<am> {
    public a() {
        AppMethodBeat.i(161672);
        this.__eventId = am.class.getName().hashCode();
        AppMethodBeat.o(161672);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(am amVar) {
        AppMethodBeat.i(122653);
        boolean a2 = a(amVar);
        AppMethodBeat.o(122653);
        return a2;
    }

    private static boolean a(am amVar) {
        AppMethodBeat.i(122652);
        if (!(amVar instanceof am)) {
            Log.f("MicroMsg.QQMail.EventListener", "not bind qq event");
            AppMethodBeat.o(122652);
        } else {
            if (amVar.dDo.dDq == 0) {
                String str = (String) g.aAh().azQ().get(ar.a.USERINFO_EXT_BIND_XMAIL_STRING_SYNC, (Object) null);
                Log.i("MicroMsg.QQMail.EventListener", "unbind qq, bindXMail is [%s]", str);
                if (Util.isNullOrNil(str)) {
                    try {
                        g.aAh().azQ().set(17, (Object) 2);
                        int aUl = z.aUl() | 1;
                        g.aAh().azQ().set(34, Integer.valueOf(aUl));
                        ((l) g.af(l.class)).aSM().d(new com.tencent.mm.ba.l("", "", "", "", "", "", "", "", aUl, "", ""));
                        ac.eGs();
                        Log.d("MicroMsg.QQMail.EventListener", "doClearQQMailHelper succ ");
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.QQMail.EventListener", e2, "", new Object[0]);
                    }
                }
            }
            AppMethodBeat.o(122652);
        }
        return false;
    }
}
