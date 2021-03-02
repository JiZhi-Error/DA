package com.tencent.mm.sdcard_migrate;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.v4.app.s;
import android.text.TextUtils;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateConfig;
import com.tencent.mm.sdcard_migrate.e;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.aa;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ExtStorageMigrateService extends Service {
    private final b NHc = new b(this, (byte) 0);
    private final a[] NHd = {null};
    private Thread NHe = null;
    private final MigrateResultCallback[] NHf = {null};
    private volatile int NHg = 0;
    private final boolean[] NHh = {false};
    private final PowerManager.WakeLock[] NHi = {null};
    private final boolean[] NHj = {false};
    private final e.a NHk = new e.a() {
        /* class com.tencent.mm.sdcard_migrate.ExtStorageMigrateService.AnonymousClass1 */

        @Override // com.tencent.mm.sdcard_migrate.e
        public final boolean gwS() {
            AppMethodBeat.i(232385);
            if (ExtStorageMigrateService.this.NHd[0] == null || !a.b(ExtStorageMigrateService.this.NHd[0])) {
                AppMethodBeat.o(232385);
                return false;
            }
            AppMethodBeat.o(232385);
            return true;
        }

        @Override // com.tencent.mm.sdcard_migrate.e
        public final void a(MigrateResultCallback migrateResultCallback) {
            AppMethodBeat.i(232386);
            synchronized (ExtStorageMigrateService.this.NHf) {
                try {
                    if (!(ExtStorageMigrateService.this.NHf[0] == null || ExtStorageMigrateService.this.NHf[0] == migrateResultCallback)) {
                        ExtStorageMigrateService.this.NHf[0].kJ(ExtStorageMigrateService.this.NHg, Binder.getCallingPid());
                    }
                    ExtStorageMigrateService.this.NHf[0] = migrateResultCallback;
                } finally {
                    AppMethodBeat.o(232386);
                }
            }
            if (gwS()) {
                synchronized (ExtStorageMigrateService.this.NHd) {
                    try {
                        migrateResultCallback.mN(ExtStorageMigrateService.this.NHd[0].NHr, ExtStorageMigrateService.this.NHd[0].NHs);
                    } finally {
                        AppMethodBeat.o(232386);
                    }
                }
                return;
            }
            AppMethodBeat.o(232386);
        }

        @Override // com.tencent.mm.sdcard_migrate.e
        public final void b(MigrateResultCallback migrateResultCallback) {
            AppMethodBeat.i(232387);
            synchronized (ExtStorageMigrateService.this.NHf) {
                try {
                    if (ExtStorageMigrateService.this.NHf[0] != null) {
                        ExtStorageMigrateService.this.NHf[0] = null;
                    }
                } finally {
                    AppMethodBeat.o(232387);
                }
            }
        }

        @Override // com.tencent.mm.sdcard_migrate.e
        public final void a(ExtStorageMigrateConfig extStorageMigrateConfig) {
            AppMethodBeat.i(232388);
            ExtStorageMigrateService.a(ExtStorageMigrateService.this, extStorageMigrateConfig);
            AppMethodBeat.o(232388);
        }

        @Override // com.tencent.mm.sdcard_migrate.e
        public final void gwW() {
            AppMethodBeat.i(232389);
            ExtStorageMigrateService.d(ExtStorageMigrateService.this);
            AppMethodBeat.o(232389);
        }
    };

    public ExtStorageMigrateService() {
        AppMethodBeat.i(169829);
        AppMethodBeat.o(169829);
    }

    static /* synthetic */ File R(File file) {
        AppMethodBeat.i(232410);
        File Q = Q(file);
        AppMethodBeat.o(232410);
        return Q;
    }

    static /* synthetic */ String access$1500(String str) {
        AppMethodBeat.i(232409);
        String Wr = Wr(str);
        AppMethodBeat.o(232409);
        return Wr;
    }

    static /* synthetic */ boolean g(ExtStorageMigrateService extStorageMigrateService) {
        AppMethodBeat.i(232412);
        boolean gwU = extStorageMigrateService.gwU();
        AppMethodBeat.o(232412);
        return gwU;
    }

    static /* synthetic */ void h(ExtStorageMigrateService extStorageMigrateService) {
        AppMethodBeat.i(232413);
        extStorageMigrateService.AD(false);
        AppMethodBeat.o(232413);
    }

    static /* synthetic */ void i(ExtStorageMigrateService extStorageMigrateService) {
        AppMethodBeat.i(232414);
        extStorageMigrateService.releaseWakeLock();
        AppMethodBeat.o(232414);
    }

    static /* synthetic */ void j(ExtStorageMigrateService extStorageMigrateService) {
        AppMethodBeat.i(232415);
        extStorageMigrateService.gwV();
        AppMethodBeat.o(232415);
    }

    public void onCreate() {
        AppMethodBeat.i(232400);
        super.onCreate();
        synchronized (this.NHd) {
            try {
                this.NHd[0] = null;
                this.NHe = null;
            } finally {
                AppMethodBeat.o(232400);
            }
        }
        synchronized (this.NHf) {
            try {
                this.NHf[0] = null;
                this.NHg = 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        AC(false);
        AppMethodBeat.o(232400);
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        AppMethodBeat.i(169832);
        ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateService", "[+] OnStartCommand called, intent: %s", intent);
        if (intent == null) {
            ExtStorageMigrateMonitor.gwK().e("MicroMsg.ExtStorageMigrateService", "[-] intent is null, skip rest logic.", new Object[0]);
            gwV();
        } else {
            String action = intent.getAction();
            if (action == null) {
                ExtStorageMigrateMonitor.gwK().e("MicroMsg.ExtStorageMigrateService", "[-] action is null, skip rest logic.", new Object[0]);
                gwV();
            } else if ("service_action_startup".equals(action)) {
                b bVar = this.NHc;
                if (ExtStorageMigrateService.this.gwT() || ExtStorageMigrateService.this.gwS()) {
                    ExtStorageMigrateMonitor.gwK().w("MicroMsg.ExtStorageMigrateService", "[!] Already on foreground or migrating logic, skip startup steps.", new Object[0]);
                } else {
                    s.c AF = bVar.AF(true);
                    s.c b2 = AF.i(System.currentTimeMillis()).g(MMApplicationContext.getResources().getString(R.string.c3t)).b(0, 0, true);
                    b2.g(2, true);
                    b2.a(bVar.gwX()).Hv = bVar.AG(false);
                    ExtStorageMigrateService extStorageMigrateService = ExtStorageMigrateService.this;
                    extStorageMigrateService.startForeground(TXLiteAVCode.EVT_HW_ENCODER_START_SUCC, AF.build());
                    extStorageMigrateService.AC(true);
                }
            } else if ("service_action_cancel_migrate".equals(action)) {
                gwV();
            } else {
                ExtStorageMigrateMonitor.gwK().e("MicroMsg.ExtStorageMigrateService", "[-] Unknown action: %s", action);
            }
        }
        AppMethodBeat.o(169832);
        return 2;
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(232401);
        IBinder asBinder = this.NHk.asBinder();
        AppMethodBeat.o(232401);
        return asBinder;
    }

    public void onDestroy() {
        AppMethodBeat.i(169833);
        ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateService", "[+] OnDestroy called.", new Object[0]);
        synchronized (this.NHd) {
            try {
                if (gwS()) {
                    a.a(this.NHd[0]);
                    try {
                        this.NHe.join();
                    } catch (InterruptedException e2) {
                    }
                } else if (gwT()) {
                    if (gwU()) {
                        AD(false);
                        this.NHc.ajG(2);
                    } else {
                        this.NHc.c(6, null);
                    }
                }
                this.NHd[0] = null;
            } catch (Throwable th) {
                AppMethodBeat.o(169833);
                throw th;
            }
        }
        if (gwT()) {
            stopForeground(true);
        }
        releaseWakeLock();
        AppMethodBeat.o(169833);
    }

    private boolean gwS() {
        boolean z = false;
        AppMethodBeat.i(232402);
        synchronized (this.NHd) {
            try {
                if (this.NHd[0] != null && a.b(this.NHd[0])) {
                    z = true;
                }
            } finally {
                AppMethodBeat.o(232402);
            }
        }
        return z;
    }

    private boolean gwT() {
        boolean z;
        synchronized (this.NHh) {
            z = this.NHh[0];
        }
        return z;
    }

    private void AC(boolean z) {
        synchronized (this.NHh) {
            this.NHh[0] = z;
        }
    }

    private boolean gwU() {
        boolean z;
        synchronized (this.NHj) {
            z = this.NHj[0];
        }
        return z;
    }

    private void AD(boolean z) {
        synchronized (this.NHj) {
            this.NHj[0] = z;
        }
    }

    private void gwV() {
        AppMethodBeat.i(232403);
        ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateService", "[+] expectedStopSelf called.", new Object[0]);
        AD(true);
        stopSelf();
        AppMethodBeat.o(232403);
    }

    /* access modifiers changed from: package-private */
    public final class b {
        private final s.c[] NHx;
        private final int[] NHy;

        private b() {
            AppMethodBeat.i(232393);
            this.NHx = new s.c[]{null};
            this.NHy = new int[]{-1};
            AppMethodBeat.o(232393);
        }

        /* synthetic */ b(ExtStorageMigrateService extStorageMigrateService, byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final s.c AF(boolean z) {
            s.c cVar;
            boolean z2;
            AppMethodBeat.i(232394);
            synchronized (this.NHx) {
                try {
                    if (this.NHx[0] == null || z) {
                        try {
                            if (Build.VERSION.SDK_INT >= 26) {
                                NotificationManager notificationManager = (NotificationManager) ExtStorageMigrateService.this.getSystemService("notification");
                                Iterator<NotificationChannel> it = notificationManager.getNotificationChannels().iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if ("reminder_channel_id".equals(it.next().getId())) {
                                            z2 = true;
                                            break;
                                        }
                                    } else {
                                        z2 = false;
                                        break;
                                    }
                                }
                                if (!z2) {
                                    NotificationChannel notificationChannel = new NotificationChannel("reminder_channel_id", ExtStorageMigrateService.this.getString(R.string.fg4), 2);
                                    notificationChannel.setDescription(ExtStorageMigrateService.this.getString(R.string.fg3));
                                    notificationManager.createNotificationChannel(notificationChannel);
                                }
                            }
                        } catch (Throwable th) {
                        }
                        cVar = new s.c(ExtStorageMigrateService.this.getApplicationContext(), "reminder_channel_id");
                        cVar.f(ExtStorageMigrateService.ajE(R.string.wx)).as(R.drawable.cj8).E(false);
                        this.NHx[0] = cVar;
                        AppMethodBeat.o(232394);
                    } else {
                        cVar = this.NHx[0];
                    }
                } finally {
                    AppMethodBeat.o(232394);
                }
            }
            return cVar;
        }

        /* access modifiers changed from: package-private */
        public final s.a gwX() {
            AppMethodBeat.i(232395);
            Intent intent = new Intent(ExtStorageMigrateService.this, ExtStorageMigrateService.class);
            intent.setAction("service_action_cancel_migrate");
            s.a.C0017a aVar = new s.a.C0017a(R.drawable.cj_, ExtStorageMigrateService.ajE(R.string.amn), PendingIntent.getService(ExtStorageMigrateService.this, 3843, intent, 268435456));
            aVar.Hj = false;
            s.a es = aVar.es();
            AppMethodBeat.o(232395);
            return es;
        }

        /* access modifiers changed from: package-private */
        public final PendingIntent AG(boolean z) {
            AppMethodBeat.i(232396);
            Intent intent = new Intent(ExtStorageMigrateService.this, ExtStorageMigrateAuxActivity.class);
            intent.setAction("auxui_action_do_migrate_routine");
            intent.putExtra("auxui_param_is_migration_end", z);
            intent.addFlags(268435456);
            PendingIntent activity = PendingIntent.getActivity(ExtStorageMigrateService.this, 3841, intent, 268435456);
            AppMethodBeat.o(232396);
            return activity;
        }

        /* access modifiers changed from: package-private */
        public final void ajF(int i2) {
            AppMethodBeat.i(232397);
            synchronized (this.NHy) {
                try {
                    if (this.NHy[0] == -1 || (i2 != this.NHy[0] && i2 % 10 == 0)) {
                        s.c g2 = AF(false).g(ExtStorageMigrateService.ajE(R.string.c3q));
                        g2.g(2, true);
                        ((NotificationManager) ExtStorageMigrateService.this.getSystemService("notification")).notify(TXLiteAVCode.EVT_HW_ENCODER_START_SUCC, g2.b(100, i2, false).build());
                    }
                    this.NHy[0] = i2;
                } finally {
                    AppMethodBeat.o(232397);
                }
            }
            synchronized (ExtStorageMigrateService.this.NHf) {
                try {
                    com.tencent.mm.sdcard_migrate.util.a.b(ExtStorageMigrateService.this.NHf[0], i2);
                } finally {
                    AppMethodBeat.o(232397);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void c(int i2, Throwable th) {
            String ajE;
            AppMethodBeat.i(232398);
            s.c i3 = AF(true).i(System.currentTimeMillis());
            if (i2 == 6) {
                ajE = ExtStorageMigrateService.ajE(R.string.c3o);
            } else {
                ajE = ExtStorageMigrateService.ajE(R.string.c3m);
            }
            s.c E = i3.g(ajE).b(0, 0, false).E(true);
            E.Hv = AG(true);
            E.g(2, false);
            ExtStorageMigrateService.a(ExtStorageMigrateService.this, E.build());
            synchronized (ExtStorageMigrateService.this.NHf) {
                try {
                    com.tencent.mm.sdcard_migrate.util.a.a(ExtStorageMigrateService.this.NHf[0], i2, th);
                } finally {
                    AppMethodBeat.o(232398);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void ajG(int i2) {
            AppMethodBeat.i(232399);
            s.c E = AF(true).i(System.currentTimeMillis()).g(ExtStorageMigrateService.ajE(R.string.c3l)).b(0, 0, false).E(true);
            E.Hv = AG(true);
            E.g(2, false);
            ExtStorageMigrateService.a(ExtStorageMigrateService.this, E.build());
            synchronized (ExtStorageMigrateService.this.NHf) {
                try {
                    com.tencent.mm.sdcard_migrate.util.a.a(ExtStorageMigrateService.this.NHf[0], i2);
                } finally {
                    AppMethodBeat.o(232399);
                }
            }
        }
    }

    private void releaseWakeLock() {
        AppMethodBeat.i(232404);
        synchronized (this.NHi) {
            try {
                if (this.NHi[0] != null && this.NHi[0].isHeld()) {
                    this.NHi[0].release();
                    this.NHi[0] = null;
                    ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateService", "[+] WakeLock released.", new Object[0]);
                }
            } finally {
                AppMethodBeat.o(232404);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {
        private final boolean NGN;
        private final boolean[] NHm = {false};
        private final CancellationSignal NHn;
        private final Set<String> NHo;
        private final Set<String> NHp;
        private final Map<String, String> NHq;
        private String NHr = null;
        private String NHs = null;
        private ByteBuffer NHt = null;
        private float mProgress = 0.0f;

        static /* synthetic */ boolean b(a aVar) {
            AppMethodBeat.i(232392);
            boolean isRunning = aVar.isRunning();
            AppMethodBeat.o(232392);
            return isRunning;
        }

        a(ExtStorageMigrateConfig extStorageMigrateConfig, CancellationSignal cancellationSignal) {
            AppMethodBeat.i(232390);
            this.NHn = cancellationSignal;
            this.NGN = extStorageMigrateConfig.NGI;
            this.NHo = new HashSet(64);
            this.NHp = new HashSet(5);
            this.NHq = new HashMap(5);
            this.NHr = ExtStorageMigrateService.access$1500(extStorageMigrateConfig.sourceDir);
            this.NHs = ExtStorageMigrateService.access$1500(extStorageMigrateConfig.NGH);
            if (extStorageMigrateConfig.NGI) {
                ExtStorageMigrateMonitor.gwK().w("MicroMsg.ExtStorageMigrateService", "[!] Force copy mode enabled, are we under test mode ??", new Object[0]);
            }
            b(extStorageMigrateConfig.sourceDir, extStorageMigrateConfig.NGJ);
            ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateService", "[+] MigrateTask, pass in config: %s", extStorageMigrateConfig);
            AppMethodBeat.o(232390);
        }

        private void b(String str, Collection<ExtStorageMigrateConfig.ExtraPathAction> collection) {
            String bhP;
            AppMethodBeat.i(232391);
            if (collection == null) {
                AppMethodBeat.o(232391);
                return;
            }
            for (ExtStorageMigrateConfig.ExtraPathAction extraPathAction : collection) {
                if (extraPathAction instanceof ExtStorageMigrateConfig.ExtraPathAction.Ignore) {
                    ExtStorageMigrateConfig.ExtraPathAction.Ignore ignore = (ExtStorageMigrateConfig.ExtraPathAction.Ignore) extraPathAction;
                    this.NHp.add(ExtStorageMigrateService.R(new File(str, ignore.NGP)).getAbsolutePath());
                    mM(str, ignore.NGP);
                } else if (extraPathAction instanceof ExtStorageMigrateConfig.ExtraPathAction.Remap) {
                    ExtStorageMigrateConfig.ExtraPathAction.Remap remap = (ExtStorageMigrateConfig.ExtraPathAction.Remap) extraPathAction;
                    Map<String, String> map = this.NHq;
                    String bhP2 = bhP(remap.NGQ);
                    if (remap.jrL.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                        bhP = remap.jrL;
                    } else {
                        bhP = bhP(remap.jrL);
                    }
                    map.put(bhP2, bhP);
                    mM(str, remap.NGQ);
                }
            }
            this.NHo.add(str);
            ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateService", "[+] MigrateTask, mSrcDirPath: %s, mDestDirPath: %s, mRemappedRelPaths: %s", this.NHr, this.NHs, this.NHq);
            AppMethodBeat.o(232391);
        }

        private void mM(String str, String str2) {
            AppMethodBeat.i(169816);
            String bhO = bhO(str);
            File file = new File(bhO, str2);
            do {
                this.NHo.add(bhO(file.getAbsolutePath()));
                file = file.getParentFile();
                if (file == null) {
                    break;
                }
            } while (!bhO.equals(file.getAbsolutePath()));
            AppMethodBeat.o(169816);
        }

        private static String bhO(String str) {
            AppMethodBeat.i(169817);
            if (str == null || str.isEmpty()) {
                AppMethodBeat.o(169817);
                return str;
            } else if (str.endsWith(FilePathGenerator.ANDROID_DIR_SEP) || str.endsWith("\\")) {
                String substring = str.substring(0, str.length() - 1);
                AppMethodBeat.o(169817);
                return substring;
            } else {
                AppMethodBeat.o(169817);
                return str;
            }
        }

        private static String bhP(String str) {
            AppMethodBeat.i(169818);
            if (str == null || str.isEmpty()) {
                AppMethodBeat.o(169818);
                return str;
            }
            String path = new File(str).getPath();
            if (path.endsWith(FilePathGenerator.ANDROID_DIR_SEP) || path.endsWith("\\")) {
                path = path.substring(0, path.length() - 1);
            }
            AppMethodBeat.o(169818);
            return path;
        }

        private void AE(boolean z) {
            synchronized (this.NHm) {
                this.NHm[0] = z;
            }
        }

        private boolean isRunning() {
            boolean z;
            synchronized (this.NHm) {
                z = this.NHm[0];
            }
            return z;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:118:0x0496, code lost:
            r15.NHl.NHc.c(6, null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:131:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00ba, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor.gwK().printErrStackTrace("MicroMsg.ExtStorageMigrateService", r0, "[-] Operation cancelled.", new java.lang.Object[0]);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00d1, code lost:
            if (com.tencent.mm.sdcard_migrate.ExtStorageMigrateService.g(r15.NHl) != false) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d3, code lost:
            com.tencent.mm.sdcard_migrate.ExtStorageMigrateService.h(r15.NHl);
            r15.NHl.NHc.ajG(3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00e2, code lost:
            AE(false);
            com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor.gwN();
            com.tencent.mm.sdcard_migrate.ExtStorageMigrateService.i(r15.NHl);
            com.tencent.mm.sdcard_migrate.ExtStorageMigrateService.j(r15.NHl);
            com.tencent.matrix.trace.core.AppMethodBeat.o(169819);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x01b5, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x01b6, code lost:
            AE(false);
            com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor.gwN();
            com.tencent.mm.sdcard_migrate.ExtStorageMigrateService.i(r15.NHl);
            com.tencent.mm.sdcard_migrate.ExtStorageMigrateService.j(r15.NHl);
            com.tencent.matrix.trace.core.AppMethodBeat.o(169819);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x01cd, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x0365, code lost:
            r1 = false;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00ba A[ExcHandler: OperationCanceledException (r0v6 'e' android.os.OperationCanceledException A[CUSTOM_DECLARE]), Splitter:B:1:0x0006] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 1187
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdcard_migrate.ExtStorageMigrateService.a.run():void");
        }

        private String S(File file) {
            String str;
            AppMethodBeat.i(169821);
            String bhP = bhP(file.getAbsolutePath().substring(this.NHr.length()));
            if (bhP.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                str = bhP.substring(1);
            } else {
                str = bhP;
            }
            ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateService", "[+] getMigratedFilePath, relSrcPath: %s", str);
            String str2 = str;
            while (true) {
                if (TextUtils.isEmpty(str2)) {
                    break;
                }
                String str3 = this.NHq.get(str2);
                ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateService", "[+] getMigratedFilePath, currRelSrcPath: %s, newRelPath: %s", str2, str3);
                if (str3 == null) {
                    int lastIndexOf = str2.lastIndexOf(47);
                    if (lastIndexOf < 0) {
                        break;
                    }
                    str2 = str2.substring(0, lastIndexOf);
                } else {
                    str = str3 + str.substring(str2.length());
                    break;
                }
            }
            if (str.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateService", "[+] getMigratedFilePath, result: %s", str);
                AppMethodBeat.o(169821);
                return str;
            }
            String str4 = this.NHs + FilePathGenerator.ANDROID_DIR_SEP + str;
            ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateService", "[+] getMigratedFilePath, result: %s", str4);
            AppMethodBeat.o(169821);
            return str4;
        }

        /* renamed from: com.tencent.mm.sdcard_migrate.ExtStorageMigrateService$a$a  reason: collision with other inner class name */
        class C2048a {
            final File NHu;
            final float NHv;

            C2048a(File file, float f2) {
                this.NHu = file;
                this.NHv = f2;
            }
        }

        private void e(File file, File file2) {
            BufferedOutputStream bufferedOutputStream;
            BufferedInputStream bufferedInputStream;
            AppMethodBeat.i(169822);
            if (!file2.exists()) {
                file2.getParentFile().mkdirs();
            }
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read > 0) {
                                this.NHn.throwIfCanceled();
                                bufferedOutputStream.write(bArr, 0, read);
                            } else {
                                ExtStorageMigrateMonitor.gwK().d("MicroMsg.ExtStorageMigrateService", "[*] Copy %s to %s then remove source.", file.getAbsolutePath(), file2.getAbsolutePath());
                                aa.closeQuietly(bufferedOutputStream);
                                aa.closeQuietly(bufferedInputStream);
                                AppMethodBeat.o(169822);
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        aa.closeQuietly(bufferedOutputStream);
                        aa.closeQuietly(bufferedInputStream);
                        AppMethodBeat.o(169822);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = null;
                    aa.closeQuietly(bufferedOutputStream);
                    aa.closeQuietly(bufferedInputStream);
                    AppMethodBeat.o(169822);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
                bufferedInputStream = null;
                aa.closeQuietly(bufferedOutputStream);
                aa.closeQuietly(bufferedInputStream);
                AppMethodBeat.o(169822);
                throw th;
            }
        }

        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(169824);
            aVar.NHn.cancel();
            AppMethodBeat.o(169824);
        }
    }

    private static File Q(File file) {
        AppMethodBeat.i(169830);
        try {
            File canonicalFile = file.getCanonicalFile();
            AppMethodBeat.o(169830);
            return canonicalFile;
        } catch (Throwable th) {
            ExtStorageMigrateMonitor.gwK().printErrStackTrace("MicroMsg.ExtStorageMigrateService", th, "[-] Fail to get canonical file for: %s", file.getAbsolutePath());
            File absoluteFile = file.getAbsoluteFile();
            AppMethodBeat.o(169830);
            return absoluteFile;
        }
    }

    private static String Wr(String str) {
        AppMethodBeat.i(169831);
        try {
            String canonicalPath = new File(str).getCanonicalPath();
            AppMethodBeat.o(169831);
            return canonicalPath;
        } catch (Throwable th) {
            ExtStorageMigrateMonitor.gwK().printErrStackTrace("MicroMsg.ExtStorageMigrateService", th, "[-] Fail to get canonical path for: %s", str);
            String absolutePath = new File(str).getAbsolutePath();
            AppMethodBeat.o(169831);
            return absolutePath;
        }
    }

    static /* synthetic */ String ajE(int i2) {
        AppMethodBeat.i(258870);
        String string = MMApplicationContext.getResources().getString(i2);
        AppMethodBeat.o(258870);
        return string;
    }

    static /* synthetic */ void a(ExtStorageMigrateService extStorageMigrateService, Notification notification) {
        boolean z = true;
        int i2 = 1;
        AppMethodBeat.i(232406);
        if (Build.VERSION.SDK_INT >= 24) {
            if (notification != null) {
                i2 = 2;
            }
            extStorageMigrateService.stopForeground(i2);
        } else {
            if (notification != null) {
                z = false;
            }
            extStorageMigrateService.stopForeground(z);
        }
        NotificationManager notificationManager = (NotificationManager) extStorageMigrateService.getSystemService("notification");
        if (notification != null) {
            notificationManager.notify(TXLiteAVCode.EVT_HW_ENCODER_START_SUCC, notification);
        } else {
            notificationManager.cancel(TXLiteAVCode.EVT_HW_ENCODER_START_SUCC);
        }
        extStorageMigrateService.AC(false);
        AppMethodBeat.o(232406);
    }

    static /* synthetic */ void a(ExtStorageMigrateService extStorageMigrateService, ExtStorageMigrateConfig extStorageMigrateConfig) {
        AppMethodBeat.i(232407);
        if (!ExtStorageMigrateRoutine.needsToDoMigrate(extStorageMigrateService)) {
            extStorageMigrateService.NHc.ajG(1);
            AppMethodBeat.o(232407);
        } else if (extStorageMigrateService.gwS()) {
            extStorageMigrateService.NHc.c(4, null);
            AppMethodBeat.o(232407);
        } else {
            String str = extStorageMigrateConfig.sourceDir;
            if (str == null || !new File(str).canRead()) {
                extStorageMigrateService.NHc.c(7, null);
                AppMethodBeat.o(232407);
            } else if (extStorageMigrateConfig.NGH == null) {
                extStorageMigrateService.NHc.c(8, null);
                AppMethodBeat.o(232407);
            } else {
                CancellationSignal cancellationSignal = new CancellationSignal();
                synchronized (extStorageMigrateService.NHd) {
                    try {
                        extStorageMigrateService.NHd[0] = new a(extStorageMigrateConfig, cancellationSignal);
                        extStorageMigrateService.NHe = new Thread(extStorageMigrateService.NHd[0], "ExtStg_Migrate");
                        extStorageMigrateService.NHe.start();
                    } catch (Throwable th) {
                        ExtStorageMigrateMonitor.gwK().printErrStackTrace("MicroMsg.ExtStorageMigrateService", th, "Exception occurred.", new Object[0]);
                        extStorageMigrateService.NHc.c(5, th);
                    }
                    try {
                    } catch (Throwable th2) {
                        AppMethodBeat.o(232407);
                        throw th2;
                    }
                }
                AppMethodBeat.o(232407);
            }
        }
    }

    static /* synthetic */ void d(ExtStorageMigrateService extStorageMigrateService) {
        AppMethodBeat.i(232408);
        extStorageMigrateService.gwV();
        AppMethodBeat.o(232408);
    }

    static /* synthetic */ void e(ExtStorageMigrateService extStorageMigrateService) {
        AppMethodBeat.i(232411);
        synchronized (extStorageMigrateService.NHi) {
            try {
                if (extStorageMigrateService.NHi[0] == null) {
                    extStorageMigrateService.NHi[0] = ((PowerManager) extStorageMigrateService.getSystemService("power")).newWakeLock(1, "wx:extstg_migrate");
                    extStorageMigrateService.NHi[0].setReferenceCounted(false);
                }
                if (!extStorageMigrateService.NHi[0].isHeld()) {
                    extStorageMigrateService.NHi[0].acquire();
                    ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateService", "[+] WakeLock acquired.", new Object[0]);
                } else {
                    ExtStorageMigrateMonitor.gwK().w("MicroMsg.ExtStorageMigrateService", "[!] Duplicated wakelock acquire.", new Object[0]);
                }
            } finally {
                AppMethodBeat.o(232411);
            }
        }
    }
}
