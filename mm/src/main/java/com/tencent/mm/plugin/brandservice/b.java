package com.tencent.mm.plugin.brandservice;

import android.content.Context;
import android.content.Intent;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.Log;

public final class b implements n {
    public static m jRt;
    public static l jRu;

    @Override // com.tencent.mm.pluginsdk.n
    public final void a(m mVar) {
        jRt = mVar;
    }

    @Override // com.tencent.mm.pluginsdk.n
    public final void a(l lVar) {
        jRu = lVar;
    }

    public static void d(Intent intent, Context context) {
        AppMethodBeat.i(194842);
        Log.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
        jRt.d(intent, context);
        AppMethodBeat.o(194842);
    }

    public static void k(int i2, Object obj) {
        AppMethodBeat.i(5533);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = obj == null ? BuildConfig.COMMAND : obj.toString();
        Log.i("MicroMsg.BrandService.BrandServiceApplication", "set config, key[%d], value[%s]", objArr);
        g.aAi();
        g.aAh().azQ().set(i2, obj);
        AppMethodBeat.o(5533);
    }

    public static void a(String str, Runnable runnable, long j2) {
        AppMethodBeat.i(5534);
        if (j2 > 0) {
            h.RTc.a(runnable, j2, str);
            AppMethodBeat.o(5534);
            return;
        }
        h.RTc.b(runnable, str);
        AppMethodBeat.o(5534);
    }
}
