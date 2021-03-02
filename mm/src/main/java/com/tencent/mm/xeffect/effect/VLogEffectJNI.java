package com.tencent.mm.xeffect.effect;

import android.content.res.AssetManager;
import android.util.Pair;
import android.util.Size;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.xeffect.XEffectLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0016\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0013J\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0016J\u0015\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0019J7\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001c0\u001b2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0000¢\u0006\u0002\b!J\u0011\u0010\"\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0015H J!\u0010#\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H J\u0019\u0010$\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u0004H J\u0011\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u0006H J\u0011\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0006H J\u0011\u0010(\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0006H J\u0011\u0010)\u001a\u00020*2\u0006\u0010&\u001a\u00020\u0006H J#\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 H J\u0019\u0010-\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010.\u001a\u00020 H J\u0019\u0010/\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0004H J1\u00101\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u00152\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000205H J!\u00107\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00062\u0006\u00108\u001a\u00020*2\u0006\u00109\u001a\u00020:H J9\u0010;\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u0002052\u0006\u0010>\u001a\u00020\u00042\u0006\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020 H J)\u0010A\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u00152\u0006\u0010C\u001a\u00020\u00152\u0006\u0010D\u001a\u00020\u0015H J!\u0010E\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u0006H J)\u0010H\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010I\u001a\u0002052\u0006\u0010J\u001a\u0002052\u0006\u0010K\u001a\u000205H J\u0019\u0010L\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010M\u001a\u00020 H J\u0019\u0010N\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010O\u001a\u000205H J\u0019\u0010P\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010M\u001a\u00020 H J\u0019\u0010Q\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010M\u001a\u00020 H J\u0019\u0010R\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010S\u001a\u000205H JA\u0010T\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u00152\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u0002052\u0006\u0010>\u001a\u00020\u00042\u0006\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020 H J\u0019\u0010V\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010W\u001a\u00020\u0015H J\u0019\u0010X\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020 H J!\u0010Z\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u00152\u0006\u0010D\u001a\u00020\u0015H J\u001d\u0010[\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010.\u001a\u00020 H\u0000¢\u0006\u0002\b\\J\u001d\u0010]\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0004H\u0000¢\u0006\u0002\b^J\u001d\u0010_\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010`\u001a\u00020aH\u0000¢\u0006\u0002\bbJ)\u0010c\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00062\u0012\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u0002050eH\u0000¢\u0006\u0002\bfJ\u001d\u0010g\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010h\u001a\u00020iH\u0000¢\u0006\u0002\bjJ-\u0010k\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u00152\u0006\u0010C\u001a\u00020\u00152\u0006\u0010D\u001a\u00020\u0015H\u0000¢\u0006\u0002\blJ\u001d\u0010m\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010n\u001a\u00020oH\u0000¢\u0006\u0002\bpJ%\u0010q\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u00152\u0006\u0010h\u001a\u00020iH\u0000¢\u0006\u0002\brJ\u001d\u0010s\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010W\u001a\u00020\u0015H\u0000¢\u0006\u0002\btJ\u001d\u0010u\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020 H\u0000¢\u0006\u0002\bvJ%\u0010w\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u00152\u0006\u0010D\u001a\u00020\u0015H\u0000¢\u0006\u0002\bxR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006y"}, hxF = {"Lcom/tencent/mm/xeffect/effect/VLogEffectJNI;", "", "()V", "TAG", "", "createEffect", "", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "asset", "Landroid/content/res/AssetManager;", "assetPath", "path", "destroyEffect", "", "effect", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "getPagDuration", "nPtr", "getPagDuration$renderlib_release", "getPagImageNum", "", "getPagImageNum$renderlib_release", "getPagSize", "Landroid/util/Size;", "getPagSize$renderlib_release", "getPagTemplateInfo", "", "Landroid/util/Pair;", "replacementType", "Lcom/tencent/mm/xeffect/effect/PAGReplacementType;", "checkMarker", "", "getPagTemplateInfo$renderlib_release", "nCreateEffect", "nCreateEffectAsset", "nCreateEffectPath", "nDestroy", "ptr", "nGetPagDuration", "nGetPagImageNum", "nGetPagSize", "", "nGetPagTemplateInfo", "", "nSetCheckMarker", "check", "nSetConfigJson", "json", "nSetEffectLayout", "centerX", "centerY", "scale", "", FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, "nSetEffectParams", "keys", "values", "", "nSetEffectText", "text", "fontSize", "fontFamily", "italic", "bold", "nSetEffectTexture", "textureId", "width", "height", "nSetEffectTime", "start", "end", "nSetFadeEffectFadeBackgroundColor", "red", "green", "blue", "nSetGradientBlurEffectBlurBottom", "blur", "nSetGradientBlurEffectBlurMaskRatio", "ratio", "nSetGradientBlurEffectBlurTop", "nSetGradientBlurEffectCenterCropBlur", "nSetGradientBlurEffectContentOffset", "offset", "nSetPagTemplateText", FirebaseAnalytics.b.INDEX, "nSetScene", "scene", "nSetShowLandmarks", "show", "nSetStickerSize", "setCheckMarker", "setCheckMarker$renderlib_release", "setConfigJson", "setConfigJson$renderlib_release", "setEffectLayout", "layout", "Lcom/tencent/mm/xeffect/effect/EffectLayoutInfo;", "setEffectLayout$renderlib_release", "setEffectParams", "effectParams", "", "setEffectParams$renderlib_release", "setEffectText", "textInfo", "Lcom/tencent/mm/xeffect/effect/EffectTextInfo;", "setEffectText$renderlib_release", "setEffectTexture", "setEffectTexture$renderlib_release", "setEffectTime", "timeRange", "Lcom/tencent/mm/xeffect/effect/EffectTimeRange;", "setEffectTime$renderlib_release", "setPagTemplateText", "setPagTemplateText$renderlib_release", "setScene", "setScene$renderlib_release", "setShowLandmarks", "setShowLandmarks$renderlib_release", "setStickerSize", "setStickerSize$renderlib_release", "renderlib_release"})
public final class VLogEffectJNI {
    public static final VLogEffectJNI INSTANCE = new VLogEffectJNI();
    private static final String TAG = TAG;

