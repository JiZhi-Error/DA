package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.KCardTypePickerView;
import com.tencent.kinda.gen.KCardTypePickerViewOnSelectCallback;
import com.tencent.kinda.gen.Option;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.picker.c;
import java.util.ArrayList;
import java.util.Iterator;

public class KindaCardTypePickerView extends MMKView<View> implements KCardTypePickerView {
    String TAG = "KindaCardTypePickerView";
    private KCardTypePickerViewOnSelectCallback mCallBack;
    private Context mContext;
    private EditText mEditText;
    private c mOptionPiker;
    private ArrayList<Option> mOptions;
    private int selected = -1;

    @Override // com.tencent.kinda.framework.widget.base.MMKView
    public View createView(Context context) {
        AppMethodBeat.i(18895);
        this.mEditText = new EditText(context);
        this.mEditText.setInputType(0);
        this.mEditText.setFocusable(false);
        this.mEditText.setBackground(null);
        this.mEditText.setTextSize(0, MMKViewUtil.dpToPx(context, 17.0f));
        this.mEditText.setPadding(0, 0, 0, 0);
        this.mContext = context;
        this.mEditText.setHintTextColor(context.getResources().getColor(R.color.FG_0));
        this.mEditText.setTextColor(context.getResources().getColor(R.color.FG_0));
        LayoutWrapper layoutWrapper = new LayoutWrapper(context, this.mEditText);
        AppMethodBeat.o(18895);
        return layoutWrapper;
    }

    @Override // com.tencent.kinda.gen.KCardTypePickerView
    public void setOptions(ArrayList<Option> arrayList) {
        AppMethodBeat.i(18889);
        this.mEditText.setText("");
        this.mOptions = arrayList;
        AppMethodBeat.o(18889);
    }

    @Override // com.tencent.kinda.gen.KCardTypePickerView
    public void select(int i2) {
        AppMethodBeat.i(18890);
        this.selected = i2;
        this.mEditText.setText(this.mOptions.get(i2).mContent);
        AppMethodBeat.o(18890);
    }

    @Override // com.tencent.kinda.gen.KCardTypePickerView
    public void setOnSelectCallback(KCardTypePickerViewOnSelectCallback kCardTypePickerViewOnSelectCallback) {
        this.mCallBack = kCardTypePickerViewOnSelectCallback;
    }

    @Override // com.tencent.kinda.gen.KCardTypePickerView
    public void setFocus(boolean z) {
        AppMethodBeat.i(18891);
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<Option> it = this.mOptions.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().mContent);
            }
            this.mOptionPiker = new c(this.mContext, arrayList);
            this.mOptionPiker.QTc = new c.b() {
                /* class com.tencent.kinda.framework.widget.base.KindaCardTypePickerView.AnonymousClass1 */

                @Override // com.tencent.mm.ui.widget.picker.c.b
                public void onResult(boolean z, Object obj, Object obj2) {
                    AppMethodBeat.i(18887);
                    KindaCardTypePickerView.this.mOptionPiker.hide();
                    if (z) {
                        KindaCardTypePickerView.this.mEditText.setText((String) obj);
                        KindaCardTypePickerView.this.selected = KindaCardTypePickerView.this.mOptionPiker.hci();
                        KindaCardTypePickerView.this.mCallBack.onSelect(KindaCardTypePickerView.this.mOptionPiker.hci());
                    }
                    AppMethodBeat.o(18887);
                }
            };
            if (this.selected != -1) {
                this.mOptionPiker.app(this.selected);
            }
            this.mOptionPiker.show();
        }
        AppMethodBeat.o(18891);
    }

    @Override // com.tencent.kinda.gen.KCardTypePickerView
    public boolean getFocus() {
        AppMethodBeat.i(18892);
        boolean isFocused = this.mEditText.isFocused();
        AppMethodBeat.o(18892);
        return isFocused;
    }

    @Override // com.tencent.kinda.gen.KCardTypePickerView
    public void setEnabled(boolean z) {
        AppMethodBeat.i(18893);
        this.mEditText.setEnabled(z);
        AppMethodBeat.o(18893);
    }

    @Override // com.tencent.kinda.gen.KCardTypePickerView
    public boolean getEnabled() {
        AppMethodBeat.i(18894);
        boolean isEnabled = this.mEditText.isEnabled();
        AppMethodBeat.o(18894);
        return isEnabled;
    }

    @Override // com.tencent.kinda.gen.KCardTypePickerView
    public void setHint(String str) {
        AppMethodBeat.i(170115);
        if (this.mEditText != null) {
            this.mEditText.setHint(str);
        }
        AppMethodBeat.o(170115);
    }
}
