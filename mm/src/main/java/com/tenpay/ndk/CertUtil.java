package com.tenpay.ndk;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.o;
import java.security.MessageDigest;

public class CertUtil {
    public static final String TAG = CertUtil.class.getSimpleName();
    private static CertUtil instance = null;
    private String cert_dir;
    private String cert_id = null;
    private byte[] certid_buf = null;
    private byte[] cipher_buf = null;
    private byte[] csr_buf = null;
    private String deskey = null;
    private EventListener eventListener = null;
    private String iccid = null;
    private String imei = null;
    private String imsi = null;
    private String login_ip = null;
    private Context mContext = null;
    private String mac = null;
    private String plain_buf = null;
    private byte[] plain_buf2 = null;
    private String priv_dir;
    private String publ_dir;
    private String qq_id = null;
    private byte[] sig_buf = null;
    private String sig_raw_buf = null;
    private String sm4Key = null;
    private String softid = null;
    private String svr_cert = null;
    private String token = null;
    private byte[] token_buf = null;
    private String token_dir;
    private int token_len = 0;
    private int useSM4 = 0;

    public interface EventListener {
        String getUniqueID();

        void onEvent(int i2, String str);
    }

    private native boolean encrypt();

    private native boolean genCertApplyCsr();

    private native boolean genCertApplyCsrNew(int i2);

    private native boolean genQrcode();

    private native boolean getCertid();

    private native boolean getToken();

    private native int getTokenCount();

    private native boolean importCert();

    private native boolean isCertExist();

    private native boolean setToken();

    private native boolean usrSig(byte[] bArr);

    public native int getLastError();

    static {
        AppMethodBeat.i(73316);
        AppMethodBeat.o(73316);
    }

    public void setEventListener(EventListener eventListener2) {
        this.eventListener = eventListener2;
    }

    private CertUtil() {
    }

    public static CertUtil getInstance() {
        AppMethodBeat.i(73288);
        if (instance == null) {
            synchronized (CertUtil.class) {
                try {
                    instance = new CertUtil();
                } catch (Throwable th) {
                    AppMethodBeat.o(73288);
                    throw th;
                }
            }
        }
        CertUtil certUtil = instance;
        AppMethodBeat.o(73288);
        return certUtil;
    }

    public void init(Context context, EventListener eventListener2) {
        AppMethodBeat.i(73289);
        this.eventListener = eventListener2;
        this.mContext = context.getApplicationContext();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (BuildInfo.IS_FLAVOR_RED) {
            try {
                Log.d(TAG, "READ_PHONE_STATE.getSubscriberId, %s", Util.getStack());
                this.imsi = telephonyManager.getSubscriberId();
                Log.d(TAG, "READ_PHONE_STATE.getSimSerialNumber", Util.getStack());
                this.iccid = telephonyManager.getSimSerialNumber();
                Log.d(TAG, "READ_PHONE_STATE.getDeviceId, %s", Util.getStack());
                this.imei = telephonyManager.getDeviceId();
                this.softid = Settings.System.getString(context.getContentResolver(), "android_id");
            } catch (Exception e2) {
            }
            this.deskey = eventListener2.getUniqueID();
            Log.d(TAG, "init deskey %s imei: %s", this.deskey, this.imei);
        } else {
            this.deskey = eventListener2.getUniqueID();
        }
        this.imei = this.deskey;
        AppMethodBeat.o(73289);
    }

    private String getCertDir() {
        AppMethodBeat.i(73290);
        String str = this.mContext.getFilesDir().getParentFile().getAbsolutePath() + "/cert";
        AppMethodBeat.o(73290);
        return str;
    }

    private void setAndCheckDir(String str) {
        AppMethodBeat.i(73291);
        String certDir = getCertDir();
        String str2 = certDir + FilePathGenerator.ANDROID_DIR_SEP + hexdigest(str + this.imei);
        this.cert_dir = str2 + "/cert";
        this.priv_dir = str2 + "/priv";
        this.publ_dir = str2 + "/publ";
        this.token_dir = str2 + "/auth";
        checkDir(certDir);
        checkDir(this.token_dir);
        AppMethodBeat.o(73291);
    }

    private void setDir(String str) {
        AppMethodBeat.i(73292);
        String str2 = getCertDir() + FilePathGenerator.ANDROID_DIR_SEP + hexdigest(str + this.imei);
        this.cert_dir = str2 + "/cert";
        this.priv_dir = str2 + "/priv";
        this.publ_dir = str2 + "/publ";
        this.token_dir = str2 + "/auth";
        AppMethodBeat.o(73292);
    }

