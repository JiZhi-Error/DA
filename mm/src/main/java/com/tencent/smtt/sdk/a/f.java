package com.tencent.smtt.sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static String f1981a = "EmergencyManager";

    /* renamed from: b  reason: collision with root package name */
    private final File f1982b;

    /* renamed from: c  reason: collision with root package name */
    private final FileOutputStream f1983c;

    /* renamed from: d  reason: collision with root package name */
    private final FileLock f1984d;

    private f(File file, FileOutputStream fileOutputStream, FileLock fileLock) {
        this.f1982b = file;
        this.f1983c = fileOutputStream;
        this.f1984d = fileLock;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a5 A[SYNTHETIC, Splitter:B:22:0x00a5] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c8 A[SYNTHETIC, Splitter:B:29:0x00c8] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.smtt.sdk.a.f a(java.io.File r7) {
        /*
        // Method dump skipped, instructions count: 238
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.a.f.a(java.io.File):com.tencent.smtt.sdk.a.f");
    }

    public void a() {
        AppMethodBeat.i(188286);
        TbsLog.i(f1981a, "Deleting lock file: " + this.f1982b.getAbsolutePath());
        this.f1984d.release();
        this.f1983c.close();
        if (!this.f1982b.delete()) {
            IOException iOException = new IOException("Failed to delete lock file: " + this.f1982b.getAbsolutePath());
            AppMethodBeat.o(188286);
            throw iOException;
        }
        AppMethodBeat.o(188286);
    }

    public void b() {
        AppMethodBeat.i(188287);
        try {
            a();
            AppMethodBeat.o(188287);
        } catch (IOException e2) {
            TbsLog.e(f1981a, "Failed to release process lock file: " + this.f1982b.getAbsolutePath() + " error: " + e2);
            AppMethodBeat.o(188287);
        }
    }
}
