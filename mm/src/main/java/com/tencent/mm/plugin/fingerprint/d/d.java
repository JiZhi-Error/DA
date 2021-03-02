package com.tencent.mm.plugin.fingerprint.d;

import android.content.Context;
import com.tencent.mm.ak.q;

public interface d {
    void a(Context context, b bVar);

    void a(Context context, b bVar, String str);

    void a(b bVar, int i2);

    void clear();

    boolean onSceneEnd(int i2, int i3, String str, q qVar);
}