    private void checkDir(String str) {
        AppMethodBeat.i(73293);
        o oVar = new o(str);
        if (!oVar.exists()) {
            oVar.mkdirs();
            AppMethodBeat.o(73293);
            return;
        }
        if (!oVar.isDirectory()) {
            oVar.delete();
            oVar.mkdirs();
        }
        AppMethodBeat.o(73293);
    }

    private boolean create_dir(String str) {
        boolean z;
        AppMethodBeat.i(73294);
        try {
            o oVar = new o(str);
            if (!oVar.exists()) {
                z = oVar.mkdirs();
                if (!z) {
                }
            } else {
                z = true;
            }
        } catch (Exception e2) {
            z = false;
        }
        AppMethodBeat.o(73294);
        return z;
    }

    private boolean del_all_files(String str) {
        o oVar;
        boolean z = false;
        AppMethodBeat.i(73295);
        o oVar2 = new o(str);
        if (!oVar2.exists()) {
            AppMethodBeat.o(73295);
            return false;
        } else if (!oVar2.isDirectory()) {
            AppMethodBeat.o(73295);
            return false;
        } else {
            String[] list = oVar2.list();
            for (int i2 = 0; i2 < list.length; i2++) {
                if (str.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                    oVar = new o(str + list[i2]);
                } else {
                    oVar = new o(str + FilePathGenerator.ANDROID_DIR_SEP + list[i2]);
                }
                if (oVar.isFile()) {
                    oVar.delete();
                    z = z;
                } else if (oVar.isDirectory()) {
                    del_all_files(str + FilePathGenerator.ANDROID_DIR_SEP + list[i2]);
                    del_dir(str + FilePathGenerator.ANDROID_DIR_SEP + list[i2], true);
                    z = true;
                } else {
                    z = z;
                }
            }
            AppMethodBeat.o(73295);
            return z;
        }
    }

    private void del_dir(String str, boolean z) {
        AppMethodBeat.i(73296);
        try {
            del_all_files(str);
            if (z) {
                new o(str.toString()).delete();
            }
            AppMethodBeat.o(73296);
        } catch (Exception e2) {
            AppMethodBeat.o(73296);
        }
    }

    private boolean isNotEmptyDir(String str) {
        AppMethodBeat.i(73297);
        boolean z = true;
        o oVar = new o(str);
        if (!oVar.exists() || !oVar.isDirectory() || oVar.het() == null) {
            z = false;
        }
        AppMethodBeat.o(73297);
        return z;
    }

    private boolean isValidDir(String str) {
        AppMethodBeat.i(73298);
        boolean z = true;
        o oVar = new o(str);
        if (!oVar.exists() || !oVar.isDirectory()) {
            z = false;
        }
        AppMethodBeat.o(73298);
        return z;
    }

    private String hexdigest(String str) {
        String str2;
        AppMethodBeat.i(73299);
        if (str == null) {
            AppMethodBeat.o(73299);
            return "";
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            MessageDigest instance2 = MessageDigest.getInstance("MD5");
            instance2.update(str.getBytes());
            byte[] digest = instance2.digest();
            char[] cArr2 = new char[32];
            int i2 = 0;
            int i3 = 0;
            while (i2 < 16) {
                byte b2 = digest[i2];
                int i4 = i3 + 1;
                cArr2[i3] = cArr[(b2 >>> 4) & 15];
                cArr2[i4] = cArr[b2 & 15];
                i2++;
                i3 = i4 + 1;
            }
            str2 = new String(cArr2);
        } catch (Exception e2) {
            str2 = null;
        }
        AppMethodBeat.o(73299);
        return str2;
    }

