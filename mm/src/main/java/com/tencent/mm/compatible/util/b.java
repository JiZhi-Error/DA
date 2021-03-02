package com.tencent.mm.compatible.util;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.a.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b {
    AbstractC0305b gLg = null;
    private final String gLh = "audio_lock";
    Context mContext = null;

    public interface a {
        void iZ(int i2);
    }

    /* renamed from: com.tencent.mm.compatible.util.b$b  reason: collision with other inner class name */
    public interface AbstractC0305b {
        void a(a aVar);

        boolean apm();

        void b(a aVar);

        boolean requestFocus();
    }

    public b(Context context) {
        AppMethodBeat.i(155865);
        this.mContext = context instanceof Activity ? MMApplicationContext.getContext() : context;
        com.tencent.mm.compatible.a.a.a(8, new a.AbstractC0298a() {
            /* class com.tencent.mm.compatible.util.b.AnonymousClass1 */

            @Override // com.tencent.mm.compatible.a.a.AbstractC0298a
            public final void run() {
                AppMethodBeat.i(155864);
                b.this.gLg = new c(b.this.mContext);
                AppMethodBeat.o(155864);
            }
        });
        AppMethodBeat.o(155865);
    }

    public final boolean requestFocus() {
        boolean requestFocus;
        AppMethodBeat.i(155866);
        synchronized ("audio_lock") {
            try {
                if (this.gLg == null) {
                    requestFocus = false;
                } else {
                    requestFocus = this.gLg.requestFocus();
                    AppMethodBeat.o(155866);
                }
            } finally {
                AppMethodBeat.o(155866);
            }
        }
        return requestFocus;
    }

    public final boolean apm() {
        boolean apm;
        AppMethodBeat.i(155867);
        synchronized ("audio_lock") {
            try {
                if (this.gLg == null) {
                    apm = false;
                } else {
                    apm = this.gLg.apm();
                    AppMethodBeat.o(155867);
                }
            } finally {
                AppMethodBeat.o(155867);
            }
        }
        return apm;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(155868);
        if (this.gLg != null) {
            this.gLg.a(aVar);
        }
        AppMethodBeat.o(155868);
    }

    public final void b(a aVar) {
        AppMethodBeat.i(215252);
        if (this.gLg != null) {
            this.gLg.b(aVar);
        }
        AppMethodBeat.o(215252);
    }
}
