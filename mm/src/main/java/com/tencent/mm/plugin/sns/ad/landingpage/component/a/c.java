package com.tencent.mm.plugin.sns.ad.landingpage.component.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.ad.c.b;
import com.tencent.mm.plugin.sns.ad.i.g;
import com.tencent.mm.plugin.sns.ad.i.i;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class c extends q {
    com.tencent.mm.ui.base.q Dtl;
    private final com.tencent.mm.plugin.sns.ad.landingpage.component.b.c Dts;

    public c(Context context, com.tencent.mm.plugin.sns.ad.landingpage.component.b.c cVar, ViewGroup viewGroup) {
        super(context, cVar, viewGroup);
        AppMethodBeat.i(201979);
        this.Dts = cVar;
        try {
            if (!(this.Edn == null || this.Dts == null)) {
                this.Edn.kv("finderUsername", this.Dts.finderUsername);
                this.Edn.kv("finderLiveNoticeId", this.Dts.finderLiveNoticeId);
            }
            AppMethodBeat.o(201979);
        } catch (Throwable th) {
            AppMethodBeat.o(201979);
        }
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
        int i2 = CdnLogic.kAppTypeFestivalImage;
        AppMethodBeat.i(201980);
        try {
            super.eWT();
            ah fds = fds();
            com.tencent.mm.plugin.sns.ad.landingpage.component.b.c cVar = this.Dts;
            if (fds == null || cVar == null) {
                Log.e("SnsAd.FinderLivingNoticeComp", "the page data or info is null, it can't do anything!!!!!");
            } else {
                String Jb = r.Jb(aNJ(fds.getSnsId()));
                Bundle bundle = new Bundle();
                bundle.putString("sns_id", Jb);
                bundle.putString("finderUsername", Util.nullAsNil(cVar.finderUsername));
                bundle.putString("finderLiveNoticeId", Util.nullAsNil(cVar.finderLiveNoticeId));
                com.tencent.mm.plugin.sns.ad.remote.a aVar = new com.tencent.mm.plugin.sns.ad.remote.a();
                aVar.Dxn = new a();
                aVar.Dxm = new b(this, true);
                com.tencent.mm.plugin.sns.ad.remote.ipc.a eXy = aVar.eXy();
                if (eXy != null) {
                    i2 = g.getInt(eXy.aA(bundle), "status", CdnLogic.kAppTypeFestivalImage);
                }
            }
            XJ(i2);
            Log.d("SnsAd.FinderLivingNoticeComp", "fillItem:: acquireLivingNoticeStatus is ".concat(String.valueOf(i2)));
            AppMethodBeat.o(201980);
        } catch (Throwable th) {
            AppMethodBeat.o(201980);
        }
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q
    public final void hWL() {
        AppMethodBeat.i(259430);
        try {
            Log.d("SnsAd.FinderLivingNoticeComp", "doBtnClick:: is called!");
            ah fds = fds();
            com.tencent.mm.plugin.sns.ad.landingpage.component.b.c cVar = this.Dts;
            if (fds == null || cVar == null) {
                Log.e("SnsAd.FinderLivingNoticeComp", "the page data is null, it can't do anything!!!!!");
                AppMethodBeat.o(259430);
                return;
            }
            com.tencent.mm.plugin.sns.ad.remote.a aVar = new com.tencent.mm.plugin.sns.ad.remote.a();
            aVar.Dxn = new C1705c();
            aVar.Dxm = new b(this);
            com.tencent.mm.plugin.sns.ad.remote.ipc.a eXy = aVar.eXy();
            if (eXy != null) {
                Bundle bundle = new Bundle();
                String Jb = r.Jb(aNJ(fds.getSnsId()));
                String str = fds.DZW;
                if (TextUtils.isEmpty(str)) {
                    str = fds.uxInfo;
                }
                bundle.putString("sns_id", Util.nullAsNil(Jb));
                bundle.putString("uxInfo", Util.nullAsNil(str));
                bundle.putString("adExtInfo", Util.nullAsNil(fds.adExtInfo));
                bundle.putString("finderUsername", Util.nullAsNil(cVar.finderUsername));
                bundle.putString("finderLiveNoticeId", Util.nullAsNil(cVar.finderLiveNoticeId));
                eXy.aA(bundle);
                com.tencent.mm.ui.base.q qVar = this.Dtl;
                if (qVar == null) {
                    qVar = com.tencent.mm.plugin.sns.ad.landingpage.a.a.ap(this.context, R.string.ek_);
                    this.Dtl = qVar;
                }
                if (qVar != null && !qVar.isShowing()) {
                    qVar.show();
                }
            }
            AppMethodBeat.o(259430);
        } catch (Throwable th) {
            AppMethodBeat.o(259430);
        }
    }

    private static long aNJ(String str) {
        AppMethodBeat.i(201983);
        if (str != null) {
            try {
                long parseLong = Long.parseLong(str);
                AppMethodBeat.o(201983);
                return parseLong;
            } catch (Throwable th) {
                Log.d("SnsAd.FinderLivingNoticeComp", "string to long has something wrong!!");
            }
        }
        AppMethodBeat.o(201983);
        return 0;
    }

    public static class a implements com.tencent.mm.plugin.sns.ad.remote.a.b {
        @Override // com.tencent.mm.plugin.sns.ad.remote.a.b
        public final Bundle a(final com.tencent.mm.plugin.sns.ad.remote.ipc.b bVar, Bundle bundle) {
            AppMethodBeat.i(201974);
            Bundle bundle2 = new Bundle();
            final String string = g.getString(bundle, "sns_id");
            String string2 = g.getString(bundle, "finderUsername");
            String string3 = g.getString(bundle, "finderLiveNoticeId");
            if (!TextUtils.isEmpty(string)) {
                bundle2.putInt("status", com.tencent.mm.plugin.sns.ad.widget.living.b.fu(string, 1));
                com.tencent.mm.plugin.sns.ad.c.b.a(string, string2, string3, new b.a() {
                    /* class com.tencent.mm.plugin.sns.ad.landingpage.component.a.c.a.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.sns.ad.c.b.a
                    public final void b(String str, int i2, Object obj) {
                        AppMethodBeat.i(201973);
                        try {
                            Log.i("SnsAd.FinderLivingNoticeComp", "Subscription out sns id is " + string + ", inner snsId is " + str + "errorCode = " + i2);
                            if (i2 != 0 || !(obj instanceof Integer)) {
                                AppMethodBeat.o(201973);
                                return;
                            }
                            com.tencent.mm.plugin.sns.ad.widget.living.b.fv(str, ((Integer) obj).intValue());
                            if (bVar == null) {
                                AppMethodBeat.o(201973);
                                return;
                            }
                            Bundle bundle = new Bundle();
                            bundle.putInt("status", ((Integer) obj).intValue());
                            bundle.putInt(OpenSDKTool4Assistant.EXTRA_ERROR_CODE, i2);
                            bVar.aB(bundle);
                            AppMethodBeat.o(201973);
                        } catch (Throwable th) {
                            AppMethodBeat.o(201973);
                        }
                    }
                });
            }
            AppMethodBeat.o(201974);
            return bundle2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ad.landingpage.component.a.c$c  reason: collision with other inner class name */
    public static class C1705c implements com.tencent.mm.plugin.sns.ad.remote.a.b {
        @Override // com.tencent.mm.plugin.sns.ad.remote.a.b
        public final Bundle a(final com.tencent.mm.plugin.sns.ad.remote.ipc.b bVar, Bundle bundle) {
            AppMethodBeat.i(201978);
            final String string = g.getString(bundle, "sns_id");
            final String string2 = g.getString(bundle, "uxInfo");
            final String string3 = g.getString(bundle, "adExtInfo");
            final String string4 = g.getString(bundle, "finderUsername");
            final String string5 = g.getString(bundle, "finderLiveNoticeId");
            com.tencent.mm.plugin.sns.ad.c.b.b(string, string4, string5, new b.a() {
                /* class com.tencent.mm.plugin.sns.ad.landingpage.component.a.c.C1705c.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.sns.ad.c.b.a
                public final void b(String str, int i2, Object obj) {
                    int i3;
                    AppMethodBeat.i(201977);
                    Log.i("SnsAd.FinderLivingNoticeComp", "Subscription out sns id is " + string + ", inner snsId is " + str);
                    if (i2 == 0) {
                        com.tencent.mm.plugin.sns.ad.widget.living.b.fv(str, 513);
                        i3 = 513;
                    } else {
                        i3 = 257;
                    }
                    String str2 = string2;
                    String str3 = string3;
                    String str4 = string4;
                    String str5 = string5;
                    com.tencent.mm.plugin.sns.ad.c.a aVar = new com.tencent.mm.plugin.sns.ad.c.a();
                    aVar.c(str, str2, str3, str4, str5, i2, 0);
                    i.a(aVar);
                    if (bVar != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt(OpenSDKTool4Assistant.EXTRA_ERROR_CODE, i2);
                        bundle.putInt("status", i3);
                        bVar.aB(bundle);
                    }
                    AppMethodBeat.o(201977);
                }
            });
            AppMethodBeat.o(201978);
            return null;
        }
    }

    static class b implements com.tencent.mm.plugin.sns.ad.remote.a.a {
        final Reference<c> Dtw;
        final boolean Dtx;

        b(c cVar) {
            this(cVar, false);
        }

        b(c cVar, boolean z) {
            AppMethodBeat.i(201975);
            this.Dtw = new WeakReference(cVar);
            this.Dtx = z;
            AppMethodBeat.o(201975);
        }

        @Override // com.tencent.mm.plugin.sns.ad.remote.a.a
        @com.tencent.mm.plugin.sns.ad.remote.b
        public final void az(Bundle bundle) {
            AppMethodBeat.i(201976);
            try {
                Log.d("SnsAd.FinderLivingNoticeComp", "OnSubscriptionOfFinderLivingOnClient is called");
                int i2 = g.getInt(bundle, "status", CdnLogic.kAppTypeFestivalImage);
                int i3 = g.getInt(bundle, OpenSDKTool4Assistant.EXTRA_ERROR_CODE, 0);
                c cVar = this.Dtw.get();
                if (cVar != null) {
                    com.tencent.mm.ui.base.q qVar = cVar.Dtl;
                    if (qVar != null && qVar.isShowing()) {
                        qVar.dismiss();
                    }
                    if (!this.Dtx) {
                        com.tencent.mm.plugin.sns.ad.c.b.ao(cVar.context, i3);
                    }
                    cVar.XJ(i2);
                }
                AppMethodBeat.o(201976);
            } catch (Throwable th) {
                AppMethodBeat.o(201976);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void XJ(int i2) {
        AppMethodBeat.i(201982);
        Button button = this.Edp;
        RoundedCornerFrameLayout roundedCornerFrameLayout = this.Edo;
        if (button == null || roundedCornerFrameLayout == null) {
            AppMethodBeat.o(201982);
        } else if (i2 == 513) {
            button.setText(this.context.getText(R.string.h3v));
            button.setEnabled(false);
            button.setAlpha(0.6f);
            roundedCornerFrameLayout.setAlpha(0.6f);
            AppMethodBeat.o(201982);
        } else {
            if (this.Dts != null) {
                button.setText(this.Dts.title);
            }
            button.setEnabled(true);
            button.setAlpha(1.0f);
            roundedCornerFrameLayout.setAlpha(1.0f);
            AppMethodBeat.o(201982);
        }
    }
}
