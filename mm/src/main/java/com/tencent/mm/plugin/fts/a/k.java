package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import java.util.HashMap;

public interface k {
    a a(j jVar);

    void a(String str, m mVar, int i2, HashMap<String, String> hashMap);

    void addSOSHistory(String str, String str2);

    void create();

    void deleteSOSHistory();

    void deleteSOSHistory(String str);

    void destroy();

    String getName();

    boolean isCreated();
}
