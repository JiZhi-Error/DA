package com.tencent.mm.au;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class a implements bd {
    private static MMHandler iWG = null;

    public static boolean f(Runnable runnable, long j2) {
        AppMethodBeat.i(104523);
        if (runnable == null) {
            AppMethodBeat.o(104523);
            return false;
        }
        if (iWG == null) {
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(iWG != null);
            objArr[1] = Util.getStack();
            Log.w("MicroMsg.GIF.SubCoreGIF", "check decoder thread available fail, handler[%B] stack[%s]", objArr);
            if (iWG != null) {
                iWG.removeCallbacksAndMessages(null);
            }
            MMHandler mMHandler = new MMHandler("GIF-Decoder");
            iWG = mMHandler;
            mMHandler.setLogging(false);
        }
        if (j2 > 0) {
            iWG.postDelayed(runnable, j2);
        } else {
            iWG.post(runnable);
        }
        AppMethodBeat.o(104523);
        return true;
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(104524);
        if (iWG != null) {
            iWG.removeCallbacksAndMessages(null);
        }
        AppMethodBeat.o(104524);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(104525);
        if (iWG != null) {
            iWG.removeCallbacksAndMessages(null);
        }
        AppMethodBeat.o(104525);
    }
}
