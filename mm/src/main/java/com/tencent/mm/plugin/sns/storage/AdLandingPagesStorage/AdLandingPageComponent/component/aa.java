package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class aa extends q {
    public aa(Context context, l lVar, ViewGroup viewGroup) {
        super(context, lVar, viewGroup);
        AppMethodBeat.i(96660);
        this.Edn.kv("canvasId", lVar.DYd);
        this.Edn.kv("canvasExt", lVar.DYe);
        AppMethodBeat.o(96660);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q
    public final void fde() {
        int i2;
        AppMethodBeat.i(96661);
        l lVar = (l) fdx();
        if (this.Edr) {
            i2 = 20;
        } else {
            i2 = 14;
        }
        Context context = this.context;
        String str = lVar.DYd;
        String str2 = lVar.DYe;
        int i3 = lVar.DYf;
        Intent intent = new Intent();
        intent.putExtra("sns_landig_pages_from_source", i2);
        intent.putExtra("sns_landig_pages_origin_from_source", fds().DZU);
        intent.putExtra("sns_landing_pages_xml", "");
        if (fdD()) {
            intent.putExtra("sns_landing_pages_canvasid", str);
            intent.putExtra("sns_landing_pages_canvas_ext", str2);
        } else {
            intent.putExtra("sns_landing_pages_pageid", Util.safeParseLong(str));
        }
        if (fdC()) {
            int[] iArr = new int[2];
            this.Edp.getLocationOnScreen(iArr);
            intent.putExtra("img_gallery_top", iArr[1]);
            intent.putExtra("img_gallery_left", iArr[0]);
            intent.putExtra("img_gallery_width", this.Edp.getWidth());
            intent.putExtra("img_gallery_height", this.Edp.getHeight());
        }
        intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", fdC());
        intent.putExtra("sns_landing_pages_extra", "");
        intent.putExtra("sns_landing_pages_no_store", i3);
        intent.putExtra("sns_landing_pages_ux_info", fds().uxInfo);
        intent.putExtra("sns_landing_is_native_sight_ad", fds().DZV);
        if ((context instanceof Activity) && fdD() && fds().bizId == 2) {
            String stringExtra = ((Activity) context).getIntent().getStringExtra("sns_landing_pages_sessionId");
            String stringExtra2 = ((Activity) context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
            if (!Util.isNullOrNil(stringExtra)) {
                String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sessionId", valueOf);
                    jSONObject.put("cid", fdx().DZi);
                    jSONObject.put("adBuffer", !Util.isNullOrNil(stringExtra2) ? stringExtra2 : "");
                    jSONObject.put("preSessionId", stringExtra);
                } catch (Exception e2) {
                }
                intent.putExtra("sns_landing_pages_search_extra", jSONObject.toString());
                intent.putExtra("sns_landing_pages_sessionId", valueOf);
                intent.putExtra("sns_landing_pages_ad_buffer", stringExtra2);
            }
        }
        if (context instanceof Activity) {
            String stringExtra3 = ((Activity) context).getIntent().getStringExtra("sns_landing_pages_rawSnsId");
            String stringExtra4 = ((Activity) context).getIntent().getStringExtra("sns_landing_pages_share_sns_id");
            intent.putExtra("sns_landing_pages_rawSnsId", stringExtra3);
            intent.putExtra("sns_landing_pages_share_sns_id", stringExtra4);
        }
        if (this.Eds && (context instanceof Activity)) {
            intent.putExtra("sns_landing_page_from_bonus", 1);
        }
        c.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
        fdy();
        fdf();
        AppMethodBeat.o(96661);
    }

    private boolean fdC() {
        AppMethodBeat.i(96662);
        if (((l) fdx()).DYg == 1) {
            AppMethodBeat.o(96662);
            return true;
        }
        AppMethodBeat.o(96662);
        return false;
    }

    private boolean fdD() {
        AppMethodBeat.i(96663);
        if (((l) fdx()).DYh == 1) {
            AppMethodBeat.o(96663);
            return true;
        }
        AppMethodBeat.o(96663);
        return false;
    }
}
