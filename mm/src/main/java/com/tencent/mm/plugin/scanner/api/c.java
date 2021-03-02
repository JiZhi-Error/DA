package com.tencent.mm.plugin.scanner.api;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import java.util.List;

public interface c extends a {
    String Iq(long j2);

    void Ir(long j2);

    void Is(long j2);

    long a(e eVar, g gVar);

    void a(Context context, ScanGoodsRequest scanGoodsRequest);

    void a(Context context, ScanGoodsRequest scanGoodsRequest, int i2);

    long b(e eVar, g gVar);

    long c(e eVar, g gVar);

    com.tencent.mm.plugin.scanner.api.a.a gT(Context context);

    boolean gy(List<Float> list);
}
