package com.tencent.mm.plugin.shake.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.e;
import com.tencent.mm.plugin.shake.b.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.smtt.sdk.TbsListener;
import java.util.List;

public final class c extends l.b implements i {
    int DgG = 1;
    int DgH = -1000;
    boolean DgI = false;
    boolean DgJ = true;
    b DgK;
    a DgL;
    private int DgM = 0;
    MMHandler DgN = new MMHandler();
    Runnable DgO = new Runnable() {
        /* class com.tencent.mm.plugin.shake.b.c.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(28092);
            if (!(c.this.DgN == null || c.this.DgO == null)) {
                c.this.DgN.removeCallbacks(c.this.DgO);
            }
            if (c.this.DgL != null) {
                bg.azz().a(c.this.DgL);
            }
            if (!(c.this.DgK == null || c.this.DgK.efs == null)) {
                c.this.DgL = new a(c.this.DgK.efs);
            }
            if (c.this.DgL != null) {
                bg.azz().a(c.this.DgL, 0);
            }
            AppMethodBeat.o(28092);
        }
    };
    private Context context;
    private b.a gmA = new b.a() {
        /* class com.tencent.mm.plugin.shake.b.c.AnonymousClass2 */

        @Override // com.tencent.mm.modelgeo.b.a
        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
            boolean z2;
            boolean z3;
            AppMethodBeat.i(28093);
            e bge = e.bge();
            if (i2 == 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (c.this.iOv == null) {
                z3 = false;
            } else {
                z3 = c.this.iOv.iVk;
            }
            bge.a(2002, z2, z3, f2, f3, (int) d3);
            Log.i("MicroMsg.ShakeFriendService", "getlocaion lat %f lng %f hasGetLbsInfo " + c.this.DgI, Float.valueOf(f3), Float.valueOf(f2));
            if (!z) {
                AppMethodBeat.o(28093);
                return true;
            }
            if (c.this.DgJ && c.this.gmu == -85.0f && c.this.gmv == -1000.0f) {
                c.this.DgJ = false;
                c.this.gmu = f3;
                c.this.gmv = f2;
                c.this.DgH = (int) d3;
                c.this.DgG = i2;
                c.this.DgI = true;
            }
            AppMethodBeat.o(28093);
            return false;
        }
    };
    float gmu = -85.0f;
    float gmv = -1000.0f;
    d iOv;

    public c(Context context2, l.a aVar) {
        super(aVar);
        AppMethodBeat.i(28094);
        this.context = context2;
        AppMethodBeat.o(28094);
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void init() {
        AppMethodBeat.i(28095);
        bg.azz().a(161, this);
        bg.azz().a(TbsListener.ErrorCode.STARTDOWNLOAD_3, this);
        bg.azz().a(1251, this);
        eTP();
        AppMethodBeat.o(28095);
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void start() {
        AppMethodBeat.i(28096);
        reset();
        init();
        this.DgK = new b(this.gmv, this.gmu, this.DgH, this.DgG, "", "");
        bg.azz().a(this.DgK, 0);
        if (!this.DgI) {
            if (this.iOv == null) {
                eTP();
            }
            this.iOv.b(this.gmA, true);
        }
        AppMethodBeat.o(28096);
    }

    private void eTP() {
        AppMethodBeat.i(28097);
        this.iOv = d.bca();
        this.DgJ = true;
        this.iOv.a(this.gmA, true);
        AppMethodBeat.o(28097);
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void reset() {
        AppMethodBeat.i(28098);
        if (this.DgK != null) {
            bg.azz().a(this.DgK);
        }
        if (this.DgL != null) {
            bg.azz().a(this.DgL);
        }
        if (!(this.DgN == null || this.DgO == null)) {
            this.DgN.removeCallbacks(this.DgO);
        }
        AppMethodBeat.o(28098);
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void eTQ() {
        AppMethodBeat.i(28101);
        super.eTQ();
        bg.azz().b(161, this);
        bg.azz().b(TbsListener.ErrorCode.STARTDOWNLOAD_3, this);
        bg.azz().b(1251, this);
        if (this.iOv != null) {
            this.iOv.c(this.gmA);
        }
        AppMethodBeat.o(28101);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(28102);
        switch (qVar.getType()) {
            case 161:
                b bVar = (b) qVar;
                if (bVar.eTO() == 3 || bVar.eTO() == 4) {
                    Log.v("MicroMsg.ShakeFriendService", "onSceneEnd ignore location report response");
                    AppMethodBeat.o(28102);
                    return;
                } else if (i3 == 0 && i2 == 0 && bVar.ret == 0) {
                    this.DgN.postDelayed(this.DgO, 3000);
                    AppMethodBeat.o(28102);
                    return;
                } else {
                    Log.e("MicroMsg.ShakeFriendService", "onSceneEnd reprot failed");
                    this.DgX.f(null, 3);
                    AppMethodBeat.o(28102);
                    return;
                }
            case TbsListener.ErrorCode.STARTDOWNLOAD_3 /*{ENCODED_INT: 162}*/:
                a aVar = (a) qVar;
                if (i3 == 0 && i2 == 0 && aVar.ret == 0) {
                    List<d> list = aVar.DgE;
                    if (list.size() == 0) {
                        Log.i("MicroMsg.ShakeFriendService", "empty shake get list");
                        this.DgX.f(null, 3);
                        AppMethodBeat.o(28102);
                        return;
                    }
                    this.DgX.f(list, 1);
                    AppMethodBeat.o(28102);
                    return;
                }
                this.DgX.f(null, 3);
                AppMethodBeat.o(28102);
                return;
            case 1251:
                com.tencent.mm.plugin.shake.c.a.b bVar2 = (com.tencent.mm.plugin.shake.c.a.b) qVar;
                if (i3 == 0 && i2 == 0) {
                    if (this.DgX != null) {
                        this.DgX.a(1251, bVar2.Dhq, 1);
                        break;
                    }
                } else if (this.DgX != null) {
                    this.DgX.a(1251, null, 2);
                    AppMethodBeat.o(28102);
                    return;
                }
                break;
        }
        AppMethodBeat.o(28102);
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void pause() {
        AppMethodBeat.i(28099);
        if (this.iOv != null) {
            this.iOv.c(this.gmA);
        }
        AppMethodBeat.o(28099);
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void resume() {
        AppMethodBeat.i(28100);
        if (this.iOv != null) {
            this.iOv.a(this.gmA, true);
        }
        AppMethodBeat.o(28100);
    }
}
