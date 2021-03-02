package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;

public final class zzci implements DataApi.GetFdForAssetResult {
    private volatile boolean closed = false;
    private volatile InputStream zzct;
    private volatile ParcelFileDescriptor zzf;
    private final Status zzp;

    public zzci(Status status, ParcelFileDescriptor parcelFileDescriptor) {
        this.zzp = status;
        this.zzf = parcelFileDescriptor;
    }

    @Override // com.google.android.gms.wearable.DataApi.GetFdForAssetResult
    public final ParcelFileDescriptor getFd() {
        AppMethodBeat.i(101120);
        if (this.closed) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot access the file descriptor after release().");
            AppMethodBeat.o(101120);
            throw illegalStateException;
        }
        ParcelFileDescriptor parcelFileDescriptor = this.zzf;
        AppMethodBeat.o(101120);
        return parcelFileDescriptor;
    }

    @Override // com.google.android.gms.wearable.DataApi.GetFdForAssetResult
    public final InputStream getInputStream() {
        AppMethodBeat.i(101121);
        if (this.closed) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot access the input stream after release().");
            AppMethodBeat.o(101121);
            throw illegalStateException;
        } else if (this.zzf == null) {
            AppMethodBeat.o(101121);
            return null;
        } else {
            if (this.zzct == null) {
                this.zzct = new ParcelFileDescriptor.AutoCloseInputStream(this.zzf);
            }
            InputStream inputStream = this.zzct;
            AppMethodBeat.o(101121);
            return inputStream;
        }
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzp;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
        AppMethodBeat.i(101122);
        if (this.zzf == null) {
            AppMethodBeat.o(101122);
        } else if (this.closed) {
            IllegalStateException illegalStateException = new IllegalStateException("releasing an already released result.");
            AppMethodBeat.o(101122);
            throw illegalStateException;
        } else {
            try {
                if (this.zzct != null) {
                    this.zzct.close();
                } else {
                    this.zzf.close();
                }
                this.closed = true;
                this.zzf = null;
                this.zzct = null;
                AppMethodBeat.o(101122);
            } catch (IOException e2) {
                AppMethodBeat.o(101122);
            }
        }
    }
}
