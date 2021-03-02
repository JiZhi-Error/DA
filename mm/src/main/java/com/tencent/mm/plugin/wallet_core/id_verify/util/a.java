package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.wallet_core.id_verify.model.h;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.protocal.protobuf.ehb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.f;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class a implements i {
    private AbstractC1915a HUD = null;
    WeakReference<MMActivity> HUE;
    WeakReference<e> HUF;
    private boolean HUG = false;
    d HUH;
    int mScene = -1;

    /* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.util.a$a  reason: collision with other inner class name */
    public interface AbstractC1915a {
        boolean run(int i2, int i3, String str, boolean z);
    }

    public final boolean a(MMActivity mMActivity, e eVar, int i2) {
        AppMethodBeat.i(70188);
        this.HUG = false;
        g.aAi();
        long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_WALLET_REALNAME_DISCLAIMER_QUERY_EXPIRED_TIME_LONG_SYNC, (Object) 0L)).longValue();
        if (longValue > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            f.d(5, Util.nowSecond(), i2);
            if (currentTimeMillis < longValue) {
                Log.i("MicroMsg.RealnameVerifyUtil", "getDisclaimer query is not expired. expiredTime = ".concat(String.valueOf(longValue)));
                AppMethodBeat.o(70188);
                return false;
            }
            Log.i("MicroMsg.RealnameVerifyUtil", "getDisclaimer query had expired. expiredTime = ".concat(String.valueOf(longValue)));
        }
        if (mMActivity == null) {
            Log.e("MicroMsg.RealnameVerifyUtil", "context is null");
            AppMethodBeat.o(70188);
        } else if (eVar == null) {
            Log.e("MicroMsg.RealnameVerifyUtil", "netmgr is null");
            AppMethodBeat.o(70188);
        } else {
            AppMethodBeat.o(70188);
        }
        return false;
    }

    private void efi() {
        AppMethodBeat.i(70189);
        if (!(this.HUF == null || this.HUF.get() == null)) {
            this.HUF.get().efi();
        }
        AppMethodBeat.o(70189);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(70190);
        if (qVar instanceof h) {
            g.aAi();
            g.aAg().hqi.b(385, this);
            efi();
            if (i2 == 0 && i3 == 0) {
                h hVar = (h) qVar;
                boolean equals = hVar.HTK.equals("1");
                if (equals) {
                    Log.i("MicroMsg.RealnameVerifyUtil", "user had agreed");
                    c(0, i3, str, equals);
                    AppMethodBeat.o(70190);
                    return;
                }
                a(this.HUE.get(), this.HUF.get(), hVar.title, hVar.HTL, hVar.HTM, hVar.HTN, this.HUD, false, hVar.HTO);
                AppMethodBeat.o(70190);
                return;
            }
            c(2, i3, str, false);
            AppMethodBeat.o(70190);
            return;
        }
        if (qVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.d) {
            g.aAi();
            g.aAg().hqi.a(385, this);
            efi();
            if (i2 == 0 && i3 == 0) {
                c(0, i3, str, true);
                AppMethodBeat.o(70190);
                return;
            }
            c(3, i3, str, false);
        }
        AppMethodBeat.o(70190);
    }

    public final void a(final MMActivity mMActivity, e eVar, String str, String str2, final String str3, String str4, AbstractC1915a aVar, boolean z, final int i2) {
        AppMethodBeat.i(70191);
        this.HUE = new WeakReference<>(mMActivity);
        this.HUF = new WeakReference<>(eVar);
        this.HUG = z;
        if (!(this.HUE == null || this.HUE.get() == null)) {
            this.HUD = aVar;
            l lVar = new l(mMActivity);
            lVar.IgH = new l.a() {
                /* class com.tencent.mm.plugin.wallet_core.id_verify.util.a.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.wallet_core.ui.l.a
                public final void onClick(View view) {
                    AppMethodBeat.i(70176);
                    f.d(3, Util.nowSecond(), i2);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str3);
                    intent.putExtra("showShare", false);
                    f.aA(mMActivity, intent);
                    AppMethodBeat.o(70176);
                }
            };
            SpannableString c2 = com.tencent.mm.pluginsdk.ui.span.l.c(mMActivity, str + str2);
            SpannableString spannableString = new SpannableString(c2);
            spannableString.setSpan(lVar, c2.length() - str2.length(), c2.length(), 33);
            TextView textView = new TextView(mMActivity);
            textView.setText(spannableString);
            textView.setTextSize(0, (float) com.tencent.mm.cb.a.aG(mMActivity, R.dimen.hc));
            textView.setTextColor(mMActivity.getResources().getColorStateList(R.color.a2x));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            f.d(0, Util.nowSecond(), i2);
            this.HUH = com.tencent.mm.ui.base.h.a(mMActivity, "", textView, str4, mMActivity.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.id_verify.util.a.AnonymousClass7 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(70182);
                    f.d(2, Util.nowSecond(), i2);
                    if (!(a.this.HUF == null || a.this.HUF.get() == null)) {
                        g.aAi();
                        g.aAg().hqi.a(385, a.this);
                        a.this.HUF.get().b(new com.tencent.mm.plugin.wallet_core.id_verify.model.d(a.this.mScene), true);
                    }
                    AppMethodBeat.o(70182);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.id_verify.util.a.AnonymousClass8 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(70183);
                    f.d(1, Util.nowSecond(), i2);
                    a.this.c(1, -1, "cancel", false);
                    AppMethodBeat.o(70183);
                }
            });
        }
        AppMethodBeat.o(70191);
    }

    /* access modifiers changed from: package-private */
    public final void c(int i2, int i3, String str, boolean z) {
        AppMethodBeat.i(70192);
        Log.i("MicroMsg.RealnameVerifyUtil", "doGetDisclaimerCallback call");
        if (this.HUD != null) {
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_WALLET_DISCLAIMER_NEED_AGERR_INT_SYNC, Integer.valueOf(z ? 0 : 1));
            if (!this.HUD.run(i2, i3, str, z)) {
                Log.e("MicroMsg.RealnameVerifyUtil", "doGetDisclaimerCallback: errCode = " + i3 + ";errMsg = " + str);
                if (i2 == 3) {
                    if (!(!Util.isNullOrNil(str) || this.HUE == null || this.HUE.get() == null)) {
                        str = this.HUE.get().getString(R.string.itf);
                    }
                    Log.e("MicroMsg.RealnameVerifyUtil", "show error dialog");
                    com.tencent.mm.ui.base.h.a((Context) this.HUE.get(), str, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet_core.id_verify.util.a.AnonymousClass9 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(70184);
                            dialogInterface.dismiss();
                            a.this.HUH.dismiss();
                            if (!(a.this.HUE == null || a.this.HUE.get() == null)) {
                                a.this.HUE.get().finish();
                            }
                            a.this.destory();
                            AppMethodBeat.o(70184);
                        }
                    });
                    AppMethodBeat.o(70192);
                    return;
                }
            }
            if (this.HUH != null) {
                this.HUH.dismiss();
            }
            destory();
        }
        AppMethodBeat.o(70192);
    }

    /* access modifiers changed from: package-private */
    public final void destory() {
        AppMethodBeat.i(70193);
        this.HUG = false;
        if (this.HUH != null) {
            Log.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : close mDisclaimerDialog");
            this.HUH = null;
        }
        if (this.HUF != null) {
            Log.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mNetSceneMgr");
            this.HUF.clear();
            this.HUF = null;
        }
        if (this.HUE != null) {
            Log.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mContextReference");
            this.HUE.clear();
            this.HUE = null;
        }
        Log.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear getDisclaimerCallback");
        this.HUD = null;
        AppMethodBeat.o(70193);
    }

    private static JSONObject r(q qVar) {
        com.tencent.mm.ak.d commReqResp;
        JSONObject jSONObject;
        AppMethodBeat.i(70194);
        if (!(qVar == null || !(qVar instanceof m) || (commReqResp = ((m) qVar).getCommReqResp()) == null)) {
            ehb ehb = (ehb) commReqResp.iLL.iLR;
            if (ehb.MhT != null) {
                try {
                    jSONObject = new JSONObject(z.b(ehb.MhT));
                } catch (JSONException e2) {
                    Log.printErrStackTrace("MicroMsg.RealnameVerifyUtil", e2, "", new Object[0]);
                    jSONObject = null;
                }
                AppMethodBeat.o(70194);
                return jSONObject;
            }
        }
        AppMethodBeat.o(70194);
        return null;
    }

    public static boolean a(Activity activity, int i2, q qVar, Bundle bundle, int i3) {
        AppMethodBeat.i(70195);
        if (i2 != 416) {
            Log.i("MicroMsg.RealnameVerifyUtil", "don't need realname verify");
            AppMethodBeat.o(70195);
            return false;
        }
        Log.i("MicroMsg.RealnameVerifyUtil", "need realname verify");
        boolean a2 = a(activity, qVar, bundle, false, i3);
        AppMethodBeat.o(70195);
        return a2;
    }

    public static boolean a(Activity activity, q qVar, Bundle bundle, boolean z, int i2) {
        String str;
        AppMethodBeat.i(70196);
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        JSONObject r = r(qVar);
        if (r != null) {
            if (r.has("real_name_info")) {
                r = r.optJSONObject("real_name_info");
            }
            String optString = r.optString("guide_flag", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            str2 = r.optString("guide_wording");
            str3 = r.optString("left_button_wording", activity.getString(R.string.sz));
            str4 = r.optString("right_button_wording", activity.getString(R.string.x_));
            str5 = r.optString("upload_credit_url", "");
            str = optString;
        } else {
            str = "";
        }
        Log.i("MicroMsg.RealnameVerifyUtil", "guide_flag = " + str + ";upload_credit_url=" + str5);
        if ("1".equals(str)) {
            Log.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog");
            boolean a2 = a(activity, bundle, null, i2);
            AppMethodBeat.o(70196);
            return a2;
        } else if (!"2".equals(str) || Util.isNullOrNil(str5)) {
            Log.e("MicroMsg.RealnameVerifyUtil", "guide_flag=" + str + ";upload_credit_url=null?" + Util.isNullOrNil(str5));
            AppMethodBeat.o(70196);
            return false;
        } else {
            Log.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog");
            boolean a3 = a(activity, str2, str5, str3, str4, z, (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(70196);
            return a3;
        }
    }

    public static boolean a(Activity activity, int i2, dju dju, Bundle bundle, int i3) {
        AppMethodBeat.i(70197);
        if (i2 != 416) {
            Log.i("MicroMsg.RealnameVerifyUtil", "don't need realname verify");
            AppMethodBeat.o(70197);
            return false;
        }
        Log.i("MicroMsg.RealnameVerifyUtil", "need realname verify");
        if (dju == null) {
            AppMethodBeat.o(70197);
            return false;
        }
        Log.i("MicroMsg.RealnameVerifyUtil", "guide_flag = " + dju.KCl + ";upload_credit_url=" + dju.yXK);
        if (Util.isEqual("1", new StringBuilder().append(dju.KCl).toString())) {
            Log.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog");
            boolean a2 = a(activity, bundle, null, i3);
            AppMethodBeat.o(70197);
            return a2;
        } else if (!Util.isEqual("2", new StringBuilder().append(dju.KCl).toString()) || Util.isNullOrNil(dju.yXK)) {
            Log.e("MicroMsg.RealnameVerifyUtil", "guide_flag=" + dju.KCl + ";upload_credit_url=null?" + Util.isNullOrNil(dju.yXK));
            AppMethodBeat.o(70197);
            return false;
        } else {
            Log.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog");
            boolean a3 = a(activity, dju.yXJ, dju.yXK, dju.lHA, dju.lHB, true, (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(70197);
            return a3;
        }
    }

    public static boolean a(Activity activity, Bundle bundle, d.a aVar, int i2) {
        AppMethodBeat.i(70198);
        Log.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog call %d", 0);
        Log.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog click OK");
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("real_name_verify_mode", 0);
        bundle.putInt("entry_scene", i2);
        com.tencent.mm.wallet_core.a.a(activity, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle, aVar);
        f.d(19, Util.nowSecond(), i2);
        AppMethodBeat.o(70198);
        return true;
    }

    public static boolean a(final Activity activity, String str, final String str2, String str3, String str4, final boolean z, DialogInterface.OnClickListener onClickListener) {
        String str5;
        String str6;
        DialogInterface.OnClickListener onClickListener2;
        AppMethodBeat.i(70199);
        if (Util.isNullOrNil(str3)) {
            str5 = activity.getString(R.string.sz);
        } else {
            str5 = str3;
        }
        if (Util.isNullOrNil(str4)) {
            str6 = activity.getString(R.string.x_);
        } else {
            str6 = str4;
        }
        if (onClickListener == null) {
            Log.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog use default calcel listener");
            onClickListener2 = new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.id_verify.util.a.AnonymousClass10 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(70185);
                    Log.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click cancel");
                    dialogInterface.dismiss();
                    if (z) {
                        activity.finish();
                    }
                    AppMethodBeat.o(70185);
                }
            };
        } else {
            onClickListener2 = onClickListener;
        }
        com.tencent.mm.ui.widget.a.d a2 = com.tencent.mm.ui.base.h.a(activity, str, "", str6, str5, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.util.a.AnonymousClass11 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(70186);
                Log.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click OK");
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                intent.putExtra("showShare", false);
                f.aA(activity, intent);
                dialogInterface.dismiss();
                if (z) {
                    activity.finish();
                }
                AppMethodBeat.o(70186);
            }
        }, onClickListener2, (int) R.color.afp);
        if (a2 != null) {
            a2.setOnCancelListener(new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.wallet_core.id_verify.util.a.AnonymousClass12 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(70187);
                    if (z) {
                        activity.finish();
                    }
                    AppMethodBeat.o(70187);
                }
            });
            a2.setOnDismissListener(new DialogInterface.OnDismissListener() {
                /* class com.tencent.mm.plugin.wallet_core.id_verify.util.a.AnonymousClass2 */

                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(70177);
                    if (z) {
                        activity.finish();
                    }
                    AppMethodBeat.o(70177);
                }
            });
        }
        AppMethodBeat.o(70199);
        return true;
    }

    public static boolean a(Activity activity, Bundle bundle, int i2, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener) {
        String str4;
        String str5;
        DialogInterface.OnClickListener onClickListener2;
        AppMethodBeat.i(70200);
        g.aAi();
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_SET_PWD_TIP_INT_SYNC, (Object) 0)).intValue();
        Log.i("MicroMsg.RealnameVerifyUtil", "showSetPwdDialog count %s", Integer.valueOf(intValue));
        if (intValue >= 3) {
            AppMethodBeat.o(70200);
            return false;
        }
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_WALLET_SET_PWD_TIP_INT_SYNC, Integer.valueOf(intValue + 1));
        if (Util.isNullOrNil(str2)) {
            str4 = activity.getString(R.string.sz);
        } else {
            str4 = str2;
        }
        if (Util.isNullOrNil(str3)) {
            str5 = activity.getString(R.string.x_);
        } else {
            str5 = str3;
        }
        if (onClickListener == null) {
            onClickListener2 = new DialogInterface.OnClickListener(false, activity) {
                /* class com.tencent.mm.plugin.wallet_core.id_verify.util.a.AnonymousClass3 */
                final /* synthetic */ boolean HUL = false;
                final /* synthetic */ Activity dnO;

                {
                    this.dnO = r3;
                }

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(70178);
                    Log.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click cancel");
                    dialogInterface.dismiss();
                    if (this.HUL) {
                        this.dnO.finish();
                    }
                    AppMethodBeat.o(70178);
                }
            };
        } else {
            onClickListener2 = onClickListener;
        }
        com.tencent.mm.ui.widget.a.d a2 = com.tencent.mm.ui.base.h.a(activity, str, "", str5, str4, new DialogInterface.OnClickListener(bundle, i2, activity, false) {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.util.a.AnonymousClass4 */
            final /* synthetic */ int HUI;
            final /* synthetic */ boolean HUL = false;
            final /* synthetic */ Activity dnO;
            final /* synthetic */ Bundle val$bundle;

            {
                this.val$bundle = r2;
                this.HUI = r3;
                this.dnO = r4;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(70179);
                Log.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click OK");
                Log.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog click OK");
                Bundle bundle = this.val$bundle;
                if (this.val$bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putInt("real_name_verify_mode", 0);
                bundle.putInt("entry_scene", this.HUI);
                bundle.putBoolean("key_from_set_pwd", true);
                com.tencent.mm.wallet_core.a.a(this.dnO, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle);
                f.d(19, Util.nowSecond(), this.HUI);
                dialogInterface.dismiss();
                if (this.HUL) {
                    this.dnO.finish();
                }
                AppMethodBeat.o(70179);
            }
        }, onClickListener2, (int) R.color.afp);
        if (a2 != null) {
            a2.setOnCancelListener(new DialogInterface.OnCancelListener(false, activity) {
                /* class com.tencent.mm.plugin.wallet_core.id_verify.util.a.AnonymousClass5 */
                final /* synthetic */ boolean HUL = false;
                final /* synthetic */ Activity dnO;

                {
                    this.dnO = r3;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(70180);
                    if (this.HUL) {
                        this.dnO.finish();
                    }
                    AppMethodBeat.o(70180);
                }
            });
            a2.setOnDismissListener(new DialogInterface.OnDismissListener(false, activity) {
                /* class com.tencent.mm.plugin.wallet_core.id_verify.util.a.AnonymousClass6 */
                final /* synthetic */ boolean HUL = false;
                final /* synthetic */ Activity dnO;

                {
                    this.dnO = r3;
                }

                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(70181);
                    if (this.HUL) {
                        this.dnO.finish();
                    }
                    AppMethodBeat.o(70181);
                }
            });
        }
        AppMethodBeat.o(70200);
        return true;
    }
}
