package com.tencent.mm.plugin.appbrand.game.c;

import android.widget.Toast;
import com.tencent.magicbrush.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.game.a.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.udp.libmmudp.a;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.mm.websocket.libwcwss.a;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import org.apache.commons.a.e;

public class b {
    private static final ClassLoader lsd = b.class.getClassLoader();
    private static boolean lse = false;

    static {
        AppMethodBeat.i(45112);
        AppMethodBeat.o(45112);
    }

    public static void LW() {
        AppMethodBeat.i(45109);
        com.tencent.magicbrush.a.b.a(new b.a() {
            /* class com.tencent.mm.plugin.appbrand.game.c.b.AnonymousClass1 */

            @Override // com.tencent.magicbrush.a.b.a
            public final void loadLibrary(String str) {
                AppMethodBeat.i(45105);
                b.YK(str);
                AppMethodBeat.o(45105);
            }

            @Override // com.tencent.magicbrush.a.b.a
            public final String dZ(String str) {
                AppMethodBeat.i(226616);
                String dZ = j.dZ(str);
                AppMethodBeat.o(226616);
                return dZ;
            }
        });
        a.a(new a.AbstractC2070a() {
            /* class com.tencent.mm.plugin.appbrand.game.c.b.AnonymousClass2 */

            @Override // com.tencent.mm.udp.libmmudp.a.AbstractC2070a
            public final void loadLibrary(String str) {
                AppMethodBeat.i(45106);
                try {
                    Log.i("MicroMsg.WAGame.MBLoadDelegateRegistryWC", "loadLibrary libName:%s", str);
                    ClassLoader unused = b.lsd;
                    j.Ed(str);
                    AppMethodBeat.o(45106);
                } catch (UnsatisfiedLinkError e2) {
                    Log.printErrStackTrace("MicroMsg.WAGame.MBLoadDelegateRegistryWC", e2, "hy: link %s error!!", str);
                    com.tencent.mm.plugin.appbrand.game.h.b.showDialog(MMApplicationContext.getContext());
                    AppMethodBeat.o(45106);
                }
            }
        });
        com.tencent.mm.game.a.a.a(new a.AbstractC0345a() {
            /* class com.tencent.mm.plugin.appbrand.game.c.b.AnonymousClass3 */

            @Override // com.tencent.mm.game.a.a.AbstractC0345a
            public final void loadLibrary(String str) {
                AppMethodBeat.i(45107);
                try {
                    Log.i("MicroMsg.WAGame.MBLoadDelegateRegistryWC", "loadLibrary libName:%s", str);
                    ClassLoader unused = b.lsd;
                    j.Ed(str);
                    AppMethodBeat.o(45107);
                } catch (UnsatisfiedLinkError e2) {
                    Log.printErrStackTrace("MicroMsg.WAGame.MBLoadDelegateRegistryWC", e2, "hy: link %s error!!", str);
                    com.tencent.mm.plugin.appbrand.game.h.b.showDialog(MMApplicationContext.getContext());
                    AppMethodBeat.o(45107);
                }
            }
        });
        com.tencent.mm.websocket.libwcwss.a.a(new a.AbstractC2172a() {
            /* class com.tencent.mm.plugin.appbrand.game.c.b.AnonymousClass4 */

            @Override // com.tencent.mm.websocket.libwcwss.a.AbstractC2172a
            public final void loadLibrary(String str) {
                AppMethodBeat.i(45108);
                try {
                    Log.i("MicroMsg.WAGame.MBLoadDelegateRegistryWC", "loadLibrary libName:%s", str);
                    ClassLoader unused = b.lsd;
                    j.Ed(str);
                    AppMethodBeat.o(45108);
                } catch (UnsatisfiedLinkError e2) {
                    Log.printErrStackTrace("MicroMsg.WAGame.MBLoadDelegateRegistryWC", e2, "hy: link %s error!!", str);
                    com.tencent.mm.plugin.appbrand.game.h.b.showDialog(MMApplicationContext.getContext());
                    AppMethodBeat.o(45108);
                }
            }
        });
        AppMethodBeat.o(45109);
    }

    private static o di(String str, String str2) {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        AppMethodBeat.i(174727);
        o X = o.X(MMApplicationContext.getContext().getDir("magicbrush", 0));
        if (X.exists() || X.mkdirs()) {
            o oVar = new o(X, str);
            try {
                bufferedInputStream = new BufferedInputStream(s.openRead(str2));
                try {
                    bufferedOutputStream = new BufferedOutputStream(s.ap(oVar));
                    try {
                        e.copy(bufferedInputStream, bufferedOutputStream);
                        e.W(bufferedInputStream);
                        e.e(bufferedOutputStream);
                        AppMethodBeat.o(174727);
                        return oVar;
                    } catch (Throwable th2) {
                        th = th2;
                        e.W(bufferedInputStream);
                        e.e(bufferedOutputStream);
                        AppMethodBeat.o(174727);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = null;
                    e.W(bufferedInputStream);
                    e.e(bufferedOutputStream);
                    AppMethodBeat.o(174727);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream = null;
                bufferedInputStream = null;
                e.W(bufferedInputStream);
                e.e(bufferedOutputStream);
                AppMethodBeat.o(174727);
                throw th;
            }
        } else {
            IllegalStateException illegalStateException = new IllegalStateException();
            AppMethodBeat.o(174727);
            throw illegalStateException;
        }
    }

    static /* synthetic */ void YK(String str) {
        boolean z;
        String concat;
        AppMethodBeat.i(45111);
        if ((!BuildInfo.IS_FLAVOR_RED && !BuildInfo.DEBUG && !WeChatEnvironment.hasDebugger()) || !"magicbrush".equals(str) || !((Boolean) com.tencent.mm.plugin.appbrand.game.a.j.YI("localso").aLT()).booleanValue()) {
            try {
                Log.i("MicroMsg.WAGame.MBLoadDelegateRegistryWC", "loadLibrary libName:%s", str);
                long currentTicks = Util.currentTicks();
                j.Ed(str);
                Log.i("MicroMsg.WAGame.MBLoadDelegateRegistryWC", "hy: loading library %s using %d ms", str, Long.valueOf(Util.ticksToNow(currentTicks)));
                AppMethodBeat.o(45111);
            } catch (UnsatisfiedLinkError e2) {
                Log.printErrStackTrace("MicroMsg.WAGame.MBLoadDelegateRegistryWC", e2, "hy: link %s error!!", str);
                com.tencent.mm.plugin.appbrand.game.h.b.showDialog(MMApplicationContext.getContext());
                AppMethodBeat.o(45111);
            }
        } else if (lse) {
            Log.i("MicroMsg.WAGame.MBLoadDelegateRegistryWC", "load custom local so libName: %s, skip", "magicbrush");
            AppMethodBeat.o(45111);
        } else {
            lse = true;
            try {
                Log.i("MicroMsg.WAGame.MBLoadDelegateRegistryWC", "load custom local so libName: %s", "magicbrush");
                String str2 = ShareConstants.SO_PATH + "magicbrush" + ".so";
                System.load(aa.z(di(str2, "/sdcard/magicbrush/".concat(String.valueOf(str2))).her()));
                z = true;
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.WAGame.MBLoadDelegateRegistryWC", e3, "load local so failed", new Object[0]);
                z = false;
            }
            if (z) {
                concat = "local so succeed: ".concat(String.valueOf("magicbrush"));
            } else {
                concat = "local so failed: ".concat(String.valueOf("magicbrush"));
            }
            Toast.makeText(MMApplicationContext.getContext(), concat, 0).show();
            AppMethodBeat.o(45111);
        }
    }
}
