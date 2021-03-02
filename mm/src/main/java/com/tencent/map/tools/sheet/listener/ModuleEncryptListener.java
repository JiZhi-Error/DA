package com.tencent.map.tools.sheet.listener;

import android.support.annotation.Keep;

@Keep
public interface ModuleEncryptListener {
    byte[] enCryptModleData(byte[] bArr);
}
