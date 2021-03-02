package com.tencent.mm.plugin.websearch.widget.view.footer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.aa;

public class MoreFooter extends LinearLayout {
    private Context context;
    private View gvQ;
    private TextView hbb;

    public MoreFooter(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(116759);
        this.context = context2;
        ViewGroup viewGroup = (ViewGroup) aa.jQ(this.context).inflate(R.layout.cci, this);
        this.hbb = (TextView) viewGroup.findViewById(R.id.ior);
        this.gvQ = viewGroup.findViewById(R.id.h8v);
        AppMethodBeat.o(116759);
    }

    public void setTitle(String str) {
        AppMethodBeat.i(116760);
        this.hbb.setText(str);
        AppMethodBeat.o(116760);
    }

    public void setOnClickLsn(View.OnClickListener onClickListener) {
        AppMethodBeat.i(116761);
        this.gvQ.setOnClickListener(onClickListener);
        AppMethodBeat.o(116761);
    }
}
