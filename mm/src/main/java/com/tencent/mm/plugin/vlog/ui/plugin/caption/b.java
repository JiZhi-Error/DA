package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.c;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.ui.plugin.caption.a;
import com.tencent.mm.plugin.vlog.ui.plugin.e;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;
import kotlinx.coroutines.f;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u0000 f2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001fB%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010B\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020\u0016J\u000e\u0010D\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u0012J \u0010E\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b2\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u0006\u0010F\u001a\u00020\u001dJ\u0006\u0010G\u001a\u00020\u0016J\u0010\u0010H\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J&\u0010I\u001a\u00020\u001d2\u001e\u0010J\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020L0K0\u001fJ\b\u0010M\u001a\u00020\u001dH\u0016J\u0010\u0010N\u001a\u00020\u001d2\u0006\u0010O\u001a\u00020LH\u0016J\u0012\u0010P\u001a\u00020\u001d2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\"\u0010S\u001a\u00020\u001d2\b\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010V\u001a\u00020L2\u0006\u0010W\u001a\u000202H\u0016J\b\u0010X\u001a\u00020\u001dH\u0016J\b\u0010Y\u001a\u00020\u001dH\u0016J\u0010\u0010Z\u001a\u00020\u001d2\u0006\u0010[\u001a\u00020\u0012H\u0016J\u0010\u0010\\\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020\u0012H\u0016J\u000e\u0010^\u001a\u00020\u001d2\u0006\u0010_\u001a\u00020`J*\u0010a\u001a\u00020\u001d2\u0006\u0010_\u001a\u00020`2\u0006\u0010b\u001a\u00020\u00122\u0006\u0010c\u001a\u00020\u00122\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\u0016J\u0010\u0010e\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u0012H\u0002R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R|\u0010\u0010\u001ap\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0018\u0012'\u0012%\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001b¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d0\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\n \u000f*\u0004\u0018\u00010(0(X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010)\u001a\n \u000f*\u0004\u0018\u00010*0*X\u0004¢\u0006\u0002\n\u0000R0\u0010+\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020-0,j\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020-`.0\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R$\u0010/\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002000\u0019j\b\u0012\u0004\u0012\u000200`\u001b0\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u000e¢\u0006\u0002\n\u0000R$\u00103\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001604j\b\u0012\u0004\u0012\u00020\u0016`50\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R$\u0010<\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b0\u001fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0016\u0010A\u001a\n \u000f*\u0004\u0018\u00010(0(X\u0004¢\u0006\u0002\n\u0000¨\u0006g"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorCaptionPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseIconPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewUpdateCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "parent", "Landroid/view/ViewGroup;", "previewHolder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "editHolder", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "btnRoot", "Landroid/view/View;", "kotlin.jvm.PlatformType", "callback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "type", "", "key", "ret", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "transition", "", "captionDatas", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem;", "captionEditClickCount", "captionEditView", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView;", "captionIconClickCount", "captionView", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView;", "checkIcon", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "dataMangerMaps", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditCaptionDataManager;", "Lkotlin/collections/HashMap;", "editRenderScripts", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/EditRenderScript;", "enableCaption", "", "invalidSets", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "lock", "Ljava/lang/Object;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "scriptTransResults", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "view", "addVideoPath", "path", "clearCaption", "getScriptTransResult", "incCaptionEditClickCount", "kvCaptionInfo", "notifyCaptionViewUpdate", "onApplyRecords", "records", "Lkotlin/Triple;", "", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "onUpdate", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "seekTo", "seekToOriginPosition", "release", "reset", "resetIconColor", "iconColor", "setVisibility", "visibility", "showCaptionEditView", "transResult", "", "updateCaption", "color", "bgColor", "font", "voiceTranslate", "Companion", "plugin-vlog_release"})
public final class b implements t, e.c, e.d {
    public static final a GKn = new a((byte) 0);
    private final View GJZ = this.parent.findViewById(R.id.bwj);
    private final ImageView GKa = ((ImageView) this.parent.findViewById(R.id.bwk));
    private final d GKb;
    private final c GKc;
    private final List<HashMap<String, a>> GKd;
    private final List<ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a>> GKe;
    private final List<ArrayList<sy>> GKf;
    private final List<HashSet<String>> GKg;
    private final List<c> GKh;
    private boolean GKi;
    private int GKj;
    private int GKk;
    private final EditorPanelHolder GKl;
    private final EditorPanelHolder GKm;
    private final Context context = this.parent.getContext();
    private final r<Integer, String, Integer, ArrayList<sy>, x> hFV;
    private final Object lock;
    private ViewGroup parent;
    private final ImageView tkI = ((ImageView) this.parent.findViewById(R.id.bwi));
    d wgr;

