package com.tencent.mm.plugin.scanner.ui.widget;

import android.content.Context;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 22\u00020\u0001:\u000223B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J\u0006\u0010\u001c\u001a\u00020\u0017J\u000e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0013J\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0013J\u0014\u0010 \u001a\u00020\u00172\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\"J\u000e\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0007J\u0018\u0010,\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010-\u001a\u00020\u0007J\u0006\u0010.\u001a\u00020\u0017J\u0010\u0010/\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J\u0006\u00100\u001a\u00020\u0017J\u0006\u00101\u001a\u00020\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\nj\b\u0012\u0004\u0012\u00020\u000e`\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "scanTabIdToIndex", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "scanTabInfos", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabController$ScanTabInfo;", "Lkotlin/collections/ArrayList;", "scrollTabList", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScrollTab;", "scrollTabView", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabView;", "selectedIndex", "addTab", "", FirebaseAnalytics.b.INDEX, "scanTab", "attachScrollTabView", "", "enableScanGoods", "enableTranslation", "getScanTabById", "tabId", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "setEnable", "enable", "setEnableSwitchTab", "setEnableTab", "tabIdList", "", "setOnTabClickListener", "tabOnClickListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnClickListener;", "setOnTabScrollListener", "tabOnScrollListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnScrollListener;", "setOnTabSelectedListener", "tabOnSelectedListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnSelectedListener;", "setSelectedTab", "tabSelectedAction", "show", "showTab", "switchNextTab", "switchPreviousTab", "Companion", "ScanTabInfo", "plugin-scan_release"})
public final class b {
    public static final a CSt = new a((byte) 0);
    public ScanScrollTabView CSp;
    public ArrayList<a> CSq = new ArrayList<>();
    public final ArrayList<C1678b> CSr;
    private HashMap<Integer, Integer> CSs;
    private int bxP = -1;
    private final Context context;

    static {
        AppMethodBeat.i(52442);
        AppMethodBeat.o(52442);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabController$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public b(Context context2) {
        p.h(context2, "context");
        AppMethodBeat.i(52441);
        this.context = context2;
        String string = this.context.getString(R.string.gbt);
        p.g(string, "context.getString(R.string.scan_entry_qbar)");
        String string2 = this.context.getString(R.string.gbo);
        p.g(string2, "context.getString(R.string.scan_entry_goods)");
        String string3 = this.context.getString(R.string.gbs);
        p.g(string3, "context.getString(R.string.scan_entry_ocr)");
        this.CSr = j.ac(new C1678b(1, string), new C1678b(12, string2), new C1678b(3, string3));
        this.CSs = new HashMap<>();
        AppMethodBeat.o(52441);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabController$attachScrollTabView$1", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnScrollListener;", "onScroll", "", "currentIndex", "", "offsetX", "", "offsetY", "onScrollStateChanged", "state", "plugin-scan_release"})
    public static final class c implements d {
        @Override // com.tencent.mm.plugin.scanner.ui.widget.d
        public final void u(int i2, float f2) {
            AppMethodBeat.i(52432);
            Log.d("MicroMsg.ScanScrollTabController", "alvinluo onScroll currentIndex: %d, offsetX: %f, offsetY: %f", Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(0.0f));
            AppMethodBeat.o(52432);
        }

