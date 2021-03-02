package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.lg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.story.f.d.j;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.vfs.s;
import com.tencent.tav.core.AssetExtension;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 h2\u00020\u0001:\u0001hB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\"J \u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0014J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\"H\u0016J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\tH\u0002J\b\u0010-\u001a\u00020\u0015H\u0002J\b\u0010.\u001a\u00020\u0015H\u0002J\u0012\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u00102\u001a\u00020\u000fH\u0002J\b\u00103\u001a\u00020\u000fH\u0002J\u0006\u00104\u001a\u00020\"J\u0006\u00105\u001a\u00020\tJ\b\u00106\u001a\u00020\tH\u0016J\u0006\u00107\u001a\u00020\"J\b\u00108\u001a\u00020+H\u0014J\b\u00109\u001a\u00020\u0015H\u0016J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010:\u001a\u00020\u0015J\u0006\u0010;\u001a\u00020\"J\b\u0010<\u001a\u00020+H\u0016J\u001a\u0010=\u001a\u00020+2\b\u0010>\u001a\u0004\u0018\u00010\t2\u0006\u0010?\u001a\u00020\"H\u0016J\u0018\u0010@\u001a\u00020+2\u0006\u0010A\u001a\u00020\"2\u0006\u0010B\u001a\u00020\"H\u0016J\"\u0010C\u001a\u00020+2\b\u0010>\u001a\u0004\u0018\u00010\t2\u0006\u0010D\u001a\u00020\u000f2\u0006\u0010E\u001a\u00020\u000fH\u0016J\u0010\u0010F\u001a\u00020+2\u0006\u0010G\u001a\u00020\u0015H\u0016J\b\u0010H\u001a\u00020+H\u0016J\b\u0010I\u001a\u00020+H\u0016J\b\u0010J\u001a\u00020+H\u0016J\b\u0010K\u001a\u00020+H\u0016J\b\u0010L\u001a\u00020+H\u0016J\b\u0010M\u001a\u00020\u0015H\u0016J\u0018\u0010N\u001a\u00020+2\u0006\u0010O\u001a\u00020\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\tJ\u0010\u0010P\u001a\u00020+2\u0006\u0010Q\u001a\u00020\tH\u0002J\b\u0010R\u001a\u00020+H\u0014J\b\u0010S\u001a\u00020+H\u0002J\b\u0010T\u001a\u00020+H\u0016J\u0012\u0010U\u001a\u00020+2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010W\u001a\u00020+2\u0006\u0010X\u001a\u00020\u0015H\u0016J\u000e\u0010Y\u001a\u00020+2\u0006\u0010Z\u001a\u00020\u0015J\u0012\u0010[\u001a\u00020+2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J\"\u0010^\u001a\u00020+2\u0006\u00109\u001a\u00020\u00152\b\u0010_\u001a\u0004\u0018\u00010\t2\u0006\u0010`\u001a\u00020\"H\u0016J\u0010\u0010a\u001a\u00020+2\u0006\u0010b\u001a\u00020\tH\u0002J\b\u0010c\u001a\u00020+H\u0014J\b\u0010&\u001a\u00020+H\u0016J\u0010\u0010d\u001a\u00020+2\u0006\u0010e\u001a\u00020\u0015H\u0014J\b\u0010f\u001a\u00020+H\u0016J\b\u0010g\u001a\u00020+H\u0014R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000¨\u0006i"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView;", "Lcom/tencent/mm/modelvideo/MMVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "C_TAG", "", "fakeBlurLayer", "Landroid/widget/ImageView;", "fakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "firstPlayWaitTime", "", "getFirstPlayWaitTime", "()J", "setFirstPlayWaitTime", "(J)V", "isFakeVideo", "", "isLocalVideo", "isLocalVideoPause", "isMute", "needShowLoading", "sessionId", "startPlayTime", "surfaceAvailable", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "videoTips", "Landroid/widget/TextView;", "avgBlockTime", "", "blockCount", "calcDownloadRange", "playTime", "start", "Lcom/tencent/mm/pointers/PInt;", "end", "checkCanPlay", "checkLandscape", "", "blurBgPath", "checkNeedReset", "checkResumeLocalVideo", "createVideoView", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView;", "mContext", "fakeEndTime", "fakeStartTime", "getErrorCode", "getFilePath", "getSessionId", "getStayTime", "initView", "isLive", "isShowLoading", "moovCostTime", "onCompletion", "onFinish", "mediaId", "ret", "onGetVideoSize", "width", "height", "onProgress", "offset", "total", "onSeekComplete", "startPlay", "onSurfaceAvailable", "onTextureUpdate", "onUIDestroy", "onUIPause", "onUIResume", "pause", AssetExtension.SCENE_PLAY, "item", "playLocalVideo", "videoPath", "prepareVideo", "reportStopLocalVideo", "reset", "resume", "storyVideoItem", "setMute", "mute", "setNeedShowLoading", "show", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoPath", "url", "durationSec", "showDebugInfo", "path", "showLoading", "startTimer", "rightNow", "stop", "stopTimer", "Companion", "plugin-story_release"})
public final class StoryVideoView extends MMVideoView {
    public static final a FHX = new a((byte) 0);
    private boolean Cei;
    private final String FHQ;
    private boolean FHR;
    boolean FHS;
    private boolean FHT;
    private boolean FHU;
    private ImageView FHV;
    private long FHW;
    private j FoT;
    private boolean guh;
    private long iJF;
    private String sessionId;
    private TextView tmU;
    private FakeVideoViewLayer xCO;

