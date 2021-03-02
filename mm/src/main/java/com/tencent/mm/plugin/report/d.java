package com.tencent.mm.plugin.report;

import com.tencent.mars.smc.IDKey;
import java.util.ArrayList;
import java.util.Map;

public interface d {
    void a(int i2, int i3, int i4, int i5, int i6, int i7, boolean z);

    void a(int i2, int i3, String str, boolean z, boolean z2);

    void a(int i2, String str, boolean z, boolean z2);

    void a(int i2, boolean z, boolean z2, boolean z3, Object... objArr);

    void a(int i2, boolean z, boolean z2, Object... objArr);

    void a(int i2, Object... objArr);

    void b(int i2, int i3, int i4, int i5, boolean z);

    void b(ArrayList<IDKey> arrayList, boolean z);

    void e(String str, String str2, Map<String, Object> map);

    void idkeyStat(long j2, long j3, long j4, boolean z);

    void kvStat(int i2, String str);

    void setUin(int i2);
}
