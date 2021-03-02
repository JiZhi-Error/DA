package com.tencent.mm.plugin.brandservice.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ag.p;
import com.tencent.mm.ag.q;
import com.tencent.mm.ag.y;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public interface b extends com.tencent.mm.kernel.c.a {

    public static class a {
        public String message;
        public boolean success = false;
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.a.b$b  reason: collision with other inner class name */
    public interface AbstractC0862b {
        void onSuccess(String str);

        void p(int i2, int i3, String str);
    }

    boolean CQ(int i2);

    boolean CR(int i2);

    void CS(int i2);

    boolean CT(int i2);

    boolean L(Object obj, Object obj2);

    void P(String str, String str2, String str3);

    void Q(String str, String str2, String str3);

    void a(Context context, JSONObject jSONObject, HashMap<String, Object> hashMap);

    void a(AbstractC0862b bVar);

    void a(jo joVar, MMActivity mMActivity, int i2);

    void a(String str, int i2, int i3, Object... objArr);

    void a(String str, y yVar, String str2, d<Bundle> dVar);

    boolean a(Context context, String str, int i2, int i3, int i4, Intent intent);

    boolean a(Context context, String str, int i2, int i3, int i4, Intent intent, int i5, a aVar);

    void ahA(String str);

    boolean ahv(String str);

    p ahw(String str);

    void ahx(String str);

    long ahy(String str);

    String ahz(String str);

    void c(jo joVar);

    void cD(String str, int i2);

    void cE(String str, int i2);

    boolean clc();

    boolean cld();

    boolean cle();

    String clf();

    void clg();

    int clh();

    String cli();

    void clj();

    void clk();

    void ct(List<q> list);

    String d(String str, int i2, int i3, int i4);

    boolean isMpUrl(String str);

    void j(List<List<String>> list, int i2);

    void k(List<String[]> list, int i2);

    void l(List<q> list, int i2);
}
