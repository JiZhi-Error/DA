package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import com.tencent.kinda.gen.KCountPickerView;
import com.tencent.kinda.gen.KCountPickerViewOnSelectCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.picker.c;

public class KindaCountPickerViewImpl extends MMKView implements KCountPickerView {
    private Context mContext;
    private KCountPickerViewOnSelectCallback mCountPickerCallback;
    private EditText mEditText;
    private int mSelectCreCountIndex;
    private String[] mTimesArray;

    @Override // com.tencent.kinda.framework.widget.base.MMKView
    public View createView(Context context) {
        AppMethodBeat.i(18897);
        this.mContext = context;
        this.mTimesArray = new String[100];
        for (int i2 = 0; i2 < this.mTimesArray.length; i2++) {
            this.mTimesArray[i2] = this.mContext.getString(R.string.ibj, String.valueOf(i2));
        }
        this.mSelectCreCountIndex = 0;
        this.mEditText = new EditText(context);
        this.mEditText.setInputType(0);
        this.mEditText.setFocusable(false);
        this.mEditText.setBackground(null);
        this.mEditText.setHint(R.string.i9_);
        this.mEditText.setPadding(0, 0, 0, 0);
        this.mEditText.setTextSize(16.0f);
        EditText editText = this.mEditText;
        AppMethodBeat.o(18897);
        return editText;
    }

    @Override // com.tencent.kinda.gen.KCountPickerView
    public void setDefaultCount(int i2) {
        AppMethodBeat.i(18898);
        this.mSelectCreCountIndex = i2;
        this.mEditText.setText(this.mContext.getString(R.string.ibj, String.valueOf(i2)));
        AppMethodBeat.o(18898);
    }

    @Override // com.tencent.kinda.gen.KCountPickerView
    public void setFocus(boolean z) {
        AppMethodBeat.i(18899);
        if (z) {
            final c cVar = new c(this.mContext, this.mTimesArray);
            cVar.QTc = new c.b() {
                /* class com.tencent.kinda.framework.widget.base.KindaCountPickerViewImpl.AnonymousClass1 */

                @Override // com.tencent.mm.ui.widget.picker.c.b
                public void onResult(boolean z, Object obj, Object obj2) {
                    AppMethodBeat.i(18896);
                    if (z) {
                        KindaCountPickerViewImpl.this.mSelectCreCountIndex = cVar.hci();
                        KindaCountPickerViewImpl.this.mEditText.setText(obj.toString());
                        KindaCountPickerViewImpl.this.mCountPickerCallback.onSelect(String.valueOf(KindaCountPickerViewImpl.this.mSelectCreCountIndex));
                    }
                    cVar.hide();
                    AppMethodBeat.o(18896);
                }
            };
            cVar.app(this.mSelectCreCountIndex);
            cVar.show();
        }
        AppMethodBeat.o(18899);
    }

    @Override // com.tencent.kinda.gen.KCountPickerView
    public boolean getFocus() {
        AppMethodBeat.i(18900);
        if (this.mEditText == null) {
            AppMethodBeat.o(18900);
            return false;
        }
        boolean hasFocus = this.mEditText.hasFocus();
        AppMethodBeat.o(18900);
        return hasFocus;
    }

    @Override // com.tencent.kinda.gen.KCountPickerView
    public void setValue(String str) {
    }

    @Override // com.tencent.kinda.gen.KCountPickerView
    public String getValue() {
        AppMethodBeat.i(18901);
        String sb = new StringBuilder().append(this.mSelectCreCountIndex).toString();
        AppMethodBeat.o(18901);
        return sb;
    }

    @Override // com.tencent.kinda.gen.KCountPickerView
    public void setOnSelectCallback(KCountPickerViewOnSelectCallback kCountPickerViewOnSelectCallback) {
        this.mCountPickerCallback = kCountPickerViewOnSelectCallback;
    }
}
