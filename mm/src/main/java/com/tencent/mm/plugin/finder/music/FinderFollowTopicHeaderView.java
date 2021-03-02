package com.tencent.mm.plugin.finder.music;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.cd;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.utils.am;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.FinderVideoViewForTopic;
import com.tencent.mm.plugin.finder.video.x;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.bdr;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 |2\u00020\u00012\u00020\u0002:\u0001|B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ*\u0010Z\u001a\u00020[2\b\u0010\\\u001a\u0004\u0018\u00010C2\b\u0010]\u001a\u0004\u0018\u0001052\u0006\u0010L\u001a\u00020\n2\u0006\u0010^\u001a\u00020\nJ \u0010_\u001a\u00020[2\u0006\u0010`\u001a\u00020\u00132\u0006\u0010a\u001a\u00020\n2\u0006\u0010b\u001a\u00020\nH\u0016J\u0010\u0010c\u001a\u00020[2\u0006\u0010d\u001a\u00020=H\u0002J\u0010\u0010e\u001a\u00020[2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010f\u001a\u00020,2\u0006\u0010^\u001a\u00020\nH\u0002J\u0010\u0010g\u001a\u00020,2\u0006\u0010h\u001a\u00020\u0013H\u0002J\b\u0010i\u001a\u00020[H\u0014J\u0006\u0010j\u001a\u00020[J\"\u0010k\u001a\u00020[2\u0006\u0010l\u001a\u00020\n2\u0006\u0010d\u001a\u00020=2\b\u0010m\u001a\u0004\u0018\u00010nH\u0016J\u0006\u0010o\u001a\u00020[J(\u0010p\u001a\u00020[2\u0006\u0010a\u001a\u00020\n2\u0006\u0010q\u001a\u00020\n2\u0006\u0010d\u001a\u00020=2\u0006\u0010r\u001a\u00020,H\u0016J \u0010s\u001a\u00020[2\u0006\u0010a\u001a\u00020\n2\u0006\u0010q\u001a\u00020\n2\u0006\u0010d\u001a\u00020=H\u0016J\u0010\u0010t\u001a\u00020[2\u0006\u0010d\u001a\u00020=H\u0016J$\u0010u\u001a\u00020[2\u0006\u0010d\u001a\u00020=2\b\u0010v\u001a\u0004\u0018\u00010w2\b\u0010x\u001a\u0004\u0018\u00010nH\u0016J\u0010\u0010y\u001a\u00020[2\u0006\u0010z\u001a\u00020,H\u0016J\b\u0010{\u001a\u00020[H\u0002R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0015\"\u0004\b3\u0010\u0017R\u001c\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010.\"\u0004\b;\u00100R\u001c\u0010<\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u000e\u0010H\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010L\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001a\u0010Q\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010N\"\u0004\bS\u0010PR\u001c\u0010T\u001a\u0004\u0018\u00010UX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010Y¨\u0006}"}, hxF = {"Lcom/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView;", "Landroid/support/constraint/ConstraintLayout;", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "audioInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "getAudioInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "setAudioInfo", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "audioPath", "", "getAudioPath", "()Ljava/lang/String;", "setAudioPath", "(Ljava/lang/String;)V", "bgmPlayBtn", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag;", "getBgmPlayBtn", "()Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag;", "setBgmPlayBtn", "(Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag;)V", "copyrightRestrictionListener", "Landroid/view/View$OnClickListener;", "currentListener", "getCurrentListener", "()Landroid/view/View$OnClickListener;", "setCurrentListener", "(Landroid/view/View$OnClickListener;)V", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "downloadFinish", "", "getDownloadFinish", "()Z", "setDownloadFinish", "(Z)V", "filePath", "getFilePath", "setFilePath", "finderBgmInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;", "getFinderBgmInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;", "setFinderBgmInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;)V", "isFirstClickPlay", "setFirstClickPlay", "media", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "getMedia", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "setMedia", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;)V", "originFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getOriginFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setOriginFeed", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "pauseMusicListener", "pauseVideoListener", "playMusicListener", "playVideoListener", "tabType", "getTabType", "()I", "setTabType", "(I)V", "type", "getType", "setType", "videoView", "Lcom/tencent/mm/plugin/finder/video/FinderVideoViewForTopic;", "getVideoView", "()Lcom/tencent/mm/plugin/finder/video/FinderVideoViewForTopic;", "setVideoView", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoViewForTopic;)V", "bindOriginFeed", "", "feed", "bgmInfo", "flag", "checkVideoDataAvailable", "mediaId", "offset", "length", "extractAudioTrack", "video", "initView", "isCopyrightRestriction", "isFileLegal", "path", "onDetachedFromWindow", "onDettach", "onFinishDownload", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onFollowBtnClick", "onMoovReadyDownload", "total", "moovFirstDownloaded", "onProgressDownload", "onStartDownload", "onStopDownload", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "result", "onWindowFocusChanged", "hasWindowFocus", "showBottomSheet", "Companion", "plugin-finder_release"})
public final class FinderFollowTopicHeaderView extends ConstraintLayout implements x {
    public static final a uPq = new a((byte) 0);
    private HashMap _$_findViewCache;
    public int dLS;
    public volatile boolean dvV;
    public String filePath = "";
    private com.tencent.mm.ui.base.q nUq;
    public int type;
    public FinderVideoViewForTopic uPc;
    public FinderItem uPd;
    public bdr uPe;
    public s uPf;
    boolean uPg = true;
    public AudioCacheInfo uPh;
    public FinderImgFeedMusicTag uPi;
    private String uPj = "";
    private View.OnClickListener uPk;
    public View.OnClickListener uPl = new o(this);
    private View.OnClickListener uPm = new m(this);
    public View.OnClickListener uPn = new n(this);
    private View.OnClickListener uPo = new l(this);
    public View.OnClickListener uPp = new g(this);

    static {
        AppMethodBeat.i(248914);
        AppMethodBeat.o(248914);
    }

    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(248917);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(248917);
        return view;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "success", "", "filepath", "", "invoke", "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$bindOriginFeed$6$2"})
    public static final class c extends kotlin.g.b.q implements kotlin.g.a.m<Boolean, String, kotlin.x> {
        final /* synthetic */ FinderFollowTopicHeaderView uPr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(FinderFollowTopicHeaderView finderFollowTopicHeaderView) {
            super(2);
            this.uPr = finderFollowTopicHeaderView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(Boolean bool, String str) {
            AppMethodBeat.i(248878);
            final boolean booleanValue = bool.booleanValue();
            final String str2 = str;
            Log.i("FinderFollowTopicHeaderView", "success:" + booleanValue + " , filePath:" + str2 + ", fileExist:" + com.tencent.mm.pluginsdk.j.a.d.a.YS(this.uPr.getFilePath()));
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                /* class com.tencent.mm.plugin.finder.music.FinderFollowTopicHeaderView.c.AnonymousClass1 */
                final /* synthetic */ c uPt;

                {
                    this.uPt = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ kotlin.x invoke() {
                    AppMethodBeat.i(248877);
                    FinderFollowTopicHeaderView finderFollowTopicHeaderView = this.uPt.uPr;
                    String str = str2;
                    if (str == null) {
                        str = "";
                    }
                    finderFollowTopicHeaderView.setAudioPath(str);
                    if (booleanValue) {
                        this.uPt.uPr.setDownloadFinish(FinderFollowTopicHeaderView.auk(this.uPt.uPr.getFilePath()));
                    }
                    com.tencent.mm.ui.base.q dialog = this.uPt.uPr.getDialog();
                    if (dialog != null && dialog.isShowing()) {
                        com.tencent.mm.ui.base.q dialog2 = this.uPt.uPr.getDialog();
                        if (dialog2 != null) {
                            dialog2.dismiss();
                        }
                        this.uPt.uPr.dla();
                    }
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(248877);
                    return xVar;
                }
            });
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(248878);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "success", "", "filepath", "", "invoke"})
    public static final class d extends kotlin.g.b.q implements kotlin.g.a.m<Boolean, String, kotlin.x> {
        final /* synthetic */ FinderFollowTopicHeaderView uPr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(FinderFollowTopicHeaderView finderFollowTopicHeaderView) {
            super(2);
            this.uPr = finderFollowTopicHeaderView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(Boolean bool, String str) {
            AppMethodBeat.i(248880);
            final boolean booleanValue = bool.booleanValue();
            final String str2 = str;
            Log.i("FinderFollowTopicHeaderView", "success:" + booleanValue + " , filePath:" + str2 + ", fileExist:" + com.tencent.mm.pluginsdk.j.a.d.a.YS(this.uPr.getFilePath()));
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                /* class com.tencent.mm.plugin.finder.music.FinderFollowTopicHeaderView.d.AnonymousClass1 */
                final /* synthetic */ d uPv;

                {
                    this.uPv = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ kotlin.x invoke() {
                    AppMethodBeat.i(248879);
                    FinderFollowTopicHeaderView finderFollowTopicHeaderView = this.uPv.uPr;
                    String str = str2;
                    if (str == null) {
                        str = "";
                    }
                    finderFollowTopicHeaderView.setFilePath(str);
                    if (booleanValue) {
                        this.uPv.uPr.setDownloadFinish(FinderFollowTopicHeaderView.auk(this.uPv.uPr.getFilePath()));
                    }
                    com.tencent.mm.ui.base.q dialog = this.uPv.uPr.getDialog();
                    if (dialog != null && dialog.isShowing()) {
                        com.tencent.mm.ui.base.q dialog2 = this.uPv.uPr.getDialog();
                        if (dialog2 != null) {
                            dialog2.dismiss();
                        }
                        this.uPv.uPr.dla();
                    }
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(248879);
                    return xVar;
                }
            });
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(248880);
            return xVar;
        }
    }

    public static final /* synthetic */ boolean Jw(int i2) {
        AppMethodBeat.i(248916);
        boolean Jv = Jv(i2);
        AppMethodBeat.o(248916);
        return Jv;
    }

    public static final /* synthetic */ boolean auk(String str) {
        AppMethodBeat.i(248915);
        boolean auj = auj(str);
        AppMethodBeat.o(248915);
        return auj;
    }

    public final FinderVideoViewForTopic getVideoView() {
        return this.uPc;
    }

    public final void setVideoView(FinderVideoViewForTopic finderVideoViewForTopic) {
        this.uPc = finderVideoViewForTopic;
    }

    public final FinderItem getOriginFeed() {
        return this.uPd;
    }

    public final void setOriginFeed(FinderItem finderItem) {
        this.uPd = finderItem;
    }

    public final bdr getFinderBgmInfo() {
        return this.uPe;
    }

    public final void setFinderBgmInfo(bdr bdr) {
        this.uPe = bdr;
    }

    public final s getMedia() {
        return this.uPf;
    }

    public final void setMedia(s sVar) {
        this.uPf = sVar;
    }

    public final void setFirstClickPlay(boolean z) {
        this.uPg = z;
    }

    public final com.tencent.mm.ui.base.q getDialog() {
        return this.nUq;
    }

    public final void setDialog(com.tencent.mm.ui.base.q qVar) {
        this.nUq = qVar;
    }

    public final boolean getDownloadFinish() {
        return this.dvV;
    }

    public final void setDownloadFinish(boolean z) {
        this.dvV = z;
    }

    public final AudioCacheInfo getAudioInfo() {
        return this.uPh;
    }

    public final void setAudioInfo(AudioCacheInfo audioCacheInfo) {
        this.uPh = audioCacheInfo;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i2) {
        this.type = i2;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final void setFilePath(String str) {
        AppMethodBeat.i(248896);
        kotlin.g.b.p.h(str, "<set-?>");
        this.filePath = str;
        AppMethodBeat.o(248896);
    }

    public final FinderImgFeedMusicTag getBgmPlayBtn() {
        return this.uPi;
    }

    public final void setBgmPlayBtn(FinderImgFeedMusicTag finderImgFeedMusicTag) {
        this.uPi = finderImgFeedMusicTag;
    }

    public final String getAudioPath() {
        return this.uPj;
    }

    public final void setAudioPath(String str) {
        AppMethodBeat.i(248897);
        kotlin.g.b.p.h(str, "<set-?>");
        this.uPj = str;
        AppMethodBeat.o(248897);
    }

    public final int getTabType() {
        return this.dLS;
    }

    public final void setTabType(int i2) {
        this.dLS = i2;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$Companion;", "", "()V", "TAG", "", "TYPE_FEED_VIDEO", "", "TYPE_PURE_MUSIC", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final View.OnClickListener getCurrentListener() {
        return this.uPk;
    }

    public final void setCurrentListener(View.OnClickListener onClickListener) {
        this.uPk = onClickListener;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class o implements View.OnClickListener {
        final /* synthetic */ FinderFollowTopicHeaderView uPr;

        o(FinderFollowTopicHeaderView finderFollowTopicHeaderView) {
            this.uPr = finderFollowTopicHeaderView;
        }

        public final void onClick(View view) {
            FinderObject feedObject;
            AppMethodBeat.i(248893);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$playVideoListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderVideoViewForTopic videoView = this.uPr.getVideoView();
            if (videoView != null) {
                if (this.uPr.uPg) {
                    this.uPr.setFirstClickPlay(false);
                    videoView.setMute(false);
                    videoView.c(0.0d, true);
                } else {
                    videoView.play();
                }
                ((WeImageView) this.uPr._$_findCachedViewById(R.id.d0j)).setImageDrawable(ar.m(this.uPr.getContext(), R.raw.finder_music_follow_topic_pause_icon, com.tencent.mm.cb.a.n(this.uPr.getContext(), R.color.FG_0)));
                ((WeImageView) this.uPr._$_findCachedViewById(R.id.d0j)).setOnClickListener(this.uPr.uPm);
                this.uPr.setCurrentListener(this.uPr.uPm);
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                Context context = this.uPr.getContext();
                kotlin.g.b.p.g(context, "context");
                FinderItem originFeed = this.uPr.getOriginFeed();
                com.tencent.mm.plugin.finder.report.k.a(context, 2, 2, (originFeed == null || (feedObject = originFeed.getFeedObject()) == null) ? null : Integer.valueOf(feedObject.follow_feed_count));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$playVideoListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248893);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class m implements View.OnClickListener {
        final /* synthetic */ FinderFollowTopicHeaderView uPr;

        m(FinderFollowTopicHeaderView finderFollowTopicHeaderView) {
            this.uPr = finderFollowTopicHeaderView;
        }

        public final void onClick(View view) {
            FinderObject feedObject;
            AppMethodBeat.i(248891);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$pauseVideoListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderVideoViewForTopic videoView = this.uPr.getVideoView();
            if (videoView != null) {
                ((WeImageView) this.uPr._$_findCachedViewById(R.id.d0j)).setImageDrawable(ar.m(this.uPr.getContext(), R.raw.finder_music_follow_topic_play_icon, com.tencent.mm.cb.a.n(this.uPr.getContext(), R.color.FG_0)));
                videoView.pause();
                ((WeImageView) this.uPr._$_findCachedViewById(R.id.d0j)).setOnClickListener(this.uPr.uPl);
                this.uPr.setCurrentListener(this.uPr.uPl);
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                Context context = this.uPr.getContext();
                kotlin.g.b.p.g(context, "context");
                FinderItem originFeed = this.uPr.getOriginFeed();
                com.tencent.mm.plugin.finder.report.k.a(context, 2, 3, (originFeed == null || (feedObject = originFeed.getFeedObject()) == null) ? null : Integer.valueOf(feedObject.follow_feed_count));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$pauseVideoListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248891);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class n implements View.OnClickListener {
        final /* synthetic */ FinderFollowTopicHeaderView uPr;

        n(FinderFollowTopicHeaderView finderFollowTopicHeaderView) {
            this.uPr = finderFollowTopicHeaderView;
        }

        public final void onClick(View view) {
            FinderObject feedObject;
            AppMethodBeat.i(248892);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$playMusicListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderImgFeedMusicTag bgmPlayBtn = this.uPr.getBgmPlayBtn();
            if (bgmPlayBtn != null) {
                bgmPlayBtn.dlf();
            }
            ((WeImageView) this.uPr._$_findCachedViewById(R.id.d0j)).setImageDrawable(ar.m(this.uPr.getContext(), R.raw.finder_music_follow_topic_pause_icon, com.tencent.mm.cb.a.n(this.uPr.getContext(), R.color.FG_0)));
            ((WeImageView) this.uPr._$_findCachedViewById(R.id.d0j)).setOnClickListener(this.uPr.uPo);
            this.uPr.setCurrentListener(this.uPr.uPo);
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            Context context = this.uPr.getContext();
            kotlin.g.b.p.g(context, "context");
            FinderItem originFeed = this.uPr.getOriginFeed();
            com.tencent.mm.plugin.finder.report.k.a(context, 2, 2, (originFeed == null || (feedObject = originFeed.getFeedObject()) == null) ? null : Integer.valueOf(feedObject.follow_feed_count));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$playMusicListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248892);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class l implements View.OnClickListener {
        final /* synthetic */ FinderFollowTopicHeaderView uPr;

        l(FinderFollowTopicHeaderView finderFollowTopicHeaderView) {
            this.uPr = finderFollowTopicHeaderView;
        }

        public final void onClick(View view) {
            FinderObject feedObject;
            AppMethodBeat.i(248890);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$pauseMusicListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderImgFeedMusicTag bgmPlayBtn = this.uPr.getBgmPlayBtn();
            if (bgmPlayBtn != null) {
                bgmPlayBtn.bdY();
            }
            ((WeImageView) this.uPr._$_findCachedViewById(R.id.d0j)).setImageDrawable(ar.m(this.uPr.getContext(), R.raw.finder_music_follow_topic_play_icon, com.tencent.mm.cb.a.n(this.uPr.getContext(), R.color.FG_0)));
            ((WeImageView) this.uPr._$_findCachedViewById(R.id.d0j)).setOnClickListener(this.uPr.uPn);
            this.uPr.setCurrentListener(this.uPr.uPn);
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            Context context = this.uPr.getContext();
            kotlin.g.b.p.g(context, "context");
            FinderItem originFeed = this.uPr.getOriginFeed();
            com.tencent.mm.plugin.finder.report.k.a(context, 2, 3, (originFeed == null || (feedObject = originFeed.getFeedObject()) == null) ? null : Integer.valueOf(feedObject.follow_feed_count));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$pauseMusicListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248890);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g implements View.OnClickListener {
        final /* synthetic */ FinderFollowTopicHeaderView uPr;

        g(FinderFollowTopicHeaderView finderFollowTopicHeaderView) {
            this.uPr = finderFollowTopicHeaderView;
        }

        public final void onClick(View view) {
            Integer num;
            FinderObject feedObject;
            AppMethodBeat.i(248883);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$copyrightRestrictionListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            bdr finderBgmInfo = this.uPr.getFinderBgmInfo();
            if ((finderBgmInfo != null ? finderBgmInfo.musicInfo : null) != null) {
                u.makeText(this.uPr.getContext(), (int) R.string.ciq, 0).show();
            } else {
                u.makeText(this.uPr.getContext(), (int) R.string.cip, 0).show();
            }
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            Context context = this.uPr.getContext();
            kotlin.g.b.p.g(context, "context");
            FinderItem originFeed = this.uPr.getOriginFeed();
            if (originFeed == null || (feedObject = originFeed.getFeedObject()) == null) {
                num = null;
            } else {
                num = Integer.valueOf(feedObject.follow_feed_count);
            }
            com.tencent.mm.plugin.finder.report.k.a(context, 2, 4, num);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$copyrightRestrictionListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248883);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFollowTopicHeaderView(Context context) {
        super(context);
        kotlin.g.b.p.h(context, "context");
        AppMethodBeat.i(248911);
        bh(context);
        AppMethodBeat.o(248911);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFollowTopicHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.g.b.p.h(context, "context");
        AppMethodBeat.i(248912);
        bh(context);
        AppMethodBeat.o(248912);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFollowTopicHeaderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.g.b.p.h(context, "context");
        AppMethodBeat.i(248913);
        bh(context);
        AppMethodBeat.o(248913);
    }

    private final void bh(Context context) {
        AppMethodBeat.i(248898);
        aa.jQ(context).inflate(R.layout.abn, (ViewGroup) this, true);
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.c5);
        int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.cb);
        setPadding(dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset);
        this.uPc = (FinderVideoViewForTopic) findViewById(R.id.j6y);
        View findViewById = findViewById(R.id.d80);
        kotlin.g.b.p.g(findViewById, "this.findViewById<TextView>(R.id.follow_btn_tv)");
        ao.a(((TextView) findViewById).getPaint(), 0.8f);
        com.tencent.mm.kernel.g.azz().b(new cd(11));
        AppMethodBeat.o(248898);
    }

    public static boolean Jv(int i2) {
        return (i2 & 1) == 1;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$bindOriginFeed$3$1"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ FinderFollowTopicHeaderView uPr;
        final /* synthetic */ bdr uPs;

        public b(FinderFollowTopicHeaderView finderFollowTopicHeaderView, bdr bdr) {
            this.uPr = finderFollowTopicHeaderView;
            this.uPs = bdr;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(248876);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$bindOriginFeed$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            FinderContact finderContact = this.uPs.contact;
            intent.putExtra("finder_username", finderContact != null ? finderContact.username : null);
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            Context context = this.uPr.getContext();
            kotlin.g.b.p.g(context, "context");
            FinderReporterUIC.a.a(context, intent, 0, 6, false, 64);
            com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
            kotlin.g.b.p.g(view, LocaleUtil.ITALIAN);
            Context context2 = view.getContext();
            kotlin.g.b.p.g(context2, "it.context");
            com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(context2, intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$bindOriginFeed$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248876);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class e implements View.OnClickListener {
        final /* synthetic */ FinderFollowTopicHeaderView uPr;

        public e(FinderFollowTopicHeaderView finderFollowTopicHeaderView) {
            this.uPr = finderFollowTopicHeaderView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(248881);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$bindOriginFeed$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            u.makeText(this.uPr.getContext(), (int) R.string.f3157com, 0).show();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$bindOriginFeed$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248881);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class f implements View.OnClickListener {
        final /* synthetic */ FinderFollowTopicHeaderView uPr;
        final /* synthetic */ int uPw;

        public f(FinderFollowTopicHeaderView finderFollowTopicHeaderView, int i2) {
            this.uPr = finderFollowTopicHeaderView;
            this.uPw = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(248882);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$bindOriginFeed$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (FinderFollowTopicHeaderView.Jw(this.uPw)) {
                this.uPr.uPp.onClick(view);
            } else {
                this.uPr.dla();
            }
            com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
            com.tencent.mm.plugin.finder.report.i.H(false, 6);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$bindOriginFeed$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248882);
        }
    }

    public static boolean auj(String str) {
        AppMethodBeat.i(248899);
        if (!com.tencent.mm.pluginsdk.j.a.d.a.YS(str) || com.tencent.mm.pluginsdk.j.a.d.a.hv(str) <= 0) {
            AppMethodBeat.o(248899);
            return false;
        }
        AppMethodBeat.o(248899);
        return true;
    }

    private final void bEq() {
        AppMethodBeat.i(248900);
        com.tencent.mm.plugin.finder.view.d dVar = new com.tencent.mm.plugin.finder.view.d(getContext());
        dVar.Ml(R.layout.abo);
        dVar.lJI.findViewById(R.id.ai8).setOnClickListener(new p(this, dVar));
        dVar.lJI.findViewById(R.id.bhy).setOnClickListener(new q(this, dVar));
        dVar.dGm();
        AppMethodBeat.o(248900);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$showBottomSheet$1$1"})
    public static final class p implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.finder.view.d tOn;
        final /* synthetic */ FinderFollowTopicHeaderView uPr;

        p(FinderFollowTopicHeaderView finderFollowTopicHeaderView, com.tencent.mm.plugin.finder.view.d dVar) {
            this.uPr = finderFollowTopicHeaderView;
            this.tOn = dVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(248894);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$showBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.tOn.bMo();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$showBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248894);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$showBottomSheet$1$2"})
    public static final class q implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.finder.view.d tOn;
        final /* synthetic */ FinderFollowTopicHeaderView uPr;

        q(FinderFollowTopicHeaderView finderFollowTopicHeaderView, com.tencent.mm.plugin.finder.view.d dVar) {
            this.uPr = finderFollowTopicHeaderView;
            this.tOn = dVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(248895);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$showBottomSheet$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.uPr.getContext());
            if (castActivityOrNull != null) {
                y yVar = y.vXH;
                if (y.bE(castActivityOrNull)) {
                    Intent intent = new Intent();
                    intent.putExtra("key_create_scene", 3);
                    intent.putExtra("scene", 2);
                    com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                    Context context = this.uPr.getContext();
                    kotlin.g.b.p.g(context, "context");
                    com.tencent.mm.plugin.finder.utils.a.w(context, intent);
                }
            }
            this.tOn.bMo();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$showBottomSheet$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248895);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void dla() {
        com.tencent.mm.ui.base.q qVar;
        AppMethodBeat.i(248901);
        y yVar = y.vXH;
        switch (y.dCL()) {
            case 1:
                u.makeText(getContext(), (int) R.string.d3l, 0).show();
                AppMethodBeat.o(248901);
                return;
            case 2:
                bEq();
                AppMethodBeat.o(248901);
                return;
            case 3:
            case 6:
                break;
            case 4:
                u.makeText(getContext(), (int) R.string.cgf, 0).show();
                AppMethodBeat.o(248901);
                return;
            case 5:
                u.makeText(getContext(), (int) R.string.d8n, 0).show();
                AppMethodBeat.o(248901);
                return;
            default:
                Log.d("FinderFollowTopicHeaderView", "not one of six state");
                break;
        }
        if (this.dvV) {
            com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
            if (com.tencent.mm.plugin.finder.spam.a.avp("post")) {
                AppMethodBeat.o(248901);
                return;
            }
            com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
            Context context = getContext();
            kotlin.g.b.p.g(context, "context");
            com.tencent.mm.plugin.finder.utils.a.fr(context);
            com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
            com.tencent.mm.plugin.finder.report.i.as(6, false);
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(getContext(), 1, true);
            View inflate = aa.jQ(getContext()).inflate(R.layout.ak1, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.fzc);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.wm);
            c.a aVar3 = com.tencent.mm.plugin.finder.api.c.tsp;
            com.tencent.mm.plugin.finder.api.g asG = c.a.asG(z.aUg());
            if (asG != null) {
                kotlin.g.b.p.g(textView, "nicknameTv");
                textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), asG.getNickname()));
                com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
                com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dka = com.tencent.mm.plugin.finder.loader.m.dka();
                com.tencent.mm.plugin.finder.loader.a aVar4 = new com.tencent.mm.plugin.finder.loader.a(asG.field_avatarUrl);
                kotlin.g.b.p.g(imageView, "avatarIv");
                com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
                dka.a(aVar4, imageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.AVATAR));
            }
            StringBuilder sb = new StringBuilder();
            kotlin.g.b.p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
            String sb2 = sb.append(com.tencent.mm.kernel.a.ayV()).append('_').append(Util.nowMilliSecond()).toString();
            com.tencent.mm.plugin.finder.report.i iVar2 = com.tencent.mm.plugin.finder.report.i.vfo;
            com.tencent.mm.plugin.finder.report.i.auH(sb2);
            eVar.V(inflate, true);
            eVar.a(i.uPy);
            eVar.a(new j(this, sb2));
            eVar.b(k.uPA);
            eVar.dGm();
            AppMethodBeat.o(248901);
        } else if (this.nUq == null) {
            this.nUq = com.tencent.mm.ui.base.q.a(getContext(), getContext().getString(R.string.coj), true, 2, null);
            AppMethodBeat.o(248901);
        } else {
            com.tencent.mm.ui.base.q qVar2 = this.nUq;
            if (qVar2 == null) {
                AppMethodBeat.o(248901);
            } else if (qVar2.isShowing() || (qVar = this.nUq) == null) {
                AppMethodBeat.o(248901);
            } else {
                qVar.show();
                AppMethodBeat.o(248901);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class i implements o.f {
        public static final i uPy = new i();

        static {
            AppMethodBeat.i(248886);
            AppMethodBeat.o(248886);
        }

        i() {
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(248885);
            kotlin.g.b.p.g(mVar, LocaleUtil.ITALIAN);
            if (mVar.gKQ()) {
                mVar.kV(1001, R.string.um);
                mVar.kV(1002, R.string.uv);
            }
            AppMethodBeat.o(248885);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class j implements o.g {
        final /* synthetic */ FinderFollowTopicHeaderView uPr;
        final /* synthetic */ String uPz;

        j(FinderFollowTopicHeaderView finderFollowTopicHeaderView, String str) {
            this.uPr = finderFollowTopicHeaderView;
            this.uPz = str;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            azk azk;
            String str;
            String str2;
            azk azk2;
            String str3;
            String str4;
            azk azk3;
            FinderContact finderContact;
            int i3;
            azk azk4;
            FinderContact finderContact2;
            String str5;
            String str6;
            String str7 = null;
            AppMethodBeat.i(248887);
            Intent intent = new Intent();
            kotlin.g.b.p.g(menuItem, "menuItem");
            if (menuItem.getItemId() == 1001) {
                intent.putExtra("key_finder_post_router", 2);
            } else if (menuItem.getItemId() == 1002) {
                intent.putExtra("key_finder_post_router", 3);
            }
            String str8 = "";
            String str9 = "";
            String str10 = "";
            if (this.uPr.getType() == 1) {
                String audioPath = this.uPr.getAudioPath();
                bdr finderBgmInfo = this.uPr.getFinderBgmInfo();
                if (finderBgmInfo == null || (str5 = finderBgmInfo.groupId) == null) {
                    str5 = "-1";
                }
                bdr finderBgmInfo2 = this.uPr.getFinderBgmInfo();
                if (finderBgmInfo2 == null || (str6 = finderBgmInfo2.audioTrackUrl) == null) {
                    str6 = "";
                }
                azk = null;
                str10 = str6;
                str = str5;
                str2 = audioPath;
            } else {
                if (this.uPr.getType() == 2) {
                    AudioCacheInfo audioInfo = this.uPr.getAudioInfo();
                    if (audioInfo == null || (str8 = audioInfo.cachePath) == null) {
                        str8 = "";
                    }
                    bdr finderBgmInfo3 = this.uPr.getFinderBgmInfo();
                    if (finderBgmInfo3 == null || (str9 = finderBgmInfo3.groupId) == null) {
                        str9 = "-1";
                    }
                    bdr finderBgmInfo4 = this.uPr.getFinderBgmInfo();
                    if (!(finderBgmInfo4 == null || (azk2 = finderBgmInfo4.musicInfo) == null)) {
                        str10 = azk2.LJi;
                        if (str10 == null) {
                            str10 = "";
                        }
                        azk azk5 = new azk();
                        bdr finderBgmInfo5 = this.uPr.getFinderBgmInfo();
                        if (finderBgmInfo5 == null || (str3 = finderBgmInfo5.groupId) == null) {
                            str3 = "";
                        }
                        azk5.wWb = str3;
                        String str11 = azk2.LJi;
                        if (str11 == null) {
                            str11 = "";
                        }
                        azk5.LJi = str11;
                        azk5.artist = azk2.artist;
                        azk5.name = azk2.name;
                        azk = azk5;
                        str = str9;
                        str2 = str8;
                    }
                }
                azk = null;
                str = str9;
                str2 = str8;
            }
            intent.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_ID", str);
            intent.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_PATH", str2);
            intent.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_INFO", azk != null ? azk.toByteArray() : null);
            bdr finderBgmInfo6 = this.uPr.getFinderBgmInfo();
            if (finderBgmInfo6 == null || (finderContact2 = finderBgmInfo6.contact) == null) {
                str4 = null;
            } else {
                str4 = finderContact2.username;
            }
            intent.putExtra("KEY_FINDER_POST_BGM_IF_ORIGIN", kotlin.g.b.p.j(str4, z.aUg()));
            intent.putExtra("KEY_FINDER_POST_ORIGIN_BGM_URL", str10);
            bdr finderBgmInfo7 = this.uPr.getFinderBgmInfo();
            if (finderBgmInfo7 != null) {
                azk3 = finderBgmInfo7.musicInfo;
            } else {
                azk3 = null;
            }
            if (azk3 != null) {
                bdr finderBgmInfo8 = this.uPr.getFinderBgmInfo();
                if (!(finderBgmInfo8 == null || (azk4 = finderBgmInfo8.musicInfo) == null)) {
                    str7 = azk4.name;
                }
                intent.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_NAME", String.valueOf(str7));
            } else {
                StringBuilder sb = new StringBuilder();
                bdr finderBgmInfo9 = this.uPr.getFinderBgmInfo();
                if (!(finderBgmInfo9 == null || (finderContact = finderBgmInfo9.contact) == null)) {
                    str7 = finderContact.nickname;
                }
                intent.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_NAME", sb.append(str7).append("的动态原声").toString());
            }
            Log.i("FinderFollowTopicHeaderView", "tabType " + this.uPr.getTabType());
            switch (this.uPr.getTabType()) {
                case 1:
                case 3:
                case 4:
                    i3 = 5;
                    break;
                case 2:
                default:
                    i3 = 5;
                    break;
                case 5:
                case 6:
                    i3 = 7;
                    break;
            }
            intent.putExtra("key_finder_post_from", i3);
            intent.putExtra("key_finder_post_id", this.uPz);
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            Context context = this.uPr.getContext();
            kotlin.g.b.p.g(context, "context");
            com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI(context, intent);
            AppMethodBeat.o(248887);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    public static final class k implements e.b {
        public static final k uPA = new k();

        static {
            AppMethodBeat.i(248889);
            AppMethodBeat.o(248889);
        }

        k() {
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(248888);
            com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
            com.tencent.mm.plugin.finder.report.i.Ks(6);
            AppMethodBeat.o(248888);
        }
    }

    public final void onWindowFocusChanged(boolean z) {
        WeImageView weImageView;
        AppMethodBeat.i(248902);
        super.onWindowFocusChanged(z);
        if (z || ((!kotlin.g.b.p.j(this.uPk, this.uPm) && !kotlin.g.b.p.j(this.uPk, this.uPo)) || (weImageView = (WeImageView) _$_findCachedViewById(R.id.d0j)) == null)) {
            AppMethodBeat.o(248902);
            return;
        }
        weImageView.performClick();
        AppMethodBeat.o(248902);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(248903);
        super.onDetachedFromWindow();
        Log.d("FinderFollowTopicHeaderView", "[onDetachedFromWindow] onViewRecycled");
        AppMethodBeat.o(248903);
    }

    public final void a(s sVar) {
        String str;
        AppMethodBeat.i(248904);
        bdr bdr = this.uPe;
        if (bdr != null) {
            String str2 = bdr.audioTrackUrl;
            if (str2 == null || str2.length() == 0) {
                al alVar = al.waC;
                String str3 = bdr.groupId;
                if (str3 == null) {
                    str3 = "emptyid_" + System.currentTimeMillis();
                }
                String awB = al.awB(str3);
                if (auj(awB)) {
                    Log.i("FinderFollowTopicHeaderView", "audio length = " + ((((float) com.tencent.mm.pluginsdk.j.a.d.a.hv(awB)) / 1024.0f) / 1024.0f) + 'M');
                    this.uPj = awB;
                    AppMethodBeat.o(248904);
                    return;
                }
                Log.i("FinderFollowTopicHeaderView", "audio:" + awB + " track no exist");
                am amVar = am.waD;
                if (am.hi(sVar.getPath(), awB)) {
                    Log.i("FinderFollowTopicHeaderView", "[SimpleAudioExtractor] true");
                    Log.i("FinderFollowTopicHeaderView", "audio length = " + ((((float) com.tencent.mm.pluginsdk.j.a.d.a.hv(awB)) / 1024.0f) / 1024.0f) + 'M');
                    MultiMediaVideoChecker multiMediaVideoChecker = MultiMediaVideoChecker.GyY;
                    if (awB == null) {
                        str = "";
                    } else {
                        str = awB;
                    }
                    MultiMediaVideoChecker.a aTW = MultiMediaVideoChecker.aTW(str);
                    if (aTW == null || aTW.duration == 0) {
                        Log.i("FinderFollowTopicHeaderView", "no audio track");
                        this.dvV = false;
                        ((LinearLayout) _$_findCachedViewById(R.id.d7y)).setOnClickListener(this.uPp);
                        AppMethodBeat.o(248904);
                        return;
                    }
                    this.uPj = awB;
                    AppMethodBeat.o(248904);
                    return;
                }
                Log.i("FinderFollowTopicHeaderView", "[SimpleAudioExtractor] false");
                Toast.makeText(getContext(), (int) R.string.col, 0).show();
                this.dvV = false;
                ((LinearLayout) _$_findCachedViewById(R.id.d7y)).setOnClickListener(this.uPp);
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(1530, 0, 1);
            }
            AppMethodBeat.o(248904);
            return;
        }
        AppMethodBeat.o(248904);
    }

    @Override // com.tencent.mm.plugin.finder.video.x
    public final void b(s sVar) {
        AppMethodBeat.i(248905);
        kotlin.g.b.p.h(sVar, "video");
        Log.i("FinderFollowTopicHeaderView", "[onStartDownload]");
        AppMethodBeat.o(248905);
    }

    @Override // com.tencent.mm.plugin.finder.video.x
    public final void a(s sVar, com.tencent.mm.i.h hVar, com.tencent.mm.i.d dVar) {
        AppMethodBeat.i(248906);
        kotlin.g.b.p.h(sVar, "video");
        Log.i("FinderFollowTopicHeaderView", "[onStopDownload]");
        AppMethodBeat.o(248906);
    }

    @Override // com.tencent.mm.plugin.finder.video.x
    public final void a(int i2, s sVar, com.tencent.mm.i.d dVar) {
        AppMethodBeat.i(248907);
        kotlin.g.b.p.h(sVar, "video");
        Log.i("FinderFollowTopicHeaderView", "[onFinishDownload] videoPath = " + sVar.getPath());
        this.dvV = i2 == 0;
        if (!this.dvV) {
            Toast.makeText(getContext(), (int) R.string.col, 0).show();
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(1530, 1, 1);
            AppMethodBeat.o(248907);
        } else if (this.uPe != null) {
            a(sVar);
            com.tencent.mm.ui.base.q qVar = this.nUq;
            if (qVar != null && qVar.isShowing()) {
                com.tencent.mm.ui.base.q qVar2 = this.nUq;
                if (qVar2 != null) {
                    qVar2.dismiss();
                }
                com.tencent.mm.ac.d.h(new h(this, sVar, i2));
            }
            Log.i("FinderFollowTopicHeaderView", "[onFinishDownload] ret = " + i2 + ",fileExist = " + com.tencent.mm.pluginsdk.j.a.d.a.YS(sVar.getPath()) + ",fileSize = " + com.tencent.mm.pluginsdk.j.a.d.a.hv(sVar.getPath()));
            AppMethodBeat.o(248907);
        } else {
            AppMethodBeat.o(248907);
        }
    }

    @Override // com.tencent.mm.plugin.finder.video.x
    public final void ac(String str, int i2, int i3) {
        AppMethodBeat.i(248908);
        kotlin.g.b.p.h(str, "mediaId");
        Log.i("FinderFollowTopicHeaderView", "[checkVideoDataAvailable]");
        AppMethodBeat.o(248908);
    }

    @Override // com.tencent.mm.plugin.finder.video.x
    public final void a(int i2, int i3, s sVar, boolean z) {
        AppMethodBeat.i(248909);
        kotlin.g.b.p.h(sVar, "video");
        Log.i("FinderFollowTopicHeaderView", "[onMoovReadyDownload]");
        AppMethodBeat.o(248909);
    }

    @Override // com.tencent.mm.plugin.finder.video.x
    public final void a(int i2, int i3, s sVar) {
        AppMethodBeat.i(248910);
        kotlin.g.b.p.h(sVar, "video");
        Log.i("FinderFollowTopicHeaderView", "[onProgressDownload] offset:" + i2 + ',' + i3);
        AppMethodBeat.o(248910);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$onFinishDownload$1$1"})
    static final class h extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ int uJz;
        final /* synthetic */ FinderFollowTopicHeaderView uPr;
        final /* synthetic */ s uPx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(FinderFollowTopicHeaderView finderFollowTopicHeaderView, s sVar, int i2) {
            super(0);
            this.uPr = finderFollowTopicHeaderView;
            this.uPx = sVar;
            this.uJz = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(248884);
            this.uPr.dla();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(248884);
            return xVar;
        }
    }
}
