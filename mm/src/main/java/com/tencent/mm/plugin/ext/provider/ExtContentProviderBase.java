package com.tencent.mm.plugin.ext.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bu;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtContentProviderBase extends ContentProvider {
    protected static boolean pep = false;
    private static HashMap<String, Long> sNc = new HashMap<>();
    protected MatrixCursor pem = new MatrixCursor(new String[0]);
    private long sMX = Util.currentTicks();
    private String sMY;
    public String sMZ = "";
    private String[] sNa;
    private int sNb = 0;

    public ExtContentProviderBase() {
        AppMethodBeat.i(24405);
        AppMethodBeat.o(24405);
    }

    static {
        AppMethodBeat.i(24419);
        AppMethodBeat.o(24419);
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final void HF(int i2) {
        AppMethodBeat.i(24406);
        Log.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", cSt(), this.sMZ, Integer.valueOf(this.sNb), Integer.valueOf(i2), Integer.valueOf(cSs()));
        h.INSTANCE.a(10505, cSt(), this.sMZ, Integer.valueOf(this.sNb), Integer.valueOf(i2), Integer.valueOf(cSs()));
        AppMethodBeat.o(24406);
    }

    /* access modifiers changed from: protected */
    public final void fP(int i2, int i3) {
        AppMethodBeat.i(24407);
        Log.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", cSt(), this.sMZ, Integer.valueOf(this.sNb), Integer.valueOf(i2), Integer.valueOf(cSs()));
        h.INSTANCE.a(10505, cSt(), this.sMZ, Integer.valueOf(this.sNb), Integer.valueOf(i2), Integer.valueOf(cSs()), Integer.valueOf(i3));
        AppMethodBeat.o(24407);
    }

    /* access modifiers changed from: protected */
    public final void ac(int i2, int i3, int i4) {
        AppMethodBeat.i(24408);
        Log.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", cSt(), this.sMZ, Integer.valueOf(this.sNb), Integer.valueOf(i3), Integer.valueOf(cSs()));
        h.INSTANCE.a(10505, cSt(), this.sMZ, Integer.valueOf(this.sNb), Integer.valueOf(i3), Integer.valueOf(cSs()), Integer.valueOf(i4));
        h.INSTANCE.idkeyStat(300, (long) i2, 1, false);
        AppMethodBeat.o(24408);
    }

    private int cSs() {
        AppMethodBeat.i(24409);
        int ticksToNow = (int) Util.ticksToNow(this.sMX);
        AppMethodBeat.o(24409);
        return ticksToNow;
    }

    /* access modifiers changed from: protected */
    public final void a(Uri uri, Context context, UriMatcher uriMatcher) {
        AppMethodBeat.i(24410);
        this.sMZ = s(uri);
        ff(context);
        if (uriMatcher != null) {
            this.sNb = uriMatcher.match(uri);
            if (this.sNb < 0) {
                this.sNb = 0;
            }
        }
        this.sMX = Util.currentTicks();
        AppMethodBeat.o(24410);
    }

    /* access modifiers changed from: protected */
    public final void a(Uri uri, Context context, int i2) {
        AppMethodBeat.i(24411);
        this.sMZ = s(uri);
        ff(context);
        this.sNb = i2;
        this.sMX = Util.currentTicks();
        AppMethodBeat.o(24411);
    }

    /* access modifiers changed from: protected */
    public final void a(Uri uri, Context context, int i2, String[] strArr) {
        AppMethodBeat.i(24412);
        this.sMZ = s(uri);
        if (strArr == null) {
            ff(context);
        } else {
            this.sNa = strArr;
        }
        this.sNb = i2;
        this.sMX = Util.currentTicks();
        AppMethodBeat.o(24412);
    }

    public final String cSt() {
        AppMethodBeat.i(24413);
        if (!Util.isNullOrNil(this.sMY)) {
            String str = this.sMY;
            AppMethodBeat.o(24413);
            return str;
        } else if (this.sNa == null || this.sNa.length <= 0) {
            AppMethodBeat.o(24413);
            return "";
        } else {
            String str2 = this.sNa[0];
            AppMethodBeat.o(24413);
            return str2;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean ckf() {
        boolean z = false;
        AppMethodBeat.i(24414);
        try {
            Log.i("MicroMsg.ExtContentProviderBase", "checkIsLogin()");
            if (!pep) {
                final b bVar = new b();
                bVar.c(4000, new Runnable() {
                    /* class com.tencent.mm.plugin.ext.provider.ExtContentProviderBase.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(24404);
                        try {
                            if (!bg.aAc()) {
                                AppMethodBeat.o(24404);
                                return;
                            }
                            bg.azz().a(new bu(new bu.a() {
                                /* class com.tencent.mm.plugin.ext.provider.ExtContentProviderBase.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tencent.mm.model.bu.a
                                public final void a(g gVar) {
                                    AppMethodBeat.i(24403);
                                    Log.i("MicroMsg.ExtContentProviderBase", "checkIsLogin() onSceneEnd()");
                                    bVar.countDown();
                                    AppMethodBeat.o(24403);
                                }
                            }), 0);
                            AppMethodBeat.o(24404);
                        } catch (Exception e2) {
                            Log.e("MicroMsg.ExtContentProviderBase", "exception in NetSceneLocalProxy");
                            bVar.countDown();
                            AppMethodBeat.o(24404);
                        }
                    }
                });
            }
            if (!bg.aAc() || !bg.aVG() || bg.azj()) {
                pep = false;
            } else {
                pep = true;
            }
            Log.i("MicroMsg.ExtContentProviderBase", "hasLogin = " + pep);
            z = pep;
            AppMethodBeat.o(24414);
        } catch (Exception e2) {
            Log.w("MicroMsg.ExtContentProviderBase", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.ExtContentProviderBase", e2, "", new Object[0]);
            AppMethodBeat.o(24414);
        }
        return z;
    }

    private static String s(Uri uri) {
        AppMethodBeat.i(24415);
        if (uri == null) {
            AppMethodBeat.o(24415);
            return "";
        }
        String nullAsNil = Util.nullAsNil(uri.getQueryParameter("appid"));
        AppMethodBeat.o(24415);
        return nullAsNil;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00fb, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r11.sMY = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x010c, code lost:
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0162, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0163, code lost:
        r3 = r1;
        r0 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean fe(android.content.Context r12) {
        /*
        // Method dump skipped, instructions count: 367
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ext.provider.ExtContentProviderBase.fe(android.content.Context):boolean");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ee, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r11.sMY = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ff, code lost:
        r5 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0166, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0167, code lost:
        r2 = r1;
        r0 = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int cSu() {
        /*
        // Method dump skipped, instructions count: 371
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ext.provider.ExtContentProviderBase.cSu():int");
    }

    private void ff(Context context) {
        AppMethodBeat.i(24418);
        if (context == null) {
            Log.w("MicroMsg.ExtContentProviderBase", "in initCallerPkgName(), context == null");
            AppMethodBeat.o(24418);
            return;
        }
        Log.i("MicroMsg.ExtContentProviderBase", "Binder.getCallingUid() = " + Binder.getCallingUid());
        this.sNa = context.getPackageManager().getPackagesForUid(Binder.getCallingUid());
        if (this.sNa == null) {
            Log.w("MicroMsg.ExtContentProviderBase", "m_pkgs == null");
        }
        AppMethodBeat.o(24418);
    }
}
