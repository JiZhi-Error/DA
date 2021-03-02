package com.tencent.mm.plugin.ai.d.b;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ai.b.a.a.d;
import com.tencent.mm.plugin.ai.b.a.a.e;
import com.tencent.mm.plugin.ai.b.a.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.s;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.tensorflow.lite.Tensor;
import org.tensorflow.lite.c;

public final class a {
    private String kwQ;
    String kwR;
    String kwS;
    private c kwT;
    e kwU;
    f kwV;
    private float[][] kwW;
    private Map<Integer, Object> kwX;
    private boolean kwY = false;
    public long kwZ = 0;

    public a(String str, String str2, String str3) {
        AppMethodBeat.i(238912);
        this.kwQ = str;
        this.kwR = str2;
        this.kwS = str3;
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.ai.d.b.a.AnonymousClass1 */

            public final void run() {
                int i2 = 0;
                AppMethodBeat.i(238910);
                a aVar = a.this;
                long currentTicks = Util.currentTicks();
                if (aVar.kwU == null) {
                    e eVar = new e(aVar.kwR);
                    if (eVar.wW()) {
                        aVar.kwU = eVar;
                    } else {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1559, 43);
                    }
                }
                if (aVar.kwV == null) {
                    f fVar = new f(aVar.kwS);
                    fVar.wW();
                    aVar.kwV = fVar;
                }
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(aVar.kwU != null ? aVar.kwU.hashCode() : 0);
                if (aVar.kwV != null) {
                    i2 = aVar.kwV.hashCode();
                }
                objArr[1] = Integer.valueOf(i2);
                objArr[2] = Long.valueOf(Util.ticksToNow(currentTicks));
                Log.i("MicroMsg.FinderRedDotDetector", "init config finish aiFinderQuantiles [%d] aiFinderTffeat2idx[%d] cost[%d]", objArr);
                AppMethodBeat.o(238910);
            }
        }, "Ai_thread");
        AppMethodBeat.o(238912);
    }

    private MappedByteBuffer bqw() {
        AppMethodBeat.i(238913);
        if (Util.isNullOrNil(this.kwQ)) {
            AppMethodBeat.o(238913);
            return null;
        } else if (!s.YS(this.kwQ)) {
            Log.w("MicroMsg.FinderRedDotDetector", "loadModel error, model file not exists. [%s]", this.kwQ);
            AppMethodBeat.o(238913);
            return null;
        } else {
            try {
                RandomAccessFile dB = s.dB(this.kwQ, false);
                MappedByteBuffer map = dB.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, dB.length());
                AppMethodBeat.o(238913);
                return map;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.FinderRedDotDetector", e2, "load model error [%s]", this.kwQ);
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1559, 21);
                Log.w("MicroMsg.FinderRedDotDetector", "loadModel error, can not open model file. [%s]", this.kwQ);
                AppMethodBeat.o(238913);
                return null;
            }
        }
    }

    public final float ci(String str, final String str2) {
        final d dVar;
        AppMethodBeat.i(238914);
        if (this.kwV == null || this.kwU == null) {
            AppMethodBeat.o(238914);
            return -1.0f;
        }
        this.kwZ = Util.nowMilliSecond();
        long currentTicks = Util.currentTicks();
        if (!"debug".equals(str)) {
            dVar = new d(new com.tencent.mm.g.b.a.d(str), this.kwU, this.kwV);
        } else {
            dVar = new d();
            dVar.kwd = 0.95f;
            dVar.kwe = 0.8f;
            dVar.kwc = 0.95f;
            dVar.kwf = 0.9f;
            dVar.kwa = 0.4f;
            dVar.kwl = 1;
            dVar.kwq = 1;
            dVar.kwj = 2;
            dVar.kwk = 1;
            dVar.kwg = 0.0f;
            dVar.kwb = 0.75f;
            dVar.kwn = 3;
            dVar.kwm = 2;
            dVar.kwp = 1;
            dVar.kvZ = 0.9f;
            dVar.kwi = 14;
            dVar.kwh = 2;
            dVar.kwo = 0.4f;
            dVar.kwr = 0.4f;
            dVar.kws = 0.4f;
            dVar.kwt = 0.4f;
            dVar.kwu = 0.4f;
            dVar.kwv = 0.4f;
            dVar.kww = 0.4f;
            dVar.kwx = 0.4f;
        }
        final float f2 = -1.0f;
        try {
            if (!this.kwY) {
                long currentTicks2 = Util.currentTicks();
                MappedByteBuffer bqw = bqw();
                if (bqw == null) {
                    Log.w("MicroMsg.FinderRedDotDetector", "init interpreter error, model is null modelPath[%s]", this.kwQ);
                    if (this.kwT != null) {
                        this.kwT.close();
                    }
                    this.kwT = null;
                } else {
                    this.kwT = new c(bqw.asReadOnlyBuffer());
                    this.kwW = (float[][]) Array.newInstance(Float.TYPE, 1, 1);
                    this.kwX = new HashMap();
                    this.kwX.put(0, this.kwW);
                    this.kwY = true;
                    c cVar = this.kwT;
                    cVar.oa();
                    int length = cVar.UiX.Ujm.length;
                    c cVar2 = this.kwT;
                    cVar2.oa();
                    int length2 = cVar2.UiX.Ujn.length;
                    if (WeChatEnvironment.hasDebugger()) {
                        for (int i2 = 0; i2 < length; i2++) {
                            c cVar3 = this.kwT;
                            cVar3.oa();
                            Tensor awn = cVar3.UiX.awn(i2);
                            Log.i("MicroMsg.FinderRedDotDetector", "model info index[%d] inputType[%s, %d, %s] dataType[%s]", Integer.valueOf(i2), Tensor.name(awn.nativeHandle), Integer.valueOf(Tensor.numBytes(awn.nativeHandle)), awn, awn.Ujq);
                        }
                        for (int i3 = 0; i3 < length2; i3++) {
                            c cVar4 = this.kwT;
                            cVar4.oa();
                            Tensor awo = cVar4.UiX.awo(i3);
                            Log.i("MicroMsg.FinderRedDotDetector", "model info index[%d] outputType[%s, %d, %s] dataType[%s]", Integer.valueOf(i3), Tensor.name(awo.nativeHandle), Integer.valueOf(Tensor.numBytes(awo.nativeHandle)), awo, awo.Ujq);
                        }
                    }
                    Log.i("MicroMsg.FinderRedDotDetector", "initInterpreter cost[%d] model[%s] md5[%s] inputCount[%d] outputCount[%d]", Long.valueOf(Util.ticksToNow(currentTicks2)), this.kwQ, s.bhK(this.kwQ), Integer.valueOf(length), Integer.valueOf(length2));
                }
            }
            if (this.kwT != null) {
                this.kwW[0][0] = 0.0f;
                c cVar5 = this.kwT;
                Object[] bqu = dVar.bqu();
                Map<Integer, Object> map = this.kwX;
                cVar5.oa();
                cVar5.UiX.a(bqu, map);
                f2 = this.kwW[0][0];
            } else {
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1559, 22);
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FinderRedDotDetector", e2, "tf run model error.[%s]", str);
            f2 = -1.0f;
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.FinderRedDotDetector", th, "tf run model error.[%s]", str);
            f2 = -1.0f;
        }
        final long ticksToNow = Util.ticksToNow(currentTicks);
        Log.i("MicroMsg.FinderRedDotDetector", "run finish [%f] cost[%d] info [%s]", Float.valueOf(f2), Long.valueOf(ticksToNow), str);
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.ai.d.b.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(238911);
                d dVar = dVar;
                float f2 = f2;
                long j2 = ticksToNow;
                String str = str2;
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("_7dayClkH", (double) dVar.kwd);
                    jSONObject.put("_7dayClkRateH", (double) dVar.kwe);
                    jSONObject.put("_7dayImprH", (double) dVar.kwc);
                    jSONObject.put("friendsTabUnread", (double) dVar.kwf);
                    jSONObject.put("fromLastHours", (double) dVar.kwa);
                    jSONObject.put("isFriendsTabRedDot", dVar.kwl);
                    jSONObject.put("isNewMsgOpenWechat", dVar.kwq);
                    jSONObject.put("isSnsRedDot", dVar.kwj);
                    jSONObject.put("isTopStoryRedDot", dVar.kwk);
                    jSONObject.put("label", (double) dVar.kwg);
                    jSONObject.put("lastStaySecs", (double) dVar.kwb);
                    jSONObject.put("lastFinderRedDotCtrlType", dVar.kwn);
                    jSONObject.put("lastFinderRedDotShowType", dVar.kwm);
                    jSONObject.put("lastSessionId", dVar.kwp);
                    jSONObject.put("snsunread", (double) dVar.kvZ);
                    jSONObject.put("startTimeTo24H", dVar.kwi);
                    jSONObject.put("startTimeToWeekDay", dVar.kwh);
                    jSONObject.put("wechatduration7dayhour", (double) dVar.kwr);
                    jSONObject.put("wechatdurationnminute_10", (double) dVar.kws);
                    jSONObject.put("wechatdurationnminute_30", (double) dVar.kwt);
                    jSONObject.put("wechatdurationnminute_90", (double) dVar.kwu);
                    jSONObject.put("findfrienduiexposure_10", (double) dVar.kwv);
                    jSONObject.put("findfrienduiexposure_30", (double) dVar.kww);
                    jSONObject.put("findfrienduiexposure_90", (double) dVar.kwx);
                    jSONObject.put("lastsessionduration", (double) dVar.kwo);
                    jSONObject2.put("result", (double) f2);
                } catch (JSONException e2) {
                    Log.printErrStackTrace("MicroMsg.AiFinderFeatureStruct", e2, "report result error", new Object[0]);
                }
                String replace = jSONObject.toString().replace(",", ";");
                String replace2 = jSONObject2.toString().replace(",", ";");
                com.tencent.mm.g.b.a.c cVar = new com.tencent.mm.g.b.a.c();
                cVar.eiP = cVar.x("InputJson", replace, true);
                cVar.eiQ = cVar.x("OutputJson", replace2, true);
                cVar.eiR = j2;
                cVar.eiS = cVar.x("ModelMd5", str, true);
                cVar.eiT = cVar.x("OriInputJson", dVar.kwy, true);
                cVar.bfK();
                if (f2 > 0.0f) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1559, 5);
                } else {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1559, 6);
                }
                if (j2 >= 1000) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1559, 7);
                }
                int i2 = (int) (100.0f * f2);
                int intValue = ((Integer) com.tencent.mm.plugin.report.service.h.a(i2, new int[]{20, 40, 60, 80, 100}, 10, 15)).intValue();
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1559, intValue);
                Log.i("MicroMsg.AiFinderFeatureStruct", "report idkey score[%d] res[%d] struct[%s]", Integer.valueOf(i2), Integer.valueOf(intValue), cVar.abW());
                AppMethodBeat.o(238911);
            }
        }, "Ai_thread");
        AppMethodBeat.o(238914);
        return f2;
    }
}
