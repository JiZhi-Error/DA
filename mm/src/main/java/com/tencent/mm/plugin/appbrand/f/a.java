package com.tencent.mm.plugin.appbrand.f;

import android.graphics.Bitmap;
import android.graphics.Rect;
import java.io.InputStream;
import java.util.Map;

public interface a extends com.tencent.luggage.a.b {

    /* renamed from: com.tencent.mm.plugin.appbrand.f.a$a  reason: collision with other inner class name */
    public interface AbstractC0580a {
        String Lb();

        void a(String str, Map<String, String> map, c cVar);

        Bitmap b(String str, Rect rect, b bVar);

        boolean match(String str);
    }

    public interface b {
        void Q(Bitmap bitmap);
    }

    public interface c {
        void C(InputStream inputStream);
    }

    Bitmap a(String str, Rect rect, b bVar);

    void a(String str, c cVar);

    void a(String str, Map<String, String> map, c cVar);

    Bitmap cR(String str);
}
