package com.tencent.mm.plugin.music.b.b;

import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a {
    public boolean Aiz = false;
    AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        /* class com.tencent.mm.plugin.music.b.b.a.AnonymousClass1 */

        public final void onAudioFocusChange(int i2) {
            AppMethodBeat.i(137144);
            Log.i("MicroMsg.Music.MusicAudioFocusHelper", "focus change %d", Integer.valueOf(i2));
            if (i2 == -2 || i2 == -3) {
                Log.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus lossTransient");
                AppMethodBeat.o(137144);
            } else if (i2 == 1 || i2 == 2 || i2 == 3) {
                Log.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus gain");
                AppMethodBeat.o(137144);
            } else {
                if (i2 == -1) {
                    Log.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus loss, passive pause");
                    if (a.this.audioManager != null) {
                        a.this.audioManager.abandonAudioFocus(a.this.audioFocusChangeListener);
                    }
                    a.this.Aiz = false;
                }
                AppMethodBeat.o(137144);
            }
        }
    };
    AudioManager audioManager = ((AudioManager) MMApplicationContext.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE));

    public a() {
        AppMethodBeat.i(137145);
        AppMethodBeat.o(137145);
    }

    public final boolean requestFocus() {
        boolean z;
        AppMethodBeat.i(137146);
        if (this.audioManager == null) {
            AppMethodBeat.o(137146);
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
            this.Aiz = true;
        }
        if (requestAudioFocus == 1) {
            AppMethodBeat.o(137146);
            return true;
        }
        AppMethodBeat.o(137146);
        return false;
    }

    public final void bLZ() {
        AppMethodBeat.i(137147);
        Log.i("MicroMsg.Music.MusicAudioFocusHelper", "abandonFocus");
        if (this.audioManager == null) {
            AppMethodBeat.o(137147);
            return;
        }
        this.audioManager.abandonAudioFocus(this.audioFocusChangeListener);
        this.Aiz = false;
        AppMethodBeat.o(137147);
    }
}
