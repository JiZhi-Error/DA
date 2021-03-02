package com.tencent.mm.plugin.festival.finder;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.h.c;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.of;
import com.tencent.mm.live.c.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.festival.PluginFestival;
import com.tencent.mm.plugin.festival.finder.bo;
import com.tencent.mm.plugin.festival.finder.k;
import com.tencent.mm.plugin.festival.model.ParcelableFestivalWish;
import com.tencent.mm.plugin.festival.model.ad;
import com.tencent.mm.plugin.festival.model.ag;
import com.tencent.mm.plugin.festival.model.ai;
import com.tencent.mm.plugin.festival.ui.view.FestivalCdnImageView;
import com.tencent.mm.plugin.festival.ui.view.c;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.as;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0019\u0018\u0000 <2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003<=>B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020)H\u0016J\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002J\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020)H\u0002J\b\u00101\u001a\u00020)H\u0016J\u0010\u00102\u001a\u00020'2\u0006\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020)H\u0016J\u001a\u00106\u001a\u00020)2\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u00020)H\u0016R\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasDanmakuPlugin;", "Lcom/tencent/mm/plugin/festival/finder/FestivalLiveCanvasOverlayElementsPluginBase;", "Lcom/tencent/mm/plugin/festival/model/IForbiddenCallback;", "Lcom/tencent/mm/plugin/festival/finder/FestivalLiveCanvasClickInterceptorPlugin;", "containerLayout", "Landroid/widget/FrameLayout;", "canvasPresenter", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasViewContract$Presenter;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasViewContract$Presenter;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "containerContract", "Lcom/tencent/mm/plugin/festival/finder/FestivalDanmakuContainerContract;", "getContainerContract", "()Lcom/tencent/mm/plugin/festival/finder/FestivalDanmakuContainerContract;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "danmakuAdapter", "com/tencent/mm/plugin/festival/finder/FestivalCanvasDanmakuPlugin$danmakuAdapter$1", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasDanmakuPlugin$danmakuAdapter$1;", "danmakuManager", "Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract;", "Lcom/tencent/mm/plugin/festival/model/ParcelableFestivalWish;", "danmakuView", "Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuView;", "elementsViewContact", "getElementsViewContact", "()Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract;", "myNewWish", "onStorageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "canClearScreen", "", "clearScreen", "", "filterWishList", "", "Lcom/tencent/mm/plugin/festival/model/LocalFestivalWishInfo;", "list", "getFlagBit", "", "loadAndFillDanmakuData", "mount", "onInterceptCanvasClick", "pointF", "Landroid/graphics/PointF;", "recoveryScreen", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "Companion", "DiffCallback", "FestivalDanmakuViewHolder", "plugin-festival_release"})
public final class c extends bo implements bn, ag {
    @Deprecated
    public static final a Uql = new a((byte) 0);
    private final String TAG = "MicroMsg.FestivalCanvasDanmakuPlugin";
    private final com.tencent.mm.plugin.festival.ui.view.b<ParcelableFestivalWish> Uqd;
    private final com.tencent.mm.plugin.festival.ui.view.c<ParcelableFestivalWish> Uqe;
    private final com.tencent.mm.plugin.festival.ui.view.c<ParcelableFestivalWish> Uqf;
    final l Uqg;
    private ParcelableFestivalWish Uqh;
    private final e Uqi;
    private final FrameLayout Uqj;
    private final k.a Uqk;
    private final com.tencent.mm.live.c.b hOp;
    private final MStorage.IOnStorageChange lqT;

    static {
        AppMethodBeat.i(262028);
        AppMethodBeat.o(262028);
    }

