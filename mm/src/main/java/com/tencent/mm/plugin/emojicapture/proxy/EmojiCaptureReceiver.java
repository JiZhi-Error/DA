package com.tencent.mm.plugin.emojicapture.proxy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "TAG", "", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-emojicapture_release"})
public final class EmojiCaptureReceiver extends BroadcastReceiver {
    private final String TAG = "MicroMsg.EmojiCaptureReceiver";

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(415);
        p.h(context, "context");
        p.h(intent, "intent");
        String action = intent.getAction();
        Log.i(this.TAG, "onReceive: ".concat(String.valueOf(action)));
        if (action == null) {
            AppMethodBeat.o(415);
            return;
        }
        switch (action.hashCode()) {
            case -2121123626:
                if (action.equals("com.tencent.mm.Emoji_Capture_Res")) {
                    int intExtra = intent.getIntExtra("res_sub_type", 0);
                    Log.i(this.TAG, "onReceive: res update " + intExtra + ' ' + intent.getBooleanExtra("res_result", false));
                    AppMethodBeat.o(415);
                    return;
                }
                break;
            case 1555831307:
                if (action.equals("com.tencent.mm.Emoji_Capture_Upload")) {
                    long longExtra = intent.getLongExtra("upload_time_enter", 0);
                    boolean booleanExtra = intent.getBooleanExtra("upload_success", false);
                    String stringExtra = intent.getStringExtra("upload_md5");
                    b bVar = b.hdv;
                    b.b(longExtra, booleanExtra, stringExtra);
                    Log.i(this.TAG, "onReceive: upload " + longExtra + ", " + booleanExtra + ", " + stringExtra);
                    break;
                }
                break;
        }
        AppMethodBeat.o(415);
    }
}
