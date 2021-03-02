package com.tencent.mm.live.core.core.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.g.b.a.fq;
import com.tencent.mm.live.core.core.b.g;
import com.tencent.mm.live.core.core.c;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.live.core.core.trtc.a;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.au;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\n\b\u0016\u0018\u0000 Y2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001YB\u0005¢\u0006\u0002\u0010\u0004J=\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00142#\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J0\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\bH\u0016J\u001c\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010!\u001a\u00020\"2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001a\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010.H\u0002J\b\u0010/\u001a\u00020\u0017H\u0016J\b\u00100\u001a\u00020\u0017H\u0002J\b\u00101\u001a\u00020\u0017H\u0016J\b\u00102\u001a\u00020\u0017H\u0016J\b\u00103\u001a\u00020\u0013H\u0016J\b\u00104\u001a\u00020\u0013H\u0016J\"\u00105\u001a\u00020\u00132\u0006\u00106\u001a\u00020\r2\b\u00107\u001a\u0004\u0018\u00010(2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020\rH\u0016J*\u0010:\u001a\u00020\u00132\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\bH\u0016J\u0012\u0010?\u001a\u00020\u00132\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u001a\u0010B\u001a\u00020\u00132\u0006\u0010C\u001a\u00020\b2\b\u0010D\u001a\u0004\u0018\u00010AH\u0016J\u001a\u0010E\u001a\u00020\u00132\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010F\u001a\u00020\bH\u0016J\b\u0010G\u001a\u00020\u0013H\u0016J\u0006\u0010H\u001a\u00020\u0013J\b\u0010I\u001a\u00020\u0013H\u0016J\b\u0010J\u001a\u00020\u0013H\u0016J\u0012\u0010K\u001a\u00020\u00132\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\u0012\u0010N\u001a\u00020\b2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\b\u0010Q\u001a\u00020\bH\u0016J\b\u0010R\u001a\u00020\bH\u0016J\b\u0010S\u001a\u00020\bH\u0016J\b\u0010T\u001a\u00020\u0013H\u0016J\u0012\u0010U\u001a\u00020\u00132\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\"\u0010V\u001a\u00020\u00132\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\bH\u0002J\u0010\u0010W\u001a\u00020\u00132\b\u0010O\u001a\u0004\u0018\u00010PJ\u0018\u0010X\u001a\u00020\u00132\b\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010\u001e\u001a\u00020\u001fR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, hxF = {"Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "Lcom/tencent/mm/live/core/core/visitor/IMMLiveVisitorCore;", "Lcom/tencent/rtmp/ITXLivePlayListener;", "()V", "cdnPlayerManager", "Lcom/tencent/mm/live/core/core/LiveCdnPlayerManager;", "curPlayerStatus", "", "debugRunnable", "com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$debugRunnable$1", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$debugRunnable$1;", "lastSEIReportTimestamp", "", "playerView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "seiReportInterval", "streamType", "cdnStartPlay", "", "Lcom/tencent/mm/live/core/view/LiveVideoView;", "playCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "cdnStopPlay", "keepLastFrame", "enterRoom", "callback", "Lcom/tencent/mm/live/core/core/LiveCallback;", "floatMode", "context", "Landroid/content/Context;", "forceMoveTask", "dontFinish", "generateType", "opType", "getTXLivePlayer", "Lcom/tencent/rtmp/TXLivePlayer;", "outterConfig", "Lcom/tencent/rtmp/TXLivePlayConfig;", "handleSeiMessage", "seiMode", "seiData", "", "isAudioMicing", "isCdnMode", "isInLinkMic", "isVideoMicing", "makeRemotePreviewFullScreen", "normalMode", "onCdnPlayerAvailalbe", "liveId", "player", "onEnterRoom", "result", "onFirstVideoFrame", "userId", "", "width", "height", "onNetStatus", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/os/Bundle;", "onPlayEvent", "event", "param", "onRemoteUserLeaveRoom", "reason", "pauseRender", "refreshByOrientation", "release", "resumeRender", "setupLiveRoomInfo", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "startLinkMic", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "startPush", "stopLinkMic", "stopPush", "switchAudioLinkMic", "switchVideoLinkMic", "updateFillMode", "updatePreviewView", "visitRoom", "Companion", "plugin-core_release"})
public class b extends com.tencent.mm.live.core.core.trtc.a implements a, ITXLivePlayListener {
    private static b hCn;
    public static final a hCo = new a((byte) 0);
    private TXCloudVideoView hCj;
    private com.tencent.mm.live.core.core.d hCk = com.tencent.mm.live.core.core.d.hwY;
    private int hCl;
    private final RunnableC0382b hCm;
    public int streamType;
    private long uKy;
    private int uXo = 5;

