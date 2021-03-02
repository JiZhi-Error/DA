package com.tencent.mmkv;

public interface a {
    void mmkvLog(b bVar, String str, int i2, String str2, String str3);

    c onMMKVCRCCheckFail(String str);

    c onMMKVFileLengthError(String str);

    boolean wantLogRedirecting();
}
