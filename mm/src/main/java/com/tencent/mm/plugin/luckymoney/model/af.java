package com.tencent.mm.plugin.luckymoney.model;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.p;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.b.f;
import com.tencent.mm.g.a.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.luckymoney.b.a;
import com.tencent.mm.plugin.luckymoney.ui.SelectLuckyMoneyContactUI;
import com.tencent.mm.pluginsdk.i.e;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.wallet_core.d;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class af {
    private static f<String, Bitmap> tgj = new b(10, af.class);
    public static int yWJ = Integer.MAX_VALUE;

    public static String o(Context context, long j2) {
        AppMethodBeat.i(65247);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j2 < Util.MILLSECONDS_OF_HOUR) {
            AppMethodBeat.o(65247);
            return "";
        }
        long timeInMillis = j2 - new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5)).getTimeInMillis();
        if (timeInMillis <= 0 || timeInMillis > Util.MILLSECONDS_OF_DAY) {
            Time time = new Time();
            time.set(j2);
            String charSequence = e.a(context.getString(R.string.dee, " "), time).toString();
            AppMethodBeat.o(65247);
            return charSequence;
        }
        String format = new SimpleDateFormat("HH:mm").format(new Date(j2));
        AppMethodBeat.o(65247);
        return format;
    }

    private static void a(ImageView imageView, String str, String str2, boolean z) {
        AppMethodBeat.i(65249);
        Log.i("MicroMsg.LuckyMoneyUtil", "load url: %s", str);
        if (imageView != null) {
            imageView.setImageBitmap(null);
        }
        if (!Util.isNullOrNil(str)) {
            c.a aVar = new c.a();
            a.eex();
            aVar.prefixPath = a.eeA();
            aVar.jbf = true;
            aVar.hZF = true;
            aVar.iaT = z;
            if (z) {
                aVar.jbx = 0.0f;
            }
            if (!Util.isNullOrNil(str2)) {
                aVar.md5 = str2;
                aVar.jbj = true;
            } else {
                aVar.jbj = false;
            }
            q.bcV().a(str, imageView, aVar.bdv());
        }
        AppMethodBeat.o(65249);
    }

    public static void b(ImageView imageView, String str, String str2, boolean z) {
        AppMethodBeat.i(258593);
        a(imageView, str, str2, false);
        AppMethodBeat.o(258593);
    }

    public static void a(ImageView imageView, String str, String str2) {
        AppMethodBeat.i(65253);
        if (imageView == null) {
            AppMethodBeat.o(65253);
            return;
        }
        if (Util.isNullOrNil(str2)) {
            str2 = p.aYD().Mj(str);
        }
        a.b.a(imageView, str2, 0.1f, false);
        AppMethodBeat.o(65253);
    }

    public static void s(ImageView imageView, String str) {
        AppMethodBeat.i(65254);
        if (imageView == null) {
            AppMethodBeat.o(65254);
            return;
        }
        imageView.setImageBitmap(null);
        if (!Util.isNullOrNil(str)) {
            c.a aVar = new c.a();
            com.tencent.mm.plugin.luckymoney.b.a.eex();
            aVar.prefixPath = com.tencent.mm.plugin.luckymoney.b.a.eeA();
            aVar.jbf = true;
            aVar.hZF = true;
            aVar.iaT = true;
            aVar.jbi = 1;
            aVar.jbq = R.drawable.cc2;
            q.bcV().a(str, imageView, aVar.bdv());
        }
        AppMethodBeat.o(65254);
    }

    public static void a(Context context, TextView textView, String str) {
        AppMethodBeat.i(65255);
        if (textView == null) {
            AppMethodBeat.o(65255);
            return;
        }
        textView.setText(l.b(context, str, textView.getTextSize()));
        AppMethodBeat.o(65255);
    }

    public static void a(MMActivity mMActivity, int i2, int i3, boolean z) {
        AppMethodBeat.i(65256);
        if (i2 != 0 || i3 <= 1) {
            a(mMActivity, 2, z);
            AppMethodBeat.o(65256);
            return;
        }
        Intent intent = new Intent();
        intent.setClass(mMActivity, SelectLuckyMoneyContactUI.class);
        intent.putExtra("key_friends_num", i3);
        if (z) {
            intent.putExtra("scene_from", 5);
        }
        mMActivity.startActivityForResult(intent, 2);
        AppMethodBeat.o(65256);
    }

    public static void a(MMActivity mMActivity, int i2, boolean z) {
        AppMethodBeat.i(65257);
        Intent intent = new Intent();
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Select_Conv_Type", 3);
        if (z) {
            intent.putExtra("scene_from", 5);
        }
        com.tencent.mm.br.c.c(mMActivity, ".ui.transmit.SelectConversationUI", intent, i2);
        AppMethodBeat.o(65257);
    }

    public static String efj() {
        AppMethodBeat.i(65258);
        g.aAi();
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_SELFINFO_SMALLIMGURL_STRING, (Object) null);
        AppMethodBeat.o(65258);
        return str;
    }

    public static String aDw(String str) {
        String str2;
        AppMethodBeat.i(65259);
        i Mx = p.aYB().Mx(str);
        if (Mx != null) {
            String aYu = Mx.aYu();
            AppMethodBeat.o(65259);
            return aYu;
        }
        g.aAi();
        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str);
        if (Kn == null || !Kn.field_username.equals(str)) {
            AppMethodBeat.o(65259);
            return null;
        } else if (Kn.fuz == 4) {
            AppMethodBeat.o(65259);
            return null;
        } else {
            g.aAi();
            byte[] bjP = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjP(str);
            if (Util.isNullOrNil(bjP)) {
                AppMethodBeat.o(65259);
                return null;
            }
            try {
                str2 = ((cpl) new cpl().parseFrom(bjP)).Lis;
            } catch (Exception e2) {
                Log.e("MicroMsg.LuckyMoneyUtil", "exception:%s", Util.stackTraceToString(e2));
                str2 = null;
            }
            AppMethodBeat.o(65259);
            return str2;
        }
    }

    public static String Ir(String str) {
        AppMethodBeat.i(65260);
        g.aAi();
        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str);
        if (Kn == null || !Kn.field_username.equals(str)) {
            AppMethodBeat.o(65260);
            return null;
        }
        String str2 = Kn.field_nickname;
        AppMethodBeat.o(65260);
        return str2;
    }

    static {
        AppMethodBeat.i(65274);
        AppMethodBeat.o(65274);
    }

    public static int gt(Context context) {
        AppMethodBeat.i(65261);
        if (yWJ == Integer.MAX_VALUE) {
            yWJ = context.getResources().getColor(R.color.yb);
        }
        int i2 = yWJ;
        AppMethodBeat.o(65261);
        return i2;
    }

    public static void eo(View view) {
        AppMethodBeat.i(65262);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.4f, 0.98f, 0.4f, 0.98f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(200);
        scaleAnimation.setInterpolator(new OvershootInterpolator());
        scaleAnimation.setFillAfter(true);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.98f, 1.0f, 0.98f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(50);
        scaleAnimation2.setFillAfter(true);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.luckymoney.model.af.AnonymousClass1 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(65245);
                AppMethodBeat.o(65245);
            }
        });
        if (view != null) {
            view.startAnimation(scaleAnimation);
        }
        AppMethodBeat.o(65262);
    }

    public static void a(final View view, Animation.AnimationListener animationListener) {
        AppMethodBeat.i(65263);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 0.96f, 0.0f, 0.96f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300);
        scaleAnimation.setInterpolator(new OvershootInterpolator());
        scaleAnimation.setFillAfter(true);
        final ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.96f, 1.0f, 0.96f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(100);
        scaleAnimation2.setFillAfter(true);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.luckymoney.model.af.AnonymousClass2 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(65246);
                view.startAnimation(scaleAnimation2);
                AppMethodBeat.o(65246);
            }
        });
        if (animationListener != null) {
            scaleAnimation2.setAnimationListener(animationListener);
        }
        if (view != null) {
            view.startAnimation(scaleAnimation);
        }
        AppMethodBeat.o(65263);
    }

    public static void b(Button button) {
        AppMethodBeat.i(65264);
        c(button);
        AppMethodBeat.o(65264);
    }

    public static void c(Button button) {
        AppMethodBeat.i(65265);
        if (button == null) {
            AppMethodBeat.o(65265);
            return;
        }
        button.setBackgroundResource(R.drawable.wq);
        AnimationDrawable animationDrawable = (AnimationDrawable) button.getBackground();
        if (animationDrawable != null) {
            animationDrawable.start();
        }
        AppMethodBeat.o(65265);
    }

    public static void d(Button button) {
        AppMethodBeat.i(65266);
        if (button == null) {
            AppMethodBeat.o(65266);
        } else if (!(button.getBackground() instanceof AnimationDrawable)) {
            AppMethodBeat.o(65266);
        } else {
            AnimationDrawable animationDrawable = (AnimationDrawable) button.getBackground();
            if (animationDrawable != null) {
                animationDrawable.stop();
            }
            AppMethodBeat.o(65266);
        }
    }

    public static boolean ac(String str, String str2, int i2) {
        AppMethodBeat.i(65267);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            Log.w("MicroMsg.LuckyMoneyUtil", Util.nullAsNil(str) + ", " + Util.nullAsNil(str2));
            AppMethodBeat.o(65267);
            return false;
        }
        ca caVar = new ca();
        caVar.setContent(str);
        caVar.setStatus(2);
        caVar.Cy(str2);
        caVar.setCreateTime(bp.Kw(str2));
        caVar.nv(1);
        if (i2 == 3) {
            caVar.setType(469762097);
        } else {
            caVar.setType(436207665);
        }
        long aC = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(caVar);
        if (aC < 0) {
            Log.e("MicroMsg.LuckyMoneyUtil", com.tencent.mm.compatible.util.f.apq() + "insert msg failed :" + aC);
            AppMethodBeat.o(65267);
            return false;
        }
        if (caVar.dOQ()) {
            com.tencent.mm.modelstat.b.jmd.b(caVar, com.tencent.mm.ag.l.t(caVar));
        } else {
            com.tencent.mm.modelstat.b.jmd.s(caVar);
        }
        caVar.setMsgId(aC);
        k kVar = new k();
        kVar.field_xml = caVar.field_content;
        String processXml = Util.processXml(str);
        k.b bVar = null;
        if (!(processXml == null || (bVar = k.b.aD(processXml, caVar.field_reserved)) == null)) {
            kVar.field_title = bVar.title;
            kVar.field_description = bVar.description;
        }
        kVar.field_type = 2001;
        kVar.field_msgId = aC;
        if (bVar != null && bVar.type == 2001 && bVar.dDG == 1) {
            if (TextUtils.isEmpty(bVar.iyu) || TextUtils.isEmpty(bVar.iyv) || bVar.iyw <= 0) {
                Log.e("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! don't send predownload image event, because image preload data is illegal!");
            } else {
                Log.i("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! send predownload image event!");
                av avVar = new av();
                avVar.dDS = new av.a();
                avVar.dDS.dDU = bVar.iyv;
                avVar.dDS.dDT = bVar.iyu;
                avVar.dDS.dDV = bVar.iyw;
                EventCenter.instance.publish(avVar);
            }
        }
        k GL = com.tencent.mm.plugin.r.a.eAT().GL(aC);
        if (GL != null && GL.field_msgId == aC) {
            com.tencent.mm.plugin.r.a.eAT().update(kVar, new String[0]);
        } else if (!com.tencent.mm.plugin.r.a.eAT().insert(kVar)) {
            Log.e("MicroMsg.LuckyMoneyUtil", "PinOpenApi.getAppMessageStorage().insert msg failed id:".concat(String.valueOf(aC)));
        }
        AppMethodBeat.o(65267);
        return true;
    }

    public static boolean a(Activity activity, int i2, com.tencent.mm.ak.q qVar, Bundle bundle, boolean z, DialogInterface.OnClickListener onClickListener, d.a aVar, int i3) {
        AppMethodBeat.i(213313);
        Log.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr call");
        if (i2 != 416) {
            Log.i("MicroMsg.LuckyMoneyUtil", "don't need realname verify");
            AppMethodBeat.o(213313);
            return false;
        }
        boolean a2 = a(activity, qVar, bundle, z, aVar, i3);
        AppMethodBeat.o(213313);
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0109  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(android.app.Activity r10, com.tencent.mm.ak.q r11, android.os.Bundle r12, boolean r13, com.tencent.mm.wallet_core.d.a r14, int r15) {
        /*
        // Method dump skipped, instructions count: 267
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.luckymoney.model.af.a(android.app.Activity, com.tencent.mm.ak.q, android.os.Bundle, boolean, com.tencent.mm.wallet_core.d$a, int):boolean");
    }

    public static String aDx(String str) {
        AppMethodBeat.i(65270);
        if (Util.isNullOrNil(str) || !g.aAc()) {
            AppMethodBeat.o(65270);
            return "";
        }
        g.aAi();
        o oVar = new o(String.format("%s/%s/", g.aAh().hqG, "LuckyMoney"));
        if (!oVar.exists() || !oVar.isDirectory()) {
            oVar.mkdirs();
        }
        String z = aa.z(new o(oVar, str).her());
        AppMethodBeat.o(65270);
        return z;
    }

    public static String fr(List<bg> list) {
        AppMethodBeat.i(65271);
        if (list == null || list.size() == 0) {
            Log.e("MicroMsg.LuckyMoneyUtil", "splitOperationField is empty!");
            AppMethodBeat.o(65271);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            bg bgVar = list.get(i2);
            if (bgVar != null) {
                if (i2 != 0) {
                    sb.append("|");
                }
                sb.append(bgVar.type);
                sb.append("|");
                sb.append(bgVar.name);
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(65271);
        return sb2;
    }

    public static void iB(String str, String str2) {
        AppMethodBeat.i(65272);
        if (!Util.isNullOrNil(str) && !Util.isNullOrNil(str2)) {
            ca caVar = new ca();
            caVar.nv(0);
            caVar.Cy(str2);
            caVar.setStatus(3);
            caVar.setContent(str);
            caVar.setCreateTime(bp.C(str2, System.currentTimeMillis() / 1000));
            caVar.setType(10000);
            ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(caVar);
        }
        AppMethodBeat.o(65272);
    }

    public static Dialog gu(Context context) {
        AppMethodBeat.i(65273);
        com.tencent.mm.ui.base.q a2 = h.a(context, 3, (int) R.style.lj, context.getString(R.string.ekc), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.luckymoney.model.af.AnonymousClass3 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        AppMethodBeat.o(65273);
        return a2;
    }

    public static void s(TextView textView) {
        AppMethodBeat.i(163577);
        textView.setShadowLayer(8.0f, 0.0f, 0.0f, MMApplicationContext.getContext().getResources().getColor(R.color.fp));
        AppMethodBeat.o(163577);
    }

    public static boolean IA(String str) {
        AppMethodBeat.i(213314);
        boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_rtx_union_luckymoney_open_config, false);
        Log.i("MicroMsg.LuckyMoneyUtil", "union luckymoney logic：OpenUnionLuckyMoney switch is ：%s", Boolean.valueOf(a2));
        if (a2) {
            boolean IA = ab.IA(str);
            AppMethodBeat.o(213314);
            return IA;
        }
        AppMethodBeat.o(213314);
        return false;
    }

    public static boolean rQ(int i2) {
        AppMethodBeat.i(213315);
        boolean rQ = ab.rQ(i2);
        AppMethodBeat.o(213315);
        return rQ;
    }

    public static void r(ImageView imageView, String str) {
        AppMethodBeat.i(65248);
        a(imageView, str, (String) null, true);
        AppMethodBeat.o(65248);
    }

    public static void o(ImageView imageView, String str) {
        AppMethodBeat.i(65251);
        a(imageView, str, (String) null, false);
        AppMethodBeat.o(65251);
    }
}
