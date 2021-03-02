package com.tencent.thumbplayer.core.thirdparties;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Process;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPThreadUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

public class LocalCache {
    private static final int MAX_COUNT = Integer.MAX_VALUE;
    private static final int MAX_SIZE = 50000000;
    public static final int TIME_DAY = 86400;
    public static final int TIME_HOUR = 3600;
    private static Map<String, LocalCache> mInstanceMap = new HashMap();
    private ACacheManager mCache;

    static {
        AppMethodBeat.i(190073);
        AppMethodBeat.o(190073);
    }

    public static LocalCache get(Context context) {
        AppMethodBeat.i(190042);
        LocalCache localCache = get(context, "LocalCache");
        AppMethodBeat.o(190042);
        return localCache;
    }

    public static LocalCache get(Context context, String str) {
        AppMethodBeat.i(190043);
        LocalCache localCache = get(new File(context.getCacheDir(), str), 50000000, Integer.MAX_VALUE);
        AppMethodBeat.o(190043);
        return localCache;
    }

    public static LocalCache get(File file) {
        AppMethodBeat.i(190044);
        LocalCache localCache = get(file, 50000000, Integer.MAX_VALUE);
        AppMethodBeat.o(190044);
        return localCache;
    }

    public static LocalCache get(Context context, long j2, int i2) {
        AppMethodBeat.i(190045);
        LocalCache localCache = get(new File(context.getCacheDir(), "LocalCache"), j2, i2);
        AppMethodBeat.o(190045);
        return localCache;
    }

    public static LocalCache get(File file, long j2, int i2) {
        LocalCache localCache;
        AppMethodBeat.i(190046);
        LocalCache localCache2 = null;
        try {
            localCache2 = mInstanceMap.get(file.getAbsoluteFile() + myPid());
        } catch (Exception e2) {
        }
        if (localCache2 == null) {
            try {
                localCache = new LocalCache(file, j2, i2);
                try {
                    mInstanceMap.put(file.getAbsolutePath() + myPid(), localCache);
                } catch (Throwable th) {
                }
            } catch (Throwable th2) {
                localCache = localCache2;
            }
        } else {
            localCache = localCache2;
        }
        AppMethodBeat.o(190046);
        return localCache;
    }

    private static String myPid() {
        AppMethodBeat.i(190047);
        String str = "_" + Process.myPid();
        AppMethodBeat.o(190047);
        return str;
    }

