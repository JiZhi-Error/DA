package com.tencent.mm.plugin.finder.music;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0014J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\u0006\u0010\u001f\u001a\u00020\u001bJ\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"H\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/music/FinderMusicTopicHeaderView;", "Landroid/support/constraint/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "setMusicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "pauseMusicListener", "Landroid/view/View$OnClickListener;", "playMusicListener", "player", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer;", "getPlayer", "()Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer;", "setPlayer", "(Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer;)V", "bindMusicInfo", "", "initView", "onDetachedFromWindow", "onViewPause", "onViewResume", "onWindowFocusChanged", "hasWindowFocus", "", "plugin-finder_release"})
public final class FinderMusicTopicHeaderView extends ConstraintLayout {
    private HashMap _$_findViewCache;
    private azk musicInfo;
    private a uPD;
    private View.OnClickListener uPn = new b(this);
    private View.OnClickListener uPo = new a(this);

    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(248964);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(248964);
        return view;
    }

    public final azk getMusicInfo() {
        return this.musicInfo;
    }

    public final void setMusicInfo(azk azk) {
        this.musicInfo = azk;
    }

    public final a getPlayer() {
        return this.uPD;
    }

    public final void setPlayer(a aVar) {
        this.uPD = aVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ FinderMusicTopicHeaderView uPT;

        b(FinderMusicTopicHeaderView finderMusicTopicHeaderView) {
            this.uPT = finderMusicTopicHeaderView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(248958);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/music/FinderMusicTopicHeaderView$playMusicListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.uPT.getMusicInfo() != null) {
                a player = this.uPT.getPlayer();
                if (player != null) {
                    player.play();
                }
                ((WeImageView) this.uPT._$_findCachedViewById(R.id.d0l)).setImageResource(R.raw.icons_filled_pause);
                ((FrameLayout) this.uPT._$_findCachedViewById(R.id.d0k)).setOnClickListener(this.uPT.uPo);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderMusicTopicHeaderView$playMusicListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248958);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ FinderMusicTopicHeaderView uPT;

        a(FinderMusicTopicHeaderView finderMusicTopicHeaderView) {
            this.uPT = finderMusicTopicHeaderView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(248957);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/music/FinderMusicTopicHeaderView$pauseMusicListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.uPT.getMusicInfo() != null) {
                a player = this.uPT.getPlayer();
                if (player != null) {
                    player.pause();
                }
                ((WeImageView) this.uPT._$_findCachedViewById(R.id.d0l)).setImageResource(R.raw.icons_filled_play);
                ((FrameLayout) this.uPT._$_findCachedViewById(R.id.d0k)).setOnClickListener(this.uPT.uPn);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderMusicTopicHeaderView$pauseMusicListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248957);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderMusicTopicHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(248962);
        bh(context);
        AppMethodBeat.o(248962);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderMusicTopicHeaderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(248963);
        bh(context);
        AppMethodBeat.o(248963);
    }

    private final void bh(Context context) {
        AppMethodBeat.i(248959);
        aa.jQ(context).inflate(R.layout.ahq, (ViewGroup) this, true);
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.c5);
        int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.cb);
        setPadding(dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset);
        AppMethodBeat.o(248959);
    }

    public final void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(248960);
        super.onWindowFocusChanged(z);
        if (!z) {
            a aVar = this.uPD;
            if (aVar == null) {
                AppMethodBeat.o(248960);
                return;
            } else if (aVar.isPlaying()) {
                ((FrameLayout) _$_findCachedViewById(R.id.d0k)).setOnClickListener(this.uPo);
                ((FrameLayout) _$_findCachedViewById(R.id.d0k)).performClick();
            }
        }
        AppMethodBeat.o(248960);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(248961);
        super.onDetachedFromWindow();
        a aVar = this.uPD;
        if (aVar != null) {
            aVar.release();
            AppMethodBeat.o(248961);
            return;
        }
        AppMethodBeat.o(248961);
    }
}
