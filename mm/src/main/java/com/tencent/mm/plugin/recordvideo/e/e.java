package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/util/MemLeakUtil;", "", "()V", "TAG", "", "leakList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/EditorEmojiPanel;", "Lkotlin/collections/ArrayList;", "addLeakObj", "", "panel", "releaseObj", "plugin-recordvideo_release"})
public final class e {
    private static final ArrayList<a> Cis = new ArrayList<>();
    public static final e Cit = new e();
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(76225);
        AppMethodBeat.o(76225);
    }

    private e() {
    }

    public static void a(a aVar) {
        AppMethodBeat.i(237990);
        p.h(aVar, "panel");
        Log.i(TAG, "add panel  ".concat(String.valueOf(aVar)));
        Cis.add(aVar);
        AppMethodBeat.o(237990);
    }

    public static void eMN() {
        AppMethodBeat.i(76224);
        Log.i(TAG, "release panel ");
        for (T t : Cis) {
            Log.i(TAG, "release panel ".concat(String.valueOf(t)));
            t.hee.destroy();
        }
        Cis.clear();
        AppMethodBeat.o(76224);
    }
}
