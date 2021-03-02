package com.tencent.wxa.b;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxa.d;
import io.flutter.plugin.a.k;
import java.util.HashMap;
import java.util.Map;

public final class a implements c {
    private b SxZ;

    public a(b bVar) {
        this.SxZ = bVar;
    }

    private Map hrM() {
        AppMethodBeat.i(206316);
        HashMap hashMap = new HashMap();
        String KQ = this.SxZ.KQ();
        String KR = this.SxZ.KR();
        Map KS = this.SxZ.KS();
        hashMap.put("activityId", KQ);
        hashMap.put("name", KR);
        hashMap.put(NativeProtocol.WEB_DIALOG_PARAMS, KS);
        AppMethodBeat.o(206316);
        return hashMap;
    }

    @Override // com.tencent.wxa.b.c
    public final void onCreateView() {
        AppMethodBeat.i(206317);
        d.G("onCreateView", hrM());
        AppMethodBeat.o(206317);
    }

    @Override // com.tencent.wxa.b.c
    public final void onResume() {
        AppMethodBeat.i(206318);
        d.G("onResumeView", hrM());
        AppMethodBeat.o(206318);
    }

    @Override // com.tencent.wxa.b.c
    public final void onPause() {
        AppMethodBeat.i(206319);
        d.G("onPauseView", hrM());
        AppMethodBeat.o(206319);
    }

    @Override // com.tencent.wxa.b.c
    public final void onDestroyView() {
        AppMethodBeat.i(206320);
        d.G("onDestroyView", hrM());
        AppMethodBeat.o(206320);
    }

    @Override // com.tencent.wxa.b.c
    public final void a(k.d dVar) {
        AppMethodBeat.i(206321);
        com.tencent.wxa.c.a.d("WxaRouter.DefaultFlutterViewLifecycle", "onBackPressed", new Object[0]);
        d.a("onBackPressed", dVar);
        AppMethodBeat.o(206321);
    }

    @Override // com.tencent.wxa.b.c
    public final void hrN() {
        AppMethodBeat.i(206322);
        d.G("closeView", hrM());
        AppMethodBeat.o(206322);
    }
}
