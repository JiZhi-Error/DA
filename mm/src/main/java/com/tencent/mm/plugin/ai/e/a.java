package com.tencent.mm.plugin.ai.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.id;
import com.tencent.mm.g.a.ie;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.g.b.a.d;
import com.tencent.mm.g.b.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class a implements com.tencent.mm.plugin.ai.a.a {
    private static int kxf = 100;
    private static a kxg;
    private com.tencent.mm.plugin.ai.d.a.a kxh = new com.tencent.mm.plugin.ai.d.a.a();
    private com.tencent.mm.plugin.ai.d.b.a kxi;
    private b kxj = null;
    private LinkedList<Byte> kxk;
    private long kxl = 0;
    public IListener<sz> kxm = new IListener<sz>() {
        /* class com.tencent.mm.plugin.ai.e.a.AnonymousClass1 */

        {
            AppMethodBeat.i(238916);
            this.__eventId = sz.class.getName().hashCode();
            AppMethodBeat.o(238916);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(sz szVar) {
            AppMethodBeat.i(238917);
            final sz szVar2 = szVar;
            if (ChannelUtil.isGPVersion()) {
                h.INSTANCE.dN(1559, 38);
                AppMethodBeat.o(238917);
            } else if (!((aj) g.ah(aj.class)).showFinderEntry()) {
                AppMethodBeat.o(238917);
            } else {
                com.tencent.f.h.RTc.b(new Runnable() {
                    /* class com.tencent.mm.plugin.ai.e.a.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(238915);
                        try {
                            a.this.TK(szVar2.dZv.info);
                            if ("debug".equals(szVar2.dZv.info)) {
                                a.a(a.this);
                            }
                            AppMethodBeat.o(238915);
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.AiService", e2, "ai run error", new Object[0]);
                            AppMethodBeat.o(238915);
                        }
                    }
                }, "Ai_thread");
                AppMethodBeat.o(238917);
            }
            return false;
        }
    };
    public IListener<ie> kxn = new IListener<ie>() {
        /* class com.tencent.mm.plugin.ai.e.a.AnonymousClass3 */

        {
            AppMethodBeat.i(238919);
            this.__eventId = ie.class.getName().hashCode();
            AppMethodBeat.o(238919);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ie ieVar) {
            AppMethodBeat.i(238920);
            ie ieVar2 = ieVar;
            int bqB = a.this.kxj != null ? a.this.kxj.bqB() : -1;
            if (bqB <= 0) {
                AppMethodBeat.o(238920);
            } else if (ieVar2.dMM.scene != bqB) {
                AppMethodBeat.o(238920);
            } else if (Util.isNullOrNil(ieVar2.dMM.dMN)) {
                h.INSTANCE.n(1559, a.this.kxj.bqA() ? 23 : 19, 1);
                AppMethodBeat.o(238920);
            } else {
                long nowMilliSecond = Util.nowMilliSecond();
                e eVar = new e();
                e bJ = eVar.bI(a.this.kxl).bJ(nowMilliSecond);
                bJ.eiR = nowMilliSecond - a.this.kxl;
                bJ.ejo = bJ.x("TipsId", ieVar2.dMM.dMN, true);
                bJ.ejr = bJ.x("CtrlType", ieVar2.dMM.dMP, true);
                bJ.bfK();
                h.INSTANCE.n(1559, a.this.kxj.bqA() ? 24 : 20, 1);
                Log.i("MicroMsg.AiService", "get red dot [%s]", eVar.abW());
                AppMethodBeat.o(238920);
            }
            return false;
        }
    };

    static /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(238927);
        aVar.bqz();
        AppMethodBeat.o(238927);
    }

    private a() {
        AppMethodBeat.i(238921);
        AppMethodBeat.o(238921);
    }

    public static a bqx() {
        AppMethodBeat.i(238922);
        if (kxg == null) {
            kxg = new a();
        }
        a aVar = kxg;
        AppMethodBeat.o(238922);
        return aVar;
    }

    public final void TK(String str) {
        boolean z;
        String str2;
        boolean z2;
        String str3;
        String a2;
        int i2;
        AppMethodBeat.i(238923);
        long currentTicks = Util.currentTicks();
        if (this.kxi == null) {
            if (this.kxj == null) {
                if (BuildInfo.IS_ARM64) {
                    a2 = ((b) g.af(b.class)).a(b.a.clicfg_finder_red_dot_64_json_1, "");
                } else {
                    a2 = ((b) g.af(b.class)).a(b.a.clicfg_finder_red_dot_32_json_1, "");
                }
                if (Util.isNullOrNil(a2)) {
                    AppMethodBeat.o(238923);
                    return;
                }
                this.kxj = new b(a2);
                b bVar = this.kxj;
                if (!Util.isNullOrNil(bVar.dNA)) {
                    try {
                        JSONObject jSONObject = new JSONObject(bVar.dNA);
                        bVar.kxt = jSONObject.optString("zipUrl", "");
                        bVar.kxu = jSONObject.optString("zipMd5", "");
                        bVar.kxv = jSONObject.optString("tensorflowlite_jni", "");
                        bVar.kxw = jSONObject.optString("tensorflowlite_flex_jni", "");
                        bVar.kxx = jSONObject.optString("model", "");
                        bVar.kxy = jSONObject.optString("modelMd5", "");
                        bVar.pos = jSONObject.optInt("pos", -1);
                        bVar.kxz = jSONObject.optString("quantiles", "");
                        bVar.kxA = jSONObject.optString("quantilesMd5", "");
                        bVar.kxB = jSONObject.optString("tffeat2idx", "");
                        bVar.kxC = jSONObject.optString("tffeat2idxMd5", "");
                        bVar.kxD = jSONObject.optInt("randomScene", -1);
                        bVar.kxE = jSONObject.optInt("modelScene", -1);
                        bVar.kxF = jSONObject.optInt("historySize", 100);
                        bVar.kxG = jSONObject.optInt("predictGap", -1);
                        bVar.TL(jSONObject.optString("noPredictSessionId", ""));
                        bVar.kxr = true;
                    } catch (JSONException e2) {
                        Log.printErrStackTrace("MicroMsg.FinderRedDotConfig", e2, "parse error", new Object[0]);
                        bVar.kxr = false;
                    }
                }
                b bVar2 = this.kxj;
                if (!bVar2.kxr) {
                    i2 = 100;
                } else {
                    i2 = bVar2.kxF;
                }
                kxf = i2;
            }
            PString pString = new PString();
            PString pString2 = new PString();
            PString pString3 = new PString();
            boolean a3 = this.kxj.a(this.kxh, pString, pString2, pString3);
            if (!Util.isNullOrNil(pString.value) && !Util.isNullOrNil(pString2.value) && !Util.isNullOrNil(pString3.value)) {
                this.kxi = new com.tencent.mm.plugin.ai.d.b.a(pString.value, pString2.value, pString3.value);
            }
            Log.i("MicroMsg.AiService", "check config cost [%d] flag[%b] [%s %s %s]", Long.valueOf(Util.ticksToNow(currentTicks)), Boolean.valueOf(a3), pString.value, pString2.value, pString3.value);
        }
        float f2 = -1.0f;
        if (this.kxi != null) {
            b bVar3 = this.kxj;
            long j2 = this.kxi.kwZ;
            if (!bVar3.kxr) {
                z = false;
            } else if (bVar3.kxG <= 0) {
                z = true;
            } else {
                long nowMilliSecond = Util.nowMilliSecond();
                long j3 = nowMilliSecond - j2;
                z = false;
                if (j3 > ((long) bVar3.kxG) * Util.MILLSECONDS_OF_MINUTE) {
                    z = true;
                }
                Log.v("MicroMsg.FinderRedDotConfig", "need predict result[%b] now[%d] before[%d] diff[%d]", Boolean.valueOf(z), Long.valueOf(nowMilliSecond), Long.valueOf(j2), Long.valueOf(j3));
            }
            if (!z) {
                Log.i("MicroMsg.AiService", "n min can not predict");
                h.INSTANCE.n(1559, 25, 1);
                AppMethodBeat.o(238923);
                return;
            }
            b bVar4 = this.kxj;
            if (Util.isNullOrNil(str)) {
                str2 = "";
            } else if ("debug".equals(str)) {
                str2 = "";
            } else {
                str2 = new d(str).eiY;
            }
            if (!bVar4.kxr) {
                z2 = false;
            } else if (bVar4.kxH.size() <= 0) {
                z2 = true;
            } else if (Util.isNullOrNil(str2)) {
                z2 = true;
            } else {
                z2 = true;
                if (bVar4.kxH.contains(str2)) {
                    z2 = false;
                }
                Log.v("MicroMsg.FinderRedDotConfig", "need predict result[%b] sessionId[%s]", Boolean.valueOf(z2), str2);
            }
            if (!z2) {
                Log.i("MicroMsg.AiService", "this session id can not predict");
                h.INSTANCE.n(1559, 26, 1);
                AppMethodBeat.o(238923);
                return;
            }
            if (this.kxj.bqA()) {
                this.kxi.kwZ = Util.nowMilliSecond();
                f2 = ((float) Util.getIntRandom(100, 1)) / 100.0f;
            } else {
                com.tencent.mm.plugin.ai.d.b.a aVar = this.kxi;
                if (this.kxj != null) {
                    b bVar5 = this.kxj;
                    if (bVar5.kxr) {
                        str3 = bVar5.kxy;
                        f2 = aVar.ci(str, str3);
                    }
                }
                str3 = "";
                f2 = aVar.ci(str, str3);
            }
            if (aC(f2)) {
                bqz();
            }
        }
        Log.i("MicroMsg.AiService", "predictFinderRedDot [%f] cost end [%d]", Float.valueOf(f2), Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(238923);
    }

    private boolean aC(float f2) {
        int i2;
        AppMethodBeat.i(238924);
        long currentTicks = Util.currentTicks();
        byte b2 = (byte) ((int) (100.0f * f2));
        if (b2 < 0) {
            AppMethodBeat.o(238924);
            return false;
        }
        if (this.kxk == null) {
            this.kxk = new LinkedList<>();
            byte[] decodeBytes = com.tencent.mm.plugin.ai.f.b.bqC().kxK.aTI().decodeBytes("finder_history");
            if (!Util.isNullOrNil(decodeBytes)) {
                for (byte b3 : decodeBytes) {
                    this.kxk.add(Byte.valueOf(b3));
                    if (this.kxk.size() > kxf) {
                        break;
                    }
                }
            }
        }
        if (this.kxk.size() < kxf) {
            this.kxk.push(Byte.valueOf(b2));
            bqy();
            h.INSTANCE.dN(1559, 16);
            AppMethodBeat.o(238924);
            return false;
        }
        Iterator<Byte> it = this.kxk.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (it.next().byteValue() > b2) {
                i2 = i3 + 1;
            } else {
                i2 = i3;
            }
            i3 = i2;
        }
        this.kxk.removeLast();
        this.kxk.push(Byte.valueOf(b2));
        bqy();
        if (this.kxj.getPos() < 0) {
            AppMethodBeat.o(238924);
            return false;
        }
        boolean z = i3 < this.kxj.getPos();
        if (z) {
            h.INSTANCE.dN(1559, 17);
        } else {
            h.INSTANCE.dN(1559, 18);
        }
        Log.i("MicroMsg.AiService", "checkAndSaveResult needSync[%b] [%d %d] cost[%d]", Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(this.kxj.getPos()), Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(238924);
        return z;
    }

    private void bqy() {
        AppMethodBeat.i(238925);
        if (this.kxk == null || this.kxk.size() <= 0) {
            AppMethodBeat.o(238925);
            return;
        }
        com.tencent.f.h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.ai.e.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(238918);
                byte[] bArr = new byte[Math.min(a.this.kxk.size(), a.kxf)];
                int i2 = 0;
                Iterator it = a.this.kxk.iterator();
                while (it.hasNext()) {
                    i2++;
                    bArr[i2] = ((Byte) it.next()).byteValue();
                    if (i2 >= a.kxf) {
                        break;
                    }
                }
                com.tencent.mm.plugin.ai.f.b.bqC().kxK.aTI().encode("finder_history", bArr);
                AppMethodBeat.o(238918);
            }
        }, "Ai_thread");
        AppMethodBeat.o(238925);
    }

    private void bqz() {
        AppMethodBeat.i(238926);
        int bqB = this.kxj != null ? this.kxj.bqB() : -1;
        if (bqB > 0) {
            id idVar = new id();
            idVar.dMJ.dMK = true;
            idVar.dMJ.dML = 47613;
            idVar.dMJ.scene = bqB;
            EventCenter.instance.publish(idVar);
            this.kxl = Util.nowMilliSecond();
        }
        Log.i("MicroMsg.AiService", "start to finder sync [%d]", Integer.valueOf(bqB));
        AppMethodBeat.o(238926);
    }
}
