package com.tencent.mm.plugin.appbrand.ae.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ae.e.a;
import com.tencent.mm.plugin.appbrand.ae.e.c;
import com.tencent.mm.plugin.appbrand.ae.e.i;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public final class d extends c {
    @Override // com.tencent.mm.plugin.appbrand.ae.b.a, com.tencent.mm.plugin.appbrand.ae.b.b
    public final c a(a aVar, i iVar) {
        AppMethodBeat.i(156647);
        super.a(aVar, iVar);
        iVar.afP("WebSocket Protocol Handshake");
        iVar.put("Server", "Java-WebSocket");
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        iVar.put("Date", simpleDateFormat.format(instance.getTime()));
        AppMethodBeat.o(156647);
        return iVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.b.c, com.tencent.mm.plugin.appbrand.ae.b.a, com.tencent.mm.plugin.appbrand.ae.b.b
    public final a bZD() {
        AppMethodBeat.i(156648);
        d dVar = new d();
        AppMethodBeat.o(156648);
        return dVar;
    }
}
