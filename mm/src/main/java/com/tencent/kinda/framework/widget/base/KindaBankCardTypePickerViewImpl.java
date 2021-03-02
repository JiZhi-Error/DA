package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.widget.EditText;
import com.tencent.kinda.gen.BankCardType;
import com.tencent.kinda.gen.KBankCardTypePickerView;
import com.tencent.kinda.gen.KBankCardTypePickerViewOnSelectCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class KindaBankCardTypePickerViewImpl extends MMKView<EditText> implements KBankCardTypePickerView {
    String TAG = "KindaBankCardTypePickerViewImpl";
    private ArrayList<BankCardType> mBankCardTypeArray;
    private Context mContext;
    private EditText mEditText;
    private ArrayList<String> mFirstOptionList = null;
    private int mFirstSelectedIndex = -1;
    private KBankCardTypePickerViewOnSelectCallback mOnSelectCallback;
    private c mOptionPiker;
    private ArrayList<List<BankCardType>> mSecondOptionList = null;
    private Map<String, ArrayList<BankCardType>> mSecondOptionMap = null;
    private ArrayList<List<String>> mSecondOptionStringList = null;
    private Map<String, ArrayList<String>> mSecondOptionStringMap = null;
    private int mSecondSelectedIndex = -1;
    private BankCardType mSelectedBankCardType;

    @Override // com.tencent.kinda.framework.widget.base.MMKView
    public EditText createView(Context context) {
        AppMethodBeat.i(18836);
        this.mContext = context;
        this.mEditText = new EditText(context);
        this.mEditText.setInputType(0);
        this.mEditText.setFocusable(false);
        this.mEditText.setBackground(null);
        this.mEditText.setTextSize(16.0f);
        this.mContext = context;
        EditText editText = this.mEditText;
        AppMethodBeat.o(18836);
        return editText;
    }

    @Override // com.tencent.kinda.gen.KBankCardTypePickerView
    public void setBankCardType(ArrayList<BankCardType> arrayList) {
        AppMethodBeat.i(18837);
        this.mEditText.setText("");
        this.mBankCardTypeArray = arrayList;
        this.mFirstOptionList = new ArrayList<>();
        this.mSecondOptionMap = new HashMap();
        this.mSecondOptionStringMap = new HashMap();
        Iterator<BankCardType> it = this.mBankCardTypeArray.iterator();
        while (it.hasNext()) {
            BankCardType next = it.next();
            if (!this.mSecondOptionMap.containsKey(next.mBankName)) {
                this.mFirstOptionList.add(next.mBankName);
                ArrayList<BankCardType> arrayList2 = new ArrayList<>();
                arrayList2.add(next);
                this.mSecondOptionMap.put(next.mBankName, arrayList2);
                ArrayList<String> arrayList3 = new ArrayList<>();
                arrayList3.add(next.mBankaccTypeName);
                this.mSecondOptionStringMap.put(next.mBankName, arrayList3);
            } else {
                ArrayList<BankCardType> arrayList4 = this.mSecondOptionMap.get(next.mBankName);
                arrayList4.add(next);
                this.mSecondOptionMap.put(next.mBankName, arrayList4);
                ArrayList<String> arrayList5 = this.mSecondOptionStringMap.get(next.mBankName);
                arrayList5.add(next.mBankaccTypeName);
                this.mSecondOptionStringMap.put(next.mBankName, arrayList5);
            }
        }
        this.mSecondOptionList = new ArrayList<>();
        this.mSecondOptionStringList = new ArrayList<>();
        Iterator<String> it2 = this.mFirstOptionList.iterator();
        while (it2.hasNext()) {
            String next2 = it2.next();
            this.mSecondOptionList.add(this.mSecondOptionMap.get(next2));
            this.mSecondOptionStringList.add(this.mSecondOptionStringMap.get(next2));
        }
        AppMethodBeat.o(18837);
    }

    @Override // com.tencent.kinda.gen.KBankCardTypePickerView
    public void setSelectedBankCardType(BankCardType bankCardType) {
        String str;
        String str2;
        int i2 = 0;
        AppMethodBeat.i(18838);
        if (bankCardType == null) {
            AppMethodBeat.o(18838);
        } else if (bankCardType.mIsMaintainance) {
            AppMethodBeat.o(18838);
        } else if (bankCardType.mForbidWord.length() > 0) {
            AppMethodBeat.o(18838);
        } else {
            this.mSelectedBankCardType = bankCardType;
            int i3 = 0;
            while (true) {
                if (i3 >= this.mFirstOptionList.size()) {
                    break;
                } else if (this.mFirstOptionList.get(i3).equals(bankCardType.mBankName)) {
                    this.mFirstSelectedIndex = i3;
                    break;
                } else {
                    i3++;
                }
            }
            while (true) {
                if (i2 >= this.mSecondOptionList.get(this.mFirstSelectedIndex).size()) {
                    break;
                } else if (this.mSecondOptionList.get(this.mFirstSelectedIndex).get(i2).mBankType.equals(bankCardType.mBankType)) {
                    this.mSecondSelectedIndex = i2;
                    break;
                } else {
                    i2++;
                }
            }
            if (this.mFirstSelectedIndex >= 0) {
                str = this.mFirstOptionList.get(this.mFirstSelectedIndex);
            } else {
                str = "";
            }
            if (this.mFirstSelectedIndex < 0 || this.mSecondSelectedIndex < 0) {
                str2 = "";
            } else {
                str2 = this.mSecondOptionStringList.get(this.mFirstSelectedIndex).get(this.mSecondSelectedIndex);
            }
            this.mEditText.setText(str + " " + str2);
            AppMethodBeat.o(18838);
        }
    }

    @Override // com.tencent.kinda.gen.KBankCardTypePickerView
    public void setFocus(boolean z) {
        AppMethodBeat.i(18839);
        if (z) {
            this.mOptionPiker = new c(this.mContext, this.mFirstOptionList, this.mSecondOptionStringList);
            this.mOptionPiker.QTc = new c.b() {
                /* class com.tencent.kinda.framework.widget.base.KindaBankCardTypePickerViewImpl.AnonymousClass1 */

                @Override // com.tencent.mm.ui.widget.picker.c.b
                public void onResult(boolean z, Object obj, Object obj2) {
                    AppMethodBeat.i(18835);
                    KindaBankCardTypePickerViewImpl.this.mOptionPiker.hide();
                    if (z) {
                        KindaBankCardTypePickerViewImpl.this.mEditText.setText(((String) obj) + " " + ((String) obj2));
                        KindaBankCardTypePickerViewImpl.this.mFirstSelectedIndex = KindaBankCardTypePickerViewImpl.this.mOptionPiker.hci();
                        KindaBankCardTypePickerViewImpl kindaBankCardTypePickerViewImpl = KindaBankCardTypePickerViewImpl.this;
                        c cVar = KindaBankCardTypePickerViewImpl.this.mOptionPiker;
                        int i2 = 0;
                        if (cVar.QTa != null) {
                            i2 = cVar.QTa.getValue();
                        }
                        kindaBankCardTypePickerViewImpl.mSecondSelectedIndex = i2;
                        if (KindaBankCardTypePickerViewImpl.this.mFirstSelectedIndex >= 0 && KindaBankCardTypePickerViewImpl.this.mSecondSelectedIndex >= 0) {
                            BankCardType bankCardType = (BankCardType) ((List) KindaBankCardTypePickerViewImpl.this.mSecondOptionList.get(KindaBankCardTypePickerViewImpl.this.mFirstSelectedIndex)).get(KindaBankCardTypePickerViewImpl.this.mSecondSelectedIndex);
                            KindaBankCardTypePickerViewImpl.this.mSelectedBankCardType = bankCardType;
                            KindaBankCardTypePickerViewImpl.this.mOnSelectCallback.onSelect(bankCardType.mBankType);
                        }
                    }
                    AppMethodBeat.o(18835);
                }
            };
            if (this.mFirstSelectedIndex >= 0) {
                if (this.mSecondSelectedIndex >= 0) {
                    this.mOptionPiker.lM(this.mFirstSelectedIndex, this.mSecondSelectedIndex);
                } else {
                    this.mOptionPiker.app(this.mFirstSelectedIndex);
                }
            }
            this.mOptionPiker.show();
        }
        AppMethodBeat.o(18839);
    }

    @Override // com.tencent.kinda.gen.KBankCardTypePickerView
    public boolean getFocus() {
        AppMethodBeat.i(18840);
        boolean isFocused = this.mEditText.isFocused();
        AppMethodBeat.o(18840);
        return isFocused;
    }

    @Override // com.tencent.kinda.gen.KBankCardTypePickerView
    public void setValue(String str) {
    }

    @Override // com.tencent.kinda.gen.KBankCardTypePickerView
    public String getValue() {
        return this.mSelectedBankCardType.mBankType;
    }

    @Override // com.tencent.kinda.gen.KBankCardTypePickerView
    public void setOnSelectCallback(KBankCardTypePickerViewOnSelectCallback kBankCardTypePickerViewOnSelectCallback) {
        this.mOnSelectCallback = kBankCardTypePickerViewOnSelectCallback;
    }
}
