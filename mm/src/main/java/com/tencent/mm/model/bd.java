package com.tencent.mm.model;

import com.tencent.mm.storagebase.h;
import java.util.HashMap;

@Deprecated
public interface bd {
    void clearPluginData(int i2);

    HashMap<Integer, h.b> getBaseDBFactories();

    void onAccountPostReset(boolean z);

    void onAccountRelease();

    void onSdcardMount(boolean z);
}
