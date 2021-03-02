package com.tencent.mm.modelsns;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.ecl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.concurrent.atomic.AtomicInteger;

public final class k {
    private static boolean jiQ = false;
    private static AtomicInteger jlt = new AtomicInteger(0);
    public Object jlk = null;
    public int jll = 1;
    public int jlm;
    public int jln;
    public int jlo;
    public StringBuffer jlp = new StringBuffer();
    public StringBuffer jlq = new StringBuffer();
    public StringBuffer jlr = new StringBuffer();
    public StringBuffer jls = new StringBuffer();
    public int opType = 0;
    public long timeStamp;

    static {
        AppMethodBeat.i(125679);
        AppMethodBeat.o(125679);
    }

    public static k tO(int i2) {
        AppMethodBeat.i(125657);
        k kVar = new k(i2, 1);
        AppMethodBeat.o(125657);
        return kVar;
    }

    public static k tP(int i2) {
        AppMethodBeat.i(125658);
        k kVar = new k(i2, 4);
        AppMethodBeat.o(125658);
        return kVar;
    }

    public final boolean bfG() {
        int i2 = l.jlv;
        if (i2 == 0) {
            return false;
        }
        if (i2 == 1) {
            if (this.opType >= 501 && this.opType <= 700) {
                return true;
            }
            if (this.opType >= 701 && this.opType <= 1000) {
                return true;
            }
        }
        if (i2 == 2 && this.opType >= 701 && this.opType <= 1000) {
            return true;
        }
        if (i2 == 3 && this.opType >= 501 && this.opType <= 700) {
            return true;
        }
        if (i2 == 4) {
            if (this.opType >= 701 && this.opType <= 1000) {
                return true;
            }
            if (this.opType < 501 || this.opType > 700) {
                return false;
            }
            return true;
        }
        return false;
    }

