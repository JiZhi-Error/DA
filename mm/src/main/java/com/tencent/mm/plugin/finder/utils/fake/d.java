package com.tencent.mm.plugin.finder.utils.fake;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.fake.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftSingleDebug;", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "commandList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockUtil$MockCommand;", "show", "", "Companion", "plugin-finder_release"})
public final class d {
    private static final String TAG = TAG;
    public static final a waW = new a((byte) 0);
    public final MMActivity activity;
    private final LinkedList<c.d> waJ = new LinkedList<>();

    public d(MMActivity mMActivity) {
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(253855);
        this.activity = mMActivity;
        AppMethodBeat.o(253855);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftSingleDebug$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(253856);
        AppMethodBeat.o(253856);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class b implements o.f {
        final /* synthetic */ d waX;

        public b(d dVar) {
            this.waX = dVar;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(253854);
            p.g(mVar, LocaleUtil.ITALIAN);
            if (mVar.gKQ()) {
                mVar.d(1, "爱心*1").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) {
                    /* class com.tencent.mm.plugin.finder.utils.fake.d.b.AnonymousClass1 */
                    final /* synthetic */ b waY;

                    {
                        this.waY = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        c.d dVar;
                        AppMethodBeat.i(253847);
                        LinkedList linkedList = this.waY.waX.waJ;
                        c cVar = c.waP;
                        c.AbstractC1316c cVar2 = c.dEK().get(e.LOVE);
                        if (cVar2 != null) {
                            dVar = cVar2.Ma(1);
                        } else {
                            dVar = null;
                        }
                        linkedList.offerLast(dVar);
                        c cVar3 = c.waP;
                        c.eD(this.waY.waX.waJ);
                        AppMethodBeat.o(253847);
                        return true;
                    }
                });
                mVar.d(2, "鼓掌*2").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) {
                    /* class com.tencent.mm.plugin.finder.utils.fake.d.b.AnonymousClass2 */
                    final /* synthetic */ b waY;

                    {
                        this.waY = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(253848);
                        LinkedList linkedList = this.waY.waX.waJ;
                        c cVar = c.waP;
                        c.AbstractC1316c cVar2 = c.dEK().get(e.CLAP);
                        linkedList.offerLast(cVar2 != null ? cVar2.Ma(2) : null);
                        c cVar3 = c.waP;
                        c.eD(this.waY.waX.waJ);
                        AppMethodBeat.o(253848);
                        return true;
                    }
                });
                mVar.d(3, "小花*3").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) {
                    /* class com.tencent.mm.plugin.finder.utils.fake.d.b.AnonymousClass3 */
                    final /* synthetic */ b waY;

                    {
                        this.waY = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(253849);
                        LinkedList linkedList = this.waY.waX.waJ;
                        c cVar = c.waP;
                        c.AbstractC1316c cVar2 = c.dEK().get(e.FLOWER);
                        linkedList.offerLast(cVar2 != null ? cVar2.Ma(3) : null);
                        c cVar3 = c.waP;
                        c.eD(this.waY.waX.waJ);
                        AppMethodBeat.o(253849);
                        return true;
                    }
                });
                mVar.d(4, "奶茶*4").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) {
                    /* class com.tencent.mm.plugin.finder.utils.fake.d.b.AnonymousClass4 */
                    final /* synthetic */ b waY;

                    {
                        this.waY = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(253850);
                        LinkedList linkedList = this.waY.waX.waJ;
                        c cVar = c.waP;
                        c.AbstractC1316c cVar2 = c.dEK().get(e.HEYTEA);
                        linkedList.offerLast(cVar2 != null ? cVar2.Ma(4) : null);
                        c cVar3 = c.waP;
                        c.eD(this.waY.waX.waJ);
                        AppMethodBeat.o(253850);
                        return true;
                    }
                });
                mVar.d(5, "打call*1").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) {
                    /* class com.tencent.mm.plugin.finder.utils.fake.d.b.AnonymousClass5 */
                    final /* synthetic */ b waY;

                    {
                        this.waY = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        c.d dVar;
                        AppMethodBeat.i(253851);
                        LinkedList linkedList = this.waY.waX.waJ;
                        c cVar = c.waP;
                        c.AbstractC1316c cVar2 = c.dEK().get(e.CALL666);
                        if (cVar2 != null) {
                            dVar = cVar2.Ma(1);
                        } else {
                            dVar = null;
                        }
                        linkedList.offerLast(dVar);
                        c cVar3 = c.waP;
                        c.eD(this.waY.waX.waJ);
                        AppMethodBeat.o(253851);
                        return true;
                    }
                });
                mVar.d(6, "火箭*1").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) {
                    /* class com.tencent.mm.plugin.finder.utils.fake.d.b.AnonymousClass6 */
                    final /* synthetic */ b waY;

                    {
                        this.waY = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        c.d dVar;
                        AppMethodBeat.i(253852);
                        LinkedList linkedList = this.waY.waX.waJ;
                        c cVar = c.waP;
                        c.AbstractC1316c cVar2 = c.dEK().get(e.ROCKET);
                        if (cVar2 != null) {
                            dVar = cVar2.Ma(1);
                        } else {
                            dVar = null;
                        }
                        linkedList.offerLast(dVar);
                        c cVar3 = c.waP;
                        c.eD(this.waY.waX.waJ);
                        AppMethodBeat.o(253852);
                        return true;
                    }
                });
                mVar.d(7, "桃花岛*1").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) {
                    /* class com.tencent.mm.plugin.finder.utils.fake.d.b.AnonymousClass7 */
                    final /* synthetic */ b waY;

                    {
                        this.waY = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        c.d dVar;
                        AppMethodBeat.i(253853);
                        LinkedList linkedList = this.waY.waX.waJ;
                        c cVar = c.waP;
                        c.AbstractC1316c cVar2 = c.dEK().get(e.ISLAND);
                        if (cVar2 != null) {
                            dVar = cVar2.Ma(1);
                        } else {
                            dVar = null;
                        }
                        linkedList.offerLast(dVar);
                        c cVar3 = c.waP;
                        c.eD(this.waY.waX.waJ);
                        AppMethodBeat.o(253853);
                        return true;
                    }
                });
            }
            AppMethodBeat.o(253854);
        }
    }
}
