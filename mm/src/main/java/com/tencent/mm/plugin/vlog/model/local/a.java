package com.tencent.mm.plugin.vlog.model.local;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Size;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.media.k.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.videocomposition.c;
import com.tencent.mm.xeffect.GlobalContextCreator;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.s;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0016\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003stuB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0018J\u001c\u0010G\u001a\u00020C2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020E0\u000f2\u0006\u0010I\u001a\u00020\u0010J\u000e\u0010J\u001a\u00020C2\u0006\u0010K\u001a\u00020\u0018J\b\u0010L\u001a\u00020CH\u0002J\"\u0010M\u001a\b\u0012\u0004\u0012\u00020E0\u000f2\u0006\u0010N\u001a\u00020\u001e2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020E0\u000fJ\u0010\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u0010R\u001a\u00020\u0004J\u0010\u0010S\u001a\u00020\u00102\b\u0010R\u001a\u0004\u0018\u00010\u0004J\u0010\u0010T\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\u0004H\u0002J\u0006\u0010V\u001a\u00020CJ\b\u0010W\u001a\u00020CH\u0002J\b\u0010X\u001a\u00020CH\u0002J\b\u0010Y\u001a\u00020CH\u0002J\b\u0010Z\u001a\u00020CH\u0002J\u0006\u0010[\u001a\u00020+J\u0006\u0010\\\u001a\u00020+J\u0010\u0010]\u001a\u00020C2\b\u0010^\u001a\u0004\u0018\u00010\u001eJ\u0006\u0010_\u001a\u00020CJ\u0014\u0010`\u001a\u00020C2\f\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fJ\u0016\u0010b\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010I\u001a\u00020\u0010J\u0018\u0010c\u001a\u00020C2\b\u0010d\u001a\u0004\u0018\u00010e2\u0006\u0010f\u001a\u00020+J\u000e\u0010g\u001a\u00020C2\u0006\u0010h\u001a\u00020\u0010J\u000e\u0010i\u001a\u00020+2\u0006\u0010j\u001a\u00020\u0004J\u0010\u0010k\u001a\u00020C2\u0006\u0010l\u001a\u00020+H\u0002J\u0016\u0010m\u001a\u00020C2\u0006\u0010^\u001a\u00020\u001e2\u0006\u0010n\u001a\u00020oJ\u0006\u0010p\u001a\u00020CJ\u0006\u0010q\u001a\u00020CJ\u0006\u0010r\u001a\u00020CR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R6\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cXT¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0001\u0010\"\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001c0!0\bj\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001c0!`\t2:\u0010 \u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001c0!0\bj\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001c0!`\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000b\"\u0004\b$\u0010\rR\u001c\u0010%\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100.X\u0004¢\u0006\u0002\n\u0000R\"\u0010/\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u000107X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010<\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A¨\u0006v"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager;", "", "()V", "ImageEnhancementResultImageSavePath", "", "getImageEnhancementResultImageSavePath", "()Ljava/lang/String;", "ImageEnhancementResultPathMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getImageEnhancementResultPathMap", "()Ljava/util/HashMap;", "setImageEnhancementResultPathMap", "(Ljava/util/HashMap;)V", "ImageEnhancementSceneValues", "", "", "getImageEnhancementSceneValues", "()Ljava/util/List;", "TAG", "TEMPLATE_CONFIG", "TEMPLATE_PATH", "TransEffectList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "getTransEffectList", "()Ljava/util/LinkedList;", "TransEffectTime", "", "VideoTemplateList", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "getVideoTemplateList", "value", "Landroid/util/Pair;", "VideoTrackLabel", "getVideoTrackLabel", "setVideoTrackLabel", "currentVideoTemplate", "getCurrentVideoTemplate", "()Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "setCurrentVideoTemplate", "(Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;)V", "globalContextCreated", "", "transitionReady", "transitionResMap", "", "transitionView", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView;", "getTransitionView", "()Ljava/lang/ref/WeakReference;", "setTransitionView", "(Ljava/lang/ref/WeakReference;)V", "vLogEffectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "getVLogEffectMgr", "()Lcom/tencent/mm/xeffect/effect/EffectManager;", "setVLogEffectMgr", "(Lcom/tencent/mm/xeffect/effect/EffectManager;)V", "videoEnhancementEffectInfo", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoEnhancementEffectInfo;", "getVideoEnhancementEffectInfo", "()Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoEnhancementEffectInfo;", "setVideoEnhancementEffectInfo", "(Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoEnhancementEffectInfo;)V", "applyTransition", "", FFmpegMetadataRetriever.METADATA_KEY_TRACK, "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "trans", "applyTransitionToAll", "trackList", "order", "checkCreateTransEffect", "transEffectInfo", "checkRefreshView", "generateTemplateEffectTrack", MessengerShareContentUtility.ATTACHMENT_TEMPLATE_TYPE, "sourceTrackList", "getImageEnhancementBitmap", "Landroid/graphics/Bitmap;", "path", "getLabel", "getLocalPath", "assetsPath", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "initTransEffect", "initTransResource", "initVideoEnhancementEffect", "initVideoTemplates", "isSvrVideoEnhancementEnable", "isVideoEnhancementEnable", "removeVideoTemplate", "videoTemplate", "reset", "saveAllImageEnhancementResultImage", "pathList", "setTransition", "setVideoEnhancement", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "enable", "setVideoEnhancementScene", "scene", "setVideoEnhancementSceneFilterSettingsByJson", "json", "setVideoEnhancementShowFaceLandmarks", "show", "setVideoTemplate", "targets", "", "tryCreateX3DGlobalContext", "tryCreateX3DGlobalContextImpl", "unInit", "TransEffectInfo", "VideoEnhancementEffectInfo", "VideoTemplateInfo", "plugin-vlog_release"})
public final class a {
    private static boolean GAA;
    private static HashMap<String, Pair<Integer, Long>> GAB = new HashMap<>();
    private static final List<Integer> GAC;
    public static final a GAD = new a();
    private static final String GAs = (com.tencent.mm.loader.j.b.aKB() + "image_enhancement_result");
    private static final LinkedList<c> GAt = new LinkedList<>();
    private static b GAu;
    private static c GAv;
    private static EffectManager GAw;
    private static WeakReference<com.tencent.mm.plugin.vlog.ui.plugin.transition.b> GAx;
    private static HashMap<String, String> GAy = new HashMap<>();
    private static boolean GAz;
    private static final LinkedList<C1849a> wKy = new LinkedList<>();
    private static final Map<String, Integer> wKz = ae.e(s.U("diehua.svg", Integer.valueOf((int) R.raw.diehua)), s.U("shanhei.svg", Integer.valueOf((int) R.raw.shanhei)), s.U("shanbai.svg", Integer.valueOf((int) R.raw.shanbai)), s.U("zuoyi.svg", Integer.valueOf((int) R.raw.zuoyi)), s.U("youyi.svg", Integer.valueOf((int) R.raw.youyi)), s.U("shangyi.svg", Integer.valueOf((int) R.raw.shangyi)), s.U("xiayi.svg", Integer.valueOf((int) R.raw.xiayi)), s.U("fangda.svg", Integer.valueOf((int) R.raw.fangda)), s.U("suoxiao.svg", Integer.valueOf((int) R.raw.suoxiao)), s.U("youzhuan.svg", Integer.valueOf((int) R.raw.youzhuan)), s.U("zuozhuan.svg", Integer.valueOf((int) R.raw.zuozhuan)));

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
    public static final class f extends q implements m<Long, Bitmap, x> {
        final /* synthetic */ ad GAL;
        final /* synthetic */ Object tpZ;
        final /* synthetic */ z.f wJX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(ad adVar, z.f fVar, Object obj) {
            super(2);
            this.GAL = adVar;
            this.wJX = fVar;
            this.tpZ = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Long l, Bitmap bitmap) {
            Integer num;
            Integer num2 = null;
            AppMethodBeat.i(190751);
            T t = (T) bitmap;
            StringBuilder append = new StringBuilder("requestFrames finish, timeMs:").append(l.longValue()).append(", bitmap:").append((Object) t).append(", size:[");
            if (t != null) {
                num = Integer.valueOf(t.getWidth());
            } else {
                num = null;
            }
            StringBuilder append2 = append.append(num).append(", ");
            if (t != null) {
                num2 = Integer.valueOf(t.getHeight());
            }
            Log.i("MicroMsg.LocalEffectManager", append2.append(num2).append("], source size:[").append(this.GAL.GzA.Gzu).append(", ").append(this.GAL.GzA.Gzv).append(']').toString());
            this.wJX.SYG = t;
            synchronized (this.tpZ) {
                try {
                    this.tpZ.notifyAll();
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.LocalEffectManager", e2, "", new Object[0]);
                }
                try {
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(190751);
                    throw th;
                }
            }
            x xVar2 = x.SXb;
            AppMethodBeat.o(190751);
            return xVar2;
        }
    }

