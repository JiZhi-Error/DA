package com.tencent.mm.plugin.finder.video;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.upload.f;
import com.tencent.mm.plugin.gallery.picker.b.b;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.protocal.protobuf.bej;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.protocal.protobuf.erf;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bJ \u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J8\u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016J,\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u00142\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderVLogCropTailor;", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "config", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;)V", "adjustRect", "Landroid/graphics/Rect;", "input", "clipRect", "contentRect", "viewRect", "calcOriginRect", "onInput", "mediaType", "", "matrix", "Landroid/graphics/Matrix;", "resize", "Lkotlin/Pair;", "originWidth", "originHeight", "maxWidth", "Companion", "plugin-finder_release"})
public final class j implements com.tencent.mm.plugin.gallery.picker.b.a<String, b.f> {
    public static final a weA = new a((byte) 0);
    private final b.C1388b wez;

    static {
        AppMethodBeat.i(254249);
        AppMethodBeat.o(254249);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderVLogCropTailor$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public j(b.C1388b bVar) {
        p.h(bVar, "config");
        AppMethodBeat.i(254248);
        this.wez = bVar;
        AppMethodBeat.o(254248);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, android.graphics.Matrix, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect] */
    @Override // com.tencent.mm.plugin.gallery.picker.b.a
    public final /* synthetic */ b.f a(String str, int i2, Matrix matrix, Rect rect, Rect rect2, Rect rect3) {
        int i3;
        int i4;
        int i5;
        AppMethodBeat.i(254246);
        String str2 = str;
        p.h(str2, "input");
        p.h(matrix, "matrix");
        p.h(rect, "clipRect");
        p.h(rect2, "contentRect");
        p.h(rect3, "viewRect");
        c cVar = c.vCb;
        VideoTransPara dqx = c.dqx();
        Log.i("Finder.FinderVLogCropTailor", "FinderVLogCropTailor videoParams ".concat(String.valueOf(dqx)));
        Log.i("Finder.FinderVLogCropTailor", "FinderVLogCropTailor mediaType ".concat(String.valueOf(i2)));
        Log.i("Finder.FinderVLogCropTailor", "matrix:" + matrix + ", clipRect:" + rect + ", contentRect:" + rect2 + ", viewRect:" + rect3);
        int i6 = dqx.iTf;
        Rect a2 = a(rect2, rect3, rect);
        int i7 = a2.right - a2.left;
        int i8 = a2.top - a2.bottom;
        int i9 = dqx.width;
        if (i7 > i9) {
            i3 = (int) (((float) i8) * (((float) i9) / ((float) i7)));
        } else {
            i3 = i8;
            i9 = i7;
        }
        o oVar = new o(Integer.valueOf(i9), Integer.valueOf(i3));
        int intValue = oVar.first.intValue();
        int intValue2 = oVar.second.intValue();
        Log.i("Finder.FinderVLogCropTailor", "resize rect, before:" + i7 + ", " + i8 + ", after:" + intValue + ", " + intValue2);
        p.h(str2, "input");
        p.h(rect, "clipRect");
        p.h(rect2, "contentRect");
        p.h(rect3, "viewRect");
        Rect a3 = a(rect2, rect3, rect);
        Log.i("Finder.FinderVLogCropTailor", "adjustRect before:" + a2.toShortString() + ", after:" + a3.toShortString());
        e eVar = new e();
        eVar.ayV(str2);
        com.tencent.mm.plugin.sight.base.a aNx = e.aNx(str2);
        Log.i("Finder.FinderVLogCropTailor", "mediaInfo: ".concat(String.valueOf(aNx)));
        eVar.wcO = new cjx();
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        cjx cjx = eVar.wcO;
        if (cjx == null) {
            p.hyc();
        }
        bej bej = new bej();
        bej.LOe.addAll(kotlin.a.e.s(fArr));
        cjx.Mpr = bej;
        cjx cjx2 = eVar.wcO;
        if (cjx2 == null) {
            p.hyc();
        }
        erf erf = new erf();
        erf.left = a3.left;
        erf.top = a3.top;
        erf.right = a3.right;
        erf.bottom = a3.bottom;
        cjx2.Mpq = erf;
        cjx cjx3 = eVar.wcO;
        if (cjx3 == null) {
            p.hyc();
        }
        cjx3.dvv = 0;
        cjx cjx4 = eVar.wcO;
        if (cjx4 == null) {
            p.hyc();
        }
        if (aNx != null) {
            i4 = aNx.videoDuration;
        } else {
            i4 = 0;
        }
        if (i4 > dqx.duration * 1000) {
            i5 = dqx.duration * 1000;
        } else {
            i5 = 0;
        }
        cjx4.iqg = i5;
        cjx cjx5 = eVar.wcO;
        if (cjx5 == null) {
            p.hyc();
        }
        cjx5.width = intValue;
        cjx cjx6 = eVar.wcO;
        if (cjx6 == null) {
            p.hyc();
        }
        cjx6.height = intValue2;
        Rect a4 = a(rect2, rect3, rect);
        int i10 = (int) ((((float) (a4.top - a4.bottom)) / ((float) (a4.right - a4.left))) * ((float) i6));
        if (i2 == 2) {
            f fVar = f.vSz;
            eVar.HA(f.a(str2, i6, i10, a4));
        } else if (i2 == 1) {
            eVar.HA("");
        }
        Log.d("Finder.FinderVLogCropTailor", "thumbPath = " + eVar.thumbPath);
        cjx cjx7 = eVar.wcO;
        if (cjx7 == null) {
            p.hyc();
        }
        erf erf2 = new erf();
        erf2.left = a4.left;
        erf2.top = a4.top;
        erf2.right = a4.right;
        erf2.bottom = a4.bottom;
        cjx7.Mps = erf2;
        e eVar2 = eVar;
        AppMethodBeat.o(254246);
        return eVar2;
    }

    private static Rect a(Rect rect, Rect rect2, Rect rect3) {
        AppMethodBeat.i(254247);
        float width = (1.0f * ((float) rect.width())) / ((float) rect2.width());
        int i2 = rect3.left - rect.left;
        int i3 = rect3.top - rect.top;
        Rect rect4 = new Rect((int) (((float) i2) / width), (int) (((float) (rect3.height() + i3)) / width), (int) (((float) (rect3.width() + i2)) / width), (int) (((float) i3) / width));
        AppMethodBeat.o(254247);
        return rect4;
    }
}
