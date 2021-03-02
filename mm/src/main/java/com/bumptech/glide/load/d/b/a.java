package com.bumptech.glide.load.d.b;

import com.bumptech.glide.load.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class a implements e<ByteBuffer> {
    private final ByteBuffer buffer;

    public a(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
    }

    @Override // com.bumptech.glide.load.a.e
    public final void cleanup() {
    }

    /* renamed from: com.bumptech.glide.load.d.b.a$a  reason: collision with other inner class name */
    public static class C0075a implements e.a<ByteBuffer> {
        /* Return type fixed from 'com.bumptech.glide.load.a.e' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.bumptech.glide.load.a.e.a
        public final /* synthetic */ e<ByteBuffer> T(ByteBuffer byteBuffer) {
            AppMethodBeat.i(77450);
            a aVar = new a(byteBuffer);
            AppMethodBeat.o(77450);
            return aVar;
        }

        @Override // com.bumptech.glide.load.a.e.a
        public final Class<ByteBuffer> os() {
            return ByteBuffer.class;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.bumptech.glide.load.a.e
    public final /* synthetic */ ByteBuffer ov() {
        AppMethodBeat.i(77451);
        this.buffer.position(0);
        ByteBuffer byteBuffer = this.buffer;
        AppMethodBeat.o(77451);
        return byteBuffer;
    }
}
