package com.tencent.mm.plugin.hp.tinker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import com.facebook.login.widget.ToolTipPopup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;

public final class a {
    Handler handler = new Handler(Looper.getMainLooper());

    /* renamed from: com.tencent.mm.plugin.hp.tinker.a$a  reason: collision with other inner class name */
    public interface AbstractC1437a {
        void dZg();
    }

    public a(Context context, final AbstractC1437a aVar) {
        AppMethodBeat.i(117454);
        Boolean dc = dc(context);
        ShareTinkerLog.v("Tinker.ScreenOffRetryPatch", "try post ScreenOffRetryPatch delay time: %d, screen: %b", Long.valueOf((long) ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME), dc);
        IntentFilter intentFilter = new IntentFilter();
        final AnonymousClass1 r2 = new Runnable() {
            /* class com.tencent.mm.plugin.hp.tinker.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(117452);
                if (aVar != null) {
                    ShareTinkerLog.v("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch runnable try to start", new Object[0]);
                    aVar.dZg();
                }
                AppMethodBeat.o(117452);
            }
        };
        if (dc == null || dc.booleanValue()) {
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
        } else {
            ShareTinkerLog.v("Tinker.ScreenOffRetryPatch", "screen is just off now, we can send message directly", new Object[0]);
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            this.handler.postDelayed(r2, ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
        }
        context.registerReceiver(new BroadcastReceiver() {
            /* class com.tencent.mm.plugin.hp.tinker.a.AnonymousClass2 */
            final /* synthetic */ long ynh = ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME;

            public final void onReceive(Context context, Intent intent) {
                AppMethodBeat.i(117453);
                if ("android.intent.action.SCREEN_OFF".equals(intent == null ? "" : intent.getAction())) {
                    ShareTinkerLog.v("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch screen off now, send message now", new Object[0]);
                    a.this.handler.postDelayed(r2, this.ynh);
                    AppMethodBeat.o(117453);
                    return;
                }
                ShareTinkerLog.v("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch screen on, remove pending runnable and receive", new Object[0]);
                a.this.handler.removeCallbacks(r2);
                context.unregisterReceiver(this);
                AppMethodBeat.o(117453);
            }
        }, intentFilter);
        AppMethodBeat.o(117454);
    }

    private static Boolean dc(Context context) {
        AppMethodBeat.i(117455);
        try {
            Boolean bool = (Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) context.getSystemService("power"), new Object[0]);
            AppMethodBeat.o(117455);
            return bool;
        } catch (Exception e2) {
            AppMethodBeat.o(117455);
            return null;
        }
    }
}
