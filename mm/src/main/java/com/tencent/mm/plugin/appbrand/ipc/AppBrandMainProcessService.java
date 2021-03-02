package com.tencent.mm.plugin.appbrand.ipc;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AppBrandMainProcessService extends Service {
    private static d lvI;
    private static ServiceConnection lvJ;
    private static final LinkedList<Parcel> lvK = new LinkedList<>();
    private static final Map<String, WeakReference<MainProcessTask>> lvL = new ConcurrentHashMap();
    private static final Handler lvM = new Handler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.AnonymousClass3 */

        public final void handleMessage(Message message) {
            AppMethodBeat.i(140596);
            MainProcessTask b2 = AppBrandMainProcessService.b(message.getData(), false);
            if (b2 == null) {
                AppMethodBeat.o(140596);
                return;
            }
            MainProcessTask YV = AppBrandMainProcessService.YV(b2.jEY);
            if (YV == null) {
                Log.e("MicroMsg.AppBrandMainProcessService", "receive client msg, get null task by id %s", b2.jEY);
                AppMethodBeat.o(140596);
                return;
            }
            AppBrandMainProcessService.b(b2, YV);
            YV.bjk();
            AppMethodBeat.o(140596);
        }
    };
    private static Messenger lvN = new Messenger(lvM);
    private static final Set<Runnable> lvO = new HashSet();
    private static final Set<a> lvP = Collections.newSetFromMap(new ConcurrentHashMap());
    private static final ConcurrentHashMap<String, b> lvQ = new ConcurrentHashMap<>();
    private final HashMap<String, IBinder.DeathRecipient> lvF = new HashMap<>();
    private final Messenger lvG = new Messenger(this.mHandler);
    private final d.a lvH = new d.a() {
        /* class com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.appbrand.ipc.d
        public final void N(Bundle bundle) {
            AppMethodBeat.i(140593);
            Message obtain = Message.obtain();
            obtain.setData(bundle);
            AppBrandMainProcessService.this.lvG.send(obtain);
            AppMethodBeat.o(140593);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.d
        public final void O(Bundle bundle) {
            AppMethodBeat.i(140594);
            MainProcessTask b2 = AppBrandMainProcessService.b(bundle, false);
            if (b2 != null) {
                b2.bjj();
            }
            AppMethodBeat.o(140594);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.d
        public final void a(final IBinder iBinder, final String str) {
            AppMethodBeat.i(140595);
            AnonymousClass1 r0 = new IBinder.DeathRecipient() {
                /* class com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.AnonymousClass2.AnonymousClass1 */

                public final void binderDied() {
                    AppMethodBeat.i(140592);
                    IBinder.DeathRecipient deathRecipient = (IBinder.DeathRecipient) AppBrandMainProcessService.this.lvF.get(str);
                    if (deathRecipient == null) {
                        AppMethodBeat.o(140592);
                        return;
                    }
                    iBinder.unlinkToDeath(deathRecipient, 0);
                    AppBrandMainProcessService.this.lvF.remove(str);
                    AppBrandMainProcessService.UG(str);
                    Log.e("MicroMsg.AppBrandMainProcessService", "Client Process Died: %s", str);
                    AppMethodBeat.o(140592);
                }
            };
            try {
                iBinder.linkToDeath(r0, 0);
                AppBrandMainProcessService.this.lvF.put(str, r0);
                AppBrandMainProcessService.fV(str);
                AppMethodBeat.o(140595);
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrandMainProcessService", "registerDeathRecipient: %s", e2);
                AppMethodBeat.o(140595);
            }
        }
    };
    private final Handler mHandler = new Handler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.AnonymousClass1 */

        public final void handleMessage(Message message) {
            AppMethodBeat.i(140591);
            final MainProcessTask b2 = AppBrandMainProcessService.b(message.getData(), true);
            if (b2 != null) {
                h.RTc.b(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(221213);
                        b2.bjj();
                        AppMethodBeat.o(221213);
                    }
                }, "MicroMsg.AppBrandMainProcessService");
            }
            AppMethodBeat.o(140591);
        }
    };

    public AppBrandMainProcessService() {
        AppMethodBeat.i(140599);
        AppMethodBeat.o(140599);
    }

    static /* synthetic */ MainProcessTask YV(String str) {
        AppMethodBeat.i(140613);
        MainProcessTask YT = YT(str);
        AppMethodBeat.o(140613);
        return YT;
    }

    static /* synthetic */ void b(MainProcessTask mainProcessTask, MainProcessTask mainProcessTask2) {
        AppMethodBeat.i(140614);
        a(mainProcessTask, mainProcessTask2);
        AppMethodBeat.o(140614);
    }

    public IBinder onBind(Intent intent) {
        return this.lvH;
    }

    static {
        AppMethodBeat.i(140616);
        AppMethodBeat.o(140616);
    }

    public static void a(MainProcessTask mainProcessTask) {
        AppMethodBeat.i(140600);
        c(mainProcessTask);
        L(a(mainProcessTask, true));
        AppMethodBeat.o(140600);
    }

    public static boolean b(MainProcessTask mainProcessTask) {
        AppMethodBeat.i(140601);
        Bundle a2 = a(mainProcessTask, false);
        if (K(a2)) {
            try {
                a(b(a2, false), mainProcessTask);
                mainProcessTask.bjk();
                AppMethodBeat.o(140601);
                return true;
            } catch (NullPointerException e2) {
                AppMethodBeat.o(140601);
                return false;
            }
        } else {
            AppMethodBeat.o(140601);
            return false;
        }
    }

    private static boolean K(Bundle bundle) {
        AppMethodBeat.i(140602);
        boolean z = true;
        try {
            lvI.O(bundle);
        } catch (Exception e2) {
            z = false;
            Log.e("MicroMsg.AppBrandMainProcessService", e2.getMessage());
        }
        AppMethodBeat.o(140602);
        return z;
    }

    private static void L(Bundle bundle) {
        AppMethodBeat.i(140603);
        if (lvI == null) {
            Y(null);
            synchronized (lvK) {
                try {
                    lvK.add(M(bundle));
                } finally {
                    AppMethodBeat.o(140603);
                }
            }
            return;
        }
        try {
            lvI.N(bundle);
            AppMethodBeat.o(140603);
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrandMainProcessService", e2.getMessage());
            AppMethodBeat.o(140603);
        }
    }

    static void c(MainProcessTask mainProcessTask) {
        AppMethodBeat.i(221214);
        synchronized (lvL) {
            try {
                lvL.put(mainProcessTask.jEY, new WeakReference<>(mainProcessTask));
            } finally {
                AppMethodBeat.o(221214);
            }
        }
    }

    private static MainProcessTask YT(String str) {
        MainProcessTask mainProcessTask;
        AppMethodBeat.i(221215);
        synchronized (lvL) {
            try {
                WeakReference<MainProcessTask> weakReference = lvL.get(str);
                mainProcessTask = weakReference == null ? null : weakReference.get();
                if (mainProcessTask == null) {
                    lvL.remove(str);
                }
            } finally {
                AppMethodBeat.o(221215);
            }
        }
        return mainProcessTask;
    }

    public static void bDD() {
        AppMethodBeat.i(261725);
        Y(null);
        AppMethodBeat.o(261725);
    }

    public static void Y(Runnable runnable) {
        AppMethodBeat.i(221217);
        if (runnable == null || lvI == null) {
            if (runnable != null) {
                synchronized (lvO) {
                    try {
                        lvO.add(runnable);
                    } catch (Throwable th) {
                        AppMethodBeat.o(221217);
                        throw th;
                    }
                }
            }
            if (lvJ == null) {
                lvJ = new ServiceConnection() {
                    /* class com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.AnonymousClass4 */

                    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        HashSet<Runnable> hashSet;
                        AppMethodBeat.i(140597);
                        d unused = AppBrandMainProcessService.lvI = d.a.r(iBinder);
                        AppBrandMainProcessService.WB();
                        AppBrandMainProcessService.fV(MMApplicationContext.getPackageName());
                        try {
                            AppBrandMainProcessService.lvI.a(new Binder(), MMApplicationContext.getProcessName());
                        } catch (Exception e2) {
                            Log.e("MicroMsg.AppBrandMainProcessService", "onServiceConnected, registerDeathRecipient, %s", e2);
                        }
                        Log.i("MicroMsg.AppBrandMainProcessService", "onServiceConnected(%s)", MMApplicationContext.getProcessName());
                        synchronized (AppBrandMainProcessService.lvO) {
                            try {
                                hashSet = new HashSet(AppBrandMainProcessService.lvO);
                                AppBrandMainProcessService.lvO.clear();
                            } finally {
                                AppMethodBeat.o(140597);
                            }
                        }
                        for (Runnable runnable : hashSet) {
                            if (runnable != null) {
                                runnable.run();
                            }
                        }
                    }

                    public final void onServiceDisconnected(ComponentName componentName) {
                        AppMethodBeat.i(140598);
                        d unused = AppBrandMainProcessService.lvI = null;
                        AppBrandMainProcessService.UG(MMApplicationContext.getPackageName());
                        AppBrandMainProcessService.bDD();
                        Log.i("MicroMsg.AppBrandMainProcessService", "onServiceDisconnected(%s)", MMApplicationContext.getProcessName());
                        AppMethodBeat.o(140598);
                    }
                };
            }
            Log.i("MicroMsg.AppBrandMainProcessService", "tryBindService");
            Context context = MMApplicationContext.getContext();
            try {
                context.bindService(new Intent(context, AppBrandMainProcessService.class), lvJ, 1);
                AppMethodBeat.o(221217);
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrandMainProcessService", "bindService() Exception:%s", e2.getMessage());
                AppMethodBeat.o(221217);
            }
        } else {
            runnable.run();
            AppMethodBeat.o(221217);
        }
    }

    public static class a {
        public void Uf(String str) {
        }

        public void onDisconnected(String str) {
        }
    }

    /* access modifiers changed from: package-private */
    public static class b {
        public boolean aMp = true;
        public String processName;

        public b(String str) {
            this.processName = str;
        }
    }

    public static void a(a aVar) {
        AppMethodBeat.i(140605);
        lvP.add(aVar);
        if (lvQ.size() != 0) {
            for (Map.Entry<String, b> entry : lvQ.entrySet()) {
                if (entry.getValue().aMp) {
                    YU(entry.getKey());
                }
            }
        }
        AppMethodBeat.o(140605);
    }

    public static void b(a aVar) {
        AppMethodBeat.i(140606);
        lvP.remove(aVar);
        AppMethodBeat.o(140606);
    }

    private static void YU(String str) {
        AppMethodBeat.i(221218);
        for (a aVar : lvP) {
            aVar.Uf(str);
        }
        AppMethodBeat.o(221218);
    }

    private static void a(MainProcessTask mainProcessTask, MainProcessTask mainProcessTask2) {
        AppMethodBeat.i(140607);
        Parcel obtain = Parcel.obtain();
        mainProcessTask.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        mainProcessTask2.f(obtain);
        obtain.recycle();
        AppMethodBeat.o(140607);
    }

    private static Parcel M(Bundle bundle) {
        AppMethodBeat.i(140608);
        Parcel obtain = Parcel.obtain();
        bundle.writeToParcel(obtain, 0);
        AppMethodBeat.o(140608);
        return obtain;
    }

    public static Bundle a(MainProcessTask mainProcessTask, boolean z) {
        AppMethodBeat.i(140609);
        Bundle bundle = new Bundle(3);
        bundle.putParcelable("task_object", mainProcessTask);
        if (z) {
            bundle.putParcelable("task_client", lvN);
        }
        bundle.putString("task_id", mainProcessTask.jEY);
        AppMethodBeat.o(140609);
        return bundle;
    }

    public static MainProcessTask b(Bundle bundle, boolean z) {
        MainProcessTask mainProcessTask;
        AppMethodBeat.i(140610);
        bundle.setClassLoader(MainProcessTask.class.getClassLoader());
        try {
            mainProcessTask = (MainProcessTask) bundle.getParcelable("task_object");
        } catch (ClassCastException e2) {
            Log.e("MicroMsg.AppBrandMainProcessService", "convertBundleToTask e=%s", e2);
            mainProcessTask = null;
        }
        if (mainProcessTask == null) {
            AppMethodBeat.o(140610);
            return null;
        }
        if (z) {
            mainProcessTask.lxa = (Messenger) bundle.getParcelable("task_client");
        }
        mainProcessTask.jEY = bundle.getString("task_id");
        AppMethodBeat.o(140610);
        return mainProcessTask;
    }

    public static boolean isLive() {
        if (lvI != null) {
            return true;
        }
        return false;
    }

    static /* synthetic */ void UG(String str) {
        AppMethodBeat.i(140611);
        ((b) Objects.requireNonNull(lvQ.get(str))).aMp = false;
        for (a aVar : lvP) {
            aVar.onDisconnected(str);
        }
        AppMethodBeat.o(140611);
    }

    static /* synthetic */ void fV(String str) {
        AppMethodBeat.i(140612);
        b bVar = lvQ.get(str);
        if (bVar == null) {
            lvQ.put(str, new b(str));
        } else {
            bVar.processName = str;
            bVar.aMp = true;
        }
        YU(str);
        AppMethodBeat.o(140612);
    }

    static /* synthetic */ void WB() {
        AppMethodBeat.i(140615);
        if (lvI != null) {
            synchronized (lvK) {
                try {
                    Iterator<Parcel> it = lvK.iterator();
                    while (it.hasNext()) {
                        Parcel next = it.next();
                        Bundle bundle = new Bundle();
                        bundle.setClassLoader(MainProcessTask.class.getClassLoader());
                        next.setDataPosition(0);
                        bundle.readFromParcel(next);
                        L(bundle);
                        next.recycle();
                    }
                    lvK.clear();
                } finally {
                    AppMethodBeat.o(140615);
                }
            }
            return;
        }
        AppMethodBeat.o(140615);
    }
}
