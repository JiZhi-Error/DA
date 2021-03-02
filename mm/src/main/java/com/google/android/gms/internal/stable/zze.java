package com.google.android.gms.internal.stable;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class zze {

    public static class zza implements BaseColumns {
        private static HashMap<Uri, zzh> zzagq = new HashMap<>();

        static {
            AppMethodBeat.i(5495);
            AppMethodBeat.o(5495);
        }

        private static zzh zza(ContentResolver contentResolver, Uri uri) {
            AppMethodBeat.i(5492);
            zzh zzh = zzagq.get(uri);
            if (zzh == null) {
                zzh = new zzh();
                zzagq.put(uri, zzh);
                contentResolver.registerContentObserver(uri, true, new zzf(null, zzh));
            } else if (zzh.zzagu.getAndSet(false)) {
                synchronized (zzh) {
                    try {
                        zzh.zzags.clear();
                        zzh.zzagt = new Object();
                    } finally {
                        AppMethodBeat.o(5492);
                    }
                }
            }
            return zzh;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r1 = r10.query(r11, new java.lang.String[]{"value"}, "name=?", new java.lang.String[]{r12}, null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0046, code lost:
            if (r1 == null) goto L_0x004e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004c, code lost:
            if (r1.moveToFirst() != false) goto L_0x0062;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004e, code lost:
            zza(r7, r8, r12, null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0052, code lost:
            if (r1 == null) goto L_0x0057;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0054, code lost:
            r1.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0057, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(5493);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0062, code lost:
            r0 = r1.getString(0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            zza(r7, r8, r12, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x006a, code lost:
            if (r1 == null) goto L_0x006f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x006c, code lost:
            r1.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x006f, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(5493);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0074, code lost:
            r1 = null;
            r0 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            new java.lang.StringBuilder("Can't get key ").append(r12).append(" from ").append(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x008c, code lost:
            if (r1 != null) goto L_0x008e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x008e, code lost:
            r1.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0092, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0093, code lost:
            r1 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0094, code lost:
            if (r1 != null) goto L_0x0096;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0096, code lost:
            r1.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0099, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(5493);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x009c, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x009d, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x00a0, code lost:
            r0 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
            return r0;
         */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x008e  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x0096  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected static java.lang.String zza(android.content.ContentResolver r10, android.net.Uri r11, java.lang.String r12) {
            /*
            // Method dump skipped, instructions count: 164
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.stable.zze.zza.zza(android.content.ContentResolver, android.net.Uri, java.lang.String):java.lang.String");
        }

        private static void zza(zzh zzh, Object obj, String str, String str2) {
            AppMethodBeat.i(5494);
            synchronized (zzh) {
                try {
                    if (obj == zzh.zzagt) {
                        zzh.zzags.put(str, str2);
                    }
                } finally {
                    AppMethodBeat.o(5494);
                }
            }
        }
    }
}
