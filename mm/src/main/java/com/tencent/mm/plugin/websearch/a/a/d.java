package com.tencent.mm.plugin.websearch.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.li;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.websearch.a.a.c;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.websearch.webview.b;
import com.tencent.mm.plugin.websearch.webview.e;
import com.tencent.mm.plugin.websearch.webview.f;
import com.tencent.mm.plugin.websearch.webview.g;
import com.tencent.mm.plugin.websearch.webview.h;
import com.tencent.mm.plugin.websearch.webview.i;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.protocal.protobuf.egj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.a;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ(\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\rH\u0016J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0006H\u0016J\n\u0010+\u001a\u0004\u0018\u00010\u001bH\u0016J\n\u0010,\u001a\u0004\u0018\u00010\u001fH\u0016J\n\u0010-\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010.\u001a\u00020#2\b\u0010/\u001a\u0004\u0018\u00010\nH\u0016J\u0006\u00100\u001a\u00020#J6\u00101\u001a\u00020#2\b\u00102\u001a\u0004\u0018\u00010\r2\b\u00103\u001a\u0004\u0018\u00010\r2\u000e\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001052\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0010\u00109\u001a\u00020#2\u0006\u0010:\u001a\u00020;H\u0016J$\u0010<\u001a\u00020#2\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010B\u001a\u00020#2\u0006\u0010A\u001a\u00020\r2\u0006\u0010C\u001a\u00020;H\u0016J\b\u0010D\u001a\u00020;H\u0016J\u0010\u0010E\u001a\u00020#2\u0006\u0010F\u001a\u00020\rH\u0016J\u001a\u0010G\u001a\u00020#2\u0006\u0010H\u001a\u00020I2\b\u0010$\u001a\u0004\u0018\u000106H\u0016J\u0010\u0010J\u001a\u00020#2\u0006\u0010K\u001a\u00020\u0006H\u0016R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\n \u0019*\u0004\u0018\u00010\n0\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, hxF = {"Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchMainTab;", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchUIComponent;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "dialog", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;", "homeContext", "Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "dialogView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;Landroid/view/View;)V", "TAG", "", "getDialog", "()Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;", "ftsEditTextView", "Lcom/tencent/mm/ui/search/FTSEditTextView;", "getHomeContext", "()Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "setHomeContext", "(Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;)V", "getListener", "()Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "mainTabView", "kotlin.jvm.PlatformType", "tagSearchWebData", "Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchWebData;", "tagSearchWebView", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "tagSearchWebViewJSApi", "Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchJSApi;", "webviewContainer", "Landroid/widget/FrameLayout;", "appendSearchTag", "", "tag", "sessionId", "searchId", "requestId", "getActivityContext", "Landroid/content/Context;", "getDataContext", "getWebSearchData", "getWebSearchJSApi", "getWebView", "onClickClearTextBtn", "view", "onDismiss", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "", "onEndSearchShareCgi", "shareContent", "Lcom/tencent/mm/protocal/protobuf/GetSearchShareResponse;", "cropBitmap", "Landroid/graphics/Bitmap;", SearchIntents.EXTRA_QUERY, "onSearchInputChange", "isInputChange", "onSearchKeyDown", "onStartSearchShareCgi", "id", "onTagClick", FirebaseAnalytics.b.INDEX, "", "startMoreTab", "moreContext", "ui-websearch_release"})
public final class d implements b, FTSEditTextView.a {
    egj IGg;
    final a IGh;
    private View IGo;
    FTSEditTextView IGp;
    private com.tencent.mm.plugin.websearch.a.a IGq;
    com.tencent.mm.plugin.websearch.a.d IGr;
    WebSearchWebView IGs;
    final c IGt;
    final String TAG = "MicroMsg.WebSearch.TagSearchMainTab";
    private FrameLayout plP;

    public d(c cVar, egj egj, a aVar, View view) {
        p.h(cVar, "dialog");
        p.h(egj, "homeContext");
        p.h(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        p.h(view, "dialogView");
        AppMethodBeat.i(197980);
        this.IGt = cVar;
        this.IGg = egj;
        this.IGh = aVar;
        this.IGo = view.findViewById(R.id.f6l);
        View findViewById = view.findViewById(R.id.f6t);
        p.g(findViewById, "dialogView.findViewById(…d.main_webview_container)");
        this.plP = (FrameLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.db_);
        p.g(findViewById2, "dialogView.findViewById(R.id.fts_edittext)");
        this.IGp = (FTSEditTextView) findViewById2;
        this.IGq = new com.tencent.mm.plugin.websearch.a.a(this);
        this.IGr = new com.tencent.mm.plugin.websearch.a.d(this);
        this.IGs = new WebSearchWebView(getActivityContext());
        this.IGp.gWY();
        this.IGp.setFtsEditTextListener(this);
        this.IGp.awD();
        this.IGp.awC();
        FTSEditTextView fTSEditTextView = this.IGp;
        Context context = this.IGp.getContext();
        p.g(context, "ftsEditTextView.context");
        fTSEditTextView.setHint(context.getResources().getString(R.string.yn));
        this.IGs.a(new e(), new f(6));
        this.IGs.addJavascriptInterface(this.IGq, "tagWebSearchJSApi");
        this.plP.addView(this.IGs);
        Log.i(this.TAG, "start to load url %s", this.IGg.url);
        this.IGs.loadUrl(this.IGg.url);
        AppMethodBeat.o(197980);
    }

    @Override // com.tencent.mm.plugin.websearch.a.a.b
    public final com.tencent.mm.plugin.websearch.a.d fYG() {
        return this.IGr;
    }

    @Override // com.tencent.mm.plugin.websearch.a.a.b
    public final com.tencent.mm.plugin.websearch.a.a fYH() {
        return this.IGq;
    }

    @Override // com.tencent.mm.plugin.websearch.a.a.b
    public final void cK(String str, boolean z) {
        AppMethodBeat.i(197970);
        p.h(str, SearchIntents.EXTRA_QUERY);
        FTSEditTextView fTSEditTextView = this.IGp;
        if (fTSEditTextView != null) {
            fTSEditTextView.O(str, null);
        }
        if (z) {
            FTSEditTextView fTSEditTextView2 = this.IGp;
            if (fTSEditTextView2 != null) {
                fTSEditTextView2.awD();
            }
            FTSEditTextView fTSEditTextView3 = this.IGp;
            if (fTSEditTextView3 != null) {
                fTSEditTextView3.showVKB();
            }
            FTSEditTextView fTSEditTextView4 = this.IGp;
            if (fTSEditTextView4 != null) {
                com.tencent.mm.plugin.websearch.a.a aVar = this.IGq;
                if (aVar != null) {
                    String totalQuery = fTSEditTextView4.getTotalQuery();
                    p.g(totalQuery, "it.totalQuery");
                    String inEditTextQuery = fTSEditTextView4.getInEditTextQuery();
                    p.g(inEditTextQuery, "it.inEditTextQuery");
                    aVar.lK(totalQuery, inEditTextQuery);
                    AppMethodBeat.o(197970);
                    return;
                }
                AppMethodBeat.o(197970);
                return;
            }
            AppMethodBeat.o(197970);
            return;
        }
        FTSEditTextView fTSEditTextView5 = this.IGp;
        if (fTSEditTextView5 != null) {
            fTSEditTextView5.gUA();
        }
        FTSEditTextView fTSEditTextView6 = this.IGp;
        if (fTSEditTextView6 != null) {
            fTSEditTextView6.hideVKB();
            AppMethodBeat.o(197970);
            return;
        }
        AppMethodBeat.o(197970);
    }

    @Override // com.tencent.mm.plugin.websearch.a.a.b
    public final void F(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(197971);
        p.h(str, "tag");
        p.h(str2, "sessionId");
        p.h(str3, "searchId");
        p.h(str4, "requestId");
        com.tencent.mm.ac.d.h(new a(this, str));
        li liVar = new li();
        liVar.uM(4);
        liVar.uN((long) cl.aWB());
        liVar.aiA();
        liVar.yx(str);
        liVar.uO(ab.Eq(this.IGg.talker) ? 2 : 1);
        liVar.yy(this.IGg.talker);
        liVar.yz(str2);
        liVar.yA(str3);
        liVar.yB(str4);
        liVar.yC("");
        liVar.bfK();
        ar.a(liVar);
        AppMethodBeat.o(197971);
    }

    @Override // com.tencent.mm.plugin.websearch.a.a.b
    public final void a(egj egj) {
        AppMethodBeat.i(197972);
        p.h(egj, "moreContext");
        c cVar = this.IGt;
        p.h(egj, "moreContext");
        com.tencent.mm.ac.d.h(new c.g(cVar, egj));
        AppMethodBeat.o(197972);
    }

    @Override // com.tencent.mm.plugin.websearch.webview.d
    public final WebSearchWebView dQg() {
        return this.IGs;
    }

    @Override // com.tencent.mm.plugin.websearch.webview.d
    public final Context getActivityContext() {
        AppMethodBeat.i(197973);
        Context context = this.IGt.getContext();
        p.g(context, "dialog.context");
        AppMethodBeat.o(197973);
        return context;
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final boolean awE() {
        String totalQuery;
        WebSearchWebView dQg;
        AppMethodBeat.i(197974);
        FTSEditTextView fTSEditTextView = this.IGp;
        if (!(fTSEditTextView == null || (totalQuery = fTSEditTextView.getTotalQuery()) == null)) {
            if (totalQuery == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.CharSequence");
                AppMethodBeat.o(197974);
                throw tVar;
            }
            String obj = n.trim(totalQuery).toString();
            if (!(!(obj == null || obj.length() == 0))) {
                totalQuery = null;
            }
            if (totalQuery != null) {
                com.tencent.mm.plugin.websearch.a.a aVar = this.IGq;
                if (aVar != null) {
                    String inEditTextQuery = fTSEditTextView.getInEditTextQuery();
                    p.g(inEditTextQuery, "view.inEditTextQuery");
                    p.h(totalQuery, SearchIntents.EXTRA_QUERY);
                    p.h(inEditTextQuery, "custom");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(SearchIntents.EXTRA_QUERY, totalQuery);
                        jSONObject.put("custom", inEditTextQuery);
                    } catch (Exception e2) {
                    }
                    com.tencent.mm.plugin.websearch.webview.d<T> dVar = aVar.IHe;
                    if (!(dVar == null || (dQg = dVar.dQg()) == null)) {
                        i iVar = i.IHk;
                        String jSONObject2 = jSONObject.toString();
                        p.g(jSONObject2, "requestObj.toString()");
                        i.a(dQg, "onSearchInputConfirm", jSONObject2);
                    }
                }
                fTSEditTextView.hideVKB();
            }
        }
        AppMethodBeat.o(197974);
        return false;
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void a(String str, String str2, List<a.c> list, FTSEditTextView.b bVar) {
        FTSEditTextView fTSEditTextView;
        AppMethodBeat.i(197975);
        if ((bVar == FTSEditTextView.b.UserInput || bVar == FTSEditTextView.b.ClearText) && (fTSEditTextView = this.IGp) != null) {
            com.tencent.mm.plugin.websearch.a.a aVar = this.IGq;
            if (aVar != null) {
                String totalQuery = fTSEditTextView.getTotalQuery();
                p.g(totalQuery, "it.totalQuery");
                String inEditTextQuery = fTSEditTextView.getInEditTextQuery();
                p.g(inEditTextQuery, "it.inEditTextQuery");
                aVar.lK(totalQuery, inEditTextQuery);
                AppMethodBeat.o(197975);
                return;
            }
            AppMethodBeat.o(197975);
            return;
        }
        AppMethodBeat.o(197975);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void eh(boolean z) {
        FTSEditTextView fTSEditTextView;
        AppMethodBeat.i(197976);
        if (!z || (fTSEditTextView = this.IGp) == null) {
            AppMethodBeat.o(197976);
            return;
        }
        com.tencent.mm.plugin.websearch.a.a aVar = this.IGq;
        if (aVar != null) {
            String totalQuery = fTSEditTextView.getTotalQuery();
            p.g(totalQuery, "it.totalQuery");
            String inEditTextQuery = fTSEditTextView.getInEditTextQuery();
            p.g(inEditTextQuery, "it.inEditTextQuery");
            aVar.lK(totalQuery, inEditTextQuery);
            AppMethodBeat.o(197976);
            return;
        }
        AppMethodBeat.o(197976);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void onClickClearTextBtn(View view) {
        AppMethodBeat.i(197977);
        FTSEditTextView fTSEditTextView = this.IGp;
        if (fTSEditTextView != null) {
            fTSEditTextView.awD();
        }
        FTSEditTextView fTSEditTextView2 = this.IGp;
        if (fTSEditTextView2 != null) {
            fTSEditTextView2.showVKB();
            AppMethodBeat.o(197977);
            return;
        }
        AppMethodBeat.o(197977);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void dpw() {
    }

    @Override // com.tencent.mm.plugin.websearch.a.a.b
    public final void aXn(String str) {
        AppMethodBeat.i(197978);
        p.h(str, "id");
        this.IGt.aXn(str);
        AppMethodBeat.o(197978);
    }

    @Override // com.tencent.mm.plugin.websearch.a.a.b
    public final void a(buv buv, Bitmap bitmap, String str) {
        AppMethodBeat.i(197979);
        p.h(buv, "shareContent");
        this.IGt.a(buv, bitmap, str);
        AppMethodBeat.o(197979);
    }

    @Override // com.tencent.mm.plugin.websearch.webview.d
    public final /* bridge */ /* synthetic */ com.tencent.mm.plugin.websearch.webview.a dQk() {
        return this.IGr;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d IGu;
        final /* synthetic */ String hvr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(d dVar, String str) {
            super(0);
            this.IGu = dVar;
            this.hvr = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(197969);
            this.IGu.IGh.gf(n.j(this.hvr, " ", "_", false), this.IGu.IGg.vkj);
            this.IGu.IGt.dismiss();
            x xVar = x.SXb;
            AppMethodBeat.o(197969);
            return xVar;
        }
    }

    /* Return type fixed from 'com.tencent.mm.plugin.websearch.webview.g' to match base method */
    @Override // com.tencent.mm.plugin.websearch.webview.c
    public final /* bridge */ /* synthetic */ g<egj> dQh() {
        return this.IGr;
    }

    @Override // com.tencent.mm.plugin.websearch.webview.d
    public final /* bridge */ /* synthetic */ b dQj() {
        return this.IGq;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.websearch.webview.h' to match base method */
    @Override // com.tencent.mm.plugin.websearch.webview.c
    public final /* bridge */ /* synthetic */ h<egj> dQi() {
        return this.IGq;
    }

    @Override // com.tencent.mm.plugin.websearch.webview.d
    public final /* bridge */ /* synthetic */ Object dQl() {
        return this.IGg;
    }
}
