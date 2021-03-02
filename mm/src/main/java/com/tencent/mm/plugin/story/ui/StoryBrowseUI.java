package com.tencent.mm.plugin.story.ui;

import android.os.Bundle;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.story.api.g;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.api.p;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import kotlin.g.b.z;
import kotlin.l;

@com.tencent.mm.ui.base.a(3)
@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0014J\b\u0010\u000f\u001a\u00020\tH\u0014J\b\u0010\u0010\u001a\u00020\fH\u0016J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\fH\u0014J\b\u0010\u0015\u001a\u00020\fH\u0014J\b\u0010\u0016\u001a\u00020\fH\u0014J\b\u0010\u0017\u001a\u00020\fH\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/StoryBrowseUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/api/IStoryBrowseUIListener;", "()V", "galleryBg", "Landroid/widget/ImageView;", "galleryView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "hPosition", "", "vPosition", "finishWithResult", "", "result", "getForceOrientation", "getLayoutId", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "storyUIBackPressed", "storyUIHasStory", "storyUINoStory", "Companion", "plugin-story_release"})
public final class StoryBrowseUI extends MMActivity implements g {
    public static final a FwN = new a((byte) 0);
    private static final String TAG = TAG;
    private int FwK;
    private int FwL;
    private StoryGalleryView FwM;
    private ImageView jUG;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public static final /* synthetic */ void c(StoryBrowseUI storyBrowseUI) {
        AppMethodBeat.i(119626);
        storyBrowseUI.frS();
        AppMethodBeat.o(119626);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/StoryBrowseUI$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(119625);
        AppMethodBeat.o(119625);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        n.a aVar;
        AppMethodBeat.i(119617);
        Log.i(TAG, "StoryBrowseUI create ".concat(String.valueOf(this)));
        supportRequestWindowFeature(1);
        customfixStatusbar(true);
        super.onCreate(bundle);
        com.tencent.mm.plugin.story.h.c cVar = com.tencent.mm.plugin.story.h.c.Fuf;
        com.tencent.mm.plugin.story.h.c.fpO();
        com.tencent.mm.plugin.story.h.b bVar = com.tencent.mm.plugin.story.h.b.FtL;
        com.tencent.mm.plugin.story.h.b.fpO();
        setSelfNavigationBarVisible(8);
        getWindow().addFlags(2097280);
        getWindow().setFlags(201327616, 201327616);
        d.rb(true);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setBackgroundColor(0);
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        this.jUG = imageView;
        this.FwL = getIntent().getIntExtra("h_position", 0);
        this.FwK = getIntent().getIntExtra("v_position", 0);
        T t = (T) getIntent().getStringExtra(ch.COL_USERNAME);
        z.f fVar = new z.f();
        fVar.SYG = (T) getIntent().getStringArrayListExtra("user_list");
        T t2 = (T) getIntent().getStringArrayListExtra("user_date_list");
        boolean booleanExtra = getIntent().getBooleanExtra("delete_when_first_empty", false);
        String stringExtra = getIntent().getStringExtra("gallery_chat_room");
        long longExtra = getIntent().getLongExtra("data_seed_key", 0);
        h hVar = h.FuH;
        String sessionId = h.fqi().getSessionId();
        boolean booleanExtra2 = getIntent().getBooleanExtra("gallery_story_need_action", false);
        Log.i(TAG, "vPosition " + this.FwK);
        h hVar2 = h.FuH;
        h.fql();
        h hVar3 = h.FuH;
        h.fqi().sk((long) NetStatusUtil.getIOSNetType(getContext()));
        h hVar4 = h.FuH;
        h.fqi().sp(0);
        h hVar5 = h.FuH;
        h.fqi().sr(0);
        z.f fVar2 = new z.f();
        fVar2.SYG = (T) p.a.fns().Kg(longExtra);
        if (fVar2.SYG == null || !(fVar2.SYG instanceof p)) {
            if (!Util.isNullOrNil((String) t)) {
                j.b bVar2 = j.Fmy;
                if (Util.isEqual((String) t, j.b.fau())) {
                    if (t2 == null || t2.isEmpty()) {
                        this.FwM = new StoryGalleryView(this, n.a.SelfGallery, 0, false, null, 28);
                        fVar2.SYG = t;
                    } else {
                        this.FwM = new StoryGalleryView(this, n.a.HistoryGallery, 0, false, null, 28);
                        fVar2.SYG = t2;
                    }
                }
            }
            if (!Util.isNullOrNil((String) t)) {
                j.b bVar3 = j.Fmy;
                if (!Util.isEqual((String) t, j.b.fau())) {
                    this.FwM = new StoryGalleryView(this, n.a.SingleGallery, 0, false, null, 28);
                    fVar2.SYG = t;
                }
            }
            if (fVar.SYG != null) {
                this.FwM = new StoryGalleryView(this, n.a.MultiUserGallery, 0, false, null, 28);
                fVar2.SYG = (T) new ArrayList(fVar.SYG);
            }
        } else {
            T t3 = fVar2.SYG;
            kotlin.g.b.p.h(t3, "dataSeed");
            if ((t3 instanceof com.tencent.mm.plugin.story.f.d.b) || (t3 instanceof com.tencent.mm.plugin.story.f.d.a) || !(t3 instanceof com.tencent.mm.plugin.story.f.d.c)) {
                aVar = n.a.MultiUserGallery;
            } else if (t3.Dff) {
                aVar = n.a.FavSelfStoryGalleryMulti;
            } else {
                j.b bVar4 = j.Fmy;
                if (Util.isEqual(j.b.fau(), t3.username)) {
                    aVar = n.a.FavSelfStoryGallery;
                } else {
                    aVar = n.a.FavOtherStoryGallery;
                }
            }
            if (fVar2.SYG instanceof com.tencent.mm.plugin.story.f.d.c) {
                this.FwM = new StoryGalleryView(this, aVar, this.FwK, booleanExtra2, fVar2.SYG.FoK);
            } else {
                this.FwM = new StoryGalleryView(this, aVar, this.FwK, booleanExtra2, null, 16);
            }
        }
        StoryGalleryView storyGalleryView = this.FwM;
        if (storyGalleryView != null) {
            storyGalleryView.fmS();
        }
        StoryGalleryView storyGalleryView2 = this.FwM;
        if (storyGalleryView2 != null) {
            storyGalleryView2.setDeleteWhenFirstEmpty(booleanExtra);
        }
        StoryGalleryView storyGalleryView3 = this.FwM;
        if (storyGalleryView3 != null) {
            storyGalleryView3.setChatRoom(stringExtra);
        }
        StoryGalleryView storyGalleryView4 = this.FwM;
        if (storyGalleryView4 != null) {
            storyGalleryView4.setSessionId(sessionId);
        }
        StoryGalleryView storyGalleryView5 = this.FwM;
        if (storyGalleryView5 != null) {
            storyGalleryView5.setDataSeed(fVar2.SYG);
        }
        StoryGalleryView storyGalleryView6 = this.FwM;
        if (storyGalleryView6 != null) {
            storyGalleryView6.setStoryBrowseUIListener(this);
        }
        StoryGalleryView storyGalleryView7 = this.FwM;
        if (storyGalleryView7 != null) {
            storyGalleryView7.setCurrentVItem(this.FwK);
        }
        StoryGalleryView storyGalleryView8 = this.FwM;
        if (storyGalleryView8 != null) {
            storyGalleryView8.setCanDragScale(true);
        }
        StoryGalleryView storyGalleryView9 = this.FwM;
        if (storyGalleryView9 != null) {
            storyGalleryView9.setGalleryScaleListener(new b(this));
        }
        relativeLayout.addView(this.jUG, new RelativeLayout.LayoutParams(-1, -1));
        StoryGalleryView storyGalleryView10 = this.FwM;
        if (storyGalleryView10 != null) {
            relativeLayout.addView(storyGalleryView10, new RelativeLayout.LayoutParams(-1, -1));
        }
        setContentView(relativeLayout);
        StoryGalleryView storyGalleryView11 = this.FwM;
        if (storyGalleryView11 != null) {
            storyGalleryView11.post(new c(this, fVar, t, fVar2));
            AppMethodBeat.o(119617);
            return;
        }
        AppMethodBeat.o(119617);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/story/ui/StoryBrowseUI$onCreate$2", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-story_release"})
    public static final class b implements StoryGalleryView.b {
        final /* synthetic */ StoryBrowseUI FwO;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(StoryBrowseUI storyBrowseUI) {
            this.FwO = storyBrowseUI;
        }

        @Override // com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.b
        public final void ca(float f2) {
            AppMethodBeat.i(119614);
            ImageView imageView = this.FwO.jUG;
            if (imageView != null) {
                imageView.setAlpha(f2);
                AppMethodBeat.o(119614);
                return;
            }
            AppMethodBeat.o(119614);
        }

        @Override // com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.b
        public final void aJl() {
            ViewPropertyAnimator animate;
            ViewPropertyAnimator alpha;
            ViewPropertyAnimator duration;
            long j2 = 0;
            AppMethodBeat.i(119615);
            StoryGalleryView storyGalleryView = this.FwO.FwM;
            if (storyGalleryView != null) {
                storyGalleryView.setEnabled(false);
                long height = (long) (((((float) storyGalleryView.getHeight()) - storyGalleryView.getTranslationY()) / ((float) storyGalleryView.getHeight())) * 300.0f);
                if (height >= 0) {
                    j2 = height;
                }
                ImageView imageView = this.FwO.jUG;
                if (!(imageView == null || (animate = imageView.animate()) == null || (alpha = animate.alpha(0.0f)) == null || (duration = alpha.setDuration(j2)) == null)) {
                    duration.start();
                }
                storyGalleryView.animate().translationY((float) storyGalleryView.getHeight()).setDuration(j2).withEndAction(new a(this)).start();
                AppMethodBeat.o(119615);
                return;
            }
            AppMethodBeat.o(119615);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/StoryBrowseUI$onCreate$2$onGalleryExitFromTop$1$1"})
        static final class a implements Runnable {
            final /* synthetic */ b FwP;

            a(b bVar) {
                this.FwP = bVar;
            }

            public final void run() {
                AppMethodBeat.i(119613);
                new MMHandler().post(new Runnable(this) {
                    /* class com.tencent.mm.plugin.story.ui.StoryBrowseUI.b.a.AnonymousClass1 */
                    final /* synthetic */ a FwQ;

                    {
                        this.FwQ = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(119612);
                        StoryBrowseUI.c(this.FwQ.FwP.FwO);
                        this.FwQ.FwP.FwO.overridePendingTransition(0, 0);
                        AppMethodBeat.o(119612);
                    }
                });
                AppMethodBeat.o(119613);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ StoryBrowseUI FwO;
        final /* synthetic */ z.f FwR;
        final /* synthetic */ z.f FwS;
        final /* synthetic */ String hLl;

        c(StoryBrowseUI storyBrowseUI, z.f fVar, String str, z.f fVar2) {
            this.FwO = storyBrowseUI;
            this.FwR = fVar;
            this.hLl = str;
            this.FwS = fVar2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x00c7, code lost:
            if (com.tencent.mm.plugin.story.h.h.fqi().ahw() == 13) goto L_0x00c9;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 249
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.ui.StoryBrowseUI.c.run():void");
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(119618);
        Log.i(TAG, "onResume ".concat(String.valueOf(this)));
        super.onResume();
        StoryGalleryView storyGalleryView = this.FwM;
        if (storyGalleryView != null) {
            storyGalleryView.onResume();
        }
        StoryGalleryView storyGalleryView2 = this.FwM;
        if (storyGalleryView2 != null) {
            storyGalleryView2.fmO();
        }
        f.cjj();
        AppMethodBeat.o(119618);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(119619);
        Log.i(TAG, "onPause ".concat(String.valueOf(this)));
        super.onPause();
        StoryGalleryView storyGalleryView = this.FwM;
        if (storyGalleryView != null) {
            storyGalleryView.onPause();
        }
        f.cji();
        AppMethodBeat.o(119619);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(119620);
        Log.i(TAG, "onDestroy ".concat(String.valueOf(this)));
        super.onDestroy();
        StoryGalleryView storyGalleryView = this.FwM;
        if (storyGalleryView != null) {
            storyGalleryView.onDestroy();
        }
        com.tencent.mm.plugin.story.h.c cVar = com.tencent.mm.plugin.story.h.c.Fuf;
        com.tencent.mm.plugin.story.h.c.onDestroy();
        AppMethodBeat.o(119620);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(119621);
        StoryGalleryView storyGalleryView = this.FwM;
        if (storyGalleryView == null || !storyGalleryView.onBackPressed()) {
            frS();
        }
        AppMethodBeat.o(119621);
    }

    @Override // com.tencent.mm.plugin.story.api.g
    public final void eEb() {
        AppMethodBeat.i(119622);
        frS();
        AppMethodBeat.o(119622);
    }

    @Override // com.tencent.mm.plugin.story.api.g
    public final void eEc() {
    }

    @Override // com.tencent.mm.plugin.story.api.g
    public final void eEd() {
        AppMethodBeat.i(119623);
        frS();
        AppMethodBeat.o(119623);
    }

    private final void frS() {
        AppMethodBeat.i(119624);
        h hVar = h.FuH;
        h.fqi().sk((long) NetStatusUtil.getIOSNetType(getContext()));
        h hVar2 = h.FuH;
        h.fqi().so(System.currentTimeMillis());
        h hVar3 = h.FuH;
        h.fqj();
        com.tencent.mm.plugin.story.h.c cVar = com.tencent.mm.plugin.story.h.c.Fuf;
        com.tencent.mm.plugin.story.h.c.onDestroy();
        setResult(-1);
        finish();
        AppMethodBeat.o(119624);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getForceOrientation() {
        return 1;
    }
}
