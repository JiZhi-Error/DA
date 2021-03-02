package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import java.util.List;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\n\u0010\t\u001a\u0004\u0018\u00010\bH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\fH&J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H&¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FoldedScrollPresenter;", "", "getItemLayoutType", "", "getLayoutParam", "Landroid/support/constraint/ConstraintLayout$LayoutParams;", "getList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getParentFeed", "getSpaceWidth", "hasMore", "", "isShowLikeInfo", "onItemClick", "", "context", "Landroid/content/Context;", "pos", "plugin-finder_release"})
public interface p {
    List<BaseFinderFeed> GW();

    void ag(Context context, int i2);

    int cZG();

    BaseFinderFeed dGI();

    boolean dGJ();
}
