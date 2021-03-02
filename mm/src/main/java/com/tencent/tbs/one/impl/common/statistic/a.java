package com.tencent.tbs.one.impl.common.statistic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public final class a extends com.tencent.tbs.one.impl.a.a<byte[]> {

    /* renamed from: b  reason: collision with root package name */
    private String f2594b;

    /* renamed from: c  reason: collision with root package name */
    private File f2595c;

    /* renamed from: d  reason: collision with root package name */
    private ZipEntry f2596d;

    /* renamed from: e  reason: collision with root package name */
    private ZipOutputStream f2597e;

    /* renamed from: f  reason: collision with root package name */
    private int f2598f = 0;

    public a(String str) {
        AppMethodBeat.i(174194);
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            a(1001, "Log path not exist or not directory!", new Throwable());
            AppMethodBeat.o(174194);
            return;
        }
        this.f2594b = str;
        this.f2596d = new ZipEntry("onelog");
        this.f2595c = a("log_", ".zip.tmp", file);
        new Object[1][0] = this.f2595c.getAbsolutePath();
        try {
            this.f2597e = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(this.f2595c)));
            this.f2597e.putNextEntry(this.f2596d);
            AppMethodBeat.o(174194);
        } catch (FileNotFoundException e2) {
            AppMethodBeat.o(174194);
        } catch (IOException e3) {
            AppMethodBeat.o(174194);
        }
    }

    private static File a(String str, String str2, File file) {
        AppMethodBeat.i(174195);
        File[] listFiles = file.listFiles();
        for (int i2 = 0; i2 < listFiles.length; i2++) {
            String name = listFiles[i2].getName();
            if (name.startsWith(str) && name.endsWith(str2)) {
                listFiles[i2].delete();
            }
        }
        File file2 = new File(file, str + System.currentTimeMillis() + str2);
        AppMethodBeat.o(174195);
        return file2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0057 A[SYNTHETIC, Splitter:B:13:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0079 A[SYNTHETIC, Splitter:B:27:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.io.File r7) {
        /*
        // Method dump skipped, instructions count: 141
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tbs.one.impl.common.statistic.a.a(java.io.File):void");
    }

    private void c() {
        AppMethodBeat.i(174196);
        if (this.f2595c != null) {
            this.f2595c.delete();
            this.f2595c = null;
        }
        AppMethodBeat.o(174196);
    }

    /* JADX WARNING: Removed duplicated region for block: B:118:0x0173 A[EDGE_INSN: B:118:0x0173->B:84:0x0173 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x010a A[Catch:{ IOException -> 0x010f, all -> 0x019d }, LOOP:4: B:46:0x0103->B:48:0x010a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0113 A[SYNTHETIC, Splitter:B:52:0x0113] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x014c A[SYNTHETIC, Splitter:B:71:0x014c] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0160 A[SYNTHETIC, Splitter:B:78:0x0160] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x018a A[SYNTHETIC, Splitter:B:95:0x018a] */
    @Override // com.tencent.tbs.one.impl.a.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
        // Method dump skipped, instructions count: 423
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tbs.one.impl.common.statistic.a.a():void");
    }
}
