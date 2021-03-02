package com.tencent.pb.common.b;

import com.tencent.pb.common.c.b;
import java.lang.ref.WeakReference;

public final class i implements c {
    private WeakReference<c> MF;

    public i(c cVar) {
        this.MF = new WeakReference<>(cVar);
    }

    @Override // com.tencent.pb.common.b.c
    public final void onResp(int i2, byte[] bArr) {
        if (this.MF == null || this.MF.get() == null) {
            b.w("OnRespForLongAIDLImpl fail", "callback is null, errCode=".concat(String.valueOf(i2)));
            return;
        }
        this.MF.get().onResp(i2, bArr);
    }
}
