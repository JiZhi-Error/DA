package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.b.f;
import com.google.android.exoplayer2.b.g;
import com.google.android.exoplayer2.i.a;
import java.nio.ByteBuffer;

public abstract class b extends g<h, i, f> implements e {
    private final String name;

    /* access modifiers changed from: protected */
    public abstract d b(byte[] bArr, int i2, boolean z);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.b.f] */
    @Override // com.google.android.exoplayer2.b.g
    public final /* bridge */ /* synthetic */ void a(i iVar) {
        super.a((f) iVar);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected b(String str) {
        super(new h[2], new i[2]);
        this.name = str;
        a.checkState(this.bhw == this.bhu.length);
        for (I i2 : this.bhu) {
            i2.dM(1024);
        }
    }

    @Override // com.google.android.exoplayer2.f.e
    public final void ah(long j2) {
    }

    /* access modifiers changed from: protected */
    public final void a(i iVar) {
        super.a((f) iVar);
    }

    /* access modifiers changed from: private */
    public f a(h hVar, i iVar, boolean z) {
        try {
            ByteBuffer byteBuffer = hVar.aKP;
            iVar.a(hVar.timeUs, b(byteBuffer.array(), byteBuffer.limit(), z), hVar.bdC);
            iVar.flags &= Integer.MAX_VALUE;
            return null;
        } catch (f e2) {
            return e2;
        }
    }

    /* Return type fixed from 'com.google.android.exoplayer2.b.f' to match base method */
    @Override // com.google.android.exoplayer2.b.g
    public final /* synthetic */ i up() {
        return new c(this);
    }

    /* Return type fixed from 'com.google.android.exoplayer2.b.e' to match base method */
    @Override // com.google.android.exoplayer2.b.g
    public final /* synthetic */ h uo() {
        return new h();
    }
}
