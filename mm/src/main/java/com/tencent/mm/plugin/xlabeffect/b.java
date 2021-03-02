package com.tencent.mm.plugin.xlabeffect;

import android.opengl.GLES20;
import android.os.SystemClock;
import android.text.TextUtils;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.k.d;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.e;
import com.tencent.mm.sticker.f;
import com.tencent.mm.xeffect.WeEffectRender;
import com.tencent.wxmm.v2helper;
import java.nio.Buffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0012\n\u0002\b\u001e\u0018\u0000 m2\u00020\u0001:\u0001mB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B%\b\u0016\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007B7\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u001a\u0010&\u001a\u00020\u00172\b\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001a\u00020*J\u0010\u0010+\u001a\u00020\u00172\b\u0010,\u001a\u0004\u0018\u00010-J\u0010\u0010.\u001a\u00020\u00172\b\u0010/\u001a\u0004\u0018\u000100J\b\u00101\u001a\u00020\u0017H\u0002J\u001c\u00102\u001a\u00020\u00172\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000104H\u0002J\u0018\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u0004H\u0002J\u0016\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(J\u000e\u00108\u001a\u00020\u000e2\u0006\u0010/\u001a\u000200J\u0006\u00109\u001a\u00020\u0017J\u001a\u0010:\u001a\u00020\u00172\b\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u0010;\u001a\u00020\u0004J\u000e\u0010:\u001a\u00020\u00042\u0006\u0010<\u001a\u00020=J\u001e\u0010:\u001a\u00020\u00042\u0006\u0010<\u001a\u00020=2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010:\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u00042\b\b\u0002\u0010;\u001a\u00020\u0004J\u0006\u0010>\u001a\u00020\tJ\u0006\u0010?\u001a\u00020\u0004J\u0006\u0010@\u001a\u00020\u0004J\u0010\u0010A\u001a\u00020\t2\u0006\u00107\u001a\u00020\u0004H\u0002J\u0006\u0010B\u001a\u00020\tJ\b\u0010C\u001a\u00020\tH\u0002J\u0016\u0010D\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\tJ\u001c\u0010F\u001a\u00020\u00172\u0014\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016J\u000e\u0010H\u001a\u00020\u00172\u0006\u0010I\u001a\u00020\u000eJD\u0010J\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u0001042\b\b\u0002\u0010K\u001a\u00020\u000e2\b\b\u0002\u0010L\u001a\u00020\u00042\b\b\u0002\u0010M\u001a\u00020\t2\b\b\u0002\u0010N\u001a\u00020\tH\u0007J:\u0010J\u001a\u00020\u00042\u0006\u0010O\u001a\u00020P2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020P2\u0006\u0010R\u001a\u00020\u00042\b\b\u0002\u0010L\u001a\u00020\u0004H\u0007J@\u0010J\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00042\b\b\u0002\u0010K\u001a\u00020\u000e2\b\b\u0002\u0010L\u001a\u00020\u00042\b\b\u0002\u0010M\u001a\u00020\t2\b\b\u0002\u0010N\u001a\u00020\tH\u0007J.\u0010S\u001a\u00020\u00172\u0006\u0010T\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\u00042\u0006\u0010V\u001a\u00020\u00042\u0006\u0010W\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\u0004J\u000e\u0010Y\u001a\u00020\u00172\u0006\u0010Z\u001a\u00020\u0004J\u0018\u0010[\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\t2\b\b\u0002\u0010)\u001a\u00020\u0004J\u000e\u0010\\\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\tJ\u0006\u0010]\u001a\u00020\u0017J\u0016\u0010^\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u00042\u0006\u0010_\u001a\u00020\u0004J\u000e\u0010`\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\tJ\u000e\u0010a\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\tJ\u000e\u0010b\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\tJ\u000e\u0010c\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\tJ\u0016\u0010d\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010e\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\tJ\u0018\u0010f\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\t2\b\b\u0002\u0010g\u001a\u00020\tJ\u000e\u0010h\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\tJ\u000e\u0010i\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\tJ\u0016\u0010j\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(J\u001e\u0010k\u001a\u00020\u00042\u0006\u0010<\u001a\u00020=2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010l\u001a\u00020\u0017H\u0002R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006n"}, hxF = {"Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "", "()V", "width", "", "height", "numThread", "(III)V", "enableImageLabel", "", "enableParallel", "(IIIZZ)V", "additionStickerIds", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "backgroundStickerId", "beautifyConfig", "", "effectConfig", "faceAutoSlimerId", "faceTrackCallback", "Lkotlin/Function1;", "", "faceTrackConfig", "faceTrackHeight", "faceTrackProc", "Lcom/tencent/mm/plugin/xlabeffect/FaceTrackProc;", "faceTrackStickerId", "faceTrackWidth", "fallbackFboObj", "Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "filterId", "foregroundStickerId", "hasFace", "nX3DHandle", "nextUpdateTick", "rosyId", "changeFilter", "path", "", "colorWeight", "", "changeSticker", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "changeSticker2D", "sticker", "Lcom/tencent/mm/sticker/StickerInfo;", "checkUpdateSticker", "copyTexture", "inputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "outputTexture", "createMakeUp", "type", "createSticker", "destroy", "faceTrack", "rotation", "dataBuffer", "Ljava/nio/Buffer;", "getHasFace", "getImageLabel", "getSegmentTexture", "hasEffect", "hasEffectFilter", "needFaceTrack", "optEffect", "enable", "postFaceTrack", "callback", "removeResource", "resId", "render", "pts", FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, "isOes", "isNeedCallFinish", "inputBuffer", "", "outputBuffer", "dataType", "setBeautyConfig", "skinSmooth", "eyeMorph", "faceMorph", "skinBright", "eyeBright", "setBeautyConfigRosy", "rosy", "setBeautyDefaultFilter", "setBeautyEnable", "setDefaultConfig", "setEffectLevel", "value", "setRosy", "setSegment", "setShapeMorph", "setShapeMorphLive", "setSize", "setSkinBright", "setSkinBrightLive", "forLive", "setSkinSmooth", "setSkinSmoothLive", "setSticker", "trackImageLabel", "updateSegment", "Companion", "plugin-xlabeffect_release"})
public final class b {
    private static final int JRm = 1;
    private static final int JRn = 2;
    private static final int JRo = 4;
    private static final int JRp = 8;
    private static final int JRq = 16;
    private static final int JRr = 32;
    private static final int JRs = 64;
    private static final int JRt = 128;
    private static final int JRu = 256;
    public static final a JRv = new a((byte) 0);
    static final String TAG = TAG;
    final long JQY;
    int JQZ;
    private final ArrayList<Long> JRa;
    private long JRb;
    private long JRc;
    private long JRd;
    private final int[] JRe;
    private a JRf;
    private com.tencent.mm.media.g.a JRg;
    public boolean JRh;
    private kotlin.g.a.b<? super Boolean, x> JRi;
    int JRj;
    private long JRk;
    private final int JRl;
    private final boolean VhY;
    private int height;
    private long oHa;
    private long oHb;
    private long oHc;
    int rwQ;
    int rwR;
    private int width;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "type", "", "value", "invoke"})
    static final class c extends q implements m<Integer, Integer, x> {
        final /* synthetic */ b JRw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(b bVar) {
            super(2);
            this.JRw = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Integer num, Integer num2) {
            AppMethodBeat.i(90508);
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            this.JRw.JRe[intValue] = intValue2;
            this.JRw.kx(intValue, intValue2);
            x xVar = x.SXb;
            AppMethodBeat.o(90508);
            return xVar;
        }
    }

    private b(int i2, int i3, int i4, boolean z, boolean z2) {
        int glr;
        long b2;
        AppMethodBeat.i(261702);
        this.width = i2;
        this.height = i3;
        this.JRl = i4;
        this.VhY = z2;
        this.JQZ = JRt;
        this.JRa = new ArrayList<>();
        this.JRk = -1;
        long currentTicks = Util.currentTicks();
        if (this.JRl > 0) {
            glr = this.JRl;
        } else {
            c cVar = c.JRA;
            glr = c.glr();
        }
        a.tryLoadLibrary();
        c cVar2 = c.JRA;
        c.glp();
        e eVar = e.JRF;
        e.glw();
        int aNe = d.ilx.aNe();
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wevis_android_gpu_portraitsegment_threshold, 100);
        boolean z3 = aNe > a2;
        String aNf = d.ilx.aNf();
        Log.i(TAG, "XLabEffect: init deviceRating = " + aNe + ", remoteRatingLimited = " + a2 + ", runWithGPU = " + z3 + ", deviceModel =  " + aNf);
        h.INSTANCE.a(21526, Boolean.valueOf(z3), Integer.valueOf(aNe), aNf);
        if (!a.isEnabled()) {
            b2 = 0;
        } else {
            e eVar2 = e.JRF;
            b2 = WeEffectRender.b(e.glu(), glr, z, z3);
        }
        this.JQY = b2;
        if (this.JQY != 0) {
            boolean a3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_wevision_render_compute_async, false);
            Log.i(TAG, "[WeVisionConfig] render compute async: " + a3 + ", enableParallel:" + this.VhY);
            if (this.VhY && a3) {
                WeEffectRender.nSetConfigFlags(this.JQY, "ConfigComputeRenderAsync", 1.0f);
            }
        }
        c cVar3 = c.JRA;
        c.glq();
        this.JRf = new a((byte) 0);
        this.JRf.ijJ = new kotlin.g.a.b<IntBuffer, x>(this) {
            /* class com.tencent.mm.plugin.xlabeffect.b.AnonymousClass1 */
            final /* synthetic */ b JRw;

            {
                this.JRw = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(IntBuffer intBuffer) {
                boolean z;
                AppMethodBeat.i(90505);
                IntBuffer intBuffer2 = intBuffer;
                p.h(intBuffer2, LocaleUtil.ITALIAN);
                b bVar = this.JRw;
                IntBuffer intBuffer3 = intBuffer2;
                int width = this.JRw.JRf.getWidth();
                int height = this.JRw.JRf.getHeight();
                p.h(intBuffer3, "dataBuffer");
                if (bVar.JQY != 0) {
                    if (bVar.glo()) {
                        if (!(bVar.rwQ == width && bVar.rwR == height)) {
                            bVar.rwQ = width;
                            bVar.rwR = height;
                        }
                        long currentTicks = Util.currentTicks();
                        int nFaceTrack = WeEffectRender.nFaceTrack(bVar.JQY, intBuffer3, width, height, (long) bVar.JQZ);
                        Log.d(b.TAG, "faceTrack: " + width + ", " + height + ' ' + bVar.JQZ + ", " + nFaceTrack + ", cost:" + Util.ticksToNow(currentTicks));
                        if (nFaceTrack == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        bVar.JRh = z;
                    } else {
                        bVar.JRh = true;
                        Log.d(b.TAG, "faceTrack: no need face track " + bVar.JRj);
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(90505);
                return xVar;
            }
        };
        if (this.JQY == 0) {
            com.tencent.mm.media.g.c cVar4 = com.tencent.mm.media.g.c.igu;
            this.JRg = com.tencent.mm.media.g.c.zI(13);
        }
        c cVar5 = c.JRA;
        c cVar6 = c.JRA;
        c cVar7 = c.JRA;
        c cVar8 = c.JRA;
        c cVar9 = c.JRA;
        c cVar10 = c.JRA;
        this.JRe = new int[]{c.aEl(), c.aEm(), c.aEn(), c.aEo(), c.aEp(), c.aEq()};
        Log.i(TAG, "XLabEffect: init " + this.JQY + ", numOfThread:" + glr + ", cost:" + Util.ticksToNow(currentTicks) + ", " + Util.getStack());
        AppMethodBeat.o(261702);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ b(int r8, int r9, int r10, boolean r11, boolean r12, int r13) {
        /*
            r7 = this;
            r6 = 261703(0x3fe47, float:3.66724E-40)
            r4 = 0
            r0 = r13 & 1
            if (r0 == 0) goto L_0x002f
            r1 = r4
        L_0x0009:
            r0 = r13 & 2
            if (r0 == 0) goto L_0x002d
            r2 = r4
        L_0x000e:
            r0 = r13 & 4
            if (r0 == 0) goto L_0x002b
            r3 = r4
        L_0x0013:
            r0 = r13 & 8
            if (r0 == 0) goto L_0x0029
        L_0x0017:
            r0 = r13 & 16
            if (r0 == 0) goto L_0x0027
            r5 = 1
        L_0x001c:
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return
        L_0x0027:
            r5 = r12
            goto L_0x001c
        L_0x0029:
            r4 = r11
            goto L_0x0017
        L_0x002b:
            r3 = r10
            goto L_0x0013
        L_0x002d:
            r2 = r9
            goto L_0x000e
        L_0x002f:
            r1 = r8
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.xlabeffect.b.<init>(int, int, int, boolean, boolean, int):void");
    }

    public b() {
        this(0, 0, 0, false, false, 16);
    }

    public b(int i2, int i3, int i4) {
        this(i2, i3, i4, false, false, 16);
    }

    public final void setSize(int i2, int i3) {
        AppMethodBeat.i(90509);
        if (!(this.width == i2 && this.height == i3)) {
            Log.i(TAG, "setSize: " + i2 + ", " + i3);
            this.width = i2;
            this.height = i3;
            this.JRf.cZ(i2, i3);
        }
        AppMethodBeat.o(90509);
    }

    public static /* synthetic */ void a(b bVar, int i2) {
        AppMethodBeat.i(90510);
        bVar.kw(i2, 0);
        AppMethodBeat.o(90510);
    }

    public final void kw(int i2, int i3) {
        AppMethodBeat.i(215217);
        if (glo()) {
            this.JRf.hDl = i2;
            this.JRf.qx(v2helper.VOIP_ENC_HEIGHT_LV1);
            this.JRf.ijM = true;
            this.JRf.aED();
        }
        kotlin.g.a.b<? super Boolean, x> bVar = this.JRi;
        if (bVar != null) {
            bVar.invoke(Boolean.valueOf(this.JRh));
        }
        this.JRi = null;
        AppMethodBeat.o(215217);
    }

    public static /* synthetic */ void a(b bVar, com.tencent.mm.media.g.d dVar) {
        AppMethodBeat.i(215219);
        bVar.c(dVar);
        AppMethodBeat.o(215219);
    }

    public final void c(com.tencent.mm.media.g.d dVar) {
        AppMethodBeat.i(215218);
        if (dVar != null) {
            kw(dVar.igv, 0);
        }
        AppMethodBeat.o(215218);
    }

    public final int a(Buffer buffer, int i2, int i3) {
        AppMethodBeat.i(215220);
        p.h(buffer, "dataBuffer");
        if (this.JQY == 0) {
            AppMethodBeat.o(215220);
            return -1;
        }
        long currentTicks = Util.currentTicks();
        int nTrackImageLabel = WeEffectRender.nTrackImageLabel(this.JQY, buffer, i2, i3);
        Log.d(TAG, "trackImageLabel: %s, %s %s, %s, cost:%s", Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(this.JQY), Integer.valueOf(nTrackImageLabel), Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(215220);
        return nTrackImageLabel;
    }

    public final int glg() {
        AppMethodBeat.i(215221);
        if (this.JQY == 0) {
            AppMethodBeat.o(215221);
            return -1;
        }
        int nGetImageLabel = WeEffectRender.nGetImageLabel(this.JQY);
        AppMethodBeat.o(215221);
        return nGetImageLabel;
    }

    public final void l(int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(184215);
        Log.i(TAG, "setBeautyConfig: skinSmooth " + i2 + ", eyeMorph " + i3 + ", faceMorph " + i4 + ", skinBright " + i5 + ", eyeBright " + i6);
        int[] iArr = this.JRe;
        if (i2 < 0) {
            c cVar = c.JRA;
            i2 = c.aEl();
        }
        iArr[0] = i2;
        int[] iArr2 = this.JRe;
        if (i3 < 0) {
            c cVar2 = c.JRA;
            i3 = c.aEm();
        }
        iArr2[1] = i3;
        int[] iArr3 = this.JRe;
        if (i4 < 0) {
            c cVar3 = c.JRA;
            i4 = c.aEn();
        }
        iArr3[2] = i4;
        int[] iArr4 = this.JRe;
        if (i5 < 0) {
            c cVar4 = c.JRA;
            i5 = c.aEo();
        }
        iArr4[3] = i5;
        int[] iArr5 = this.JRe;
        if (i6 < 0) {
            c cVar5 = c.JRA;
            i6 = c.aEp();
        }
        iArr5[4] = i6;
        AppMethodBeat.o(184215);
    }

    public final void ahu(int i2) {
        AppMethodBeat.i(215222);
        Log.i(TAG, "setBeautyConfigRosy: rosy ".concat(String.valueOf(i2)));
        int[] iArr = this.JRe;
        if (i2 < 0) {
            c cVar = c.JRA;
            i2 = c.aEq();
        }
        iArr[5] = i2;
        AppMethodBeat.o(215222);
    }

    public final void ti(boolean z) {
        AppMethodBeat.i(184216);
        if (z) {
            kx(0, this.JRe[0]);
            kx(1, this.JRe[1]);
            kx(2, this.JRe[2]);
            kx(3, this.JRe[3]);
            kx(4, this.JRe[4]);
            c cVar = c.JRA;
            c.b(new c(this));
            AppMethodBeat.o(184216);
            return;
        }
        kx(0, 0);
        kx(1, 0);
        kx(2, 0);
        kx(3, 0);
        kx(4, 0);
        AppMethodBeat.o(184216);
    }

    public final void glh() {
        AppMethodBeat.i(215223);
        kx(0, this.JRe[0]);
        AppMethodBeat.o(215223);
    }

    public final void gli() {
        AppMethodBeat.i(215224);
        kx(6, this.JRe[0]);
        AppMethodBeat.o(215224);
    }

    public final void glj() {
        AppMethodBeat.i(215225);
        kx(1, this.JRe[1]);
        kx(2, this.JRe[2]);
        kx(4, this.JRe[4]);
        AppMethodBeat.o(215225);
    }

    public final void glk() {
        AppMethodBeat.i(215226);
        kx(1, this.JRe[1]);
        kx(8, this.JRe[2]);
        kx(4, this.JRe[4]);
        AppMethodBeat.o(215226);
    }

    public final void gll() {
        AppMethodBeat.i(215227);
        kx(3, this.JRe[3]);
        AppMethodBeat.o(215227);
    }

    public final void glm() {
        AppMethodBeat.i(215229);
        kx(5, this.JRe[5]);
        AppMethodBeat.o(215229);
    }

    public static /* synthetic */ void a(b bVar, boolean z) {
        AppMethodBeat.i(215231);
        bVar.aa(z, 100);
        AppMethodBeat.o(215231);
    }

    public final void aa(boolean z, int i2) {
        AppMethodBeat.i(215230);
        if (z) {
            StringBuilder sb = new StringBuilder();
            e eVar = e.JRF;
            m(sb.append(e.glt()).append("/filters/Lut.png").toString(), ((float) i2) / 100.0f);
            AppMethodBeat.o(215230);
            return;
        }
        m(null, 1.0f);
        AppMethodBeat.o(215230);
    }

    public final void kx(int i2, int i3) {
        AppMethodBeat.i(90512);
        if (this.JQY == 0) {
            AppMethodBeat.o(90512);
            return;
        }
        if (i2 == 8) {
            if (this.JRb == 0) {
                StringBuilder sb = new StringBuilder();
                e eVar = e.JRF;
                this.JRb = WeEffectRender.nAddFaceAutoSlimer(this.JQY, sb.append(e.glt()).append("/Slimer/natureslim").toString());
            }
            Log.i(TAG, "setFaceAutoSlimerRate: ".concat(String.valueOf(i3)));
            WeEffectRender.nSetFaceAutoSlimerRate(this.JQY, this.JRb, ((float) i3) / 100.0f);
        } else if (i2 == 5) {
            if (this.JRc > 0) {
                WeEffectRender.nRemoveFilter(this.JQY, this.JRc);
            }
            StringBuilder sb2 = new StringBuilder();
            e eVar2 = e.JRF;
            String sb3 = sb2.append(e.glt()).append("/LutFilters/WechatRosy.png").toString();
            Log.i(TAG, "setRosy: ".concat(String.valueOf(i3)));
            this.JRc = WeEffectRender.nCreateFilter(this.JQY, sb3, ((float) i3) / 100.0f);
        } else {
            Log.i(TAG, "setEffectLevel: " + i2 + ", " + i3);
            WeEffectRender.nSetEffectLevel(this.JQY, i2, ((float) i3) / 100.0f);
        }
        bu(i2, i3 > 0);
        AppMethodBeat.o(90512);
    }

    public final void a(f fVar) {
        AppMethodBeat.i(90513);
        if (this.JQY == 0) {
            AppMethodBeat.o(90513);
            return;
        }
        WeEffectRender.nRemoveResource(this.JQY, this.oHa);
        WeEffectRender.nRemoveResource(this.JQY, this.oHb);
        WeEffectRender.nRemoveResource(this.JQY, this.oHc);
        Iterator<T> it = this.JRa.iterator();
        while (it.hasNext()) {
            WeEffectRender.nRemoveResource(this.JQY, it.next().longValue());
        }
        this.oHa = 0;
        this.oHb = 0;
        this.oHc = 0;
        this.JRa.clear();
        bu(11, false);
        bu(12, false);
        bu(13, false);
        if (fVar == null || !fVar.isValid()) {
            this.JQZ &= ((JRn | JRq) | JRr) ^ -1;
        } else {
            e eVar = fVar.NNs;
            if (eVar != null) {
                this.oHa = a(eVar);
                bu(11, true);
            }
            e eVar2 = fVar.NNt;
            if (eVar2 != null) {
                this.oHb = a(eVar2);
                bu(12, true);
            }
            e eVar3 = fVar.NNu;
            if (eVar3 != null) {
                this.oHc = a(eVar3);
                bu(13, true);
            }
            ArrayList<Long> arrayList = this.JRa;
            ArrayList<e> arrayList2 = fVar.NNv;
            ArrayList arrayList3 = new ArrayList(j.a(arrayList2, 10));
            Iterator<T> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                arrayList3.add(Long.valueOf(a((e) it2.next())));
            }
            arrayList.addAll(arrayList3);
        }
        gln();
        Log.i(TAG, "change sticker " + this.oHa + ", " + this.oHc + ", " + this.JRa);
        AppMethodBeat.o(90513);
    }

    private final void gln() {
        boolean z;
        int i2;
        int i3;
        AppMethodBeat.i(90514);
        if (this.JQY == 0) {
            AppMethodBeat.o(90514);
            return;
        }
        boolean z2 = ahv(10) || ahv(12);
        if (!ahv(10) || ahv(12)) {
            z = false;
        } else {
            z = true;
        }
        Log.i(TAG, "setSegment:" + z2 + ", " + z);
        if (z2) {
            i2 = this.JQZ | JRp;
        } else {
            i2 = this.JQZ & (JRp ^ -1);
        }
        this.JQZ = i2;
        long j2 = this.JQY;
        if (z) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        WeEffectRender.nSetSegment(j2, z2, 0, i3, -1);
        AppMethodBeat.o(90514);
    }

    public final void zG(boolean z) {
        AppMethodBeat.i(90515);
        bu(10, z);
        gln();
        AppMethodBeat.o(90515);
    }

    public static /* synthetic */ void b(b bVar) {
        AppMethodBeat.i(215232);
        bVar.m(null, 1.0f);
        AppMethodBeat.o(215232);
    }

    public final void m(String str, float f2) {
        AppMethodBeat.i(168850);
        if (this.JQY == 0) {
            AppMethodBeat.o(168850);
        } else if (TextUtils.isEmpty(str)) {
            WeEffectRender.nRemoveFilter(this.JQY, this.JRk);
            Log.i(TAG, "changeFilter: remove filter " + this.JRk);
            bu(9, false);
            AppMethodBeat.o(168850);
        } else {
            long j2 = this.JQY;
            if (str == null) {
                p.hyc();
            }
            this.JRk = WeEffectRender.nCreateFilter(j2, str, f2);
            Log.i(TAG, "changeFilter: create filter " + this.JRk);
            bu(9, true);
            AppMethodBeat.o(168850);
        }
    }

    public static /* synthetic */ int a(b bVar, int i2, int i3, boolean z, int i4) {
        AppMethodBeat.i(215234);
        if ((i4 & 32) != 0) {
            z = true;
        }
        int f2 = bVar.f(i2, i3, 0, z);
        AppMethodBeat.o(215234);
        return f2;
    }

    private int f(int i2, int i3, int i4, boolean z) {
        int i5;
        AppMethodBeat.i(215233);
        if (this.JQY == 0) {
            com.tencent.mm.media.g.a aVar = this.JRg;
            if (aVar != null) {
                i5 = aVar.igo;
            } else {
                i5 = -1;
            }
            GLES20.glBindFramebuffer(36160, i5);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
            GLES20.glBindTexture(3553, i3);
            GLES20.glCopyTexImage2D(3553, 0, NativeBitmapStruct.GLFormat.GL_RGBA, 0, 0, this.width, this.height, 0);
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glBindTexture(3553, 0);
            AppMethodBeat.o(215233);
            return -1;
        }
        long currentTicks = Util.currentTicks();
        if (this.JQY != 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.JRd < elapsedRealtime) {
                WeEffectRender.nUpdateSticker(this.JQY);
                this.JRd += 83;
                if (this.JRd < elapsedRealtime) {
                    this.JRd = elapsedRealtime;
                }
            }
        }
        int nRenderToTexture = WeEffectRender.nRenderToTexture(this.JQY, i2, i3, this.width, this.height, 0, false, false);
        if (z) {
            GLES20.glFinish();
        }
        Log.d(TAG, "render: " + this.JQY + ' ' + nRenderToTexture + ", cost:" + Util.ticksToNow(currentTicks));
        AppMethodBeat.o(215233);
        return nRenderToTexture;
    }

    public final int b(byte[] bArr, int i2, int i3, byte[] bArr2) {
        AppMethodBeat.i(215235);
        p.h(bArr, "inputBuffer");
        p.h(bArr2, "outputBuffer");
        if (this.JQY == 0) {
            AppMethodBeat.o(215235);
            return -1;
        }
        int nRenderToBuffer = WeEffectRender.nRenderToBuffer(this.JQY, bArr, i2, i3, bArr2, 5, 0, false);
        GLES20.glFinish();
        AppMethodBeat.o(215235);
        return nRenderToBuffer;
    }

    public static /* synthetic */ int a(b bVar, com.tencent.mm.media.g.d dVar, com.tencent.mm.media.g.d dVar2, boolean z, int i2) {
        AppMethodBeat.i(215236);
        if ((i2 & 32) != 0) {
            z = true;
        }
        if (dVar == null || dVar2 == null) {
            AppMethodBeat.o(215236);
            return -1;
        }
        int f2 = bVar.f(dVar.igv, dVar2.igv, 0, z);
        AppMethodBeat.o(215236);
        return f2;
    }

    public final long a(e eVar) {
        AppMethodBeat.i(90518);
        p.h(eVar, "sticker");
        if (this.JQY == 0) {
            AppMethodBeat.o(90518);
            return -1;
        }
        Log.i(TAG, "create sticker: " + eVar.cHM + ' ' + eVar.type);
        this.JQZ = this.JQZ | JRn | JRo;
        if (eVar.gyB()) {
            this.JQZ |= JRr;
        }
        if (eVar.gyA()) {
            this.JQZ |= JRq;
        }
        String str = eVar.type;
        switch (str.hashCode()) {
            case -2052467665:
                if (str.equals("Sticker2D")) {
                    long nCreateSticker = WeEffectRender.nCreateSticker(this.JQY, 0, eVar.cHM);
                    AppMethodBeat.o(90518);
                    return nCreateSticker;
                }
                break;
            case -1890090921:
                if (str.equals("StickerFixed")) {
                    long nCreateSticker2 = WeEffectRender.nCreateSticker(this.JQY, 2, eVar.cHM);
                    AppMethodBeat.o(90518);
                    return nCreateSticker2;
                }
                break;
            case -964830573:
                if (str.equals("FaceDeformation")) {
                    long nCreateSticker3 = WeEffectRender.nCreateSticker(this.JQY, 3, eVar.cHM);
                    AppMethodBeat.o(90518);
                    return nCreateSticker3;
                }
                break;
            case -656591085:
                if (str.equals("Segment")) {
                    long nCreateSticker4 = WeEffectRender.nCreateSticker(this.JQY, 1, eVar.cHM);
                    AppMethodBeat.o(90518);
                    return nCreateSticker4;
                }
                break;
        }
        long nCreateSticker5 = WeEffectRender.nCreateSticker(this.JQY, 0, eVar.cHM);
        AppMethodBeat.o(90518);
        return nCreateSticker5;
    }

    public final long db(int i2, String str) {
        AppMethodBeat.i(215237);
        p.h(str, "path");
        if (this.JQY == 0) {
            AppMethodBeat.o(215237);
            return -1;
        }
        switch (i2) {
            case 0:
                long nCreateMakeUp = WeEffectRender.nCreateMakeUp(this.JQY, 0, str);
                AppMethodBeat.o(215237);
                return nCreateMakeUp;
            case 1:
                long nCreateMakeUp2 = WeEffectRender.nCreateMakeUp(this.JQY, 1, str);
                AppMethodBeat.o(215237);
                return nCreateMakeUp2;
            case 2:
                long nCreateMakeUp3 = WeEffectRender.nCreateMakeUp(this.JQY, 2, str);
                AppMethodBeat.o(215237);
                return nCreateMakeUp3;
            case 3:
                long nCreateMakeUp4 = WeEffectRender.nCreateMakeUp(this.JQY, 3, str);
                AppMethodBeat.o(215237);
                return nCreateMakeUp4;
            default:
                long nCreateMakeUp5 = WeEffectRender.nCreateMakeUp(this.JQY, 4, str);
                AppMethodBeat.o(215237);
                return nCreateMakeUp5;
        }
    }

    public final void Ml(long j2) {
        AppMethodBeat.i(215238);
        if (this.JQY == 0) {
            AppMethodBeat.o(215238);
            return;
        }
        WeEffectRender.nRemoveResource(this.JQY, j2);
        AppMethodBeat.o(215238);
    }

    public final void destroy() {
        AppMethodBeat.i(90519);
        Log.i(TAG, "destroy: " + this.JQY + ' ' + Util.getStack());
        c cVar = c.JRA;
        c.b(null);
        this.JRf.release();
        if (this.JQY != 0) {
            WeEffectRender.nRemoveResource(this.JQY, this.oHa);
            WeEffectRender.nRemoveResource(this.JQY, this.oHb);
            WeEffectRender.nRemoveResource(this.JQY, this.oHc);
            Iterator<T> it = this.JRa.iterator();
            while (it.hasNext()) {
                WeEffectRender.nRemoveResource(this.JQY, it.next().longValue());
            }
            WeEffectRender.nDestroy(this.JQY);
            AppMethodBeat.o(90519);
            return;
        }
        com.tencent.mm.media.g.a aVar = this.JRg;
        if (aVar != null) {
            aVar.close();
            AppMethodBeat.o(90519);
            return;
        }
        AppMethodBeat.o(90519);
    }

    public final void bu(int i2, boolean z) {
        if (z) {
            this.JRj |= 1 << i2;
        } else {
            this.JRj &= (1 << i2) ^ -1;
        }
    }

    private final boolean ahv(int i2) {
        return (this.JRj & (1 << i2)) != 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean glo() {
        return ((((((this.JRj & -2) & -9) & -513) & -65) & -129) & -33) > 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b$\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020HR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.XD¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0014\u00102\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b3\u00101R\u0014\u00104\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b5\u00101R\u0014\u00106\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b7\u00101R\u0014\u00108\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b9\u00101R\u0014\u0010:\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b;\u00101R\u0014\u0010<\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b=\u00101R\u0014\u0010>\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b?\u00101R\u0014\u0010@\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\bA\u00101R\u0014\u0010B\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\bC\u00101R\u000e\u0010D\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006I"}, hxF = {"Lcom/tencent/mm/plugin/xlabeffect/XLabEffect$Companion;", "", "()V", "CW_ROTATE_0", "", "CW_ROTATE_180", "CW_ROTATE_270", "CW_ROTATE_90", "DEFAULT_STICKER_INTERVAL", "", "EFFECT_TYPE_EYE_BRIGHT", "EFFECT_TYPE_EYE_MORPH", "EFFECT_TYPE_FACE_MORPH", "EFFECT_TYPE_FACE_MORPH_LIVE", "EFFECT_TYPE_FILTER", "EFFECT_TYPE_MAKEUP_BLUSHER", "EFFECT_TYPE_MAKEUP_CONTOURS", "EFFECT_TYPE_MAKEUP_EYEBROW", "EFFECT_TYPE_MAKEUP_EYESHADOW", "EFFECT_TYPE_MAKEUP_LIP", "EFFECT_TYPE_REMOVE_BG", "EFFECT_TYPE_ROSY", "EFFECT_TYPE_SKIN_BRIGHT", "EFFECT_TYPE_SKIN_BRIGHT_LIVE", "EFFECT_TYPE_SKIN_SMOOTH", "EFFECT_TYPE_SKIN_SMOOTH_LIVE", "EFFECT_TYPE_STICKER_BACK", "EFFECT_TYPE_STICKER_FACE", "EFFECT_TYPE_STICKER_FRONT", "MAKEUP_TYPE_BLUSHER", "MAKEUP_TYPE_CONTOURS", "MAKEUP_TYPE_EYEBROW", "MAKEUP_TYPE_EYESHADOW", "MAKEUP_TYPE_LIP", "MM_KVSTAT_RunWithGPU", "RENDER_FORMAT_BGR", "RENDER_FORMAT_BGRA", "RENDER_FORMAT_NV12", "RENDER_FORMAT_NV21", "RENDER_FORMAT_RGB", "RENDER_FORMAT_RGBA", "STICKER_TYPE_DEFORMATION", "STICKER_TYPE_FIXED", "STICKER_TYPE_NORMAL", "STICKER_TYPE_SEGMENT", "TAG", "", "TRACKER_CAT", "getTRACKER_CAT", "()I", "TRACKER_FACE", "getTRACKER_FACE", "TRACKER_FACE_ACTION", "getTRACKER_FACE_ACTION", "TRACKER_GESTURE", "getTRACKER_GESTURE", "TRACKER_MIRROR", "getTRACKER_MIRROR", "TRACKER_NORMAL", "getTRACKER_NORMAL", "TRACKER_SCENE_CLS", "getTRACKER_SCENE_CLS", "TRACKER_SEGMENT", "getTRACKER_SEGMENT", "TRACKER_STICKER_2D", "getTRACKER_STICKER_2D", "TRACKER_STICKER_3D", "getTRACKER_STICKER_3D", "VIDEO_LABEL_NUM", "isEnabled", "", "tryLoadLibrary", "", "plugin-xlabeffect_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static boolean isEnabled() {
            AppMethodBeat.i(90506);
            com.tencent.mm.plugin.expansions.d dVar = com.tencent.mm.plugin.expansions.d.rNG;
            boolean aoc = com.tencent.mm.plugin.expansions.d.aoc("xlab");
            AppMethodBeat.o(90506);
            return aoc;
        }

        public static void tryLoadLibrary() {
            AppMethodBeat.i(90507);
            if (isEnabled()) {
                com.tencent.mm.plugin.expansions.d dVar = com.tencent.mm.plugin.expansions.d.rNG;
                com.tencent.mm.plugin.expansions.d.aoa("xlabeffect");
                d.gls();
            }
            AppMethodBeat.o(90507);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.xlabeffect.b$b  reason: collision with other inner class name */
    static final class C2014b extends q implements kotlin.g.a.b<String, x> {
        public static final C2014b JRx = new C2014b();

        static {
            AppMethodBeat.i(215216);
            AppMethodBeat.o(215216);
        }

        C2014b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(215215);
            String str2 = str;
            p.h(str2, LocaleUtil.ITALIAN);
            a aVar = b.JRv;
            if (a.isEnabled()) {
                com.tencent.mm.plugin.expansions.d dVar = com.tencent.mm.plugin.expansions.d.rNG;
                com.tencent.mm.plugin.expansions.d.aoa(str2);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(215215);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(90523);
        com.tencent.mm.xeffect.d dVar = com.tencent.mm.xeffect.d.RxN;
        com.tencent.mm.xeffect.d.R(C2014b.JRx);
        a.tryLoadLibrary();
        AppMethodBeat.o(90523);
    }

    public static /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(215228);
        bVar.kx(7, bVar.JRe[3]);
        AppMethodBeat.o(215228);
    }
}
