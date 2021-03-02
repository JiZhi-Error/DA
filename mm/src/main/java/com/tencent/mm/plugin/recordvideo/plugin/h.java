package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorFrameView;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.f;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.r;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.s;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019J\u001e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020!J\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%J\u0006\u0010'\u001a\u00020(J\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020+0*j\b\u0012\u0004\u0012\u00020+`,J\"\u0010-\u001a\u0012\u0012\u0004\u0012\u00020.0*j\b\u0012\u0004\u0012\u00020.`,2\n\b\u0002\u0010/\u001a\u0004\u0018\u000100J\u0006\u00101\u001a\u00020\u001eJ\u0006\u00102\u001a\u00020\u001eJ\u0006\u00103\u001a\u00020\u001eJ\u0006\u00104\u001a\u00020(J\u0006\u00105\u001a\u00020\u0014J\u0006\u00106\u001a\u00020\u0014J\u000e\u00107\u001a\u00020\u00142\u0006\u00108\u001a\u000209J\u0016\u0010:\u001a\u00020\u00142\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<J\u0016\u0010>\u001a\u00020\u00142\u0006\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020<J\b\u0010A\u001a\u00020!H\u0016J\b\u0010B\u001a\u00020\u0014H\u0016J\b\u0010C\u001a\u00020\u0014H\u0016J\b\u0010D\u001a\u00020\u0014H\u0016J\b\u0010E\u001a\u00020\u0014H\u0016J\u0010\u0010F\u001a\u00020\u00142\u0006\u0010G\u001a\u00020\u001eH\u0016J\u0006\u0010H\u001a\u00020\u0014J\u000e\u0010I\u001a\u00020\u00142\u0006\u0010J\u001a\u00020KJ\u001c\u0010L\u001a\u00020\u00142\u0006\u0010M\u001a\u00020!2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020O0%J\u0006\u0010P\u001a\u00020!J\u000e\u0010Q\u001a\u00020\u00142\u0006\u0010R\u001a\u00020SR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006T"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/EditItemContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "pendingTextItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItemView;", "pendingTipItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer;", "setView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer;)V", "addEmojiItem", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "addTextItem", "item", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "addTipItem", "text", "", "textColor", "", "textBgColor", "checkTipItem", "", "enableGif", "enable", "getAllItemViews", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "getDrawingRect", "", "getEditorDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "Lkotlin/collections/ArrayList;", "getEditorItemList", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "Landroid/graphics/Matrix;", "getEmojiCount", "getLocationItemHeight", "getTextCount", "getValidRect", "gotoClipMode", "gotoPreviewMode", "initConfig", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "initHeightSafeArea", "safeHeight", "", "safeFrameHeight", "initWidthSafeArea", "safeWidth", "safeFrameWidth", "onBackPress", "onPause", "onResume", "release", "reset", "setVisibility", "visibility", "showPreview", "updateLocationItem", "storyLocation", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "updateLyricsItem", "visible", "lyricsInfo", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "updateTipItemLayout", "updateValidArea", "validRect", "Landroid/graphics/Rect;", "plugin-recordvideo_release"})
public final class h implements t {
    public r BQf;
    public s BQg;
    public EditorItemContainer BQh;
    d wgr;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class a extends q implements kotlin.g.a.a<x> {
        public static final a BQj = new a();

        static {
            AppMethodBeat.i(75497);
            AppMethodBeat.o(75497);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    public h(EditorItemContainer editorItemContainer, d dVar) {
        p.h(editorItemContainer, "view");
        p.h(dVar, "status");
        AppMethodBeat.i(75513);
        this.BQh = editorItemContainer;
        this.wgr = dVar;
        this.BQh.setOnTextClick(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.recordvideo.plugin.h.AnonymousClass1 */
            final /* synthetic */ h BQi;

            {
                this.BQi = r1;
            }

            public final void onClick(View view) {
                View view2;
                AppMethodBeat.i(75493);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/EditItemContainerPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h hVar = this.BQi;
                if (!(view instanceof r)) {
                    view2 = null;
                } else {
                    view2 = view;
                }
                hVar.BQf = (r) view2;
                r rVar = this.BQi.BQf;
                if (rVar != null) {
                    rVar.setVisibility(8);
                    Bundle bundle = new Bundle();
                    bundle.putCharSequence("PARAM_EDIT_TEXT_CONTENT", rVar.getText());
                    bundle.putInt("PARAM_EDIT_TEXT_COLOR", rVar.getColor());
                    bundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", rVar.getTextBg());
                    this.BQi.wgr.a(d.c.BVd, bundle);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditItemContainerPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(75493);
            }
        });
        this.BQh.setOnTipClick(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.recordvideo.plugin.h.AnonymousClass2 */
            final /* synthetic */ h BQi;

            {
                this.BQi = r1;
            }

            public final void onClick(View view) {
                View view2;
                AppMethodBeat.i(75494);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/EditItemContainerPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h hVar = this.BQi;
                if (!(view instanceof s)) {
                    view2 = null;
                } else {
                    view2 = view;
                }
                hVar.BQg = (s) view2;
                s sVar = this.BQi.BQg;
                if (sVar != null) {
                    sVar.setVisibility(8);
                    Bundle bundle = new Bundle();
                    bundle.putCharSequence("PARAM_EDIT_TEXT_CONTENT", sVar.getText());
                    bundle.putInt("PARAM_EDIT_TEXT_COLOR", sVar.getColor());
                    bundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", sVar.getTextBg());
                    this.BQi.wgr.a(d.c.BVe, bundle);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditItemContainerPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(75494);
            }
        });
        this.BQh.setOnLocationClick(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.recordvideo.plugin.h.AnonymousClass3 */
            final /* synthetic */ h BQi;

            {
                this.BQi = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(75495);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/EditItemContainerPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                d.b.a(this.BQi.wgr, d.c.BVf);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditItemContainerPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(75495);
            }
        });
        this.BQh.setDeleteStateListener(new kotlin.g.a.b<Boolean, x>(this) {
            /* class com.tencent.mm.plugin.recordvideo.plugin.h.AnonymousClass4 */
            final /* synthetic */ h BQi;

            {
                this.BQi = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                AppMethodBeat.i(75496);
                if (bool.booleanValue()) {
                    d.b.a(this.BQi.wgr, d.c.BVi);
                } else {
                    d.b.a(this.BQi.wgr, d.c.BVj);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(75496);
                return xVar;
            }
        });
        this.BQh.setItemChangeListener(new kotlin.g.a.b<View, x>(this) {
            /* class com.tencent.mm.plugin.recordvideo.plugin.h.AnonymousClass5 */
            final /* synthetic */ h BQi;

            {
                this.BQi = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(View view) {
                AppMethodBeat.i(169932);
                View view2 = view;
                if (view2 instanceof c) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("PARAM_DELETE_VIEW_TYPE_INT", ((c) view2).getType().ordinal());
                    this.BQi.wgr.a(d.c.BVy, bundle);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(169932);
                return xVar;
            }
        });
        AppMethodBeat.o(75513);
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
    public final void onDetach() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(237286);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(237286);
    }

    public final void ac(float f2, float f3) {
        AppMethodBeat.i(75498);
        EditorItemContainer editorItemContainer = this.BQh;
        Context context = editorItemContainer.getContext();
        p.g(context, "context");
        editorItemContainer.CeW = new EditorFrameView(context);
        EditorFrameView editorFrameView = editorItemContainer.CeW;
        if (editorFrameView != null) {
            editorFrameView.setPosition(com.tencent.mm.plugin.recordvideo.ui.editor.c.POSITION_LEFT);
        }
        EditorFrameView editorFrameView2 = editorItemContainer.CeW;
        if (editorFrameView2 != null) {
            editorFrameView2.setVisibility(4);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) f3, -1);
        layoutParams.addRule(20);
        editorItemContainer.addView(editorItemContainer.CeW, layoutParams);
        Context context2 = editorItemContainer.getContext();
        p.g(context2, "context");
        editorItemContainer.CeY = new EditorFrameView(context2);
        EditorFrameView editorFrameView3 = editorItemContainer.CeY;
        if (editorFrameView3 != null) {
            editorFrameView3.setPosition(com.tencent.mm.plugin.recordvideo.ui.editor.c.POSITION_RIGHT);
        }
        EditorFrameView editorFrameView4 = editorItemContainer.CeY;
        if (editorFrameView4 != null) {
            editorFrameView4.setVisibility(4);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) f3, -1);
        layoutParams2.addRule(21);
        editorItemContainer.addView(editorItemContainer.CeY, layoutParams2);
        e eVar = e.BKp;
        e.eIR().left = (int) f3;
        e eVar2 = e.BKp;
        e.eIR().right = ((int) f3) + ((int) f2);
        StringBuilder sb = new StringBuilder("logStory: initWidthSafeArea safeAreaRect:");
        e eVar3 = e.BKp;
        Log.i("MicroMsg.EditorItemContainer", sb.append(e.eIR()).toString());
        AppMethodBeat.o(75498);
    }

    public final void ad(float f2, float f3) {
        AppMethodBeat.i(75499);
        EditorItemContainer editorItemContainer = this.BQh;
        Context context = editorItemContainer.getContext();
        p.g(context, "context");
        editorItemContainer.CeX = new EditorFrameView(context);
        EditorFrameView editorFrameView = editorItemContainer.CeX;
        if (editorFrameView != null) {
            editorFrameView.setPosition(com.tencent.mm.plugin.recordvideo.ui.editor.c.POSITION_TOP);
        }
        EditorFrameView editorFrameView2 = editorItemContainer.CeX;
        if (editorFrameView2 != null) {
            editorFrameView2.setVisibility(4);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) f3);
        layoutParams.addRule(10);
        editorItemContainer.addView(editorItemContainer.CeX, layoutParams);
        Context context2 = editorItemContainer.getContext();
        p.g(context2, "context");
        editorItemContainer.CeZ = new EditorFrameView(context2);
        EditorFrameView editorFrameView3 = editorItemContainer.CeZ;
        if (editorFrameView3 != null) {
            editorFrameView3.setPosition(com.tencent.mm.plugin.recordvideo.ui.editor.c.POSITION_BOTTOM);
        }
        EditorFrameView editorFrameView4 = editorItemContainer.CeZ;
        if (editorFrameView4 != null) {
            editorFrameView4.setVisibility(4);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, (int) f3);
        layoutParams2.addRule(12);
        editorItemContainer.addView(editorItemContainer.CeZ, layoutParams2);
        e eVar = e.BKp;
        e.eIR().top = (int) f3;
        e eVar2 = e.BKp;
        e.eIR().bottom = ((int) f3) + ((int) f2);
        StringBuilder sb = new StringBuilder("logStory: initHeightSafeArea safeAreaRect:");
        e eVar3 = e.BKp;
        Log.i("MicroMsg.EditorItemContainer", sb.append(e.eIR()).toString());
        AppMethodBeat.o(75499);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(75500);
        this.BQh.setVisibility(i2);
        AppMethodBeat.o(75500);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
        AppMethodBeat.i(75501);
        EditorItemContainer editorItemContainer = this.BQh;
        int childCount = editorItemContainer.ruN.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = editorItemContainer.ruN.getChildAt(i2);
            if (childAt instanceof f) {
                ((f) childAt).pause();
            }
        }
        AppMethodBeat.o(75501);
    }

    public final void ay(String str, int i2, int i3) {
        AppMethodBeat.i(75502);
        p.h(str, "text");
        this.BQh.eMm();
        EditorItemContainer editorItemContainer = this.BQh;
        String str2 = str;
        if (!(str2 == null || n.aL(str2))) {
            editorItemContainer.Cfh = new s(editorItemContainer.getContext());
            editorItemContainer.ruN.addView(editorItemContainer.Cfh, new RelativeLayout.LayoutParams(-2, -2));
            s sVar = editorItemContainer.Cfh;
            if (sVar != null) {
                e eVar = e.BKp;
                Rect eIR = e.eIR();
                e eVar2 = e.BKp;
                sVar.b(eIR, e.eIT());
            }
            s sVar2 = editorItemContainer.Cfh;
            if (sVar2 != null) {
                e eVar3 = e.BKp;
                sVar2.setValidArea(e.eIS());
            }
            s sVar3 = editorItemContainer.Cfh;
            if (sVar3 != null) {
                c.a.a(sVar3, editorItemContainer.CeT);
            }
            s sVar4 = editorItemContainer.Cfh;
            if (sVar4 != null) {
                sVar4.setStateResolve(editorItemContainer.Cfo);
            }
            s sVar5 = editorItemContainer.Cfh;
            if (sVar5 != null) {
                sVar5.setText(new com.tencent.mm.plugin.recordvideo.ui.editor.item.q(str2, i2, i3, editorItemContainer.getLocationItemHeight(), null, 16));
            }
            s sVar6 = editorItemContainer.Cfh;
            if (sVar6 != null) {
                sVar6.setOnClickListener(editorItemContainer.Cfk);
                AppMethodBeat.o(75502);
                return;
            }
        }
        AppMethodBeat.o(75502);
    }

    public static /* synthetic */ ArrayList a(h hVar) {
        AppMethodBeat.i(163427);
        ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> d2 = hVar.d(null);
        AppMethodBeat.o(163427);
        return d2;
    }

    public final ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> d(Matrix matrix) {
        AppMethodBeat.i(163426);
        ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> arrayList = new ArrayList<>();
        Iterator<T> it = this.BQh.getAllItemViews().iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c2 = it.next().c(matrix);
            if (c2 != null) {
                arrayList.add(c2);
            }
        }
        AppMethodBeat.o(163426);
        return arrayList;
    }

    public final ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> getEditorDataList() {
        AppMethodBeat.i(75505);
        ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> arrayList = new ArrayList<>();
        Iterator<T> it = this.BQh.getAllItemViews().iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.recordvideo.ui.editor.item.a cJO = it.next().cJO();
            if (cJO != null) {
                arrayList.add(cJO);
            }
        }
        AppMethodBeat.o(75505);
        return arrayList;
    }

    public final float[] eKr() {
        AppMethodBeat.i(75506);
        float[] fArr = {(float) this.BQh.getLeft(), (float) this.BQh.getTop(), (float) this.BQh.getRight(), (float) this.BQh.getBottom()};
        AppMethodBeat.o(75506);
        return fArr;
    }

    public static float[] eKs() {
        AppMethodBeat.i(237285);
        e eVar = e.BKp;
        e eVar2 = e.BKp;
        e eVar3 = e.BKp;
        e eVar4 = e.BKp;
        float[] fArr = {(float) e.eIS().left, (float) e.eIS().top, (float) e.eIS().right, (float) e.eIS().bottom};
        AppMethodBeat.o(237285);
        return fArr;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
        AppMethodBeat.i(75507);
        EditorItemContainer editorItemContainer = this.BQh;
        int childCount = editorItemContainer.ruN.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = editorItemContainer.ruN.getChildAt(i2);
            if ((childAt instanceof f) && !editorItemContainer.Cfa) {
                ((f) childAt).resume();
            }
        }
        AppMethodBeat.o(75507);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
        AppMethodBeat.i(75508);
        this.BQh.reset();
        AppMethodBeat.o(75508);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
        AppMethodBeat.i(75509);
        this.BQh.reset();
        AppMethodBeat.o(75509);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        return false;
    }

    public final void eKt() {
        AppMethodBeat.i(75510);
        this.BQh.setEnableTouch(true);
        AppMethodBeat.o(75510);
    }

    public final int eKu() {
        int i2;
        AppMethodBeat.i(75511);
        int i3 = 0;
        Iterator<T> it = this.BQh.getAllItemViews().iterator();
        while (it.hasNext()) {
            if (it.next() instanceof f) {
                i2 = i3 + 1;
            } else {
                i2 = i3;
            }
            i3 = i2;
        }
        AppMethodBeat.o(75511);
        return i3;
    }

    public final int eKv() {
        int i2;
        AppMethodBeat.i(75512);
        int i3 = 0;
        Iterator<T> it = this.BQh.getAllItemViews().iterator();
        while (it.hasNext()) {
            if (it.next() instanceof r) {
                i2 = i3 + 1;
            } else {
                i2 = i3;
            }
            i3 = i2;
        }
        AppMethodBeat.o(75512);
        return i3;
    }

    public final boolean eKq() {
        boolean z;
        String str;
        CharSequence text;
        int i2 = 0;
        AppMethodBeat.i(75503);
        if (this.BQh.Cfh != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            s tipItemView = this.BQh.getTipItemView();
            if (tipItemView == null || (text = tipItemView.getText()) == null || (str = text.toString()) == null) {
                str = "";
            }
            s tipItemView2 = this.BQh.getTipItemView();
            int color = tipItemView2 != null ? tipItemView2.getColor() : 0;
            s tipItemView3 = this.BQh.getTipItemView();
            if (tipItemView3 != null) {
                i2 = tipItemView3.getTextBg();
            }
            ay(str, color, i2);
            AppMethodBeat.o(75503);
            return true;
        }
        AppMethodBeat.o(75503);
        return false;
    }
}
