package com.tencent.mm.plugin.textstatus.i;

import android.view.View;
import com.tencent.mm.plugin.textstatus.g.r;
import kotlin.g.a.a;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\"\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/third/ISpecialViewSingleton;", "", "getView", "Landroid/view/View;", "jumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "getViewAndRefresh", "refreshCallback", "Lkotlin/Function0;", "", "release", "plugin-textstatus_release"})
public interface b {
    View a(r rVar);

    View a(r rVar, a<x> aVar);

    void b(r rVar);
}
