package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.NoiseSuppressor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class j implements h.a {
    private NoiseSuppressor gDn = null;

    @TargetApi(16)
    public j(AudioRecord audioRecord) {
        AppMethodBeat.i(155614);
        boolean isAvailable = NoiseSuppressor.isAvailable();
        Log.d("MicroMsg.MMNoiseSuppressor", "available  ".concat(String.valueOf(isAvailable)));
        if (isAvailable) {
            this.gDn = NoiseSuppressor.create(audioRecord.getAudioSessionId());
        }
        AppMethodBeat.o(155614);
    }

    @Override // com.tencent.mm.compatible.b.h.a
    @TargetApi(16)
    public final boolean isAvailable() {
        AppMethodBeat.i(155615);
        boolean isAvailable = NoiseSuppressor.isAvailable();
        AppMethodBeat.o(155615);
        return isAvailable;
    }

    @Override // com.tencent.mm.compatible.b.h.a
    @TargetApi(16)
    public final boolean anE() {
        AppMethodBeat.i(155616);
        if (this.gDn != null) {
            try {
                int enabled = this.gDn.setEnabled(true);
                if (enabled == 0) {
                    AppMethodBeat.o(155616);
                    return true;
                }
                Log.d("MicroMsg.MMNoiseSuppressor", "setEnabled failed ".concat(String.valueOf(enabled)));
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MMNoiseSuppressor", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(155616);
        return false;
    }
}
