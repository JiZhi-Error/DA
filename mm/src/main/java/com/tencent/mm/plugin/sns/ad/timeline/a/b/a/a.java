package com.tencent.mm.plugin.sns.ad.timeline.a.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.f;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.i.j;
import com.tencent.mm.plugin.sns.ad.timeline.a.b.b;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;

public final class a implements b {
    @Override // com.tencent.mm.plugin.sns.ad.timeline.a.c
    public final boolean a(View view, int i2, SnsInfo snsInfo, d dVar) {
        int i3;
        Intent intent;
        String str;
        AppMethodBeat.i(202103);
        if (view == null || snsInfo == null || snsInfo.getAdXml() == null) {
            AppMethodBeat.o(202103);
            return false;
        }
        ADXml adXml = snsInfo.getAdXml();
        if (!aNO(adXml.xml)) {
            AppMethodBeat.o(202103);
            return false;
        }
        String replaceAll = adXml.xml.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("headCanvasInfo", "adCanvasInfo");
        if (i2 == 0) {
            i3 = 22;
        } else {
            i3 = 23;
        }
        if (view == null || view.getContext() == null || snsInfo == null || TextUtils.isEmpty(replaceAll)) {
            intent = null;
        } else {
            Intent intent2 = new Intent();
            intent2.putExtra("sns_landing_pages_share_sns_id", snsInfo.getSnsId());
            if (snsInfo == null || snsInfo.getTimeLine() == null) {
                str = "";
            } else {
                str = snsInfo.getTimeLine().Id;
            }
            intent2.putExtra("sns_landing_pages_rawSnsId", str);
            intent2.putExtra("sns_landing_pages_ux_info", snsInfo.getUxinfo());
            intent2.putExtra("sns_landing_pages_xml", replaceAll);
            intent2.setClass(view.getContext(), SnsAdNativeLandingPagesUI.class);
            intent2.putExtra("sns_landig_pages_from_source", i3);
            intent2.putExtra("sns_landing_pages_xml_prefix", f.COL_ADXML);
            intent2.putExtra("sns_landing_is_native_sight_ad", true);
            intent = intent2;
        }
        boolean ap = ap(view.getContext(), intent);
        AppMethodBeat.o(202103);
        return ap;
    }

    @Override // com.tencent.mm.plugin.sns.ad.timeline.a.b.b
    public final void a(SnsInfo snsInfo, d dVar) {
        SnsAdClick snsAdClick;
        AppMethodBeat.i(202104);
        if (!(dVar == null || (snsAdClick = (SnsAdClick) dVar.z("ext_sns_ad_click", null)) == null)) {
            j.a(snsAdClick, 21);
            r.a(snsAdClick);
        }
        AppMethodBeat.o(202104);
    }

    private static boolean aNO(String str) {
        AppMethodBeat.i(202105);
        try {
            boolean kG = i.kG(str, "headCanvasInfo");
            AppMethodBeat.o(202105);
            return kG;
        } catch (Throwable th) {
            AppMethodBeat.o(202105);
            return false;
        }
    }

    private static boolean ap(Context context, Intent intent) {
        AppMethodBeat.i(202106);
        if (intent == null || context == null) {
            AppMethodBeat.o(202106);
            return false;
        }
        try {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/sns/ad/timeline/clicker/avatar/impl/AdCanvasAvatarAction", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                activity.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/sns/ad/timeline/clicker/avatar/impl/AdCanvasAvatarAction", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Activity) context).overridePendingTransition(R.anim.eq, R.anim.s);
            } else {
                intent.addFlags(268435456);
                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/mm/plugin/sns/ad/timeline/clicker/avatar/impl/AdCanvasAvatarAction", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/sns/ad/timeline/clicker/avatar/impl/AdCanvasAvatarAction", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            AppMethodBeat.o(202106);
            return true;
        } catch (Throwable th) {
            AppMethodBeat.o(202106);
            return false;
        }
    }
}
