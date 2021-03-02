package android.support.v4.media.session;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.view.KeyEvent;
import java.util.List;

public class MediaButtonReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            new StringBuilder("Ignore unsupported intent: ").append(intent);
            return;
        }
        ComponentName g2 = g(context, "android.intent.action.MEDIA_BUTTON");
        if (g2 != null) {
            intent.setComponent(g2);
            if (Build.VERSION.SDK_INT >= 26) {
                context.startForegroundService(intent);
            } else {
                context.startService(intent);
            }
        } else {
            ComponentName g3 = g(context, "android.media.browse.MediaBrowserService");
            if (g3 != null) {
                BroadcastReceiver.PendingResult goAsync = goAsync();
                Context applicationContext = context.getApplicationContext();
                a aVar = new a(applicationContext, intent, goAsync);
                MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(applicationContext, g3, aVar);
                aVar.Mv = mediaBrowserCompat;
                mediaBrowserCompat.KQ.connect();
                return;
            }
            throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
        }
    }

    static class a extends MediaBrowserCompat.b {
        private final BroadcastReceiver.PendingResult Mu;
        MediaBrowserCompat Mv;
        private final Context mContext;
        private final Intent mIntent;

        a(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
            this.mContext = context;
            this.mIntent = intent;
            this.Mu = pendingResult;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public final void onConnected() {
            try {
                MediaControllerCompat mediaControllerCompat = new MediaControllerCompat(this.mContext, this.Mv.KQ.eK());
                KeyEvent keyEvent = (KeyEvent) this.mIntent.getParcelableExtra("android.intent.extra.KEY_EVENT");
                if (keyEvent == null) {
                    throw new IllegalArgumentException("KeyEvent may not be null");
                }
                mediaControllerCompat.Mw.dispatchMediaButtonEvent(keyEvent);
                finish();
            } catch (RemoteException e2) {
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public final void onConnectionSuspended() {
            finish();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public final void onConnectionFailed() {
            finish();
        }

        private void finish() {
            this.Mv.disconnect();
            this.Mu.finish();
        }
    }

    private static ComponentName g(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices.size() == 1) {
            ResolveInfo resolveInfo = queryIntentServices.get(0);
            return new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        } else if (queryIntentServices.isEmpty()) {
            return null;
        } else {
            throw new IllegalStateException("Expected 1 service that handles " + str + ", found " + queryIntentServices.size());
        }
    }
}