    private final native long nCreateEffect(int i2);

    private final native long nCreateEffectAsset(int i2, AssetManager assetManager, String str);

    private final native long nCreateEffectPath(int i2, String str);

    private final native void nDestroy(long j2);

    private final native long nGetPagDuration(long j2);

    private final native int nGetPagImageNum(long j2);

    private final native int[] nGetPagSize(long j2);

    private final native long[] nGetPagTemplateInfo(long j2, int i2, boolean z);

    private final native void nSetCheckMarker(long j2, boolean z);

    private final native void nSetConfigJson(long j2, String str);

    private final native void nSetEffectLayout(long j2, int i2, int i3, float f2, float f3);

    private final native void nSetEffectParams(long j2, int[] iArr, float[] fArr);

    private final native void nSetEffectText(long j2, String str, float f2, String str2, boolean z, boolean z2);

    private final native void nSetEffectTexture(long j2, int i2, int i3, int i4);

    private final native void nSetEffectTime(long j2, long j3, long j4);

    private final native void nSetPagTemplateText(long j2, int i2, String str, float f2, String str2, boolean z, boolean z2);

    private final native void nSetScene(long j2, int i2);

    private final native void nSetShowLandmarks(long j2, boolean z);

    private final native void nSetStickerSize(long j2, int i2, int i3);

    public final native void nSetFadeEffectFadeBackgroundColor(long j2, float f2, float f3, float f4);

    public final native void nSetGradientBlurEffectBlurBottom(long j2, boolean z);

    public final native void nSetGradientBlurEffectBlurMaskRatio(long j2, float f2);

    public final native void nSetGradientBlurEffectBlurTop(long j2, boolean z);

    public final native void nSetGradientBlurEffectCenterCropBlur(long j2, boolean z);

    public final native void nSetGradientBlurEffectContentOffset(long j2, float f2);

    static {
        AppMethodBeat.i(237139);
        AppMethodBeat.o(237139);
    }

    private VLogEffectJNI() {
    }

    public final long createEffect(j jVar) {
        AppMethodBeat.i(237120);
        p.h(jVar, "type");
        long nCreateEffect = nCreateEffect(jVar.ordinal());
        AppMethodBeat.o(237120);
        return nCreateEffect;
    }

    public final long createEffect(j jVar, String str) {
        AppMethodBeat.i(237121);
        p.h(jVar, "type");
        p.h(str, "path");
        long nCreateEffectPath = nCreateEffectPath(jVar.ordinal(), str);
        AppMethodBeat.o(237121);
        return nCreateEffectPath;
    }

    public final long createEffect(j jVar, AssetManager assetManager, String str) {
        AppMethodBeat.i(237122);
        p.h(jVar, "type");
        p.h(assetManager, "asset");
        p.h(str, "assetPath");
        long nCreateEffectAsset = nCreateEffectAsset(jVar.ordinal(), assetManager, str);
        AppMethodBeat.o(237122);
        return nCreateEffectAsset;
    }

    public final void setEffectTime$renderlib_release(long j2, i iVar) {
        AppMethodBeat.i(237124);
        p.h(iVar, "timeRange");
        if (j2 != 0) {
            nSetEffectTime(j2, iVar.start, iVar.boX);
        }
        AppMethodBeat.o(237124);
    }

