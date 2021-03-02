package com.tencent.mm.wallet_core.ui;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.e;
import com.tencent.mm.wallet_core.c.ah;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.DecimalFormat;
import java.util.Calendar;

@Deprecated
public class EditHintView extends RelativeLayout implements View.OnFocusChangeListener {
    public boolean OYB;
    private b Rvc;
    private TextView Rvd;
    TenpaySecureEditText Rve;
    private int Rvf;
    private int Rvg;
    private int Rvh;
    private boolean Rvi;
    private String Rvj;
    private DatePickerDialog Rvk;
    private int Rvl;
    private int Rvm;
    private d Rvn;
    private a Rvo;
    private int background;
    private int gravity;
    private int imeOptions;
    private int inputType;
    private TextView jBS;
    private View.OnFocusChangeListener ktK;
    private ImageView ktM;
    private String ktN;
    private String ktO;
    private int ktP;
    private int ktQ;
    public boolean ktR;
    private boolean ktT;
    private int ktU;
    private int ktV;
    private View.OnClickListener ktW;
    private boolean maw;
    private int mode;

    public interface a {
    }

    public interface b {
    }

    static /* synthetic */ void g(EditHintView editHintView) {
        AppMethodBeat.i(72938);
        editHintView.hhO();
        AppMethodBeat.o(72938);
    }

