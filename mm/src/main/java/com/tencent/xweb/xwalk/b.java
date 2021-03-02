package com.tencent.xweb.xwalk;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;

public final class b {
    private static final String[] SFL = {"_id"};
    private final Object SFM = new Object();
    SQLiteDatabase mDatabase;
    private boolean mInitialized;

    public static b db(final Context context, final String str) {
        AppMethodBeat.i(207245);
        b bVar = new b();
        new Thread(bVar) {
            /* class com.tencent.xweb.xwalk.b.AnonymousClass1 */
            final /* synthetic */ b SFN;

            {
                this.SFN = r1;
            }

            public final void run() {
                AppMethodBeat.i(207244);
                b.a(this.SFN, context, str);
                AppMethodBeat.o(207244);
            }
        }.start();
        AppMethodBeat.o(207245);
        return bVar;
    }

    private b() {
        AppMethodBeat.i(207246);
        AppMethodBeat.o(207246);
    }

    /* access modifiers changed from: package-private */
    public final boolean huL() {
        AppMethodBeat.i(207247);
        synchronized (this.SFM) {
            while (!this.mInitialized) {
                try {
                    try {
                        this.SFM.wait();
                    } catch (InterruptedException e2) {
                        Log.e("HttpAuthDatabase", "Caught exception while checking initialization", e2);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(207247);
                    throw th;
                }
            }
        }
        if (this.mDatabase != null) {
            AppMethodBeat.o(207247);
            return true;
        }
        AppMethodBeat.o(207247);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String[] getHttpAuthUsernamePassword(java.lang.String r11, java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 144
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.xwalk.b.getHttpAuthUsernamePassword(java.lang.String, java.lang.String):java.lang.String[]");
    }

    static /* synthetic */ void a(b bVar, Context context, String str) {
        AppMethodBeat.i(207249);
        synchronized (bVar.SFM) {
            try {
                if (!bVar.mInitialized) {
                    try {
                        bVar.mDatabase = context.openOrCreateDatabase(str, 0, null);
                    } catch (SQLiteException e2) {
                        if (context.deleteDatabase(str)) {
                            bVar.mDatabase = context.openOrCreateDatabase(str, 0, null);
                        }
                    }
                    if (bVar.mDatabase == null) {
                        Log.e("HttpAuthDatabase", "Unable to open or create ".concat(String.valueOf(str)));
                    } else if (bVar.mDatabase.getVersion() != 1) {
                        bVar.mDatabase.beginTransactionNonExclusive();
                        try {
                            bVar.mDatabase.execSQL("CREATE TABLE httpauth (_id INTEGER PRIMARY KEY, host TEXT, realm TEXT, username TEXT, password TEXT, UNIQUE (host, realm) ON CONFLICT REPLACE);");
                            bVar.mDatabase.setVersion(1);
                            bVar.mDatabase.setTransactionSuccessful();
                            bVar.mDatabase.endTransaction();
                        } catch (Throwable th) {
                            bVar.mDatabase.endTransaction();
                            AppMethodBeat.o(207249);
                            throw th;
                        }
                    }
                    bVar.mInitialized = true;
                    bVar.SFM.notifyAll();
                    AppMethodBeat.o(207249);
                }
            } finally {
                AppMethodBeat.o(207249);
            }
        }
    }
}
