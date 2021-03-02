package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.g.b.a.jh;
import com.tencent.mm.g.b.a.jo;
import com.tencent.mm.i.h;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.story.e.b;
import com.tencent.mm.plugin.story.f.d.j;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.k;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.h.b;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.ui.view.gallery.m;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.Arrays;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013*\u0002\u0016\u001f\u0018\u00002\u00020\u0001:\u0002CDB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&J\u0016\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\rJ\u001c\u0010*\u001a\u00020\"2\b\u0010+\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010,\u001a\u00020\rH\u0002J\u0006\u0010-\u001a\u00020\rJ\u000e\u0010.\u001a\u00020\r2\u0006\u0010(\u001a\u00020\nJ\b\u0010/\u001a\u0004\u0018\u00010\u001dJ\u0010\u00100\u001a\u00020\"2\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020\r2\u0006\u0010(\u001a\u00020\nH\u0002J\u0006\u00104\u001a\u00020\"J\u0006\u00105\u001a\u00020\"J\u0006\u00106\u001a\u00020\"J\u0006\u00107\u001a\u00020\"J\u0006\u00108\u001a\u00020\"J\u0006\u00109\u001a\u00020\"J\u0006\u0010:\u001a\u00020\"J\u0012\u0010;\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010$H\u0002J\u000e\u0010<\u001a\u00020\"2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010=\u001a\u00020\"2\u0006\u0010>\u001a\u00020\rJ\b\u0010?\u001a\u00020\"H\u0002J\u0006\u0010@\u001a\u00020\"J\u001a\u0010A\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\r2\b\b\u0002\u0010,\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0014\u0010\u0018\u001a\b\u0018\u00010\u0019R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0004\n\u0002\u0010 ¨\u0006E"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "", "()V", "STORY_VIDEO_VIEW_IDKEY_STAT", "", "TAG", "", "audioFocos", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "currVideoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "currentSessionId", "isMute", "", "isPlayingVideoItem", "isRequestAudioFocus", "isVideoPause", "isVideoPlaying", "()Z", "setVideoPlaying", "(Z)V", "onlineVideoEventListener", "com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1;", "proxy", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayProxy;", "showLoadingTime", "", "videoView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView;", "videoViewCallback", "com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1;", "attachVideoView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "changeVideoItem", "item", "playing", "checkDetachVideoView", "newParent", "enableReport", "checkPauseOnProgress", "getPlayStatus", "getVideoView", "initCreateVideoView", "context", "Landroid/content/Context;", "isVideoNotChangeItem", "newVideoViewInstance", "onUIDestroy", "onUIPause", "onUIResume", "pauseVideo", "playVideo", "resetVideo", "sameParent", "setMute", "setNeedShowLoading", "show", "setVideoViewProp", "stopTask", "stopVideo", "detach", "VideoPlayCdnCallback", "VideoPlayProxy", "plugin-story_release"})
public final class n {
    boolean FHg;
    String FHh;
    private boolean FHi;
    j FHj;
    boolean FHk;
    private com.tencent.mm.compatible.util.b FHl = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    private boolean FHm;
    StoryVideoView FIc;
    b FId;
    final long FIe = 987;
    int FIf;
    private final d FIg = new d(this);
    private final e FIh;
    final String TAG = "MicroMsg.Gallery.StoryVideoViewMgr";
    private boolean guh;

