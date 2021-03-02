package com.tencent.mm.plugin.fingerprint.b.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.fingerprint.d.d;
import java.util.Map;

public interface i extends a {
    void a(Context context, f fVar, b bVar);

    void a(Context context, f fVar, d dVar);

    void a(boolean z, boolean z2, boolean z3, Bundle bundle);

    void b(Context context, f fVar, b bVar);

    void cancel();

    boolean dJQ();

    Map<String, String> dJY();

    boolean dKn();

    boolean dKo();

    boolean dKp();

    boolean dKq();

    boolean dKr();

    boolean dKs();

    boolean dKt();

    int dKu();

    d dKv();

    boolean dKw();

    boolean fN(Context context);

    boolean fO(Context context);

    void pp(boolean z);

    void pq(boolean z);

    void prepare();

    void q(Object... objArr);
}
