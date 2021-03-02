package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ae.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.MMEditText;

public class MMFormMobileInputView extends LinearLayout {
    private EditText OQd;
    private EditText OQe;
    private String OQf;
    private String OQg;
    private final int OQh;
    private a OQi;
    private Context mContext;
    private int nBG;
    private int[] nBK;

    public interface a {
    }

    @TargetApi(11)
    public MMFormMobileInputView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        AppMethodBeat.i(141915);
        this.mContext = null;
        this.nBG = -1;
        this.OQf = "";
        this.OQg = "";
        this.OQh = 13;
        this.OQi = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0244a.FormItemView, i2, 0);
        this.nBG = obtainStyledAttributes.getResourceId(1, -1);
        obtainStyledAttributes.recycle();
        aa.jQ(context).inflate(R.layout.b8_, this);
        this.mContext = context;
        AppMethodBeat.o(141915);
    }

    public MMFormMobileInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setOnCountryCodeChangedListener(a aVar) {
        this.OQi = aVar;
    }

    public final void Bv(boolean z) {
        AppMethodBeat.i(141917);
        gx(this.OQd);
        if (z) {
            this.OQd.setBackgroundResource(R.drawable.ca2);
        } else {
            this.OQd.setBackgroundResource(R.drawable.ca3);
        }
        gy(this.OQd);
        gx(this.OQe);
        if (z) {
            this.OQe.setBackgroundResource(R.drawable.ca2);
        } else {
            this.OQe.setBackgroundResource(R.drawable.ca3);
        }
        gy(this.OQe);
        AppMethodBeat.o(141917);
    }

    private void gx(View view) {
        AppMethodBeat.i(141918);
        this.nBK = new int[]{view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom()};
        AppMethodBeat.o(141918);
    }

    private void gy(View view) {
        AppMethodBeat.i(141919);
        if (this.nBK != null) {
            view.setPadding(this.nBK[0], this.nBK[1], this.nBK[2], this.nBK[3]);
        }
        AppMethodBeat.o(141919);
    }

    public void setCountryCode(String str) {
        AppMethodBeat.i(141920);
        if (this.OQd != null) {
            this.OQd.setText(str);
            AppMethodBeat.o(141920);
            return;
        }
        Log.e("MicroMsg.MMFormMobileInputView", "countryCodeET is null!");
        AppMethodBeat.o(141920);
    }

    public void setHint(String str) {
        AppMethodBeat.i(141921);
        if (this.OQe != null) {
            this.OQe.setHint(str);
            AppMethodBeat.o(141921);
            return;
        }
        Log.e("MicroMsg.MMFormMobileInputView", "mobileNumberET is null!");
        AppMethodBeat.o(141921);
    }

    public void setMobileNumber(String str) {
        AppMethodBeat.i(141922);
        if (this.OQe != null) {
            this.OQe.setText(str);
            AppMethodBeat.o(141922);
            return;
        }
        Log.e("MicroMsg.MMFormMobileInputView", "mobileNumberET is null!");
        AppMethodBeat.o(141922);
    }

    public String getMobileNumber() {
        AppMethodBeat.i(141923);
        if (this.OQe != null) {
            String pureNumber = PhoneFormater.pureNumber(this.OQe.getText().toString());
            AppMethodBeat.o(141923);
            return pureNumber;
        }
        AppMethodBeat.o(141923);
        return "";
    }

    public String getCountryCode() {
        AppMethodBeat.i(141924);
        if (this.OQd != null) {
            String trim = this.OQd.getText().toString().trim();
            AppMethodBeat.o(141924);
            return trim;
        }
        AppMethodBeat.o(141924);
        return "";
    }

    public EditText getCountryCodeEditText() {
        return this.OQd;
    }

    public EditText getMobileNumberEditText() {
        return this.OQe;
    }

    public void onFinishInflate() {
        AppMethodBeat.i(141916);
        this.OQd = (EditText) findViewById(R.id.bgk);
        this.OQe = (EditText) findViewById(R.id.fh2);
        if (this.OQd == null || this.OQe == null) {
            Log.w("MicroMsg.MMFormMobileInputView", "countryCodeET : %s, mobileNumberET : %s", this.OQd, this.OQe);
        } else if (this.nBG != -1) {
            this.OQe.setHint(this.nBG);
        }
        if (!(this.OQd == null || this.OQe == null)) {
            if (this.OQd.hasFocus() || this.OQe.hasFocus()) {
                Bv(true);
            } else {
                Bv(false);
            }
            AnonymousClass1 r0 = new View.OnFocusChangeListener() {
                /* class com.tencent.mm.ui.base.MMFormMobileInputView.AnonymousClass1 */

                public final void onFocusChange(View view, boolean z) {
                    AppMethodBeat.i(141911);
                    if (view == MMFormMobileInputView.this.OQd || view == MMFormMobileInputView.this.OQe) {
                        MMFormMobileInputView.this.Bv(z);
                    }
                    AppMethodBeat.o(141911);
                }
            };
            this.OQd.setOnFocusChangeListener(r0);
            this.OQe.setOnFocusChangeListener(r0);
            this.OQe.addTextChangedListener(new MMEditText.c(this.OQe, null, 20));
            this.OQe.addTextChangedListener(new TextWatcher() {
                /* class com.tencent.mm.ui.base.MMFormMobileInputView.AnonymousClass2 */
                private PhoneFormater kqv = new PhoneFormater();

                {
                    AppMethodBeat.i(141912);
                    AppMethodBeat.o(141912);
                }

                public final void afterTextChanged(Editable editable) {
                    AppMethodBeat.i(141913);
                    int selectionEnd = MMFormMobileInputView.this.OQe.getSelectionEnd();
                    String obj = MMFormMobileInputView.this.OQe.getText().toString();
                    String substring = MMFormMobileInputView.this.OQe.getText().toString().substring(0, selectionEnd);
                    if (obj != null && !obj.equals(MMFormMobileInputView.this.OQf)) {
                        String obj2 = MMFormMobileInputView.this.OQd.getText().toString();
                        MMFormMobileInputView.this.OQf = this.kqv.formatNumber(obj2.replace("+", ""), obj);
                        MMFormMobileInputView.this.OQg = this.kqv.formatNumber(obj2.replace("+", ""), substring);
                        if (obj.equals(MMFormMobileInputView.this.OQf)) {
                            AppMethodBeat.o(141913);
                            return;
                        }
                        MMFormMobileInputView.this.OQe.setText(MMFormMobileInputView.this.OQf);
                        int length = MMFormMobileInputView.this.OQe.getText().toString().length();
                        if (substring != null) {
                            try {
                                MMFormMobileInputView.this.OQg = this.kqv.formatNumber(obj2.replace("+", ""), substring);
                                if (obj.length() > 13 && selectionEnd <= length) {
                                    MMFormMobileInputView.this.OQe.setSelection(substring.toString().length());
                                    AppMethodBeat.o(141913);
                                    return;
                                } else if (selectionEnd > length || MMFormMobileInputView.this.OQg.toString().length() > length) {
                                    MMFormMobileInputView.this.OQe.setSelection(length - Math.abs(obj.length() - selectionEnd));
                                    AppMethodBeat.o(141913);
                                    return;
                                } else {
                                    MMFormMobileInputView.this.OQe.setSelection(MMFormMobileInputView.this.OQg.toString().length());
                                    AppMethodBeat.o(141913);
                                    return;
                                }
                            } catch (Exception e2) {
                                Log.printErrStackTrace("MicroMsg.MMFormMobileInputView", e2, "", new Object[0]);
                            }
                        } else {
                            MMFormMobileInputView.this.OQe.setSelection(0);
                            AppMethodBeat.o(141913);
                            return;
                        }
                    }
                    AppMethodBeat.o(141913);
                }

                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }
            });
            this.OQd.addTextChangedListener(new TextWatcher() {
                /* class com.tencent.mm.ui.base.MMFormMobileInputView.AnonymousClass3 */

                public final void afterTextChanged(Editable editable) {
                    AppMethodBeat.i(141914);
                    String obj = MMFormMobileInputView.this.OQd.getText().toString();
                    if (Util.isNullOrNil(obj)) {
                        MMFormMobileInputView.this.OQd.setText("+");
                        MMFormMobileInputView.this.OQd.setSelection(MMFormMobileInputView.this.OQd.getText().toString().length());
                    } else if (!obj.contains("+")) {
                        MMFormMobileInputView.this.OQd.setText("+".concat(String.valueOf(obj)));
                        MMFormMobileInputView.this.OQd.setSelection(MMFormMobileInputView.this.OQd.getText().toString().length());
                    } else if (obj.length() > 1) {
                        String substring = obj.substring(1);
                        if (substring.length() > 4) {
                            MMFormMobileInputView.this.OQd.setText(substring.substring(0, 4));
                            AppMethodBeat.o(141914);
                            return;
                        }
                    }
                    if (MMFormMobileInputView.this.OQi != null) {
                        a unused = MMFormMobileInputView.this.OQi;
                    }
                    AppMethodBeat.o(141914);
                }

                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }
            });
        }
        AppMethodBeat.o(141916);
    }
}