    public EditHintView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        AppMethodBeat.i(72906);
        this.ktN = "";
        this.ktO = "";
        this.inputType = 1;
        this.maw = true;
        this.ktV = -1;
        this.ktU = 1;
        this.gravity = 19;
        this.Rvf = -1;
        this.ktP = -1;
        this.ktT = false;
        this.Rvg = 1;
        this.Rvh = -1;
        this.background = -1;
        this.ktQ = -1;
        this.ktR = true;
        this.OYB = true;
        this.Rvi = true;
        this.Rvj = null;
        this.mode = 0;
        this.Rvk = null;
        this.Rvl = 0;
        this.Rvm = 0;
        this.ktW = new View.OnClickListener() {
            /* class com.tencent.mm.wallet_core.ui.EditHintView.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(72904);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/EditHintView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (EditHintView.this.ktM.getVisibility() == 0) {
                    if (EditHintView.this.ktR && !Util.isNullOrNil(EditHintView.this.getText())) {
                        EditHintView.this.Rve.ClearInput();
                    } else if (EditHintView.this.ktP != 1) {
                        EditHintView.o(EditHintView.this);
                    } else if (EditHintView.this.Rvo != null && EditHintView.this.Rvi) {
                        a unused = EditHintView.this.Rvo;
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/EditHintView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(72904);
            }
        };
        this.Rvn = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C2011a.EditHintView, i2, 0);
        int resourceId = obtainStyledAttributes.getResourceId(8, 0);
        if (resourceId != 0) {
            this.ktN = context.getString(resourceId);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(13, 0);
        if (resourceId2 != 0) {
            this.ktO = context.getString(resourceId2);
        }
        this.inputType = obtainStyledAttributes.getInteger(4, 1);
        this.ktR = obtainStyledAttributes.getBoolean(7, true);
        this.gravity = obtainStyledAttributes.getInt(0, 19);
        this.maw = obtainStyledAttributes.getBoolean(2, true);
        this.ktV = obtainStyledAttributes.getInteger(11, -1);
        this.ktP = obtainStyledAttributes.getInteger(6, 0);
        this.imeOptions = obtainStyledAttributes.getInteger(5, 5);
        this.Rvh = obtainStyledAttributes.getColor(10, R.color.a2x);
        this.background = obtainStyledAttributes.getResourceId(1, -1);
        this.ktQ = obtainStyledAttributes.getResourceId(9, R.drawable.t7);
        this.ktU = obtainStyledAttributes.getInteger(12, 1);
        this.OYB = obtainStyledAttributes.getBoolean(3, true);
        obtainStyledAttributes.recycle();
        View inflate = aa.jQ(context).inflate(R.layout.a0j, (ViewGroup) this, true);
        this.Rve = (TenpaySecureEditText) inflate.findViewById(R.id.dpf);
        this.jBS = (TextView) inflate.findViewById(R.id.ior);
        this.Rvd = (TextView) inflate.findViewById(R.id.gfw);
        this.ktM = (ImageView) inflate.findViewById(R.id.dy5);
        this.Rve.setImeOptions(this.imeOptions);
        switch (this.ktP) {
            case 0:
                break;
            case 1:
                this.ktV = 25;
                this.Rve.setIsBankcardFormat(true);
                this.inputType = 2;
                break;
            case 2:
            case 9:
                this.ktV = 30;
                this.inputType = 3;
                break;
            case 3:
                this.ktR = false;
                this.Rve.setIsValidThru(true);
                setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.wallet_core.ui.EditHintView.AnonymousClass7 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(72903);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/EditHintView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (EditHintView.this.Rvk == null) {
                            Calendar instance = Calendar.getInstance();
                            instance.setTimeInMillis(System.currentTimeMillis());
                            instance.add(2, 1);
                            EditHintView.this.Rvl = instance.get(1);
                            EditHintView.this.Rvm = instance.get(2);
                            EditHintView.this.Rvk = new e(EditHintView.this.getContext(), new DatePickerDialog.OnDateSetListener() {
                                /* class com.tencent.mm.wallet_core.ui.EditHintView.AnonymousClass7.AnonymousClass1 */

                                public final void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
                                    AppMethodBeat.i(72902);
                                    if (i2 >= EditHintView.this.Rvl || i3 >= EditHintView.this.Rvm) {
                                        DecimalFormat decimalFormat = new DecimalFormat("00");
                                        if (z.aUo()) {
                                            EditHintView.this.Rvj = decimalFormat.format((long) (i3 + 1)) + i2;
                                        } else {
                                            EditHintView.this.Rvj = decimalFormat.format((long) i2).substring(2) + decimalFormat.format((long) (i3 + 1));
                                        }
                                        EditHintView.this.Rve.setText(decimalFormat.format((long) (i3 + 1)) + decimalFormat.format((long) i2).substring(2));
                                    } else {
                                        h.c(EditHintView.this.getContext(), EditHintView.this.getContext().getString(R.string.icc), null, true);
                                    }
                                    EditHintView.this.ktT = EditHintView.this.bql();
                                    if (EditHintView.this.Rvc != null) {
                                        Log.d("MicroMsg.EditHintView", "View:" + EditHintView.this.ktO + ", editType:" + EditHintView.this.ktP + " inputValid change to " + EditHintView.this.ktT);
                                        b unused = EditHintView.this.Rvc;
                                        boolean unused2 = EditHintView.this.ktT;
                                    }
                                    AppMethodBeat.o(72902);
                                }
                            }, EditHintView.this.Rvl, EditHintView.this.Rvm, instance.get(5), instance.getTimeInMillis());
                        }
                        EditHintView.this.Rvk.show();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/EditHintView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(72903);
                    }
                });
                break;
            case 4:
                this.ktV = 4;
                this.inputType = 2;
                break;
            case 5:
                this.ktV = 18;
                this.inputType = 4;
                break;
            case 6:
                this.ktV = 6;
                this.jBS.setVisibility(8);
                this.inputType = 2;
                break;
            case 7:
            case 17:
                this.ktV = 6;
                this.jBS.setVisibility(8);
                this.Rve.setIsPasswordFormat(true, true);
                this.Rve.setImeOptions(6);
                this.inputType = 128;
                break;
            case 8:
                this.inputType = 32;
                break;
            case 10:
                if (this.ktR || this.maw) {
                }
            case 11:
            default:
                this.inputType = 1;
                break;
            case 12:
                this.ktV = 12;
                this.Rve.setIsMoneyAmountFormat(true);
                break;
            case 13:
            case 16:
                this.Rve.setIsSecurityAnswerFormat(true);
                break;
            case 14:
                this.ktV = 3;
                this.jBS.setVisibility(8);
                this.Rve.setIsCvvPaymentFormat(true);
                this.Rve.setImeOptions(6);
                this.inputType = 128;
                break;
            case 15:
                this.ktV = 4;
                this.jBS.setVisibility(8);
                this.Rve.setIsCvv4PaymentFormat(true);
                this.Rve.setImeOptions(6);
                this.inputType = 128;
                break;
        }
        hhO();
        this.Rve.setSingleLine(this.OYB);
        if (!this.OYB) {
            this.Rve.setMaxLines(1073741823);
        }
        this.ktM.setOnClickListener(this.ktW);
        this.Rve.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.wallet_core.ui.EditHintView.AnonymousClass1 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(72900);
                if (EditHintView.this.mode == 4 && EditHintView.this.bql()) {
                    EditHintView.this.mode = 0;
                    EditHintView.this.Rve.ClearInput();
                }
                AppMethodBeat.o(72900);
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(72901);
                boolean bql = EditHintView.this.bql();
                if (!(bql == EditHintView.this.ktT || EditHintView.this.Rvc == null)) {
                    Log.d("MicroMsg.EditHintView", "View:" + EditHintView.this.ktO + ", editType:" + EditHintView.this.ktP + " inputValid change to " + bql);
                    EditHintView.this.ktT = bql;
                    b unused = EditHintView.this.Rvc;
                    boolean unused2 = EditHintView.this.ktT;
                }
                EditHintView.g(EditHintView.this);
                AppMethodBeat.o(72901);
            }
        });
        this.Rve.setOnFocusChangeListener(this);
        if (!Util.isNullOrNil(this.ktN)) {
            this.Rve.setHint(this.ktN);
        }
        if (!Util.isNullOrNil(this.ktO)) {
            this.jBS.setText(this.ktO);
        }
        this.Rve.setGravity(this.gravity);
        if (this.inputType == 2) {
            this.Rve.setKeyListener(new NumberKeyListener() {
                /* class com.tencent.mm.wallet_core.ui.EditHintView.AnonymousClass2 */

                public final int getInputType() {
                    return 3;
                }

                /* access modifiers changed from: protected */
                public final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                }
            });
        } else if (this.inputType == 4) {
            this.Rve.setKeyListener(new NumberKeyListener() {
                /* class com.tencent.mm.wallet_core.ui.EditHintView.AnonymousClass3 */

                public final int getInputType() {
                    return 1;
                }

                /* access modifiers changed from: protected */
                public final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'x', 'X'};
                }
            });
        } else if (this.inputType == 128) {
            this.Rve.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.Rve.setKeyListener(new NumberKeyListener() {
                /* class com.tencent.mm.wallet_core.ui.EditHintView.AnonymousClass4 */

                public final int getInputType() {
                    return 18;
                }

                /* access modifiers changed from: protected */
                public final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                }
            });
            this.Rve.setRawInputType(18);
        } else if (this.inputType == 3) {
            this.Rve.setKeyListener(new NumberKeyListener() {
                /* class com.tencent.mm.wallet_core.ui.EditHintView.AnonymousClass5 */

                public final int getInputType() {
                    return 3;
                }

                /* access modifiers changed from: protected */
                public final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-'};
                }
            });
        } else {
            this.Rve.setInputType(this.inputType);
        }
        if (this.ktV != -1) {
            this.Rve.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.ktV)});
        }
        super.setEnabled(true);
        super.setClickable(true);
        if (!this.maw) {
            this.Rve.setEnabled(false);
            this.Rve.setTextColor(getResources().getColor(this.Rvh));
            this.Rve.setFocusable(false);
            this.Rve.setClickable(false);
            this.Rve.setBackgroundResource(R.drawable.b0w);
            setBackgroundResource(R.drawable.b9w);
        }
        if (!this.ktR) {
            this.ktT = true;
            this.Rve.setEnabled(false);
            this.Rve.setTextColor(getResources().getColor(R.color.x2));
            this.Rve.setFocusable(false);
            this.Rve.setClickable(false);
            this.Rve.setBackgroundResource(R.drawable.b0w);
            setBackgroundResource(R.drawable.qa);
        } else {
            this.ktT = false;
            this.Rve.setBackgroundResource(this.ktQ);
            setBackgroundResource(R.drawable.b0w);
        }
        if (this.background > 0) {
            setBackgroundResource(this.background);
        }
        if (!(this.jBS == null || this.Rvf == -1)) {
            ViewGroup.LayoutParams layoutParams = this.jBS.getLayoutParams();
            layoutParams.width = this.Rvf;
            this.jBS.setLayoutParams(layoutParams);
        }
        if (z.aUo()) {
            this.Rve.setSecureEncrypt(new com.tencent.mm.wallet_core.a.a(getEncryptType()));
        }
        AppMethodBeat.o(72906);
    }

    public EditHintView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setOnInputValidChangeListener(b bVar) {
        this.Rvc = bVar;
    }

    public void setTipWidth(int i2) {
        AppMethodBeat.i(72907);
        this.Rvf = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), ((float) i2) * 1.0f);
        if (this.jBS != null) {
            ViewGroup.LayoutParams layoutParams = this.jBS.getLayoutParams();
            layoutParams.width = this.Rvf;
            this.jBS.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(72907);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        AppMethodBeat.i(72908);
        if (this.ktP == 7 || this.ktP == 17 || this.ktP == 14 || this.ktP == 15) {
            setMeasuredDimension(getDefaultSize(BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 960.0f), i2), getDefaultSize(BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 720.0f), i3));
            int measuredWidth = getMeasuredWidth();
            if (this.ktP == 7 || this.ktP == 17) {
                i4 = measuredWidth / 6;
            } else if (this.ktP == 14) {
                i4 = measuredWidth / 3;
            } else {
                i4 = measuredWidth / 4;
            }
            i2 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
            i3 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
            setMeasuredDimension(getDefaultSize(measuredWidth, i2), getDefaultSize(i4, i3));
        }
        super.onMeasure(i2, i3);
        AppMethodBeat.o(72908);
    }

    public void setHintStr(String str) {
        AppMethodBeat.i(72909);
        this.Rve.setHint(str);
        AppMethodBeat.o(72909);
    }

    public void setTipStr(String str) {
        AppMethodBeat.i(72910);
        this.jBS.setText(str);
        AppMethodBeat.o(72910);
    }

    public void setPreFilledStr(String str) {
        AppMethodBeat.i(72911);
        if (!Util.isNullOrNil(str)) {
            this.Rvd.setText(str);
            this.Rvd.setVisibility(0);
            AppMethodBeat.o(72911);
            return;
        }
        this.Rvd.setText("");
        this.Rvd.setVisibility(8);
        AppMethodBeat.o(72911);
    }

    public void setValStr(String str) {
        AppMethodBeat.i(72912);
        switch (this.ktP) {
            case 1:
                if (Util.isNullOrNil(str) || str.length() > 5) {
                    this.Rve.setText(str);
                    this.Rve.setSelection(this.Rve.getText().length());
                    AppMethodBeat.o(72912);
                    return;
                }
                this.Rve.setSelection(0);
                this.Rve.setBankcardTailNum(str);
                this.ktV = 24 - str.length();
                this.Rve.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.ktV)});
                AppMethodBeat.o(72912);
                return;
            default:
                this.Rve.setText(str);
                this.Rve.setSelection(this.Rve.getText().length());
                AppMethodBeat.o(72912);
                return;
        }
    }

    public void set3DesValStr(String str) {
        AppMethodBeat.i(72913);
        switch (this.ktP) {
            case 1:
                if (Util.isNullOrNil(str) || str.length() > 5) {
                    this.Rve.set3DesEncrptData(str);
                    this.Rve.setSelection(this.Rve.getText().length());
                    AppMethodBeat.o(72913);
                    return;
                }
                this.Rve.setSelection(0);
                this.Rve.set3DesEncrptData(str);
                this.ktV = 24 - str.length();
                this.Rve.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.ktV)});
                AppMethodBeat.o(72913);
                return;
            default:
                this.Rve.setText(str);
                this.Rve.setSelection(this.Rve.getText().length());
                AppMethodBeat.o(72913);
                return;
        }
    }

    private void setValStrForce(String str) {
        AppMethodBeat.i(72914);
        KeyListener keyListener = this.Rve.getKeyListener();
        this.Rve.setKeyListener(null);
        setEnabled(false);
        setClickable(false);
        setValStr(str);
        this.Rve.setKeyListener(keyListener);
        AppMethodBeat.o(72914);
    }

    public void setPreText(String str) {
        AppMethodBeat.i(72915);
        KeyListener keyListener = this.Rve.getKeyListener();
        this.Rve.setInputType(1);
        this.Rve.setKeyListener(null);
        setValStr(str);
        this.Rve.setKeyListener(keyListener);
        this.mode = 4;
        AppMethodBeat.o(72915);
    }

    public void setEditBG(int i2) {
        AppMethodBeat.i(72916);
        if (this.Rve != null) {
            this.Rve.setBackgroundResource(i2);
        }
        AppMethodBeat.o(72916);
    }

    public void setEncryptType(int i2) {
        AppMethodBeat.i(72917);
        if (z.aUo()) {
            this.Rve.setSecureEncrypt(new com.tencent.mm.wallet_core.a.a(i2));
        }
        AppMethodBeat.o(72917);
    }

    public void setTipTextColor(int i2) {
        AppMethodBeat.i(72918);
        if (this.jBS != null) {
            this.jBS.setTextColor(i2);
        }
        AppMethodBeat.o(72918);
    }

    public void setMaxLen(int i2) {
        AppMethodBeat.i(72919);
        if (i2 != -1) {
            this.ktV = i2;
            this.Rve.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
        }
        AppMethodBeat.o(72919);
    }

    public void setIdentifyCardType(int i2) {
        AppMethodBeat.i(72920);
        this.Rvg = i2;
        if (i2 == 1) {
            this.Rve.setKeyListener(new NumberKeyListener() {
                /* class com.tencent.mm.wallet_core.ui.EditHintView.AnonymousClass6 */

                public final int getInputType() {
                    return 1;
                }

                /* access modifiers changed from: protected */
                public final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'x', 'X'};
                }
            });
            AppMethodBeat.o(72920);
            return;
        }
        this.Rve.setInputType(1);
        AppMethodBeat.o(72920);
    }

    public String getText() {
        AppMethodBeat.i(72921);
        switch (this.ktP) {
            case 0:
            case 8:
            case 10:
                String nullAs = Util.nullAs(this.Rve.getText().toString(), "");
                AppMethodBeat.o(72921);
                return nullAs;
            case 1:
            case 13:
            case 16:
                TenpaySecureEditText tenpaySecureEditText = this.Rve;
                com.tencent.mm.wallet_core.b.hgC();
                String encryptDataWithHash = tenpaySecureEditText.getEncryptDataWithHash(false, com.tencent.mm.wallet_core.b.hgD());
                AppMethodBeat.o(72921);
                return encryptDataWithHash;
            case 2:
            case 9:
                String nullAs2 = Util.nullAs(this.Rve.getText().toString(), "");
                AppMethodBeat.o(72921);
                return nullAs2;
            case 3:
                String replace = Util.nullAs(this.Rvj, "").replace(FilePathGenerator.ANDROID_DIR_SEP, "");
                AppMethodBeat.o(72921);
                return replace;
            case 4:
            case 14:
            case 15:
                String str = this.Rve.get3DesEncrptData();
                AppMethodBeat.o(72921);
                return str;
            case 5:
                String str2 = this.Rve.get3DesEncrptData();
                AppMethodBeat.o(72921);
                return str2;
            case 6:
                String str3 = this.Rve.get3DesVerifyCode();
                AppMethodBeat.o(72921);
                return str3;
            case 7:
                TenpaySecureEditText tenpaySecureEditText2 = this.Rve;
                com.tencent.mm.wallet_core.b.hgC();
                String encryptDataWithHash2 = tenpaySecureEditText2.getEncryptDataWithHash(true, com.tencent.mm.wallet_core.b.hgD());
                AppMethodBeat.o(72921);
                return encryptDataWithHash2;
            case 11:
            case 12:
            default:
                String nullAs3 = Util.nullAs(this.Rve.getText().toString(), "");
                AppMethodBeat.o(72921);
                return nullAs3;
        }
    }

    public String getMD5Value() {
        String obj;
        AppMethodBeat.i(72922);
        if (this.ktP == 3) {
            obj = Util.nullAs(this.Rvj, "").replace(FilePathGenerator.ANDROID_DIR_SEP, "");
        } else {
            obj = this.Rve.getText().toString();
        }
        String mD5String = MD5Util.getMD5String(obj);
        AppMethodBeat.o(72922);
        return mD5String;
    }

    public final boolean bql() {
        AppMethodBeat.i(72923);
        if (this.ktR || this.maw) {
            switch (this.ktP) {
                case 0:
                case 2:
                case 3:
                case 6:
                case 10:
                case 11:
                case 13:
                case 16:
                default:
                    if (this.Rve.getInputLength() >= this.ktU) {
                        AppMethodBeat.o(72923);
                        return true;
                    }
                    AppMethodBeat.o(72923);
                    return false;
                case 1:
                    boolean isBankcardNum = this.Rve.isBankcardNum();
                    AppMethodBeat.o(72923);
                    return isBankcardNum;
                case 4:
                    if (this.Rve.getInputLength() > 0) {
                        AppMethodBeat.o(72923);
                        return true;
                    }
                    AppMethodBeat.o(72923);
                    return false;
                case 5:
                    boolean isAreaIDCardNum = this.Rve.isAreaIDCardNum(this.Rvg);
                    AppMethodBeat.o(72923);
                    return isAreaIDCardNum;
                case 7:
                case 17:
                    if (this.Rve.getInputLength() == 6) {
                        AppMethodBeat.o(72923);
                        return true;
                    }
                    AppMethodBeat.o(72923);
                    return false;
                case 8:
                    boolean isValidEmail = Util.isValidEmail(this.Rve.getText().toString());
                    AppMethodBeat.o(72923);
                    return isValidEmail;
                case 9:
                    boolean isPhoneNum = this.Rve.isPhoneNum();
                    AppMethodBeat.o(72923);
                    return isPhoneNum;
                case 12:
                    boolean isMoneyAmount = this.Rve.isMoneyAmount();
                    AppMethodBeat.o(72923);
                    return isMoneyAmount;
                case 14:
                    if (this.Rve.getInputLength() == 3) {
                        AppMethodBeat.o(72923);
                        return true;
                    }
                    AppMethodBeat.o(72923);
                    return false;
                case 15:
                    if (this.Rve.getInputLength() == 4) {
                        AppMethodBeat.o(72923);
                        return true;
                    }
                    AppMethodBeat.o(72923);
                    return false;
            }
        } else {
            AppMethodBeat.o(72923);
            return true;
        }
    }

    public String get3DesEncrptData() {
        AppMethodBeat.i(72924);
        String str = this.Rve.get3DesEncrptData();
        AppMethodBeat.o(72924);
        return str;
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        AppMethodBeat.i(72925);
        this.Rve.setEllipsize(truncateAt);
        AppMethodBeat.o(72925);
    }

    public void setEnabled(boolean z) {
        AppMethodBeat.i(72926);
        super.setEnabled(z);
        this.ktR = z;
        this.ktM.setEnabled(true);
        AppMethodBeat.o(72926);
    }

    public void setClickable(boolean z) {
        AppMethodBeat.i(72927);
        super.setClickable(z);
        this.maw = z;
        if (!z) {
            this.Rve.setEnabled(false);
            if (!this.ktR) {
                this.Rve.setTextColor(getResources().getColor(R.color.wx));
            } else {
                this.Rve.setTextColor(getResources().getColor(this.Rvh));
            }
            this.Rve.setFocusable(false);
            this.Rve.setClickable(false);
            AppMethodBeat.o(72927);
            return;
        }
        this.Rve.setEnabled(true);
        if (!this.ktR) {
            this.Rve.setTextColor(getResources().getColor(R.color.x2));
        } else {
            this.Rve.setTextColor(getResources().getColor(this.Rvh));
        }
        this.Rve.setFocusable(true);
        this.Rve.setClickable(true);
        AppMethodBeat.o(72927);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(72928);
        if (!this.ktR) {
            if (this.ktM.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                z2 = getValidRectOfInfoIv().contains((int) motionEvent.getX(), (int) motionEvent.getY());
            } else {
                z2 = false;
            }
            if (!z2) {
                AppMethodBeat.o(72928);
                return true;
            }
        }
        AppMethodBeat.o(72928);
        return false;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(72929);
        super.setOnClickListener(onClickListener);
        AppMethodBeat.o(72929);
    }

    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        AppMethodBeat.i(72930);
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.ktK = onFocusChangeListener;
        AppMethodBeat.o(72930);
    }

    private void hhO() {
        AppMethodBeat.i(72931);
        if (this.ktP == 7 || this.ktP == 14 || this.ktP == 15) {
            AppMethodBeat.o(72931);
        } else if (!this.ktR || Util.isNullOrNil(getText())) {
            switch (this.ktP) {
                case 1:
                    if (this.Rvi) {
                        this.ktM.setVisibility(0);
                        this.ktM.setImageResource(R.raw.wallet_scan_camera);
                        AppMethodBeat.o(72931);
                        return;
                    }
                    this.ktM.setVisibility(8);
                    AppMethodBeat.o(72931);
                    return;
                case 2:
                case 5:
                case 6:
                case 7:
                case 8:
                default:
                    this.ktM.setVisibility(8);
                    AppMethodBeat.o(72931);
                    return;
                case 3:
                case 4:
                case 9:
                case 10:
                    this.ktM.setVisibility(0);
                    this.ktM.setImageResource(R.drawable.bk3);
                    AppMethodBeat.o(72931);
                    return;
            }
        } else {
            this.ktM.setVisibility(0);
            this.ktM.setImageResource(R.drawable.a_5);
            AppMethodBeat.o(72931);
        }
    }

    public void onFocusChange(View view, boolean z) {
        AppMethodBeat.i(72932);
        if (this.ktK != null) {
            this.ktK.onFocusChange(this, z);
        }
        Log.d("MicroMsg.EditHintView", "View:" + this.ktO + ", editType:" + this.ktP + " onFocusChange to " + z);
        if (!this.ktT) {
            this.jBS.setEnabled(false);
            AppMethodBeat.o(72932);
            return;
        }
        this.jBS.setEnabled(true);
        AppMethodBeat.o(72932);
    }

    public void setImeOptions(int i2) {
        AppMethodBeat.i(72933);
        this.Rve.setImeOptions(i2);
        AppMethodBeat.o(72933);
    }

    public void setOnEditorActionListener(TextView.OnEditorActionListener onEditorActionListener) {
        AppMethodBeat.i(72934);
        this.Rve.setOnEditorActionListener(onEditorActionListener);
        AppMethodBeat.o(72934);
    }

    public void setInfoIvVisible(int i2) {
        AppMethodBeat.i(72935);
        this.ktM.setVisibility(i2);
        AppMethodBeat.o(72935);
    }

    private Rect getValidRectOfInfoIv() {
        AppMethodBeat.i(72936);
        Rect rect = new Rect();
        this.ktM.getHitRect(rect);
        rect.left -= 50;
        rect.right += 50;
        rect.top -= 25;
        rect.bottom += 25;
        AppMethodBeat.o(72936);
        return rect;
    }

    public void setOnInfoListener(a aVar) {
        this.Rvo = aVar;
    }

    public void setShowScanCamera(boolean z) {
        AppMethodBeat.i(72937);
        this.Rvi = z;
        hhO();
        AppMethodBeat.o(72937);
    }

    private int getEncryptType() {
        switch (this.ktP) {
            case 1:
                return 50;
            case 2:
            case 3:
            case 5:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            default:
                return 0;
            case 4:
            case 14:
            case 15:
                return 30;
            case 6:
                return 60;
            case 7:
                return 20;
            case 13:
                return 40;
            case 16:
                return -20;
            case 17:
                return -10;
        }
    }

    static /* synthetic */ void o(EditHintView editHintView) {
        int i2;
        AppMethodBeat.i(72939);
        int i3 = 0;
        switch (editHintView.ktP) {
            case 3:
                editHintView.getContext();
                i2 = ah.hhB();
                editHintView.getContext();
                i3 = ah.hhC();
                break;
            case 4:
                editHintView.getContext();
                i2 = ah.hhD();
                i3 = R.string.bk7;
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            default:
                i2 = -1;
                break;
            case 9:
                i2 = R.layout.c_k;
                i3 = R.string.i_s;
                break;
            case 10:
                i2 = R.layout.c9t;
                i3 = R.string.i_j;
                break;
        }
        if (i2 != -1) {
            if (editHintView.Rvn == null) {
                editHintView.Rvn = b.a(editHintView.getContext(), i2, editHintView.getResources().getString(i3), editHintView.getResources().getString(R.string.idg), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.wallet_core.ui.EditHintView.AnonymousClass9 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(72905);
                        EditHintView.this.Rvn.dismiss();
                        AppMethodBeat.o(72905);
                    }
                });
            }
            editHintView.Rvn.show();
        }
        AppMethodBeat.o(72939);
    }
}
