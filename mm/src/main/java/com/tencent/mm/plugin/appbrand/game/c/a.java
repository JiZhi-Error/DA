package com.tencent.mm.plugin.appbrand.game.c;

import android.graphics.drawable.Drawable;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a.a;
import com.tencent.magicbrush.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.c;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends com.tencent.luggage.game.b.a {
    public static final a lsc = new a();

    static {
        AppMethodBeat.i(45104);
        AppMethodBeat.o(45104);
    }

    @Override // com.tencent.luggage.game.b.a
    public final void a(MBRuntime mBRuntime, AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(45103);
        super.a(mBRuntime, appBrandRuntime);
        com.tencent.magicbrush.a.a.a(new C0584a((byte) 0));
        com.tencent.magicbrush.handler.glfont.a.a(new b());
        AppMethodBeat.o(45103);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.appbrand.game.c.a$a  reason: collision with other inner class name */
    public static final class C0584a implements a.AbstractC0192a {
        private C0584a() {
        }

        /* synthetic */ C0584a(byte b2) {
            this();
        }

        @Override // com.tencent.magicbrush.a.a.AbstractC0192a
        public final int q(String str, int i2) {
            AppMethodBeat.i(45099);
            int a2 = a(str, i2, null);
            AppMethodBeat.o(45099);
            return a2;
        }

        @Override // com.tencent.magicbrush.a.a.AbstractC0192a
        public final Drawable r(String str, int i2) {
            AppMethodBeat.i(45100);
            i iVar = new i();
            a(str, i2, iVar);
            Drawable a2 = com.tencent.mm.ce.b.gxI().a(iVar.value, true);
            AppMethodBeat.o(45100);
            return a2;
        }

        private static int a(String str, int i2, i<c> iVar) {
            int i3;
            int i4;
            AppMethodBeat.i(45101);
            if (str == null || i2 < 0 || i2 >= str.length()) {
                AppMethodBeat.o(45101);
                return 0;
            }
            int codePointAt = str.codePointAt(i2);
            T t = (T) com.tencent.mm.ce.b.gxI().ajN(codePointAt);
            if (t != null) {
                if (iVar != null) {
                    iVar.value = t;
                }
                int charCount = Character.charCount(codePointAt);
                AppMethodBeat.o(45101);
                return charCount;
            }
            int charCount2 = i2 + Character.charCount(codePointAt);
            if (charCount2 < str.length()) {
                i3 = str.codePointAt(charCount2);
            } else {
                i3 = 0;
            }
            T t2 = (T) com.tencent.mm.ce.b.gxI().kK(codePointAt, i3);
            if (t2 == null) {
                AppMethodBeat.o(45101);
                return 0;
            }
            if (t2.owI != 0) {
                i4 = Character.charCount(i3) + charCount2;
            } else {
                i4 = charCount2;
            }
            if (iVar != null) {
                iVar.value = t2;
            }
            int i5 = i4 - i2;
            AppMethodBeat.o(45101);
            return i5;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b implements d.a {
        private int cuC;

        public b() {
            this.cuC = -1;
            this.cuC = bf.CTRL_INDEX;
        }

        @Override // com.tencent.magicbrush.a.d.a
        public final void ik(int i2) {
            AppMethodBeat.i(45102);
            Log.i("MicroMsg.MBFontManagerRegistryWC", "mbfont idkey logid:" + this.cuC + ",key:" + i2);
            h.INSTANCE.dN(this.cuC, i2);
            AppMethodBeat.o(45102);
        }
    }
}