        @Override // com.tencent.mm.plugin.scanner.ui.widget.d
        public final void onScrollStateChanged(int i2) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabController$setOnTabSelectedListener$tabOnSelectedListenerWrapper$1", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnSelectedListener;", "onTabSelected", "", "tabId", "", "tabSelectedAction", "onTabUnSelected", "plugin-scan_release"})
    public static final class d implements e {
        final /* synthetic */ b CSw;
        final /* synthetic */ e CSx;

        public d(b bVar, e eVar) {
            this.CSw = bVar;
            this.CSx = eVar;
        }

        @Override // com.tencent.mm.plugin.scanner.ui.widget.e
        /* renamed from: if  reason: not valid java name */
        public final void m29if(int i2, int i3) {
            AppMethodBeat.i(52433);
            Integer num = (Integer) this.CSw.CSs.get(Integer.valueOf(i2));
            if (num != null) {
                this.CSw.bxP = num.intValue();
            }
            this.CSx.m30if(i2, i3);
            AppMethodBeat.o(52433);
        }

        @Override // com.tencent.mm.plugin.scanner.ui.widget.e
        public final void WQ(int i2) {
            AppMethodBeat.i(52434);
            this.CSx.WQ(i2);
            AppMethodBeat.o(52434);
        }
    }

    public final void ii(int i2, int i3) {
        AppMethodBeat.i(240672);
        Integer num = this.CSs.get(Integer.valueOf(i2));
        Log.i("MicroMsg.ScanScrollTabController", "alvinluo setSelectedTab tabId: %d, index: %s, tabSelectedAction: %d", Integer.valueOf(i2), num, Integer.valueOf(i3));
        if (num != null) {
            this.bxP = num.intValue();
            ScanScrollTabView scanScrollTabView = this.CSp;
            if (scanScrollTabView != null) {
                scanScrollTabView.ii(num.intValue(), i3);
                AppMethodBeat.o(240672);
                return;
            }
        }
        AppMethodBeat.o(240672);
    }

    public final void gE(List<Integer> list) {
        T t;
        int i2;
        AppMethodBeat.i(240673);
        p.h(list, "tabIdList");
        Log.v("MicroMsg.ScanScrollTabController", "alvinluo setEnableTab tabIdList size: %d", Integer.valueOf(list.size()));
        ScanScrollTabView scanScrollTabView = this.CSp;
        if (scanScrollTabView != null) {
            scanScrollTabView.removeAllTabs();
        }
        this.CSq.clear();
        Iterator<T> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            Log.v("MicroMsg.ScanScrollTabController", "alvinluo setEnableTab tabId: %d", Integer.valueOf(intValue));
            Iterator<T> it2 = this.CSr.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    t = null;
                    break;
                }
                t = it2.next();
                if (t.CSu == intValue) {
                    break;
                }
            }
            if (t == null) {
                AppMethodBeat.o(240673);
                return;
            }
            if (a(i3, t)) {
                i2 = i3 + 1;
            } else {
                i2 = i3;
            }
            i3 = i2;
        }
        AppMethodBeat.o(240673);
    }

    public final void eRD() {
        AppMethodBeat.i(52437);
        int i2 = this.bxP + 1;
        Log.d("MicroMsg.ScanScrollTabController", "alvinluo switchNextTab selectedIndex: %d, nextIndex: %d", Integer.valueOf(this.bxP), Integer.valueOf(i2));
        if (i2 >= 0 && i2 < this.CSq.size()) {
            this.bxP = i2;
            ScanScrollTabView scanScrollTabView = this.CSp;
            if (scanScrollTabView != null) {
                scanScrollTabView.ii(i2, 3);
                AppMethodBeat.o(52437);
                return;
            }
        }
        AppMethodBeat.o(52437);
    }

    public final void eRE() {
        AppMethodBeat.i(52438);
        int i2 = this.bxP - 1;
        Log.d("MicroMsg.ScanScrollTabController", "alvinluo switchPreviousTab selectedIndex: %d, previousIndex: %d", Integer.valueOf(this.bxP), Integer.valueOf(i2));
        if (i2 >= 0 && i2 < this.CSq.size()) {
            this.bxP = i2;
            ScanScrollTabView scanScrollTabView = this.CSp;
            if (scanScrollTabView != null) {
                scanScrollTabView.ii(i2, 3);
                AppMethodBeat.o(52438);
                return;
            }
        }
        AppMethodBeat.o(52438);
    }

    public final void setEnableSwitchTab(boolean z) {
        AppMethodBeat.i(52439);
        Log.i("MicroMsg.ScanScrollTabController", "alvinluo setEnableSwitchTab enable: %b", Boolean.valueOf(z));
        ScanScrollTabView scanScrollTabView = this.CSp;
        if (scanScrollTabView != null) {
            scanScrollTabView.setEnableSwitchTab(z);
            AppMethodBeat.o(52439);
            return;
        }
        AppMethodBeat.o(52439);
    }

    private static boolean WX(int i2) {
        AppMethodBeat.i(52440);
        if (i2 == 3 && !r.eSd()) {
            AppMethodBeat.o(52440);
            return false;
        } else if (i2 != 12 || r.eSf()) {
            AppMethodBeat.o(52440);
            return true;
        } else {
            AppMethodBeat.o(52440);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabController$ScanTabInfo;", "", "scanTabId", "", "scanTabTitle", "", "(ILjava/lang/String;)V", "getScanTabId", "()I", "getScanTabTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-scan_release"})
    /* renamed from: com.tencent.mm.plugin.scanner.ui.widget.b$b  reason: collision with other inner class name */
    public static final class C1678b {
        final int CSu;
        final String CSv;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
            if (kotlin.g.b.p.j(r3.CSv, r4.CSv) != false) goto L_0x001e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 52431(0xcccf, float:7.3471E-41)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x001e
                boolean r0 = r4 instanceof com.tencent.mm.plugin.scanner.ui.widget.b.C1678b
                if (r0 == 0) goto L_0x0023
                com.tencent.mm.plugin.scanner.ui.widget.b$b r4 = (com.tencent.mm.plugin.scanner.ui.widget.b.C1678b) r4
                int r0 = r3.CSu
                int r1 = r4.CSu
                if (r0 != r1) goto L_0x0023
                java.lang.String r0 = r3.CSv
                java.lang.String r1 = r4.CSv
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0023
            L_0x001e:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0022:
                return r0
            L_0x0023:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0022
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.ui.widget.b.C1678b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(52430);
            int i2 = this.CSu * 31;
            String str = this.CSv;
            int hashCode = (str != null ? str.hashCode() : 0) + i2;
            AppMethodBeat.o(52430);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(52429);
            String str = "ScanTabInfo(scanTabId=" + this.CSu + ", scanTabTitle=" + this.CSv + ")";
            AppMethodBeat.o(52429);
            return str;
        }

        public C1678b(int i2, String str) {
            p.h(str, "scanTabTitle");
            AppMethodBeat.i(52428);
            this.CSu = i2;
            this.CSv = str;
            AppMethodBeat.o(52428);
        }
    }

    public final boolean a(int i2, C1678b bVar) {
        AppMethodBeat.i(52435);
        if (!WX(bVar.CSu)) {
            Log.w("MicroMsg.ScanScrollTabController", "alvinluo initTabs tabId: %d not show", Integer.valueOf(bVar.CSu));
            AppMethodBeat.o(52435);
            return false;
        } else if (bVar.CSu == 12 && WeChatBrands.Business.Entries.DiscoveryScanRecognize.restricted()) {
            AppMethodBeat.o(52435);
            return false;
        } else if (bVar.CSu != 3 || !WeChatBrands.Business.Entries.DiscoveryScanTranslate.restricted()) {
            ScrollTab scrollTab = new ScrollTab(this.context);
            scrollTab.setTabId(bVar.CSu);
            scrollTab.setTabTitle(bVar.CSv);
            this.CSs.put(Integer.valueOf(bVar.CSu), Integer.valueOf(i2));
            this.CSq.add(scrollTab);
            ScanScrollTabView scanScrollTabView = this.CSp;
            if (scanScrollTabView != null) {
                scanScrollTabView.b(scrollTab);
            }
            Log.i("MicroMsg.ScanScrollTabController", "alvinluo addTab index: %d, tabId: %d", Integer.valueOf(i2), Integer.valueOf(bVar.CSu));
            AppMethodBeat.o(52435);
            return true;
        } else {
            AppMethodBeat.o(52435);
            return false;
        }
    }
}