    private boolean isNullOrEmpty(String str) {
        AppMethodBeat.i(73300);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(73300);
            return true;
        }
        AppMethodBeat.o(73300);
        return false;
    }

    public synchronized String getCertApplyCSR(String str) {
        String str2 = null;
        synchronized (this) {
            AppMethodBeat.i(73301);
            this.qq_id = str;
            this.csr_buf = null;
            if (genCertApplyCsr() && this.csr_buf != null) {
                try {
                    str2 = new String(this.csr_buf, "ASCII");
                } catch (Exception e2) {
                    AppMethodBeat.o(73301);
                }
            }
            AppMethodBeat.o(73301);
        }
        return str2;
    }

    public synchronized String getCertApplyCSR(String str, int i2) {
        String str2 = null;
        synchronized (this) {
            AppMethodBeat.i(73302);
            this.qq_id = str;
            this.csr_buf = null;
            if (genCertApplyCsrNew(i2) && this.csr_buf != null) {
                try {
                    str2 = new String(this.csr_buf, "ASCII");
                } catch (Exception e2) {
                    AppMethodBeat.o(73302);
                }
            }
            AppMethodBeat.o(73302);
        }
        return str2;
    }

    public synchronized boolean importCert(String str, String str2) {
        boolean importCert;
        AppMethodBeat.i(73303);
        if (str2.length() <= 0) {
            importCert = false;
            AppMethodBeat.o(73303);
        } else {
            try {
                this.svr_cert = new String(str2.getBytes(), "ASCII");
            } catch (Exception e2) {
            }
            clearCert(str);
            setAndCheckDir(str);
            create_dir(this.cert_dir);
            create_dir(this.priv_dir);
            create_dir(this.publ_dir);
            importCert = importCert();
            AppMethodBeat.o(73303);
        }
        return importCert;
    }

    public synchronized boolean isCertExist(String str) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(73304);
            if (isNullOrEmpty(str)) {
                AppMethodBeat.o(73304);
            } else {
                setDir(str);
                if (!isNotEmptyDir(this.cert_dir) || !isNotEmptyDir(this.publ_dir) || !isNotEmptyDir(this.priv_dir)) {
                    AppMethodBeat.o(73304);
                } else {
                    this.cert_id = str;
                    z = isCertExist();
                    AppMethodBeat.o(73304);
                }
            }
        }
        return z;
    }

    public synchronized void clearAllCert() {
        AppMethodBeat.i(73305);
        del_dir(getCertDir(), true);
        AppMethodBeat.o(73305);
    }

    public synchronized void clearCert(String str) {
        AppMethodBeat.i(73306);
        del_dir(getCertDir() + FilePathGenerator.ANDROID_DIR_SEP + hexdigest(str + this.imei), true);
        AppMethodBeat.o(73306);
    }

    public synchronized String encrypt(String str, String str2) {
        String str3 = null;
        synchronized (this) {
            AppMethodBeat.i(73307);
            if (isNullOrEmpty(str) || isNullOrEmpty(str2)) {
                AppMethodBeat.o(73307);
            } else {
                setAndCheckDir(str);
                if (!isNotEmptyDir(this.cert_dir) || !isNotEmptyDir(this.publ_dir) || !isNotEmptyDir(this.priv_dir)) {
                    AppMethodBeat.o(73307);
                } else {
                    this.cert_id = str;
                    this.plain_buf = str2;
                    this.cipher_buf = null;
                    if (encrypt() && this.cipher_buf != null) {
                        try {
                            str3 = new String(this.cipher_buf, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                        } catch (Exception e2) {
                            AppMethodBeat.o(73307);
                        }
                    }
                    AppMethodBeat.o(73307);
                }
            }
        }
        return str3;
    }

    public synchronized String genUserSig(String str, byte[] bArr) {
        String str2 = null;
        synchronized (this) {
            AppMethodBeat.i(73308);
            if (isNullOrEmpty(str) || bArr == null || bArr.length == 0) {
                AppMethodBeat.o(73308);
            } else {
                setAndCheckDir(str);
                if (!isNotEmptyDir(this.cert_dir) || !isNotEmptyDir(this.publ_dir) || !isNotEmptyDir(this.priv_dir)) {
                    AppMethodBeat.o(73308);
                } else {
                    this.cert_id = str;
                    this.sig_buf = null;
                    if (usrSig(bArr) && this.sig_buf != null) {
                        try {
                            str2 = new String(this.sig_buf, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                        } catch (Exception e2) {
                            AppMethodBeat.o(73308);
                        }
                    }
                    AppMethodBeat.o(73308);
                }
            }
        }
        return str2;
    }

    public synchronized String genUserSig(String str, String str2) {
        String str3 = null;
        synchronized (this) {
            AppMethodBeat.i(73309);
            if (isNullOrEmpty(str) || isNullOrEmpty(str2)) {
                AppMethodBeat.o(73309);
            } else {
                setAndCheckDir(str);
                if (!isNotEmptyDir(this.cert_dir) || !isNotEmptyDir(this.publ_dir) || !isNotEmptyDir(this.priv_dir)) {
                    AppMethodBeat.o(73309);
                } else if (str == null || str2 == null || str.length() <= 0 || str2.length() <= 0) {
                    AppMethodBeat.o(73309);
                } else {
                    this.cert_id = str;
                    this.sig_raw_buf = str2;
                    this.sig_buf = null;
                    if (usrSig(str2.getBytes()) && this.sig_buf != null) {
                        try {
                            str3 = new String(this.sig_buf, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                        } catch (Exception e2) {
                            AppMethodBeat.o(73309);
                        }
                    }
                    AppMethodBeat.o(73309);
                }
            }
        }
        return str3;
    }

    public synchronized byte[] genQrcode(String str, byte[] bArr, String str2) {
        byte[] bArr2 = null;
        synchronized (this) {
            AppMethodBeat.i(73310);
            if (isNullOrEmpty(str) || isNullOrEmpty(str2) || bArr == null || bArr.length == 0) {
                AppMethodBeat.o(73310);
            } else {
                setAndCheckDir(str);
                if (!isNotEmptyDir(this.cert_dir) || !isNotEmptyDir(this.publ_dir) || !isNotEmptyDir(this.priv_dir)) {
                    AppMethodBeat.o(73310);
                } else {
                    this.cert_id = str;
                    this.plain_buf2 = bArr;
                    this.cipher_buf = null;
                    this.token = str2;
                    if (genQrcode() && this.cipher_buf != null) {
                        try {
                            bArr2 = this.cipher_buf;
                        } catch (Exception e2) {
                            AppMethodBeat.o(73310);
                        }
                    }
                    AppMethodBeat.o(73310);
                }
            }
        }
        return bArr2;
    }

    public synchronized boolean setTokens(String str, String str2, boolean z, String str3) {
        boolean z2 = false;
        z2 = false;
        z2 = false;
        z2 = false;
        int i2 = 0;
        synchronized (this) {
            AppMethodBeat.i(73311);
            if (isNullOrEmpty(str) || isNullOrEmpty(str2)) {
                AppMethodBeat.o(73311);
            } else if (!z || (str3 != null && str3.length() == 16)) {
                setAndCheckDir(str);
                if (!isValidDir(this.cert_dir)) {
                    AppMethodBeat.o(73311);
                } else if (!isValidDir(this.token_dir)) {
                    AppMethodBeat.o(73311);
                } else {
                    if (z) {
                        i2 = 1;
                    }
                    this.useSM4 = i2;
                    this.sm4Key = str3;
                    this.cert_id = str;
                    this.token = str2;
                    this.token_len = this.token.length();
                    z2 = setToken();
                    AppMethodBeat.o(73311);
                }
            } else {
                AppMethodBeat.o(73311);
            }
        }
        return z2;
    }

    public synchronized String getToken(String str) {
        String str2 = null;
        synchronized (this) {
            AppMethodBeat.i(73312);
            if (isNullOrEmpty(str)) {
                AppMethodBeat.o(73312);
            } else {
                setAndCheckDir(str);
                if (!isNotEmptyDir(this.token_dir)) {
                    AppMethodBeat.o(73312);
                } else {
                    this.cert_id = str;
                    if (getToken() && this.token_buf != null) {
                        try {
                            str2 = new String(this.token_buf, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                        } catch (Exception e2) {
                            AppMethodBeat.o(73312);
                        }
                    }
                    AppMethodBeat.o(73312);
                }
            }
        }
        return str2;
    }

    public synchronized void clearToken(String str) {
        AppMethodBeat.i(73313);
        if (isNullOrEmpty(str)) {
            AppMethodBeat.o(73313);
        } else {
            setDir(str);
            del_dir(this.token_dir, true);
            AppMethodBeat.o(73313);
        }
    }

    public synchronized int getTokenCount(String str) {
        int tokenCount;
        AppMethodBeat.i(73314);
        if (isNullOrEmpty(str)) {
            tokenCount = 0;
            AppMethodBeat.o(73314);
        } else {
            setDir(str);
            this.cert_id = str;
            tokenCount = getTokenCount();
            AppMethodBeat.o(73314);
        }
        return tokenCount;
    }

    private void onNativeEvent(int i2, String str) {
        AppMethodBeat.i(73315);
        if (this.eventListener != null) {
            this.eventListener.onEvent(i2, str);
        }
        AppMethodBeat.o(73315);
    }
}
