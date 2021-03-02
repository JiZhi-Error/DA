package com.tencent.mm.plugin.vlog.ui.plugin.timeedit;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.e;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.f;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.n;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.o;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.q;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.r;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditViewParser;", "", "()V", "captionItemView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView;", "recordCaptionItemView", "getTimeEditView", "Landroid/view/View;", "context", "Landroid/content/Context;", "data", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "itemStateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "displayArea", "Landroid/graphics/Rect;", "scale", "Landroid/graphics/PointF;", "refreshView", "", "itemView", "Companion", "plugin-vlog_release"})
public final class c {
    public static final a GNd = new a((byte) 0);
    private com.tencent.mm.plugin.recordvideo.ui.editor.a Cgo;
    private com.tencent.mm.plugin.recordvideo.ui.editor.a GNc;

    static {
        AppMethodBeat.i(191905);
        AppMethodBeat.o(191905);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditViewParser$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final View a(Context context, com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar, EditorItemContainer.b bVar, Rect rect, PointF pointF) {
        float aG;
        n nVar = null;
        AppMethodBeat.i(191903);
        p.h(context, "context");
        p.h(aVar, "data");
        p.h(bVar, "itemStateResolve");
        p.h(rect, "displayArea");
        p.h(pointF, "scale");
        int i2 = rect.top + rect.bottom;
        switch (d.$EnumSwitchMapping$0[aVar.Cex.ordinal()]) {
            case 1:
                nVar = new f(context);
                nVar.setStateResolve(bVar);
                nVar.af(pointF.x, pointF.y);
                nVar.setEmojiItem((e) aVar);
                aG = 0.5f;
                break;
            case 2:
                nVar = new r(context);
                nVar.af(pointF.x, pointF.y);
                nVar.setStateResolve(bVar);
                nVar.setText((q) aVar);
                aG = 0.5f;
                break;
            case 3:
                if (this.Cgo != null) {
                    com.tencent.mm.plugin.recordvideo.ui.editor.a aVar2 = this.Cgo;
                    if ((aVar2 != null ? aVar2.getParent() : null) != null) {
                        com.tencent.mm.plugin.recordvideo.ui.editor.a aVar3 = this.Cgo;
                        if (aVar3 != null) {
                            aVar3.a((com.tencent.mm.plugin.recordvideo.ui.editor.item.c) aVar);
                        }
                        com.tencent.mm.plugin.recordvideo.ui.editor.a aVar4 = this.Cgo;
                        if (aVar4 != null) {
                            aVar4.setVisibility(0);
                        }
                        AppMethodBeat.o(191903);
                        return null;
                    }
                }
                nVar = new com.tencent.mm.plugin.recordvideo.ui.editor.a(context);
                nVar.setStateResolve(bVar);
                nVar.setCaptionItem((com.tencent.mm.plugin.recordvideo.ui.editor.item.c) aVar);
                this.Cgo = nVar;
                com.tencent.mm.plugin.recordvideo.background.e eVar = com.tencent.mm.plugin.recordvideo.background.e.BKp;
                aG = 0.5f - (((float) ((i2 / 2) - (com.tencent.mm.plugin.recordvideo.background.e.getVisibleRect().bottom - com.tencent.mm.cb.a.aG(context, R.dimen.cn)))) / ((float) i2));
                break;
            case 4:
                if (this.GNc != null) {
                    com.tencent.mm.plugin.recordvideo.ui.editor.a aVar5 = this.GNc;
                    if ((aVar5 != null ? aVar5.getParent() : null) != null) {
                        com.tencent.mm.plugin.recordvideo.ui.editor.a aVar6 = this.GNc;
                        if (aVar6 != null) {
                            aVar6.a((com.tencent.mm.plugin.recordvideo.ui.editor.item.c) aVar);
                        }
                        com.tencent.mm.plugin.recordvideo.ui.editor.a aVar7 = this.GNc;
                        if (aVar7 != null) {
                            aVar7.setVisibility(0);
                        }
                        AppMethodBeat.o(191903);
                        return null;
                    }
                }
                nVar = new com.tencent.mm.plugin.recordvideo.ui.editor.a(context);
                nVar.setStateResolve(bVar);
                nVar.setCaptionItem((com.tencent.mm.plugin.recordvideo.ui.editor.item.c) aVar);
                this.GNc = nVar;
                com.tencent.mm.plugin.recordvideo.background.e eVar2 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
                aG = 0.5f - (((float) ((i2 / 2) - (com.tencent.mm.plugin.recordvideo.background.e.eIS().bottom - com.tencent.mm.cb.a.aG(context, R.dimen.bu)))) / ((float) i2));
                break;
            case 5:
                nVar = new n(context);
                nVar.setStateResolve(bVar);
                nVar.setEditItem((o) aVar);
            default:
                aG = 0.5f;
                break;
        }
        if (nVar != null) {
            com.tencent.mm.plugin.recordvideo.background.e eVar3 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
            Rect eIR = com.tencent.mm.plugin.recordvideo.background.e.eIR();
            com.tencent.mm.plugin.recordvideo.background.e eVar4 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
            nVar.b(eIR, com.tencent.mm.plugin.recordvideo.background.e.eIT());
        }
        if (nVar != null) {
            com.tencent.mm.plugin.recordvideo.background.e eVar5 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
            nVar.setValidArea(com.tencent.mm.plugin.recordvideo.background.e.eIS());
        }
        if (nVar != null) {
            nVar.a(rect, aG);
        }
        Log.i("MicroMsg.TimeEditViewParser", "setDefaultLocation heightPercent:".concat(String.valueOf(aG)));
        View view = (View) nVar;
        AppMethodBeat.o(191903);
        return view;
    }

    public static void a(View view, com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar) {
        AppMethodBeat.i(191904);
        p.h(view, "itemView");
        p.h(aVar, "data");
        switch (d.haE[aVar.Cex.ordinal()]) {
            case 1:
                ((r) view).setText((q) aVar);
                ((r) view).setEnableNotify(true);
                ((r) view).setVisibility(0);
                break;
        }
        AppMethodBeat.o(191904);
    }
}
