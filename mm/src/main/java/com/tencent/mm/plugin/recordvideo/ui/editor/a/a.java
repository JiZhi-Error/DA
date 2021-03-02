package com.tencent.mm.plugin.recordvideo.ui.editor.a;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0010\u001a\u00020\u000fH\u0016J-\u0010\u0011\u001a\u00020\u000f2#\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016R+\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/EditorEmojiPanel;", "Lcom/tencent/mm/emoji/view/EmojiPanelBottomSheet;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "darkMode", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Z)V", "visibleCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visible", "", "dismiss", "setOnVisibleChangeCallback", "callback", "setShow", "show", "plugin-recordvideo_release"})
public final class a extends com.tencent.mm.emoji.view.a {
    public b<? super Boolean, x> Ccp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        p.h(context, "context");
        p.h(viewGroup, "parent");
        AppMethodBeat.i(237898);
        this.hee.setBackgroundColor(com.tencent.mm.cb.a.n(context, R.color.mv));
        AppMethodBeat.o(237898);
    }

    public final void setShow(boolean z) {
        AppMethodBeat.i(237895);
        if (z) {
            show();
            AppMethodBeat.o(237895);
            return;
        }
        dismiss();
        AppMethodBeat.o(237895);
    }

    @Override // com.tencent.mm.emoji.view.a
    public final void show() {
        AppMethodBeat.i(237896);
        super.show();
        b<? super Boolean, x> bVar = this.Ccp;
        if (bVar != null) {
            bVar.invoke(Boolean.TRUE);
            AppMethodBeat.o(237896);
            return;
        }
        AppMethodBeat.o(237896);
    }

    @Override // com.tencent.mm.emoji.view.a
    public final void dismiss() {
        AppMethodBeat.i(237897);
        super.dismiss();
        b<? super Boolean, x> bVar = this.Ccp;
        if (bVar != null) {
            bVar.invoke(Boolean.FALSE);
            AppMethodBeat.o(237897);
            return;
        }
        AppMethodBeat.o(237897);
    }
}
