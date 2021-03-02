package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class InvoiceEditView extends RelativeLayout implements View.OnFocusChangeListener {
    private int background;
    private int gravity;
    private int imeOptions;
    private int inputType;
    private TextView jBS;
    private boolean kK;
    private View.OnFocusChangeListener ktK;
    EditText ktL;
    private ImageView ktM;
    private String ktN;
    private String ktO;
    private int ktP;
    private int ktQ;
    public boolean ktR;
    private int ktS;
    public boolean ktT;
    private int ktU;
    private int ktV;
    private View.OnClickListener ktW;
    private String ktX;
    public boolean ktZ;
    private a kua;
    private c kub;
    private b kuc;
    private int kud;
    public boolean kue;

    public interface a {
    }

    public interface b {
    }

    public interface c {
        void bqh();
    }

    static /* synthetic */ void a(InvoiceEditView invoiceEditView, boolean z) {
        AppMethodBeat.i(20898);
        invoiceEditView.gr(z);
        AppMethodBeat.o(20898);
    }

    public InvoiceEditView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        AppMethodBeat.i(20876);
        this.ktZ = false;
        this.ktN = "";
        this.ktO = "";
        this.inputType = 1;
        this.kud = 0;
        this.gravity = 19;
        this.ktP = -1;
        this.background = -1;
        this.ktQ = -1;
        this.ktR = true;
        this.kue = true;
        this.ktT = false;
        this.ktU = 0;
        this.ktV = 100;
        this.kK = true;
        this.ktW = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.address.ui.InvoiceEditView.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(20875);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/InvoiceEditView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (InvoiceEditView.this.ktM.getVisibility() == 0) {
                    if (InvoiceEditView.this.ktR && InvoiceEditView.this.ktP != 2 && !Util.isNullOrNil(InvoiceEditView.this.getText())) {
                        InvoiceEditView.this.ktL.setText("");
                        InvoiceEditView.a(InvoiceEditView.this, InvoiceEditView.this.ktL.isFocused());
                    } else if (InvoiceEditView.this.kua != null) {
                        a unused = InvoiceEditView.this.kua;
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/InvoiceEditView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(20875);
            }
        };
        this.ktX = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.a.InvoiceEditView, i2, 0);
        int resourceId = obtainStyledAttributes.getResourceId(7, 0);
        if (resourceId != 0) {
            this.ktN = context.getString(resourceId);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(13, 0);
        if (resourceId2 != 0) {
            this.ktO = context.getString(resourceId2);
        }
        this.inputType = obtainStyledAttributes.getInteger(3, 1);
        this.ktP = obtainStyledAttributes.getInteger(5, 0);
        this.ktR = obtainStyledAttributes.getBoolean(6, true);
        this.gravity = obtainStyledAttributes.getInt(0, 19);
        this.imeOptions = obtainStyledAttributes.getInteger(4, 5);
        this.background = obtainStyledAttributes.getResourceId(1, R.drawable.b0w);
        this.ktS = obtainStyledAttributes.getResourceId(10, -1);
        this.ktQ = obtainStyledAttributes.getResourceId(8, R.drawable.b0w);
        this.kK = obtainStyledAttributes.getBoolean(12, true);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(R.layout.awa, (ViewGroup) this, true);
        this.ktL = (EditText) inflate.findViewById(R.id.dpf);
        this.ktL.setTextSize(0, (float) com.tencent.mm.cb.a.aG(context, R.dimen.is));
        this.jBS = (TextView) inflate.findViewById(R.id.ior);
        this.ktM = (ImageView) inflate.findViewById(R.id.dy5);
        this.ktM.setOnClickListener(this.ktW);
        this.ktL.setImeOptions(this.imeOptions);
        this.ktL.setInputType(this.inputType);
        if (this.inputType == 2) {
            this.ktL.setKeyListener(new NumberKeyListener() {
                /* class com.tencent.mm.plugin.address.ui.InvoiceEditView.AnonymousClass1 */

                public final int getInputType() {
                    return 2;
                }

                /* access modifiers changed from: protected */
                public final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '-', '+', '_', 8212, ' ', ' ', '(', ')', 65288, 65289, '@', '~', '*', '&', '^', '%', '$', '#', '@', '!', ';', ':', 65306, 65307, '{', '}', '[', ']', 65371, 65373, 12304, 12305, '<', '>', '~', '`', 183, '=', '=', '+'};
                }
            });
        } else if (this.inputType == 3) {
            this.ktL.setKeyListener(new NumberKeyListener() {
                /* class com.tencent.mm.plugin.address.ui.InvoiceEditView.AnonymousClass2 */

                public final int getInputType() {
                    return 3;
                }

                /* access modifiers changed from: protected */
                public final char[] getAcceptedChars() {
                    if (InvoiceEditView.this.ktZ) {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', ' '};
                    }
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '-', '+', '_', 8212, ' ', ' ', '(', ')', 65288, 65289, '@', '~', '*', '&', '^', '%', '$', '#', '@', '!', ';', ':', 65306, 65307, '{', '}', '[', ']', 65371, 65373, 12304, 12305, '<', '>', 36716, '~', '`', 183, '=', '=', '+'};
                }
            });
        } else {
            this.ktL.setInputType(this.inputType);
        }
        gr(this.ktL.isFocused());
        this.ktL.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.address.ui.InvoiceEditView.AnonymousClass3 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(20874);
                if (InvoiceEditView.this.ktP == 5 && InvoiceEditView.this.kud != editable.toString().length()) {
                    InvoiceEditView.this.kud = editable.toString().length();
                    InvoiceEditView.this.setBankNumberValStr(editable.toString());
                }
                boolean bql = InvoiceEditView.this.bql();
                if (!(bql == InvoiceEditView.this.ktT || InvoiceEditView.this.kub == null)) {
                    Log.d("MicroMsg.InvoiceEditView", "View:" + InvoiceEditView.this.ktO + ", editType:" + InvoiceEditView.this.ktP + " inputValid change to " + bql);
                    InvoiceEditView.this.ktT = bql;
                    InvoiceEditView.this.kub.bqh();
                }
                if ((!InvoiceEditView.this.ktZ || InvoiceEditView.this.ktT) && InvoiceEditView.this.ktZ && InvoiceEditView.this.ktT) {
                    InvoiceEditView.this.ktL.setTextColor(InvoiceEditView.this.getResources().getColor(R.color.a2x));
                }
                InvoiceEditView.a(InvoiceEditView.this, InvoiceEditView.this.ktL.isFocused());
                AppMethodBeat.o(20874);
            }
        });
        this.ktL.setOnFocusChangeListener(this);
        if (!Util.isNullOrNil(this.ktN)) {
            this.ktL.setHint(this.ktN);
        }
        if (!Util.isNullOrNil(this.ktO)) {
            this.jBS.setText(this.ktO);
        }
        Rect rect = new Rect();
        d(this.ktL, rect);
        if (!this.ktR) {
            this.ktL.setEnabled(false);
            this.ktL.setTextColor(getResources().getColor(R.color.c5));
            this.ktL.setFocusable(false);
            this.ktL.setClickable(false);
            this.ktL.setBackgroundResource(R.drawable.b0w);
            if (this.kue) {
                setBackgroundResource(R.drawable.qa);
            }
            setPadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        } else {
            this.ktT = false;
            this.ktL.setBackgroundResource(this.ktQ);
            setBackgroundResource(this.background);
        }
        e(this.ktL, rect);
        if (this.ktS != -1) {
            this.ktM.setImageResource(this.ktS);
        }
        if (!this.kK) {
            this.ktL.setSingleLine(false);
        }
        AppMethodBeat.o(20876);
    }

    public InvoiceEditView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setOnInputValidChangeListener(c cVar) {
        this.kub = cVar;
    }

    public void setOnInputInvoiceTypeChangeListener(b bVar) {
        this.kuc = bVar;
    }

    public String getText() {
        AppMethodBeat.i(20877);
        String obj = this.ktL.getText().toString();
        AppMethodBeat.o(20877);
        return obj;
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        AppMethodBeat.i(20878);
        this.ktL.setEllipsize(truncateAt);
        AppMethodBeat.o(20878);
    }

    public void setEnabled(boolean z) {
        AppMethodBeat.i(20879);
        super.setEnabled(z);
        this.ktR = z;
        this.ktM.setEnabled(true);
        AppMethodBeat.o(20879);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(20880);
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
                AppMethodBeat.o(20880);
                return true;
            }
        }
        AppMethodBeat.o(20880);
        return false;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(20881);
        super.setOnClickListener(onClickListener);
        AppMethodBeat.o(20881);
    }

    public final boolean bql() {
        AppMethodBeat.i(20882);
        String obj = this.ktL.getText().toString();
        switch (this.ktP) {
            case 0:
                if (obj.length() < this.ktU || obj.length() > this.ktV) {
                    AppMethodBeat.o(20882);
                    return false;
                }
                AppMethodBeat.o(20882);
                return true;
            case 1:
                if (obj.length() == 0 || (obj.length() >= this.ktU && obj.length() <= this.ktV)) {
                    AppMethodBeat.o(20882);
                    return true;
                }
                AppMethodBeat.o(20882);
                return false;
            case 2:
            case 3:
            default:
                if (obj.length() < this.ktU || obj.length() > this.ktV) {
                    AppMethodBeat.o(20882);
                    return false;
                }
                AppMethodBeat.o(20882);
                return true;
            case 4:
                if (obj.length() <= 100) {
                    AppMethodBeat.o(20882);
                    return true;
                }
                AppMethodBeat.o(20882);
                return false;
            case 5:
                if (obj.length() <= 48) {
                    AppMethodBeat.o(20882);
                    return true;
                }
                AppMethodBeat.o(20882);
                return false;
        }
    }

    private void gr(boolean z) {
        AppMethodBeat.i(20883);
        if (!this.ktR || Util.isNullOrNil(getText())) {
            switch (this.ktP) {
                case 0:
                case 1:
                case 4:
                    this.ktM.setVisibility(8);
                    AppMethodBeat.o(20883);
                    return;
                case 2:
                    this.ktM.setVisibility(0);
                    this.ktM.setContentDescription(getContext().getString(R.string.e7));
                    AppMethodBeat.o(20883);
                    return;
                case 3:
                    this.ktM.setVisibility(0);
                    this.ktM.setContentDescription(getContext().getString(R.string.fg));
                    AppMethodBeat.o(20883);
                    return;
                default:
                    this.ktM.setVisibility(8);
                    AppMethodBeat.o(20883);
                    return;
            }
        } else {
            this.ktM.setImageResource(R.drawable.a_5);
            this.ktM.setContentDescription(getContext().getString(R.string.b5m));
            switch (this.ktP) {
                case 0:
                case 1:
                case 4:
                case 5:
                    if (z) {
                        this.ktM.setVisibility(0);
                        AppMethodBeat.o(20883);
                        return;
                    }
                    this.ktM.setVisibility(8);
                    AppMethodBeat.o(20883);
                    return;
                case 2:
                    this.ktM.setVisibility(0);
                    this.ktM.setContentDescription(getContext().getString(R.string.e7));
                    AppMethodBeat.o(20883);
                    return;
                case 3:
                    this.ktM.setVisibility(0);
                    this.ktM.setContentDescription(getContext().getString(R.string.fg));
                    AppMethodBeat.o(20883);
                    return;
                default:
                    this.ktM.setVisibility(8);
                    AppMethodBeat.o(20883);
                    return;
            }
        }
    }

    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        AppMethodBeat.i(20884);
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.ktK = onFocusChangeListener;
        AppMethodBeat.o(20884);
    }

    public void setInfoIvOnClickListener(a aVar) {
        this.kua = aVar;
    }

    public void onFocusChange(View view, boolean z) {
        AppMethodBeat.i(20885);
        if (this.ktK != null) {
            this.ktK.onFocusChange(this, z);
        }
        Log.d("MicroMsg.InvoiceEditView", "View:" + this.ktO + ", editType:" + this.ktP + " onFocusChange to " + z);
        if (this.kub != null) {
            this.kub.bqh();
        }
        if (!this.ktT) {
            this.jBS.setEnabled(false);
        } else {
            this.jBS.setEnabled(true);
        }
        if (view == this.ktL) {
            Rect rect = new Rect();
            d(this, rect);
            if (z) {
                setBackgroundResource(R.drawable.ca2);
            } else {
                setBackgroundResource(R.drawable.ca3);
            }
            e(this, rect);
        }
        gr(z);
        AppMethodBeat.o(20885);
    }

    public void setHintStr(String str) {
        AppMethodBeat.i(20886);
        this.ktL.setHint(str);
        AppMethodBeat.o(20886);
    }

    public void setTipStr(String str) {
        AppMethodBeat.i(20887);
        this.jBS.setText(str);
        AppMethodBeat.o(20887);
    }

    public void setValStr(String str) {
        AppMethodBeat.i(20888);
        this.ktL.setText(str);
        this.ktL.setSelection(this.ktL.getText().length());
        this.ktX = str;
        AppMethodBeat.o(20888);
    }

    public void setBankNumberValStr(String str) {
        int i2 = 0;
        AppMethodBeat.i(20889);
        if (this.ktP == 5) {
            String replace = str.replace(" ", "");
            if (replace.length() >= 4) {
                StringBuilder sb = new StringBuilder();
                if (replace.length() % 4 == 0) {
                    while (i2 < (replace.length() / 4) - 1) {
                        sb.append(replace.substring(i2 * 4, (i2 + 1) * 4)).append(" ");
                        i2++;
                    }
                } else {
                    while (i2 < replace.length() / 4) {
                        sb.append(replace.substring(i2 * 4, (i2 + 1) * 4)).append(" ");
                        i2++;
                    }
                    str = sb.append(replace.substring((replace.length() / 4) * 4, replace.length())).toString();
                }
            }
        }
        this.ktL.setText(str);
        this.ktL.setSelection(this.ktL.getText().length());
        AppMethodBeat.o(20889);
    }

    public final boolean bqm() {
        AppMethodBeat.i(20890);
        if (getText().equals(Util.nullAsNil(this.ktX))) {
            AppMethodBeat.o(20890);
            return false;
        }
        AppMethodBeat.o(20890);
        return true;
    }

    public void setEditBG(int i2) {
        AppMethodBeat.i(20891);
        if (this.ktL != null) {
            Rect rect = new Rect();
            d(this.ktL, rect);
            this.ktL.setBackgroundResource(i2);
            e(this.ktL, rect);
        }
        AppMethodBeat.o(20891);
    }

    public void setTipTextColor(int i2) {
        AppMethodBeat.i(20892);
        if (this.jBS != null) {
            this.jBS.setTextColor(i2);
        }
        AppMethodBeat.o(20892);
    }

    public void setImeOptions(int i2) {
        AppMethodBeat.i(20893);
        this.ktL.setImeOptions(i2);
        AppMethodBeat.o(20893);
    }

    public void setInfoIvVisible(int i2) {
        AppMethodBeat.i(20894);
        this.ktM.setVisibility(i2);
        AppMethodBeat.o(20894);
    }

    private Rect getValidRectOfInfoIv() {
        AppMethodBeat.i(20895);
        Rect rect = new Rect();
        this.ktM.getHitRect(rect);
        rect.left -= 50;
        rect.right += 50;
        rect.top -= 25;
        rect.bottom += 25;
        AppMethodBeat.o(20895);
        return rect;
    }

    private static void d(View view, Rect rect) {
        AppMethodBeat.i(20896);
        rect.left = view.getPaddingLeft();
        rect.right = view.getPaddingRight();
        rect.top = view.getPaddingTop();
        rect.bottom = view.getPaddingBottom();
        AppMethodBeat.o(20896);
    }

    private static void e(View view, Rect rect) {
        AppMethodBeat.i(20897);
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        AppMethodBeat.o(20897);
    }
}
