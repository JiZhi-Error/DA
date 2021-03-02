package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ckl;
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.protocal.protobuf.erc;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001d\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R>\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\fj\b\u0012\u0004\u0012\u00020\u0004`\r2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\fj\b\u0012\u0004\u0012\u00020\u0004`\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "lyricsInfo", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "matrix", "Landroid/graphics/Matrix;", "(Ljava/util/List;Landroid/graphics/Matrix;)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "<set-?>", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLyricsInfo", "()Ljava/util/ArrayList;", "isValid", "", "limitLyrics", "", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "toString", "", "Companion", "plugin-recordvideo_release"})
public final class l extends a {
    public static final a CfB = new a((byte) 0);
    ArrayList<ckm> CfA = new ArrayList<>();

    static {
        AppMethodBeat.i(237789);
        AppMethodBeat.o(237789);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItem$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(List<? extends ckm> list, Matrix matrix) {
        super(d.LYRICS);
        p.h(list, "lyricsInfo");
        p.h(matrix, "matrix");
        AppMethodBeat.i(237787);
        this.CfA.clear();
        this.CfA.addAll(list);
        this.gT.set(matrix);
        AppMethodBeat.o(237787);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(jn jnVar) {
        super(d.LYRICS);
        p.h(jnVar, "proto");
        AppMethodBeat.i(237788);
        try {
            ckl ckl = new ckl();
            SKBuiltinBuffer_t sKBuiltinBuffer_t = jnVar.KOd;
            p.g(sKBuiltinBuffer_t, "proto.itemData");
            b buffer = sKBuiltinBuffer_t.getBuffer();
            p.g(buffer, "proto.itemData.buffer");
            try {
                ckl.parseFrom(buffer.zy);
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
                ckl = null;
            }
            ckl ckl2 = ckl;
            if (ckl2 != null) {
                this.CfA.clear();
                this.CfA.addAll(ckl2.MpX);
                Matrix matrix = this.gT;
                erc erc = ckl2.Lce;
                p.g(erc, "it.matrix");
                matrix.setValues(a(erc));
                Log.i("MicroMsg.LyricsItem", toString());
                AppMethodBeat.o(237788);
                return;
            }
            AppMethodBeat.o(237788);
        } catch (IOException e3) {
            Log.printErrStackTrace("MicroMsg.LyricsItem", e3, "LocationItem parse error", new Object[0]);
            AppMethodBeat.o(237788);
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.h
    public final com.tencent.mm.bw.a eMk() {
        AppMethodBeat.i(237784);
        ckl ckl = new ckl();
        float[] fArr = new float[9];
        erc erc = new erc();
        this.gT.getValues(fArr);
        for (int i2 = 0; i2 < 9; i2++) {
            erc.LOe.add(Float.valueOf(fArr[i2]));
        }
        ckl.MpX.addAll(this.CfA);
        ckl.Lce = erc;
        ckl ckl2 = ckl;
        AppMethodBeat.o(237784);
        return ckl2;
    }

    public final void Ij(long j2) {
        AppMethodBeat.i(237785);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t : this.CfA) {
            if (t.startTime < j2) {
                arrayList2.add(t);
            }
        }
        arrayList.addAll(arrayList2);
        this.CfA.clear();
        this.CfA.addAll(arrayList);
        AppMethodBeat.o(237785);
    }

    public final String toString() {
        AppMethodBeat.i(237786);
        String str = "[" + hashCode() + "]lyrics size:" + this.CfA.size();
        AppMethodBeat.o(237786);
        return str;
    }
}
