package com.tencent.luggage.game.b;

import android.graphics.Typeface;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.glfont.b;
import com.tencent.magicbrush.handler.glfont.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.lang.ref.WeakReference;

public class a {
    public static final a cus = new a();

    static {
        AppMethodBeat.i(130461);
        AppMethodBeat.o(130461);
    }

    protected a() {
    }

    public void a(MBRuntime mBRuntime, AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(130460);
        final WeakReference weakReference = new WeakReference(appBrandRuntime);
        i iVar = (i) mBRuntime.Rh();
        AnonymousClass1 r2 = new b() {
            /* class com.tencent.luggage.game.b.a.AnonymousClass1 */

            @Override // com.tencent.magicbrush.handler.glfont.b
            public final Typeface dg(String str) {
                Typeface typeface = null;
                AppMethodBeat.i(130456);
                Log.i("MBFontManagerRegistry", "loadFont at path[%s]", str);
                if (str == null || str.length() == 0) {
                    AppMethodBeat.o(130456);
                } else {
                    try {
                        typeface = Typeface.createFromFile(str);
                    } catch (Exception e2) {
                        Log.e("MBFontManagerRegistry", "Create typeface from file failed. fontPath = [%s]", str);
                    }
                    AppMethodBeat.o(130456);
                }
                return typeface;
            }

            @Override // com.tencent.magicbrush.handler.glfont.b
            public final String dl(String str) {
                String b2;
                AppMethodBeat.i(130457);
                Log.i("MBFontManagerRegistry", "getFontPath at path[%s]", str);
                if (str == null || str.length() == 0) {
                    AppMethodBeat.o(130457);
                    return null;
                }
                AppBrandRuntime appBrandRuntime = (AppBrandRuntime) weakReference.get();
                if (appBrandRuntime == null) {
                    Log.e("MBFontManagerRegistry", "hy: runtime released");
                    AppMethodBeat.o(130457);
                    return null;
                }
                if (str.startsWith("wxfile://")) {
                    b2 = a(appBrandRuntime, str);
                } else {
                    b2 = b(appBrandRuntime, str);
                }
                if (b2 == null) {
                    AppMethodBeat.o(130457);
                    return null;
                }
                AppMethodBeat.o(130457);
                return b2;
            }

            private static String a(AppBrandRuntime appBrandRuntime, String str) {
                AppMethodBeat.i(130458);
                String str2 = null;
                try {
                    o VY = appBrandRuntime.getFileSystem().VY(str);
                    if (VY != null) {
                        str2 = aa.z(VY.her());
                    } else {
                        Log.e("MBFontManagerRegistry", "Read [%s] from filesystem failed, no file", str);
                    }
                } catch (Exception e2) {
                    Log.e("MBFontManagerRegistry", "Read [%s] from filesystem failed", str);
                }
                AppMethodBeat.o(130458);
                return str2;
            }

            private static String b(AppBrandRuntime appBrandRuntime, String str) {
                AppMethodBeat.i(130459);
                String str2 = null;
                try {
                    str2 = bg.h(appBrandRuntime, str);
                } catch (Exception e2) {
                    Log.e("MBFontManagerRegistry", "Read [%s] from WxaPkgRuntimeReader failed", str);
                }
                AppMethodBeat.o(130459);
                return str2;
            }
        };
        iVar.cMZ = r2;
        if (iVar.cNs != null) {
            iVar.cNs.cMZ = r2;
        }
        AppMethodBeat.o(130460);
    }
}
