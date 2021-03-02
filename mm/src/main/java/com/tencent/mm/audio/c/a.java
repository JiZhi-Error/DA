package com.tencent.mm.audio.c;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.sdk.platformtools.Log;

public final class a {
    public static AudioTrack a(boolean z, int i2, int i3, int i4) {
        e eVar;
        int i5 = 3;
        AppMethodBeat.i(130010);
        int i6 = z ? 3 : 0;
        if (com.tencent.mm.plugin.audio.c.a.cea().cdW() || com.tencent.mm.plugin.audio.c.a.ceb()) {
            i6 = 3;
        }
        if (ae.gKu.gDA) {
            ae.gKu.dump();
            if (z && ae.gKu.gEh >= 0) {
                i6 = ae.gKu.gEh;
            } else if (!z && ae.gKu.gEi >= 0) {
                i6 = ae.gKu.gEi;
            }
        }
        int minBufferSize = AudioTrack.getMinBufferSize(i2, i3, 2);
        Log.i("AudioDeviceFactory", "speakerOn: %b, type: %d, sampleRate: %d, channelConfig: %d, PlayBufSize: %d, bufTimes: %d", Boolean.valueOf(z), Integer.valueOf(i6), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(minBufferSize), Integer.valueOf(i4));
        e eVar2 = new e(i6, i2, i3, i4 * minBufferSize);
        if (eVar2.getState() == 0) {
            eVar2.release();
            Log.i("AudioDeviceFactory", "reconstruct AudioTrack");
            if (i6 != 0) {
                i5 = 0;
            }
            eVar = new e(i5, i2, i3, i4 * minBufferSize);
        } else {
            eVar = eVar2;
        }
        Log.i("AudioDeviceFactory", "AudioTrack state: " + eVar.getState());
        AppMethodBeat.o(130010);
        return eVar;
    }
}
