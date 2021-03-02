package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.q;
import java.lang.ref.WeakReference;

public final class af extends q {
    private h EcI;
    ab EfL;
    String EfM = "";
    String EfN = "";
    String EfO = "";
    volatile int EfP = -10;
    IListener<vd> EfQ;
    q nUi = null;

    public af(Context context, ab abVar, ViewGroup viewGroup) {
        super(context, abVar, viewGroup);
        this.EfL = abVar;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXe() {
        AppMethodBeat.i(203012);
        super.eXe();
        fdE();
        if (this.EfQ == null) {
            this.EfQ = new IListener<vd>() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.af.AnonymousClass1 */

                {
                    AppMethodBeat.i(203001);
                    this.__eventId = vd.class.getName().hashCode();
                    AppMethodBeat.o(203001);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                @Override // com.tencent.mm.sdk.event.IListener
                public final /* synthetic */ boolean callback(vd vdVar) {
                    AppMethodBeat.i(203003);
                    boolean a2 = a(vdVar);
                    AppMethodBeat.o(203003);
                    return a2;
                }

                private boolean a(vd vdVar) {
                    AppMethodBeat.i(203002);
                    try {
                        af afVar = af.this;
                        if (!(vdVar == null || vdVar.ebw == null || afVar.EfL == null)) {
                            String str = vdVar.ebw.ebx;
                            String str2 = vdVar.ebw.eby;
                            int i2 = vdVar.ebw.ebA;
                            String fdn = afVar.fdn();
                            Log.d("SnsAd.AdLandingPageQRCodeBtnComp", "onDownloadEventFromOthers is called, from " + str + "; self is " + fdn + "; type is " + i2);
                            if (!Util.isEqual(str, fdn) && !TextUtils.isEmpty(vdVar.ebw.ebz)) {
                                String str3 = vdVar.ebw.ebz;
                                Log.d("SnsAd.AdLandingPageQRCodeBtnComp", "onDownloadEventFromOthers is called, the path is ".concat(String.valueOf(str3)));
                                if (i2 == 0) {
                                    if (Util.isEqual(str2, afVar.EfL.DZy) && TextUtils.isEmpty(afVar.EfM)) {
                                        afVar.EfM = str3;
                                    }
                                } else if (i2 == 1 && Util.isEqual(str2, afVar.EfN) && TextUtils.isEmpty(afVar.EfO)) {
                                    afVar.EfO = str3;
                                }
                            }
                        }
                    } catch (Throwable th) {
                    }
                    AppMethodBeat.o(203002);
                    return false;
                }
            };
            this.EfQ.alive();
        }
        AppMethodBeat.o(203012);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
        AppMethodBeat.i(203013);
        super.eWT();
        if (this.EfL != null) {
            String str = this.EfL.DZy;
            Log.d("SnsAd.AdLandingPageQRCodeBtnComp", "the qr code img url: ".concat(String.valueOf(str)));
            if (this.EfL.DZz == 1) {
                try {
                    AdLandingPagesProxy.getInstance().doAdUpdateQrUrlScene("", this.EfL.DYM, "", fds().uxInfo, fdn(), fds().getSnsId(), new b(this));
                    this.EfP = 0;
                    Log.i("SnsAd.AdLandingPageQRCodeBtnComp", "mNewQRStatus = " + this.EfP);
                } catch (Throwable th) {
                    Log.e("SnsAd.AdLandingPageQRCodeBtnComp", th.toString());
                }
            }
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(str, fdx().DZj, new a(this, false));
        }
        AppMethodBeat.o(203013);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q
    public final void hWL() {
        AppMethodBeat.i(259445);
        fdE();
        try {
            if (this.EfL.DZz == 1) {
                if (this.nUi == null && (this.context instanceof Activity) && !((Activity) this.context).isFinishing()) {
                    this.nUi = com.tencent.mm.ui.base.h.a(this.context, "加载中", true, (DialogInterface.OnCancelListener) null);
                }
                if (this.EfP == 3 && !TextUtils.isEmpty(this.EfO)) {
                    if (this.nUi != null) {
                        this.nUi.dismiss();
                        this.nUi = null;
                    }
                    this.Edn.kv("qrUrl", this.EfN);
                    this.EcI.jX(this.EfO, this.EfN);
                    AppMethodBeat.o(259445);
                    return;
                } else if (this.EfP == 0 || this.EfP == 1 || this.EfP == 2) {
                    if (this.nUi != null) {
                        this.nUi.show();
                    }
                    AppMethodBeat.o(259445);
                    return;
                }
            }
            if (this.nUi != null) {
                this.nUi.dismiss();
                this.nUi = null;
            }
        } catch (Throwable th) {
            Log.e("SnsAd.AdLandingPageQRCodeBtnComp", th.toString());
        }
        if (!TextUtils.isEmpty(this.EfM)) {
            try {
                this.Edn.kv("qrUrl", this.EfL.DZy);
                this.EcI.jX(this.EfM, this.EfL.DZy);
                AppMethodBeat.o(259445);
                return;
            } catch (Throwable th2) {
                Log.e("SnsAd.AdLandingPageQRCodeBtnComp", "the ad qr helper has something wrong. exception: ".concat(String.valueOf(th2)));
            }
        }
        AppMethodBeat.o(259445);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXd() {
        AppMethodBeat.i(203015);
        super.eXd();
        if (this.EfQ != null) {
            this.EfQ.dead();
            this.EfQ = null;
        }
        AppMethodBeat.o(203015);
    }

    /* access modifiers changed from: protected */
    public final void O(int i2, String str, String str2) {
        AppMethodBeat.i(203016);
        vd vdVar = new vd();
        vdVar.ebw.ebx = fdn();
        vdVar.ebw.eby = str;
        vdVar.ebw.ebz = str2;
        vdVar.ebw.ebA = i2;
        EventCenter.instance.publish(vdVar);
        AppMethodBeat.o(203016);
    }

    private void fdE() {
        AppMethodBeat.i(203017);
        if (this.EcI == null) {
            Bundle bundle = new Bundle();
            ab abVar = this.EfL;
            bundle.putString("qrExtInfo", abVar != null ? abVar.DYM : "");
            this.EcI = new h(this.context, fds(), 3, bundle);
        }
        AppMethodBeat.o(203017);
    }

    public static class a implements f.a {
        WeakReference<af> EfS;
        private boolean EfT = false;

        a(af afVar, boolean z) {
            AppMethodBeat.i(203005);
            this.EfS = new WeakReference<>(afVar);
            this.EfT = z;
            AppMethodBeat.o(203005);
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
        public final void eWN() {
            AppMethodBeat.i(203006);
            af afVar = this.EfS.get();
            if (afVar != null && this.EfT) {
                afVar.EfP = 2;
                Log.i("SnsAd.AdLandingPageQRCodeBtnComp", "mNewQRStatus = 2");
            }
            AppMethodBeat.o(203006);
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
        public final void eWO() {
            AppMethodBeat.i(203007);
            Log.e("SnsAd.AdLandingPageQRCodeBtnComp", "there is something error happening when downloading qr image.");
            final af afVar = this.EfS.get();
            if (afVar != null && this.EfT) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.af.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(203004);
                        try {
                            if (afVar.nUi != null) {
                                afVar.nUi.dismiss();
                                afVar.nUi = null;
                            }
                            AppMethodBeat.o(203004);
                        } catch (Throwable th) {
                            Log.e("SnsAd.AdLandingPageQRCodeBtnComp", th.toString());
                            AppMethodBeat.o(203004);
                        }
                    }
                });
                afVar.EfP = -2;
                Log.i("SnsAd.AdLandingPageQRCodeBtnComp", "mNewQRStatus = -2");
            }
            AppMethodBeat.o(203007);
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
        public final void aNH(String str) {
            AppMethodBeat.i(203008);
            af afVar = this.EfS.get();
            if (afVar != null) {
                Log.d("SnsAd.AdLandingPageQRCodeBtnComp", "download qr image completed, the path " + str + "; cId " + afVar.fdn());
                if (this.EfT) {
                    afVar.EfO = str;
                    afVar.EfP = 3;
                    Log.i("SnsAd.AdLandingPageQRCodeBtnComp", "mNewQRStatus = 3");
                    afVar.O(1, afVar.EfN, str);
                    AppMethodBeat.o(203008);
                    return;
                }
                afVar.EfM = str;
                if (afVar.EfL != null) {
                    afVar.O(0, afVar.EfL.DZy, str);
                    AppMethodBeat.o(203008);
                    return;
                }
            } else {
                Log.w("SnsAd.AdLandingPageQRCodeBtnComp", "qrCodeBtnComp is null in weak ref");
            }
            AppMethodBeat.o(203008);
        }
    }

    public static class b implements AdLandingPagesProxy.e {
        private WeakReference<af> EfS;

        b(af afVar) {
            AppMethodBeat.i(203010);
            this.EfS = new WeakReference<>(afVar);
            AppMethodBeat.o(203010);
        }

        @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e
        public final void bn(Object obj) {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0069, code lost:
            r0 = r6.EfS.get();
         */
        @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void h(int r7, int r8, java.lang.Object r9) {
            /*
            // Method dump skipped, instructions count: 154
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.af.b.h(int, int, java.lang.Object):void");
        }
    }
}
