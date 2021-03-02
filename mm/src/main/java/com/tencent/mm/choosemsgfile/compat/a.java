package com.tencent.mm.choosemsgfile.compat;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public interface a extends com.tencent.mm.kernel.c.a {

    /* renamed from: com.tencent.mm.choosemsgfile.compat.a$a  reason: collision with other inner class name */
    public interface AbstractC0293a {
        void a(int i2, String str, ArrayList<MsgFile> arrayList);
    }

    void a(Activity activity, String str, int i2, String str2, AbstractC0293a aVar);

    void a(MMActivity mMActivity, String str, String str2, int i2, String str3, AbstractC0293a aVar);

    void g(Context context, String str, String str2);
}
