package com.tencent.mm.live.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.c;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.k;
import com.google.android.exoplayer2.h.n;
import com.google.android.exoplayer2.q;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import java.io.IOException;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000É\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001,\u0018\u00002\u00020\u00012\u00020\u0002:\u0001]B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010<\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\r2\u0006\u00102\u001a\u00020\u0011H\u0002J\u0006\u0010@\u001a\u00020#J\b\u0010A\u001a\u00020\nH\u0002J\b\u0010B\u001a\u00020#H\u0002J\u0006\u0010C\u001a\u00020#J\u0010\u0010D\u001a\u00020#2\u0006\u0010E\u001a\u00020\u001cH\u0016J\u0012\u0010F\u001a\u00020#2\b\u0010E\u001a\u0004\u0018\u00010GH\u0016J\u0012\u0010H\u001a\u00020#2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u0018\u0010K\u001a\u00020#2\u0006\u0010L\u001a\u00020\u001c2\u0006\u0010M\u001a\u00020\nH\u0016J\b\u0010N\u001a\u00020#H\u0016J\u0010\u0010O\u001a\u00020#2\u0006\u0010E\u001a\u00020\nH\u0016J\u001c\u0010P\u001a\u00020#2\b\u0010E\u001a\u0004\u0018\u00010Q2\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J\u001c\u0010T\u001a\u00020#2\b\u0010E\u001a\u0004\u0018\u00010U2\b\u0010R\u001a\u0004\u0018\u00010VH\u0016J\b\u0010W\u001a\u00020#H\u0002J\u0006\u0010X\u001a\u00020#J\b\u0010Y\u001a\u00020#H\u0002J\u0010\u0010Z\u001a\u00020#2\b\u0010[\u001a\u0004\u0018\u00010\u0011J\b\u0010\\\u001a\u00020#H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R7\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020#\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u00020,X\u0004¢\u0006\u0004\n\u0002\u0010-R\u000e\u0010.\u001a\u00020/X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R\u0016\u00102\u001a\n 3*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000R$\u00106\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u000107X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006^"}, hxF = {"Lcom/tencent/mm/live/view/LiveReplayVideoView;", "Landroid/widget/RelativeLayout;", "Lcom/google/android/exoplayer2/Player$EventListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BANDWIDTH_METER", "Lcom/google/android/exoplayer2/upstream/DefaultBandwidthMeter;", "REPEATER_DELAY", "", "TAG", "", "closeBtn", "Landroid/widget/ImageView;", "dataSourceFactory", "Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "eventHandler", "Landroid/os/Handler;", "footerGroup", "Landroid/view/ViewGroup;", "headerGroup", "isVideoEnd", "", "onCloseClickListener", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "getOnCloseClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnCloseClickListener", "(Lkotlin/jvm/functions/Function1;)V", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "repeaterHandler", "repeaterTask", "com/tencent/mm/live/view/LiveReplayVideoView$repeaterTask$1", "Lcom/tencent/mm/live/view/LiveReplayVideoView$repeaterTask$1;", "textureView", "Landroid/view/TextureView;", "titleTv", "Landroid/widget/TextView;", "userAgent", "kotlin.jvm.PlatformType", "videoSeekBar", "Lcom/tencent/mm/pluginsdk/ui/tools/RedesignVideoPlayerSeekBar;", "videoSeekBarDragCallback", "Lkotlin/Function0;", "getVideoSeekBarDragCallback", "()Lkotlin/jvm/functions/Function0;", "setVideoSeekBarDragCallback", "(Lkotlin/jvm/functions/Function0;)V", "buildDefaultDataSourceFactory", "buildDefaultHttpDataSourceFactory", "Lcom/google/android/exoplayer2/upstream/HttpDataSource$Factory;", "bandwidthMeter", "finish", "getLayoutId", "initVideoPlayer", "onDestroy", "onLoadingChanged", "p0", "onPlaybackParametersChanged", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "ex", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "playWhenReady", "playbackState", "onPositionDiscontinuity", "onRepeatModeChanged", "onTimelineChanged", "Lcom/google/android/exoplayer2/Timeline;", "p1", "", "onTracksChanged", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "postRepeaterTask", "release", "reset", "start", "url", "toggleHeaderAndFooter", "ExoMediaSourceEventListener", "plugin-logic_release"})
public final class LiveReplayVideoView extends RelativeLayout implements q.a {
    private final String TAG;
    private TextureView bec;
    public g.a bwl;
    public final Handler eventHandler;
    private final ImageView hTd;
    public v hWJ;
    private final ViewGroup hWK;
    private final ViewGroup hWL;
    public RedesignVideoPlayerSeekBar hWM;
    private kotlin.g.a.a<x> hWN;
    private final com.google.android.exoplayer2.h.l hWO;
    public boolean hWP;
    private final long hWQ;
    public final Handler hWR;
    private kotlin.g.a.b<? super View, x> hWS;
    public final b hWT;
    public final TextView titleTv;
    private final String userAgent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveReplayVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(208587);
        this.TAG = "MicroMsg.LiveReplayVideoView";
        this.eventHandler = new Handler(Looper.getMainLooper());
        this.userAgent = com.google.android.exoplayer2.i.x.h(context, context.getString(R.string.wx));
        this.hWO = new com.google.android.exoplayer2.h.l();
        this.hWQ = 1000;
        this.hWR = new Handler();
        this.hWT = new b(this);
        View.inflate(context, getLayoutId(), this);
        View findViewById = findViewById(R.id.ee1);
        p.g(findViewById, "findViewById(R.id.live_after_replay_close_icon)");
        this.hTd = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.ee_);
        p.g(findViewById2, "findViewById(R.id.live_after_replay_title_tv)");
        this.titleTv = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.ee8);
        p.g(findViewById3, "findViewById(R.id.live_after_replay_texture_view)");
        this.bec = (TextureView) findViewById3;
        this.hWM = (RedesignVideoPlayerSeekBar) findViewById(R.id.ee4);
        View findViewById4 = findViewById(R.id.ee9);
        p.g(findViewById4, "findViewById(R.id.live_after_replay_title_group)");
        this.hWK = (ViewGroup) findViewById4;
        View findViewById5 = findViewById(R.id.ee2);
        p.g(findViewById5, "findViewById(R.id.live_after_replay_footer_group)");
        this.hWL = (ViewGroup) findViewById5;
        this.hTd.setImageDrawable(ar.e(getResources().getDrawable(R.raw.icons_filled_close), -1));
        this.hWJ = com.google.android.exoplayer2.g.a(new d(getContext()), new c(new a.C0111a(this.hWO)), new com.google.android.exoplayer2.c(new k()));
        Context context2 = getContext();
        p.g(context2, "context");
        com.google.android.exoplayer2.h.l lVar = this.hWO;
        String str = this.userAgent;
        p.g(str, "userAgent");
        this.bwl = new n(context2, this.hWO, new com.google.android.exoplayer2.h.p(str, lVar, true));
        v vVar = this.hWJ;
        if (vVar != null) {
            vVar.a(this);
        }
        v vVar2 = this.hWJ;
        if (vVar2 != null) {
            vVar2.c(this.bec);
        }
        this.hTd.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.view.LiveReplayVideoView.AnonymousClass1 */
            final /* synthetic */ LiveReplayVideoView hWU;

            {
                this.hWU = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(208565);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/view/LiveReplayVideoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                kotlin.g.a.b<View, x> onCloseClickListener = this.hWU.getOnCloseClickListener();
                if (onCloseClickListener != null) {
                    p.g(view, LocaleUtil.ITALIAN);
                    onCloseClickListener.invoke(view);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/view/LiveReplayVideoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(208565);
            }
        });
        this.bec.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.view.LiveReplayVideoView.AnonymousClass2 */
            final /* synthetic */ LiveReplayVideoView hWU;

            {
                this.hWU = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(208566);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/view/LiveReplayVideoView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                LiveReplayVideoView.f(this.hWU);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/view/LiveReplayVideoView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(208566);
            }
        });
        RedesignVideoPlayerSeekBar redesignVideoPlayerSeekBar = this.hWM;
        if (redesignVideoPlayerSeekBar != null) {
            redesignVideoPlayerSeekBar.setPlayBtnOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.live.view.LiveReplayVideoView.AnonymousClass3 */
                final /* synthetic */ LiveReplayVideoView hWU;

                {
                    this.hWU = r1;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(208567);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/view/LiveReplayVideoView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    v vVar = this.hWU.hWJ;
                    if (vVar != null) {
                        if (vVar.tj()) {
                            vVar.aO(false);
                            RedesignVideoPlayerSeekBar redesignVideoPlayerSeekBar = this.hWU.hWM;
                            if (redesignVideoPlayerSeekBar != null) {
                                redesignVideoPlayerSeekBar.setIsPlay(false);
                            }
                        } else {
                            if (this.hWU.hWP) {
                                LiveReplayVideoView.i(this.hWU);
                                this.hWU.hWP = false;
                            }
                            vVar.aO(true);
                            RedesignVideoPlayerSeekBar redesignVideoPlayerSeekBar2 = this.hWU.hWM;
                            if (redesignVideoPlayerSeekBar2 != null) {
                                redesignVideoPlayerSeekBar2.setIsPlay(true);
                            }
                        }
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/view/LiveReplayVideoView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(208567);
                }
            });
        }
        RedesignVideoPlayerSeekBar redesignVideoPlayerSeekBar2 = this.hWM;
        if (redesignVideoPlayerSeekBar2 != null) {
            redesignVideoPlayerSeekBar2.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b(this) {
                /* class com.tencent.mm.live.view.LiveReplayVideoView.AnonymousClass4 */
                final /* synthetic */ LiveReplayVideoView hWU;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.hWU = r1;
                }

                @Override // com.tencent.mm.plugin.sight.decode.ui.b
                public final void aJq() {
                    AppMethodBeat.i(208568);
                    Log.i(this.hWU.TAG, "onSeekPre");
                    v vVar = this.hWU.hWJ;
                    if (vVar != null) {
                        vVar.aO(false);
                        AppMethodBeat.o(208568);
                        return;
                    }
                    AppMethodBeat.o(208568);
                }

                @Override // com.tencent.mm.plugin.sight.decode.ui.b
                public final void rk(int i2) {
                    AppMethodBeat.i(208569);
                    Log.i(this.hWU.TAG, "onSeekTo ".concat(String.valueOf(i2)));
                    v vVar = this.hWU.hWJ;
                    if (vVar != null) {
                        vVar.seekTo(((long) i2) * 1000);
                    }
                    v vVar2 = this.hWU.hWJ;
                    if (vVar2 != null) {
                        vVar2.aO(true);
                    }
                    kotlin.g.a.a<x> videoSeekBarDragCallback = this.hWU.getVideoSeekBarDragCallback();
                    if (videoSeekBarDragCallback != null) {
                        videoSeekBarDragCallback.invoke();
                    }
                    if (this.hWU.hWP) {
                        this.hWU.hWP = false;
                        LiveReplayVideoView.i(this.hWU);
                    }
                    AppMethodBeat.o(208569);
                }
            });
            AppMethodBeat.o(208587);
            return;
        }
        AppMethodBeat.o(208587);
    }

    public static final /* synthetic */ void i(LiveReplayVideoView liveReplayVideoView) {
        AppMethodBeat.i(208590);
        liveReplayVideoView.aJp();
        AppMethodBeat.o(208590);
    }

    public final kotlin.g.a.a<x> getVideoSeekBarDragCallback() {
        return this.hWN;
    }

    public final void setVideoSeekBarDragCallback(kotlin.g.a.a<x> aVar) {
        this.hWN = aVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/live/view/LiveReplayVideoView$repeaterTask$1", "Ljava/lang/Runnable;", "run", "", "plugin-logic_release"})
    public static final class b implements Runnable {
        final /* synthetic */ LiveReplayVideoView hWU;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(LiveReplayVideoView liveReplayVideoView) {
            this.hWU = liveReplayVideoView;
        }

        public final void run() {
            Long l = null;
            AppMethodBeat.i(208577);
            v vVar = this.hWU.hWJ;
            Long valueOf = vVar != null ? Long.valueOf(vVar.getCurrentPosition()) : null;
            v vVar2 = this.hWU.hWJ;
            if (vVar2 != null) {
                l = Long.valueOf(vVar2.getBufferedPosition());
            }
            RedesignVideoPlayerSeekBar redesignVideoPlayerSeekBar = this.hWU.hWM;
            if (redesignVideoPlayerSeekBar != null) {
                redesignVideoPlayerSeekBar.xv((int) ((valueOf != null ? valueOf.longValue() : 0) / 1000));
            }
            Log.i(this.hWU.TAG, "repeaterTask curPosition:" + valueOf + "ms bufferedPosition:" + l + LocaleUtil.MALAY);
            this.hWU.hWR.postDelayed(this, this.hWU.hWQ);
            AppMethodBeat.o(208577);
        }
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super android.view.View, kotlin.x>, kotlin.g.a.b<android.view.View, kotlin.x> */
    public final kotlin.g.a.b<View, x> getOnCloseClickListener() {
        return this.hWS;
    }

    public final void setOnCloseClickListener(kotlin.g.a.b<? super View, x> bVar) {
        this.hWS = bVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LiveReplayVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(208588);
        AppMethodBeat.o(208588);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J4\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016Jf\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eH\u0016Jf\u0010\u0019\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eH\u0016Jx\u0010\u001a\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016JV\u0010\u001f\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J \u0010 \u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0016¨\u0006!"}, hxF = {"Lcom/tencent/mm/live/view/LiveReplayVideoView$ExoMediaSourceEventListener;", "Lcom/google/android/exoplayer2/source/AdaptiveMediaSourceEventListener;", "Lcom/google/android/exoplayer2/source/ExtractorMediaSource$EventListener;", "(Lcom/tencent/mm/live/view/LiveReplayVideoView;)V", "onDownstreamFormatChanged", "", "trackType", "", "trackFormat", "Lcom/google/android/exoplayer2/Format;", "trackSelectionReason", "trackSelectionData", "", "mediaTimeMs", "", "onHasEndTag", "onLoadCanceled", "dataSpec", "Lcom/google/android/exoplayer2/upstream/DataSpec;", "dataType", "mediaStartTimeMs", "mediaEndTimeMs", "elapsedRealtimeMs", "loadDurationMs", "bytesLoaded", "onLoadCompleted", "onLoadError", "error", "Ljava/io/IOException;", "wasCanceled", "", "onLoadStarted", "onUpstreamDiscarded", "plugin-logic_release"})
    public final class a implements com.google.android.exoplayer2.source.b, h.a {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.google.android.exoplayer2.source.b
        public final void a(j jVar, int i2, Format format, long j2, long j3, long j4) {
            AppMethodBeat.i(208570);
            Log.d(LiveReplayVideoView.this.TAG, "onLoadStarted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", jVar, Integer.valueOf(i2), format, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
            AppMethodBeat.o(208570);
        }

        @Override // com.google.android.exoplayer2.source.b
        public final void b(j jVar, int i2, Format format, long j2, long j3, long j4) {
            AppMethodBeat.i(208571);
            Log.d(LiveReplayVideoView.this.TAG, "onLoadCompleted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", jVar, Integer.valueOf(i2), format, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
            AppMethodBeat.o(208571);
        }

        @Override // com.google.android.exoplayer2.source.b
        public final void c(j jVar, int i2, Format format, long j2, long j3, long j4) {
            AppMethodBeat.i(208572);
            Log.d(LiveReplayVideoView.this.TAG, "onLoadCanceled, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", jVar, Integer.valueOf(i2), format, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
            AppMethodBeat.o(208572);
        }

        @Override // com.google.android.exoplayer2.source.b
        public final void a(j jVar, int i2, Format format, long j2, long j3, long j4, long j5, long j6, IOException iOException, boolean z) {
            AppMethodBeat.i(208573);
            RedesignVideoPlayerSeekBar redesignVideoPlayerSeekBar = LiveReplayVideoView.this.hWM;
            if (redesignVideoPlayerSeekBar != null) {
                redesignVideoPlayerSeekBar.setIsPlay(false);
            }
            Log.printErrStackTrace(LiveReplayVideoView.this.TAG, iOException, "onLoadError1, IOException, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s, loadDurationMs:%s, bytesLoaded:%s, wasCanceled:%s", jVar, Integer.valueOf(i2), format, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Boolean.valueOf(z));
            AppMethodBeat.o(208573);
        }

        @Override // com.google.android.exoplayer2.source.b
        public final void a(int i2, Format format, long j2) {
            AppMethodBeat.i(208574);
            Log.d(LiveReplayVideoView.this.TAG, "onDownstreamFormatChanged, trackType:%s, trackFormat:%s, mediaTimeMs:%s", Integer.valueOf(i2), format, Long.valueOf(j2));
            AppMethodBeat.o(208574);
        }

        @Override // com.google.android.exoplayer2.source.b
        public final void vl() {
            AppMethodBeat.i(208575);
            Log.d(LiveReplayVideoView.this.TAG, "onHasEndTag");
            AppMethodBeat.o(208575);
        }

        @Override // com.google.android.exoplayer2.source.h.a
        public final void onLoadError(IOException iOException) {
            AppMethodBeat.i(208576);
            Log.printErrStackTrace(LiveReplayVideoView.this.TAG, iOException, "onLoadError2, IOException", new Object[0]);
            RedesignVideoPlayerSeekBar redesignVideoPlayerSeekBar = LiveReplayVideoView.this.hWM;
            if (redesignVideoPlayerSeekBar != null) {
                redesignVideoPlayerSeekBar.setIsPlay(false);
                AppMethodBeat.o(208576);
                return;
            }
            AppMethodBeat.o(208576);
        }
    }

    public final void aJp() {
        AppMethodBeat.i(208578);
        this.hWR.removeCallbacks(this.hWT);
        this.hWR.post(this.hWT);
        AppMethodBeat.o(208578);
    }

    private final int getLayoutId() {
        return R.layout.b01;
    }

    @Override // com.google.android.exoplayer2.q.a
    public final void b(com.google.android.exoplayer2.p pVar) {
        AppMethodBeat.i(208579);
        Log.i(this.TAG, "onPlaybackParametersChanged");
        AppMethodBeat.o(208579);
    }

    @Override // com.google.android.exoplayer2.q.a
    public final void tz() {
        AppMethodBeat.i(208580);
        Log.i(this.TAG, "onTracksChanged");
        AppMethodBeat.o(208580);
    }

    @Override // com.google.android.exoplayer2.q.a
    public final void a(e eVar) {
        AppMethodBeat.i(208581);
        Log.i(this.TAG, "onPlayerError");
        AppMethodBeat.o(208581);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.exoplayer2.q.a
    public final void c(boolean z, int i2) {
        Long l;
        long j2;
        Long l2 = null;
        long j3 = 0;
        AppMethodBeat.i(208582);
        Log.i(this.TAG, "onPlayerStateChanged playWhenReady:" + z + " playbackState:" + i2);
        switch (i2) {
            case 1:
                AppMethodBeat.o(208582);
                return;
            case 3:
                String str = this.TAG;
                StringBuilder sb = new StringBuilder("duration:");
                v vVar = this.hWJ;
                if (vVar != null) {
                    l = Long.valueOf(vVar.getDuration());
                } else {
                    l = null;
                }
                StringBuilder append = sb.append(l).append("ms curPosition:");
                v vVar2 = this.hWJ;
                if (vVar2 != null) {
                    l2 = Long.valueOf(vVar2.getDuration());
                }
                Log.i(str, append.append(l2).append(LocaleUtil.MALAY).toString());
                RedesignVideoPlayerSeekBar redesignVideoPlayerSeekBar = this.hWM;
                if (redesignVideoPlayerSeekBar != null) {
                    v vVar3 = this.hWJ;
                    if (vVar3 != null) {
                        j2 = vVar3.getDuration();
                    } else {
                        j2 = 0;
                    }
                    redesignVideoPlayerSeekBar.setVideoTotalTime((int) (j2 / 1000));
                }
                RedesignVideoPlayerSeekBar redesignVideoPlayerSeekBar2 = this.hWM;
                if (redesignVideoPlayerSeekBar2 != null) {
                    v vVar4 = this.hWJ;
                    if (vVar4 != null) {
                        j3 = vVar4.getCurrentPosition();
                    }
                    redesignVideoPlayerSeekBar2.xv((int) (j3 / 1000));
                    AppMethodBeat.o(208582);
                    return;
                }
                AppMethodBeat.o(208582);
                return;
            case 4:
                this.hWP = true;
                v vVar5 = this.hWJ;
                if (vVar5 != null) {
                    vVar5.seekTo(0);
                }
                RedesignVideoPlayerSeekBar redesignVideoPlayerSeekBar3 = this.hWM;
                if (redesignVideoPlayerSeekBar3 != null) {
                    redesignVideoPlayerSeekBar3.setIsPlay(false);
                }
                this.hWR.removeCallbacks(this.hWT);
                v vVar6 = this.hWJ;
                if (vVar6 != null) {
                    vVar6.aO(false);
                    AppMethodBeat.o(208582);
                    return;
                }
                break;
        }
        AppMethodBeat.o(208582);
    }

    @Override // com.google.android.exoplayer2.q.a
    public final void aR(boolean z) {
        AppMethodBeat.i(208583);
        Log.i(this.TAG, "onLoadingChanged");
        AppMethodBeat.o(208583);
    }

    @Override // com.google.android.exoplayer2.q.a
    public final void tA() {
        AppMethodBeat.i(208584);
        Log.i(this.TAG, "onPositionDiscontinuity");
        AppMethodBeat.o(208584);
    }

    @Override // com.google.android.exoplayer2.q.a
    public final void aA(int i2) {
        AppMethodBeat.i(208585);
        Log.i(this.TAG, "onRepeatModeChanged");
        AppMethodBeat.o(208585);
    }

    @Override // com.google.android.exoplayer2.q.a
    public final void ty() {
        AppMethodBeat.i(208586);
        Log.i(this.TAG, "onTimelineChanged");
        AppMethodBeat.o(208586);
    }

    public static final /* synthetic */ void f(LiveReplayVideoView liveReplayVideoView) {
        AppMethodBeat.i(208589);
        if (liveReplayVideoView.hWK.getVisibility() == 0) {
            liveReplayVideoView.hWK.setVisibility(8);
        } else {
            liveReplayVideoView.hWK.setVisibility(0);
        }
        if (liveReplayVideoView.hWL.getVisibility() == 0) {
            liveReplayVideoView.hWL.setVisibility(8);
            AppMethodBeat.o(208589);
            return;
        }
        liveReplayVideoView.hWL.setVisibility(0);
        AppMethodBeat.o(208589);
    }
}
