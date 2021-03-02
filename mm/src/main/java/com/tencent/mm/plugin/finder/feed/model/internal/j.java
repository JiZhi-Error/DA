package com.tencent.mm.plugin.finder.feed.model.internal;

import com.facebook.share.internal.ShareConstants;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J$\u0010\u0004\u001a\u00020\u00052\u001a\u0010\u0006\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b\u0012\u0004\u0012\u00020\u00050\u0007H&J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\nH&J\u0016\u0010\u000b\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\bH&¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/internal/IPreload;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "", "getCache", "", "call", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lkotlin/Function0;", "setCache", "response", "plugin-finder_release"})
public interface j<T extends i> {
    void D(b<? super IResponse<T>, x> bVar);

    void G(a<x> aVar);

    void a(IResponse<T> iResponse);
}
