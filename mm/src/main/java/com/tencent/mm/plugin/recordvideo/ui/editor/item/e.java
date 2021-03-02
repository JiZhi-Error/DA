package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aiu;
import com.tencent.mm.protocal.protobuf.erc;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EmojiItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "showMatrix", "Landroid/graphics/Matrix;", "editorMatrix", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/graphics/Matrix;Landroid/graphics/Matrix;)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "<set-?>", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getShowMatrix", "()Landroid/graphics/Matrix;", "isValid", "", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "toString", "", "Companion", "plugin-recordvideo_release"})
public final class e extends a {
    public static final a Cfu = new a((byte) 0);
    Matrix Cft;
    public EmojiInfo gWm;

    static {
        AppMethodBeat.i(237765);
        AppMethodBeat.o(237765);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EmojiItem$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public /* synthetic */ e(EmojiInfo emojiInfo) {
        this(emojiInfo, new Matrix(), new Matrix());
        AppMethodBeat.i(237763);
        AppMethodBeat.o(237763);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(EmojiInfo emojiInfo, Matrix matrix, Matrix matrix2) {
        super(d.EMOJI);
        p.h(matrix, "showMatrix");
        p.h(matrix2, "editorMatrix");
        AppMethodBeat.i(237762);
        this.Cft = new Matrix();
        this.gWm = emojiInfo;
        this.Cft.set(matrix);
        this.gT.set(matrix2);
        b.i("MicroMsg.EmojiItem", toString());
        AppMethodBeat.o(237762);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(jn jnVar) {
        super(d.EMOJI);
        p.h(jnVar, "proto");
        AppMethodBeat.i(237764);
        this.Cft = new Matrix();
        try {
            aiu aiu = new aiu();
            SKBuiltinBuffer_t sKBuiltinBuffer_t = jnVar.KOd;
            p.g(sKBuiltinBuffer_t, "proto.itemData");
            com.tencent.mm.bw.b buffer = sKBuiltinBuffer_t.getBuffer();
            p.g(buffer, "proto.itemData.buffer");
            try {
                aiu.parseFrom(buffer.zy);
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
                aiu = null;
            }
            aiu aiu2 = aiu;
            if (aiu2 != null) {
                com.tencent.mm.kernel.b.a ah = g.ah(d.class);
                p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
                this.gWm = ((d) ah).getProvider().amm(aiu2.md5);
                Matrix matrix = this.Cft;
                erc erc = aiu2.Lsq;
                p.g(erc, "it.showMatrix");
                matrix.setValues(a(erc));
                Matrix matrix2 = this.gT;
                erc erc2 = aiu2.Lsp;
                p.g(erc2, "it.editorMatrix");
                matrix2.setValues(a(erc2));
                a(aiu2.Cgj);
                b.i("MicroMsg.EmojiItem", toString());
                AppMethodBeat.o(237764);
                return;
            }
            AppMethodBeat.o(237764);
        } catch (IOException e3) {
            b.printErrStackTrace("MicroMsg.EmojiItem", e3, "EmojiItem parse error", new Object[0]);
            AppMethodBeat.o(237764);
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.h
    public final com.tencent.mm.bw.a eMk() {
        String str;
        String str2;
        AppMethodBeat.i(237760);
        aiu aiu = new aiu();
        EmojiInfo emojiInfo = this.gWm;
        if (emojiInfo == null || (str = emojiInfo.getMd5()) == null) {
            str = "";
        }
        aiu.md5 = str;
        EmojiInfo emojiInfo2 = this.gWm;
        if (emojiInfo2 == null || (str2 = emojiInfo2.getName()) == null) {
            str2 = "";
        }
        aiu.name = str2;
        aiu.Lsp = f(this.gT);
        aiu.Lsq = f(this.Cft);
        aiu.Cgj = eMi();
        aiu aiu2 = aiu;
        AppMethodBeat.o(237760);
        return aiu2;
    }

    public final String toString() {
        String str = null;
        AppMethodBeat.i(237761);
        StringBuilder append = new StringBuilder("[").append(hashCode()).append("]md5:");
        EmojiInfo emojiInfo = this.gWm;
        StringBuilder append2 = append.append(emojiInfo != null ? emojiInfo.getMd5() : null).append(" name:");
        EmojiInfo emojiInfo2 = this.gWm;
        if (emojiInfo2 != null) {
            str = emojiInfo2.getName();
        }
        String sb = append2.append(str).toString();
        AppMethodBeat.o(237761);
        return sb;
    }
}
