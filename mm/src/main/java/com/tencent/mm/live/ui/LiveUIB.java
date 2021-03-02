package com.tencent.mm.live.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.google.android.exoplayer2.source.b.h;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.d.d;
import com.tencent.mm.live.d.e;
import com.tencent.mm.live.view.LiveReplayVideoView;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tavkit.component.TAVExporter;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u0006H\u0014J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0014J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\fH\u0014J\b\u0010\u0014\u001a\u00020\fH\u0014J\b\u0010\u0015\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/live/ui/LiveUIB;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "fromSence", "", "liveReplayVideoView", "Lcom/tencent/mm/live/view/LiveReplayVideoView;", "mReplayStatusBegin", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "setWindowStyle", "plugin-logic_release"})
public final class LiveUIB extends MMActivity {
    private final String TAG = "MicroMsg.LiveUIB";
    private LiveReplayVideoView hTU;
    private int hTV;
    private int hTW;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "invoke"})
    static final class a extends q implements kotlin.g.a.b<View, x> {
        final /* synthetic */ LiveUIB hTX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(LiveUIB liveUIB) {
            super(1);
            this.hTX = liveUIB;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(View view) {
            AppMethodBeat.i(208377);
            p.h(view, LocaleUtil.ITALIAN);
            this.hTX.finish();
            x xVar = x.SXb;
            AppMethodBeat.o(208377);
            return xVar;
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.i(208379);
        Log.i(this.TAG, "onCreate (" + hashCode() + ')');
        setTheme(R.style.a2);
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        setSelfNavigationBarVisible(8);
        getWindow().addFlags(2097280);
        getWindow().addFlags(67108864);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(67108864);
            Window window = getWindow();
            p.g(window, "window");
            View decorView = window.getDecorView();
            p.g(decorView, "window.decorView");
            decorView.setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
            getWindow().addFlags(Integer.MIN_VALUE);
            Window window2 = getWindow();
            p.g(window2, "window");
            window2.setStatusBarColor(0);
        }
        getWindow().setFormat(-3);
        getWindow().setSoftInputMode(3);
        this.hTW = getIntent().getIntExtra("FROM_SENCE", 2);
        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
        this.hTV = com.tencent.mm.live.b.x.aGr().MnK ? 1 : 0;
        this.hTU = (LiveReplayVideoView) findViewById(R.id.eky);
        LiveReplayVideoView liveReplayVideoView = this.hTU;
        if (liveReplayVideoView != null) {
            liveReplayVideoView.setOnCloseClickListener(new a(this));
        }
        LiveReplayVideoView liveReplayVideoView2 = this.hTU;
        if (liveReplayVideoView2 != null) {
            com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
            String str = com.tencent.mm.live.b.x.aGr().MnI;
            RedesignVideoPlayerSeekBar redesignVideoPlayerSeekBar = liveReplayVideoView2.hWM;
            if (redesignVideoPlayerSeekBar != null) {
                redesignVideoPlayerSeekBar.setIsPlay(true);
            }
            v vVar = liveReplayVideoView2.hWJ;
            if (vVar != null) {
                vVar.seekTo(0);
            }
            v vVar2 = liveReplayVideoView2.hWJ;
            if (vVar2 != null) {
                vVar2.aO(false);
            }
            liveReplayVideoView2.hWP = false;
            TextView textView = liveReplayVideoView2.titleTv;
            Context context = liveReplayVideoView2.getContext();
            com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
            textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(context, com.tencent.mm.live.b.x.aGr().LpF));
            liveReplayVideoView2.setVisibility(0);
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                z = true;
            }
            if (!z) {
                h hVar = new h(Uri.parse(str), liveReplayVideoView2.bwl, liveReplayVideoView2.eventHandler, new LiveReplayVideoView.a());
                v vVar3 = liveReplayVideoView2.hWJ;
                if (vVar3 != null) {
                    vVar3.a(hVar);
                }
                v vVar4 = liveReplayVideoView2.hWJ;
                if (vVar4 != null) {
                    vVar4.aO(true);
                }
                liveReplayVideoView2.aJp();
            }
        }
        LiveReplayVideoView liveReplayVideoView3 = this.hTU;
        if (liveReplayVideoView3 != null) {
            liveReplayVideoView3.setVideoSeekBarDragCallback(new b(this));
            AppMethodBeat.o(208379);
            return;
        }
        AppMethodBeat.o(208379);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.b1f;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(208380);
        Log.i(this.TAG, "onResume (" + hashCode() + ')');
        super.onResume();
        AppMethodBeat.o(208380);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(208381);
        Log.i(this.TAG, "onPause (" + hashCode() + ')');
        super.onPause();
        AppMethodBeat.o(208381);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        long j2 = 0;
        AppMethodBeat.i(208382);
        Log.i(this.TAG, "onDestroy (" + hashCode() + ')');
        LiveReplayVideoView liveReplayVideoView = this.hTU;
        if (liveReplayVideoView != null) {
            com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
            String aGm = com.tencent.mm.live.b.x.aGm();
            com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
            long j3 = com.tencent.mm.live.b.x.aGr().hyH;
            com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
            String str = com.tencent.mm.live.b.x.aGr().LpF;
            com.tencent.mm.live.b.x xVar4 = com.tencent.mm.live.b.x.hJf;
            String aGt = com.tencent.mm.live.b.x.aGt();
            v vVar = liveReplayVideoView.hWJ;
            long duration = vVar != null ? vVar.getDuration() : 0;
            v vVar2 = liveReplayVideoView.hWJ;
            if (vVar2 != null) {
                j2 = vVar2.getCurrentPosition();
            }
            e.a(aGm, j3, str, aGt, duration, j2);
        }
        super.onDestroy();
        com.tencent.mm.live.b.x xVar5 = com.tencent.mm.live.b.x.hJf;
        String aGm2 = com.tencent.mm.live.b.x.aGm();
        com.tencent.mm.live.b.x xVar6 = com.tencent.mm.live.b.x.hJf;
        long j4 = com.tencent.mm.live.b.x.aGr().hyH;
        com.tencent.mm.live.b.x xVar7 = com.tencent.mm.live.b.x.hJf;
        String str2 = com.tencent.mm.live.b.x.aGr().LpF;
        com.tencent.mm.live.b.x xVar8 = com.tencent.mm.live.b.x.hJf;
        String aGt2 = com.tencent.mm.live.b.x.aGt();
        int i2 = this.hTW;
        com.tencent.mm.live.b.x xVar9 = com.tencent.mm.live.b.x.hJf;
        e.a(aGm2, j4, str2, aGt2, i2, com.tencent.mm.live.b.x.aGr().MnK ? 1 : 0, this.hTV);
        LiveReplayVideoView liveReplayVideoView2 = this.hTU;
        if (liveReplayVideoView2 != null) {
            liveReplayVideoView2.hWR.removeCallbacks(liveReplayVideoView2.hWT);
            v vVar3 = liveReplayVideoView2.hWJ;
            if (vVar3 != null) {
                vVar3.release();
            }
            v vVar4 = liveReplayVideoView2.hWJ;
            if (vVar4 != null) {
                vVar4.b(liveReplayVideoView2);
            }
            liveReplayVideoView2.hWJ = null;
            AppMethodBeat.o(208382);
            return;
        }
        AppMethodBeat.o(208382);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public final void onNewIntent(Intent intent) {
        AppMethodBeat.i(208383);
        Log.i(this.TAG, "onNewIntent (" + hashCode() + ')');
        super.onNewIntent(intent);
        AppMethodBeat.o(208383);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0001\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a {
        final /* synthetic */ LiveUIB hTX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(LiveUIB liveUIB) {
            super(0);
            this.hTX = liveUIB;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(208378);
            com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
            if (p.j(com.tencent.mm.live.b.x.aGt(), z.aTY())) {
                d.aIA();
            } else {
                d.aIJ();
            }
            LiveReplayVideoView liveReplayVideoView = this.hTX.hTU;
            if (liveReplayVideoView != null) {
                liveReplayVideoView.setVideoSeekBarDragCallback(null);
            }
            AppMethodBeat.o(208378);
            return null;
        }
    }
}
