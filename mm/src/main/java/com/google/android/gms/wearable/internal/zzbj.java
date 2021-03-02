package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.ChannelIOException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import javax.annotation.Nullable;

public final class zzbj extends InputStream {
    private final InputStream zzcv;
    @Nullable
    private volatile zzav zzcw;

    public zzbj(InputStream inputStream) {
        AppMethodBeat.i(101058);
        this.zzcv = (InputStream) Preconditions.checkNotNull(inputStream);
        AppMethodBeat.o(101058);
    }

    private final int zza(int i2) {
        zzav zzav;
        AppMethodBeat.i(101069);
        if (i2 != -1 || (zzav = this.zzcw) == null) {
            AppMethodBeat.o(101069);
            return i2;
        }
        ChannelIOException channelIOException = new ChannelIOException("Channel closed unexpectedly before stream was finished", zzav.zzg, zzav.zzcj);
        AppMethodBeat.o(101069);
        throw channelIOException;
    }

    @Override // java.io.InputStream
    public final int available() {
        AppMethodBeat.i(101060);
        int available = this.zzcv.available();
        AppMethodBeat.o(101060);
        return available;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public final void close() {
        AppMethodBeat.i(101061);
        this.zzcv.close();
        AppMethodBeat.o(101061);
    }

    public final void mark(int i2) {
        AppMethodBeat.i(101062);
        this.zzcv.mark(i2);
        AppMethodBeat.o(101062);
    }

    public final boolean markSupported() {
        AppMethodBeat.i(101063);
        boolean markSupported = this.zzcv.markSupported();
        AppMethodBeat.o(101063);
        return markSupported;
    }

    @Override // java.io.InputStream
    public final int read() {
        AppMethodBeat.i(101064);
        int zza = zza(this.zzcv.read());
        AppMethodBeat.o(101064);
        return zza;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        AppMethodBeat.i(101065);
        int zza = zza(this.zzcv.read(bArr));
        AppMethodBeat.o(101065);
        return zza;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(101066);
        int zza = zza(this.zzcv.read(bArr, i2, i3));
        AppMethodBeat.o(101066);
        return zza;
    }

    @Override // java.io.InputStream
    public final void reset() {
        AppMethodBeat.i(101067);
        this.zzcv.reset();
        AppMethodBeat.o(101067);
    }

    @Override // java.io.InputStream
    public final long skip(long j2) {
        AppMethodBeat.i(101068);
        long skip = this.zzcv.skip(j2);
        AppMethodBeat.o(101068);
        return skip;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzav zzav) {
        AppMethodBeat.i(101059);
        this.zzcw = (zzav) Preconditions.checkNotNull(zzav);
        AppMethodBeat.o(101059);
    }
}
