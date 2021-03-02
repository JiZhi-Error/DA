package com.tencent.kinda.framework.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ll;
import com.tencent.mm.plugin.appbrand.jsapi.bo;
import com.tencent.mm.plugin.appbrand.jsapi.cj;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public class KindaJSInvokeListener extends IListener<ll> {
    private static final String TAG = "MicroMsg.KindaJSInvokeListener";

    public interface JSHandler {
        void handle(ll llVar);

        String handleJsApi();

        int handleType();
    }

    public KindaJSInvokeListener() {
        AppMethodBeat.i(214440);
        this.__eventId = ll.class.getName().hashCode();
        AppMethodBeat.o(214440);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public /* bridge */ /* synthetic */ boolean callback(ll llVar) {
        AppMethodBeat.i(214443);
        boolean callback = callback(llVar);
        AppMethodBeat.o(214443);
        return callback;
    }

    public boolean callback(ll llVar) {
        AppMethodBeat.i(214441);
        Log.i(TAG, "handle jsapi callback: %s, %s", llVar.dQJ.dQM, Integer.valueOf(llVar.dQJ.type));
        JSHandler createHandler = createHandler(llVar);
        if (createHandler != null) {
            createHandler.handle(llVar);
        }
        AppMethodBeat.o(214441);
        return false;
    }

    private JSHandler createHandler(ll llVar) {
        AppMethodBeat.i(214442);
        if (llVar.dQJ.dQM.equals(cj.NAME)) {
            PhoneBindCardVerifySmsJSHandler phoneBindCardVerifySmsJSHandler = new PhoneBindCardVerifySmsJSHandler();
            AppMethodBeat.o(214442);
            return phoneBindCardVerifySmsJSHandler;
        } else if (llVar.dQJ.dQM.equals(bo.NAME)) {
            requestQueryCashierJsHandler requestquerycashierjshandler = new requestQueryCashierJsHandler();
            AppMethodBeat.o(214442);
            return requestquerycashierjshandler;
        } else {
            AppMethodBeat.o(214442);
            return null;
        }
    }
}
