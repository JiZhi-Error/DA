package com.tencent.mm.plugin.patmsg.a;

import android.util.Pair;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.czg;
import com.tencent.mm.protocal.protobuf.czh;
import com.tencent.mm.storage.ca;
import java.util.List;

public interface b extends a {
    boolean HD(long j2);

    List<ca> HE(long j2);

    boolean J(int i2, String str, String str2);

    Pair<Long, Long> K(int i2, String str, String str2);

    czh a(czg czg, long j2);

    String a(czg czg);

    void a(Pair<Long, Long> pair, int i2);

    czg aJJ(String str);

    String aJK(String str);

    boolean ae(long j2, long j3);

    int b(czg czg, long j2);

    long b(String str, Pair<Long, Long> pair);

    void bd(String str, long j2);

    String d(Pair<Long, Long> pair);

    boolean e(Pair<Long, Long> pair);
}