    static {
        AppMethodBeat.i(191639);
        AppMethodBeat.o(191639);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "type", "", "key", "", "ret", "transition", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.vlog.ui.plugin.caption.b$b  reason: collision with other inner class name */
    static final class C1863b extends q implements r<Integer, String, Integer, ArrayList<sy>, x> {
        final /* synthetic */ b GKo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1863b(b bVar) {
            super(4);
            this.GKo = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(Integer num, String str, Integer num2, ArrayList<sy> arrayList) {
            int i2;
            AppMethodBeat.i(191623);
            int intValue = num.intValue();
            String str2 = str;
            int intValue2 = num2.intValue();
            ArrayList<sy> arrayList2 = arrayList;
            p.h(str2, "key");
            synchronized (this.GKo.lock) {
                try {
                    Log.i("MicroMsg.EditorCaptionPlugin", "callback key:" + str2 + " ret:" + intValue2 + " size:" + (arrayList2 != null ? Integer.valueOf(arrayList2.size()) : null));
                    if (intValue2 != 0) {
                        ((HashSet) this.GKo.GKg.get(intValue)).add(str2);
                        if (((HashSet) this.GKo.GKg.get(intValue)).size() >= ((HashMap) this.GKo.GKd.get(intValue)).size()) {
                            if (intValue2 == -2) {
                                i2 = R.string.hxy;
                            } else {
                                i2 = R.string.hxv;
                            }
                            u.makeText(this.GKo.context, com.tencent.mm.cb.a.aI(this.GKo.context, i2), 0).show();
                            this.GKo.GKb.cE(intValue, com.tencent.mm.cb.a.aI(this.GKo.context, R.string.hw1));
                            this.GKo.GKi = true;
                            x xVar = x.SXb;
                        }
                    }
                    b.a(this.GKo, intValue);
                    b.b(this.GKo, intValue);
                    x xVar2 = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(191623);
                    throw th;
                }
            }
            x xVar3 = x.SXb;
            AppMethodBeat.o(191623);
            return xVar3;
        }
    }

    public b(ViewGroup viewGroup, EditorPanelHolder editorPanelHolder, EditorPanelHolder editorPanelHolder2, d dVar) {
        p.h(viewGroup, "parent");
        p.h(editorPanelHolder, "previewHolder");
        p.h(editorPanelHolder2, "editHolder");
        p.h(dVar, "status");
        AppMethodBeat.i(191638);
        this.parent = viewGroup;
        this.GKl = editorPanelHolder;
        this.GKm = editorPanelHolder2;
        this.wgr = dVar;
        Context context2 = this.context;
        p.g(context2, "context");
        this.GKb = new d(context2);
        Context context3 = this.context;
        p.g(context3, "context");
        this.GKc = new c(context3);
        this.GKd = j.listOf((Object[]) new HashMap[]{new HashMap(), new HashMap()});
        this.GKe = j.listOf((Object[]) new ArrayList[]{new ArrayList(), new ArrayList()});
        this.GKf = j.listOf((Object[]) new ArrayList[]{new ArrayList(), new ArrayList()});
        this.GKg = j.listOf((Object[]) new HashSet[]{new HashSet(), new HashSet()});
        this.GKh = j.listOf((Object[]) new c[]{new c(com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CAPTION), new c(com.tencent.mm.plugin.recordvideo.ui.editor.item.d.RECORD_CAPTION)});
        this.lock = new Object();
        this.hFV = new C1863b(this);
        this.parent.setVisibility(0);
        this.tkI.setImageDrawable(ar.m(this.context, R.raw.icons_filled_caption, -1));
        ImageView imageView = this.GKa;
        Context context4 = this.context;
        p.g(context4, "context");
        imageView.setImageDrawable(context4.getResources().getDrawable(R.raw.popvideo_post_selected_origin));
        EditorPanelHolder.a(this.GKl, this.GKb);
        this.GKm.setCoverByKeyboard(true);
        EditorPanelHolder.a(this.GKm, this.GKc);
        this.GKl.setOnVisibleChangeCallback(new kotlin.g.a.b<Boolean, x>(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.caption.b.AnonymousClass1 */
            final /* synthetic */ b GKo;

            {
                this.GKo = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                AppMethodBeat.i(191612);
                if (bool.booleanValue()) {
                    d.b.a(this.GKo.wgr, d.c.BWL);
                } else {
                    d.b.a(this.GKo.wgr, d.c.BWM);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(191612);
                return xVar;
            }
        });
        this.GKm.setOnVisibleChangeCallback(new kotlin.g.a.b<Boolean, x>(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.caption.b.AnonymousClass4 */
            final /* synthetic */ b GKo;

            {
                this.GKo = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                AppMethodBeat.i(191615);
                if (!bool.booleanValue()) {
                    this.GKo.GKc.gyh.close();
                    c cVar = this.GKo.GKc;
                    Object systemService = cVar.getContext().getSystemService("input_method");
                    if (systemService == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                        AppMethodBeat.o(191615);
                        throw tVar;
                    }
                    ((InputMethodManager) systemService).hideSoftInputFromWindow(cVar.getWindowToken(), 0);
                    d.b.a(this.GKo.wgr, d.c.BVs);
                    d.b.a(this.GKo.wgr, d.c.BWM);
                } else {
                    d.b.a(this.GKo.wgr, d.c.BWL);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(191615);
                return xVar;
            }
        });
        this.GKb.setVideoPauseListener(new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.caption.b.AnonymousClass5 */
            final /* synthetic */ b GKo;

            {
                this.GKo = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(191616);
                d.b.a(this.GKo.wgr, d.c.BVr);
                x xVar = x.SXb;
                AppMethodBeat.o(191616);
                return xVar;
            }
        });
        this.GKb.setVideoSeekListener(new kotlin.g.a.b<Long, x>(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.caption.b.AnonymousClass6 */
            final /* synthetic */ b GKo;

            {
                this.GKo = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Long l) {
                AppMethodBeat.i(191617);
                long longValue = l.longValue();
                Bundle bundle = new Bundle();
                bundle.putInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT", (int) longValue);
                this.GKo.wgr.a(d.c.BUW, bundle);
                d.b.a(this.GKo.wgr, d.c.BVs);
                x xVar = x.SXb;
                AppMethodBeat.o(191617);
                return xVar;
            }
        });
        this.GKb.setStartTransListener(new kotlin.g.a.b<Integer, x>(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.caption.b.AnonymousClass7 */
            final /* synthetic */ b GKo;

            {
                this.GKo = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Integer num) {
                AppMethodBeat.i(191618);
                int intValue = num.intValue();
                this.GKo.GKl.setShow(false);
                b.c(this.GKo, intValue);
                x xVar = x.SXb;
                AppMethodBeat.o(191618);
                return xVar;
            }
        });
        this.GKb.setClearTransListener(new m<Integer, Boolean, x>(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.caption.b.AnonymousClass8 */
            final /* synthetic */ b GKo;

            {
                this.GKo = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Integer num, Boolean bool) {
                AppMethodBeat.i(191619);
                int intValue = num.intValue();
                boolean booleanValue = bool.booleanValue();
                ((c) this.GKo.GKh.get(intValue)).CeH.clear();
                ImageView imageView = this.GKo.GKa;
                p.g(imageView, "checkIcon");
                imageView.setVisibility(booleanValue ? 0 : 4);
                this.GKo.GKi = booleanValue;
                d dVar = this.GKo.wgr;
                d.c cVar = d.c.BWt;
                Bundle bundle = new Bundle();
                bundle.putInt("PARAM_1_INT", intValue);
                dVar.a(cVar, bundle);
                x xVar = x.SXb;
                AppMethodBeat.o(191619);
                return xVar;
            }
        });
        this.GKb.setDismissListener(new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.caption.b.AnonymousClass9 */
            final /* synthetic */ b GKo;

            {
                this.GKo = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(191620);
                this.GKo.GKl.setShow(false);
                x xVar = x.SXb;
                AppMethodBeat.o(191620);
                return xVar;
            }
        });
        this.GKb.setItemClickListener(new m<Integer, sy, x>(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.caption.b.AnonymousClass10 */
            final /* synthetic */ b GKo;

            {
                this.GKo = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Integer num, sy syVar) {
                AppMethodBeat.i(191621);
                int intValue = num.intValue();
                sy syVar2 = syVar;
                p.h(syVar2, "result");
                this.GKo.fDT();
                this.GKo.GKl.setShow(false);
                d.b.a(this.GKo.wgr, d.c.BVr);
                d.b.a(this.GKo.wgr, d.c.BVG);
                this.GKo.GKc.GKp = intValue;
                this.GKo.GKc.a(syVar2);
                this.GKo.GKc.fDV();
                this.GKo.GKc.hU((List) this.GKo.GKf.get(intValue));
                this.GKo.GKc.GKr.notifyDataSetChanged();
                this.GKo.GKc.gyh.start();
                this.GKo.GKm.setShow(true);
                x xVar = x.SXb;
                AppMethodBeat.o(191621);
                return xVar;
            }
        });
        this.GKc.setCancelClickListener(new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.caption.b.AnonymousClass11 */
            final /* synthetic */ b GKo;

            {
                this.GKo = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(191622);
                this.GKo.GKm.setShow(false);
                d.b.a(this.GKo.wgr, d.c.BVs);
                x xVar = x.SXb;
                AppMethodBeat.o(191622);
                return xVar;
            }
        });
        this.GKc.setSureClickListener(new m<Integer, ArrayList<sy>, x>(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.caption.b.AnonymousClass2 */
            final /* synthetic */ b GKo;

            {
                this.GKo = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Integer num, ArrayList<sy> arrayList) {
                AppMethodBeat.i(191613);
                int intValue = num.intValue();
                ArrayList<sy> arrayList2 = arrayList;
                p.h(arrayList2, "result");
                this.GKo.GKm.setShow(false);
                ((ArrayList) this.GKo.GKf.get(intValue)).clear();
                ((ArrayList) this.GKo.GKf.get(intValue)).addAll(arrayList2);
                b.b(this.GKo, intValue);
                d.b.a(this.GKo.wgr, d.c.BVs);
                x xVar = x.SXb;
                AppMethodBeat.o(191613);
                return xVar;
            }
        });
        this.tkI.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.caption.b.AnonymousClass3 */
            final /* synthetic */ b GKo;

            {
                this.GKo = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(191614);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorCaptionPlugin$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.GKo.GKj++;
                if (!this.GKo.GKi) {
                    this.GKo.GKi = true;
                    b.a(this.GKo, 0);
                    b.b(this.GKo, 0);
                    b.c(this.GKo, 0);
                } else {
                    this.GKo.GKl.setShow(true);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorCaptionPlugin$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(191614);
            }
        });
        AppMethodBeat.o(191638);
    }