    public n() {
        AppMethodBeat.i(120664);
        Log.i(this.TAG, "init create StoryVideoViewMgr " + hashCode());
        EventCenter.instance.addListener(this.FIg);
        this.FIh = new e(this);
        AppMethodBeat.o(120664);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/OnlineVideoEvent;", "callback", "", "event", "plugin-story_release"})
    public static final class d extends IListener<oq> {
        final /* synthetic */ n FIj;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(n nVar) {
            this.FIj = nVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(oq oqVar) {
            Integer num;
            j jVar;
            oq.a aVar;
            AppMethodBeat.i(120641);
            oq oqVar2 = oqVar;
            String str = this.FIj.TAG;
            StringBuilder sb = new StringBuilder("onelinevideo event callback, retcode:");
            if (oqVar2 == null || (aVar = oqVar2.dUF) == null) {
                num = null;
            } else {
                num = Integer.valueOf(aVar.retCode);
            }
            Log.i(str, sb.append(num).append(", currVideoItem:").append(this.FIj.FHj).toString());
            if (!(oqVar2 == null || this.FIj.FHj == null || (((jVar = this.FIj.FHj) != null && jVar.ecf == 0) || oqVar2.dUF.retCode != -21112))) {
                com.tencent.mm.ac.d.h(new a(this, oqVar2));
            }
            AppMethodBeat.o(120641);
            return false;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ d FIn;
            final /* synthetic */ oq FIo;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar, oq oqVar) {
                super(0);
                this.FIn = dVar;
                this.FIo = oqVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                int i2;
                edt edt;
                String str;
                String str2 = null;
                AppMethodBeat.i(120640);
                j jVar = this.FIn.FIj.FHj;
                if (jVar != null) {
                    i2 = jVar.iXu;
                } else {
                    i2 = 0;
                }
                j jVar2 = this.FIn.FIj.FHj;
                if (jVar2 != null) {
                    edt = jVar2.Fpd;
                } else {
                    edt = null;
                }
                if (i2 > 0 && edt != null) {
                    String str3 = this.FIo.dUF.mediaId;
                    s sVar = s.Fny;
                    if (p.j(str3, s.cs(i2, edt.Url))) {
                        String str4 = this.FIn.FIj.TAG;
                        StringBuilder append = new StringBuilder().append(this.FIo.dUF.mediaId).append(" video source changed, filePath:");
                        StoryVideoView storyVideoView = this.FIn.FIj.FIc;
                        if (storyVideoView != null) {
                            str = storyVideoView.getFilePath();
                        } else {
                            str = null;
                        }
                        Log.i(str4, append.append(str).toString());
                        n.a(this.FIn.FIj, false, 2);
                        StoryVideoView storyVideoView2 = this.FIn.FIj.FIc;
                        if (storyVideoView2 != null) {
                            str2 = storyVideoView2.getFilePath();
                        }
                        com.tencent.mm.vfs.s.deleteFile(str2);
                        j jVar3 = this.FIn.FIj.FHj;
                        if (jVar3 != null) {
                            s sVar2 = s.Fny;
                            com.tencent.mm.plugin.story.i.n a2 = s.a(jVar3);
                            a2.frR();
                            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
                            j.b.fog().b(a2);
                        }
                        this.FIn.FIj.PF();
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(120640);
                return xVar;
            }
        }
    }

    public final void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        Integer num;
        StoryVideoView storyVideoView;
        AppMethodBeat.i(120650);
        p.h(viewGroup, "parent");
        this.FIf = 0;
        boolean I = I(viewGroup);
        String str = this.TAG;
        StringBuilder append = new StringBuilder("attachVideoView, parent:").append(viewGroup.hashCode()).append(", isVideoPause:").append(this.FHg).append(", currentSessionId:").append(this.FHh).append(", isPlayingVideoItem:").append(this.FHi).append(" videoView ");
        StoryVideoView storyVideoView2 = this.FIc;
        if (storyVideoView2 != null) {
            num = Integer.valueOf(storyVideoView2.hashCode());
        } else {
            num = null;
        }
        Log.printInfoStack(str, append.append(num).append(" sameParent ").append(I).append(" this:").append(hashCode()).toString(), new Object[0]);
        H(viewGroup);
        if (this.FIc == null) {
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            hm(context);
        }
        if (!I) {
            if (layoutParams == null) {
                viewGroup.addView(this.FIc);
                AppMethodBeat.o(120650);
                return;
            }
            viewGroup.addView(this.FIc, layoutParams);
            AppMethodBeat.o(120650);
        } else if (layoutParams == null || (storyVideoView = this.FIc) == null) {
            AppMethodBeat.o(120650);
        } else {
            storyVideoView.setLayoutParams(layoutParams);
            AppMethodBeat.o(120650);
        }
    }

    public final void a(com.tencent.mm.plugin.story.f.d.j jVar, boolean z) {
        AppMethodBeat.i(120652);
        p.h(jVar, "item");
        boolean z2 = !g(jVar);
        Log.printInfoStack(this.TAG, "change:" + z2 + ' ' + this.FHk + ", " + z + ", changeVideoItem: origin: " + this.FHj + ", new: " + jVar + ",  change:" + z2 + " this:" + hashCode(), new Object[0]);
        if (z2) {
            this.FHj = jVar;
            if (this.FHk || z) {
                a(this, false, 2);
                PF();
            }
        }
        AppMethodBeat.o(120652);
    }

    public final void PF() {
        AppMethodBeat.i(120653);
        Log.printInfoStack(this.TAG, "playVideo, " + this.FHg + ' ' + this.FHk + ", " + this.FHj, new Object[0]);
        fst();
        this.FHk = true;
        com.tencent.mm.plugin.story.f.d.j jVar = this.FHj;
        if (jVar != null) {
            boolean z = this.FHg;
            this.FHg = false;
            if (z) {
                StoryVideoView storyVideoView = this.FIc;
                if (storyVideoView != null) {
                    storyVideoView.o(jVar);
                }
            } else {
                this.FHh = UUID.randomUUID().toString();
                b bVar = this.FId;
                if (bVar != null) {
                    bVar.p(jVar);
                }
                StoryVideoView storyVideoView2 = this.FIc;
                if (storyVideoView2 != null) {
                    storyVideoView2.a(jVar, this.FHh);
                }
            }
            this.FHg = false;
            if (jVar.foW()) {
                this.FHi = true;
            }
            if (!this.FHm) {
                this.FHl.requestFocus();
                this.FHm = true;
            }
        }
        h hVar = h.FuH;
        jo fqi = h.fqi();
        StoryVideoView storyVideoView3 = this.FIc;
        fqi.sk((long) NetStatusUtil.getIOSNetType(storyVideoView3 != null ? storyVideoView3.getContext() : null));
        AppMethodBeat.o(120653);
    }

    /* access modifiers changed from: package-private */
    public final void fst() {
        AppMethodBeat.i(120654);
        Log.i(this.TAG, "setVideoViewProp, isMute:" + this.guh);
        StoryVideoView storyVideoView = this.FIc;
        if (storyVideoView != null) {
            storyVideoView.setMute(this.guh);
            AppMethodBeat.o(120654);
            return;
        }
        AppMethodBeat.o(120654);
    }

    public static /* synthetic */ void a(n nVar, boolean z, int i2) {
        AppMethodBeat.i(120656);
        if ((i2 & 2) != 0) {
            z = true;
        }
        nVar.aw(false, z);
        AppMethodBeat.o(120656);
    }

    public final void aw(boolean z, boolean z2) {
        AppMethodBeat.i(120655);
        Log.printInfoStack(this.TAG, "stopVideo, detach: ".concat(String.valueOf(z)), new Object[0]);
        if (this.FHi) {
            this.FHh = null;
            StoryVideoView storyVideoView = this.FIc;
            if (storyVideoView != null) {
                storyVideoView.stop();
            }
            this.FHg = false;
            if (this.FHm) {
                this.FHl.apm();
                this.FHm = false;
            }
            this.FHi = false;
        }
        if (z) {
            this.FHk = false;
            H(null);
            h hVar = h.FuH;
            h.fqi().so(System.currentTimeMillis());
            if (z2) {
                h hVar2 = h.FuH;
                h.fqj();
            }
        }
        AppMethodBeat.o(120655);
    }

    public final void setMute(boolean z) {
        AppMethodBeat.i(120657);
        p.g("", "if(BuildConfig.DEBUG) Ut…tack().toString() else \"\"");
        Log.i(this.TAG, "setMute " + z + " ret " + "");
        this.guh = z;
        AppMethodBeat.o(120657);
    }

    public final void onUIResume() {
        AppMethodBeat.i(120658);
        StoryVideoView storyVideoView = this.FIc;
        if (storyVideoView != null) {
            storyVideoView.onUIResume();
            AppMethodBeat.o(120658);
            return;
        }
        AppMethodBeat.o(120658);
    }

    public final void onUIPause() {
        AppMethodBeat.i(120659);
        Log.i(this.TAG, "onUIPause " + hashCode());
        H(null);
        if (this.FHm) {
            this.FHl.apm();
            this.FHm = false;
        }
        AppMethodBeat.o(120659);
    }

    public final void onUIDestroy() {
        AppMethodBeat.i(120660);
        Log.i(this.TAG, "onUIDestroy " + hashCode());
        this.FHk = false;
        H(null);
        this.FHj = null;
        this.FIc = null;
        if (this.FHm) {
            this.FHl.apm();
            this.FHm = false;
        }
        EventCenter.instance.removeListener(this.FIg);
        AppMethodBeat.o(120660);
    }

    /* access modifiers changed from: package-private */
    public final void hm(Context context) {
        AppMethodBeat.i(120661);
        this.FIc = new StoryVideoView(context);
        this.FId = new b();
        StoryVideoView storyVideoView = this.FIc;
        if (storyVideoView != null) {
            storyVideoView.setIOnlineVideoProxy(this.FId);
        }
        StoryVideoView storyVideoView2 = this.FIc;
        if (storyVideoView2 != null) {
            storyVideoView2.setIMMVideoViewCallback(this.FIh);
        }
        StoryVideoView storyVideoView3 = this.FIc;
        if (storyVideoView3 != null) {
            storyVideoView3.setReporter(new c(this));
        }
        this.FHi = false;
        AppMethodBeat.o(120661);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$initCreateVideoView$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IReport;", "idkeyStat", "", "ID", "", "key", "value", "isImportant", "", "kvStat", "logID", "", "val", "", "plugin-story_release"})
    public static final class c implements i.c {
        final /* synthetic */ n FIj;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(n nVar) {
            this.FIj = nVar;
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.c
        public final void yU(long j2) {
            AppMethodBeat.i(120639);
            StoryVideoView storyVideoView = this.FIj.FIc;
            if (storyVideoView != null) {
                if (!storyVideoView.FHS) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(this.FIj.FIe, j2, 1, false);
                    if (j2 >= 141 && j2 <= 145) {
                        Log.i(this.FIj.TAG, "initCreateVideoView test key " + j2 + " value 1 currVideoItem:" + this.FIj.FHj + ' ' + Util.getStack());
                    }
                }
                AppMethodBeat.o(120639);
                return;
            }
            AppMethodBeat.o(120639);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.c
        public final void DX(String str) {
        }
    }

    /* access modifiers changed from: package-private */
    public final void H(ViewGroup viewGroup) {
        int i2;
        ViewParent viewParent;
        ViewParent viewParent2;
        AppMethodBeat.i(120662);
        String str = this.TAG;
        StringBuilder sb = new StringBuilder("checkDetachVideoView, videoView:");
        StoryVideoView storyVideoView = this.FIc;
        if (storyVideoView != null) {
            i2 = storyVideoView.hashCode();
        } else {
            i2 = 0;
        }
        StringBuilder append = sb.append(i2).append(", isPlay:");
        StoryVideoView storyVideoView2 = this.FIc;
        StringBuilder append2 = append.append(storyVideoView2 != null ? storyVideoView2.isPlaying() : false).append(", parent:");
        StoryVideoView storyVideoView3 = this.FIc;
        ViewParent parent = storyVideoView3 != null ? storyVideoView3.getParent() : null;
        Log.printInfoStack(str, append2.append(parent != null ? parent.hashCode() : 0).append(", newParent:").append(viewGroup != null ? viewGroup.hashCode() : 0).append(", isPlayingVideoItem:").append(this.FHi).toString(), new Object[0]);
        StoryVideoView storyVideoView4 = this.FIc;
        if (storyVideoView4 != null) {
            viewParent = storyVideoView4.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent != null && !I(viewGroup)) {
            a(this, true, 1);
            StoryVideoView storyVideoView5 = this.FIc;
            if (storyVideoView5 != null) {
                viewParent2 = storyVideoView5.getParent();
            } else {
                viewParent2 = null;
            }
            if (viewParent2 == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(120662);
                throw tVar;
            }
            ((ViewGroup) viewParent2).removeView(this.FIc);
            this.FHj = null;
        }
        AppMethodBeat.o(120662);
    }

    private final boolean I(ViewGroup viewGroup) {
        AppMethodBeat.i(120663);
        StoryVideoView storyVideoView = this.FIc;
        boolean j2 = p.j(storyVideoView != null ? storyVideoView.getParent() : null, viewGroup);
        AppMethodBeat.o(120663);
        return j2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J,\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016J\u001c\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0013\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0014\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0015"}, hxF = {"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "onError", "", "sessionId", "", "mediaId", OpenSDKTool4Assistant.EXTRA_ERROR_MSG, "what", "", "extra", "onGetVideoSize", "width", "height", "onPrepared", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "plugin-story_release"})
    public static final class e implements i.b {
        final /* synthetic */ n FIj;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(n nVar) {
            this.FIj = nVar;
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void c(String str, String str2, String str3, int i2, int i3) {
            AppMethodBeat.i(120642);
            Log.i(this.FIj.TAG, "videoViewCallback onError: " + str + ", meidiaId:" + str2 + ", errorMsg:" + str3 + ", what:" + i2 + ", extra:" + i3);
            AppMethodBeat.o(120642);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dH(String str, String str2) {
            AppMethodBeat.i(120643);
            Log.i(this.FIj.TAG, "videoViewCallback onPrepared: " + str + ", meidiaId:" + str2);
            AppMethodBeat.o(120643);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dI(String str, String str2) {
            b.a aVar;
            AppMethodBeat.i(120644);
            Log.i(this.FIj.TAG, "videoViewCallback onVideoEnded: " + str + ", meidiaId:" + str2);
            h hVar = h.FuH;
            jo fqi = h.fqi();
            fqi.sv(fqi.ahF() + 1);
            com.tencent.mm.plugin.story.f.d.j jVar = this.FIj.FHj;
            if (jVar != null) {
                com.tencent.mm.plugin.story.h.b bVar = com.tencent.mm.plugin.story.h.b.FtL;
                long j2 = jVar.edx;
                if (com.tencent.mm.plugin.story.h.b.beE()) {
                    Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", "onVideoEnd ".concat(String.valueOf(j2)));
                    if (com.tencent.mm.plugin.story.h.b.Ftx.containsKey(Long.valueOf(j2)) && (aVar = com.tencent.mm.plugin.story.h.b.Ftx.get(Long.valueOf(j2))) != null) {
                        aVar.idt = true;
                        AppMethodBeat.o(120644);
                        return;
                    }
                }
                AppMethodBeat.o(120644);
                return;
            }
            AppMethodBeat.o(120644);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void d(String str, String str2, int i2, int i3) {
            AppMethodBeat.i(120645);
            Log.i(this.FIj.TAG, "videoViewCallback onGetVideoSize: " + str + ", " + this.FIj.FHh + ", meidiaId:" + str2);
            AppMethodBeat.o(120645);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dJ(String str, String str2) {
            AppMethodBeat.i(120646);
            Log.i(this.FIj.TAG, "videoViewCallback onVideoPause: " + str + ", meidiaId:" + str2);
            AppMethodBeat.o(120646);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dK(String str, String str2) {
            String str3;
            b.a aVar;
            StoryVideoView storyVideoView;
            AppMethodBeat.i(120647);
            String str4 = this.FIj.TAG;
            StringBuilder append = new StringBuilder("videoViewCallback onVideoPlay: ").append(str).append(' ');
            StoryVideoView storyVideoView2 = this.FIj.FIc;
            if (storyVideoView2 != null) {
                str3 = storyVideoView2.getSessionId();
            } else {
                str3 = null;
            }
            Log.i(str4, append.append(str3).append(", ").append(this.FIj.FHh).append(", meidiaId:").append(str2).append(", isVideoPause:").append(this.FIj.FHg).toString());
            if (kotlin.n.n.I(str, this.FIj.FHh, false) && this.FIj.FHg && (storyVideoView = this.FIj.FIc) != null && !storyVideoView.FHS) {
                this.FIj.H(null);
            }
            com.tencent.mm.plugin.story.f.d.j jVar = this.FIj.FHj;
            if (jVar != null) {
                com.tencent.mm.plugin.story.h.c cVar = com.tencent.mm.plugin.story.h.c.Fuf;
                com.tencent.mm.plugin.story.h.c.Kq(jVar.edx);
                com.tencent.mm.plugin.story.h.b bVar = com.tencent.mm.plugin.story.h.b.FtL;
                long j2 = jVar.edx;
                if (com.tencent.mm.plugin.story.h.b.beE()) {
                    StringBuilder append2 = new StringBuilder("onVideoPlay storyId ").append(j2).append(" lastStoryId ").append(com.tencent.mm.plugin.story.h.b.Ftw).append(" contains:").append(com.tencent.mm.plugin.story.h.b.Ftx.containsKey(Long.valueOf(j2))).append(" result");
                    b.a aVar2 = com.tencent.mm.plugin.story.h.b.Ftx.get(Long.valueOf(j2));
                    Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", append2.append(aVar2 != null ? Long.valueOf(aVar2.FtO) : null).toString());
                    if (j2 == com.tencent.mm.plugin.story.h.b.Ftw && com.tencent.mm.plugin.story.h.b.Ftx.containsKey(Long.valueOf(j2)) && (aVar = com.tencent.mm.plugin.story.h.b.Ftx.get(Long.valueOf(j2))) != null && !aVar.Eva && aVar.FtO <= 0 && aVar.FtN > 0) {
                        aVar.isWaiting = false;
                        long milliSecondsToNow = Util.milliSecondsToNow(aVar.FtN);
                        aVar.FtO = Util.nowMilliSecond();
                        if (milliSecondsToNow > 120000) {
                            Log.w("MicroMsg.StoryBrowseDetailIDKeyStat", "onPlayCostTime  storyId " + j2 + " onPlayCostTime:" + milliSecondsToNow);
                        } else {
                            Log.i("MicroMsg.StoryBrowseDetailIDKeyStat", "onPlayCostTime  storyId " + j2 + " onPlayCostTime:" + milliSecondsToNow);
                            com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 31, milliSecondsToNow);
                            com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 30, 1);
                            if (milliSecondsToNow <= 400) {
                                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 90, 1);
                            } else if (milliSecondsToNow <= 800) {
                                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 91, 1);
                            } else if (milliSecondsToNow <= 1600) {
                                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 92, 1);
                            } else if (milliSecondsToNow <= 3200) {
                                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 93, 1);
                            } else if (milliSecondsToNow <= 5000) {
                                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 94, 1);
                            } else {
                                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 95, 1);
                            }
                            if (milliSecondsToNow <= 400) {
                                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 50, 1);
                            } else if (milliSecondsToNow <= 800) {
                                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 51, 1);
                            } else if (milliSecondsToNow <= 1000) {
                                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 52, 1);
                            } else if (milliSecondsToNow <= 2000) {
                                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 53, 1);
                            } else if (milliSecondsToNow <= 3000) {
                                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 54, 1);
                            } else if (milliSecondsToNow <= 4000) {
                                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 55, 1);
                            } else {
                                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 56, 1);
                            }
                            if (j2 == com.tencent.mm.plugin.story.h.b.Ftz) {
                                if (com.tencent.mm.plugin.story.h.b.FtD) {
                                    com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 40, 1);
                                    com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 42, milliSecondsToNow);
                                } else {
                                    com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 41, 1);
                                    com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 43, milliSecondsToNow);
                                }
                                if (milliSecondsToNow <= 1000) {
                                    if (com.tencent.mm.plugin.story.h.b.FtD) {
                                        com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 44, 1);
                                    } else {
                                        com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 45, 1);
                                    }
                                } else if (milliSecondsToNow <= 2000) {
                                    if (com.tencent.mm.plugin.story.h.b.FtD) {
                                        com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 46, 1);
                                    } else {
                                        com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 47, 1);
                                    }
                                } else if (com.tencent.mm.plugin.story.h.b.FtD) {
                                    com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 48, 1);
                                } else {
                                    com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 49, 1);
                                }
                            }
                        }
                    }
                }
                m.FHB.KD(jVar.edx);
                k kVar = k.FmH;
                k.aRR(jVar.username);
                AppMethodBeat.o(120647);
                return;
            }
            AppMethodBeat.o(120647);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dL(String str, String str2) {
            b.a aVar;
            AppMethodBeat.i(120648);
            Log.i(this.FIj.TAG, "videoViewCallback onVideoWaiting: " + str + ", meidiaId:" + str2);
            com.tencent.mm.plugin.story.f.d.j jVar = this.FIj.FHj;
            if (jVar != null) {
                com.tencent.mm.plugin.story.h.c cVar = com.tencent.mm.plugin.story.h.c.Fuf;
                com.tencent.mm.plugin.story.h.c.Kp(jVar.edx);
                com.tencent.mm.plugin.story.h.b bVar = com.tencent.mm.plugin.story.h.b.FtL;
                long j2 = jVar.edx;
                if (!com.tencent.mm.plugin.story.h.b.beE() || !com.tencent.mm.plugin.story.h.b.Ftx.containsKey(Long.valueOf(j2)) || (aVar = com.tencent.mm.plugin.story.h.b.Ftx.get(Long.valueOf(j2))) == null || aVar.Eva || !aVar.FtP) {
                    AppMethodBeat.o(120648);
                    return;
                }
                aVar.isWaiting = true;
                AppMethodBeat.o(120648);
                return;
            }
            AppMethodBeat.o(120648);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void dM(String str, String str2) {
            String str3;
            AppMethodBeat.i(120649);
            String str4 = this.FIj.TAG;
            StringBuilder append = new StringBuilder("videoViewCallback onVideoWaitingEnd: ").append(str).append(' ');
            StoryVideoView storyVideoView = this.FIj.FIc;
            if (storyVideoView != null) {
                str3 = storyVideoView.getSessionId();
            } else {
                str3 = null;
            }
            Log.i(str4, append.append(str3).append(", ").append(this.FIj.FHh).append(", meidiaId:").append(str2).append(", isVideoPause:").append(this.FIj.FHg).toString());
            if (kotlin.n.n.I(str, this.FIj.FHh, false) && this.FIj.FHg) {
                StoryVideoView storyVideoView2 = this.FIj.FIc;
                if (storyVideoView2 == null) {
                    AppMethodBeat.o(120649);
                    return;
                } else if (!storyVideoView2.FHS) {
                    this.FIj.H(null);
                }
            }
            AppMethodBeat.o(120649);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.b
        public final void fo(String str, String str2) {
            AppMethodBeat.i(222933);
            Log.i(this.FIj.TAG, "onVideoFirstFrameDraw: " + str + ", meidiaId:" + str2);
            AppMethodBeat.o(222933);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018H\u0002¢\u0006\u0002\u0010\u001aJ2\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\n\u0010 \u001a\u00060!R\u00020\"H\u0002J \u0010#\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0010H\u0016J \u0010&\u001a\u00020'2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0010H\u0016J\u0012\u0010(\u001a\u00020'2\b\u0010 \u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010)\u001a\u00020'2\u0006\u0010\u0007\u001a\u00020\bJ&\u0010*\u001a\u00020'2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010+\u001a\u00020'2\u0006\u0010\u001d\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayProxy;", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;)V", "TAG", "", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "preloadFinish", "", "getPreloadFinish", "()Z", "setPreloadFinish", "(Z)V", "preloadSize", "", "getPreloadSize", "()I", "setPreloadSize", "(I)V", "videoCache", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "createReportRptTips", "", "", "()[Ljava/lang/Object;", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "url", "path", "callback", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayCdnCallback;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "isVideoDataAvailable", "offset", "length", "requestVideoData", "", "setIEngineCallback", "setStoryVideoItem", "startHttpStream", "stop", "plugin-story_release"})
    public final class b implements com.tencent.mm.modelvideo.b {
        boolean FHO;
        com.tencent.mm.plugin.story.f.d.j FHP;
        com.tencent.mm.plugin.story.i.n FIi;
        final String TAG = "MicroMsg.VideoPlayProxy";
        int dRQ;
        private b.a qWn;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        public final void p(com.tencent.mm.plugin.story.f.d.j jVar) {
            AppMethodBeat.i(120634);
            p.h(jVar, "item");
            this.FHP = jVar;
            s sVar = s.Fny;
            this.FIi = s.a(jVar);
            Log.i(this.TAG, "setStoryVideoItem " + jVar + " videoCache " + this.FIi);
            AppMethodBeat.o(120634);
        }

        @Override // com.tencent.mm.modelvideo.b
        public final void p(String str, String str2, String str3) {
            Integer num;
            boolean z;
            com.tencent.mm.plugin.story.i.n nVar;
            edt edt;
            b.a aVar;
            int i2 = 0;
            Integer num2 = null;
            AppMethodBeat.i(120635);
            Log.i(this.TAG, "startHttpStream " + str + ' ' + str2 + ' ' + str3 + " this:" + this);
            if (this.FHP != null) {
                s sVar = s.Fny;
                com.tencent.mm.plugin.story.f.d.j jVar = this.FHP;
                if (jVar == null) {
                    p.hyc();
                }
                this.FIi = s.a(jVar);
                com.tencent.mm.plugin.story.i.n nVar2 = this.FIi;
                if (nVar2 != null && !com.tencent.mm.vfs.s.YS(nVar2.field_filePath)) {
                    com.tencent.mm.plugin.story.f.l lVar = com.tencent.mm.plugin.story.f.l.FmK;
                    String str4 = nVar2.field_filePath;
                    p.g(str4, "it.field_filePath");
                    com.tencent.mm.plugin.story.f.l.aRX(str4);
                    Log.i(this.TAG, "startHttpStream error downloadFinish " + nVar2.alN() + " ret:" + com.tencent.mm.vfs.s.YS(nVar2.field_filePath) + " path:" + nVar2.field_filePath);
                    nVar2.frR();
                    j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
                    j.b.fog().b(nVar2);
                }
                com.tencent.mm.plugin.story.f.d.j jVar2 = n.this.FHj;
                if (jVar2 != null) {
                    com.tencent.mm.plugin.story.h.c cVar = com.tencent.mm.plugin.story.h.c.Fuf;
                    com.tencent.mm.plugin.story.h.c.fpS();
                    com.tencent.mm.plugin.story.h.b bVar2 = com.tencent.mm.plugin.story.h.b.FtL;
                    long j2 = jVar2.edx;
                    if (com.tencent.mm.plugin.story.h.b.beE()) {
                        Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", "startHttp storyId ".concat(String.valueOf(j2)));
                        if (com.tencent.mm.plugin.story.h.b.Ftx.containsKey(Long.valueOf(j2)) && (aVar = com.tencent.mm.plugin.story.h.b.Ftx.get(Long.valueOf(j2))) != null) {
                            aVar.FtP = true;
                        }
                    }
                }
                com.tencent.mm.plugin.story.f.d.j jVar3 = this.FHP;
                if (!Util.isNullOrNil((jVar3 == null || (edt = jVar3.Fpd) == null) ? null : edt.Url)) {
                    n nVar3 = n.this;
                    nVar3.FIf++;
                    StoryVideoView storyVideoView = nVar3.FIc;
                    if (storyVideoView != null) {
                        storyVideoView.setNeedShowLoading(true);
                    }
                    a aVar2 = new a();
                    aVar2.qWn = this.qWn;
                    aVar2.a(this.FIi, this.FHP);
                    com.tencent.mm.i.h hVar = new com.tencent.mm.i.h();
                    hVar.taskName = "task_StoryVideoViewMgr";
                    a aVar3 = new a();
                    aVar3.qWn = this.qWn;
                    aVar3.a(this.FIi, this.FHP);
                    hVar.field_mediaId = str;
                    hVar.url = str3;
                    hVar.gqU = 1;
                    hVar.gqP = 6;
                    hVar.concurrentCount = 4;
                    hVar.field_fullpath = str2;
                    hVar.gre = aVar2;
                    hVar.field_fileType = com.tencent.mm.i.a.gpV;
                    hVar.field_requestVideoFormat = com.tencent.mm.modelcontrol.e.L(1, str2);
                    m mVar = m.FHB;
                    com.tencent.mm.plugin.story.f.d.j jVar4 = this.FHP;
                    if (jVar4 == null) {
                        p.hyc();
                    }
                    m.j(jVar4);
                    com.tencent.mm.plugin.story.f.d.j jVar5 = n.this.FHj;
                    if (jVar5 != null) {
                        com.tencent.mm.plugin.story.h.b bVar3 = com.tencent.mm.plugin.story.h.b.FtL;
                        long j3 = jVar5.edx;
                        if (this.FIi == null || ((nVar = this.FIi) != null && nVar.field_cacheSize == 0)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        com.tencent.mm.plugin.story.h.b.M(j3, z);
                    }
                    o.bhk().e(hVar);
                    if (!(this.FHP == null || str == null)) {
                        m mVar2 = m.FHB;
                        com.tencent.mm.plugin.story.f.d.j jVar6 = this.FHP;
                        if (jVar6 == null) {
                            p.hyc();
                        }
                        m.b k = m.k(jVar6);
                        if (k.uTW && !aVar2.uTW) {
                            String str5 = this.TAG;
                            StringBuilder append = new StringBuilder("checkPreloadOnVideoPlay ").append(str).append(", moovReady, offset:").append(k.offset).append(", length:").append(k.length).append(", cacheSize:");
                            com.tencent.mm.plugin.story.i.n nVar4 = this.FIi;
                            if (nVar4 != null) {
                                num = Integer.valueOf(nVar4.field_cacheSize);
                            } else {
                                num = null;
                            }
                            StringBuilder append2 = append.append(num).append(", totalSize:");
                            com.tencent.mm.plugin.story.i.n nVar5 = this.FIi;
                            if (nVar5 != null) {
                                num2 = Integer.valueOf(nVar5.field_totalSize);
                            }
                            Log.i(str5, append2.append(num2).append(", preloadFinish:").append(k.FHO).toString());
                            if (k.offset > 0 && k.length > 0) {
                                aVar2.a(str, k.offset, k.length, "");
                                com.tencent.mm.plugin.story.i.n nVar6 = this.FIi;
                                if (nVar6 != null) {
                                    i2 = nVar6.field_cacheSize;
                                }
                                this.dRQ = i2;
                                this.FHO = k.FHO;
                            }
                        }
                    }
                }
            }
            AppMethodBeat.o(120635);
        }

        @Override // com.tencent.mm.modelvideo.b
        public final void he(String str) {
            Integer num;
            Integer num2;
            Integer num3;
            Integer num4;
            Integer num5;
            Integer num6;
            int i2;
            String str2;
            long j2;
            int i3 = 2;
            int i4 = 1;
            Long l = null;
            AppMethodBeat.i(120636);
            p.h(str, "mediaId");
            Log.i(this.TAG, "this: " + this + " stop " + str + ' ' + Util.getStack());
            Object[] objArr = new Object[17];
            StoryVideoView storyVideoView = n.this.FIc;
            objArr[0] = storyVideoView != null ? Integer.valueOf(storyVideoView.getCurrPosMs()) : 0;
            StoryVideoView storyVideoView2 = n.this.FIc;
            if (storyVideoView2 != null) {
                num = Integer.valueOf((int) storyVideoView2.getFirstPlayWaitTime());
            } else {
                num = null;
            }
            objArr[1] = num;
            StoryVideoView storyVideoView3 = n.this.FIc;
            if (storyVideoView3 != null) {
                num2 = Integer.valueOf(storyVideoView3.fsH());
            } else {
                num2 = null;
            }
            objArr[2] = num2;
            StoryVideoView storyVideoView4 = n.this.FIc;
            if (storyVideoView4 != null) {
                num3 = Integer.valueOf(storyVideoView4.fsI());
            } else {
                num3 = null;
            }
            objArr[3] = num3;
            StoryVideoView storyVideoView5 = n.this.FIc;
            if (storyVideoView5 != null) {
                num4 = Integer.valueOf(storyVideoView5.fsJ());
            } else {
                num4 = null;
            }
            objArr[4] = num4;
            StoryVideoView storyVideoView6 = n.this.FIc;
            if (storyVideoView6 != null) {
                num5 = Integer.valueOf(storyVideoView6.getStayTime());
            } else {
                num5 = null;
            }
            objArr[5] = num5;
            StoryVideoView storyVideoView7 = n.this.FIc;
            if (storyVideoView7 != null) {
                num6 = Integer.valueOf(storyVideoView7.getErrorCode());
            } else {
                num6 = null;
            }
            objArr[6] = num6;
            objArr[7] = Integer.valueOf(this.dRQ);
            if (this.dRQ > 0) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            objArr[8] = Integer.valueOf(i2);
            if (this.FHO) {
                i3 = 3;
            }
            objArr[9] = Integer.valueOf(i3);
            b.a aVar = com.tencent.mm.plugin.story.e.b.FlA;
            StoryVideoView storyVideoView8 = n.this.FIc;
            if (storyVideoView8 == null || (str2 = storyVideoView8.getFilePath()) == null) {
                str2 = "";
            }
            objArr[10] = b.a.aRO(str2);
            com.tencent.mm.plugin.story.f.d.j jVar = this.FHP;
            if (jVar != null) {
                l = Long.valueOf(jVar.edx);
            }
            objArr[11] = l;
            h hVar = h.FuH;
            objArr[12] = Long.valueOf(h.fqi().ahw());
            h hVar2 = h.FuH;
            objArr[13] = Long.valueOf(h.fqi().ahy());
            h hVar3 = h.FuH;
            if (h.fqi().ahB() != 1) {
                i4 = 0;
            }
            objArr[14] = Integer.valueOf(i4);
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            com.tencent.mm.plugin.story.i.k foc = j.b.foc();
            com.tencent.mm.plugin.story.f.d.j jVar2 = this.FHP;
            if (jVar2 != null) {
                j2 = jVar2.edx;
            } else {
                j2 = 0;
            }
            objArr[15] = Integer.valueOf(foc.KB(j2));
            objArr[16] = Integer.valueOf(n.this.FIf);
            Log.i(this.TAG, "reportTips: " + Arrays.toString(objArr));
            o.bhk().l(str, objArr);
            AppMethodBeat.o(120636);
        }

        @Override // com.tencent.mm.modelvideo.b
        public final void requestVideoData(String str, int i2, int i3) {
            AppMethodBeat.i(120637);
            p.h(str, "mediaId");
            com.tencent.mm.ac.d.h(new a(this, str, i2, i3));
            AppMethodBeat.o(120637);
        }

        @Override // com.tencent.mm.modelvideo.b
        public final boolean isVideoDataAvailable(String str, int i2, int i3) {
            Integer num = null;
            AppMethodBeat.i(120638);
            p.h(str, "mediaId");
            com.tencent.mm.plugin.story.f.d.j jVar = this.FHP;
            if (jVar != null) {
                s sVar = s.Fny;
                this.FIi = s.a(jVar);
                com.tencent.mm.plugin.story.i.n nVar = this.FIi;
                if (nVar != null && nVar.alN()) {
                    String str2 = this.TAG;
                    StringBuilder append = new StringBuilder("isVideoDataAvailable ").append(str).append(", ").append(i2).append(", ").append(i3).append(", download finish cacheSize:");
                    com.tencent.mm.plugin.story.i.n nVar2 = this.FIi;
                    if (nVar2 != null) {
                        num = Integer.valueOf(nVar2.field_cacheSize);
                    }
                    Log.i(str2, append.append(num).append(" this:").append(this).toString());
                    AppMethodBeat.o(120638);
                    return true;
                }
            }
            boolean isVideoDataAvailable = o.bhk().isVideoDataAvailable(str, i2, i3);
            String str3 = this.TAG;
            StringBuilder append2 = new StringBuilder("isVideoDataAvailable ").append(str).append(", ").append(i2).append(", ").append(i3).append(", available:").append(isVideoDataAvailable).append(" cacheSize:");
            com.tencent.mm.plugin.story.i.n nVar3 = this.FIi;
            if (nVar3 != null) {
                num = Integer.valueOf(nVar3.field_cacheSize);
            }
            Log.i(str3, append2.append(num).append(" this:").append(this).toString());
            AppMethodBeat.o(120638);
            return isVideoDataAvailable;
        }

        @Override // com.tencent.mm.modelvideo.b
        public final void a(b.a aVar) {
            this.qWn = aVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ b FIl;
            final /* synthetic */ int FIm;
            final /* synthetic */ int gUs;
            final /* synthetic */ String qWs;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar, String str, int i2, int i3) {
                super(0);
                this.FIl = bVar;
                this.qWs = str;
                this.gUs = i2;
                this.FIm = i3;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(120633);
                com.tencent.mm.plugin.story.f.d.j jVar = this.FIl.FHP;
                if (jVar != null) {
                    b bVar = this.FIl;
                    s sVar = s.Fny;
                    bVar.FIi = s.a(jVar);
                }
                o.bhk();
                int r = com.tencent.mm.an.e.r(this.qWs, this.gUs, this.FIm);
                String str = this.FIl.TAG;
                StringBuilder append = new StringBuilder("requestVideoData ").append(this.qWs).append(' ').append(this.gUs).append(' ').append(this.FIm).append(' ');
                com.tencent.mm.plugin.story.i.n nVar = this.FIl.FIi;
                Log.i(str, append.append(nVar != null ? Integer.valueOf(nVar.field_cacheSize) : null).append(", ret:").append(r).append(" this:").append(this.FIl).toString());
                x xVar = x.SXb;
                AppMethodBeat.o(120633);
                return xVar;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\"\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0016J*\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0016J \u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011H\u0016J\u0010\u0010\u001e\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0006J\u001a\u0010 \u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010!\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayCdnCallback;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;)V", "TAG", "", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "isMoovReady", "", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "videoCache", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "onDataAvailable", "", "mediaId", "offset", "", "length", "onFinish", "ret", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onM3U8Ready", "m3u8", "onMoovReady", "svrflag", "onProgress", "total", "setIEngineCallback", "callback", "setVideoCache", "vitem", "plugin-story_release"})
    final class a implements h.a {
        com.tencent.mm.plugin.story.f.d.j FHP;
        com.tencent.mm.plugin.story.i.n FIi;
        final String TAG = "MicroMsg.VideoPlayProxy";
        b.a qWn;
        volatile boolean uTW;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        public final void a(com.tencent.mm.plugin.story.i.n nVar, com.tencent.mm.plugin.story.f.d.j jVar) {
            this.FIi = nVar;
            this.FHP = jVar;
        }

        @Override // com.tencent.mm.i.h.a
        public final void Ds(String str) {
            AppMethodBeat.i(222931);
            p.h(str, "mediaId");
            AppMethodBeat.o(222931);
        }

        @Override // com.tencent.mm.i.h.a
        public final void a(String str, long j2, long j3, String str2) {
            String str3;
            AppMethodBeat.i(222932);
            p.h(str, "mediaId");
            String str4 = this.TAG;
            StringBuilder append = new StringBuilder("onMoovReady, mediaId:").append(str).append(", offset:").append(j2).append(", length:").append(j3).append(", isMoovReady:").append(this.uTW).append(" this:").append(this).append(" currVideoItem:");
            com.tencent.mm.plugin.story.f.d.j jVar = n.this.FHj;
            if (jVar != null) {
                str3 = jVar.username;
            } else {
                str3 = null;
            }
            Log.i(str4, append.append(str3).toString());
            if (this.uTW) {
                AppMethodBeat.o(222932);
                return;
            }
            this.uTW = true;
            com.tencent.mm.ac.d.h(new c(this, str, j2, j3, str2));
            AppMethodBeat.o(222932);
        }

        @Override // com.tencent.mm.i.h.a
        public final void onDataAvailable(String str, long j2, long j3) {
            String str2;
            AppMethodBeat.i(120630);
            p.h(str, "mediaId");
            String str3 = this.TAG;
            StringBuilder append = new StringBuilder("onDataAvailable, mediaId:").append(str).append(", offset:").append(j2).append(", length:").append(j3).append(" this:").append(this).append(" currVideoItem:");
            com.tencent.mm.plugin.story.f.d.j jVar = n.this.FHj;
            if (jVar != null) {
                str2 = jVar.username;
            } else {
                str2 = null;
            }
            Log.i(str3, append.append(str2).toString());
            com.tencent.mm.ac.d.h(new C1787a(this, str, j2, j3));
            AppMethodBeat.o(120630);
        }

        @Override // com.tencent.mm.i.h.a
        public final void i(String str, long j2, long j3) {
            String str2;
            AppMethodBeat.i(120631);
            p.h(str, "mediaId");
            String str3 = this.TAG;
            StringBuilder append = new StringBuilder("onProgress, mediaId:").append(str).append(", offset:").append(j2).append(", total:").append(j3).append(" this:").append(this).append(" currVideoItem:");
            com.tencent.mm.plugin.story.f.d.j jVar = n.this.FHj;
            if (jVar != null) {
                str2 = jVar.username;
            } else {
                str2 = null;
            }
            Log.i(str3, append.append(str2).toString());
            com.tencent.mm.ac.d.h(new d(this, str, j2, j3));
            AppMethodBeat.o(120631);
        }

        @Override // com.tencent.mm.i.h.a
        public final void a(String str, int i2, com.tencent.mm.i.d dVar) {
            long j2;
            long j3;
            String[] strArr = null;
            AppMethodBeat.i(120632);
            p.h(str, "mediaId");
            String str2 = this.TAG;
            StringBuilder append = new StringBuilder("onFinish, mediaId:").append(str).append(", ret:").append(i2).append(", sceneResult:").append(dVar != null ? dVar.field_retCode : 0).append(" this:").append(this).append(" currVideoItem:");
            com.tencent.mm.plugin.story.f.d.j jVar = n.this.FHj;
            Log.i(str2, append.append(jVar != null ? jVar.username : null).toString());
            com.tencent.mm.plugin.story.f.d.j jVar2 = this.FHP;
            if (jVar2 != null) {
                com.tencent.mm.plugin.story.h.b bVar = com.tencent.mm.plugin.story.h.b.FtL;
                com.tencent.mm.plugin.story.h.b.Ko(jVar2.edx);
                m.FHB.KE(jVar2.edx);
            }
            com.tencent.mm.plugin.story.i.n nVar = this.FIi;
            com.tencent.mm.plugin.sight.base.a aNx = com.tencent.mm.plugin.sight.base.e.aNx(nVar != null ? nVar.field_filePath : null);
            if (aNx != null) {
                com.tencent.mm.plugin.story.h.h hVar = com.tencent.mm.plugin.story.h.h.FuH;
                com.tencent.mm.plugin.story.h.h.fqw().rQ((long) aNx.videoDuration);
                com.tencent.mm.plugin.story.h.h hVar2 = com.tencent.mm.plugin.story.h.h.FuH;
                com.tencent.mm.plugin.story.h.h.fqw().rR((long) aNx.videoBitrate);
                com.tencent.mm.plugin.story.h.h hVar3 = com.tencent.mm.plugin.story.h.h.FuH;
                com.tencent.mm.plugin.story.h.h.fqw().rS((long) aNx.audioBitrate);
                com.tencent.mm.plugin.story.h.h hVar4 = com.tencent.mm.plugin.story.h.h.FuH;
                com.tencent.mm.plugin.story.h.h.fqw().rT((long) aNx.frameRate);
                com.tencent.mm.plugin.story.h.h hVar5 = com.tencent.mm.plugin.story.h.h.FuH;
                com.tencent.mm.plugin.story.h.h.fqw().rU((long) aNx.width);
                com.tencent.mm.plugin.story.h.h hVar6 = com.tencent.mm.plugin.story.h.h.FuH;
                com.tencent.mm.plugin.story.h.h.fqw().rV((long) aNx.height);
                com.tencent.mm.plugin.story.h.h hVar7 = com.tencent.mm.plugin.story.h.h.FuH;
                com.tencent.mm.plugin.story.h.h.fqw().rW((long) aNx.audioChannel);
            }
            com.tencent.mm.plugin.story.h.h hVar8 = com.tencent.mm.plugin.story.h.h.FuH;
            jh fqw = com.tencent.mm.plugin.story.h.h.fqw();
            if (this.FIi != null) {
                com.tencent.mm.plugin.story.i.n nVar2 = this.FIi;
                if (nVar2 == null) {
                    p.hyc();
                }
                j2 = (long) nVar2.field_totalSize;
            } else {
                j2 = 0;
            }
            fqw.rP(j2);
            com.tencent.mm.plugin.story.h.h hVar9 = com.tencent.mm.plugin.story.h.h.FuH;
            jh fqw2 = com.tencent.mm.plugin.story.h.h.fqw();
            com.tencent.mm.plugin.story.i.n nVar3 = this.FIi;
            fqw2.wK(nVar3 != null ? nVar3.field_url : null);
            com.tencent.mm.plugin.story.h.h hVar10 = com.tencent.mm.plugin.story.h.h.FuH;
            jh fqw3 = com.tencent.mm.plugin.story.h.h.fqw();
            f.baR();
            com.tencent.mm.plugin.story.i.n nVar4 = this.FIi;
            fqw3.wL(com.tencent.mm.an.a.NX(nVar4 != null ? nVar4.field_filePath : null));
            if (dVar != null) {
                com.tencent.mm.plugin.story.h.h hVar11 = com.tencent.mm.plugin.story.h.h.FuH;
                com.tencent.mm.plugin.story.h.h.fqw().rN(dVar.field_startTime);
                com.tencent.mm.plugin.story.h.h hVar12 = com.tencent.mm.plugin.story.h.h.FuH;
                com.tencent.mm.plugin.story.h.h.fqw().rO(dVar.field_endTime);
            }
            if (dVar != null) {
                strArr = dVar.field_usedSvrIps;
            }
            if (strArr != null) {
                StringBuffer stringBuffer = new StringBuffer();
                for (String str3 : dVar.field_usedSvrIps) {
                    stringBuffer.append(str3).append("|");
                }
                com.tencent.mm.plugin.story.h.h hVar13 = com.tencent.mm.plugin.story.h.h.FuH;
                com.tencent.mm.plugin.story.h.h.fqw().wM(stringBuffer.toString());
            }
            if (n.this.FId != null) {
                com.tencent.mm.plugin.story.h.h hVar14 = com.tencent.mm.plugin.story.h.h.FuH;
                jh fqw4 = com.tencent.mm.plugin.story.h.h.fqw();
                b bVar2 = n.this.FId;
                if (bVar2 == null) {
                    p.hyc();
                }
                fqw4.rX((long) bVar2.dRQ);
                com.tencent.mm.plugin.story.h.h hVar15 = com.tencent.mm.plugin.story.h.h.FuH;
                jh fqw5 = com.tencent.mm.plugin.story.h.h.fqw();
                b bVar3 = n.this.FId;
                if (bVar3 == null) {
                    p.hyc();
                }
                if (bVar3.FHO) {
                    j3 = 3;
                } else {
                    b bVar4 = n.this.FId;
                    if (bVar4 == null) {
                        p.hyc();
                    }
                    j3 = bVar4.dRQ > 0 ? 2 : 1;
                }
                fqw5.rY(j3);
            }
            com.tencent.mm.plugin.story.h.h hVar16 = com.tencent.mm.plugin.story.h.h.FuH;
            com.tencent.mm.plugin.story.h.h.fqx();
            com.tencent.mm.ac.d.h(new b(this, str, i2));
            AppMethodBeat.o(120632);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        public static final class c extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ a FIk;
            final /* synthetic */ String qWs;
            final /* synthetic */ long qWt;
            final /* synthetic */ long qWu;
            final /* synthetic */ String qWw;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(a aVar, String str, long j2, long j3, String str2) {
                super(0);
                this.FIk = aVar;
                this.qWs = str;
                this.qWt = j2;
                this.qWu = j3;
                this.qWw = str2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(120627);
                StoryVideoView storyVideoView = n.this.FIc;
                if (storyVideoView != null) {
                    storyVideoView.AI(this.qWt);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(120627);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.n$a$a  reason: collision with other inner class name */
        static final class C1787a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ a FIk;
            final /* synthetic */ String qWs;
            final /* synthetic */ long qWt;
            final /* synthetic */ long qWu;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1787a(a aVar, String str, long j2, long j3) {
                super(0);
                this.FIk = aVar;
                this.qWs = str;
                this.qWt = j2;
                this.qWu = j3;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(120625);
                StoryVideoView storyVideoView = n.this.FIc;
                if (storyVideoView != null) {
                    storyVideoView.onDataAvailable(this.qWs, this.qWt, this.qWu);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(120625);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class d extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ a FIk;
            final /* synthetic */ String qWs;
            final /* synthetic */ long qWt;
            final /* synthetic */ long qWx;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(a aVar, String str, long j2, long j3) {
                super(0);
                this.FIk = aVar;
                this.qWs = str;
                this.qWt = j2;
                this.qWx = j3;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX WARNING: Removed duplicated region for block: B:12:0x005d  */
            /* JADX WARNING: Removed duplicated region for block: B:42:0x0180  */
            @Override // kotlin.g.a.a
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final /* synthetic */ kotlin.x invoke() {
                /*
                // Method dump skipped, instructions count: 395
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.ui.view.gallery.n.a.d.invoke():java.lang.Object");
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class b extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ a FIk;
            final /* synthetic */ String qWs;
            final /* synthetic */ int qWv;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(a aVar, String str, int i2) {
                super(0);
                this.FIk = aVar;
                this.qWs = str;
                this.qWv = i2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(120626);
                b.a aVar = this.FIk.qWn;
                if (aVar != null) {
                    aVar.ax(this.qWs, this.qWv);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(120626);
                return xVar;
            }
        }
    }

    private final boolean g(com.tencent.mm.plugin.story.f.d.j jVar) {
        boolean z;
        String str;
        edt edt;
        com.tencent.mm.plugin.story.f.d.j jVar2;
        com.tencent.mm.plugin.story.f.d.k kVar;
        com.tencent.mm.plugin.story.f.d.k kVar2 = null;
        AppMethodBeat.i(120651);
        if (!(jVar.ecf == 0 || (jVar2 = this.FHj) == null || jVar2.ecf != jVar.ecf)) {
            com.tencent.mm.plugin.story.f.d.k kVar3 = jVar.Fpc;
            com.tencent.mm.plugin.story.f.d.j jVar3 = this.FHj;
            if (jVar3 != null) {
                kVar = jVar3.Fpc;
            } else {
                kVar = null;
            }
            if (kVar3 == kVar) {
                AppMethodBeat.o(120651);
                return true;
            }
        }
        String str2 = jVar.Fpd.Url;
        if (str2 == null || str2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            com.tencent.mm.plugin.story.f.d.j jVar4 = this.FHj;
            if (jVar4 == null || (edt = jVar4.Fpd) == null) {
                str = null;
            } else {
                str = edt.Url;
            }
            if (p.j(str, jVar.Fpd.Url)) {
                com.tencent.mm.plugin.story.f.d.k kVar4 = jVar.Fpc;
                com.tencent.mm.plugin.story.f.d.j jVar5 = this.FHj;
                if (jVar5 != null) {
                    kVar2 = jVar5.Fpc;
                }
                if (kVar4 == kVar2) {
                    AppMethodBeat.o(120651);
                    return true;
                }
            }
        }
        AppMethodBeat.o(120651);
        return false;
    }
}
