package com.bumptech.glide.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a implements Closeable {
    private final File aDB;
    private final File aDC;
    private final File aDD;
    private final int aDE;
    private Writer aDF;
    private final LinkedHashMap<String, c> aDG = new LinkedHashMap<>(0, 0.75f, true);
    private int aDH;
    private long aDI = 0;
    final ThreadPoolExecutor aDJ = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0061a((byte) 0));
    private final Callable<Void> aDK = new Callable<Void>() {
        /* class com.bumptech.glide.a.a.AnonymousClass1 */

        @Override // java.util.concurrent.Callable
        private Void call() {
            AppMethodBeat.i(100638);
            synchronized (a.this) {
                try {
                    if (a.this.aDF != null) {
                        a.b(a.this);
                        if (a.c(a.this)) {
                            a.d(a.this);
                            a.this.aDH = 0;
                        }
                        AppMethodBeat.o(100638);
                    }
                } finally {
                    AppMethodBeat.o(100638);
                }
            }
            return null;
        }
    };
    private final int appVersion;
    private final File directory;
    private long maxSize;
    private long size = 0;

    public static /* synthetic */ void a(a aVar, b bVar, boolean z) {
        AppMethodBeat.i(100628);
        aVar.a(bVar, z);
        AppMethodBeat.o(100628);
    }

    static /* synthetic */ void b(a aVar) {
        AppMethodBeat.i(100625);
        aVar.trimToSize();
        AppMethodBeat.o(100625);
    }

    static /* synthetic */ boolean c(a aVar) {
        AppMethodBeat.i(100626);
        boolean nZ = aVar.nZ();
        AppMethodBeat.o(100626);
        return nZ;
    }

    static /* synthetic */ void d(a aVar) {
        AppMethodBeat.i(100627);
        aVar.nY();
        AppMethodBeat.o(100627);
    }

    private a(File file, long j2) {
        AppMethodBeat.i(100610);
        this.directory = file;
        this.appVersion = 1;
        this.aDB = new File(file, "journal");
        this.aDC = new File(file, "journal.tmp");
        this.aDD = new File(file, "journal.bkp");
        this.aDE = 1;
        this.maxSize = j2;
        AppMethodBeat.o(100610);
    }

    public static a b(File file, long j2) {
        AppMethodBeat.i(100611);
        if (j2 <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("maxSize <= 0");
            AppMethodBeat.o(100611);
            throw illegalArgumentException;
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                a(file2, file3, false);
            }
        }
        a aVar = new a(file, j2);
        if (aVar.aDB.exists()) {
            try {
                aVar.nW();
                aVar.nX();
                AppMethodBeat.o(100611);
                return aVar;
            } catch (IOException e2) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                aVar.close();
                c.r(aVar.directory);
            }
        }
        file.mkdirs();
        a aVar2 = new a(file, j2);
        aVar2.nY();
        AppMethodBeat.o(100611);
        return aVar2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void nW() {
        /*
        // Method dump skipped, instructions count: 421
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.a.a.nW():void");
    }

    private void nX() {
        AppMethodBeat.i(100613);
        q(this.aDC);
        Iterator<c> it = this.aDG.values().iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.aDS == null) {
                for (int i2 = 0; i2 < this.aDE; i2++) {
                    this.size += next.aDP[i2];
                }
            } else {
                next.aDS = null;
                for (int i3 = 0; i3 < this.aDE; i3++) {
                    q(next.aDQ[i3]);
                    q(next.aDR[i3]);
                }
                it.remove();
            }
        }
        AppMethodBeat.o(100613);
    }

    private synchronized void nY() {
        AppMethodBeat.i(100614);
        if (this.aDF != null) {
            this.aDF.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aDC), c.US_ASCII));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.appVersion));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.aDE));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (c cVar : this.aDG.values()) {
                if (cVar.aDS != null) {
                    bufferedWriter.write("DIRTY " + cVar.key + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + cVar.key + cVar.od() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.aDB.exists()) {
                a(this.aDB, this.aDD, true);
            }
            a(this.aDC, this.aDB, false);
            this.aDD.delete();
            this.aDF = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aDB, true), c.US_ASCII));
            AppMethodBeat.o(100614);
        } catch (Throwable th) {
            bufferedWriter.close();
            AppMethodBeat.o(100614);
            throw th;
        }
    }

    private static void q(File file) {
        AppMethodBeat.i(100615);
        if (!file.exists() || file.delete()) {
            AppMethodBeat.o(100615);
            return;
        }
        IOException iOException = new IOException();
        AppMethodBeat.o(100615);
        throw iOException;
    }

    private static void a(File file, File file2, boolean z) {
        AppMethodBeat.i(100616);
        if (z) {
            q(file2);
        }
        if (!file.renameTo(file2)) {
            IOException iOException = new IOException();
            AppMethodBeat.o(100616);
            throw iOException;
        }
        AppMethodBeat.o(100616);
    }

    public final synchronized d O(String str) {
        int i2 = 0;
        d dVar = null;
        synchronized (this) {
            AppMethodBeat.i(100617);
            oa();
            c cVar = this.aDG.get(str);
            if (cVar == null) {
                AppMethodBeat.o(100617);
            } else if (!cVar.readable) {
                AppMethodBeat.o(100617);
            } else {
                File[] fileArr = cVar.aDQ;
                int length = fileArr.length;
                while (true) {
                    if (i2 >= length) {
                        this.aDH++;
                        this.aDF.append((CharSequence) "READ");
                        this.aDF.append(' ');
                        this.aDF.append((CharSequence) str);
                        this.aDF.append('\n');
                        if (nZ()) {
                            this.aDJ.submit(this.aDK);
                        }
                        dVar = new d(this, str, cVar.aDT, cVar.aDQ, cVar.aDP, (byte) 0);
                        AppMethodBeat.o(100617);
                    } else if (!fileArr[i2].exists()) {
                        AppMethodBeat.o(100617);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        return dVar;
    }

    public final synchronized b P(String str) {
        c cVar;
        b bVar;
        AppMethodBeat.i(100618);
        oa();
        c cVar2 = this.aDG.get(str);
        if (-1 == -1 || (cVar2 != null && cVar2.aDT == -1)) {
            if (cVar2 == null) {
                c cVar3 = new c(this, str, (byte) 0);
                this.aDG.put(str, cVar3);
                cVar = cVar3;
            } else if (cVar2.aDS != null) {
                AppMethodBeat.o(100618);
                bVar = null;
            } else {
                cVar = cVar2;
            }
            bVar = new b(this, cVar, (byte) 0);
            cVar.aDS = bVar;
            this.aDF.append((CharSequence) "DIRTY");
            this.aDF.append(' ');
            this.aDF.append((CharSequence) str);
            this.aDF.append('\n');
            this.aDF.flush();
            AppMethodBeat.o(100618);
        } else {
            AppMethodBeat.o(100618);
            bVar = null;
        }
        return bVar;
    }

    private boolean nZ() {
        AppMethodBeat.i(100620);
        if (this.aDH < 2000 || this.aDH < this.aDG.size()) {
            AppMethodBeat.o(100620);
            return false;
        }
        AppMethodBeat.o(100620);
        return true;
    }

    private synchronized boolean remove(String str) {
        boolean z;
        synchronized (this) {
            AppMethodBeat.i(100621);
            oa();
            c cVar = this.aDG.get(str);
            if (cVar == null || cVar.aDS != null) {
                AppMethodBeat.o(100621);
                z = false;
            } else {
                for (int i2 = 0; i2 < this.aDE; i2++) {
                    File file = cVar.aDQ[i2];
                    if (!file.exists() || file.delete()) {
                        this.size -= cVar.aDP[i2];
                        cVar.aDP[i2] = 0;
                    } else {
                        IOException iOException = new IOException("failed to delete ".concat(String.valueOf(file)));
                        AppMethodBeat.o(100621);
                        throw iOException;
                    }
                }
                this.aDH++;
                this.aDF.append((CharSequence) "REMOVE");
                this.aDF.append(' ');
                this.aDF.append((CharSequence) str);
                this.aDF.append('\n');
                this.aDG.remove(str);
                if (nZ()) {
                    this.aDJ.submit(this.aDK);
                }
                z = true;
                AppMethodBeat.o(100621);
            }
        }
        return z;
    }

    private void oa() {
        AppMethodBeat.i(100622);
        if (this.aDF == null) {
            IllegalStateException illegalStateException = new IllegalStateException("cache is closed");
            AppMethodBeat.o(100622);
            throw illegalStateException;
        }
        AppMethodBeat.o(100622);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        AppMethodBeat.i(100623);
        if (this.aDF == null) {
            AppMethodBeat.o(100623);
        } else {
            Iterator it = new ArrayList(this.aDG.values()).iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar.aDS != null) {
                    cVar.aDS.abort();
                }
            }
            trimToSize();
            this.aDF.close();
            this.aDF = null;
            AppMethodBeat.o(100623);
        }
    }

    private void trimToSize() {
        AppMethodBeat.i(100624);
        while (this.size > this.maxSize) {
            remove(this.aDG.entrySet().iterator().next().getKey());
        }
        AppMethodBeat.o(100624);
    }

    public final class d {
        private final long[] aDP;
        private final long aDT;
        public final File[] aDU;
        private final String key;

        /* synthetic */ d(a aVar, String str, long j2, File[] fileArr, long[] jArr, byte b2) {
            this(str, j2, fileArr, jArr);
        }

        private d(String str, long j2, File[] fileArr, long[] jArr) {
            this.key = str;
            this.aDT = j2;
            this.aDU = fileArr;
            this.aDP = jArr;
        }
    }

    public final class b {
        final c aDM;
        final boolean[] aDN;
        public boolean aDO;

        /* synthetic */ b(a aVar, c cVar, byte b2) {
            this(cVar);
        }

        private b(c cVar) {
            AppMethodBeat.i(100629);
            this.aDM = cVar;
            this.aDN = cVar.readable ? null : new boolean[a.this.aDE];
            AppMethodBeat.o(100629);
        }

        public final File ob() {
            File file;
            AppMethodBeat.i(100630);
            synchronized (a.this) {
                try {
                    if (this.aDM.aDS != this) {
                        IllegalStateException illegalStateException = new IllegalStateException();
                        AppMethodBeat.o(100630);
                        throw illegalStateException;
                    }
                    if (!this.aDM.readable) {
                        this.aDN[0] = true;
                    }
                    file = this.aDM.aDR[0];
                    if (!a.this.directory.exists()) {
                        a.this.directory.mkdirs();
                    }
                } finally {
                    AppMethodBeat.o(100630);
                }
            }
            return file;
        }

        public final void abort() {
            AppMethodBeat.i(100631);
            a.a(a.this, this, false);
            AppMethodBeat.o(100631);
        }

        public final void oc() {
            AppMethodBeat.i(100632);
            if (!this.aDO) {
                try {
                    abort();
                    AppMethodBeat.o(100632);
                    return;
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.o(100632);
        }
    }

    /* access modifiers changed from: package-private */
    public final class c {
        final long[] aDP;
        File[] aDQ;
        File[] aDR;
        b aDS;
        long aDT;
        final String key;
        boolean readable;

        /* synthetic */ c(a aVar, String str, byte b2) {
            this(str);
        }

        private c(String str) {
            AppMethodBeat.i(100633);
            this.key = str;
            this.aDP = new long[a.this.aDE];
            this.aDQ = new File[a.this.aDE];
            this.aDR = new File[a.this.aDE];
            StringBuilder append = new StringBuilder(str).append('.');
            int length = append.length();
            for (int i2 = 0; i2 < a.this.aDE; i2++) {
                append.append(i2);
                this.aDQ[i2] = new File(a.this.directory, append.toString());
                append.append(".tmp");
                this.aDR[i2] = new File(a.this.directory, append.toString());
                append.setLength(length);
            }
            AppMethodBeat.o(100633);
        }

        public final String od() {
            AppMethodBeat.i(100634);
            StringBuilder sb = new StringBuilder();
            for (long j2 : this.aDP) {
                sb.append(' ').append(j2);
            }
            String sb2 = sb.toString();
            AppMethodBeat.o(100634);
            return sb2;
        }

        /* access modifiers changed from: package-private */
        public final void c(String[] strArr) {
            AppMethodBeat.i(100635);
            if (strArr.length != a.this.aDE) {
                IOException d2 = d(strArr);
                AppMethodBeat.o(100635);
                throw d2;
            }
            for (int i2 = 0; i2 < strArr.length; i2++) {
                try {
                    this.aDP[i2] = Long.parseLong(strArr[i2]);
                } catch (NumberFormatException e2) {
                    IOException d3 = d(strArr);
                    AppMethodBeat.o(100635);
                    throw d3;
                }
            }
            AppMethodBeat.o(100635);
        }

        private static IOException d(String[] strArr) {
            AppMethodBeat.i(100636);
            IOException iOException = new IOException("unexpected journal line: " + Arrays.toString(strArr));
            AppMethodBeat.o(100636);
            throw iOException;
        }
    }

    /* renamed from: com.bumptech.glide.a.a$a  reason: collision with other inner class name */
    static final class ThreadFactoryC0061a implements ThreadFactory {
        private ThreadFactoryC0061a() {
        }

        /* synthetic */ ThreadFactoryC0061a(byte b2) {
            this();
        }

        public final synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            AppMethodBeat.i(100647);
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            AppMethodBeat.o(100647);
            return thread;
        }
    }

    private synchronized void a(b bVar, boolean z) {
        synchronized (this) {
            AppMethodBeat.i(100619);
            c cVar = bVar.aDM;
            if (cVar.aDS != bVar) {
                IllegalStateException illegalStateException = new IllegalStateException();
                AppMethodBeat.o(100619);
                throw illegalStateException;
            }
            if (z && !cVar.readable) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.aDE) {
                        break;
                    } else if (!bVar.aDN[i2]) {
                        bVar.abort();
                        IllegalStateException illegalStateException2 = new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i2)));
                        AppMethodBeat.o(100619);
                        throw illegalStateException2;
                    } else if (!cVar.aDR[i2].exists()) {
                        bVar.abort();
                        AppMethodBeat.o(100619);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            for (int i3 = 0; i3 < this.aDE; i3++) {
                File file = cVar.aDR[i3];
                if (!z) {
                    q(file);
                } else if (file.exists()) {
                    File file2 = cVar.aDQ[i3];
                    file.renameTo(file2);
                    long j2 = cVar.aDP[i3];
                    long length = file2.length();
                    cVar.aDP[i3] = length;
                    this.size = (this.size - j2) + length;
                }
            }
            this.aDH++;
            cVar.aDS = null;
            if (cVar.readable || z) {
                cVar.readable = true;
                this.aDF.append((CharSequence) "CLEAN");
                this.aDF.append(' ');
                this.aDF.append((CharSequence) cVar.key);
                this.aDF.append((CharSequence) cVar.od());
                this.aDF.append('\n');
                if (z) {
                    long j3 = this.aDI;
                    this.aDI = 1 + j3;
                    cVar.aDT = j3;
                }
            } else {
                this.aDG.remove(cVar.key);
                this.aDF.append((CharSequence) "REMOVE");
                this.aDF.append(' ');
                this.aDF.append((CharSequence) cVar.key);
                this.aDF.append('\n');
            }
            this.aDF.flush();
            if (this.size > this.maxSize || nZ()) {
                this.aDJ.submit(this.aDK);
            }
            AppMethodBeat.o(100619);
        }
    }
}
