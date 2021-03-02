package com.tencent.mm.model;

import com.tencent.mm.sdk.storage.IAutoStorage;
import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.storage.ah;
import java.util.List;

public interface ap extends IAutoStorage<ah>, IStorage {
    ah Kd(String str);

    ah Ke(String str);

    String Kf(String str);

    String Kg(String str);

    List<String> Kh(String str);

    boolean Ki(String str);

    boolean Kj(String str);

    int Kk(String str);

    String getDisplayName(String str);

    void z(String str, long j2);
}
