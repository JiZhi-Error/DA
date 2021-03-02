package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.d;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a extends m {
    public boolean DXr;
    private boolean DXs = true;
    private boolean DXt = false;
    public com.tencent.mm.plugin.sns.ad.landingpage.helper.b.a DXu;
    private volatile boolean DXv = false;
    public boolean DXw;
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(96313);
            if (intent == null) {
                AppMethodBeat.o(96313);
                return;
            }
            try {
                if ("com.tencent.mm.adlanding.close_exposure_voice".equals(intent.getAction())) {
                    if (!a.this.fdk().DZi.equals(intent.getStringExtra("para_id"))) {
                        a aVar = a.this;
                        if (aVar.DXw) {
                            aVar.fcJ();
                        }
                        AppMethodBeat.o(96313);
                        return;
                    }
                } else if ("com.tencent.mm.adlanding.video.action.PAUSE_OR_RESUME".equals(intent.getAction())) {
                    a.this.aX(intent);
                }
                AppMethodBeat.o(96313);
            } catch (Throwable th) {
                AppMethodBeat.o(96313);
            }
        }
    };

    public abstract boolean isPlaying();

    public a(Context context, z zVar, ViewGroup viewGroup) {
        super(context, zVar, viewGroup);
        try {
            this.DXu = com.tencent.mm.plugin.sns.ad.landingpage.helper.b.a.eXm();
            d W = d.W(this.context);
            IntentFilter intentFilter = new IntentFilter("com.tencent.mm.adlanding.close_exposure_voice");
            intentFilter.addAction("com.tencent.mm.adlanding.video.action.PAUSE_OR_RESUME");
            W.a(this.receiver, intentFilter);
            Log.v("AbsVideoPlayComp", "register receiver " + this.receiver);
        } catch (Throwable th) {
        }
    }

    public void fcJ() {
        this.DXr = false;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public void eXe() {
        super.eXe();
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public void eXd() {
        super.eXd();
        d.W(this.context).unregisterReceiver(this.receiver);
        this.DXw = true;
        Log.v("AbsVideoPlayComp", "unregister receiver " + this.receiver);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public void eWZ() {
        super.eWZ();
        this.DXw = true;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public void eXa() {
        super.eXa();
        this.DXw = false;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public void eXb() {
        super.eXb();
        if (this.DXs) {
            this.DXs = false;
            if (!fds().DZV) {
                fcJ();
            } else {
                fcK();
            }
        }
    }

    public void fcK() {
        this.DXr = true;
    }

    public final void fcL() {
        Intent intent = new Intent("com.tencent.mm.adlanding.close_exposure_voice");
        intent.putExtra("para_id", fdk().DZi);
        d.W(this.context).b(intent);
    }

    /* access modifiers changed from: protected */
    public final void aX(Intent intent) {
        if (intent != null) {
            int intExtra = IntentUtil.getIntExtra(intent, "TRY_PAUSE_OR_RESUME", 0);
            if (intExtra == 1) {
                this.DXt = true;
                if (isPlaying()) {
                    cWX();
                }
            } else if (intExtra == 2) {
                this.DXt = false;
                if (!isPlaying()) {
                    cWY();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void cWX() {
    }

    /* access modifiers changed from: protected */
    public void cWY() {
    }

    public final int fcM() {
        if (this.context != null) {
            return this.context.hashCode();
        }
        return 0;
    }
}
