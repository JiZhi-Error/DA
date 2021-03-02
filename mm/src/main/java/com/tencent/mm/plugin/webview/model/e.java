package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import java.util.LinkedList;
import java.util.List;

public final class e {
    private static List<e.a> IXx = new LinkedList();

    public interface a {
        void pI(boolean z);
    }

    static /* synthetic */ Bitmap bV(Context context, String str) {
        AppMethodBeat.i(78853);
        Bitmap bT = bT(context, str);
        AppMethodBeat.o(78853);
        return bT;
    }

    static {
        AppMethodBeat.i(78854);
        AppMethodBeat.o(78854);
    }

    public static void a(final Context context, final String str, final String str2, final a aVar) {
        AppMethodBeat.i(78845);
        if (context == null || Util.isNullOrNil(str)) {
            Log.e("MicroMsg.WebviewShrotcutManager", "context or username is null");
            if (aVar != null) {
                aVar.pI(false);
            }
            AppMethodBeat.o(78845);
            return;
        }
        Log.d("MicroMsg.WebviewShrotcutManager", "addShortcut, username = %s", str);
        if (!g.aAc()) {
            Log.e("MicroMsg.WebviewShrotcutManager", "acc not ready");
            if (aVar != null) {
                aVar.pI(false);
            }
            AppMethodBeat.o(78845);
            return;
        }
        as Kn = ((l) g.af(l.class)).aSN().Kn(str);
        String str3 = "";
        if (Kn != null) {
            str3 = Kn.arI();
        }
        if (Util.isNullOrNil(str3)) {
            Log.e("MicroMsg.WebviewShrotcutManager", "displayname is nil, should pull from service");
            ay.a.iDq.a(str, "", new ay.b.a() {
                /* class com.tencent.mm.plugin.webview.model.e.AnonymousClass1 */

                @Override // com.tencent.mm.model.ay.b.a
                public final void p(String str, boolean z) {
                    AppMethodBeat.i(78841);
                    Log.i("MicroMsg.WebviewShrotcutManager", "getContactCallBack, suc = %b", Boolean.valueOf(z));
                    if (z) {
                        as Kn = ((l) g.af(l.class)).aSN().Kn(str);
                        if (Kn != null && !Util.isNullOrNil(Kn.arI())) {
                            e.a(context, str, str2, Kn.arI(), aVar);
                        } else if (aVar != null) {
                            aVar.pI(false);
                            AppMethodBeat.o(78841);
                            return;
                        }
                    } else if (aVar != null) {
                        aVar.pI(false);
                        AppMethodBeat.o(78841);
                        return;
                    }
                    AppMethodBeat.o(78841);
                }
            });
            AppMethodBeat.o(78845);
            return;
        }
        a(context, str, str2, str3, aVar);
        AppMethodBeat.o(78845);
    }

