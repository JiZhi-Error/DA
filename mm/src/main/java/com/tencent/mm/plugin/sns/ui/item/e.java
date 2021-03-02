package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.f;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.sns.ad.i.b;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import org.json.JSONObject;

public final class e {
    public static void a(final ADXml.g gVar, final int i2, final ImageView imageView, final ImageView imageView2) {
        AppMethodBeat.i(100072);
        if (gVar == null) {
            AppMethodBeat.o(100072);
            return;
        }
        final int i3 = gVar.DWB;
        final int i4 = gVar.DWD;
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.item.e.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(203920);
                Log.d("FullCardAdUtils", "curPlayTime:" + i2 + ", disppear=" + gVar.DWB + ", appear=" + gVar.DWD);
                try {
                    if (!TextUtils.isEmpty(gVar.DWA)) {
                        b.j(gVar.DWA, imageView);
                        if (i2 >= i3 && i3 > 0) {
                            ImageView imageView = imageView;
                            if (imageView.getVisibility() == 0) {
                                Log.d("FullCardAdUtils", "animHideView:" + imageView.hashCode());
                                imageView.setVisibility(4);
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                                alphaAnimation.setDuration(300);
                                imageView.startAnimation(alphaAnimation);
                            }
                        } else if (imageView.getVisibility() != 0) {
                            imageView.setVisibility(0);
                            Log.d("FullCardAdUtils", "show frontCoverIv, hash=" + imageView.hashCode());
                        }
                    } else {
                        e.l(imageView);
                    }
                    if (!TextUtils.isEmpty(gVar.DWC)) {
                        b.j(gVar.DWC, imageView2);
                        if (i2 >= i4) {
                            ImageView imageView2 = imageView2;
                            if (imageView2.getVisibility() != 0) {
                                Log.d("FullCardAdUtils", "animShowView:" + imageView2.hashCode());
                                imageView2.setVisibility(0);
                                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                                alphaAnimation2.setDuration(300);
                                imageView2.startAnimation(alphaAnimation2);
                            }
                            AppMethodBeat.o(203920);
                            return;
                        } else if (imageView2.getVisibility() == 0) {
                            imageView2.setVisibility(4);
                            Log.d("FullCardAdUtils", "hide endCoverIv, hash=" + imageView2.hashCode());
                            AppMethodBeat.o(203920);
                            return;
                        }
                    } else {
                        e.l(imageView2);
                    }
                    AppMethodBeat.o(203920);
                } catch (Exception e2) {
                    Log.e("FullCardAdUtils", "checkCoverImageState exp=" + e2.toString());
                    AppMethodBeat.o(203920);
                }
            }
        });
        AppMethodBeat.o(100072);
    }

    static void l(ImageView imageView) {
        AppMethodBeat.i(160748);
        imageView.setVisibility(4);
        imageView.setImageDrawable(null);
        imageView.setTag(R.id.hu3, "");
        AppMethodBeat.o(160748);
    }

    public static void l(String str, ImageView imageView) {
        AppMethodBeat.i(160749);
        if (TextUtils.isEmpty(str)) {
            l(imageView);
            AppMethodBeat.o(160749);
            return;
        }
        if (!str.equals((String) imageView.getTag(R.id.hu3))) {
            imageView.setImageDrawable(null);
        }
        AppMethodBeat.o(160749);
    }

    public static void a(int i2, float f2, float f3, String str, String str2, int i3) {
        AppMethodBeat.i(176418);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("result", i2);
            jSONObject2.put(FirebaseAnalytics.b.SCORE, (double) f2);
            jSONObject2.put("targetScore", (double) f3);
            jSONObject.put(IssueStorage.COLUMN_EXT_INFO, jSONObject2);
            jSONObject.put("uxinfo", str);
            jSONObject.put("snsId", str2);
            jSONObject.put("scene", i3);
            k.jY("16552", jSONObject.toString());
            AppMethodBeat.o(176418);
        } catch (Exception e2) {
            Log.e("FullCardAdUtils", "gestureCgiReport exp=" + e2.toString());
            AppMethodBeat.o(176418);
        }
    }

    public static void a(Context context, View view, SnsInfo snsInfo, int i2) {
        AppMethodBeat.i(179353);
        try {
            Log.i("FullCardAdUtils", "openGestureLandingPage, source=" + i2 + ", snsId=" + snsInfo.field_snsId);
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            Intent intent = new Intent();
            intent.putExtra("img_gallery_left", iArr[0]);
            intent.putExtra("img_gallery_top", iArr[1]);
            intent.putExtra("img_gallery_width", view.getWidth());
            intent.putExtra("img_gallery_height", view.getHeight());
            intent.putExtra("sns_landing_pages_share_sns_id", snsInfo.getSnsId());
            intent.putExtra("sns_landing_pages_rawSnsId", snsInfo.getTimeLine().Id);
            intent.putExtra("sns_landing_pages_ux_info", snsInfo.getUxinfo());
            String gestureCanvasInfo = snsInfo.getAdXml().getGestureCanvasInfo();
            if (!i.kG(snsInfo.getAdXml().xml, "adFullCardGestureCanvasInfo")) {
                gestureCanvasInfo.replaceAll("(?s)<adFullCardGestureCanvasInfo[^>]*>.*?</adFullCardGestureCanvasInfo>", "");
            }
            intent.putExtra("sns_landing_pages_xml", gestureCanvasInfo);
            intent.setClass(context, SnsAdNativeLandingPagesUI.class);
            intent.putExtra("sns_landig_pages_from_source", i2);
            intent.putExtra("sns_landing_pages_xml_prefix", f.COL_ADXML);
            if (!snsInfo.getAdXml().forbiddenCustomAnimation) {
                intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
            }
            intent.putExtra("sns_landing_is_native_sight_ad", true);
            if (snsInfo.isTwistAd()) {
                intent.putExtra("sns_landing_page_is_gesture_twist_ad", true);
            }
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/sns/ui/item/FullCardAdItemUtils", "openGestureLandingPage", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/sns/ui/item/FullCardAdItemUtils", "openGestureLandingPage", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            if (!snsInfo.getAdXml().forbiddenCustomAnimation && (context instanceof Activity)) {
                ((Activity) context).overridePendingTransition(0, 0);
            }
            AppMethodBeat.o(179353);
        } catch (Exception e2) {
            Log.e("FullCardAdUtils", "openGestureLandingPage, exp=" + e2.toString());
            AppMethodBeat.o(179353);
        }
    }

    public static boolean fkr() {
        AppMethodBeat.i(179354);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ad_fullcard_video_new_player, 0);
        Log.i("FullCardAdUtils", "isExptUseNewPlayer, value=".concat(String.valueOf(a2)));
        if (a2 > 0) {
            AppMethodBeat.o(179354);
            return true;
        }
        AppMethodBeat.o(179354);
        return false;
    }
}
