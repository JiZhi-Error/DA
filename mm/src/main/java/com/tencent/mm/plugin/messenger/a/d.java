package com.tencent.mm.plugin.messenger.a;

import android.content.Context;
import com.tencent.mm.protocal.protobuf.eeq;

public interface d {

    public interface a {
        void bIM();
    }

    void a(Context context, String str, String str2, int i2, String str3, String str4, long j2, String str5);

    void a(Context context, String str, String str2, String str3, int i2, int i3, eeq eeq, String str4, String str5);

    void a(Context context, String str, String str2, String str3, int i2, int i3, String str4, String str5);

    void a(Context context, String str, String str2, String str3, int i2, String str4, String str5, a aVar);

    void a(String str, byte[] bArr, String str2, String str3);

    void ad(String str, String str2, int i2);

    void e(String str, String str2, String str3, boolean z);

    void iF(String str, String str2);

    void s(String str, String str2, boolean z);
}
