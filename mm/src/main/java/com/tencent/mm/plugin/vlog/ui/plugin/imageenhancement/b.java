package com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement;

import android.content.Context;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.xeffect.a;
import com.tencent.mm.xeffect.effect.n;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.s;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010+\u001a\u00020,J\u0010\u0010-\u001a\u00020,2\b\u0010.\u001a\u0004\u0018\u00010/J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0007H\u0002J8\u00103\u001a\u00020\t2\u0006\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u00102\b\b\u0002\u00107\u001a\u00020\u00042\b\b\u0002\u00108\u001a\u0002012\b\b\u0002\u00109\u001a\u00020\u0019H\u0002J4\u0010:\u001a.\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u0006j\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u0001`\nH\u0002J\b\u0010;\u001a\u00020,H\u0002J\u000e\u0010<\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u001eJ\u000e\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\tJ\u0010\u0010?\u001a\u0002052\u0006\u00102\u001a\u00020\u0007H\u0002J\u000e\u0010@\u001a\u00020\u00042\u0006\u00104\u001a\u000205J\u000e\u0010A\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u0007J\u0006\u0010C\u001a\u00020,J\u0006\u0010D\u001a\u00020EJ\u0006\u0010F\u001a\u00020EJ\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010H\u001a\u00020IJ\u000e\u0010J\u001a\u00020\t2\u0006\u0010K\u001a\u00020LJ6\u0010M\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006j\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b`\n2\u0006\u0010K\u001a\u00020IJ\u0006\u0010N\u001a\u00020,J6\u0010O\u001a\u00020,2.\u0010P\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006j\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b`\nJ\u0014\u0010Q\u001a\u00020I2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u000e\u0010S\u001a\u00020L2\u0006\u0010>\u001a\u00020\tJ6\u0010T\u001a\u00020I2.\u0010U\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006j\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b`\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R9\u0010\u0005\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006j\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b`\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR9\u0010\r\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006j\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b`\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00070\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014R\u000e\u0010$\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0014R\u001a\u0010(\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0012\"\u0004\b*\u0010\u0014¨\u0006V"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/imageenhancement/ImageEnhancementFilterSettingLogic;", "", "()V", "TAG", "", "currentSettings", "Ljava/util/HashMap;", "", "", "Lcom/tencent/mm/xeffect/ImageEnhancementSceneFilterInfo;", "Lkotlin/collections/HashMap;", "getCurrentSettings", "()Ljava/util/HashMap;", "defaultSceneFilterSettings", "getDefaultSceneFilterSettings", "eyeBright", "", "getEyeBright", "()F", "setEyeBright", "(F)V", "eyeMorph", "getEyeMorph", "setEyeMorph", "faceBeautyWeights", "", "getFaceBeautyWeights", "()[F", "faceBeautyWeightsIndex", "", "Lcom/tencent/mm/xeffect/ImageEnhancementSceneFilterInfo$FaceBeautyType;", "getFaceBeautyWeightsIndex", "()Ljava/util/Map;", "faceMorph", "getFaceMorph", "setFaceMorph", "sceneSaveJsonFileName", "skinBright", "getSkinBright", "setSkinBright", "skinSmooth", "getSkinSmooth", "setSkinSmooth", "applyFilterSettings", "", "applyImageEnhancementSettings", "effect", "Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;", "builtinLutTypeFromIntValue", "Lcom/tencent/mm/xeffect/ImageEnhancementSceneFilterInfo$BuiltinLutFilterType;", "value", "createFilter", "type", "Lcom/tencent/mm/xeffect/ImageEnhancementSceneFilterInfo$FilterType;", "weight", "filterPath", "builtinLutFilterType", "filterWeights", "createSettingsFromFile", "createSettingsFromServerConfig", "faceBeautyTypeToDesc", "filterInfoDesc", "info", "filterTypeFromIntValue", "filterTypeToDesc", "imageLabelToDesc", "label", "initConfig", "isEnableDebug", "", "isShowSceneDesc", "jsonArrayToSceneFilterInfoList", "jsonArray", "Lorg/json/JSONArray;", "jsonToSceneFilterInfo", "json", "Lorg/json/JSONObject;", "jsonToSceneFiltersInfoMap", "loadFaceBeautySettings", "saveSettings", "infoMap", "sceneFilterInfoListToJson", "filtersInfo", "sceneFilterInfoToJson", "sceneFiltersInfoMapToJson", "sceneFiltersInfoMap", "plugin-vlog_release"})
public final class b {
    private static float GLA = 0.1f;
    private static float GLB = 0.2f;
    private static float GLC = 0.4f;
    private static final Map<a.b, Integer> GLD = ae.e(s.U(a.b.SkinSmooth, 0), s.U(a.b.EyeBright, 1), s.U(a.b.SkinBright, 2), s.U(a.b.EyeMorph, 3), s.U(a.b.FaceMorph, 4));
    private static final float[] GLE = {GLy, GLC, GLB, GLz, GLA};
    public static final b GLF = new b();
    private static final String GLv = (com.tencent.mm.loader.j.b.aKB() + "imageEnhancementSceneFilterSettings.json");
    private static final HashMap<Integer, List<a>> GLw = new HashMap<>();
    private static final HashMap<Integer, List<a>> GLx = new HashMap<>();
    private static float GLy = 0.45f;
    private static float GLz = 0.1f;

    static {
        AppMethodBeat.i(191770);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(a.c.BRIGHTEN_FILTER, 0.3f, null, null, null, 28));
        arrayList.add(a(a.c.LUT_FILTER, 0.3f, null, a.EnumC2175a.XinxianLut, null, 20));
        GLw.put(Integer.valueOf(n.a.Pet.ordinal()), arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(a(a.c.FACE_BEAUTY, 0.0f, null, null, new float[]{GLy, GLC, GLB, GLz, GLA}, 14));
        GLw.put(Integer.valueOf(n.a.People.ordinal()), arrayList2);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(a(a.c.ACES_FILTER, 0.5f, null, null, null, 28));
        arrayList3.add(a(a.c.LUT_FILTER, 0.3f, null, a.EnumC2175a.MeiweiLut, null, 20));
        GLw.put(Integer.valueOf(n.a.Food.ordinal()), arrayList3);
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(a(a.c.LUT_FILTER, 0.3f, null, a.EnumC2175a.QingxinLut, null, 20));
        GLw.put(Integer.valueOf(n.a.Plant.ordinal()), arrayList4);
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(a(a.c.LUT_FILTER, 0.6f, null, a.EnumC2175a.YouhuaLut, null, 20));
        GLw.put(Integer.valueOf(n.a.Flower.ordinal()), arrayList5);
        ArrayList arrayList6 = new ArrayList();
        arrayList6.add(a(a.c.LUT_FILTER, 0.6f, null, a.EnumC2175a.YuanqiLut, null, 20));
        GLw.put(Integer.valueOf(n.a.Sky.ordinal()), arrayList6);
        ArrayList arrayList7 = new ArrayList();
        arrayList7.add(a(a.c.HUE_SATURATION_FILTER, 0.5f, null, null, null, 28));
        GLw.put(Integer.valueOf(n.a.SunriseSunset.ordinal()), arrayList7);
        ArrayList arrayList8 = new ArrayList();
        arrayList8.add(a(a.c.AUTO_BALANCE_FILTER, 1.0f, null, null, null, 28));
        arrayList8.add(a(a.c.BRIGHTEN_FILTER, 0.5f, null, null, null, 28));
        GLw.put(Integer.valueOf(n.a.Snow.ordinal()), arrayList8);
        ArrayList arrayList9 = new ArrayList();
        arrayList9.add(a(a.c.ACES_FILTER, 0.3f, null, null, null, 28));
        arrayList9.add(a(a.c.HUE_SATURATION_FILTER, 0.5f, null, null, null, 28));
        GLw.put(Integer.valueOf(n.a.City.ordinal()), arrayList9);
        ArrayList arrayList10 = new ArrayList();
        arrayList10.add(a(a.c.ACES_FILTER, 0.5f, null, null, null, 28));
        GLw.put(Integer.valueOf(n.a.Night.ordinal()), arrayList10);
        ArrayList arrayList11 = new ArrayList();
        arrayList11.add(a(a.c.BRIGHTEN_FILTER, 0.3f, null, null, null, 28));
        arrayList11.add(a(a.c.LUT_FILTER, 0.2f, null, a.EnumC2175a.XinxianLut, null, 20));
        GLw.put(Integer.valueOf(n.a.Room.ordinal()), arrayList11);
        ArrayList arrayList12 = new ArrayList();
        arrayList12.add(a(a.c.AUTO_BALANCE_FILTER, 0.0f, null, null, null, 28));
        arrayList12.add(a(a.c.ACES_FILTER, 0.6f, null, null, null, 28));
        GLw.put(Integer.valueOf(n.a.Doc.ordinal()), arrayList12);
        AppMethodBeat.o(191770);
    }

    private b() {
    }

    public final void cMT() {
        AppMethodBeat.i(191753);
        if (fEb()) {
            HashMap<Integer, List<a>> fDZ = fDZ();
            if (fDZ != null) {
                GLx.clear();
                GLx.putAll(fDZ);
                fDX();
                AppMethodBeat.o(191753);
                return;
            }
            AppMethodBeat.o(191753);
            return;
        }
        fEa();
        AppMethodBeat.o(191753);
    }

    private static void fDX() {
        T t;
        boolean z;
        AppMethodBeat.i(191754);
        List<a> list = GLx.get(Integer.valueOf(n.a.People.ordinal()));
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                T next = it.next();
                if (next.Rxf == a.c.FACE_BEAUTY) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    t = next;
                    break;
                }
            }
            T t2 = t;
            if (t2 != null) {
                if (t2.Rxi.length == GLE.length) {
                    float[] fArr = t2.Rxi;
                    p.g(fArr, "it.filterWeights");
                    e.f(fArr, GLE);
                } else {
                    t2.Rxi = new float[GLE.length];
                    float[] fArr2 = GLE;
                    float[] fArr3 = t2.Rxi;
                    p.g(fArr3, "it.filterWeights");
                    e.f(fArr2, fArr3);
                }
            }
        }
        Log.i("MicroMsg.ImageEnhancementFilterSettingLogic", "loadFaceBeautySettings, skinSmooth:" + GLy + ", skinBright:" + GLB + ", faceMorph:" + GLA + ", eyeBright:" + GLC + ", eyeMorph:" + GLz);
        AppMethodBeat.o(191754);
    }

    private static /* synthetic */ a a(a.c cVar, float f2, String str, a.EnumC2175a aVar, float[] fArr, int i2) {
        AppMethodBeat.i(191755);
        if ((i2 & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 4) != 0) {
            str = "";
        }
        if ((i2 & 8) != 0) {
            aVar = a.EnumC2175a.Rxj;
        }
        if ((i2 & 16) != 0) {
            fArr = new float[0];
        }
        a aVar2 = new a();
        aVar2.Rxf = cVar;
        aVar2.Rxg = f2;
        aVar2.hDj = str;
        aVar2.Rxh = aVar;
        aVar2.Rxi = fArr;
        AppMethodBeat.o(191755);
        return aVar2;
    }

    public static String acJ(int i2) {
        AppMethodBeat.i(191756);
        Context context = MMApplicationContext.getContext();
        if (i2 == n.a.Pet.ordinal()) {
            String string = context.getString(R.string.hx2);
            p.g(string, "context.getString(R.string.video_label_pet)");
            AppMethodBeat.o(191756);
            return string;
        } else if (i2 == n.a.People.ordinal()) {
            String string2 = context.getString(R.string.hx1);
            p.g(string2, "context.getString(R.string.video_label_people)");
            AppMethodBeat.o(191756);
            return string2;
        } else if (i2 == n.a.Food.ordinal()) {
            String string3 = context.getString(R.string.hwy);
            p.g(string3, "context.getString(R.string.video_label_food)");
            AppMethodBeat.o(191756);
            return string3;
        } else if (i2 == n.a.Plant.ordinal()) {
            String string4 = context.getString(R.string.hx3);
            p.g(string4, "context.getString(R.string.video_label_plant)");
            AppMethodBeat.o(191756);
            return string4;
        } else if (i2 == n.a.Flower.ordinal()) {
            String string5 = context.getString(R.string.hwx);
            p.g(string5, "context.getString(R.string.video_label_flower)");
            AppMethodBeat.o(191756);
            return string5;
        } else if (i2 == n.a.Sky.ordinal()) {
            String string6 = context.getString(R.string.hx5);
            p.g(string6, "context.getString(R.string.video_label_sky)");
            AppMethodBeat.o(191756);
            return string6;
        } else if (i2 == n.a.SunriseSunset.ordinal()) {
            String string7 = context.getString(R.string.hx7);
            p.g(string7, "context.getString(R.stri…ideo_label_sunrisesunset)");
            AppMethodBeat.o(191756);
            return string7;
        } else if (i2 == n.a.Snow.ordinal()) {
            String string8 = context.getString(R.string.hx6);
            p.g(string8, "context.getString(R.string.video_label_snow)");
            AppMethodBeat.o(191756);
            return string8;
        } else if (i2 == n.a.City.ordinal()) {
            String string9 = context.getString(R.string.hwv);
            p.g(string9, "context.getString(R.string.video_label_city)");
            AppMethodBeat.o(191756);
            return string9;
        } else if (i2 == n.a.Night.ordinal()) {
            String string10 = context.getString(R.string.hwz);
            p.g(string10, "context.getString(R.string.video_label_night)");
            AppMethodBeat.o(191756);
            return string10;
        } else if (i2 == n.a.Room.ordinal()) {
            String string11 = context.getString(R.string.hx4);
            p.g(string11, "context.getString(R.string.video_label_room)");
            AppMethodBeat.o(191756);
            return string11;
        } else if (i2 == n.a.Doc.ordinal()) {
            String string12 = context.getString(R.string.hww);
            p.g(string12, "context.getString(R.string.video_label_doc)");
            AppMethodBeat.o(191756);
            return string12;
        } else if (i2 == n.a.Origin.ordinal()) {
            String string13 = context.getString(R.string.hx0);
            p.g(string13, "context.getString(R.string.video_label_origin)");
            AppMethodBeat.o(191756);
            return string13;
        } else {
            AppMethodBeat.o(191756);
            return "Unknown type";
        }
    }

    public final void fDY() {
        AppMethodBeat.i(191757);
        if (fEb()) {
            fDX();
            r(GLx);
        }
        String boY = com.tencent.mm.vfs.s.boY(GLv);
        com.tencent.mm.plugin.vlog.model.local.a aVar = com.tencent.mm.plugin.vlog.model.local.a.GAD;
        p.g(boY, "settingsJson");
        com.tencent.mm.plugin.vlog.model.local.a.aUd(boY);
        AppMethodBeat.o(191757);
    }

    public static void a(n nVar) {
        AppMethodBeat.i(191758);
        String boY = com.tencent.mm.vfs.s.boY(GLv);
        p.g(boY, "json");
        if (!(boY.length() > 0) || nVar == null) {
            AppMethodBeat.o(191758);
            return;
        }
        nVar.bpE(boY);
        AppMethodBeat.o(191758);
    }

    private static JSONObject a(a aVar) {
        AppMethodBeat.i(191759);
        p.h(aVar, "info");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", aVar.Rxf.ordinal());
        jSONObject.put("filterWeight", Float.valueOf(aVar.Rxg));
        jSONObject.put("filterPath", aVar.hDj);
        jSONObject.put("builtinLutFilterType", aVar.Rxh.ordinal());
        JSONArray jSONArray = new JSONArray();
        float[] fArr = aVar.Rxi;
        p.g(fArr, "info.filterWeights");
        for (float f2 : fArr) {
            jSONArray.put(Float.valueOf(f2));
        }
        jSONObject.put("filterWeights", jSONArray);
        AppMethodBeat.o(191759);
        return jSONObject;
    }

    private static a bs(JSONObject jSONObject) {
        a.c cVar;
        a.EnumC2175a aVar;
        AppMethodBeat.i(191760);
        p.h(jSONObject, "json");
        a aVar2 = new a();
        int optInt = jSONObject.optInt("type", 0);
        a.c[] values = a.c.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                cVar = a.c.RxE;
                break;
            }
            cVar = values[i2];
            if (cVar.ordinal() == optInt) {
                break;
            }
            i2++;
        }
        aVar2.Rxf = cVar;
        aVar2.Rxg = (float) jSONObject.optDouble("filterWeight", 0.0d);
        aVar2.hDj = jSONObject.optString("filterPath");
        int optInt2 = jSONObject.optInt("builtinLutFilterType", 0);
        a.EnumC2175a[] values2 = a.EnumC2175a.values();
        int length2 = values2.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length2) {
                aVar = a.EnumC2175a.Rxj;
                break;
            }
            aVar = values2[i3];
            if (aVar.ordinal() == optInt2) {
                break;
            }
            i3++;
        }
        aVar2.Rxh = aVar;
        JSONArray optJSONArray = jSONObject.optJSONArray("filterWeights");
        if (optJSONArray != null) {
            aVar2.Rxi = new float[optJSONArray.length()];
            int length3 = optJSONArray.length();
            for (int i4 = 0; i4 < length3; i4++) {
                aVar2.Rxi[i4] = (float) optJSONArray.getDouble(i4);
            }
        }
        AppMethodBeat.o(191760);
        return aVar2;
    }

    private static JSONArray hV(List<? extends a> list) {
        AppMethodBeat.i(191761);
        p.h(list, "filtersInfo");
        JSONArray jSONArray = new JSONArray();
        for (a aVar : list) {
            jSONArray.put(a(aVar));
        }
        AppMethodBeat.o(191761);
        return jSONArray;
    }

    private static List<a> J(JSONArray jSONArray) {
        AppMethodBeat.i(191762);
        p.h(jSONArray, "jsonArray");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            p.g(jSONObject, "jsonArray.getJSONObject(i)");
            arrayList.add(bs(jSONObject));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(191762);
        return arrayList2;
    }

    private static JSONArray q(HashMap<Integer, List<a>> hashMap) {
        AppMethodBeat.i(191763);
        p.h(hashMap, "sceneFiltersInfoMap");
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<Integer, List<a>> entry : hashMap.entrySet()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene", entry.getKey().intValue());
            jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_FILTERS, hV(entry.getValue()));
            jSONArray.put(jSONObject);
        }
        AppMethodBeat.o(191763);
        return jSONArray;
    }

    private HashMap<Integer, List<a>> K(JSONArray jSONArray) {
        AppMethodBeat.i(191764);
        p.h(jSONArray, "json");
        HashMap<Integer, List<a>> hashMap = new HashMap<>();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            int optInt = jSONObject.optInt("scene", -1);
            JSONArray optJSONArray = jSONObject.optJSONArray(ShareConstants.WEB_DIALOG_PARAM_FILTERS);
            if (optInt >= 0 && optJSONArray != null) {
                hashMap.put(Integer.valueOf(optInt), J(optJSONArray));
            }
        }
        AppMethodBeat.o(191764);
        return hashMap;
    }

    private void r(HashMap<Integer, List<a>> hashMap) {
        AppMethodBeat.i(191765);
        p.h(hashMap, "infoMap");
        JSONArray q = q(hashMap);
        String str = GLv;
        String jSONArray = q.toString();
        p.g(jSONArray, "json.toString()");
        Charset charset = d.UTF_8;
        if (jSONArray == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(191765);
            throw tVar;
        }
        byte[] bytes = jSONArray.getBytes(charset);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        com.tencent.mm.vfs.s.C(str, bytes);
        AppMethodBeat.o(191765);
    }

    private final HashMap<Integer, List<a>> fDZ() {
        AppMethodBeat.i(191766);
        try {
            HashMap<Integer, List<a>> K = K(new JSONArray(com.tencent.mm.vfs.s.boY(GLv)));
            AppMethodBeat.o(191766);
            return K;
        } catch (Exception e2) {
            HashMap<Integer, List<a>> hashMap = GLw;
            AppMethodBeat.o(191766);
            return hashMap;
        }
    }

    private final void fEa() {
        b.a aVar;
        AppMethodBeat.i(191767);
        int ordinal = b.a.clicfg_image_enhancement_scene_config_1.ordinal();
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < 5; i2++) {
            b.a[] values = b.a.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    aVar = null;
                    break;
                }
                b.a aVar2 = values[i3];
                if (aVar2.ordinal() == ordinal + i2) {
                    aVar = aVar2;
                    break;
                }
                i3++;
            }
            String a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(aVar, "");
            Log.i("MicroMsg.ImageEnhancementFilterSettingLogic", "scene_config_" + i2 + " json:" + a2);
            p.g(a2, "sceneJson");
            if (a2.length() > 0) {
                try {
                    JSONArray jSONArray2 = new JSONArray(a2);
                    Log.i("MicroMsg.ImageEnhancementFilterSettingLogic", "parse scene_config_" + i2 + " len:" + jSONArray2.length());
                    if (jSONArray2.length() > 0) {
                        int length2 = jSONArray2.length();
                        for (int i4 = 0; i4 < length2; i4++) {
                            JSONObject optJSONObject = jSONArray2.optJSONObject(i4);
                            if (optJSONObject != null) {
                                jSONArray.put(optJSONObject);
                            }
                        }
                    }
                } catch (Exception e2) {
                }
            }
        }
        Log.i("MicroMsg.ImageEnhancementFilterSettingLogic", "finalConfigJson:" + jSONArray + ", save to file:" + GLv);
        String str = GLv;
        String jSONArray3 = jSONArray.toString();
        p.g(jSONArray3, "finalConfigJson.toString()");
        Charset charset = d.UTF_8;
        if (jSONArray3 == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(191767);
            throw tVar;
        }
        byte[] bytes = jSONArray3.getBytes(charset);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        com.tencent.mm.vfs.s.C(str, bytes);
        GLx.clear();
        GLx.putAll(K(jSONArray));
        AppMethodBeat.o(191767);
    }

    private static boolean fEb() {
        AppMethodBeat.i(191768);
        if (MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_SHOW_IMAGE_ENHANCEMENT_SETTING_INT_SYNC", 0) == 1) {
            AppMethodBeat.o(191768);
            return true;
        }
        AppMethodBeat.o(191768);
        return false;
    }

    public static boolean fEc() {
        AppMethodBeat.i(191769);
        if (MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_SHOW_IMAGE_ENHANCEMENT_SCENE_INT_SYNC", 0) == 1) {
            AppMethodBeat.o(191769);
            return true;
        }
        AppMethodBeat.o(191769);
        return false;
    }
}
