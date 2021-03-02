package com.tencent.mm.pluginsdk.model;

import android.os.FileObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class v extends FileObserver {
    private String CZI;
    private a JVF;

    public interface a {
        void eCy();
    }

    public v(String str, a aVar) {
        super(str);
        AppMethodBeat.i(151647);
        Log.i("MicroMsg.ScreenshotObserver", "observer  ".concat(String.valueOf(str)));
        this.JVF = aVar;
        AppMethodBeat.o(151647);
    }

    public final void onEvent(int i2, String str) {
        AppMethodBeat.i(151648);
        if (str != null && i2 == 8 && (this.CZI == null || !str.equalsIgnoreCase(this.CZI))) {
            this.CZI = str;
            this.JVF.eCy();
            Log.i("MicroMsg.ScreenshotObserver", "Send event to listener. ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(151648);
    }

    public final void start() {
        AppMethodBeat.i(151649);
        super.startWatching();
        AppMethodBeat.o(151649);
    }

    public final void stop() {
        AppMethodBeat.i(151650);
        super.stopWatching();
        AppMethodBeat.o(151650);
    }
}
