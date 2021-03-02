package com.bumptech.glide.load.b.a;

public final class g implements a<byte[]> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.bumptech.glide.load.b.a.a
    public final /* bridge */ /* synthetic */ int U(byte[] bArr) {
        return bArr.length;
    }

    @Override // com.bumptech.glide.load.b.a.a
    public final String getTag() {
        return "ByteArrayPool";
    }

    @Override // com.bumptech.glide.load.b.a.a
    public final int oY() {
        return 1;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.bumptech.glide.load.b.a.a
    public final /* bridge */ /* synthetic */ byte[] di(int i2) {
        return new byte[i2];
    }
}
