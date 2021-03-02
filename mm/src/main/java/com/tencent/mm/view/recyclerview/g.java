package com.tencent.mm.view.recyclerview;

import android.database.Observable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 x*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004xyz{B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010.\u001a\u00020/H&J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020/H\u0016J\u0010\u00103\u001a\u00020/2\u0006\u00102\u001a\u00020/H\u0016J%\u00104\u001a\u0002052\u0006\u00106\u001a\u00028\u00002\u0006\u00102\u001a\u00020/2\u0006\u00107\u001a\u00020\u0007H\u0016¢\u0006\u0002\u00108J%\u00109\u001a\u0002052\u0006\u00106\u001a\u00028\u00002\u0006\u00102\u001a\u00020/2\u0006\u00107\u001a\u00020\u0007H\u0016¢\u0006\u0002\u00108J\u001d\u0010:\u001a\u0002052\u0006\u00106\u001a\u00028\u00002\u0006\u00102\u001a\u00020/H&¢\u0006\u0002\u0010;J+\u0010:\u001a\u0002052\u0006\u00106\u001a\u00028\u00002\u0006\u00102\u001a\u00020/2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=H&¢\u0006\u0002\u0010?J'\u0010@\u001a\u0004\u0018\u00018\u00002\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020/2\u0006\u00107\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010DJ'\u0010E\u001a\u0004\u0018\u00018\u00002\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020/2\u0006\u00107\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010DJ\u001d\u0010F\u001a\u00028\u00002\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020/H&¢\u0006\u0002\u0010GJ\u0018\u0010H\u001a\u0002052\u0006\u00107\u001a\u00020\u00072\b\b\u0002\u0010I\u001a\u00020\u000eJ \u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u00020L2\u0006\u0010C\u001a\u00020/2\b\b\u0002\u0010I\u001a\u00020\u000eJ\u0018\u0010M\u001a\u0002052\u0006\u00107\u001a\u00020\u00072\b\b\u0002\u0010I\u001a\u00020\u000eJ \u0010N\u001a\u00020\u00072\u0006\u0010K\u001a\u00020L2\u0006\u0010C\u001a\u00020/2\b\b\u0002\u0010I\u001a\u00020\u000eJ\u000e\u0010O\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u0007J\u000e\u0010P\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u0007J\u001f\u0010Q\u001a\u0004\u0018\u00018\u00002\u0006\u0010R\u001a\u0002012\b\b\u0002\u0010S\u001a\u00020\u000e¢\u0006\u0002\u0010TJ\u0006\u0010U\u001a\u00020/J\u0006\u0010V\u001a\u00020/J\u000e\u0010W\u001a\u00020/2\u0006\u00102\u001a\u00020/J\u0006\u0010X\u001a\u00020/J\u000e\u0010Y\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020/J\u0006\u0010[\u001a\u00020/J\u000e\u0010\\\u001a\u00020\u00072\u0006\u0010]\u001a\u00020/J\u0006\u0010^\u001a\u00020/J\u000e\u0010_\u001a\u0002012\u0006\u00102\u001a\u00020/J\u000e\u0010`\u001a\u00020/2\u0006\u00102\u001a\u00020/J\b\u0010a\u001a\u00020\u000eH\u0002J\u000e\u0010b\u001a\u0002052\u0006\u0010R\u001a\u000201J\u0010\u0010c\u001a\u0002052\u0006\u0010'\u001a\u00020(H\u0016J\u001b\u0010d\u001a\u0002052\u0006\u00106\u001a\u00028\u00002\u0006\u00102\u001a\u00020/¢\u0006\u0002\u0010;J+\u0010d\u001a\u0002052\u0006\u00106\u001a\u00028\u00002\u0006\u00102\u001a\u00020/2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=H\u0016¢\u0006\u0002\u0010?J\u001b\u0010e\u001a\u00028\u00002\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020/¢\u0006\u0002\u0010GJ\u0010\u0010f\u001a\u0002052\u0006\u0010'\u001a\u00020(H\u0016J\u0015\u0010g\u001a\u0002052\u0006\u00106\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010hJ\u0010\u0010i\u001a\u0002052\u0006\u0010j\u001a\u00020LH\u0002J\u0010\u0010k\u001a\u0002052\u0006\u0010l\u001a\u00020\fH\u0016J\u0018\u0010m\u001a\u0002052\u0006\u0010R\u001a\u0002012\b\b\u0002\u0010I\u001a\u00020\u000eJ\u0018\u0010n\u001a\u0002052\u0006\u0010R\u001a\u0002012\b\b\u0002\u0010I\u001a\u00020\u000eJ3\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020r2\u0006\u00106\u001a\u00028\u00002\u0006\u00102\u001a\u00020/2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=H\u0016¢\u0006\u0002\u0010sJ\u0018\u0010t\u001a\u00020p2\u0006\u0010q\u001a\u00020r2\u0006\u0010C\u001a\u00020/H\u0016J\u0010\u0010u\u001a\u0002052\u0006\u0010l\u001a\u00020\fH\u0016J\u0015\u0010v\u001a\u00028\u00002\u0006\u0010j\u001a\u00020LH&¢\u0006\u0002\u0010wR\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0015\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011R\u001a\u0010\u0017\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0&X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020(X.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0010\u0010-\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006|"}, hxF = {"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx;", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "()V", "footerInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lkotlin/collections/ArrayList;", "headerInfoList", "hookObservable", "Landroid/database/Observable;", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "isAttachedToRecyclerView", "", "()Z", "setAttachedToRecyclerView", "(Z)V", "isHookRecyclerViewAdapterObservableSuccessfully", "isHookRecyclerViewAdapterObservableSuccessfully$delegate", "Lkotlin/Lazy;", "isSupportAvoidCrashWithNotifyWhenScrollOrLayout", "setSupportAvoidCrashWithNotifyWhenScrollOrLayout", "isSupportNotifyItemViewChangeWithoutAnyAttachAndDetachAction", "setSupportNotifyItemViewChangeWithoutAnyAttachAndDetachAction", "itemClickListener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "getItemClickListener", "()Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "setItemClickListener", "(Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;)V", "itemLongClickListener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "getItemLongClickListener", "()Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "setItemLongClickListener", "(Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;)V", "observable", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "recyclerViewOriginalObserver", "_getItemCount", "", "_getItemId", "", "position", "_getItemViewType", "_onBindFooterHolder", "", "holder", "info", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;ILcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;)V", "_onBindHeaderHolder", "_onBindViewHolder", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V", "payloads", "", "", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;ILjava/util/List;)V", "_onCreateFooterHolder", "parent", "Landroid/view/ViewGroup;", "type", "(Landroid/view/ViewGroup;ILcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;)Landroid/support/v7/widget/RecyclerView$ViewHolder;", "_onCreateHeaderHolder", "_onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;", "addFooter", "isNotifyAnim", "addFooterView", "resource", "Landroid/view/View;", "addHeader", "addHeaderView", "containsFooter", "containsHeader", "findViewHolderByItemId", "itemId", "isLog", "(JZ)Landroid/support/v7/widget/RecyclerView$ViewHolder;", "getContentCount", "getFixCount", "getFixPosition", "getFooterCount", "getFooterData", "footerPosition", "getHeaderCount", "getHeaderData", "headerPosition", "getItemCount", "getItemId", "getItemViewType", "hookRecyclerViewAdapterObservable", "notifyItemChanged", "onAttachedToRecyclerView", "onBindViewHolder", "onCreateViewHolder", "onDetachedFromRecyclerView", "onViewDetachedFromWindow", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;)V", "protectViewItemRecycleHealthy", "view", "registerAdapterDataObserver", "observer", "removeFooter", "removeHeader", "throwBindViewHolderException", "", "e", "Ljava/lang/Exception;", "(Ljava/lang/Exception;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILjava/util/List;)Ljava/lang/String;", "throwCreateViewHolderException", "unregisterAdapterDataObserver", "wrapViewHolder", "(Landroid/view/View;)Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Companion", "FixedViewInfo", "OnItemClickListener", "OnItemLongClickListener", "libmmui_release"})
public abstract class g<VH extends RecyclerView.v> extends RecyclerView.a<VH> {
    public static final a RqQ = new a((byte) 0);
    private boolean RqG;
    boolean RqH = true;
    boolean RqI = true;
    private Observable<RecyclerView.c> RqJ;
    private final kotlin.f RqK = kotlin.g.ah(new C2164g(this));
    private final ConcurrentLinkedQueue<RecyclerView.c> RqL = new ConcurrentLinkedQueue<>();
    public final ArrayList<b> RqM = new ArrayList<>();
    public final ArrayList<b> RqN = new ArrayList<>();
    public d<VH> RqO;
    public c<VH> RqP;
    public RecyclerView hak;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003J3\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H&¢\u0006\u0002\u0010\r¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;ILandroid/support/v7/widget/RecyclerView$ViewHolder;)V", "libmmui_release"})
    public interface c<VH extends RecyclerView.v> {
        void a(RecyclerView.a<VH> aVar, View view, int i2, VH vh);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003J3\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H&¢\u0006\u0002\u0010\r¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "", "onItemLongClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;ILandroid/support/v7/widget/RecyclerView$ViewHolder;)Z", "libmmui_release"})
    public interface d<VH extends RecyclerView.v> {
        boolean b(RecyclerView.a<VH> aVar, View view, int i2, VH vh);
    }

    private final boolean hgr() {
        return ((Boolean) this.RqK.getValue()).booleanValue();
    }

    public abstract void b(VH vh, int i2, List<Object> list);

    public abstract void h(VH vh, int i2);

    public abstract VH hJ(View view);

    public abstract int hgt();

    public abstract VH p(ViewGroup viewGroup, int i2);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$Companion;", "", "()V", "TAG", "", "libmmui_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final RecyclerView getRecyclerView() {
        RecyclerView recyclerView = this.hak;
        if (recyclerView == null) {
            p.btv("recyclerView");
        }
        return recyclerView;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean hgs() {
        try {
            Field declaredField = RecyclerView.a.class.getDeclaredField("atj");
            p.g(declaredField, "RecyclerView.Adapter::cl…laredField(\"mObservable\")");
            declaredField.setAccessible(true);
            Constructor<?> declaredConstructor = declaredField.get(this).getClass().getDeclaredConstructor(new Class[0]);
            p.g(declaredConstructor, "origin.javaClass.getDeclaredConstructor()");
            declaredConstructor.setAccessible(true);
            Object newInstance = declaredConstructor.newInstance(new Object[0]);
            p.g(newInstance, "constructor.newInstance()");
            if (newInstance == null) {
                throw new t("null cannot be cast to non-null type android.database.Observable<android.support.v7.widget.RecyclerView.AdapterDataObserver>");
            }
            this.RqJ = (Observable) newInstance;
            declaredField.set(this, this.RqJ);
            return this.RqJ != null;
        } catch (Throwable th) {
            Log.printErrStackTrace("RecyclerViewAdapterEx", th, "", new Object[0]);
            return false;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final void a(RecyclerView.c cVar) {
        p.h(cVar, "observer");
        if (hgr()) {
            this.RqL.add(cVar);
        } else {
            super.a(cVar);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final void b(RecyclerView.c cVar) {
        p.h(cVar, "observer");
        if (hgr()) {
            this.RqL.remove(cVar);
        } else {
            super.b(cVar);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public void b(RecyclerView recyclerView) {
        Observable<RecyclerView.c> observable;
        p.h(recyclerView, "recyclerView");
        super.b(recyclerView);
        this.hak = recyclerView;
        this.RqG = this.RqG;
        if (hgr() && (observable = this.RqJ) != null) {
            observable.registerObserver(new h(this, recyclerView));
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J \u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0016"}, hxF = {"com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onAttachedToRecyclerView$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "checkValid", "", "preItemCount", "", "onChanged", "", "onItemRangeChanged", "positionStart", "itemCount", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "libmmui_release"})
    public static final class h extends RecyclerView.c {
        final /* synthetic */ g RqS;
        private final Handler aDv = new Handler(Looper.getMainLooper());
        final /* synthetic */ RecyclerView tDJ;

        h(g gVar, RecyclerView recyclerView) {
            this.RqS = gVar;
            this.tDJ = recyclerView;
            AppMethodBeat.i(164718);
            AppMethodBeat.o(164718);
        }

        public final boolean aqd(int i2) {
            AppMethodBeat.i(205047);
            if (i2 == this.RqS.getItemCount()) {
                AppMethodBeat.o(205047);
                return true;
            }
            AppMethodBeat.o(205047);
            return false;
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onChanged() {
            AppMethodBeat.i(164712);
            if (!this.RqS.RqI || !this.tDJ.ld()) {
                for (RecyclerView.c cVar : this.RqS.RqL) {
                    cVar.onChanged();
                }
                AppMethodBeat.o(164712);
                return;
            }
            Log.w("RecyclerViewAdapterEx", "[onChanged] Cannot call this method while RecyclerView is computing a layout or scrolling");
            this.tDJ.post(new a(this));
            AppMethodBeat.o(164712);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
        static final class a implements Runnable {
            final /* synthetic */ h RqT;

            a(h hVar) {
                this.RqT = hVar;
            }

            public final void run() {
                AppMethodBeat.i(164704);
                this.RqT.RqS.notifyDataSetChanged();
                AppMethodBeat.o(164704);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeChanged(int i2, int i3) {
            RecyclerView.f itemAnimator;
            AppMethodBeat.i(164713);
            if (!this.RqS.RqI || !this.tDJ.ld()) {
                if (this.RqS.RqH && (itemAnimator = this.tDJ.getItemAnimator()) != null) {
                    Log.w("RecyclerViewAdapterEx", "originItemAnimator=".concat(String.valueOf(itemAnimator)));
                    this.tDJ.setItemAnimator(null);
                    this.aDv.removeCallbacksAndMessages(null);
                    this.aDv.postDelayed(new b(itemAnimator, this, itemAnimator), itemAnimator.lA() + 60);
                }
                for (RecyclerView.c cVar : this.RqS.RqL) {
                    cVar.onItemRangeChanged(i2, i3);
                }
                AppMethodBeat.o(164713);
                return;
            }
            Log.w("RecyclerViewAdapterEx", "[onItemRangeChanged] Cannot call this method while RecyclerView is computing a layout or scrolling, positionStart=" + i2 + " itemCount=" + i3 + ' ' + Util.getStack());
            this.tDJ.post(new d(this, i3, i2));
            AppMethodBeat.o(164713);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
        static final class d implements Runnable {
            final /* synthetic */ h RqT;
            final /* synthetic */ int tYg;
            final /* synthetic */ int tYh;

            d(h hVar, int i2, int i3) {
                this.RqT = hVar;
                this.tYh = i2;
                this.tYg = i3;
            }

            public final void run() {
                AppMethodBeat.i(164707);
                if (!this.RqT.aqd(this.tYh)) {
                    Log.e("RecyclerViewAdapterEx", "[onItemRangeChanged] preItemCount=" + this.tYh + " but now itemCount is " + this.RqT.RqS.getItemCount());
                    AppMethodBeat.o(164707);
                    return;
                }
                this.RqT.RqS.b(this.tYg, Integer.valueOf(this.tYh));
                AppMethodBeat.o(164707);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run", "com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onAttachedToRecyclerView$1$onItemRangeChanged$2$1"})
        static final class b implements Runnable {
            final /* synthetic */ h RqT;
            final /* synthetic */ RecyclerView.f RqU;
            final /* synthetic */ RecyclerView.f RqV;

            b(RecyclerView.f fVar, h hVar, RecyclerView.f fVar2) {
                this.RqU = fVar;
                this.RqT = hVar;
                this.RqV = fVar2;
            }

            public final void run() {
                AppMethodBeat.i(164705);
                this.RqT.tDJ.setItemAnimator(this.RqU);
                AppMethodBeat.o(164705);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeChanged(int i2, int i3, Object obj) {
            AppMethodBeat.i(164714);
            if (!this.RqS.RqI || !this.tDJ.ld()) {
                if (this.RqS.RqH) {
                    RecyclerView.f itemAnimator = this.tDJ.getItemAnimator();
                    this.tDJ.setItemAnimator(null);
                    if (itemAnimator != null) {
                        Log.w("RecyclerViewAdapterEx", "originItemAnimator=".concat(String.valueOf(itemAnimator)));
                        if (itemAnimator.lA() > 0) {
                            this.aDv.removeCallbacksAndMessages(null);
                            this.aDv.postDelayed(new c(itemAnimator, this, itemAnimator), itemAnimator.lA() + 60);
                        }
                    }
                }
                for (RecyclerView.c cVar : this.RqS.RqL) {
                    cVar.onItemRangeChanged(i2, i3, obj);
                }
                AppMethodBeat.o(164714);
                return;
            }
            Log.w("RecyclerViewAdapterEx", "[onItemRangeChanged] Cannot call this method while RecyclerView is computing a layout or scrolling, positionStart=" + i2 + " itemCount=" + i3 + " payload=" + obj + ' ' + Util.getStack());
            this.tDJ.post(new e(this, i3, i2, obj));
            AppMethodBeat.o(164714);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
        static final class e implements Runnable {
            final /* synthetic */ h RqT;
            final /* synthetic */ int tYg;
            final /* synthetic */ int tYh;
            final /* synthetic */ Object tYi;

            e(h hVar, int i2, int i3, Object obj) {
                this.RqT = hVar;
                this.tYh = i2;
                this.tYg = i3;
                this.tYi = obj;
            }

            public final void run() {
                AppMethodBeat.i(164708);
                if (!this.RqT.aqd(this.tYh)) {
                    Log.e("RecyclerViewAdapterEx", "[onItemRangeChanged] preItemCount=" + this.tYh + " but now itemCount is " + this.RqT.RqS.getItemCount());
                    AppMethodBeat.o(164708);
                    return;
                }
                this.RqT.RqS.e(this.tYg, this.tYh, this.tYi);
                AppMethodBeat.o(164708);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run", "com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onAttachedToRecyclerView$1$onItemRangeChanged$5$1"})
        static final class c implements Runnable {
            final /* synthetic */ h RqT;
            final /* synthetic */ RecyclerView.f RqU;
            final /* synthetic */ RecyclerView.f RqV;

            c(RecyclerView.f fVar, h hVar, RecyclerView.f fVar2) {
                this.RqU = fVar;
                this.RqT = hVar;
                this.RqV = fVar2;
            }

            public final void run() {
                AppMethodBeat.i(164706);
                this.RqT.tDJ.setItemAnimator(this.RqU);
                AppMethodBeat.o(164706);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeInserted(int i2, int i3) {
            AppMethodBeat.i(164715);
            if (!this.RqS.RqI || !this.tDJ.ld()) {
                for (RecyclerView.c cVar : this.RqS.RqL) {
                    cVar.onItemRangeInserted(i2, i3);
                }
                AppMethodBeat.o(164715);
                return;
            }
            Log.w("RecyclerViewAdapterEx", "[onItemRangeInserted] Cannot call this method while RecyclerView is computing a layout or scrolling, positionStart=" + i2 + " itemCount=" + i3 + ' ' + Util.getStack());
            this.tDJ.post(new f(this, i3, i2));
            AppMethodBeat.o(164715);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
        static final class f implements Runnable {
            final /* synthetic */ h RqT;
            final /* synthetic */ int tYg;
            final /* synthetic */ int tYh;

            f(h hVar, int i2, int i3) {
                this.RqT = hVar;
                this.tYh = i2;
                this.tYg = i3;
            }

            public final void run() {
                AppMethodBeat.i(164709);
                if (!this.RqT.aqd(this.tYh)) {
                    Log.e("RecyclerViewAdapterEx", "[onItemRangeInserted] preItemCount=" + this.tYh + " but now itemCount is " + this.RqT.RqS.getItemCount());
                    AppMethodBeat.o(164709);
                    return;
                }
                this.RqT.RqS.as(this.tYg, this.tYh);
                AppMethodBeat.o(164709);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeMoved(int i2, int i3, int i4) {
            AppMethodBeat.i(164716);
            if (!this.RqS.RqI || !this.tDJ.ld()) {
                for (RecyclerView.c cVar : this.RqS.RqL) {
                    cVar.onItemRangeMoved(i2, i3, i4);
                }
                AppMethodBeat.o(164716);
                return;
            }
            Log.w("RecyclerViewAdapterEx", "[onItemRangeMoved] Cannot call this method while RecyclerView is computing a layout or scrolling, fromPosition=" + i2 + " toPosition=" + i3 + " itemCount=" + i4 + ' ' + Util.getStack());
            this.tDJ.post(new RunnableC2165g(this, i4, i2, i3));
            AppMethodBeat.o(164716);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
        /* renamed from: com.tencent.mm.view.recyclerview.g$h$g  reason: collision with other inner class name */
        static final class RunnableC2165g implements Runnable {
            final /* synthetic */ h RqT;
            final /* synthetic */ int RqW;
            final /* synthetic */ int RqX;
            final /* synthetic */ int tYh;

            RunnableC2165g(h hVar, int i2, int i3, int i4) {
                this.RqT = hVar;
                this.tYh = i2;
                this.RqW = i3;
                this.RqX = i4;
            }

            public final void run() {
                AppMethodBeat.i(164710);
                if (!this.RqT.aqd(this.tYh)) {
                    Log.e("RecyclerViewAdapterEx", "[onItemRangeMoved] preItemCount=" + this.tYh + " but now itemCount is " + this.RqT.RqS.getItemCount());
                    AppMethodBeat.o(164710);
                    return;
                }
                this.RqT.RqS.ar(this.RqW, this.RqX);
                AppMethodBeat.o(164710);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeRemoved(int i2, int i3) {
            AppMethodBeat.i(164717);
            if (!this.RqS.RqI || !this.tDJ.ld()) {
                for (RecyclerView.c cVar : this.RqS.RqL) {
                    cVar.onItemRangeRemoved(i2, i3);
                }
                AppMethodBeat.o(164717);
                return;
            }
            Log.w("RecyclerViewAdapterEx", "[onItemRangeRemoved] Cannot call this method while RecyclerView is computing a layout or scrolling, positionStart=" + i2 + " itemCount=" + i3 + ' ' + Util.getStack());
            this.tDJ.post(new RunnableC2166h(this, i3, i2));
            AppMethodBeat.o(164717);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
        /* renamed from: com.tencent.mm.view.recyclerview.g$h$h  reason: collision with other inner class name */
        static final class RunnableC2166h implements Runnable {
            final /* synthetic */ h RqT;
            final /* synthetic */ int tYg;
            final /* synthetic */ int tYh;

            RunnableC2166h(h hVar, int i2, int i3) {
                this.RqT = hVar;
                this.tYh = i2;
                this.tYg = i3;
            }

            public final void run() {
                AppMethodBeat.i(164711);
                if (!this.RqT.aqd(this.tYh)) {
                    Log.e("RecyclerViewAdapterEx", "[notifyItemRangeRemoved] preItemCount=" + this.tYh + " but now itemCount is " + this.RqT.RqS.getItemCount());
                    AppMethodBeat.o(164711);
                    return;
                }
                this.RqT.RqS.at(this.tYg, this.tYh);
                AppMethodBeat.o(164711);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public void c(RecyclerView recyclerView) {
        p.h(recyclerView, "recyclerView");
        super.c(recyclerView);
        this.RqG = false;
    }

    public final void a(b bVar, boolean z) {
        p.h(bVar, "info");
        if (!this.RqM.contains(bVar)) {
            this.RqM.add(bVar);
            if (z) {
                cj(this.RqM.size() - 1);
                return;
            }
            Log.i("RecyclerViewAdapterEx", "[addHeader] notifyDataSetChanged");
            notifyDataSetChanged();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0013\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$addHeaderView$info$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "getItemId", "", "getItemType", "", "getLayoutId", "getView", "Landroid/view/View;", "isStatic", "libmmui_release"})
    public static final class f extends b {
        final /* synthetic */ int $type;
        final /* synthetic */ View RqR;

        f(View view, int i2) {
            this.RqR = view;
            this.$type = i2;
        }

        @Override // com.tencent.mm.view.recyclerview.g.b
        public final boolean hgu() {
            return true;
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final long lT() {
            AppMethodBeat.i(164702);
            long hashCode = (long) this.RqR.hashCode();
            AppMethodBeat.o(164702);
            return hashCode;
        }

        @Override // com.tencent.mm.view.recyclerview.g.b
        public final View getView() {
            return this.RqR;
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final int cxn() {
            return this.$type;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(164703);
            if (!(obj instanceof b) || lT() != ((b) obj).lT()) {
                AppMethodBeat.o(164703);
                return false;
            }
            AppMethodBeat.o(164703);
            return true;
        }
    }

    public final b f(View view, int i2, boolean z) {
        p.h(view, "resource");
        f fVar = new f(view, i2);
        if (!this.RqM.contains(fVar)) {
            this.RqM.add(fVar);
            Log.i("Finder.FinderTopicFeedUIContract.TopicFeedViewCallback", "headerInfoList.add : " + fVar.lT());
            if (z) {
                cj(this.RqM.size() - 1);
            } else {
                Log.i("RecyclerViewAdapterEx", "[addHeaderView] notifyDataSetChanged");
                notifyDataSetChanged();
            }
        }
        return fVar;
    }

    public final boolean a(b bVar) {
        p.h(bVar, "info");
        return this.RqM.contains(bVar);
    }

    public final boolean b(b bVar) {
        p.h(bVar, "info");
        return this.RqN.contains(bVar);
    }

    public static /* synthetic */ void b(g gVar, b bVar) {
        p.h(bVar, "info");
        if (!gVar.RqN.contains(bVar)) {
            gVar.RqN.add(bVar);
            gVar.cj(gVar.getItemCount() - 1);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0013\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$addFooterView$info$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "getItemId", "", "getItemType", "", "getLayoutId", "getView", "Landroid/view/View;", "isStatic", "libmmui_release"})
    public static final class e extends b {
        final /* synthetic */ int $type;
        final /* synthetic */ View RqR;

        e(View view, int i2) {
            this.RqR = view;
            this.$type = i2;
        }

        @Override // com.tencent.mm.view.recyclerview.g.b
        public final boolean hgu() {
            return true;
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final long lT() {
            AppMethodBeat.i(164700);
            long hashCode = (long) this.RqR.hashCode();
            AppMethodBeat.o(164700);
            return hashCode;
        }

        @Override // com.tencent.mm.view.recyclerview.g.b
        public final View getView() {
            return this.RqR;
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final int cxn() {
            return this.$type;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(164701);
            if (!(obj instanceof b) || lT() != ((b) obj).lT()) {
                AppMethodBeat.o(164701);
                return false;
            }
            AppMethodBeat.o(164701);
            return true;
        }
    }

    public final b g(View view, int i2, boolean z) {
        p.h(view, "resource");
        e eVar = new e(view, i2);
        if (!this.RqN.contains(eVar)) {
            this.RqN.add(eVar);
            if (z) {
                cj(getItemCount() - 1);
            } else {
                Log.i("RecyclerViewAdapterEx", "[addFooterView] notifyDataSetChanged");
                notifyDataSetChanged();
            }
        }
        return eVar;
    }

    public final void T(long j2, boolean z) {
        boolean z2;
        Iterator<b> it = this.RqM.iterator();
        p.g(it, "headerInfoList.iterator()");
        boolean z3 = false;
        int i2 = 0;
        while (it.hasNext()) {
            b next = it.next();
            p.g(next, "iterator.next()");
            if (next.lT() == j2) {
                it.remove();
                z2 = true;
                if (z) {
                    ck(i2);
                }
            } else {
                z2 = z3;
            }
            i2++;
            z3 = z2;
        }
        if (z3 && !z) {
            Log.i("RecyclerViewAdapterEx", "[removeHeader] notifyDataSetChanged");
            notifyDataSetChanged();
        }
    }

    public final void U(long j2, boolean z) {
        boolean z2;
        Iterator<b> it = this.RqN.iterator();
        p.g(it, "footerInfoList.iterator()");
        boolean z3 = false;
        int i2 = 0;
        while (it.hasNext()) {
            b next = it.next();
            p.g(next, "iterator.next()");
            if (next.lT() == j2) {
                it.remove();
                z2 = true;
                if (z) {
                    ck(this.RqM.size() + hgt() + i2);
                }
            } else {
                z2 = z3;
            }
            i2++;
            z3 = z2;
        }
        if (z3 && !z) {
            Log.i("RecyclerViewAdapterEx", "[removeFooter] notifyDataSetChanged");
            notifyDataSetChanged();
        }
    }

    public int apZ(int i2) {
        return 0;
    }

    public long aqa(int i2) {
        return 0;
    }

    public VH a(ViewGroup viewGroup, int i2, b bVar) {
        p.h(viewGroup, "parent");
        p.h(bVar, "info");
        return null;
    }

    public VH b(ViewGroup viewGroup, int i2, b bVar) {
        p.h(viewGroup, "parent");
        p.h(bVar, "info");
        return null;
    }

    public void a(VH vh, int i2, b bVar) {
        p.h(vh, "holder");
        p.h(bVar, "info");
    }

    public void b(VH vh, int i2, b bVar) {
        p.h(vh, "holder");
        p.h(bVar, "info");
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final VH a(ViewGroup viewGroup, int i2) {
        int i3;
        VH p;
        VH b2;
        VH a2;
        p.h(viewGroup, "parent");
        try {
            Iterator<b> it = this.RqM.iterator();
            int i4 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i3 = -1;
                    break;
                }
                if (it.next().cxn() == i2) {
                    i3 = i4;
                    break;
                }
                i4++;
            }
            Iterator<b> it2 = this.RqN.iterator();
            int i5 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i5 = -1;
                    break;
                }
                if (it2.next().cxn() == i2) {
                    break;
                }
                i5++;
            }
            if (i3 >= 0) {
                b bVar = this.RqM.get(i3);
                p.g(bVar, "headerInfoList[indexH]");
                b bVar2 = bVar;
                if (bVar2.hgu()) {
                    View view = bVar2.getView();
                    if (view != null) {
                        a2 = hJ(view);
                    } else {
                        View inflate = aa.jQ(viewGroup.getContext()).inflate(0, viewGroup, false);
                        p.g(inflate, "MMLayoutInflater.getInfl…ayoutId(), parent, false)");
                        a2 = hJ(inflate);
                    }
                } else {
                    a2 = a(viewGroup, i2, bVar2);
                    if (a2 == null) {
                        p.hyc();
                    }
                }
                p = a2;
            } else if (i5 >= 0) {
                b bVar3 = this.RqN.get(i5);
                p.g(bVar3, "footerInfoList[indexF]");
                b bVar4 = bVar3;
                if (bVar4.hgu()) {
                    View view2 = bVar4.getView();
                    if (view2 != null) {
                        b2 = hJ(view2);
                    } else {
                        View inflate2 = aa.jQ(viewGroup.getContext()).inflate(0, viewGroup, false);
                        p.g(inflate2, "MMLayoutInflater.getInfl…ayoutId(), parent, false)");
                        b2 = hJ(inflate2);
                    }
                } else {
                    b bVar5 = this.RqN.get(i5);
                    p.g(bVar5, "footerInfoList[indexF]");
                    b2 = b(viewGroup, i2, bVar5);
                    if (b2 == null) {
                        p.hyc();
                    }
                }
                p = b2;
            } else {
                p = p(viewGroup, i2);
            }
            View view3 = p.aus;
            p.g(view3, "holder.itemView");
            if (!view3.hasOnClickListeners()) {
                view3.setOnClickListener(new i(this, p));
                view3.setOnLongClickListener(new j(this, p));
            }
            return p;
        } catch (Exception e2) {
            RuntimeException runtimeException = new RuntimeException(e2.getMessage() + "\n" + (c(e2, i2) + " crashActivity=" + viewGroup.getContext().getClass().getName()));
            runtimeException.setStackTrace(e2.getStackTrace());
            throw runtimeException;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i implements View.OnClickListener {
        final /* synthetic */ g RqS;
        final /* synthetic */ RecyclerView.v wrN;

        i(g gVar, RecyclerView.v vVar) {
            this.RqS = gVar;
            this.wrN = vVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.tencent.mm.view.recyclerview.g$c<VH extends android.support.v7.widget.RecyclerView$v> */
        /* JADX WARN: Multi-variable type inference failed */
        public final void onClick(View view) {
            AppMethodBeat.i(164719);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onCreateViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            RecyclerView.v bu = this.RqS.getRecyclerView().bu(view);
            int lR = bu != null ? bu.lR() : -1;
            c<VH> cVar = this.RqS.RqP;
            if (cVar != 0) {
                p.g(view, LocaleUtil.ITALIAN);
                cVar.a(this.RqS, view, lR, this.wrN);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onCreateViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(164719);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class j implements View.OnLongClickListener {
        final /* synthetic */ g RqS;
        final /* synthetic */ RecyclerView.v wrN;

        j(g gVar, RecyclerView.v vVar) {
            this.RqS = gVar;
            this.wrN = vVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.tencent.mm.view.recyclerview.g$d<VH extends android.support.v7.widget.RecyclerView$v> */
        /* JADX WARN: Multi-variable type inference failed */
        public final boolean onLongClick(View view) {
            boolean z;
            AppMethodBeat.i(164720);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onCreateViewHolder$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            RecyclerView.v bu = this.RqS.getRecyclerView().bu(view);
            int lR = bu != null ? bu.lR() : -1;
            d<VH> dVar = this.RqS.RqO;
            if (dVar != 0) {
                p.g(view, LocaleUtil.ITALIAN);
                z = dVar.b(this.RqS, view, lR, this.wrN);
            } else {
                z = false;
            }
            com.tencent.mm.hellhoundlib.a.a.a(z, this, "com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onCreateViewHolder$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(164720);
            return z;
        }
    }

    public String c(Exception exc, int i2) {
        p.h(exc, "e");
        return "viewType=".concat(String.valueOf(i2));
    }

    public final b aqb(int i2) {
        b bVar = this.RqM.get(i2);
        p.g(bVar, "headerInfoList[headerPosition]");
        return bVar;
    }

    public final b aqc(int i2) {
        b bVar = this.RqN.get(i2);
        p.g(bVar, "footerInfoList[footerPosition]");
        return bVar;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        if (i2 < this.RqM.size()) {
            return this.RqM.get(i2).cxn();
        }
        if (i2 < hgt() + this.RqM.size()) {
            return apZ(i2 - this.RqM.size());
        }
        return this.RqN.get(i2 - (this.RqM.size() + hgt())).cxn();
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final long getItemId(int i2) {
        if (getItemCount() <= i2 || i2 < 0) {
            String str = "[getItemId] position=" + i2 + " itemCount=" + getItemCount() + " headerCount=" + this.RqM.size() + " footerCount=" + this.RqN.size() + ' ' + Util.getStack();
            Log.e("RecyclerViewAdapterEx", str);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(20251, 3, str);
            return 0;
        } else if (i2 < this.RqM.size()) {
            return this.RqM.get(i2).lT();
        } else {
            if (i2 < hgt() + this.RqM.size()) {
                return aqa(i2 - this.RqM.size());
            }
            return this.RqN.get(i2 - (this.RqM.size() + hgt())).lT();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        return this.RqM.size() + hgt() + this.RqN.size();
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final void a(VH vh, int i2) {
        p.h(vh, "holder");
        long uptimeMillis = SystemClock.uptimeMillis();
        if (i2 < this.RqM.size()) {
            b bVar = this.RqM.get(i2);
            p.g(bVar, "headerInfoList[position]");
            b bVar2 = bVar;
            if (!bVar2.hgu()) {
                a(vh, i2, bVar2);
            }
        } else if (i2 >= hgt() + this.RqM.size()) {
            b bVar3 = this.RqN.get(i2 - (this.RqM.size() + hgt()));
            p.g(bVar3, "footerInfoList[footerIndex]");
            b bVar4 = bVar3;
            if (!bVar4.hgu()) {
                b(vh, i2, bVar4);
            }
        } else {
            h(vh, i2 - this.RqM.size());
        }
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        if (uptimeMillis2 > 17) {
            Log.i("RecyclerViewAdapterEx", "[onBindViewHolder] pos:" + i2 + ", itemId=" + getItemId(i2) + " itemType=" + getItemViewType(i2) + " cost=" + uptimeMillis2);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public void a(VH vh, int i2, List<Object> list) {
        p.h(vh, "holder");
        p.h(list, "payloads");
        try {
            if (list.isEmpty()) {
                super.a(vh, i2, list);
            } else if (i2 < this.RqM.size()) {
                b bVar = this.RqM.get(i2);
                p.g(bVar, "headerInfoList[position]");
                a(vh, i2, bVar);
            } else if (i2 >= hgt() + this.RqM.size()) {
                b bVar2 = this.RqN.get(i2 - (this.RqM.size() + hgt()));
                p.g(bVar2, "footerInfoList[footerIndex]");
                b(vh, i2, bVar2);
            } else {
                b(vh, i2 - this.RqM.size(), list);
            }
        } catch (Exception e2) {
            StringBuilder append = new StringBuilder().append(a(e2, vh, list)).append(" crashActivity=");
            View view = vh.aus;
            p.g(view, "holder.itemView");
            RuntimeException runtimeException = new RuntimeException(e2.getMessage() + "\n" + append.append(view.getContext().getClass().getName()).toString());
            runtimeException.setStackTrace(e2.getStackTrace());
            throw runtimeException;
        }
    }

    public String a(Exception exc, VH vh, List<Object> list) {
        p.h(exc, "e");
        p.h(vh, "holder");
        p.h(list, "payloads");
        return "";
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "getLayoutId", "", "getView", "Landroid/view/View;", "isStatic", "", "libmmui_release"})
    public static abstract class b implements a {
        public boolean hgu() {
            return false;
        }

        public View getView() {
            return null;
        }
    }

    public final VH V(long j2, boolean z) {
        StringBuilder sb = new StringBuilder();
        RecyclerView recyclerView = this.hak;
        if (recyclerView == null) {
            p.btv("recyclerView");
        }
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView recyclerView2 = this.hak;
            if (recyclerView2 == null) {
                p.btv("recyclerView");
            }
            RecyclerView recyclerView3 = this.hak;
            if (recyclerView3 == null) {
                p.btv("recyclerView");
            }
            VH vh = (VH) recyclerView2.bu(recyclerView3.getChildAt(i2));
            if (!(vh == null || vh.lR() == -1)) {
                long itemId = getItemId(vh.lR());
                if (z) {
                    sb.append("adapterPosition=" + vh.lR() + " itemId=" + itemId + '\n');
                }
                if (j2 == itemId) {
                    if (vh != null) {
                        return vh;
                    }
                    throw new t("null cannot be cast to non-null type VH");
                }
            }
        }
        if (z) {
            Log.w("RecyclerViewAdapterEx", "[findViewHolderByItemId] ".concat(String.valueOf(sb)));
        }
        return null;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final void l(VH vh) {
        p.h(vh, "holder");
        super.l(vh);
        View view = vh.aus;
        p.g(view, "holder.itemView");
        dW(view);
    }

    private final void dW(View view) {
        if (view instanceof ViewGroup) {
            int childCount = ((ViewGroup) view).getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = ((ViewGroup) view).getChildAt(i2);
                if (childAt != null) {
                    childAt.animate().cancel();
                    childAt.hasTransientState();
                    dW(childAt);
                }
            }
            view.animate().cancel();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "invoke"})
    /* renamed from: com.tencent.mm.view.recyclerview.g$g  reason: collision with other inner class name */
    static final class C2164g extends q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ g RqS;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2164g(g gVar) {
            super(0);
            this.RqS = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(205046);
            Boolean valueOf = Boolean.valueOf(this.RqS.hgs());
            AppMethodBeat.o(205046);
            return valueOf;
        }
    }

    public final void Or(long j2) {
        VH V = V(j2, false);
        if (V != null) {
            ci(V.lR());
        }
    }
}