    public static final /* synthetic */ ArrayList a(b bVar, int i2) {
        AppMethodBeat.i(191641);
        ArrayList<sy> acG = bVar.acG(i2);
        AppMethodBeat.o(191641);
        return acG;
    }

    public static final /* synthetic */ void b(b bVar, int i2) {
        AppMethodBeat.i(191642);
        bVar.acE(i2);
        AppMethodBeat.o(191642);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return null;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(191640);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(191640);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorCaptionPlugin$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private final void acE(int i2) {
        Object obj;
        boolean z;
        AppMethodBeat.i(191624);
        ArrayList arrayList = new ArrayList(this.GKh.get(i2).CeH);
        ArrayList<sy> arrayList2 = this.GKf.get(i2);
        ArrayList arrayList3 = new ArrayList(j.a(arrayList2, 10));
        for (T t : arrayList2) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                Object next = it.next();
                if (((sy) next).id == t.id) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    obj = next;
                    break;
                }
            }
            sy syVar = (sy) obj;
            if (syVar != null) {
                t.LaS = syVar.LaS;
            }
            arrayList3.add(t);
        }
        ArrayList arrayList4 = arrayList3;
        Iterator<T> it2 = this.GKf.get(i2).iterator();
        boolean z2 = false;
        while (it2.hasNext()) {
            if (!it2.next().LaV) {
                d dVar = this.GKb;
                p.h(arrayList4, "items");
                dVar.acH(i2);
                sy syVar2 = new sy();
                syVar2.LaT = -2;
                syVar2.LaU = -1;
                dVar.GKW.get(i2).GKy.add(syVar2);
                dVar.GKW.get(i2).GKy.add(syVar2);
                dVar.GKW.get(i2).GKy.addAll(arrayList4);
                sy syVar3 = new sy();
                syVar3.LaT = 2147483645;
                syVar3.LaU = 2147483646;
                dVar.GKW.get(i2).GKy.add(syVar3);
                dVar.GKW.get(i2).GKy.add(syVar3);
                this.GKb.acI(i2);
                z2 = true;
            }
        }
        this.GKh.get(i2).CeH.clear();
        this.GKh.get(i2).CeH.addAll(arrayList4);
        ImageView imageView = this.GKa;
        p.g(imageView, "checkIcon");
        if (imageView.getVisibility() == 0) {
            if (z2) {
                d dVar2 = this.GKb;
                if (i2 == 0) {
                    View loadingView = dVar2.getLoadingView();
                    p.g(loadingView, "loadingView");
                    loadingView.setVisibility(4);
                    LinearLayout emptyLayout = dVar2.getEmptyLayout();
                    p.g(emptyLayout, "emptyLayout");
                    emptyLayout.setVisibility(4);
                    LinearLayout contentLayout = dVar2.getContentLayout();
                    p.g(contentLayout, "contentLayout");
                    contentLayout.setVisibility(0);
                } else {
                    View recordLoadingView = dVar2.getRecordLoadingView();
                    p.g(recordLoadingView, "recordLoadingView");
                    recordLoadingView.setVisibility(4);
                    ViewGroup recordEmptyLayout = dVar2.getRecordEmptyLayout();
                    p.g(recordEmptyLayout, "recordEmptyLayout");
                    recordEmptyLayout.setVisibility(4);
                    ViewGroup recordContentLayout = dVar2.getRecordContentLayout();
                    p.g(recordContentLayout, "recordContentLayout");
                    recordContentLayout.setVisibility(0);
                }
            }
            Bundle bundle = new Bundle();
            bundle.putInt("PARAM_1_INT", i2);
            bundle.putByteArray("PARAM_1_BYTEARRAY", this.GKh.get(i2).eMj().toByteArray());
            this.wgr.a(d.c.BWp, bundle);
        }
        AppMethodBeat.o(191624);
    }

    public final void aUn(String str) {
        AppMethodBeat.i(191625);
        p.h(str, "path");
        if (!s.YS(str)) {
            Log.e("MicroMsg.EditorCaptionPlugin", "file not exist ".concat(String.valueOf(str)));
        } else if (this.GKd.get(0).get(str) == null) {
            this.GKd.get(0).put(str, new a());
            AppMethodBeat.o(191625);
            return;
        }
        AppMethodBeat.o(191625);
    }

    public final void a(byte[] bArr, int i2, int i3, String str) {
        T t;
        boolean z;
        AppMethodBeat.i(191626);
        p.h(bArr, "transResult");
        try {
            sy syVar = new sy();
            try {
                syVar.parseFrom(bArr);
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
                syVar = null;
            }
            sy syVar2 = syVar;
            if (syVar2 != null) {
                int i4 = 0;
                for (T t2 : this.GKh) {
                    int i5 = i4 + 1;
                    if (i4 < 0) {
                        j.hxH();
                    }
                    T t3 = t2;
                    Iterator<T> it = t3.CeH.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            t = null;
                            break;
                        }
                        T next = it.next();
                        if (next.id == syVar2.id) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                            t = next;
                            break;
                        }
                    }
                    T t4 = t;
                    if (t4 != null) {
                        d dVar = this.GKb;
                        p.h(syVar2, "transResult");
                        int i6 = 0;
                        Iterator<T> it2 = dVar.GKW.get(i4).GKy.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            T next2 = it2.next();
                            int i7 = i6 + 1;
                            if (i6 < 0) {
                                j.hxH();
                            }
                            T t5 = next2;
                            if (t5.id == syVar2.id) {
                                t5.LaS = syVar2.LaS;
                                dVar.GKW.get(i4).ci(i6);
                                break;
                            }
                            i6 = i7;
                        }
                        t3.textColor = i2;
                        t3.bgColor = i3;
                        t3.CeI = str;
                        t4.LaS = syVar2.LaS;
                        Bundle bundle = new Bundle();
                        bundle.putInt("PARAM_1_INT", i4);
                        bundle.putByteArray("PARAM_1_BYTEARRAY", t3.eMj().toByteArray());
                        this.wgr.a(d.c.BWp, bundle);
                        i4 = i5;
                    } else {
                        i4 = i5;
                    }
                }
                AppMethodBeat.o(191626);
                return;
            }
            AppMethodBeat.o(191626);
        } catch (IOException e3) {
            Log.printErrStackTrace("MicroMsg.EditorCaptionPlugin", e3, "", new Object[0]);
            AppMethodBeat.o(191626);
        }
    }

    public final void ce(byte[] bArr) {
        T t;
        boolean z;
        AppMethodBeat.i(191627);
        p.h(bArr, "transResult");
        try {
            sy syVar = new sy();
            try {
                syVar.parseFrom(bArr);
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
                syVar = null;
            }
            sy syVar2 = syVar;
            if (syVar2 != null) {
                int i2 = 0;
                for (T t2 : this.GKh) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        j.hxH();
                    }
                    Iterator<T> it = t2.CeH.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            t = null;
                            break;
                        }
                        T next = it.next();
                        if (next.id == syVar2.id) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                            t = next;
                            break;
                        }
                    }
                    if (t != null) {
                        this.GKc.GKp = i2;
                        this.GKc.a(syVar2);
                        this.GKc.fDV();
                        this.GKc.hU(this.GKf.get(i2));
                        this.GKc.GKr.notifyDataSetChanged();
                        this.GKc.gyh.start();
                        this.GKm.setShow(true);
                        i2 = i3;
                    } else {
                        i2 = i3;
                    }
                }
                AppMethodBeat.o(191627);
                return;
            }
            AppMethodBeat.o(191627);
        } catch (IOException e3) {
            Log.printErrStackTrace("MicroMsg.EditorCaptionPlugin", e3, "", new Object[0]);
            AppMethodBeat.o(191627);
        }
    }

    public final void acF(int i2) {
        AppMethodBeat.i(191628);
        d.a(this.GKb, i2);
        AppMethodBeat.o(191628);
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.d
    public final void a(ac acVar, long j2, boolean z) {
        AppMethodBeat.i(191629);
        this.GKe.get(0).clear();
        if (acVar != null) {
            for (T t : acVar.fBD()) {
                com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a aVar = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a(t.path, t.GzA.GGz, t.GzA.GGA, t.GzA.mwH);
                this.GKe.get(0).add(aVar);
                Log.i("MicroMsg.EditorCaptionPlugin", "update script:".concat(String.valueOf(aVar)));
            }
        }
        if (!this.GKi) {
            AppMethodBeat.o(191629);
            return;
        }
        acG(0);
        acE(0);
        AppMethodBeat.o(191629);
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.c
    public final void a(e.AbstractC1868e eVar) {
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.c
    public final void onProgress(long j2) {
        AppMethodBeat.i(191630);
        if (!this.GKi) {
            AppMethodBeat.o(191630);
            return;
        }
        this.GKb.aL(0, j2);
        this.GKb.aL(1, j2);
        AppMethodBeat.o(191630);
    }

    private final ArrayList<sy> acG(int i2) {
        AppMethodBeat.i(191631);
        this.GKf.get(i2).clear();
        long j2 = 0;
        for (T t : this.GKe.get(i2)) {
            a aVar = this.GKd.get(i2).get(t.path);
            if (aVar != null) {
                if (aVar.wJy.size() != 0) {
                    Log.i("MicroMsg.EditorCaptionPlugin", "set translate caption. path:" + t.path);
                    for (T t2 : aVar.wJy) {
                        if (t2.LaU >= t.eiq && t2.LaT <= t.Cgu) {
                            sy syVar = new sy();
                            syVar.id = t2.id;
                            syVar.LaS = t2.LaS;
                            syVar.LaT = ((long) ((int) (((float) (t2.LaT - t.eiq)) / t.mwH))) + j2;
                            syVar.LaU = ((long) ((int) (((float) (t2.LaU - t.eiq)) / t.mwH))) + j2;
                            this.GKf.get(i2).add(syVar);
                        }
                    }
                } else if (aVar.wJC == 0 && aVar.tUq) {
                    Log.i("MicroMsg.EditorCaptionPlugin", "set default caption. path:" + t.path);
                    sy syVar2 = new sy();
                    syVar2.id = -1;
                    String aI = com.tencent.mm.cb.a.aI(this.context, R.string.hw2);
                    p.g(aI, "ResourceHelper.getString…tring.video_caption_hint)");
                    Charset charset = kotlin.n.d.UTF_8;
                    if (aI == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                        AppMethodBeat.o(191631);
                        throw tVar;
                    }
                    byte[] bytes = aI.getBytes(charset);
                    p.g(bytes, "(this as java.lang.String).getBytes(charset)");
                    syVar2.LaS = new com.tencent.mm.bw.b(bytes);
                    syVar2.LaT = ((long) ((int) (((float) t.eiq) / t.mwH))) + j2;
                    syVar2.LaU = ((long) ((int) (((float) t.Cgu) / t.mwH))) + j2;
                    syVar2.LaV = true;
                    this.GKf.get(i2).add(syVar2);
                }
            }
            j2 = ((long) ((int) (((float) (t.Cgu - t.eiq)) / t.mwH))) + j2;
        }
        Log.i("MicroMsg.EditorCaptionPlugin", "type:" + i2 + ", scriptTransResult size:" + this.GKf.get(i2).size());
        ArrayList<sy> arrayList = this.GKf.get(i2);
        AppMethodBeat.o(191631);
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
        AppMethodBeat.i(191632);
        this.GKj = 0;
        this.GKk = 0;
        ImageView imageView = this.GKa;
        p.g(imageView, "checkIcon");
        imageView.setVisibility(4);
        this.GKi = false;
        Iterator<T> it = this.GKh.iterator();
        while (it.hasNext()) {
            it.next().CeH.clear();
        }
        Iterator<T> it2 = this.GKd.iterator();
        while (it2.hasNext()) {
            it2.next().clear();
        }
        AppMethodBeat.o(191632);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
        AppMethodBeat.i(191633);
        this.GKc.gyh.setKeyboardHeightObserver(null);
        Iterator<T> it = this.GKd.iterator();
        while (it.hasNext()) {
            for (Map.Entry entry : it.next().entrySet()) {
                a aVar = (a) entry.getValue();
                com.tencent.mm.kernel.b aAg = g.aAg();
                p.g(aAg, "MMKernel.network()");
                aAg.azz().b(3835, aVar);
                try {
                    aVar.ife = true;
                    com.tencent.mm.compatible.i.c cVar = aVar.igg;
                    if (cVar != null) {
                        cVar.release();
                    }
                    aVar.igg = null;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.EditCaptionDataManager", e2, "", new Object[0]);
                }
            }
        }
        AppMethodBeat.o(191633);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(191634);
        View view = this.GJZ;
        p.g(view, "btnRoot");
        view.setVisibility(i2);
        AppMethodBeat.o(191634);
    }

    public final void hT(List<kotlin.r<String, Long, Long>> list) {
        AppMethodBeat.i(191635);
        p.h(list, "records");
        this.GKe.get(1).clear();
        for (T t : list) {
            com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a aVar = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a(t.first, 0, t.SWY.longValue() - t.second.longValue(), 1.0f);
            this.GKe.get(1).add(aVar);
            Log.i("MicroMsg.EditorCaptionPlugin", "update record script:".concat(String.valueOf(aVar)));
        }
        this.GKd.get(1).clear();
        if (!list.isEmpty()) {
            d dVar = this.GKb;
            ViewGroup recordCaptionTab = dVar.getRecordCaptionTab();
            p.g(recordCaptionTab, "recordCaptionTab");
            recordCaptionTab.setVisibility(0);
            View captionTabSpace = dVar.getCaptionTabSpace();
            p.g(captionTabSpace, "captionTabSpace");
            captionTabSpace.setVisibility(0);
            View captionTabIndicator = dVar.getCaptionTabIndicator();
            p.g(captionTabIndicator, "captionTabIndicator");
            captionTabIndicator.setVisibility(0);
            TextView captionTabText = dVar.getCaptionTabText();
            p.g(captionTabText, "captionTabText");
            captionTabText.setText(dVar.getContext().getString(R.string.hvw));
            TextView transBtn = dVar.getTransBtn();
            p.g(transBtn, "transBtn");
            transBtn.setText(dVar.getContext().getString(R.string.hvy));
            dVar.VT(0);
            for (T t2 : list) {
                if (this.GKd.get(1).get(t2.first) == null) {
                    this.GKd.get(1).put(t2.first, new a());
                }
            }
        } else {
            d dVar2 = this.GKb;
            dVar2.VT(0);
            ViewGroup recordCaptionTab2 = dVar2.getRecordCaptionTab();
            p.g(recordCaptionTab2, "recordCaptionTab");
            recordCaptionTab2.setVisibility(8);
            View captionTabSpace2 = dVar2.getCaptionTabSpace();
            p.g(captionTabSpace2, "captionTabSpace");
            captionTabSpace2.setVisibility(8);
            View captionTabIndicator2 = dVar2.getCaptionTabIndicator();
            p.g(captionTabIndicator2, "captionTabIndicator");
            captionTabIndicator2.setVisibility(4);
            TextView captionTabText2 = dVar2.getCaptionTabText();
            p.g(captionTabText2, "captionTabText");
            captionTabText2.setText(dVar2.getContext().getString(R.string.hvv));
            TextView transBtn2 = dVar2.getTransBtn();
            p.g(transBtn2, "transBtn");
            transBtn2.setText(dVar2.getContext().getString(R.string.hvx));
            this.GKd.get(1).clear();
        }
        d.a(this.GKb, 1);
        AppMethodBeat.o(191635);
    }

    public final void fDT() {
        this.GKk++;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x014f A[LOOP:4: B:54:0x0149->B:56:0x014f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x026e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String fDU() {
        /*
        // Method dump skipped, instructions count: 628
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.ui.plugin.caption.b.fDU():java.lang.String");
    }

    public final void VC(int i2) {
        AppMethodBeat.i(191637);
        this.tkI.setImageDrawable(ar.m(this.context, R.raw.icons_filled_caption, i2));
        AppMethodBeat.o(191637);
    }

    public static final /* synthetic */ void c(b bVar, int i2) {
        AppMethodBeat.i(191643);
        Log.i("MicroMsg.EditorCaptionPlugin", "voiceTranslate type:".concat(String.valueOf(i2)));
        ImageView imageView = bVar.GKa;
        p.g(imageView, "checkIcon");
        imageView.setVisibility(0);
        d dVar = bVar.GKb;
        if (i2 == 0) {
            View loadingView = dVar.getLoadingView();
            p.g(loadingView, "loadingView");
            loadingView.setVisibility(0);
            LinearLayout contentLayout = dVar.getContentLayout();
            p.g(contentLayout, "contentLayout");
            contentLayout.setVisibility(4);
            LinearLayout emptyLayout = dVar.getEmptyLayout();
            p.g(emptyLayout, "emptyLayout");
            emptyLayout.setVisibility(4);
        } else {
            View recordLoadingView = dVar.getRecordLoadingView();
            p.g(recordLoadingView, "recordLoadingView");
            recordLoadingView.setVisibility(0);
            ViewGroup recordContentLayout = dVar.getRecordContentLayout();
            p.g(recordContentLayout, "recordContentLayout");
            recordContentLayout.setVisibility(4);
            ViewGroup recordEmptyLayout = dVar.getRecordEmptyLayout();
            p.g(recordEmptyLayout, "recordEmptyLayout");
            recordEmptyLayout.setVisibility(4);
        }
        for (Map.Entry<String, a> entry : bVar.GKd.get(i2).entrySet()) {
            String key = entry.getKey();
            a value = entry.getValue();
            r<Integer, String, Integer, ArrayList<sy>, x> rVar = bVar.hFV;
            p.h(key, "filePath");
            p.h(rVar, "callback");
            Log.i("MicroMsg.EditCaptionDataManager", "[" + value.hashCode() + "]prepare translate file:" + key);
            if (value.wJB || !p.j(key, value.filePath)) {
                value.wJB = false;
                value.tUq = true;
                value.hFV = rVar;
                value.filePath = key;
                int axp = value.axp(key);
                if (axp != 0) {
                    value.tUq = false;
                    rVar.invoke(Integer.valueOf(i2), key, Integer.valueOf(axp), null);
                } else {
                    value.wJC = axp;
                    f.b(bn.TUK, ba.hMW(), new a.b(value, i2, null), 2);
                }
            } else {
                Integer valueOf = Integer.valueOf(i2);
                ArrayList<sy> arrayList = value.wJy;
                rVar.invoke(valueOf, key, Integer.valueOf(arrayList == null || arrayList.isEmpty() ? -2 : 0), value.wJy);
            }
        }
        AppMethodBeat.o(191643);
    }
}
