package com.tencent.mm.plugin.emojicapture.ui.capture;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch.JsApiSetBackgroundFetchToken;
import com.tencent.mm.plugin.appbrand.jsapi.bw;
import com.tencent.mm.plugin.appbrand.jsapi.bx;
import com.tencent.mm.plugin.appbrand.jsapi.cz;
import com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.API_openWeAppSearch;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.model.a.f;
import com.tencent.mm.plugin.emojicapture.model.a.i;
import com.tencent.mm.plugin.emojicapture.ui.layout.StickerLayoutManager;
import com.tencent.mm.plugin.emojicapture.ui.layout.c;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.s;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¯\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010=\u001a\u000202J\u0006\u0010>\u001a\u000202J\b\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u0002022\u0006\u0010B\u001a\u00020CH\u0002J\u0006\u0010D\u001a\u000202J\u0006\u0010E\u001a\u000202J\b\u0010F\u001a\u000202H\u0002J\u0010\u0010G\u001a\u0002022\u0006\u0010H\u001a\u00020\nH\u0002J-\u0010I\u001a\u0002022#\u0010J\u001a\u001f\u0012\u0013\u0012\u00110@¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(L\u0012\u0004\u0012\u000202\u0018\u00010KH\u0016J\u0010\u0010M\u001a\u0002022\u0006\u0010N\u001a\u00020@H\u0016J.\u0010O\u001a\u0002022\u0006\u0010;\u001a\u00020<2\b\u0010P\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010Q\u001a\u00020@2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\rJ\u0006\u0010S\u001a\u000202R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000RP\u0010+\u001a8\u0012\u0015\u0012\u0013\u0018\u00010-¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(1\u0012\u0004\u0012\u000202\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u000e\u00107\u001a\u000208X\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u000e¢\u0006\u0002\n\u0000¨\u0006T"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "dataCallback", "Lcom/tencent/mm/plugin/emojicapture/model/capture/DataCallbackHolder;", "downloadCallback", "com/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView$downloadCallback$1", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView$downloadCallback$1;", "firstSelectSticker", "layoutManager", "Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerLayoutManager;", "moreSelectInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "moreStickerDialog", "Landroid/support/design/widget/BottomSheetDialog;", "moreStickerView", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/MoreStickerView;", "panelData", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData;", "recommendCallback", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendData;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "getReporter", "()Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "setReporter", "(Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "requestLensId", "requestLensInfo", "selectFrame", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame;", "selectedPosition", "selectionCallback", "Lkotlin/Function2;", "Lcom/tencent/mm/sticker/StickerPack;", "Lkotlin/ParameterName;", "name", "pack", "info", "", "getSelectionCallback", "()Lkotlin/jvm/functions/Function2;", "setSelectionCallback", "(Lkotlin/jvm/functions/Function2;)V", "stickerAdapter", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "stickerRecycler", "Landroid/support/v7/widget/RecyclerView;", "timeEnter", "", "destroy", "hideMore", "isShow", "", "notifyStatus", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "onRecordStop", "refreshSelected", "reportStickersExposure", "selectItem", "position", "setOnVisibleChangeCallback", "callback", "Lkotlin/Function1;", "visible", "setShow", "show", "setup", "selectSticker", "imitate", "talkerName", "showMore", "plugin-emojicapture_release"})
public final class EditorStickerView extends RelativeLayout {
    public final String TAG;
    public long hdz;
    public EmojiCaptureReporter rqJ;
    MoreStickerView rtA;
    android.support.design.widget.a rtB;
    private chz rtC;
    String rtD;
    private chz rtE;
    public final a rtF;
    private final StickerSelectFrame rtq;
    private final RecyclerView rtr;
    private final com.tencent.mm.plugin.emojicapture.ui.a.b rts;
    private final StickerLayoutManager rtu;
    public String rtv;
    private m<? super com.tencent.mm.sticker.f, ? super chz, x> rtw;
    public final com.tencent.mm.plugin.emojicapture.model.a.f rtx;
    public final i rty;
    final com.tencent.mm.plugin.emojicapture.model.a.a rtz;
    private int va;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/sticker/LensItem;", "invoke"})
    static final class f extends q implements kotlin.g.a.b<com.tencent.mm.sticker.c, x> {
        final /* synthetic */ EditorStickerView rtG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(EditorStickerView editorStickerView) {
            super(1);
            this.rtG = editorStickerView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.sticker.c cVar) {
            chz chz;
            AppMethodBeat.i(640);
            com.tencent.mm.sticker.c cVar2 = cVar;
            EditorStickerView editorStickerView = this.rtG;
            if (cVar2 != null) {
                chz = cVar2.NMJ;
            } else {
                chz = null;
            }
            editorStickerView.rtE = chz;
            if (cVar2 != null) {
                EmojiCaptureReporter reporter = this.rtG.getReporter();
                if (reporter != null) {
                    reporter.h(cVar2.NMJ.Lso, cVar2.NMJ.Name, cVar2.gZh, cVar2.NMK);
                }
                this.rtG.rtC = cVar2.NMJ;
                this.rtG.rtD = cVar2.NMJ.Lso;
                com.tencent.mm.sticker.loader.e eVar = com.tencent.mm.sticker.loader.e.NNN;
                j d2 = com.tencent.mm.sticker.loader.e.d(cVar2.NMJ);
                if (d2 == j.OK) {
                    EditorStickerView.a(this.rtG, d2);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(640);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(EditorStickerView editorStickerView, j jVar) {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.c.CTRL_INDEX);
        editorStickerView.c(jVar);
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.c.CTRL_INDEX);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditorStickerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.n.a.CTRL_INDEX);
        this.TAG = "MicroMsg.EditorStickerView";
        this.va = -1;
        this.rtz = new com.tencent.mm.plugin.emojicapture.model.a.a();
        this.rtF = new a(this);
        View.inflate(context, R.layout.a1l, this);
        setLayerType(1, null);
        View findViewById = findViewById(R.id.bzk);
        p.g(findViewById, "findViewById(R.id.emoji_…ure_sticker_select_frame)");
        this.rtq = (StickerSelectFrame) findViewById;
        this.rtq.setSelected(true);
        this.rtq.setVisibility(8);
        View findViewById2 = findViewById(R.id.bzj);
        p.g(findViewById2, "findViewById(R.id.emoji_capture_sticker_recycler)");
        this.rtr = (RecyclerView) findViewById2;
        this.rtr.setVisibility(8);
        this.rtu = new StickerLayoutManager(context);
        this.rtr.setLayoutManager(this.rtu);
        this.rts = new com.tencent.mm.plugin.emojicapture.ui.a.b();
        com.tencent.mm.plugin.emojicapture.ui.layout.c cVar = new com.tencent.mm.plugin.emojicapture.ui.layout.c();
        cVar.f(this.rtr);
        cVar.rwT = new c.a(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.capture.EditorStickerView.AnonymousClass1 */
            final /* synthetic */ EditorStickerView rtG;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.rtG = r1;
            }

            @Override // com.tencent.mm.plugin.emojicapture.ui.layout.c.a
            public final void onPageSelected(int i2) {
                AppMethodBeat.i(629);
                Log.i(this.rtG.TAG, "onPageSelected: ".concat(String.valueOf(i2)));
                EditorStickerView.a(this.rtG, i2);
                AppMethodBeat.o(629);
            }
        };
        this.rtr.setAdapter(this.rts);
        this.rtr.setItemAnimator(null);
        this.rts.rsD = new m<Integer, com.tencent.mm.sticker.c, x>(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.capture.EditorStickerView.AnonymousClass2 */
            final /* synthetic */ EditorStickerView rtG;

            {
                this.rtG = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Integer num, com.tencent.mm.sticker.c cVar) {
                com.tencent.mm.plugin.emojicapture.model.a.c cVar2;
                Window window;
                Window window2;
                AppMethodBeat.i(630);
                int intValue = num.intValue();
                com.tencent.mm.sticker.c cVar3 = cVar;
                p.h(cVar3, "info");
                int itemCount = this.rtG.rts.getItemCount();
                if (intValue >= 0 && itemCount > intValue) {
                    chz chz = cVar3.NMJ;
                    f.a aVar = com.tencent.mm.plugin.emojicapture.model.a.f.rpr;
                    if (p.j(chz, com.tencent.mm.plugin.emojicapture.model.a.f.rpm)) {
                        EditorStickerView editorStickerView = this.rtG;
                        EmojiCaptureReporter emojiCaptureReporter = editorStickerView.rqJ;
                        if (emojiCaptureReporter != null) {
                            emojiCaptureReporter.cIs();
                        }
                        if (editorStickerView.rtB == null) {
                            editorStickerView.rtx.cJk();
                            editorStickerView.rtB = new android.support.design.widget.a(editorStickerView.getContext());
                            Context context = editorStickerView.getContext();
                            p.g(context, "context");
                            editorStickerView.rtA = new MoreStickerView(context);
                            MoreStickerView moreStickerView = editorStickerView.rtA;
                            if (moreStickerView != null) {
                                moreStickerView.setReporter(editorStickerView.rqJ);
                            }
                            MoreStickerView moreStickerView2 = editorStickerView.rtA;
                            if (moreStickerView2 != null) {
                                moreStickerView2.setBackgroundResource(R.drawable.emoji_capture_sticker_panel_bg);
                            }
                            float dimension = editorStickerView.getResources().getDimension(R.dimen.a1z) + editorStickerView.getResources().getDimension(R.dimen.a1x) + editorStickerView.getResources().getDimension(R.dimen.ag4);
                            ViewParent parent = editorStickerView.getParent();
                            if (parent == null) {
                                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                                AppMethodBeat.o(630);
                                throw tVar;
                            }
                            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, ((ViewGroup) parent).getHeight() - ((int) dimension));
                            android.support.design.widget.a aVar2 = editorStickerView.rtB;
                            if (aVar2 != null) {
                                MoreStickerView moreStickerView3 = editorStickerView.rtA;
                                if (moreStickerView3 == null) {
                                    p.hyc();
                                }
                                aVar2.setContentView(moreStickerView3, marginLayoutParams);
                            }
                            android.support.design.widget.a aVar3 = editorStickerView.rtB;
                            if (!(aVar3 == null || (window2 = aVar3.getWindow()) == null)) {
                                window2.clearFlags(2);
                            }
                            android.support.design.widget.a aVar4 = editorStickerView.rtB;
                            if (!(aVar4 == null || (window = aVar4.getWindow()) == null)) {
                                window.addFlags(1024);
                            }
                            android.support.design.widget.a aVar5 = editorStickerView.rtB;
                            if (aVar5 != null) {
                                aVar5.setOnDismissListener(new e(editorStickerView));
                            }
                            com.tencent.mm.plugin.emojicapture.model.a.a aVar6 = editorStickerView.rtz;
                            MoreStickerView moreStickerView4 = editorStickerView.rtA;
                            if (moreStickerView4 != null) {
                                cVar2 = moreStickerView4.getDataCallback();
                            } else {
                                cVar2 = null;
                            }
                            aVar6.roK = cVar2;
                            if (cVar2 != null) {
                                cVar2.ad(aVar6.dataList);
                            }
                            if (cVar2 != null) {
                                cVar2.fH(0, aVar6.dataList.size());
                            }
                            MoreStickerView moreStickerView5 = editorStickerView.rtA;
                            if (moreStickerView5 != null) {
                                moreStickerView5.setSelectionCallback(new f(editorStickerView));
                            }
                            MoreStickerView moreStickerView6 = editorStickerView.rtA;
                            if (moreStickerView6 != null) {
                                moreStickerView6.setCloseCallback(new g(editorStickerView));
                            }
                            MoreStickerView moreStickerView7 = editorStickerView.rtA;
                            if (moreStickerView7 != null) {
                                moreStickerView7.setLoadMoreCallback(new h(editorStickerView));
                            }
                        }
                        android.support.design.widget.a aVar7 = editorStickerView.rtB;
                        if (aVar7 != null) {
                            aVar7.show();
                        }
                        MoreStickerView moreStickerView8 = editorStickerView.rtA;
                        if (moreStickerView8 != null) {
                            moreStickerView8.cJN();
                        }
                        MoreStickerView moreStickerView9 = editorStickerView.rtA;
                        if (moreStickerView9 != null) {
                            moreStickerView9.anp(editorStickerView.rtD);
                        }
                    } else {
                        RecyclerView recyclerView = this.rtG.rtr;
                        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(intValue, new com.tencent.mm.hellhoundlib.b.a());
                        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView$2", "invoke", "(ILcom/tencent/mm/sticker/LensItem;)V", "Undefined", "smoothScrollToPosition", "(I)V");
                        recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView$2", "invoke", "(ILcom/tencent/mm/sticker/LensItem;)V", "Undefined", "smoothScrollToPosition", "(I)V");
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(630);
                return xVar;
            }
        };
        this.rtr.b(new com.tencent.mm.plugin.emojicapture.ui.layout.b(context));
        this.rty = new i(new com.tencent.mm.plugin.emojicapture.model.a.h(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.capture.EditorStickerView.AnonymousClass3 */
            final /* synthetic */ EditorStickerView rtG;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.rtG = r1;
            }

            @Override // com.tencent.mm.plugin.emojicapture.model.a.h
            public final void ad(List<com.tencent.mm.sticker.c> list) {
                AppMethodBeat.i(633);
                p.h(list, "lensList");
                Log.i(this.rtG.TAG, "update: " + list.size());
                if (!list.isEmpty()) {
                    this.rtG.rtr.setVisibility(0);
                    this.rtG.rtq.setVisibility(0);
                } else {
                    this.rtG.rtr.setVisibility(8);
                    this.rtG.rtq.setVisibility(8);
                    this.rtG.va = -1;
                    m<com.tencent.mm.sticker.f, chz, x> selectionCallback = this.rtG.getSelectionCallback();
                    if (selectionCallback != null) {
                        selectionCallback.invoke(null, null);
                    }
                }
                com.tencent.mm.plugin.emojicapture.ui.a.b bVar = this.rtG.rts;
                p.h(list, "lensList");
                Log.i(com.tencent.mm.plugin.emojicapture.ui.a.b.TAG, "update: " + list.size());
                bVar.rsC.clear();
                bVar.rsC.addAll(list);
                AppMethodBeat.o(633);
            }

            @Override // com.tencent.mm.plugin.emojicapture.model.a.h
            public final void Gn(int i2) {
                AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.c.CTRL_INDEX);
                Log.i(this.rtG.TAG, "updateSelection, ".concat(String.valueOf(i2)));
                this.rtG.rtr.post(new a(this, i2));
                AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.c.CTRL_INDEX);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.EditorStickerView$3$a */
            static final class a implements Runnable {
                final /* synthetic */ int gUj;
                final /* synthetic */ AnonymousClass3 rtH;

                a(AnonymousClass3 r1, int i2) {
                    this.rtH = r1;
                    this.gUj = i2;
                }

                public final void run() {
                    AppMethodBeat.i(632);
                    RecyclerView recyclerView = this.rtH.rtG.rtr;
                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(this.gUj, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView$3$updateSelection$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                    recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView$3$updateSelection$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                    EditorStickerView.a(this.rtH.rtG, this.gUj);
                    this.rtH.rtG.rtr.post(new Runnable(this) {
                        /* class com.tencent.mm.plugin.emojicapture.ui.capture.EditorStickerView.AnonymousClass3.a.AnonymousClass1 */
                        final /* synthetic */ a rtI;

                        {
                            this.rtI = r1;
                        }

                        public final void run() {
                            AppMethodBeat.i(631);
                            EditorStickerView.l(this.rtI.rtH.rtG);
                            AppMethodBeat.o(631);
                        }
                    });
                    AppMethodBeat.o(632);
                }
            }
        }, this.rts);
        this.rtx = new com.tencent.mm.plugin.emojicapture.model.a.f((MMActivity) context, new com.tencent.mm.plugin.emojicapture.model.a.e(this.rty, this.rtz));
        this.rtr.a(new RecyclerView.l(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.capture.EditorStickerView.AnonymousClass4 */
            final /* synthetic */ EditorStickerView rtG;

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                AppMethodBeat.i(256444);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                bVar.pH(i3);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
                super.onScrolled(recyclerView, i2, i3);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(256444);
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.rtG = r1;
            }

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b.CTRL_INDEX);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
                p.h(recyclerView, "recyclerView");
                if (i2 == 0) {
                    EditorStickerView.l(this.rtG);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b.CTRL_INDEX);
            }
        });
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.n.a.CTRL_INDEX);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EditorStickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(API_openWeAppSearch.CTRL_INDEX);
        AppMethodBeat.o(API_openWeAppSearch.CTRL_INDEX);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.m<? super com.tencent.mm.sticker.f, ? super com.tencent.mm.protocal.protobuf.chz, kotlin.x>, kotlin.g.a.m<com.tencent.mm.sticker.f, com.tencent.mm.protocal.protobuf.chz, kotlin.x> */
    public final m<com.tencent.mm.sticker.f, chz, x> getSelectionCallback() {
        return this.rtw;
    }

    public final void setSelectionCallback(m<? super com.tencent.mm.sticker.f, ? super chz, x> mVar) {
        this.rtw = mVar;
    }

    public final EmojiCaptureReporter getReporter() {
        return this.rqJ;
    }

    public final void setReporter(EmojiCaptureReporter emojiCaptureReporter) {
        this.rqJ = emojiCaptureReporter;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView$downloadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojicapture_release"})
    public static final class a implements com.tencent.mm.loader.g.f<com.tencent.mm.sticker.loader.g> {
        final /* synthetic */ EditorStickerView rtG;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(EditorStickerView editorStickerView) {
            this.rtG = editorStickerView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.g.c, com.tencent.mm.loader.g.j] */
        @Override // com.tencent.mm.loader.g.f
        public final /* synthetic */ void a(com.tencent.mm.sticker.loader.g gVar, j jVar) {
            AppMethodBeat.i(636);
            com.tencent.mm.sticker.loader.g gVar2 = gVar;
            p.h(gVar2, "task");
            p.h(jVar, "status");
            if (p.j(gVar2.NNU.rnS, this.rtG.rtD)) {
                Log.i(this.rtG.TAG, "onLoaderFin: ".concat(String.valueOf(jVar)));
                EditorStickerView.a(this.rtG, jVar);
            }
            AppMethodBeat.o(636);
        }
    }

    public final void cJM() {
        AppMethodBeat.i(bx.CTRL_INDEX);
        com.tencent.mm.ac.d.a(200, new c(this));
        AppMethodBeat.o(bx.CTRL_INDEX);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    static final class e implements DialogInterface.OnDismissListener {
        final /* synthetic */ EditorStickerView rtG;

        e(EditorStickerView editorStickerView) {
            this.rtG = editorStickerView;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(639);
            chz chz = this.rtG.rtE;
            if (chz != null) {
                this.rtG.rtx.a(chz);
                this.rtG.rty.setSelection(chz.Lso);
            }
            EmojiCaptureReporter reporter = this.rtG.getReporter();
            if (reporter != null) {
                reporter.cIt();
                AppMethodBeat.o(639);
                return;
            }
            AppMethodBeat.o(639);
        }
    }

    private final void c(j jVar) {
        AppMethodBeat.i(cz.CTRL_INDEX);
        Log.i(this.TAG, "notifyStatus: " + this.rtD);
        if (this.rtD == null || jVar != j.OK) {
            m<? super com.tencent.mm.sticker.f, ? super chz, x> mVar = this.rtw;
            if (mVar != null) {
                mVar.invoke(null, null);
                AppMethodBeat.o(cz.CTRL_INDEX);
                return;
            }
            AppMethodBeat.o(cz.CTRL_INDEX);
            return;
        }
        com.tencent.mm.sticker.loader.e eVar = com.tencent.mm.sticker.loader.e.NNN;
        String str = this.rtD;
        if (str == null) {
            p.hyc();
        }
        String biw = com.tencent.mm.sticker.loader.e.biw(str);
        f.a aVar = com.tencent.mm.sticker.f.NNw;
        com.tencent.mm.sticker.f bit = f.a.bit(biw);
        if (bit.isValid()) {
            if (Util.isNullOrNil(bit.rnS)) {
                String str2 = this.rtD;
                if (str2 == null) {
                    p.hyc();
                }
                bit.biq(str2);
            }
            m<? super com.tencent.mm.sticker.f, ? super chz, x> mVar2 = this.rtw;
            if (mVar2 != null) {
                mVar2.invoke(bit, this.rtC);
                AppMethodBeat.o(cz.CTRL_INDEX);
                return;
            }
            AppMethodBeat.o(cz.CTRL_INDEX);
            return;
        }
        Log.i(this.TAG, "onLoaderFin: sticker is not valid");
        s.deleteDir(biw);
        AppMethodBeat.o(cz.CTRL_INDEX);
    }

    public final void setShow(boolean z) {
        AppMethodBeat.i(645);
        if (z) {
            com.tencent.mm.plugin.emojicapture.model.a.f fVar = this.rtx;
            if (!fVar.rpf) {
                fVar.rpf = true;
                fVar.roR.clear();
                fVar.cJm();
                fVar.cJl();
                fVar.cJn();
                fVar.cJk();
                com.tencent.mm.sticker.a.b bVar = com.tencent.mm.sticker.a.b.NOi;
                com.tencent.mm.sticker.a.b.ae(new f.c(fVar));
                com.tencent.mm.sticker.a.b bVar2 = com.tencent.mm.sticker.a.b.NOi;
                com.tencent.mm.sticker.a.b.gzg();
            }
            if (getVisibility() == 0 && getAlpha() == 1.0f) {
                AppMethodBeat.o(645);
                return;
            }
            setVisibility(0);
            animate().cancel();
            animate().alpha(1.0f).start();
            MoreStickerView moreStickerView = this.rtA;
            if (moreStickerView != null) {
                moreStickerView.anp(null);
                AppMethodBeat.o(645);
                return;
            }
            AppMethodBeat.o(645);
        } else if (getVisibility() != 0 || getAlpha() == 0.0f) {
            AppMethodBeat.o(645);
        } else {
            animate().cancel();
            animate().alpha(0.0f).withEndAction(new d(this)).start();
            AppMethodBeat.o(645);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ EditorStickerView rtG;

        d(EditorStickerView editorStickerView) {
            this.rtG = editorStickerView;
        }

        public final void run() {
            AppMethodBeat.i(638);
            this.rtG.setVisibility(8);
            AppMethodBeat.o(638);
        }
    }

    public final void setOnVisibleChangeCallback(kotlin.g.a.b<? super Boolean, x> bVar) {
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ EditorStickerView rtG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(EditorStickerView editorStickerView) {
            super(0);
            this.rtG = editorStickerView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(637);
            android.support.design.widget.a aVar = this.rtG.rtB;
            if (aVar == null || !aVar.isShowing()) {
                EditorStickerView.a(this.rtG, this.rtG.va);
            } else {
                chz chz = this.rtG.rtE;
                if (chz != null) {
                    this.rtG.rtC = chz;
                    this.rtG.rtD = chz.Lso;
                    com.tencent.mm.sticker.loader.e eVar = com.tencent.mm.sticker.loader.e.NNN;
                    j d2 = com.tencent.mm.sticker.loader.e.d(chz);
                    if (d2 == j.OK) {
                        EditorStickerView.a(this.rtG, d2);
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(637);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ EditorStickerView rtG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(EditorStickerView editorStickerView) {
            super(0);
            this.rtG = editorStickerView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(174298);
            com.tencent.mm.sticker.c Gs = this.rtG.rts.Gs(this.rtG.va);
            if (Gs != null) {
                f.a aVar = com.tencent.mm.plugin.emojicapture.model.a.f.rpr;
                if (f.a.b(Gs.NMJ)) {
                    com.tencent.mm.sticker.a.b bVar = com.tencent.mm.sticker.a.b.NOi;
                    com.tencent.mm.sticker.a.b.f(Gs.NMJ);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(174298);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ EditorStickerView rtG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(EditorStickerView editorStickerView) {
            super(0);
            this.rtG = editorStickerView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(JsApiSetBackgroundFetchToken.CTRL_INDEX);
            android.support.design.widget.a aVar = this.rtG.rtB;
            if (aVar != null) {
                aVar.dismiss();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(JsApiSetBackgroundFetchToken.CTRL_INDEX);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ EditorStickerView rtG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(EditorStickerView editorStickerView) {
            super(0);
            this.rtG = editorStickerView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(bw.CTRL_INDEX);
            this.rtG.rtx.cJk();
            x xVar = x.SXb;
            AppMethodBeat.o(bw.CTRL_INDEX);
            return xVar;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0054 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(com.tencent.mm.plugin.emojicapture.ui.capture.EditorStickerView r6, int r7) {
        /*
        // Method dump skipped, instructions count: 140
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emojicapture.ui.capture.EditorStickerView.a(com.tencent.mm.plugin.emojicapture.ui.capture.EditorStickerView, int):void");
    }

    public static final /* synthetic */ void l(EditorStickerView editorStickerView) {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.b.CTRL_INDEX);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        boolean z = true;
        int childCount = editorStickerView.rtr.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            com.tencent.mm.sticker.c Gs = editorStickerView.rts.Gs(RecyclerView.bw(editorStickerView.rtr.getChildAt(i2)));
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
        EmojiCaptureReporter emojiCaptureReporter = editorStickerView.rqJ;
        if (emojiCaptureReporter != null) {
            emojiCaptureReporter.fY(sb.toString(), sb2.toString());
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.b.CTRL_INDEX);
            return;
        }
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.b.CTRL_INDEX);
    }
}
