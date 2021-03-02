package com.tencent.mm.plugin.appbrand.backgroundrunning.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.s;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningApp;
import com.tencent.mm.plugin.appbrand.backgroundrunning.c;
import com.tencent.mm.plugin.appbrand.backgroundrunning.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

public class AppBrandForegroundNotificationService extends Service {
    public static int kYM = TXLiteAVCode.EVT_CAMERA_CLOSE;
    private NotificationManager Iw;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        AppMethodBeat.i(44807);
        super.onCreate();
        Log.i("MicroMsg.AppBrandForegroundNotificationService", "onCreate");
        AppMethodBeat.o(44807);
    }

    public void onDestroy() {
        AppMethodBeat.i(44808);
        Log.i("MicroMsg.AppBrandForegroundNotificationService", "onDestroy");
        stopForeground(false);
        super.onDestroy();
        AppMethodBeat.o(44808);
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        ArrayList arrayList;
        d.a aVar;
        d.b bVar;
        AppMethodBeat.i(44809);
        Log.i("MicroMsg.AppBrandForegroundNotificationService", "onStartCommand");
        if (intent == null || intent.getExtras() == null) {
            Log.i("MicroMsg.AppBrandForegroundNotificationService", "onStartCommand, intent is null");
            AppMethodBeat.o(44809);
        } else {
            ArrayList<AppBrandBackgroundRunningApp> parcelableArrayListExtra = intent.getParcelableArrayListExtra("key_apps");
            if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
                Log.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildForegroundNotifications, apps is null");
                arrayList = null;
            } else {
                Log.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "preProcessApps");
                if (parcelableArrayListExtra.isEmpty()) {
                    aVar = null;
                } else {
                    aVar = new d.a((byte) 0);
                    for (AppBrandBackgroundRunningApp appBrandBackgroundRunningApp : parcelableArrayListExtra) {
                        if (!Util.isNullOrNil(appBrandBackgroundRunningApp.kYf)) {
                            if (aVar.kYw == null) {
                                aVar.kYw = new ArrayList(parcelableArrayListExtra.size());
                            }
                            aVar.kYw.add(appBrandBackgroundRunningApp);
                        } else {
                            if (aVar.kYx == null) {
                                aVar.kYx = new ArrayList(parcelableArrayListExtra.size());
                            }
                            aVar.kYx.add(appBrandBackgroundRunningApp);
                        }
                    }
                }
                if (aVar == null) {
                    Log.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildForegroundNotifications, backgroundRunningApps is null");
                    arrayList = null;
                } else {
                    List<AppBrandBackgroundRunningApp> list = aVar.kYx;
                    if (list == null || list.isEmpty()) {
                        Log.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildNormalForegroundNotification, apps is null");
                        bVar = null;
                    } else {
                        Log.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildNormalForegroundNotification, apps:%s", list);
                        String bm = c.bm(list);
                        String bo = c.bo(list);
                        s.c cVar = new s.c(MMApplicationContext.getContext(), "reminder_channel_id");
                        cVar.g(2, true);
                        cVar.f(bm).g(bo).as(a.ezb()).i(System.currentTimeMillis());
                        Notification build = cVar.build();
                        build.flags = 8;
                        build.defaults = -1;
                        bVar = new d.b(build, kYM);
                    }
                    List<d.b> bp = d.bp(aVar.kYw);
                    if (bVar != null || (bp != null && !bp.isEmpty())) {
                        ArrayList arrayList2 = new ArrayList();
                        if (bVar != null) {
                            arrayList2.add(bVar);
                        }
                        if (bp != null && !bp.isEmpty()) {
                            arrayList2.addAll(bp);
                        }
                        arrayList = arrayList2;
                    } else {
                        arrayList = null;
                    }
                }
            }
            if (arrayList == null || arrayList.isEmpty()) {
                Log.i("MicroMsg.AppBrandForegroundNotificationService", "onStartCommand, notificationWrappers is empty");
                AppMethodBeat.o(44809);
            } else {
                d.b bVar2 = (d.b) arrayList.get(0);
                startForeground(bVar2.notificationId, bVar2.kYy);
                int size = arrayList.size();
                if (1 < size) {
                    for (int i4 = 1; i4 < size; i4++) {
                        d.b bVar3 = (d.b) arrayList.get(i4);
                        if (this.Iw == null) {
                            this.Iw = (NotificationManager) getSystemService("notification");
                        }
                        this.Iw.notify(bVar3.notificationId, bVar3.kYy);
                    }
                }
                AppMethodBeat.o(44809);
            }
        }
        return 2;
    }

    public void onTaskRemoved(Intent intent) {
        AppMethodBeat.i(44810);
        super.onTaskRemoved(intent);
        Log.i("MicroMsg.AppBrandForegroundNotificationService", "onTaskRemoved");
        ((NotificationManager) MMApplicationContext.getContext().getSystemService("notification")).cancel(kYM);
        stopSelf();
        AppMethodBeat.o(44810);
    }
}
