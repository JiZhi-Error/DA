package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Keep;
import android.support.v4.app.s;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.ag.a;
import com.tencent.mm.plugin.appbrand.jsapi.audio.l;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.utils.c;
import com.tencent.mm.plugin.appbrand.widget.g;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;

public final class AppBrandAudioOfVideoBackgroundPlayNotificationLogic extends CustomBackgroundRunningNotificationLogic {
    private static final int kXV = a.fromDPToPix(MMApplicationContext.getContext(), 17104901);
    private static final int kXW = a.fromDPToPix(MMApplicationContext.getContext(), 17104902);
    private final NotificationManager Iw;
    private volatile boolean gNC = false;
    private final AppBrandRuntime kEc;
    private final com.tencent.mm.plugin.appbrand.jsapi.ag.a kXX;
    private int kXY = l.CTRL_INDEX;
    private volatile String kXZ = null;
    private volatile Bitmap kYa = null;
    private BroadcastReceiver kYb = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandAudioOfVideoBackgroundPlayNotificationLogic.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(226398);
            if (intent == null || Util.isNullOrNil(intent.getAction())) {
                AppMethodBeat.o(226398);
                return;
            }
            String stringExtra = intent.getStringExtra("background_audio_notification_action_key");
            if (Util.isNullOrNil(stringExtra)) {
                Log.e("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "action is null, err, return");
                AppMethodBeat.o(226398);
                return;
            }
            Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "action:%s", stringExtra);
            if (stringExtra.equals("background_audio_notification_action_play")) {
                AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.kXX.bLT();
                AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.gNC = true;
                Log.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onReceive, notify start");
                AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.Iw.notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.getNotificationId(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.mAppContext, true));
                AppMethodBeat.o(226398);
            } else if (stringExtra.equals("background_audio_notification_action_pause")) {
                AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.kXX.bLU();
                AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.kXX.mIF.bLZ();
                AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.gNC = false;
                Log.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onReceive, notify pause");
                AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.Iw.notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.getNotificationId(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.mAppContext, false));
                AppMethodBeat.o(226398);
            } else {
                if (stringExtra.equals("background_audio_notification_action_close")) {
                    AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.kXX.bLV();
                    AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.gNC = false;
                    Log.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onReceive, cancel");
                    AppBrandAudioOfVideoBackgroundPlayNotificationLogic appBrandAudioOfVideoBackgroundPlayNotificationLogic = AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this;
                    Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "cancelNotify");
                    if (appBrandAudioOfVideoBackgroundPlayNotificationLogic.mIsCanceled) {
                        Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "cancelNotify, already cancel");
                    } else {
                        appBrandAudioOfVideoBackgroundPlayNotificationLogic.mIsCanceled = true;
                        h.RTc.aV(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandAudioOfVideoBackgroundPlayNotificationLogic.AnonymousClass5 */

                            public final void run() {
                                AppMethodBeat.i(226403);
                                AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.gNC = false;
                                AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.Iw.cancel(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.getNotificationId());
                                try {
                                    AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.mAppContext.unregisterReceiver(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.kYb);
                                } catch (Exception e2) {
                                }
                                AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.kXZ = null;
                                AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.kYa = null;
                                AppMethodBeat.o(226403);
                            }
                        });
                    }
                    AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.kXX.bLX();
                }
                AppMethodBeat.o(226398);
            }
        }
    };
    private final Context mAppContext;
    volatile boolean mIsCanceled = true;

    static /* synthetic */ Bitmap P(Bitmap bitmap) {
        AppMethodBeat.i(226423);
        Bitmap O = O(bitmap);
        AppMethodBeat.o(226423);
        return O;
    }

    static /* synthetic */ Notification a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic appBrandAudioOfVideoBackgroundPlayNotificationLogic, Context context, boolean z, Bitmap bitmap) {
        AppMethodBeat.i(226422);
        Notification a2 = appBrandAudioOfVideoBackgroundPlayNotificationLogic.a(context, z, bitmap);
        AppMethodBeat.o(226422);
        return a2;
    }

    static {
        AppMethodBeat.i(226425);
        AppMethodBeat.o(226425);
    }

    @Keep
    public AppBrandAudioOfVideoBackgroundPlayNotificationLogic(String str) {
        super(str);
        AppMethodBeat.i(226406);
        q TQ = com.tencent.mm.plugin.appbrand.a.TQ(str);
        if (TQ == null) {
            IllegalStateException illegalStateException = new IllegalStateException("find AppBrandRuntime fail");
            AppMethodBeat.o(226406);
            throw illegalStateException;
        }
        this.kEc = TQ;
        com.tencent.mm.plugin.appbrand.jsapi.ag.a aVar = (com.tencent.mm.plugin.appbrand.jsapi.ag.a) this.kEc.aw(com.tencent.mm.plugin.appbrand.jsapi.ag.a.class);
        if (aVar == null) {
            IllegalStateException illegalStateException2 = new IllegalStateException("find AppBrandRuntimeAudioOfVideoBackgroundPlayManager fail");
            AppMethodBeat.o(226406);
            throw illegalStateException2;
        }
        this.kXX = aVar;
        this.kXX.mIH = new a.AbstractC0602a() {
            /* class com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandAudioOfVideoBackgroundPlayNotificationLogic.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.a.AbstractC0602a
            public final void byV() {
                AppMethodBeat.i(226399);
                if (AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.mIsCanceled) {
                    Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioStart, isCanceled");
                    AppMethodBeat.o(226399);
                    return;
                }
                AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.gNC = true;
                Log.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioStart, notify start");
                AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.Iw.notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.getNotificationId(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.mAppContext, true));
                AppMethodBeat.o(226399);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.a.AbstractC0602a
            public final void byW() {
                AppMethodBeat.i(226400);
                if (AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.mIsCanceled) {
                    Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioPause, isCanceled");
                    AppMethodBeat.o(226400);
                    return;
                }
                AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.gNC = false;
                Log.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioPause, notify pause");
                AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.Iw.notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.getNotificationId(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.mAppContext, false));
                AppMethodBeat.o(226400);
            }
        };
        this.mAppContext = this.kEc.mContext;
        this.Iw = (NotificationManager) this.mAppContext.getSystemService("notification");
        AppMethodBeat.o(226406);
    }

    @Override // com.tencent.mm.plugin.appbrand.backgroundrunning.CustomBackgroundRunningNotificationLogic
    public final Notification byP() {
        AppMethodBeat.i(226407);
        Notification a2 = a(this.mAppContext, this.gNC, (Bitmap) null);
        AppMethodBeat.o(226407);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.backgroundrunning.CustomBackgroundRunningNotificationLogic
    public final int getNotificationId() {
        AppMethodBeat.i(226408);
        if (292 == this.kXY) {
            this.kXY = MMApplicationContext.getProcessName().hashCode() + l.CTRL_INDEX;
        }
        int i2 = this.kXY;
        AppMethodBeat.o(226408);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.backgroundrunning.CustomBackgroundRunningNotificationLogic
    public final void byQ() {
        AppMethodBeat.i(226409);
        Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "startNotify");
        if (!this.mIsCanceled) {
            Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "startNotify, already start");
            h.RTc.aV(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandAudioOfVideoBackgroundPlayNotificationLogic.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(226401);
                    AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.Iw.notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.getNotificationId(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.mAppContext, true));
                    AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.gNC = true;
                    AppMethodBeat.o(226401);
                }
            });
            AppMethodBeat.o(226409);
            return;
        }
        this.mIsCanceled = false;
        h.RTc.aV(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandAudioOfVideoBackgroundPlayNotificationLogic.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(226402);
                AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.mAppContext.registerReceiver(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.kYb, new IntentFilter("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK"));
                AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.Iw.notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.getNotificationId(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.mAppContext, true));
                AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.gNC = true;
                AppMethodBeat.o(226402);
            }
        });
        AppMethodBeat.o(226409);
    }

    private Notification a(Context context, boolean z, Bitmap bitmap) {
        AppMethodBeat.i(226410);
        s.c E = com.tencent.mm.bq.a.cd(context, "reminder_channel_id").as(com.tencent.mm.bq.a.ezb()).a(b(context, z, bitmap)).E(false);
        E.g(2, true);
        Notification build = E.build();
        AppMethodBeat.o(226410);
        return build;
    }

    private RemoteViews b(Context context, boolean z, Bitmap bitmap) {
        AppMethodBeat.i(226411);
        String bLQ = this.kXX.bLQ();
        if (Util.isNullOrNil(bLQ)) {
            bLQ = this.kEc.OU().brandName;
        }
        if (bitmap == null) {
            bitmap = byR();
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), (int) R.layout.bn4);
        if (bitmap != null) {
            remoteViews.setImageViewBitmap(R.id.fqb, bitmap);
        }
        if (!Util.isNullOrNil(bLQ)) {
            remoteViews.setViewVisibility(R.id.fqh, 0);
            remoteViews.setTextViewText(R.id.fqh, bLQ);
        } else {
            remoteViews.setViewVisibility(R.id.fqh, 8);
        }
        remoteViews.setViewVisibility(R.id.fqd, 8);
        boolean wc = wc(dH(context));
        Intent intent = new Intent("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
        intent.putExtra("background_audio_notification_action_key", "background_audio_notification_action_pre");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 134217728);
        Bitmap gO = gO(wc);
        if (gO == null) {
            Log.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getRemoteViews, preIconBitmap is null");
        } else {
            remoteViews.setImageViewBitmap(R.id.fqg, gO);
            remoteViews.setOnClickPendingIntent(R.id.fqg, broadcast);
        }
        Intent intent2 = new Intent("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
        if (z) {
            intent2.putExtra("background_audio_notification_action_key", "background_audio_notification_action_pause");
        } else {
            intent2.putExtra("background_audio_notification_action_key", "background_audio_notification_action_play");
        }
        PendingIntent broadcast2 = PendingIntent.getBroadcast(context, 1, intent2, 134217728);
        remoteViews.setImageViewResource(R.id.fqf, t(z, wc));
        remoteViews.setOnClickPendingIntent(R.id.fqf, broadcast2);
        Intent intent3 = new Intent("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
        intent3.putExtra("background_audio_notification_action_key", "background_audio_notification_action_next");
        PendingIntent broadcast3 = PendingIntent.getBroadcast(context, 2, intent3, 134217728);
        Bitmap gQ = gQ(wc);
        if (gQ == null) {
            Log.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getRemoteViews, nextIconBitmap is null");
        } else {
            remoteViews.setImageViewBitmap(R.id.fqe, gQ);
            remoteViews.setOnClickPendingIntent(R.id.fqe, broadcast3);
        }
        Intent intent4 = new Intent("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
        intent4.putExtra("background_audio_notification_action_key", "background_audio_notification_action_close");
        PendingIntent broadcast4 = PendingIntent.getBroadcast(context, 3, intent4, 134217728);
        remoteViews.setImageViewResource(R.id.fqc, gS(wc));
        remoteViews.setOnClickPendingIntent(R.id.fqc, broadcast4);
        AppMethodBeat.o(226411);
        return remoteViews;
    }

    private Bitmap byR() {
        AppMethodBeat.i(226412);
        String bLR = this.kXX.bLR();
        if (Util.isNullOrNil(bLR)) {
            bLR = this.kEc.OU().iconUrl;
        }
        if (Util.isNullOrNil(bLR)) {
            Bitmap O = O(byS());
            AppMethodBeat.o(226412);
            return O;
        } else if (!bLR.equals(this.kXZ) || this.kYa == null) {
            Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, albumUrl: ".concat(String.valueOf(bLR)));
            this.kXZ = bLR;
            c.a(this.kEc.NY(), bLR, null, new c.a() {
                /* class com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandAudioOfVideoBackgroundPlayNotificationLogic.AnonymousClass7 */

                @Override // com.tencent.mm.plugin.appbrand.utils.c.a
                public final void Wz(String str) {
                    AppMethodBeat.i(226405);
                    Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, localPath: ".concat(String.valueOf(str)));
                    Bitmap P = AppBrandAudioOfVideoBackgroundPlayNotificationLogic.P(BitmapUtil.getBitmapNative(str, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.kXV, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.kXW));
                    if (P == null) {
                        Log.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, albumBitmap is null");
                        AppMethodBeat.o(226405);
                        return;
                    }
                    AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.kYa = P;
                    AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, P);
                    AppMethodBeat.o(226405);
                }
            });
            Bitmap O2 = O(byS());
            AppMethodBeat.o(226412);
            return O2;
        } else {
            Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, use mAlbumBitmap");
            Bitmap bitmap = this.kYa;
            AppMethodBeat.o(226412);
            return bitmap;
        }
    }

    private Bitmap byS() {
        AppMethodBeat.i(226413);
        g gVar = (g) this.kEc.af(g.class);
        if (gVar == null) {
            Log.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadDefaultAlbum, iconProvider is null");
            AppMethodBeat.o(226413);
            return null;
        }
        Drawable cab = gVar.cab();
        if (cab == null) {
            Log.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadDefaultAlbum, albumDrawable is null");
            AppMethodBeat.o(226413);
            return null;
        }
        Bitmap transformDrawableToBitmap = BitmapUtil.transformDrawableToBitmap(cab);
        AppMethodBeat.o(226413);
        return transformDrawableToBitmap;
    }

    private static Bitmap O(Bitmap bitmap) {
        AppMethodBeat.i(226414);
        if (bitmap == null) {
            Log.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getRoundedCornerBitmap, bitmap is null");
            AppMethodBeat.o(226414);
            return null;
        }
        Bitmap roundedCornerBitmap = BitmapUtil.getRoundedCornerBitmap(bitmap, false, 12.0f, false);
        AppMethodBeat.o(226414);
        return roundedCornerBitmap;
    }

    private static int t(boolean z, boolean z2) {
        return z ? z2 ? R.drawable.clt : R.drawable.clv : z2 ? R.drawable.clx : R.drawable.cly;
    }

    private static Bitmap gO(boolean z) {
        AppMethodBeat.i(226415);
        Bitmap bitmapNative = BitmapUtil.getBitmapNative(gP(z));
        if (bitmapNative == null) {
            Log.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getPreIconBitmap, bitmap is null");
            AppMethodBeat.o(226415);
            return null;
        }
        Bitmap alpha = BitmapUtil.setAlpha(bitmapNative, 0.3f);
        AppMethodBeat.o(226415);
        return alpha;
    }

    private static int gP(boolean z) {
        return z ? R.drawable.cm0 : R.drawable.cm2;
    }

    private static Bitmap gQ(boolean z) {
        AppMethodBeat.i(226416);
        Bitmap bitmapNative = BitmapUtil.getBitmapNative(gR(z));
        if (bitmapNative == null) {
            Log.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getNextIconBitmap, bitmap is null");
            AppMethodBeat.o(226416);
            return null;
        }
        Bitmap alpha = BitmapUtil.setAlpha(bitmapNative, 0.3f);
        AppMethodBeat.o(226416);
        return alpha;
    }

    private static int gR(boolean z) {
        return z ? R.drawable.clp : R.drawable.clr;
    }

    private static int gS(boolean z) {
        return z ? R.drawable.clm : R.drawable.cln;
    }

    private static int dH(Context context) {
        AppMethodBeat.i(226417);
        RemoteViews remoteViews = com.tencent.mm.bq.a.cd(context, "reminder_channel_id").build().contentView;
        if (remoteViews == null) {
            AppMethodBeat.o(226417);
            return WebView.NIGHT_MODE_COLOR;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(remoteViews.getLayoutId(), (ViewGroup) null);
        TextView textView = (TextView) viewGroup.findViewById(16908310);
        if (textView != null) {
            int currentTextColor = textView.getCurrentTextColor();
            AppMethodBeat.o(226417);
            return currentTextColor;
        }
        int h2 = h(viewGroup);
        AppMethodBeat.o(226417);
        return h2;
    }

    private static int h(ViewGroup viewGroup) {
        AppMethodBeat.i(226418);
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
            AppMethodBeat.o(226418);
            return currentTextColor;
        }
        AppMethodBeat.o(226418);
        return WebView.NIGHT_MODE_COLOR;
    }

    private static void a(View view, List<TextView> list) {
        AppMethodBeat.i(226419);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                a(viewGroup.getChildAt(i2), list);
            }
            AppMethodBeat.o(226419);
            return;
        }
        if (view instanceof TextView) {
            list.add((TextView) view);
        }
        AppMethodBeat.o(226419);
    }

    private static boolean wc(int i2) {
        AppMethodBeat.i(226420);
        int i3 = i2 | WebView.NIGHT_MODE_COLOR;
        int red = Color.red((int) WebView.NIGHT_MODE_COLOR) - Color.red(i3);
        int green = Color.green((int) WebView.NIGHT_MODE_COLOR) - Color.green(i3);
        int blue = Color.blue((int) WebView.NIGHT_MODE_COLOR) - Color.blue(i3);
        if (Math.sqrt((double) ((blue * blue) + (red * red) + (green * green))) < 180.0d) {
            AppMethodBeat.o(226420);
            return true;
        }
        AppMethodBeat.o(226420);
        return false;
    }

    static /* synthetic */ Notification a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic appBrandAudioOfVideoBackgroundPlayNotificationLogic, Context context, boolean z) {
        AppMethodBeat.i(226421);
        Notification a2 = appBrandAudioOfVideoBackgroundPlayNotificationLogic.a(context, z, (Bitmap) null);
        AppMethodBeat.o(226421);
        return a2;
    }

    static /* synthetic */ void b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic appBrandAudioOfVideoBackgroundPlayNotificationLogic, final Bitmap bitmap) {
        AppMethodBeat.i(226424);
        if (appBrandAudioOfVideoBackgroundPlayNotificationLogic.mIsCanceled) {
            Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "refreshNotification, isCanceled");
            AppMethodBeat.o(226424);
            return;
        }
        h.RTc.aV(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandAudioOfVideoBackgroundPlayNotificationLogic.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(226404);
                AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.Iw.notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.getNotificationId(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.mAppContext, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.gNC, bitmap));
                AppMethodBeat.o(226404);
            }
        });
        AppMethodBeat.o(226424);
    }
}