    static {
        AppMethodBeat.i(190779);
        n.a[] values = n.a.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (n.a aVar : values) {
            arrayList.add(Integer.valueOf(aVar.ordinal()));
        }
        GAC = arrayList;
        AppMethodBeat.o(190779);
    }

    private a() {
    }

    public static final /* synthetic */ void fBZ() {
        AppMethodBeat.i(190780);
        fBT();
        AppMethodBeat.o(190780);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003JG\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0005HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001e¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "", "name", "", "order", "", "assetPath", "svgPath", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "effect", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "(Ljava/lang/String;ILjava/lang/String;IJLcom/tencent/mm/xeffect/effect/VLogEffect;)V", "getAssetPath", "()Ljava/lang/String;", "setAssetPath", "(Ljava/lang/String;)V", "getDuration", "()J", "setDuration", "(J)V", "getEffect", "()Lcom/tencent/mm/xeffect/effect/VLogEffect;", "setEffect", "(Lcom/tencent/mm/xeffect/effect/VLogEffect;)V", "getName", "setName", "getOrder", "()I", "setOrder", "(I)V", "getSvgPath", "setSvgPath", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-vlog_release"})
    /* renamed from: com.tencent.mm.plugin.vlog.model.local.a$a  reason: collision with other inner class name */
    public static final class C1849a {
        public int GAE;
        com.tencent.mm.xeffect.effect.ad GAn;
        public String assetPath;
        public long duration;
        public String name;
        public int order;

        public C1849a() {
            this(null, 0, null, 0, 0, 63);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x003e, code lost:
            if (kotlin.g.b.p.j(r5.GAn, r6.GAn) != false) goto L_0x0040;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r6) {
            /*
                r5 = this;
                r4 = 190738(0x2e912, float:2.67281E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                if (r5 == r6) goto L_0x0040
                boolean r0 = r6 instanceof com.tencent.mm.plugin.vlog.model.local.a.C1849a
                if (r0 == 0) goto L_0x0045
                com.tencent.mm.plugin.vlog.model.local.a$a r6 = (com.tencent.mm.plugin.vlog.model.local.a.C1849a) r6
                java.lang.String r0 = r5.name
                java.lang.String r1 = r6.name
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0045
                int r0 = r5.order
                int r1 = r6.order
                if (r0 != r1) goto L_0x0045
                java.lang.String r0 = r5.assetPath
                java.lang.String r1 = r6.assetPath
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0045
                int r0 = r5.GAE
                int r1 = r6.GAE
                if (r0 != r1) goto L_0x0045
                long r0 = r5.duration
                long r2 = r6.duration
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L_0x0045
                com.tencent.mm.xeffect.effect.ad r0 = r5.GAn
                com.tencent.mm.xeffect.effect.ad r1 = r6.GAn
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0045
            L_0x0040:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            L_0x0044:
                return r0
            L_0x0045:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                goto L_0x0044
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.model.local.a.C1849a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(190737);
            String str = this.name;
            int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.order) * 31;
            String str2 = this.assetPath;
            int hashCode2 = str2 != null ? str2.hashCode() : 0;
            long j2 = this.duration;
            int i3 = (((((hashCode2 + hashCode) * 31) + this.GAE) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            com.tencent.mm.xeffect.effect.ad adVar = this.GAn;
            if (adVar != null) {
                i2 = adVar.hashCode();
            }
            int i4 = i3 + i2;
            AppMethodBeat.o(190737);
            return i4;
        }

        public final String toString() {
            AppMethodBeat.i(190736);
            String str = "TransEffectInfo(name=" + this.name + ", order=" + this.order + ", assetPath=" + this.assetPath + ", svgPath=" + this.GAE + ", duration=" + this.duration + ", effect=" + this.GAn + ")";
            AppMethodBeat.o(190736);
            return str;
        }

        private C1849a(String str, int i2, String str2, int i3, long j2) {
            p.h(str, "name");
            p.h(str2, "assetPath");
            AppMethodBeat.i(190734);
            this.name = str;
            this.order = i2;
            this.assetPath = str2;
            this.GAE = i3;
            this.duration = j2;
            this.GAn = null;
            AppMethodBeat.o(190734);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C1849a(String str, int i2, String str2, int i3, long j2, int i4) {
            this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? "" : str2, (i4 & 8) != 0 ? -1 : i3, (i4 & 16) != 0 ? 500 : j2);
            AppMethodBeat.i(190735);
            AppMethodBeat.o(190735);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoEnhancementEffectInfo;", "", "effect", "Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;", "currentScene", "", "(Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;I)V", "getCurrentScene", "()I", "setCurrentScene", "(I)V", "getEffect", "()Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;", "setEffect", "(Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;)V", "effectId", "", "getEffectId", "()J", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-vlog_release"})
    public static final class b {
        int GAF;
        n GzV;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
            if (r3.GAF == r4.GAF) goto L_0x001e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 190742(0x2e916, float:2.67286E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x001e
                boolean r0 = r4 instanceof com.tencent.mm.plugin.vlog.model.local.a.b
                if (r0 == 0) goto L_0x0023
                com.tencent.mm.plugin.vlog.model.local.a$b r4 = (com.tencent.mm.plugin.vlog.model.local.a.b) r4
                com.tencent.mm.xeffect.effect.n r0 = r3.GzV
                com.tencent.mm.xeffect.effect.n r1 = r4.GzV
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0023
                int r0 = r3.GAF
                int r1 = r4.GAF
                if (r0 != r1) goto L_0x0023
            L_0x001e:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0022:
                return r0
            L_0x0023:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0022
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.model.local.a.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(190741);
            n nVar = this.GzV;
            int hashCode = ((nVar != null ? nVar.hashCode() : 0) * 31) + this.GAF;
            AppMethodBeat.o(190741);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(190740);
            String str = "VideoEnhancementEffectInfo(effect=" + this.GzV + ", currentScene=" + this.GAF + ")";
            AppMethodBeat.o(190740);
            return str;
        }

        public /* synthetic */ b() {
            this(n.a.Origin.ordinal());
            AppMethodBeat.i(190739);
            AppMethodBeat.o(190739);
        }

        private b(int i2) {
            this.GzV = null;
            this.GAF = i2;
        }

        public final long fCb() {
            n nVar = this.GzV;
            if (nVar != null) {
                return nVar.id;
            }
            return 0;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b.\b\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\u001a\b\u0002\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00130\u0012¢\u0006\u0002\u0010\u0014J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\u001b\u00103\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00130\u0012HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0006HÆ\u0003J\t\u00106\u001a\u00020\bHÆ\u0003J\t\u00107\u001a\u00020\nHÆ\u0003J\t\u00108\u001a\u00020\bHÆ\u0003J\t\u00109\u001a\u00020\rHÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\b2\u001a\b\u0002\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00130\u0012HÆ\u0001J\u0013\u0010=\u001a\u00020\r2\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020\nHÖ\u0001J\t\u0010@\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\"R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR,\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00130\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0016\"\u0004\b.\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b/\u00100¨\u0006A"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "", "path", "", "musicPath", "size", "Landroid/util/Size;", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "imageNums", "", "effectId", "trackCropToTemplateSize", "", "name", "icon", "templateEffectRangeId", "replacementInfo", "", "Landroid/util/Pair;", "(Ljava/lang/String;Ljava/lang/String;Landroid/util/Size;JIJZLjava/lang/String;Ljava/lang/String;JLjava/util/List;)V", "getDuration", "()J", "setDuration", "(J)V", "getEffectId", "getIcon", "()Ljava/lang/String;", "getImageNums", "()I", "setImageNums", "(I)V", "getMusicPath", "setMusicPath", "(Ljava/lang/String;)V", "getName", "getPath", "getReplacementInfo", "()Ljava/util/List;", "setReplacementInfo", "(Ljava/util/List;)V", "getSize", "()Landroid/util/Size;", "setSize", "(Landroid/util/Size;)V", "getTemplateEffectRangeId", "setTemplateEffectRangeId", "getTrackCropToTemplateSize", "()Z", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-vlog_release"})
    public static final class c {
        public Size ApT;
        private int GAG;
        public final boolean GAH;
        public long GAI;
        List<Pair<Long, Long>> GAJ;
        public long duration;
        public final String icon;
        public String iiv;
        public final String name;
        public final String path;
        private final long wKD;

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x006c, code lost:
            if (kotlin.g.b.p.j(r5.GAJ, r6.GAJ) != false) goto L_0x006e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r6) {
            /*
            // Method dump skipped, instructions count: 120
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.model.local.a.c.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(190746);
            String str = this.path;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.iiv;
            int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
            Size size = this.ApT;
            int hashCode3 = size != null ? size.hashCode() : 0;
            long j2 = this.duration;
            long j3 = this.wKD;
            int i3 = (((((((hashCode3 + hashCode2) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.GAG) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            boolean z = this.GAH;
            if (z) {
                z = true;
            }
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = z ? 1 : 0;
            int i7 = (i4 + i3) * 31;
            String str3 = this.name;
            int hashCode4 = ((str3 != null ? str3.hashCode() : 0) + i7) * 31;
            String str4 = this.icon;
            int hashCode5 = str4 != null ? str4.hashCode() : 0;
            long j4 = this.GAI;
            int i8 = (((hashCode5 + hashCode4) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            List<Pair<Long, Long>> list = this.GAJ;
            if (list != null) {
                i2 = list.hashCode();
            }
            int i9 = i8 + i2;
            AppMethodBeat.o(190746);
            return i9;
        }

        public final String toString() {
            AppMethodBeat.i(190745);
            String str = "VideoTemplateInfo(path=" + this.path + ", musicPath=" + this.iiv + ", size=" + this.ApT + ", duration=" + this.duration + ", imageNums=" + this.GAG + ", effectId=" + this.wKD + ", trackCropToTemplateSize=" + this.GAH + ", name=" + this.name + ", icon=" + this.icon + ", templateEffectRangeId=" + this.GAI + ", replacementInfo=" + this.GAJ + ")";
            AppMethodBeat.o(190745);
            return str;
        }

        private c(String str, String str2, Size size, long j2, int i2, boolean z, String str3, String str4, long j3, List<Pair<Long, Long>> list) {
            p.h(str, "path");
            p.h(str2, "musicPath");
            p.h(size, "size");
            p.h(str3, "name");
            p.h(str4, "icon");
            p.h(list, "replacementInfo");
            AppMethodBeat.i(190743);
            this.path = str;
            this.iiv = str2;
            this.ApT = size;
            this.duration = j2;
            this.GAG = i2;
            this.wKD = 0;
            this.GAH = z;
            this.name = str3;
            this.icon = str4;
            this.GAI = -1;
            this.GAJ = list;
            AppMethodBeat.o(190743);
        }

        public /* synthetic */ c(String str, String str2, Size size, long j2, int i2, boolean z) {
            this(str, str2, size, j2, i2, z, "", "", -1, new ArrayList());
            AppMethodBeat.i(190744);
            AppMethodBeat.o(190744);
        }
    }

    public static LinkedList<C1849a> fBM() {
        return wKy;
    }

    public static LinkedList<c> fBN() {
        return GAt;
    }

    public static b fBO() {
        return GAu;
    }

    public static EffectManager fBP() {
        return GAw;
    }

    public static WeakReference<com.tencent.mm.plugin.vlog.ui.plugin.transition.b> fBQ() {
        return GAx;
    }

    public static void i(WeakReference<com.tencent.mm.plugin.vlog.ui.plugin.transition.b> weakReference) {
        GAx = weakReference;
    }

    public static HashMap<String, String> fBR() {
        return GAy;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    public static final class e<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(190750);
            int a2 = kotlin.b.a.a((Long) ((Pair) t).first, (Long) ((Pair) t2).first);
            AppMethodBeat.o(190750);
            return a2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    public static final class g<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(190752);
            int a2 = kotlin.b.a.a(Integer.valueOf(t.order), Integer.valueOf(t2.order));
            AppMethodBeat.o(190752);
            return a2;
        }
    }

    public static HashMap<String, Pair<Integer, Long>> fBS() {
        return GAB;
    }

    public static void p(HashMap<String, Pair<Integer, Long>> hashMap) {
        AppMethodBeat.i(190758);
        p.h(hashMap, "value");
        if (!hashMap.isEmpty()) {
            GAB.clear();
            GAB.putAll(hashMap);
        }
        AppMethodBeat.o(190758);
    }

    public static int aUc(String str) {
        Integer num;
        AppMethodBeat.i(190759);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(190759);
            return -1;
        }
        Pair<Integer, Long> pair = GAB.get(str);
        if (pair == null || (num = (Integer) pair.first) == null) {
            AppMethodBeat.o(190759);
            return -1;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(190759);
        return intValue;
    }

    public final synchronized void init() {
        Long l;
        AppMethodBeat.i(190760);
        Log.i("MicroMsg.LocalEffectManager", APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
        if (GAw == null) {
            GAw = new EffectManager();
        }
        fBT();
        w.fBs();
        GAu = new b();
        StringBuilder sb = new StringBuilder("initVideoEnhancementEffect effectId:");
        b bVar = GAu;
        if (bVar != null) {
            l = Long.valueOf(bVar.fCb());
        } else {
            l = null;
        }
        Log.i("MicroMsg.LocalEffectManager", sb.append(l).toString());
        AppMethodBeat.o(190760);
    }

    private static void fBT() {
        AppMethodBeat.i(190761);
        Log.i("MicroMsg.LocalEffectManager", "initTransResource: transition res " + com.tencent.mm.plugin.recordvideo.res.f.BYo.BXZ + '}');
        if (com.tencent.mm.plugin.recordvideo.res.f.BYo.BXZ) {
            dMd();
            AppMethodBeat.o(190761);
            return;
        }
        com.tencent.mm.plugin.recordvideo.res.f.BYo.BYa = h.GAM;
        AppMethodBeat.o(190761);
    }

    private static void dMd() {
        AppMethodBeat.i(190762);
        GAz = true;
        String eLk = com.tencent.mm.plugin.recordvideo.res.f.BYo.eLk();
        try {
            JSONArray eLn = com.tencent.mm.plugin.recordvideo.res.f.BYo.eLn();
            if (eLn == null) {
                p.hyc();
            }
            int length = eLn.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = eLn.optJSONObject(i2);
                String optString = optJSONObject.optString("name");
                String string = optJSONObject.getString("pag");
                Integer num = wKz.get(optJSONObject.getString("svg"));
                int i3 = optJSONObject.getInt("order");
                String str = eLk + string;
                int intValue = num != null ? num.intValue() : -1;
                LinkedList<C1849a> linkedList = wKy;
                p.g(optString, "transEffectName");
                linkedList.add(new C1849a(optString, i3, str, intValue, 500, 32));
            }
            LinkedList<C1849a> linkedList2 = wKy;
            if (linkedList2.size() > 1) {
                kotlin.a.j.a((List) linkedList2, (Comparator) new g());
            }
            AppMethodBeat.o(190762);
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.LocalEffectManager", e2, "Cannot load transEffect config", new Object[0]);
            AppMethodBeat.o(190762);
        }
    }

    public static List<ad> a(c cVar, List<ad> list) {
        long j2;
        ad adVar;
        int i2;
        AppMethodBeat.i(190764);
        p.h(cVar, MessengerShareContentUtility.ATTACHMENT_TEMPLATE_TYPE);
        p.h(list, "sourceTrackList");
        long currentTicks = Util.currentTicks();
        HashMap hashMap = new HashMap();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            hashMap.put(it.next().path, 0L);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(cVar.GAJ);
        ArrayList arrayList3 = arrayList2;
        if (arrayList3.size() > 1) {
            kotlin.a.j.a((List) arrayList3, (Comparator) new e());
        }
        arrayList2.set(arrayList2.size() - 1, Pair.create(((Pair) kotlin.a.j.ku(arrayList2)).first, Long.valueOf(cVar.duration)));
        new HashMap();
        int size = arrayList2.size();
        for (int i3 = 0; i3 < size; i3++) {
            Long l = (Long) ((Pair) arrayList2.get(i3)).first;
            Long l2 = (Long) ((Pair) arrayList2.get(i3)).second;
            long longValue = l2.longValue();
            p.g(l, "replacementStart");
            long longValue2 = longValue - l.longValue();
            ad adVar2 = list.get(i3 % list.size());
            Long l3 = (Long) hashMap.get(adVar2.path);
            long longValue3 = l3 != null ? l3.longValue() : -1;
            int i4 = 0;
            int size2 = list.size();
            long j3 = longValue3;
            while (true) {
                if (i4 >= size2) {
                    j2 = j3;
                    adVar = adVar2;
                    break;
                }
                adVar2 = list.get((i3 + i4) % list.size());
                Long l4 = (Long) hashMap.get(adVar2.path);
                j3 = l4 != null ? l4.longValue() : -1;
                if (j3 + longValue2 <= adVar2.getDurationMs() || adVar2.type == 1) {
                    j2 = j3;
                    adVar = adVar2;
                } else {
                    i4++;
                }
            }
            ad adVar3 = new ad(adVar.path, adVar.type);
            if (adVar.type == 1) {
                adVar3.KQ(0);
                adVar3.KR(longValue2);
                adVar3.GzA.GJB = longValue2;
            } else {
                adVar3.KQ(j2);
                adVar3.KR(j2 + longValue2);
            }
            adVar3.KO(l.longValue());
            p.g(l2, "replacementEnd");
            adVar3.KP(l2.longValue());
            adVar3.Gzu = adVar.Gzu;
            adVar3.Gzv = adVar.Gzv;
            adVar3.Gzw = adVar.Gzw;
            adVar3.GzA.Rhb = false;
            adVar3.Gzx.rwL.set(adVar.Gzx.rwL);
            adVar3.Gzx.viewRect.set(adVar.Gzx.viewRect);
            adVar3.Gzx.iiw.set(adVar.Gzx.iiw);
            adVar3.Gzx.xnf = adVar.Gzx.xnf;
            adVar3.Gzx.aXu = adVar.Gzx.aXu * 5.0f;
            adVar3.Gzx.aXt = adVar.Gzx.aXt * 5.0f;
            adVar3.Gzx.gT.set(adVar.Gzx.gT);
            int i5 = 0;
            int i6 = -1;
            for (T t : cVar.GAJ) {
                int i7 = i5 + 1;
                if (i5 < 0) {
                    kotlin.a.j.hxH();
                }
                T t2 = t;
                if (!p.j((Long) ((Pair) t2).first, (Long) ((Pair) arrayList2.get(i3)).first) || !p.j((Long) ((Pair) t2).second, (Long) ((Pair) arrayList2.get(i3)).second)) {
                    i2 = i6;
                } else {
                    i2 = i5;
                }
                i5 = i7;
                i6 = i2;
            }
            Log.i("MicroMsg.LocalEffectManager", "add template track, time:[" + l + ", " + l2 + "], track time:[" + adVar3.GzA.GGz + ", " + adVar3.GzA.GGA + ", " + adVar3.GzA.GJB + "], path:" + adVar.path + ", originIndex:" + i6);
            long j4 = j2 + longValue2;
            if (j4 >= adVar.getDurationMs()) {
                j4 = 0;
            }
            hashMap.put(adVar.path, Long.valueOf(j4));
            arrayList.add(adVar3);
        }
        Log.i("MicroMsg.LocalEffectManager", "finish generate template track name:" + cVar.name + ", result.size:" + arrayList.size() + ", replacementInfo:" + cVar.GAJ + ", template.duration:" + cVar.duration + ", cost:" + Util.ticksToNow(currentTicks));
        ArrayList arrayList4 = arrayList;
        AppMethodBeat.o(190764);
        return arrayList4;
    }

    public static void D(List<ad> list, int i2) {
        T t;
        boolean z;
        AppMethodBeat.i(190765);
        p.h(list, "trackList");
        Iterator<T> it = wKy.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (next.order == i2) {
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
        for (ad adVar : kotlin.a.j.N(list, list.size() - 1)) {
            a(adVar, t2);
        }
        AppMethodBeat.o(190765);
    }

    public static void a(ad adVar, int i2) {
        T t;
        boolean z;
        AppMethodBeat.i(190766);
        p.h(adVar, FFmpegMetadataRetriever.METADATA_KEY_TRACK);
        Iterator<T> it = wKy.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (next.order == i2) {
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
        a(adVar, t);
        AppMethodBeat.o(190766);
    }

    private static void a(ad adVar, C1849a aVar) {
        AppMethodBeat.i(190767);
        p.h(adVar, FFmpegMetadataRetriever.METADATA_KEY_TRACK);
        EffectManager effectManager = GAw;
        if (effectManager != null) {
            effectManager.Ot(adVar.fBI());
        }
        adVar.GzA.Rhc.GAn = null;
        adVar.a(aVar);
        AppMethodBeat.o(190767);
    }

    public static void a(c cVar, long[] jArr) {
        com.tencent.mm.xeffect.effect.ad adVar;
        long j2;
        Long l = null;
        AppMethodBeat.i(190768);
        p.h(cVar, "videoTemplate");
        p.h(jArr, "targets");
        EffectManager effectManager = GAw;
        if (effectManager != null) {
            effectManager.hiv();
        }
        b(null, false);
        c cVar2 = GAv;
        if (cVar2 != null) {
            Log.i("MicroMsg.LocalEffectManager", "setVideoTemplate: remove  " + (cVar2 != null ? Long.valueOf(cVar2.GAI) : null));
            EffectManager effectManager2 = GAw;
            if (effectManager2 != null) {
                effectManager2.b(com.tencent.mm.xeffect.effect.j.PAGVideoTemplateEffect);
            }
        }
        EffectManager effectManager3 = GAw;
        if (effectManager3 != null) {
            com.tencent.mm.xeffect.effect.j jVar = com.tencent.mm.xeffect.effect.j.PAGVideoTemplateEffect;
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            AssetManager assets = context.getAssets();
            p.g(assets, "MMApplicationContext.getContext().assets");
            adVar = effectManager3.a(jVar, assets, cVar.path);
        } else {
            adVar = null;
        }
        if (adVar != null) {
            adVar.aH(0, cVar.duration);
        }
        EffectManager effectManager4 = GAw;
        if (effectManager4 != null) {
            effectManager4.a(adVar);
        }
        StringBuilder sb = new StringBuilder("setVideoTemplate: addEffect ");
        if (adVar != null) {
            l = Long.valueOf(adVar.id);
        }
        Log.i("MicroMsg.LocalEffectManager", sb.append(l).toString());
        if (adVar != null) {
            j2 = adVar.id;
        } else {
            j2 = 0;
        }
        cVar.GAI = j2;
        GAv = cVar;
        AppMethodBeat.o(190768);
    }

    public static List<Integer> fBU() {
        return GAC;
    }

    public static void b(ac acVar, boolean z) {
        Long l;
        long j2;
        n nVar = null;
        AppMethodBeat.i(190769);
        b bVar = GAu;
        if (bVar != null) {
            if (z && bVar.GzV == null) {
                EffectManager effectManager = GAw;
                com.tencent.mm.xeffect.effect.ad a2 = effectManager != null ? effectManager.a(com.tencent.mm.xeffect.effect.j.ImageEnhanceEffect) : null;
                EffectManager effectManager2 = GAw;
                if (effectManager2 != null) {
                    effectManager2.a(a2);
                }
                if (!(a2 instanceof n)) {
                    a2 = null;
                }
                bVar.GzV = (n) a2;
            } else if (!z && bVar.GzV != null) {
                EffectManager effectManager3 = GAw;
                if (effectManager3 != null) {
                    n nVar2 = bVar.GzV;
                    if (nVar2 != null) {
                        j2 = nVar2.id;
                    } else {
                        j2 = 0;
                    }
                    effectManager3.Ot(j2);
                }
                bVar.GzV = null;
            }
            if (acVar != null) {
                acVar.Gzp = z;
            }
            if (z) {
                com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.GLF.fDY();
                if (acVar != null) {
                    acVar.a(new i(z, acVar));
                }
            }
        }
        StringBuilder append = new StringBuilder("setVideoEnhancement enable:").append(z).append(", effectId:");
        b bVar2 = GAu;
        if (bVar2 != null) {
            l = Long.valueOf(bVar2.fCb());
        } else {
            l = null;
        }
        StringBuilder append2 = append.append(l).append(", rangeId:");
        b bVar3 = GAu;
        if (bVar3 != null) {
            nVar = bVar3.GzV;
        }
        Log.i("MicroMsg.LocalEffectManager", append2.append(nVar).toString());
        AppMethodBeat.o(190769);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\r¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/vlog/model/local/LocalEffectManager$setVideoEnhancement$1$1", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "lastTrackPath", "", "getLastTrackPath", "()Ljava/lang/String;", "setLastTrackPath", "(Ljava/lang/String;)V", "onFrameStart", "", "pts", "", "onRelease", "plugin-vlog_release"})
    public static final class i implements com.tencent.mm.videocomposition.b.e {
        private String GAN = "";
        final /* synthetic */ ac GAO;
        final /* synthetic */ boolean ntM;

        i(boolean z, ac acVar) {
            this.ntM = z;
            this.GAO = acVar;
        }

        @Override // com.tencent.mm.videocomposition.b.e
        public final void KM(long j2) {
            n nVar;
            String str;
            String str2;
            String str3 = null;
            AppMethodBeat.i(190755);
            a aVar = a.GAD;
            b fBO = a.fBO();
            if (fBO != null) {
                nVar = fBO.GzV;
            } else {
                nVar = null;
            }
            if (nVar != null) {
                ad a2 = com.tencent.mm.plugin.vlog.model.i.a(this.GAO, j2);
                if (a2 != null) {
                    str = a2.path;
                } else {
                    str = null;
                }
                if (!p.j(str, this.GAN)) {
                    a aVar2 = a.GAD;
                    if (a2 != null) {
                        str3 = a2.path;
                    }
                    int aUc = a.aUc(str3);
                    a aVar3 = a.GAD;
                    if (a.fBU().contains(Integer.valueOf(aUc))) {
                        a aVar4 = a.GAD;
                        a.acA(aUc);
                    }
                    if (a2 == null || (str2 = a2.path) == null) {
                        str2 = "";
                    }
                    this.GAN = str2;
                }
            }
            AppMethodBeat.o(190755);
        }

        @Override // com.tencent.mm.videocomposition.b.e
        public final void onRelease() {
        }
    }

    public static boolean fBV() {
        long j2;
        n nVar;
        b bVar = GAu;
        if (bVar == null || (nVar = bVar.GzV) == null) {
            j2 = -1;
        } else {
            j2 = nVar.id;
        }
        return j2 > 0;
    }

    public static boolean fBW() {
        boolean z;
        AppMethodBeat.i(190770);
        if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE || WeChatEnvironment.hasDebugger()) {
            z = true;
        } else {
            z = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_image_enhancement_enable, 0) == 1;
        }
        int i2 = MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_ENABLE_IMAGE_ENHANCEMENT_SETTING_INT_SYNC", 0);
        if (i2 == 0) {
            AppMethodBeat.o(190770);
            return z;
        } else if (i2 == 1) {
            AppMethodBeat.o(190770);
            return true;
        } else {
            AppMethodBeat.o(190770);
            return false;
        }
    }

    public static void acA(int i2) {
        boolean z = true;
        AppMethodBeat.i(190771);
        if (i2 < 0) {
            Log.e("MicroMsg.LocalEffectManager", "setVideoEnhancementScene error:".concat(String.valueOf(i2)));
            AppMethodBeat.o(190771);
            return;
        }
        b bVar = GAu;
        if (bVar != null) {
            if (bVar.fCb() > 0) {
                Log.i("MicroMsg.LocalEffectManager", "setVideoEnhancementScene, effectId:" + bVar.fCb() + ", scene:" + i2);
                n nVar = bVar.GzV;
                if (nVar != null) {
                    nVar.setScene(i2);
                }
                bVar.GAF = i2;
            }
            if (MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_SHOW_IMAGE_ENHANCEMENT_FACE_LANDMARKS_INT_SYNC", 0) != 1) {
                z = false;
            }
            b bVar2 = GAu;
            if (bVar2 != null) {
                if (bVar2.fCb() > 0) {
                    Log.i("MicroMsg.LocalEffectManager", "setVideoEnhancementShowFaceLandmarks, show:".concat(String.valueOf(z)));
                    n nVar2 = bVar2.GzV;
                    if (nVar2 != null) {
                        nVar2.DL(z);
                        AppMethodBeat.o(190771);
                        return;
                    }
                }
                AppMethodBeat.o(190771);
                return;
            }
            AppMethodBeat.o(190771);
            return;
        }
        AppMethodBeat.o(190771);
    }

    public static boolean aUd(String str) {
        AppMethodBeat.i(190772);
        p.h(str, "json");
        b bVar = GAu;
        if (bVar == null || bVar.fCb() <= 0) {
            AppMethodBeat.o(190772);
            return false;
        }
        n nVar = bVar.GzV;
        if (nVar != null) {
            nVar.bpE(str);
        }
        Log.i("MicroMsg.LocalEffectManager", "setImageEnhancementSceneFilterSettingsByJson:".concat(String.valueOf(str)));
        Log.i("MicroMsg.LocalEffectManager", "setImageEnhancementSceneFilterSettingsByJson, ret:true, effectId:" + bVar.fCb());
        AppMethodBeat.o(190772);
        return true;
    }

    private static Bitmap aUe(String str) {
        AppMethodBeat.i(190773);
        p.h(str, "path");
        Object obj = new Object();
        Log.i("MicroMsg.LocalEffectManager", "getImageEnhancementBitmap path:".concat(String.valueOf(str)));
        try {
            ad adVar = new ad(str, 1);
            ac acVar = new ac(kotlin.a.j.listOf(adVar));
            b(acVar, true);
            int aUc = aUc(str);
            if (GAC.contains(Integer.valueOf(aUc))) {
                acA(aUc);
            }
            z.f fVar = new z.f();
            fVar.SYG = null;
            acVar.a(GAw);
            c.a aVar = com.tencent.mm.videocomposition.c.RgU;
            com.tencent.mm.videocomposition.c b2 = c.a.b(acVar.getComposition());
            b2.setSize(adVar.GzA.Gzu, adVar.GzA.Gzv);
            b2.b(kotlin.a.j.listOf((Object) 100L), new f(adVar, fVar, obj));
            synchronized (obj) {
                try {
                    obj.wait();
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.LocalEffectManager", e2, "", new Object[0]);
                }
                try {
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(190773);
                    throw th;
                }
            }
            b(acVar, false);
            T t = fVar.SYG;
            AppMethodBeat.o(190773);
            return t;
        } catch (Exception e3) {
            Log.e("MicroMsg.LocalEffectManager", "getImageEnhancementBitmap parse track fail path:" + str + ", error:" + e3.getLocalizedMessage());
            AppMethodBeat.o(190773);
            return null;
        }
    }

    public static void hP(List<String> list) {
        AppMethodBeat.i(190774);
        p.h(list, "pathList");
        GAy.clear();
        com.tencent.mm.videocomposition.i iVar = com.tencent.mm.videocomposition.i.Rhj;
        int hfl = com.tencent.mm.videocomposition.i.hfl();
        com.tencent.mm.videocomposition.i iVar2 = com.tencent.mm.videocomposition.i.Rhj;
        com.tencent.mm.videocomposition.i.apL(2000);
        com.tencent.mm.videocomposition.i.Rhj.clear();
        for (T t : list) {
            Bitmap aUe = aUe(t);
            if (aUe != null) {
                String str = GAs + '/' + Util.currentTicks();
                BitmapUtil.saveBitmapToImage(aUe, 100, Bitmap.CompressFormat.JPEG, str, false);
                GAy.put(t, str);
                Log.i("MicroMsg.LocalEffectManager", "save enhancement image result in " + str + ", origin:" + ((String) t));
                if (GAy.size() == list.size()) {
                    Log.i("MicroMsg.LocalEffectManager", "save enhancement image result finish");
                }
            }
        }
        com.tencent.mm.videocomposition.i iVar3 = com.tencent.mm.videocomposition.i.Rhj;
        com.tencent.mm.videocomposition.i.apL(hfl);
        Log.i("MicroMsg.LocalEffectManager", "save enhancement image result finish return");
        AppMethodBeat.o(190774);
    }

    public static void fBX() {
        AppMethodBeat.i(190775);
        StringBuilder sb = new StringBuilder();
        com.tencent.mm.plugin.xlabeffect.e eVar = com.tencent.mm.plugin.xlabeffect.e.JRF;
        StringBuilder append = sb.append(com.tencent.mm.plugin.xlabeffect.e.glu()).append(FilePathGenerator.ANDROID_DIR_SEP);
        com.tencent.mm.plugin.xlabeffect.e eVar2 = com.tencent.mm.plugin.xlabeffect.e.JRF;
        String sb2 = append.append(com.tencent.mm.plugin.xlabeffect.e.glv()).toString();
        if (com.tencent.mm.plugin.recordvideo.res.g.BYp.eLz() && !com.tencent.mm.vfs.s.YS(sb2)) {
            com.tencent.mm.vfs.s.nx(com.tencent.mm.plugin.recordvideo.res.g.BYp.eLy(), sb2);
            Log.i("MicroMsg.LocalEffectManager", "tryCreateX3DGlobalContext, copy image label model path, from:" + com.tencent.mm.plugin.recordvideo.res.g.BYp.eLy() + " to " + sb2);
        }
        if (!com.tencent.mm.vfs.s.YS(sb2)) {
            Log.e("MicroMsg.LocalEffectManager", "tryCreateX3DGlobalContext model not exist!");
            AppMethodBeat.o(190775);
            return;
        }
        Log.i("MicroMsg.LocalEffectManager", "start tryCreateX3DGlobalContext");
        com.tencent.mm.plugin.xlabeffect.e eVar3 = com.tencent.mm.plugin.xlabeffect.e.JRF;
        GAA = GlobalContextCreator.bpC(com.tencent.mm.plugin.xlabeffect.e.glu());
        Log.i("MicroMsg.LocalEffectManager", "tryCreateX3DGlobalContext finish");
        AppMethodBeat.o(190775);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class j implements Runnable {
        public static final j GAP = new j();

        static {
            AppMethodBeat.i(190757);
            AppMethodBeat.o(190757);
        }

        j() {
        }

        public final void run() {
            AppMethodBeat.i(190756);
            c.a aVar = com.tencent.mm.media.k.c.ilt;
            c.b aNa = c.a.aNa();
            if (p.j(aNa.ilv, EGL14.EGL_NO_CONTEXT)) {
                Log.e("MicroMsg.LocalEffectManager", "tryCreateX3DGlobalContext, create EGLContext failed");
                AppMethodBeat.o(190756);
                return;
            }
            a aVar2 = a.GAD;
            a.fBX();
            if (!p.j(aNa.eglSurface, EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(aNa.ilu, aNa.eglSurface);
            }
            EGL14.eglDestroyContext(aNa.ilu, aNa.ilv);
            AppMethodBeat.o(190756);
        }
    }

    public static void fBY() {
        AppMethodBeat.i(190776);
        com.tencent.f.h.RTc.aX(j.GAP);
        AppMethodBeat.o(190776);
    }

    public final synchronized void unInit() {
        AppMethodBeat.i(190777);
        wKy.clear();
        Log.i("MicroMsg.LocalEffectManager", "clear");
        GAB.clear();
        EffectManager effectManager = GAw;
        if (effectManager != null) {
            effectManager.destroy();
        }
        GAw = null;
        GAu = null;
        com.tencent.mm.plugin.recordvideo.res.f.BYo.BYa = null;
        GAx = null;
        com.tencent.mm.vfs.s.deleteDir(GAs);
        GAy.clear();
        if (GAA) {
            GlobalContextCreator.hir();
            GAA = false;
        }
        AppMethodBeat.o(190777);
    }

    public final synchronized void reset() {
        AppMethodBeat.i(190778);
        Log.i("MicroMsg.LocalEffectManager", "reset");
        EffectManager effectManager = GAw;
        if (effectManager != null) {
            effectManager.hiv();
        }
        GAy.clear();
        AppMethodBeat.o(190778);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class h extends q implements kotlin.g.a.a<x> {
        public static final h GAM = new h();

        static {
            AppMethodBeat.i(190754);
            AppMethodBeat.o(190754);
        }

        h() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(190753);
            Log.i("MicroMsg.LocalEffectManager", "initTransResource: transition res callback");
            com.tencent.mm.plugin.recordvideo.res.f.BYo.BYa = null;
            a aVar = a.GAD;
            a.fBZ();
            a aVar2 = a.GAD;
            a.fCa();
            x xVar = x.SXb;
            AppMethodBeat.o(190753);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        public static final d GAK = new d();

        static {
            AppMethodBeat.i(190749);
            AppMethodBeat.o(190749);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            com.tencent.mm.plugin.vlog.ui.plugin.transition.b bVar;
            AppMethodBeat.i(190748);
            a aVar = a.GAD;
            WeakReference<com.tencent.mm.plugin.vlog.ui.plugin.transition.b> fBQ = a.fBQ();
            if (!(fBQ == null || (bVar = fBQ.get()) == null)) {
                bVar.fEs();
            }
            a aVar2 = a.GAD;
            a.i(null);
            x xVar = x.SXb;
            AppMethodBeat.o(190748);
            return xVar;
        }
    }

    public static void b(C1849a aVar) {
        AppMethodBeat.i(190763);
        p.h(aVar, "transEffectInfo");
        if (aVar.GAn == null) {
            EffectManager effectManager = GAw;
            aVar.GAn = effectManager != null ? effectManager.a(com.tencent.mm.xeffect.effect.j.PAGTransitionEffect, aVar.assetPath) : null;
        }
        AppMethodBeat.o(190763);
    }

    public static final /* synthetic */ void fCa() {
        AppMethodBeat.i(190781);
        Log.i("MicroMsg.LocalEffectManager", "checkRefreshView: " + GAz);
        if (GAz) {
            com.tencent.mm.ac.d.h(d.GAK);
        }
        AppMethodBeat.o(190781);
    }
}
