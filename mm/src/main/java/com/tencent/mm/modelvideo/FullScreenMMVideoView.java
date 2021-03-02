package com.tencent.mm.modelvideo;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public class FullScreenMMVideoView extends MMVideoView {
    private String jpM;

    public FullScreenMMVideoView(Context context) {
        super(context);
    }

    public FullScreenMMVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FullScreenMMVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.modelvideo.MMVideoView
    public final void c(boolean z, String str, int i2) {
        AppMethodBeat.i(240843);
        try {
            super.c(z, str, i2);
            bgR();
            AppMethodBeat.o(240843);
        } catch (Throwable th) {
            Log.e("MicroMsg.FullScreenMMVideoView", th.toString());
            AppMethodBeat.o(240843);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.modelvideo.MMVideoView
    public final void bgR() {
        AppMethodBeat.i(240844);
        try {
            if (!Util.isNullOrNil(this.url)) {
                this.jpT = "MMVideo_FullScreen" + this.url.hashCode();
                this.jpU = getRootPath() + "MMVideo_" + this.url.hashCode() + ".mp4";
                s.boN(s.boZ(this.jpU));
                Log.i("MicroMsg.FullScreenMMVideoView", "%s set video path [%s %s]", bgQ(), this.jpT, this.jpU);
            }
            AppMethodBeat.o(240844);
        } catch (Throwable th) {
            Log.e("MicroMsg.FullScreenMMVideoView", th.toString());
            AppMethodBeat.o(240844);
        }
    }

    private String getRootPath() {
        AppMethodBeat.i(240845);
        if (!Util.isNullOrNil(this.jpM)) {
            String str = this.jpM;
            AppMethodBeat.o(240845);
            return str;
        }
        String str2 = b.aKJ() + "video/";
        AppMethodBeat.o(240845);
        return str2;
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView
    public void setRootPath(String str) {
        this.jpM = str;
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.tools.j.a, com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void onCompletion() {
        AppMethodBeat.i(240846);
        try {
            if (this.jqj) {
                super.fdO();
            } else {
                super.onCompletion();
                if (!(this.jpT == null || this.jpS == null)) {
                    this.jpS.he(this.jpT);
                }
                reset();
                if (this.qbJ != null) {
                    this.qbJ.stop();
                }
            }
            this.jpX.release();
            AppMethodBeat.o(240846);
        } catch (Throwable th) {
            Log.e("MicroMsg.FullScreenMMVideoView", th.toString());
            AppMethodBeat.o(240846);
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final String bgQ() {
        AppMethodBeat.i(240847);
        String str = this.jpT + " ";
        AppMethodBeat.o(240847);
        return str;
    }
}
