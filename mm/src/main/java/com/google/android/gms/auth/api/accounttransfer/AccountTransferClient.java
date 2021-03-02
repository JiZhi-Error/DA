package com.google.android.gms.auth.api.accounttransfer;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.auth.zzab;
import com.google.android.gms.internal.auth.zzac;
import com.google.android.gms.internal.auth.zzae;
import com.google.android.gms.internal.auth.zzag;
import com.google.android.gms.internal.auth.zzai;
import com.google.android.gms.internal.auth.zzak;
import com.google.android.gms.internal.auth.zzv;
import com.google.android.gms.internal.auth.zzx;
import com.google.android.gms.internal.auth.zzy;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AccountTransferClient extends GoogleApi<zzq> {
    private static final Api.ClientKey<zzx> zzau = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zzx, zzq> zzav = new zzf();
    private static final Api<zzq> zzaw = new Api<>("AccountTransfer.ACCOUNT_TRANSFER_API", zzav, zzau);

    static class zzd<T> extends zzv {
        private zze<T> zzbg;

        public zzd(zze<T> zze) {
            this.zzbg = zze;
        }

        @Override // com.google.android.gms.internal.auth.zzv, com.google.android.gms.internal.auth.zzaa
        public final void onFailure(Status status) {
            AppMethodBeat.i(10637);
            this.zzbg.zzd(status);
            AppMethodBeat.o(10637);
        }
    }

    static abstract class zze<T> extends TaskApiCall<zzx, T> {
        private TaskCompletionSource<T> zzbh;

        private zze() {
        }

        /* synthetic */ zze(zzf zzf) {
            this();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient, com.google.android.gms.tasks.TaskCompletionSource] */
        @Override // com.google.android.gms.common.api.internal.TaskApiCall
        public /* synthetic */ void doExecute(zzx zzx, TaskCompletionSource taskCompletionSource) {
            this.zzbh = taskCompletionSource;
            zzd((zzac) zzx.getService());
        }

        /* access modifiers changed from: protected */
        public final void setResult(T t) {
            this.zzbh.setResult(t);
        }

        /* access modifiers changed from: protected */
        public final void zzd(Status status) {
            AccountTransferClient.zze(this.zzbh, status);
        }

        /* access modifiers changed from: protected */
        public abstract void zzd(zzac zzac);
    }

    static abstract class zzf extends zze<Void> {
        zzab zzbi;

        private zzf() {
            super(null);
            this.zzbi = new zzn(this);
        }

        /* synthetic */ zzf(zzf zzf) {
            this();
        }
    }

    static {
        AppMethodBeat.i(10647);
        AppMethodBeat.o(10647);
    }

    AccountTransferClient(Activity activity) {
        super(activity, (Api) zzaw, (Api.ApiOptions) null, new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
        AppMethodBeat.i(10639);
        AppMethodBeat.o(10639);
    }

    AccountTransferClient(Context context) {
        super(context, zzaw, (Api.ApiOptions) null, new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
        AppMethodBeat.i(10638);
        AppMethodBeat.o(10638);
    }

    private static void zzd(TaskCompletionSource taskCompletionSource, Status status) {
        AppMethodBeat.i(10645);
        taskCompletionSource.setException(new AccountTransferException(status));
        AppMethodBeat.o(10645);
    }

    static /* synthetic */ void zze(TaskCompletionSource taskCompletionSource, Status status) {
        AppMethodBeat.i(10646);
        zzd(taskCompletionSource, status);
        AppMethodBeat.o(10646);
    }

    public Task<DeviceMetaData> getDeviceMetaData(String str) {
        AppMethodBeat.i(10642);
        Preconditions.checkNotNull(str);
        Task<DeviceMetaData> doRead = doRead(new zzj(this, new zzy(str)));
        AppMethodBeat.o(10642);
        return doRead;
    }

    public Task<Void> notifyCompletion(String str, int i2) {
        AppMethodBeat.i(10644);
        Preconditions.checkNotNull(str);
        Task<Void> doWrite = doWrite(new zzm(this, new zzae(str, i2)));
        AppMethodBeat.o(10644);
        return doWrite;
    }

    public Task<byte[]> retrieveData(String str) {
        AppMethodBeat.i(10641);
        Preconditions.checkNotNull(str);
        Task<byte[]> doRead = doRead(new zzh(this, new zzag(str)));
        AppMethodBeat.o(10641);
        return doRead;
    }

    public Task<Void> sendData(String str, byte[] bArr) {
        AppMethodBeat.i(10640);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(bArr);
        Task<Void> doWrite = doWrite(new zzg(this, new zzai(str, bArr)));
        AppMethodBeat.o(10640);
        return doWrite;
    }

    public Task<Void> showUserChallenge(String str, PendingIntent pendingIntent) {
        AppMethodBeat.i(10643);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(pendingIntent);
        Task<Void> doWrite = doWrite(new zzl(this, new zzak(str, pendingIntent)));
        AppMethodBeat.o(10643);
        return doWrite;
    }
}
