package com.tencent.mm.audio.d.a;

import android.media.AudioRecord;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    private boolean dBi;
    private AudioRecord dzu;

    public final void release() {
        AppMethodBeat.i(146313);
        if (this.dzu != null) {
            this.dzu.setRecordPositionUpdateListener(null);
            this.dzu.release();
            this.dzu = null;
        }
        AppMethodBeat.o(146313);
    }

    public final boolean ZZ() {
        boolean z;
        AppMethodBeat.i(146312);
        if (this.dzu == null) {
            Log.e("MicroMsg.RecorderPcm", "mAudioRecord is null, return");
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(146312);
            return false;
        }
        this.dBi = false;
        try {
            this.dzu.stop();
            release();
            AppMethodBeat.o(146312);
            return true;
        } catch (Exception e2) {
            Log.printInfoStack("MicroMsg.RecorderPcm", "", e2);
            AppMethodBeat.o(146312);
            return false;
        }
    }
}
