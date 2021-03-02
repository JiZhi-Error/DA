package com.tencent.mm.plugin.websearch.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.websearch.a.a;
import com.tencent.mm.plugin.websearch.a.d;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.websearch.webview.b;
import com.tencent.mm.plugin.websearch.webview.f;
import com.tencent.mm.plugin.websearch.webview.g;
import com.tencent.mm.plugin.websearch.webview.h;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.protocal.protobuf.egj;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ(\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\fH\u0016J\u0006\u0010%\u001a\u00020 J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J\n\u0010)\u001a\u0004\u0018\u00010\u0018H\u0016J\n\u0010*\u001a\u0004\u0018\u00010\u001cH\u0016J\n\u0010+\u001a\u0004\u0018\u00010\u001aH\u0016J\u0006\u0010,\u001a\u00020 J$\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u00103\u001a\u00020 2\u0006\u00102\u001a\u00020\f2\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020 2\u0006\u00107\u001a\u00020\fH\u0016J\u0010\u00108\u001a\u00020 2\u0006\u00109\u001a\u00020\u0005H\u0016R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\n \u0016*\u0004\u0018\u00010\t0\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, hxF = {"Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchMoreTab;", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchUIComponent;", "dialog", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;", "homeContext", "Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "dialogView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;Landroid/view/View;)V", "TAG", "", "getDialog", "()Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;", "getHomeContext", "()Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "setHomeContext", "(Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;)V", "getListener", "()Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "moreTabView", "kotlin.jvm.PlatformType", "tagSearchWebData", "Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchWebData;", "tagSearchWebView", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "tagSearchWebViewJSApi", "Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchJSApi;", "webviewContainer", "Landroid/widget/FrameLayout;", "appendSearchTag", "", "tag", "sessionId", "searchId", "requestId", "exitMoreTab", "getActivityContext", "Landroid/content/Context;", "getDataContext", "getWebSearchData", "getWebSearchJSApi", "getWebView", "onDismiss", "onEndSearchShareCgi", "shareContent", "Lcom/tencent/mm/protocal/protobuf/GetSearchShareResponse;", "cropBitmap", "Landroid/graphics/Bitmap;", SearchIntents.EXTRA_QUERY, "onSearchInputChange", "isInputChange", "", "onStartSearchShareCgi", "id", "startMoreTab", "moreContext", "ui-websearch_release"})
public final class e implements b {
    egj IGg;
    private final a IGh;
    private a IGq;
    d IGr;
    WebSearchWebView IGs;
    private final c IGt;
    View IGv;
    private final String TAG = "MicroMsg.WebSearch.TagSearchMoreTab";
    private FrameLayout plP;

    public e(c cVar, egj egj, a aVar, View view) {
        p.h(cVar, "dialog");
        p.h(egj, "homeContext");
        p.h(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        p.h(view, "dialogView");
        AppMethodBeat.i(197987);
        this.IGt = cVar;
        this.IGg = egj;
        this.IGh = aVar;
        this.IGv = view.findViewById(R.id.fkx);
        View findViewById = view.findViewById(R.id.fl9);
        p.g(findViewById, "dialogView.findViewById(…d.more_webview_container)");
        this.plP = (FrameLayout) findViewById;
        this.IGq = new a(this);
        this.IGr = new d(this);
        this.IGs = new WebSearchWebView(getActivityContext());
        this.IGs.a(new com.tencent.mm.plugin.websearch.webview.e(), new f(6));
        this.IGs.addJavascriptInterface(this.IGq, "tagWebSearchJSApi");
        this.plP.addView(this.IGs);
        AppMethodBeat.o(197987);
    }

    @Override // com.tencent.mm.plugin.websearch.a.a.b
    public final d fYG() {
        return this.IGr;
    }

    @Override // com.tencent.mm.plugin.websearch.a.a.b
    public final a fYH() {
        return this.IGq;
    }

    @Override // com.tencent.mm.plugin.websearch.a.a.b
    public final void cK(String str, boolean z) {
        AppMethodBeat.i(197981);
        p.h(str, SearchIntents.EXTRA_QUERY);
        AppMethodBeat.o(197981);
    }

    @Override // com.tencent.mm.plugin.websearch.a.a.b
    public final void F(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(197982);
        p.h(str, "tag");
        p.h(str2, "sessionId");
        p.h(str3, "searchId");
        p.h(str4, "requestId");
        AppMethodBeat.o(197982);
    }

    @Override // com.tencent.mm.plugin.websearch.a.a.b
    public final void a(egj egj) {
        AppMethodBeat.i(197983);
        p.h(egj, "moreContext");
        Log.i(this.TAG, "start to load url %s", this.IGg.url);
        this.IGs.loadUrl(this.IGg.url);
        View view = this.IGv;
        p.g(view, "moreTabView");
        if (view.getX() == 0.0f) {
            View view2 = this.IGv;
            p.g(view2, "moreTabView");
            view2.setX((float) com.tencent.mm.cb.a.jn(getActivityContext()));
        }
        this.IGv.animate().translationX(0.0f).setStartDelay(200).setDuration(300).start();
        View view3 = this.IGv;
        p.g(view3, "moreTabView");
        view3.setVisibility(0);
        AppMethodBeat.o(197983);
    }

    @Override // com.tencent.mm.plugin.websearch.webview.d
    public final WebSearchWebView dQg() {
        return this.IGs;
    }

    @Override // com.tencent.mm.plugin.websearch.webview.d
    public final Context getActivityContext() {
        AppMethodBeat.i(197984);
        Context context = this.IGt.getContext();
        p.g(context, "dialog.context");
        AppMethodBeat.o(197984);
        return context;
    }

    @Override // com.tencent.mm.plugin.websearch.a.a.b
    public final void aXn(String str) {
        AppMethodBeat.i(197985);
        p.h(str, "id");
        this.IGt.aXn(str);
        AppMethodBeat.o(197985);
    }

    @Override // com.tencent.mm.plugin.websearch.a.a.b
    public final void a(buv buv, Bitmap bitmap, String str) {
        AppMethodBeat.i(197986);
        p.h(buv, "shareContent");
        this.IGt.a(buv, bitmap, str);
        AppMethodBeat.o(197986);
    }

    @Override // com.tencent.mm.plugin.websearch.webview.d
    public final /* bridge */ /* synthetic */ com.tencent.mm.plugin.websearch.webview.a dQk() {
        return this.IGr;
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
