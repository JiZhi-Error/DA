package com.tencent.mm.plugin.appbrand.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.v;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.ag.c;
import com.tencent.mm.plugin.appbrand.bc;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.x;
import java.util.ArrayList;

public class a extends x {
    public a(s sVar) {
        super(sVar);
    }

    @Override // com.tencent.mm.plugin.appbrand.x
    public v bti() {
        AppMethodBeat.i(147752);
        c cVar = new c(this.dra);
        AppMethodBeat.o(147752);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.x
    public final v.a Us(String str) {
        AppMethodBeat.i(147753);
        c.a aVar = new c.a(super.Us(str), bc.a(this.kAr.getRuntime(), str, this.kAr.Ot()), this.kAr.getAppId(), this.kAr.bsW());
        AppMethodBeat.o(147753);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.x
    public final void a(ArrayList<v.a> arrayList, String str) {
        AppMethodBeat.i(147754);
        super.a(arrayList, str);
        arrayList.add(new c.a(this.kAr.Ou() + "shared_buffer.js", d.afA("wxa_library/shared_buffer.js"), this.kAr.getAppId(), this.kAr.bsW()));
        arrayList.add(new c.a(this.kAr.Ou() + "android.js", d.afA("wxa_library/android.js"), this.kAr.getAppId(), this.kAr.bsW()));
        arrayList.add(new c.a(this.kAr.Ou() + "lazy_load.js", d.afA("wxa_library/lazy_load.js"), this.kAr.getAppId(), this.kAr.bsW()));
        arrayList.add(new c.a(this.kAr.Ou() + "WAWorker.js", this.kAr.bqZ().UM("WAWorker.js"), this.kAr.getAppId(), this.kAr.bsW()));
        arrayList.add(new v.a(this.kAr.Ou() + "WASourceMap.js", bc.b(this.kAr)));
        arrayList.add(new v.a(this.kAr.Ou() + "sourcemapSysinfo", bc.getSysInfo()));
        AppMethodBeat.o(147754);
    }
}
