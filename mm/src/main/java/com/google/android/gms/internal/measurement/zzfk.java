package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public final class zzfk extends zzjq {
    private final SSLSocketFactory zzajg;

    public zzfk(zzjr zzjr) {
        super(zzjr);
        AppMethodBeat.i(1427);
        this.zzajg = Build.VERSION.SDK_INT < 19 ? new zzkb() : null;
        AppMethodBeat.o(1427);
    }

    static /* synthetic */ byte[] zza(zzfk zzfk, HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(1452);
        byte[] zzb = zzb(httpURLConnection);
        AppMethodBeat.o(1452);
        return zzb;
    }

    private static byte[] zzb(HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(1429);
        InputStream inputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            AppMethodBeat.o(1429);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.i(1443);
        Context context = super.getContext();
        AppMethodBeat.o(1443);
        return context;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.i(1435);
        super.zzab();
        AppMethodBeat.o(1435);
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public final HttpURLConnection zzb(URL url) {
        AppMethodBeat.i(1430);
        URLConnection openConnection = url.openConnection();
        if (!(openConnection instanceof HttpURLConnection)) {
            IOException iOException = new IOException("Failed to obtain HTTP connection");
            AppMethodBeat.o(1430);
            throw iOException;
        }
        if (this.zzajg != null && (openConnection instanceof HttpsURLConnection)) {
            ((HttpsURLConnection) openConnection).setSSLSocketFactory(this.zzajg);
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setReadTimeout(61000);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setDoInput(true);
        AppMethodBeat.o(1430);
        return httpURLConnection;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.i(1442);
        Clock zzbt = super.zzbt();
        AppMethodBeat.o(1442);
        return zzbt;
    }

    public final boolean zzex() {
        NetworkInfo networkInfo;
        AppMethodBeat.i(1428);
        zzch();
        try {
            networkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e2) {
            networkInfo = null;
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            AppMethodBeat.o(1428);
            return false;
        }
        AppMethodBeat.o(1428);
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.i(1433);
        super.zzfr();
        AppMethodBeat.o(1433);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.i(1434);
        super.zzfs();
        AppMethodBeat.o(1434);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.i(1436);
        zzdu zzft = super.zzft();
        AppMethodBeat.o(1436);
        return zzft;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.i(1437);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.o(1437);
        return zzfu;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.i(1438);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.o(1438);
        return zzfv;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.i(1439);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.o(1439);
        return zzfw;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.i(1440);
        zzii zzfx = super.zzfx();
        AppMethodBeat.o(1440);
        return zzfx;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.i(1441);
        zzif zzfy = super.zzfy();
        AppMethodBeat.o(1441);
        return zzfy;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.i(1444);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.o(1444);
        return zzfz;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.i(1445);
        zzfe zzga = super.zzga();
        AppMethodBeat.o(1445);
        return zzga;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.i(1446);
        zzka zzgb = super.zzgb();
        AppMethodBeat.o(1446);
        return zzgb;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.i(1447);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.o(1447);
        return zzgc;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.i(1448);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.o(1448);
        return zzgd;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.i(1449);
        zzfg zzge = super.zzge();
        AppMethodBeat.o(1449);
        return zzge;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.i(1450);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.o(1450);
        return zzgf;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.i(1451);
        zzef zzgg = super.zzgg();
        AppMethodBeat.o(1451);
        return zzgg;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzjq
    public final boolean zzhf() {
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzjp
    public final /* bridge */ /* synthetic */ zzeb zziw() {
        AppMethodBeat.i(1431);
        zzeb zziw = super.zziw();
        AppMethodBeat.o(1431);
        return zziw;
    }

    @Override // com.google.android.gms.internal.measurement.zzjp
    public final /* bridge */ /* synthetic */ zzei zzix() {
        AppMethodBeat.i(1432);
        zzei zzix = super.zzix();
        AppMethodBeat.o(1432);
        return zzix;
    }
}
