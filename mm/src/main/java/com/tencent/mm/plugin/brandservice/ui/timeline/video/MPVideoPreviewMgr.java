package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.plugin.appbrand.jsapi.video.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar;
import com.tencent.mm.plugin.bizui.widget.StoryListView;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.ad;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.ak;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.at;
import com.tencent.mm.protocal.protobuf.bsq;
import com.tencent.mm.protocal.protobuf.bsr;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.protocal.protobuf.eqv;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.o;
import kotlin.x;
import org.xwalk.core.XWalkEnvironment;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003_`aB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010+\u001a\u00020,2\b\u0010*\u001a\u0004\u0018\u00010\u0004J\u000e\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020/J\u0010\u00100\u001a\u00020)2\b\u00101\u001a\u0004\u0018\u00010\u0004J\u001e\u00102\u001a\u00020)2\u0006\u00103\u001a\u00020\u00042\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207J\u001a\u00108\u001a\u00020)2\b\u00109\u001a\u0004\u0018\u00010\u00042\b\u0010*\u001a\u0004\u0018\u00010\u0004J\"\u0010:\u001a\u00020)2\u0018\u0010;\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020!0=0<H\u0002J\u0016\u0010>\u001a\u00020)2\u0006\u0010.\u001a\u00020/2\u0006\u0010?\u001a\u00020\u0004J\u0006\u0010@\u001a\u00020)J\u0012\u0010A\u001a\u00020)2\b\u0010B\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010C\u001a\u00020)2\b\u0010B\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010D\u001a\u00020)2\u0018\u00104\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020!0=0<H\u0002J\u0012\u0010E\u001a\u0004\u0018\u00010\u00042\b\u0010*\u001a\u0004\u0018\u00010\u0004J\u0014\u0010F\u001a\u0004\u0018\u00010\u00042\b\u0010*\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010G\u001a\u00020,2\b\u0010*\u001a\u0004\u0018\u00010\u0004J\u0016\u0010H\u001a\u00020)2\u0006\u0010.\u001a\u00020/2\u0006\u0010I\u001a\u00020\u0015J\"\u0010J\u001a\u00020)2\u0018\u00104\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020!0=0<H\u0002J\u0010\u0010K\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0004J\u001c\u0010L\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u00042\b\u0010M\u001a\u0004\u0018\u00010\u0004H\u0002J8\u0010N\u001a\u00020)2\u0006\u0010.\u001a\u00020/2\b\u0010O\u001a\u0004\u0018\u00010\u001f2\u0006\u0010P\u001a\u00020,2\b\u0010Q\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0004H\u0002J\u0006\u0010R\u001a\u00020)J\u0012\u0010S\u001a\u00020)2\b\b\u0002\u0010T\u001a\u00020\u0013H\u0002J\b\u0010U\u001a\u00020)H\u0002J\u0006\u0010V\u001a\u00020)J\u0010\u0010W\u001a\u00020)2\b\u0010B\u001a\u0004\u0018\u00010\u0004J\u000e\u0010X\u001a\u0004\u0018\u00010Y*\u00020/H\u0002J\f\u0010Z\u001a\u00020\u0004*\u00020/H\u0002J\u000e\u0010[\u001a\u0004\u0018\u00010\\*\u00020/H\u0002J\f\u0010]\u001a\u00020\u0004*\u00020/H\u0002J\f\u0010^\u001a\u00020\u0004*\u00020/H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00040\nj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00040\nj\b\u0012\u0004\u0012\u00020\u0004`\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R6\u0010\u0011\u001a*\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0012j\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014`\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006b"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr;", "", "()V", "TAG", "", "abTestOn", "", "getAbTestOn", "()Z", "blackList", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "canSetAlpha", "cgiQueue", "currentVid", "hotLocation", "", "infoToCard", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "Lkotlin/collections/HashMap;", "previewInfo", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$PreviewInfo;", "updateTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "urlManager", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "videoLocation", "weakParent", "Landroid/view/ViewGroup;", "weakPreview", "Landroid/view/View;", "weakTimer", "Landroid/widget/TextView;", "weakVideoView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView;", "weakVideoWrapper", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoWrapper;", "addBlackList", "", "vid", "autoPlayTime", "", "cgiPlayUrl", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "changeStatus", "status", "checkPosition", "reason", "list", "Lcom/tencent/mm/plugin/bizui/widget/StoryListView;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "checkSameTopVideo", "lastVid", "chooseVideo", "videoInfoList", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "clickCard", "extra", "destroy", "doPauseForResume", "event", "doStatusElse", "filterCard", "getAutoPlayId", "getPlayUrl", "isAutoPlay", "registerCard", "cardTmpl", "removeBlackList", "saveVideoInTimeline", "setPlayUrl", "url", "startPreview", "parent", "height", "playUrl", "startTimer", "stopPreviewAd", "except", "stopPreviewVideo", "stopTimer", "triggerEvent", "getBizMMReader", "Lcom/tencent/mm/message/BizMMReader;", "getTitle", "getTopBizReaderItem", "Lcom/tencent/mm/message/BizReaderItem;", "getUrl", "getVid", "EmptyControlBar", "Event", "PreviewInfo", "plugin-brandservice_release"})
public final class MPVideoPreviewMgr {
    public static final boolean pJj = com.tencent.mm.plugin.webview.ui.tools.video.a.gic();
    public static WeakReference<ViewGroup> pJk;
    public static WeakReference<View> pJl;
    public static WeakReference<AppBrandVideoView> pJm;
    public static WeakReference<AppBrandVideoWrapper> pJn;
    public static WeakReference<TextView> pJo;
    public static MTimerHandler pJp;
    public static final a pJq = new a();
    public static boolean pJr;
    public static String pJs = "";
    private static int[] pJt;
    public static int[] pJu;
    private static final MMKVSlotManager pJv;
    public static HashSet<String> pJw = new HashSet<>();
    public static HashMap<Long, WeakReference<ad>> pJx = new HashMap<>();
    private static final HashSet<String> pJy = new HashSet<>();
    public static final MPVideoPreviewMgr pJz = new MPVideoPreviewMgr();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<no name provided>", "", "vid", "", "url", "invoke"})
    static final class b extends q implements m<String, String, x> {
        public static final b pJM = new b();

        static {
            AppMethodBeat.i(195918);
            AppMethodBeat.o(195918);
        }

        b() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(String str, String str2) {
            AppMethodBeat.i(195917);
            bsq bsq = new bsq();
            bsq.vid = str;
            bsq.LZt = str2;
            d.a aVar = new d.a();
            aVar.c(bsq);
            aVar.d(new bsr());
            aVar.MB("/cgi-bin/mmbiz-bin/appmsg/getplayurl");
            aVar.sG(2962);
            aVar.sI(0);
            aVar.sJ(0);
            IPCRunCgi.a(aVar.aXF(), AnonymousClass1.pJN);
            x xVar = x.SXb;
            AppMethodBeat.o(195917);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<no name provided>", "", "view", "Landroid/view/View;", "invoke"})
    public static final class c extends q implements kotlin.g.a.b<View, Float> {
        public static final c pJO = new c();

        static {
            AppMethodBeat.i(195920);
            AppMethodBeat.o(195920);
        }

        c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Float invoke(View view) {
            float f2 = 0.0f;
            AppMethodBeat.i(195919);
            View view2 = view;
            p.h(view2, "view");
            MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
            if (MPVideoPreviewMgr.pJu == null) {
                MPVideoPreviewMgr mPVideoPreviewMgr2 = MPVideoPreviewMgr.pJz;
                MPVideoPreviewMgr.pJu = new int[2];
            }
            MPVideoPreviewMgr mPVideoPreviewMgr3 = MPVideoPreviewMgr.pJz;
            view2.getLocationInWindow(MPVideoPreviewMgr.pJu);
            MPVideoPreviewMgr mPVideoPreviewMgr4 = MPVideoPreviewMgr.pJz;
            int[] iArr = MPVideoPreviewMgr.pJu;
            if (iArr == null) {
                p.hyc();
            }
            float f3 = (float) iArr[1];
            MPVideoPreviewMgr mPVideoPreviewMgr5 = MPVideoPreviewMgr.pJz;
            int[] iArr2 = MPVideoPreviewMgr.pJt;
            if (iArr2 == null) {
                p.hyc();
            }
            float f4 = (float) iArr2[0];
            MPVideoPreviewMgr mPVideoPreviewMgr6 = MPVideoPreviewMgr.pJz;
            int[] iArr3 = MPVideoPreviewMgr.pJt;
            if (iArr3 == null) {
                p.hyc();
            }
            float f5 = (float) iArr3[1];
            if (f3 > f5) {
                Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition inHotPercent exceed upper edge");
            } else if (((float) com.tencent.mm.plugin.brandservice.ui.timeline.b.prs) + f3 < f4) {
                Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition inHotPercent exceed lower edge");
            } else {
                MPVideoPreviewMgr mPVideoPreviewMgr7 = MPVideoPreviewMgr.pJz;
                int[] iArr4 = MPVideoPreviewMgr.pJt;
                if (iArr4 == null) {
                    p.hyc();
                }
                if (f3 < ((float) iArr4[0])) {
                    f2 = ((((float) com.tencent.mm.plugin.brandservice.ui.timeline.b.prs) + f3) - f4) / ((float) com.tencent.mm.plugin.brandservice.ui.timeline.b.prs);
                } else if (((float) com.tencent.mm.plugin.brandservice.ui.timeline.b.prs) + f3 > f5) {
                    f2 = (f5 - f3) / ((float) com.tencent.mm.plugin.brandservice.ui.timeline.b.prs);
                } else {
                    f2 = 1.0f;
                }
                Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition inHotPercent percent = ".concat(String.valueOf(f2)));
            }
            Float valueOf = Float.valueOf(f2);
            AppMethodBeat.o(195919);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, hxF = {"<no name provided>", "", "same", "", "parent", "Landroid/view/ViewGroup;", "height", "", "invoke"})
    public static final class f extends q implements kotlin.g.a.q<Boolean, ViewGroup, Integer, x> {
        public static final f pJR = new f();

        static {
            AppMethodBeat.i(195926);
            AppMethodBeat.o(195926);
        }

        f() {
            super(3);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(Boolean bool, ViewGroup viewGroup, Integer num) {
            ViewParent viewParent;
            View view;
            View view2 = null;
            AppMethodBeat.i(195925);
            boolean booleanValue = bool.booleanValue();
            ViewGroup viewGroup2 = viewGroup;
            int intValue = num.intValue();
            p.h(viewGroup2, "parent");
            if (!booleanValue && !booleanValue) {
                MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
                MPVideoPreviewMgr.pJk = new WeakReference(viewGroup2);
                MPVideoPreviewMgr mPVideoPreviewMgr2 = MPVideoPreviewMgr.pJz;
                WeakReference weakReference = MPVideoPreviewMgr.pJl;
                View view3 = weakReference != null ? (View) weakReference.get() : null;
                if (view3 == null) {
                    Log.i("MicroMsg.MPVideoPreviewMgr", "setParent v = null, error");
                } else {
                    MPVideoPreviewMgr mPVideoPreviewMgr3 = MPVideoPreviewMgr.pJz;
                    WeakReference weakReference2 = MPVideoPreviewMgr.pJl;
                    if (weakReference2 == null || (view = (View) weakReference2.get()) == null) {
                        viewParent = null;
                    } else {
                        viewParent = view.getParent();
                    }
                    if (!(viewParent instanceof ViewGroup)) {
                        viewParent = null;
                    }
                    ViewGroup viewGroup3 = (ViewGroup) viewParent;
                    if (viewGroup3 != null) {
                        MPVideoPreviewMgr mPVideoPreviewMgr4 = MPVideoPreviewMgr.pJz;
                        WeakReference weakReference3 = MPVideoPreviewMgr.pJl;
                        if (weakReference3 != null) {
                            view2 = (View) weakReference3.get();
                        }
                        viewGroup3.removeView(view2);
                    }
                    viewGroup2.addView(view3, -1, intValue);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(195925);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<no name provided>", "", "same", "", "context", "Landroid/content/Context;", "invoke"})
    public static final class g extends q implements m<Boolean, Context, x> {
        public static final g pJS = new g();

        static {
            AppMethodBeat.i(195932);
            AppMethodBeat.o(195932);
        }

        g() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Boolean bool, Context context) {
            View inflate;
            ViewParent viewParent;
            ViewParent viewParent2;
            ViewParent viewParent3;
            FrameLayout frameLayout;
            FrameLayout frameLayout2;
            AppMethodBeat.i(195931);
            boolean booleanValue = bool.booleanValue();
            Context context2 = context;
            p.h(context2, "context");
            z.f fVar = new z.f();
            fVar.SYG = null;
            a aVar = new a(context2, fVar);
            if (booleanValue) {
                MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
                WeakReference weakReference = MPVideoPreviewMgr.pJl;
                View view = weakReference != null ? (View) weakReference.get() : null;
                if (view == null) {
                    view = LayoutInflater.from(context2).inflate(R.layout.l9, (ViewGroup) null, false);
                    MPVideoPreviewMgr mPVideoPreviewMgr2 = MPVideoPreviewMgr.pJz;
                    if (view == null) {
                        p.hyc();
                    }
                    MPVideoPreviewMgr.pJl = new WeakReference(view);
                }
                inflate = view;
                MPVideoPreviewMgr mPVideoPreviewMgr3 = MPVideoPreviewMgr.pJz;
                WeakReference weakReference2 = MPVideoPreviewMgr.pJm;
                fVar.SYG = weakReference2 != null ? (T) ((AppBrandVideoView) weakReference2.get()) : null;
                if (fVar.SYG == null) {
                    aVar.invoke();
                }
            } else if (!booleanValue) {
                inflate = LayoutInflater.from(context2).inflate(R.layout.l9, (ViewGroup) null, false);
                MPVideoPreviewMgr mPVideoPreviewMgr4 = MPVideoPreviewMgr.pJz;
                MPVideoPreviewMgr.pJl = new WeakReference(inflate);
                aVar.invoke();
            } else {
                kotlin.m mVar = new kotlin.m();
                AppMethodBeat.o(195931);
                throw mVar;
            }
            T t = fVar.SYG;
            if (t != null) {
                viewParent = t.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent != null) {
                T t2 = fVar.SYG;
                if (t2 != null) {
                    viewParent2 = t2.getParent();
                } else {
                    viewParent2 = null;
                }
                if (!p.j(viewParent2, inflate)) {
                    T t3 = fVar.SYG;
                    if (t3 != null) {
                        viewParent3 = t3.getParent();
                    } else {
                        viewParent3 = null;
                    }
                    if (!(viewParent3 instanceof ViewGroup)) {
                        viewParent3 = null;
                    }
                    ViewGroup viewGroup = (ViewGroup) viewParent3;
                    if (viewGroup != null) {
                        viewGroup.removeView(fVar.SYG);
                    }
                    if (!(inflate == null || (frameLayout = (FrameLayout) inflate.findViewById(R.id.be_)) == null)) {
                        frameLayout.addView(fVar.SYG, 0, new FrameLayout.LayoutParams(-1, -1));
                    }
                }
            } else if (!(inflate == null || (frameLayout2 = (FrameLayout) inflate.findViewById(R.id.be_)) == null)) {
                frameLayout2.addView(fVar.SYG, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(195931);
            return xVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<no name provided>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ Context $context;
            final /* synthetic */ z.f pJT;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Context context, z.f fVar) {
                super(0);
                this.$context = context;
                this.pJT = fVar;
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J,\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016J\u001c\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0013\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0014\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0015"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$startPreview$setUI$1$createVideo$1$1$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IMMVideoViewCallback;", "onError", "", "sessionId", "", "mediaId", OpenSDKTool4Assistant.EXTRA_ERROR_MSG, "what", "", "extra", "onGetVideoSize", "width", "height", "onPrepared", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "plugin-brandservice_release"})
            /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr$g$a$a  reason: collision with other inner class name */
            public static final class C0893a implements e.c {
                C0893a() {
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
                public final void c(String str, String str2, String str3, int i2, int i3) {
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
                public final void dH(String str, String str2) {
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
                public final void dI(String str, String str2) {
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
                public final void d(String str, String str2, int i2, int i3) {
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
                public final void dJ(String str, String str2) {
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
                public final void dK(String str, String str2) {
                    View view;
                    TextView textView;
                    String str3;
                    View view2;
                    TextView textView2;
                    AppBrandVideoView appBrandVideoView;
                    AppMethodBeat.i(195927);
                    Log.i("MicroMsg.MPVideoPreviewMgr", "startPreview onVideoPlay");
                    MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
                    if (MPVideoPreviewMgr.pJr) {
                        MPVideoPreviewMgr mPVideoPreviewMgr2 = MPVideoPreviewMgr.pJz;
                        MPVideoPreviewMgr.pJq.pJJ = System.currentTimeMillis();
                        MPVideoPreviewMgr mPVideoPreviewMgr3 = MPVideoPreviewMgr.pJz;
                        MPVideoPreviewMgr.pJr = false;
                        MPVideoPreviewMgr mPVideoPreviewMgr4 = MPVideoPreviewMgr.pJz;
                        WeakReference weakReference = MPVideoPreviewMgr.pJl;
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(weakReference != null ? (View) weakReference.get() : null, "alpha", 0.0f, 1.0f);
                        p.g(ofFloat, LocaleUtil.ITALIAN);
                        ofFloat.setDuration(200L);
                        ofFloat.start();
                        MPVideoPreviewMgr mPVideoPreviewMgr5 = MPVideoPreviewMgr.pJz;
                        WeakReference weakReference2 = MPVideoPreviewMgr.pJl;
                        if (!(weakReference2 == null || (view2 = (View) weakReference2.get()) == null || (textView2 = (TextView) view2.findViewById(R.id.ggv)) == null)) {
                            MPVideoPreviewMgr mPVideoPreviewMgr6 = MPVideoPreviewMgr.pJz;
                            MPVideoPreviewMgr.pJo = new WeakReference(textView2);
                            MPVideoPreviewMgr mPVideoPreviewMgr7 = MPVideoPreviewMgr.pJz;
                            WeakReference weakReference3 = MPVideoPreviewMgr.pJm;
                            int duration = (weakReference3 == null || (appBrandVideoView = (AppBrandVideoView) weakReference3.get()) == null) ? 0 : appBrandVideoView.getDuration();
                            String rJ = com.tencent.mm.ag.m.rJ(duration);
                            textView2.setText(rJ != null ? rJ : "");
                            MPVideoPreviewMgr mPVideoPreviewMgr8 = MPVideoPreviewMgr.pJz;
                            MPVideoPreviewMgr.pJq.setVideoDuration(duration);
                        }
                        MPVideoPreviewMgr mPVideoPreviewMgr9 = MPVideoPreviewMgr.pJz;
                        WeakReference weakReference4 = MPVideoPreviewMgr.pJl;
                        if (!(weakReference4 == null || (view = (View) weakReference4.get()) == null || (textView = (TextView) view.findViewById(R.id.ggw)) == null)) {
                            MPVideoPreviewMgr mPVideoPreviewMgr10 = MPVideoPreviewMgr.pJz;
                            if (MPVideoPreviewMgr.pJq.akb > 1) {
                                MPVideoPreviewMgr mPVideoPreviewMgr11 = MPVideoPreviewMgr.pJz;
                                com.tencent.mm.storage.z zVar = MPVideoPreviewMgr.pJq.pJA;
                                if (zVar != null) {
                                    MPVideoPreviewMgr mPVideoPreviewMgr12 = MPVideoPreviewMgr.pJz;
                                    String v = MPVideoPreviewMgr.v(zVar);
                                    if (v != null) {
                                        str3 = v;
                                        textView.setText(str3);
                                    }
                                }
                            }
                            textView.setText(str3);
                        }
                        MPVideoPreviewMgr mPVideoPreviewMgr13 = MPVideoPreviewMgr.pJz;
                        MPVideoPreviewMgr.pJq.aiO("PLAY");
                        MPVideoPreviewMgr mPVideoPreviewMgr14 = MPVideoPreviewMgr.pJz;
                        MPVideoPreviewMgr.pJq.pl(1);
                        MPVideoPreviewMgr mPVideoPreviewMgr15 = MPVideoPreviewMgr.pJz;
                        MPVideoPreviewMgr.pJq.pl(2);
                        MPVideoPreviewMgr mPVideoPreviewMgr16 = MPVideoPreviewMgr.pJz;
                        MPVideoPreviewMgr.startTimer();
                    }
                    AppMethodBeat.o(195927);
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
                public final void dL(String str, String str2) {
                    AppMethodBeat.i(195928);
                    MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
                    MPVideoPreviewMgr.pJq.pJK = System.currentTimeMillis();
                    AppMethodBeat.o(195928);
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
                public final void dM(String str, String str2) {
                    AppMethodBeat.i(195929);
                    MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
                    MPVideoPreviewMgr.pJq.pJL = System.currentTimeMillis();
                    MPVideoPreviewMgr mPVideoPreviewMgr2 = MPVideoPreviewMgr.pJz;
                    MPVideoPreviewMgr.pJq.pl(5);
                    AppMethodBeat.o(195929);
                }
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(195930);
                EmptyControlBar emptyControlBar = new EmptyControlBar(this.$context);
                AppBrandVideoWrapper appBrandVideoWrapper = new AppBrandVideoWrapper(this.$context);
                appBrandVideoWrapper.setMyVideoViewFactory(com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.f.mFb);
                appBrandVideoWrapper.setVideoFooterView(emptyControlBar);
                appBrandVideoWrapper.setFocusAudio(false);
                MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
                MPVideoPreviewMgr.pJn = new WeakReference(appBrandVideoWrapper);
                z.f fVar = this.pJT;
                T t = (T) new AppBrandVideoView(this.$context, appBrandVideoWrapper, (byte) 0);
                t.a(emptyControlBar);
                t.setIMMVideoViewCallback(new C0893a());
                fVar.SYG = t;
                MPVideoPreviewMgr mPVideoPreviewMgr2 = MPVideoPreviewMgr.pJz;
                T t2 = this.pJT.SYG;
                if (t2 == null) {
                    p.hyc();
                }
                MPVideoPreviewMgr.pJm = new WeakReference(t2);
                x xVar = x.SXb;
                AppMethodBeat.o(195930);
                return xVar;
            }
        }
    }

    static {
        AppMethodBeat.i(195955);
        com.tencent.mm.plugin.webview.ui.tools.video.a aVar = com.tencent.mm.plugin.webview.ui.tools.video.a.JxN;
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("MicroMsg.MPVideoPreviewMgr");
        p.g(mmkv, "MultiProcessMMKV.getMMKV(TAG)");
        pJv = new MMKVSlotManager(mmkv, 14400);
        AppMethodBeat.o(195955);
    }

    private MPVideoPreviewMgr() {
    }

    public static final /* synthetic */ void cqT() {
        AppMethodBeat.i(195959);
        cqK();
        AppMethodBeat.o(195959);
    }

    public static final /* synthetic */ String t(com.tencent.mm.storage.z zVar) {
        AppMethodBeat.i(195956);
        String r = r(zVar);
        AppMethodBeat.o(195956);
        return r;
    }

    public final void a(String str, StoryListView storyListView, com.tencent.mm.plugin.brandservice.ui.timeline.b bVar) {
        ad adVar;
        at atVar;
        View view;
        ad adVar2;
        dkr dkr;
        LinkedList<dlb> linkedList;
        dlb dlb;
        cdu cdu;
        int[] iArr;
        AppMethodBeat.i(195935);
        p.h(str, "reason");
        p.h(storyListView, "list");
        p.h(bVar, "adapter");
        if (!pJj) {
            AppMethodBeat.o(195935);
            return;
        }
        Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition reason = ".concat(String.valueOf(str)));
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext()) || com.tencent.mm.plugin.topstory.a.h.isFreeSimCard()) {
            if (pJt == null || ((iArr = pJt) != null && iArr[1] == 0)) {
                int[] iArr2 = new int[2];
                storyListView.getLocationInWindow(iArr2);
                int[] iArr3 = new int[2];
                pJt = iArr3;
                iArr3[0] = iArr2[1];
                int[] iArr4 = pJt;
                if (iArr4 == null) {
                    p.hyc();
                }
                iArr4[1] = iArr2[1] + ((storyListView.getHeight() * 2) / 3);
            }
            LinkedList linkedList2 = new LinkedList();
            int firstVisiblePosition = storyListView.getFirstVisiblePosition();
            int lastVisiblePosition = storyListView.getLastVisiblePosition();
            StringBuilder sb = new StringBuilder("checkPosition x = ");
            int[] iArr5 = pJt;
            StringBuilder append = sb.append(iArr5 != null ? Integer.valueOf(iArr5[0]) : null).append(", y = ");
            int[] iArr6 = pJt;
            Log.i("MicroMsg.MPVideoPreviewMgr", append.append(iArr6 != null ? Integer.valueOf(iArr6[1]) : null).append(", height = ").append(storyListView.getHeight()).append(", startPos = ").append(firstVisiblePosition).append(", endPos = ").append(lastVisiblePosition).toString());
            if (firstVisiblePosition <= lastVisiblePosition) {
                int i2 = firstVisiblePosition;
                while (true) {
                    if (i2 != 0) {
                        com.tencent.mm.storage.z De = bVar.De(i2 - 1);
                        if (De != null) {
                            switch (De.field_type) {
                                case 285212721:
                                    v s = s(De);
                                    if (s != null) {
                                        View childAt = storyListView.getChildAt(i2 - firstVisiblePosition);
                                        Object tag = childAt != null ? childAt.getTag() : null;
                                        if (!(tag instanceof ak)) {
                                            tag = null;
                                        }
                                        ak akVar = (ak) tag;
                                        if (!(akVar == null || (atVar = akVar.pxN) == null || (view = atVar.ptQ) == null)) {
                                            Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition has TopVideo, index = " + (i2 - firstVisiblePosition));
                                            linkedList2.add(new o(De, view));
                                            String str2 = s.vid;
                                            p.g(str2, "top.vid");
                                            pJq.pJE.put(str2, Integer.valueOf(i2));
                                            break;
                                        }
                                    }
                                    break;
                                case 620757041:
                                    WeakReference<ad> weakReference = pJx.get(Long.valueOf(De.field_msgId));
                                    if (weakReference != null) {
                                        adVar = weakReference.get();
                                    } else {
                                        adVar = null;
                                    }
                                    if (!(adVar == null || !adVar.cmS() || adVar.getVideoView() == null || De.gAD() == null)) {
                                        switch (De.gAD().style) {
                                            case 101:
                                            case 102:
                                                if (De.gAD().Nga.KUf.get(0).KWy.get(0).iAb == 5) {
                                                    View videoView = adVar.getVideoView();
                                                    if (videoView == null) {
                                                        p.hyc();
                                                    }
                                                    linkedList2.add(new o(De, videoView));
                                                    pJq.pJE.put(r(De), Integer.valueOf(i2));
                                                    break;
                                                }
                                                break;
                                        }
                                    }
                                    break;
                                case 637534257:
                                    WeakReference<ad> weakReference2 = pJx.get(Long.valueOf(De.field_msgId));
                                    ad adVar3 = weakReference2 != null ? weakReference2.get() : null;
                                    if (adVar3 != null && adVar3.cmS() && adVar3.getVideoView() != null && !Util.isNullOrNil(De.gAG())) {
                                        String r = r(De);
                                        View videoView2 = adVar3.getVideoView();
                                        if (videoView2 == null) {
                                            p.hyc();
                                        }
                                        linkedList2.add(new o(De, videoView2));
                                        pJq.pJE.put(r, Integer.valueOf(i2));
                                        break;
                                    }
                                default:
                                    if (De.gAs()) {
                                        WeakReference<ad> weakReference3 = pJx.get(Long.valueOf(De.field_msgId));
                                        if (weakReference3 != null) {
                                            adVar2 = weakReference3.get();
                                        } else {
                                            adVar2 = null;
                                        }
                                        if (!(adVar2 == null || !adVar2.cmS() || adVar2.getVideoView() == null || (dkr = De.NQr) == null || (linkedList = dkr.MOG) == null || (dlb = linkedList.get(0)) == null || (cdu = dlb.MOY) == null || cdu.iAb != 5)) {
                                            View videoView3 = adVar2.getVideoView();
                                            if (videoView3 == null) {
                                                p.hyc();
                                            }
                                            linkedList2.add(new o(De, videoView3));
                                            pJq.pJE.put(r(De), Integer.valueOf(i2));
                                            break;
                                        }
                                    }
                                    break;
                            }
                        }
                    }
                    if (i2 != lastVisiblePosition) {
                        i2++;
                    }
                }
            }
            Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition videoInfoList size = " + linkedList2.size());
            J(linkedList2);
            if (Util.isNullOrNil(linkedList2)) {
                cqK();
                cqJ();
                AppMethodBeat.o(195935);
                return;
            }
            I(linkedList2);
            AppMethodBeat.o(195935);
            return;
        }
        Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition not wifi");
        AppMethodBeat.o(195935);
    }

    private static void I(LinkedList<o<com.tencent.mm.storage.z, View>> linkedList) {
        o oVar;
        String aiK;
        B b2;
        LinkedList linkedList2;
        int i2;
        AppBrandVideoView appBrandVideoView;
        AppBrandVideoView appBrandVideoView2;
        AppBrandVideoView appBrandVideoView3;
        AppBrandVideoView appBrandVideoView4;
        AppBrandVideoView appBrandVideoView5;
        View view;
        WeakReference<AppBrandVideoView> weakReference;
        AppBrandVideoView appBrandVideoView6;
        AppBrandVideoView appBrandVideoView7;
        ViewGroup viewGroup;
        ad adVar;
        Integer num = null;
        AppMethodBeat.i(195936);
        c cVar = c.pJO;
        LinkedList linkedList3 = new LinkedList();
        ArrayList arrayList = new ArrayList();
        for (T t : linkedList) {
            if (((Number) cVar.invoke(t.second)).floatValue() != 0.0f) {
                arrayList.add(t);
            }
        }
        linkedList3.addAll(arrayList);
        Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition hotList size = " + linkedList3.size());
        if (Util.isNullOrNil(linkedList3)) {
            cqK();
            cqJ();
            AppMethodBeat.o(195936);
            return;
        }
        if (linkedList3.size() <= 1) {
            oVar = (o) linkedList3.get(0);
        } else {
            Object obj = linkedList3.get(0);
            p.g(obj, "hotList[0]");
            o oVar2 = (o) obj;
            Object obj2 = linkedList3.get(1);
            p.g(obj2, "hotList[1]");
            oVar = (o) obj2;
            if (((double) ((Number) cVar.invoke(oVar2.second)).floatValue()) < 0.5d) {
                Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition hotList second");
            } else {
                oVar = oVar2;
            }
        }
        A a2 = oVar.first;
        String r = r(a2);
        pJq.pJA = a2;
        switch (((com.tencent.mm.storage.z) a2).field_type) {
            case 285212721:
                v s = s(a2);
                if (s != null) {
                    pJq.d(s);
                    a aVar = pJq;
                    u a3 = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(((com.tencent.mm.storage.z) a2).field_msgId, ((com.tencent.mm.storage.z) a2).field_content);
                    aVar.akb = (a3 == null || (linkedList2 = a3.iAd) == null) ? 0 : linkedList2.size();
                    B b3 = oVar.second;
                    if (!(b3 instanceof ViewGroup)) {
                        b3 = null;
                    }
                    aiK = aiK(r);
                    b2 = b3;
                    break;
                } else {
                    Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition error");
                    AppMethodBeat.o(195936);
                    return;
                }
                break;
            case 620757041:
                pi piVar = a2.gAD().Nga.KUf.get(0).KWy.get(0);
                if (piVar != null) {
                    pJq.pJB = piVar;
                    pJq.akb = a2.gAD().Nga.KUf.size();
                    B b4 = oVar.second;
                    if (!(b4 instanceof ViewGroup)) {
                        b4 = null;
                    }
                    aiK = aiK(r);
                    b2 = b4;
                    break;
                } else {
                    Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition reccard error");
                    AppMethodBeat.o(195936);
                    return;
                }
            case 637534257:
                pJq.d(null);
                b2 = null;
                aiK = "";
                break;
            default:
                if (a2.gAs()) {
                    dkr dkr = a2.NQr;
                    if ((dkr != null ? dkr.MOG : null) != null) {
                        pJq.akb = a2.NQr.MOG.size();
                        B b5 = oVar.second;
                        if (!(b5 instanceof ViewGroup)) {
                            b5 = null;
                        }
                        aiK = aiK(r);
                        b2 = b5;
                        break;
                    }
                }
                b2 = null;
                aiK = "";
                break;
        }
        if (pJw.contains(r)) {
            Log.i("MicroMsg.MPVideoPreviewMgr", "checkPosition in blacklist");
            AppMethodBeat.o(195936);
            return;
        }
        if (a2.gAs()) {
            i2 = com.tencent.mm.plugin.brandservice.ui.timeline.b.prt;
        } else {
            i2 = com.tencent.mm.plugin.brandservice.ui.timeline.b.prs;
        }
        if (((com.tencent.mm.storage.z) a2).field_type == 637534257) {
            cqK();
            BM(((com.tencent.mm.storage.z) a2).field_msgId);
            WeakReference<ad> weakReference2 = pJx.get(Long.valueOf(((com.tencent.mm.storage.z) a2).field_msgId));
            if (weakReference2 == null || (adVar = weakReference2.get()) == null) {
                AppMethodBeat.o(195936);
                return;
            }
            adVar.setVideoStatus(1);
            AppMethodBeat.o(195936);
            return;
        }
        if (((com.tencent.mm.storage.z) a2).field_type == 285212721 || ((com.tencent.mm.storage.z) a2).field_type == 620757041 || a2.gAs()) {
            if (b2 == null || b2.getContext() == null || Util.isNullOrNil(aiK)) {
                Log.i("MicroMsg.MPVideoPreviewMgr", "startPreview parent null or url = ".concat(String.valueOf(aiK)));
                AppMethodBeat.o(195936);
                return;
            }
            cqJ();
            Context context = b2.getContext();
            WeakReference<ViewGroup> weakReference3 = pJk;
            boolean j2 = p.j(context, (weakReference3 == null || (viewGroup = weakReference3.get()) == null) ? null : viewGroup.getContext());
            WeakReference<ViewGroup> weakReference4 = pJk;
            boolean j3 = p.j(b2, weakReference4 != null ? weakReference4.get() : null);
            boolean j4 = p.j(pJs, r);
            StringBuilder append = new StringBuilder("startPreview sameContext = ").append(j2).append(", sameParent = ").append(j3).append(", sameVid = ").append(j4).append(", visible = ");
            WeakReference<AppBrandVideoView> weakReference5 = pJm;
            if (!(weakReference5 == null || (appBrandVideoView7 = weakReference5.get()) == null)) {
                num = Integer.valueOf(appBrandVideoView7.getVisibility());
            }
            Log.i("MicroMsg.MPVideoPreviewMgr", append.append(num).toString());
            if (!j2 || !j3 || !j4) {
                Context context2 = b2.getContext();
                Boolean valueOf = Boolean.valueOf(j2);
                p.g(context2, "context");
                g.pJS.invoke(valueOf, context2);
                f.pJR.d(Boolean.valueOf(j3), b2, Integer.valueOf(i2));
                if (!(j4 || (weakReference = pJm) == null || (appBrandVideoView6 = weakReference.get()) == null)) {
                    appBrandVideoView6.pause();
                }
                pJr = true;
                WeakReference<View> weakReference6 = pJl;
                if (!(weakReference6 == null || (view = weakReference6.get()) == null)) {
                    view.setAlpha(0.0f);
                }
                pJq.pJI = System.currentTimeMillis();
                pJq.pJD = String.valueOf(System.currentTimeMillis());
                pJq.aiO("PREPARE");
                pJs = r;
                WeakReference<AppBrandVideoView> weakReference7 = pJm;
                if (!(weakReference7 == null || (appBrandVideoView5 = weakReference7.get()) == null)) {
                    appBrandVideoView5.setAutoPlay(true);
                }
                WeakReference<AppBrandVideoView> weakReference8 = pJm;
                if (!(weakReference8 == null || (appBrandVideoView4 = weakReference8.get()) == null)) {
                    appBrandVideoView4.setMute(true);
                }
                WeakReference<AppBrandVideoView> weakReference9 = pJm;
                if (!(weakReference9 == null || (appBrandVideoView3 = weakReference9.get()) == null)) {
                    appBrandVideoView3.setLoop(true);
                }
                WeakReference<AppBrandVideoView> weakReference10 = pJm;
                if (!(weakReference10 == null || (appBrandVideoView2 = weakReference10.get()) == null)) {
                    appBrandVideoView2.e(aiK, false, 0);
                }
                WeakReference<AppBrandVideoView> weakReference11 = pJm;
                if (!(weakReference11 == null || (appBrandVideoView = weakReference11.get()) == null)) {
                    appBrandVideoView.start();
                    AppMethodBeat.o(195936);
                    return;
                }
            } else {
                Log.i("MicroMsg.MPVideoPreviewMgr", "startPreview replay");
                AppMethodBeat.o(195936);
                return;
            }
        }
        AppMethodBeat.o(195936);
    }

    private static /* synthetic */ void cqJ() {
        AppMethodBeat.i(195938);
        BM(0);
        AppMethodBeat.o(195938);
    }

    private static void BM(long j2) {
        ad adVar;
        AppMethodBeat.i(195937);
        Log.i("MicroMsg.MPVideoPreviewMgr", "stopPreviewAd except = ".concat(String.valueOf(j2)));
        for (Map.Entry<Long, WeakReference<ad>> entry : pJx.entrySet()) {
            if (!(entry.getKey().longValue() == j2 || (adVar = entry.getValue().get()) == null)) {
                adVar.setVideoStatus(3);
            }
        }
        AppMethodBeat.o(195937);
    }

    public static void cqK() {
        long j2;
        int i2;
        View view;
        WeakReference<AppBrandVideoView> weakReference;
        AppBrandVideoView appBrandVideoView;
        AppBrandVideoView appBrandVideoView2;
        AppBrandVideoView appBrandVideoView3;
        AppBrandVideoView appBrandVideoView4;
        AppBrandVideoView appBrandVideoView5;
        AppMethodBeat.i(195939);
        Log.i("MicroMsg.MPVideoPreviewMgr", "stopPreviewVideo");
        a aVar = pJq;
        WeakReference<AppBrandVideoView> weakReference2 = pJm;
        if (weakReference2 == null || (appBrandVideoView5 = weakReference2.get()) == null) {
            j2 = 0;
        } else {
            j2 = (long) appBrandVideoView5.getCurrPosMs();
        }
        aVar.pJH = j2;
        pJq.pl(4);
        pJq.pJA = null;
        pJq.d(null);
        pJq.aiO("IDLE");
        WeakReference<AppBrandVideoView> weakReference3 = pJm;
        if (!(weakReference3 == null || (appBrandVideoView4 = weakReference3.get()) == null)) {
            appBrandVideoView4.setAutoPlay(false);
        }
        WeakReference<AppBrandVideoView> weakReference4 = pJm;
        if (!(weakReference4 == null || (appBrandVideoView3 = weakReference4.get()) == null)) {
            appBrandVideoView3.pause();
        }
        WeakReference<AppBrandVideoView> weakReference5 = pJm;
        if (weakReference5 == null || (appBrandVideoView2 = weakReference5.get()) == null) {
            i2 = 0;
        } else {
            i2 = appBrandVideoView2.getCurrPosSec();
        }
        if (!(i2 <= 0 || (weakReference = pJm) == null || (appBrandVideoView = weakReference.get()) == null)) {
            appBrandVideoView.bIX();
        }
        WeakReference<View> weakReference6 = pJl;
        if (!(weakReference6 == null || (view = weakReference6.get()) == null)) {
            view.setAlpha(0.0f);
        }
        pJs = "";
        stopTimer();
        AppMethodBeat.o(195939);
    }

    public static void startTimer() {
        AppMethodBeat.i(195940);
        if (pJp == null) {
            pJp = new MTimerHandler(h.pJU, true);
        }
        MTimerHandler mTimerHandler = pJp;
        if (mTimerHandler != null) {
            mTimerHandler.stopTimer();
        }
        MTimerHandler mTimerHandler2 = pJp;
        if (mTimerHandler2 != null) {
            mTimerHandler2.startTimer(1000);
            AppMethodBeat.o(195940);
            return;
        }
        AppMethodBeat.o(195940);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    public static final class h implements MTimerHandler.CallBack {
        public static final h pJU = new h();

        static {
            AppMethodBeat.i(195934);
            AppMethodBeat.o(195934);
        }

        h() {
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            TextView textView;
            int i2;
            AppBrandVideoView appBrandVideoView;
            AppBrandVideoView appBrandVideoView2;
            int i3 = 0;
            AppMethodBeat.i(195933);
            MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
            WeakReference weakReference = MPVideoPreviewMgr.pJo;
            if (!(weakReference == null || (textView = (TextView) weakReference.get()) == null)) {
                MPVideoPreviewMgr mPVideoPreviewMgr2 = MPVideoPreviewMgr.pJz;
                WeakReference weakReference2 = MPVideoPreviewMgr.pJm;
                if (weakReference2 == null || (appBrandVideoView2 = (AppBrandVideoView) weakReference2.get()) == null) {
                    i2 = 0;
                } else {
                    i2 = appBrandVideoView2.getDuration();
                }
                MPVideoPreviewMgr mPVideoPreviewMgr3 = MPVideoPreviewMgr.pJz;
                WeakReference weakReference3 = MPVideoPreviewMgr.pJm;
                if (!(weakReference3 == null || (appBrandVideoView = (AppBrandVideoView) weakReference3.get()) == null)) {
                    i3 = appBrandVideoView.getCurrPosMs();
                }
                p.g(textView, LocaleUtil.ITALIAN);
                String rJ = com.tencent.mm.ag.m.rJ(((i2 * 1000) - i3) / 1000);
                textView.setText(rJ != null ? rJ : "");
            }
            AppMethodBeat.o(195933);
            return true;
        }
    }

    public static void stopTimer() {
        AppMethodBeat.i(195941);
        MTimerHandler mTimerHandler = pJp;
        if (mTimerHandler != null) {
            mTimerHandler.stopTimer();
            AppMethodBeat.o(195941);
            return;
        }
        AppMethodBeat.o(195941);
    }

    public static void aiH(String str) {
        AppMethodBeat.i(195942);
        if (!pJj) {
            AppMethodBeat.o(195942);
        } else if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(195942);
        } else {
            pJq.aiO(str);
            AppMethodBeat.o(195942);
        }
    }

    public static void aiI(String str) {
        AppBrandVideoView appBrandVideoView;
        long j2;
        AppBrandVideoView appBrandVideoView2;
        AppBrandVideoView appBrandVideoView3;
        AppMethodBeat.i(195943);
        if (!pJj) {
            AppMethodBeat.o(195943);
        } else if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(195943);
        } else {
            Log.i("MicroMsg.MPVideoPreviewMgr", "triggerEvent status = " + pJq.pJC + ", event = " + str);
            String str2 = pJq.pJC;
            if (str2 != null) {
                switch (str2.hashCode()) {
                    case -103903604:
                        if (str2.equals("PAUSE_FOR_RESUME")) {
                            if (str == null) {
                                AppMethodBeat.o(195943);
                                return;
                            }
                            switch (str.hashCode()) {
                                case -1132223796:
                                    if (str.equals("ONRESUME") && !Util.isNullOrNil(pJs)) {
                                        WeakReference<AppBrandVideoView> weakReference = pJm;
                                        if (!(weakReference == null || (appBrandVideoView = weakReference.get()) == null)) {
                                            appBrandVideoView.start();
                                        }
                                        pJq.pJI = System.currentTimeMillis();
                                        pJq.pJJ = System.currentTimeMillis();
                                        pJq.pJD = String.valueOf(System.currentTimeMillis());
                                        aiH("PLAY");
                                        pJq.pl(2);
                                        break;
                                    }
                                case -592677033:
                                    if (str.equals("ONPAUSE") && !Util.isNullOrNil(pJs)) {
                                        WeakReference<AppBrandVideoView> weakReference2 = pJm;
                                        if (!(weakReference2 == null || (appBrandVideoView3 = weakReference2.get()) == null)) {
                                            appBrandVideoView3.pause();
                                        }
                                        a aVar = pJq;
                                        WeakReference<AppBrandVideoView> weakReference3 = pJm;
                                        if (weakReference3 == null || (appBrandVideoView2 = weakReference3.get()) == null) {
                                            j2 = 0;
                                        } else {
                                            j2 = (long) appBrandVideoView2.getCurrPosMs();
                                        }
                                        aVar.pJH = j2;
                                        pJq.pl(4);
                                        AppMethodBeat.o(195943);
                                        return;
                                    }
                                    break;
                            }
                            AppMethodBeat.o(195943);
                            return;
                        }
                        break;
                }
            }
            if (str == null) {
                AppMethodBeat.o(195943);
                return;
            }
            switch (str.hashCode()) {
                case -1132223796:
                    if (str.equals("ONRESUME")) {
                        AppMethodBeat.o(195943);
                        return;
                    }
                    break;
                case -592677033:
                    if (str.equals("ONPAUSE") && !Util.isNullOrNil(pJs)) {
                        MMHandlerThread.postToMainThreadDelayed(e.pJQ, 500);
                        break;
                    }
            }
            AppMethodBeat.o(195943);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        public static final e pJQ = new e();

        static {
            AppMethodBeat.i(195924);
            AppMethodBeat.o(195924);
        }

        e() {
        }

        public final void run() {
            AppMethodBeat.i(195923);
            MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
            MPVideoPreviewMgr.cqT();
            AppMethodBeat.o(195923);
        }
    }

    private static void J(LinkedList<o<com.tencent.mm.storage.z, View>> linkedList) {
        AppMethodBeat.i(195944);
        HashSet<String> hashSet = new HashSet<>();
        Iterator<T> it = linkedList.iterator();
        while (it.hasNext()) {
            String r = r(it.next().first);
            if (pJw.contains(r)) {
                hashSet.add(r);
                Log.i("MicroMsg.MPVideoPreviewMgr", "removeBlackList still vid = ".concat(String.valueOf(r)));
            }
        }
        pJw = hashSet;
        AppMethodBeat.o(195944);
    }

    public static void aiJ(String str) {
        long j2;
        AppBrandVideoView appBrandVideoView;
        AppBrandVideoWrapper appBrandVideoWrapper;
        Bitmap bitmap;
        TextureView texture;
        AppMethodBeat.i(195945);
        if (!pJj) {
            AppMethodBeat.o(195945);
        } else if (Util.isNullOrNil(pJs)) {
            AppMethodBeat.o(195945);
        } else {
            if (p.j(pJs, str)) {
                WeakReference<AppBrandVideoWrapper> weakReference = pJn;
                if (weakReference == null || (appBrandVideoWrapper = weakReference.get()) == null) {
                    AppMethodBeat.o(195945);
                    return;
                }
                p.g(appBrandVideoWrapper, "weakVideoWrapper?.get() ?: return");
                com.tencent.mm.plugin.webview.ui.tools.video.a aVar = com.tencent.mm.plugin.webview.ui.tools.video.a.JxN;
                String str2 = pJs;
                int currPosSec = appBrandVideoWrapper.getCurrPosSec();
                int currentTimeMillis = (int) ((System.currentTimeMillis() / 1000) + 600);
                if (appBrandVideoWrapper == null || (texture = appBrandVideoWrapper.getTexture()) == null) {
                    bitmap = null;
                } else {
                    bitmap = texture.getBitmap();
                }
                com.tencent.mm.plugin.webview.ui.tools.video.a.a(str2, currPosSec, currentTimeMillis, bitmap);
                Log.i("MicroMsg.MPVideoPreviewMgr", "addBlackList vid = ".concat(String.valueOf(str)));
                pJw.add(str);
            }
            a aVar2 = pJq;
            WeakReference<AppBrandVideoView> weakReference2 = pJm;
            if (weakReference2 == null || (appBrandVideoView = weakReference2.get()) == null) {
                j2 = 0;
            } else {
                j2 = (long) appBrandVideoView.getCurrPosMs();
            }
            aVar2.pJH = j2;
            pJq.pl(4);
            pJq.pl(3);
            pJq.pJA = null;
            pJq.d(null);
            aiH("IDLE");
            AppMethodBeat.o(195945);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0164, code lost:
        r1 = r4.Mjm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0166, code lost:
        if (r1 == null) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0168, code lost:
        r1 = r1.KSu;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0172, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(aiK(r1)) == false) goto L_0x018f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0174, code lost:
        r3 = com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr.pJy;
        r1 = r4.Mjm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0178, code lost:
        if (r1 == null) goto L_0x019c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x017a, code lost:
        r1 = r1.KSu;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x017c, code lost:
        if (r1 != null) goto L_0x0181;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x017e, code lost:
        kotlin.g.b.p.hyc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0181, code lost:
        r3.add(r1);
        r1 = r4.Mjm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0186, code lost:
        if (r1 == null) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0188, code lost:
        r2 = r1.KSu;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x018a, code lost:
        r0.invoke(r2, r4.KSj);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x018f, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(195946);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x019a, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x019c, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x009e, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(aiK(r1.vid)) == false) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a0, code lost:
        com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr.pJy.add(r1.vid);
        r0.invoke(r1.vid, r1.url);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0123, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(aiK(r1.KSu)) == false) goto L_0x0133;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0125, code lost:
        com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr.pJy.add(r1.KSu);
        r0.invoke(r1.KSu, r1.KSj);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0133, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(195946);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void q(com.tencent.mm.storage.z r7) {
        /*
        // Method dump skipped, instructions count: 430
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr.q(com.tencent.mm.storage.z):void");
    }

    private static String aiK(String str) {
        String str2;
        AppMethodBeat.i(195947);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.MPVideoPreviewMgr", "getPlayUrl vid null");
            AppMethodBeat.o(195947);
            return "";
        }
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) pJv.getSlot();
        String decodeString = multiProcessMMKV.decodeString("MicroMsg.MPVideoPreviewMgr_" + str + "_url");
        if (!Util.isNullOrNil(decodeString)) {
            if (System.currentTimeMillis() - multiProcessMMKV.decodeLong("MicroMsg.MPVideoPreviewMgr_" + str + XWalkEnvironment.SP_KEY_FILE_READER_POSTFIX_TIME) > 14400000) {
                Log.i("MicroMsg.MPVideoPreviewMgr", "getPlayUrl expire");
                str2 = "";
                Log.i("MicroMsg.MPVideoPreviewMgr", "getPlayUrl vid = " + str + ", url = " + str2);
                AppMethodBeat.o(195947);
                return str2;
            }
        }
        str2 = decodeString;
        Log.i("MicroMsg.MPVideoPreviewMgr", "getPlayUrl vid = " + str + ", url = " + str2);
        AppMethodBeat.o(195947);
        return str2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u001f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0014J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0014J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0002J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020\u000eH\u0016J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000bH\u0016J\b\u0010#\u001a\u00020\u000eH\u0016J\u000e\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u0018J\u000e\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020(J\b\u0010)\u001a\u00020\u000eH\u0002J\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0010\u0010-\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010.\u001a\u00020\u000eH\u0016J\u0010\u0010/\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020(H\u0016J\u0006\u00100\u001a\u00020\u000eJ\u0010\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u0018H\u0016J\u0010\u00103\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u00104\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u0018H\u0016J\u0010\u00106\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u00107\u001a\u00020\u000e2\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020\u000eH\u0002J\u0010\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u0018H\u0016J\b\u0010=\u001a\u00020\u000eH\u0002J\b\u0010>\u001a\u00020\u000eH\u0002J\u0010\u0010?\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020\u0018H\u0016J\u0010\u0010A\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\u0018H\u0016J\u0010\u0010C\u001a\u00020\u000e2\u0006\u0010D\u001a\u00020\u0018H\u0016J\u0010\u0010E\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020\u0018H\u0016J\u0010\u0010G\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\u0018H\u0016J\u0010\u0010I\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020\u0018H\u0016J\u0010\u0010K\u001a\u00020\u000e2\u0006\u0010L\u001a\u00020MH\u0016J\b\u0010N\u001a\u00020\u000eH\u0002J\u0010\u0010O\u001a\u00020\u000e2\u0006\u0010P\u001a\u00020QH\u0016J\u0010\u0010R\u001a\u00020\u000e2\u0006\u0010S\u001a\u00020\u000bH\u0016J\u0010\u0010T\u001a\u00020\u000e2\u0006\u0010U\u001a\u00020\u000bH\u0016J\b\u0010V\u001a\u00020\u000eH\u0016J\b\u0010W\u001a\u00020\u000eH\u0002J\b\u0010X\u001a\u00020\u000eH\u0016J\b\u0010Y\u001a\u00020\u000eH\u0002J\b\u0010Z\u001a\u00020\u000eH\u0016J\b\u0010[\u001a\u00020\u000eH\u0016J\b\u0010\\\u001a\u00020\u000eH\u0002J\b\u0010]\u001a\u00020\u0018H\u0002J\u0018\u0010^\u001a\u00020\u000e2\u0006\u0010_\u001a\u00020\u000b2\u0006\u0010`\u001a\u00020\u000bH\u0004J\u0010\u0010a\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u0018H\u0016¨\u0006b"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$EmptyControlBar;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/progressbar/VideoPlayerSeekBar;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IControlBar;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IMMVideoFooter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "addOnVisibilityChangedListener", "", "onVisibilityChangedListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$OnControlbarVisibilityChangedListener;", "enterFullScreen", "flowShow", "getLayoutId", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "hideCenterPlayBtnIfNeed", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "isAutoHide", "", "isControlProgressShowing", "isDanmakuBtnOpen", "isFullScreenState", "isShow", "onDestroy", "onFullScreenChange", "quitFullScreen", "resetAutoHideTimer", "seek", "position", "seekForPoint", "setAutoHide", "autoHide", "setBtnCloseListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View$OnClickListener;", "setDanmakuBtnIcon", "setDanmakuBtnOnClickListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$OnDanmakuBtnOnClickListener;", "setDanmakuBtnOpen", "setExitFullScreenBtnOnClickListener", "setFullScreenBtn", "setFullScreenBtnOnClickListener", "setFullScreenTitleBar", "setIsPlay", "isPlay", "setMuteBtnOnClickListener", "setMuteBtnState", "isMute", "setOnPlayButtonClickListener", "setOnUpdateProgressLenListener", "onUpdateProgressLenListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$OnControlbarProgressChangedListener;", "setPlayBtn", "setPlayBtnInCenterPosition", "playBtnInCenterPosition", "setPlayBtnState", "setRootLayout", "setShowControlProgress", "showControlProgress", "setShowDanmakuBtn", "show", "setShowFullScreenBtn", "showFullScreenBtn", "setShowMuteBtn", "showMuteBtn", "setShowPlayBtn", "showPlayBtn", "setShowProgress", "showProgress", "setStatePorter", "porter", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$StatePorter;", "setTimeTextSize", "setTitle", "title", "", "setVideoTotalTime", "seconds", "setVisibility", "visibility", "showCenterPlayBtnIfNeed", "showControlProgressInternal", "stopCacheUpdate", "toggleDanmakuBtn", "toggleShow", "triggerCacheUpdate", "updateLayoutMargins", "updateMiddleBar", "updateProgress", "progressLen", "totalLen", "updateVideoStatus", "plugin-brandservice_release"})
    public static final class EmptyControlBar extends VideoPlayerSeekBar implements e.a, e.b {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EmptyControlBar(Context context) {
            super(context);
            p.h(context, "context");
            AppMethodBeat.i(195908);
            AppMethodBeat.o(195908);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EmptyControlBar(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            p.h(context, "context");
            p.h(attributeSet, "attrs");
            AppMethodBeat.i(195909);
            AppMethodBeat.o(195909);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EmptyControlBar(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            p.h(context, "context");
            p.h(attributeSet, "attrs");
            AppMethodBeat.i(195910);
            AppMethodBeat.o(195910);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void setStatePorter(e.i iVar) {
            AppMethodBeat.i(195898);
            p.h(iVar, "porter");
            AppMethodBeat.o(195898);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void onDestroy() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar
        public final int getLayoutId() {
            return R.layout.l8;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar
        public final void init() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar, com.tencent.mm.plugin.appbrand.jsapi.video.e.b
        public final void setVideoTotalTime(int i2) {
        }

        public final void setBtnCloseListener(View.OnClickListener onClickListener) {
            AppMethodBeat.i(195899);
            p.h(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            AppMethodBeat.o(195899);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void setMuteBtnOnClickListener(View.OnClickListener onClickListener) {
            AppMethodBeat.i(195900);
            p.h(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            AppMethodBeat.o(195900);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void setExitFullScreenBtnOnClickListener(View.OnClickListener onClickListener) {
            AppMethodBeat.i(195901);
            p.h(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            AppMethodBeat.o(195901);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void setOnPlayButtonClickListener(View.OnClickListener onClickListener) {
            AppMethodBeat.i(195902);
            p.h(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            AppMethodBeat.o(195902);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void setTitle(String str) {
            AppMethodBeat.i(195903);
            p.h(str, "title");
            AppMethodBeat.o(195903);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void setShowMuteBtn(boolean z) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void setMuteBtnState(boolean z) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void setShowControlProgress(boolean z) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void setPlayBtnInCenterPosition(boolean z) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void bIZ() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void bJC() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar, com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void setIsPlay(boolean z) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar, com.tencent.mm.plugin.appbrand.jsapi.video.e.b
        public final void hP(boolean z) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void setFullScreenBtnOnClickListener(View.OnClickListener onClickListener) {
            AppMethodBeat.i(195904);
            p.h(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            AppMethodBeat.o(195904);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void setDanmakuBtnOnClickListener(e.g gVar) {
            AppMethodBeat.i(195905);
            p.h(gVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            AppMethodBeat.o(195905);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final boolean bJt() {
            return false;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void setDanmakuBtnOpen(boolean z) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void setShowDanmakuBtn(boolean z) {
        }

        public final void setAutoHide(boolean z) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void bJv() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void bJB() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void hide() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final boolean bJw() {
            return false;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void bJu() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void KD() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void bGL() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final boolean bJx() {
            return false;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final boolean bJy() {
            return true;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void bJz() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void bJA() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar, com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void seek(int i2) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar
        public final void bKO() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void setShowFullScreenBtn(boolean z) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void setShowPlayBtn(boolean z) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void setShowProgress(boolean z) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final boolean bJD() {
            return false;
        }

        public final void setVisibility(int i2) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void setOnUpdateProgressLenListener(e.AbstractC0717e eVar) {
            AppMethodBeat.i(195906);
            p.h(eVar, "onUpdateProgressLenListener");
            AppMethodBeat.o(195906);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
        public final void a(e.f fVar) {
            AppMethodBeat.i(195907);
            p.h(fVar, "onVisibilityChangedListener");
            AppMethodBeat.o(195907);
        }
    }

    public static int aiL(String str) {
        int i2;
        AppMethodBeat.i(195948);
        if (!Util.isNullOrNil(str)) {
            Integer num = pJq.pJF.get(str);
            i2 = num != null ? num.intValue() : 0;
        } else {
            i2 = 0;
        }
        AppMethodBeat.o(195948);
        return i2;
    }

    public static int aiM(String str) {
        int i2;
        AppMethodBeat.i(195949);
        if (!Util.isNullOrNil(str)) {
            Integer num = pJq.pJG.get(str);
            i2 = num != null ? num.intValue() : 0;
        } else {
            i2 = 0;
        }
        AppMethodBeat.o(195949);
        return i2;
    }

    public static String aiN(String str) {
        AppMethodBeat.i(195950);
        if (!pJj) {
            AppMethodBeat.o(195950);
            return "";
        }
        String str2 = "";
        if (p.j(pJs, str)) {
            str2 = pJq.pJD;
        }
        AppMethodBeat.o(195950);
        return str2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001KB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010G\u001a\u00020HJ\u000e\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR:\u0010\t\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u000b0\nj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u000b`\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR:\u0010#\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u000b0\nj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u000b`\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010\u0010R(\u0010(\u001a\u0004\u0018\u00010'2\b\u0010&\u001a\u0004\u0018\u00010'@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001a\"\u0004\b4\u0010\u001cR\u001a\u00105\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001a\"\u0004\b7\u0010\u001cR\u001c\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R(\u0010>\u001a\u0004\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0006\"\u0004\b@\u0010\bR6\u0010A\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b`\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u000e\"\u0004\bC\u0010\u0010R$\u0010D\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010/\"\u0004\bF\u00101¨\u0006L"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$PreviewInfo;", "", "()V", "autoPlayId", "", "getAutoPlayId", "()Ljava/lang/String;", "setAutoPlayId", "(Ljava/lang/String;)V", "autoPlayTime", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getAutoPlayTime", "()Ljava/util/HashMap;", "setAutoPlayTime", "(Ljava/util/HashMap;)V", "bizInfo", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "getBizInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "setBizInfo", "(Lcom/tencent/mm/storage/BizTimeLineInfo;)V", "bufferEnd", "", "getBufferEnd", "()J", "setBufferEnd", "(J)V", "bufferStart", "getBufferStart", "setBufferStart", "curPosMs", "getCurPosMs", "setCurPosMs", "hasAutoPlay", "getHasAutoPlay", "setHasAutoPlay", "value", "Lcom/tencent/mm/message/BizReaderItem;", "item", "getItem", "()Lcom/tencent/mm/message/BizReaderItem;", "setItem", "(Lcom/tencent/mm/message/BizReaderItem;)V", "itemCount", "getItemCount", "()I", "setItemCount", "(I)V", "prepareEnd", "getPrepareEnd", "setPrepareEnd", "prepareStart", "getPrepareStart", "setPrepareStart", "recAppMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "getRecAppMsg", "()Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "setRecAppMsg", "(Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;)V", "status", "getStatus", "setStatus", "vidToPos", "getVidToPos", "setVidToPos", "videoDuration", "getVideoDuration", "setVideoDuration", "destroy", "", "report", "event", "Status", "plugin-brandservice_release"})
    public static final class a {
        public int akb;
        private v iAi;
        public com.tencent.mm.storage.z pJA;
        pi pJB;
        String pJC = "IDLE";
        public String pJD = "";
        public HashMap<String, Integer> pJE = new HashMap<>();
        HashMap<String, Integer> pJF = new HashMap<>();
        HashMap<String, Integer> pJG = new HashMap<>();
        public long pJH;
        public long pJI;
        public long pJJ;
        public long pJK;
        public long pJL;
        private int videoDuration;

        public a() {
            AppMethodBeat.i(195914);
            AppMethodBeat.o(195914);
        }

        public final void d(v vVar) {
            AppMethodBeat.i(195911);
            this.iAi = vVar;
            if (vVar != null) {
                this.pJF.put(vVar.vid, 1);
                AppMethodBeat.o(195911);
                return;
            }
            this.akb = 0;
            AppMethodBeat.o(195911);
        }

        public final void aiO(String str) {
            AppMethodBeat.i(195912);
            this.pJC = str;
            Log.i("MicroMsg.MPVideoPreviewMgr", "PreviewInfo status = ".concat(String.valueOf(str)));
            AppMethodBeat.o(195912);
        }

        public final void setVideoDuration(int i2) {
            this.videoDuration = i2 * 1000;
        }

        public final void pl(int i2) {
            String str;
            String str2 = null;
            AppMethodBeat.i(195913);
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o oVar = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.pLS;
            com.tencent.mm.storage.z zVar = this.pJA;
            if (zVar != null) {
                MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
                str = MPVideoPreviewMgr.t(zVar);
            } else {
                str = null;
            }
            com.tencent.mm.storage.z zVar2 = this.pJA;
            if (zVar2 != null) {
                MPVideoPreviewMgr mPVideoPreviewMgr2 = MPVideoPreviewMgr.pJz;
                str2 = MPVideoPreviewMgr.u(zVar2);
            }
            if (!Util.isNullOrNil(str) && !Util.isNullOrNil(str2)) {
                com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.setEventType(i2);
                com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.setVid(str);
                com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.aiV(str2);
                com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.aiU(this.pJD);
                Integer num = this.pJE.get(str);
                com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.DT(num != null ? num.intValue() : 0);
                com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.BP((long) this.videoDuration);
                com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.BQ(0);
                com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.BO(0);
                switch (i2) {
                    case 1:
                        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.BQ(this.pJJ - this.pJI);
                        break;
                    case 3:
                        if (this.pJJ != 0) {
                            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.BO(System.currentTimeMillis() - this.pJJ);
                            break;
                        }
                        break;
                    case 4:
                        if (this.pJJ != 0) {
                            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.BO(System.currentTimeMillis() - this.pJJ);
                            this.pJG.put(str, Integer.valueOf((int) com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.crc()));
                            break;
                        }
                        break;
                    case 5:
                        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.BQ(this.pJL - this.pJK);
                        if (this.pJJ != 0) {
                            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.BO(System.currentTimeMillis() - this.pJJ);
                            break;
                        }
                        break;
                }
                com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.report();
            }
            AppMethodBeat.o(195913);
        }
    }

    private static String r(com.tencent.mm.storage.z zVar) {
        dkr dkr;
        LinkedList<dlb> linkedList;
        dlb dlb;
        cdu cdu;
        eqv eqv;
        LinkedList<dlb> linkedList2;
        dlb dlb2;
        cdu cdu2;
        eqv eqv2;
        AppMethodBeat.i(195951);
        String str = "";
        if (zVar.gAs()) {
            dkr dkr2 = zVar.NQr;
            if (dkr2 == null || (linkedList2 = dkr2.MOG) == null || (dlb2 = linkedList2.get(0)) == null || (cdu2 = dlb2.MOY) == null || (eqv2 = cdu2.Mjm) == null || (str = eqv2.KSu) == null) {
                str = "";
            }
            AppMethodBeat.o(195951);
        } else {
            switch (zVar.field_type) {
                case 285212721:
                    v s = s(zVar);
                    if (s == null || (str = s.vid) == null) {
                        str = "";
                        break;
                    }
                case 620757041:
                    if (zVar.gAD() != null) {
                        switch (zVar.gAD().style) {
                            case 101:
                            case 102:
                                str = zVar.gAD().Nga.KUf.get(0).KWy.get(0).KSu;
                                p.g(str, "this.tlRecCardWrapper.ex…Info[0].AppMsg[0].VideoId");
                                break;
                        }
                    }
                    break;
                case 637534257:
                    str = zVar.gAG();
                    if (str == null) {
                        str = "";
                        break;
                    }
                    break;
                default:
                    if (zVar.gAs() && ((dkr = zVar.NQr) == null || (linkedList = dkr.MOG) == null || (dlb = linkedList.get(0)) == null || (cdu = dlb.MOY) == null || (eqv = cdu.Mjm) == null || (str = eqv.KSu) == null)) {
                        str = "";
                        break;
                    }
            }
            AppMethodBeat.o(195951);
        }
        return str;
    }

    private static v s(com.tencent.mm.storage.z zVar) {
        LinkedList linkedList;
        v vVar;
        AppMethodBeat.i(195952);
        u a2 = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(zVar.field_msgId, zVar.field_content);
        if (a2 == null || a2 == null || (linkedList = a2.iAd) == null || (vVar = (v) linkedList.get(0)) == null || vVar.type != 5) {
            AppMethodBeat.o(195952);
            return null;
        }
        AppMethodBeat.o(195952);
        return vVar;
    }

    public static void a(com.tencent.mm.storage.z zVar, ad adVar) {
        AppMethodBeat.i(195953);
        p.h(zVar, "info");
        p.h(adVar, "cardTmpl");
        if (!pJj) {
            AppMethodBeat.o(195953);
            return;
        }
        pJx.put(Long.valueOf(zVar.field_msgId), new WeakReference<>(adVar));
        AppMethodBeat.o(195953);
    }

    public static void a(com.tencent.mm.storage.z zVar, String str) {
        com.tencent.mm.storage.z zVar2;
        AppMethodBeat.i(195954);
        p.h(zVar, "info");
        p.h(str, "extra");
        if (!pJj) {
            AppMethodBeat.o(195954);
            return;
        }
        d dVar = new d(str, zVar);
        switch (zVar.field_type) {
            case 285212721:
                switch (str.hashCode()) {
                    default:
                        AppMethodBeat.o(195954);
                        return;
                    case -103903604:
                        if (str.equals("PAUSE_FOR_RESUME")) {
                            aiH("PAUSE_FOR_RESUME");
                            AppMethodBeat.o(195954);
                            return;
                        }
                        break;
                }
            case 620757041:
                dVar.invoke();
                AppMethodBeat.o(195954);
                return;
            case 637534257:
                BM(0);
                if (pJq.pJA != null && ((zVar2 = pJq.pJA) == null || zVar2.field_type != 637534257)) {
                    aiH("PAUSE_FOR_RESUME");
                    AppMethodBeat.o(195954);
                    return;
                }
            default:
                if (zVar.gAs()) {
                    dVar.invoke();
                    break;
                }
                break;
        }
        AppMethodBeat.o(195954);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"onClick", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ String pJP;
        final /* synthetic */ com.tencent.mm.storage.z prL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str, com.tencent.mm.storage.z zVar) {
            super(0);
            this.pJP = str;
            this.prL = zVar;
        }

        @Override // kotlin.g.a.a
        public final void invoke() {
            AppMethodBeat.i(195922);
            String str = this.pJP;
            switch (str.hashCode()) {
                case -103903604:
                    if (str.equals("PAUSE_FOR_RESUME")) {
                        MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
                        MPVideoPreviewMgr.aiH("PAUSE_FOR_RESUME");
                        AppMethodBeat.o(195922);
                        return;
                    }
                    break;
            }
            MPVideoPreviewMgr mPVideoPreviewMgr2 = MPVideoPreviewMgr.pJz;
            MPVideoPreviewMgr.aiJ(MPVideoPreviewMgr.t(this.prL));
            com.tencent.mm.plugin.webview.ui.tools.video.a aVar = com.tencent.mm.plugin.webview.ui.tools.video.a.JxN;
            MPVideoPreviewMgr mPVideoPreviewMgr3 = MPVideoPreviewMgr.pJz;
            com.tencent.mm.plugin.webview.ui.tools.video.a.bbi(MPVideoPreviewMgr.t(this.prL));
            AppMethodBeat.o(195922);
        }
    }

    public static final /* synthetic */ String u(com.tencent.mm.storage.z zVar) {
        AppMethodBeat.i(195957);
        String str = "";
        switch (zVar.field_type) {
            case 285212721:
                v s = s(zVar);
                if (s == null || (str = s.url) == null) {
                    str = "";
                    break;
                }
            case 620757041:
                if (zVar.gAD() != null) {
                    switch (zVar.gAD().style) {
                        case 101:
                        case 102:
                            str = zVar.gAD().Nga.KUf.get(0).KWy.get(0).KSj;
                            p.g(str, "this.tlRecCardWrapper.ex…o[0].AppMsg[0].ContentUrl");
                            break;
                    }
                }
                break;
            default:
                if (zVar.gAs()) {
                    str = zVar.NQr.MOG.get(0).MOY.KSj;
                    p.g(str, "this.recFeed.RecommendItem[0].ItemInfo.ContentUrl");
                    break;
                }
                break;
        }
        AppMethodBeat.o(195957);
        return str;
    }

    public static final /* synthetic */ String v(com.tencent.mm.storage.z zVar) {
        AppMethodBeat.i(195958);
        String str = "";
        switch (zVar.field_type) {
            case 285212721:
                v s = s(zVar);
                if (s == null || (str = s.title) == null) {
                    str = "";
                    break;
                }
            case 620757041:
                if (zVar.gAD() != null) {
                    switch (zVar.gAD().style) {
                        case 101:
                        case 102:
                            str = zVar.gAD().Nga.KUf.get(0).KWy.get(0).Title;
                            p.g(str, "this.tlRecCardWrapper.ex…izInfo[0].AppMsg[0].Title");
                            break;
                    }
                }
                break;
            default:
                if (zVar.gAs()) {
                    str = zVar.NQr.MOG.get(0).MOY.Title;
                    p.g(str, "this.recFeed.RecommendItem[0].ItemInfo.Title");
                    break;
                }
                break;
        }
        AppMethodBeat.o(195958);
        return str;
    }

    public static final /* synthetic */ void fn(String str, String str2) {
        AppMethodBeat.i(195960);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            Log.i("MicroMsg.MPVideoPreviewMgr", "setPlayUrl null");
            AppMethodBeat.o(195960);
            return;
        }
        Log.i("MicroMsg.MPVideoPreviewMgr", "setPlayUrl vid = " + str + ", url = " + str2);
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) pJv.getSlot();
        multiProcessMMKV.encode("MicroMsg.MPVideoPreviewMgr_" + str + "_url", str2);
        multiProcessMMKV.encode("MicroMsg.MPVideoPreviewMgr_" + str + XWalkEnvironment.SP_KEY_FILE_READER_POSTFIX_TIME, System.currentTimeMillis());
        AppMethodBeat.o(195960);
    }
}