    private LocalCache(File file, long j2, int i2) {
        AppMethodBeat.i(190048);
        if (file.exists() || file.mkdirs()) {
            this.mCache = new ACacheManager(file, j2, i2);
            AppMethodBeat.o(190048);
            return;
        }
        this.mCache = null;
        AppMethodBeat.o(190048);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0037 A[SYNTHETIC, Splitter:B:16:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b A[SYNTHETIC, Splitter:B:24:0x004b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void put(java.lang.String r7, java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 108
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.thirdparties.LocalCache.put(java.lang.String, java.lang.String):void");
    }

    public void put(String str, String str2, int i2) {
        AppMethodBeat.i(190050);
        put(str, Utils.access$300(i2, str2));
        AppMethodBeat.o(190050);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0063 A[SYNTHETIC, Splitter:B:26:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006f A[SYNTHETIC, Splitter:B:32:0x006f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getAsString(java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 132
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.thirdparties.LocalCache.getAsString(java.lang.String):java.lang.String");
    }

    public void put(String str, JSONObject jSONObject) {
        AppMethodBeat.i(190052);
        put(str, jSONObject.toString());
        AppMethodBeat.o(190052);
    }

    public void put(String str, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(190053);
        put(str, jSONObject.toString(), i2);
        AppMethodBeat.o(190053);
    }

    public JSONObject getAsJSONObject(String str) {
        AppMethodBeat.i(190054);
        try {
            JSONObject jSONObject = new JSONObject(getAsString(str));
            AppMethodBeat.o(190054);
            return jSONObject;
        } catch (Exception e2) {
            AppMethodBeat.o(190054);
            return null;
        }
    }

    public void put(String str, JSONArray jSONArray) {
        AppMethodBeat.i(190055);
        put(str, jSONArray.toString());
        AppMethodBeat.o(190055);
    }

    public void put(String str, JSONArray jSONArray, int i2) {
        AppMethodBeat.i(190056);
        put(str, jSONArray.toString(), i2);
        AppMethodBeat.o(190056);
    }

    public JSONArray getAsJSONArray(String str) {
        AppMethodBeat.i(190057);
        try {
            JSONArray jSONArray = new JSONArray(getAsString(str));
            AppMethodBeat.o(190057);
            return jSONArray;
        } catch (Exception e2) {
            AppMethodBeat.o(190057);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0030 A[SYNTHETIC, Splitter:B:14:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0044 A[SYNTHETIC, Splitter:B:20:0x0044] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void put(java.lang.String r7, byte[] r8) {
        /*
            r6 = this;
            r5 = 190058(0x2e66a, float:2.66328E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            com.tencent.thumbplayer.core.thirdparties.LocalCache$ACacheManager r0 = r6.mCache
            if (r0 != 0) goto L_0x000e
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
        L_0x000d:
            return
        L_0x000e:
            com.tencent.thumbplayer.core.thirdparties.LocalCache$ACacheManager r0 = r6.mCache
            java.io.File r4 = com.tencent.thumbplayer.core.thirdparties.LocalCache.ACacheManager.access$100(r0, r7)
            r1 = 0
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x002c, all -> 0x003f }
            r0.<init>(r4)     // Catch:{ Exception -> 0x002c, all -> 0x003f }
            r0.write(r8)     // Catch:{ Exception -> 0x005b, all -> 0x0055 }
            r0.flush()     // Catch:{ IOException -> 0x005d }
            r0.close()     // Catch:{ IOException -> 0x005d }
        L_0x0023:
            com.tencent.thumbplayer.core.thirdparties.LocalCache$ACacheManager r0 = r6.mCache
            com.tencent.thumbplayer.core.thirdparties.LocalCache.ACacheManager.access$200(r0, r4)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            goto L_0x000d
        L_0x002c:
            r0 = move-exception
            r0 = r1
        L_0x002e:
            if (r0 == 0) goto L_0x0036
            r0.flush()     // Catch:{ IOException -> 0x0059 }
            r0.close()     // Catch:{ IOException -> 0x0059 }
        L_0x0036:
            com.tencent.thumbplayer.core.thirdparties.LocalCache$ACacheManager r0 = r6.mCache
            com.tencent.thumbplayer.core.thirdparties.LocalCache.ACacheManager.access$200(r0, r4)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            goto L_0x000d
        L_0x003f:
            r0 = move-exception
            r2 = r0
            r3 = r1
        L_0x0042:
            if (r3 == 0) goto L_0x004a
            r3.flush()     // Catch:{ IOException -> 0x0053 }
            r3.close()     // Catch:{ IOException -> 0x0053 }
        L_0x004a:
            com.tencent.thumbplayer.core.thirdparties.LocalCache$ACacheManager r0 = r6.mCache
            com.tencent.thumbplayer.core.thirdparties.LocalCache.ACacheManager.access$200(r0, r4)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            throw r2
        L_0x0053:
            r0 = move-exception
            goto L_0x004a
        L_0x0055:
            r1 = move-exception
            r2 = r1
            r3 = r0
            goto L_0x0042
        L_0x0059:
            r0 = move-exception
            goto L_0x0036
        L_0x005b:
            r1 = move-exception
            goto L_0x002e
        L_0x005d:
            r0 = move-exception
            goto L_0x0023
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.thirdparties.LocalCache.put(java.lang.String, byte[]):void");
    }

    public void put(String str, byte[] bArr, int i2) {
        AppMethodBeat.i(190059);
        put(str, Utils.access$700(i2, bArr));
        AppMethodBeat.o(190059);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x005a A[SYNTHETIC, Splitter:B:27:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0066 A[SYNTHETIC, Splitter:B:33:0x0066] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getAsBinary(java.lang.String r6) {
        /*
        // Method dump skipped, instructions count: 125
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.thirdparties.LocalCache.getAsBinary(java.lang.String):byte[]");
    }

    public void put(String str, Serializable serializable) {
        AppMethodBeat.i(190061);
        put(str, serializable, -1);
        AppMethodBeat.o(190061);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c A[SYNTHETIC, Splitter:B:13:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0041 A[SYNTHETIC, Splitter:B:23:0x0041] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0052 A[SYNTHETIC, Splitter:B:31:0x0052] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void put(java.lang.String r6, java.io.Serializable r7, int r8) {
        /*
            r5 = this;
            r4 = 190062(0x2e66e, float:2.66334E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0061, Throwable -> 0x003d, all -> 0x004d }
            r2.<init>()     // Catch:{ Exception -> 0x0061, Throwable -> 0x003d, all -> 0x004d }
            java.io.ObjectOutputStream r0 = new java.io.ObjectOutputStream     // Catch:{ Exception -> 0x0061, Throwable -> 0x003d, all -> 0x004d }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0061, Throwable -> 0x003d, all -> 0x004d }
            r0.writeObject(r7)     // Catch:{ Exception -> 0x0029, Throwable -> 0x005f, all -> 0x005b }
            byte[] r1 = r2.toByteArray()     // Catch:{ Exception -> 0x0029, Throwable -> 0x005f, all -> 0x005b }
            r2 = -1
            if (r8 == r2) goto L_0x0025
            r5.put(r6, r1, r8)     // Catch:{ Exception -> 0x0029, Throwable -> 0x005f, all -> 0x005b }
        L_0x001e:
            r0.close()     // Catch:{ Throwable -> 0x0033 }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x0024:
            return
        L_0x0025:
            r5.put(r6, r1)
            goto L_0x001e
        L_0x0029:
            r1 = move-exception
        L_0x002a:
            if (r0 == 0) goto L_0x002f
            r0.close()     // Catch:{ Throwable -> 0x0038 }
        L_0x002f:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0024
        L_0x0033:
            r0 = move-exception
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0024
        L_0x0038:
            r0 = move-exception
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0024
        L_0x003d:
            r0 = move-exception
            r0 = r1
        L_0x003f:
            if (r0 == 0) goto L_0x0044
            r0.close()     // Catch:{ Throwable -> 0x0048 }
        L_0x0044:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0024
        L_0x0048:
            r0 = move-exception
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0024
        L_0x004d:
            r0 = move-exception
            r2 = r0
            r3 = r1
        L_0x0050:
            if (r3 == 0) goto L_0x0055
            r3.close()     // Catch:{ Throwable -> 0x0059 }
        L_0x0055:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r2
        L_0x0059:
            r0 = move-exception
            goto L_0x0055
        L_0x005b:
            r1 = move-exception
            r2 = r1
            r3 = r0
            goto L_0x0050
        L_0x005f:
            r1 = move-exception
            goto L_0x003f
        L_0x0061:
            r0 = move-exception
            r0 = r1
            goto L_0x002a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.thirdparties.LocalCache.put(java.lang.String, java.io.Serializable, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002a A[SYNTHETIC, Splitter:B:17:0x002a] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002f A[SYNTHETIC, Splitter:B:20:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003c A[SYNTHETIC, Splitter:B:26:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0041 A[SYNTHETIC, Splitter:B:29:0x0041] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getAsObject(java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 101
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.thirdparties.LocalCache.getAsObject(java.lang.String):java.lang.Object");
    }

    public void put(String str, Bitmap bitmap) {
        AppMethodBeat.i(190064);
        put(str, Utils.access$1000(bitmap));
        AppMethodBeat.o(190064);
    }

    public void put(String str, Bitmap bitmap, int i2) {
        AppMethodBeat.i(190065);
        put(str, Utils.access$1000(bitmap), i2);
        AppMethodBeat.o(190065);
    }

    public Bitmap getAsBitmap(String str) {
        AppMethodBeat.i(190066);
        if (getAsBinary(str) == null) {
            AppMethodBeat.o(190066);
            return null;
        }
        Bitmap access$1100 = Utils.access$1100(getAsBinary(str));
        AppMethodBeat.o(190066);
        return access$1100;
    }

    public void put(String str, Drawable drawable) {
        AppMethodBeat.i(190067);
        put(str, Utils.access$1200(drawable));
        AppMethodBeat.o(190067);
    }

    public void put(String str, Drawable drawable, int i2) {
        AppMethodBeat.i(190068);
        put(str, Utils.access$1200(drawable), i2);
        AppMethodBeat.o(190068);
    }

    public Drawable getAsDrawable(String str) {
        AppMethodBeat.i(190069);
        if (getAsBinary(str) == null) {
            AppMethodBeat.o(190069);
            return null;
        }
        Drawable access$1300 = Utils.access$1300(Utils.access$1100(getAsBinary(str)));
        AppMethodBeat.o(190069);
        return access$1300;
    }

    public File file(String str) {
        AppMethodBeat.i(190070);
        if (this.mCache == null) {
            AppMethodBeat.o(190070);
            return null;
        }
        File access$100 = ACacheManager.access$100(this.mCache, str);
        if (access$100.exists()) {
            AppMethodBeat.o(190070);
            return access$100;
        }
        AppMethodBeat.o(190070);
        return null;
    }

    public boolean remove(String str) {
        AppMethodBeat.i(190071);
        if (this.mCache == null) {
            AppMethodBeat.o(190071);
            return false;
        }
        boolean access$1400 = ACacheManager.access$1400(this.mCache, str);
        AppMethodBeat.o(190071);
        return access$1400;
    }

    public void clear() {
        AppMethodBeat.i(190072);
        if (this.mCache == null) {
            AppMethodBeat.o(190072);
            return;
        }
        ACacheManager.access$1500(this.mCache);
        AppMethodBeat.o(190072);
    }

    public class ACacheManager {
        private final AtomicInteger cacheCount;
        protected File cacheDir;
        private final AtomicLong cacheSize;
        private final int countLimit;
        private final Map<File, Long> lastUsageDates;
        private final long sizeLimit;

        static /* synthetic */ File access$100(ACacheManager aCacheManager, String str) {
            AppMethodBeat.i(190013);
            File newFile = aCacheManager.newFile(str);
            AppMethodBeat.o(190013);
            return newFile;
        }

        static /* synthetic */ boolean access$1400(ACacheManager aCacheManager, String str) {
            AppMethodBeat.i(190016);
            boolean remove = aCacheManager.remove(str);
            AppMethodBeat.o(190016);
            return remove;
        }

        static /* synthetic */ void access$1500(ACacheManager aCacheManager) {
            AppMethodBeat.i(190017);
            aCacheManager.clear();
            AppMethodBeat.o(190017);
        }

        static /* synthetic */ long access$1600(ACacheManager aCacheManager, File file) {
            AppMethodBeat.i(190018);
            long calculateSize = aCacheManager.calculateSize(file);
            AppMethodBeat.o(190018);
            return calculateSize;
        }

        static /* synthetic */ void access$200(ACacheManager aCacheManager, File file) {
            AppMethodBeat.i(190014);
            aCacheManager.put(file);
            AppMethodBeat.o(190014);
        }

        static /* synthetic */ File access$400(ACacheManager aCacheManager, String str) {
            AppMethodBeat.i(190015);
            File file = aCacheManager.get(str);
            AppMethodBeat.o(190015);
            return file;
        }

        private ACacheManager(File file, long j2, int i2) {
            AppMethodBeat.i(190004);
            this.lastUsageDates = Collections.synchronizedMap(new HashMap());
            this.cacheDir = file;
            this.sizeLimit = j2;
            this.countLimit = i2;
            this.cacheSize = new AtomicLong();
            this.cacheCount = new AtomicInteger();
            calculateCacheSizeAndCacheCount();
            AppMethodBeat.o(190004);
        }

        private void calculateCacheSizeAndCacheCount() {
            AppMethodBeat.i(190005);
            TPThreadUtil.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                /* class com.tencent.thumbplayer.core.thirdparties.LocalCache.ACacheManager.AnonymousClass1 */

                public void run() {
                    AppMethodBeat.i(190003);
                    File[] listFiles = ACacheManager.this.cacheDir.listFiles();
                    if (listFiles != null) {
                        int length = listFiles.length;
                        int i2 = 0;
                        int i3 = 0;
                        int i4 = 0;
                        while (i2 < length) {
                            File file = listFiles[i2];
                            i4 = (int) (((long) i4) + ACacheManager.access$1600(ACacheManager.this, file));
                            ACacheManager.this.lastUsageDates.put(file, Long.valueOf(file.lastModified()));
                            i2++;
                            i3++;
                        }
                        ACacheManager.this.cacheSize.set((long) i4);
                        ACacheManager.this.cacheCount.set(i3);
                    }
                    AppMethodBeat.o(190003);
                }
            });
            AppMethodBeat.o(190005);
        }

        private void put(File file) {
            AppMethodBeat.i(190006);
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
            AppMethodBeat.o(190006);
        }

        private File get(String str) {
            AppMethodBeat.i(190007);
            File newFile = newFile(str);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            newFile.setLastModified(valueOf.longValue());
            this.lastUsageDates.put(newFile, valueOf);
            AppMethodBeat.o(190007);
            return newFile;
        }

        private File newFile(String str) {
            AppMethodBeat.i(190008);
            File file = new File(this.cacheDir, new StringBuilder().append(str.hashCode()).toString());
            AppMethodBeat.o(190008);
            return file;
        }

        private boolean remove(String str) {
            AppMethodBeat.i(190009);
            boolean delete = get(str).delete();
            AppMethodBeat.o(190009);
            return delete;
        }

        private void clear() {
            AppMethodBeat.i(190010);
            this.lastUsageDates.clear();
            this.cacheSize.set(0);
            File[] listFiles = this.cacheDir.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    file.delete();
                }
            }
            AppMethodBeat.o(190010);
        }

        private long removeNext() {
            File file;
            File file2;
            AppMethodBeat.i(190011);
            if (this.lastUsageDates.isEmpty()) {
                AppMethodBeat.o(190011);
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
                    AppMethodBeat.o(190011);
                }
            }
            if (file == null) {
                AppMethodBeat.o(190011);
                return 0;
            }
            long calculateSize = calculateSize(file);
            if (file != null && file.delete()) {
                this.lastUsageDates.remove(file);
            }
            return calculateSize;
        }

        private long calculateSize(File file) {
            AppMethodBeat.i(190012);
            if (file == null) {
                AppMethodBeat.o(190012);
                return 0;
            }
            long length = file.length();
            AppMethodBeat.o(190012);
            return length;
        }
    }

    /* access modifiers changed from: package-private */
    public static class Utils {
        private static final char mSeparator = ' ';

        private Utils() {
        }

        static /* synthetic */ byte[] access$1000(Bitmap bitmap) {
            AppMethodBeat.i(190038);
            byte[] Bitmap2Bytes = Bitmap2Bytes(bitmap);
            AppMethodBeat.o(190038);
            return Bitmap2Bytes;
        }

        static /* synthetic */ Bitmap access$1100(byte[] bArr) {
            AppMethodBeat.i(190039);
            Bitmap Bytes2Bimap = Bytes2Bimap(bArr);
            AppMethodBeat.o(190039);
            return Bytes2Bimap;
        }

        static /* synthetic */ Bitmap access$1200(Drawable drawable) {
            AppMethodBeat.i(190040);
            Bitmap drawable2Bitmap = drawable2Bitmap(drawable);
            AppMethodBeat.o(190040);
            return drawable2Bitmap;
        }

        static /* synthetic */ Drawable access$1300(Bitmap bitmap) {
            AppMethodBeat.i(190041);
            Drawable bitmap2Drawable = bitmap2Drawable(bitmap);
            AppMethodBeat.o(190041);
            return bitmap2Drawable;
        }

        static /* synthetic */ String access$300(int i2, String str) {
            AppMethodBeat.i(190032);
            String newStringWithDateInfo = newStringWithDateInfo(i2, str);
            AppMethodBeat.o(190032);
            return newStringWithDateInfo;
        }

        static /* synthetic */ boolean access$500(String str) {
            AppMethodBeat.i(190033);
            boolean isDue = isDue(str);
            AppMethodBeat.o(190033);
            return isDue;
        }

        static /* synthetic */ String access$600(String str) {
            AppMethodBeat.i(190034);
            String clearDateInfo = clearDateInfo(str);
            AppMethodBeat.o(190034);
            return clearDateInfo;
        }

        static /* synthetic */ byte[] access$700(int i2, byte[] bArr) {
            AppMethodBeat.i(190035);
            byte[] newByteArrayWithDateInfo = newByteArrayWithDateInfo(i2, bArr);
            AppMethodBeat.o(190035);
            return newByteArrayWithDateInfo;
        }

        static /* synthetic */ boolean access$800(byte[] bArr) {
            AppMethodBeat.i(190036);
            boolean isDue = isDue(bArr);
            AppMethodBeat.o(190036);
            return isDue;
        }

        static /* synthetic */ byte[] access$900(byte[] bArr) {
            AppMethodBeat.i(190037);
            byte[] clearDateInfo = clearDateInfo(bArr);
            AppMethodBeat.o(190037);
            return clearDateInfo;
        }

        private static boolean isDue(String str) {
            AppMethodBeat.i(190019);
            boolean isDue = isDue(str.getBytes());
            AppMethodBeat.o(190019);
            return isDue;
        }

        private static boolean isDue(byte[] bArr) {
            AppMethodBeat.i(190020);
            String[] dateInfoFromDate = getDateInfoFromDate(bArr);
            if (dateInfoFromDate != null && dateInfoFromDate.length == 2) {
                String str = dateInfoFromDate[0];
                while (str.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    str = str.substring(1, str.length());
                }
                try {
                    if (System.currentTimeMillis() > Long.valueOf(str).longValue() + (Long.valueOf(dateInfoFromDate[1]).longValue() * 1000)) {
                        AppMethodBeat.o(190020);
                        return true;
                    }
                } catch (Exception e2) {
                    AppMethodBeat.o(190020);
                    return false;
                }
            }
            AppMethodBeat.o(190020);
            return false;
        }

        private static String newStringWithDateInfo(int i2, String str) {
            AppMethodBeat.i(190021);
            String str2 = createDateInfo(i2) + str;
            AppMethodBeat.o(190021);
            return str2;
        }

        private static byte[] newByteArrayWithDateInfo(int i2, byte[] bArr) {
            AppMethodBeat.i(190022);
            byte[] bytes = createDateInfo(i2).getBytes();
            byte[] bArr2 = new byte[(bytes.length + bArr.length)];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
            AppMethodBeat.o(190022);
            return bArr2;
        }

        private static String clearDateInfo(String str) {
            AppMethodBeat.i(190023);
            if (str != null && hasDateInfo(str.getBytes())) {
                str = str.substring(str.indexOf(32) + 1, str.length());
            }
            AppMethodBeat.o(190023);
            return str;
        }

        private static byte[] clearDateInfo(byte[] bArr) {
            AppMethodBeat.i(190024);
            if (hasDateInfo(bArr)) {
                byte[] copyOfRange = copyOfRange(bArr, indexOf(bArr, mSeparator) + 1, bArr.length);
                AppMethodBeat.o(190024);
                return copyOfRange;
            }
            AppMethodBeat.o(190024);
            return bArr;
        }

        private static boolean hasDateInfo(byte[] bArr) {
            AppMethodBeat.i(190025);
            if (bArr == null || bArr.length <= 15 || bArr[13] != 45 || indexOf(bArr, mSeparator) <= 14) {
                AppMethodBeat.o(190025);
                return false;
            }
            AppMethodBeat.o(190025);
            return true;
        }

        private static String[] getDateInfoFromDate(byte[] bArr) {
            AppMethodBeat.i(190026);
            if (hasDateInfo(bArr)) {
                String[] strArr = {new String(copyOfRange(bArr, 0, 13)), new String(copyOfRange(bArr, 14, indexOf(bArr, mSeparator)))};
                AppMethodBeat.o(190026);
                return strArr;
            }
            AppMethodBeat.o(190026);
            return null;
        }

        private static int indexOf(byte[] bArr, char c2) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                if (bArr[i2] == c2) {
                    return i2;
                }
            }
            return -1;
        }

        private static byte[] copyOfRange(byte[] bArr, int i2, int i3) {
            AppMethodBeat.i(190027);
            int i4 = i3 - i2;
            if (i4 < 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(i2 + " > " + i3);
                AppMethodBeat.o(190027);
                throw illegalArgumentException;
            }
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, i2, bArr2, 0, Math.min(bArr.length - i2, i4));
            AppMethodBeat.o(190027);
            return bArr2;
        }

        private static String createDateInfo(int i2) {
            AppMethodBeat.i(190028);
            String sb = new StringBuilder().append(System.currentTimeMillis()).toString();
            while (sb.length() < 13) {
                sb = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(sb));
            }
            String str = sb + "-" + i2 + mSeparator;
            AppMethodBeat.o(190028);
            return str;
        }

        private static byte[] Bitmap2Bytes(Bitmap bitmap) {
            AppMethodBeat.i(190029);
            if (bitmap == null) {
                AppMethodBeat.o(190029);
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            AppMethodBeat.o(190029);
            return byteArray;
        }

        private static Bitmap Bytes2Bimap(byte[] bArr) {
            if (bArr.length == 0) {
            }
            return null;
        }

        private static Bitmap drawable2Bitmap(Drawable drawable) {
            AppMethodBeat.i(190030);
            if (drawable == null) {
                AppMethodBeat.o(190030);
                return null;
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            AppMethodBeat.o(190030);
            return createBitmap;
        }

        private static Drawable bitmap2Drawable(Bitmap bitmap) {
            AppMethodBeat.i(190031);
            if (bitmap == null) {
                AppMethodBeat.o(190031);
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
            AppMethodBeat.o(190031);
            return bitmapDrawable;
        }
    }
}
