package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.FilesCopy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.s;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.ZipInputStream;
import org.apache.commons.a.d;

public final class z extends j {
    public final String kSr;
    public final String kTj;
    public volatile long kTk = -1;
    private final b kTl = new b() {
        /* class com.tencent.mm.plugin.appbrand.appstorage.z.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.appstorage.z.b
        public final m v(o oVar) {
            AppMethodBeat.i(175591);
            if (oVar.exists()) {
                m mVar = m.OK;
                AppMethodBeat.o(175591);
                return mVar;
            }
            m mVar2 = m.RET_NOT_EXISTS;
            AppMethodBeat.o(175591);
            return mVar2;
        }
    };
    private final b kTm = new b() {
        /* class com.tencent.mm.plugin.appbrand.appstorage.z.AnonymousClass7 */

        @Override // com.tencent.mm.plugin.appbrand.appstorage.z.b
        public final m v(o oVar) {
            AppMethodBeat.i(175597);
            if (!oVar.exists()) {
                m mVar = m.RET_NOT_EXISTS;
                AppMethodBeat.o(175597);
                return mVar;
            } else if (oVar.isDirectory()) {
                m mVar2 = m.OK;
                AppMethodBeat.o(175597);
                return mVar2;
            } else {
                m mVar3 = m.ERR_IS_FILE;
                AppMethodBeat.o(175597);
                return mVar3;
            }
        }
    };
    private final a kTn = new a() {
        /* class com.tencent.mm.plugin.appbrand.appstorage.z.AnonymousClass8 */

        @Override // com.tencent.mm.plugin.appbrand.appstorage.z.a
        public final m a(o oVar, Object... objArr) {
            AppMethodBeat.i(175598);
            if (oVar.exists()) {
                m mVar = m.RET_ALREADY_EXISTS;
                AppMethodBeat.o(175598);
                return mVar;
            } else if (!((Boolean) objArr[0]).booleanValue() ? oVar.mkdirs() : oVar.mkdirs()) {
                m mVar2 = m.OK;
                AppMethodBeat.o(175598);
                return mVar2;
            } else {
                m mVar3 = m.ERR_OP_FAIL;
                AppMethodBeat.o(175598);
                return mVar3;
            }
        }
    };
    private final a kTo = new a() {
        /* class com.tencent.mm.plugin.appbrand.appstorage.z.AnonymousClass9 */

        @Override // com.tencent.mm.plugin.appbrand.appstorage.z.a
        public final m a(o oVar, Object... objArr) {
            AppMethodBeat.i(175599);
            if (oVar.isFile() || !oVar.exists()) {
                m mVar = m.RET_NOT_EXISTS;
                AppMethodBeat.o(175599);
                return mVar;
            } else if (oVar.equals(z.this.bxC())) {
                m mVar2 = m.ERR_PERMISSION_DENIED;
                AppMethodBeat.o(175599);
                return mVar2;
            } else if (((Boolean) objArr[0]).booleanValue()) {
                Log.d("MicroMsg.LuggageNonFlattenedFileSystem", "rmdir recursive");
                try {
                    n.t(oVar);
                    m mVar3 = m.OK;
                    AppMethodBeat.o(175599);
                    return mVar3;
                } catch (Exception e2) {
                    Log.e("MicroMsg.LuggageNonFlattenedFileSystem", "rmdir recursive exp = %s", e2);
                    m mVar4 = m.ERR_OP_FAIL;
                    AppMethodBeat.o(175599);
                    return mVar4;
                }
            } else {
                o[] het = oVar.het();
                if (het.length > 0) {
                    if (het.length != 1) {
                        m mVar5 = m.ERR_DIR_NOT_EMPTY;
                        AppMethodBeat.o(175599);
                        return mVar5;
                    } else if (het[0].getName().equals(FilePathGenerator.NO_MEDIA_FILENAME)) {
                        het[0].delete();
                    } else {
                        m mVar6 = m.ERR_DIR_NOT_EMPTY;
                        AppMethodBeat.o(175599);
                        return mVar6;
                    }
                }
                if (oVar.delete()) {
                    m mVar7 = m.OK;
                    AppMethodBeat.o(175599);
                    return mVar7;
                }
                m mVar8 = m.ERR_OP_FAIL;
                AppMethodBeat.o(175599);
                return mVar8;
            }
        }
    };
    private final a kTp = new a() {
        /* class com.tencent.mm.plugin.appbrand.appstorage.z.AnonymousClass10 */

        @Override // com.tencent.mm.plugin.appbrand.appstorage.z.a
        public final m a(o oVar, Object... objArr) {
            AppMethodBeat.i(175601);
            if (!oVar.isDirectory()) {
                m mVar = m.ERR_IS_FILE;
                AppMethodBeat.o(175601);
                return mVar;
            } else if (n.u(oVar)) {
                m mVar2 = m.ERR_SYMLINK;
                AppMethodBeat.o(175601);
                return mVar2;
            } else {
                final T t = (T) new LinkedList();
                final String quote = Pattern.quote(aa.z(oVar.her()));
                oVar.a(new q() {
                    /* class com.tencent.mm.plugin.appbrand.appstorage.z.AnonymousClass10.AnonymousClass1 */

                    @Override // com.tencent.mm.vfs.q
                    public final boolean accept(o oVar) {
                        AppMethodBeat.i(175600);
                        boolean z = !oVar.getName().endsWith(FilePathGenerator.NO_MEDIA_FILENAME);
                        if (z) {
                            k kVar = new k();
                            kVar.fileName = n.Wd(aa.z(oVar.her()).replaceFirst(quote, ""));
                            t.add(kVar);
                        }
                        AppMethodBeat.o(175600);
                        return z;
                    }
                });
                ((i) objArr[0]).value = t;
                m mVar3 = m.OK;
                AppMethodBeat.o(175601);
                return mVar3;
            }
        }
    };
    private final a kTq = new a() {
        /* class com.tencent.mm.plugin.appbrand.appstorage.z.AnonymousClass11 */

        @Override // com.tencent.mm.plugin.appbrand.appstorage.z.a
        public final m a(o oVar, Object... objArr) {
            Long l;
            Long l2;
            AppMethodBeat.i(175602);
            i iVar = (i) objArr[0];
            if (objArr.length >= 3) {
                l = (Long) objArr[2];
                l2 = (Long) objArr[1];
            } else {
                l = null;
                l2 = null;
            }
            if (!oVar.exists()) {
                m mVar = m.RET_NOT_EXISTS;
                AppMethodBeat.o(175602);
                return mVar;
            } else if (!oVar.isFile()) {
                m mVar2 = m.ERR_PERMISSION_DENIED;
                AppMethodBeat.o(175602);
                return mVar2;
            } else if (n.u(oVar)) {
                m mVar3 = m.ERR_SYMLINK;
                AppMethodBeat.o(175602);
                return mVar3;
            } else {
                if (iVar != null) {
                    if (l2 == null || l == null) {
                        iVar.value = (T) n.s(oVar);
                    } else {
                        m g2 = z.g(l2.longValue(), l.longValue(), oVar.length());
                        if (g2 != m.OK) {
                            AppMethodBeat.o(175602);
                            return g2;
                        }
                        if (l.longValue() == MAlarmHandler.NEXT_FIRE_INTERVAL) {
                            l = Long.valueOf(oVar.length() - l2.longValue());
                        }
                        iVar.value = (T) n.a(oVar, l2.longValue(), l.longValue());
                    }
                }
                m mVar4 = m.OK;
                AppMethodBeat.o(175602);
                return mVar4;
            }
        }
    };
    private final a kTr = new a() {
        /* class com.tencent.mm.plugin.appbrand.appstorage.z.AnonymousClass12 */

        @Override // com.tencent.mm.plugin.appbrand.appstorage.z.a
        public final m a(o oVar, Object... objArr) {
            AppMethodBeat.i(175603);
            if (n.u(oVar)) {
                m mVar = m.ERR_SYMLINK;
                AppMethodBeat.o(175603);
                return mVar;
            }
            InputStream inputStream = (InputStream) objArr[0];
            boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
            if (inputStream instanceof ZipInputStream) {
                if (n.a((ZipInputStream) inputStream, aa.z(oVar.her())) != 0) {
                    m mVar2 = m.ERR_OP_FAIL;
                    AppMethodBeat.o(175603);
                    return mVar2;
                } else if (z.this.kTk <= 0 || z.this.bxD() <= z.this.kTk) {
                    m mVar3 = m.OK;
                    AppMethodBeat.o(175603);
                    return mVar3;
                } else {
                    oVar.delete();
                    m mVar4 = m.ERR_EXCEED_DIRECTORY_MAX_SIZE;
                    AppMethodBeat.o(175603);
                    return mVar4;
                }
            } else if (oVar.isDirectory()) {
                m mVar5 = m.RET_ALREADY_EXISTS;
                AppMethodBeat.o(175603);
                return mVar5;
            } else {
                if (z.this.kTk > 0) {
                    try {
                        if (((long) inputStream.available()) + z.this.bxD() > z.this.kTk) {
                            m mVar6 = m.ERR_EXCEED_DIRECTORY_MAX_SIZE;
                            AppMethodBeat.o(175603);
                            return mVar6;
                        }
                    } catch (Exception e2) {
                        Log.e("MicroMsg.LuggageNonFlattenedFileSystem", "writeFile, access available e=%s", e2);
                        m mVar7 = m.ERR_OP_FAIL;
                        AppMethodBeat.o(175603);
                        return mVar7;
                    }
                }
                if (oVar.exists() || !booleanValue) {
                    OutputStream outputStream = null;
                    try {
                        outputStream = s.dw(aa.z(oVar.her()), booleanValue);
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = inputStream.read(bArr, 0, 4096);
                            if (read != -1) {
                                outputStream.write(bArr, 0, read);
                            } else {
                                outputStream.flush();
                                return m.OK;
                            }
                        }
                    } catch (Exception e3) {
                        Log.i("MicroMsg.LuggageNonFlattenedFileSystem", "writeFile exp %s", e3);
                        return m.ERR_OP_FAIL;
                    } finally {
                        Util.qualityClose(outputStream);
                        Util.qualityClose(inputStream);
                        AppMethodBeat.o(175603);
                    }
                } else {
                    m mVar8 = m.RET_NOT_EXISTS;
                    AppMethodBeat.o(175603);
                    return mVar8;
                }
            }
        }
    };
    private final b kTs = new b() {
        /* class com.tencent.mm.plugin.appbrand.appstorage.z.AnonymousClass13 */

        @Override // com.tencent.mm.plugin.appbrand.appstorage.z.b
        public final m v(o oVar) {
            AppMethodBeat.i(175604);
            if (oVar.isDirectory()) {
                m mVar = m.ERR_IS_DIRECTORY;
                AppMethodBeat.o(175604);
                return mVar;
            } else if (!oVar.exists()) {
                m mVar2 = m.RET_NOT_EXISTS;
                AppMethodBeat.o(175604);
                return mVar2;
            } else {
                int Wg = FileUnlink.Wg(aa.z(oVar.mUri));
                if (Wg != 0) {
                    Log.e("MicroMsg.LuggageNonFlattenedFileSystem", "unlink err %d, %s", Integer.valueOf(Wg), aa.z(oVar.mUri));
                }
                if (Wg == 0) {
                    m mVar3 = m.OK;
                    AppMethodBeat.o(175604);
                    return mVar3;
                }
                m mVar4 = m.ERR_OP_FAIL;
                AppMethodBeat.o(175604);
                return mVar4;
            }
        }
    };
    private final a kTt = new a() {
        /* class com.tencent.mm.plugin.appbrand.appstorage.z.AnonymousClass14 */

        @Override // com.tencent.mm.plugin.appbrand.appstorage.z.a
        public final m a(o oVar, Object... objArr) {
            AppMethodBeat.i(175605);
            if (!oVar.exists()) {
                m mVar = m.RET_NOT_EXISTS;
                AppMethodBeat.o(175605);
                return mVar;
            }
            int b2 = FileStat.b(aa.z(oVar.mUri), (FileStructStat) objArr[0]);
            if (b2 != 0) {
                Log.e("MicroMsg.LuggageNonFlattenedFileSystem", "stat err %d, %s", Integer.valueOf(b2), aa.z(oVar.mUri));
            }
            if (b2 == 0) {
                m mVar2 = m.OK;
                AppMethodBeat.o(175605);
                return mVar2;
            }
            m mVar3 = m.ERR_OP_FAIL;
            AppMethodBeat.o(175605);
            return mVar3;
        }
    };
    private final a kTu = new a() {
        /* class com.tencent.mm.plugin.appbrand.appstorage.z.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.appbrand.appstorage.z.a
        public final m a(o oVar, Object... objArr) {
            AppMethodBeat.i(175593);
            if (!oVar.isDirectory()) {
                m mVar = m.ERR_NOT_SUPPORTED;
                AppMethodBeat.o(175593);
                return mVar;
            }
            final List list = (List) objArr[0];
            final String quote = Pattern.quote(aa.z(oVar.her()));
            n.a(oVar, new q() {
                /* class com.tencent.mm.plugin.appbrand.appstorage.z.AnonymousClass2.AnonymousClass1 */

                @Override // com.tencent.mm.vfs.q
                public final boolean accept(o oVar) {
                    AppMethodBeat.i(175592);
                    boolean z = !oVar.getName().endsWith(FilePathGenerator.NO_MEDIA_FILENAME);
                    if (z && !oVar.isDirectory()) {
                        x xVar = new x(n.Wd(aa.z(oVar.her()).replaceFirst(quote, "")));
                        FileStat.b(aa.z(oVar.her()), xVar);
                        list.add(xVar);
                    }
                    AppMethodBeat.o(175592);
                    return z;
                }
            });
            m mVar2 = m.OK;
            AppMethodBeat.o(175593);
            return mVar2;
        }
    };
    private final a kTv = new a() {
        /* class com.tencent.mm.plugin.appbrand.appstorage.z.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.appbrand.appstorage.z.a
        public final m a(o oVar, Object... objArr) {
            AppMethodBeat.i(175594);
            o oVar2 = (o) objArr[0];
            boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
            if (oVar.isDirectory()) {
                m mVar = m.RET_ALREADY_EXISTS;
                AppMethodBeat.o(175594);
                return mVar;
            } else if (n.u(oVar)) {
                m mVar2 = m.ERR_SYMLINK;
                AppMethodBeat.o(175594);
                return mVar2;
            } else if (z.this.kTk > 0 && z.this.bxD() + oVar2.length() > z.this.kTk) {
                m mVar3 = m.ERR_EXCEED_DIRECTORY_MAX_SIZE;
                AppMethodBeat.o(175594);
                return mVar3;
            } else if (booleanValue) {
                if (l.cE(aa.z(oVar2.her()), aa.z(oVar.her()))) {
                    m mVar4 = m.OK;
                    AppMethodBeat.o(175594);
                    return mVar4;
                }
                m mVar5 = m.ERR_OP_FAIL;
                AppMethodBeat.o(175594);
                return mVar5;
            } else if (FilesCopy.copy(aa.z(oVar2.her()), aa.z(oVar.her()), false)) {
                m mVar6 = m.OK;
                AppMethodBeat.o(175594);
                return mVar6;
            } else {
                m mVar7 = m.ERR_OP_FAIL;
                AppMethodBeat.o(175594);
                return mVar7;
            }
        }
    };
    private final a kTw = new a() {
        /* class com.tencent.mm.plugin.appbrand.appstorage.z.AnonymousClass4 */

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.tencent.mm.vfs.o */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mm.plugin.appbrand.appstorage.z.a
        public final m a(o oVar, Object... objArr) {
            ((i) objArr[0]).value = oVar;
            return m.OK;
        }
    };
    private final a kTx = new a() {
        /* class com.tencent.mm.plugin.appbrand.appstorage.z.AnonymousClass5 */

        @Override // com.tencent.mm.plugin.appbrand.appstorage.z.a
        public final m a(o oVar, Object... objArr) {
            AppMethodBeat.i(175595);
            if (n.u(oVar)) {
                m mVar = m.ERR_SYMLINK;
                AppMethodBeat.o(175595);
                return mVar;
            } else if (!oVar.isFile() || !oVar.exists()) {
                o oVar2 = (o) objArr[0];
                int vfsUnzip = ZipJNI.vfsUnzip(aa.z(oVar2.her()), aa.z(oVar.her()), null);
                Log.i("MicroMsg.LuggageNonFlattenedFileSystem", "unzip zipFile(%s) iRet(%d)", aa.z(oVar2.her()), Integer.valueOf(vfsUnzip));
                if (vfsUnzip != 0) {
                    switch (vfsUnzip) {
                        case -106:
                            m mVar2 = m.ERR_WRITE_ZIP_ENTRY;
                            AppMethodBeat.o(175595);
                            return mVar2;
                        case -105:
                        case -104:
                        case -103:
                        case -102:
                        case -1:
                        case 2:
                            m mVar3 = m.ERR_BAD_ZIP_FILE;
                            AppMethodBeat.o(175595);
                            return mVar3;
                        case 1:
                            m mVar4 = m.ERR_PERMISSION_DENIED;
                            AppMethodBeat.o(175595);
                            return mVar4;
                        default:
                            m mVar5 = m.ERR_OP_FAIL;
                            AppMethodBeat.o(175595);
                            return mVar5;
                    }
                } else if (z.this.kTk <= 0 || z.this.bxD() <= z.this.kTk) {
                    m mVar6 = m.OK;
                    AppMethodBeat.o(175595);
                    return mVar6;
                } else {
                    n.t(oVar);
                    m mVar7 = m.ERR_EXCEED_DIRECTORY_MAX_SIZE;
                    AppMethodBeat.o(175595);
                    return mVar7;
                }
            } else {
                m mVar8 = m.RET_ALREADY_EXISTS;
                AppMethodBeat.o(175595);
                return mVar8;
            }
        }
    };

    /* access modifiers changed from: package-private */
    public interface a {
        m a(o oVar, Object... objArr);
    }

    public z(String str, String str2) {
        AppMethodBeat.i(134418);
        this.kSr = str;
        this.kTj = str2;
        Log.i("MicroMsg.LuggageNonFlattenedFileSystem", "mRootPath:%s mPathPrefix:%s", this.kSr, this.kTj);
        AppMethodBeat.o(134418);
    }

    public final String getRootPath() {
        return this.kSr;
    }

    public final String bxB() {
        return this.kTj;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final boolean Vi(String str) {
        AppMethodBeat.i(134419);
        boolean startsWith = Util.nullAsNil(str).startsWith(this.kTj);
        AppMethodBeat.o(134419);
        return startsWith;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final boolean VZ(String str) {
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final void initialize() {
        AppMethodBeat.i(134420);
        o bxC = bxC();
        if (bxC == null || !bxC.exists()) {
            Log.e("MicroMsg.LuggageNonFlattenedFileSystem", "Initialization Failed");
        }
        AppMethodBeat.o(134420);
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final void release() {
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.j
    public final void bxq() {
        AppMethodBeat.i(134421);
        o oVar = new o(this.kSr);
        n.t(oVar);
        if (oVar.exists()) {
            oVar.delete();
        }
        AppMethodBeat.o(134421);
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m a(i<String> iVar) {
        return m.ERR_NOT_SUPPORTED;
    }

    /* access modifiers changed from: package-private */
    public final o bxC() {
        AppMethodBeat.i(175606);
        if (TextUtils.isEmpty(this.kSr)) {
            AppMethodBeat.o(175606);
            return null;
        }
        o oVar = new o(this.kSr);
        if (oVar.exists() && oVar.isFile()) {
            oVar.delete();
        }
        oVar.mkdirs();
        try {
            new o(aa.z(oVar.mUri) + "/.nomedia").createNewFile();
        } catch (Exception e2) {
        }
        AppMethodBeat.o(175606);
        return oVar;
    }

    /* access modifiers changed from: package-private */
    public abstract class b implements a {
        public abstract m v(o oVar);

        private b() {
        }

        /* synthetic */ b(z zVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.appstorage.z.a
        public final m a(o oVar, Object... objArr) {
            return v(oVar);
        }
    }

    private m a(String str, a aVar, boolean z, Object... objArr) {
        boolean z2;
        AppMethodBeat.i(134423);
        if (Util.isNullOrNil(str)) {
            m mVar = m.ERR_PERMISSION_DENIED;
            AppMethodBeat.o(134423);
            return mVar;
        }
        String str2 = this.kTj.endsWith(FilePathGenerator.ANDROID_DIR_SEP) ? this.kTj : this.kTj + FilePathGenerator.ANDROID_DIR_SEP;
        if (!str.equals(this.kTj)) {
            if (!str.startsWith(str2)) {
                m mVar2 = m.ERR_PERMISSION_DENIED;
                AppMethodBeat.o(134423);
                return mVar2;
            }
            str2 = str;
        }
        String replace = n.Wd(str2.replaceFirst(Pattern.quote(this.kTj), "")).replace("\u0000", "");
        o bxC = bxC();
        if (bxC == null) {
            m mVar3 = m.ERR_FS_NOT_MOUNTED;
            AppMethodBeat.o(134423);
            return mVar3;
        }
        String oH = d.oH(aa.z(bxC.her()), replace);
        if (Util.isNullOrNil(oH)) {
            m mVar4 = m.ERR_PERMISSION_DENIED;
            AppMethodBeat.o(134423);
            return mVar4;
        }
        o oVar = new o(oH);
        o bxC2 = bxC();
        if (bxC2 == null || !b(bxC2, oVar)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            m mVar5 = m.ERR_PERMISSION_DENIED;
            AppMethodBeat.o(134423);
            return mVar5;
        } else if (z || oVar.heq().exists()) {
            m a2 = aVar.a(oVar, objArr);
            AppMethodBeat.o(134423);
            return a2;
        } else {
            m mVar6 = m.ERR_PARENT_DIR_NOT_EXISTS;
            AppMethodBeat.o(134423);
            return mVar6;
        }
    }

    private m a(String str, a aVar, Object... objArr) {
        AppMethodBeat.i(134424);
        m a2 = a(str, aVar, false, objArr);
        AppMethodBeat.o(134424);
        return a2;
    }

    private static boolean b(o oVar, o oVar2) {
        AppMethodBeat.i(182985);
        while (oVar2 != null) {
            if (oVar.equals(oVar2)) {
                AppMethodBeat.o(182985);
                return true;
            }
            oVar2 = oVar2.heq();
        }
        AppMethodBeat.o(182985);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m Vj(String str) {
        AppMethodBeat.i(134426);
        m a2 = a(str, this.kTl, new Object[0]);
        AppMethodBeat.o(134426);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m Vl(String str) {
        AppMethodBeat.i(134427);
        m a2 = a(str, this.kTm, new Object[0]);
        AppMethodBeat.o(134427);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m ai(String str, boolean z) {
        AppMethodBeat.i(134428);
        m a2 = a(str, this.kTn, z, Boolean.valueOf(z));
        AppMethodBeat.o(134428);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m aj(String str, boolean z) {
        AppMethodBeat.i(134429);
        m a2 = a(str, this.kTo, z, Boolean.valueOf(z));
        AppMethodBeat.o(134429);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m a(String str, i<List<k>> iVar) {
        AppMethodBeat.i(134430);
        m a2 = a(str, this.kTp, iVar);
        AppMethodBeat.o(134430);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m b(String str, i<ByteBuffer> iVar) {
        AppMethodBeat.i(134431);
        m a2 = a(str, this.kTq, iVar);
        AppMethodBeat.o(134431);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m a(String str, long j2, long j3, i<ByteBuffer> iVar) {
        AppMethodBeat.i(134432);
        m a2 = a(str, this.kTq, iVar, Long.valueOf(j2), Long.valueOf(j3));
        AppMethodBeat.o(134432);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m a(String str, InputStream inputStream, boolean z) {
        AppMethodBeat.i(134433);
        if (inputStream == null) {
            m mVar = m.ERR_OP_FAIL;
            AppMethodBeat.o(134433);
            return mVar;
        }
        m a2 = a(str, this.kTr, inputStream, Boolean.valueOf(z));
        AppMethodBeat.o(134433);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m VX(String str) {
        AppMethodBeat.i(134434);
        m a2 = a(str, this.kTs, new Object[0]);
        AppMethodBeat.o(134434);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m a(String str, FileStructStat fileStructStat) {
        AppMethodBeat.i(134435);
        m a2 = a(str, this.kTt, fileStructStat);
        AppMethodBeat.o(134435);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m h(String str, List<x> list) {
        AppMethodBeat.i(134436);
        m a2 = a(str, this.kTu, list);
        AppMethodBeat.o(134436);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m a(String str, o oVar, boolean z) {
        AppMethodBeat.i(175607);
        m a2 = a(str, this.kTv, oVar, Boolean.valueOf(z));
        AppMethodBeat.o(175607);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final o ag(String str, boolean z) {
        AppMethodBeat.i(175608);
        i iVar = new i();
        a(str, this.kTw, iVar);
        T t = iVar.value;
        if (t == null) {
            Log.e("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), get null file", str);
            AppMethodBeat.o(175608);
            return null;
        } else if (!t.exists()) {
            Log.e("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), file not exists", str);
            AppMethodBeat.o(175608);
            return null;
        } else if (!z && !t.isFile()) {
            Log.e("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), not a file", str);
            AppMethodBeat.o(175608);
            return null;
        } else if (n.u(t)) {
            Log.e("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), symlink file", str);
            AppMethodBeat.o(175608);
            return null;
        } else {
            AppMethodBeat.o(175608);
            return t;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m a(String str, o oVar) {
        AppMethodBeat.i(175609);
        m a2 = a(str, this.kTx, oVar);
        AppMethodBeat.o(175609);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final long bxD() {
        AppMethodBeat.i(196180);
        long q = n.q(new o(this.kSr));
        AppMethodBeat.o(196180);
        return q;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m a(o oVar, String str, boolean z, i<String> iVar) {
        return m.ERR_NOT_SUPPORTED;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m a(final o oVar, final String str, final i<String> iVar) {
        AppMethodBeat.i(175610);
        if (!Vi(str)) {
            m mVar = m.ERR_NOT_SUPPORTED;
            AppMethodBeat.o(175610);
            return mVar;
        } else if (oVar == null || !oVar.exists()) {
            m mVar2 = m.ERR_OP_FAIL;
            AppMethodBeat.o(175610);
            return mVar2;
        } else if (TextUtils.isEmpty(str)) {
            m mVar3 = m.ERR_NOT_SUPPORTED;
            AppMethodBeat.o(175610);
            return mVar3;
        } else {
            long bxD = bxD() + oVar.length();
            if (this.kTk <= 0 || bxD <= this.kTk) {
                m Vl = Vl(str);
                if (Vl == m.RET_NOT_EXISTS || Vl == m.ERR_IS_FILE) {
                    try {
                        m a2 = a(str, new a() {
                            /* class com.tencent.mm.plugin.appbrand.appstorage.z.AnonymousClass6 */

                            @Override // com.tencent.mm.plugin.appbrand.appstorage.z.a
                            public final m a(o oVar, Object... objArr) {
                                AppMethodBeat.i(175596);
                                oVar.delete();
                                l.cE(aa.z(oVar.her()), aa.z(oVar.her()));
                                if (iVar != null) {
                                    iVar.value = (T) str;
                                }
                                m mVar = m.OK;
                                AppMethodBeat.o(175596);
                                return mVar;
                            }
                        }, new Object[0]);
                        AppMethodBeat.o(175610);
                        return a2;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.LuggageNonFlattenedFileSystem", e2, "saveFile() error", new Object[0]);
                        m mVar4 = m.ERR_OP_FAIL;
                        AppMethodBeat.o(175610);
                        return mVar4;
                    }
                } else {
                    AppMethodBeat.o(175610);
                    return Vl;
                }
            } else {
                Log.e("MicroMsg.LuggageNonFlattenedFileSystem", "saveFile exceed directory max size, MAX_SIZE[%d MB], TOTAL_SIZE[%d MB]", Long.valueOf(this.kTk / 1048576), Long.valueOf(bxD / 1048576));
                m mVar5 = m.ERR_EXCEED_DIRECTORY_MAX_SIZE;
                AppMethodBeat.o(175610);
                return mVar5;
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final List<q.a> bxs() {
        return null;
    }
}
