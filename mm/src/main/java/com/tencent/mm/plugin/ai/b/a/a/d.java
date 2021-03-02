package com.tencent.mm.plugin.ai.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ai.c.a;
import com.tencent.mm.plugin.ai.f.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class d {
    private static final int[] kvJ = {10, 30, 90};
    public float kvZ;
    public float kwa;
    public float kwb;
    public float kwc;
    public float kwd;
    public float kwe;
    public float kwf;
    public float kwg = 0.0f;
    public long kwh;
    public long kwi;
    public long kwj;
    public long kwk;
    public long kwl;
    public long kwm;
    public long kwn;
    public float kwo;
    public long kwp;
    public long kwq;
    public float kwr;
    public float kws;
    public float kwt;
    public float kwu;
    public float kwv;
    public float kww;
    public float kwx;
    public String kwy;

    public d() {
    }

    public d(com.tencent.mm.g.b.a.d dVar, e eVar, f fVar) {
        float f2;
        float f3;
        long longValue;
        long longValue2;
        float f4;
        boolean z;
        long longValue3;
        boolean z2;
        long longValue4;
        boolean z3;
        long longValue5;
        long longValue6;
        long longValue7;
        long longValue8;
        float f5;
        float f6;
        float f7;
        float a2;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        long longValue9;
        AppMethodBeat.i(238880);
        int i2 = (int) dVar.eje;
        if (!eVar.jCx) {
            f2 = 0.0f;
        } else {
            f2 = a.f(i2, eVar.kwA.get("snsunread"));
        }
        this.kvZ = f2;
        int i3 = (int) dVar.eiL;
        if (!eVar.jCx) {
            f3 = 0.0f;
        } else {
            f3 = a.f(i3, eVar.kwA.get("last_stay_secs"));
        }
        this.kwb = f3;
        long nowMilliSecond = Util.nowMilliSecond();
        int AU = a.AU(nowMilliSecond);
        int AV = a.AV(nowMilliSecond);
        if (!fVar.jCx) {
            longValue = 0;
        } else {
            HashMap<Integer, Long> hashMap = fVar.kwA.get("starttime_to_weekday");
            if (!hashMap.containsKey(Integer.valueOf(AV))) {
                longValue = 0;
            } else {
                longValue = hashMap.get(Integer.valueOf(AV)).longValue();
            }
        }
        this.kwh = longValue;
        if (!fVar.jCx) {
            longValue2 = 0;
        } else {
            HashMap<Integer, Long> hashMap2 = fVar.kwA.get("starttime_to_24h");
            if (!hashMap2.containsKey(Integer.valueOf(AU))) {
                longValue2 = 0;
            } else {
                longValue2 = hashMap2.get(Integer.valueOf(AU)).longValue();
            }
        }
        this.kwi = longValue2;
        int i4 = (int) dVar.eja;
        if (!eVar.jCx) {
            f4 = 0.0f;
        } else {
            f4 = a.f(i4, eVar.kwA.get("friendstabredunread"));
        }
        this.kwf = f4;
        if (dVar.ejd == 1) {
            z = true;
        } else {
            z = false;
        }
        if (!fVar.jCx) {
            longValue3 = 0;
        } else {
            int i5 = z ? 1 : 0;
            HashMap<Integer, Long> hashMap3 = fVar.kwA.get("is_snsreddot");
            if (!hashMap3.containsKey(Integer.valueOf(i5))) {
                longValue3 = 0;
            } else {
                longValue3 = hashMap3.get(Integer.valueOf(i5)).longValue();
            }
        }
        this.kwj = longValue3;
        if (dVar.ejf == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!fVar.jCx) {
            longValue4 = 0;
        } else {
            int i6 = z2 ? 1 : 0;
            HashMap<Integer, Long> hashMap4 = fVar.kwA.get("is_topstoryreddot");
            if (!hashMap4.containsKey(Integer.valueOf(i6))) {
                longValue4 = 0;
            } else {
                longValue4 = hashMap4.get(Integer.valueOf(i6)).longValue();
            }
        }
        this.kwk = longValue4;
        if (dVar.eiZ == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!fVar.jCx) {
            longValue5 = 0;
        } else {
            int i7 = z3 ? 1 : 0;
            HashMap<Integer, Long> hashMap5 = fVar.kwA.get("is_friendstabreddot");
            if (!hashMap5.containsKey(Integer.valueOf(i7))) {
                longValue5 = 0;
            } else {
                longValue5 = hashMap5.get(Integer.valueOf(i7)).longValue();
            }
        }
        this.kwl = longValue5;
        int i8 = dVar.eiX;
        if (!fVar.jCx) {
            longValue6 = 0;
        } else {
            HashMap<Integer, Long> hashMap6 = fVar.kwA.get("lastfinderreddotshowtype");
            if (!hashMap6.containsKey(Integer.valueOf(i8))) {
                longValue6 = 0;
            } else {
                longValue6 = hashMap6.get(Integer.valueOf(i8)).longValue();
            }
        }
        this.kwm = longValue6;
        int i9 = dVar.eiW;
        if (!fVar.jCx) {
            longValue7 = 0;
        } else {
            HashMap<Integer, Long> hashMap7 = fVar.kwA.get("lastfinderreddotctrltype");
            if (!hashMap7.containsKey(Integer.valueOf(i9))) {
                longValue7 = 0;
            } else {
                longValue7 = hashMap7.get(Integer.valueOf(i9)).longValue();
            }
        }
        this.kwn = longValue7;
        int i10 = Util.getInt(dVar.eiY, -1);
        if (i10 > 0) {
            if (!fVar.jCx) {
                longValue9 = 0;
            } else {
                HashMap<Integer, Long> hashMap8 = fVar.kwA.get("lastsessionid");
                if (!hashMap8.containsKey(Integer.valueOf(i10))) {
                    longValue9 = 0;
                } else {
                    longValue9 = hashMap8.get(Integer.valueOf(i10)).longValue();
                }
            }
            this.kwp = longValue9;
        } else {
            this.kwp = 0;
        }
        boolean z4 = dVar.eiJ;
        if (!fVar.jCx) {
            longValue8 = 0;
        } else {
            int i11 = z4 ? 1 : 0;
            HashMap<Integer, Long> hashMap9 = fVar.kwA.get("is_newmsgopenwechat");
            if (!hashMap9.containsKey(Integer.valueOf(i11))) {
                longValue8 = 0;
            } else {
                longValue8 = hashMap9.get(Integer.valueOf(i11)).longValue();
            }
        }
        this.kwq = longValue8;
        long j2 = nowMilliSecond - dVar.eiK;
        if (j2 >= 0) {
            int i12 = ((((int) j2) / 1000) / 60) / 60;
            if (!eVar.jCx) {
                f16 = 0.0f;
            } else {
                f16 = a.f(i12, eVar.kwA.get("from_last_hours"));
            }
            this.kwa = f16;
        }
        int vu = b.bqC().kxI.vu(AU);
        int vv = b.bqC().kxI.vv(AU);
        if (vu > 0) {
            f5 = (((float) vv) * 1.0f) / ((float) vu);
        } else {
            f5 = 0.0f;
        }
        if (!eVar.jCx) {
            f6 = 0.0f;
        } else {
            f6 = a.f(vu, eVar.kwA.get("7day_impr_h"));
        }
        this.kwc = f6;
        if (!eVar.jCx) {
            f7 = 0.0f;
        } else {
            f7 = a.f(vv, eVar.kwA.get("7day_clk_h"));
        }
        this.kwd = f7;
        if (!eVar.jCx) {
            a2 = 0.0f;
        } else {
            a2 = a.a(f5, eVar.kwA.get("7day_clk_rate_h"));
        }
        this.kwe = a2;
        long j3 = dVar.eji;
        if (!eVar.jCx) {
            f8 = 0.0f;
        } else {
            f8 = a.f((int) j3, eVar.kwA.get("lastsessionduration"));
        }
        this.kwo = f8;
        long j4 = dVar.ejk;
        if (!eVar.jCx) {
            f9 = 0.0f;
        } else {
            f9 = a.f((int) j4, eVar.kwA.get("wechatduration7dayhour"));
        }
        this.kwr = f9;
        long[] TJ = TJ(dVar.ejl);
        long j5 = TJ[0];
        if (!eVar.jCx) {
            f10 = 0.0f;
        } else {
            f10 = a.f((int) j5, eVar.kwA.get("wechatdurationnminute_10"));
        }
        this.kws = f10;
        long j6 = TJ[1];
        if (!eVar.jCx) {
            f11 = 0.0f;
        } else {
            f11 = a.f((int) j6, eVar.kwA.get("wechatdurationnminute_30"));
        }
        this.kwt = f11;
        long j7 = TJ[2];
        if (!eVar.jCx) {
            f12 = 0.0f;
        } else {
            f12 = a.f((int) j7, eVar.kwA.get("wechatdurationnminute_90"));
        }
        this.kwu = f12;
        long[] TJ2 = TJ(dVar.ejj);
        long j8 = TJ2[0];
        if (!eVar.jCx) {
            f13 = 0.0f;
        } else {
            f13 = a.f((int) j8, eVar.kwA.get("findfrienduiexposure_10"));
        }
        this.kwv = f13;
        long j9 = TJ2[1];
        if (!eVar.jCx) {
            f14 = 0.0f;
        } else {
            f14 = a.f((int) j9, eVar.kwA.get("findfrienduiexposure_30"));
        }
        this.kww = f14;
        long j10 = TJ2[2];
        if (!eVar.jCx) {
            f15 = 0.0f;
        } else {
            f15 = a.f((int) j10, eVar.kwA.get("findfrienduiexposure_90"));
        }
        this.kwx = f15;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("now", nowMilliSecond);
            jSONObject.put("currHour", a.AU(nowMilliSecond));
            jSONObject.put("currWeekday", a.AV(nowMilliSecond));
            jSONObject.put("_7Exposure", vu);
            jSONObject.put("_7Click", vv);
            jSONObject.put("_7Rate", (double) f5);
            jSONObject.put("snsunread", dVar.eje);
            jSONObject.put("lastStaySecs", dVar.eiL);
            jSONObject.put("friendsTabUnread", dVar.eja);
            jSONObject.put("isSnsRedDot", dVar.ejd);
            jSONObject.put("isTopStoryRedDot", dVar.ejf);
            jSONObject.put("isFriendsTabRedDot", dVar.eiZ);
            jSONObject.put("lastFinderRedDotShowType", dVar.eiX);
            jSONObject.put("lastFinderRedDotCtrlType", dVar.eiW);
            jSONObject.put("sessionId", dVar.eiY);
            jSONObject.put("isNewMsgOpenWechat", dVar.eiJ);
            long j11 = nowMilliSecond - dVar.eiK;
            if (j11 >= 0) {
                jSONObject.put("fromLastHours", ((((int) j11) / 1000) / 60) / 60);
            }
            jSONObject.put("lastsessionduration", dVar.eji);
            jSONObject.put("wechatduration7dayhour", dVar.ejk);
            jSONObject.put("wechatdurationnminute", dVar.ejl);
            jSONObject.put("findfrienduiexposure", dVar.ejj);
            this.kwy = jSONObject.toString().replace(",", ";");
            AppMethodBeat.o(238880);
        } catch (Exception e2) {
            Log.d("MicroMsg.AiFinderFeatureStruct", "note input error:[%s]", e2.toString());
            AppMethodBeat.o(238880);
        }
    }

    public final Object[] bqu() {
        AppMethodBeat.i(238881);
        Object[] objArr = new Object[25];
        try {
            objArr[0] = new float[][]{new float[]{this.kwd}};
            objArr[1] = new float[][]{new float[]{this.kwe}};
            objArr[2] = new float[][]{new float[]{this.kwc}};
            objArr[3] = new float[][]{new float[]{this.kwv}};
            objArr[4] = new float[][]{new float[]{this.kww}};
            objArr[5] = new float[][]{new float[]{this.kwx}};
            objArr[6] = new float[][]{new float[]{this.kwf}};
            objArr[7] = new float[][]{new float[]{this.kwa}};
            objArr[8] = new long[][]{new long[]{this.kwl}};
            objArr[9] = new long[][]{new long[]{this.kwq}};
            objArr[10] = new long[][]{new long[]{this.kwj}};
            objArr[11] = new long[][]{new long[]{this.kwk}};
            objArr[12] = new float[][]{new float[]{this.kwg}};
            objArr[13] = new float[][]{new float[]{this.kwb}};
            objArr[14] = new long[][]{new long[]{this.kwn}};
            objArr[15] = new long[][]{new long[]{this.kwm}};
            objArr[16] = new float[][]{new float[]{this.kwo}};
            objArr[17] = new long[][]{new long[]{this.kwp}};
            objArr[18] = new float[][]{new float[]{this.kvZ}};
            objArr[19] = new long[][]{new long[]{this.kwi}};
            objArr[20] = new long[][]{new long[]{this.kwh}};
            objArr[21] = new float[][]{new float[]{this.kwr}};
            objArr[22] = new float[][]{new float[]{this.kws}};
            objArr[23] = new float[][]{new float[]{this.kwt}};
            objArr[24] = new float[][]{new float[]{this.kwu}};
        } catch (Exception e2) {
            Log.e("MicroMsg.AiFinderFeatureStruct", "put data error [%s]", e2.toString());
        }
        AppMethodBeat.o(238881);
        return objArr;
    }

    private static long[] TJ(String str) {
        AppMethodBeat.i(238882);
        long[] jArr = new long[kvJ.length];
        try {
            JSONObject jSONObject = new JSONObject(str.replaceAll(";", ","));
            for (int i2 = 0; i2 < kvJ.length; i2++) {
                jArr[i2] = jSONObject.optLong(new StringBuilder().append(kvJ[i2]).toString(), -1);
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(238882);
        return jArr;
    }
}
