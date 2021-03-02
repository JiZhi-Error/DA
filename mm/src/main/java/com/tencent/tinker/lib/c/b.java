package com.tencent.tinker.lib.c;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareArkHotDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipFile;

public final class b extends c {
    private static ArrayList<ShareArkHotDiffPatchInfo> SjB = new ArrayList<>();

    protected static boolean a(ShareSecurityCheck shareSecurityCheck, Context context, String str, File file) {
        String str2 = shareSecurityCheck.getMetaContentMap().get(ShareConstants.ARKHOT_META_FILE);
        if (str2 != null) {
            SjB.clear();
            ShareArkHotDiffPatchInfo.parseDiffPatchInfo(str2, SjB);
            b(context, str + "/arkHot/", file);
        }
        return true;
    }

    private static boolean b(Context context, String str, File file) {
        ZipFile zipFile;
        ZipFile zipFile2;
        String str2;
        a lk = a.lk(context);
        try {
            zipFile2 = new ZipFile(file);
            try {
                Iterator<ShareArkHotDiffPatchInfo> it = SjB.iterator();
                while (it.hasNext()) {
                    ShareArkHotDiffPatchInfo next = it.next();
                    String str3 = next.path;
                    if (str3.equals("")) {
                        str2 = next.name;
                    } else {
                        str2 = str3 + FilePathGenerator.ANDROID_DIR_SEP + next.name;
                    }
                    String str4 = next.patchMd5;
                    if (!SharePatchFileUtil.checkIfMd5Valid(str4)) {
                        lk.SjV.e(file, c.asu(8));
                        SharePatchFileUtil.closeZip(zipFile2);
                        return false;
                    }
                    File file2 = new File(str + next.name);
                    if (!file2.exists()) {
                        file2.getParentFile().mkdirs();
                    } else if (!str4.equals(SharePatchFileUtil.getMD5(file2))) {
                        file2.delete();
                    } else {
                        continue;
                    }
                    if (!a(zipFile2, zipFile2.getEntry(str2), file2, str4, false)) {
                        lk.SjV.a(file, file2, next.name, 8);
                        SharePatchFileUtil.closeZip(zipFile2);
                        return false;
                    }
                }
                SharePatchFileUtil.closeZip(zipFile2);
                return true;
            } catch (IOException e2) {
                e = e2;
                zipFile = zipFile2;
                try {
                    throw new TinkerRuntimeException("patch " + ShareTinkerInternals.getTypeString(8) + " extract failed (" + e.getMessage() + ").", e);
                } catch (Throwable th) {
                    th = th;
                    zipFile2 = zipFile;
                    SharePatchFileUtil.closeZip(zipFile2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                SharePatchFileUtil.closeZip(zipFile2);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            zipFile = null;
            throw new TinkerRuntimeException("patch " + ShareTinkerInternals.getTypeString(8) + " extract failed (" + e.getMessage() + ").", e);
        } catch (Throwable th3) {
            th = th3;
            zipFile2 = null;
            SharePatchFileUtil.closeZip(zipFile2);
            throw th;
        }
    }
}
