package com.tencent.mm.ci;

import android.os.Debug;
import android.os.Environment;
import android.os.Message;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public final class d implements EventListener {
    public static a OvX = null;
    public static d Owc;
    private static int Owd = 5242880;
    public static final String Owf = (Environment.getExternalStorageDirectory() + "/tencent/MicroMsg/tracedog/");
    static MMHandler hAk = new MMHandler() {
        /* class com.tencent.mm.ci.d.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            b bVar;
            AppMethodBeat.i(145597);
            Log.i("MicroMsg.TraceDebugManager", "TRACE handle msg :%d ", Integer.valueOf(message.what));
            if (message.what == 0) {
                d.Owc.b((a) message.obj);
            } else if (message.what != 1) {
                d.a(d.Owc, (a) message.obj);
            } else if (!(d.Owc.Owi == null || (bVar = (b) d.Owc.Owi.get()) == null)) {
                bVar.gGo();
            }
            super.handleMessage(message);
            AppMethodBeat.o(145597);
        }
    };
    private volatile boolean Owe;
    private LinkedBlockingQueue<a> Owg;
    ExecutorService Owh;
    public WeakReference<b> Owi;
    private volatile boolean jkK;

    public interface b {
        void gGo();
    }

    static /* synthetic */ void a(d dVar, a aVar) {
        AppMethodBeat.i(145611);
        dVar.a(aVar);
        AppMethodBeat.o(145611);
    }

    static /* synthetic */ void a(d dVar, String str) {
        AppMethodBeat.i(145612);
        dVar.blF(str);
        AppMethodBeat.o(145612);
    }

    static /* synthetic */ String ak(o oVar) {
        AppMethodBeat.i(170140);
        String aj = aj(oVar);
        AppMethodBeat.o(170140);
        return aj;
    }

    static {
        AppMethodBeat.i(145613);
        AppMethodBeat.o(145613);
    }

    public static d gGm() {
        AppMethodBeat.i(145600);
        if (Owc == null) {
            Owc = new d();
        }
        d dVar = Owc;
        AppMethodBeat.o(145600);
        return dVar;
    }

    private void a(a aVar) {
        AppMethodBeat.i(145601);
        if (this.Owe) {
            AppMethodBeat.o(145601);
        } else if (!c.apn()) {
            Log.i("MicroMsg.TraceDebugManager", "TRACE sdcard is invalid");
            AppMethodBeat.o(145601);
        } else {
            gGn();
            try {
                o oVar = new o(Owf);
                if (aVar.een != 6 && oVar.exists()) {
                    Log.i("MicroMsg.TraceDebugManager", "TRACE delete all file ");
                    s.dy(aa.z(oVar.mUri), true);
                }
                oVar.mkdirs();
                Debug.startMethodTracing(aVar.savePath, aVar.Owl <= 0 ? Owd : aVar.Owl * 1024 * 1024);
                this.Owe = true;
            } catch (IncompatibleClassChangeError e2) {
                Log.printErrStackTrace("MicroMsg.Crash", e2, "May cause dvmFindCatchBlock crash!", new Object[0]);
                IncompatibleClassChangeError incompatibleClassChangeError = (IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e2);
                AppMethodBeat.o(145601);
                throw incompatibleClassChangeError;
            } catch (Throwable th) {
                this.Owe = false;
                Log.printErrStackTrace("MicroMsg.TraceDebugManager", th, "TRACE startMethodTracing ERROR", new Object[0]);
            }
            if (aVar.een == 6) {
                Log.i("MicroMsg.TraceDebugManager", "TRACE startTrace uploadType is CLIENT ");
                AppMethodBeat.o(145601);
            } else if (!this.Owe) {
                AppMethodBeat.o(145601);
            } else {
                Message obtain = Message.obtain();
                obtain.what = 0;
                obtain.obj = aVar;
                if (Util.isNullOrNil(aVar.className) || aVar.een == 5) {
                    hAk.sendMessageDelayed(obtain, 15000);
                    AppMethodBeat.o(145601);
                    return;
                }
                hAk.sendMessageDelayed(obtain, 10000);
                AppMethodBeat.o(145601);
            }
        }
    }

    private static void gGn() {
        AppMethodBeat.i(145602);
        hAk.removeMessages(0);
        hAk.removeMessages(2);
        hAk.removeMessages(1);
        AppMethodBeat.o(145602);
    }

    public final boolean b(final a aVar) {
        AppMethodBeat.i(145604);
        gGn();
        if (!this.Owe || this.jkK) {
            Log.i("MicroMsg.TraceDebugManager", "TRACE stopTrace hasStartTrace : %b ,isUploading :%b  ", Boolean.valueOf(this.Owe), Boolean.valueOf(this.jkK));
            AppMethodBeat.o(145604);
            return false;
        } else if (!c.apn()) {
            Log.i("MicroMsg.TraceDebugManager", "TRACE stopTrace sdcard invalid");
            AppMethodBeat.o(145604);
            return false;
        } else {
            this.Owh.execute(new Runnable() {
                /* class com.tencent.mm.ci.d.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(145596);
                    try {
                        Debug.stopMethodTracing();
                        String str = aVar.savePath;
                        int i2 = aVar.Owm;
                        if (aVar.savePath == null) {
                            d.this.Owe = false;
                            AppMethodBeat.o(145596);
                            return;
                        }
                        o oVar = new o(str);
                        o oVar2 = new o(str.substring(0, str.lastIndexOf(46)) + ".snapshot");
                        long currentTimeMillis = System.currentTimeMillis();
                        oVar.am(oVar2);
                        oVar.delete();
                        Log.i("MicroMsg.TraceDebugManager", "TRACE xorEn last :" + (System.currentTimeMillis() - currentTimeMillis));
                        Process.setThreadPriority(10);
                        if (aVar.een == 6) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(aa.z(oVar2.her()));
                            try {
                                s.t(arrayList, aa.z(oVar2.her()) + ".zip");
                                d.hAk.sendEmptyMessage(1);
                                d.this.Owe = false;
                                AppMethodBeat.o(145596);
                            } catch (Exception e2) {
                                Log.e("MicroMsg.TraceDebugManager", "exception:%s", Util.stackTraceToString(e2));
                                Log.e("MicroMsg.TraceDebugManager", "zip file failed msg:%s ", e2.getMessage());
                                d.this.Owe = false;
                                AppMethodBeat.o(145596);
                            }
                        } else {
                            if (d.this.Owg == null || d.this.Owg.size() == 0) {
                                String ak = d.ak(oVar2);
                                if (!Util.isNullOrNil(ak)) {
                                    d dVar = d.this;
                                    if (i2 == 1 || (i2 == 3 && NetStatusUtil.isWifi(MMApplicationContext.getContext()))) {
                                        dVar.blF(ak);
                                    }
                                }
                            }
                            d.this.Owe = false;
                            AppMethodBeat.o(145596);
                        }
                    } catch (IncompatibleClassChangeError e3) {
                        Log.printErrStackTrace("MicroMsg.Crash", e3, "May cause dvmFindCatchBlock crash!", new Object[0]);
                        IncompatibleClassChangeError incompatibleClassChangeError = (IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e3);
                        AppMethodBeat.o(145596);
                        throw incompatibleClassChangeError;
                    } catch (Throwable th) {
                        d.this.Owe = false;
                        AppMethodBeat.o(145596);
                        throw th;
                    }
                }
            });
            AppMethodBeat.o(145604);
            return true;
        }
    }

    private static String aj(o oVar) {
        AppMethodBeat.i(170139);
        ArrayList arrayList = new ArrayList();
        if (oVar.isDirectory()) {
            Log.i("MicroMsg.TraceDebugManager", "TRACE currentPath is dir");
            o[] het = oVar.het();
            if (het == null) {
                Log.e("MicroMsg.TraceDebugManager", " get file list failed");
                AppMethodBeat.o(170139);
                return null;
            }
            for (o oVar2 : het) {
                arrayList.add(aa.z(oVar2.her()));
            }
        } else {
            arrayList.add(aa.z(oVar.her()));
        }
        o oVar3 = new o(Owf + Util.nowMilliSecond() + ".zip");
        try {
            s.t(arrayList, aa.z(oVar3.her()));
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                new o((String) arrayList.get(i2)).delete();
            }
            if (oVar3.length() > 3145728) {
                Log.e("MicroMsg.TraceDebugManager", "trace file is too large:%d ", Long.valueOf(oVar3.length()));
                AppMethodBeat.o(170139);
                return null;
            }
            String z = aa.z(oVar3.her());
            AppMethodBeat.o(170139);
            return z;
        } catch (Exception e2) {
            Log.e("MicroMsg.TraceDebugManager", "exception:%s", Util.stackTraceToString(e2));
            Log.e("MicroMsg.TraceDebugManager", "zip file failed msg:%s ", e2.getMessage());
            AppMethodBeat.o(170139);
            return null;
        }
    }

    private d() {
    }

    public final void gV(String str, int i2) {
        AppMethodBeat.i(145606);
        if (this.Owg != null && this.Owg.size() > 0) {
            Log.i("MicroMsg.TraceDebugManager", "TRACE gatherData : isUploading : %b  hasStart :%b currentClass : %s currentCode %d ", Boolean.valueOf(this.jkK), Boolean.valueOf(this.Owe), str, Integer.valueOf(i2));
            if (!this.jkK && !this.Owe) {
                Iterator<a> it = this.Owg.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.className == null) {
                        a((a) null);
                        this.Owg.remove(next);
                        AppMethodBeat.o(145606);
                        return;
                    } else if (next.className.equals(str) && next.een == i2) {
                        a(next);
                        this.Owg.remove(next);
                        AppMethodBeat.o(145606);
                        return;
                    }
                }
            }
        }
        AppMethodBeat.o(145606);
    }

    /* access modifiers changed from: package-private */
    public final void blF(String str) {
        AppMethodBeat.i(145607);
        if (str == null) {
            AppMethodBeat.o(145607);
            return;
        }
        this.jkK = true;
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.TraceDebugManager", "TRACE error uploadPath %s ", str);
        } else if (!c.apn()) {
            Log.e("MicroMsg.TraceDebugManager", "TRACE sdcard invalid.");
        } else {
            o oVar = new o(str);
            if (!oVar.exists()) {
                Log.e("MicroMsg.TraceDebugManager", "TRACE upload file is not exist");
            } else {
                if (oVar.isDirectory()) {
                    str = aj(oVar);
                }
                if (str != null && new o(str).length() >= 131072) {
                    if (OvX == null) {
                        Log.e("MicroMsg.TraceDebugManager", "TRACE upload : no file upload impl set!");
                    } else {
                        boolean aJP = OvX.aJP(str);
                        Log.i("MicroMsg.TraceDebugManager", "TRACE upload : %b", Boolean.valueOf(aJP));
                        if (aJP) {
                            s.dy(Owf, true);
                        }
                    }
                }
            }
        }
        this.jkK = false;
        AppMethodBeat.o(145607);
    }

    public final void c(a aVar) {
        AppMethodBeat.i(145608);
        if (aVar.een <= 0) {
            AppMethodBeat.o(145608);
            return;
        }
        if (this.Owh == null) {
            this.Owh = Executors.newSingleThreadExecutor();
        }
        if (this.jkK || this.Owe) {
            Log.i("MicroMsg.TraceDebugManager", "TRACE isUloading or hasStartTrace %b %b", Boolean.valueOf(this.jkK), Boolean.valueOf(this.Owe));
            AppMethodBeat.o(145608);
            return;
        }
        hAk.removeMessages(0);
        if (aVar.Owm == 4 || aVar.Owm == 5) {
            akF(aVar.Owm);
        } else if (aVar.een == 6 || aVar.een == 5) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = aVar;
            if (aVar.een == 5) {
                hAk.sendMessage(obtain);
            } else {
                hAk.sendMessageDelayed(obtain, 500);
            }
        } else {
            if (this.Owg == null) {
                this.Owg = new LinkedBlockingQueue<>();
            }
            this.Owg.clear();
            this.Owg.add(aVar);
        }
        Log.i("MicroMsg.TraceDebugManager", "TRACE PUSH : class : %s  code :%s type :%s", aVar.className, Integer.valueOf(aVar.een), Integer.valueOf(aVar.Owm));
        AppMethodBeat.o(145608);
    }

    private void akF(final int i2) {
        AppMethodBeat.i(145609);
        this.Owh.execute(new Runnable() {
            /* class com.tencent.mm.ci.d.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(145598);
                d.a(d.this, i2 == 4 ? "/data/anr/" : d.Owf);
                AppMethodBeat.o(145598);
            }
        });
        AppMethodBeat.o(145609);
    }

    public static final class a {
        int Owl;
        int Owm;
        String className;
        int een;
        String savePath;

        public a(String str, int i2, int i3, int i4) {
            AppMethodBeat.i(145599);
            this.className = str;
            this.een = i2;
            this.Owl = i3;
            this.Owm = i4;
            StringBuilder sb = new StringBuilder();
            if (Util.isNullOrNil(str)) {
                sb.append(d.Owf).append("WEIXIN_").append(System.currentTimeMillis()).append(".trace");
            } else {
                StringBuilder append = sb.append(d.Owf).append(str).append("_");
                String str2 = "";
                switch (i2) {
                    case 1:
                        str2 = "onResume";
                        break;
                    case 2:
                        str2 = "onPause";
                        break;
                    case 3:
                        str2 = "onCreate";
                        break;
                    case 4:
                        str2 = "onScrool";
                        break;
                    case 5:
                        str2 = "all";
                        break;
                }
                append.append(str2).append(".trace");
            }
            Log.i("MicroMsg.TraceDebugManager", "TRACE startMethod path %s traceSize : %d", sb.toString(), Integer.valueOf(i3));
            this.savePath = sb.toString();
            AppMethodBeat.o(145599);
        }
    }
}
