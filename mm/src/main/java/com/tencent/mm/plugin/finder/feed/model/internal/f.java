package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.mm.plugin.finder.feed.model.internal.i;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "", "onFetchDone", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "plugin-finder_release"})
public interface f<T extends i> {
    void onFetchDone(IResponse<T> iResponse);
}
