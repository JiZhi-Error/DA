package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.LinkedList;
import java.util.List;

public class WxaBindBizInfoView extends LinearLayout {
    private static int olJ = a.fromDPToPix(MMApplicationContext.getContext(), 15);
    private static int olK = a.fromDPToPix(MMApplicationContext.getContext(), 30);
    private ImageView lIM;
    private TextView mPa;
    private List<WxaAttributes.WxaEntryInfo> olD;
    private View olE;
    private TextView olF;
    private LinearLayout olG;
    private ViewGroup olH;
    private View olI;

    public WxaBindBizInfoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(49374);
        init();
        AppMethodBeat.o(49374);
    }

    public WxaBindBizInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(49375);
        init();
        AppMethodBeat.o(49375);
    }

    private void init() {
        AppMethodBeat.i(49376);
        this.olD = new LinkedList();
        View inflate = View.inflate(getContext(), R.layout.ew, this);
        this.olE = inflate.findViewById(R.id.d59);
        this.lIM = (ImageView) inflate.findViewById(R.id.dtd);
        this.mPa = (TextView) inflate.findViewById(R.id.ipq);
        this.olF = (TextView) inflate.findViewById(R.id.bga);
        this.olI = inflate.findViewById(R.id.fjr);
        this.olG = (LinearLayout) inflate.findViewById(R.id.be5);
        this.olH = (ViewGroup) inflate.findViewById(R.id.e1w);
        AppMethodBeat.o(49376);
    }

    static {
        AppMethodBeat.i(49377);
        AppMethodBeat.o(49377);
    }

    public List<WxaAttributes.WxaEntryInfo> getWxaEntryInfoList() {
        return this.olD;
    }
}
