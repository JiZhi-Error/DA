package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.ViewGroup;
import com.facebook.internal.NativeProtocol;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class p extends m {
    protected g.a Edn;
    int clickCount = 0;

    public p(Context context, z zVar, ViewGroup viewGroup) {
        super(context, zVar, viewGroup);
        ah fds = fds();
        String nullAsNil = Util.nullAsNil(fds.uxInfo);
        int i2 = fds.DZU;
        int i3 = fds.source;
        long safeParseLong = Util.safeParseLong(fds.lAN);
        int i4 = zVar.subType;
        String nullAsNil2 = Util.nullAsNil(fds.getViewId());
        String nullAsNil3 = Util.nullAsNil(fds.fcN());
        String nullAsNil4 = Util.nullAsNil(zVar.DZi);
        String nullAsNil5 = Util.nullAsNil(zVar.DZv);
        this.Edn = new g.a(nullAsNil, i3, i2, safeParseLong, i4, nullAsNil2, nullAsNil3);
        ku(nullAsNil4, nullAsNil5);
    }

    /* access modifiers changed from: protected */
    public final void fdw() {
        this.clickCount++;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWX() {
        ViewGroup.LayoutParams layoutParams = this.contentView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins((int) this.EcX.paddingLeft, (int) this.EcX.paddingTop, (int) this.EcX.paddingRight, (int) this.EcX.paddingBottom);
        }
        this.contentView.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final boolean bp(JSONObject jSONObject) {
        int i2;
        if (!super.bp(jSONObject)) {
            return false;
        }
        try {
            jSONObject.put("clickCount", this.clickCount);
            z zVar = this.EcX;
            if (zVar != null) {
                i2 = zVar.subType;
            } else {
                i2 = 0;
            }
            jSONObject.putOpt("subType", Integer.valueOf(i2));
            return true;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.Sns.AdLandingPageBtnBaseComp", e2, "", new Object[0]);
            return false;
        }
    }

    public final void a(z zVar, ah ahVar) {
        if (ahVar != null && zVar != null && this.Edn != null) {
            String nullAsNil = Util.nullAsNil(ahVar.uxInfo);
            int i2 = ahVar.DZU;
            int i3 = ahVar.source;
            long safeParseLong = Util.safeParseLong(ahVar.lAN);
            int i4 = zVar.subType;
            String nullAsNil2 = Util.nullAsNil(ahVar.getViewId());
            String nullAsNil3 = Util.nullAsNil(ahVar.fcN());
            String nullAsNil4 = Util.nullAsNil(zVar.DZi);
            String nullAsNil5 = Util.nullAsNil(zVar.DZv);
            g.a aVar = this.Edn;
            try {
                aVar.Ecy.h("uxinfo", nullAsNil);
                aVar.Ecy.U("scene", i3);
                aVar.Ecy.U("originScene", i2);
                aVar.Ecy.v("canvasId", safeParseLong);
                aVar.Ecy.U("type", 21);
                aVar.Ecy.U("subType", i4);
                aVar.Ecy.U(NativeProtocol.WEB_DIALOG_ACTION, 1);
                if (!Util.isNullOrNil(nullAsNil2, nullAsNil3)) {
                    aVar.Ecy.h("viewid", nullAsNil2);
                    aVar.Ecy.h("commInfo", nullAsNil3);
                }
            } catch (Exception e2) {
                Log.e("NetSceneAdLadingPageClick", "updateRetInfo exp=" + e2.toString());
            }
            ku(nullAsNil4, nullAsNil5);
        }
    }

    /* access modifiers changed from: protected */
    public void fdf() {
        this.Edn.report("13387");
    }

    private void ku(String str, String str2) {
        if (this.Edn != null) {
            this.Edn.kv("cid", str);
            this.Edn.kv("jumpExtInfo", str2);
        }
    }
}
