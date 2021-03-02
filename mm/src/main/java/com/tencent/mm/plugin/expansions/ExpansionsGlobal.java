package com.tencent.mm.plugin.expansions;

import a.f;
import a.h;
import android.arch.a.c.a;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class ExpansionsGlobal {
    private static final byte[] rNt = new byte[0];
    private static volatile boolean rNu = a.isMainProcess();
    private static volatile boolean rNv = false;
    private static AtomicBoolean rNw = new AtomicBoolean(false);

    static {
        AppMethodBeat.i(152972);
        AppMethodBeat.o(152972);
    }

    public static class CP extends ContentProvider {
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

        public Bundle call(String str, String str2, final Bundle bundle) {
            AppMethodBeat.i(152971);
            if ("expansionsWait".equals(str)) {
                Log.i("MicroMsg.exp.ExpansionsGlobal", "cp receive remote expansions call, request");
                final AnonymousClass1 r0 = new a<Integer, Void>() {
                    /* class com.tencent.mm.plugin.expansions.ExpansionsGlobal.CP.AnonymousClass1 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
                        r0 = r7.getBinder("messenger");
                     */
                    @Override // android.arch.a.c.a
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final /* synthetic */ java.lang.Void apply(java.lang.Integer r4) {
                        /*
                            r3 = this;
                            r2 = 152968(0x25588, float:2.14354E-40)
                            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                            java.lang.Integer r4 = (java.lang.Integer) r4
                            android.os.Bundle r0 = r7
                            if (r0 == 0) goto L_0x001f
                            android.os.Bundle r0 = r7
                            java.lang.String r1 = "messenger"
                            android.os.IBinder r0 = r0.getBinder(r1)
                            if (r0 == 0) goto L_0x001f
                            com.tencent.mm.plugin.expansions.ExpansionsGlobal$CP$1$1 r1 = new com.tencent.mm.plugin.expansions.ExpansionsGlobal$CP$1$1
                            r1.<init>(r0, r4)
                            a.h.a(r1)
                        L_0x001f:
                            r0 = 0
                            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expansions.ExpansionsGlobal.CP.AnonymousClass1.apply(java.lang.Object):java.lang.Object");
                    }
                };
                h.a(new Callable<Void>() {
                    /* class com.tencent.mm.plugin.expansions.ExpansionsGlobal.CP.AnonymousClass3 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // java.util.concurrent.Callable
                    public final /* synthetic */ Void call() {
                        AppMethodBeat.i(152970);
                        AtomicInteger atomicInteger = new AtomicInteger(0);
                        while (!a.cMk()) {
                            Log.i("MicroMsg.exp.ExpansionsGlobal", "expansions not ready for global, just wait");
                            if (atomicInteger.getAndIncrement() >= 3) {
                                TimeoutException timeoutException = new TimeoutException("wait for global timeout");
                                AppMethodBeat.o(152970);
                                throw timeoutException;
                            }
                            Thread.sleep(1000);
                        }
                        a.cMl();
                        Log.i("MicroMsg.exp.ExpansionsGlobal", "expansions is ready");
                        r0.apply(1);
                        AppMethodBeat.o(152970);
                        return null;
                    }
                }).a(new f<Void, Void>() {
                    /* class com.tencent.mm.plugin.expansions.ExpansionsGlobal.CP.AnonymousClass2 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [a.h] */
                    @Override // a.f
                    public final /* synthetic */ Void a(h<Void> hVar) {
                        AppMethodBeat.i(152969);
                        if (hVar.nH()) {
                            Log.i("MicroMsg.exp.ExpansionsGlobal", "#isFaulted, request expansions fail");
                            r0.apply(2);
                        }
                        AppMethodBeat.o(152969);
                        return null;
                    }
                }, h.aBN);
            }
            AppMethodBeat.o(152971);
            return null;
        }
    }
}
