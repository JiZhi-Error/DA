package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.vfs.s;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public final class c extends b {
    private boolean EkN = true;
    private int EkO;
    private final String EkP;
    private final String EkQ;
    private final a EkR;
    private final int EkS;
    private final String filePath;
    private int scene;

    public interface a {
        void Hn(String str);

        void aas(String str);

        void dx(String str, int i2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ String doInBackground(Void[] voidArr) {
        AppMethodBeat.i(97282);
        String fev = fev();
        AppMethodBeat.o(97282);
        return fev;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(String str) {
        AppMethodBeat.i(97281);
        String str2 = str;
        if (str2 != null) {
            this.EkR.aas(str2);
            AppMethodBeat.o(97281);
            return;
        }
        this.EkR.Hn(this.filePath);
        AppMethodBeat.o(97281);
    }

    public c(String str, String str2, int i2, a aVar) {
        AppMethodBeat.i(97279);
        s.boN(str);
        this.filePath = str + FilePathGenerator.ANDROID_DIR_SEP + str2;
        this.EkO = i2;
        this.scene = 0;
        this.EkQ = "temp_".concat(String.valueOf(str2));
        this.EkP = str + FilePathGenerator.ANDROID_DIR_SEP + this.EkQ;
        this.EkS = Downloads.SPLIT_RANGE_SIZE_WAP;
        this.EkR = aVar;
        AppMethodBeat.o(97279);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x05ae, code lost:
        r1 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x05af, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0327, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        r2.getInputStream().close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0333, code lost:
        r2.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x038a, code lost:
        r0 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0444, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0445, code lost:
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AdLandingPageDownloadBigFileTask", r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0451, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x045e, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        r2.getInputStream().close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x046a, code lost:
        r2.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x04c1, code lost:
        r0 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x058a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x058b, code lost:
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AdLandingPageDownloadBigFileTask", r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0597, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x05a2, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x05a3, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x05ae A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:9:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0322 A[SYNTHETIC, Splitter:B:58:0x0322] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0327 A[Catch:{ IOException -> 0x05ab }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x032c A[SYNTHETIC, Splitter:B:63:0x032c] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x038a  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0451  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0459 A[SYNTHETIC, Splitter:B:76:0x0459] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x045e A[Catch:{ IOException -> 0x059a }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0463 A[SYNTHETIC, Splitter:B:81:0x0463] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x04c1  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0597  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String fev() {
        /*
        // Method dump skipped, instructions count: 1469
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c.fev():java.lang.String");
    }

    private int getMediaType() {
        switch (this.EkO) {
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
            case 44:
            case 45:
            case 133:
            case 1000000001:
                return 1;
            case PlayerException.EXCEPTION_TYPE_INITLIB /*{ENCODED_INT: 61}*/:
                return 2;
            case 62:
                return 3;
            default:
                return 0;
        }
    }
}
