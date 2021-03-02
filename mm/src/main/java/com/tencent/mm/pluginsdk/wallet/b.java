package com.tencent.mm.pluginsdk.wallet;

import android.content.Context;
import android.graphics.Typeface;
import com.tencent.mm.protocal.protobuf.czu;
import java.util.Map;

public interface b extends com.tencent.mm.kernel.c.a {

    public interface a {
        void aas(String str);

        void onSuccess(String str);
    }

    void a(Map<String, Object> map, String str, String str2, int i2, a aVar);

    czu elk();

    Typeface gA(Context context);

    void he(int i2, int i3);
}
