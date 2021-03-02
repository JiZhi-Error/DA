package com.tencent.mm.plugin.wallet.wecoin.a;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import com.tencent.mm.kernel.c.a;

public interface c extends a {
    d a(FragmentActivity fragmentActivity, int i2, String str, e<Boolean> eVar);

    void a(Context context, e<Boolean> eVar);

    void a(Context context, String str, byte[] bArr, e<Long> eVar);

    void a(e<Long> eVar);

    b aP(Activity activity);

    void bN(Context context, String str);

    boolean dfq();

    Long hXF();
}
