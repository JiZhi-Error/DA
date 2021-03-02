package com.tencent.mm.live.b.d;

import android.renderscript.RSInvalidStateException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.blur.f;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/live/model/util/RenderScriptBlurWrapper;", "", "()V", "TAG", "", "blurInstance", "Lcom/tencent/mm/ui/blur/SupportRenderScriptBlur;", "instance", "release", "", "plugin-logic_release"})
public final class c {
    private static final String TAG = TAG;
    private static f hLp;
    public static final c hLq = new c();

    static {
        AppMethodBeat.i(207868);
        AppMethodBeat.o(207868);
    }

    private c() {
    }

    public static f aHp() {
        AppMethodBeat.i(207866);
        Log.i(TAG, "instance instance:" + hLp);
        if (hLp == null) {
            hLp = new f(MMApplicationContext.getContext());
        }
        f fVar = hLp;
        if (fVar == null) {
            p.hyc();
        }
        AppMethodBeat.o(207866);
        return fVar;
    }

    public static void release() {
        AppMethodBeat.i(207867);
        Log.i(TAG, "release instance:" + hLp);
        try {
            f fVar = hLp;
            if (fVar != null) {
                fVar.destroy();
            }
            hLp = null;
            AppMethodBeat.o(207867);
        } catch (RSInvalidStateException e2) {
            Log.w(TAG, "RSInvalidStateException " + e2.getMessage());
            AppMethodBeat.o(207867);
        } catch (Exception e3) {
            Log.w(TAG, "Exception " + e3.getMessage());
            AppMethodBeat.o(207867);
        }
    }
}
