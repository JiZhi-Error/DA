package com.tencent.mm.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.protocal.protobuf.drt;
import java.util.ArrayList;

public interface n extends a {
    void a(Intent intent, drr drr, int i2);

    void a(Intent intent, drt drt, int i2);

    void b(Activity activity, String str);

    boolean fD(String str);

    ArrayList<String> fE(String str);

    boolean fF(String str);

    String fG(String str);

    String fH(String str);

    void fI(String str);
}
