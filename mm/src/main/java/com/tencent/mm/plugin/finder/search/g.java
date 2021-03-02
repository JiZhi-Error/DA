package com.tencent.mm.plugin.finder.search;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.share.internal.ShareConstants;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.cgi.cp;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.bai;
import com.tencent.mm.protocal.protobuf.bbv;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.av;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 32\u00020\u0001:\u00043456B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0006\u0010\u001a\u001a\u00020\u0007J\u0018\u0010\u001b\u001a\u00020\u00072\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001dH\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u0010H\u0002J\b\u0010!\u001a\u00020\u0010H\u0002J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\u0007J\u0006\u0010%\u001a\u00020\u0007J\u0018\u0010&\u001a\u00020\u00072\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0012H\u0002J,\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00102\b\u0010*\u001a\u0004\u0018\u00010\u001f2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0006\u0010-\u001a\u00020\u0007J\u0006\u0010.\u001a\u00020\u0007J\u0006\u0010/\u001a\u00020\u0007J\b\u00100\u001a\u00020\u0007H\u0002J\u0010\u00101\u001a\u00020#2\b\b\u0002\u00102\u001a\u00020#R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00060\u0016R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u00067"}, hxF = {"Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "onHotWordClickListener", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "", "(Lcom/tencent/mm/ui/MMActivity;Lkotlin/jvm/functions/Function1;)V", "container", "Landroid/widget/LinearLayout;", "contentList", "Landroid/widget/ListView;", TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, "Landroid/widget/TextView;", "hintGap", "", "hotWordDataList", "", "hotWordNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneGetHotWordList;", "hotWordsAdapter", "Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic$PopularListAdapter;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderSearchGetHotWordListResponse;", "textAvailableWidth", "dismissPopularList", "filterHotWords", "hotWords", "Ljava/util/LinkedList;", "getHotWord", "", "position", "getTextAvailableWidth", "isShowing", "", "onCreate", "onDestroy", "onHotWordsChange", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reportExpose", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "resetBgColor", "showInner", "showPopularList", "refreshUi", "Companion", "HotWordItemHolder", "PopularDataManager", "PopularListAdapter", "plugin-finder_release"})
public final class g implements i {
    public static final a vuP = new a((byte) 0);
    private MMActivity activity;
    LinearLayout tmh;
    private bbv twE;
    private int vuI;
    private int vuJ;
    public cp vuK;
    private TextView vuL;
    private ListView vuM;
    private d vuN = new d();
    private List<? extends bby> vuO;

