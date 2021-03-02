package com.tencent.mm.plugin.appbrand.jsapi.ag;

import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class c {
    AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.ag.c.AnonymousClass1 */

        public final void onAudioFocusChange(int i2) {
            AppMethodBeat.i(215797);
            Log.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "focus change %d", Integer.valueOf(i2));
            if (i2 == -2 || i2 == -3) {
                Log.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "audio focus lossTransient");
                c.this.mIT.bLU();
                AppMethodBeat.o(215797);
            } else if (i2 == 1 || i2 == 2 || i2 == 3) {
                Log.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "audio focus gain");
                c.this.mIT.bLT();
                AppMethodBeat.o(215797);
            } else {
                if (i2 == -1) {
                    Log.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "audio focus loss, passive pause");
                    c.this.mIT.bLV();
                    if (c.this.audioManager != null) {
                        c.this.audioManager.abandonAudioFocus(c.this.audioFocusChangeListener);
                    }
                }
                AppMethodBeat.o(215797);
            }
        }
    };
    AudioManager audioManager = ((AudioManager) MMApplicationContext.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE));
    a mIT;

    public c(a aVar) {
        AppMethodBeat.i(215798);
        this.mIT = aVar;
        AppMethodBeat.o(215798);
    }

    public final boolean requestFocus() {
        boolean z;
        AppMethodBeat.i(215799);
        if (this.audioManager == null) {
            AppMethodBeat.o(215799);
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
        Log.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "request audio focus %b", objArr);
        if (requestAudioFocus == 1) {
            AppMethodBeat.o(215799);
            return true;
        }
        AppMethodBeat.o(215799);
        return false;
    }

    public final void bLZ() {
        AppMethodBeat.i(215800);
        Log.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "abandonFocus");
        if (this.audioManager == null) {
            AppMethodBeat.o(215800);
            return;
        }
        this.audioManager.abandonAudioFocus(this.audioFocusChangeListener);
        AppMethodBeat.o(215800);
    }
}
