package com.tencent.mm.app;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.e.b;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;
import java.util.HashMap;

public final class s {
    static ApplicationLike dks;
    static String dlj = "";
    String dlk;
    String dll;
    long dlm;
    long dln;

    public s(ApplicationLike applicationLike) {
        dks = applicationLike;
        d.dks = applicationLike;
    }

    static void a(ApplicationLike applicationLike) {
        HashMap<String, String> hashMap;
        AppMethodBeat.i(125024);
        if (applicationLike == null) {
            AppMethodBeat.o(125024);
        } else if (applicationLike == null || applicationLike.getApplication() == null) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("tinkerApplication is null");
            AppMethodBeat.o(125024);
            throw tinkerRuntimeException;
        } else {
            Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
            if (tinkerResultIntent == null || ShareIntentUtil.getIntentReturnCode(tinkerResultIntent) != 0) {
                hashMap = null;
            } else {
                hashMap = ShareIntentUtil.getIntentPackageConfig(tinkerResultIntent);
            }
            if (hashMap != null) {
                a.ict = hashMap.get("patch.rev");
                a.icu = hashMap.get(ShareConstants.NEW_TINKER_ID);
                Log.w("MicroMsg.MMApplicationLikeImpl", "application set patch rev:%s patch tinkerId:%s ", a.ict, a.icu);
            }
            AppMethodBeat.o(125024);
        }
    }

    static final boolean D(File file) {
        AppMethodBeat.i(175407);
        if (file == null || !file.exists()) {
            AppMethodBeat.o(175407);
            return false;
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                AppMethodBeat.o(175407);
                return false;
            }
            for (File file2 : listFiles) {
                file2.delete();
            }
            AppMethodBeat.o(175407);
            return true;
        } else {
            AppMethodBeat.o(175407);
            return false;
        }
    }

    static String gd(String str) {
        AppMethodBeat.i(125025);
        try {
            File patchDirectory = SharePatchFileUtil.getPatchDirectory(dks.getApplication());
            String absolutePath = new File(new File(patchDirectory.getAbsolutePath(), SharePatchFileUtil.getPatchVersionDirectory(b.d(dks))).getAbsolutePath() + "/lib/lib/" + str).getAbsolutePath();
            AppMethodBeat.o(125025);
            return absolutePath;
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.MMApplicationLikeImpl", th, "[-] Fail to get patched native libs path.", new Object[0]);
            AppMethodBeat.o(125025);
            return null;
        }
    }
}
