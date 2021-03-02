package com.tencent.mm.plugin.messenger.foundation.a;

import android.content.Context;
import java.io.Serializable;

public interface c extends com.tencent.mm.kernel.c.a {

    public interface a {
        void a(boolean z, String str, String str2);
    }

    public static class b implements Serializable {
        public String appId;
        public String appName;
        public String signature;
        public String zpX;
        public String zpY;
        public String zpZ;
        public String zqa;
        public int zqb;
        public int zqc;
    }

    /* renamed from: com.tencent.mm.plugin.messenger.foundation.a.c$c  reason: collision with other inner class name */
    public interface AbstractC1475c {
        void f(boolean z, String str);
    }

    void a(Context context, b bVar);

    void a(Context context, b bVar, a aVar);

    void a(Context context, b bVar, AbstractC1475c cVar);

    void a(Context context, b bVar, String str, AbstractC1475c cVar);

    void b(Context context, b bVar, a aVar);
}
