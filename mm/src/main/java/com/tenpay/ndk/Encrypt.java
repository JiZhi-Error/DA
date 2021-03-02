package com.tenpay.ndk;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;

public class Encrypt {
    private static final String CHARSET = "UTF-8";
    private byte[] dec_buf;
    private byte[] enc_buf;
    private byte[] enc_passwd;
    private byte[] key_buf;
    private byte[] raw_buf;
    private byte[] raw_passwd;
    private String server_time_stamp = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private int time_stamp;

    private native boolean decrypt(byte[] bArr, byte[] bArr2);

    private native boolean encrypt(byte[] bArr, byte[] bArr2);

    private native boolean encryptPasswd(byte b2, byte[] bArr);

    private native boolean encryptPasswdWithRSA2048(byte b2, byte[] bArr, int i2);

    private native boolean encryptVerifyCode(byte[] bArr);

    private native byte[] getRandom();

    public native byte[] sm4BCDDecryptCBC(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public native byte[] sm4BCDEncryptCBC(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public String desedeEncode(String str) {
        String str2;
        AppMethodBeat.i(73317);
        if (str == null || str.length() <= 0) {
            str2 = null;
        } else {
            try {
                this.raw_buf = str.getBytes("UTF-8");
                encrypt(null, this.raw_buf);
                if (this.enc_buf == null) {
                    AppMethodBeat.o(73317);
                    return null;
                }
                try {
                    str2 = new String(this.enc_buf, "UTF-8");
                } catch (Exception e2) {
                    AppMethodBeat.o(73317);
                    return null;
                }
            } catch (Exception e3) {
                AppMethodBeat.o(73317);
                return null;
            }
        }
        AppMethodBeat.o(73317);
        return str2;
    }

    public String desedeVerifyCode(String str) {
        String str2;
        AppMethodBeat.i(73318);
        if (str == null || str.length() <= 0) {
            str2 = null;
        } else {
            try {
                this.raw_buf = str.getBytes("UTF-8");
                encryptVerifyCode(this.raw_buf);
                if (this.enc_buf == null) {
                    AppMethodBeat.o(73318);
                    return null;
                }
                try {
                    str2 = new String(this.enc_buf, "UTF-8");
                } catch (Exception e2) {
                    AppMethodBeat.o(73318);
                    return null;
                }
            } catch (Exception e3) {
                AppMethodBeat.o(73318);
                return null;
            }
        }
        AppMethodBeat.o(73318);
        return str2;
    }

    public String desedeEncode(String str, String str2) {
        String str3;
        AppMethodBeat.i(73319);
        if (str == null || str2 == null || str.length() <= 0) {
            str3 = null;
        } else {
            try {
                this.raw_buf = str.getBytes("UTF-8");
                this.key_buf = str2.getBytes("UTF-8");
                encrypt(this.key_buf, this.raw_buf);
                if (this.enc_buf == null) {
                    AppMethodBeat.o(73319);
                    return null;
                }
                try {
                    str3 = new String(this.enc_buf, "UTF-8");
                } catch (Exception e2) {
                    AppMethodBeat.o(73319);
                    return null;
                }
            } catch (Exception e3) {
                AppMethodBeat.o(73319);
                return null;
            }
        }
        AppMethodBeat.o(73319);
        return str3;
    }

    public String desedeDecode(String str, String str2) {
        String str3;
        AppMethodBeat.i(73320);
        if (str == null || str2 == null || str.length() <= 0) {
            str3 = null;
        } else {
            try {
                this.raw_buf = str.getBytes("UTF-8");
                this.key_buf = str2.getBytes("UTF-8");
                decrypt(this.key_buf, this.raw_buf);
                if (this.dec_buf == null) {
                    AppMethodBeat.o(73320);
                    return null;
                }
                try {
                    str3 = new String(this.dec_buf, "UTF-8");
                } catch (Exception e2) {
                    AppMethodBeat.o(73320);
                    return null;
                }
            } catch (Exception e3) {
                AppMethodBeat.o(73320);
                return null;
            }
        }
        AppMethodBeat.o(73320);
        return str3;
    }

    public String getPasswdTimeStamp() {
        AppMethodBeat.i(73321);
        String valueOf = String.valueOf(this.time_stamp);
        AppMethodBeat.o(73321);
        return valueOf;
    }

    public void setTimeStamp(String str) {
        this.server_time_stamp = str;
    }

    public String encryptPasswdWithRSA2048(String str) {
        String str2 = null;
        AppMethodBeat.i(73322);
        if (str != null && str.length() > 0) {
            this.raw_passwd = null;
            this.enc_passwd = null;
            if (str.length() > 0) {
                try {
                    this.raw_passwd = str.getBytes("UTF-8");
                    if (!encryptPasswdWithRSA2048((byte) 2, this.raw_passwd, 1)) {
                        AppMethodBeat.o(73322);
                        return str2;
                    }
                } catch (Exception e2) {
                    AppMethodBeat.o(73322);
                }
            }
            if (this.enc_passwd == null) {
                AppMethodBeat.o(73322);
            } else {
                try {
                    str2 = "V01_" + new String(this.enc_passwd, "UTF-8");
                } catch (Exception e3) {
                    AppMethodBeat.o(73322);
                }
            }
            return str2;
        }
        AppMethodBeat.o(73322);
        return str2;
    }

    public String encryptPasswd(String str) {
        String str2;
        AppMethodBeat.i(73323);
        if (str == null || str.length() <= 0) {
            str2 = null;
        } else {
            try {
                this.raw_passwd = str.getBytes("UTF-8");
                encryptPasswd((byte) 2, this.raw_passwd);
                if (this.enc_passwd == null) {
                    AppMethodBeat.o(73323);
                    return null;
                }
                try {
                    int length = this.enc_passwd.length / 2;
                    byte[] bArr = new byte[length];
                    System.arraycopy(this.enc_passwd, length, bArr, 0, length);
                    str2 = new String(bArr, "UTF-8");
                } catch (Exception e2) {
                    AppMethodBeat.o(73323);
                    return null;
                }
            } catch (Exception e3) {
                AppMethodBeat.o(73323);
                return null;
            }
        }
        AppMethodBeat.o(73323);
        return str2;
    }

    public String getRandomKey() {
        String str;
        AppMethodBeat.i(73324);
        byte[] random = getRandom();
        if (random != null) {
            try {
                str = new String(random, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
            }
            AppMethodBeat.o(73324);
            return str;
        }
        str = null;
        AppMethodBeat.o(73324);
        return str;
    }
}
