package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d;
import com.tencent.mm.protocal.protobuf.ain;
import com.tencent.mm.protocal.protobuf.erc;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010#\u001a\u00020$H\u0004J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u0010\u001a\u00020\u000fH\u0004J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020&H\u0004J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0016J\u0012\u0010-\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010$H\u0004J\u000e\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u001cJ\u000e\u00100\u001a\u00020\t2\u0006\u00101\u001a\u000202R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018¨\u00063"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorData;", "dataType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;)V", "getDataType", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "setDataType", "enableTimeEdit", "", "getEnableTimeEdit", "()Z", "setEnableTimeEdit", "(Z)V", "<set-?>", "Landroid/graphics/Matrix;", "matrix", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "modTimeRange", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "getModTimeRange", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "setModTimeRange", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;)V", "objectId", "", "getObjectId", "()Ljava/lang/String;", "setObjectId", "(Ljava/lang/String;)V", "timeRange", "getTimeRange", "getTimeRangeProto", "Lcom/tencent/mm/protocal/protobuf/EditTimeRange;", "matrixToProto", "Lcom/tencent/mm/protocal/protobuf/ViewMatrix;", "protoToMatrix", "", "viewMatrix", "setTimeRange", "", "range", "setTimeRangeProto", "showAtObjectId", "objID", "showAtTime", "currentMs", "", "plugin-recordvideo_release"})
public abstract class a implements h {
    public d Ceu;
    public final d Cev = new d(2147483647L, false, 2);
    public boolean Cew = true;
    public d Cex;
    public Matrix gT = new Matrix();
    public String objectId;

    public a(d dVar) {
        p.h(dVar, "dataType");
        this.Cex = dVar;
    }

    public final void b(d dVar) {
        p.h(dVar, "<set-?>");
        this.Cex = dVar;
    }

    protected static float[] a(erc erc) {
        p.h(erc, "viewMatrix");
        float[] fArr = new float[9];
        int i2 = 0;
        LinkedList<Float> linkedList = erc.LOe;
        p.g(linkedList, "viewMatrix.value");
        for (T t : linkedList) {
            p.g(t, "data");
            fArr[i2] = t.floatValue();
            i2++;
        }
        return fArr;
    }

    protected static erc f(Matrix matrix) {
        p.h(matrix, "matrix");
        float[] fArr = new float[9];
        erc erc = new erc();
        matrix.getValues(fArr);
        for (int i2 = 0; i2 < 9; i2++) {
            erc.LOe.add(Float.valueOf(fArr[i2]));
        }
        return erc;
    }

    /* access modifiers changed from: protected */
    public final ain eMi() {
        ain ain = new ain();
        ain.start = this.Cev.Cgx.getTime();
        ain.boX = this.Cev.Cgy.getTime();
        return ain;
    }

    /* access modifiers changed from: protected */
    public final void a(ain ain) {
        if (ain != null) {
            this.Cev.ai(ain.start, ain.boX);
        }
    }

    public final boolean Ig(long j2) {
        if (j2 < this.Cev.Cgx.getTime() || j2 > this.Cev.Cgy.getTime()) {
            return false;
        }
        return true;
    }

    public final boolean aLB(String str) {
        p.h(str, "objID");
        if (p.j(str, this.objectId)) {
            return true;
        }
        return false;
    }
}
