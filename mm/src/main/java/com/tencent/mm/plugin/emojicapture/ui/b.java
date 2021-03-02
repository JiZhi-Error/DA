package com.tencent.mm.plugin.emojicapture.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16})
public final class b implements Runnable {
    private final /* synthetic */ a cuq;

    b(a aVar) {
        this.cuq = aVar;
    }

    public final /* synthetic */ void run() {
        AppMethodBeat.i(JsApiQueryDownloadTask.CTRL_INDEX);
        p.g(this.cuq.invoke(), "invoke(...)");
        AppMethodBeat.o(JsApiQueryDownloadTask.CTRL_INDEX);
    }
}
