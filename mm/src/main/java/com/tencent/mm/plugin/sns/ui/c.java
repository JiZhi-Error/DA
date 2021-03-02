package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class c extends BaseAdapter {
    public com.tencent.mm.plugin.sns.data.c Enq = null;
    public int lCq = 0;
    private final Context mContext;
    private String yFy = null;

    public c(Context context, com.tencent.mm.plugin.sns.data.c cVar) {
        AppMethodBeat.i(97694);
        this.mContext = context;
        this.Enq = cVar;
        this.yFy = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
        AppMethodBeat.o(97694);
    }

    public final int getCount() {
        AppMethodBeat.i(97695);
        if (this.lCq == 1) {
            int size = this.Enq.DDr.EQZ.adUnlikeInfo.fcH().size();
            AppMethodBeat.o(97695);
            return size;
        }
        int i2 = 0;
        if (this.Enq.DDr.EQY.adFeedbackInfo != null) {
            i2 = this.Enq.DDr.EQY.adFeedbackInfo.list.size();
        }
        int i3 = i2 + 1;
        AppMethodBeat.o(97695);
        return i3;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        String str;
        AppMethodBeat.i(97696);
        if (view == null) {
            view = View.inflate(this.mContext, R.layout.c_, null);
        }
        view.setTag(this.Enq);
        String str2 = "";
        if (this.lCq == 1) {
            ADInfo.c.a aVar = (ADInfo.c.a) getItem(i2);
            if (LocaleUtil.CHINA.equals(this.yFy)) {
                str2 = aVar.DWa;
            } else if (LocaleUtil.TAIWAN.equals(this.yFy) || LocaleUtil.HONGKONG.equals(this.yFy)) {
                str2 = aVar.DWb;
            } else {
                str2 = aVar.DWc;
            }
            if (Util.isNullOrNil(str2)) {
                str2 = aVar.DWc;
            }
        } else if (i2 != 0) {
            ADXml.e eVar = this.Enq.DDr.EQY.adFeedbackInfo;
            if (eVar != null && i2 <= eVar.list.size()) {
                ADXml.f fVar = eVar.list.get(i2 - 1);
                if (LocaleUtil.CHINA.equals(this.yFy)) {
                    str2 = fVar.DWu;
                } else if (LocaleUtil.TAIWAN.equals(this.yFy) || LocaleUtil.HONGKONG.equals(this.yFy)) {
                    str2 = fVar.DWv;
                } else {
                    str2 = fVar.DQp;
                }
                if (Util.isNullOrNil(str2)) {
                    str2 = fVar.DQp;
                }
            }
        } else if (!(this.Enq == null || this.Enq.DDr.EQY == null)) {
            ADInfo aDInfo = this.Enq.DDr.EQZ;
            if (LocaleUtil.CHINA.equals(this.yFy)) {
                str = aDInfo.adDislikeInfoTitle_cn;
            } else if (LocaleUtil.TAIWAN.equals(this.yFy) || LocaleUtil.HONGKONG.equals(this.yFy)) {
                str = aDInfo.adDislikeInfoTitle_tw;
            } else {
                str = aDInfo.adDislikeInfoTitle_en;
            }
            str2 = !Util.isNullOrNil(str) ? str : this.mContext.getString(R.string.h4p);
        }
        TextView textView = (TextView) view.findViewById(R.id.ga);
        if (this.Enq.DDr.EQZ.forbidClick) {
            textView.setTextColor(this.mContext.getResources().getColor(R.color.BW_0_Alpha_0_2));
        } else {
            textView.setTextColor(this.mContext.getResources().getColor(R.color.Link));
        }
        textView.setText(str2);
        view.findViewById(R.id.g_).setVisibility(i2 == getCount() + -1 ? 8 : 0);
        AppMethodBeat.o(97696);
        return view;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final Object getItem(int i2) {
        AppMethodBeat.i(97697);
        ADInfo.c.a aVar = this.Enq.DDr.EQZ.adUnlikeInfo.fcH().get(i2);
        AppMethodBeat.o(97697);
        return aVar;
    }
}
