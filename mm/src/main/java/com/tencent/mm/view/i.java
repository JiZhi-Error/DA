package com.tencent.mm.view;

import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H&J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/view/IPreViewDataCallback;", "", "onPreFinishLoadMore", "", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "libmmui_release"})
public interface i {
    void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> cVar);

    void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> cVar);

    void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> cVar);
}
