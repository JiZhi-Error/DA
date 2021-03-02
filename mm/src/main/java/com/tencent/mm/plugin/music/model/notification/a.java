package com.tencent.mm.plugin.music.model.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.s;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.plugin.music.h.b;
import com.tencent.mm.plugin.music.model.d;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tav.core.AssetExtension;
import java.util.ArrayList;
import java.util.List;

public final class a {
    MMMusicPlayerService AkZ;
    NotificationManager Ala;
    Runnable Alb = new Runnable() {
        /* class com.tencent.mm.plugin.music.model.notification.a.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(63102);
            Log.i("MicroMsg.Music.MMMusicNotification", "close");
            MMHandlerThread.removeRunnable(a.this.Alb);
            a.this.AkZ.stopForeground(true);
            a.this.UZi = null;
            AppMethodBeat.o(63102);
        }
    };
    BroadcastReceiver Alc;
    Bundle UZi = null;
    d.e UZj;
    boolean isInit = false;

    public a() {
        AppMethodBeat.i(63105);
        AppMethodBeat.o(63105);
    }

    public static void a(com.tencent.mm.plugin.music.model.e.a aVar, int i2, boolean z) {
        AppMethodBeat.i(63106);
        Log.i("MicroMsg.Music.MMMusicNotification", "sendMusicPlayerEvent action:%d", Integer.valueOf(i2));
        mx mxVar = new mx();
        mxVar.dSE.action = i2;
        mxVar.dSE.state = "";
        mxVar.dSE.dSy = aVar.euO();
        mxVar.dSE.appId = "not from app brand appid";
        mxVar.dSE.dSG = z;
        EventCenter.instance.asyncPublish(mxVar, Looper.getMainLooper());
        AppMethodBeat.o(63106);
    }

    public final void d(com.tencent.mm.plugin.music.model.e.a aVar) {
        AppMethodBeat.i(63107);
        if (!this.isInit) {
            Log.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, play err");
            AppMethodBeat.o(63107);
        } else if (this.AkZ == null) {
            Log.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
            AppMethodBeat.o(63107);
        } else {
            Log.i("MicroMsg.Music.MMMusicNotification", AssetExtension.SCENE_PLAY);
            MMHandlerThread.removeRunnable(this.Alb);
            try {
                this.AkZ.startForeground(291, a((Context) this.AkZ, aVar, true));
                AppMethodBeat.o(63107);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Music.MMMusicNotification", e2, "", new Object[0]);
                AppMethodBeat.o(63107);
            }
        }
    }

    public final void e(com.tencent.mm.plugin.music.model.e.a aVar) {
        AppMethodBeat.i(63108);
        if (!this.isInit) {
            Log.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, pause err");
            AppMethodBeat.o(63108);
        } else if (this.AkZ == null) {
            Log.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
            AppMethodBeat.o(63108);
        } else {
            Log.i("MicroMsg.Music.MMMusicNotification", "pause");
            MMHandlerThread.removeRunnable(this.Alb);
            this.Ala.notify(291, a((Context) this.AkZ, aVar, false));
            AppMethodBeat.o(63108);
        }
    }

    public final void close() {
        AppMethodBeat.i(63109);
        if (!this.isInit) {
            Log.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, close err");
            AppMethodBeat.o(63109);
        } else if (this.AkZ == null) {
            Log.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
            AppMethodBeat.o(63109);
        } else {
            Log.i("MicroMsg.Music.MMMusicNotification", "close");
            MMHandlerThread.removeRunnable(this.Alb);
            MMHandlerThread.postToMainThreadDelayed(this.Alb, 1000);
            AppMethodBeat.o(63109);
        }
    }

    /* access modifiers changed from: package-private */
    public final Notification a(Context context, com.tencent.mm.plugin.music.model.e.a aVar, boolean z) {
        AppMethodBeat.i(63110);
        Intent eut = d.euu().eut();
        this.UZi = eut.getExtras();
        if (aVar.jfx) {
            eut.setClassName(context, "com.tencent.mm.plugin.mv.ui.MusicMvMainUI");
        } else {
            eut.setClassName(context, "com.tencent.mm.plugin.music.ui.MusicMainUI");
        }
        eut.putExtra("key_scene", 5);
        PendingIntent activity = PendingIntent.getActivity(context, 0, eut, 134217728);
        s.c cd = com.tencent.mm.bq.a.cd(context, "reminder_channel_id");
        cd.Hv = activity;
        Notification build = cd.as(com.tencent.mm.bq.a.ezb()).a(b(context, aVar, z)).build();
        AppMethodBeat.o(63110);
        return build;
    }

    private RemoteViews b(Context context, com.tencent.mm.plugin.music.model.e.a aVar, boolean z) {
        AppMethodBeat.i(63111);
        String str = aVar.field_songName;
        String str2 = aVar.field_songSinger;
        if (!Util.isNullOrNil(aVar.field_songAlbum)) {
            str2 = str2 + aVar.field_songAlbum;
        }
        Bitmap f2 = f(aVar);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), (int) R.layout.bn4);
        if (f2 != null) {
            remoteViews.setImageViewBitmap(R.id.fqb, f2);
        } else {
            remoteViews.setImageViewResource(R.id.fqb, R.drawable.c5b);
        }
        if (!Util.isNullOrNil(str)) {
            remoteViews.setViewVisibility(R.id.fqh, 0);
            remoteViews.setTextViewText(R.id.fqh, str);
        } else {
            remoteViews.setViewVisibility(R.id.fqh, 8);
        }
        if (!Util.isNullOrNil(str2)) {
            remoteViews.setViewVisibility(R.id.fqd, 0);
            remoteViews.setTextViewText(R.id.fqd, str2);
        } else {
            remoteViews.setViewVisibility(R.id.fqd, 8);
        }
        boolean wc = wc(dH(this.AkZ));
        Intent intent = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
        intent.putExtra("mm_music_notification_action_key", "mm_music_notification_action_pre");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 134217728);
        remoteViews.setImageViewResource(R.id.fqg, gP(wc));
        remoteViews.setOnClickPendingIntent(R.id.fqg, broadcast);
        Intent intent2 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
        if (z) {
            intent2.putExtra("mm_music_notification_action_key", "mm_music_notification_action_pause");
        } else {
            intent2.putExtra("mm_music_notification_action_key", "mm_music_notification_action_play");
        }
        PendingIntent broadcast2 = PendingIntent.getBroadcast(context, 1, intent2, 134217728);
        remoteViews.setImageViewResource(R.id.fqf, t(z, wc));
        remoteViews.setOnClickPendingIntent(R.id.fqf, broadcast2);
        Intent intent3 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
        intent3.putExtra("mm_music_notification_action_key", "mm_music_notification_action_next");
        PendingIntent broadcast3 = PendingIntent.getBroadcast(context, 2, intent3, 134217728);
        remoteViews.setImageViewResource(R.id.fqe, gR(wc));
        remoteViews.setOnClickPendingIntent(R.id.fqe, broadcast3);
        Intent intent4 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
        intent4.putExtra("mm_music_notification_action_key", "mm_music_notification_action_close");
        PendingIntent broadcast4 = PendingIntent.getBroadcast(context, 3, intent4, 134217728);
        remoteViews.setImageViewResource(R.id.fqc, gS(wc));
        remoteViews.setOnClickPendingIntent(R.id.fqc, broadcast4);
        AppMethodBeat.o(63111);
        return remoteViews;
    }

    private Bitmap f(final com.tencent.mm.plugin.music.model.e.a aVar) {
        Bitmap bitmap = null;
        AppMethodBeat.i(63112);
        if (aVar == null) {
            Log.e("MicroMsg.Music.MMMusicNotification", "music is null, return");
            AppMethodBeat.o(63112);
            return null;
        }
        Log.i("MicroMsg.Music.MMMusicNotification", "music.field_musicType %d", Integer.valueOf(aVar.field_musicType));
        try {
            switch (aVar.field_musicType) {
                case 0:
                case 5:
                case 7:
                case 10:
                case 11:
                    bitmap = q.bcR().a(aVar.field_songAlbumLocalPath, com.tencent.mm.cb.a.getDensity(this.AkZ), true);
                    break;
                case 1:
                case 8:
                case 9:
                    cnb cnb = new cnb();
                    cnb.Id = aVar.field_songMediaId;
                    cnb.Msz = aVar.field_songAlbumUrl;
                    cnb.MsA = aVar.field_songAlbumType;
                    cnb.Url = cnb.Msz;
                    if (o.DCM != null) {
                        bitmap = o.DCM.b(cnb);
                        break;
                    }
                    break;
                case 6:
                    bitmap = q.bcR().b(aVar.field_songAlbumLocalPath, com.tencent.mm.cb.a.getDensity(this.AkZ), true);
                    break;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Music.MMMusicNotification", e2, "get bitmap", new Object[0]);
        }
        if (bitmap != null) {
            Bitmap roundedCornerBitmap = BitmapUtil.getRoundedCornerBitmap(bitmap, false, 12.0f, false);
            AppMethodBeat.o(63112);
            return roundedCornerBitmap;
        }
        Bitmap OQ = q.bcV().OQ(aVar.field_songAlbumUrl);
        if (OQ == null) {
            final String bV = b.bV(aVar.field_musicId, false);
            c.a aVar2 = new c.a();
            aVar2.fullPath = b.bV(aVar.field_musicId, false);
            aVar2.jbf = true;
            aVar2.dr(com.tencent.mm.cb.a.aG(this.AkZ, R.dimen.afb), com.tencent.mm.cb.a.aG(this.AkZ, R.dimen.afa));
            aVar2.jbd = true;
            q.bcV().a(aVar.field_songAlbumUrl, aVar2.bdv(), new com.tencent.mm.av.a.c.d() {
                /* class com.tencent.mm.plugin.music.model.notification.a.AnonymousClass4 */

                @Override // com.tencent.mm.av.a.c.d
                public final void a(boolean z, Object... objArr) {
                    AppMethodBeat.i(261721);
                    Log.i("MicroMsg.Music.MMMusicNotification", "music.field_songAlbumUrl:%s, success:%b", aVar.field_songAlbumUrl, Boolean.valueOf(z));
                    if (z) {
                        Bitmap decodeFile = BitmapUtil.decodeFile(bV, null);
                        if (decodeFile == null) {
                            Log.e("MicroMsg.Music.MMMusicNotification", "bitmap is null, return");
                            AppMethodBeat.o(261721);
                            return;
                        }
                        q.bcV().h(aVar.field_songAlbumUrl, decodeFile);
                        a.this.AkZ.refresh();
                    }
                    AppMethodBeat.o(261721);
                }
            });
        }
        Bitmap roundedCornerBitmap2 = BitmapUtil.getRoundedCornerBitmap(OQ, false, 12.0f, false);
        AppMethodBeat.o(63112);
        return roundedCornerBitmap2;
    }

    private static int t(boolean z, boolean z2) {
        return z ? z2 ? R.drawable.clt : R.drawable.clv : z2 ? R.drawable.clx : R.drawable.cly;
    }

    private static int gP(boolean z) {
        return z ? R.drawable.cm0 : R.drawable.cm2;
    }

    private static int gR(boolean z) {
        return z ? R.drawable.clp : R.drawable.clr;
    }

    private static int gS(boolean z) {
        return z ? R.drawable.clm : R.drawable.cln;
    }

    private static int dH(Context context) {
        AppMethodBeat.i(63113);
        RemoteViews remoteViews = com.tencent.mm.bq.a.cd(context, "reminder_channel_id").build().contentView;
        if (remoteViews == null) {
            AppMethodBeat.o(63113);
            return WebView.NIGHT_MODE_COLOR;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(remoteViews.getLayoutId(), (ViewGroup) null);
        TextView textView = (TextView) viewGroup.findViewById(16908310);
        if (textView != null) {
            int currentTextColor = textView.getCurrentTextColor();
            AppMethodBeat.o(63113);
            return currentTextColor;
        }
        int h2 = h(viewGroup);
        AppMethodBeat.o(63113);
        return h2;
    }

    private static int h(ViewGroup viewGroup) {
        AppMethodBeat.i(63114);
        ArrayList<TextView> arrayList = new ArrayList();
        a(viewGroup, arrayList);
        TextView textView = null;
        for (TextView textView2 : arrayList) {
            if (textView2.getTextSize() <= -1.0f) {
                textView2 = textView;
            }
            textView = textView2;
        }
        if (textView != null) {
            int currentTextColor = textView.getCurrentTextColor();
            AppMethodBeat.o(63114);
            return currentTextColor;
        }
        AppMethodBeat.o(63114);
        return WebView.NIGHT_MODE_COLOR;
    }

    private static void a(View view, List<TextView> list) {
        AppMethodBeat.i(63115);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                a(viewGroup.getChildAt(i2), list);
            }
            AppMethodBeat.o(63115);
            return;
        }
        if (view instanceof TextView) {
            list.add((TextView) view);
        }
        AppMethodBeat.o(63115);
    }

    private static boolean wc(int i2) {
        AppMethodBeat.i(63116);
        int i3 = i2 | WebView.NIGHT_MODE_COLOR;
        int red = Color.red((int) WebView.NIGHT_MODE_COLOR) - Color.red(i3);
        int green = Color.green((int) WebView.NIGHT_MODE_COLOR) - Color.green(i3);
        int blue = Color.blue((int) WebView.NIGHT_MODE_COLOR) - Color.blue(i3);
        if (Math.sqrt((double) ((blue * blue) + (red * red) + (green * green))) < 180.0d) {
            AppMethodBeat.o(63116);
            return true;
        }
        AppMethodBeat.o(63116);
        return false;
    }

    static /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(261722);
        if (aVar.UZi != null) {
            d.euu().as(aVar.UZi);
        }
        AppMethodBeat.o(261722);
    }
}
