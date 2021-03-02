package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.i;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.protocal.protobuf.erc;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010;\u001a\u00020<J\u0006\u0010=\u001a\u00020<J\b\u0010>\u001a\u000207H\u0016J\b\u0010?\u001a\u00020@H\u0016J\u0018\u0010A\u001a\u00020<2\u0006\u0010B\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u001fH\u0016J\b\u0010D\u001a\u00020EH\u0016J\u000e\u0010F\u001a\u00020<2\u0006\u0010\u0005\u001a\u00020\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R\u001a\u0010/\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0014\"\u0004\b1\u0010\u0016R\u001a\u00102\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010+\"\u0004\b4\u00105R\u000e\u00106\u001a\u000207X\u0004¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010'\"\u0004\b:\u0010)¨\u0006G"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PagStickerItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorTTSData;", "pagPath", "", "matrix", "Landroid/graphics/Matrix;", "(Ljava/lang/String;Landroid/graphics/Matrix;)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "callback", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/ItemEditCallback;", "getCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/ItemEditCallback;", "setCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/ItemEditCallback;)V", "centerX", "", "getCenterX", "()F", "setCenterX", "(F)V", "centerY", "getCenterY", "setCenterY", "drawingRect", "Landroid/graphics/RectF;", "getDrawingRect", "()Landroid/graphics/RectF;", "effectId", "", "getEffectId", "()J", "setEffectId", "(J)V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "getPagPath", "()Ljava/lang/String;", FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, "getRotate", "setRotate", "scale", "getScale", "setScale", "text", "getText", "setText", "(Ljava/lang/String;)V", "ttsInfo", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TTSInfo;", "width", "getWidth", "setWidth", "bringToFront", "", "delete", "getTTSInfo", "isValid", "", "setTTSInfo", "path", "durationMs", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "updateMatrix", "plugin-recordvideo_release"})
public final class o extends a implements i {
    public final String Cga;
    public final RectF Cgb;
    private final b Cgc;
    public j Cgd;
    public float centerX;
    public float centerY;
    public int height;
    public float mat;
    public float scale;
    public String text;
    public long wKD;
    public int width;

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.i
    public final boolean eMq() {
        AppMethodBeat.i(237824);
        boolean a2 = i.a.a(this);
        AppMethodBeat.o(237824);
        return a2;
    }

    public final void setText(String str) {
        AppMethodBeat.i(237817);
        p.h(str, "<set-?>");
        this.text = str;
        AppMethodBeat.o(237817);
    }

    public /* synthetic */ o(String str) {
        this(str, new Matrix());
        AppMethodBeat.i(237822);
        AppMethodBeat.o(237822);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private o(String str, Matrix matrix) {
        super(d.PAG_STICKER);
        p.h(str, "pagPath");
        p.h(matrix, "matrix");
        AppMethodBeat.i(237821);
        this.text = "";
        this.width = 160;
        this.height = 160;
        this.scale = 1.0f;
        this.Cgb = new RectF();
        this.Cgc = new b();
        this.Cga = str;
        this.gT.set(matrix);
        AppMethodBeat.o(237821);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(jn jnVar) {
        super(d.PAG_STICKER);
        String str;
        p.h(jnVar, "proto");
        AppMethodBeat.i(237823);
        this.text = "";
        this.width = 160;
        this.height = 160;
        this.scale = 1.0f;
        this.Cgb = new RectF();
        this.Cgc = new b();
        cyg cyg = new cyg();
        SKBuiltinBuffer_t sKBuiltinBuffer_t = jnVar.KOd;
        p.g(sKBuiltinBuffer_t, "proto.itemData");
        try {
            cyg.parseFrom(sKBuiltinBuffer_t.getBufferToBytes());
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            cyg = null;
        }
        cyg cyg2 = cyg;
        if (cyg2 != null) {
            String str2 = cyg2.Cga;
            p.g(str2, "it.pagPath");
            String str3 = cyg2.text;
            p.g(str3, "it.text");
            this.text = str3;
            Matrix matrix = this.gT;
            erc erc = cyg2.Lce;
            p.g(erc, "it.matrix");
            matrix.setValues(a(erc));
            g(this.gT);
            a(cyg2.Cgj);
            str = str2;
        } else {
            str = "";
        }
        this.Cga = str;
        AppMethodBeat.o(237823);
    }

    public final void g(Matrix matrix) {
        AppMethodBeat.i(237818);
        p.h(matrix, "matrix");
        float[] fArr = {0.0f, 0.0f};
        matrix.mapPoints(fArr, new float[]{((float) this.width) / 2.0f, ((float) this.height) / 2.0f});
        this.centerX = fArr[0];
        this.centerY = fArr[1] - this.Cgb.top;
        float[] fArr2 = new float[9];
        matrix.getValues(fArr2);
        double d2 = (double) fArr2[0];
        double d3 = (double) fArr2[3];
        this.scale = (float) Math.sqrt((d2 * d2) + (d3 * d3));
        this.mat = (float) Math.atan2(d3, (double) fArr2[4]);
        j jVar = this.Cgd;
        if (jVar != null) {
            jVar.q(this.centerX, this.centerY, this.scale, this.mat);
            AppMethodBeat.o(237818);
            return;
        }
        AppMethodBeat.o(237818);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.h
    public final a eMk() {
        AppMethodBeat.i(237819);
        cyg cyg = new cyg();
        cyg.Cga = this.Cga;
        cyg.text = this.text;
        cyg.Lce = f(this.gT);
        cyg.Cgj = eMi();
        cyg cyg2 = cyg;
        AppMethodBeat.o(237819);
        return cyg2;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.i
    public final void bh(String str, long j2) {
        AppMethodBeat.i(237820);
        p.h(str, "path");
        this.Cgc.setPath(str);
        this.Cgc.durationMs = j2;
        AppMethodBeat.o(237820);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.i
    public final b eMp() {
        return this.Cgc;
    }
}
