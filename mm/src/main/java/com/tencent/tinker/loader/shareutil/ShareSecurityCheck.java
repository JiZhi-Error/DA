package com.tencent.tinker.loader.shareutil;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.File;
import java.security.cert.Certificate;
import java.util.HashMap;

public class ShareSecurityCheck {
    private static final String TAG = "Tinker.SecurityCheck";
    private static String mPublicKeyMd5 = null;
    private final Context mContext;
    private final HashMap<String, String> metaContentMap = new HashMap<>();
    private final HashMap<String, String> packageProperties = new HashMap<>();

    public ShareSecurityCheck(Context context) {
        this.mContext = context;
        if (mPublicKeyMd5 == null) {
            init(this.mContext);
        }
    }

    public HashMap<String, String> getMetaContentMap() {
        return this.metaContentMap;
    }

    public HashMap<String, String> getPackagePropertiesIfPresent() {
        String[] split;
        if (!this.packageProperties.isEmpty()) {
            return this.packageProperties;
        }
        String str = this.metaContentMap.get(ShareConstants.PACKAGE_META_FILE);
        if (str == null) {
            return null;
        }
        String[] split2 = str.split("\n");
        for (String str2 : split2) {
            if (str2 != null && str2.length() > 0 && !str2.startsWith("#") && (split = str2.split("=", 2)) != null && split.length >= 2) {
                this.packageProperties.put(split[0].trim(), split[1].trim());
            }
        }
        return this.packageProperties;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x009e A[SYNTHETIC, Splitter:B:37:0x009e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean verifyPatchMetaSignature(java.io.File r11) {
        /*
        // Method dump skipped, instructions count: 183
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.ShareSecurityCheck.verifyPatchMetaSignature(java.io.File):boolean");
    }

    private boolean check(File file, Certificate[] certificateArr) {
        if (certificateArr.length > 0) {
            for (int length = certificateArr.length - 1; length >= 0; length--) {
                try {
                    if (mPublicKeyMd5.equals(SharePatchFileUtil.getMD5(certificateArr[length].getEncoded()))) {
                        return true;
                    }
                } catch (Exception e2) {
                    ShareTinkerLog.e(TAG, file.getAbsolutePath(), e2);
                }
            }
        }
        return false;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    private void init(Context context) {
        try {
            String md5 = SharePatchFileUtil.getMD5(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            mPublicKeyMd5 = md5;
            if (md5 == null) {
                throw new TinkerRuntimeException("get public key md5 is null");
            }
            SharePatchFileUtil.closeQuietly(null);
        } catch (Exception e2) {
            throw new TinkerRuntimeException("ShareSecurityCheck init public key fail", e2);
        } catch (Throwable th) {
            SharePatchFileUtil.closeQuietly(null);
            throw th;
        }
    }
}
