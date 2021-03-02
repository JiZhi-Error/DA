package com.tencent.thumbplayer.utils;

import android.content.Context;
import android.os.Process;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class a {
    private static Map<String, a> mInstanceMap = new HashMap();
    private C2211a Sfd;

    static {
        AppMethodBeat.i(189617);
        AppMethodBeat.o(189617);
    }

    public static a cW(Context context, String str) {
        AppMethodBeat.i(189608);
        a ab = ab(new File(context.getCacheDir(), str));
        AppMethodBeat.o(189608);
        return ab;
    }

    private static a ab(File file) {
        a aVar;
        AppMethodBeat.i(189609);
        a aVar2 = null;
        try {
            aVar2 = mInstanceMap.get(file.getAbsoluteFile() + myPid());
        } catch (Exception e2) {
        }
        if (aVar2 == null) {
            try {
                aVar = new a(file);
                try {
                    mInstanceMap.put(file.getAbsolutePath() + myPid(), aVar);
                } catch (Throwable th) {
                }
            } catch (Throwable th2) {
                aVar = aVar2;
            }
        } else {
            aVar = aVar2;
        }
        AppMethodBeat.o(189609);
        return aVar;
    }

    private static String myPid() {
        AppMethodBeat.i(189610);
        String str = "_" + Process.myPid();
        AppMethodBeat.o(189610);
        return str;
    }

    private a(File file) {
        AppMethodBeat.i(189611);
        if (file.exists() || file.mkdirs()) {
            this.Sfd = new C2211a(file, 50000000, Integer.MAX_VALUE, (byte) 0);
            AppMethodBeat.o(189611);
            return;
        }
        this.Sfd = null;
        AppMethodBeat.o(189611);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x006b A[SYNTHETIC, Splitter:B:28:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0077 A[SYNTHETIC, Splitter:B:34:0x0077] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] getAsBinary(java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 141
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.utils.a.getAsBinary(java.lang.String):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002a A[SYNTHETIC, Splitter:B:17:0x002a] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002f A[SYNTHETIC, Splitter:B:20:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003c A[SYNTHETIC, Splitter:B:26:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0041 A[SYNTHETIC, Splitter:B:29:0x0041] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getAsObject(java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 101
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.utils.a.getAsObject(java.lang.String):java.lang.Object");
    }

    public final boolean remove(String str) {
        AppMethodBeat.i(189615);
        if (this.Sfd == null) {
            AppMethodBeat.o(189615);
            return false;
        }
        boolean a2 = C2211a.a(this.Sfd, str);
        AppMethodBeat.o(189615);
        return a2;
    }

    public final void clear() {
        AppMethodBeat.i(189616);
        if (this.Sfd == null) {
            AppMethodBeat.o(189616);
            return;
        }
        this.Sfd.clear();
        AppMethodBeat.o(189616);
    }

    /* renamed from: com.tencent.thumbplayer.utils.a$a  reason: collision with other inner class name */
    public static class C2211a {
        final AtomicInteger cacheCount;
        protected File cacheDir;
        final AtomicLong cacheSize;
        private final int countLimit;
        final Map<File, Long> lastUsageDates;
        private final long sizeLimit;

        /* synthetic */ C2211a(File file, long j2, int i2, byte b2) {
            this(file, 50000000, Integer.MAX_VALUE);
        }

        static /* synthetic */ void a(C2211a aVar, File file) {
            AppMethodBeat.i(189603);
            aVar.put(file);
            AppMethodBeat.o(189603);
        }

        static /* synthetic */ boolean a(C2211a aVar, String str) {
            AppMethodBeat.i(189604);
            boolean remove = aVar.remove(str);
            AppMethodBeat.o(189604);
            return remove;
        }

        private C2211a(File file, long j2, int i2) {
            AppMethodBeat.i(189595);
            this.lastUsageDates = Collections.synchronizedMap(new HashMap());
            this.cacheDir = file;
            this.sizeLimit = j2;
            this.countLimit = i2;
            this.cacheSize = new AtomicLong();
            this.cacheCount = new AtomicInteger();
            j.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                /* class com.tencent.thumbplayer.utils.a.C2211a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(189594);
                    File[] listFiles = C2211a.this.cacheDir.listFiles();
                    if (listFiles != null) {
                        int length = listFiles.length;
                        int i2 = 0;
                        int i3 = 0;
                        int i4 = 0;
                        while (i2 < length) {
                            File file = listFiles[i2];
                            i4 = (int) (((long) i4) + C2211a.calculateSize(file));
                            C2211a.this.lastUsageDates.put(file, Long.valueOf(file.lastModified()));
                            i2++;
                            i3++;
                        }
                        C2211a.this.cacheSize.set((long) i4);
                        C2211a.this.cacheCount.set(i3);
                    }
                    AppMethodBeat.o(189594);
                }
            });
            AppMethodBeat.o(189595);
        }

        private void put(File file) {
            AppMethodBeat.i(189596);
            int i2 = this.cacheCount.get();
            while (i2 + 1 > this.countLimit) {
                this.cacheSize.addAndGet(-removeNext());
                i2 = this.cacheCount.addAndGet(-1);
            }
            this.cacheCount.addAndGet(1);
            long calculateSize = calculateSize(file);
            long j2 = this.cacheSize.get();
            while (j2 + calculateSize > this.sizeLimit) {
                j2 = this.cacheSize.addAndGet(-removeNext());
            }
            this.cacheSize.addAndGet(calculateSize);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            file.setLastModified(valueOf.longValue());
            this.lastUsageDates.put(file, valueOf);
            AppMethodBeat.o(189596);
        }

        /* access modifiers changed from: package-private */
        public final File get(String str) {
            AppMethodBeat.i(189597);
            File newFile = newFile(str);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            newFile.setLastModified(valueOf.longValue());
            this.lastUsageDates.put(newFile, valueOf);
            AppMethodBeat.o(189597);
            return newFile;
        }

        /* access modifiers changed from: package-private */
        public final File newFile(String str) {
            AppMethodBeat.i(189598);
            File file = new File(this.cacheDir, new StringBuilder().append(str.hashCode()).toString());
            AppMethodBeat.o(189598);
            return file;
        }

        private boolean remove(String str) {
            AppMethodBeat.i(189599);
            boolean delete = get(str).delete();
            AppMethodBeat.o(189599);
            return delete;
        }

        /* access modifiers changed from: package-private */
        public final void clear() {
            AppMethodBeat.i(189600);
            this.lastUsageDates.clear();
            this.cacheSize.set(0);
            File[] listFiles = this.cacheDir.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    file.delete();
                }
            }
            AppMethodBeat.o(189600);
        }

        private long removeNext() {
            File file;
            File file2;
            AppMethodBeat.i(189601);
            if (this.lastUsageDates.isEmpty()) {
                AppMethodBeat.o(189601);
                return 0;
            }
            Set<Map.Entry<File, Long>> entrySet = this.lastUsageDates.entrySet();
            synchronized (this.lastUsageDates) {
                try {
                    file = null;
                    Long l = null;
                    for (Map.Entry<File, Long> entry : entrySet) {
                        if (file == null) {
                            file = entry.getKey();
                            l = entry.getValue();
                        } else {
                            Long value = entry.getValue();
                            if (value.longValue() < l.longValue()) {
                                file2 = entry.getKey();
                            } else {
                                file2 = file;
                                value = l;
                            }
                            file = file2;
                            l = value;
                        }
                    }
                } finally {
                    AppMethodBeat.o(189601);
                }
            }
            if (file == null) {
                AppMethodBeat.o(189601);
                return 0;
            }
            long calculateSize = calculateSize(file);
            if (file != null && file.delete()) {
                this.lastUsageDates.remove(file);
            }
            return calculateSize;
        }

        static long calculateSize(File file) {
            AppMethodBeat.i(189602);
            if (file == null) {
                AppMethodBeat.o(189602);
                return 0;
            }
            long length = file.length();
            AppMethodBeat.o(189602);
            return length;
        }
    }

    /* access modifiers changed from: package-private */
    public static class b {
        static boolean hasDateInfo(byte[] bArr) {
            AppMethodBeat.i(189606);
            if (bArr == null || bArr.length <= 15 || bArr[13] != 45 || da(bArr) <= 14) {
                AppMethodBeat.o(189606);
                return false;
            }
            AppMethodBeat.o(189606);
            return true;
        }

        static int da(byte[] bArr) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                if (bArr[i2] == 32) {
                    return i2;
                }
            }
            return -1;
        }

        static byte[] copyOfRange(byte[] bArr, int i2, int i3) {
            AppMethodBeat.i(189607);
            int i4 = i3 - i2;
            if (i4 < 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(i2 + " > " + i3);
                AppMethodBeat.o(189607);
                throw illegalArgumentException;
            }
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, i2, bArr2, 0, Math.min(bArr.length - i2, i4));
            AppMethodBeat.o(189607);
            return bArr2;
        }

        static boolean isDue(byte[] bArr) {
            String[] strArr;
            AppMethodBeat.i(189605);
            if (hasDateInfo(bArr)) {
                strArr = new String[]{new String(copyOfRange(bArr, 0, 13)), new String(copyOfRange(bArr, 14, da(bArr)))};
            } else {
                strArr = null;
            }
            if (strArr != null) {
                String str = strArr[0];
                while (str.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    str = str.substring(1, str.length());
                }
                try {
                    if (System.currentTimeMillis() > Long.valueOf(str).longValue() + (Long.valueOf(strArr[1]).longValue() * 1000)) {
                        AppMethodBeat.o(189605);
                        return true;
                    }
                } catch (Exception e2) {
                    AppMethodBeat.o(189605);
                    return false;
                }
            }
            AppMethodBeat.o(189605);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0040 A[SYNTHETIC, Splitter:B:20:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0050 A[SYNTHETIC, Splitter:B:26:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005c A[SYNTHETIC, Splitter:B:32:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0071 A[SYNTHETIC, Splitter:B:38:0x0071] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x008b A[SYNTHETIC, Splitter:B:50:0x008b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void put(java.lang.String r8, java.io.Serializable r9) {
        /*
        // Method dump skipped, instructions count: 167
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.utils.a.put(java.lang.String, java.io.Serializable):void");
    }
}
