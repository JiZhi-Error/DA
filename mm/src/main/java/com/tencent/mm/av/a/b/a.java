package com.tencent.mm.av.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.c.b;
import com.tencent.mm.av.a.c.g;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.modelsfs.SFSInputStream;
import com.tencent.mm.modelsfs.e;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class a implements b {
    private g jbF;

    @Override // com.tencent.mm.av.a.c.b
    public final void bdw() {
        AppMethodBeat.i(130409);
        com.tencent.mm.av.a.g.b.bdB();
        AppMethodBeat.o(130409);
    }

    @Override // com.tencent.mm.av.a.c.b
    public final void a(g gVar) {
        this.jbF = gVar;
    }

    private String a(String str, c cVar) {
        AppMethodBeat.i(130405);
        String str2 = cVar.fullPath;
        if (!((str2 != null && str2.length() != 0) || (str2 = cVar.prefixPath) == null || str2.length() == 0)) {
            str2 = str2 + FilePathGenerator.ANDROID_DIR_SEP + this.jbF.OX(str);
        }
        if (cVar.jbe && Util.isNullOrNil(str2)) {
            str2 = com.tencent.mm.av.a.g.b.aLN() + FilePathGenerator.ANDROID_DIR_SEP + this.jbF.OX(str);
        }
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(130405);
            return null;
        }
        AppMethodBeat.o(130405);
        return str2;
    }

    private String b(String str, c cVar) {
        String str2;
        AppMethodBeat.i(130406);
        String str3 = cVar.jbh;
        if ((str3 == null || str3.length() == 0) && (str2 = cVar.fullPath) != null && str2.length() > 0) {
            String str4 = cVar.prefixPath;
            if (str4 == null || str4.length() == 0 || !str2.startsWith(str4)) {
                Log.e("MicroMsg.imageloader.DefaultImageDiskCache", "[johnw] SFS can't deal with absolute path: %s", str2);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("SFS can't deal with absolute path: ".concat(String.valueOf(str2)));
                AppMethodBeat.o(130406);
                throw illegalArgumentException;
            }
            str3 = str2.substring(str4.length());
            if (str3.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                str3 = str3.substring(1);
            }
        }
        if (str3 == null || str3.length() == 0) {
            str3 = this.jbF.OX(str);
        }
        if (str3 == null || str3.length() == 0) {
            AppMethodBeat.o(130406);
            return null;
        }
        AppMethodBeat.o(130406);
        return str3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0077, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0078, code lost:
        if (r1 != null) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034 A[SYNTHETIC, Splitter:B:14:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0077 A[ExcHandler: all (r0v7 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r1 
      PHI: (r1v12 com.tencent.mm.modelsfs.SFSOutputStream) = (r1v11 com.tencent.mm.modelsfs.SFSOutputStream), (r1v17 com.tencent.mm.modelsfs.SFSOutputStream), (r1v17 com.tencent.mm.modelsfs.SFSOutputStream) binds: [B:6:0x0019, B:41:0x00c8, B:42:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:6:0x0019] */
    @Override // com.tencent.mm.av.a.c.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.lang.String r11, byte[] r12, com.tencent.mm.av.a.a.c r13) {
        /*
        // Method dump skipped, instructions count: 335
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.av.a.b.a.a(java.lang.String, byte[], com.tencent.mm.av.a.a.c):boolean");
    }

    @Override // com.tencent.mm.av.a.c.b
    public final boolean c(String str, c cVar) {
        AppMethodBeat.i(130408);
        SFSContext sFSContext = cVar.jbw;
        if (sFSContext != null) {
            String b2 = b(str, cVar);
            if (b2 == null) {
                AppMethodBeat.o(130408);
                return false;
            } else if (sFSContext.mNativePtr == 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Reuse already released SFSContext.");
                AppMethodBeat.o(130408);
                throw illegalArgumentException;
            } else {
                if (e.Pv(b2)) {
                    e.Px(b2);
                    b2 = e.Pw(b2);
                }
                boolean nativeUnlink = SFSContext.nativeUnlink(sFSContext.mNativePtr, b2);
                AppMethodBeat.o(130408);
                return nativeUnlink;
            }
        } else {
            String a2 = a(str, cVar);
            if (a2 == null) {
                AppMethodBeat.o(130408);
                return false;
            }
            boolean delete = new o(a2).delete();
            AppMethodBeat.o(130408);
            return delete;
        }
    }

    @Override // com.tencent.mm.av.a.c.b
    public final InputStream d(String str, c cVar) {
        long j2;
        AppMethodBeat.i(130410);
        try {
            SFSContext sFSContext = cVar.jbw;
            if (sFSContext != null) {
                String b2 = b(str, cVar);
                if (b2 == null) {
                    AppMethodBeat.o(130410);
                    return null;
                } else if (sFSContext.mNativePtr == 0) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Reuse already released SFSContext.");
                    AppMethodBeat.o(130410);
                    throw illegalArgumentException;
                } else {
                    if (e.Pv(b2)) {
                        j2 = e.Px(b2);
                        b2 = e.Pw(b2);
                    } else {
                        j2 = 0;
                    }
                    long nativeOpenRead = SFSContext.nativeOpenRead(sFSContext.mNativePtr, b2);
                    if (nativeOpenRead == 0) {
                        FileNotFoundException fileNotFoundException = new FileNotFoundException(b2 + ": " + SFSContext.nativeErrorMessage());
                        AppMethodBeat.o(130410);
                        throw fileNotFoundException;
                    } else if (j2 != 0) {
                        com.tencent.mm.modelsfs.c cVar2 = new com.tencent.mm.modelsfs.c(nativeOpenRead, j2);
                        AppMethodBeat.o(130410);
                        return cVar2;
                    } else {
                        SFSInputStream sFSInputStream = new SFSInputStream(nativeOpenRead);
                        AppMethodBeat.o(130410);
                        return sFSInputStream;
                    }
                }
            } else {
                String a2 = a(str, cVar);
                if (a2 == null) {
                    AppMethodBeat.o(130410);
                    return null;
                }
                InputStream openRead = s.openRead(a2);
                AppMethodBeat.o(130410);
                return openRead;
            }
        } catch (FileNotFoundException e2) {
            AppMethodBeat.o(130410);
            return null;
        }
    }
}
