package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.File;

public class FileProviderHelper {
    private static final String TAG = "MicroMsg.FileProviderHelper";

    public static void setIntentDataAndType(Context context, Intent intent, Uri uri, String str, boolean z) {
        AppMethodBeat.i(200844);
        String scheme = uri.getScheme();
        if (scheme == null || scheme.isEmpty() || scheme.equals("file") || scheme.equals("wcf")) {
            setIntentDataAndType(context, intent, new o(uri.getPath()), str, z);
            AppMethodBeat.o(200844);
            return;
        }
        intent.setDataAndType(uri, str);
        intent.addFlags(1);
        if (z) {
            intent.addFlags(2);
        }
        AppMethodBeat.o(200844);
    }

    public static Uri getUriForFileWithoutVFSRemap(Context context, File file) {
        Uri uri;
        AppMethodBeat.i(200845);
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                uri = FileProvider.getUriForFile(context, context.getPackageName() + ".external.fileprovider", file);
            } else {
                uri = Uri.fromFile(file);
            }
        } catch (Throwable th) {
            Log.printErrStackTrace(TAG, th, "[-] Fail to call getUriForFileWithoutVFSRemap", new Object[0]);
            uri = null;
        }
        AppMethodBeat.o(200845);
        return uri;
    }

    public static void setIntentDataAndType(Context context, Intent intent, o oVar, String str, boolean z) {
        Uri fromFile;
        AppMethodBeat.i(200843);
        String k = s.k(aa.z(oVar.mUri), false);
        if (k == null) {
            fromFile = null;
        } else if (Build.VERSION.SDK_INT >= 24) {
            fromFile = FileProvider.getUriForFile(context, context.getPackageName() + ".external.fileprovider", new File(k));
        } else {
            fromFile = Uri.fromFile(new File(k));
        }
        if (!BuildInfo.IS_FLAVOR_RED || fromFile != null) {
            int i2 = 1;
            if (z) {
                i2 = 3;
            }
            intent.setDataAndType(fromFile, str).addFlags(i2);
            AppMethodBeat.o(200843);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Path cannot be exported via provider: ".concat(String.valueOf(oVar)));
        AppMethodBeat.o(200843);
        throw illegalArgumentException;
    }

    public static Uri getUriForFile(Context context, o oVar) {
        Uri fromFile;
        AppMethodBeat.i(156179);
        String k = s.k(aa.z(oVar.mUri), false);
        if (k == null) {
            fromFile = null;
        } else if (Build.VERSION.SDK_INT >= 24) {
            fromFile = FileProvider.getUriForFile(context, context.getPackageName() + ".external.fileprovider", new File(k));
        } else {
            fromFile = Uri.fromFile(new File(k));
        }
        AppMethodBeat.o(156179);
        return fromFile;
    }
}
