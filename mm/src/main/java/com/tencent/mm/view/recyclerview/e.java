package com.tencent.mm.view.recyclerview;

import android.support.v7.widget.RecyclerView;
import com.tencent.mm.view.recyclerview.a;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH&J\u001c\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0017JE\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00062\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001aH&¢\u0006\u0002\u0010\u001bJ \u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u000bH&J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/view/recyclerview/ItemConvert;", QLog.TAG_REPORTLEVEL_DEVELOPER, "Lcom/tencent/mm/view/recyclerview/ConvertData;", "", "()V", "isAttachedToRecyclerView", "", "()Z", "setAttachedToRecyclerView", "(Z)V", "getLayoutId", "", "onAttachedToRecyclerView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/view/recyclerview/ConvertData;IIZLjava/util/List;)V", "onCreateViewHolder", "onDetachedFromRecyclerView", "onViewRecycled", "libmmui_release"})
public abstract class e<D extends a> {
    boolean RqG;

    public abstract void a(RecyclerView recyclerView, h hVar, int i2);

    public abstract void a(h hVar, D d2, int i2, int i3, boolean z, List<Object> list);

    public abstract int getLayoutId();

    public void b(h hVar) {
        p.h(hVar, "holder");
    }

    public void a(RecyclerView recyclerView, WxRecyclerAdapter<?> wxRecyclerAdapter) {
        p.h(recyclerView, "recyclerView");
        p.h(wxRecyclerAdapter, "adapter");
        this.RqG = true;
    }

    public void c(RecyclerView recyclerView) {
        p.h(recyclerView, "recyclerView");
        this.RqG = false;
    }
}
