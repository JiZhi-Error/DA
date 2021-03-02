package org.extra.a;

import android.content.Context;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.extra.a.a.f;
import org.extra.a.c;

public final class d {
    protected final Set<String> UhB;
    protected final c.b UhC;
    protected final c.a UhD;
    protected boolean UhE;
    protected boolean edG;

    protected d() {
        this(new e(), new a());
        AppMethodBeat.i(236778);
        AppMethodBeat.o(236778);
    }

    private d(c.b bVar, c.a aVar) {
        AppMethodBeat.i(236779);
        this.UhB = new HashSet();
        this.UhC = bVar;
        this.UhD = aVar;
        AppMethodBeat.o(236779);
    }

    public final void dh(Context context, String str) {
        AppMethodBeat.i(236780);
        if (context == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Given context is null");
            AppMethodBeat.o(236780);
            throw illegalArgumentException;
        } else if (f.isEmpty(str)) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Given library is either null or empty");
            AppMethodBeat.o(236780);
            throw illegalArgumentException2;
        } else {
            t("Beginning load of %s...", str);
            ab(context, str, null);
            AppMethodBeat.o(236780);
        }
    }

    private void ab(Context context, String str, String str2) {
        f fVar;
        Throwable th;
        AppMethodBeat.i(236781);
        if (!this.UhB.contains(str) || this.edG) {
            try {
                this.UhC.loadLibrary(str);
                this.UhB.add(str);
                t("%s (%s) was loaded normally!", str, null);
                AppMethodBeat.o(236781);
            } catch (UnsatisfiedLinkError e2) {
                t("Loading the library normally failed: %s", Log.getStackTraceString(e2));
                t("%s (%s) was not loaded normally, re-linking...", str, null);
                File ac = ac(context, str, null);
                if (!ac.exists() || this.edG) {
                    if (this.edG) {
                        t("Forcing a re-link of %s (%s)...", str, null);
                    }
                    File dir = context.getDir(ShareConstants.SO_PATH, 0);
                    File ac2 = ac(context, str, null);
                    final String mapLibraryName = this.UhC.mapLibraryName(str);
                    File[] listFiles = dir.listFiles(new FilenameFilter() {
                        /* class org.extra.a.d.AnonymousClass1 */

                        public final boolean accept(File file, String str) {
                            AppMethodBeat.i(236777);
                            boolean startsWith = str.startsWith(mapLibraryName);
                            AppMethodBeat.o(236777);
                            return startsWith;
                        }
                    });
                    if (listFiles != null) {
                        for (File file : listFiles) {
                            if (this.edG || !file.getAbsolutePath().equals(ac2.getAbsolutePath())) {
                                try {
                                    file.delete();
                                } catch (SecurityException e3) {
                                }
                            }
                        }
                    }
                    this.UhD.a(context, this.UhC.hPR(), this.UhC.mapLibraryName(str), ac, this);
                }
                try {
                    if (this.UhE) {
                        fVar = new f(ac);
                        List<String> hPT = fVar.hPT();
                        fVar.close();
                        for (String str3 : hPT) {
                            dh(context, this.UhC.bvq(str3));
                        }
                    }
                } catch (IOException e4) {
                }
                this.UhC.bvp(ac.getAbsolutePath());
                this.UhB.add(str);
                t("%s (%s) was re-linked!", str, null);
                AppMethodBeat.o(236781);
            } catch (Throwable th2) {
                th = th2;
                fVar.close();
                AppMethodBeat.o(236781);
                throw th;
            }
        } else {
            t("%s already loaded previously!", str);
            AppMethodBeat.o(236781);
        }
    }

    private File ac(Context context, String str, String str2) {
        AppMethodBeat.i(236782);
        String mapLibraryName = this.UhC.mapLibraryName(str);
        if (f.isEmpty(str2)) {
            File file = new File(context.getDir(ShareConstants.SO_PATH, 0), mapLibraryName);
            AppMethodBeat.o(236782);
            return file;
        }
        File file2 = new File(context.getDir(ShareConstants.SO_PATH, 0), mapLibraryName + "." + str2);
        AppMethodBeat.o(236782);
        return file2;
    }

    public static void t(String str, Object... objArr) {
        AppMethodBeat.i(236783);
        String.format(Locale.US, str, objArr);
        AppMethodBeat.o(236783);
    }
}
