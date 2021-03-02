package com.tencent.tbs.a.a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tbs.a.a.b.a;
import com.tencent.tbs.a.d;
import com.tencent.tbs.a.e;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class b implements d {
    private C2195b RRW = new C2195b(this, (byte) 0);
    private volatile a RRX = new a(this, (byte) 0);
    private com.tencent.tbs.a.a.c.b RRY;
    private a RRZ;
    private com.tencent.tbs.a.a.a.a RSa;

    /* renamed from: a  reason: collision with root package name */
    private boolean f2298a = true;

    /* renamed from: b  reason: collision with root package name */
    boolean f2299b = true;

    /* renamed from: h  reason: collision with root package name */
    private Context f2300h;

    static /* synthetic */ String a(b bVar) {
        AppMethodBeat.i(53072);
        String a2 = bVar.a();
        AppMethodBeat.o(53072);
        return a2;
    }

    public b(Context context, com.tencent.tbs.a.a.c.b bVar, a aVar, com.tencent.tbs.a.a.a.a aVar2) {
        AppMethodBeat.i(53067);
        this.RRY = bVar;
        this.RRZ = aVar;
        this.RSa = aVar2;
        this.f2300h = context;
        AppMethodBeat.o(53067);
    }

    private String a() {
        AppMethodBeat.i(174283);
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) this.f2300h.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == Process.myPid()) {
                File file = new File(e.a(), runningAppProcessInfo.processName.toLowerCase().replace(".", "_"));
                if (!file.exists()) {
                    file.mkdirs();
                }
                String absolutePath = file.getAbsolutePath();
                AppMethodBeat.o(174283);
                return absolutePath;
            }
        }
        String a2 = e.a();
        AppMethodBeat.o(174283);
        return a2;
    }

    @Override // com.tencent.tbs.a.d
    public final void a(com.tencent.tbs.a.b bVar) {
        AppMethodBeat.i(174284);
        if (this.f2298a) {
            if (!this.RRX.a()) {
                a aVar = this.RRX;
                synchronized (aVar) {
                    try {
                        new Thread(aVar).start();
                        aVar.f2301c = true;
                    } catch (Exception e2) {
                    }
                    try {
                    } catch (Throwable th) {
                        AppMethodBeat.o(174284);
                        throw th;
                    }
                }
            }
            try {
                this.RRX.RSb.put(bVar);
                AppMethodBeat.o(174284);
            } catch (InterruptedException e3) {
                AppMethodBeat.o(174284);
            }
        } else {
            b(bVar);
            AppMethodBeat.o(174284);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(com.tencent.tbs.a.b bVar) {
        AppMethodBeat.i(174285);
        if (!c(bVar)) {
            new Throwable("log file open failed!");
            AppMethodBeat.o(174285);
            return;
        }
        this.RRW.b(com.tencent.tbs.a.a.d(bVar));
        AppMethodBeat.o(174285);
    }

    private boolean c(com.tencent.tbs.a.b bVar) {
        AppMethodBeat.i(174286);
        try {
            String str = this.RRW.f2303d;
            String d2 = this.RRY.d(bVar);
            if (d2 == null || d2.trim().length() == 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("File name should not be empty.");
                AppMethodBeat.o(174286);
                throw illegalArgumentException;
            }
            if (!d2.equals(str)) {
                if (this.RRW.RSd != null) {
                    this.RRW.d();
                }
                File[] listFiles = new File(a()).listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        if (this.RRZ.a(file)) {
                            file.delete();
                        }
                    }
                }
                if (!this.RRW.a(d2)) {
                    AppMethodBeat.o(174286);
                    return false;
                }
            }
            File file2 = this.RRW.f2302b;
            if (file2 == null || !this.RSa.a(file2)) {
                AppMethodBeat.o(174286);
                return true;
            }
            this.RRW.d();
            File file3 = new File(a(), d2 + "-" + (System.currentTimeMillis() % Util.MILLSECONDS_OF_DAY));
            if (file3.exists()) {
                file3.delete();
            }
            file2.renameTo(file3);
            boolean a2 = this.RRW.a(d2);
            AppMethodBeat.o(174286);
            return a2;
        } catch (Exception e2) {
            AppMethodBeat.o(174286);
            return false;
        }
    }

    class a implements Runnable {
        BlockingQueue<com.tencent.tbs.a.b> RSb;

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f2301c;

        private a() {
            AppMethodBeat.i(53062);
            this.RSb = new LinkedBlockingQueue();
            AppMethodBeat.o(53062);
        }

        /* synthetic */ a(b bVar, byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final boolean a() {
            boolean z;
            synchronized (this) {
                z = this.f2301c;
            }
            return z;
        }

        public final void run() {
            AppMethodBeat.i(53063);
            while (true) {
                try {
                    com.tencent.tbs.a.b take = this.RSb.take();
                    if (take != null) {
                        b.this.b(take);
                    } else {
                        AppMethodBeat.o(53063);
                        return;
                    }
                } catch (InterruptedException e2) {
                    synchronized (this) {
                        this.f2301c = false;
                        AppMethodBeat.o(53063);
                        return;
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(53063);
                    throw th;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.tbs.a.a.b$b  reason: collision with other inner class name */
    public class C2195b {
        OutputStream RSd;

        /* renamed from: b  reason: collision with root package name */
        File f2302b;

        /* renamed from: d  reason: collision with root package name */
        String f2303d;

        private C2195b() {
        }

        /* synthetic */ C2195b(b bVar, byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final boolean a(String str) {
            AppMethodBeat.i(53064);
            this.f2303d = str;
            this.f2302b = new File(b.a(b.this), str);
            if (!this.f2302b.exists()) {
                try {
                    File parentFile = this.f2302b.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    this.f2302b.createNewFile();
                } catch (IOException e2) {
                    this.f2302b = null;
                    AppMethodBeat.o(53064);
                    return false;
                }
            }
            try {
                this.RSd = new BufferedOutputStream(new FileOutputStream(this.f2302b, true));
                AppMethodBeat.o(53064);
                return true;
            } catch (Exception e3) {
                this.f2302b = null;
                AppMethodBeat.o(53064);
                return false;
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean d() {
            AppMethodBeat.i(174280);
            if (this.RSd != null) {
                try {
                    this.RSd.close();
                    this.RSd = null;
                    this.f2302b = null;
                } catch (IOException e2) {
                    this.RSd = null;
                    this.f2302b = null;
                    AppMethodBeat.o(174280);
                    return false;
                } catch (Throwable th) {
                    this.RSd = null;
                    this.f2302b = null;
                    AppMethodBeat.o(174280);
                    throw th;
                }
            }
            AppMethodBeat.o(174280);
            return true;
        }

        /* access modifiers changed from: package-private */
        public final void b(String str) {
            byte[] h2;
            AppMethodBeat.i(53066);
            if (this.RSd != null) {
                try {
                    if (b.this.f2299b) {
                        String valueOf = String.valueOf(System.currentTimeMillis());
                        byte[] nL = a.nL("tbslog.txt", valueOf);
                        if (!(nL == null || (h2 = a.h(valueOf, str, nL)) == null)) {
                            this.RSd.write(h2);
                        }
                    } else if (!TextUtils.isEmpty(str)) {
                        this.RSd.write(str.getBytes());
                    }
                    if (this.RSd != null) {
                        try {
                            this.RSd.flush();
                            AppMethodBeat.o(53066);
                            return;
                        } catch (IOException e2) {
                            AppMethodBeat.o(53066);
                            return;
                        }
                    }
                } catch (Exception e3) {
                    if (this.RSd != null) {
                        try {
                            this.RSd.flush();
                            AppMethodBeat.o(53066);
                            return;
                        } catch (IOException e4) {
                            AppMethodBeat.o(53066);
                            return;
                        }
                    }
                } catch (Throwable th) {
                    if (this.RSd != null) {
                        try {
                            this.RSd.flush();
                        } catch (IOException e5) {
                        }
                    }
                    AppMethodBeat.o(53066);
                    throw th;
                }
            }
            AppMethodBeat.o(53066);
        }
    }
}
