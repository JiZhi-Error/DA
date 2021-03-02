package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.ad.e.d;
import com.tencent.mm.plugin.sns.ad.e.h;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;

public final class bq {
    private LinearLayout EQQ;
    public TextView EQR;
    public View EQS;
    private TextView EQT;
    ImageView EQU;
    private ImageView EQV;
    private View EQW;
    private View EQX;
    public ADXml EQY;
    public ADInfo EQZ;
    private View view;
    private String yFy = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());

    public final String fjV() {
        if (this.EQZ == null || this.EQZ.uxInfo == null) {
            return "";
        }
        return this.EQZ.uxInfo;
    }

    public final int[] fjW() {
        AppMethodBeat.i(99718);
        int[] iArr = new int[2];
        if (this.EQQ != null) {
            this.EQW.getLocationInWindow(iArr);
            iArr[0] = iArr[0] + this.EQW.getMeasuredWidth() + a.fromDPToPix(this.EQW.getContext(), 5);
        } else if (this.EQW != null) {
            this.EQW.getLocationInWindow(iArr);
            iArr[0] = iArr[0] + this.EQW.getMeasuredWidth() + a.fromDPToPix(this.EQW.getContext(), 5);
        }
        AppMethodBeat.o(99718);
        return iArr;
    }

    public bq(View view2) {
        AppMethodBeat.i(99719);
        this.view = view2;
        Log.i("MicroMsg.TimeLineAdView", "adView init lan " + this.yFy);
        this.EQR = (TextView) this.view.findViewById(R.id.fk);
        this.EQT = (TextView) this.view.findViewById(R.id.fq);
        this.EQU = (ImageView) this.view.findViewById(R.id.fp);
        this.EQV = (ImageView) this.view.findViewById(R.id.fn);
        this.EQS = this.view.findViewById(R.id.fo);
        this.EQW = this.view.findViewById(R.id.fl);
        this.EQX = this.view.findViewById(R.id.fm);
        this.EQQ = (LinearLayout) this.view.findViewById(R.id.fj);
        this.EQR.setText(" " + this.view.getResources().getString(R.string.h4o) + " ");
        AppMethodBeat.o(99719);
    }

    public final void b(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        AppMethodBeat.i(99720);
        this.EQS.setOnClickListener(onClickListener);
        this.EQR.setOnClickListener(onClickListener2);
        if (this.EQW != null) {
            this.EQW.setOnClickListener(onClickListener2);
        }
        if (this.EQQ != null) {
            this.EQQ.setOnClickListener(onClickListener2);
        }
        AppMethodBeat.o(99720);
    }

    public final void N(Object obj, Object obj2) {
        AppMethodBeat.i(99721);
        this.EQS.setTag(obj);
        this.EQR.setTag(obj2);
        if (this.EQW != null) {
            this.EQW.setTag(obj2);
        }
        if (this.EQQ != null) {
            this.EQQ.setTag(obj2);
        }
        AppMethodBeat.o(99721);
    }

    public final void b(ADXml aDXml, ADInfo aDInfo) {
        String str;
        AppMethodBeat.i(99722);
        this.EQZ = aDInfo;
        this.EQY = aDXml;
        String str2 = "";
        if (aDXml != null) {
            if (LocaleUtil.CHINA.equals(this.yFy)) {
                str2 = aDXml.adActionLinkTitle_cn;
            } else if (LocaleUtil.TAIWAN.equals(this.yFy) || LocaleUtil.HONGKONG.equals(this.yFy)) {
                str2 = aDXml.adActionLinkTitle_tw;
            } else {
                str2 = aDXml.adActionLinkTitle_en;
            }
        }
        if (aDXml != null && Util.isNullOrNil(str2)) {
            str2 = aDXml.adActionLinkName;
        }
        Context context = this.EQT.getContext();
        if (Util.isNullOrNil(str2)) {
            str2 = context.getString(R.string.h4v);
        }
        this.EQT.setText(str2);
        this.EQV.setTag("");
        if (this.EQV.getVisibility() == 0) {
            this.EQV.setVisibility(4);
        }
        if (aDInfo != null && aDInfo.isWeapp()) {
            if (ao.isDarkMode()) {
                this.EQU.setImageResource(R.raw.album_ad_link_tag_weapp_dark);
                this.EQV.setImageResource(R.drawable.bx4);
            } else {
                this.EQU.setImageResource(R.raw.album_ad_link_tag_weapp);
                this.EQV.setImageResource(R.drawable.bx5);
            }
            if (aDXml != null && !aDXml.isFullCardAd() && !aDXml.isCardAd() && !aDXml.isSphereCardAd()) {
                d.f(aDInfo.actionExtWeApp.appUserName, this.EQV);
            }
        } else if (h.a(aDXml, aDInfo)) {
            if (ao.isDarkMode()) {
                this.EQU.setImageResource(R.raw.album_ad_finder_link_dark_icon);
            } else {
                this.EQU.setImageResource(R.raw.album_ad_finder_link_icon);
            }
        } else if (ao.isDarkMode()) {
            this.EQU.setImageResource(R.raw.album_advertise_link_dark_icon);
        } else {
            this.EQU.setImageResource(R.raw.album_advertise_link_icon);
        }
        if (!Util.isNullOrNil(aDXml.adActionLinkIcon)) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a("adId", aDXml.adActionLinkIcon, false, 41, new f.a() {
                /* class com.tencent.mm.plugin.sns.ui.bq.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWN() {
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWO() {
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void aNH(String str) {
                    AppMethodBeat.i(99717);
                    if (Util.isNullOrNil(str)) {
                        AppMethodBeat.o(99717);
                        return;
                    }
                    Drawable createFromPath = Drawable.createFromPath(str);
                    if (createFromPath != null) {
                        bq.this.EQU.setImageDrawable(createFromPath);
                    }
                    AppMethodBeat.o(99717);
                }
            });
        }
        if (aDInfo == null || Util.isNullOrNil(aDInfo.adActionPOIName)) {
            this.EQX.setVisibility(8);
        } else {
            this.EQX.setVisibility(0);
        }
        if (aDXml != null) {
            if (LocaleUtil.CHINA.equals(this.yFy)) {
                str = aDXml.expandOutsideTitle_cn;
            } else if (LocaleUtil.TAIWAN.equals(this.yFy) || LocaleUtil.HONGKONG.equals(this.yFy)) {
                str = aDXml.expandOutsideTitle_tw;
            } else {
                str = aDXml.expandOutsideTitle_en;
            }
            if (!Util.isNullOrNil(str)) {
                this.EQR.setText(str);
            }
        }
        AppMethodBeat.o(99722);
    }

    public final void setVisibility(int i2) {
        int i3;
        AppMethodBeat.i(99723);
        if (this.EQY == null || this.EQY.adActionLinkHidden != 1) {
            this.EQS.setVisibility(i2);
        } else {
            this.EQS.setVisibility(8);
        }
        com.tencent.mm.storage.a biB = com.tencent.mm.model.c.d.aXv().biB("Sns_CanvasAd_DetailLink_JumpWay");
        if (biB.isValid()) {
            i3 = Util.getInt(biB.field_value, -1);
        } else {
            i3 = -1;
        }
        if (i3 != -1 && this.EQY != null && this.EQY.isLandingPagesAd() && i.aQg(this.EQY.xml)) {
            this.EQS.setVisibility(i2);
        }
        this.EQR.setVisibility(i2);
        if (this.EQW != null) {
            this.EQW.setVisibility(i2);
        }
        if (this.EQQ != null) {
            this.EQQ.setVisibility(i2);
        }
        if (this.EQZ == null || Util.isNullOrNil(this.EQZ.adActionPOIName)) {
            this.EQX.setVisibility(8);
            AppMethodBeat.o(99723);
            return;
        }
        this.EQX.setVisibility(i2);
        AppMethodBeat.o(99723);
    }
}
