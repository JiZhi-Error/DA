package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.CustomFitTextView;

public class WalletPayUSecurityQuestionView extends LinearLayout {
    private TextView IuT;
    private CustomFitTextView IuU;
    private String IuV;
    private Context mContext;

    public WalletPayUSecurityQuestionView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        boolean z;
        String str;
        AppMethodBeat.i(72235);
        this.mContext = context;
        String str2 = "";
        String str3 = "";
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, a.C2011a.EditHintView, -1, 0);
            int resourceId = obtainStyledAttributes.getResourceId(13, 0);
            str2 = resourceId != 0 ? this.mContext.getString(resourceId) : str2;
            int resourceId2 = obtainStyledAttributes.getResourceId(8, 0);
            str3 = resourceId2 != 0 ? this.mContext.getString(resourceId2) : str3;
            boolean z2 = obtainStyledAttributes.getBoolean(2, false);
            obtainStyledAttributes.recycle();
            z = z2;
            str = str2;
        } else {
            z = false;
            str = str2;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.bhr, (ViewGroup) this, true);
        this.IuT = (TextView) inflate.findViewById(R.id.ior);
        this.IuU = (CustomFitTextView) inflate.findViewById(R.id.gfw);
        this.IuT.setText(str);
        CustomFitTextView customFitTextView = this.IuU;
        customFitTextView.a(str3, customFitTextView.maxLines, customFitTextView.Qqu, customFitTextView.Qqs, customFitTextView.getResources().getColor(R.color.uj));
        if (!z) {
            this.IuU.setEnabled(false);
            this.IuU.setFocusable(false);
            this.IuU.setClickable(false);
            this.IuU.setBackgroundResource(R.drawable.b0w);
            setBackgroundResource(R.drawable.b9w);
            AppMethodBeat.o(72235);
            return;
        }
        this.IuU.setEnabled(false);
        this.IuU.setTextColor(getResources().getColor(R.color.adw));
        this.IuU.setFocusable(false);
        this.IuU.setClickable(false);
        this.IuU.setBackgroundResource(R.drawable.b0w);
        setBackgroundResource(R.drawable.qa);
        AppMethodBeat.o(72235);
    }

    public WalletPayUSecurityQuestionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setQuestionText(String str) {
        AppMethodBeat.i(72236);
        this.IuV = str;
        KeyListener keyListener = this.IuU.getKeyListener();
        this.IuU.setInputType(1);
        this.IuU.setKeyListener(null);
        setValStr(str);
        this.IuU.setKeyListener(keyListener);
        AppMethodBeat.o(72236);
    }

    public String getCurrentQuestion() {
        return this.IuV;
    }

    public void setValStr(String str) {
        AppMethodBeat.i(72237);
        CustomFitTextView customFitTextView = this.IuU;
        customFitTextView.a(str, 3, false, -1, customFitTextView.getCurrentTextColor());
        AppMethodBeat.o(72237);
    }

    public final boolean bql() {
        AppMethodBeat.i(72238);
        if (!Util.isNullOrNil(this.IuV)) {
            AppMethodBeat.o(72238);
            return true;
        }
        AppMethodBeat.o(72238);
        return false;
    }
}
