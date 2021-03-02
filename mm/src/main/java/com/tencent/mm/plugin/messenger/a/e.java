package com.tencent.mm.plugin.messenger.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.ak.h;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.Map;

public interface e extends com.tencent.mm.kernel.c.a {

    public interface a {
        String f(Map<String, String> map, String str);
    }

    public interface b {
        CharSequence a(Map<String, String> map, String str, Bundle bundle, WeakReference<Context> weakReference, WeakReference<NeatTextView> weakReference2);
    }

    public interface c {
        void a(Map<String, String> map, h.a aVar);

        void b(String str, Map<String, String> map, Bundle bundle);
    }

    public interface d {
        CharSequence V(Map<String, String> map, String str);

        Boolean cE(Map<String, String> map);
    }

    void a(d dVar);

    void a(String str, a aVar);

    void a(String str, b bVar);

    void a(String str, c cVar);

    void a(String str, Map<String, String> map, Bundle bundle);

    void aDU(String str);

    void aDV(String str);

    CharSequence aDW(String str);

    CharSequence b(String str, Bundle bundle, WeakReference<Context> weakReference, WeakReference<NeatTextView> weakReference2);

    void b(d dVar);

    void b(String str, c cVar);
}