    static {
        AppMethodBeat.i(120621);
        AppMethodBeat.o(120621);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoryVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(120619);
        this.FHQ = "MicroMsg.StoryVideoView";
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        setRootPath(s.k(j.b.getAccStoryPath(), true));
        goo();
        setIsShowBasicControls(false);
        LinearLayout linearLayout = this.mEB;
        p.g(linearLayout, "footerRoot");
        linearLayout.setVisibility(8);
        this.TAG = this.FHQ;
        this.FHR = true;
        AppMethodBeat.o(120619);
    }

    public static final /* synthetic */ String i(StoryVideoView storyVideoView) {
        AppMethodBeat.i(120624);
        String mediaId = storyVideoView.getMediaId();
        AppMethodBeat.o(120624);
        return mediaId;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StoryVideoView(Context context) {
        this(context, null);
        p.h(context, "context");
        AppMethodBeat.i(120620);
        AppMethodBeat.o(120620);
    }

    public final long getFirstPlayWaitTime() {
        return this.FHW;
    }

    public final void setFirstPlayWaitTime(long j2) {
        this.FHW = j2;
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void initView() {
        AppMethodBeat.i(120584);
        super.initView();
        com.tencent.mm.plugin.story.f.e.a aVar = com.tencent.mm.plugin.story.f.e.a.Fpl;
        this.xCO = com.tencent.mm.plugin.story.f.e.a.hk(getContext());
        this.FHV = new ImageView(getContext());
        ImageView imageView = this.FHV;
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        ImageView imageView2 = this.FHV;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        RelativeLayout relativeLayout = this.mEy;
        FakeVideoViewLayer fakeVideoViewLayer = this.xCO;
        if (fakeVideoViewLayer == null) {
            p.btv("fakeLayer");
        }
        relativeLayout.addView(fakeVideoViewLayer, new ViewGroup.LayoutParams(-1, -1));
        this.mEy.addView(this.FHV, 0);
        this.tmU = (TextView) findViewById(R.id.j6r);
        AppMethodBeat.o(120584);
    }

    public final void a(com.tencent.mm.plugin.story.f.d.j jVar, String str) {
        AppMethodBeat.i(120585);
        p.h(jVar, "item");
        TextView textView = this.tmU;
        if (textView != null) {
            textView.setVisibility(8);
        }
        this.FoT = jVar;
        edt edt = jVar.Fpd;
        int i2 = jVar.iXu;
        this.FHU = false;
        FakeVideoViewLayer fakeVideoViewLayer = this.xCO;
        if (fakeVideoViewLayer == null) {
            p.btv("fakeLayer");
        }
        fakeVideoViewLayer.setVisibility(8);
        ImageView imageView = this.FHV;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        if (!jVar.foW()) {
            Log.i(this.TAG, "play empty item");
            showLoading();
            AppMethodBeat.o(120585);
            return;
        }
        if (jVar.foV()) {
            this.FHU = true;
            Log.i(this.TAG, "LogStory: play fake video");
            FakeVideoViewLayer fakeVideoViewLayer2 = this.xCO;
            if (fakeVideoViewLayer2 == null) {
                p.btv("fakeLayer");
            }
            fakeVideoViewLayer2.setVisibility(0);
            com.tencent.mm.plugin.recordvideo.background.c cVar = jVar.Fpe;
            if (cVar != null) {
                String str2 = cVar.field_blurBgPath;
                p.g(str2, "fakeData.field_blurBgPath");
                String str3 = str2;
                if (!(str3 == null || str3.length() == 0)) {
                    Point az = au.az(getContext());
                    Bitmap extractThumbNail = BitmapUtil.extractThumbNail(str2, az.y, az.x, true);
                    ImageView imageView2 = this.FHV;
                    if (imageView2 != null) {
                        imageView2.setImageBitmap(extractThumbNail);
                    }
                    ImageView imageView3 = this.FHV;
                    if (imageView3 != null) {
                        imageView3.setVisibility(0);
                    }
                } else {
                    ImageView imageView4 = this.FHV;
                    if (imageView4 != null) {
                        imageView4.setVisibility(8);
                    }
                }
                FakeVideoViewLayer fakeVideoViewLayer3 = this.xCO;
                if (fakeVideoViewLayer3 == null) {
                    p.btv("fakeLayer");
                }
                fakeVideoViewLayer3.setFakeVideoInfo(cVar);
                FakeVideoViewLayer fakeVideoViewLayer4 = this.xCO;
                if (fakeVideoViewLayer4 == null) {
                    p.btv("fakeLayer");
                }
                fakeVideoViewLayer4.tv(this.guh);
                this.jpU = cVar.eII().videoPath;
                this.jpT = "";
                String str4 = this.jpU;
                p.g(str4, "filepath");
                aSF(str4);
            }
        } else {
            Log.i(this.TAG, "LogStory: play normal video");
            com.tencent.mm.plugin.story.f.s sVar = com.tencent.mm.plugin.story.f.s.Fny;
            String a2 = com.tencent.mm.plugin.story.f.s.a(edt);
            if (s.boW(a2) > 0) {
                Log.i(this.TAG, "play " + a2 + " downloadDone now can play " + edt.Id);
                this.jpU = a2;
                if (a2 != null) {
                    aSF(a2);
                }
            } else {
                com.tencent.mm.plugin.story.f.s sVar2 = com.tencent.mm.plugin.story.f.s.Fny;
                n a3 = com.tencent.mm.plugin.story.f.s.a(jVar);
                int boW = (int) s.boW(a3.field_filePath);
                Log.i(this.TAG, "play " + a2 + " error try play from url or videoCache " + edt.Id + " fileLength:" + boW + " cacheSize:" + a3.field_cacheSize);
                if (boW < a3.field_cacheSize) {
                    a3.field_cacheSize = boW;
                    j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
                    j.b.fog().b(a3);
                }
                Log.i(this.TAG, String.valueOf(a3));
                if (!a3.alN() || !s.YS(a3.field_filePath)) {
                    if (a3.alN() && !s.YS(a3.field_filePath)) {
                        Log.i(this.TAG, "error downloadFinish " + a3.alN() + " ret:" + s.YS(a3.field_filePath));
                        a3.frR();
                        j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
                        j.b.fog().b(a3);
                    }
                    Log.i(this.TAG, "play " + edt.Id + ' ' + str + " start online play " + a3.field_filePath);
                    reset();
                    this.qbJ.stop();
                    this.qbJ.setVideoCallback(this);
                    this.FHS = false;
                    this.mEK = true;
                    setNeedShowLoading(true);
                    super.c(false, jVar.Fpd.Url, (int) edt.Ned);
                    this.jpU = a3.field_filePath;
                    com.tencent.mm.plugin.story.f.s sVar3 = com.tencent.mm.plugin.story.f.s.Fny;
                    this.jpT = com.tencent.mm.plugin.story.f.s.cs(i2, edt.Url);
                    this.sessionId = str;
                    this.iJF = Util.currentTicks();
                    this.FHW = 0;
                    start();
                } else {
                    Log.i(this.TAG, "play " + edt.Id + " download finish");
                    this.jpU = a3.field_filePath;
                    com.tencent.mm.plugin.story.f.s sVar4 = com.tencent.mm.plugin.story.f.s.Fny;
                    this.jpT = com.tencent.mm.plugin.story.f.s.cs(i2, edt.Url);
                    String str5 = this.jpU;
                    p.g(str5, "filepath");
                    aSF(str5);
                }
            }
        }
        setLoop(true);
        com.tencent.mm.pluginsdk.ui.tools.j jVar2 = this.qbJ;
        if (jVar2 == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(120585);
            throw tVar;
        }
        ((View) jVar2).setAlpha(0.0f);
        AppMethodBeat.o(120585);
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.tools.j.a, com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void onCompletion() {
        AppMethodBeat.i(120586);
        Log.i(this.TAG, "onCompletion, currPosMs:" + getCurrPosMs() + ", playStatus:" + this.jpW + ", downloadStatus:" + this.jpV);
        if (getCurrPosMs() <= 0) {
            AppMethodBeat.o(120586);
            return;
        }
        i.b bVar = this.pNj;
        if (bVar != null) {
            bVar.dI(getSessionId(), getMediaId());
        }
        super.onCompletion();
        AppMethodBeat.o(120586);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final String getSessionId() {
        AppMethodBeat.i(120587);
        String nullAsNil = Util.nullAsNil(this.sessionId);
        p.g(nullAsNil, "Util.nullAsNil(sessionId)");
        AppMethodBeat.o(120587);
        return nullAsNil;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void setMute(boolean z) {
        AppMethodBeat.i(120588);
        super.setMute(z);
        this.guh = z;
        if (this.qbJ != null) {
            this.qbJ.setMute(z);
        }
        AppMethodBeat.o(120588);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void o(com.tencent.mm.plugin.story.f.d.j r7) {
        /*
        // Method dump skipped, instructions count: 281
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoView.o(com.tencent.mm.plugin.story.f.d.j):void");
    }

    @Override // com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final boolean pause() {
        AppMethodBeat.i(120590);
        Log.i(this.TAG, "pause, isLocalVideo:" + this.FHS);
        FakeVideoViewLayer fakeVideoViewLayer = this.xCO;
        if (fakeVideoViewLayer == null) {
            p.btv("fakeLayer");
        }
        fakeVideoViewLayer.eLA();
        if (this.FHS) {
            this.FHT = true;
            this.qbJ.pause();
            AppMethodBeat.o(120590);
            return true;
        }
        boolean pause = super.pause();
        AppMethodBeat.o(120590);
        return pause;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0064, code lost:
        if (r0.BYt != false) goto L_0x0066;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void aSF(java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 205
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoView.aSF(java.lang.String):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView$playLocalVideo$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-story_release"})
    public static final class b implements j.a {
        final /* synthetic */ StoryVideoView FHY;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(StoryVideoView storyVideoView) {
            this.FHY = storyVideoView;
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final void tf() {
            AppMethodBeat.i(120580);
            String str = this.FHY.TAG;
            StringBuilder append = new StringBuilder("localVideo onPrepared, isLocalVideoPause:").append(this.FHY.FHT).append(", isFakeVideo:");
            com.tencent.mm.plugin.story.f.d.j jVar = this.FHY.FoT;
            Log.i(str, append.append(jVar != null ? Boolean.valueOf(jVar.foV()) : null).append(", fakeStartTime:").append(StoryVideoView.d(this.FHY)).append(", fakeEndTime:").append(StoryVideoView.e(this.FHY)).toString());
            if (!this.FHY.FHT) {
                com.tencent.mm.plugin.story.f.d.j jVar2 = this.FHY.FoT;
                if (jVar2 == null || !jVar2.foV() || StoryVideoView.d(this.FHY) <= 0) {
                    this.FHY.qbJ.start();
                } else {
                    this.FHY.qbJ.d((double) StoryVideoView.d(this.FHY), true);
                }
                this.FHY.qbJ.setOneTimeVideoTextureUpdateCallback(new a(this));
            }
            AppMethodBeat.o(120580);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTextureUpdate"})
        static final class a implements j.e {
            final /* synthetic */ b FHZ;

            a(b bVar) {
                this.FHZ = bVar;
            }

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.e
            public final void bLh() {
                AppMethodBeat.i(120579);
                this.FHZ.FHY.setFirstPlayWaitTime(Util.ticksToNow(this.FHZ.FHY.iJF));
                MMHandlerThread.postToMainThreadDelayed(new Runnable(this) {
                    /* class com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoView.b.a.AnonymousClass1 */
                    final /* synthetic */ a FIa;

                    {
                        this.FIa = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(120578);
                        Log.i(this.FIa.FHZ.FHY.TAG, "onTextureUpdate");
                        if (this.FIa.FHZ.FHY.qbJ == null) {
                            AppMethodBeat.o(120578);
                            return;
                        }
                        this.FIa.FHZ.FHY.hideLoading();
                        com.tencent.mm.pluginsdk.ui.tools.j jVar = this.FIa.FHZ.FHY.qbJ;
                        if (jVar == null) {
                            t tVar = new t("null cannot be cast to non-null type android.view.View");
                            AppMethodBeat.o(120578);
                            throw tVar;
                        }
                        ((View) jVar).setAlpha(1.0f);
                        AppMethodBeat.o(120578);
                    }
                }, 50);
                AppMethodBeat.o(120579);
            }
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final void onCompletion() {
            AppMethodBeat.i(120581);
            String str = this.FHY.TAG;
            StringBuilder sb = new StringBuilder("localVideo onCompleted, isFakeVideo:");
            com.tencent.mm.plugin.story.f.d.j jVar = this.FHY.FoT;
            Log.i(str, sb.append(jVar != null ? Boolean.valueOf(jVar.foV()) : null).append(", fakeStartTime:").append(StoryVideoView.d(this.FHY)).toString());
            com.tencent.mm.plugin.story.f.d.j jVar2 = this.FHY.FoT;
            if (jVar2 == null || !jVar2.foV() || StoryVideoView.d(this.FHY) <= 0) {
                this.FHY.qbJ.d(0.0d, true);
            } else {
                this.FHY.qbJ.d((double) StoryVideoView.d(this.FHY), true);
            }
            i.b bVar = this.FHY.pNj;
            if (bVar != null) {
                bVar.dI(this.FHY.getSessionId(), StoryVideoView.i(this.FHY));
                AppMethodBeat.o(120581);
                return;
            }
            AppMethodBeat.o(120581);
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final int fh(int i2, int i3) {
            AppMethodBeat.i(120582);
            com.tencent.mm.plugin.story.f.d.j jVar = this.FHY.FoT;
            if (jVar != null && jVar.foV() && StoryVideoView.e(this.FHY) > 0 && ((long) i2) >= StoryVideoView.e(this.FHY)) {
                Log.i(this.FHY.TAG, "fakeVideo exceed endTime, playTime:" + i2 + ", fakeEndTime:" + StoryVideoView.e(this.FHY) + ", fakeStartTime:" + StoryVideoView.d(this.FHY));
                if (StoryVideoView.d(this.FHY) > 0) {
                    this.FHY.qbJ.d((double) StoryVideoView.d(this.FHY), true);
                } else {
                    this.FHY.qbJ.d(0.0d, true);
                }
            }
            AppMethodBeat.o(120582);
            return 0;
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final void eo(int i2, int i3) {
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final void onError(int i2, int i3) {
        }
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void fO(boolean z) {
        AppMethodBeat.i(120593);
        Log.printInfoStack(this.TAG, bgQ() + " startTimer, isLocalVideo:" + this.FHS, new Object[0]);
        if (!this.FHS) {
            super.fO(z);
        }
        AppMethodBeat.o(120593);
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void stopTimer() {
        AppMethodBeat.i(120594);
        Log.printInfoStack(this.TAG, bgQ() + " stopTimer, isLocalVideo:" + this.FHS, new Object[0]);
        super.stopTimer();
        AppMethodBeat.o(120594);
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i
    public final boolean isLive() {
        AppMethodBeat.i(120595);
        if (this.FHS) {
            AppMethodBeat.o(120595);
            return false;
        }
        boolean isLive = super.isLive();
        AppMethodBeat.o(120595);
        return isLive;
    }

    public final void setNeedShowLoading(boolean z) {
        AppMethodBeat.i(120596);
        Log.i(this.TAG, hashCode() + " setNeedShowLoading: " + z);
        this.FHR = z;
        if (!this.FHR) {
            hideLoading();
        }
        AppMethodBeat.o(120596);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void showLoading() {
        AppMethodBeat.i(120597);
        if (this.FHR) {
            BT(800);
        }
        AppMethodBeat.o(120597);
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void onUIPause() {
        AppMethodBeat.i(120598);
        Log.i(this.TAG, "onUIPause, isLocalVideo:" + this.FHS);
        FakeVideoViewLayer fakeVideoViewLayer = this.xCO;
        if (fakeVideoViewLayer == null) {
            p.btv("fakeLayer");
        }
        fakeVideoViewLayer.eLA();
        if (this.FHS) {
            com.tencent.mm.pluginsdk.ui.tools.j jVar = this.qbJ;
            if (jVar != null) {
                jVar.pause();
                AppMethodBeat.o(120598);
                return;
            }
            AppMethodBeat.o(120598);
            return;
        }
        super.onUIPause();
        AppMethodBeat.o(120598);
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void onUIResume() {
        AppMethodBeat.i(120599);
        Log.i(this.TAG, "onUIResume, isLocalVideo:" + this.FHS);
        if (isPlaying()) {
            FakeVideoViewLayer fakeVideoViewLayer = this.xCO;
            if (fakeVideoViewLayer == null) {
                p.btv("fakeLayer");
            }
            fakeVideoViewLayer.tv(this.guh);
        }
        if (this.FHS) {
            AppMethodBeat.o(120599);
            return;
        }
        super.onUIResume();
        AppMethodBeat.o(120599);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void onUIDestroy() {
        AppMethodBeat.i(120600);
        Log.i(this.TAG, "onUIDestroy, isLocalVideo:" + this.FHS);
        FakeVideoViewLayer fakeVideoViewLayer = this.xCO;
        if (fakeVideoViewLayer == null) {
            p.btv("fakeLayer");
        }
        fakeVideoViewLayer.eLB();
        super.onUIDestroy();
        AppMethodBeat.o(120600);
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.modelvideo.b.a
    public final void i(String str, long j2, long j3) {
        AppMethodBeat.i(120601);
        if (!Util.isEqual(this.jpT, str)) {
            AppMethodBeat.o(120601);
            return;
        }
        String str2 = this.TAG;
        StringBuilder append = new StringBuilder("%s download  onProgress [%d, %d], pauseByLoadData:").append(this.jqb).append(", playStatus:").append(this.jpW).append(", currPosMs:").append(getCurrPosMs()).append(", isPlyaing:");
        com.tencent.mm.pluginsdk.ui.tools.j jVar = this.qbJ;
        p.g(jVar, "videoView");
        Log.d(str2, append.append(jVar.isPlaying()).toString(), bgQ(), Long.valueOf(j2), Long.valueOf(j3));
        if ((getCurrPosMs() <= 0 || this.jpW == 1 || this.jpW == 0) && ub(getCurrPosSec())) {
            fO(true);
        }
        AppMethodBeat.o(120601);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void eo(int i2, int i3) {
        AppMethodBeat.i(120602);
        super.eo(i2, i3);
        Log.i(this.TAG, "onGetVideoSize, mediaId:" + getMediaId() + ", isLocalVideo:" + this.FHS + ", isPrepareVideo:" + this.jqe + ", isPrepared:" + this.ZA + ", playerStatus:" + this.jpW + ", downloadStatus:" + this.jpV);
        AppMethodBeat.o(120602);
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.modelvideo.b.a
    public final void ax(String str, int i2) {
        AppMethodBeat.i(120603);
        super.ax(str, i2);
        AppMethodBeat.o(120603);
    }

    private final boolean cXc() {
        AppMethodBeat.i(120604);
        if (this.FHS) {
            AppMethodBeat.o(120604);
            return false;
        }
        try {
            boolean z = g.aAh().azQ().getBoolean(ar.a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, false);
            AppMethodBeat.o(120604);
            return z;
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "check need reset error", new Object[0]);
            AppMethodBeat.o(120604);
            return false;
        }
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView
    public final boolean uc(int i2) {
        AppMethodBeat.i(120605);
        boolean uc = super.uc(i2);
        Log.i(this.TAG, "checkCanPlay, cachePlayTime:" + this.jqc + ", ret:" + uc);
        AppMethodBeat.o(120605);
        return uc;
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView
    public final boolean a(int i2, PInt pInt, PInt pInt2) {
        AppMethodBeat.i(120606);
        p.h(pInt, "start");
        p.h(pInt2, "end");
        String str = "";
        pInt.value = Math.max(i2, this.jqc);
        if (this.jpW == 1) {
            pInt.value = i2;
            pInt2.value = pInt.value + this.jqd;
            str = str + "step1;";
        }
        if (this.jpW == 2) {
            pInt.value = i2 - 8;
            if (pInt.value < 0) {
                pInt.value = 0;
            }
            pInt2.value = pInt.value + this.jqd + 8;
            str = str + "step2;";
        }
        if (this.jpW == 3) {
            pInt.value = this.jqc;
            pInt2.value = i2 + 1 + this.jqh.jqn;
            str = str + "step3;";
        } else if (this.jpW == 4) {
            pInt.value = this.jqc;
            pInt2.value = this.jqd + i2 + 1 + this.jqh.jqn;
            str = str + "step4;";
        }
        if (pInt2.value >= this.jpY + 1) {
            pInt2.value = this.jpY + 1;
            str = str + "step5;";
        }
        if (pInt2.value < pInt.value) {
            pInt2.value = pInt.value + this.jqh.jqn;
            AppMethodBeat.o(120606);
            return false;
        }
        Log.i(this.TAG, "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s] %s", bgQ(), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(i2), Integer.valueOf(this.jpW), Integer.valueOf(this.jqc), Integer.valueOf(this.jqd), this.jpT, str);
        AppMethodBeat.o(120606);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.modelvideo.MMVideoView
    public final void start() {
        AppMethodBeat.i(120607);
        if (this.bFM > 0 && !this.FHS) {
            Log.i(this.TAG, "start from onError and not local video");
            com.tencent.mm.plugin.story.f.d.j jVar = this.FoT;
            if (jVar != null) {
                com.tencent.mm.plugin.story.f.s sVar = com.tencent.mm.plugin.story.f.s.Fny;
                n a2 = com.tencent.mm.plugin.story.f.s.a(jVar);
                if (a2.alN()) {
                    Log.i(this.TAG, "start from onError and download finish now");
                    String str = a2.field_filePath;
                    p.g(str, "videoCache.field_filePath");
                    aSF(str);
                    AppMethodBeat.o(120607);
                    return;
                }
            }
        }
        String str2 = this.jpU;
        p.g(str2, "filepath");
        aSG(str2);
        super.start();
        AppMethodBeat.o(120607);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void stop() {
        long j2;
        long j3 = 1;
        AppMethodBeat.i(120608);
        try {
            FakeVideoViewLayer fakeVideoViewLayer = this.xCO;
            if (fakeVideoViewLayer == null) {
                p.btv("fakeLayer");
            }
            fakeVideoViewLayer.eLB();
            if (this.FHS) {
                lg lgVar = new lg();
                com.tencent.mm.plugin.story.f.d.j jVar = this.FoT;
                lg ys = lgVar.ys(String.valueOf(jVar != null ? Long.valueOf(jVar.edx) : null));
                h hVar = h.FuH;
                lg tZ = ys.tZ(h.fqi().ahw());
                h hVar2 = h.FuH;
                if (h.fqi().ahB() != 1) {
                    j3 = 0;
                }
                lg uG = tZ.ub(j3).ue(this.FHW).ui((long) getStayTime()).uj((long) getErrorCode()).uG(1);
                h hVar3 = h.FuH;
                lg uH = uG.uH(h.fqi().ahv());
                h hVar4 = h.FuH;
                uH.uI(h.fqi().ahy()).ud((long) getCurrPosMs());
                Log.d(this.TAG, "time distance %d", Long.valueOf(System.currentTimeMillis() - lgVar.aiy()));
                if (System.currentTimeMillis() - lgVar.aiy() >= 500) {
                    com.tencent.mm.plugin.story.f.d.j jVar2 = this.FoT;
                    if (jVar2 != null) {
                        j2 = jVar2.edx;
                    } else {
                        j2 = 0;
                    }
                    try {
                        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
                        j.b.eJP().post(new c(this, lgVar, j2));
                    } catch (Exception e2) {
                        Log.printErrStackTrace(this.TAG, e2, "reportStopLocalVideo", new Object[0]);
                        lgVar.bfK();
                    }
                }
                this.qbJ.stop();
                reset();
            } else {
                super.stop();
            }
            ImageView imageView = this.FHV;
            if (imageView != null) {
                imageView.setVisibility(8);
                AppMethodBeat.o(120608);
                return;
            }
            AppMethodBeat.o(120608);
        } catch (Exception e3) {
            Log.printErrStackTrace(this.TAG, e3, "stop error", new Object[0]);
            AppMethodBeat.o(120608);
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.modelvideo.MMVideoView
    public final void c(boolean z, String str, int i2) {
        AppMethodBeat.i(259989);
        super.c(z, str, i2);
        AppMethodBeat.o(259989);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView, com.tencent.mm.pluginsdk.ui.tools.j.e
    public final void bLh() {
        AppMethodBeat.i(120610);
        super.bLh();
        com.tencent.mm.pluginsdk.ui.tools.j jVar = this.qbJ;
        if (jVar == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(120610);
            throw tVar;
        }
        ((View) jVar).setAlpha(1.0f);
        if (this.FHW <= 0) {
            this.FHW = Util.ticksToNow(this.iJF);
            String str = this.TAG;
            StringBuilder append = new StringBuilder("onTextureUpdate firstPlayWaitTime ").append(this.FHW).append(" storyId: ");
            com.tencent.mm.plugin.story.f.d.j jVar2 = this.FoT;
            Log.i(str, append.append(jVar2 != null ? Long.valueOf(jVar2.edx) : null).toString());
        }
        AppMethodBeat.o(120610);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ StoryVideoView FHY;
        final /* synthetic */ lg FIb;
        final /* synthetic */ long Foo;

        c(StoryVideoView storyVideoView, lg lgVar, long j2) {
            this.FHY = storyVideoView;
            this.FIb = lgVar;
            this.Foo = j2;
        }

        public final void run() {
            AppMethodBeat.i(120583);
            Log.i(this.FHY.TAG, "reportStopLocalVideo");
            com.tencent.mm.plugin.sight.base.a aNx = e.aNx(this.FHY.jpU);
            if (aNx != null) {
                lg uc = this.FIb.uc((long) aNx.videoDuration);
                j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
                uc.ua((long) j.b.foc().KB(this.Foo)).uk((long) aNx.videoBitrate).bfK();
            }
            AppMethodBeat.o(120583);
        }
    }

    public final int fsH() {
        if (this.KaY.Eut > this.KaY.mvz) {
            return (int) (this.KaY.Eut - this.KaY.mvz);
        }
        return 0;
    }

    public final int fsI() {
        return this.KaY.blockCount;
    }

    public final int getStayTime() {
        AppMethodBeat.i(120611);
        int ticksToNow = (int) Util.ticksToNow(this.iJF);
        AppMethodBeat.o(120611);
        return ticksToNow;
    }

    public final int getErrorCode() {
        return this.KaY.mNz;
    }

    public final String getFilePath() {
        AppMethodBeat.i(120612);
        String str = this.jpU;
        p.g(str, "filepath");
        AppMethodBeat.o(120612);
        return str;
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.modelvideo.MMVideoView
    public final void setScaleType(i.e eVar) {
        AppMethodBeat.i(120613);
        super.setScaleType(eVar);
        AppMethodBeat.o(120613);
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final com.tencent.mm.pluginsdk.ui.tools.j di(Context context) {
        AppMethodBeat.i(120614);
        StoryVideoPlayTextureView storyVideoPlayTextureView = new StoryVideoPlayTextureView(context);
        storyVideoPlayTextureView.setOpenWithNoneSurface(true);
        storyVideoPlayTextureView.setNeedResetExtractor(cXc());
        storyVideoPlayTextureView.setIsOnlineVideoType(true);
        StoryVideoPlayTextureView storyVideoPlayTextureView2 = storyVideoPlayTextureView;
        AppMethodBeat.o(120614);
        return storyVideoPlayTextureView2;
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView, com.tencent.mm.pluginsdk.ui.tools.j.d
    public final void bgX() {
        AppMethodBeat.i(120615);
        super.bgX();
        Log.i(this.TAG, "onSurfaceAvailable");
        this.Cei = true;
        AppMethodBeat.o(120615);
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView
    public final void bgV() {
        AppMethodBeat.i(120616);
        Log.i(this.TAG, "prepareVideo, surfaceAvailable:" + this.Cei);
        if (this.qbJ != null) {
            com.tencent.mm.pluginsdk.ui.tools.j jVar = this.qbJ;
            if (jVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoPlayTextureView");
                AppMethodBeat.o(120616);
                throw tVar;
            }
            ((StoryVideoPlayTextureView) jVar).setNeedResetExtractor(cXc());
        }
        String str = this.jpU;
        p.g(str, "filepath");
        aSG(str);
        super.bgV();
        AppMethodBeat.o(120616);
    }

    private final void aSG(String str) {
        AppMethodBeat.i(120617);
        com.tencent.mm.kernel.e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_LOCAL_SIGHT_DEBUGINFO_INT_SYNC, (Object) 0);
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(120617);
            throw tVar;
        }
        if (((Integer) obj).intValue() == 1) {
            TextView textView = this.tmU;
            if (textView != null) {
                textView.setText(e.aFm(str));
            }
            TextView textView2 = this.tmU;
            if (textView2 != null) {
                textView2.setVisibility(0);
                AppMethodBeat.o(120617);
                return;
            }
        }
        AppMethodBeat.o(120617);
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView
    public final void reset() {
        AppMethodBeat.i(120618);
        super.reset();
        this.Cei = false;
        this.sessionId = null;
        AppMethodBeat.o(120618);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView$Companion;", "", "()V", "PRELOAD_CACHE", "", "PRELOAD_CACHE_GOOD_NETWORK", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.c, com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void fN(boolean z) {
        AppMethodBeat.i(120592);
        if (this.FHS) {
            AppMethodBeat.o(120592);
            return;
        }
        super.fN(z);
        AppMethodBeat.o(120592);
    }

    public final int fsJ() {
        if (this.KaY.blockCount > 0) {
            return (int) (this.KaY.KcZ / ((long) this.KaY.blockCount));
        }
        return 0;
    }

    public static final /* synthetic */ long d(StoryVideoView storyVideoView) {
        com.tencent.mm.plugin.recordvideo.background.c cVar;
        AppMethodBeat.i(120622);
        com.tencent.mm.plugin.story.f.d.j jVar = storyVideoView.FoT;
        if (jVar == null || (cVar = jVar.Fpe) == null) {
            AppMethodBeat.o(120622);
            return 0;
        }
        long j2 = cVar.eII().startTime;
        AppMethodBeat.o(120622);
        return j2;
    }

    public static final /* synthetic */ long e(StoryVideoView storyVideoView) {
        com.tencent.mm.plugin.recordvideo.background.c cVar;
        AppMethodBeat.i(120623);
        com.tencent.mm.plugin.story.f.d.j jVar = storyVideoView.FoT;
        if (jVar == null || (cVar = jVar.Fpe) == null) {
            AppMethodBeat.o(120623);
            return 0;
        }
        long j2 = cVar.eII().endTime;
        AppMethodBeat.o(120623);
        return j2;
    }
}
