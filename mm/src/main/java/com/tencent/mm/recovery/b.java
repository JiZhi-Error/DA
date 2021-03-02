package com.tencent.mm.recovery;

import android.content.Context;
import android.support.v4.e.c;
import android.text.TextUtils;
import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expansions.a;
import com.tencent.mm.plugin.hp.net.b;
import com.tencent.mm.plugin.hp.net.e;
import com.tencent.mm.protocal.protobuf.cxv;
import com.tencent.mm.recoveryv2.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.toolkit.a.g;
import com.tencent.recovery.ConstantsRecovery;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {
    public static void b(final Context context, final c<Integer> cVar) {
        AppMethodBeat.i(193902);
        f.i("MicroMsg.recovery.operator", "#fetchTinkerPatch");
        a.cMr();
        a.aoa(Mars.libMarsHttp);
        AnonymousClass2 r0 = new c<Integer>() {
            /* class com.tencent.mm.recovery.b.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.support.v4.e.c
            public final /* synthetic */ void accept(Integer num) {
                AppMethodBeat.i(193897);
                Integer num2 = num;
                if (b.uF(num2.intValue())) {
                    Context context = context;
                    c cVar = cVar;
                    f.i("MicroMsg.recovery.operatorFallback", "#fetchTinkerPatch");
                    String aKw = com.tencent.mm.loader.j.a.aKw();
                    Log.i("MicroMsg.recovery.operatorFallback", "baseTinkerId = ".concat(String.valueOf(aKw)));
                    cxv cxv = new cxv();
                    cxv.MCI = aKw;
                    cxv.APx = com.tencent.mm.loader.j.a.aKx();
                    cxv.MCJ = e.dZe();
                    cxv.MCJ.add(e.ih("biz-scene", ConstantsRecovery.RECOVERY_CONF_NAME));
                    cxv.MCL = 1;
                    com.tencent.mm.recovery.a.c.a(context, cxv, cVar, true);
                    AppMethodBeat.o(193897);
                    return;
                }
                cVar.accept(num2);
                AppMethodBeat.o(193897);
            }
        };
        String aKw = com.tencent.mm.loader.j.a.aKw();
        Log.i("MicroMsg.recovery.operator", "baseTinkerId = ".concat(String.valueOf(aKw)));
        cxv cxv = new cxv();
        cxv.MCI = aKw;
        cxv.APx = com.tencent.mm.loader.j.a.aKx();
        cxv.MCJ = com.tencent.mm.recovery.a.b.dZe();
        cxv.MCJ.add(com.tencent.mm.recovery.a.b.ih("biz-scene", ConstantsRecovery.RECOVERY_CONF_NAME));
        cxv.MCL = 1;
        a(context, cxv, r0, true);
        AppMethodBeat.o(193902);
    }

    public static void a(final Context context, cxv cxv, final c<Integer> cVar, final boolean z) {
        AppMethodBeat.i(193903);
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        com.tencent.mm.recovery.a.a aVar = new com.tencent.mm.recovery.a.a(cxv);
        f.i("MicroMsg.recovery.operator", "NetSceneBaseMMTLSCheckCopycat#doSceneSync()");
        aVar.a(new b.a() {
            /* class com.tencent.mm.recovery.b.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.hp.net.b.a
            public final void a(int i2, com.tencent.mm.plugin.hp.d.b bVar) {
                AppMethodBeat.i(193899);
                f.i("MicroMsg.recovery.operator", "onCheckEnd, error = " + i2 + ", response = " + bVar);
                if (i2 == 0 || i2 == -5) {
                    f.i("MicroMsg.recovery.operator", "fetchTinkerPatch cgi rsp successful");
                    if (i2 == -5 || bVar == null || TextUtils.isEmpty(bVar.pkK)) {
                        atomicInteger.set(1);
                        cVar.accept(Integer.valueOf(atomicInteger.get()));
                        AppMethodBeat.o(193899);
                        return;
                    }
                    b.a(context, bVar.pkK, (long) Math.max(bVar.fileSize, 0), bVar.pkL, cVar, z);
                    AppMethodBeat.o(193899);
                    return;
                }
                f.w("MicroMsg.recovery.operator", "fetchTinkerPatch cgi rsp error, abort");
                atomicInteger.set(Math.abs(i2) + 20);
                cVar.accept(Integer.valueOf(atomicInteger.get()));
                AppMethodBeat.o(193899);
            }
        });
        AppMethodBeat.o(193903);
    }

    public static void a(Context context, String str, c<Integer> cVar) {
        AppMethodBeat.i(193904);
        a(context, str, 0, null, cVar, true);
        AppMethodBeat.o(193904);
    }

    public static void a(final Context context, String str, long j2, String str2, final c<Integer> cVar, final boolean z) {
        AppMethodBeat.i(193905);
        f.i("MicroMsg.recovery.operator", "#downloadTinkerPatch, file size = " + j2 + ", url = " + str);
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        com.tencent.mm.toolkit.a.c T = new com.tencent.mm.toolkit.a.c(str).T(new File(context.getCacheDir(), "recovery/tinker_path_file_" + System.currentTimeMillis()));
        T.OvC = new com.tencent.mm.toolkit.a.a.b() {
            /* class com.tencent.mm.recovery.b.AnonymousClass5 */

            @Override // com.tencent.mm.toolkit.a.a.b
            public final void df(int i2, String str) {
                AppMethodBeat.i(193901);
                f.w("MicroMsg.recovery.operator", "#onFailed, code = " + i2 + ", msg = " + str);
                int i3 = 2;
                if (i2 == 1001) {
                    i3 = 3;
                } else if (i2 >= 1101 && i2 <= 1106) {
                    i3 = (i2 - 1101) + 4;
                }
                atomicInteger.set(i3);
                cVar.accept(Integer.valueOf(atomicInteger.get()));
                AppMethodBeat.o(193901);
            }

            @Override // com.tencent.mm.toolkit.a.a.b
            public final void a(com.tencent.mm.toolkit.a.c cVar) {
                AppMethodBeat.i(193900);
                File file = cVar.Ovr;
                f.i("MicroMsg.recovery.operator", "#onComplete, file = ".concat(String.valueOf(file)));
                f.i("MicroMsg.recovery.operator", "download tinker path success");
                if (file.exists()) {
                    atomicInteger.set(0);
                    if (z) {
                        com.tencent.tinker.lib.e.c.cY(context, file.getAbsolutePath());
                    }
                    cVar.accept(Integer.valueOf(atomicInteger.get()));
                    AppMethodBeat.o(193900);
                    return;
                }
                atomicInteger.set(2);
                cVar.accept(Integer.valueOf(atomicInteger.get()));
                AppMethodBeat.o(193900);
            }
        };
        if (j2 > 0) {
            T.mContentLength = j2;
        }
        if (!TextUtils.isEmpty(str2)) {
            T.OvA = new com.tencent.mm.toolkit.a.f(str2);
        }
        f.i("MicroMsg.recovery.operator", "#downloadTinkerPatch start sync downloading");
        new g().jG(context).e(T);
        AppMethodBeat.o(193905);
    }

    static /* synthetic */ boolean uF(int i2) {
        return i2 > 20;
    }
}
