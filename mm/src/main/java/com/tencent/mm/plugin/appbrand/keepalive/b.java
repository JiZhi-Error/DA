package com.tencent.mm.plugin.appbrand.keepalive;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.keepalive.a;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public enum b {
    INSTANCE;
    
    public String mOk = null;
    private boolean mOl = false;

    private b(String str) {
    }

    public static b valueOf(String str) {
        AppMethodBeat.i(47036);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(47036);
        return bVar;
    }

    static {
        AppMethodBeat.i(47040);
        AppMethodBeat.o(47040);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.keepalive.b$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] kRf = new int[com.tencent.mm.plugin.appbrand.a.b.values().length];

        static {
            AppMethodBeat.i(47032);
            try {
                kRf[com.tencent.mm.plugin.appbrand.a.b.BACKGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                kRf[com.tencent.mm.plugin.appbrand.a.b.SUSPEND.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                kRf[com.tencent.mm.plugin.appbrand.a.b.kQH.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                kRf[com.tencent.mm.plugin.appbrand.a.b.DESTROYED.ordinal()] = 4;
                AppMethodBeat.o(47032);
            } catch (NoSuchFieldError e5) {
                AppMethodBeat.o(47032);
            }
        }
    }

    public static void c(String str, final Runnable runnable) {
        AppMethodBeat.i(47037);
        if (!TextUtils.isEmpty(str)) {
            XIPCInvoker.a(MainProcessIPCService.dkO, new IPCString(str), a.class, new d<IPCVoid>() {
                /* class com.tencent.mm.plugin.appbrand.keepalive.b.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.ipcinvoker.d
                public final /* synthetic */ void bn(IPCVoid iPCVoid) {
                    AppMethodBeat.i(47031);
                    if (runnable != null) {
                        runnable.run();
                    }
                    AppMethodBeat.o(47031);
                }
            });
        }
        AppMethodBeat.o(47037);
    }

    /* access modifiers changed from: package-private */
    public static final class a implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCString iPCString, d<IPCVoid> dVar) {
            a.C0727a aVar;
            AppMethodBeat.i(47033);
            a aVar2 = a.mOf;
            String iPCString2 = iPCString.toString();
            if (!aVar2.mOg.containsKey(iPCString2)) {
                aVar = new a.C0727a((byte) 0);
                aVar2.mOg.put(iPCString2, aVar);
            } else {
                aVar = aVar2.mOg.get(iPCString2);
            }
            Class<?> aff = h.bWb().aff(iPCString2);
            Log.i("MicroMsg.KeepAliveServiceConnector", "bindKeepAliveService appBrandUIClassName:%s, serviceClass:%s", iPCString2, aff);
            if (aff != null) {
                Context context = MMApplicationContext.getContext();
                Intent intent = new Intent();
                intent.setClass(context, aff);
                Log.i("MicroMsg.KeepAliveServiceConnector", "bindKeepAliveService service:%s bindRet:%b", aff.getName(), Boolean.valueOf(context.bindService(intent, aVar.mOh, 1)));
            }
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(47033);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.appbrand.keepalive.b$b  reason: collision with other inner class name */
    public static final class C0728b implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid> {
        private C0728b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCString iPCString, d<IPCVoid> dVar) {
            AppMethodBeat.i(47034);
            a aVar = a.mOf;
            String iPCString2 = iPCString.toString();
            if (!aVar.mOg.containsKey(iPCString2)) {
                Log.w("MicroMsg.AppBrandKeepAliveMMSavior", "unbindKeepAliveService not had connector of %s", iPCString2);
                AppMethodBeat.o(47034);
                return;
            }
            try {
                MMApplicationContext.getContext().unbindService(aVar.mOg.get(iPCString2).mOh);
                AppMethodBeat.o(47034);
            } catch (Exception e2) {
                Log.e("MicroMsg.KeepAliveServiceConnector", "unbindKeepAliveService exp:%s", e2);
                AppMethodBeat.o(47034);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005c, code lost:
        com.tencent.mm.ipcinvoker.extension.XIPCInvoker.a(com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService.dkO, new com.tencent.mm.ipcinvoker.type.IPCString(r6.mOk), com.tencent.mm.plugin.appbrand.keepalive.b.a.class, null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.plugin.appbrand.keepalive.b r6, java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 117
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.keepalive.b.a(com.tencent.mm.plugin.appbrand.keepalive.b, java.lang.String):void");
    }

    static /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(47039);
        Log.i("MicroMsg.AppBrandKeepAliveManager", "stopKeepAlive");
        if (bVar.mOk == null) {
            Log.e("MicroMsg.AppBrandKeepAliveManager", "stopKeepAlive mAppBrandUIClass null");
            AppMethodBeat.o(47039);
            return;
        }
        synchronized (bVar) {
            try {
                if (!bVar.mOl) {
                    Log.i("MicroMsg.AppBrandKeepAliveManager", "stopKeepAlive: already no keep");
                    return;
                }
                bVar.mOl = false;
                XIPCInvoker.a(MainProcessIPCService.dkO, new IPCString(bVar.mOk), C0728b.class, null);
                AppMethodBeat.o(47039);
            } finally {
                AppMethodBeat.o(47039);
            }
        }
    }
}
