package com.google.android.gms.wearable.internal;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.ChannelIOException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.OutputStream;
import javax.annotation.Nullable;

public final class zzbl extends OutputStream {
    @Nullable
    private volatile zzav zzcw;
    private final OutputStream zzcy;

    public zzbl(OutputStream outputStream) {
        AppMethodBeat.i(101071);
        this.zzcy = (OutputStream) Preconditions.checkNotNull(outputStream);
        AppMethodBeat.o(101071);
    }

    private final IOException zza(IOException iOException) {
        AppMethodBeat.i(101077);
        zzav zzav = this.zzcw;
        if (zzav != null) {
            Log.isLoggable("ChannelOutputStream", 2);
            ChannelIOException channelIOException = new ChannelIOException("Channel closed unexpectedly before stream was finished", zzav.zzg, zzav.zzcj);
            AppMethodBeat.o(101077);
            return channelIOException;
        }
        AppMethodBeat.o(101077);
        return iOException;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(101072);
        try {
            this.zzcy.close();
            AppMethodBeat.o(101072);
        } catch (IOException e2) {
            IOException zza = zza(e2);
            AppMethodBeat.o(101072);
            throw zza;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        AppMethodBeat.i(101073);
        try {
            this.zzcy.flush();
            AppMethodBeat.o(101073);
        } catch (IOException e2) {
            IOException zza = zza(e2);
            AppMethodBeat.o(101073);
            throw zza;
        }
    }

    @Override // java.io.OutputStream
    public final void write(int i2) {
        AppMethodBeat.i(101076);
        try {
            this.zzcy.write(i2);
            AppMethodBeat.o(101076);
        } catch (IOException e2) {
            IOException zza = zza(e2);
            AppMethodBeat.o(101076);
            throw zza;
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        AppMethodBeat.i(101074);
        try {
            this.zzcy.write(bArr);
            AppMethodBeat.o(101074);
        } catch (IOException e2) {
            IOException zza = zza(e2);
            AppMethodBeat.o(101074);
            throw zza;
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(101075);
        try {
            this.zzcy.write(bArr, i2, i3);
            AppMethodBeat.o(101075);
        } catch (IOException e2) {
            IOException zza = zza(e2);
            AppMethodBeat.o(101075);
            throw zza;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(zzav zzav) {
        this.zzcw = zzav;
    }
}
