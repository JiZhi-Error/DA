package com.tencent.mm.plugin.fingerprint.d;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import java.util.Map;

public interface a extends com.tencent.mm.kernel.c.a {
    int a(c cVar);

    int a(c cVar, boolean z);

    void a(ow owVar, int i2);

    void a(ow owVar, int i2, String str);

    void a(i iVar);

    boolean a(boolean z, boolean z2, Bundle bundle);

    void dJN();

    boolean dJO();

    boolean dJP();

    boolean dJQ();

    boolean dJR();

    String dJS();

    boolean dJT();

    boolean dJU();

    void dJV();

    boolean dJW();

    boolean dJX();

    Map<String, String> dJY();

    Map<String, String> dJZ();

    boolean dKa();

    boolean dKb();

    boolean dKc();

    void fK(Context context);

    void pj(boolean z);

    void pk(boolean z);

    int type();

    void userCancel();
}
