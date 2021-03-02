package com.tencent.mm.view.recyclerview;

import com.tencent.mm.view.recyclerview.a;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000eH&J\u0016\u0010\u0010\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0016¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/view/recyclerview/ExposeTimeRecordListener;", "T", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "", "()V", "getExposedId", "", "holder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "ignoreFlingExposed", "", "onExposeTimeRecorded", "", "recordsSet", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "onItemExposeStart", "item", "libmmui_release"})
public abstract class d<T extends a> {
    public abstract void l(Set<b<T>> set);

    public void a(b<T> bVar) {
        p.h(bVar, "item");
    }
}
