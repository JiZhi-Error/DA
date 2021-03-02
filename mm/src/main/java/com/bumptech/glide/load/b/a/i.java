package com.bumptech.glide.load.b.a;

public final class i implements a<int[]> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.bumptech.glide.load.b.a.a
    public final /* bridge */ /* synthetic */ int U(int[] iArr) {
        return iArr.length;
    }

    @Override // com.bumptech.glide.load.b.a.a
    public final String getTag() {
        return "IntegerArrayPool";
    }

    @Override // com.bumptech.glide.load.b.a.a
    public final int oY() {
        return 4;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.bumptech.glide.load.b.a.a
    public final /* bridge */ /* synthetic */ int[] di(int i2) {
        return new int[i2];
    }
}
