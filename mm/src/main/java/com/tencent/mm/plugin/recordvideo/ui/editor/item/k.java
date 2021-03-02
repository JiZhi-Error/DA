package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cka;
import com.tencent.mm.protocal.protobuf.erc;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB1\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u000f\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "cityName", "", "poiName", "longitude", "", "latitude", "matrix", "Landroid/graphics/Matrix;", "(Ljava/lang/String;Ljava/lang/String;FFLandroid/graphics/Matrix;)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "<set-?>", "getCityName", "()Ljava/lang/String;", "getLatitude", "()F", "getLongitude", "getPoiName", "isValid", "", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "toString", "Companion", "plugin-recordvideo_release"})
public final class k extends a {
    public static final a Cfz = new a((byte) 0);
    String Cfy;
    float dTj;
    String kHV;
    float latitude;

    static {
        AppMethodBeat.i(237783);
        AppMethodBeat.o(237783);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public /* synthetic */ k(String str, String str2, float f2, float f3) {
        this(str, str2, f2, f3, new Matrix());
        AppMethodBeat.i(237781);
        AppMethodBeat.o(237781);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(String str, String str2, float f2, float f3, Matrix matrix) {
        super(d.CeM);
        p.h(str, "cityName");
        p.h(str2, "poiName");
        p.h(matrix, "matrix");
        AppMethodBeat.i(237780);
        this.Cfy = "";
        this.kHV = "";
        this.Cfy = str;
        this.kHV = str2;
        this.latitude = f3;
        this.dTj = f2;
        p.h(matrix, "<set-?>");
        this.gT = matrix;
        b.i("MicroMsg.LocationItem", toString());
        AppMethodBeat.o(237780);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(jn jnVar) {
        super(d.TEXT);
        p.h(jnVar, "proto");
        AppMethodBeat.i(237782);
        this.Cfy = "";
        this.kHV = "";
        try {
            cka cka = new cka();
            SKBuiltinBuffer_t sKBuiltinBuffer_t = jnVar.KOd;
            p.g(sKBuiltinBuffer_t, "proto.itemData");
            com.tencent.mm.bw.b buffer = sKBuiltinBuffer_t.getBuffer();
            p.g(buffer, "proto.itemData.buffer");
            try {
                cka.parseFrom(buffer.zy);
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
                cka = null;
            }
            cka cka2 = cka;
            if (cka2 != null) {
                String str = cka2.Cfy;
                p.g(str, "it.cityName");
                this.Cfy = str;
                String str2 = cka2.kHV;
                p.g(str2, "it.poiName");
                this.kHV = str2;
                this.dTj = cka2.dTj;
                this.latitude = cka2.latitude;
                Matrix matrix = this.gT;
                erc erc = cka2.Lce;
                p.g(erc, "it.matrix");
                matrix.setValues(a(erc));
            }
            b.i("MicroMsg.LocationItem", toString());
            AppMethodBeat.o(237782);
        } catch (IOException e3) {
            b.printErrStackTrace("MicroMsg.LocationItem", e3, "LocationItem parse error", new Object[0]);
            AppMethodBeat.o(237782);
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.h
    public final com.tencent.mm.bw.a eMk() {
        AppMethodBeat.i(237778);
        cka cka = new cka();
        cka.Cfy = this.Cfy;
        cka.kHV = this.kHV;
        cka.Lce = f(this.gT);
        cka.dTj = this.dTj;
        cka.latitude = this.latitude;
        cka cka2 = cka;
        AppMethodBeat.o(237778);
        return cka2;
    }

    public final String toString() {
        AppMethodBeat.i(237779);
        String str = "[" + hashCode() + "]poiName:" + this.kHV + " cityName:" + this.Cfy;
        AppMethodBeat.o(237779);
        return str;
    }
}
