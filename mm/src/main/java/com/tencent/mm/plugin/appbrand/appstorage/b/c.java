package com.tencent.mm.plugin.appbrand.appstorage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import org.apache.commons.a.b;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fJ \u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/AppBrandTransferTask;", "", "legacyPath", "", "targetPath", "(Ljava/lang/String;Ljava/lang/String;)V", "dirSpaceUsage", SharePatchInfo.OAT_DIR, "Ljava/io/File;", "executeSync", "Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/TransferTaskResult;", "hasLocalRecord", "", "hasSyncRecord", "fakeNative", "legacyDisapprove", "moveDir", "needLogSpaceForTest", "recursiveDelete", "Companion", "plugin-appbrand-integration_release"})
public final class c {
    @Deprecated
    public static final a kTR = new a((byte) 0);
    private final String kTP;
    private final String kTQ;

    static {
        AppMethodBeat.i(175122);
        AppMethodBeat.o(175122);
    }

    private /* synthetic */ c() {
        this("", "");
        AppMethodBeat.i(175121);
        AppMethodBeat.o(175121);
    }

    public c(String str, String str2) {
        p.h(str, "legacyPath");
        p.h(str2, "targetPath");
        AppMethodBeat.i(175120);
        this.kTP = str;
        this.kTQ = str2;
        AppMethodBeat.o(175120);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/AppBrandTransferTask$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private static boolean cL(String str, String str2) {
        AppMethodBeat.i(228121);
        File file = new File(str);
        File file2 = new File(str2);
        if (file2.exists() && file2.isDirectory()) {
            String[] list = file2.list();
            p.g(list, "targetFile.list()");
            if (list.length == 0) {
                file2.delete();
            } else {
                IllegalStateException illegalStateException = new IllegalStateException("transfer desc dir is exists");
                AppMethodBeat.o(228121);
                throw illegalStateException;
            }
        }
        if (!file.exists() || !file.isDirectory()) {
            IllegalStateException illegalStateException2 = new IllegalStateException("transfer src dir is not exists");
            AppMethodBeat.o(228121);
            throw illegalStateException2;
        }
        try {
            a aVar = a.kTL;
            p.h(file, "srcDir");
            p.h(file2, "destDir");
            if (!file.exists()) {
                FileNotFoundException fileNotFoundException = new FileNotFoundException("Source '" + file + "' does not exist");
                AppMethodBeat.o(228121);
                throw fileNotFoundException;
            } else if (!file.isDirectory()) {
                IOException iOException = new IOException("Source '" + file + "' is not a directory");
                AppMethodBeat.o(228121);
                throw iOException;
            } else if (file2.exists()) {
                b bVar = new b("Destination '" + file2 + "' already exists");
                AppMethodBeat.o(228121);
                throw bVar;
            } else {
                if (!file.renameTo(file2)) {
                    String canonicalPath = file2.getCanonicalPath();
                    p.g(canonicalPath, "destDir.canonicalPath");
                    if (n.J(canonicalPath, file.getCanonicalPath() + File.separator, false)) {
                        IOException iOException2 = new IOException("Cannot move directory: " + file + " to a subdirectory of itself: " + file2);
                        AppMethodBeat.o(228121);
                        throw iOException2;
                    }
                    org.apache.commons.a.c.h(file, file2);
                    aVar.deleteDirectory(file);
                    if (file.exists()) {
                        IOException iOException3 = new IOException("Failed to delete original directory '" + file + "' after copy to '" + file2 + "'");
                        AppMethodBeat.o(228121);
                        throw iOException3;
                    }
                }
                AppMethodBeat.o(228121);
                return true;
            }
        } catch (IOException e2) {
            Log.w("MicroMsg.AppBrand.AppBrandTransferTask", "moveDir: [%s]", e2.getMessage());
            AppMethodBeat.o(228121);
            return false;
        }
    }

    private static boolean G(File file) {
        AppMethodBeat.i(228122);
        try {
            a.kTL.deleteDirectory(file);
            AppMethodBeat.o(228122);
            return true;
        } catch (IOException e2) {
            Log.w("MicroMsg.AppBrand.AppBrandTransferTask", "recursiveDelete: [%s]", e2.getMessage());
            AppMethodBeat.o(228122);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0087 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d4 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00da A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0112 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.appbrand.appstorage.b.e d(boolean r13, boolean r14, boolean r15) {
        /*
        // Method dump skipped, instructions count: 435
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appstorage.b.c.d(boolean, boolean, boolean):com.tencent.mm.plugin.appbrand.appstorage.b.e");
    }
}
