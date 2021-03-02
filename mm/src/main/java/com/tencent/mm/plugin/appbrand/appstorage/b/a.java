package com.tencent.mm.plugin.appbrand.appstorage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.FileStat;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bJ\u001b\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0002¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/AppBrandFileUtilsCompat;", "", "()V", "TAG", "", "cleanDirectory", "", "directory", "Ljava/io/File;", "deleteDirectory", "forceDelete", "file", "isSymlink", "", "moveDirectory", "srcDir", "destDir", "verifiedListFiles", "", "(Ljava/io/File;)[Ljava/io/File;", "plugin-appbrand-integration_release"})
public final class a {
    public static final a kTL = new a();

    static {
        AppMethodBeat.i(228118);
        AppMethodBeat.o(228118);
    }

    private a() {
    }

    public final void deleteDirectory(File file) {
        AppMethodBeat.i(228116);
        p.h(file, "directory");
        if (!file.exists()) {
            AppMethodBeat.o(228116);
            return;
        }
        if (!F(file)) {
            if (!file.exists()) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(file + " does not exist");
                AppMethodBeat.o(228116);
                throw illegalArgumentException;
            } else if (!file.isDirectory()) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(file + " is not a directory");
                AppMethodBeat.o(228116);
                throw illegalArgumentException2;
            } else {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    IOException iOException = new IOException("Failed to list contents of ".concat(String.valueOf(file)));
                    AppMethodBeat.o(228116);
                    throw iOException;
                }
                IOException e2 = null;
                for (File file2 : listFiles) {
                    try {
                        if (file2.isDirectory()) {
                            deleteDirectory(file2);
                        } else {
                            boolean exists = file2.exists();
                            if (!file2.delete()) {
                                if (!exists) {
                                    FileNotFoundException fileNotFoundException = new FileNotFoundException("File does not exist: ".concat(String.valueOf(file2)));
                                    AppMethodBeat.o(228116);
                                    throw fileNotFoundException;
                                }
                                IOException iOException2 = new IOException("Unable to delete file: ".concat(String.valueOf(file2)));
                                AppMethodBeat.o(228116);
                                throw iOException2;
                            }
                        }
                    } catch (IOException e3) {
                        e2 = e3;
                    }
                }
                if (e2 != null) {
                    IOException iOException3 = e2;
                    AppMethodBeat.o(228116);
                    throw iOException3;
                }
            }
        }
        if (!file.delete()) {
            IOException iOException4 = new IOException("Unable to delete directory " + file + '.');
            AppMethodBeat.o(228116);
            throw iOException4;
        }
        AppMethodBeat.o(228116);
    }

    private static boolean F(File file) {
        AppMethodBeat.i(228117);
        if (!file.exists()) {
            AppMethodBeat.o(228117);
            return false;
        }
        try {
            FileStructStat fileStructStat = new FileStructStat();
            if (FileStat.stat(file.getAbsolutePath(), fileStructStat) == 0) {
                Log.i("MicroMsg.AppBrandFileUtilsCompat", "constainsSymLink, path %s, stat.st_mode %d", file.getAbsolutePath(), Integer.valueOf(fileStructStat.st_mode));
                boolean isSymLink = fileStructStat.isSymLink();
                AppMethodBeat.o(228117);
                return isSymLink;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandFileUtilsCompat", e2, "", new Object[0]);
        }
        AppMethodBeat.o(228117);
        return false;
    }
}
