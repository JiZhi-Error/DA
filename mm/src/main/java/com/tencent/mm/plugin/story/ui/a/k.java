package com.tencent.mm.plugin.story.ui.a;

import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.b.a;
import com.tencent.mm.plugin.story.i.j;
import com.tencent.mm.plugin.story.ui.view.StoryMsgListView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0005j\b\u0012\u0004\u0012\u00020\n`\u0007¢\u0006\u0002\u0010\u000bJ \u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020,2\u0006\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020,H\u0016J\u0010\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020<H\u0016J\u0018\u0010@\u001a\u00020<2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020,H\u0016J\u0018\u0010A\u001a\u00020\u00032\u0006\u0010;\u001a\u00020B2\u0006\u0010?\u001a\u00020<H\u0016R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R7\u0010\"\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001d\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R7\u0010+\u001a\u001f\u0012\u0013\u0012\u00110,¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u001d\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010(\"\u0004\b/\u0010*R\"\u00100\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001f\"\u0004\b2\u0010!R*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0005j\b\u0012\u0004\u0012\u00020\n`\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u000f\"\u0004\b4\u0010\u0011R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u000f\"\u0004\b6\u0010\u0011¨\u0006C"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/adapter/StoryMsgListAdapter;", "Landroid/support/v4/view/PagerAdapter;", "isSelf", "", "visitors", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "comments", "pages", "Lcom/tencent/mm/plugin/story/ui/view/StoryMsgListView;", "(ZLjava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "TAG", "", "getComments", "()Ljava/util/ArrayList;", "setComments", "(Ljava/util/ArrayList;)V", "hostStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getHostStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setHostStory", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "()Z", "setSelf", "(Z)V", "onBlankClick", "Lkotlin/Function0;", "", "getOnBlankClick", "()Lkotlin/jvm/functions/Function0;", "setOnBlankClick", "(Lkotlin/jvm/functions/Function0;)V", "onCommentItemClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "commentItem", "getOnCommentItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnCommentItemClick", "(Lkotlin/jvm/functions/Function1;)V", "onContentTopOverScroll", "", "dy", "getOnContentTopOverScroll", "setOnContentTopOverScroll", "onContentTopOverScrollStop", "getOnContentTopOverScrollStop", "setOnContentTopOverScrollStop", "getPages", "setPages", "getVisitors", "setVisitors", "destroyItem", "container", "Landroid/view/ViewGroup;", "position", "view", "", "getCount", "getItemPosition", "obj", "instantiateItem", "isViewFromObject", "Landroid/view/View;", "plugin-story_release"})
public final class k extends q {
    public ArrayList<a> FwY;
    public j FxM;
    public b<? super a, x> Fyo;
    public kotlin.g.a.a<x> Fyp;
    public b<? super Integer, x> Fyq;
    public kotlin.g.a.a<x> Fyr;
    public ArrayList<a> Fys;
    public ArrayList<StoryMsgListView> Fyt;
    private final String TAG;
    public boolean dJM;

    public /* synthetic */ k(boolean z) {
        this(z, new ArrayList(), new ArrayList(), new ArrayList());
        AppMethodBeat.i(119787);
        AppMethodBeat.o(119787);
    }

    private k(boolean z, ArrayList<a> arrayList, ArrayList<a> arrayList2, ArrayList<StoryMsgListView> arrayList3) {
        p.h(arrayList, "visitors");
        p.h(arrayList2, "comments");
        p.h(arrayList3, "pages");
        AppMethodBeat.i(119786);
        this.dJM = z;
        this.Fys = arrayList;
        this.FwY = arrayList2;
        this.Fyt = arrayList3;
        this.TAG = "MicroMsg.StoryMsgListAdapter";
        AppMethodBeat.o(119786);
    }

    @Override // android.support.v4.view.q
    public final boolean isViewFromObject(View view, Object obj) {
        AppMethodBeat.i(119781);
        p.h(view, "view");
        p.h(obj, "obj");
        boolean j2 = p.j(view, obj);
        AppMethodBeat.o(119781);
        return j2;
    }

    @Override // android.support.v4.view.q
    public final int getCount() {
        AppMethodBeat.i(119782);
        int size = this.Fyt.size();
        AppMethodBeat.o(119782);
        return size;
    }

    @Override // android.support.v4.view.q
    public final Object instantiateItem(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(119783);
        p.h(viewGroup, "container");
        Log.d(this.TAG, "instantiateItem isSelf:" + this.dJM);
        if (this.dJM) {
            if (i2 == 0) {
                StoryMsgListView.a aVar = StoryMsgListView.FDv;
                this.Fyt.get(i2).a(StoryMsgListView.fsg(), this.FwY, this.Fys, this.FxM);
                this.Fyt.get(i2).setOnBlankClick(this.Fyp);
                this.Fyt.get(i2).setOnContentTopOverScroll(this.Fyq);
                this.Fyt.get(i2).setOnContentTopOverScrollStop(this.Fyr);
            } else {
                this.Fyt.get(i2).setOnCommentItemClick(this.Fyo);
                this.Fyt.get(i2).setOnBlankClick(this.Fyp);
                this.Fyt.get(i2).setOnContentTopOverScroll(this.Fyq);
                this.Fyt.get(i2).setOnContentTopOverScrollStop(this.Fyr);
                StoryMsgListView.a aVar2 = StoryMsgListView.FDv;
                this.Fyt.get(i2).a(StoryMsgListView.fsh(), this.FwY, this.Fys, this.FxM);
            }
            this.Fyt.get(i2).abe(au.aD(viewGroup.getContext()) + at.fromDPToPix(viewGroup.getContext(), 48) + at.fromDPToPix(viewGroup.getContext(), 24));
        } else {
            this.Fyt.get(i2).setOnCommentItemClick(this.Fyo);
            this.Fyt.get(i2).setOnBlankClick(this.Fyp);
            this.Fyt.get(i2).setOnContentTopOverScroll(this.Fyq);
            this.Fyt.get(i2).setOnContentTopOverScrollStop(this.Fyr);
            StoryMsgListView.a aVar3 = StoryMsgListView.FDv;
            this.Fyt.get(i2).a(StoryMsgListView.fsh(), this.FwY, this.Fys, this.FxM);
            this.Fyt.get(i2).abe(au.aD(viewGroup.getContext()) + at.fromDPToPix(viewGroup.getContext(), 24));
        }
        viewGroup.addView(this.Fyt.get(i2));
        StoryMsgListView storyMsgListView = this.Fyt.get(i2);
        p.g(storyMsgListView, "pages[position]");
        AppMethodBeat.o(119783);
        return storyMsgListView;
    }

    @Override // android.support.v4.view.q
    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        AppMethodBeat.i(119784);
        p.h(viewGroup, "container");
        p.h(obj, "view");
        Log.d(this.TAG, "destroyItem ".concat(String.valueOf(i2)));
        viewGroup.removeView((View) obj);
        AppMethodBeat.o(119784);
    }

    @Override // android.support.v4.view.q
    public final int getItemPosition(Object obj) {
        AppMethodBeat.i(119785);
        p.h(obj, "obj");
        AppMethodBeat.o(119785);
        return -2;
    }
}
