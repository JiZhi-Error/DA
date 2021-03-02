package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class NearLifeErrorContent extends FrameLayout {
    private TextView ACw;
    private View ACx;
    private View contentView;
    private ListView hUI;
    private Context mContext;

    public NearLifeErrorContent(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(26616);
        this.mContext = context;
        init();
        AppMethodBeat.o(26616);
    }

    public NearLifeErrorContent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(26617);
        this.mContext = context;
        init();
        AppMethodBeat.o(26617);
    }

    private void init() {
        AppMethodBeat.i(26618);
        this.contentView = View.inflate(this.mContext, R.layout.bev, this);
        this.ACw = (TextView) this.contentView.findViewById(R.id.ftx);
        this.ACx = this.contentView.findViewById(R.id.fuh);
        AppMethodBeat.o(26618);
    }

    public void setListView(ListView listView) {
        this.hUI = listView;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void Tx(int i2) {
        AppMethodBeat.i(26619);
        switch (i2) {
            case 0:
                this.ACw.setVisibility(8);
                this.ACx.setVisibility(8);
                this.hUI.setVisibility(0);
                AppMethodBeat.o(26619);
                return;
            case 1:
                this.ACw.setVisibility(0);
                this.ACx.setVisibility(8);
                this.hUI.setVisibility(8);
                AppMethodBeat.o(26619);
                return;
            case 2:
                this.ACw.setVisibility(8);
                this.ACx.setVisibility(0);
                this.hUI.setVisibility(8);
                break;
        }
        AppMethodBeat.o(26619);
    }
}
