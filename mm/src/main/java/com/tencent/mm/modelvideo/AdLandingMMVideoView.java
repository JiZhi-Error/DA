package com.tencent.mm.modelvideo;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class AdLandingMMVideoView extends MMVideoView {
    protected boolean gRx;
    private i.a jpL;

    public AdLandingMMVideoView(Context context) {
        super(context);
    }

    public AdLandingMMVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdLandingMMVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setNeedPause(boolean z) {
        this.gRx = z;
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView
    public void setIMMDownloadFinish(i.a aVar) {
        this.jpL = aVar;
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.modelvideo.b.a
    public final void onDataAvailable(String str, long j2, long j3) {
        AppMethodBeat.i(240839);
        try {
            this.jqf = false;
            if (j2 <= -1 || j3 <= -1) {
                Log.w(this.TAG, "%s deal data available error offset[%d], length[%d]", bgQ(), Long.valueOf(j2), Long.valueOf(j3));
                AppMethodBeat.o(240839);
            } else if (!Util.isEqual(this.jpT, str)) {
                AppMethodBeat.o(240839);
            } else {
                try {
                    this.jqc = this.jpX.dG((int) j2, (int) j3);
                } catch (Exception e2) {
                    Log.e(this.TAG, "%s deal data available file pos to video time error[%s] ", bgQ(), e2.toString());
                }
                Log.i(this.TAG, "%s deal data available. offset[%d] length[%d] cachePlayTime[%d] needPause[%b]", bgQ(), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(this.jqc), Boolean.valueOf(this.gRx));
                if (!this.gRx) {
                    fO(true);
                }
                AppMethodBeat.o(240839);
            }
        } catch (Throwable th) {
            Log.e(this.TAG, th.toString());
            AppMethodBeat.o(240839);
        }
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.modelvideo.b.a
    public final void ax(String str, int i2) {
        boolean z = true;
        AppMethodBeat.i(240840);
        try {
            if (!Util.isEqual(this.jpT, str) || this.jpV == 3) {
                AppMethodBeat.o(240840);
                return;
            }
            Log.i(this.TAG, "%s download finish [%d] needPause[%b]", bgQ(), Integer.valueOf(i2), Boolean.valueOf(this.gRx));
            if (i2 == 0) {
                this.jpV = 3;
            }
            if (this.jpL != null) {
                i.a aVar = this.jpL;
                String str2 = this.jpU;
                if (this.jpW <= 0) {
                    z = false;
                }
                aVar.aO(str2, z);
            }
            if (!this.gRx) {
                fO(true);
            }
            this.jqf = false;
            AppMethodBeat.o(240840);
        } catch (Throwable th) {
            Log.e(this.TAG, th.toString());
            AppMethodBeat.o(240840);
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final boolean c(double d2, boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(240841);
        try {
            if (this.gRx) {
                Log.i(this.TAG, "seekTo adjust needPause[%b]", Boolean.valueOf(this.gRx));
                z = false;
            }
            z2 = super.c(d2, z);
            AppMethodBeat.o(240841);
        } catch (Throwable th) {
            Log.e(this.TAG, th.toString());
            AppMethodBeat.o(240841);
        }
        return z2;
    }

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final String bgQ() {
        AppMethodBeat.i(240842);
        String str = this.jpT + " ";
        AppMethodBeat.o(240842);
        return str;
    }
}
