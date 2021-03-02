package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.i;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ehd;
import com.tencent.mm.protocal.protobuf.erc;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B5\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB=\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000eB\u000f\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\rH\u0016J\u000e\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020\u0000R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorTTSData;", "text", "", "textColor", "", "textBgColor", "marginBottom", "matrix", "Landroid/graphics/Matrix;", "(Ljava/lang/CharSequence;IIILandroid/graphics/Matrix;)V", "font", "", "(Ljava/lang/CharSequence;IILjava/lang/String;ILandroid/graphics/Matrix;)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "getFont", "()Ljava/lang/String;", "setFont", "(Ljava/lang/String;)V", "getMarginBottom", "()I", "setMarginBottom", "(I)V", "<set-?>", "getText", "()Ljava/lang/CharSequence;", "getTextBgColor", "getTextColor", "ttsInfo", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TTSInfo;", "getTTSInfo", "isValid", "", "setTTSInfo", "", "path", "durationMs", "", "toProtoBuf", "Lcom/tencent/mm/protocal/protobuf/TextItemData;", "toString", "update", "item", "Companion", "plugin-recordvideo_release"})
public final class q extends a implements i {
    public static final a Cgh = new a((byte) 0);
    int CeB;
    public String CeI;
    private final b Cgc;
    public int Cgg;
    public CharSequence text;
    public int textColor;

    static {
        AppMethodBeat.i(237837);
        AppMethodBeat.o(237837);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.i
    public final boolean eMq() {
        AppMethodBeat.i(237838);
        boolean a2 = i.a.a(this);
        AppMethodBeat.o(237838);
        return a2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ q(java.lang.CharSequence r8, int r9, int r10, int r11, android.graphics.Matrix r12, int r13) {
        /*
            r7 = this;
            r6 = 237833(0x3a109, float:3.33275E-40)
            r0 = r13 & 8
            if (r0 == 0) goto L_0x0021
            r4 = 0
        L_0x0008:
            r0 = r13 & 16
            if (r0 == 0) goto L_0x001f
            android.graphics.Matrix r5 = new android.graphics.Matrix
            r5.<init>()
        L_0x0011:
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r0.<init>(r1, r2, r3, r4, r5)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return
        L_0x001f:
            r5 = r12
            goto L_0x0011
        L_0x0021:
            r4 = r11
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.ui.editor.item.q.<init>(java.lang.CharSequence, int, int, int, android.graphics.Matrix, int):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(CharSequence charSequence, int i2, int i3, int i4, Matrix matrix) {
        super(d.TEXT);
        p.h(matrix, "matrix");
        AppMethodBeat.i(237832);
        this.CeI = "";
        this.Cgc = new b();
        this.text = charSequence;
        this.textColor = i2;
        this.Cgg = i3;
        this.CeB = i4;
        this.gT.set(matrix);
        Log.i("MicroMsg.TextItem", toString());
        AppMethodBeat.o(237832);
    }

    public /* synthetic */ q(CharSequence charSequence, int i2, int i3, String str) {
        this(charSequence, i2, i3, str, new Matrix());
        AppMethodBeat.i(237835);
        AppMethodBeat.o(237835);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private q(CharSequence charSequence, int i2, int i3, String str, Matrix matrix) {
        super(d.TEXT);
        p.h(str, "font");
        p.h(matrix, "matrix");
        AppMethodBeat.i(237834);
        this.CeI = "";
        this.Cgc = new b();
        this.text = charSequence;
        this.textColor = i2;
        this.Cgg = i3;
        this.CeI = str;
        this.CeB = 0;
        this.gT.set(matrix);
        Log.i("MicroMsg.TextItem", toString());
        AppMethodBeat.o(237834);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(jn jnVar) {
        super(d.TEXT);
        p.h(jnVar, "proto");
        AppMethodBeat.i(237836);
        this.CeI = "";
        this.Cgc = new b();
        try {
            ehd ehd = new ehd();
            SKBuiltinBuffer_t sKBuiltinBuffer_t = jnVar.KOd;
            p.g(sKBuiltinBuffer_t, "proto.itemData");
            com.tencent.mm.bw.b buffer = sKBuiltinBuffer_t.getBuffer();
            p.g(buffer, "proto.itemData.buffer");
            try {
                ehd.parseFrom(buffer.zy);
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
                ehd = null;
            }
            ehd ehd2 = ehd;
            if (ehd2 != null) {
                this.text = ehd2.text;
                this.textColor = ehd2.textColor;
                this.Cgg = ehd2.Cgg;
                this.CeB = ehd2.CeB;
                Matrix matrix = this.gT;
                erc erc = ehd2.Lce;
                p.g(erc, "it.matrix");
                matrix.setValues(a(erc));
                String str = ehd2.CeI;
                p.g(str, "it.font");
                this.CeI = str;
                a(ehd2.Cgj);
                Log.i("MicroMsg.TextItem", toString());
                AppMethodBeat.o(237836);
                return;
            }
            AppMethodBeat.o(237836);
        } catch (IOException e3) {
            Log.printErrStackTrace("MicroMsg.TextItem", e3, "LocationItem parse error", new Object[0]);
            AppMethodBeat.o(237836);
        }
    }

    public final void a(q qVar) {
        AppMethodBeat.i(237827);
        p.h(qVar, "item");
        this.text = qVar.text;
        this.textColor = qVar.textColor;
        this.Cgg = qVar.Cgg;
        this.CeB = qVar.CeB;
        this.gT.set(qVar.gT);
        this.CeI = qVar.CeI;
        Log.i("MicroMsg.TextItem", toString());
        AppMethodBeat.o(237827);
    }

    public final boolean isValid() {
        AppMethodBeat.i(237829);
        if (!TextUtils.isEmpty(this.text)) {
            AppMethodBeat.o(237829);
            return true;
        }
        AppMethodBeat.o(237829);
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.i
    public final void bh(String str, long j2) {
        AppMethodBeat.i(237830);
        p.h(str, "path");
        this.Cgc.setPath(str);
        this.Cgc.durationMs = j2;
        AppMethodBeat.o(237830);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.i
    public final b eMp() {
        return this.Cgc;
    }

    public final String toString() {
        AppMethodBeat.i(237831);
        String str = "[" + hashCode() + "]text:" + this.text + " color:" + this.textColor + " bgColor:" + this.Cgg;
        AppMethodBeat.o(237831);
        return str;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.h
    public final /* synthetic */ com.tencent.mm.bw.a eMk() {
        AppMethodBeat.i(237828);
        ehd ehd = new ehd();
        ehd.text = String.valueOf(this.text);
        ehd.Lce = f(this.gT);
        ehd.Cgg = this.Cgg;
        ehd.textColor = this.textColor;
        ehd.CeI = this.CeI;
        ehd.Cgj = eMi();
        ehd ehd2 = ehd;
        AppMethodBeat.o(237828);
        return ehd2;
    }
}
