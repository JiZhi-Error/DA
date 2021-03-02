package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorTTSData;", "", "getTTSInfo", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TTSInfo;", "hasTTS", "", "setTTSInfo", "", "path", "", "durationMs", "", "plugin-recordvideo_release"})
public interface i {
    void bh(String str, long j2);

    b eMp();

    boolean eMq();

    @l(hxD = {1, 1, 16})
    public static final class a {
        public static boolean a(i iVar) {
            AppMethodBeat.i(237777);
            if (iVar.eMp().path.length() > 0) {
                AppMethodBeat.o(237777);
                return true;
            }
            AppMethodBeat.o(237777);
            return false;
        }
    }
}