    public static void a(final Context context, final String str, final String str2, final String str3, final a aVar) {
        AppMethodBeat.i(78846);
        if (bU(context, str3)) {
            Log.i("MicroMsg.WebviewShrotcutManager", "shortcut has exist");
            if (aVar != null) {
                aVar.pI(true);
            }
            AppMethodBeat.o(78846);
            return;
        }
        final AnonymousClass2 r0 = new e.a() {
            /* class com.tencent.mm.plugin.webview.model.e.AnonymousClass2 */

            @Override // com.tencent.mm.aj.e.a
            public final void Mr(String str) {
                AppMethodBeat.i(78842);
                if (!str.equals(str)) {
                    AppMethodBeat.o(78842);
                    return;
                }
                Log.i("MicroMsg.WebviewShrotcutManager", "notifyChanged avatar(%s).", str);
                e.IXx.remove(this);
                p.aYn().b(this);
                Bitmap bV = e.bV(context, str);
                if (bV != null && !bV.isRecycled()) {
                    Intent a2 = e.a(context, str, str2, str3, bV, true);
                    if (a2 == null) {
                        Log.e("MicroMsg.WebviewShrotcutManager", "intent is null");
                        if (aVar != null) {
                            aVar.pI(false);
                            AppMethodBeat.o(78842);
                            return;
                        }
                    } else {
                        com.tencent.mm.plugin.base.model.b.p(context, a2);
                        if (aVar != null) {
                            aVar.pI(true);
                        }
                    }
                } else if (aVar != null) {
                    aVar.pI(false);
                    AppMethodBeat.o(78842);
                    return;
                }
                AppMethodBeat.o(78842);
            }
        };
        IXx.add(r0);
        p.aYn().a(r0);
        Bitmap bT = bT(context, str);
        if (bT == null || bT.isRecycled()) {
            Log.e("MicroMsg.WebviewShrotcutManager", "getAvatarBitmap fail, bmp is null, start timer.");
            new MTimerHandler(new b(new Runnable() {
                /* class com.tencent.mm.plugin.webview.model.e.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(78843);
                    Log.i("MicroMsg.WebviewShrotcutManager", "expired");
                    if (e.IXx.contains(r0)) {
                        e.IXx.remove(r0);
                        p.aYn().b(r0);
                        if (aVar != null) {
                            aVar.pI(false);
                        }
                    }
                    AppMethodBeat.o(78843);
                }
            }), false).startTimer(5000);
            AppMethodBeat.o(78846);
            return;
        }
        IXx.remove(r0);
        p.aYn().b(r0);
        Intent a2 = a(context, str, str2, str3, bT, true);
        if (a2 == null) {
            Log.e("MicroMsg.WebviewShrotcutManager", "intent is null");
            if (aVar != null) {
                aVar.pI(false);
            }
            AppMethodBeat.o(78846);
            return;
        }
        com.tencent.mm.plugin.base.model.b.p(context, a2);
        if (aVar != null) {
            aVar.pI(true);
        }
        AppMethodBeat.o(78846);
    }

    public static void g(Context context, String str, String str2, String str3) {
        AppMethodBeat.i(78848);
        if (context == null || Util.isNullOrNil(str3)) {
            Log.e("MicroMsg.WebviewShrotcutManager", "remove failed, invalid params");
        }
        Intent a2 = a(context, str, str2, str3, null, false);
        if (a2 == null) {
            Log.e("MicroMsg.WebviewShrotcutManager", "remove failed, intent is null");
            AppMethodBeat.o(78848);
            return;
        }
        com.tencent.mm.plugin.base.model.b.q(context, a2);
        AppMethodBeat.o(78848);
    }

    public static Intent a(Context context, String str, String str2, String str3, Bitmap bitmap, boolean z) {
        AppMethodBeat.i(78849);
        Log.i("MicroMsg.WebviewShrotcutManager", "buildIntent, install = %b", Boolean.valueOf(z));
        if (bitmap != null || !z) {
            String aYD = aYD(str);
            if (Util.isNullOrNil(aYD)) {
                AppMethodBeat.o(78849);
                return null;
            }
            Intent intent = new Intent(z ? "com.android.launcher.action.INSTALL_SHORTCUT" : "com.android.launcher.action.UNINSTALL_SHORTCUT");
            intent.putExtra("android.intent.extra.shortcut.NAME", str3);
            intent.putExtra("duplicate", false);
            String str4 = "";
            i Mx = p.aYB().Mx(str);
            if (Mx != null) {
                str4 = com.tencent.mm.b.g.getMessageDigest((str3 + Mx.aYu()).getBytes());
            }
            Intent intent2 = new Intent("com.tencent.mm.action.WX_SHORTCUT");
            intent2.putExtra("type", 2);
            intent2.putExtra("id", aYD);
            intent2.putExtra("ext_info", aYD(str2));
            intent2.putExtra("ext_info_1", aYD(str3));
            StringBuilder sb = new StringBuilder();
            g.aAf();
            intent2.putExtra("token", eY(str2, sb.append(com.tencent.mm.kernel.a.getUin()).toString()));
            intent2.putExtra("digest", str4);
            intent2.setPackage(context.getPackageName());
            intent2.addFlags(67108864);
            intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
            intent.putExtra("android.intent.extra.shortcut.ICON", bitmap);
            AppMethodBeat.o(78849);
            return intent;
        }
        Log.e("MicroMsg.WebviewShrotcutManager", "no bmp");
        AppMethodBeat.o(78849);
        return null;
    }

    private static String aYD(String str) {
        AppMethodBeat.i(78850);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(78850);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        g.aAf();
        String eW = com.tencent.mm.plugin.base.model.b.eW(str, sb.append(com.tencent.mm.kernel.a.getUin()).append("_").append(System.currentTimeMillis()).toString());
        if (Util.isNullOrNil(eW)) {
            AppMethodBeat.o(78850);
            return null;
        }
        String str2 = "shortcut_" + com.tencent.mm.plugin.base.model.b.toHexString(eW.getBytes());
        AppMethodBeat.o(78850);
        return str2;
    }

    public static String eY(String str, String str2) {
        AppMethodBeat.i(78851);
        String messageDigest = com.tencent.mm.b.g.getMessageDigest((com.tencent.mm.b.g.getMessageDigest(str.getBytes()) + com.tencent.mm.plugin.base.model.b.eW(str2, str)).getBytes());
        AppMethodBeat.o(78851);
        return messageDigest;
    }

    /* access modifiers changed from: package-private */
    public static class b implements MTimerHandler.CallBack {
        private Runnable dQN;

        b(Runnable runnable) {
            this.dQN = runnable;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(78844);
            if (this.dQN != null) {
                this.dQN.run();
            }
            AppMethodBeat.o(78844);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x007e A[Catch:{ Exception -> 0x00a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean bU(android.content.Context r12, java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 169
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.model.e.bU(android.content.Context, java.lang.String):boolean");
    }

    private static Bitmap bT(Context context, String str) {
        AppMethodBeat.i(78847);
        Bitmap a2 = c.a(str, false, -1, null);
        if (a2 == null || a2.isRecycled()) {
            AppMethodBeat.o(78847);
            return a2;
        }
        int i2 = (int) (context.getResources().getDisplayMetrics().density * 48.0f);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a2, i2, i2, false);
        AppMethodBeat.o(78847);
        return createScaledBitmap;
    }
}
