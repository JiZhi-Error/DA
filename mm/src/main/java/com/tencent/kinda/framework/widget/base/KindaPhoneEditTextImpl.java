package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.text.Editable;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.kinda.gen.ClearButtonMode;
import com.tencent.kinda.gen.KPhoneEditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.formview.b;

public class KindaPhoneEditTextImpl extends MMKEditText implements KPhoneEditText {
    private ClearButtonMode clearButtonMode = ClearButtonMode.WHILEEDITING;

    @Override // com.tencent.kinda.framework.widget.base.MMKEditText, com.tencent.kinda.framework.widget.base.MMKEditText, com.tencent.kinda.framework.widget.base.MMKView
    public LinearLayout createView(Context context) {
        AppMethodBeat.i(18915);
        LinearLayout createView = super.createView(context);
        if (context instanceof BaseFrActivity) {
            setMaxLength(11);
            ((BaseFrActivity) context).setEditFocusListener(this.editText, 0, false);
        }
        ViewGroup.LayoutParams layoutParams = this.editText.getLayoutParams();
        layoutParams.height = -2;
        this.editText.setLayoutParams(layoutParams);
        AppMethodBeat.o(18915);
        return createView;
    }

    @Override // com.tencent.kinda.framework.widget.base.MMKEditText, com.tencent.kinda.gen.KEditText
    public void setText(String str) {
        AppMethodBeat.i(18916);
        Log.d(MMKView.TAG, "KindaPhoneEditTextImpl setText ".concat(String.valueOf(str)));
        if (str != null && !getText().equals(str)) {
            this.editText.setText(str);
            if (str.contains("+")) {
                this.editText.setSelection(str.length());
            }
        }
        AppMethodBeat.o(18916);
    }

    @Override // com.tencent.kinda.framework.widget.base.MMKEditText, com.tencent.kinda.gen.KEditText
    public String getText() {
        AppMethodBeat.i(18917);
        Log.d(MMKView.TAG, "KindaPhoneEditTextImpl getText ");
        Editable text = this.editText.getText();
        if (text != null) {
            String charSequence = text.toString();
            AppMethodBeat.o(18917);
            return charSequence;
        }
        AppMethodBeat.o(18917);
        return null;
    }

    @Override // com.tencent.kinda.framework.widget.base.MMKEditText, com.tencent.kinda.gen.KEditText
    public void setFocus(boolean z) {
        AppMethodBeat.i(18918);
        if (z) {
            this.editText.requestFocus();
            AppMethodBeat.o(18918);
            return;
        }
        this.editText.clearFocus();
        AppMethodBeat.o(18918);
    }

    @Override // com.tencent.kinda.framework.widget.base.MMKEditText, com.tencent.kinda.gen.KEditText
    public boolean getFocus() {
        AppMethodBeat.i(18919);
        boolean isFocused = this.editText.isFocused();
        AppMethodBeat.o(18919);
        return isFocused;
    }

    @Override // com.tencent.kinda.framework.widget.base.MMKEditText, com.tencent.kinda.gen.KEditText
    public ClearButtonMode getClearButtonMode() {
        return this.clearButtonMode;
    }

    @Override // com.tencent.kinda.gen.KPhoneEditText
    public void showTip(String str, String str2) {
        AppMethodBeat.i(18920);
        b.e(this.mBaseFrActivity, str2);
        AppMethodBeat.o(18920);
    }
}
