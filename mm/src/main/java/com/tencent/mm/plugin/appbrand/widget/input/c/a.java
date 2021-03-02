package com.tencent.mm.plugin.appbrand.widget.input.c;

import android.os.Looper;
import android.os.Message;
import android.text.Selection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class a {
    private final MMHandler mQp = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.appbrand.widget.input.c.a.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(131518);
            if (1000 == message.what) {
                String str = (String) message.obj;
                int i2 = message.arg1;
                if (a.this.owK != null) {
                    a.this.owK.bL(str, i2);
                }
            }
            AppMethodBeat.o(131518);
        }
    };
    public volatile c owK;

    public a() {
        AppMethodBeat.i(131519);
        AppMethodBeat.o(131519);
    }

    public final void a(CharSequence charSequence, boolean z) {
        AppMethodBeat.i(131520);
        if (charSequence == null) {
            AppMethodBeat.o(131520);
            return;
        }
        Message obtainMessage = this.mQp.obtainMessage(1000, Selection.getSelectionEnd(charSequence), 0, charSequence.toString());
        this.mQp.removeMessages(1000);
        this.mQp.sendMessageDelayed(obtainMessage, z ? 150 : 0);
        AppMethodBeat.o(131520);
    }
}
