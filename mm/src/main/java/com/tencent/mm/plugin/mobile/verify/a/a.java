package com.tencent.mm.plugin.mobile.verify.a;

import android.os.Bundle;

public interface a extends com.tencent.mm.kernel.b.a {

    /* renamed from: com.tencent.mm.plugin.mobile.verify.a.a$a  reason: collision with other inner class name */
    public interface AbstractC1483a {
        void F(Bundle bundle);
    }

    void getMobileToken(String str, String str2, AbstractC1483a aVar);

    void removeCallback(String str);
}
