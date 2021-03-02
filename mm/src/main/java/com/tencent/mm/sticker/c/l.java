package com.tencent.mm.sticker.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.e.b;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B=\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/sticker/task/GetLensListTaskProcess;", "Lcom/tencent/mm/sticker/task/GetLensListTask;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "type", "", "pageBuff", "", "lensCtx", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "callback", "Lcom/tencent/mm/sticker/task/GetLensListCallback;", "(I[B[BLcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Lcom/tencent/mm/sticker/task/GetLensListCallback;)V", "getCallback", "()Lcom/tencent/mm/sticker/task/GetLensListCallback;", "setCallback", "(Lcom/tencent/mm/sticker/task/GetLensListCallback;)V", "dead", "", "plugin-sticker_release"})
public final class l extends i implements a {
    h NOB;

    public l(int i2, byte[] bArr, byte[] bArr2, b<a> bVar, h hVar) {
        AppMethodBeat.i(105993);
        this.NOB = hVar;
        if (bVar != null) {
            bVar.keep(this);
        }
        Bundle bundle = new Bundle();
        bundle.putInt(k.gzq(), i2);
        bundle.putByteArray(k.gzr(), bArr);
        bundle.putByteArray(k.gzs(), bArr2);
        h.a(MMApplicationContext.getPackageName(), bundle, n.class, new d<ResultType>(this) {
            /* class com.tencent.mm.sticker.c.l.AnonymousClass1 */
            final /* synthetic */ l NOC;

            {
                this.NOC = r1;
            }

            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(Object obj) {
                AppMethodBeat.i(105992);
                Bundle bundle = (Bundle) obj;
                int i2 = bundle.getInt(k.gzo());
                int i3 = bundle.getInt(k.gzt());
                bpi bpi = new bpi();
                byte[] byteArray = bundle.getByteArray(k.gzu());
                if (byteArray != null) {
                    bpi.parseFrom(byteArray);
                }
                Log.i(k.auD(), "ipc callback: " + i2 + ' ' + i3);
                h hVar = this.NOC.NOB;
                if (hVar != null) {
                    hVar.a(i2, i3, bpi);
                    AppMethodBeat.o(105992);
                    return;
                }
                AppMethodBeat.o(105992);
            }
        });
        AppMethodBeat.o(105993);
    }

    @Override // com.tencent.mm.vending.e.a
    public final void dead() {
        this.NOB = null;
    }
}
