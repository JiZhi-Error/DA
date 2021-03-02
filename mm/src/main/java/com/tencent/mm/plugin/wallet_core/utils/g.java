package com.tencent.mm.plugin.wallet_core.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.aib;
import com.tencent.mm.protocal.protobuf.ccy;
import com.tencent.mm.protocal.protobuf.cml;
import com.tencent.mm.protocal.protobuf.cyf;
import com.tencent.mm.protocal.protobuf.dqe;
import com.tencent.mm.protocal.protobuf.ehc;
import com.tencent.mm.protocal.protobuf.ehf;
import com.tencent.mm.protocal.protobuf.erg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.wallet_core.ui.f;
import java.util.Iterator;
import junit.framework.Assert;

public final class g {

    public interface a {
        void a(dqe dqe);
    }

    public static void a(TextView textView, ehf ehf, a aVar) {
        AppMethodBeat.i(71660);
        if (a(ehf)) {
            textView.setClickable(true);
            textView.setOnTouchListener(new o(textView.getContext()));
        }
        textView.setText(a(textView.getContext(), ehf, aVar));
        AppMethodBeat.o(71660);
    }

    private static boolean a(ehf ehf) {
        AppMethodBeat.i(71661);
        if (ehf.NgT == null || ehf.NgT.isEmpty()) {
            AppMethodBeat.o(71661);
            return false;
        }
        Iterator<ehc> it = ehf.NgT.iterator();
        while (it.hasNext()) {
            if (it.next().KEP != null) {
                AppMethodBeat.o(71661);
                return true;
            }
        }
        AppMethodBeat.o(71661);
        return false;
    }

    public static void a(CdnImageView cdnImageView, ccy ccy) {
        AppMethodBeat.i(71662);
        a(cdnImageView, ccy, -1, 0, 0, true);
        AppMethodBeat.o(71662);
    }

    public static void a(CdnImageView cdnImageView, ccy ccy, int i2, boolean z) {
        AppMethodBeat.i(71663);
        a(cdnImageView, ccy, i2, 0, 0, z);
        AppMethodBeat.o(71663);
    }

