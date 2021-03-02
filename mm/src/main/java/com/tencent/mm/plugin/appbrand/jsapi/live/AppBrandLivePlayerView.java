package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import org.json.JSONObject;

public class AppBrandLivePlayerView extends TXCloudVideoView {
    boolean cFE;
    l lXC;
    a lXD;
    private c lXE;
    int lXF;
    private b lXG;

    public interface a {
        void bGL();

        boolean isFullScreen();

        void xd(int i2);
    }

    public interface b {
        void bGM();
    }

    public interface c {
        void n(boolean z, int i2);
    }

    public AppBrandLivePlayerView(Context context) {
        super(context);
        AppMethodBeat.i(145822);
        init(context);
        AppMethodBeat.o(145822);
    }

    public AppBrandLivePlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(145823);
        init(context);
        AppMethodBeat.o(145823);
    }

    public final boolean j(String str, JSONObject jSONObject) {
        AppMethodBeat.i(145824);
        i k = this.lXC.k(str, jSONObject);
        Log.i("MicroMsg.AppBrandLivePlayerView", "onOperate code:%d info:%s", Integer.valueOf(k.errorCode), k.errorInfo);
        if (k.errorCode == 0) {
            AppMethodBeat.o(145824);
            return true;
        }
        AppMethodBeat.o(145824);
        return false;
    }

    public final void onExit() {
        i iVar;
        AppMethodBeat.i(145825);
        l lVar = this.lXC;
        if (!lVar.mInited) {
            iVar = new i(-3, "uninited livePlayer");
        } else {
            lVar.cFu.stopPlay(true);
            lVar.cFu.setPlayListener(null);
            lVar.mInited = false;
            iVar = new i();
        }
        Log.i("MicroMsg.AppBrandLivePlayerView", "onDestroy code:%d info:%s", Integer.valueOf(iVar.errorCode), iVar.errorInfo);
        if (this.lXG != null) {
            this.lXG.bGM();
        }
        AppMethodBeat.o(145825);
    }

    public final void hU(int i2) {
        i iVar;
        AppMethodBeat.i(145826);
        l lVar = this.lXC;
        Log.i("TXLivePlayerJSAdapter", "enterBackground");
        if ((i2 != 2 || lVar.cEL) && (i2 != 1 || lVar.cEK)) {
            lVar.lYb = lVar.cFu.isPlaying();
            if (lVar.lYb) {
                if (lVar.cFE && lVar.cFv != null) {
                    lVar.cFv.onPlayEvent(6000, new Bundle());
                }
                iVar = lVar.k("pause", null);
            } else {
                iVar = new i();
            }
        } else {
            lVar.lYb = false;
            iVar = new i();
        }
        Log.i("MicroMsg.AppBrandLivePlayerView", "onBackground code:%d info:%s", Integer.valueOf(iVar.errorCode), iVar.errorInfo);
        AppMethodBeat.o(145826);
    }

    public void setNeedEvent(boolean z) {
        this.cFE = z;
    }

    public void setPlayEventListener(ITXLivePlayListener iTXLivePlayListener) {
        this.lXC.cFv = iTXLivePlayListener;
    }

    public void setAudioVolumeEventListener(TXLivePlayer.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        this.lXC.mAudioVolumeListener = iTXAudioVolumeEvaluationListener;
    }

    public void setFullScreenDelegate(a aVar) {
        this.lXD = aVar;
    }

    public void setOnFullScreenChangeListener(c cVar) {
        this.lXE = cVar;
    }

    /* access modifiers changed from: package-private */
    public final void ht(boolean z) {
        AppMethodBeat.i(145827);
        if (this.cFE && this.lXE != null) {
            this.lXE.n(z, this.lXF);
        }
        AppMethodBeat.o(145827);
    }

    private void init(Context context) {
        AppMethodBeat.i(145828);
        this.lXC = new l(context);
        AppMethodBeat.o(145828);
    }

    public void setExitListener(b bVar) {
        this.lXG = bVar;
    }

    public void setSnapshotListener(TXLivePlayer.ITXSnapshotListener iTXSnapshotListener) {
        this.lXC.cFw = iTXSnapshotListener;
    }
}
