package com.tencent.mm.plugin.location.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.MMImageButton;

public class ShareHeader extends LinearLayout {
    private Context mContext;
    private TextView titleTv;
    private ViewGroup yIF;
    private MMImageButton yIG;
    private MMImageButton yIH;

    @TargetApi(11)
    public ShareHeader(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(55885);
        this.mContext = context;
        init();
        AppMethodBeat.o(55885);
    }

    public ShareHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(55886);
        this.mContext = context;
        init();
        AppMethodBeat.o(55886);
    }

    private void init() {
        AppMethodBeat.i(55887);
        View inflate = View.inflate(this.mContext, R.layout.bs1, this);
        this.yIF = (ViewGroup) inflate.findViewById(R.id.do1);
        this.yIG = (MMImageButton) inflate.findViewById(R.id.iqn);
        this.yIH = (MMImageButton) inflate.findViewById(R.id.iqv);
        this.titleTv = (TextView) inflate.findViewById(R.id.ipm);
        AppMethodBeat.o(55887);
    }

    public ViewGroup getHeaderBar() {
        return this.yIF;
    }

    public void setOnLeftClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(55888);
        this.yIG.setOnClickListener(onClickListener);
        AppMethodBeat.o(55888);
    }

    public void setOnRightClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(55889);
        this.yIH.setOnClickListener(onClickListener);
        AppMethodBeat.o(55889);
    }

    public void setTitle(String str) {
        AppMethodBeat.i(55890);
        this.titleTv.setText(str);
        AppMethodBeat.o(55890);
    }

    public void setTitleColor(int i2) {
        AppMethodBeat.i(55891);
        this.titleTv.setTextColor(i2);
        AppMethodBeat.o(55891);
    }
}
