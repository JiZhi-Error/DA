package com.tencent.mm.plugin.music.h;

import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a {
    AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        /* class com.tencent.mm.plugin.music.h.a.AnonymousClass1 */

        public final void onAudioFocusChange(int i2) {
            AppMethodBeat.i(137438);
            Log.i("MicroMsg.Music.MusicAudioFocusHelper", "focus change %d", Integer.valueOf(i2));
            if (i2 == -2 || i2 == -3) {
                Log.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus lossTransient");
                if (k.euj().etW().bee()) {
                    k.euj().etW().esU();
                    AppMethodBeat.o(137438);
                    return;
                }
            } else if (i2 == 1 || i2 == 2 || i2 == 3) {
                Log.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus gain");
                if (k.euj().etW().bee()) {
                    k.euj().etW().resume();
                    AppMethodBeat.o(137438);
                    return;
                }
            } else if (i2 == -1) {
                Log.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus loss, passive pause");
                if (k.euj().etW().bee()) {
                    k.euj().etW().esU();
                    k.euj();
                    k.eui();
                    k.euj().SP(600000);
                }
                if (a.this.audioManager != null) {
                    a.this.audioManager.abandonAudioFocus(a.this.audioFocusChangeListener);
                }
            }
            AppMethodBeat.o(137438);
        }
    };
    AudioManager audioManager = ((AudioManager) MMApplicationContext.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE));

    public a() {
        AppMethodBeat.i(137439);
        AppMethodBeat.o(137439);
    }

    public final boolean requestFocus() {
        boolean z;
        AppMethodBeat.i(137440);
        if (this.audioManager == null) {
            AppMethodBeat.o(137440);
            return false;
        }
        int requestAudioFocus = this.audioManager.requestAudioFocus(this.audioFocusChangeListener, 3, 2);
        Object[] objArr = new Object[1];
        if (requestAudioFocus == 1) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.i("MicroMsg.Music.MusicAudioFocusHelper", "request audio focus %b", objArr);
        if (requestAudioFocus == 1) {
            AppMethodBeat.o(137440);
            return true;
        }
        AppMethodBeat.o(137440);
        return false;
    }

    public final void bLZ() {
        AppMethodBeat.i(137441);
        Log.i("MicroMsg.Music.MusicAudioFocusHelper", "abandonFocus");
        if (this.audioManager == null) {
            AppMethodBeat.o(137441);
            return;
        }
        this.audioManager.abandonAudioFocus(this.audioFocusChangeListener);
        AppMethodBeat.o(137441);
    }
}
