package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONException;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$initVolumeBroadcastReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-webview_release"})
public final class WebViewVideoEventHandler$initVolumeBroadcastReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ j Jye;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    WebViewVideoEventHandler$initVolumeBroadcastReceiver$1(j jVar) {
        this.Jye = jVar;
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(210703);
        if (context == null || intent == null) {
            AppMethodBeat.o(210703);
            return;
        }
        if (p.j("android.media.VOLUME_CHANGED_ACTION", intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
            Log.d(this.Jye.TAG, "initVolumeBroadcastReceiver onReceive action");
            try {
                j.a(this.Jye, "onVolumeChange", j.g(this.Jye));
                AppMethodBeat.o(210703);
                return;
            } catch (JSONException e2) {
                Log.e(this.Jye.TAG, "onVolumeChange fail " + e2.getMessage());
            }
        }
        AppMethodBeat.o(210703);
    }
}
