package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

@TargetApi(8)
public final class c implements b.AbstractC0305b {
    private Context context;
    b.a gLj;
    private AudioManager.OnAudioFocusChangeListener gLk = new AudioManager.OnAudioFocusChangeListener() {
        /* class com.tencent.mm.compatible.util.c.AnonymousClass1 */

        public final void onAudioFocusChange(int i2) {
            AppMethodBeat.i(155869);
            if (c.this.gLj != null) {
                Log.d("MicroMsg.AudioFocusHelper", "jacks change: %d", Integer.valueOf(i2));
                c.this.gLj.iZ(i2);
            }
            AppMethodBeat.o(155869);
        }
    };
    private AudioManager mAudioManager;

    @Override // com.tencent.mm.compatible.util.b.AbstractC0305b
    public final void a(b.a aVar) {
        this.gLj = aVar;
    }

    @Override // com.tencent.mm.compatible.util.b.AbstractC0305b
    public final void b(b.a aVar) {
        if (this.gLj == aVar) {
            this.gLj = null;
        }
    }

    public c(Context context2) {
        AppMethodBeat.i(155870);
        this.context = context2 instanceof Activity ? MMApplicationContext.getContext() : context2;
        AppMethodBeat.o(155870);
    }

    @Override // com.tencent.mm.compatible.util.b.AbstractC0305b
    public final boolean requestFocus() {
        AppMethodBeat.i(155871);
        if (this.mAudioManager == null && this.context != null) {
            this.mAudioManager = (AudioManager) this.context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        boolean z = this.mAudioManager != null ? 1 == this.mAudioManager.requestAudioFocus(this.gLk, 3, 2) : false;
        Log.printInfoStack("MicroMsg.AudioFocusHelper", "jacks requestFocus: %B, %x", Boolean.valueOf(z), Integer.valueOf(this.gLk.hashCode()));
        AppMethodBeat.o(155871);
        return z;
    }

    @Override // com.tencent.mm.compatible.util.b.AbstractC0305b
    public final boolean apm() {
        AppMethodBeat.i(155872);
        if (this.mAudioManager == null && this.context != null) {
            this.mAudioManager = (AudioManager) this.context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        boolean z = this.mAudioManager != null ? 1 == this.mAudioManager.abandonAudioFocus(this.gLk) : false;
        Log.printInfoStack("MicroMsg.AudioFocusHelper", "jacks abandonFocus: %B, %x", Boolean.valueOf(z), Integer.valueOf(this.gLk.hashCode()));
        AppMethodBeat.o(155872);
        return z;
    }
}
