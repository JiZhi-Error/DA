package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "inputPanel", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView;)V", "getInputPanel", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView;", "setInputPanel", "initHeightSafeArea", "", "safeHeight", "", "safeFrameHeight", "initWidthSafeArea", "safeWidth", "safeFrameWidth", "plugin-recordvideo_release"})
public final class g implements t {
    public EditorInputView BPY;

    public g(EditorInputView editorInputView) {
        p.h(editorInputView, "inputPanel");
        AppMethodBeat.i(75492);
        this.BPY = editorInputView;
        AppMethodBeat.o(75492);
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
        AppMethodBeat.i(237284);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(237284);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
    }

    public final void bL(float f2) {
        AppMethodBeat.i(75490);
        this.BPY.bL(f2);
        AppMethodBeat.o(75490);
    }

    public final void bM(float f2) {
        AppMethodBeat.i(75491);
        this.BPY.bL(f2);
        AppMethodBeat.o(75491);
    }
}
