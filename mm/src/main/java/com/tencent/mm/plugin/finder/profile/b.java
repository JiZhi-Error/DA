package com.tencent.mm.plugin.finder.profile;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.model.bl;
import com.tencent.mm.protocal.protobuf.bds;
import java.util.ArrayList;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020\u0019R\u000e\u0010\u000b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR!\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0005j\b\u0012\u0004\u0012\u00020\u000f`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R=\u0010\u0013\u001a%\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterContract;", "", "context", "Landroid/app/Activity;", "outerDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "Lkotlin/collections/ArrayList;", ch.COL_USERNAME, "", "(Landroid/app/Activity;Ljava/util/ArrayList;Ljava/lang/String;)V", "TAG", "getContext", "()Landroid/app/Activity;", "dataList", "Lcom/tencent/mm/plugin/finder/model/FinderTopicInfoFeed;", "getDataList", "()Ljava/util/ArrayList;", "getOuterDataList", "selectListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "selected", "", "getSelectListener", "()Lkotlin/jvm/functions/Function2;", "setSelectListener", "(Lkotlin/jvm/functions/Function2;)V", "getUsername", "()Ljava/lang/String;", "view", "Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterView;", "getView", "()Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterView;", "setView", "(Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterView;)V", "genView", "Landroid/view/View;", "refresh", "plugin-finder_release"})
public final class b {
    public final String TAG = "Finder.FinderTopicFilterContract";
    public final Activity dKq;
    public final ArrayList<bl> kgc = new ArrayList<>();
    public FinderTopicFilterView uZn;
    public m<? super bds, ? super Boolean, x> uZo;
    public final ArrayList<bds> uZp;
    public final String username;

    public b(Activity activity, ArrayList<bds> arrayList, String str) {
        p.h(activity, "context");
        p.h(arrayList, "outerDataList");
        p.h(str, ch.COL_USERNAME);
        AppMethodBeat.i(249992);
        this.dKq = activity;
        this.uZp = arrayList;
        this.username = str;
        AppMethodBeat.o(249992);
    }
}
