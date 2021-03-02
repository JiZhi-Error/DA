package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.as;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001c\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00182\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u000fJ\u000e\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u0015J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010%\u001a\u00020\u000fJ\b\u0010&\u001a\u00020\u000fH\u0002J\b\u0010'\u001a\u00020\u000fH\u0016J\u0010\u0010(\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000fH\u0016J\u0010\u0010)\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000fH\u0002J\u0006\u0010\u0010\u001a\u00020\u000fJ\u0018\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u000fH\u0016J\u0018\u0010,\u001a\u00020\u00022\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000fH\u0016J\u0010\u00100\u001a\u00020\u001c2\b\u00101\u001a\u0004\u0018\u00010\nJ\u0014\u00102\u001a\u00020\u001c2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00150\u0018J\u001e\u00104\u001a\u00020\u001c2\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016J\u000e\u00106\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u0012R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0005R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0016X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00188\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R&\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u00168\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u00069"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "avatarItems", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mm/plugin/multitalk/data/MultitalkAvatarViewData;", "avatarViewManager", "Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManager;", "getContext", "()Landroid/content/Context;", "setContext", "footerCount", "", "headerCount", "isFooterShow", "", "mAvatarItemHasBeenShow", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "mCurrentScreenSize", "Ljava/util/ArrayList;", "mCurrentVideoSize", "mIs2GOr3G", "addMember", "", "members", "Lcom/tencent/pb/talkroom/sdk/MultiTalkGroupMember;", "clickListener", "Landroid/view/View$OnClickListener;", "checkIsAvatarContent", "position", "findChildIndexByUsername", "userName", "getAvatarCount", "getAvatarWidth", "getItemCount", "getItemViewType", "getMarginWidth", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", FirebaseAnalytics.b.INDEX, "registerAvatarManager", "manager", "setCurrentScreenSet", "currentScreenSet", "setCurrentVideoSet", "currentVideoSet", "setIs2GOr3G", "is2GOr3G", "Companion", "plugin-multitalk_release"})
public final class a extends RecyclerView.a<b> {
    private static final int tMh = 2;
    private static final int tMi = 3;
    private static final int zQQ = 1;
    public static final C1493a zQR = new C1493a((byte) 0);
    private Context context;
    public final int wqJ = 1;
    public CopyOnWriteArrayList<com.tencent.mm.plugin.multitalk.data.a> zQI = new CopyOnWriteArrayList<>();
    public boolean zQJ;
    public HashSet<String> zQK;
    public ArrayList<String> zQL;
    private HashSet<String> zQM;
    private boolean zQN;
    int zQO = 1;
    public com.tencent.mm.plugin.multitalk.model.a zQP;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "usrName", "", "invoke"})
    static final class b extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ a zQS;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar) {
            super(1);
            this.zQS = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            T t;
            HashSet hashSet;
            AppMethodBeat.i(239757);
            String str2 = str;
            p.h(str2, "usrName");
            Iterator<T> it = this.zQS.zQI.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                T next = it.next();
                T t2 = next;
                if (p.j(t2 != null ? t2.nickName : null, str2)) {
                    t = next;
                    break;
                }
            }
            T t3 = t;
            if (!(t3 == null || (hashSet = this.zQS.zQM) == null)) {
                hashSet.add(t3.zHg.RHb);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(239757);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "usrName", "", "invoke"})
    static final class c extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ a zQS;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar) {
            super(1);
            this.zQS = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            T t;
            HashSet hashSet;
            AppMethodBeat.i(239758);
            String str2 = str;
            p.h(str2, "usrName");
            Iterator<T> it = this.zQS.zQI.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                T next = it.next();
                T t2 = next;
                if (p.j(t2 != null ? t2.nickName : null, str2)) {
                    t = next;
                    break;
                }
            }
            T t3 = t;
            if (!(t3 == null || (hashSet = this.zQS.zQM) == null)) {
                hashSet.add(t3.zHg.RHb);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(239758);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "usrName", "", "invoke"})
    static final class d extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ a zQS;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(a aVar) {
            super(1);
            this.zQS = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            T t;
            HashSet hashSet;
            AppMethodBeat.i(239759);
            String str2 = str;
            p.h(str2, "usrName");
            Iterator<T> it = this.zQS.zQI.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                T next = it.next();
                T t2 = next;
                if (p.j(t2 != null ? t2.nickName : null, str2)) {
                    t = next;
                    break;
                }
            }
            T t3 = t;
            if (!(t3 == null || (hashSet = this.zQS.zQM) == null)) {
                hashSet.add(t3.zHg.RHb);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(239759);
            return xVar;
        }
    }

    public a(Context context2) {
        p.h(context2, "context");
        AppMethodBeat.i(178964);
        this.context = context2;
        AppMethodBeat.o(178964);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ b a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(178957);
        p.h(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.b54, viewGroup, false);
        p.g(inflate, "LayoutInflater.from(cont…atar_cell, parent, false)");
        b bVar = new b(inflate);
        AppMethodBeat.o(178957);
        return bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01be, code lost:
        if (kotlin.a.j.a(r0, (r1 == null || (r1 = r1.zHg) == null) ? null : r1.RHb) != true) goto L_0x01c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f7, code lost:
        if (kotlin.a.j.a(r0, r1) != true) goto L_0x00f9;
     */
    @Override // android.support.v7.widget.RecyclerView.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void a(com.tencent.mm.plugin.multitalk.ui.widget.b r11, int r12) {
        /*
        // Method dump skipped, instructions count: 780
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.ui.widget.a.a(android.support.v7.widget.RecyclerView$v, int):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutAdapter$Companion;", "", "()V", "VIEW_TYPE_FOOTER", "", "VIEW_TYPE_HEADER", "VIEW_TYPE_ITEM", "plugin-multitalk_release"})
    /* renamed from: com.tencent.mm.plugin.multitalk.ui.widget.a$a  reason: collision with other inner class name */
    public static final class C1493a {
        private C1493a() {
        }

        public /* synthetic */ C1493a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(178965);
        AppMethodBeat.o(178965);
    }

    public final synchronized void a(ArrayList<MultiTalkGroupMember> arrayList, View.OnClickListener onClickListener) {
        com.tencent.mm.plugin.multitalk.data.a aVar;
        String str;
        String str2;
        ArrayList<String> arrayList2;
        int i2 = 0;
        synchronized (this) {
            AppMethodBeat.i(178954);
            p.h(arrayList, "members");
            p.h(onClickListener, "clickListener");
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            HashSet<String> hashSet = new HashSet<>();
            for (T t : arrayList) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    j.hxH();
                }
                T t2 = t;
                HashSet<String> hashSet2 = this.zQK;
                if (((hashSet2 == null || !hashSet2.contains(t2.RHb)) && ((arrayList2 = this.zQL) == null || !arrayList2.contains(t2.RHb))) || this.zQJ) {
                    com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                    p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
                    as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(t2.RHb);
                    if (Kn == null || (str = Kn.arI()) == null) {
                        str = t2.RHb;
                        p.g(str, "member.usrName");
                    }
                    aVar = new com.tencent.mm.plugin.multitalk.data.a(t2, onClickListener, i2, false, str);
                } else {
                    com.tencent.mm.kernel.c.a af2 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                    p.g(af2, "MMKernel.service(IMessengerStorage::class.java)");
                    as Kn2 = ((com.tencent.mm.plugin.messenger.foundation.a.l) af2).aSN().Kn(t2.RHb);
                    if (Kn2 == null || (str2 = Kn2.arI()) == null) {
                        str2 = t2.RHb;
                        p.g(str2, "member.usrName");
                    }
                    aVar = new com.tencent.mm.plugin.multitalk.data.a(t2, onClickListener, i2, true, str2);
                }
                HashSet<String> hashSet3 = this.zQM;
                if (hashSet3 != null && hashSet3.contains(t2.RHb)) {
                    hashSet.add(t2.RHb);
                }
                copyOnWriteArrayList.add(aVar);
                i2 = i3;
            }
            this.zQM = hashSet;
            synchronized (this.zQI) {
                try {
                    this.zQI.clear();
                    this.zQI.addAll(copyOnWriteArrayList);
                    notifyDataSetChanged();
                    x xVar = x.SXb;
                } finally {
                    AppMethodBeat.o(178954);
                }
            }
        }
    }

    public final void c(HashSet<String> hashSet) {
        AppMethodBeat.i(178956);
        p.h(hashSet, "currentVideoSet");
        this.zQK = hashSet;
        AppMethodBeat.o(178956);
    }

    public final void aA(ArrayList<String> arrayList) {
        AppMethodBeat.i(239760);
        p.h(arrayList, "currentScreenSet");
        this.zQL = arrayList;
        AppMethodBeat.o(239760);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(178958);
        if (i2 == 0) {
            int i3 = tMh;
            AppMethodBeat.o(178958);
            return i3;
        } else if (i2 != getItemCount() - 1) {
            int i4 = zQQ;
            AppMethodBeat.o(178958);
            return i4;
        } else if (this.zQN) {
            int i5 = tMi;
            AppMethodBeat.o(178958);
            return i5;
        } else {
            int i6 = zQQ;
            AppMethodBeat.o(178958);
            return i6;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(178959);
        if (this.zQI.size() > 12) {
            this.zQN = true;
            this.zQO = 1;
            int size = this.zQI.size() + this.wqJ + this.zQO;
            AppMethodBeat.o(178959);
            return size;
        }
        this.zQN = false;
        this.zQO = 0;
        int size2 = this.zQI.size() + this.wqJ;
        AppMethodBeat.o(178959);
        return size2;
    }

    public final boolean Rn(int i2) {
        AppMethodBeat.i(178960);
        if (i2 < this.wqJ || i2 > (getItemCount() - this.zQO) - 1) {
            AppMethodBeat.o(178960);
            return true;
        }
        AppMethodBeat.o(178960);
        return false;
    }

    private int eoy() {
        AppMethodBeat.i(178961);
        int itemCount = (getItemCount() - this.wqJ) - this.zQO;
        AppMethodBeat.o(178961);
        return itemCount;
    }

    private final int eoz() {
        AppMethodBeat.i(178962);
        int jo = com.tencent.mm.cb.a.jo(this.context) - com.tencent.mm.cb.a.fromDPToPix(this.context, (int) com.tencent.mm.plugin.appbrand.jsapi.pay.q.CTRL_INDEX);
        int jn = com.tencent.mm.cb.a.jn(this.context);
        if (jo > jn) {
            if (eoy() < 5) {
                int i2 = jn / 2;
                AppMethodBeat.o(178962);
                return i2;
            }
            int i3 = jn / 3;
            AppMethodBeat.o(178962);
            return i3;
        } else if (eoy() < 5) {
            int i4 = jo / 2;
            AppMethodBeat.o(178962);
            return i4;
        } else {
            int i5 = jo / 3;
            AppMethodBeat.o(178962);
            return i5;
        }
    }

    private final int Ro(int i2) {
        AppMethodBeat.i(239761);
        switch (eoy()) {
            case 3:
                if (i2 == 2) {
                    int eoz = eoz() / 2;
                    AppMethodBeat.o(239761);
                    return eoz;
                }
                AppMethodBeat.o(239761);
                return 0;
            default:
                AppMethodBeat.o(239761);
                return 0;
        }
    }
}
