package com.tencent.mm.plugin.story.f;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.particles.b;
import com.tencent.mm.particles.c;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryHeaderTipView;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.plugin.story.api.i;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.ui.album.StoryAlbumUI;
import com.tencent.mm.plugin.story.ui.view.StoryHeaderTipView;
import com.tencent.mm.plugin.story.ui.view.StoryMuteView;
import com.tencent.mm.plugin.story.ui.view.e;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0002J$\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010%\u001a\u0004\u0018\u00010&2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0012H\u0016J\u0010\u0010*\u001a\u00020+2\u0006\u0010 \u001a\u00020!H\u0016J\u0014\u0010,\u001a\u0004\u0018\u00010-2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001c\u0010.\u001a\u00020/2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020\u0012H\u0002J\b\u00103\u001a\u00020\u0016H\u0002J\u0010\u00104\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\u0010\u00105\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\u0010\u00106\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0004¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000fj\b\u0012\u0004\u0012\u00020\f`\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u00067"}, hxF = {"Lcom/tencent/mm/plugin/story/model/StoryUIFactory;", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory;", "()V", "CONFETTI_WIDTH_DP", "", "TAG", "", "VIVO_COMPATIBLE_LIST", "", "confettiManagers", "Ljava/util/HashMap;", "Landroid/view/View;", "Lcom/tencent/mm/particles/ConfettiManager;", "Lkotlin/collections/HashMap;", "mRunningConfetti", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "printLog", "", "unreadConfettiGenerator", "Lcom/tencent/mm/particles/ConfettiGenerator;", "bindUnreadBubbleConfetti", "", "parentView", "Landroid/view/ViewGroup;", "anchor", "offsetX", "offsetY", "genCompatibleBubble", "Landroid/graphics/Bitmap;", "getStoryGallery", "Lcom/tencent/mm/plugin/story/api/AbsStoryGallery;", "context", "Landroid/content/Context;", "type", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "chatRoom", "getStoryHeaderTipView", "Lcom/tencent/mm/plugin/story/api/AbsStoryHeaderTipView;", "getStoryHintDrawable", "Landroid/graphics/drawable/Drawable;", "highLight", "getStoryHintProxy", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy;", "getStoryMuteView", "Lcom/tencent/mm/plugin/story/api/AbsStoryMuteView;", "instantiateAlbumFragment", "Lcom/tencent/mm/ui/MMFragment;", "bundle", "Landroid/os/Bundle;", "isInCompatibleList", "lazyInit", "startUnreadBubbleConfetti", "stopUnreadBubbleConfetti", "unbindUnreadBubbleConfetti", "plugin-story_release"})
public final class r implements n {
    private static b Fnq = null;
    private static HashMap<View, c> Fnr = new HashMap<>();
    private static ArrayList<c> Fns = new ArrayList<>();
    private static int Fnt = 0;
    private static final List<String> Fnu = j.listOf((Object[]) new String[]{"y83a", "v1732a", " y83", "v1732t"});
    public static final r Fnv = new r();
    private static final String TAG = TAG;
    private static boolean printLog = true;

    static {
        AppMethodBeat.i(118788);
        AppMethodBeat.o(118788);
    }

    private r() {
    }

    @Override // com.tencent.mm.plugin.story.api.n
    public final i hj(Context context) {
        AppMethodBeat.i(118778);
        p.h(context, "context");
        com.tencent.mm.plugin.story.proxy.b bVar = new com.tencent.mm.plugin.story.proxy.b(context);
        AppMethodBeat.o(118778);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.story.api.n
    public final AbsStoryGallery a(Context context, n.a aVar, String str) {
        AppMethodBeat.i(118779);
        p.h(context, "context");
        p.h(aVar, "type");
        StoryGalleryView storyGalleryView = new StoryGalleryView(context, aVar, 0, false, null, 28);
        storyGalleryView.setChatRoom(str);
        StoryGalleryView storyGalleryView2 = storyGalleryView;
        AppMethodBeat.o(118779);
        return storyGalleryView2;
    }

    @Override // com.tencent.mm.plugin.story.api.n
    public final AbsStoryMuteView hh(Context context) {
        AppMethodBeat.i(118780);
        StoryMuteView storyMuteView = null;
        if (context != null) {
            storyMuteView = new StoryMuteView(context);
        }
        AppMethodBeat.o(118780);
        return storyMuteView;
    }

    @Override // com.tencent.mm.plugin.story.api.n
    public final AbsStoryHeaderTipView hi(Context context) {
        AppMethodBeat.i(118781);
        StoryHeaderTipView storyHeaderTipView = null;
        if (context != null) {
            storyHeaderTipView = new StoryHeaderTipView(context);
        }
        AppMethodBeat.o(118781);
        return storyHeaderTipView;
    }

    @Override // com.tencent.mm.plugin.story.api.n
    public final MMFragment instantiateAlbumFragment(Context context, Bundle bundle) {
        AppMethodBeat.i(118782);
        Fragment instantiate = Fragment.instantiate(context, StoryAlbumUI.class.getName(), bundle);
        if (instantiate == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragment");
            AppMethodBeat.o(118782);
            throw tVar;
        }
        MMFragment mMFragment = (MMFragment) instantiate;
        AppMethodBeat.o(118782);
        return mMFragment;
    }

    @Override // com.tencent.mm.plugin.story.api.n
    public final Drawable vJ(boolean z) {
        int i2;
        AppMethodBeat.i(118783);
        if (z) {
            i2 = R.raw.chatting_avatar_story_hint;
        } else {
            i2 = R.raw.chatting_avatar_story_hint_white;
        }
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        Drawable drawable = context.getResources().getDrawable(i2);
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8);
        drawable.setBounds(0, 0, fromDPToPix, fromDPToPix);
        p.g(drawable, "hintDrawable");
        AppMethodBeat.o(118783);
        return drawable;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067 A[SYNTHETIC] */
    @Override // com.tencent.mm.plugin.story.api.n
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(android.view.ViewGroup r12, android.view.View r13, int r14) {
        /*
        // Method dump skipped, instructions count: 394
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.f.r.b(android.view.ViewGroup, android.view.View, int):void");
    }

    @Override // com.tencent.mm.plugin.story.api.n
    public final void fP(View view) {
        AppMethodBeat.i(118785);
        p.h(view, "anchor");
        if (Fnr.containsKey(view)) {
            Fnr.remove(view);
        }
        AppMethodBeat.o(118785);
    }

    @Override // com.tencent.mm.plugin.story.api.n
    public final void fQ(View view) {
        AppMethodBeat.i(118786);
        p.h(view, "anchor");
        Log.d(TAG, "startUnreadBubbleConfetti mRunningConfetti=" + Fns);
        c cVar = Fnr.get(view);
        if (cVar != null) {
            if (!Fns.contains(cVar)) {
                Log.d(TAG, "startUnreadBubbleConfetti");
                cVar.bkJ();
                Fns.add(cVar);
            }
            AppMethodBeat.o(118786);
            return;
        }
        AppMethodBeat.o(118786);
    }

    @Override // com.tencent.mm.plugin.story.api.n
    public final void fR(View view) {
        AppMethodBeat.i(118787);
        p.h(view, "anchor");
        Log.d(TAG, "stopUnreadBubbleConfetti mRunningConfetti=" + Fns);
        c cVar = Fnr.get(view);
        if (cVar != null) {
            if (Fns.contains(cVar)) {
                Log.printDebugStack(TAG, "stopUnreadBubbleConfetti", new Object[0]);
                cVar.bkK();
                Fns.remove(cVar);
            }
            AppMethodBeat.o(118787);
            return;
        }
        AppMethodBeat.o(118787);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/story/ui/view/CommentTipSmallConfetti;", LocaleUtil.ITALIAN, "Ljava/util/Random;", "kotlin.jvm.PlatformType", "generateConfetti"})
    static final class a implements b {
        final /* synthetic */ z.f Fnw;

        a(z.f fVar) {
            this.Fnw = fVar;
        }

        @Override // com.tencent.mm.particles.b
        public final /* synthetic */ com.tencent.mm.particles.a.b a(Random random) {
            AppMethodBeat.i(118777);
            T t = this.Fnw.SYG;
            p.g(t, "scaled");
            e eVar = new e(t);
            AppMethodBeat.o(118777);
            return eVar;
        }
    }
}