    static {
        AppMethodBeat.i(251364);
        AppMethodBeat.o(251364);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic$Companion;", "", "()V", "ACTION_TYPE_SEARCH", "", "START_REQUEST_UP_LIMIT", "TAG", "", "UI_UPDATE_LIMIT", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public g(final MMActivity mMActivity, final kotlin.g.a.b<? super bby, x> bVar) {
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(bVar, "onHotWordClickListener");
        AppMethodBeat.i(251363);
        this.activity = mMActivity;
        View findViewById = mMActivity.findViewById(R.id.d0t);
        p.g(findViewById, "activity.findViewById(R.…r_popular_list_container)");
        this.tmh = (LinearLayout) findViewById;
        View findViewById2 = mMActivity.findViewById(R.id.d0v);
        p.g(findViewById2, "activity.findViewById(R.…nder_popular_list_header)");
        this.vuL = (TextView) findViewById2;
        View findViewById3 = mMActivity.findViewById(R.id.d0u);
        p.g(findViewById3, "activity.findViewById(R.…der_popular_list_content)");
        this.vuM = (ListView) findViewById3;
        this.vuM.setAdapter((ListAdapter) this.vuN);
        this.vuM.setOnItemClickListener(new AdapterView.OnItemClickListener(this) {
            /* class com.tencent.mm.plugin.finder.search.g.AnonymousClass1 */
            final /* synthetic */ g vuQ;

            {
                this.vuQ = r1;
            }

            /* JADX WARNING: Removed duplicated region for block: B:10:0x004a  */
            @Override // android.widget.AdapterView.OnItemClickListener
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onItemClick(android.widget.AdapterView<?> r9, android.view.View r10, int r11, long r12) {
                /*
                // Method dump skipped, instructions count: 138
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.search.g.AnonymousClass1.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
            }
        });
        this.tmh.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.finder.search.g.AnonymousClass2 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(251339);
                mMActivity.hideVKB();
                AppMethodBeat.o(251339);
                return false;
            }
        });
        this.vuI = av.az(this.activity).x - com.tencent.mm.cb.a.aG(this.activity, R.dimen.cp);
        this.vuJ = com.tencent.mm.cb.a.aG(mMActivity, R.dimen.c5);
        dpI();
        AppMethodBeat.o(251363);
    }

    public final void onDestroy() {
        AppMethodBeat.i(251353);
        com.tencent.mm.kernel.g.azz().b(4069, this);
        AppMethodBeat.o(251353);
    }

    public final void dpI() {
        AppMethodBeat.i(251354);
        if (this.tmh.getParent() instanceof ViewGroup) {
            ViewParent parent = this.tmh.getParent();
            if (parent == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(251354);
                throw tVar;
            }
            ((ViewGroup) parent).setBackgroundColor(this.activity.getResources().getColor(R.color.BW_93));
        }
        AppMethodBeat.o(251354);
    }

    public final void cnl() {
        AppMethodBeat.i(251355);
        int firstVisiblePosition = this.vuM.getFirstVisiblePosition();
        int lastVisiblePosition = this.vuM.getLastVisiblePosition();
        if (firstVisiblePosition <= lastVisiblePosition) {
            while (true) {
                String KM = KM(firstVisiblePosition);
                if (KM != null) {
                    String j2 = n.j(KM, ",", "$", false);
                    k kVar = k.vfA;
                    FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(this.activity);
                    k.a(j2, firstVisiblePosition, 1, fH != null ? fH.dIx() : null);
                }
                if (firstVisiblePosition == lastVisiblePosition) {
                    break;
                }
                firstVisiblePosition++;
            }
        }
        AppMethodBeat.o(251355);
    }

    private final String KM(int i2) {
        bby bby;
        AppMethodBeat.i(251356);
        List<? extends bby> list = this.vuO;
        if (list != null) {
            if (!(i2 >= 0 && i2 < list.size())) {
                list = null;
            }
            if (!(list == null || (bby = (bby) list.get(i2)) == null)) {
                String str = bby.LLa;
                AppMethodBeat.o(251356);
                return str;
            }
        }
        AppMethodBeat.o(251356);
        return null;
    }

    public final boolean ow(boolean z) {
        List<? extends bby> list;
        AppMethodBeat.i(251357);
        this.tmh.setVisibility(0);
        this.tmh.requestFocus();
        if (z && (this.vuO == null || ((list = this.vuO) != null && list.isEmpty()))) {
            dpK();
        }
        List<? extends bby> list2 = this.vuO;
        if (list2 != null) {
            boolean isEmpty = list2.isEmpty();
            AppMethodBeat.o(251357);
            return isEmpty;
        }
        AppMethodBeat.o(251357);
        return true;
    }

    public final void dpJ() {
        AppMethodBeat.i(251358);
        this.tmh.setVisibility(8);
        AppMethodBeat.o(251358);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0015, code lost:
        if (r0 == null) goto L_0x0017;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dpK() {
        /*
            r3 = this;
            r2 = 251359(0x3d5df, float:3.52229E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            com.tencent.mm.plugin.finder.search.g$c r0 = com.tencent.mm.plugin.finder.search.g.c.vuZ
            java.util.List r0 = com.tencent.mm.plugin.finder.search.g.c.dpS()
            if (r0 == 0) goto L_0x0017
            r1 = 0
            r3.ow(r1)
            r3.eq(r0)
            if (r0 != 0) goto L_0x001c
        L_0x0017:
            r3.dpJ()
            kotlin.x r0 = kotlin.x.SXb
        L_0x001c:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.search.g.dpK():void");
    }

    private final void eq(List<? extends bby> list) {
        AppMethodBeat.i(251360);
        c cVar = c.vuZ;
        c.KN(cl.aWB());
        this.vuO = list;
        Log.i("Finder.FinderPopularListLogic", "onHotWordsChange : " + list + " size: " + (list != null ? list.size() : -1));
        if (list == null) {
            this.tmh.setVisibility(8);
            AppMethodBeat.o(251360);
        } else if (list.isEmpty()) {
            this.tmh.setVisibility(8);
            this.vuN.notifyDataSetChanged();
            AppMethodBeat.o(251360);
        } else {
            this.tmh.setVisibility(0);
            this.vuN.notifyDataSetChanged();
            AppMethodBeat.o(251360);
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        String str2;
        String string;
        AppMethodBeat.i(251361);
        if (i2 == 0 && i3 == 0 && (qVar instanceof cp)) {
            StringBuilder sb = new StringBuilder("onSceneEnd getHotWords : ");
            LinkedList<bby> cZn = ((cp) qVar).cZn();
            Log.i("Finder.FinderPopularListLogic", sb.append(cZn != null ? cZn.size() : -1).append(' ').toString());
            LinkedList<bby> cZn2 = ((cp) qVar).cZn();
            av(cZn2);
            TextView textView = this.vuL;
            bbv bbv = ((cp) qVar).twE;
            if (bbv != null) {
                str2 = bbv.LKZ;
            } else {
                str2 = null;
            }
            if (str2 != null) {
                string = str2;
            } else {
                string = this.activity.getResources().getString(R.string.d8f);
            }
            textView.setText(string);
            eq(cZn2);
            c cVar = c.vuZ;
            if (cZn2 == null) {
                cZn2 = new LinkedList<>();
            }
            p.h(cZn2, "hotWords");
            c.aw(cZn2);
            h.RTc.aX(c.a.vva);
            this.twE = ((cp) qVar).twE;
            cnl();
        }
        AppMethodBeat.o(251361);
    }

    private static void av(LinkedList<bby> linkedList) {
        AppMethodBeat.i(251362);
        if (linkedList != null) {
            Iterator<bby> it = linkedList.iterator();
            p.g(it, "hotWords.iterator()");
            while (it.hasNext()) {
                bby next = it.next();
                p.g(next, "iterator.next()");
                if (next.actionType != 1) {
                    it.remove();
                }
            }
        }
        AppMethodBeat.o(251362);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0012R\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic$PopularListAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "setHotWord", "", "holder", "Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic$HotWordItemHolder;", "Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic;", "hotWordText", "", "recommendReason", "setItemBg", "contentView", "plugin-finder_release"})
    public final class d extends BaseAdapter {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public d() {
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            int i3;
            AppMethodBeat.i(251350);
            if (view == null) {
                if (viewGroup == null) {
                    p.hyc();
                }
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ai3, viewGroup, false);
                b bVar2 = new b();
                View findViewById = view.findViewById(R.id.cmd);
                p.g(findViewById, "contentView.findViewById….id.finder_hot_word_text)");
                TextView textView = (TextView) findViewById;
                p.h(textView, "<set-?>");
                bVar2.krl = textView;
                View findViewById2 = view.findViewById(R.id.cmc);
                p.g(findViewById2, "contentView.findViewById…inder_hot_word_last_line)");
                TextView textView2 = (TextView) findViewById2;
                p.h(textView2, "<set-?>");
                bVar2.vuS = textView2;
                View findViewById3 = view.findViewById(R.id.dpc);
                p.g(findViewById3, "contentView.findViewById(R.id.hint)");
                TextView textView3 = (TextView) findViewById3;
                p.h(textView3, "<set-?>");
                bVar2.vuT = textView3;
                View findViewById4 = view.findViewById(R.id.bsp);
                p.g(findViewById4, "contentView.findViewById(R.id.divider_view)");
                p.h(findViewById4, "<set-?>");
                bVar2.lrc = findViewById4;
                View findViewById5 = view.findViewById(R.id.cmk);
                p.g(findViewById5, "contentView.findViewById…finder_last_line_divider)");
                p.h(findViewById5, "<set-?>");
                bVar2.vuU = findViewById5;
                p.g(view, "contentView");
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                Object tag = view.getTag();
                if (tag == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderPopularListLogic.HotWordItemHolder");
                    AppMethodBeat.o(251350);
                    throw tVar;
                }
                bVar = (b) tag;
            }
            List list = g.this.vuO;
            if (list == null) {
                p.hyc();
            }
            String str = ((bby) list.get(i2)).LLa;
            if (str == null) {
                str = "";
            }
            List list2 = g.this.vuO;
            if (list2 == null) {
                p.hyc();
            }
            String str2 = ((bby) list2.get(i2)).LLc;
            if (Util.isNullOrNil(str2)) {
                bVar.dpL().setVisibility(0);
                bVar.dpL().setText(str);
                bVar.dpM().setVisibility(8);
                bVar.dpN().setVisibility(8);
            } else {
                int i4 = g.this.vuI;
                StaticLayout staticLayout = new StaticLayout(str, 0, str.length(), bVar.dpL().getPaint(), i4, Layout.Alignment.ALIGN_NORMAL, 1.0f, 1.0f, true);
                if (staticLayout.getLineCount() > 0) {
                    int lineCount = staticLayout.getLineCount();
                    staticLayout.getLineEnd(0);
                    if (lineCount > 1) {
                        i3 = staticLayout.getLineEnd(staticLayout.getLineCount() - 2);
                    } else {
                        i3 = 0;
                    }
                    int lineEnd = staticLayout.getLineEnd(staticLayout.getLineCount() - 1);
                    if (str == null) {
                        t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
                        AppMethodBeat.o(251350);
                        throw tVar2;
                    }
                    String substring = str.substring(i3, lineEnd);
                    p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Log.i("Finder.FinderPopularListLogic", "lastLineText :".concat(String.valueOf(substring)));
                    TextPaint paint = bVar.dpM().getPaint();
                    float measureText = paint != null ? paint.measureText(substring, 0, substring.length()) : 0.0f;
                    TextPaint paint2 = bVar.dpN().getPaint();
                    float measureText2 = paint2 != null ? paint2.measureText(str2) : 0.0f;
                    Log.i("Finder.FinderPopularListLogic", "推荐原因不在同一行");
                    bVar.dpN().setVisibility(0);
                    if (measureText + measureText2 + ((float) g.this.vuJ) > ((float) i4)) {
                        bVar.dpL().setText(str);
                        TextView dpM = bVar.dpM();
                        dpM.setText("");
                        dpM.setVisibility(4);
                        bVar.dpP().setVisibility(8);
                        bVar.dpN().setText(str2);
                    } else {
                        Log.i("Finder.FinderPopularListLogic", "推荐原因在同一行");
                        if (lineCount == 1) {
                            bVar.dpL().setVisibility(8);
                        } else {
                            TextView dpL = bVar.dpL();
                            if (str == null) {
                                t tVar3 = new t("null cannot be cast to non-null type java.lang.String");
                                AppMethodBeat.o(251350);
                                throw tVar3;
                            }
                            String substring2 = str.substring(0, i3);
                            p.g(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            dpL.setText(substring2);
                        }
                        TextView dpM2 = bVar.dpM();
                        dpM2.setVisibility(0);
                        dpM2.setText(substring);
                        bVar.dpP().setVisibility(0);
                        bVar.dpN().setText(str2);
                    }
                }
            }
            if (i2 == getCount() - 1) {
                bVar.dpO().setVisibility(4);
            } else {
                bVar.dpO().setVisibility(0);
            }
            if (getCount() == 1) {
                if (i2 == 0) {
                    view.setBackground(g.this.activity.getResources().getDrawable(R.drawable.aoh));
                }
            } else if (getCount() > 1) {
                if (i2 == 0) {
                    view.setBackground(g.this.activity.getResources().getDrawable(R.drawable.aoj));
                } else if (i2 == getCount() - 1) {
                    view.setBackground(g.this.activity.getResources().getDrawable(R.drawable.aoi));
                } else {
                    view.setBackgroundColor(g.this.activity.getResources().getColor(R.color.afz));
                }
            }
            AppMethodBeat.o(251350);
            return view;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(251351);
            List list = g.this.vuO;
            if (list == null) {
                p.hyc();
            }
            Object obj = list.get(i2);
            AppMethodBeat.o(251351);
            return obj;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        public final int getCount() {
            AppMethodBeat.i(251352);
            List list = g.this.vuO;
            if (list != null) {
                int size = list.size();
                AppMethodBeat.o(251352);
                return size;
            }
            AppMethodBeat.o(251352);
            return 0;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic$HotWordItemHolder;", "", "(Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic;)V", "dividerView", "Landroid/view/View;", "getDividerView", "()Landroid/view/View;", "setDividerView", "(Landroid/view/View;)V", "hintText", "Landroid/widget/TextView;", "getHintText", "()Landroid/widget/TextView;", "setHintText", "(Landroid/widget/TextView;)V", "lastLineDivider", "getLastLineDivider", "setLastLineDivider", "lastLineText", "getLastLineText", "setLastLineText", "text", "getText", "setText", "plugin-finder_release"})
    public final class b {
        public TextView krl;
        public View lrc;
        public TextView vuS;
        public TextView vuT;
        public View vuU;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        public final TextView dpL() {
            AppMethodBeat.i(251340);
            TextView textView = this.krl;
            if (textView == null) {
                p.btv("text");
            }
            AppMethodBeat.o(251340);
            return textView;
        }

        public final TextView dpM() {
            AppMethodBeat.i(251341);
            TextView textView = this.vuS;
            if (textView == null) {
                p.btv("lastLineText");
            }
            AppMethodBeat.o(251341);
            return textView;
        }

        public final TextView dpN() {
            AppMethodBeat.i(251342);
            TextView textView = this.vuT;
            if (textView == null) {
                p.btv("hintText");
            }
            AppMethodBeat.o(251342);
            return textView;
        }

        public final View dpO() {
            AppMethodBeat.i(251343);
            View view = this.lrc;
            if (view == null) {
                p.btv("dividerView");
            }
            AppMethodBeat.o(251343);
            return view;
        }

        public final View dpP() {
            AppMethodBeat.i(251344);
            View view = this.vuU;
            if (view == null) {
                p.btv("lastLineDivider");
            }
            AppMethodBeat.o(251344);
            return view;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019J\b\u0010\u001b\u001a\u00020\tH\u0002J\u0006\u0010\u001c\u001a\u00020\tJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0014\u0010\u001f\u001a\u00020\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001a0!J\u0016\u0010\"\u001a\u00020\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001a0!H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic$PopularDataManager;", "", "()V", "FILE_NAME", "", "INVALID_TIME_LIMIT", "", "TAG", "isLoadFromFile", "", "lastUpdateListTime", "getLastUpdateListTime", "()I", "setLastUpdateListTime", "(I)V", "popularHistory", "Lcom/tencent/mm/protocal/protobuf/FinderPopularHistory;", "getPopularHistory", "()Lcom/tencent/mm/protocal/protobuf/FinderPopularHistory;", "setPopularHistory", "(Lcom/tencent/mm/protocal/protobuf/FinderPopularHistory;)V", "startRequestTime", "getStartRequestTime", "setStartRequestTime", "getHotWords", "", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "isHistoryValid", "isShouldUpdateUi", "readFromFile", "", "saveToFile", "hotWords", "Ljava/util/LinkedList;", "setHotWords", "plugin-finder_release"})
    public static final class c {
        private static boolean vuV;
        private static int vuW;
        private static int vuX;
        private static bai vuY;
        public static final c vuZ = new c();

        static {
            AppMethodBeat.i(251349);
            AppMethodBeat.o(251349);
        }

        private c() {
        }

        public static void KN(int i2) {
            vuW = i2;
        }

        public static void KO(int i2) {
            vuX = i2;
        }

        public static int dpQ() {
            return vuX;
        }

        public static bai dpR() {
            return vuY;
        }

        public static List<bby> dpS() {
            boolean z;
            AppMethodBeat.i(251347);
            if (vuY == null && !vuV) {
                if (vuY == null) {
                    vuY = new bai();
                }
                StringBuilder sb = new StringBuilder();
                al alVar = al.waC;
                byte[] aW = s.aW(sb.append(al.dEF()).append("popular.info").toString(), 0, -1);
                try {
                    bai bai = vuY;
                    if (bai != null) {
                        bai.parseFrom(aW);
                    }
                    Log.i("Finder.PopularDataManager", "read from File");
                } catch (Exception e2) {
                    Log.printErrStackTrace("Finder.PopularDataManager", e2, "", new Object[0]);
                }
                vuV = true;
            }
            bai bai2 = vuY;
            if (bai2 != null) {
                bai bai3 = vuY;
                if (bai3 != null) {
                    z = ((long) cl.aWB()) - bai3.lastUpdateTime < 480 && bai3.LJY.size() > 0;
                    Log.i("Finder.PopularDataManager", "cur: " + cl.aWB() + "  lastUpdateTime : " + bai3.lastUpdateTime + " isValid: " + z);
                } else {
                    Log.i("Finder.PopularDataManager", "isValid: false");
                    z = false;
                }
                if (z) {
                    LinkedList<bby> linkedList = bai2.LJY;
                    AppMethodBeat.o(251347);
                    return linkedList;
                }
            }
            AppMethodBeat.o(251347);
            return null;
        }

        static void aw(LinkedList<bby> linkedList) {
            AppMethodBeat.i(251348);
            bai bai = new bai();
            bai.LJY = linkedList;
            bai.lastUpdateTime = (long) cl.aWB();
            vuY = bai;
            AppMethodBeat.o(251348);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            public static final a vva = new a();

            static {
                AppMethodBeat.i(251346);
                AppMethodBeat.o(251346);
            }

            a() {
            }

            public final void run() {
                AppMethodBeat.i(251345);
                StringBuilder sb = new StringBuilder();
                al alVar = al.waC;
                String sb2 = sb.append(al.dEF()).append("popular.info").toString();
                o oVar = new o(sb2);
                c cVar = c.vuZ;
                bai dpR = c.dpR();
                byte[] byteArray = dpR != null ? dpR.toByteArray() : null;
                if (!s.YS(String.valueOf(oVar.heq()))) {
                    s.boN(String.valueOf(oVar.heq()));
                }
                s.C(sb2, byteArray);
                AppMethodBeat.o(251345);
            }
        }
    }
}
