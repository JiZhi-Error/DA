package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.widget.SnsRatioView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ax implements View.OnClickListener {
    private c Dyw;
    private View EwT;
    private TextView EwU;
    private TextView EwV;
    private TextView EwW;
    private View EwX;
    private Button EwY;
    private Button EwZ;
    private View Exa;
    private SnsRatioView Exb;
    private TextView Exc;
    private TextView Exd;
    private SnsInfo Exe;
    private int Exf = Color.parseColor("#1A000000");
    private int Exg = Color.parseColor("#FFFFFFFF");
    private int Exh = Color.parseColor("#E6000000");
    private int Exi = Color.parseColor("#4D000000");
    private Context mContext;

    public ax(Context context, View view, c cVar) {
        AppMethodBeat.i(98302);
        this.mContext = context;
        this.Dyw = cVar;
        this.EwT = view.findViewById(R.id.jcv);
        this.Exf = context.getResources().getColor(R.color.a8p);
        this.Exg = context.getResources().getColor(R.color.a8m);
        this.Exh = context.getResources().getColor(R.color.a8q);
        this.Exi = context.getResources().getColor(R.color.a8n);
        this.EwU = (TextView) view.findViewById(R.id.jcz);
        this.EwV = (TextView) view.findViewById(R.id.jcx);
        this.EwW = (TextView) view.findViewById(R.id.jcw);
        this.EwX = view.findViewById(R.id.jcs);
        this.EwY = (Button) view.findViewById(R.id.jct);
        this.EwZ = (Button) view.findViewById(R.id.jcu);
        this.Exa = view.findViewById(R.id.grg);
        this.Exb = (SnsRatioView) view.findViewById(R.id.jcy);
        this.Exc = (TextView) view.findViewById(R.id.jd0);
        this.Exd = (TextView) view.findViewById(R.id.jd1);
        this.EwY.setOnClickListener(this);
        this.EwZ.setOnClickListener(this);
        int fromDPToPix = a.fromDPToPix(MMApplicationContext.getContext(), 4);
        int fromDPToPix2 = a.fromDPToPix(MMApplicationContext.getContext(), 8);
        int fromDPToPix3 = a.fromDPToPix(MMApplicationContext.getContext(), 8);
        SnsRatioView snsRatioView = this.Exb;
        snsRatioView.FfR.setAntiAlias(true);
        snsRatioView.FfS.setAntiAlias(true);
        snsRatioView.FfL = fromDPToPix;
        snsRatioView.FfO = Math.max(fromDPToPix, fromDPToPix3);
        snsRatioView.FfM = 70;
        snsRatioView.FfN = fromDPToPix2;
        snsRatioView.FfT[0] = (float) fromDPToPix;
        snsRatioView.FfT[1] = (float) fromDPToPix;
        snsRatioView.FfT[2] = (float) fromDPToPix;
        snsRatioView.FfT[3] = (float) fromDPToPix;
        snsRatioView.FfT[4] = (float) fromDPToPix;
        snsRatioView.FfT[5] = (float) fromDPToPix;
        snsRatioView.FfT[6] = (float) fromDPToPix;
        snsRatioView.FfT[7] = (float) fromDPToPix;
        AppMethodBeat.o(98302);
    }

    public final void a(SnsInfo snsInfo, Object obj) {
        ADInfo.d dVar;
        AppMethodBeat.i(98303);
        try {
            this.EwY.setTag(obj);
            this.EwZ.setTag(obj);
            this.Exe = snsInfo;
            ADXml adXml = snsInfo.getAdXml();
            ADXml.l lVar = snsInfo.getAdXml().adVoteInfo;
            String uxinfo = snsInfo.getUxinfo();
            String str = lVar.DWX;
            int kN = y.kN(str, uxinfo);
            boolean z = kN > 0;
            ADInfo.d kR = kR(str, uxinfo);
            if (kR == null) {
                Log.i("SnsAdCardVoteCtrl", "fillVoteInfoView, web voteResult == null, snsId=" + snsInfo.getSnsId());
                dVar = snsInfo.getAdInfo().adVoteInfoExt;
            } else {
                Log.i("SnsAdCardVoteCtrl", "fillVoteInfoView, web voteResult != null, snsId=" + snsInfo.getSnsId());
                dVar = kR;
            }
            if (!TextUtils.isEmpty(adXml.adCardDesc)) {
                this.EwW.setText(adXml.adCardDesc);
                this.EwW.setVisibility(0);
            } else {
                this.EwW.setVisibility(8);
            }
            if (!TextUtils.isEmpty(lVar.DWY)) {
                this.EwV.setText(lVar.DWY);
                this.EwV.setVisibility(0);
            } else {
                this.EwV.setVisibility(8);
            }
            if (!TextUtils.isEmpty(adXml.adCardTitle)) {
                this.EwU.setText(adXml.adCardTitle);
                this.EwU.setVisibility(0);
            } else {
                this.EwU.setVisibility(8);
                this.EwV.setVisibility(8);
            }
            String str2 = lVar.DWZ.get(0).id;
            String str3 = lVar.DWZ.get(1).id;
            String YS = lVar.YS(0);
            String YS2 = lVar.YS(1);
            if (z) {
                int kr = dVar.kr(str2, str3);
                int i2 = 100 - kr;
                this.EwX.setVisibility(8);
                this.Exa.setVisibility(0);
                SnsRatioView snsRatioView = this.Exb;
                snsRatioView.FfJ = kr;
                snsRatioView.FfK = i2;
                snsRatioView.FfJ = Math.max(0, snsRatioView.FfJ);
                snsRatioView.FfJ = Math.min(100, snsRatioView.FfJ);
                snsRatioView.FfK = Math.max(0, snsRatioView.FfK);
                snsRatioView.FfK = Math.min(100, snsRatioView.FfK);
                if (snsRatioView.FfJ + snsRatioView.FfK != 100) {
                    snsRatioView.FfK = 100 - snsRatioView.FfJ;
                }
                snsRatioView.invalidate();
                this.Exc.setText(YS + " " + kr + "%");
                this.Exd.setText(i2 + "% " + YS2);
                if (kN == 1) {
                    this.Exb.iZ(this.Exf, this.Exg);
                    this.Exc.setTextColor(this.Exh);
                    this.Exd.setTextColor(this.Exi);
                    AppMethodBeat.o(98303);
                    return;
                }
                this.Exb.iZ(this.Exg, this.Exf);
                this.Exc.setTextColor(this.Exi);
                this.Exd.setTextColor(this.Exh);
                AppMethodBeat.o(98303);
                return;
            }
            this.EwX.setVisibility(0);
            this.Exa.setVisibility(8);
            this.EwY.setText(YS);
            this.EwZ.setText(YS2);
            AppMethodBeat.o(98303);
        } catch (Exception e2) {
            Log.e("SnsAdCardVoteCtrl", "fillVoteInfoView, exp:" + android.util.Log.getStackTraceString(e2));
            AppMethodBeat.o(98303);
        }
    }

    public final void fgQ() {
        AppMethodBeat.i(98305);
        if (this.EwT.getVisibility() != 0) {
            this.EwT.setVisibility(0);
        }
        AppMethodBeat.o(98305);
    }

    public final void fgR() {
        AppMethodBeat.i(98306);
        if (this.EwT.getVisibility() != 8) {
            this.EwT.setVisibility(8);
        }
        AppMethodBeat.o(98306);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(98307);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdCardVoteCtrl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view == this.EwY) {
            this.Dyw.Fbb.onClick(view);
        } else if (view == this.EwZ) {
            this.Dyw.Fbc.onClick(view);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdCardVoteCtrl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98307);
    }

    private static ADInfo.d kR(String str, String str2) {
        AppMethodBeat.i(98304);
        long currentTimeMillis = System.currentTimeMillis();
        g.aAf();
        String ayV = com.tencent.mm.kernel.a.ayV();
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        sb.append(str);
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        if (ayV == null) {
            ayV = "";
        }
        sb.append(ayV);
        String str3 = "";
        if (sb.length() > 0) {
            str3 = MMApplicationContext.getContext().getSharedPreferences("SnsAdVote", 0).getString(sb.toString() + "_voteRet", "");
        } else {
            Log.e("StorageHelper", "getSnsAdVoteResultInfo, key is empty");
        }
        Log.i("StorageHelper", "getSnsAdVoteResultInfo, ret=" + str3 + ", timeCost=" + (System.currentTimeMillis() - currentTimeMillis));
        try {
            if (!TextUtils.isEmpty(str3)) {
                JSONArray jSONArray = new JSONArray(str3);
                if (jSONArray.length() == 0) {
                    AppMethodBeat.o(98304);
                    return null;
                }
                ADInfo.d dVar = new ADInfo.d();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    ADInfo.e eVar = new ADInfo.e();
                    eVar.id = jSONObject.optString("id");
                    eVar.DWg = jSONObject.optInt("scoring");
                    eVar.DWh = jSONObject.optInt(NativeProtocol.AUDIENCE_FRIENDS);
                    JSONArray optJSONArray = jSONObject.optJSONArray("friendsList");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                            eVar.DWi.add(optJSONArray.getString(i3));
                        }
                    }
                    dVar.DWf.add(eVar);
                }
                AppMethodBeat.o(98304);
                return dVar;
            }
        } catch (Exception e2) {
            Log.e("SnsAdCardVoteCtrl", "getAdVoteInfoExtFromWebUpdate, exp=" + e2.toString());
        }
        AppMethodBeat.o(98304);
        return null;
    }
}
