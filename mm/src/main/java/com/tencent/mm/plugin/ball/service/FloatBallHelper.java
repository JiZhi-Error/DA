package com.tencent.mm.plugin.ball.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class FloatBallHelper {
    private ResultReceiver cBu = new ResultReceiver(MMHandler.createFreeHandler(Looper.getMainLooper())) {
        /* class com.tencent.mm.plugin.ball.service.FloatBallHelper.AnonymousClass5 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* access modifiers changed from: protected */
        public void onReceiveResult(int i2, Bundle bundle) {
            AppMethodBeat.i(258540);
            switch (i2) {
                case 1:
                    if (bundle != null) {
                        int i3 = bundle.getInt("type", 0);
                        String string = bundle.getString("key", null);
                        if (i3 != 0) {
                            FloatBallHelper.this.ag(i3, string);
                            Log.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(ADD_BALL_INFO), type:%d, key: %s", Integer.valueOf(i2), Integer.valueOf(i3), string);
                            AppMethodBeat.o(258540);
                            return;
                        }
                        Log.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(ADD_BALL_INFO), no type", Integer.valueOf(i2));
                        AppMethodBeat.o(258540);
                        return;
                    }
                    Log.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(ADD_BALL_INFO), no resultData", Integer.valueOf(i2));
                    AppMethodBeat.o(258540);
                    return;
                case 2:
                    Log.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(UPDATE_BALL_INFO)", Integer.valueOf(i2));
                    AppMethodBeat.o(258540);
                    return;
                case 3:
                    Log.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(REMOVE_BALL_INFO)", Integer.valueOf(i2));
                    FloatBallHelper.this.bCB();
                    AppMethodBeat.o(258540);
                    return;
                case 4:
                    Log.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(FINISH_WHEN_SWITCH_BALL)", Integer.valueOf(i2));
                    FloatBallHelper.this.aGi();
                    AppMethodBeat.o(258540);
                    return;
                case 5:
                    if (bundle == null) {
                        Log.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(BALL_INFO_COUNT_CHANGED), no resultData", Integer.valueOf(i2));
                        break;
                    } else {
                        int i4 = bundle.getInt("ActiveCount", 0);
                        FloatBallHelper.this.BG(i4);
                        Log.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(BALL_INFO_COUNT_CHANGED), activeCount:%s", Integer.valueOf(i2), Integer.valueOf(i4));
                        AppMethodBeat.o(258540);
                        return;
                    }
            }
            AppMethodBeat.o(258540);
        }
    };
    public BallInfo oWE;
    protected int oWF;
    protected b oWG = ((b) g.af(b.class));
    protected FloatBallProxyUI.a oWH = new FloatBallProxyUI.a() {
        /* class com.tencent.mm.plugin.ball.service.FloatBallHelper.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.ball.ui.FloatBallProxyUI.a
        public final void eU(int i2, int i3) {
            AppMethodBeat.i(258538);
            Log.i("MicroMsg.FloatBallHelper", "floatBallProxyUIResultCallback, reach count limit, callback: %d", Integer.valueOf(i3));
            if (i3 == 1) {
                Log.i("MicroMsg.FloatBallHelper", "floatBallProxyUIResultCallback, show float menu view");
                FloatBallHelper.this.a(FloatBallHelper.this.oWI);
                AppMethodBeat.o(258538);
                return;
            }
            if (i3 == 2 && i2 == 1 && FloatBallHelper.this.oWE != null) {
                FloatBallHelper.this.oWE.oWs.oWz = 2;
                ((b) g.af(b.class)).r(FloatBallHelper.this.oWE);
            }
            AppMethodBeat.o(258538);
        }
    };
    protected ResultReceiver oWI = new ResultReceiverImpl(MMHandler.createFreeHandler(Looper.getMainLooper()), this);

    static class ResultReceiverImpl extends ResultReceiver {
        protected WeakReference<FloatBallHelper> Jux;

        public ResultReceiverImpl(Handler handler, FloatBallHelper floatBallHelper) {
            super(handler);
            AppMethodBeat.i(258541);
            this.Jux = new WeakReference<>(floatBallHelper);
            AppMethodBeat.o(258541);
        }

        /* access modifiers changed from: protected */
        public void onReceiveResult(int i2, Bundle bundle) {
            AppMethodBeat.i(258542);
            if (this.Jux == null) {
                AppMethodBeat.o(258542);
                return;
            }
            FloatBallHelper floatBallHelper = this.Jux.get();
            if (floatBallHelper == null) {
                AppMethodBeat.o(258542);
                return;
            }
            if (i2 == 2 && bundle != null) {
                boolean z = bundle.getBoolean("can_add_float_ball_when_hide", false);
                if (z && floatBallHelper.cio()) {
                    Log.i("MicroMsg.FloatBallHelper", "alvinluo autoAddFloatBall onReceiveResult add new after remove floatBall done");
                    floatBallHelper.ciw().oWz = 1;
                    floatBallHelper.y(true, 7);
                    AppMethodBeat.o(258542);
                    return;
                } else if (floatBallHelper.oWE != null) {
                    Log.i("MicroMsg.FloatBallHelper", "alvinluo autoAddFloatBall onReceiveResult not add, canAdd: %b", Boolean.valueOf(z));
                    floatBallHelper.ciw().oWz = 2;
                    ((b) g.af(b.class)).r(floatBallHelper.oWE);
                }
            }
            AppMethodBeat.o(258542);
        }
    }

    public FloatBallHelper() {
        AppMethodBeat.i(106062);
        AppMethodBeat.o(106062);
    }

    public boolean aGg() {
        return false;
    }

    public boolean aGh() {
        return false;
    }

    public void y(boolean z, int i2) {
    }

    public void G(int i2, String str) {
        AppMethodBeat.i(106063);
        this.oWE = new BallInfo(i2, str);
        this.oWF = i2;
        BallInfo cim = cim();
        if (cim != null) {
            Log.i("MicroMsg.FloatBallHelper", "replaceCurrentBallIfNeed, replace current ball");
            this.oWE = cim;
        }
        if (this.oWG != null) {
            this.oWG.a(this.oWE, this.cBu);
        }
        AppMethodBeat.o(106063);
    }

    public boolean wu(int i2) {
        return false;
    }

    public void bCA() {
        AppMethodBeat.i(106065);
        v(new a$1(this));
        AppMethodBeat.o(106065);
    }

    public void aGf() {
        AppMethodBeat.i(106066);
        v(new a$2(this));
        AppMethodBeat.o(106066);
    }

    public void aGj() {
        AppMethodBeat.i(106067);
        v(new a$3(this));
        AppMethodBeat.o(106067);
    }

    /* access modifiers changed from: protected */
    public final boolean cij() {
        AppMethodBeat.i(216975);
        if (!bCG() || ciq()) {
            AppMethodBeat.o(216975);
            return false;
        }
        AppMethodBeat.o(216975);
        return true;
    }

    /* access modifiers changed from: protected */
    public void bCB() {
    }

    /* access modifiers changed from: protected */
    public void aGi() {
    }

    /* access modifiers changed from: protected */
    public void BG(int i2) {
    }

    /* access modifiers changed from: protected */
    public void ag(int i2, String str) {
    }

    private static String cik() {
        AppMethodBeat.i(106068);
        int azs = a.azs();
        if (azs != 0) {
            String str = (((long) azs) & Util.MAX_32BIT_VALUE) + "#" + "float_ball_storage";
            Log.i("MicroMsg.FloatBallHelper", "accountDataKey:%s", str);
            AppMethodBeat.o(106068);
            return str;
        }
        Log.i("MicroMsg.FloatBallHelper", "accountDataKey:%s", "float_ball_storage");
        AppMethodBeat.o(106068);
        return "float_ball_storage";
    }

    public final void dhp() {
        AppMethodBeat.i(106069);
        if (this.oWG != null) {
            this.oWG.dhp();
        }
        AppMethodBeat.o(106069);
    }

    public final void a(ResultReceiver resultReceiver) {
        AppMethodBeat.i(216976);
        if (this.oWG != null) {
            this.oWG.a(resultReceiver);
        }
        AppMethodBeat.o(216976);
    }

    public final BallInfo cil() {
        AppMethodBeat.i(106071);
        if (this.oWG != null) {
            BallInfo h2 = this.oWG.h(this.oWE);
            AppMethodBeat.o(106071);
            return h2;
        }
        AppMethodBeat.o(106071);
        return null;
    }

    public BallInfo cim() {
        AppMethodBeat.i(106072);
        BallInfo cin = cin();
        AppMethodBeat.o(106072);
        return cin;
    }

    public final BallInfo cin() {
        AppMethodBeat.i(106073);
        if (this.oWE != null) {
            String cif = this.oWE.cif();
            Log.v("MicroMsg.FloatBallHelper", "getCurrentBallFromMMKV ballInfoKey: %s", cif);
            String decodeString = MultiProcessMMKV.getMMKV(cik()).decodeString(cif);
            if (!Util.isNullOrNil(decodeString)) {
                BallInfo agR = agR(decodeString);
                Log.i("MicroMsg.FloatBallHelper", "getCurrentBallFromMMKV, data:%s, ballInfo:%s", decodeString, agR);
                AppMethodBeat.o(106073);
                return agR;
            }
            Log.w("MicroMsg.FloatBallHelper", "getCurrentBallFromMMKV, no saved data");
        }
        AppMethodBeat.o(106073);
        return null;
    }

    private BallInfo agR(String str) {
        AppMethodBeat.i(216977);
        try {
            BallInfo av = BallInfo.av(new JSONObject(str));
            AppMethodBeat.o(216977);
            return av;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.FloatBallHelper", e2, "getCurrentBallFromMMKV:%s", this.oWE);
            AppMethodBeat.o(216977);
            return null;
        }
    }

    public final boolean cio() {
        AppMethodBeat.i(106074);
        if (this.oWG != null) {
            boolean i2 = this.oWG.i(this.oWE);
            AppMethodBeat.o(106074);
            return i2;
        }
        AppMethodBeat.o(106074);
        return false;
    }

    public static int cip() {
        AppMethodBeat.i(216978);
        int decodeInt = MultiProcessMMKV.getMMKV(cik()).decodeInt("ActiveCount", 0);
        AppMethodBeat.o(216978);
        return decodeInt;
    }

    public final boolean ciq() {
        AppMethodBeat.i(106075);
        if (this.oWG == null) {
            AppMethodBeat.o(106075);
            return false;
        } else if (this.oWG.h(this.oWE) != null) {
            AppMethodBeat.o(106075);
            return true;
        } else {
            AppMethodBeat.o(106075);
            return false;
        }
    }

    public void cir() {
        AppMethodBeat.i(106076);
        if (this.oWG != null) {
            this.oWG.l(this.oWE);
        }
        AppMethodBeat.o(106076);
    }

    public void cis() {
        AppMethodBeat.i(106077);
        if (this.oWG != null) {
            this.oWG.j(this.oWE);
        }
        AppMethodBeat.o(106077);
    }

    public void cit() {
        AppMethodBeat.i(106078);
        if (this.oWG != null) {
            this.oWG.k(this.oWE);
        }
        AppMethodBeat.o(106078);
    }

    public final void dhz() {
        AppMethodBeat.i(106079);
        if (this.oWG != null) {
            this.oWG.jM(true);
        }
        AppMethodBeat.o(106079);
    }

    public final void cjk() {
        AppMethodBeat.i(106080);
        if (this.oWG != null) {
            this.oWG.jL(true);
        }
        AppMethodBeat.o(106080);
    }

    public final void ciu() {
        AppMethodBeat.i(216979);
        if (this.oWG != null) {
            this.oWG.t(this.oWE);
        }
        AppMethodBeat.o(216979);
    }

    public final void dhA() {
        AppMethodBeat.i(258543);
        if (this.oWG != null) {
            this.oWG.a(System.currentTimeMillis(), (b.a) null);
        }
        AppMethodBeat.o(258543);
    }

    public final void agS(String str) {
        AppMethodBeat.i(106081);
        if (this.oWE != null && !Util.isNullOrNil(str) && !eV(this.oWE.icon, str)) {
            Log.i("MicroMsg.FloatBallHelper", "updateIcon, icon:%s", str);
            this.oWE.icon = str;
            cit();
        }
        AppMethodBeat.o(106081);
    }

    public final void U(boolean z) {
        AppMethodBeat.i(106082);
        if (!(this.oWE == null || this.oWG == null)) {
            this.oWG.a(this.oWE, z);
        }
        AppMethodBeat.o(106082);
    }

    public void agT(String str) {
        AppMethodBeat.i(106083);
        if (this.oWE != null && !Util.isNullOrNil(str)) {
            if (str.length() > 50) {
                str = str.substring(0, 50);
            }
            if (!eV(this.oWE.name, str)) {
                Log.i("MicroMsg.FloatBallHelper", "updateName, name:%s", str);
                this.oWE.name = str;
                cit();
            }
        }
        AppMethodBeat.o(106083);
    }

    public final void agU(String str) {
        AppMethodBeat.i(106084);
        if (this.oWE != null && !Util.isNullOrNil(str) && !eV(this.oWE.desc, str)) {
            Log.i("MicroMsg.FloatBallHelper", "updateDesc, desc:%s", str);
            this.oWE.desc = str;
            cit();
        }
        AppMethodBeat.o(106084);
    }

    public final void BH(int i2) {
        AppMethodBeat.i(106085);
        if (!(this.oWE == null || this.oWE.state == i2)) {
            Log.i("MicroMsg.FloatBallHelper", "updateState, state:%s", Integer.valueOf(i2));
            this.oWE.state = i2;
            cit();
        }
        AppMethodBeat.o(106085);
    }

    public final void jT(boolean z) {
        AppMethodBeat.i(106086);
        if (!(this.oWE == null || this.oWE.oWr == z)) {
            Log.i("MicroMsg.FloatBallHelper", "updatePassive, passive:%s", Boolean.valueOf(z));
            this.oWE.oWr = z;
            cit();
        }
        AppMethodBeat.o(106086);
    }

    public final void jU(boolean z) {
        AppMethodBeat.i(176959);
        if (!(this.oWE == null || this.oWE.nno == z)) {
            Log.i("MicroMsg.FloatBallHelper", "updateHidden, hidden:%s", Boolean.valueOf(z));
            this.oWE.nno = z;
            cit();
        }
        AppMethodBeat.o(176959);
    }

    public final void eU(String str, String str2) {
        AppMethodBeat.i(106087);
        if (this.oWE != null && (!this.oWE.hasExtra(str) || !eV(this.oWE.eT(str, str2), str2))) {
            Log.printInfoStack("MicroMsg.FloatBallHelper", "updateStringExtra, %s:%s", str, str2);
            this.oWE.eS(str, str2);
            cit();
        }
        AppMethodBeat.o(106087);
    }

    public final void civ() {
        AppMethodBeat.i(258544);
        cit();
        AppMethodBeat.o(258544);
    }

    public final void Bz(long j2) {
        AppMethodBeat.i(184560);
        if (!(this.oWE == null || this.oWE.progress == j2)) {
            Log.v("MicroMsg.FloatBallHelper", "updateProgress, progress:%d", Long.valueOf(j2));
            this.oWE.progress = j2;
            cit();
        }
        AppMethodBeat.o(184560);
    }

    public final BallReportInfo ciw() {
        AppMethodBeat.i(106088);
        if (this.oWE == null) {
            IllegalStateException illegalStateException = new IllegalStateException("call FloatBallHelper#onCreate first");
            AppMethodBeat.o(106088);
            throw illegalStateException;
        }
        BallReportInfo ballReportInfo = this.oWE.oWs;
        AppMethodBeat.o(106088);
        return ballReportInfo;
    }

    private static boolean eV(String str, String str2) {
        AppMethodBeat.i(106089);
        if (str == null && str2 == null) {
            AppMethodBeat.o(106089);
            return true;
        } else if ("".equals(str) && "".equals(str2)) {
            AppMethodBeat.o(106089);
            return true;
        } else if (Util.isNullOrNil(str) || Util.isNullOrNil(str2) || !str.equals(str2)) {
            AppMethodBeat.o(106089);
            return false;
        } else {
            AppMethodBeat.o(106089);
            return true;
        }
    }

    public final BallInfo cix() {
        return this.oWE;
    }

    public boolean bCG() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean ciy() {
        AppMethodBeat.i(216981);
        boolean bCG = bCG();
        AppMethodBeat.o(216981);
        return bCG;
    }

    /* access modifiers changed from: package-private */
    public final boolean ciz() {
        return this.oWE.type == 20;
    }

    private static void v(Runnable runnable) {
        AppMethodBeat.i(216982);
        h.RTc.e(runnable, "FloatBallLoopTag");
        AppMethodBeat.o(216982);
    }

    public void onDestroy() {
        AppMethodBeat.i(106064);
        if (this.oWG != null) {
            this.oWG.s(this.oWE);
        }
        AppMethodBeat.o(106064);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.plugin.ball.service.FloatBallHelper r7) {
        /*
        // Method dump skipped, instructions count: 140
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ball.service.FloatBallHelper.a(com.tencent.mm.plugin.ball.service.FloatBallHelper):void");
    }

    static /* synthetic */ void b(FloatBallHelper floatBallHelper) {
        AppMethodBeat.i(216984);
        Log.i("MicroMsg.FloatBallHelper", "alvinluo removeMessageBallIfNeed enable: %b, isFromMessageFloatBall: %b, ballInfo.contentType: %d, originFloatBallType: %d", Boolean.valueOf(floatBallHelper.ciy()), Boolean.valueOf(floatBallHelper.ciz()), Integer.valueOf(floatBallHelper.oWE.beK), Integer.valueOf(floatBallHelper.oWF));
        if (floatBallHelper.bCG() && floatBallHelper.ciy() && floatBallHelper.ciz() && floatBallHelper.oWG != null) {
            floatBallHelper.oWG.BD(floatBallHelper.oWF);
        }
        AppMethodBeat.o(216984);
    }
}
