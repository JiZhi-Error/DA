package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.a.m;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u00100\u001a\u00020\u0004J\u0006\u00101\u001a\u00020!J\u0006\u00102\u001a\u00020!J\u0016\u00103\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014RL\u0010\u001b\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b( \u0012\u0004\u0012\u00020!\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0012\"\u0004\b(\u0010\u0014R\u001a\u0010)\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0012\"\u0004\b+\u0010\u0014R\u001a\u0010,\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0012\"\u0004\b.\u0010\u0014R\u000e\u0010/\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/xlabeffect/XLabEffectGlobalConfig;", "", "()V", "COUNT_DIFF", "", "KEY_END_COUNT", "", "KEY_EYE_BRIGHT", "KEY_EYE_MORPH", "KEY_FACE_MORPH", "KEY_SKIN_BRIGHT", "KEY_SKIN_SMOOTH", "KEY_START_COUNT", "MMKV_NAME", "TAG", "endCount", "eyeBright", "getEyeBright", "()I", "setEyeBright", "(I)V", "eyeMorph", "getEyeMorph", "setEyeMorph", "faceMorph", "getFaceMorph", "setFaceMorph", "onConfigChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "type", "value", "", "getOnConfigChange", "()Lkotlin/jvm/functions/Function2;", "setOnConfigChange", "(Lkotlin/jvm/functions/Function2;)V", "rosy", "getRosy", "setRosy", "skinBright", "getSkinBright", "setSkinBright", "skinSmooth", "getSkinSmooth", "setSkinSmooth", "startCount", "getNumOfThread", "markEnd", "markStart", "setConfig", "plugin-xlabeffect_release"})
public final class c {
    public static final c JRA = new c();
    private static int JRy = 0;
    private static int JRz = 0;
    private static final String TAG = TAG;
    private static int hDb = 65;
    private static int hDc;
    private static int hDd = 60;
    private static int hDe = 100;
    private static int hDf = 30;
    private static int hDg = 20;
    private static m<? super Integer, ? super Integer, x> ioh;

    static {
        AppMethodBeat.i(184222);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("xlab_effect_config");
        Log.i(TAG, "config is : " + hDb + ", " + hDc + ", " + hDd + ", " + hDe + ", " + hDf);
        JRy = mmkv.getInt("start_count", JRy);
        JRz = mmkv.getInt("end_count", JRz);
        Log.i(TAG, "count track is : " + JRy + ", " + JRz);
        AppMethodBeat.o(184222);
    }

    private c() {
    }

    public static int aEl() {
        return hDb;
    }

    public static int aEm() {
        return hDc;
    }

    public static int aEn() {
        return hDd;
    }

    public static int aEo() {
        return hDe;
    }

    public static int aEp() {
        return hDf;
    }

    public static int aEq() {
        return hDg;
    }

    public static void b(m<? super Integer, ? super Integer, x> mVar) {
        ioh = mVar;
    }

    public static void ky(int i2, int i3) {
        AppMethodBeat.i(184218);
        Log.i(TAG, "setConfig: " + i2 + ", " + i3);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("xlab_effect_config");
        switch (i2) {
            case 0:
                hDb = i3;
                mmkv.putInt("skin_smooth", hDb);
                break;
            case 1:
                hDc = i3;
                mmkv.putInt("eye_morph", hDc);
                break;
            case 2:
                hDd = i3;
                mmkv.putInt("face_morph", hDd);
                break;
            case 3:
                hDe = i3;
                mmkv.putInt("skin_bright", hDe);
                break;
            case 4:
                hDf = i3;
                mmkv.putInt("eye_bright", hDf);
                break;
        }
        m<? super Integer, ? super Integer, x> mVar = ioh;
        if (mVar != null) {
            mVar.invoke(Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(184218);
            return;
        }
        AppMethodBeat.o(184218);
    }

    public static void glp() {
        AppMethodBeat.i(184219);
        JRy++;
        MultiProcessMMKV.getMMKV("xlab_effect_config").putInt("start_count", JRy);
        AppMethodBeat.o(184219);
    }

    public static void glq() {
        AppMethodBeat.i(184220);
        JRz++;
        MultiProcessMMKV.getMMKV("xlab_effect_config").putInt("end_count", JRz);
        AppMethodBeat.o(184220);
    }

    public static int glr() {
        boolean z = false;
        AppMethodBeat.i(184221);
        MultiProcessMMKV.getMMKV("xlab_effect_config");
        boolean z2 = JRy - JRz < 3;
        if (z2) {
            z = true;
        }
        if (z) {
            h.INSTANCE.dN(1012, 101);
        } else {
            h.INSTANCE.dN(1012, 102);
        }
        Log.i(TAG, "getNumOfThread: true, " + z2);
        if (z) {
            AppMethodBeat.o(184221);
            return 2;
        }
        AppMethodBeat.o(184221);
        return 1;
    }
}
