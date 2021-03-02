package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;

public class InvoiceQrcodeTextView extends RelativeLayout implements View.OnFocusChangeListener {
    private int background;
    private int gravity;
    private int imeOptions;
    private int inputType;
    private TextView jBS;
    private boolean kK;
    private View.OnFocusChangeListener ktK;
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
    private int kud;
    public boolean kue;
    private a kur;
    private c kus;
    private b kut;
    TextView kuu;
    private int kuv;
    private int kuw;

    public interface a {
    }

    public interface b {
    }

    public interface c {
    }

    static /* synthetic */ void a(InvoiceQrcodeTextView invoiceQrcodeTextView, boolean z) {
        AppMethodBeat.i(231581);
        invoiceQrcodeTextView.gr(z);
        AppMethodBeat.o(231581);
    }

    public InvoiceQrcodeTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        AppMethodBeat.i(20929);
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
            /* class com.tencent.mm.plugin.address.ui.InvoiceQrcodeTextView.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(231580);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/InvoiceQrcodeTextView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (InvoiceQrcodeTextView.this.ktM.getVisibility() == 0) {
                    if (InvoiceQrcodeTextView.this.ktR && InvoiceQrcodeTextView.this.ktP != 2 && !Util.isNullOrNil(InvoiceQrcodeTextView.this.getText())) {
                        InvoiceQrcodeTextView.this.kuu.setText("");
                        InvoiceQrcodeTextView.a(InvoiceQrcodeTextView.this, InvoiceQrcodeTextView.this.kuu.isFocused());
                    } else if (InvoiceQrcodeTextView.this.kur != null) {
                        a unused = InvoiceQrcodeTextView.this.kur;
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/InvoiceQrcodeTextView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(231580);
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.awd, (ViewGroup) this, true);
        this.kuu = (TextView) inflate.findViewById(R.id.dpf);
        this.kuu.setTextSize(0, (float) com.tencent.mm.cb.a.aG(context, R.dimen.is));
        this.jBS = (TextView) inflate.findViewById(R.id.ior);
        this.ktM = (ImageView) inflate.findViewById(R.id.dy5);
        this.ktM.setOnClickListener(this.ktW);
        this.kuu.setImeOptions(this.imeOptions);
        if (!Util.isNullOrNil(this.ktN)) {
            this.kuu.setHint(this.ktN);
        }
        if (!Util.isNullOrNil(this.ktO)) {
            this.jBS.setText(this.ktO);
        }
        Rect rect = new Rect();
        d(this.kuu, rect);
        e(this.kuu, rect);
        setPadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        if (this.ktS != -1) {
            this.ktM.setImageResource(this.ktS);
        }
        if (!this.kK) {
            this.kuu.setSingleLine(false);
        }
        this.kuu.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.address.ui.InvoiceQrcodeTextView.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(231575);
                InvoiceQrcodeTextView.this.kuv = (int) motionEvent.getRawX();
                InvoiceQrcodeTextView.this.kuw = (int) motionEvent.getRawY();
                AppMethodBeat.o(231575);
                return false;
            }
        });
        this.kuu.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.tencent.mm.plugin.address.ui.InvoiceQrcodeTextView.AnonymousClass2 */

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(231579);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/InvoiceQrcodeTextView$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                final TextView textView = (TextView) view;
                if (textView.getText() != null) {
                    final CharSequence text = textView.getText();
                    SpannableString spannableString = new SpannableString(text);
                    spannableString.setSpan(new BackgroundColorSpan(textView.getContext().getResources().getColor(R.color.ws)), 0, text.length(), 33);
                    textView.setText(spannableString);
                    com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(textView.getContext(), textView);
                    aVar.QSs = new View.OnCreateContextMenuListener() {
                        /* class com.tencent.mm.plugin.address.ui.InvoiceQrcodeTextView.AnonymousClass2.AnonymousClass1 */

                        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                            AppMethodBeat.i(231576);
                            contextMenu.add(textView.getContext().getString(R.string.t_));
                            AppMethodBeat.o(231576);
                        }
                    };
                    aVar.HLY = new o.g() {
                        /* class com.tencent.mm.plugin.address.ui.InvoiceQrcodeTextView.AnonymousClass2.AnonymousClass2 */

                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(231577);
                            if (i2 == 0) {
                                ClipboardHelper.setText(textView.getText().toString());
                                h.cC(textView.getContext(), textView.getContext().getString(R.string.ta));
                            }
                            AppMethodBeat.o(231577);
                        }
                    };
                    aVar.QwU = new PopupWindow.OnDismissListener() {
                        /* class com.tencent.mm.plugin.address.ui.InvoiceQrcodeTextView.AnonymousClass2.AnonymousClass3 */

                        public final void onDismiss() {
                            AppMethodBeat.i(231578);
                            textView.setText(text);
                            AppMethodBeat.o(231578);
                        }
                    };
                    aVar.ez(InvoiceQrcodeTextView.this.kuv, InvoiceQrcodeTextView.this.kuw);
                }
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/address/ui/InvoiceQrcodeTextView$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(231579);
                return false;
            }
        });
        AppMethodBeat.o(20929);
    }

    public InvoiceQrcodeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void bqo() {
        AppMethodBeat.i(20930);
        setBackgroundResource(0);
        this.jBS.setTextColor(getResources().getColor(R.color.uj));
        this.kuu.setTextColor(getResources().getColor(R.color.a2x));
        this.kuu.setInputType(0);
        this.kuu.clearFocus();
        this.kuu.setSingleLine(false);
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.kuu.getWindowToken(), 0);
        AppMethodBeat.o(20930);
    }

    public void setOnInputValidChangeListener(c cVar) {
        this.kus = cVar;
    }

    public void setOnInputInvoiceTypeChangeListener(b bVar) {
        this.kut = bVar;
    }

    public String getText() {
        AppMethodBeat.i(20931);
        String charSequence = this.kuu.getText().toString();
        AppMethodBeat.o(20931);
        return charSequence;
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        AppMethodBeat.i(20932);
        this.kuu.setEllipsize(truncateAt);
        AppMethodBeat.o(20932);
    }

    public void setEnabled(boolean z) {
        AppMethodBeat.i(20933);
        super.setEnabled(z);
        this.ktR = z;
        this.ktM.setEnabled(true);
        AppMethodBeat.o(20933);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(20934);
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
                AppMethodBeat.o(20934);
                return true;
            }
        }
        AppMethodBeat.o(20934);
        return false;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(20935);
        super.setOnClickListener(onClickListener);
        AppMethodBeat.o(20935);
    }

    private void gr(boolean z) {
        AppMethodBeat.i(20936);
        if (!this.ktR || Util.isNullOrNil(getText())) {
            switch (this.ktP) {
                case 0:
                case 1:
                case 4:
                    this.ktM.setVisibility(8);
                    AppMethodBeat.o(20936);
                    return;
                case 2:
                    this.ktM.setVisibility(0);
                    this.ktM.setContentDescription(getContext().getString(R.string.e7));
                    AppMethodBeat.o(20936);
                    return;
                case 3:
                    this.ktM.setVisibility(0);
                    this.ktM.setContentDescription(getContext().getString(R.string.fg));
                    AppMethodBeat.o(20936);
                    return;
                default:
                    this.ktM.setVisibility(8);
                    AppMethodBeat.o(20936);
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
                        AppMethodBeat.o(20936);
                        return;
                    }
                    this.ktM.setVisibility(8);
                    AppMethodBeat.o(20936);
                    return;
                case 2:
                    this.ktM.setVisibility(0);
                    this.ktM.setContentDescription(getContext().getString(R.string.e7));
                    AppMethodBeat.o(20936);
                    return;
                case 3:
                    this.ktM.setVisibility(0);
                    this.ktM.setContentDescription(getContext().getString(R.string.fg));
                    AppMethodBeat.o(20936);
                    return;
                default:
                    this.ktM.setVisibility(8);
                    AppMethodBeat.o(20936);
                    return;
            }
        }
    }

    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        AppMethodBeat.i(20937);
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.ktK = onFocusChangeListener;
        AppMethodBeat.o(20937);
    }

    public void setInfoIvOnClickListener(a aVar) {
        this.kur = aVar;
    }

    public void onFocusChange(View view, boolean z) {
        AppMethodBeat.i(20938);
        if (this.ktK != null) {
            this.ktK.onFocusChange(this, z);
        }
        Log.d("MicroMsg.InvoiceEditView", "View:" + this.ktO + ", editType:" + this.ktP + " onFocusChange to " + z);
        if (!this.ktT) {
            this.jBS.setEnabled(false);
        } else {
            this.jBS.setEnabled(true);
        }
        if (view == this.kuu) {
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
        AppMethodBeat.o(20938);
    }

    public void setHintStr(String str) {
        AppMethodBeat.i(20939);
        this.kuu.setHint(str);
        AppMethodBeat.o(20939);
    }

    public void setTipStr(String str) {
        AppMethodBeat.i(20940);
        this.jBS.setText(str);
        AppMethodBeat.o(20940);
    }

    public void setValStr(String str) {
        AppMethodBeat.i(20941);
        this.kuu.setText(str);
        this.ktX = str;
        AppMethodBeat.o(20941);
    }

    public void setBankNumberValStr(String str) {
        AppMethodBeat.i(20942);
        if (this.ktP == 5) {
            String replace = str.replace(" ", "");
            if (replace.length() >= 4) {
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < replace.length() / 4; i2++) {
                    sb.append(replace.substring(i2 * 4, (i2 + 1) * 4)).append(" ");
                }
                str = sb.append(replace.substring((replace.length() / 4) * 4, replace.length())).toString();
            }
        }
        this.kuu.setText(str);
        AppMethodBeat.o(20942);
    }

    public void setEditBG(int i2) {
        AppMethodBeat.i(20943);
        if (this.kuu != null) {
            Rect rect = new Rect();
            d(this.kuu, rect);
            this.kuu.setBackgroundResource(i2);
            e(this.kuu, rect);
        }
        AppMethodBeat.o(20943);
    }

    public void setTipTextColor(int i2) {
        AppMethodBeat.i(20944);
        if (this.jBS != null) {
            this.jBS.setTextColor(i2);
        }
        AppMethodBeat.o(20944);
    }

    public void setImeOptions(int i2) {
        AppMethodBeat.i(20945);
        this.kuu.setImeOptions(i2);
        AppMethodBeat.o(20945);
    }

    public void setInfoIvVisible(int i2) {
        AppMethodBeat.i(20946);
        this.ktM.setVisibility(i2);
        AppMethodBeat.o(20946);
    }

    private Rect getValidRectOfInfoIv() {
        AppMethodBeat.i(20947);
        Rect rect = new Rect();
        this.ktM.getHitRect(rect);
        rect.left -= 50;
        rect.right += 50;
        rect.top -= 25;
        rect.bottom += 25;
        AppMethodBeat.o(20947);
        return rect;
    }

    private static void d(View view, Rect rect) {
        AppMethodBeat.i(20948);
        rect.left = view.getPaddingLeft();
        rect.right = view.getPaddingRight();
        rect.top = view.getPaddingTop();
        rect.bottom = view.getPaddingBottom();
        AppMethodBeat.o(20948);
    }

    private static void e(View view, Rect rect) {
        AppMethodBeat.i(20949);
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        AppMethodBeat.o(20949);
    }
}
