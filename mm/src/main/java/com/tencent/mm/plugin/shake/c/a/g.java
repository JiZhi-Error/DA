package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.l;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.c.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class g extends l.b implements i {
    private static int Dhr = 0;
    private c DhM;
    private e DhN = new e();
    private boolean DhO = false;
    private boolean DhP = false;
    private long Dhs = 0;
    private b.a gmA = new b.a() {
        /* class com.tencent.mm.plugin.shake.c.a.g.AnonymousClass1 */

        @Override // com.tencent.mm.modelgeo.b.a
        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
            AppMethodBeat.i(28199);
            if (!z) {
                AppMethodBeat.o(28199);
                return true;
            }
            if (g.this.gmu == -85.0f && g.this.gmv == -1000.0f) {
                g.this.gmu = f3;
                g.this.gmv = f2;
                m.eUs().gmu = g.this.gmu;
                m.eUs().gmv = g.this.gmv;
                if (g.this.DhP) {
                    Log.i("MicroMsg.ShakeCardService", "ShakeCardService do netscen from onGetLocation()");
                    g.d(g.this);
                }
            }
            AppMethodBeat.o(28199);
            return false;
        }
    };
    private float gmu = -85.0f;
    private float gmv = -1000.0f;
    private int gwE = 0;
    private d iOv;
    private String lAo = "";
    private MMHandler mHandler = new MMHandler();
    public int pTI;

    static /* synthetic */ void d(g gVar) {
        AppMethodBeat.i(28216);
        gVar.eUw();
        AppMethodBeat.o(28216);
    }

    public g(l.a aVar) {
        super(aVar);
        AppMethodBeat.i(28202);
        AppMethodBeat.o(28202);
    }

    public final void setFromScene(int i2) {
        AppMethodBeat.i(28203);
        this.gwE = i2;
        Log.i("MicroMsg.ShakeCardService", "ShakeCardService from_scene:".concat(String.valueOf(i2)));
        AppMethodBeat.o(28203);
    }

    public final void Rv(String str) {
        AppMethodBeat.i(28204);
        if (str == null || str.length() > 256) {
            Log.i("MicroMsg.ShakeCardService", "ShakeCardService ext_info size > 256 byte, extinfo:".concat(String.valueOf(str)));
            AppMethodBeat.o(28204);
            return;
        }
        Log.i("MicroMsg.ShakeCardService", "ShakeCardService mExtInfo:" + this.lAo);
        this.lAo = str;
        AppMethodBeat.o(28204);
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void init() {
        AppMethodBeat.i(28205);
        Dhr = m.eUs().Dhr;
        this.Dhs = m.eUs().Dhs;
        this.gmu = m.eUs().gmu;
        this.gmv = m.eUs().gmv;
        bg.azz().a(1250, this);
        eTP();
        AppMethodBeat.o(28205);
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void reset() {
        AppMethodBeat.i(28206);
        if (this.DhM != null) {
            bg.azz().a(this.DhM);
        }
        AppMethodBeat.o(28206);
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void start() {
        Object obj;
        boolean z;
        AppMethodBeat.i(28207);
        init();
        reset();
        if (this.iOv == null) {
            eTP();
        }
        this.iOv.b(this.gmA, true);
        d eUs = m.eUs();
        if (TextUtils.isEmpty("key_shake_card_item") || !eUs.pQY.containsKey("key_shake_card_item")) {
            obj = null;
        } else {
            obj = eUs.pQY.get("key_shake_card_item");
        }
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - this.Dhs;
        if (obj == null || !(obj instanceof e)) {
            if (this.Dhs == 0) {
                z = true;
            } else if (currentTimeMillis >= 0) {
                z = true;
            } else {
                h.INSTANCE.a(11666, Integer.valueOf(this.gwE));
                this.mHandler.postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.shake.c.a.g.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(28200);
                        g.this.DhN.pTI = 3;
                        g.this.pTI = g.this.DhN.pTI;
                        g.this.DhN.Dhy = m.eUs().Dht;
                        if (g.this.DgX != null) {
                            g.this.DgX.a(1250, g.this.DhN, 2);
                        }
                        AppMethodBeat.o(28200);
                    }
                }, 3000);
                Log.i("MicroMsg.ShakeCardService", "ShakeCardService do not doNetSceneShakeCard, because time is not expire");
                z = false;
            }
            if (z) {
                if (this.DhO) {
                    Log.i("MicroMsg.ShakeCardService", "ShakeCardService is doing netscene, return");
                    AppMethodBeat.o(28207);
                    return;
                } else if (this.gmu == -85.0f || this.gmv == -1000.0f) {
                    this.DhP = true;
                    Log.i("MicroMsg.ShakeCardService", "ShakeCardService location is not geted, wait 4 second");
                    this.mHandler.postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.shake.c.a.g.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(28201);
                            if (!g.this.DhO) {
                                g.d(g.this);
                            }
                            AppMethodBeat.o(28201);
                        }
                    }, 4000);
                    AppMethodBeat.o(28207);
                    return;
                } else {
                    eUw();
                }
            }
            AppMethodBeat.o(28207);
            return;
        }
        this.DgX.a(1250, (e) obj, 1);
        m.eUs().putValue("key_shake_card_item", null);
        Log.i("MicroMsg.ShakeCardService", "getlbscard return data is no empty, don't do doNetSceneShakeCard, return ok");
        AppMethodBeat.o(28207);
    }

    private void eUw() {
        AppMethodBeat.i(28208);
        if (this.DhO) {
            Log.i("MicroMsg.ShakeCardService", "ShakeCardService is doing doNetSceneShakeCard, return");
            AppMethodBeat.o(28208);
            return;
        }
        this.DhO = true;
        this.DhP = false;
        Log.i("MicroMsg.ShakeCardService", "ShakeCardService do doNetSceneShakeCard");
        this.DhM = new c(this.gmv, this.gmu, this.gwE, this.lAo);
        bg.azz().a(this.DhM, 0);
        AppMethodBeat.o(28208);
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void pause() {
        AppMethodBeat.i(28209);
        csp();
        AppMethodBeat.o(28209);
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void eTQ() {
        AppMethodBeat.i(28211);
        bg.azz().b(1250, this);
        csp();
        super.eTQ();
        AppMethodBeat.o(28211);
    }

    private void eTP() {
        AppMethodBeat.i(28212);
        this.iOv = d.bca();
        this.iOv.a(this.gmA, true);
        AppMethodBeat.o(28212);
    }

    private void csp() {
        AppMethodBeat.i(28213);
        if (this.iOv != null) {
            this.iOv.c(this.gmA);
        }
        AppMethodBeat.o(28213);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(28214);
        if (qVar instanceof c) {
            e eVar = this.DhN;
            e eVar2 = ((c) qVar).Dhq;
            eVar.pTI = eVar2.pTI;
            eVar.pRX = eVar2.pRX;
            eVar.eaP = eVar2.eaP;
            eVar.title = eVar2.title;
            eVar.pRY = eVar2.pRY;
            eVar.pRZ = eVar2.pRZ;
            eVar.gTG = eVar2.gTG;
            eVar.iwv = eVar2.iwv;
            eVar.ixw = eVar2.ixw;
            eVar.Dhr = eVar2.Dhr;
            eVar.Dhu = eVar2.Dhu;
            eVar.Dhv = eVar2.Dhv;
            eVar.Dhw = eVar2.Dhw;
            eVar.Dhx = eVar2.Dhx;
            eVar.Dhy = eVar2.Dhy;
            eVar.pSb = eVar2.pSb;
            eVar.Dhz = eVar2.Dhz;
            eVar.DhA = eVar2.DhA;
            this.pTI = this.DhN.pTI;
            Log.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd()  action_type:" + this.pTI + "  frequency_level:" + Dhr + " control_flag:" + this.DhN.Dhu);
            if (i2 == 0 && i3 == 0) {
                Dhr = this.DhN.Dhr;
                Log.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd is OK ");
                if (this.DgX != null) {
                    this.DgX.a(1250, this.DhN, 1);
                }
                eUx();
            } else if (!(i2 == 5 && i3 == -1) && (i2 != 4 || i3 == 0)) {
                Log.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + i2 + " errCode is " + i3);
                if (this.DgX != null) {
                    this.DgX.a(1250, this.DhN, 2);
                }
                eUx();
            } else {
                Log.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + i2 + " errCode is " + i3);
                if (this.DgX != null) {
                    this.DgX.a(1250, this.DhN, 2);
                }
                long Xz = (long) a.Xz(a.eUK());
                Log.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd wait nextInterval is ".concat(String.valueOf(Xz)));
                this.Dhs = (System.currentTimeMillis() / 1000) + Xz;
            }
            m.eUs().Dhr = Dhr;
            m.eUs().Dhs = this.Dhs;
            this.DhO = false;
        }
        AppMethodBeat.o(28214);
    }

    private void eUx() {
        long Xz;
        AppMethodBeat.i(28215);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (a.Xx(Dhr)) {
            Log.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is valid");
            Xz = (long) a.Xy(Dhr);
        } else {
            Log.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is not valid");
            Xz = (long) a.Xz(a.eUK());
        }
        Log.i("MicroMsg.ShakeCardService", "ShakeCardService updateWaitingTime wait nextInterval is ".concat(String.valueOf(Xz)));
        this.Dhs = Xz + currentTimeMillis;
        AppMethodBeat.o(28215);
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void resume() {
        AppMethodBeat.i(28210);
        if (this.iOv != null) {
            this.iOv.a(this.gmA, true);
        }
        AppMethodBeat.o(28210);
    }
}
