package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.AutomaticGainControl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class i implements h.a {
    private AutomaticGainControl gDm = null;

    @TargetApi(16)
    public i(AudioRecord audioRecord) {
        AppMethodBeat.i(155611);
        boolean isAvailable = AutomaticGainControl.isAvailable();
        Log.d("MicroMsg.MMAutomaticGainControl", "available  ".concat(String.valueOf(isAvailable)));
        if (isAvailable) {
            this.gDm = AutomaticGainControl.create(audioRecord.getAudioSessionId());
        }
        AppMethodBeat.o(155611);
    }

    @Override // com.tencent.mm.compatible.b.h.a
    @TargetApi(16)
    public final boolean isAvailable() {
        AppMethodBeat.i(155612);
        boolean isAvailable = AutomaticGainControl.isAvailable();
        AppMethodBeat.o(155612);
        return isAvailable;
    }

    @Override // com.tencent.mm.compatible.b.h.a
    @TargetApi(16)
    public final boolean anE() {
        AppMethodBeat.i(155613);
        if (this.gDm != null) {
            try {
                int enabled = this.gDm.setEnabled(true);
                if (enabled == 0) {
                    AppMethodBeat.o(155613);
                    return true;
                }
                Log.d("MicroMsg.MMAutomaticGainControl", "setEnabled failed ".concat(String.valueOf(enabled)));
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MMAutomaticGainControl", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(155613);
        return false;
    }
}
