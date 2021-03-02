package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.ui.SnsAdProxyUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import java.io.Serializable;
import org.json.JSONObject;

public final class ac extends q implements Serializable {
    protected AdLandingPagesProxy.e Een = new AdLandingPagesProxy.e() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e
        public final void h(int i2, int i3, Object obj) {
            AppMethodBeat.i(202989);
            Log.i("MicroMsg.AdLandingPagePersonalProfileBtnComp", "onCallback, errType=" + i2 + ", errNo=" + i3);
            if (!(ac.this.context instanceof Activity) || !((Activity) ac.this.context).isFinishing()) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(202991);
                        try {
                            if (ac.this.gxX.isShowing()) {
                                ac.this.gxX.dismiss();
                            }
                            AppMethodBeat.o(202991);
                        } catch (Throwable th) {
                            Log.e("MicroMsg.AdLandingPagePersonalProfileBtnComp", "showLoading exp=" + th.toString());
                            AppMethodBeat.o(202991);
                        }
                    }
                });
                if (i2 == 0 && i3 == 0 && (obj instanceof byte[])) {
                    Intent intent = new Intent(ac.this.context, SnsAdProxyUI.class);
                    intent.putExtra(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, 3);
                    intent.putExtra("searchContactResponseByte", (byte[]) obj);
                    intent.putExtra("searchWord", Util.nullAsNil(ac.this.EfC));
                    Context context = ac.this.context;
                    a bl = new a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPagePersonalProfileBtnComp$1", "onCallback", "(IILjava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPagePersonalProfileBtnComp$1", "onCallback", "(IILjava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(202989);
                    return;
                }
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(202988);
                        u.makeText(ac.this.context, (int) R.string.h4g, 0).show();
                        AppMethodBeat.o(202988);
                    }
                });
                AppMethodBeat.o(202989);
                return;
            }
            Log.i("MicroMsg.AdLandingPagePersonalProfileBtnComp", "onCallback, isFinishing return");
            AppMethodBeat.o(202989);
        }

        @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e
        public final void bn(Object obj) {
            AppMethodBeat.i(202990);
            if (obj instanceof String) {
                try {
                    JSONObject jSONObject = new JSONObject((String) obj);
                    ac.this.goe = jSONObject.optString(ch.COL_USERNAME);
                    ac.this.EfC = jSONObject.optString("aliasname");
                    AppMethodBeat.o(202990);
                    return;
                } catch (Exception e2) {
                    Log.e("MicroMsg.AdLandingPagePersonalProfileBtnComp", "parse username exp=" + e2.toString());
                }
            }
            AppMethodBeat.o(202990);
        }
    };
    protected m EfB;
    protected String EfC;
    protected String goe;
    protected q gxX;

    public ac(Context context, m mVar, ViewGroup viewGroup) {
        super(context, mVar, viewGroup);
        AppMethodBeat.i(202992);
        this.EfB = mVar;
        this.Edn.kv("wxGroupInfo", mVar.DYi);
        AppMethodBeat.o(202992);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q
    public final void fde() {
        AppMethodBeat.i(202993);
        String nullAsNil = Util.nullAsNil(fds().uxInfo);
        if (!TextUtils.isEmpty(this.EfB.DYi)) {
            Log.i("MicroMsg.AdLandingPagePersonalProfileBtnComp", "onBtnClick, btnInfo=" + this.EfB + ", uxinfo=" + nullAsNil);
            try {
                if (this.gxX == null) {
                    this.gxX = h.a(this.context, this.context.getString(R.string.ekc), true, (DialogInterface.OnCancelListener) null);
                }
                if (!this.gxX.isShowing()) {
                    this.gxX.show();
                }
            } catch (Throwable th) {
                Log.e("MicroMsg.AdLandingPagePersonalProfileBtnComp", "showLoading exp=" + th.toString());
            }
            AdLandingPagesProxy.getInstance().getBtnPersonalWxUserName(nullAsNil, this.EfB.DYi, this.Een);
        } else {
            Log.e("MicroMsg.AdLandingPagePersonalProfileBtnComp", "onBtnClick, wxGroupInfo==null");
        }
        fdf();
        AppMethodBeat.o(202993);
    }
}
