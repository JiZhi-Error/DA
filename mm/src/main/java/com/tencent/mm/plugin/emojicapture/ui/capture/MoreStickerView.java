package com.tencent.mm.plugin.emojicapture.ui.capture;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.game.e.a.e;
import com.tencent.mm.plugin.appbrand.game.e.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskForNative;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTaskForNative;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallStateForNative;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTaskForNative;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTaskForNative;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTaskForNative;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiResumeDownloadTaskForNative;
import com.tencent.mm.plugin.appbrand.jsapi.w.c;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.model.a.c;
import com.tencent.mm.plugin.emojicapture.ui.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\tH\u0014J\b\u0010;\u001a\u00020\u0013H\u0002J\u0010\u0010<\u001a\u00020\u00132\b\u0010=\u001a\u0004\u0018\u00010\fJ\u0006\u0010>\u001a\u00020\u0013R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u000e\u0010$\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0010\u0010-\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R9\u0010.\u001a!\u0012\u0015\u0012\u0013\u0018\u000100¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u0013\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006?"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/capture/MoreStickerView;", "Landroid/support/constraint/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "adapter", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;", "close", "Landroid/view/View;", "closeCallback", "Lkotlin/Function0;", "", "getCloseCallback", "()Lkotlin/jvm/functions/Function0;", "setCloseCallback", "(Lkotlin/jvm/functions/Function0;)V", "dataCallback", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;", "getDataCallback", "()Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;", "firstUpdateData", "", "itemWidth", "layoutManager", "Landroid/support/v7/widget/GridLayoutManager;", "loadMoreCallback", "getLoadMoreCallback", "setLoadMoreCallback", "maxSpan", "recycler", "Landroid/support/v7/widget/RecyclerView;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "getReporter", "()Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "setReporter", "(Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "selectedId", "selectionCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/sticker/LensItem;", "Lkotlin/ParameterName;", "name", "info", "getSelectionCallback", "()Lkotlin/jvm/functions/Function1;", "setSelectionCallback", "(Lkotlin/jvm/functions/Function1;)V", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "reportStickersExposure", "resetSelection", "selectedLensId", "setShow", "plugin-emojicapture_release"})
public final class MoreStickerView extends ConstraintLayout {
    private final String TAG;
    private final RecyclerView gTW;
    private final GridLayoutManager haU;
    private final int qmd;
    private final c roK;
    private String rpt;
    private EmojiCaptureReporter rqJ;
    private final View rtJ;
    private final a rtK;
    private int rtL;
    private boolean rtM;
    private b<? super com.tencent.mm.sticker.c, x> rtN;
    private kotlin.g.a.a<x> rtO;
    private kotlin.g.a.a<x> rtP;

