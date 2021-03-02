package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ae.a;
import com.tencent.mm.sdk.platformtools.Log;

public class MMFormSelectorView extends LinearLayout {
    private String hint;
    private TextView jVO;
    private int layout;
    private Context mContext;
    private EditText nBD;
    private String title;

    @TargetApi(11)
    public MMFormSelectorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        AppMethodBeat.i(141926);
        this.mContext = null;
        this.layout = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0244a.FormItemView, i2, 0);
        int resourceId = obtainStyledAttributes.getResourceId(3, 0);
        if (resourceId != 0) {
            this.title = context.getString(resourceId);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        if (resourceId2 != 0) {
            this.hint = context.getString(resourceId2);
        }
        this.layout = obtainStyledAttributes.getResourceId(2, this.layout);
        obtainStyledAttributes.recycle();
        inflate(context, this.layout, this);
        this.mContext = context;
        AppMethodBeat.o(141926);
    }

    public MMFormSelectorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setTitle(String str) {
        AppMethodBeat.i(141928);
        if (this.jVO != null) {
            this.jVO.setText(str);
            AppMethodBeat.o(141928);
            return;
        }
        Log.e("MicroMsg.MMFormSelectorView", "titleTV is null!");
        AppMethodBeat.o(141928);
    }

    public void setHint(String str) {
        AppMethodBeat.i(141929);
        if (this.nBD != null) {
            this.nBD.setHint(str);
            AppMethodBeat.o(141929);
            return;
        }
        Log.e("MicroMsg.MMFormSelectorView", "contentET is null!");
        AppMethodBeat.o(141929);
    }

    public void setTitle(int i2) {
        AppMethodBeat.i(141930);
        if (this.jVO != null) {
            this.jVO.setText(i2);
            AppMethodBeat.o(141930);
            return;
        }
        Log.e("MicroMsg.MMFormSelectorView", "titleTV is null!");
        AppMethodBeat.o(141930);
    }

    public void setHint(int i2) {
        AppMethodBeat.i(141931);
        if (this.nBD != null) {
            this.nBD.setHint(i2);
            AppMethodBeat.o(141931);
            return;
        }
        Log.e("MicroMsg.MMFormSelectorView", "contentET is null!");
        AppMethodBeat.o(141931);
    }

    public void setText(String str) {
        AppMethodBeat.i(141932);
        if (this.nBD != null) {
            this.nBD.setText(str);
            AppMethodBeat.o(141932);
            return;
        }
        Log.e("MicroMsg.MMFormSelectorView", "contentET is null!");
        AppMethodBeat.o(141932);
    }

    public String getText() {
        AppMethodBeat.i(141933);
        if (this.nBD != null) {
            String obj = this.nBD.getText().toString();
            AppMethodBeat.o(141933);
            return obj;
        }
        Log.e("MicroMsg.MMFormSelectorView", "contentET is null!");
        AppMethodBeat.o(141933);
        return null;
    }

    public void onFinishInflate() {
        AppMethodBeat.i(141927);
        this.jVO = (TextView) findViewById(R.id.ipm);
        this.nBD = (EditText) findViewById(R.id.bxz);
        if (this.jVO == null || this.nBD == null) {
            Log.w("MicroMsg.MMFormSelectorView", "titleTV : %s, contentET : %s", this.jVO, this.nBD);
            AppMethodBeat.o(141927);
            return;
        }
        if (this.title != null) {
            this.jVO.setText(this.title);
        }
        if (this.hint != null) {
            this.nBD.setHint(this.hint);
        }
        AppMethodBeat.o(141927);
    }
}