    static {
        AppMethodBeat.i(196558);
        AppMethodBeat.o(196558);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
    public static final class e extends q implements kotlin.g.a.q<com.tencent.mm.live.core.b.l, Integer, Integer, x> {
        final /* synthetic */ b hCp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(b bVar) {
            super(3);
            this.hCp = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(com.tencent.mm.live.core.b.l lVar, Integer num, Integer num2) {
            AppMethodBeat.i(196527);
            final com.tencent.mm.live.core.b.l lVar2 = lVar;
            num.intValue();
            num2.intValue();
            p.h(lVar2, "surface");
            lVar2.hEC = new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.live.core.core.d.b.e.AnonymousClass1 */
                final /* synthetic */ e hCt;

                {
                    this.hCt = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(196525);
                    lVar2.hEC = null;
                    this.hCt.hCp.hAr.bO(lVar2.beb);
                    x xVar = x.SXb;
                    AppMethodBeat.o(196525);
                    return xVar;
                }
            };
            lVar2.hED = new m<Integer, Integer, x>(this) {
                /* class com.tencent.mm.live.core.core.d.b.e.AnonymousClass2 */
                final /* synthetic */ e hCt;

                {
                    this.hCt = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // kotlin.g.a.m
                public final /* synthetic */ x invoke(Integer num, Integer num2) {
                    AppMethodBeat.i(196526);
                    this.hCt.hCp.hAr.cX(num.intValue(), num2.intValue());
                    x xVar = x.SXb;
                    AppMethodBeat.o(196526);
                    return xVar;
                }
            };
            x xVar = x.SXb;
            AppMethodBeat.o(196527);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
    static final class f extends q implements kotlin.g.a.q<com.tencent.mm.live.core.b.l, Integer, Integer, x> {
        final /* synthetic */ b hCp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(b bVar) {
            super(3);
            this.hCp = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(com.tencent.mm.live.core.b.l lVar, Integer num, Integer num2) {
            AppMethodBeat.i(196530);
            final com.tencent.mm.live.core.b.l lVar2 = lVar;
            num.intValue();
            num2.intValue();
            p.h(lVar2, "surface");
            lVar2.hEC = new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.live.core.core.d.b.f.AnonymousClass1 */
                final /* synthetic */ f hCu;

                {
                    this.hCu = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(196528);
                    lVar2.hEC = null;
                    this.hCu.hCp.hAr.bO(lVar2.beb);
                    x xVar = x.SXb;
                    AppMethodBeat.o(196528);
                    return xVar;
                }
            };
            lVar2.hED = new m<Integer, Integer, x>(this) {
                /* class com.tencent.mm.live.core.core.d.b.f.AnonymousClass2 */
                final /* synthetic */ f hCu;

                {
                    this.hCu = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // kotlin.g.a.m
                public final /* synthetic */ x invoke(Integer num, Integer num2) {
                    AppMethodBeat.i(196529);
                    this.hCu.hCp.hAr.cX(num.intValue(), num2.intValue());
                    x xVar = x.SXb;
                    AppMethodBeat.o(196529);
                    return xVar;
                }
            };
            x xVar = x.SXb;
            AppMethodBeat.o(196530);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "mFps", "", "invoke"})
    public static final class g extends q implements kotlin.g.a.b<Integer, x> {
        public static final g hCv = new g();

        static {
            AppMethodBeat.i(196532);
            AppMethodBeat.o(196532);
        }

        g() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Integer num) {
            AppMethodBeat.i(196531);
            int intValue = num.intValue();
            if (intValue <= 5) {
                com.tencent.mm.live.core.c.c.aER();
            } else if (intValue <= 10) {
                com.tencent.mm.live.core.c.c.aES();
            } else if (intValue > 10) {
                com.tencent.mm.live.core.c.c.aET();
            }
            com.tencent.mm.live.core.c.c.qL(intValue);
            x xVar = x.SXb;
            AppMethodBeat.o(196531);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "cost", "", "invoke"})
    static final class h extends q implements kotlin.g.a.b<Integer, x> {
        public static final h hCw = new h();

        static {
            AppMethodBeat.i(196534);
            AppMethodBeat.o(196534);
        }

        h() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Integer num) {
            AppMethodBeat.i(196533);
            com.tencent.mm.live.core.c.c.qK(num.intValue());
            x xVar = x.SXb;
            AppMethodBeat.o(196533);
            return xVar;
        }
    }

    public b() {
        super(false);
        AppMethodBeat.i(196557);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_live_seireport_interval, 5);
        if (a2 > 0) {
            this.uXo = a2;
        }
        Log.i("MicroMsg.LiveCoreVisitor", "get sei report interval:" + a2 + ", final:" + this.uXo);
        this.hCm = new RunnableC0382b(this);
        AppMethodBeat.o(196557);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\rH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "TAG", "", "getInstance", "context", "Landroid/content/Context;", "hasInstance", "", "releaseInstance", "", "plugin-core_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static b aEf() {
            AppMethodBeat.i(196514);
            if (b.hCn == null) {
                b.hCn = new b();
            }
            b bVar = b.hCn;
            if (bVar == null) {
                p.hyc();
            }
            AppMethodBeat.o(196514);
            return bVar;
        }

        public static boolean aDp() {
            AppMethodBeat.i(196515);
            if (b.hCn != null) {
                AppMethodBeat.o(196515);
                return true;
            }
            AppMethodBeat.o(196515);
            return false;
        }

        public static void releaseInstance() {
            AppMethodBeat.i(196516);
            b bVar = b.hCn;
            if (bVar != null) {
                bVar.release();
            }
            b.hCn = null;
            AppMethodBeat.o(196516);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$debugRunnable$1", "Ljava/lang/Runnable;", "run", "", "plugin-core_release"})
    /* renamed from: com.tencent.mm.live.core.core.d.b$b  reason: collision with other inner class name */
    public static final class RunnableC0382b implements Runnable {
        final /* synthetic */ b hCp;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        RunnableC0382b(b bVar) {
            this.hCp = bVar;
        }

        public final void run() {
            AppMethodBeat.i(196517);
            com.tencent.mm.live.core.core.b.f fVar = this.hCp.hAy;
            if (fVar != null) {
                com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
                if (this.hCp.hAl == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.live.core.core.trtc.WXTRTCCloudImpl");
                    AppMethodBeat.o(196517);
                    throw tVar;
                }
                String str = fVar.hzu.userId;
                p.g(str, "trtcParams.userId");
                com.tencent.mm.live.core.debug.a.GC(String.valueOf(com.tencent.mm.live.core.core.trtc.b.Gq(str)));
            }
            this.hCp.hAk.removeCallbacks(this);
            this.hCp.hAk.postDelayed(this, 10000);
            AppMethodBeat.o(196517);
        }
    }

    @Override // com.tencent.rtmp.ITXLivePlayListener
    public void onPlayEvent(int i2, Bundle bundle) {
        int i3;
        byte[] bArr;
        long j2;
        long j3;
        long j4;
        com.tencent.mm.live.core.core.b.e eVar;
        com.tencent.mm.live.core.core.b.e eVar2;
        com.tencent.mm.live.core.core.b.e eVar3;
        com.tencent.mm.live.core.core.b.e eVar4;
        com.tencent.mm.live.core.core.c cVar;
        String str = null;
        AppMethodBeat.i(196535);
        Log.i("MicroMsg.LiveCoreVisitor", "onPlayEvent:" + i2 + ", isPlaying:" + com.tencent.mm.live.core.core.d.isPlaying());
        if (com.tencent.mm.live.core.core.d.isPlaying()) {
            this.hCl = i2;
            switch (i2) {
                case -2304:
                case 2101:
                case 2102:
                case 2106:
                case 2108:
                    com.tencent.mm.live.core.core.d dVar = com.tencent.mm.live.core.core.d.hwY;
                    if (com.tencent.mm.live.core.core.d.aCc() && (i2 == 2101 || i2 == -2304 || i2 == 2108)) {
                        com.tencent.mm.live.core.core.d dVar2 = com.tencent.mm.live.core.core.d.hwY;
                        com.tencent.mm.live.core.core.d.aCb();
                    }
                    if (bundle != null) {
                        str = bundle.getString(TXLiveConstants.EVT_DESCRIPTION);
                    }
                    com.tencent.mm.live.core.c.b bVar = com.tencent.mm.live.core.c.b.hEJ;
                    if (str == null) {
                        str = "";
                    }
                    com.tencent.mm.live.core.c.b.h("onPlayEvent", i2, str);
                    break;
                case -2301:
                    com.tencent.mm.live.core.core.d.ev(false);
                    if (NetStatusUtil.getNetType(MMApplicationContext.getContext()) == -1 && (cVar = this.hAx) != null) {
                        e.d dVar3 = e.d.hxF;
                        c.a.a(cVar, e.d.aCC());
                    }
                    com.tencent.mm.live.core.core.d dVar4 = com.tencent.mm.live.core.core.d.hwY;
                    if (com.tencent.mm.live.core.core.d.aCc()) {
                        com.tencent.mm.live.core.core.d dVar5 = com.tencent.mm.live.core.core.d.hwY;
                        com.tencent.mm.live.core.core.d.aCb();
                        AppMethodBeat.o(196535);
                        return;
                    }
                    break;
                case 2001:
                case 2004:
                    a(com.tencent.mm.live.core.mini.d.STATE_NORMAL);
                    com.tencent.mm.live.core.core.c cVar2 = this.hAx;
                    if (cVar2 != null) {
                        e.d dVar6 = e.d.hxF;
                        c.a.a(cVar2, e.d.aCA());
                        AppMethodBeat.o(196535);
                        return;
                    }
                    AppMethodBeat.o(196535);
                    return;
                case 2009:
                    com.tencent.mm.live.core.core.c cVar3 = this.hAx;
                    if (cVar3 != null) {
                        e.d dVar7 = e.d.hxF;
                        cVar3.callback(e.d.aCD(), bundle);
                        AppMethodBeat.o(196535);
                        return;
                    }
                    AppMethodBeat.o(196535);
                    return;
                case 2012:
                    com.tencent.mm.live.core.core.b.f fVar = this.hAy;
                    if (fVar == null || (eVar4 = fVar.hwP) == null) {
                        i3 = 0;
                    } else {
                        i3 = eVar4.uEz;
                    }
                    if (bundle != null) {
                        bArr = bundle.getByteArray(TXLiveConstants.EVT_GET_MSG);
                    } else {
                        bArr = null;
                    }
                    if (i3 > 0) {
                        Log.i("MicroMsg.LiveCoreVisitor", "handleSeiMessage seiMode:" + i3 + " seiData:" + bArr);
                        if (!(i3 == 0 || bArr == null)) {
                            if (!(bArr.length == 0)) {
                                String str2 = new String(bArr, kotlin.n.d.UTF_8);
                                int g2 = n.g(str2, "\\0");
                                if (g2 == str2.length() - 2) {
                                    str2 = str2.substring(0, g2);
                                    p.g(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                }
                                Log.i("MicroMsg.LiveCoreVisitor", "final seiMessage:".concat(String.valueOf(str2)));
                                try {
                                    i iVar = new i(str2);
                                    if (iVar.optInt("wxT") == 0 || Util.isNullOrNil(iVar.optString("d"))) {
                                        if (com.tencent.mm.ac.d.cW(i3, e.k.SEIMode_GAMEREPORT.value) && n.e(str2, "sgame")) {
                                            long currentTimeMillis = System.currentTimeMillis();
                                            if (currentTimeMillis - this.uKy > ((long) (this.uXo * 1000))) {
                                                i iVar2 = new i();
                                                iVar2.i("SVRT", Long.valueOf(cl.aWy()));
                                                iVar2.i("SEI", new i(str2));
                                                Log.i("MicroMsg.LiveCoreVisitor", "handleSeiMessage SEIMode_GAMEREPORT jsonData:".concat(String.valueOf(iVar2)));
                                                fq fqVar = new fq();
                                                fqVar.sD("onPlayEvent");
                                                fqVar.pg(2012);
                                                com.tencent.mm.live.core.core.b.f fVar2 = this.hAy;
                                                if (fVar2 == null || (eVar3 = fVar2.hwP) == null) {
                                                    j2 = 0;
                                                } else {
                                                    j2 = eVar3.liveId;
                                                }
                                                fqVar.ph(j2);
                                                com.tencent.mm.live.core.core.b.f fVar3 = this.hAy;
                                                if (fVar3 == null || (eVar2 = fVar3.hwP) == null) {
                                                    j3 = 0;
                                                } else {
                                                    j3 = (long) eVar2.hzo;
                                                }
                                                fqVar.pi(j3);
                                                com.tencent.mm.live.core.core.b.f fVar4 = this.hAy;
                                                if (fVar4 == null || (eVar = fVar4.hwP) == null) {
                                                    j4 = 0;
                                                } else {
                                                    j4 = (long) eVar.hzl;
                                                }
                                                fqVar.pj(j4);
                                                fqVar.sE(com.tencent.mm.compatible.util.q.encode(iVar2.toString(), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                                                fqVar.bfK();
                                                this.uKy = currentTimeMillis;
                                            }
                                        }
                                        if (com.tencent.mm.ac.d.cW(i3, e.k.SEIMode_SUBTITLE.value) && n.e(str2, MessengerShareContentUtility.SUBTITLE)) {
                                            Log.i("MicroMsg.LiveCoreVisitor", "handleSeiMessage SEIMode_SUBTITLE jsonData:".concat(String.valueOf(new i(str2))));
                                            AppMethodBeat.o(196535);
                                            return;
                                        }
                                        AppMethodBeat.o(196535);
                                        return;
                                    }
                                    if (com.tencent.mm.ac.d.cW(i3, e.k.SEIMode_LINKMIC.value)) {
                                        Bundle bundle2 = new Bundle();
                                        bundle2.putString("live_cdn_sei_msg", iVar.optString("d"));
                                        com.tencent.mm.live.core.core.c cVar4 = this.hAx;
                                        if (cVar4 != null) {
                                            e.d dVar8 = e.d.hxF;
                                            cVar4.callback(e.d.aFS(), bundle2);
                                            AppMethodBeat.o(196535);
                                            return;
                                        }
                                    }
                                    AppMethodBeat.o(196535);
                                    return;
                                } catch (Exception e2) {
                                    Log.w("MicroMsg.LiveCoreVisitor", "handleSeiMessage Exception:" + e2.getMessage() + " seiMessage:" + str2);
                                }
                            }
                        }
                        Log.i("MicroMsg.LiveCoreVisitor", "skip handleSeiMessage");
                        AppMethodBeat.o(196535);
                        return;
                    }
                    break;
                case 2103:
                    if (NetStatusUtil.getNetType(MMApplicationContext.getContext()) == -1) {
                        com.tencent.mm.live.core.core.c cVar5 = this.hAx;
                        if (cVar5 != null) {
                            e.d dVar9 = e.d.hxF;
                            c.a.a(cVar5, e.d.aCB());
                            AppMethodBeat.o(196535);
                            return;
                        }
                        AppMethodBeat.o(196535);
                        return;
                    }
                    break;
                case 2105:
                    com.tencent.mm.live.core.core.d dVar10 = com.tencent.mm.live.core.core.d.hwY;
                    com.tencent.mm.live.core.core.d.aCa();
                    com.tencent.mm.live.core.core.c cVar6 = this.hAx;
                    if (cVar6 != null) {
                        e.d dVar11 = e.d.hxF;
                        c.a.a(cVar6, e.d.aCE());
                        AppMethodBeat.o(196535);
                        return;
                    }
                    AppMethodBeat.o(196535);
                    return;
            }
        }
        AppMethodBeat.o(196535);
    }

    @Override // com.tencent.rtmp.ITXLivePlayListener
    public void onNetStatus(Bundle bundle) {
        com.tencent.mm.live.core.core.b.e eVar;
        long j2;
        com.tencent.mm.live.core.core.b.e eVar2;
        long j3 = 0;
        AppMethodBeat.i(196536);
        int netType = NetStatusUtil.getNetType(MMApplicationContext.getContext());
        Log.i("MicroMsg.LiveCoreVisitor", "onNetStatus curPlayStatus:" + this.hCl + ", netQuality:" + netType + ", isPlaying:" + com.tencent.mm.live.core.core.d.isPlaying() + ",netStatus:" + bundle);
        if (com.tencent.mm.live.core.core.d.isPlaying() && netType != -1 && this.hCl == -2301) {
            com.tencent.mm.live.core.core.d dVar = com.tencent.mm.live.core.core.d.hwY;
            com.tencent.mm.live.core.core.d.qq(this.streamType);
            com.tencent.mm.live.core.core.c cVar = this.hAx;
            if (cVar != null) {
                e.d dVar2 = e.d.hxF;
                c.a.a(cVar, e.d.aCy());
            }
        }
        com.tencent.mm.live.core.core.d dVar3 = com.tencent.mm.live.core.core.d.hwY;
        com.tencent.mm.live.core.core.d.aBZ();
        if (bundle != null) {
            e.j jVar = e.j.hyq;
            String aCY = e.j.aCY();
            com.tencent.mm.live.core.core.b.f fVar = this.hAy;
            if (fVar == null || (eVar2 = fVar.hwP) == null) {
                j2 = 0;
            } else {
                j2 = eVar2.liveId;
            }
            bundle.putLong(aCY, j2);
        }
        if (bundle != null) {
            e.j jVar2 = e.j.hyq;
            String aCZ = e.j.aCZ();
            e.i iVar = e.i.hyd;
            bundle.putInt(aCZ, e.i.aCX());
        }
        if (bundle != null) {
            e.j jVar3 = e.j.hyq;
            String aDa = e.j.aDa();
            e.a aVar = e.a.hxc;
            bundle.putInt(aDa, e.a.aCf());
        }
        if (bundle != null) {
            e.j jVar4 = e.j.hyq;
            bundle.putLong(e.j.aDb(), System.currentTimeMillis());
        }
        if (bundle != null) {
            e.j jVar5 = e.j.hyq;
            String aDc = e.j.aDc();
            com.tencent.mm.live.core.core.b.f fVar2 = this.hAy;
            if (!(fVar2 == null || (eVar = fVar2.hwP) == null)) {
                j3 = eVar.startTime;
            }
            bundle.putLong(aDc, j3);
        }
        if (bundle != null) {
            e.j jVar6 = e.j.hyq;
            bundle.putInt(e.j.aDi(), NetStatusUtil.getNetType(MMApplicationContext.getContext()));
        }
        if (bundle != null) {
            e.j jVar7 = e.j.hyq;
            String aDj = e.j.aDj();
            com.tencent.mm.live.core.d.b bVar = com.tencent.mm.live.core.d.b.hEQ;
            bundle.putString(aDj, com.tencent.mm.live.core.d.b.x(bundle));
        }
        com.tencent.mm.live.core.core.c cVar2 = this.hAx;
        if (cVar2 != null) {
            e.d dVar4 = e.d.hxF;
            cVar2.callback(e.d.aCz(), bundle);
            AppMethodBeat.o(196536);
            return;
        }
        AppMethodBeat.o(196536);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\r"}, hxF = {"com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$floatMode$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-core_release"})
    public static final class c implements TextureView.SurfaceTextureListener {
        final /* synthetic */ com.tencent.mm.live.core.b.h hCq;
        final /* synthetic */ long hyx;

        c(com.tencent.mm.live.core.b.h hVar, long j2) {
            this.hCq = hVar;
            this.hyx = j2;
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            AppMethodBeat.i(196518);
            this.hCq.cX(i2, i3);
            AppMethodBeat.o(196518);
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            AppMethodBeat.i(196519);
            Log.i("MicroMsg.LiveCoreVisitor", "float onSurfaceTextureDestroyed");
            AppMethodBeat.o(196519);
            return false;
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            AppMethodBeat.i(196520);
            Log.i("MicroMsg.LiveCoreVisitor", "float onSurfaceTextureAvailable, surface:" + surfaceTexture + ", size:[" + i2 + ", " + i3 + ']');
            this.hCq.bO(surfaceTexture);
            this.hCq.cX(i2, i3);
            com.tencent.mm.live.core.c.c.qJ((int) Util.ticksToNow(this.hyx));
            AppMethodBeat.o(196520);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u000e¸\u0006\u0000"}, hxF = {"com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$normalMode$1$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "surface", "plugin-core_release"})
    public static final class d implements TextureView.SurfaceTextureListener {
        final /* synthetic */ com.tencent.mm.live.core.b.h hCr;
        final /* synthetic */ long hCs;

        d(com.tencent.mm.live.core.b.h hVar, long j2) {
            this.hCr = hVar;
            this.hCs = j2;
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            AppMethodBeat.i(196521);
            p.h(surfaceTexture, "surfaceTexture");
            Log.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureAvailable, size:[%s, %s]", Integer.valueOf(i2), Integer.valueOf(i3));
            this.hCr.bO(new Surface(surfaceTexture));
            this.hCr.cX(i2, i3);
            com.tencent.mm.live.core.c.c.qI((int) Util.ticksToNow(this.hCs));
            AppMethodBeat.o(196521);
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            AppMethodBeat.i(196522);
            p.h(surfaceTexture, "surfaceTexture");
            Log.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureSizeChanged, size:[%s, %s]", Integer.valueOf(i2), Integer.valueOf(i3));
            this.hCr.cX(i2, i3);
            AppMethodBeat.o(196522);
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            AppMethodBeat.i(196523);
            p.h(surfaceTexture, "surfaceTexture");
            Log.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureDestroyed");
            this.hCr.aEG();
            AppMethodBeat.o(196523);
            return false;
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            AppMethodBeat.i(196524);
            p.h(surfaceTexture, "surface");
            AppMethodBeat.o(196524);
        }
    }

    @Override // com.tencent.mm.live.core.core.b, com.tencent.mm.live.core.core.trtc.a
    public final void a(com.tencent.mm.live.core.core.c cVar) {
        AppMethodBeat.i(196539);
        p.h(cVar, "callback");
        super.a(cVar);
        com.tencent.mm.live.core.core.trtc.a.a aDC = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        p.g(aDC, "ConfigHelper.getInstance()");
        com.tencent.mm.live.core.core.trtc.a.a.d aDD = aDC.aDD();
        p.g(aDD, "ConfigHelper.getInstance().videoConfig");
        aDD.eC(false);
        com.tencent.mm.live.core.core.trtc.a.a aDC2 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        p.g(aDC2, "ConfigHelper.getInstance()");
        com.tencent.mm.live.core.core.trtc.a.a.a aDE = aDC2.aDE();
        p.g(aDE, "ConfigHelper.getInstance().audioConfig");
        aDE.ez(false);
        AppMethodBeat.o(196539);
    }

    @Override // com.tencent.mm.live.core.core.trtc.a, com.tencent.mm.live.core.core.trtc.a.d
    public final void onEnterRoom(long j2) {
        AppMethodBeat.i(196540);
        super.onEnterRoom(j2);
        this.hAk.post(this.hCm);
        AppMethodBeat.o(196540);
    }

    public final void a(long j2, TXLivePlayer tXLivePlayer, TXCloudVideoView tXCloudVideoView) {
        AppMethodBeat.i(196543);
        this.hCj = tXCloudVideoView;
        this.hAm.a(j2, tXLivePlayer);
        AppMethodBeat.o(196543);
    }

    @Override // com.tencent.mm.live.core.core.trtc.a, com.tencent.mm.live.core.core.trtc.a.d
    public final void onRemoteUserLeaveRoom(String str, int i2) {
        AppMethodBeat.i(196547);
        super.onRemoteUserLeaveRoom(str, i2);
        AppMethodBeat.o(196547);
    }

    public final void aEc() {
        AppMethodBeat.i(196550);
        Log.i("MicroMsg.LiveCoreVisitor", "[makeRemotePreviewFullScreen] anchorID:" + this.hAz.hzG + " preview:" + this.hAs);
        if (this.hAs == null) {
            Log.w("MicroMsg.LiveCoreVisitor", "previewView == null!");
        } else if (!TextUtils.isEmpty(this.hAz.hzG)) {
            LivePreviewView livePreviewView = this.hAs;
            if (livePreviewView != null) {
                livePreviewView.GE(this.hAz.hzG);
                AppMethodBeat.o(196550);
                return;
            }
            AppMethodBeat.o(196550);
            return;
        }
        AppMethodBeat.o(196550);
    }

    public final void aEd() {
        AppMethodBeat.i(196552);
        aBX();
        aBS();
        this.hAz.hzB = g.b.AUDIO_LINK_MIC;
        AppMethodBeat.o(196552);
    }

    @Override // com.tencent.mm.live.core.core.trtc.a
    public final void release() {
        AppMethodBeat.i(196555);
        super.release();
        this.hAk.removeCallbacks(this.hCm);
        AppMethodBeat.o(196555);
    }

    @Override // com.tencent.mm.live.core.core.trtc.a, com.tencent.mm.live.core.core.trtc.a.d
    public final void onFirstVideoFrame(String str, int i2, int i3, int i4) {
        boolean z = true;
        AppMethodBeat.i(196556);
        super.onFirstVideoFrame(str, i2, i3, i4);
        boolean z2 = au.az(MMApplicationContext.getContext()).x > au.az(MMApplicationContext.getContext()).y;
        if (i3 <= i4) {
            z = false;
        }
        if (z2 == z) {
            Log.i("MicroMsg.LiveCoreVisitor", "updateFillMode to SCALE_TYPE_CENTER_CROP");
            com.tencent.mm.live.core.b.h Gy = this.hAm.Gy(str);
            if (Gy != null) {
                Gy.qy(2);
                AppMethodBeat.o(196556);
                return;
            }
            AppMethodBeat.o(196556);
            return;
        }
        Log.i("MicroMsg.LiveCoreVisitor", "updateFillMode to SCALE_TYPE_FIT_MODE");
        com.tencent.mm.live.core.b.h Gy2 = this.hAm.Gy(str);
        if (Gy2 != null) {
            Gy2.qy(5);
            AppMethodBeat.o(196556);
            return;
        }
        AppMethodBeat.o(196556);
    }

    @Override // com.tencent.mm.live.core.core.b, com.tencent.mm.live.core.core.trtc.a
    public final int a(Context context, boolean z, boolean z2, int i2, int i3) {
        long j2;
        com.tencent.mm.live.core.core.b.e eVar;
        com.tencent.mm.live.core.core.b.e eVar2;
        boolean z3 = false;
        AppMethodBeat.i(196537);
        p.h(context, "context");
        if (this.hAz.isFloatMode()) {
            AppMethodBeat.o(196537);
            return 0;
        }
        long currentTicks = Util.currentTicks();
        this.hAz.hzE = g.d.FLOAT_MODE;
        if (!this.hAz.aDt() && !this.hAz.aDu()) {
            com.tencent.mm.live.core.core.b.f fVar = this.hAy;
            if (!(fVar == null || (eVar2 = fVar.hwP) == null)) {
                int i4 = eVar2.hzl;
                e.a aVar = e.a.hxc;
                if (i4 == e.a.aCf()) {
                    z3 = true;
                }
            }
            if (z3) {
                com.tencent.mm.live.core.core.trtc.a.b.c cVar = this.hAm;
                com.tencent.mm.live.core.core.b.f fVar2 = this.hAy;
                if (fVar2 == null || (eVar = fVar2.hwP) == null) {
                    j2 = 0;
                } else {
                    j2 = eVar.liveId;
                }
                TXLivePlayer zv = cVar.zv(j2);
                TXCloudVideoView tXCloudVideoView = new TXCloudVideoView(MMApplicationContext.getContext());
                this.hAq.co(tXCloudVideoView);
                zv.setPlayerView(tXCloudVideoView);
                int a2 = super.a(context, z, z2, i2, i3);
                AppMethodBeat.o(196537);
                return a2;
            }
        }
        com.tencent.mm.live.core.b.h Gy = this.hAm.Gy(this.hAz.hzG);
        if (Gy != null) {
            TXCloudVideoView W = W(Gy.userId, Gy.streamType);
            if (W != null) {
                W.removeVideoView();
            }
            Log.i("MicroMsg.LiveCoreVisitor", "enter float mode");
            Gy.aEG();
            TextureView textureView = new TextureView(MMApplicationContext.getContext());
            textureView.setSurfaceTextureListener(new c(Gy, currentTicks));
            this.hAq.co(textureView);
        }
        int a22 = super.a(context, z, z2, i2, i3);
        AppMethodBeat.o(196537);
        return a22;
    }

    @Override // com.tencent.mm.live.core.core.b, com.tencent.mm.live.core.core.trtc.a
    public final void aBU() {
        LivePreviewView livePreviewView;
        long j2;
        com.tencent.mm.live.core.core.b.e eVar;
        AppMethodBeat.i(196538);
        if (!this.hAz.isFloatMode()) {
            AppMethodBeat.o(196538);
            return;
        }
        long currentTicks = Util.currentTicks();
        this.hAz.hzE = g.d.NORMAL_MODE;
        if (this.hCj != null) {
            com.tencent.mm.live.core.core.trtc.a.b.c cVar = this.hAm;
            com.tencent.mm.live.core.core.b.f fVar = this.hAy;
            if (fVar == null || (eVar = fVar.hwP) == null) {
                j2 = 0;
            } else {
                j2 = eVar.liveId;
            }
            cVar.zv(j2).setPlayerView(this.hCj);
        }
        com.tencent.mm.live.core.b.h Gy = this.hAm.Gy(this.hAz.hzG);
        if (Gy != null) {
            Log.i("MicroMsg.LiveCoreVisitor", "normalMode, find renderSurface for userId:" + this.hAz.hzG);
            TXCloudVideoView W = W(Gy.userId, Gy.streamType);
            if (W != null) {
                TextureView textureView = new TextureView(MMApplicationContext.getContext());
                W.addVideoView(textureView);
                textureView.setSurfaceTextureListener(new d(Gy, currentTicks));
            }
        }
        if (this.hAz.aDt() && (livePreviewView = this.hAs) != null) {
            livePreviewView.a(new e(this));
        }
        super.aBU();
        AppMethodBeat.o(196538);
    }

    public final void a(LivePreviewView livePreviewView, com.tencent.mm.live.core.core.c cVar) {
        AppMethodBeat.i(196541);
        p.h(cVar, "callback");
        this.hAs = livePreviewView;
        a(cVar);
        AppMethodBeat.o(196541);
    }

    public final void a(LivePreviewView livePreviewView) {
        this.hAs = livePreviewView;
    }

    public final void aDX() {
        LivePreviewView livePreviewView;
        TXCloudVideoView tXCloudVideoView = null;
        AppMethodBeat.i(196542);
        if (!TextUtils.isEmpty(this.hAz.hzG)) {
            com.tencent.mm.live.core.core.trtc.a.b.c cVar = this.hAm;
            String str = this.hAz.hzG;
            LivePreviewView livePreviewView2 = this.hAs;
            cVar.a(str, livePreviewView2 != null ? livePreviewView2.X(this.hAz.hzG, 0) : null);
            this.hAm.muteRemoteAudio(this.hAz.hzG, false);
        }
        if (!TextUtils.isEmpty(this.hAz.hzI)) {
            com.tencent.mm.live.core.core.trtc.a.b.c cVar2 = this.hAm;
            String str2 = this.hAz.hzI;
            LivePreviewView livePreviewView3 = this.hAs;
            if (livePreviewView3 != null) {
                tXCloudVideoView = livePreviewView3.X(this.hAz.hzI, 0);
            }
            cVar2.a(str2, tXCloudVideoView);
            this.hAm.muteRemoteAudio(this.hAz.hzG, false);
        }
        if (!this.hAz.aDt() || (livePreviewView = this.hAs) == null) {
            AppMethodBeat.o(196542);
            return;
        }
        livePreviewView.a(new f(this));
        AppMethodBeat.o(196542);
    }

    public final int aDY() {
        AppMethodBeat.i(196544);
        this.hAz.hzB = g.b.AUDIO_LINK_MIC;
        com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
        com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", "[sdk]start link mic");
        com.tencent.mm.live.core.core.trtc.a.c cVar = this.hAn;
        if (cVar == null || cVar.aDP() != 20) {
            com.tencent.mm.live.core.core.trtc.a.a aDC = com.tencent.mm.live.core.core.trtc.a.a.aDC();
            p.g(aDC, "ConfigHelper.getInstance()");
            com.tencent.mm.live.core.core.trtc.a.a.a aDE = aDC.aDE();
            p.g(aDE, "ConfigHelper.getInstance().audioConfig");
            aDE.ez(true);
            com.tencent.mm.live.core.core.trtc.a.c cVar2 = this.hAn;
            if (cVar2 != null) {
                cVar2.aDK();
            }
            com.tencent.mm.live.core.core.trtc.a.c cVar3 = this.hAn;
            if (cVar3 != null) {
                cVar3.aDO();
            }
            com.tencent.mm.live.core.core.trtc.a.c cVar4 = this.hAn;
            if (cVar4 != null) {
                cVar4.startLocalAudio();
            }
            AppMethodBeat.o(196544);
        } else {
            AppMethodBeat.o(196544);
        }
        return 0;
    }

    @Override // com.tencent.mm.live.core.core.trtc.a
    public final boolean aDx() {
        AppMethodBeat.i(196545);
        com.tencent.mm.live.core.core.trtc.a.c cVar = this.hAn;
        if (cVar == null || cVar.aDP() != 21) {
            AppMethodBeat.o(196545);
            return true;
        }
        AppMethodBeat.o(196545);
        return false;
    }

    public final int aDZ() {
        AppMethodBeat.i(196546);
        this.hAz.hzB = g.b.NO_LINK_MIC;
        com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
        com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", "[sdk]stop link mic");
        com.tencent.mm.live.core.core.trtc.a.c cVar = this.hAn;
        if (cVar == null || cVar.aDP() != 21) {
            com.tencent.mm.live.core.core.trtc.a.a aDC = com.tencent.mm.live.core.core.trtc.a.a.aDC();
            p.g(aDC, "ConfigHelper.getInstance()");
            com.tencent.mm.live.core.core.trtc.a.a.a aDE = aDC.aDE();
            p.g(aDE, "ConfigHelper.getInstance().audioConfig");
            aDE.ez(false);
            com.tencent.mm.live.core.core.trtc.a.a aDC2 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
            p.g(aDC2, "ConfigHelper.getInstance()");
            com.tencent.mm.live.core.core.trtc.a.a.d aDD = aDC2.aDD();
            p.g(aDD, "ConfigHelper.getInstance().videoConfig");
            aDD.eC(false);
            com.tencent.mm.live.core.core.trtc.a.c cVar2 = this.hAn;
            if (cVar2 != null) {
                cVar2.aDO();
            }
            com.tencent.mm.live.core.core.trtc.a.c cVar3 = this.hAn;
            if (cVar3 != null) {
                cVar3.stopLocalAudio();
            }
            aBS();
            AppMethodBeat.o(196546);
        } else {
            AppMethodBeat.o(196546);
        }
        return 0;
    }

    public final void aEa() {
        AppMethodBeat.i(196548);
        this.hAm.Gv(this.hAz.hzG);
        this.hAm.muteRemoteAudio(this.hAz.hzG, true);
        AppMethodBeat.o(196548);
    }

    public final void aEb() {
        AppMethodBeat.i(196549);
        if (this.hAs == null) {
            Log.w("MicroMsg.LiveCoreVisitor", "previewView == null!");
        } else if (!TextUtils.isEmpty(this.hAz.hzG)) {
            com.tencent.mm.live.core.core.trtc.a.b.c cVar = this.hAm;
            String str = this.hAz.hzG;
            LivePreviewView livePreviewView = this.hAs;
            cVar.a(str, livePreviewView != null ? livePreviewView.X(this.hAz.hzG, 0) : null);
            this.hAm.muteRemoteAudio(this.hAz.hzG, false);
            AppMethodBeat.o(196549);
            return;
        }
        AppMethodBeat.o(196549);
    }

    public final void b(LivePreviewView livePreviewView) {
        int i2;
        AppMethodBeat.i(196551);
        com.tencent.mm.live.core.core.trtc.a.c cVar = this.hAn;
        if (cVar != null) {
            cVar.aDK();
        }
        aBY();
        if (livePreviewView == null) {
            Log.e("MicroMsg.LiveCore", "startPreview preiewView is null");
        } else {
            this.hAr.aEz();
            com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
            com.tencent.mm.live.core.debug.a.GA("startPreview ".concat(String.valueOf(livePreviewView)));
            this.hAs = livePreviewView;
            com.tencent.mm.live.core.core.trtc.a.a aDC = com.tencent.mm.live.core.core.trtc.a.a.aDC();
            p.g(aDC, "ConfigHelper.getInstance()");
            com.tencent.mm.live.core.core.trtc.a.a.a aDE = aDC.aDE();
            p.g(aDE, "ConfigHelper.getInstance().audioConfig");
            aDE.ez(true);
            com.tencent.mm.live.core.core.trtc.a.a aDC2 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
            p.g(aDC2, "ConfigHelper.getInstance()");
            com.tencent.mm.live.core.core.trtc.a.a.d aDD = aDC2.aDD();
            p.g(aDD, "ConfigHelper.getInstance().videoConfig");
            aDD.eC(true);
            livePreviewView.a(new a.h(this));
            com.tencent.mm.media.widget.a.d dVar = this.hAt;
            if (dVar != null && dVar.aPc()) {
                com.tencent.mm.live.core.core.trtc.a.a aDC3 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                p.g(aDC3, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.b aDG = aDC3.aDG();
                com.tencent.mm.media.widget.a.d dVar2 = this.hAt;
                if (dVar2 != null) {
                    i2 = dVar2.aPu();
                } else {
                    i2 = 0;
                }
                aDG.hBp = i2;
                Log.i("MicroMsg.LiveCore", "start preview success");
                com.tencent.mm.live.core.b.d dVar3 = this.hAr;
                com.tencent.mm.media.widget.a.d dVar4 = this.hAt;
                com.tencent.mm.media.widget.a.b aPr = dVar4 != null ? dVar4.aPr() : null;
                if (aPr == null) {
                    p.hyc();
                }
                dVar3.a(aPr);
                this.hAr.setOnDrawListener(new a.g(this));
            }
        }
        this.hAz.hzB = g.b.VIDEO_LINK_MIC;
        this.hAr.f(h.hCw);
        AppMethodBeat.o(196551);
    }

    @Override // com.tencent.mm.live.core.core.b
    public final int aBX() {
        AppMethodBeat.i(196553);
        this.hAr.e((kotlin.g.a.b<? super Integer, x>) null);
        this.hAl.enableCustomVideoCapture(false);
        this.hAA = false;
        AppMethodBeat.o(196553);
        return 0;
    }

    @Override // com.tencent.mm.live.core.core.b
    public final int aBY() {
        AppMethodBeat.i(196554);
        this.hAr.e(g.hCv);
        this.hAl.enableCustomVideoCapture(true);
        this.hAA = true;
        AppMethodBeat.o(196554);
        return 0;
    }
}
