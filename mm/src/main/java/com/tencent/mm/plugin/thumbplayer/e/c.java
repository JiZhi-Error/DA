package com.tencent.mm.plugin.thumbplayer.e;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.api.ITPPlayerListener;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.g.b;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\b\u0010'\u001a\u00020(H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010)\u001a\u00020(H\u0016J\b\u0010*\u001a\u00020(H\u0002J\u0012\u0010+\u001a\u00020(2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0012\u0010+\u001a\u00020(2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0012\u0010+\u001a\u00020(2\b\u00100\u001a\u0004\u0018\u00010\fH\u0016J(\u0010+\u001a\u00020(2\b\u00100\u001a\u0004\u0018\u00010\f2\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u000102H\u0016J\u0010\u00103\u001a\u00020(2\u0006\u00104\u001a\u00020\fH\u0016J\u0012\u00105\u001a\u00020(2\b\u00106\u001a\u0004\u0018\u00010%H\u0016J\b\u00107\u001a\u00020(H\u0016R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000¨\u00068"}, hxF = {"Lcom/tencent/mm/plugin/thumbplayer/player/MMTPPlayer;", "Lcom/tencent/thumbplayer/tplayer/TPPlayer;", "Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "threadLooper", "Landroid/os/Looper;", "(Landroid/content/Context;Landroid/os/Looper;)V", "callbackLoop", "(Landroid/content/Context;Landroid/os/Looper;Landroid/os/Looper;)V", "TAG", "", "id", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "inInitializing", "", "getInInitializing", "()Z", "setInInitializing", "(Z)V", "inPrepareAsync", "getInPrepareAsync", "setInPrepareAsync", "prepareCostTime", "", "getPrepareCostTime", "()J", "setPrepareCostTime", "(J)V", "startInitializedTimestamp", "getStartInitializedTimestamp", "setStartInitializedTimestamp", "stateChangeListenerProxy", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnStateChangeListener;", "stateListener", "prepareAsync", "", "reset", "resetData", "setDataSource", "pfd", "Landroid/os/ParcelFileDescriptor;", "mediaAsset", "Lcom/tencent/thumbplayer/api/composition/ITPMediaAsset;", "url", "httpHeader", "", "setMediaId", "mediaId", "setOnPlayerStateChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "stop", "plugin-thumbplayer_release"})
public final class c extends b implements a {
    boolean GhT;
    long GhU;
    boolean GhV;
    private ITPPlayerListener.IOnStateChangeListener GhW = new a(this);
    private ITPPlayerListener.IOnStateChangeListener GhX;
    private final String TAG = "MicroMsg.TP.MMTPPlayer";
    String id = "";
    long tHR;

    public c(Context context) {
        super(context);
        AppMethodBeat.i(238746);
        super.setOnPlayerStateChangeListener(this.GhW);
        AppMethodBeat.o(238746);
    }

    @Override // com.tencent.mm.plugin.thumbplayer.e.a
    public final void setMediaId(String str) {
        AppMethodBeat.i(238738);
        p.h(str, "mediaId");
        this.id = str;
        Log.d(this.TAG, "setMediaId");
        AppMethodBeat.o(238738);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer, com.tencent.thumbplayer.g.b
    public final void setDataSource(String str) {
        AppMethodBeat.i(238739);
        if (!this.GhT) {
            this.GhT = true;
            this.GhU = cl.aWA();
            super.setDataSource(str);
            Log.d(this.TAG, "setDataSource");
            AppMethodBeat.o(238739);
            return;
        }
        Log.i(this.TAG, "already setDataSource ".concat(String.valueOf(str)));
        AppMethodBeat.o(238739);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer, com.tencent.thumbplayer.g.b
    public final void setDataSource(String str, Map<String, String> map) {
        AppMethodBeat.i(238740);
        if (!this.GhT) {
            this.GhT = true;
            this.GhU = cl.aWA();
            super.setDataSource(str, map);
            Log.d(this.TAG, "setDataSource");
            AppMethodBeat.o(238740);
            return;
        }
        Log.i(this.TAG, "already setDataSource ".concat(String.valueOf(str)));
        AppMethodBeat.o(238740);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer, com.tencent.thumbplayer.g.b
    public final void setDataSource(ParcelFileDescriptor parcelFileDescriptor) {
        AppMethodBeat.i(238741);
        if (!this.GhT) {
            this.GhT = true;
            this.GhU = cl.aWA();
            super.setDataSource(parcelFileDescriptor);
            Log.d(this.TAG, "setDataSource");
            AppMethodBeat.o(238741);
            return;
        }
        Log.i(this.TAG, "already setDataSource ".concat(String.valueOf(parcelFileDescriptor)));
        AppMethodBeat.o(238741);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer, com.tencent.thumbplayer.g.b
    public final void setDataSource(ITPMediaAsset iTPMediaAsset) {
        AppMethodBeat.i(238742);
        if (!this.GhT) {
            this.GhT = true;
            this.GhU = cl.aWA();
            super.setDataSource(iTPMediaAsset);
            Log.d(this.TAG, "setDataSource");
            AppMethodBeat.o(238742);
            return;
        }
        Log.i(this.TAG, "already setDataSource ".concat(String.valueOf(iTPMediaAsset)));
        AppMethodBeat.o(238742);
    }

    @Override // com.tencent.mm.plugin.thumbplayer.e.a
    public final long fwS() {
        return this.tHR;
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer, com.tencent.thumbplayer.g.b
    public final void prepareAsync() {
        AppMethodBeat.i(238743);
        if (!this.GhV) {
            this.GhV = true;
            super.prepareAsync();
            AppMethodBeat.o(238743);
            return;
        }
        Log.i(this.TAG, "already prepareAsync");
        AppMethodBeat.o(238743);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer, com.tencent.thumbplayer.g.b
    public final void stop() {
        AppMethodBeat.i(238744);
        super.stop();
        and();
        AppMethodBeat.o(238744);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer, com.tencent.thumbplayer.g.b
    public final void reset() {
        AppMethodBeat.i(238745);
        super.reset();
        and();
        AppMethodBeat.o(238745);
    }

    private final void and() {
        this.id = "";
        this.GhT = false;
        this.GhV = false;
        this.GhU = 0;
        this.tHR = 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "preState", "", "curState", "onStateChange"})
    static final class a implements ITPPlayerListener.IOnStateChangeListener {
        final /* synthetic */ c GhY;

        a(c cVar) {
            this.GhY = cVar;
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener
        public final void onStateChange(int i2, int i3) {
            AppMethodBeat.i(238737);
            if (this.GhY.GhU > 0) {
                Log.i(this.GhY.TAG, "state from:" + i2 + " to:" + i3 + " cost:" + (cl.aWA() - this.GhY.GhU) + " id:" + this.GhY.id);
            }
            switch (i3) {
                case 2:
                    this.GhY.GhT = false;
                    break;
                case 3:
                    this.GhY.GhV = false;
                    break;
                case 4:
                    this.GhY.tHR = cl.aWA() - this.GhY.GhU;
                    break;
            }
            ITPPlayerListener.IOnStateChangeListener iOnStateChangeListener = this.GhY.GhX;
            if (iOnStateChangeListener != null) {
                iOnStateChangeListener.onStateChange(i2, i3);
                AppMethodBeat.o(238737);
                return;
            }
            AppMethodBeat.o(238737);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer, com.tencent.thumbplayer.g.b
    public final void setOnPlayerStateChangeListener(ITPPlayerListener.IOnStateChangeListener iOnStateChangeListener) {
        this.GhX = iOnStateChangeListener;
    }
}
