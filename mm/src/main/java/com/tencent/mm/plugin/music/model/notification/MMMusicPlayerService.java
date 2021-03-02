package com.tencent.mm.plugin.music.model.notification;

import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.plugin.music.model.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tav.core.AssetExtension;

public class MMMusicPlayerService extends Service {
    a Alg;
    Runnable Alh = new Runnable() {
        /* class com.tencent.mm.plugin.music.model.notification.MMMusicPlayerService.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(63121);
            Log.i("MicroMsg.Music.MMMusicPlayerService", "quit");
            MMHandlerThread.removeRunnable(MMMusicPlayerService.this.Alh);
            MMMusicPlayerService.this.stopSelf();
            AppMethodBeat.o(63121);
        }
    };

    public MMMusicPlayerService() {
        AppMethodBeat.i(63122);
        AppMethodBeat.o(63122);
    }

    public void onCreate() {
        AppMethodBeat.i(63123);
        super.onCreate();
        Log.i("MicroMsg.Music.MMMusicPlayerService", "onCreate");
        Log.i("MicroMsg.Music.MMMusicPlayerService", APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
        this.Alg = new a();
        a aVar = this.Alg;
        Log.i("MicroMsg.Music.MMMusicNotification", APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
        aVar.AkZ = this;
        aVar.Ala = (NotificationManager) getSystemService("notification");
        aVar.Alc = new BroadcastReceiver() {
            /* class com.tencent.mm.plugin.music.model.notification.a.AnonymousClass2 */

            public final void onReceive(Context context, Intent intent) {
                AppMethodBeat.i(63103);
                if (intent == null || Util.isNullOrNil(intent.getAction())) {
                    AppMethodBeat.o(63103);
                    return;
                }
                String stringExtra = intent.getStringExtra("mm_music_notification_action_key");
                if (Util.isNullOrNil(stringExtra)) {
                    Log.e("MicroMsg.Music.MMMusicNotification", "action is null, err, return");
                    AppMethodBeat.o(63103);
                    return;
                }
                Log.i("MicroMsg.Music.MMMusicNotification", "action:%s", stringExtra);
                d etW = k.euj().etW();
                if (etW == null) {
                    Log.e("MicroMsg.Music.MMMusicNotification", "musicPlayer is null, return");
                    AppMethodBeat.o(63103);
                    return;
                }
                com.tencent.mm.plugin.music.model.e.a etY = ((e) b.aS(e.class)).etY();
                if (etY == null) {
                    Log.e("MicroMsg.Music.MMMusicNotification", "music is null, return");
                    AppMethodBeat.o(63103);
                } else if (stringExtra.equals("mm_music_notification_action_play")) {
                    etW.resume();
                    a.a(a.this);
                    com.tencent.mm.plugin.music.model.d.e.a(2, etY);
                    AppMethodBeat.o(63103);
                } else if (stringExtra.equals("mm_music_notification_action_pause")) {
                    etW.esU();
                    k.eul().bLZ();
                    com.tencent.mm.plugin.music.model.d.e.a(3, etY);
                    AppMethodBeat.o(63103);
                } else if (stringExtra.equals("mm_music_notification_action_pre")) {
                    if (etY.field_musicType == 11) {
                        a.a(a.this);
                        k.euj().sl(true);
                    } else if (((e) b.aS(e.class)).getMode() == 2) {
                        mx mxVar = new mx();
                        mxVar.dSE.action = 17;
                        mxVar.dSE.state = "";
                        EventCenter.instance.asyncPublish(mxVar, Looper.getMainLooper());
                        ((e) b.aS(e.class)).eud();
                    } else {
                        etW.tG(0);
                        etW.resume();
                    }
                    a.a(etY, 13, etW.esV());
                    com.tencent.mm.plugin.music.model.d.e.a(1, etY);
                    AppMethodBeat.o(63103);
                } else if (stringExtra.equals("mm_music_notification_action_next")) {
                    if (etY.field_musicType == 11) {
                        a.a(a.this);
                        k.euj().sl(true);
                    } else if (((e) b.aS(e.class)).getMode() == 2) {
                        mx mxVar2 = new mx();
                        mxVar2.dSE.action = 16;
                        mxVar2.dSE.state = "";
                        EventCenter.instance.asyncPublish(mxVar2, Looper.getMainLooper());
                        ((e) b.aS(e.class)).euc();
                    } else {
                        etW.tG(0);
                        etW.resume();
                    }
                    a.a(etY, 14, etW.esV());
                    com.tencent.mm.plugin.music.model.d.e.a(4, etY);
                    AppMethodBeat.o(63103);
                } else {
                    if (stringExtra.equals("mm_music_notification_action_close")) {
                        MMHandlerThread.postToMainThread(a.this.Alb);
                        etW.stopPlay();
                        com.tencent.mm.plugin.music.model.d.e.a(5, etY);
                    }
                    AppMethodBeat.o(63103);
                }
            }
        };
        aVar.UZj = new d.e() {
            /* class com.tencent.mm.plugin.music.model.notification.a.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.music.model.d.e
            public final void bx(Bundle bundle) {
                AppMethodBeat.i(261720);
                Log.d("MicroMsg.Music.MMMusicNotification", "alvinluo onMusicDataChanged");
                a.this.UZi = bundle;
                com.tencent.mm.plugin.music.f.a.d etW = k.euj().etW();
                if (etW == null) {
                    Log.e("MicroMsg.Music.MMMusicNotification", "musicPlayer is null, return");
                    AppMethodBeat.o(261720);
                    return;
                }
                com.tencent.mm.plugin.music.model.e.a etY = ((e) b.aS(e.class)).etY();
                if (etY == null) {
                    Log.e("MicroMsg.Music.MMMusicNotification", "music is null, return");
                    AppMethodBeat.o(261720);
                    return;
                }
                if (a.this.AkZ != null) {
                    a.this.Ala.notify(291, a.this.a(a.this.AkZ, etY, etW.bec()));
                }
                AppMethodBeat.o(261720);
            }
        };
        com.tencent.mm.plugin.music.model.d euu = com.tencent.mm.plugin.music.model.d.euu();
        d.e eVar = aVar.UZj;
        if (eVar != null) {
            euu.UZe.add(eVar);
        }
        registerReceiver(aVar.Alc, new IntentFilter("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK"));
        aVar.isInit = true;
        refresh();
        AppMethodBeat.o(63123);
    }

    /* access modifiers changed from: package-private */
    public final void refresh() {
        AppMethodBeat.i(63124);
        Log.i("MicroMsg.Music.MMMusicPlayerService", "initNotification");
        e eVar = (e) b.aS(e.class);
        if (eVar == null) {
            Log.e("MicroMsg.Music.MMMusicPlayerService", "initNotification logic music is null, return");
            AppMethodBeat.o(63124);
            return;
        }
        com.tencent.mm.plugin.music.model.e.a etY = eVar.etY();
        if (etY == null) {
            Log.e("MicroMsg.Music.MMMusicPlayerService", "initNotification music is null, return");
            AppMethodBeat.o(63124);
        } else if (!Util.isNullOrNil(etY.field_protocol)) {
            Log.e("MicroMsg.Music.MMMusicPlayerService", "exoplayer play audio, ingore");
            AppMethodBeat.o(63124);
        } else {
            com.tencent.mm.plugin.music.f.a.d etW = k.euj().etW();
            if (etW == null) {
                Log.e("MicroMsg.Music.MMMusicPlayerService", "musicPlayer is null, return");
                AppMethodBeat.o(63124);
            } else if (etW.bec()) {
                d(etY);
                AppMethodBeat.o(63124);
            } else if (etW.bed()) {
                e(etY);
                AppMethodBeat.o(63124);
            } else {
                AppMethodBeat.o(63124);
            }
        }
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        return 2;
    }

    public final void d(com.tencent.mm.plugin.music.model.e.a aVar) {
        AppMethodBeat.i(63125);
        Log.i("MicroMsg.Music.MMMusicPlayerService", AssetExtension.SCENE_PLAY);
        if (aVar == null) {
            Log.e("MicroMsg.Music.MMMusicPlayerService", "music is null, return");
            AppMethodBeat.o(63125);
            return;
        }
        MMHandlerThread.removeRunnable(this.Alh);
        this.Alg.d(aVar);
        AppMethodBeat.o(63125);
    }

    public final void e(com.tencent.mm.plugin.music.model.e.a aVar) {
        AppMethodBeat.i(63126);
        Log.i("MicroMsg.Music.MMMusicPlayerService", "pause");
        if (aVar == null) {
            Log.e("MicroMsg.Music.MMMusicPlayerService", "music is null, return");
            AppMethodBeat.o(63126);
            return;
        }
        MMHandlerThread.removeRunnable(this.Alh);
        this.Alg.e(aVar);
        AppMethodBeat.o(63126);
    }

    public final void stop() {
        AppMethodBeat.i(63127);
        Log.i("MicroMsg.Music.MMMusicPlayerService", "stop");
        this.Alg.close();
        MMHandlerThread.removeRunnable(this.Alh);
        MMHandlerThread.postToMainThreadDelayed(this.Alh, Util.MILLSECONDS_OF_MINUTE);
        AppMethodBeat.o(63127);
    }

    public void onDestroy() {
        AppMethodBeat.i(63128);
        super.onDestroy();
        Log.i("MicroMsg.Music.MMMusicPlayerService", "onDestroy");
        a aVar = this.Alg;
        Log.i("MicroMsg.Music.MMMusicNotification", "uninit");
        aVar.AkZ.unregisterReceiver(aVar.Alc);
        com.tencent.mm.plugin.music.model.d euu = com.tencent.mm.plugin.music.model.d.euu();
        d.e eVar = aVar.UZj;
        if (eVar != null) {
            euu.UZe.remove(eVar);
        }
        aVar.Alc = null;
        aVar.AkZ = null;
        aVar.Ala = null;
        aVar.isInit = false;
        AppMethodBeat.o(63128);
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(63129);
        a aVar = new a();
        AppMethodBeat.o(63129);
        return aVar;
    }

    public class a extends Binder {
        public a() {
        }
    }
}
