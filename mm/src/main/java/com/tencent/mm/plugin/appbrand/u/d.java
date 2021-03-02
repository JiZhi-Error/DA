package com.tencent.mm.plugin.appbrand.u;

import android.webkit.JavascriptInterface;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.u.a.b;
import com.tencent.mm.plugin.appbrand.u.a.e;
import com.tencent.mm.plugin.appbrand.u.d.a;
import com.tencent.mm.plugin.appbrand.u.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class d implements b.a, e.a {
    static final /* synthetic */ boolean $assertionsDisabled = (!d.class.desiredAssertionStatus());
    private final s kAr;
    private final i lxm;
    private final Map<Integer, Integer> njU = new ConcurrentHashMap();
    private final e njV;

    static {
        AppMethodBeat.i(147378);
        AppMethodBeat.o(147378);
    }

    public d(s sVar, i iVar) {
        AppMethodBeat.i(147370);
        this.kAr = sVar;
        this.lxm = iVar;
        e eVar = new e();
        eVar.a(new a(this, sVar));
        eVar.a(new c(this, sVar));
        eVar.a(new com.tencent.mm.plugin.appbrand.u.d.b(this, sVar));
        this.njV = eVar;
        AppMethodBeat.o(147370);
    }

    public final void bPS() {
        AppMethodBeat.i(147371);
        Log.i("MicroMsg.NodeJavaBroker", "shutdown");
        for (Map.Entry<Integer, Integer> entry : this.njU.entrySet()) {
            unListen(entry.getKey().intValue());
        }
        this.njU.clear();
        AppMethodBeat.o(147371);
    }

    @JavascriptInterface
    public void req(int i2, final String str, final int i3) {
        AppMethodBeat.i(147372);
        Log.v("MicroMsg.NodeJavaBroker", "req: cmd:%d args:%s respId:%d", Integer.valueOf(i2), str, Integer.valueOf(i3));
        com.tencent.mm.plugin.appbrand.u.a.a yF = b.yF(i2);
        if (!$assertionsDisabled && yF == null) {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(147372);
            throw assertionError;
        } else if (!(yF instanceof b)) {
            IllegalStateException illegalStateException = new IllegalStateException("req asynchronously, but target cmd not async!");
            AppMethodBeat.o(147372);
            throw illegalStateException;
        } else {
            final b bVar = (b) yF;
            h.RTc.aX(new com.tencent.f.i.h() {
                /* class com.tencent.mm.plugin.appbrand.u.d.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(147369);
                    bVar.a(str, new com.tencent.mm.plugin.appbrand.u.a.c(d.this.kAr, i3, d.this));
                    AppMethodBeat.o(147369);
                }

                @Override // com.tencent.f.i.h, com.tencent.f.i.g
                public final String getKey() {
                    AppMethodBeat.i(177511);
                    String str = "MicroMsg.NodeJavaBroker~CMD~" + bVar.bPT();
                    AppMethodBeat.o(177511);
                    return str;
                }
            });
            AppMethodBeat.o(147372);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.u.a.b.a
    public final void ap(int i2, String str) {
        AppMethodBeat.i(147373);
        if (i2 <= 0) {
            AppMethodBeat.o(147373);
            return;
        }
        this.lxm.evaluateJavascript(String.format("typeof gNodeController != 'undefined' && gNodeController.javaResp(%d, %s);", Integer.valueOf(i2), str), null);
        AppMethodBeat.o(147373);
    }

    @JavascriptInterface
    public String reqSync(int i2, String str) {
        AppMethodBeat.i(147374);
        Log.v("MicroMsg.NodeJavaBroker", "reqSync: cmd:%d args:%s", Integer.valueOf(i2), str);
        com.tencent.mm.plugin.appbrand.u.a.a yF = b.yF(i2);
        if (!$assertionsDisabled && yF == null) {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(147374);
            throw assertionError;
        } else if (!(yF instanceof com.tencent.mm.plugin.appbrand.u.a.d)) {
            IllegalStateException illegalStateException = new IllegalStateException("req synchronously, but target cmd not sync!");
            AppMethodBeat.o(147374);
            throw illegalStateException;
        } else {
            String a2 = ((com.tencent.mm.plugin.appbrand.u.a.d) yF).a(str, new com.tencent.mm.plugin.appbrand.u.a.c(this.kAr));
            AppMethodBeat.o(147374);
            return a2;
        }
    }

    @JavascriptInterface
    public void listen(int i2, int i3) {
        AppMethodBeat.i(147375);
        e yG = this.njV.yG(i2);
        if (yG == null) {
            Log.e("MicroMsg.NodeJavaBroker", "listen listenerProxy null");
            AppMethodBeat.o(147375);
            return;
        }
        yG.listen(i3);
        this.njU.put(Integer.valueOf(i3), Integer.valueOf(i2));
        AppMethodBeat.o(147375);
    }

    @JavascriptInterface
    public void unListen(int i2) {
        AppMethodBeat.i(147376);
        Integer num = this.njU.get(Integer.valueOf(i2));
        if (num == null) {
            AppMethodBeat.o(147376);
            return;
        }
        int intValue = num.intValue();
        Log.v("MicroMsg.NodeJavaBroker", "unListen: listenerType:%d listenerId:%d", Integer.valueOf(intValue), Integer.valueOf(i2));
        e yG = this.njV.yG(intValue);
        if (yG == null) {
            Log.e("MicroMsg.NodeJavaBroker", "unListen listenerProxy null");
            AppMethodBeat.o(147376);
            return;
        }
        yG.unListen(i2);
        this.njU.remove(Integer.valueOf(i2));
        AppMethodBeat.o(147376);
    }

    @Override // com.tencent.mm.plugin.appbrand.u.a.e.a
    public final void f(int i2, Map<String, Object> map) {
        AppMethodBeat.i(147377);
        com.tencent.luggage.h.e.m(map);
        this.lxm.evaluateJavascript(String.format("typeof gNodeController != 'undefined' && gNodeController.javaOnTrigger(%d, %s);", Integer.valueOf(i2), new com.tencent.mm.ab.i(map).toString()), null);
        AppMethodBeat.o(147377);
    }
}
