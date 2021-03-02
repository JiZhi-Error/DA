package com.tencent.mm.plugin.messenger.foundation.a;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.vending.b.b;

public interface e extends a {
    b addContactAssembler(d dVar);

    void processModContact(cpl cpl, String str, byte[] bArr, boolean z, boolean z2, int i2);
}
