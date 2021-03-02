package com.tencent.tinker.lib.e;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.tinker.lib.b.b;
import com.tencent.tinker.lib.d.c;
import com.tencent.tinker.lib.d.d;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;

public class a {
    private static a SjR;
    public static boolean sInstalled = false;
    public final boolean FgY;
    public final File SjS;
    final b SjT;
    public final c SjU;
    public final d SjV;
    public final File SjW;
    public final File SjX;
    public final boolean SjY;
    public d SjZ;
    public boolean Ska;
    public final Context context;
    public int tinkerFlags;
    final boolean tinkerLoadVerifyFlag;

    /* synthetic */ a(Context context2, int i2, c cVar, d dVar, b bVar, File file, File file2, File file3, boolean z, boolean z2, boolean z3, byte b2) {
        this(context2, i2, cVar, dVar, bVar, file, file2, file3, z, z2, z3);
    }

    private a(Context context2, int i2, c cVar, d dVar, b bVar, File file, File file2, File file3, boolean z, boolean z2, boolean z3) {
        this.Ska = false;
        this.context = context2;
        this.SjT = bVar;
        this.SjU = cVar;
        this.SjV = dVar;
        this.tinkerFlags = i2;
        this.SjS = file;
        this.SjW = file2;
        this.SjX = file3;
        this.FgY = z;
        this.tinkerLoadVerifyFlag = z3;
        this.SjY = z2;
    }

    public static a lk(Context context2) {
        if (!sInstalled) {
            throw new TinkerRuntimeException("you must install tinker before get tinker sInstance");
        }
        synchronized (a.class) {
            if (SjR == null) {
                SjR = new C2216a(context2).hpi();
            }
        }
        return SjR;
    }

    public static void a(a aVar) {
        if (SjR != null) {
            throw new TinkerRuntimeException("Tinker instance is already set.");
        }
        SjR = aVar;
    }

    public final d hpd() {
        return this.SjZ;
    }

    public final boolean hpe() {
        return this.Ska;
    }

    public final File hpf() {
        return this.SjW;
    }

    public final File hpg() {
        return this.SjX;
    }

    public final b hph() {
        return this.SjT;
    }

    public final void dZn() {
        if (this.SjS != null) {
            File patchInfoFile = SharePatchFileUtil.getPatchInfoFile(this.SjS.getAbsolutePath());
            if (!patchInfoFile.exists()) {
                ShareTinkerLog.w("Tinker.Tinker", "try to clean patch while patch info file does not exist.", new Object[0]);
                return;
            }
            File patchInfoLockFile = SharePatchFileUtil.getPatchInfoLockFile(this.SjS.getAbsolutePath());
            SharePatchInfo readAndCheckPropertyWithLock = SharePatchInfo.readAndCheckPropertyWithLock(patchInfoFile, patchInfoLockFile);
            if (readAndCheckPropertyWithLock != null) {
                readAndCheckPropertyWithLock.isRemoveNewVersion = true;
                SharePatchInfo.rewritePatchInfoFileWithLock(patchInfoFile, readAndCheckPropertyWithLock, patchInfoLockFile);
            }
        }
    }

    private void bqJ(String str) {
        if (this.SjS != null && str != null) {
            SharePatchFileUtil.deleteDir(this.SjS.getAbsolutePath() + FilePathGenerator.ANDROID_DIR_SEP + str);
        }
    }

    public final void ae(File file) {
        if (this.SjS != null && file != null && file.exists()) {
            bqJ(SharePatchFileUtil.getPatchVersionDirectory(SharePatchFileUtil.getMD5(file)));
        }
    }

    /* renamed from: com.tencent.tinker.lib.e.a$a  reason: collision with other inner class name */
    public static class C2216a {
        private File SjS;
        public b SjT;
        public c SjU;
        public d SjV;
        private File SjW;
        private File SjX;
        private final boolean Skb;
        private final boolean Skc;
        public Boolean Skd;
        private final Context context;
        public int status = -1;

        public C2216a(Context context2) {
            if (context2 == null) {
                throw new TinkerRuntimeException("Context must not be null.");
            }
            this.context = context2;
            this.Skb = com.tencent.tinker.lib.f.b.isInMainProcess(context2);
            this.Skc = com.tencent.tinker.lib.f.b.lo(context2);
            this.SjS = SharePatchFileUtil.getPatchDirectory(context2);
            if (this.SjS == null) {
                ShareTinkerLog.e("Tinker.Tinker", "patchDirectory is null!", new Object[0]);
                return;
            }
            this.SjW = SharePatchFileUtil.getPatchInfoFile(this.SjS.getAbsolutePath());
            this.SjX = SharePatchFileUtil.getPatchInfoLockFile(this.SjS.getAbsolutePath());
            ShareTinkerLog.w("Tinker.Tinker", "tinker patch directory: %s", this.SjS);
        }

        public final a hpi() {
            if (this.status == -1) {
                this.status = 15;
            }
            if (this.SjU == null) {
                this.SjU = new com.tencent.tinker.lib.d.a(this.context);
            }
            if (this.SjV == null) {
                this.SjV = new com.tencent.tinker.lib.d.b(this.context);
            }
            if (this.SjT == null) {
                this.SjT = new com.tencent.tinker.lib.b.a(this.context);
            }
            if (this.Skd == null) {
                this.Skd = Boolean.FALSE;
            }
            return new a(this.context, this.status, this.SjU, this.SjV, this.SjT, this.SjS, this.SjW, this.SjX, this.Skb, this.Skc, this.Skd.booleanValue(), (byte) 0);
        }
    }
}
