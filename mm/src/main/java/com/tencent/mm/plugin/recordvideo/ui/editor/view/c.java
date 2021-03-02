package com.tencent.mm.plugin.recordvideo.ui.editor.view;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

public interface c {
    boolean Ig(long j2);

    void a(Rect rect, float f2);

    boolean aLB(String str);

    void b(Rect rect, int i2);

    boolean eLK();

    float[] getContentBoundary();

    RectF getDrawRect();

    com.tencent.mm.plugin.recordvideo.ui.editor.item.a getEditorData();

    b getType();

    void setValidArea(Rect rect);

    public static final class a {
        public static /* synthetic */ void a(c cVar, Rect rect) {
            AppMethodBeat.i(237964);
            cVar.a(rect, 0.5f);
            AppMethodBeat.o(237964);
        }

        public static boolean a(c cVar, long j2) {
            AppMethodBeat.i(237965);
            com.tencent.mm.plugin.recordvideo.ui.editor.item.a editorData = cVar.getEditorData();
            if (!(editorData instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.a) || !editorData.Ig(j2) || !cVar.eLK()) {
                ((View) cVar).setVisibility(4);
                AppMethodBeat.o(237965);
                return false;
            }
            ((View) cVar).setVisibility(0);
            AppMethodBeat.o(237965);
            return true;
        }

        public static boolean a(c cVar, String str) {
            AppMethodBeat.i(237966);
            p.h(str, "objID");
            com.tencent.mm.plugin.recordvideo.ui.editor.item.a editorData = cVar.getEditorData();
            if (!(editorData instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.a) || !editorData.aLB(str)) {
                ((View) cVar).setVisibility(4);
                AppMethodBeat.o(237966);
                return false;
            }
            ((View) cVar).setVisibility(0);
            AppMethodBeat.o(237966);
            return true;
        }
    }
}