    public final void setEffectLayout$renderlib_release(long j2, f fVar) {
        AppMethodBeat.i(237125);
        p.h(fVar, "layout");
        if (j2 != 0) {
            nSetEffectLayout(j2, fVar.centerX, fVar.centerY, fVar.scale, fVar.mat);
        }
        AppMethodBeat.o(237125);
    }

    public final void setEffectText$renderlib_release(long j2, h hVar) {
        AppMethodBeat.i(237126);
        p.h(hVar, "textInfo");
        if (j2 != 0) {
            nSetEffectText(j2, hVar.text, hVar.fontSize, hVar.fontFamily, hVar.RxU, hVar.sYW);
        }
        AppMethodBeat.o(237126);
    }

    public final void setEffectTexture$renderlib_release(long j2, int i2, int i3, int i4) {
        AppMethodBeat.i(237127);
        nSetEffectTexture(j2, i2, i3, i4);
        AppMethodBeat.o(237127);
    }

    public final void setStickerSize$renderlib_release(long j2, int i2, int i3) {
        AppMethodBeat.i(237128);
        XEffectLog.i(TAG, "setStickerSize ptr:" + j2 + ", width:" + i2 + ", height:" + i3, new Object[0]);
        nSetStickerSize(j2, i2, i3);
        AppMethodBeat.o(237128);
    }

    public final Size getPagSize$renderlib_release(long j2) {
        AppMethodBeat.i(237129);
        int[] nGetPagSize = nGetPagSize(j2);
        Size size = new Size(nGetPagSize[0], nGetPagSize[1]);
        AppMethodBeat.o(237129);
        return size;
    }

    public final int getPagImageNum$renderlib_release(long j2) {
        AppMethodBeat.i(237130);
        int nGetPagImageNum = nGetPagImageNum(j2);
        AppMethodBeat.o(237130);
        return nGetPagImageNum;
    }

    public final long getPagDuration$renderlib_release(long j2) {
        AppMethodBeat.i(237131);
        long nGetPagDuration = nGetPagDuration(j2);
        AppMethodBeat.o(237131);
        return nGetPagDuration;
    }

    public final void setCheckMarker$renderlib_release(long j2, boolean z) {
        AppMethodBeat.i(237132);
        nSetCheckMarker(j2, z);
        AppMethodBeat.o(237132);
    }

    public final void setPagTemplateText$renderlib_release(long j2, int i2, h hVar) {
        AppMethodBeat.i(237133);
        p.h(hVar, "textInfo");
        if (j2 != 0) {
            nSetPagTemplateText(j2, i2, hVar.text, hVar.fontSize, hVar.fontFamily, hVar.RxU, hVar.sYW);
        }
        AppMethodBeat.o(237133);
    }

    public final List<Pair<Long, Long>> getPagTemplateInfo$renderlib_release(long j2, q qVar, boolean z) {
        AppMethodBeat.i(237134);
        p.h(qVar, "replacementType");
        ArrayList arrayList = new ArrayList();
        long[] nGetPagTemplateInfo = nGetPagTemplateInfo(j2, qVar.ordinal(), z);
        if (nGetPagTemplateInfo != null) {
            int length = nGetPagTemplateInfo.length / 2;
            for (int i2 = 0; i2 < length; i2++) {
                arrayList.add(new Pair(Long.valueOf(nGetPagTemplateInfo[i2 * 2]), Long.valueOf(nGetPagTemplateInfo[(i2 * 2) + 1])));
            }
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(237134);
        return arrayList2;
    }

    public final void setConfigJson$renderlib_release(long j2, String str) {
        AppMethodBeat.i(237135);
        p.h(str, "json");
        nSetConfigJson(j2, str);
        AppMethodBeat.o(237135);
    }

    public final void setScene$renderlib_release(long j2, int i2) {
        AppMethodBeat.i(237136);
        nSetScene(j2, i2);
        AppMethodBeat.o(237136);
    }

    public final void setShowLandmarks$renderlib_release(long j2, boolean z) {
        AppMethodBeat.i(237137);
        nSetShowLandmarks(j2, z);
        AppMethodBeat.o(237137);
    }

    public final void setEffectParams$renderlib_release(long j2, Map<Integer, Float> map) {
        AppMethodBeat.i(237138);
        p.h(map, "effectParams");
        int size = map.size();
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        int i2 = 0;
        for (T t : map.entrySet()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            T t2 = t;
            iArr[i2] = ((Number) t2.getKey()).intValue();
            fArr[i2] = ((Number) t2.getValue()).floatValue();
            i2 = i3;
        }
        nSetEffectParams(j2, j.u((Collection<Integer>) map.keySet()), j.t(map.values()));
        AppMethodBeat.o(237138);
    }

    public final void destroyEffect(ad adVar) {
        AppMethodBeat.i(237123);
        p.h(adVar, "effect");
        nDestroy(adVar.ptr);
        AppMethodBeat.o(237123);
    }
}
