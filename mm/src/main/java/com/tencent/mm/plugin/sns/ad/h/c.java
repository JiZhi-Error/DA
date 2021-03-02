package com.tencent.mm.plugin.sns.ad.h;

import android.os.Looper;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.ad.timeline.dynamic.b;
import com.tencent.mm.protocal.protobuf.bz;
import com.tencent.mm.protocal.protobuf.ca;
import com.tencent.mm.protocal.protobuf.cb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.List;

public final class c extends a<ca, cb> implements i {
    b Dxh;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.protocal.protobuf.dop, java.lang.Object[]] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ad.h.a
    public final /* synthetic */ void a(ca caVar, Object[] objArr) {
        AppMethodBeat.i(202061);
        ca caVar2 = caVar;
        try {
            String str = (String) objArr[0];
            String str2 = (String) objArr[1];
            bz[] bzVarArr = (bz[]) objArr[2];
            if (caVar2 != null) {
                caVar2.KFZ = str;
                caVar2.gTk = str2;
                if (com.tencent.mm.plugin.sns.ad.i.c.x(bzVarArr)) {
                    Collections.addAll(caVar2.KGa, bzVarArr);
                }
                Log.d("SnsAd.AdDynamicUpdate", "fillRequestParam::sns_id " + caVar2.KFZ + ", uxinfo " + caVar2.gTk + ", req data size " + caVar2.KGa.size());
            }
            AppMethodBeat.o(202061);
        } catch (Throwable th) {
            Log.w("SnsAd.AdDynamicUpdate", "fillRequestParam::convert to param throw wrong!!!");
            AppMethodBeat.o(202061);
        }
    }

    public c(String str, String str2, bz[] bzVarArr) {
        AppMethodBeat.i(202057);
        a(new ca(), new cb(), "/cgi-bin/mmoc-bin/adplayinfo/ad_dynamic_update", 5012, str, str2, bzVarArr);
        AppMethodBeat.o(202057);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(202058);
        g.azz().a(5012, this);
        g.azz().a(this, 0);
        this.Dxh = bVar;
        AppMethodBeat.o(202058);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        cb cbVar;
        AppMethodBeat.i(202059);
        g.azz().b(5012, this);
        Log.d("SnsAd.AdDynamicUpdate", "onSceneEnd::the error type is " + i2 + ", error code is " + i3);
        if (i2 != 0 || i3 != 0 || !(qVar instanceof c) || (cbVar = (cb) ((c) qVar).eXx()) == null) {
            b(-1, "", null);
            AppMethodBeat.o(202059);
            return;
        }
        b(0, cbVar.KFZ, cbVar.KGb);
        AppMethodBeat.o(202059);
    }

    private void b(final int i2, final String str, final List<bz> list) {
        AppMethodBeat.i(202060);
        Log.d("SnsAd.AdDynamicUpdate", "onResponseFinish::the error code is " + i2 + ", sns id " + str);
        final b bVar = this.Dxh;
        if (Looper.getMainLooper() != Looper.myLooper()) {
            h.RTc.aV(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ad.h.c.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(202056);
                    if (bVar != null) {
                        bVar.c(i2, str, list);
                    }
                    AppMethodBeat.o(202056);
                }
            });
        } else if (bVar != null) {
            bVar.c(i2, str, list);
            AppMethodBeat.o(202060);
            return;
        }
        AppMethodBeat.o(202060);
    }
}
