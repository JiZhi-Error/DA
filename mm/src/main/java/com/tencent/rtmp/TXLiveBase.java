package com.tencent.rtmp;

import android.content.Context;
import com.tencent.liteav.TXLiteAVExternalDecoderFactoryInterface;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.license.LicenceCheck;
import com.tencent.liteav.basic.license.f;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TXLiveBase {
    private static final String FILE_MD5_FFMPEG_ARM = "___md5_libtxffmpeg_arm_md5______";
    private static final String FILE_MD5_FFMPEG_V64 = "___md5_libtxffmpeg_v64_md5______";
    private static final String FILE_MD5_FFMPEG_V7A = "___md5_libtxffmpeg_v7a_md5______";
    private static final String FILE_MD5_LITEAV_ARM = "___md5_libliteavsdk_arm_md5_____";
    private static final String FILE_MD5_LITEAV_V64 = "___md5_libliteavsdk_v64_md5_____";
    private static final String FILE_MD5_LITEAV_V7A = "___md5_libliteavsdk_v7a_md5_____";
    private static final String FILE_MD5_SATURN_ARM = "___md5_libsaturn_arm_md5________";
    private static final String FILE_MD5_SATURN_V64 = "___md5_libsaturn_v64_md5________";
    private static final String FILE_MD5_SATURN_V7A = "___md5_libsaturn_v7a_md5________";
    private static final String FILE_MD5_TRAE_ARM = "___md5_libtraeimp_arm_md5_______";
    private static final String FILE_MD5_TRAE_V64 = "___md5_libtraeimp_v64_md5_______";
    private static final String FILE_MD5_TRAE_V7A = "___md5_libtraeimp_v7a_md5_______";
    private static final String TAG = "TXLiveBase";
    private static TXLiveBase instance = new TXLiveBase();
    private static ITXLiveBaseListener listener = null;

    static {
        AppMethodBeat.i(14238);
        AppMethodBeat.o(14238);
    }

    private TXLiveBase() {
    }

    public static TXLiveBase getInstance() {
        return instance;
    }

    public void setLicence(Context context, String str, String str2) {
        AppMethodBeat.i(14225);
        LicenceCheck.a().a(context, str, str2);
        AppMethodBeat.o(14225);
    }

    public String getLicenceInfo(Context context) {
        AppMethodBeat.i(14226);
        f fVar = new f();
        LicenceCheck.a().a(fVar, context);
        String str = fVar.f408a;
        AppMethodBeat.o(14226);
        return str;
    }

    public static void setListener(ITXLiveBaseListener iTXLiveBaseListener) {
        AppMethodBeat.i(14227);
        TXCLog.setListener(new a());
        listener = iTXLiveBaseListener;
        AppMethodBeat.o(14227);
    }

    public static void setLogLevel(int i2) {
        AppMethodBeat.i(14228);
        TXCLog.setLevel(i2);
        AppMethodBeat.o(14228);
    }

    public static void setConsoleEnabled(boolean z) {
        AppMethodBeat.i(14229);
        TXCLog.setConsoleEnabled(z);
        AppMethodBeat.o(14229);
    }

    public static void setAppVersion(String str) {
        AppMethodBeat.i(14230);
        TXCDRApi.txSetAppVersion(str);
        TXCCommonUtil.setAppVersion(str);
        AppMethodBeat.o(14230);
    }

    public static void setLibraryPath(String str) {
        AppMethodBeat.i(14231);
        com.tencent.liteav.basic.util.f.b(str);
        AppMethodBeat.o(14231);
    }

    public static boolean isLibraryPathValid(String str) {
        AppMethodBeat.i(14232);
        String fileMD5 = getFileMD5(str, "libliteavsdk.so");
        String fileMD52 = getFileMD5(str, "libsaturn.so");
        String fileMD53 = getFileMD5(str, "libtxffmpeg.so");
        String fileMD54 = getFileMD5(str, "libtraeimp-rtmp.so");
        new StringBuilder("MD5-CHECK-V64 libliteavsdk = ").append(fileMD5).append(" FILE_MD5_LITEAV_V64 = ___md5_libliteavsdk_v64_md5_____");
        new StringBuilder("MD5-CHECK-V64 libsaturn    = ").append(fileMD52).append(" FILE_MD5_SATURN_V64 = ___md5_libsaturn_v64_md5________");
        new StringBuilder("MD5-CHECK-V64 libtxffmpeg  = ").append(fileMD53).append(" FILE_MD5_FFMPEG_V64 = ___md5_libtxffmpeg_v64_md5______");
        new StringBuilder("MD5-CHECK-V64 libtraeimpl  = ").append(fileMD54).append(" FILE_MD5_TRAE_V64   = ___md5_libtraeimp_v64_md5_______");
        if (fileMD5 == null || !fileMD5.equalsIgnoreCase(FILE_MD5_LITEAV_V64) || fileMD52 == null || !fileMD52.equalsIgnoreCase(FILE_MD5_SATURN_V64) || fileMD53 == null || !fileMD53.equalsIgnoreCase(FILE_MD5_FFMPEG_V64) || fileMD54 == null || !fileMD54.equalsIgnoreCase(FILE_MD5_TRAE_V64)) {
            new StringBuilder("MD5-CHECK-V7A libliteavsdk = ").append(fileMD5).append(" FILE_MD5_LITEAV_V7A = ___md5_libliteavsdk_v7a_md5_____");
            new StringBuilder("MD5-CHECK-V7A libsaturn    = ").append(fileMD52).append(" FILE_MD5_SATURN_V7A = ___md5_libsaturn_v7a_md5________");
            new StringBuilder("MD5-CHECK-V7A libtxffmpeg  = ").append(fileMD53).append(" FILE_MD5_FFMPEG_V7A = ___md5_libtxffmpeg_v7a_md5______");
            new StringBuilder("MD5-CHECK-V7A libtraeimpl  = ").append(fileMD54).append(" FILE_MD5_TRAE_V7A   = ___md5_libtraeimp_v7a_md5_______");
            if (fileMD5 == null || !fileMD5.equalsIgnoreCase(FILE_MD5_LITEAV_V7A) || fileMD52 == null || !fileMD52.equalsIgnoreCase(FILE_MD5_SATURN_V7A) || fileMD53 == null || !fileMD53.equalsIgnoreCase(FILE_MD5_FFMPEG_V7A) || fileMD54 == null || !fileMD54.equalsIgnoreCase(FILE_MD5_TRAE_V7A)) {
                new StringBuilder("MD5-CHECK-ARM libliteavsdk = ").append(fileMD5).append(" FILE_MD5_LITEAV_ARM = ___md5_libliteavsdk_arm_md5_____");
                new StringBuilder("MD5-CHECK-ARM libsaturn    = ").append(fileMD52).append(" FILE_MD5_SATURN_ARM = ___md5_libsaturn_arm_md5________");
                new StringBuilder("MD5-CHECK-ARM libtxffmpeg  = ").append(fileMD53).append(" FILE_MD5_FFMPEG_ARM = ___md5_libtxffmpeg_arm_md5______");
                new StringBuilder("MD5-CHECK-ARM libtraeimpl  = ").append(fileMD54).append(" FILE_MD5_TRAE_ARM   = ___md5_libtraeimp_arm_md5_______");
                if (fileMD5 == null || !fileMD5.equalsIgnoreCase(FILE_MD5_LITEAV_ARM) || fileMD52 == null || !fileMD52.equalsIgnoreCase(FILE_MD5_SATURN_ARM) || fileMD53 == null || !fileMD53.equalsIgnoreCase(FILE_MD5_FFMPEG_ARM) || fileMD54 == null || !fileMD54.equalsIgnoreCase(FILE_MD5_TRAE_ARM)) {
                    AppMethodBeat.o(14232);
                    return false;
                }
                AppMethodBeat.o(14232);
                return true;
            }
            AppMethodBeat.o(14232);
            return true;
        }
        AppMethodBeat.o(14232);
        return true;
    }

    public static void setExternalDecoderFactory(TXLiteAVExternalDecoderFactoryInterface tXLiteAVExternalDecoderFactoryInterface) {
        AppMethodBeat.i(259970);
        com.tencent.liteav.basic.a.a(tXLiteAVExternalDecoderFactoryInterface);
        AppMethodBeat.o(259970);
    }

    public static String getSDKVersionStr() {
        AppMethodBeat.i(14233);
        String sDKVersionStr = TXCCommonUtil.getSDKVersionStr();
        AppMethodBeat.o(14233);
        return sDKVersionStr;
    }

    public static void setPituLicencePath(String str) {
        AppMethodBeat.i(14234);
        TXCCommonUtil.setPituLicencePath(str);
        AppMethodBeat.o(14234);
    }

    public static String getPituSDKVersion() {
        AppMethodBeat.i(14235);
        String a2 = p.a();
        AppMethodBeat.o(14235);
        return a2;
    }

    public static void setAppID(String str) {
        AppMethodBeat.i(14236);
        TXCCommonUtil.setAppID(str);
        AppMethodBeat.o(14236);
    }

    /* access modifiers changed from: package-private */
    public static class a implements TXCLog.a {
        private a() {
        }

        @Override // com.tencent.liteav.basic.log.TXCLog.a
        public void a(int i2, String str, String str2) {
            AppMethodBeat.i(13937);
            if (TXLiveBase.listener != null) {
                TXLiveBase.listener.OnLog(i2, str, str2);
            }
            AppMethodBeat.o(13937);
        }
    }

    private static String getFileMD5(String str, String str2) {
        MessageDigest messageDigest = null;
        AppMethodBeat.i(14237);
        File file = new File(str, str2);
        if (!file.exists() || !file.isFile()) {
            AppMethodBeat.o(14237);
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, 1024);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            fileInputStream.close();
        } catch (FileNotFoundException | IOException | NoSuchAlgorithmException e2) {
        }
        String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
        AppMethodBeat.o(14237);
        return bigInteger;
    }

    public static void setUserId(String str) {
        AppMethodBeat.i(222653);
        TXCCommonUtil.setUserId(str);
        AppMethodBeat.o(222653);
    }
}
