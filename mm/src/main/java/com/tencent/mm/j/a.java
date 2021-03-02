package com.tencent.mm.j;

import android.content.Intent;
import android.view.KeyEvent;
import com.tencent.mm.ui.MMActivity;

public interface a {

    /* renamed from: com.tencent.mm.j.a$a  reason: collision with other inner class name */
    public static class C0358a {
        public static AbstractC0359a gCq;

        /* renamed from: com.tencent.mm.j.a$a$a  reason: collision with other inner class name */
        public interface AbstractC0359a {
            a a(MMActivity mMActivity);
        }
    }

    public interface b {
        void anx();

        boolean any();
    }

    public interface c {
        void onFinish();
    }

    public interface d {
        void anA();

        void anz();
    }

    void a(b bVar);

    void a(c cVar);

    void a(String str, String str2, b bVar);

    void ant();

    void anu();

    void anv();

    boolean anw();

    void b(b bVar);

    void c(Boolean bool);

    boolean dispatchKeyEvent(KeyEvent keyEvent);

    boolean onActivityResult(int i2, int i3, Intent intent);

    void onDestroy();

    void onPause();

    void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr);

    void onResume();
}
