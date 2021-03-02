package com.tencent.map.swlocation.api;

import com.b.a.a.q;

public interface INetworkApi extends q {
    @Deprecated
    byte[] httpRequest(String str, byte[] bArr);

    @Override // com.b.a.a.q
    byte[] httpRequest(byte[] bArr);
}
