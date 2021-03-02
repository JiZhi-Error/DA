package com.tencent.mm.plugin.emojicapture.ui.editor.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.fontdecode.PathExtractor;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.d;
import com.tencent.mm.plugin.emojicapture.ui.editor.text.c;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001!B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J@\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0016J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0004H\u0016R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/PathTextDrawer;", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "fontPaths", "", "", "textSize", "", "([Ljava/lang/String;I)V", "currFont", "dataMap", "", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/PathTextDrawer$TextPathData;", "defaultDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/DefaultTextDrawer;", "text", "", "drawLine", "", "canvas", "Landroid/graphics/Canvas;", "lineStart", "lineEnd", "x", "", "y", "paint", "Landroid/graphics/Paint;", "withEllipsis", "", "refresh", "setText", "switchFont", "fontPath", "TextPathData", "plugin-emojicapture_release"})
public final class b implements c {
    private String rvH = "";
    private Map<String, a> rvI = new HashMap();
    private final a rvJ = new a();
    private CharSequence text;

    public b(String[] strArr, int i2) {
        p.h(strArr, "fontPaths");
        AppMethodBeat.i(826);
        for (String str : strArr) {
            a aVar = new a(str, i2);
            if (aVar.rvK.isValid()) {
                this.rvI.put(str, aVar);
            }
        }
        AppMethodBeat.o(826);
    }

    @Override // com.tencent.mm.plugin.emojicapture.ui.editor.text.c
    public final void setText(CharSequence charSequence) {
        AppMethodBeat.i(822);
        p.h(charSequence, "text");
        this.text = charSequence;
        this.rvJ.setText(charSequence);
        AppMethodBeat.o(822);
    }

    @Override // com.tencent.mm.plugin.emojicapture.ui.editor.text.c
    public final void refresh() {
        AppMethodBeat.i(823);
        for (a aVar : this.rvI.values()) {
            CharSequence charSequence = this.text;
            aVar.rvL.clear();
            aVar.rvM.clear();
            if (charSequence != null) {
                for (int i2 = 0; i2 < charSequence.length(); i2++) {
                    char charAt = charSequence.charAt(i2);
                    Path path = new Path();
                    RectF rectF = new RectF();
                    if (aVar.rvK.a(charAt, path, rectF)) {
                        aVar.rvL.add(path);
                        aVar.rvM.add(rectF);
                    } else {
                        aVar.rvL.add(null);
                        aVar.rvM.add(null);
                    }
                }
            }
        }
        AppMethodBeat.o(823);
    }

    @Override // com.tencent.mm.plugin.emojicapture.ui.editor.text.c
    public final void anr(String str) {
        AppMethodBeat.i(824);
        p.h(str, "fontPath");
        this.rvH = str;
        AppMethodBeat.o(824);
    }

    @Override // com.tencent.mm.plugin.emojicapture.ui.editor.text.c
    public final void a(Canvas canvas, int i2, int i3, float f2, float f3, Paint paint, boolean z) {
        float measureText;
        AppMethodBeat.i(825);
        p.h(canvas, "canvas");
        p.h(paint, "paint");
        if (Util.isNullOrNil(this.text)) {
            AppMethodBeat.o(825);
            return;
        }
        a aVar = this.rvI.get(this.rvH);
        if (aVar == null) {
            this.rvJ.a(canvas, i2, i3, f2, f3, paint, z);
            AppMethodBeat.o(825);
            return;
        }
        canvas.save();
        canvas.translate(f2, f3);
        int i4 = -1;
        for (int i5 = i2; i5 < i3; i5++) {
            if (aVar.rvL.get(i5) != null) {
                Path path = aVar.rvL.get(i5);
                if (path == null) {
                    p.hyc();
                }
                canvas.drawPath(path, paint);
                measureText = paint.measureText(this.text, i5, i5 + 1);
            } else {
                CharSequence charSequence = this.text;
                if (charSequence == null) {
                    p.hyc();
                }
                if (kotlin.n.a.isSurrogate(charSequence.charAt(i5)) && i4 == -1) {
                    i4 = i5;
                } else if (i4 != -1) {
                    CharSequence charSequence2 = this.text;
                    if (charSequence2 == null) {
                        p.hyc();
                    }
                    if (i5 < charSequence2.length() - 1) {
                        CharSequence charSequence3 = this.text;
                        if (charSequence3 == null) {
                            p.hyc();
                        }
                        if (kotlin.n.a.isSurrogate(charSequence3.charAt(i5 + 1))) {
                        }
                    }
                    canvas.save();
                    CharSequence charSequence4 = this.text;
                    if (charSequence4 == null) {
                        p.hyc();
                    }
                    canvas.drawText(charSequence4, i4, i5 + 1, 0.0f, 0.0f, paint);
                    canvas.restore();
                    measureText = paint.measureText(this.text, i4, i5 + 1);
                    i4 = -1;
                } else {
                    CharSequence charSequence5 = this.text;
                    if (charSequence5 == null) {
                        p.hyc();
                    }
                    canvas.drawText(charSequence5, i5, i5 + 1, 0.0f, 0.0f, paint);
                    measureText = paint.measureText(this.text, i5, i5 + 1);
                }
            }
            canvas.translate(measureText, 0.0f);
        }
        if (z) {
            canvas.drawText(c.a.cJS(), 0.0f, 0.0f, paint);
        }
        canvas.restore();
        AppMethodBeat.o(825);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000b¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/PathTextDrawer$TextPathData;", "", "fontPath", "", "textSize", "", "(Ljava/lang/String;I)V", "boxList", "", "Landroid/graphics/RectF;", "getBoxList", "()Ljava/util/List;", "metrics", "Lcom/tencent/mm/fontdecode/PathExtractor$Metrics;", "getMetrics", "()Lcom/tencent/mm/fontdecode/PathExtractor$Metrics;", "pathExtractor", "Lcom/tencent/mm/fontdecode/PathExtractor;", "pathList", "Landroid/graphics/Path;", "getPathList", "isValid", "", "refresh", "", "text", "", "plugin-emojicapture_release"})
    public static final class a {
        final PathExtractor rvK;
        final List<Path> rvL;
        final List<RectF> rvM;
        private final PathExtractor.Metrics rvN = new PathExtractor.Metrics();

        public a(String str, int i2) {
            p.h(str, "fontPath");
            AppMethodBeat.i(d.CTRL_INDEX);
            this.rvK = new PathExtractor(str);
            this.rvK.setTextSize(i2);
            this.rvL = new ArrayList();
            this.rvM = new ArrayList();
            this.rvK.a(this.rvN);
            AppMethodBeat.o(d.CTRL_INDEX);
        }
    }
}
