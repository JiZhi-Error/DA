package com.tencent.mm.plugin.webview.luggage.ipc;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.ui.MMActivity;

public final class b {
    public static <T extends c> void a(MMActivity mMActivity, Bundle bundle, Class<T> cls, final a aVar) {
        AppMethodBeat.i(78488);
        Intent intent = new Intent();
        intent.putExtra("task_class_name", cls.getName());
        intent.putExtra("input_data", bundle);
        intent.putExtra("orientation", -1);
        mMActivity.mmSetOnActivityResultCallback(new MMActivity.a() {
            /* class com.tencent.mm.plugin.webview.luggage.ipc.b.AnonymousClass1 */

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                AppMethodBeat.i(78487);
                if (i2 == 3456) {
                    if (intent == null || aVar == null) {
                        AppMethodBeat.o(78487);
                        return;
                    } else {
                        aVar.v(intent.getBundleExtra("input_data"));
                    }
                }
                AppMethodBeat.o(78487);
            }
        });
        c.b(mMActivity, "webview", ".luggage.ipc.IpcProxyUI", intent, 3456);
        AppMethodBeat.o(78488);
    }
}
