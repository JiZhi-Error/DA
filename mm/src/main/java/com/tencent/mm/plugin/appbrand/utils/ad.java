package com.tencent.mm.plugin.appbrand.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.TXLiveConstants;

@TargetApi(3)
public final class ad extends OrientationEventListener {
    public int jHZ = 45;
    private a ohy = a.NONE;
    private b ohz;

    public interface b {
        void a(a aVar, a aVar2);
    }

    public enum a {
        NONE,
        PORTRAIT,
        LANDSCAPE,
        REVERSE_PORTRAIT,
        REVERSE_LANDSCAPE;

        public static a valueOf(String str) {
            AppMethodBeat.i(137917);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(137917);
            return aVar;
        }

        static {
            AppMethodBeat.i(137918);
            AppMethodBeat.o(137918);
        }
    }

    public ad(Context context, b bVar) {
        super(context);
        this.ohz = bVar;
    }

    public final void enable() {
        AppMethodBeat.i(137919);
        super.enable();
        AppMethodBeat.o(137919);
    }

    public final void disable() {
        AppMethodBeat.i(137920);
        super.disable();
        this.ohy = a.NONE;
        AppMethodBeat.o(137920);
    }

    public final void onOrientationChanged(int i2) {
        AppMethodBeat.i(137921);
        if (i2 == -1) {
            AppMethodBeat.o(137921);
            return;
        }
        a aVar = this.ohy;
        if ((i2 >= 360 - this.jHZ && i2 < 360) || (i2 >= 0 && i2 <= this.jHZ + 0)) {
            aVar = a.PORTRAIT;
        } else if (i2 >= 270 - this.jHZ && i2 <= this.jHZ + 270) {
            aVar = a.LANDSCAPE;
        } else if (i2 >= 180 - this.jHZ && i2 <= this.jHZ + TXLiveConstants.RENDER_ROTATION_180) {
            aVar = a.REVERSE_PORTRAIT;
        } else if (i2 >= 90 - this.jHZ && i2 <= this.jHZ + 90) {
            aVar = a.REVERSE_LANDSCAPE;
        }
        if (aVar != this.ohy) {
            if (!(this.ohz == null || this.ohy == a.NONE)) {
                this.ohz.a(this.ohy, aVar);
            }
            this.ohy = aVar;
        }
        Log.i("MicroMsg.OrientationListenerHelper", "OrientationListener onOrientationChanged: %d", Integer.valueOf(i2));
        AppMethodBeat.o(137921);
    }
}
