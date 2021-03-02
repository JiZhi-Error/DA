package com.tencent.magicbrush.handler.fs;

import android.support.annotation.Keep;

@Keep
public interface IMBFileSystem {
    byte[] readFile(String str);
}
