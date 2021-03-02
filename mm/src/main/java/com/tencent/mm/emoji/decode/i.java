package com.tencent.mm.emoji.decode;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.effect.IStickerDecoder;
import com.tencent.mm.xeffect.effect.IStickerDecoderFactory;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/emoji/decode/WXGifBitmapProviderFactory;", "Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;", "()V", "getDecoder", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "bytes", "", "path", "", "plugin-xlabeffect_release"})
public final class i implements IStickerDecoderFactory {
    @Override // com.tencent.mm.xeffect.effect.IStickerDecoderFactory
    public final IStickerDecoder getDecoder(byte[] bArr) {
        AppMethodBeat.i(215213);
        p.h(bArr, "bytes");
        h hVar = new h(bArr);
        AppMethodBeat.o(215213);
        return hVar;
    }

    @Override // com.tencent.mm.xeffect.effect.IStickerDecoderFactory
    public final IStickerDecoder getDecoder(String str) {
        AppMethodBeat.i(215214);
        p.h(str, "path");
        h hVar = new h(str);
        AppMethodBeat.o(215214);
        return hVar;
    }
}
