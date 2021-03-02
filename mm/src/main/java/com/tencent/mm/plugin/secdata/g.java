package com.tencent.mm.plugin.secdata;

import com.tencent.mm.bw.a;
import com.tencent.mm.kernel.b.d;

public interface g extends d {
    <T extends a> T getOnlyMemory(int i2, String str);

    <T extends a> void getWithClear(int i2, String str, Class<T> cls, i<T> iVar);

    <T extends a> void getWithoutClear(int i2, String str, Class<T> cls, i<T> iVar);

    <T extends a> T getWithoutClearSync(int i2, String str, Class<T> cls);

    boolean removeFromStorageSync(int i2, String str);

    <T extends a> void updateOnlyMemory(int i2, String str, T t);

    <T extends a> void updateWithSave(int i2, String str, T t, i<T> iVar);
}