    public k(int i2, int i3) {
        AppMethodBeat.i(125659);
        this.opType = i2;
        this.jlo = i3;
        if (!bfG()) {
            AppMethodBeat.o(125659);
            return;
        }
        this.timeStamp = System.currentTimeMillis();
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            this.jln = 4;
        } else if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
            this.jln = 3;
        } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
            this.jln = 2;
        } else if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
            this.jln = 1;
        } else {
            this.jln = 0;
        }
        this.jlm = jlt.incrementAndGet();
        AppMethodBeat.o(125659);
    }

    public final boolean tQ(int i2) {
        AppMethodBeat.i(125660);
        this.jlk = Integer.valueOf(i2);
        AppMethodBeat.o(125660);
        return true;
    }

    public final void update() {
        AppMethodBeat.i(125661);
        if (!bfG()) {
            AppMethodBeat.o(125661);
            return;
        }
        this.timeStamp = System.currentTimeMillis();
        this.jlm = jlt.incrementAndGet();
        AppMethodBeat.o(125661);
    }

    public final k PH(String str) {
        AppMethodBeat.i(125662);
        if (!bfG()) {
            AppMethodBeat.o(125662);
        } else {
            if (this.jlp.length() != 0) {
                this.jlp.append("||".concat(String.valueOf(str)));
            } else if (Util.isNullOrNil(str)) {
                this.jlp.append(" ");
            } else {
                this.jlp.append(str);
            }
            AppMethodBeat.o(125662);
        }
        return this;
    }

    public final k tR(int i2) {
        AppMethodBeat.i(125663);
        k PH = PH(String.valueOf(i2));
        AppMethodBeat.o(125663);
        return PH;
    }

    public final k PI(String str) {
        AppMethodBeat.i(125664);
        if (!bfG()) {
            AppMethodBeat.o(125664);
        } else {
            if (this.jlq.length() == 0) {
                this.jlq.append(str);
            } else {
                this.jlq.append("||".concat(String.valueOf(str)));
            }
            AppMethodBeat.o(125664);
        }
        return this;
    }

    public final k bfH() {
        AppMethodBeat.i(125665);
        this.jlq = new StringBuffer();
        AppMethodBeat.o(125665);
        return this;
    }

    public final k bfI() {
        AppMethodBeat.i(125666);
        this.jlp = new StringBuffer();
        AppMethodBeat.o(125666);
        return this;
    }

    public final k PJ(String str) {
        AppMethodBeat.i(125667);
        if (!bfG()) {
            AppMethodBeat.o(125667);
        } else {
            if (this.jlr.length() == 0) {
                this.jlr.append(str);
            } else {
                this.jlr.append("||".concat(String.valueOf(str)));
            }
            AppMethodBeat.o(125667);
        }
        return this;
    }

    public final k fL(boolean z) {
        AppMethodBeat.i(125668);
        k PH = PH(z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        AppMethodBeat.o(125668);
        return PH;
    }

    public final k tS(int i2) {
        AppMethodBeat.i(125669);
        if (!bfG()) {
            AppMethodBeat.o(125669);
        } else {
            if (this.jlq.length() == 0) {
                this.jlq.append(i2);
            } else {
                this.jlq.append("||".concat(String.valueOf(i2)));
            }
            AppMethodBeat.o(125669);
        }
        return this;
    }

    public static void bfJ() {
        AppMethodBeat.i(125670);
        Log.i("MicroMsg.StatisticsOplog", "wait op");
        AppMethodBeat.o(125670);
    }

    public final boolean bfK() {
        AppMethodBeat.i(125671);
        if (!bfG()) {
            AppMethodBeat.o(125671);
            return false;
        }
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.modelsns.k.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(125656);
                k.a(k.this);
                AppMethodBeat.o(125656);
            }
        }, "StatisticsOplog");
        AppMethodBeat.o(125671);
        return true;
    }

    public final byte[] aZm() {
        AppMethodBeat.i(125672);
        ecl ecl = new ecl();
        ecl.opType = this.opType;
        ecl.jlo = this.jlo;
        ecl.jll = this.jll;
        ecl.timeStamp = this.timeStamp;
        ecl.jlm = this.jlm;
        ecl.jln = this.jln;
        ecl.NcC = this.jlp.toString();
        ecl.NcD = this.jls.toString();
        ecl.NcE = this.jlq.toString();
        ecl.NcF = this.jlr.toString();
        try {
            byte[] byteArray = ecl.toByteArray();
            AppMethodBeat.o(125672);
            return byteArray;
        } catch (Exception e2) {
            Log.e("MicroMsg.StatisticsOplog", "putIntent " + e2.getMessage());
            AppMethodBeat.o(125672);
            return null;
        }
    }

    public final void b(Intent intent, String str) {
        AppMethodBeat.i(125673);
        byte[] aZm = aZm();
        if (aZm == null) {
            AppMethodBeat.o(125673);
            return;
        }
        intent.putExtra(str, aZm);
        AppMethodBeat.o(125673);
    }

    public static k C(Bundle bundle) {
        AppMethodBeat.i(125674);
        byte[] byteArray = bundle.getByteArray("intent_key_StatisticsOplog");
        if (byteArray == null) {
            AppMethodBeat.o(125674);
            return null;
        }
        k ar = ar(byteArray);
        AppMethodBeat.o(125674);
        return ar;
    }

    public static k w(Intent intent) {
        AppMethodBeat.i(125675);
        k c2 = c(intent, "intent_key_StatisticsOplog");
        AppMethodBeat.o(125675);
        return c2;
    }

    public static k c(Intent intent, String str) {
        AppMethodBeat.i(125676);
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            AppMethodBeat.o(125676);
            return null;
        }
        k ar = ar(byteArrayExtra);
        AppMethodBeat.o(125676);
        return ar;
    }

    private static k ar(byte[] bArr) {
        AppMethodBeat.i(125677);
        if (bArr == null) {
            AppMethodBeat.o(125677);
            return null;
        }
        ecl ecl = new ecl();
        try {
            ecl.parseFrom(bArr);
            k kVar = new k(ecl.opType, ecl.jlo);
            kVar.jll = ecl.jll;
            kVar.timeStamp = ecl.timeStamp;
            kVar.jlm = ecl.jlm;
            kVar.jln = ecl.jln;
            kVar.jlp = new StringBuffer(ecl.NcC);
            kVar.jls = new StringBuffer(ecl.NcD);
            kVar.jlq = new StringBuffer(ecl.NcE);
            kVar.jlr = new StringBuffer(ecl.NcF);
            AppMethodBeat.o(125677);
            return kVar;
        } catch (Exception e2) {
            Log.e("MicroMsg.StatisticsOplog", "putIntent " + e2.getMessage());
            AppMethodBeat.o(125677);
            return null;
        }
    }

    static /* synthetic */ void a(k kVar) {
        AppMethodBeat.i(125678);
        m mVar = new m();
        mVar.n("\n\nmodel", kVar.jll + ",");
        mVar.n("opType", kVar.opType + ",");
        mVar.n("timeStamp", kVar.timeStamp + ",");
        mVar.n("seq", kVar.jlm + ",");
        mVar.n("netWork", kVar.jln + ",");
        mVar.n("page", kVar.jlo + ",");
        mVar.n("StatusDesc1", kVar.jlp.toString() + ",");
        mVar.n("DataFlowSourceInfo", kVar.jlq.toString() + ",");
        mVar.n("DataFlowResultInfo", kVar.jlr.toString() + ",");
        mVar.n("StatusDesc2", kVar.jls.toString() + ", ");
        mVar.jlx.append("bindkey: " + kVar.jlk);
        Log.d("MicroMsg.StatisticsOplog", "report logbuffer: " + mVar.abW());
        e.INSTANCE.a(12645, mVar);
        AppMethodBeat.o(125678);
    }
}
