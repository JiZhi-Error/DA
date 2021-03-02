package com.tencent.mm.xeffect.effect;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@Keep
@l(hxD = {1, 1, 15}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, hxF = {"Lcom/tencent/mm/xeffect/effect/StickerDecoderFactoryWrapper;", "Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;", "factory", "(Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;)V", "getFactory", "()Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;", "getDecoder", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "bytes", "", "path", "", "renderlib_release"})
public final class StickerDecoderFactoryWrapper implements IStickerDecoderFactory {
    private final IStickerDecoderFactory factory;

    public StickerDecoderFactoryWrapper(IStickerDecoderFactory iStickerDecoderFactory) {
        p.h(iStickerDecoderFactory, "factory");
        AppMethodBeat.i(237106);
        this.factory = iStickerDecoderFactory;
        AppMethodBeat.o(237106);
    }

    public final IStickerDecoderFactory getFactory() {
        return this.factory;
    }

    @Override // com.tencent.mm.xeffect.effect.IStickerDecoderFactory
    public final IStickerDecoder getDecoder(String str) {
        AppMethodBeat.i(237104);
        p.h(str, "path");
        z.auD();
        StickerDecoderWrapper stickerDecoderWrapper = new StickerDecoderWrapper(this.factory.getDecoder(str));
        AppMethodBeat.o(237104);
        return stickerDecoderWrapper;
    }

    @Override // com.tencent.mm.xeffect.effect.IStickerDecoderFactory
    public final IStickerDecoder getDecoder(byte[] bArr) {
        AppMethodBeat.i(237105);
        p.h(bArr, "bytes");
        z.auD();
        new StringBuilder("getDecoder from bytes: ").append(bArr.length);
        StickerDecoderWrapper stickerDecoderWrapper = new StickerDecoderWrapper(this.factory.getDecoder(bArr));
        AppMethodBeat.o(237105);
        return stickerDecoderWrapper;
    }
}
