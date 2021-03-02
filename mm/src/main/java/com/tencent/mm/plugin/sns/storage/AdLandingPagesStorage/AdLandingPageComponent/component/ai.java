package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.protocal.protobuf.box;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import java.io.Serializable;

public final class ai extends q implements Serializable {
    AdLandingPagesProxy.e EdJ = new AdLandingPagesProxy.e() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ai.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e
        public final void bn(Object obj) {
        }

        @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e
        public final void h(int i2, int i3, Object obj) {
            AppMethodBeat.i(96735);
            Log.i("MicroMsg.AdLandingPageSmartPhoneBtnComp", "onCallback, errType=" + i2 + ", errNo=" + i3);
            if (i2 == 0 && i3 == 0) {
                box box = new box();
                try {
                    box.parseFrom((byte[]) obj);
                    String str = box.LWX;
                    Log.i("MicroMsg.AdLandingPageSmartPhoneBtnComp", "full_number=" + str + ", dial_id=" + box.LWY);
                    AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity) ai.this.context, str);
                    AppMethodBeat.o(96735);
                } catch (Exception e2) {
                    Log.e("MicroMsg.AdLandingPageSmartPhoneBtnComp", Util.stackTraceToString(e2));
                    AppMethodBeat.o(96735);
                }
            } else {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ai.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(96734);
                        u.makeText(ai.this.context, (int) R.string.h4g, 0).show();
                        AppMethodBeat.o(96734);
                    }
                });
                AppMethodBeat.o(96735);
            }
        }
    };
    protected o EgA;

    public ai(Context context, o oVar, ViewGroup viewGroup) {
        super(context, oVar, viewGroup);
        AppMethodBeat.i(96736);
        this.EgA = oVar;
        ah fds = fds();
        this.EgA.DYn = Util.safeParseLong(fds.aid);
        this.EgA.gTk = fds.uxInfo;
        this.EgA.kZe = fds.kZe;
        Log.i("MicroMsg.AdLandingPageSmartPhoneBtnComp", "btnInfo=" + this.EgA);
        this.Edn.bo("smartphoneID", (long) oVar.DYl);
        AppMethodBeat.o(96736);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q
    public final void fde() {
        AppMethodBeat.i(96737);
        AdLandingPagesProxy.getInstance().doGetSmartPhoneScene(this.EgA.DYn, this.EgA.DYm, this.EgA.kZe, this.EgA.gTk, this.EgA.DYl, this.EdJ);
        fdf();
        AppMethodBeat.o(96737);
    }
}
