package com.tencent.mm.plugin.r.a;

import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.j;
import java.util.LinkedList;

public interface a {
    Cursor H(int[] iArr);

    Bitmap a(String str, int i2, float f2);

    g aJw(String str);

    g aJx(String str);

    String aJy(String str);

    void aJz(String str);

    void bg(LinkedList<String> linkedList);

    void e(g gVar);

    Cursor eAW();

    j eAX();

    Cursor eAY();

    void eZ(String str, int i2);

    void f(g gVar);

    void g(g gVar);

    Cursor hG(int i2, int i3);

    /* renamed from: com.tencent.mm.plugin.r.a.a$a  reason: collision with other inner class name */
    public static class C1616a {
        private static a ANA = null;

        public static void a(a aVar) {
            ANA = aVar;
        }

        public static a eAZ() {
            return ANA;
        }
    }
}
