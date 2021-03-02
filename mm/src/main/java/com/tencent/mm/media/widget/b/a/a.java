package com.tencent.mm.media.widget.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.b.a.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010%\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u000fR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013RL\u0010\u0014\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013R\u001a\u0010\"\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0011\"\u0004\b$\u0010\u0013¨\u0006&"}, hxF = {"Lcom/tencent/mm/media/widget/camera2/effect/VendorFaceBeautyConfig;", "", "()V", "KEY_FB_LEVEL", "", "getKEY_FB_LEVEL", "()Ljava/lang/String;", "KEY_SKIN_RATE", "getKEY_SKIN_RATE", "KEY_SLIM_RATE", "getKEY_SLIM_RATE", "MMKV_NAME", "TAG", "getTAG", "fbLevel", "", "getFbLevel", "()I", "setFbLevel", "(I)V", "onConfigChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "type", "value", "", "getOnConfigChange", "()Lkotlin/jvm/functions/Function2;", "setOnConfigChange", "(Lkotlin/jvm/functions/Function2;)V", "skinLevel", "getSkinLevel", "setSkinLevel", "slimLevel", "getSlimLevel", "setSlimLevel", "setConfig", "plugin-mediaeditor_release"})
public final class a {
    private static final String TAG = TAG;
    private static final String iob = iob;
    private static final String ioc = ioc;
    private static final String iod = iod;
    private static int ioe = 3;
    private static int iof = 40;
    private static int iog = 40;
    private static m<? super String, ? super Integer, x> ioh;
    public static final a ioi = new a();

    static {
        AppMethodBeat.i(94181);
        AppMethodBeat.o(94181);
    }

    private a() {
    }

    public static int aPN() {
        return ioe;
    }

    public static int aPO() {
        return iof;
    }

    public static int aPP() {
        return iog;
    }

    public static void b(m<? super String, ? super Integer, x> mVar) {
        ioh = mVar;
    }

    public static void ae(String str, int i2) {
        AppMethodBeat.i(94180);
        p.h(str, "type");
        Log.i(TAG, "setConfig: " + str + ", " + i2);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("vendor_effect_config");
        b.a aVar = b.ipa;
        if (p.j(str, b.ioT)) {
            ioe = i2;
            mmkv.putInt(ioc, ioe);
        } else {
            b.a aVar2 = b.ipa;
            if (p.j(str, b.ioV)) {
                iof = i2;
                mmkv.putInt(iob, iof);
            } else {
                b.a aVar3 = b.ipa;
                if (p.j(str, b.ioU)) {
                    iog = i2;
                    mmkv.putInt(iod, iog);
                }
            }
        }
        m<? super String, ? super Integer, x> mVar = ioh;
        if (mVar != null) {
            mVar.invoke(str, Integer.valueOf(i2));
            AppMethodBeat.o(94180);
            return;
        }
        AppMethodBeat.o(94180);
    }
}
