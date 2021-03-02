package com.tencent.mm.sticker.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.e.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/sticker/task/GetLensInfoTaskProcess;", "Lcom/tencent/mm/sticker/task/GetLensInfoTask;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "lensId", "", "callback", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Ljava/lang/String;Lcom/tencent/mm/sticker/task/GetLensInfoCallback;)V", "getCallback", "()Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "setCallback", "(Lcom/tencent/mm/sticker/task/GetLensInfoCallback;)V", "dead", "", "plugin-sticker_release"})
public final class g extends d implements a {
    c NOr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(b<a> bVar, final String str, c cVar) {
        super(str);
        p.h(str, "lensId");
        AppMethodBeat.i(105989);
        this.NOr = cVar;
        if (bVar != null) {
            bVar.keep(this);
        }
        Bundle bundle = new Bundle();
        bundle.putString(f.gzn(), str);
        h.a(MMApplicationContext.getPackageName(), bundle, m.class, new d<ResultType>(this) {
            /* class com.tencent.mm.sticker.c.g.AnonymousClass1 */
            final /* synthetic */ g NOs;

            {
                this.NOs = r1;
            }

            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(Object obj) {
                AppMethodBeat.i(105987);
                final Bundle bundle = (Bundle) obj;
                com.tencent.f.h.RTc.aX(new Runnable(this) {
                    /* class com.tencent.mm.sticker.c.g.AnonymousClass1.AnonymousClass1 */
                    final /* synthetic */ AnonymousClass1 NOt;

                    {
                        this.NOt = r1;
                    }

                    public final void run() {
                        byte[] bArr;
                        AppMethodBeat.i(105986);
                        Bundle bundle = bundle;
                        int i2 = bundle != null ? bundle.getInt(f.gzo()) : 0;
                        Log.i(f.auD(), "IPCInvoker: " + str + ", " + i2);
                        Bundle bundle2 = bundle;
                        if (bundle2 != null) {
                            bArr = bundle2.getByteArray(f.gzp());
                        } else {
                            bArr = null;
                        }
                        if (bArr == null) {
                            c cVar = this.NOt.NOs.NOr;
                            if (cVar != null) {
                                cVar.a(i2, null);
                                AppMethodBeat.o(105986);
                                return;
                            }
                            AppMethodBeat.o(105986);
                            return;
                        }
                        chz chz = new chz();
                        chz.parseFrom(bArr);
                        c cVar2 = this.NOt.NOs.NOr;
                        if (cVar2 != null) {
                            cVar2.a(i2, chz);
                            AppMethodBeat.o(105986);
                            return;
                        }
                        AppMethodBeat.o(105986);
                    }
                });
                AppMethodBeat.o(105987);
            }
        });
        AppMethodBeat.o(105989);
    }

    @Override // com.tencent.mm.vending.e.a
    public final void dead() {
        AppMethodBeat.i(105988);
        Log.i(f.auD(), "dead: ");
        this.NOr = null;
        AppMethodBeat.o(105988);
    }
}