    public static final /* synthetic */ void f(MoreStickerView moreStickerView) {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.game.e.a.c.CTRL_INDEX);
        moreStickerView.cJN();
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.game.e.a.c.CTRL_INDEX);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MoreStickerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(e.CTRL_INDEX);
        this.TAG = "MicroMsg.MoreStickerView";
        this.rtL = 5;
        this.rtM = true;
        View.inflate(context, R.layout.a1k, this);
        View findViewById = findViewById(R.id.bzi);
        p.g(findViewById, "findViewById(R.id.emoji_…ture_sticker_panel_close)");
        this.rtJ = findViewById;
        View findViewById2 = findViewById(R.id.bzg);
        p.g(findViewById2, "findViewById(R.id.emoji_…re_sticker_more_recycler)");
        this.gTW = (RecyclerView) findViewById2;
        this.qmd = context.getResources().getDimensionPixelSize(R.dimen.cs);
        this.haU = new GridLayoutManager(this.rtL);
        this.rtK = new a();
        this.gTW.setLayoutManager(this.haU);
        this.gTW.setAdapter(this.rtK);
        this.gTW.setItemAnimator(null);
        this.haU.a(new GridLayoutManager.b(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.capture.MoreStickerView.AnonymousClass1 */
            final /* synthetic */ MoreStickerView rtQ;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.rtQ = r1;
            }

            @Override // android.support.v7.widget.GridLayoutManager.b
            public final int bX(int i2) {
                AppMethodBeat.i(652);
                if (this.rtQ.rtK.getItemViewType(i2) == 0) {
                    AppMethodBeat.o(652);
                    return 1;
                }
                int i3 = this.rtQ.rtL;
                AppMethodBeat.o(652);
                return i3;
            }
        });
        this.rtK.rsD = new m<Integer, com.tencent.mm.sticker.c, x>(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.capture.MoreStickerView.AnonymousClass2 */
            final /* synthetic */ MoreStickerView rtQ;

            {
                this.rtQ = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Integer num, com.tencent.mm.sticker.c cVar) {
                AppMethodBeat.i(c.b.CTRL_INDEX);
                int intValue = num.intValue();
                com.tencent.mm.sticker.c cVar2 = cVar;
                p.h(cVar2, "info");
                this.rtQ.rtK.setSelection(intValue);
                b<com.tencent.mm.sticker.c, x> selectionCallback = this.rtQ.getSelectionCallback();
                if (selectionCallback != null) {
                    selectionCallback.invoke(cVar2);
                }
                this.rtQ.rpt = cVar2.NMJ.Lso;
                x xVar = x.SXb;
                AppMethodBeat.o(c.b.CTRL_INDEX);
                return xVar;
            }
        };
        this.rtK.rsE = new b<Integer, x>(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.capture.MoreStickerView.AnonymousClass3 */
            final /* synthetic */ MoreStickerView rtQ;

            {
                this.rtQ = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Integer num) {
                kotlin.g.a.a<x> loadMoreCallback;
                AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch.a.CTRL_INDEX);
                if (num.intValue() >= this.rtQ.rtK.getItemCount() - this.rtQ.rtL && (loadMoreCallback = this.rtQ.getLoadMoreCallback()) != null) {
                    loadMoreCallback.invoke();
                }
                x xVar = x.SXb;
                AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch.a.CTRL_INDEX);
                return xVar;
            }
        };
        this.roK = new com.tencent.mm.plugin.emojicapture.model.a.c(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.capture.MoreStickerView.AnonymousClass4 */
            final /* synthetic */ MoreStickerView rtQ;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.rtQ = r1;
            }

            @Override // com.tencent.mm.plugin.emojicapture.model.a.c
            public final void ad(List<com.tencent.mm.sticker.c> list) {
                AppMethodBeat.i(JsApiGetInstallStateForNative.CTRL_INDEX);
                p.h(list, "lensList");
                com.tencent.mm.plugin.emojicapture.ui.a.a aVar = this.rtQ.rtK;
                p.h(list, "lensList");
                Log.i(com.tencent.mm.plugin.emojicapture.ui.a.a.TAG, "update: " + list.size());
                aVar.rsC.clear();
                aVar.rsC.addAll(list);
                if (this.rtQ.rtM) {
                    this.rtQ.gTW.postDelayed(new a(this), 300);
                    this.rtQ.rtM = false;
                }
                AppMethodBeat.o(JsApiGetInstallStateForNative.CTRL_INDEX);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.MoreStickerView$4$a */
            static final class a implements Runnable {
                final /* synthetic */ AnonymousClass4 rtR;

                a(AnonymousClass4 r1) {
                    this.rtR = r1;
                }

                public final void run() {
                    AppMethodBeat.i(JsApiAddDownloadTaskForNative.CTRL_INDEX);
                    MoreStickerView.f(this.rtR.rtQ);
                    AppMethodBeat.o(JsApiAddDownloadTaskForNative.CTRL_INDEX);
                }
            }

            @Override // com.tencent.mm.plugin.emojicapture.model.a.c
            public final void fH(int i2, int i3) {
                AppMethodBeat.i(JsApiCancelDownloadTaskForNative.CTRL_INDEX);
                this.rtQ.rtK.as(i2, i3);
                AppMethodBeat.o(JsApiCancelDownloadTaskForNative.CTRL_INDEX);
            }

            @Override // com.tencent.mm.plugin.emojicapture.model.a.c
            public final void fI(int i2, int i3) {
                AppMethodBeat.i(JsApiInstallDownloadTaskForNative.CTRL_INDEX);
                this.rtQ.rtK.at(i2, i3);
                AppMethodBeat.o(JsApiInstallDownloadTaskForNative.CTRL_INDEX);
            }

            @Override // com.tencent.mm.plugin.emojicapture.model.a.c
            public final void fJ(int i2, int i3) {
                AppMethodBeat.i(JsApiPauseDownloadTaskForNative.CTRL_INDEX);
                this.rtQ.rtK.ar(i2, i3);
                AppMethodBeat.o(JsApiPauseDownloadTaskForNative.CTRL_INDEX);
            }

            @Override // com.tencent.mm.plugin.emojicapture.model.a.c
            public final void fK(int i2, int i3) {
                AppMethodBeat.i(JsApiResumeDownloadTaskForNative.CTRL_INDEX);
                this.rtQ.rtK.aq(i2, i3);
                AppMethodBeat.o(JsApiResumeDownloadTaskForNative.CTRL_INDEX);
            }
        };
        this.gTW.a(new RecyclerView.l(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.capture.MoreStickerView.AnonymousClass5 */
            final /* synthetic */ MoreStickerView rtQ;

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                AppMethodBeat.i(256445);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                bVar.pH(i3);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/capture/MoreStickerView$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
                super.onScrolled(recyclerView, i2, i3);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/capture/MoreStickerView$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(256445);
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.rtQ = r1;
            }

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                AppMethodBeat.i(JsApiQueryDownloadTaskForNative.CTRL_INDEX);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/capture/MoreStickerView$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
                p.h(recyclerView, "recyclerView");
                if (i2 == 0) {
                    MoreStickerView.f(this.rtQ);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/capture/MoreStickerView$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                AppMethodBeat.o(JsApiQueryDownloadTaskForNative.CTRL_INDEX);
            }
        });
        this.rtJ.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.capture.MoreStickerView.AnonymousClass6 */
            final /* synthetic */ MoreStickerView rtQ;

            {
                this.rtQ = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(662);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/capture/MoreStickerView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                kotlin.g.a.a<x> closeCallback = this.rtQ.getCloseCallback();
                if (closeCallback != null) {
                    closeCallback.invoke();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/capture/MoreStickerView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(662);
            }
        });
        AppMethodBeat.o(e.CTRL_INDEX);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MoreStickerView(Context context) {
        this(context, null);
        p.h(context, "context");
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.game.e.a.a.CTRL_INDEX);
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.game.e.a.a.CTRL_INDEX);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MoreStickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(f.CTRL_INDEX);
        AppMethodBeat.o(f.CTRL_INDEX);
    }

    public final EmojiCaptureReporter getReporter() {
        return this.rqJ;
    }

    public final void setReporter(EmojiCaptureReporter emojiCaptureReporter) {
        this.rqJ = emojiCaptureReporter;
    }

    public final com.tencent.mm.plugin.emojicapture.model.a.c getDataCallback() {
        return this.roK;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super com.tencent.mm.sticker.c, kotlin.x>, kotlin.g.a.b<com.tencent.mm.sticker.c, kotlin.x> */
    public final b<com.tencent.mm.sticker.c, x> getSelectionCallback() {
        return this.rtN;
    }

    public final void setSelectionCallback(b<? super com.tencent.mm.sticker.c, x> bVar) {
        this.rtN = bVar;
    }

    public final kotlin.g.a.a<x> getCloseCallback() {
        return this.rtO;
    }

    public final void setCloseCallback(kotlin.g.a.a<x> aVar) {
        this.rtO = aVar;
    }

    public final kotlin.g.a.a<x> getLoadMoreCallback() {
        return this.rtP;
    }

    public final void setLoadMoreCallback(kotlin.g.a.a<x> aVar) {
        this.rtP = aVar;
    }

    public final void anp(String str) {
        AppMethodBeat.i(663);
        if (!p.j(this.rpt, str)) {
            this.rtK.setSelection(-1);
            b<? super com.tencent.mm.sticker.c, x> bVar = this.rtN;
            if (bVar != null) {
                bVar.invoke(null);
                AppMethodBeat.o(663);
                return;
            }
        }
        AppMethodBeat.o(663);
    }

    /* access modifiers changed from: package-private */
    public final void cJN() {
        AppMethodBeat.i(664);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        boolean z = true;
        if (this.gTW.getChildCount() <= 0) {
            AppMethodBeat.o(664);
            return;
        }
        int childCount = this.gTW.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            com.tencent.mm.sticker.c Gs = this.rtK.Gs(RecyclerView.bw(this.gTW.getChildAt(i2)));
            if (Gs != null && !Util.isNullOrNil(Gs.NMJ.Lso)) {
                if (!z) {
                    sb.append("#");
                    sb2.append("#");
                }
                sb.append(Gs.NMJ.Lso);
                sb2.append(Gs.NMJ.Name);
                z = false;
            }
        }
        EmojiCaptureReporter emojiCaptureReporter = this.rqJ;
        if (emojiCaptureReporter != null) {
            emojiCaptureReporter.fY(sb.toString(), sb2.toString());
            AppMethodBeat.o(664);
            return;
        }
        AppMethodBeat.o(664);
    }

    @Override // android.support.constraint.ConstraintLayout
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(665);
        super.onMeasure(i2, i3);
        if (getMeasuredWidth() > this.qmd) {
            this.rtL = getMeasuredWidth() / this.qmd;
            this.haU.bW(this.rtL);
        }
        AppMethodBeat.o(665);
    }
}
