package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.protocal.protobuf.dul;
import com.tencent.mm.protocal.protobuf.eml;
import com.tencent.mm.protocal.protobuf.zz;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\bH\u0016J \u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddLogic;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "mContext", "Landroid/content/Context;", "mAppId", "", "onDone", "Lkotlin/Function0;", "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "mPhoneNumberAddView", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddView;", "getView", "Landroid/view/View;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "sendSms", "mobile", "sendSmsInner", "showErrorTips", "errMsg", "uninit", "verifyCode", "isCheck", "", TMQQDownloaderOpenSDKConst.UINTYPE_CODE, "Companion", "luggage-wechat-full-sdk_release"})
public final class s implements l {
    private static final String TAG = TAG;
    public static final a nzF = new a((byte) 0);
    private final String mAppId;
    private final Context mContext;
    private m nzD;
    private final kotlin.g.a.a<x> nzE;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "invoke"})
    public static final class d extends q implements kotlin.g.a.b<dul, x> {
        final /* synthetic */ s nzG;
        final /* synthetic */ ProgressDialog nzJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(s sVar, ProgressDialog progressDialog) {
            super(1);
            this.nzG = sVar;
            this.nzJ = progressDialog;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(dul dul) {
            AppMethodBeat.i(148090);
            final dul dul2 = dul;
            a aVar = s.nzF;
            Log.i(s.TAG, "sendSms success" + (dul2 != null));
            if (dul2 != null) {
                a aVar2 = s.nzF;
                Log.i(s.TAG, "sendSms:%d", Integer.valueOf(dul2.status));
                MMHandlerThread.postToMainThread(new Runnable(this) {
                    /* class com.tencent.mm.plugin.appbrand.phonenumber.s.d.AnonymousClass1 */
                    final /* synthetic */ d nzK;

                    {
                        this.nzK = r1;
                    }

                    public final void run() {
                        Long l = null;
                        AppMethodBeat.i(148087);
                        int i2 = dul2.status;
                        h hVar = h.nzb;
                        if (i2 == h.bTm()) {
                            y aex = z.nBg.aex(this.nzK.nzG.mAppId);
                            if (aex != null) {
                                y aex2 = z.nBg.aex(this.nzK.nzG.mAppId);
                                if (aex2 != null) {
                                    l = Long.valueOf(aex2.nAQ);
                                }
                                if (l == null) {
                                    p.hyc();
                                }
                                aex.nAQ = l.longValue() + 1;
                                AppMethodBeat.o(148087);
                                return;
                            }
                            AppMethodBeat.o(148087);
                            return;
                        }
                        h hVar2 = h.nzb;
                        if (i2 == h.bTn()) {
                            y aex3 = z.nBg.aex(this.nzK.nzG.mAppId);
                            if (aex3 != null) {
                                y aex4 = z.nBg.aex(this.nzK.nzG.mAppId);
                                if (aex4 != null) {
                                    l = Long.valueOf(aex4.nAR);
                                }
                                if (l == null) {
                                    p.hyc();
                                }
                                aex3.nAR = l.longValue() + 1;
                            }
                            s sVar = this.nzK.nzG;
                            String string = this.nzK.nzG.mContext.getString(R.string.lr);
                            p.g(string, "mContext.getString(R.str…er_send_verify_code_fail)");
                            s.b(sVar, string);
                            AppMethodBeat.o(148087);
                            return;
                        }
                        h hVar3 = h.nzb;
                        if (i2 == h.bTo()) {
                            y aex5 = z.nBg.aex(this.nzK.nzG.mAppId);
                            if (aex5 != null) {
                                y aex6 = z.nBg.aex(this.nzK.nzG.mAppId);
                                if (aex6 != null) {
                                    l = Long.valueOf(aex6.nAR);
                                }
                                if (l == null) {
                                    p.hyc();
                                }
                                aex5.nAR = l.longValue() + 1;
                            }
                            s sVar2 = this.nzK.nzG;
                            String string2 = this.nzK.nzG.mContext.getString(R.string.ls);
                            p.g(string2, "mContext.getString(R.str…end_verify_code_frequent)");
                            s.b(sVar2, string2);
                            AppMethodBeat.o(148087);
                            return;
                        }
                        y aex7 = z.nBg.aex(this.nzK.nzG.mAppId);
                        if (aex7 != null) {
                            y aex8 = z.nBg.aex(this.nzK.nzG.mAppId);
                            if (aex8 != null) {
                                l = Long.valueOf(aex8.nAR);
                            }
                            if (l == null) {
                                p.hyc();
                            }
                            aex7.nAR = l.longValue() + 1;
                        }
                        s sVar3 = this.nzK.nzG;
                        String string3 = this.nzK.nzG.mContext.getString(R.string.lr);
                        p.g(string3, "mContext.getString(R.str…er_send_verify_code_fail)");
                        s.b(sVar3, string3);
                        AppMethodBeat.o(148087);
                    }
                });
            } else {
                MMHandlerThread.postToMainThread(new Runnable(this) {
                    /* class com.tencent.mm.plugin.appbrand.phonenumber.s.d.AnonymousClass2 */
                    final /* synthetic */ d nzK;

                    {
                        this.nzK = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(148088);
                        y aex = z.nBg.aex(this.nzK.nzG.mAppId);
                        if (aex != null) {
                            y aex2 = z.nBg.aex(this.nzK.nzG.mAppId);
                            Long valueOf = aex2 != null ? Long.valueOf(aex2.nAR) : null;
                            if (valueOf == null) {
                                p.hyc();
                            }
                            aex.nAR = valueOf.longValue() + 1;
                        }
                        s sVar = this.nzK.nzG;
                        String string = this.nzK.nzG.mContext.getString(R.string.lr);
                        p.g(string, "mContext.getString(R.str…er_send_verify_code_fail)");
                        s.b(sVar, string);
                        AppMethodBeat.o(148088);
                    }
                });
            }
            m.runOnUiThread(new Runnable(this) {
                /* class com.tencent.mm.plugin.appbrand.phonenumber.s.d.AnonymousClass3 */
                final /* synthetic */ d nzK;

                {
                    this.nzK = r1;
                }

                public final void run() {
                    AppMethodBeat.i(148089);
                    this.nzK.nzJ.dismiss();
                    AppMethodBeat.o(148089);
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(148090);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "invoke"})
    static final class f extends q implements kotlin.g.a.b<zz, x> {
        final /* synthetic */ s nzG;
        final /* synthetic */ String nzH;
        final /* synthetic */ ProgressDialog nzJ;
        final /* synthetic */ boolean nzN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(s sVar, boolean z, String str, ProgressDialog progressDialog) {
            super(1);
            this.nzG = sVar;
            this.nzN = z;
            this.nzH = str;
            this.nzJ = progressDialog;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(zz zzVar) {
            AppMethodBeat.i(148097);
            final zz zzVar2 = zzVar;
            a aVar = s.nzF;
            Log.i(s.TAG, "verifyCode success:" + (zzVar2 != null));
            if (zzVar2 != null) {
                a aVar2 = s.nzF;
                Log.i(s.TAG, "checkVerifyCode:%d", Integer.valueOf(zzVar2.status));
                MMHandlerThread.postToMainThread(new Runnable(this) {
                    /* class com.tencent.mm.plugin.appbrand.phonenumber.s.f.AnonymousClass1 */
                    final /* synthetic */ f nzO;

                    {
                        this.nzO = r1;
                    }

                    public final void run() {
                        Long l = null;
                        AppMethodBeat.i(148094);
                        int i2 = zzVar2.status;
                        h hVar = h.nzb;
                        if (i2 == h.bTp()) {
                            y aex = z.nBg.aex(this.nzO.nzG.mAppId);
                            if (aex != null) {
                                y aex2 = z.nBg.aex(this.nzO.nzG.mAppId);
                                if (aex2 != null) {
                                    l = Long.valueOf(aex2.nAT);
                                }
                                if (l == null) {
                                    p.hyc();
                                }
                                aex.nAT = l.longValue() + 1;
                            }
                            final String str = zzVar2.nzu;
                            final String str2 = zzVar2.bxK;
                            final String str3 = zzVar2.Lli;
                            final String str4 = zzVar2.nzv;
                            if (str4 == null) {
                                str4 = "";
                            }
                            if (this.nzO.nzN) {
                                new g(this.nzO.nzG.mAppId, this.nzO.nzH, 0).y(new kotlin.g.a.b<eml, x>(this) {
                                    /* class com.tencent.mm.plugin.appbrand.phonenumber.s.f.AnonymousClass1.AnonymousClass1 */
                                    final /* synthetic */ AnonymousClass1 nzQ;

                                    {
                                        this.nzQ = r2;
                                    }

                                    /* Return type fixed from 'java.lang.Object' to match base method */
                                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                    @Override // kotlin.g.a.b
                                    public final /* synthetic */ x invoke(eml eml) {
                                        AppMethodBeat.i(148093);
                                        eml eml2 = eml;
                                        a aVar = s.nzF;
                                        Log.i(s.TAG, "updateUserPhone success:" + (eml2 != null));
                                        if (eml2 != null) {
                                            r rVar = r.nzC;
                                            String str = this.nzQ.nzO.nzH;
                                            String str2 = str3;
                                            p.g(str2, "showMobile");
                                            String str3 = str;
                                            p.g(str3, "encryptedData");
                                            String str4 = str2;
                                            p.g(str4, "iv");
                                            r.c(new PhoneItem(str, str2, str3, str4, str4));
                                            this.nzQ.nzO.nzG.nzE.invoke();
                                        }
                                        x xVar = x.SXb;
                                        AppMethodBeat.o(148093);
                                        return xVar;
                                    }
                                });
                                AppMethodBeat.o(148094);
                                return;
                            }
                            r rVar = r.nzC;
                            String str5 = this.nzO.nzH;
                            p.g(str3, "showMobile");
                            p.g(str, "encryptedData");
                            p.g(str2, "iv");
                            r.c(new PhoneItem(str5, str3, str, str2, str4));
                            this.nzO.nzG.nzE.invoke();
                            AppMethodBeat.o(148094);
                            return;
                        }
                        h hVar2 = h.nzb;
                        if (i2 == h.bTq()) {
                            y aex3 = z.nBg.aex(this.nzO.nzG.mAppId);
                            if (aex3 != null) {
                                y aex4 = z.nBg.aex(this.nzO.nzG.mAppId);
                                if (aex4 != null) {
                                    l = Long.valueOf(aex4.nAU);
                                }
                                if (l == null) {
                                    p.hyc();
                                }
                                aex3.nAU = l.longValue() + 1;
                            }
                            s sVar = this.nzO.nzG;
                            String string = this.nzO.nzG.mContext.getString(R.string.ls);
                            p.g(string, "mContext.getString(R.str…end_verify_code_frequent)");
                            s.b(sVar, string);
                            AppMethodBeat.o(148094);
                            return;
                        }
                        h hVar3 = h.nzb;
                        if (i2 == h.bTr()) {
                            y aex5 = z.nBg.aex(this.nzO.nzG.mAppId);
                            if (aex5 != null) {
                                y aex6 = z.nBg.aex(this.nzO.nzG.mAppId);
                                if (aex6 != null) {
                                    l = Long.valueOf(aex6.nAU);
                                }
                                if (l == null) {
                                    p.hyc();
                                }
                                aex5.nAU = l.longValue() + 1;
                            }
                            s sVar2 = this.nzO.nzG;
                            String string2 = this.nzO.nzG.mContext.getString(R.string.lu);
                            p.g(string2, "mContext.getString(R.str…number_verify_code_error)");
                            s.b(sVar2, string2);
                            AppMethodBeat.o(148094);
                            return;
                        }
                        y aex7 = z.nBg.aex(this.nzO.nzG.mAppId);
                        if (aex7 != null) {
                            y aex8 = z.nBg.aex(this.nzO.nzG.mAppId);
                            if (aex8 != null) {
                                l = Long.valueOf(aex8.nAU);
                            }
                            if (l == null) {
                                p.hyc();
                            }
                            aex7.nAU = l.longValue() + 1;
                        }
                        s sVar3 = this.nzO.nzG;
                        String string3 = this.nzO.nzG.mContext.getString(R.string.lx);
                        p.g(string3, "mContext.getString(R.str…_number_verify_code_fail)");
                        s.b(sVar3, string3);
                        AppMethodBeat.o(148094);
                    }
                });
            } else {
                MMHandlerThread.postToMainThread(new Runnable(this) {
                    /* class com.tencent.mm.plugin.appbrand.phonenumber.s.f.AnonymousClass2 */
                    final /* synthetic */ f nzO;

                    {
                        this.nzO = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(148095);
                        y aex = z.nBg.aex(this.nzO.nzG.mAppId);
                        if (aex != null) {
                            y aex2 = z.nBg.aex(this.nzO.nzG.mAppId);
                            Long valueOf = aex2 != null ? Long.valueOf(aex2.nAU) : null;
                            if (valueOf == null) {
                                p.hyc();
                            }
                            aex.nAU = valueOf.longValue() + 1;
                        }
                        s sVar = this.nzO.nzG;
                        String string = this.nzO.nzG.mContext.getString(R.string.lx);
                        p.g(string, "mContext.getString(R.str…_number_verify_code_fail)");
                        s.b(sVar, string);
                        AppMethodBeat.o(148095);
                    }
                });
            }
            m.runOnUiThread(new Runnable(this) {
                /* class com.tencent.mm.plugin.appbrand.phonenumber.s.f.AnonymousClass3 */
                final /* synthetic */ f nzO;

                {
                    this.nzO = r1;
                }

                public final void run() {
                    AppMethodBeat.i(148096);
                    this.nzO.nzJ.dismiss();
                    AppMethodBeat.o(148096);
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(148097);
            return xVar;
        }
    }

    public s(Context context, String str, kotlin.g.a.a<x> aVar) {
        p.h(context, "mContext");
        p.h(str, "mAppId");
        p.h(aVar, "onDone");
        AppMethodBeat.i(148103);
        this.mContext = context;
        this.mAppId = str;
        this.nzE = aVar;
        AppMethodBeat.o(148103);
    }

    public static final /* synthetic */ void b(s sVar, String str) {
        AppMethodBeat.i(148106);
        sVar.aeu(str);
        AppMethodBeat.o(148106);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddLogic$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(148104);
        AppMethodBeat.o(148104);
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.l
    public final void init() {
        AppMethodBeat.i(148098);
        this.nzD = new t(this.mContext, this);
        z.nBg.aew(this.mAppId);
        AppMethodBeat.o(148098);
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.l
    public final View getView() {
        AppMethodBeat.i(148099);
        m mVar = this.nzD;
        if (mVar != null) {
            View view = mVar.getView();
            AppMethodBeat.o(148099);
            return view;
        }
        AppMethodBeat.o(148099);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.l
    public final void aes(String str) {
        AppMethodBeat.i(148100);
        p.h(str, "mobile");
        if (!Util.isNullOrNil(str)) {
            com.tencent.mm.plugin.appbrand.utils.l.a(this.mContext, this.mContext.getString(R.string.m0) + str, this.mContext.getString(R.string.lz), this.mContext.getString(R.string.a36), this.mContext.getString(R.string.a37), new b(this, str), c.nzI);
            AppMethodBeat.o(148100);
            return;
        }
        String string = this.mContext.getString(R.string.a2r);
        p.g(string, "mContext.getString(R.str…_number_format_err_title)");
        aeu(string);
        AppMethodBeat.o(148100);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class b implements DialogInterface.OnClickListener {
        final /* synthetic */ s nzG;
        final /* synthetic */ String nzH;

        b(s sVar, String str) {
            this.nzG = sVar;
            this.nzH = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(148085);
            s.a(this.nzG, this.nzH);
            AppMethodBeat.o(148085);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class c implements DialogInterface.OnClickListener {
        public static final c nzI = new c();

        static {
            AppMethodBeat.i(148086);
            AppMethodBeat.o(148086);
        }

        c() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
        }
    }

    private final void aeu(String str) {
        AppMethodBeat.i(230147);
        com.tencent.mm.plugin.appbrand.utils.l.b(this.mContext, str, this.mContext.getString(R.string.lo), e.nzM);
        AppMethodBeat.o(230147);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    public static final class e implements DialogInterface.OnClickListener {
        public static final e nzM = new e();

        static {
            AppMethodBeat.i(148092);
            AppMethodBeat.o(148092);
        }

        e() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(148091);
            dialogInterface.dismiss();
            AppMethodBeat.o(148091);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.l
    public final void b(boolean z, String str, String str2) {
        Long l = null;
        AppMethodBeat.i(148101);
        p.h(str, "mobile");
        p.h(str2, TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
        y aex = z.nBg.aex(this.mAppId);
        if (aex != null) {
            y aex2 = z.nBg.aex(this.mAppId);
            Long valueOf = aex2 != null ? Long.valueOf(aex2.nAS) : null;
            if (valueOf == null) {
                p.hyc();
            }
            aex.nAS = valueOf.longValue() + 1;
        }
        if (z) {
            y aex3 = z.nBg.aex(this.mAppId);
            if (aex3 != null) {
                y aex4 = z.nBg.aex(this.mAppId);
                if (aex4 != null) {
                    l = Long.valueOf(aex4.nAV);
                }
                if (l == null) {
                    p.hyc();
                }
                aex3.nAV = l.longValue() + 1;
            }
        } else {
            y aex5 = z.nBg.aex(this.mAppId);
            if (aex5 != null) {
                y aex6 = z.nBg.aex(this.mAppId);
                if (aex6 != null) {
                    l = Long.valueOf(aex6.nAW);
                }
                if (l == null) {
                    p.hyc();
                }
                aex5.nAW = l.longValue() + 1;
            }
        }
        Log.i(TAG, "verifyCode mAppId:" + this.mAppId + ", mobile:" + str + " code:" + str2);
        new b(this.mAppId, str, str2).y(new f(this, z, str, com.tencent.mm.plugin.appbrand.utils.l.b(this.mContext, this.mContext.getString(R.string.a33))));
        AppMethodBeat.o(148101);
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.l
    public final void uninit() {
        AppMethodBeat.i(148102);
        m mVar = this.nzD;
        if (mVar != null) {
            mVar.reset();
        }
        z.nBg.aev(this.mAppId);
        AppMethodBeat.o(148102);
    }

    public static final /* synthetic */ void a(s sVar, String str) {
        AppMethodBeat.i(148105);
        Log.i(TAG, "sendSms appId:" + sVar.mAppId + ", mobile:" + str);
        m mVar = sVar.nzD;
        if (mVar != null) {
            mVar.bTu();
        }
        ProgressDialog b2 = com.tencent.mm.plugin.appbrand.utils.l.b(sVar.mContext, sVar.mContext.getString(R.string.a31));
        y aex = z.nBg.aex(sVar.mAppId);
        if (aex != null) {
            y aex2 = z.nBg.aex(sVar.mAppId);
            Long valueOf = aex2 != null ? Long.valueOf(aex2.nAP) : null;
            if (valueOf == null) {
                p.hyc();
            }
            aex.nAP = valueOf.longValue() + 1;
        }
        new e(sVar.mAppId, str).y(new d(sVar, b2));
        AppMethodBeat.o(148105);
    }
}