    public static void a(CdnImageView cdnImageView, ccy ccy, int i2, int i3, int i4, boolean z) {
        AppMethodBeat.i(71664);
        cdnImageView.setUseSdcardCache(z);
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int) ccy.width);
        int fromDPToPix2 = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int) ccy.height);
        if (i3 <= 0) {
            i3 = fromDPToPix;
        }
        if (i4 <= 0) {
            i4 = fromDPToPix2;
        }
        ViewGroup.LayoutParams layoutParams = cdnImageView.getLayoutParams();
        if (layoutParams != null && i3 > 0 && i4 > 0) {
            layoutParams.width = i3;
            layoutParams.height = i4;
        }
        cdnImageView.s(ccy.url, i3, i4, i2);
        AppMethodBeat.o(71664);
    }

    public static CharSequence a(Context context, ehf ehf, a aVar) {
        AppMethodBeat.i(71665);
        if (ehf == null || ehf.NgT == null || ehf.NgT.isEmpty()) {
            AppMethodBeat.o(71665);
            return "";
        }
        int size = ehf.NgT.size();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i2 = 0; i2 < size; i2++) {
            spannableStringBuilder.append(a(context, ehf.NgT.get(i2), aVar));
        }
        AppMethodBeat.o(71665);
        return spannableStringBuilder;
    }

    public static int cI(String str, boolean z) {
        String str2;
        long j2;
        AppMethodBeat.i(162279);
        aib aib = new aib();
        if (str == null) {
            AppMethodBeat.o(162279);
            return 0;
        } else if (!ao.isDarkMode()) {
            int parseColor = Color.parseColor(str);
            AppMethodBeat.o(162279);
            return parseColor;
        } else {
            try {
                if (((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_android_no_kinda_dark_mode_sw, 1) == 0) {
                    int parseColor2 = Color.parseColor(str);
                    AppMethodBeat.o(162279);
                    return parseColor2;
                }
                if (str.startsWith("#")) {
                    str2 = str.substring(1);
                } else {
                    str2 = str;
                }
                long parseLong = Long.parseLong(str2, 16);
                if (!z) {
                    aib.LrI = parseLong;
                    aib.LrJ = -1;
                    j2 = -1;
                } else if (parseLong == Long.parseLong("ff000000", 16) || parseLong == 0) {
                    j2 = Long.parseLong("CCFFFFFF", 16);
                } else if (parseLong == Long.parseLong("78000000", 16)) {
                    j2 = Long.parseLong("80FFFFFF", 16);
                } else if (parseLong == Long.parseLong("909090", 16) || parseLong == Long.parseLong("ff909090", 16)) {
                    j2 = Long.parseLong("4DFFFFFF", 16);
                } else {
                    aib.LrI = parseLong;
                    aib.LrJ = -1;
                    j2 = -1;
                }
                if (j2 != -1) {
                    int argbColor = argbColor(j2);
                    AppMethodBeat.o(162279);
                    return argbColor;
                }
                long colorByMode = ((com.tencent.mm.pluginsdk.wallet.a) com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(aib.LrI, aib.LrJ);
                if (colorByMode != -1) {
                    int argbColor2 = argbColor(colorByMode);
                    AppMethodBeat.o(162279);
                    return argbColor2;
                }
                int hT = ao.hT(Color.parseColor(str));
                AppMethodBeat.o(162279);
                return hT;
            } catch (Exception e2) {
                int parseColor3 = Color.parseColor(str);
                AppMethodBeat.o(162279);
                return parseColor3;
            }
        }
    }

    private static CharSequence a(final Context context, ehc ehc, final a aVar) {
        long j2;
        int i2;
        int i3;
        AppMethodBeat.i(71666);
        SpannableString spannableString = new SpannableString(ehc.text);
        boolean z = true;
        if (ao.isDarkMode()) {
            if (ehc.NgN == null) {
                j2 = -1;
                ehc.NgN = new aib();
                if (ehc.NgL == Long.parseLong("ff000000", 16) || ehc.NgL == 0) {
                    j2 = Long.parseLong("CCFFFFFF", 16);
                } else if (ehc.NgL == Long.parseLong("78000000", 16)) {
                    j2 = Long.parseLong("80FFFFFF", 16);
                } else {
                    ehc.NgN.LrI = ehc.NgL;
                    ehc.NgN.LrJ = -1;
                }
                if (j2 == -1) {
                    j2 = ((com.tencent.mm.pluginsdk.wallet.a) com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(ehc.NgN.LrI, ehc.NgN.LrJ);
                    if (j2 == -1) {
                        j2 = (long) ao.hT((int) ehc.NgL);
                        z = false;
                    }
                }
            } else {
                j2 = ((com.tencent.mm.pluginsdk.wallet.a) com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(ehc.NgN.LrI, ehc.NgN.LrJ);
            }
            i2 = (int) j2;
        } else {
            j2 = ehc.NgL;
            i2 = (int) j2;
        }
        if (!z || (-16777216 & j2) != 0) {
            i3 = i2;
        } else {
            i3 = (int) (j2 | -16777216);
        }
        WcPayTextApppearanceSpan wcPayTextApppearanceSpan = new WcPayTextApppearanceSpan(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int) ehc.size), ColorStateList.valueOf(i3));
        spannableString.setSpan(wcPayTextApppearanceSpan, 0, spannableString.length(), 17);
        if (!Util.isNullOrNil(ehc.CeI)) {
            wcPayTextApppearanceSpan.IoX = f.cK(context, ehc.CeI);
        }
        Object obj = null;
        if (ehc.NgM == 1) {
            obj = new StrikethroughSpan();
        } else if (ehc.NgM == 2) {
            obj = new UnderlineSpan();
        }
        if (obj != null) {
            spannableString.setSpan(obj, 0, spannableString.length(), 17);
        }
        if (!(ehc.KEP == null || ehc.KEP.type == 0)) {
            final dqe dqe = ehc.KEP;
            Log.i("MicroMsg.WcPayViewEngineRender", "route type: %s", Integer.valueOf(dqe.type));
            spannableString.setSpan(new q(new q.a() {
                /* class com.tencent.mm.plugin.wallet_core.utils.g.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.wallet_core.ui.q.a
                public final void dF(View view) {
                    AppMethodBeat.i(71651);
                    if (aVar != null) {
                        new Object[1][0] = view;
                        g.a(context, dqe, (Bundle) null);
                        a aVar = aVar;
                        dqe dqe = dqe;
                        new Object[1][0] = view;
                        aVar.a(dqe);
                        AppMethodBeat.o(71651);
                        return;
                    }
                    g.a(context, dqe, (Bundle) null);
                    AppMethodBeat.o(71651);
                }
            }), 0, spannableString.length(), 17);
        }
        AppMethodBeat.o(71666);
        return spannableString;
    }

    public static void a(Context context, dqe dqe, Bundle bundle) {
        int i2 = 1000;
        AppMethodBeat.i(71667);
        if (dqe == null) {
            AppMethodBeat.o(71667);
            return;
        }
        Log.i("MicroMsg.WcPayViewEngineRender", "route info type: %s, uri: %s", Integer.valueOf(dqe.type), dqe.url);
        if (dqe.type == 1) {
            f.o(context, dqe.url, true);
            AppMethodBeat.o(71667);
        } else if (dqe.type != 2) {
            if (dqe.type != 3) {
                if (dqe.type == 4) {
                    if (dqe.url.equals("balance")) {
                        c.d(context, "wallet", ".balance.ui.WalletBalanceManagerUI", 65281);
                        AppMethodBeat.o(71667);
                        return;
                    } else if (dqe.url.equals("bankCard")) {
                        Intent intent = new Intent();
                        intent.putExtra("intent_finish_self", true);
                        c.b(context, "wallet", ".bind.ui.WalletBankcardManageUI", intent, 65281);
                        AppMethodBeat.o(71667);
                        return;
                    } else if (dqe.url.equals("qmfCard")) {
                        c.b(context, "honey_pay", ".ui.HoneyPayMainUI", new Intent(), 65283);
                        AppMethodBeat.o(71667);
                        return;
                    } else if (dqe.url.equals("paySecurity")) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("wallet_lock_jsapi_scene", 1);
                        c.b(context, "wallet", ".pwd.ui.WalletSecuritySettingUI", intent2, 65282);
                        AppMethodBeat.o(71667);
                        return;
                    } else if (dqe.url.equals("lqt")) {
                        Intent intent3 = new Intent();
                        intent3.putExtra("key_account_type", 1);
                        c.b(context, "wallet", ".balance.ui.lqt.WalletLqtDetailUI", intent3, 65286);
                        AppMethodBeat.o(71667);
                        return;
                    } else if (dqe.url.equals("realname")) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("real_name_verify_mode", 0);
                        bundle2.putInt("entry_scene", 0);
                        if (bundle != null) {
                            bundle2.putAll(bundle);
                        }
                        Assert.assertTrue("context must be activity", context instanceof Activity);
                        com.tencent.mm.wallet_core.a.a((Activity) context, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle2);
                        AppMethodBeat.o(71667);
                        return;
                    }
                } else if (dqe.type == 5) {
                    if (dqe.url.equals("wxpay://lqp/balanceQuotaState")) {
                        c.b(context, "wallet_ecard", ".ui.WalletECardLogoutUI", new Intent());
                        AppMethodBeat.o(71667);
                        return;
                    }
                } else if (dqe.type != 13) {
                    Log.w("MicroMsg.WcPayViewEngineRender", "can't handle type: %s, uri: %s", Integer.valueOf(dqe.type), dqe.url);
                } else if (dqe.MTl != null) {
                    AppMethodBeat.o(71667);
                    return;
                }
            }
            AppMethodBeat.o(71667);
        } else if (dqe.MTh == null) {
            Log.e("MicroMsg.WcPayViewEngineRender", "tiny app uri is null");
            AppMethodBeat.o(71667);
        } else {
            if (bundle != null) {
                i2 = bundle.getInt("key_tiny_app_scene", 1000);
            }
            f.u(dqe.MTh.username, dqe.MTh.path, dqe.MTh.version, i2);
            AppMethodBeat.o(71667);
        }
    }

    public static void a(View view, ViewGroup.MarginLayoutParams marginLayoutParams, erg erg) {
        AppMethodBeat.i(71668);
        if (erg == null) {
            AppMethodBeat.o(71668);
            return;
        }
        a(marginLayoutParams, erg.NoS);
        a(view, erg.MTe);
        AppMethodBeat.o(71668);
    }

    public static void a(View view, cyf cyf) {
        AppMethodBeat.i(71669);
        if (cyf == null) {
            AppMethodBeat.o(71669);
            return;
        }
        view.setPadding(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int) cyf.left), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int) cyf.top), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int) cyf.right), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int) cyf.bottom));
        AppMethodBeat.o(71669);
    }

    private static void a(ViewGroup.MarginLayoutParams marginLayoutParams, cml cml) {
        AppMethodBeat.i(71670);
        if (cml == null) {
            AppMethodBeat.o(71670);
            return;
        }
        marginLayoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int) cml.top);
        marginLayoutParams.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int) cml.bottom);
        marginLayoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int) cml.left);
        marginLayoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int) cml.right);
        AppMethodBeat.o(71670);
    }

    public static int argbColor(long j2) {
        AppMethodBeat.i(162280);
        int argb = Color.argb((int) ((j2 >> 24) & 255), (int) ((j2 >> 16) & 255), (int) ((j2 >> 8) & 255), (int) (255 & j2));
        AppMethodBeat.o(162280);
        return argb;
    }

    public static String a(Context context, ehf ehf) {
        AppMethodBeat.i(71671);
        String charSequence = a(context, ehf, (a) null).toString();
        AppMethodBeat.o(71671);
        return charSequence;
    }
}
