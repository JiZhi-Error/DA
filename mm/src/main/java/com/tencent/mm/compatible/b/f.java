package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.AcousticEchoCanceler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class f implements h.a {
    private AcousticEchoCanceler gCS = null;

    @TargetApi(16)
    public f(AudioRecord audioRecord) {
        AppMethodBeat.i(155557);
        boolean isAvailable = AcousticEchoCanceler.isAvailable();
        Log.d("MicroMsg.MMAcousticEchoCanceler", "available  ".concat(String.valueOf(isAvailable)));
        if (isAvailable) {
            this.gCS = AcousticEchoCanceler.create(audioRecord.getAudioSessionId());
        }
        AppMethodBeat.o(155557);
    }

    @Override // com.tencent.mm.compatible.b.h.a
    @TargetApi(16)
    public final boolean isAvailable() {
        AppMethodBeat.i(155558);
        boolean isAvailable = AcousticEchoCanceler.isAvailable();
        AppMethodBeat.o(155558);
        return isAvailable;
    }

    @Override // com.tencent.mm.compatible.b.h.a
    @TargetApi(16)
    public final boolean anE() {
        AppMethodBeat.i(155559);
        if (this.gCS != null) {
            try {
                int enabled = this.gCS.setEnabled(true);
                if (enabled == 0) {
                    AppMethodBeat.o(155559);
                    return true;
                }
                Log.d("MicroMsg.MMAcousticEchoCanceler", "setEnabled failed ".concat(String.valueOf(enabled)));
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MMAcousticEchoCanceler", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(155559);
        return false;
    }
}
