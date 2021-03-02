package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import java.util.Map;

public interface h extends a {
    void M(Context context, String str, String str2);

    void a(Context context, int i2, String str, String str2, Map<String, String> map);

    void a(Context context, int i2, String str, String str2, Map<String, String> map, String str3, int i3);

    void a(Context context, int i2, String str, String str2, boolean z, Map<String, String> map, int i3);

    void a(Context context, String str, String str2, Map<String, String> map);

    void a(ag agVar);

    void b(Context context, int i2, String str, String str2);

    void b(Context context, int i2, String str, String str2, boolean z, Map<String, String> map, String str3);
}
