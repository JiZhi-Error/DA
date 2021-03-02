package com.tencent.mm.plugin.appbrand.m;

import com.eclipsesource.v8.ScriptPartObject;
import com.tencent.mm.appbrand.v8.m;
import java.net.URL;
import java.util.ArrayList;

public interface v extends j {
    public static final int[] mNV = {4, 0, 2, 1, 3};

    long XK();

    void a(URL url, String str, String str2, int i2, String str3, m.b bVar);

    void a(ArrayList<ScriptPartObject> arrayList, URL url, String str, String str2, m.b bVar);

    long getIsolatePtr();

    long getUVLoopPtr();
}
