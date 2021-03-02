package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.js;
import com.tencent.mm.plugin.sns.ad.e.f;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.io.Serializable;

public final class u extends q implements Serializable {
    protected g Eel;
    protected boolean Eem = false;
    protected AdLandingPagesProxy.e Een = new AdLandingPagesProxy.e() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e
        public final void bn(Object obj) {
        }

        @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e
        public final void h(int i2, int i3, Object obj) {
            AppMethodBeat.i(96573);
            int intValue = ((Integer) obj).intValue();
            Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "onCallback, errType=" + i2 + ", errNo=" + i3 + ", state=" + intValue);
            if (intValue == 0) {
                String str = u.this.Eel.dOD + AdLandingPagesProxy.getInstance().getUin();
                if (!TextUtils.isEmpty(str)) {
                    MMApplicationContext.getContext().getSharedPreferences("adLandingPageSp", 0).edit().putString(str, AppEventsConstants.EVENT_PARAM_VALUE_NO).commit();
                    Log.d("AdLandingPageSp", "saveString, key=" + str + ", value=" + AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                js jsVar = new js();
                jsVar.dOC.dOD = u.this.Eel.dOD;
                jsVar.dOC.state = intValue;
                EventCenter.instance.publish(jsVar);
            }
            AppMethodBeat.o(96573);
        }
    };
    private IListener<js> Eeo = new IListener<js>() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u.AnonymousClass2 */

        {
            AppMethodBeat.i(160684);
            this.__eventId = js.class.getName().hashCode();
            AppMethodBeat.o(160684);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(js jsVar) {
            AppMethodBeat.i(96576);
            boolean a2 = a(jsVar);
            AppMethodBeat.o(96576);
            return a2;
        }

        private boolean a(js jsVar) {
            AppMethodBeat.i(96575);
            try {
                Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "GetHbCoverStateEvent callback, hbCoverId=" + jsVar.dOC.dOD + ", state=" + jsVar.dOC.state);
                if (u.this.Eel.dOD.equals(jsVar.dOC.dOD) && jsVar.dOC.state == 0) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(96574);
                            u.this.Edp.setText(u.this.Eel.DXZ);
                            u.this.fdB();
                            AppMethodBeat.o(96574);
                        }
                    });
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.AdLandingPageGetHBCoverBtnComp", "GetHbCoverStateEvent exp:" + e2.toString());
            }
            AppMethodBeat.o(96575);
            return false;
        }
    };

    public u(Context context, g gVar, ViewGroup viewGroup) {
        super(context, gVar, viewGroup);
        AppMethodBeat.i(96577);
        this.Eel = gVar;
        this.Eeo.alive();
        AppMethodBeat.o(96577);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q
    public final void fde() {
        AppMethodBeat.i(96578);
        super.fde();
        this.Eem = true;
        AppMethodBeat.o(96578);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWZ() {
        AppMethodBeat.i(96579);
        super.eWZ();
        if (this.Eem) {
            Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "viewWillAppear, isClicked=true, doGetHbCoverState");
            this.Eem = false;
            AdLandingPagesProxy.getInstance().doGetHbCoverState(this.Eel.dOD, this.Een);
        }
        AppMethodBeat.o(96579);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
        String string;
        AppMethodBeat.i(96580);
        super.eWT();
        if (!YU(fds().source)) {
            Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "fillItem, from source unSupport");
            fdB();
            AppMethodBeat.o(96580);
            return;
        }
        String str = this.Eel.dOD + AdLandingPagesProxy.getInstance().getUin();
        if (TextUtils.isEmpty(str)) {
            string = "";
        } else {
            string = MMApplicationContext.getContext().getSharedPreferences("adLandingPageSp", 0).getString(str, "");
            Log.d("AdLandingPageSp", "getString, key=" + str + ", value=" + string);
        }
        boolean equals = AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(string);
        Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "fillItem, hasGetHbCober=".concat(String.valueOf(equals)));
        if (equals) {
            this.Edp.setText(this.Eel.DXZ);
            fdB();
            AppMethodBeat.o(96580);
            return;
        }
        if (!this.Eel.isExpired()) {
            Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "fillItem, doGetHbCoverState");
            AdLandingPagesProxy.getInstance().doGetHbCoverState(this.Eel.dOD, this.Een);
        }
        AppMethodBeat.o(96580);
    }

    public static boolean YU(int i2) {
        boolean z = true;
        AppMethodBeat.i(96581);
        if (!(i2 == 1 || i2 == 16 || i2 == 2)) {
            z = false;
        }
        Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "isFromSourcesSupportHbCover, source=" + i2 + ", ret=" + z);
        AppMethodBeat.o(96581);
        return z;
    }

    public final void fdB() {
        AppMethodBeat.i(96582);
        this.Edp.setEnabled(false);
        this.Edp.setTextColor(Color.parseColor("#33000000"));
        this.Edp.setBackgroundColor(Color.parseColor("#0d000000"));
        f.a(this.context, fdx(), this.Edp);
        AppMethodBeat.o(96582);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXd() {
        AppMethodBeat.i(96583);
        super.eXd();
        this.Eeo.dead();
        Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "viewWillDestroy");
        AppMethodBeat.o(96583);
    }
}
