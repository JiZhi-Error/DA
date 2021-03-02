package com.tencent.i.a.c;

import android.os.Message;
import com.tencent.h.c.h;
import com.tencent.i.a.b.a;
import com.tencent.i.a.b.b;
import com.tencent.i.a.b.c.a.d;
import com.tencent.i.a.c.b.g;
import com.tencent.i.a.c.d.a;
import com.tencent.i.a.h;
import com.tencent.i.a.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c extends a {
    private AtomicBoolean SrA = new AtomicBoolean(false);
    private AtomicBoolean SrB = new AtomicBoolean(true);
    private com.tencent.i.a.c.d.c Srz;

    public c(String str, final com.tencent.i.a.a.c cVar) {
        super(str, cVar, new b() {
            /* class com.tencent.i.a.c.c.AnonymousClass1 */

            @Override // com.tencent.i.a.b.b
            public final void hql() {
                AppMethodBeat.i(214721);
                this.Sre.a(new com.tencent.i.a.b.c.a(com.tencent.i.a.a.c.this));
                this.Sre.a(new com.tencent.i.a.b.c.b(com.tencent.i.a.a.c.this));
                AppMethodBeat.o(214721);
            }
        });
        AppMethodBeat.i(214722);
        this.Srz = new com.tencent.i.a.c.d.c(cVar);
        this.Srz.Stj = this;
        AppMethodBeat.o(214722);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.i.a.a.a
    public final void q(Message message) {
        com.tencent.i.a.c.a.a aVar = null;
        AppMethodBeat.i(214723);
        switch (message.what) {
            case 1:
                if (this.SrA.get()) {
                    h.i("sensor_MasterEngine", "[method: consumeMessage ] MSG_START_TASK started");
                    AppMethodBeat.o(214723);
                    return;
                }
                this.SqZ = (h.a) message.obj;
                hqk();
                hqi();
                com.tencent.h.c.h.d("sensor_MasterEngine", "[method: consumeMessage ] MSG_START_TASK");
                this.SrA.set(true);
                asC(1);
                asC(3);
                asC(7);
                com.tencent.i.a.c.d.c cVar = this.Srz;
                cVar.SqZ = hqh();
                if (cVar.SqZ != null) {
                    if (cVar.SqZ.Sqr == com.tencent.i.a.c.GESTURETYPE_SINGLE) {
                        aVar = new com.tencent.i.a.c.a.c(cVar.SqM, this);
                    } else if (cVar.SqZ.Sqr == com.tencent.i.a.c.GESTURETYPE_MULTI) {
                        aVar = new com.tencent.i.a.c.a.b(cVar.SqM, this);
                    }
                }
                cVar.Stq = aVar;
                cVar.Stk.clearAll();
                cVar.hqH();
                HashMap<Integer, d> hashMap = this.Sra.Sre.wLb;
                if (hashMap == null || hashMap.isEmpty()) {
                    AppMethodBeat.o(214723);
                    return;
                }
                for (Map.Entry<Integer, d> entry : hashMap.entrySet()) {
                    d value = entry.getValue();
                    if (value != null) {
                        value.a(this);
                        entry.getKey().intValue();
                        if (value != null && !value.hqr()) {
                            value.Ef(value.hqp());
                        }
                    }
                }
                AppMethodBeat.o(214723);
                return;
            case 2:
                com.tencent.h.c.h.i("sensor_MasterEngine", "[method: consumeMessage ] MSG_RESUME_TASK : " + this.SrB.get());
                if (!this.SrB.get()) {
                    com.tencent.h.c.h.i("sensor_MasterEngine", "[method: consumeMessage ] resumed");
                    AppMethodBeat.o(214723);
                    return;
                }
                this.Srz.hqH();
                this.SrB.set(false);
                AppMethodBeat.o(214723);
                return;
            case 3:
                if (!this.SrA.get() || this.SrB.get()) {
                    com.tencent.i.a.c.d.c cVar2 = this.Srz;
                    int i2 = message.arg1;
                    Object obj = message.obj;
                    a.C0145a aVar2 = cVar2.Stk;
                    if (i2 != 1) {
                        aVar2.bra(a.C0145a.mN(i2, -1)).add(obj);
                    } else if (obj != null) {
                        List list = (List) obj;
                        if (list == null || list.isEmpty()) {
                            AppMethodBeat.o(214723);
                            return;
                        }
                        g gVar = (g) list.get(0);
                        if (gVar != null) {
                            ArrayList<Object> bra = aVar2.bra(a.C0145a.mN(i2, gVar.RNh));
                            bra.addAll(list);
                            if (((com.tencent.i.a.c.d.a.this.SqZ == null || com.tencent.i.a.c.d.a.this.SqZ.Sqr != com.tencent.i.a.c.GESTURETYPE_MULTI) ? 500 : 0) <= 0) {
                                bra.clear();
                                AppMethodBeat.o(214723);
                                return;
                            }
                            int ceil = (int) Math.ceil((double) (((((float) (((long) com.tencent.i.a.c.d.a.this.SqM.SqN.hqa().Sqy) * 500)) * 1.0f) / 1000.0f) * 1.0f));
                            if (bra.size() > ceil) {
                                bra.removeAll(new ArrayList(bra.subList(0, bra.size() - ceil)));
                            }
                            AppMethodBeat.o(214723);
                            return;
                        }
                    }
                    AppMethodBeat.o(214723);
                    return;
                }
                this.Srz.v(message.arg1, message.obj);
                AppMethodBeat.o(214723);
                return;
            case 4:
                A(this.Sra.Sre.wLb);
                com.tencent.h.c.h.i("sensor_MasterEngine", "[method: consumeMessage ] MSG_NOTIFY_TASK_STOP msg.arg1 : " + message.arg1);
                if (message.arg1 == 5 || message.arg1 == 7) {
                    asB(message.arg1);
                    AppMethodBeat.o(214723);
                    return;
                }
                u(message.arg1, message.obj);
                AppMethodBeat.o(214723);
                return;
            case 5:
                com.tencent.h.c.h.i("sensor_MasterEngine", "[method: consumeMessage ] MSG_PAUSE_TASK : " + this.SrB.get());
                if (this.SrB.get()) {
                    AppMethodBeat.o(214723);
                    return;
                }
                this.SrB.set(true);
                this.Srz.Eg(true);
                AppMethodBeat.o(214723);
                return;
            case 6:
                if (!this.SrA.get()) {
                    AppMethodBeat.o(214723);
                    return;
                }
                this.SrA.set(false);
                this.SrB.set(true);
                hqj();
                com.tencent.h.c.h.i("sensor_MasterEngine", "[method: consumeMessage ] MSG_STOP_TASK_DELAY : ");
                a.C0142a aVar3 = (a.C0142a) message.obj;
                if (this.Son != null) {
                    super.b(7, -1, null, 10000);
                }
                i.a aVar4 = aVar3.Srd.length > 0 ? (i.a) aVar3.Srd[0] : null;
                this.Srz.Eg(aVar4 != null ? aVar4.Sqx : true);
                AppMethodBeat.o(214723);
                return;
            case 7:
                com.tencent.h.c.h.i("sensor_MasterEngine", "[method: consumeMessage ] MSG_STOP_TASK_IMMEDIATELY");
                hqw();
                AppMethodBeat.o(214723);
                return;
            case 8:
                com.tencent.h.c.h.i("sensor_MasterEngine", "[method: consumeMessage ] MSG_DESTROY");
                hqw();
                if (this.Son != null) {
                    this.Son.removeCallbacksAndMessages(null);
                }
                if (this.mHandlerThread != null) {
                    com.tencent.h.c.h.i("sensor_AsyncWorker", "[method: quitHandlerThread ] ");
                    this.mHandlerThread.quit();
                    break;
                }
                break;
        }
        AppMethodBeat.o(214723);
    }

    @Override // com.tencent.i.a.b.a
    public final boolean a(h.a aVar, com.tencent.i.a.b.c cVar) {
        AppMethodBeat.i(214724);
        super.a(aVar, cVar);
        u(1, aVar);
        AppMethodBeat.o(214724);
        return true;
    }

    @Override // com.tencent.i.a.b.c.a.b, com.tencent.i.a.b.a
    public final boolean hqe() {
        AppMethodBeat.i(214725);
        hqd();
        AppMethodBeat.o(214725);
        return true;
    }

    @Override // com.tencent.i.a.b.c.a.b, com.tencent.i.a.b.a
    public final boolean hqf() {
        AppMethodBeat.i(214726);
        j(4, 5, null);
        AppMethodBeat.o(214726);
        return true;
    }

    @Override // com.tencent.i.a.b.a
    public final boolean a(i.a aVar, long j2) {
        AppMethodBeat.i(214727);
        super.a(aVar, j2);
        a.C0142a aVar2 = new a.C0142a(aVar);
        if (this.Son != null) {
            Message obtainMessage = this.Son.obtainMessage();
            obtainMessage.what = 4;
            obtainMessage.arg1 = 6;
            obtainMessage.obj = aVar2;
            this.Son.sendMessageDelayed(obtainMessage, j2);
        }
        AppMethodBeat.o(214727);
        return true;
    }

    @Override // com.tencent.i.a.b.c.a.b, com.tencent.i.a.b.a
    public final boolean hqg() {
        AppMethodBeat.i(214728);
        j(4, 7, null);
        AppMethodBeat.o(214728);
        return true;
    }

    @Override // com.tencent.i.a.b.a
    public final void destroy() {
        AppMethodBeat.i(214729);
        super.destroy();
        asB(8);
        AppMethodBeat.o(214729);
    }

    @Override // com.tencent.i.a.b.c.a.b, com.tencent.i.a.b.a
    public final boolean YY() {
        AppMethodBeat.i(214730);
        boolean z = this.SrB.get();
        AppMethodBeat.o(214730);
        return z;
    }

    @Override // com.tencent.i.a.b.a
    public final boolean YZ() {
        AppMethodBeat.i(214731);
        if (!this.SrA.get()) {
            AppMethodBeat.o(214731);
            return true;
        }
        AppMethodBeat.o(214731);
        return false;
    }

    private static void A(HashMap<Integer, d> hashMap) {
        AppMethodBeat.i(214732);
        if (hashMap == null || hashMap.isEmpty()) {
            AppMethodBeat.o(214732);
            return;
        }
        for (Map.Entry<Integer, d> entry : hashMap.entrySet()) {
            d value = entry.getValue();
            if (!(value == null || value == null)) {
                value.hqq();
            }
        }
        AppMethodBeat.o(214732);
    }

    private static void B(HashMap<Integer, d> hashMap) {
        AppMethodBeat.i(214733);
        if (hashMap == null || hashMap.isEmpty()) {
            AppMethodBeat.o(214733);
            return;
        }
        for (Map.Entry<Integer, d> entry : hashMap.entrySet()) {
            d value = entry.getValue();
            if (!(value == null || value == null)) {
                value.Qt();
                value.Ef(false);
            }
        }
        AppMethodBeat.o(214733);
    }

    private void hqv() {
        AppMethodBeat.i(214734);
        asC(3);
        asC(7);
        AppMethodBeat.o(214734);
    }

    private void hqw() {
        AppMethodBeat.i(214736);
        hqj();
        B(this.Sra.Sre.wLb);
        hqv();
        this.Srz.dQn();
        AppMethodBeat.o(214736);
    }

    private void asC(int i2) {
        AppMethodBeat.i(214735);
        this.Son.removeMessages(i2);
        AppMethodBeat.o(214735);
    }
}