    public static final /* synthetic */ void d(c cVar) {
        AppMethodBeat.i(262029);
        cVar.dwZ();
        AppMethodBeat.o(262029);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(FrameLayout frameLayout, k.a aVar, com.tencent.mm.live.c.b bVar) {
        super(frameLayout, bVar);
        p.h(frameLayout, "containerLayout");
        p.h(aVar, "canvasPresenter");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(262027);
        this.Uqj = frameLayout;
        this.Uqk = aVar;
        this.hOp = bVar;
        Context context = this.Uqj.getContext();
        p.g(context, "containerLayout.context");
        com.tencent.mm.plugin.festival.ui.view.b<ParcelableFestivalWish> bVar2 = new com.tencent.mm.plugin.festival.ui.view.b<>(context);
        this.Uqj.addView(bVar2, new ViewGroup.LayoutParams(-1, -1));
        ViewGroup.LayoutParams layoutParams = bVar2.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) (!(layoutParams instanceof ViewGroup.MarginLayoutParams) ? null : layoutParams);
        if (marginLayoutParams != null) {
            Context context2 = bVar2.getContext();
            p.g(context2, "context");
            marginLayoutParams.topMargin = context2.getResources().getDimensionPixelSize(R.dimen.ci);
            bVar2.requestLayout();
        }
        this.Uqd = bVar2;
        this.Uqe = this.Uqd;
        this.Uqe.setRowCount(3);
        this.Uqe.setDuration(10000);
        com.tencent.mm.plugin.festival.ui.view.c<ParcelableFestivalWish> cVar = this.Uqe;
        Context context3 = this.Uqj.getContext();
        p.g(context3, "context");
        cVar.setPaddingVertical(context3.getResources().getDimensionPixelSize(R.dimen.ct));
        this.Uqf = this.Uqe;
        this.Uqg = new d(this);
        this.lqT = new l(this);
        this.Uqi = new e(this);
        AppMethodBeat.o(262027);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasDanmakuPlugin$Companion;", "", "()V", "STORAGE_LOAD_SERIAL_TAG", "", "plugin-festival_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.festival.finder.bo
    public final String getTAG() {
        return this.TAG;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalCanvasDanmakuPlugin$containerContract$1", "Lcom/tencent/mm/plugin/festival/finder/FestivalDanmakuContainerContract;", "visibleRectInRoot", "Landroid/graphics/Rect;", "getVisibleRectInRoot", "()Landroid/graphics/Rect;", "plugin-festival_release"})
    public static final class d implements l {
        final /* synthetic */ c Uqp;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(c cVar) {
            this.Uqp = cVar;
        }

        @Override // com.tencent.mm.plugin.festival.finder.l
        public final Rect dCY() {
            int width;
            Resources resources;
            DisplayMetrics displayMetrics;
            AppMethodBeat.i(262007);
            Context f2 = c.f(this.Uqp);
            p.g(f2, "context");
            int dimensionPixelSize = f2.getResources().getDimensionPixelSize(R.dimen.ct);
            int fromDPToPix = (dimensionPixelSize * 2) + (com.tencent.mm.cb.a.fromDPToPix(c.f(this.Uqp), 17) * 3);
            if (this.Uqp.Uqj.getVisibility() != 0 || !this.Uqp.Uqj.isLaidOut()) {
                com.tencent.mm.plugin.festival.c.j jVar = com.tencent.mm.plugin.festival.c.j.UGJ;
                Context f3 = c.f(this.Uqp);
                p.g(f3, "context");
                int statusBarHeight = (dimensionPixelSize * 13) + com.tencent.mm.plugin.festival.c.j.getStatusBarHeight(f3);
                Context f4 = c.f(this.Uqp);
                if (!(f4 instanceof Activity)) {
                    f4 = null;
                }
                Activity activity = (Activity) f4;
                if (activity == null || (resources = activity.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
                    Object a2 = android.support.v4.content.b.a(c.f(this.Uqp), WindowManager.class);
                    if (a2 == null) {
                        p.hyc();
                    }
                    p.g(a2, "ContextCompat.getSystemS…dowManager::class.java)!!");
                    Display defaultDisplay = ((WindowManager) a2).getDefaultDisplay();
                    p.g(defaultDisplay, "ContextCompat.getSystemS…ss.java)!!.defaultDisplay");
                    width = defaultDisplay.getWidth();
                } else {
                    width = displayMetrics.widthPixels;
                }
                Rect rect = new Rect(0, statusBarHeight, width, fromDPToPix + statusBarHeight);
                AppMethodBeat.o(262007);
                return rect;
            }
            Rect rect2 = new Rect(this.Uqp.Uqd.getLeft() + this.Uqp.Uqj.getLeft(), this.Uqp.Uqd.getTop() + this.Uqp.Uqj.getTop(), this.Uqp.Uqd.getRight() + this.Uqp.Uqj.getLeft(), Math.max(this.Uqp.Uqd.getHeight(), fromDPToPix) + this.Uqp.Uqd.getTop() + this.Uqp.Uqj.getTop());
            AppMethodBeat.o(262007);
            return rect2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    static final class l implements MStorage.IOnStorageChange {
        final /* synthetic */ c Uqp;

        l(c cVar) {
            this.Uqp = cVar;
        }

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(262018);
            c.d(this.Uqp);
            AppMethodBeat.o(262018);
        }
    }

    private static List<ai> kQ(List<? extends ai> list) {
        AppMethodBeat.i(262019);
        HashMap hashMap = new HashMap();
        for (ai aiVar : list) {
            String str = aiVar.field_userName;
            if (!(str == null || str.length() == 0)) {
                if (!p.j(aiVar.field_userName, z.aTY())) {
                    com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                    p.g(af, "service(IMessengerStorage::class.java)");
                    as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(aiVar.field_userName);
                    if (Kn != null) {
                        if (Kn.arv()) {
                            if (Kn.ary()) {
                            }
                        }
                    }
                }
                long j2 = aiVar.field_createTime;
                ai aiVar2 = (ai) hashMap.get(aiVar.field_userName);
                if (j2 > (aiVar2 != null ? aiVar2.field_createTime : 0)) {
                    String str2 = aiVar.field_userName;
                    p.g(str2, "wish.field_userName");
                    hashMap.put(str2, aiVar);
                }
            }
        }
        LinkedList linkedList = new LinkedList();
        for (ai aiVar3 : hashMap.values()) {
            if (aiVar3.field_delFlag == 0) {
                linkedList.add(aiVar3);
            }
        }
        LinkedList linkedList2 = linkedList;
        AppMethodBeat.o(262019);
        return linkedList2;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class f implements Runnable {
        final /* synthetic */ c Uqp;

        f(c cVar) {
            this.Uqp = cVar;
        }

        public final void run() {
            AppMethodBeat.i(262010);
            c.d(this.Uqp);
            AppMethodBeat.o(262010);
        }
    }

    private final void dwZ() {
        boolean z;
        AppMethodBeat.i(262020);
        if (p.j(Looper.getMainLooper(), Looper.myLooper())) {
            com.tencent.f.h.RTc.e(new f(this), "FestivalCanvasDanmakuPlugin_storage");
            AppMethodBeat.o(262020);
            return;
        }
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFestival.class);
        p.g(ah, "plugin(PluginFestival::class.java)");
        List<ai> kQ = kQ(((PluginFestival) ah).getFestivalWishStorage().u(new StringBuilder("userName !=? and wishText !=? order by createTime desc limit 2147483647 offset 0").toString(), new String[]{z.aTY(), ""}));
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(kQ, 10));
        Iterator<T> it = kQ.iterator();
        while (it.hasNext()) {
            ParcelableFestivalWish.a aVar = ParcelableFestivalWish.UzR;
            arrayList.add(ParcelableFestivalWish.a.a(it.next()));
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            AppMethodBeat.o(262020);
            return;
        }
        v dataList = this.Uqe.getDataList();
        if (dataList == null) {
            dataList = v.SXr;
        }
        ArrayList arrayList3 = new ArrayList(dataList);
        if (arrayList3.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            com.tencent.f.h.RTc.aV(new g(this, arrayList2));
            AppMethodBeat.o(262020);
            return;
        }
        try {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            c.b a2 = android.support.v7.h.c.a(new b(arrayList3, new ArrayList(arrayList2)), false);
            p.g(a2, "DiffUtil.calculateDiff(D…rayList(newList)), false)");
            a2.a(new h(arrayList2, linkedList, arrayList3, linkedList2));
            com.tencent.f.h.RTc.aV(new i(this, linkedList2, linkedList));
            AppMethodBeat.o(262020);
        } catch (Exception e2) {
            Log.e(this.TAG, "loadAndFillDanmakuData calculateDiff exception:".concat(String.valueOf(e2)));
            com.tencent.f.h.RTc.aV(new j(this, arrayList2));
            AppMethodBeat.o(262020);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class g implements Runnable {
        final /* synthetic */ c Uqp;
        final /* synthetic */ List uWv;

        g(c cVar, List list) {
            this.Uqp = cVar;
            this.uWv = list;
        }

        public final void run() {
            AppMethodBeat.i(262011);
            if (this.Uqp.Uqe.isStarted()) {
                this.Uqp.Uqe.ab(this.uWv);
            }
            AppMethodBeat.o(262011);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalCanvasDanmakuPlugin$loadAndFillDanmakuData$3", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "position", "", "count", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-festival_release"})
    public static final class h implements android.support.v7.h.d {
        final /* synthetic */ LinkedList Uqr;
        final /* synthetic */ ArrayList Uqs;
        final /* synthetic */ LinkedList Uqt;
        final /* synthetic */ List uWv;

        h(List list, LinkedList linkedList, ArrayList arrayList, LinkedList linkedList2) {
            this.uWv = list;
            this.Uqr = linkedList;
            this.Uqs = arrayList;
            this.Uqt = linkedList2;
        }

        @Override // android.support.v7.h.d
        public final void f(int i2, int i3) {
            AppMethodBeat.i(262012);
            int i4 = i2 + i3;
            while (i2 < i4) {
                ParcelableFestivalWish parcelableFestivalWish = (ParcelableFestivalWish) kotlin.a.j.L(this.uWv, i2);
                if (parcelableFestivalWish != null) {
                    this.Uqr.add(parcelableFestivalWish);
                }
                i2++;
            }
            AppMethodBeat.o(262012);
        }

        @Override // android.support.v7.h.d
        public final void k(int i2, int i3) {
            AppMethodBeat.i(262013);
            int i4 = i2 + i3;
            while (i2 < i4) {
                ParcelableFestivalWish parcelableFestivalWish = (ParcelableFestivalWish) this.Uqs.remove(i2);
                if (parcelableFestivalWish != null) {
                    this.Uqt.add(parcelableFestivalWish);
                }
                i2++;
            }
            AppMethodBeat.o(262013);
        }

        @Override // android.support.v7.h.d
        public final void l(int i2, int i3) {
        }

        @Override // android.support.v7.h.d
        public final void c(int i2, int i3, Object obj) {
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class i implements Runnable {
        final /* synthetic */ c Uqp;
        final /* synthetic */ LinkedList Uqr;
        final /* synthetic */ LinkedList Uqt;

        i(c cVar, LinkedList linkedList, LinkedList linkedList2) {
            this.Uqp = cVar;
            this.Uqt = linkedList;
            this.Uqr = linkedList2;
        }

        public final void run() {
            AppMethodBeat.i(262014);
            if (this.Uqp.Uqe.isStarted()) {
                this.Uqp.Uqe.kY(this.Uqt);
                this.Uqp.Uqe.kX(this.Uqr);
            }
            AppMethodBeat.o(262014);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class j implements Runnable {
        final /* synthetic */ c Uqp;
        final /* synthetic */ List uWv;

        j(c cVar, List list) {
            this.Uqp = cVar;
            this.uWv = list;
        }

        public final void run() {
            AppMethodBeat.i(262015);
            if (this.Uqp.Uqe.isStarted()) {
                this.Uqp.Uqe.kX(this.uWv);
            }
            AppMethodBeat.o(262015);
        }
    }

    @Override // com.tencent.mm.plugin.festival.finder.bo, com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        ParcelableFestivalWish parcelableFestivalWish;
        AppMethodBeat.i(262021);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (d.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                if (bundle == null || (parcelableFestivalWish = (ParcelableFestivalWish) bundle.getParcelable("PARAM_FESTIVAL_FINDER_LIVE_MY_NEW_WISH_PARCELABLE_MODEL")) == null) {
                    AppMethodBeat.o(262021);
                    return;
                }
                p.g(parcelableFestivalWish, "param?.getParcelable<Par…arcelableModel) ?: return");
                if (this.Uqe.isStarted()) {
                    this.Uqe.addFirst(parcelableFestivalWish);
                    this.Uqh = parcelableFestivalWish;
                    AppMethodBeat.o(262021);
                    return;
                }
                break;
            case 2:
            case 3:
                ParcelableFestivalWish parcelableFestivalWish2 = this.Uqh;
                if (parcelableFestivalWish2 != null) {
                    this.Uqe.h(parcelableFestivalWish2, true);
                    AppMethodBeat.o(262021);
                    return;
                }
                break;
        }
        AppMethodBeat.o(262021);
    }

    @Override // com.tencent.mm.plugin.festival.finder.p, com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void mount() {
        AppMethodBeat.i(262022);
        super.mount();
        this.Uqe.setTouchEnabled(false);
        this.Uqe.setAdapter(this.Uqi);
        this.Uqe.start();
        this.Uqd.setOnDanmakuAppearListener(new k(this));
        dwZ();
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFestival.class);
        p.g(ah, "plugin(PluginFestival::class.java)");
        ((PluginFestival) ah).getFestivalWishStorage().add("FestivalCanvasDanmakuPlugin_storage", this.lqT);
        AppMethodBeat.o(262022);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalCanvasDanmakuPlugin$mount$1", "Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract$OnDanmakuAppearListener;", "Lcom/tencent/mm/plugin/festival/model/ParcelableFestivalWish;", "storage", "Lcom/tencent/mm/plugin/festival/model/FestivalWishStorage;", "kotlin.jvm.PlatformType", com.tencent.mm.plugin.appbrand.jsapi.storage.f.NAME, "()Lcom/tencent/mm/plugin/festival/model/FestivalWishStorage;", "onDanmakuAppear", "", "data", "plugin-festival_release"})
    public static final class k implements c.AbstractC1084c<ParcelableFestivalWish> {
        final /* synthetic */ c Uqp;
        private final ad Uqu;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        k(c cVar) {
            this.Uqp = cVar;
            AppMethodBeat.i(262017);
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFestival.class);
            p.g(ah, "plugin(PluginFestival::class.java)");
            this.Uqu = ((PluginFestival) ah).getFestivalWishStorage();
            AppMethodBeat.o(262017);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.festival.ui.view.c.AbstractC1084c
        public final /* synthetic */ void dw(ParcelableFestivalWish parcelableFestivalWish) {
            boolean remove;
            int i2 = 2000;
            AppMethodBeat.i(262016);
            ParcelableFestivalWish parcelableFestivalWish2 = parcelableFestivalWish;
            p.h(parcelableFestivalWish2, "data");
            try {
                ad adVar = this.Uqu;
                String str = parcelableFestivalWish2.UzM;
                if (str == null) {
                    remove = false;
                } else {
                    remove = adVar.UzJ.remove(str);
                }
                if (remove) {
                    int size = this.Uqu.UzJ.size();
                    if (size < 30) {
                        if (size <= 10) {
                            i2 = 4000;
                        } else {
                            i2 = android.support.v4.b.a.clamp(kotlin.h.a.cR(((((float) (size - 10)) / 20.0f) * 2000.0f) + 2000.0f), 2000, 4000);
                        }
                    }
                    this.Uqp.Uqd.setIntervalBetweenItem(i2);
                    AppMethodBeat.o(262016);
                    return;
                }
            } catch (Exception e2) {
            }
            AppMethodBeat.o(262016);
        }
    }

    @Override // com.tencent.mm.plugin.festival.finder.p, com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(262023);
        super.unMount();
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFestival.class);
        p.g(ah, "plugin(PluginFestival::class.java)");
        ((PluginFestival) ah).getFestivalWishStorage().remove(this.lqT);
        this.Uqe.unMount();
        AppMethodBeat.o(262023);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final void epk() {
        AppMethodBeat.i(262024);
        super.epk();
        if (this.Uqe.isStarted()) {
            this.Uqe.pause();
        }
        AppMethodBeat.o(262024);
    }

    @Override // com.tencent.mm.plugin.festival.finder.p, com.tencent.mm.plugin.finder.live.plugin.d
    public final void dCW() {
        AppMethodBeat.i(262025);
        super.dCW();
        if (this.Uqe.isStarted() && gFa()) {
            this.Uqe.resume();
        }
        AppMethodBeat.o(262025);
    }

    @Override // com.tencent.mm.plugin.festival.finder.bn
    public final boolean d(PointF pointF) {
        AppMethodBeat.i(262026);
        p.h(pointF, "pointF");
        if (!gFa() || this.hwr.getVisibility() != 0) {
            AppMethodBeat.o(262026);
            return false;
        } else if (Float.isNaN(pointF.x) || Float.isNaN(pointF.y)) {
            AppMethodBeat.o(262026);
            return false;
        } else {
            boolean e2 = this.Uqe.e(new PointF((pointF.x - this.hwr.getX()) - this.Uqd.getX(), (pointF.y - this.hwr.getY()) - this.Uqd.getY()));
            AppMethodBeat.o(262026);
            return e2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\b\u0012\u00060\u0002R\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001J\u001c\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0014\u0010\t\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalCanvasDanmakuPlugin$danmakuAdapter$1", "Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract$Adapter;", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasDanmakuPlugin$FestivalDanmakuViewHolder;", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasDanmakuPlugin;", "Lcom/tencent/mm/plugin/festival/model/ParcelableFestivalWish;", "onBindViewHolder", "", "viewHolder", "data", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "plugin-festival_release"})
    public static final class e implements c.a<C1062c, ParcelableFestivalWish> {
        final /* synthetic */ c Uqp;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(c cVar) {
            this.Uqp = cVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.festival.ui.view.c$a$a, java.lang.Object] */
        @Override // com.tencent.mm.plugin.festival.ui.view.c.a
        public final /* synthetic */ void a(C1062c cVar, ParcelableFestivalWish parcelableFestivalWish) {
            boolean z;
            AppMethodBeat.i(262009);
            C1062c cVar2 = cVar;
            ParcelableFestivalWish parcelableFestivalWish2 = parcelableFestivalWish;
            p.h(cVar2, "viewHolder");
            p.h(parcelableFestivalWish2, "data");
            cVar2.aus.setTag(R.id.jvc, parcelableFestivalWish2);
            String str = parcelableFestivalWish2.username;
            if (str == null || str.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                cVar2.Uqn.setImageDrawable(cVar2.Uqn.getPlaceholderDrawable());
            } else {
                a.b.d(cVar2.Uqn, parcelableFestivalWish2.username, 0.5f);
            }
            com.tencent.mm.plugin.festival.c.j jVar = com.tencent.mm.plugin.festival.c.j.UGJ;
            TextView textView = cVar2.pIN;
            Context f2 = c.f(this.Uqp);
            p.g(f2, "context");
            com.tencent.mm.plugin.festival.c.j.g(textView, f2.getResources().getString(R.string.j8c, parcelableFestivalWish2.iEB));
            com.tencent.mm.plugin.festival.c.j jVar2 = com.tencent.mm.plugin.festival.c.j.UGJ;
            com.tencent.mm.plugin.festival.c.j.g(cVar2.Uqo, parcelableFestivalWish2.UzN);
            AppMethodBeat.o(262009);
        }

        /* Return type fixed from 'com.tencent.mm.plugin.festival.ui.view.c$a$a' to match base method */
        @Override // com.tencent.mm.plugin.festival.ui.view.c.a
        public final /* synthetic */ C1062c r(ViewGroup viewGroup) {
            AppMethodBeat.i(262008);
            p.h(viewGroup, "parent");
            c cVar = this.Uqp;
            View inflate = LayoutInflater.from(c.f(this.Uqp)).inflate(R.layout.ce1, viewGroup, false);
            p.g(inflate, "LayoutInflater.from(cont…em_layout, parent, false)");
            C1062c cVar2 = new C1062c(cVar, inflate);
            AppMethodBeat.o(262008);
            return cVar2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasDanmakuPlugin$FestivalDanmakuViewHolder;", "Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract$Adapter$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasDanmakuPlugin;Landroid/view/View;)V", "avatarIv", "Lcom/tencent/mm/plugin/festival/ui/view/FestivalCdnImageView;", "getAvatarIv", "()Lcom/tencent/mm/plugin/festival/ui/view/FestivalCdnImageView;", "nicknameTv", "Landroid/widget/TextView;", "getNicknameTv", "()Landroid/widget/TextView;", "wishTv", "getWishTv", "plugin-festival_release"})
    /* renamed from: com.tencent.mm.plugin.festival.finder.c$c  reason: collision with other inner class name */
    public final class C1062c extends c.a.C1083a {
        final FestivalCdnImageView Uqn;
        final TextView Uqo;
        final /* synthetic */ c Uqp;
        final TextView pIN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1062c(c cVar, final View view) {
            super(view);
            p.h(view, "itemView");
            this.Uqp = cVar;
            AppMethodBeat.i(262005);
            View findViewById = view.findViewById(R.id.x1);
            ((FestivalCdnImageView) findViewById).setShowCircleImage(true);
            p.g(findViewById, "itemView.findViewById<Fe… showCircleImage = true }");
            this.Uqn = (FestivalCdnImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.fzg);
            p.g(findViewById2, "itemView.findViewById(R.id.nickname_tv)");
            this.pIN = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.k3t);
            TextView textView = (TextView) findViewById3;
            textView.setShadowLayer((float) com.tencent.mm.cb.a.fromDPToPix(textView.getContext(), 6), 0.0f, 0.0f, android.support.v4.content.b.n(textView.getContext(), R.color.agk));
            p.g(findViewById3, "itemView.findViewById<Te…low_color))\n            }");
            this.Uqo = (TextView) findViewById3;
            view.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.festival.finder.c.C1062c.AnonymousClass1 */
                final /* synthetic */ C1062c Uqq;

                {
                    this.Uqq = r1;
                }

                public final void onClick(View view) {
                    String str;
                    AppMethodBeat.i(262004);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalCanvasDanmakuPlugin$FestivalDanmakuViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Object tag = view.getTag(R.id.jvc);
                    if (!(tag instanceof ParcelableFestivalWish)) {
                        tag = null;
                    }
                    ParcelableFestivalWish parcelableFestivalWish = (ParcelableFestivalWish) tag;
                    if (parcelableFestivalWish != null) {
                        if (!this.Uqq.Uqp.Uqd.pbB) {
                            this.Uqq.UEZ.set(this.Uqq.Uqp.Uqk.getLastTouchUpPointRaw());
                        }
                        com.tencent.mm.plugin.festival.model.a.a aVar = com.tencent.mm.plugin.festival.model.a.a.UzS;
                        p.h(parcelableFestivalWish, "wishInfo");
                        of PF = new of().PF(com.tencent.mm.plugin.festival.model.a.a.hRU());
                        com.tencent.mm.plugin.festival.model.a.b bVar2 = com.tencent.mm.plugin.festival.model.a.b.UzX;
                        of TA = PF.GK(com.tencent.mm.plugin.festival.model.a.b.hRV()).TA(parcelableFestivalWish.UzM);
                        if (parcelableFestivalWish.hRT()) {
                            str = parcelableFestivalWish.username;
                        } else {
                            str = parcelableFestivalWish.UzO;
                        }
                        TA.Tz(str).SM(1).SR(2).bfK();
                        com.tencent.mm.live.c.b bVar3 = this.Uqq.Uqp.hOp;
                        b.c cVar = b.c.wsX;
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("PARAM_FESTIVAL_FINDER_LIVE_PERSONAL_WISH_DATA_MODEL", parcelableFestivalWish);
                        if (!Float.isNaN(this.Uqq.UEZ.x) && !Float.isNaN(this.Uqq.UEZ.y)) {
                            bundle.putParcelable("PARAM_FESTIVAL_FINDER_LIVE_PERSONAL_WISH_ANIM_START_POINT", this.Uqq.UEZ);
                        }
                        bundle.putBoolean("PARAM_FESTIVAL_FINDER_LIVE_PERSONAL_WISH_CAN_JUMP_CONTACT_PROFILE", true);
                        bVar3.statusChange(cVar, bundle);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalCanvasDanmakuPlugin$FestivalDanmakuViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(262004);
                }
            });
            AppMethodBeat.o(262005);
        }
    }

    @Override // com.tencent.mm.plugin.festival.model.ag
    public final int dCX() {
        return 2;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B5\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasDanmakuPlugin$DiffCallback;", "Landroid/support/v7/util/DiffUtil$Callback;", "oldList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/festival/model/ParcelableFestivalWish;", "Lkotlin/collections/ArrayList;", "newList", "(Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "areContentsTheSame", "", "oldIndex", "", "newIndex", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-festival_release"})
    public static final class b extends c.a {
        private final ArrayList<ParcelableFestivalWish> Sor;
        private final ArrayList<ParcelableFestivalWish> Uqm;

        public b(ArrayList<ParcelableFestivalWish> arrayList, ArrayList<ParcelableFestivalWish> arrayList2) {
            p.h(arrayList, "oldList");
            p.h(arrayList2, "newList");
            AppMethodBeat.i(262003);
            this.Uqm = arrayList;
            this.Sor = arrayList2;
            AppMethodBeat.o(262003);
        }

        @Override // android.support.v7.h.c.a
        public final int aB() {
            AppMethodBeat.i(261999);
            int size = this.Uqm.size();
            AppMethodBeat.o(261999);
            return size;
        }

        @Override // android.support.v7.h.c.a
        public final int aC() {
            AppMethodBeat.i(262000);
            int size = this.Sor.size();
            AppMethodBeat.o(262000);
            return size;
        }

        @Override // android.support.v7.h.c.a
        public final boolean i(int i2, int i3) {
            AppMethodBeat.i(262001);
            boolean j2 = p.j(this.Uqm.get(i2).UzM, this.Sor.get(i3).UzM);
            AppMethodBeat.o(262001);
            return j2;
        }

        @Override // android.support.v7.h.c.a
        public final boolean j(int i2, int i3) {
            AppMethodBeat.i(262002);
            boolean j2 = p.j(this.Uqm.get(i2).UzM, this.Sor.get(i3).UzM);
            AppMethodBeat.o(262002);
            return j2;
        }
    }

    @Override // com.tencent.mm.plugin.festival.finder.bo
    public final /* bridge */ /* synthetic */ bo.a dsw() {
        return this.Uqf;
    }

    public static final /* synthetic */ Context f(c cVar) {
        AppMethodBeat.i(262030);
        Context context = cVar.Uqj.getContext();
        AppMethodBeat.o(262030);
        return context;
    }
}
