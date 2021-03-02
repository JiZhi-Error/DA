package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.protocal.protobuf.ain;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u001aH&J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH&J\b\u0010 \u001a\u00020\u001aH&J\b\u0010!\u001a\u00020\u0006H&J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u0006H\u0017J\b\u0010$\u001a\u00020%H\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "", "matrix", "Landroid/graphics/Matrix;", "(Landroid/graphics/Matrix;)V", "currFrameTime", "", "getCurrFrameTime", "()J", "setCurrFrameTime", "(J)V", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "selectTimeMs", "getSelectTimeMs", "setSelectTimeMs", "timeRange", "Lcom/tencent/mm/protocal/protobuf/EditTimeRange;", "getTimeRange", "()Lcom/tencent/mm/protocal/protobuf/EditTimeRange;", "setTimeRange", "(Lcom/tencent/mm/protocal/protobuf/EditTimeRange;)V", "consumeTime", "lastFrameTime", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "prepareNext", "seekTo", "timeMs", "showAtTime", "", "plugin-recordvideo_release"})
public abstract class a {
    public ain Cgj;
    private long Cgk;
    Matrix gT;
    long rpy;

    public abstract void destroy();

    public abstract void draw(Canvas canvas, Paint paint);

    public abstract long eMv();

    public abstract void init();

    public a(Matrix matrix) {
        p.h(matrix, "matrix");
        this.gT = matrix;
    }

    public void seekTo(long j2) {
        this.Cgk = j2;
    }

    /* access modifiers changed from: protected */
    public final boolean eMu() {
        ain ain = this.Cgj;
        if (ain == null) {
            return true;
        }
        if (this.Cgk < ain.start || this.Cgk > ain.boX) {
            return false;
        }
        return true;
    }

    public long Ik(long j2) {
        while (this.rpy <= j2) {
            this.rpy += eMv();
        }
        this.rpy -= j2;
        return this.rpy;
    }
}
