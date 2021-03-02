package com.tencent.mm.plugin.audio.broadcast.headset;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/audio/broadcast/headset/HeadsetPlugReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "isHeadsetPlugState", "", "onReceive", "", "p0", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "plugin-audio_release"})
public final class HeadsetPlugReceiver extends BroadcastReceiver {
    public static final a oHM = new a((byte) 0);
    private int oHL = -1;

    static {
        AppMethodBeat.i(223951);
        AppMethodBeat.o(223951);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/audio/broadcast/headset/HeadsetPlugReceiver$Companion;", "", "()V", "TAG", "", "plugin-audio_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onReceive(Context context, Intent intent) {
        int i2;
        boolean z = false;
        AppMethodBeat.i(223950);
        int intExtra = intent != null ? intent.getIntExtra("state", -1) : 0;
        if (intent != null) {
            i2 = intent.getIntExtra("microphone", -1);
        } else {
            i2 = 0;
        }
        Log.i("MicroMsg.HeadsetPlugReceiver", "onReceive action[ HEADSET_PLUG ] state = %s,mic = %s", Integer.valueOf(intExtra), Integer.valueOf(i2));
        if (this.oHL == -1 || this.oHL != intExtra) {
            this.oHL = intExtra;
            if (intExtra != 0) {
                z = true;
            }
            a.jo(z);
        }
        AppMethodBeat.o(223950);
    }
}
