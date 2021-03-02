package com.tencent.mm.splash;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.splash.a;
import com.tencent.mm.splash.o;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class h {
    public static final ArrayList<i> NLB = new ArrayList<>();
    public static final ArrayList<Message> NLC = new ArrayList<>();
    static String NLD;
    static e NLE;
    static b NLF;
    static f NLG;
    static Set<SplashActivity> NLH = new HashSet();
    private static boolean NLI = false;
    private static volatile boolean NLJ = false;
    private static boolean NLK = false;
    private static o NLL;
    private static boolean NLM = false;
    static c NLN;
    private static Class<? extends SplashActivity> NLO;
    private static Set<String> NLP = new HashSet();
    private static Class<? extends Activity> NLQ;
    private static n NLR = new n();
    private static HashSet<String> NLS = new HashSet<>();
    private static boolean NLT = false;
    @SuppressLint({"HandlerLeak"})
    private static Handler NLU = new Handler(Looper.getMainLooper()) {
        /* class com.tencent.mm.splash.h.AnonymousClass3 */

        public final void handleMessage(Message message) {
            AppMethodBeat.i(40626);
            super.handleMessage(message);
            if (message.what == 0) {
                h.access$200();
                AppMethodBeat.o(40626);
                return;
            }
            a.jy(h.gNz);
            a.a(new a.AbstractC2062a() {
                /* class com.tencent.mm.splash.h.AnonymousClass3.AnonymousClass1 */

                @Override // com.tencent.mm.splash.a.AbstractC2062a
                public final void gye() {
                    AppMethodBeat.i(40623);
                    h.access$200();
                    AppMethodBeat.o(40623);
                }

                @Override // com.tencent.mm.splash.a.AbstractC2062a
                public final void eZS() {
                    AppMethodBeat.i(40624);
                    h.c("WxSplash.Splash", "dexopt service return failed. kill self.", new Object[0]);
                    h.eCp();
                    AppMethodBeat.o(40624);
                }

                @Override // com.tencent.mm.splash.a.AbstractC2062a
                public final void gyf() {
                    AppMethodBeat.i(40625);
                    h.c("WxSplash.Splash", "dexopt service return timeout. kill self.", new Object[0]);
                    h.eCp();
                    AppMethodBeat.o(40625);
                }
            });
            AppMethodBeat.o(40626);
        }
    };
    static d dme;
    static Application gNz;

    static /* synthetic */ void Wz() {
        AppMethodBeat.i(40650);
        gyn();
        AppMethodBeat.o(40650);
    }

    static /* synthetic */ void access$200() {
        AppMethodBeat.i(40649);
        gyo();
        AppMethodBeat.o(40649);
    }

    static {
        AppMethodBeat.i(40652);
        AppMethodBeat.o(40652);
    }

    static void a(SplashActivity splashActivity) {
        AppMethodBeat.i(40631);
        NLH.add(splashActivity);
        AppMethodBeat.o(40631);
    }

    static void b(SplashActivity splashActivity) {
        AppMethodBeat.i(40632);
        NLH.remove(splashActivity);
        AppMethodBeat.o(40632);
    }

    public static String bb(Activity activity) {
        if (activity instanceof i) {
            return ((i) activity).NMc;
        }
        return "";
    }

    public static void bik(String str) {
        AppMethodBeat.i(40633);
        NLS.add(str);
        AppMethodBeat.o(40633);
    }

    public static void a(o oVar) {
        NLL = oVar;
    }

    public static void bb(Class<? extends SplashActivity> cls) {
        NLO = cls;
    }

    public static void bc(Class<? extends Activity> cls) {
        NLQ = cls;
    }

    public static void a(c cVar) {
        NLN = cVar;
    }

    public static void a(e eVar) {
        NLE = eVar;
    }

    public static void a(d dVar) {
        dme = dVar;
    }

    public static void a(b bVar) {
        NLF = bVar;
    }

    public static void a(f fVar) {
        NLG = fVar;
    }

    public static void jC(Context context) {
        boolean z = true;
        AppMethodBeat.i(40634);
        try {
            ComponentName topActivity = Util.getTopActivity(context);
            if (topActivity != null && topActivity.getPackageName().equals(context.getPackageName()) && NLD != null && topActivity.getClassName().equals(NLD)) {
                c("WxSplash.Splash", "it is LauncherUI", new Object[0]);
            } else if (topActivity == null || !topActivity.getPackageName().startsWith("com.excelliance")) {
                z = false;
            } else {
                c("WxSplash.Splash", "it is dual open", new Object[0]);
            }
            if (!z) {
                c("WxSplash.Splash", "do nothing and return.", new Object[0]);
                AppMethodBeat.o(40634);
                return;
            }
            NLR.idkey(675, 36, 1);
            String gya = a.gya();
            o oVar = new o(gya);
            if (!oVar.exists()) {
                oVar.mkdirs();
            }
            o oVar2 = new o(gya + "/main-process-blocking");
            if (oVar2.exists()) {
                oVar2.delete();
            }
            if (oVar2.createNewFile()) {
                Intent intent = new Intent(context, NLQ);
                intent.addFlags(268435456);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/splash/Splash", "startFigLeafActivityIfNeed", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/splash/Splash", "startFigLeafActivityIfNeed", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            AppMethodBeat.o(40634);
        } catch (IOException e2) {
            a(e2, "request fig leaf failed.");
            AppMethodBeat.o(40634);
        }
    }

    public static void bil(String str) {
        NLD = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0123  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean o(android.app.Application r16) {
        /*
        // Method dump skipped, instructions count: 894
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.splash.h.o(android.app.Application):boolean");
    }

    public static void gyh() {
        boolean z = true;
        AppMethodBeat.i(40636);
        if (NLK) {
            try {
                Handler.Callback callback = (Handler.Callback) l.NMv.get(l.kHW);
                Object[] objArr = new Object[2];
                if (callback != l.NMu) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                objArr[1] = callback;
                c("WxSplash.Splash", "double check, callback %s %s", objArr);
                if (callback == l.NMu) {
                    AppMethodBeat.o(40636);
                    return;
                }
                c("WxSplash.Splash", "double check found problem!", new Object[0]);
                Field field = l.NMv;
                l.NMu.AFR = callback;
                field.setAccessible(true);
                field.set(l.kHW, l.NMu);
                NLR.idkey(675, 31, 1);
                l.kHW.sendEmptyMessage(987654321);
                AppMethodBeat.o(40636);
                return;
            } catch (Exception e2) {
                a(e2, "double check exception.");
            }
        }
        AppMethodBeat.o(40636);
    }

    public static boolean gyi() {
        return true;
    }

    public static boolean gyj() {
        if (NLI) {
            return true;
        }
        return false;
    }

    public static boolean gyk() {
        return NLJ;
    }

    public static void eCp() {
        AppMethodBeat.i(40637);
        com.tencent.mm.hellhoundlib.b.a a2 = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        Object obj = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/splash/Splash", "killSelf", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/splash/Splash", "killSelf", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(40637);
    }

    public static void gyl() {
        int i2 = 0;
        AppMethodBeat.i(40638);
        if (!g.zF) {
            boolean jw = a.jw(gNz);
            Handler handler = NLU;
            if (jw) {
                i2 = 1;
            }
            handler.sendEmptyMessage(i2);
            AppMethodBeat.o(40638);
            return;
        }
        NLU.sendEmptyMessage(0);
        AppMethodBeat.o(40638);
    }

    public static void p(Message message) {
        AppMethodBeat.i(40639);
        l.kHW.sendMessage(message);
        AppMethodBeat.o(40639);
    }

    private static void gym() {
        AppMethodBeat.i(40640);
        c("WxSplash.Splash", "Gonna replay %s pending message(s).", Integer.valueOf(NLC.size()));
        Iterator<Message> it = NLC.iterator();
        while (it.hasNext()) {
            p(it.next());
        }
        NLC.clear();
        AppMethodBeat.o(40640);
    }

    private static void gyn() {
        AppMethodBeat.i(40641);
        c("WxSplash.Splash", "splash done, do finally things. ", new Object[0]);
        NLI = false;
        int size = NLH.size();
        for (SplashActivity splashActivity : NLH) {
            c("WxSplash.Splash", "iterate splash activity %s.", splashActivity);
            splashActivity.gyt();
        }
        if (size == 0) {
            c("WxSplash.Splash", "no splash activity found, so we terminate hacked activities manually.", new Object[0]);
            Iterator<i> it = NLB.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        }
        c("WxSplash.Splash", "resend all %s pending message. ", Integer.valueOf(NLC.size()));
        if (!NLJ) {
            gym();
        }
        NLL = null;
        c("WxSplash.Splash", "we need splash no more.", new Object[0]);
        synchronized (h.class) {
            try {
                NLM = false;
            } finally {
                AppMethodBeat.o(40641);
            }
        }
        n nVar = NLR;
        if (nVar.mStartTimestamp > 0) {
            long currentTimeMillis = System.currentTimeMillis() - nVar.mStartTimestamp;
            if (g.zF) {
                nVar.idkey(676, 1, 1);
                nVar.idkey(676, 3, currentTimeMillis);
                AppMethodBeat.o(40641);
                return;
            }
            nVar.idkey(676, 0, 1);
            nVar.idkey(676, 2, currentTimeMillis);
        }
    }

    private static synchronized void gyo() {
        synchronized (h.class) {
            AppMethodBeat.i(40642);
            a.jx(gNz);
            synchronized (h.class) {
                try {
                    if (!NLM) {
                        NLM = true;
                        try {
                            if (!NLK) {
                                c("WxSplash.Splash", "not hacked, return.", new Object[0]);
                            } else if (g.zF) {
                                c("WxSplash.Splash", "not hack content provider, return.", new Object[0]);
                            } else if (!(l.NMs == null || l.NMs.size() == 0)) {
                                NLR.idkey(675, 10, 1);
                                Object obj = l.dmH;
                                Field declaredField = obj.getClass().getDeclaredField("mInitialApplication");
                                declaredField.setAccessible(true);
                                Object obj2 = declaredField.get(obj);
                                l.NMr = (Application) obj2;
                                if (obj2 == null) {
                                    c("WxSplash.Splash", "mInitialApplication is null, use mine. ", new Object[0]);
                                    obj2 = gNz;
                                }
                                try {
                                    Class.forName("com.tencent.mm.plugin.base.stub.WXCommProvider");
                                    Class.forName("com.tencent.mm.plugin.base.stub.WXCommProvider$1");
                                    c("WxSplash.Splash", "WXCommProvider is ok", new Object[0]);
                                } catch (Throwable th) {
                                    a(th, "before install provider, we found a weird thing.");
                                }
                                c("WxSplash.Splash", "before delay install ContentProviders. ", new Object[0]);
                                l.NMt.invoke(obj, obj2, l.NMs);
                                c("WxSplash.Splash", "delay install ContentProviders. ", new Object[0]);
                                l.NMs.clear();
                            }
                        } catch (Exception e2) {
                            NLR.idkey(675, 11, 1);
                            a(e2, "install provider failed!");
                        }
                        if (NLL == null) {
                            gyn();
                            AppMethodBeat.o(40642);
                        } else {
                            NLL.d(new o.a() {
                                /* class com.tencent.mm.splash.h.AnonymousClass4 */

                                @Override // com.tencent.mm.splash.o.a
                                public final void gyr() {
                                    AppMethodBeat.i(170141);
                                    h.access$300();
                                    AppMethodBeat.o(170141);
                                }

                                @Override // com.tencent.mm.splash.o.a
                                public final void done() {
                                    AppMethodBeat.i(170142);
                                    h.c("WxSplash.Splash", "told me done.", new Object[0]);
                                    h.Wz();
                                    AppMethodBeat.o(170142);
                                }
                            });
                            AppMethodBeat.o(40642);
                        }
                    }
                } finally {
                    AppMethodBeat.o(40642);
                }
            }
        }
    }

    private static boolean gh(String str) {
        AppMethodBeat.i(40643);
        if (dme != null) {
            boolean gh = dme.gh(str);
            AppMethodBeat.o(40643);
            return gh;
        }
        AppMethodBeat.o(40643);
        return false;
    }

    public static void a(i iVar) {
        AppMethodBeat.i(40644);
        if (!gh(iVar.NMc)) {
            iVar.recreate();
            c("WxSplash.Splash", "do recreate for %s", iVar.NMc);
            AppMethodBeat.o(40644);
            return;
        }
        iVar.finish();
        c("WxSplash.Splash", "eat activity, %s", iVar.NMc);
        AppMethodBeat.o(40644);
    }

    public static Class<? extends Activity> gyp() {
        return NLO;
    }

    public static boolean bim(String str) {
        AppMethodBeat.i(240221);
        boolean contains = NLP.contains(str);
        c("WxSplash.Splash", "ignore activity %s ?, %s", str, Boolean.valueOf(contains));
        AppMethodBeat.o(240221);
        return contains;
    }

    private static Object jD(Context context) {
        AppMethodBeat.i(40645);
        Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
        method.setAccessible(true);
        Object invoke = method.invoke(null, new Object[0]);
        if (invoke != null) {
            AppMethodBeat.o(40645);
            return invoke;
        }
        Field field = context.getClass().getField("mLoadedApk");
        field.setAccessible(true);
        Object obj = field.get(context);
        Field declaredField = obj.getClass().getDeclaredField("mActivityThread");
        declaredField.setAccessible(true);
        Object obj2 = declaredField.get(obj);
        AppMethodBeat.o(40645);
        return obj2;
    }

    public static void c(String str, String str2, Object... objArr) {
        AppMethodBeat.i(40646);
        if (NLN != null) {
            NLN.c(str, str2, objArr);
        }
        AppMethodBeat.o(40646);
    }

    public static void a(Throwable th, String str) {
        AppMethodBeat.i(40647);
        if (NLN != null) {
            NLN.a(th, str);
        }
        AppMethodBeat.o(40647);
    }

    public static n gyq() {
        return NLR;
    }

    static /* synthetic */ void access$100() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(40648);
        try {
            Object jD = jD(gNz);
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(jD == l.dmH);
            c("WxSplash.Splash", "spy, activityThread %s", objArr);
            Field declaredField = jD.getClass().getDeclaredField("mH");
            declaredField.setAccessible(true);
            Handler handler = (Handler) declaredField.get(jD);
            Object[] objArr2 = new Object[1];
            if (handler == l.kHW) {
                z = true;
            } else {
                z = false;
            }
            objArr2[0] = Boolean.valueOf(z);
            c("WxSplash.Splash", "spy, ActivityThread_mH %s", objArr2);
            Field declaredField2 = Handler.class.getDeclaredField("mCallback");
            declaredField2.setAccessible(true);
            Handler.Callback callback = (Handler.Callback) declaredField2.get(handler);
            Object[] objArr3 = new Object[2];
            if (callback != l.NMu) {
                z2 = false;
            }
            objArr3[0] = Boolean.valueOf(z2);
            objArr3[1] = callback;
            c("WxSplash.Splash", "spy, callback %s %s", objArr3);
            AppMethodBeat.o(40648);
        } catch (Exception e2) {
            a(e2, "spy failed.");
            AppMethodBeat.o(40648);
        }
    }

    static /* synthetic */ void access$300() {
        AppMethodBeat.i(170143);
        NLJ = true;
        c("WxSplash.Splash", "pending early replay %s", Boolean.valueOf(NLJ));
        gym();
        AppMethodBeat.o(170143);
    }
}
