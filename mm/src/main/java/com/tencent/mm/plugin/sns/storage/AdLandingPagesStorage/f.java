package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qqmusic.mediaplayer.PlayerException;

public final class f extends b {
    private a Elf;

    public interface a {
        void aNH(String str);

        void eWN();

        void eWO();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ String doInBackground(Void[] voidArr) {
        AppMethodBeat.i(97316);
        String fev = fev();
        AppMethodBeat.o(97316);
        return fev;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(String str) {
        AppMethodBeat.i(97315);
        String str2 = str;
        if (str2 == null) {
            this.Elf.aNH(this.filePath);
            AppMethodBeat.o(97315);
            return;
        }
        Log.e("MicroMsg.AdLandingPageDownloadSmallFileTask", "onPostExecute, errMsg=" + str2 + ", url=" + this.url);
        this.Elf.eWO();
        AppMethodBeat.o(97315);
    }

    public f(String str, String str2, boolean z, int i2, int i3, a aVar) {
        this.url = str;
        this.filePath = str2;
        this.EkN = z;
        this.EkO = i2;
        this.scene = i3;
        this.Elf = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x04b8 A[SYNTHETIC, Splitter:B:66:0x04b8] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x04bd A[Catch:{ IOException -> 0x0736 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x04c9  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0520  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x05e7  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x05ee A[SYNTHETIC, Splitter:B:84:0x05ee] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x05f3 A[Catch:{ IOException -> 0x072f }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x05ff  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0656  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x072c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String fev() {
        /*
        // Method dump skipped, instructions count: 1859
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.fev():java.lang.String");
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
