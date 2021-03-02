package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.telephony.PhoneNumberUtils;
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
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;

public class AddrEditView extends RelativeLayout implements View.OnFocusChangeListener {
    private int background;
    private int gravity;
    private int imeOptions;
    private int inputType;
    private TextView jBS;
    private boolean kK;
    private a ktI;
    private b ktJ;
    private View.OnFocusChangeListener ktK;
    EditText ktL;
    private ImageView ktM;
    private String ktN;
    private String ktO;
    private int ktP;
    private int ktQ;
    public boolean ktR;
    private int ktS;
    private boolean ktT;
    private int ktU;
    private int ktV;
    private View.OnClickListener ktW;
    private String ktX;

    public interface a {
        void onClick();
    }

    public interface b {
        void bqh();
    }

    static /* synthetic */ void b(AddrEditView addrEditView, boolean z) {
        AppMethodBeat.i(20872);
        addrEditView.gr(z);
        AppMethodBeat.o(20872);
    }

    public AddrEditView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        AppMethodBeat.i(20850);
        this.ktN = "";
        this.ktO = "";
        this.inputType = 1;
        this.gravity = 19;
        this.ktP = -1;
        this.background = -1;
        this.ktQ = -1;
        this.ktR = true;
        this.ktT = false;
        this.ktU = 1;
        this.ktV = 30;
        this.kK = true;
        this.ktW = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.address.ui.AddrEditView.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(20849);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/AddrEditView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (AddrEditView.this.ktM.getVisibility() == 0) {
                    if (AddrEditView.this.ktR && AddrEditView.this.ktP != 2 && !Util.isNullOrNil(AddrEditView.this.getText())) {
                        AddrEditView.this.ktL.setText("");
                        AddrEditView.b(AddrEditView.this, AddrEditView.this.ktL.isFocused());
                    } else if (AddrEditView.this.ktI != null) {
                        AddrEditView.this.ktI.onClick();
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/AddrEditView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(20849);
            }
        };
        this.ktX = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.a.AddrEditView, i2, 0);
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.ce, (ViewGroup) this, true);
        this.ktL = (EditText) inflate.findViewById(R.id.dpf);
        this.ktL.setTextSize(0, (float) com.tencent.mm.cb.a.aG(context, R.dimen.is));
        this.jBS = (TextView) inflate.findViewById(R.id.ior);
        this.ktM = (ImageView) inflate.findViewById(R.id.dy5);
        this.ktM.setOnClickListener(this.ktW);
        this.ktL.setImeOptions(this.imeOptions);
        this.ktL.setInputType(this.inputType);
        if (this.inputType == 2) {
            this.ktL.setKeyListener(new NumberKeyListener() {
                /* class com.tencent.mm.plugin.address.ui.AddrEditView.AnonymousClass1 */

                public final int getInputType() {
                    return 3;
                }

                /* access modifiers changed from: protected */
                public final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                }
            });
        } else if (this.inputType == 3) {
            this.ktL.setKeyListener(new NumberKeyListener() {
                /* class com.tencent.mm.plugin.address.ui.AddrEditView.AnonymousClass2 */

                public final int getInputType() {
                    return 3;
                }

                /* access modifiers changed from: protected */
                public final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                }
            });
        } else {
            this.ktL.setInputType(this.inputType);
        }
        gr(this.ktL.isFocused());
        this.ktL.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.address.ui.AddrEditView.AnonymousClass3 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(20848);
                boolean bql = AddrEditView.this.bql();
                if (!(bql == AddrEditView.this.ktT || AddrEditView.this.ktJ == null)) {
                    Log.d("MicroMsg.AddrEditView", "View:" + AddrEditView.this.ktO + ", editType:" + AddrEditView.this.ktP + " inputValid change to " + bql);
                    AddrEditView.this.ktT = bql;
                    b bVar = AddrEditView.this.ktJ;
                    boolean unused = AddrEditView.this.ktT;
                    bVar.bqh();
                }
                AddrEditView.b(AddrEditView.this, AddrEditView.this.ktL.isFocused());
                AppMethodBeat.o(20848);
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
            setBackgroundResource(R.drawable.ai_);
            setPadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        } else {
            this.ktT = false;
            this.ktL.setBackgroundResource(this.ktQ);
            setBackgroundResource(this.background);
        }
        e(this.ktL, rect);
        this.ktL.setGravity(this.gravity);
        if (this.ktS != -1) {
            this.ktM.setImageDrawable(ar.m(context, this.ktS, context.getResources().getColor(R.color.FG_0)));
        }
        if (!this.kK) {
            this.ktL.setSingleLine(false);
        }
        AppMethodBeat.o(20850);
    }

    public AddrEditView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void bqk() {
        AppMethodBeat.i(231574);
        this.ktL.setHintTextColor(getContext().getResources().getColor(R.color.ac));
        this.ktL.setTextColor(getContext().getResources().getColor(R.color.ae));
        this.jBS.setTextColor(getContext().getResources().getColor(R.color.ae));
        if (this.ktS != -1) {
            this.ktM.setImageDrawable(ar.m(getContext(), this.ktS, getContext().getResources().getColor(R.color.ae)));
        }
        AppMethodBeat.o(231574);
    }

    public void setOnInputValidChangeListener(b bVar) {
        this.ktJ = bVar;
    }

    public String getText() {
        AppMethodBeat.i(20851);
        String obj = this.ktL.getText().toString();
        AppMethodBeat.o(20851);
        return obj;
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        AppMethodBeat.i(20852);
        this.ktL.setEllipsize(truncateAt);
        AppMethodBeat.o(20852);
    }

    public void setEnabled(boolean z) {
        AppMethodBeat.i(20853);
        super.setEnabled(z);
        this.ktR = z;
        this.ktM.setEnabled(true);
        AppMethodBeat.o(20853);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(20854);
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
                AppMethodBeat.o(20854);
                return true;
            }
        }
        AppMethodBeat.o(20854);
        return false;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(20855);
        super.setOnClickListener(onClickListener);
        AppMethodBeat.o(20855);
    }

    public final boolean bql() {
        String replaceAll;
        AppMethodBeat.i(20856);
        String obj = this.ktL.getText().toString();
        switch (this.ktP) {
            case 0:
            default:
                if (obj.length() >= this.ktU) {
                    AppMethodBeat.o(20856);
                    return true;
                }
                AppMethodBeat.o(20856);
                return false;
            case 1:
                if (obj.length() >= this.ktU && obj.length() <= this.ktV) {
                    if (obj == null) {
                        replaceAll = null;
                    } else {
                        replaceAll = obj.replaceAll("\\D", "");
                        if (replaceAll.startsWith("86")) {
                            replaceAll = replaceAll.substring(2);
                        }
                    }
                    if (PhoneNumberUtils.isGlobalPhoneNumber(replaceAll)) {
                        AppMethodBeat.o(20856);
                        return true;
                    }
                }
                AppMethodBeat.o(20856);
                return false;
            case 2:
                if (obj.length() < this.ktU || TE(obj) > 32) {
                    AppMethodBeat.o(20856);
                    return false;
                }
                AppMethodBeat.o(20856);
                return true;
            case 3:
            case 5:
                if (obj.length() < this.ktU || TE(obj) > 128) {
                    AppMethodBeat.o(20856);
                    return false;
                }
                AppMethodBeat.o(20856);
                return true;
            case 4:
                if (obj.length() <= this.ktV) {
                    AppMethodBeat.o(20856);
                    return true;
                }
                AppMethodBeat.o(20856);
                return false;
        }
    }

    private void gr(boolean z) {
        AppMethodBeat.i(20857);
        if (!this.ktR || Util.isNullOrNil(getText())) {
            switch (this.ktP) {
                case 0:
                case 1:
                    this.ktM.setVisibility(8);
                    AppMethodBeat.o(20857);
                    return;
                case 2:
                    this.ktM.setVisibility(0);
                    this.ktM.setImageResource(R.raw.icons_outlined_subscriptions);
                    this.ktM.setContentDescription(getContext().getString(R.string.e7));
                    AppMethodBeat.o(20857);
                    return;
                case 3:
                    this.ktM.setVisibility(0);
                    this.ktM.setImageResource(R.raw.icons_outlined_location);
                    this.ktM.setContentDescription(getContext().getString(R.string.fg));
                    AppMethodBeat.o(20857);
                    return;
                default:
                    this.ktM.setVisibility(8);
                    AppMethodBeat.o(20857);
                    return;
            }
        } else {
            this.ktM.setImageDrawable(at.aN(getContext(), R.attr.l1));
            this.ktM.setContentDescription(getContext().getString(R.string.b5m));
            switch (this.ktP) {
                case 0:
                case 1:
                    if (z) {
                        this.ktM.setVisibility(0);
                        AppMethodBeat.o(20857);
                        return;
                    }
                    this.ktM.setVisibility(8);
                    AppMethodBeat.o(20857);
                    return;
                case 2:
                    this.ktM.setVisibility(0);
                    this.ktM.setImageResource(R.raw.icons_outlined_subscriptions);
                    this.ktM.setContentDescription(getContext().getString(R.string.e7));
                    AppMethodBeat.o(20857);
                    return;
                case 3:
                    this.ktM.setVisibility(0);
                    this.ktM.setImageResource(R.raw.icons_outlined_location);
                    this.ktM.setContentDescription(getContext().getString(R.string.fg));
                    AppMethodBeat.o(20857);
                    return;
                default:
                    this.ktM.setVisibility(8);
                    AppMethodBeat.o(20857);
                    return;
            }
        }
    }

    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        AppMethodBeat.i(20858);
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.ktK = onFocusChangeListener;
        AppMethodBeat.o(20858);
    }

    public void setInfoIvOnClickListener(a aVar) {
        this.ktI = aVar;
    }

    public void onFocusChange(View view, boolean z) {
        AppMethodBeat.i(20859);
        if (this.ktK != null) {
            this.ktK.onFocusChange(this, z);
        }
        Log.d("MicroMsg.AddrEditView", "View:" + this.ktO + ", editType:" + this.ktP + " onFocusChange to " + z);
        if (this.ktJ != null) {
            this.ktJ.bqh();
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
        AppMethodBeat.o(20859);
    }

    public void setHintStr(String str) {
        AppMethodBeat.i(20860);
        this.ktL.setHint(str);
        AppMethodBeat.o(20860);
    }

    public void setTipStr(String str) {
        AppMethodBeat.i(20861);
        this.jBS.setText(str);
        AppMethodBeat.o(20861);
    }

    public void setValStr(String str) {
        AppMethodBeat.i(20862);
        this.ktL.setText(str);
        this.ktL.setSelection(this.ktL.getText().length());
        this.ktX = str;
        AppMethodBeat.o(20862);
    }

    public final boolean bqm() {
        AppMethodBeat.i(20863);
        if (getText().equals(Util.nullAsNil(this.ktX))) {
            AppMethodBeat.o(20863);
            return false;
        }
        AppMethodBeat.o(20863);
        return true;
    }

    public void setEditBG(int i2) {
        AppMethodBeat.i(20864);
        if (this.ktL != null) {
            Rect rect = new Rect();
            d(this.ktL, rect);
            this.ktL.setBackgroundResource(i2);
            e(this.ktL, rect);
        }
        AppMethodBeat.o(20864);
    }

    public void setTipTextColor(int i2) {
        AppMethodBeat.i(20865);
        if (this.jBS != null) {
            this.jBS.setTextColor(i2);
        }
        AppMethodBeat.o(20865);
    }

    public void setImeOptions(int i2) {
        AppMethodBeat.i(20866);
        this.ktL.setImeOptions(i2);
        AppMethodBeat.o(20866);
    }

    public void setInfoIvVisible(int i2) {
        AppMethodBeat.i(20867);
        this.ktM.setVisibility(i2);
        AppMethodBeat.o(20867);
    }

    private Rect getValidRectOfInfoIv() {
        AppMethodBeat.i(20868);
        Rect rect = new Rect();
        this.ktM.getHitRect(rect);
        rect.left -= 50;
        rect.right += 50;
        rect.top -= 25;
        rect.bottom += 25;
        AppMethodBeat.o(20868);
        return rect;
    }

    private static void d(View view, Rect rect) {
        AppMethodBeat.i(20869);
        rect.left = view.getPaddingLeft();
        rect.right = view.getPaddingRight();
        rect.top = view.getPaddingTop();
        rect.bottom = view.getPaddingBottom();
        AppMethodBeat.o(20869);
    }

    private static void e(View view, Rect rect) {
        AppMethodBeat.i(20870);
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        AppMethodBeat.o(20870);
    }

    private static int TE(String str) {
        int i2 = 0;
        AppMethodBeat.i(20871);
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (str.substring(i3, i3 + 1).matches("[Α-￥]")) {
                i2 += 2;
            } else {
                i2++;
            }
        }
        AppMethodBeat.o(20871);
        return i2;
    }
}
