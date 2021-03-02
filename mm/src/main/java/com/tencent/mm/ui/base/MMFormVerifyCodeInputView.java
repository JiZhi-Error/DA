package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ae.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;

public class MMFormVerifyCodeInputView extends LinearLayout {
    private View.OnFocusChangeListener heD;
    private TextView jVO;
    private Button klC;
    private int layout;
    private Context mContext;
    private EditText nBD;
    private TextView nBE;
    private int nBF;
    private int nBG;
    private int nBH;
    private int nBI;
    private int nBJ;
    private int[] nBK;
    private View.OnClickListener nBL;
    private MTimerHandler timerHandler;

    static /* synthetic */ int f(MMFormVerifyCodeInputView mMFormVerifyCodeInputView) {
        int i2 = mMFormVerifyCodeInputView.nBJ;
        mMFormVerifyCodeInputView.nBJ = i2 - 1;
        return i2;
    }

    @TargetApi(11)
    public MMFormVerifyCodeInputView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        AppMethodBeat.i(141938);
        this.mContext = null;
        this.nBF = -1;
        this.nBG = -1;
        this.nBH = -1;
        this.layout = -1;
        this.nBI = 60;
        this.nBJ = this.nBI;
        this.heD = null;
        this.nBL = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0244a.FormItemView, i2, 0);
        this.nBG = obtainStyledAttributes.getResourceId(1, -1);
        this.nBF = obtainStyledAttributes.getResourceId(3, -1);
        this.nBH = obtainStyledAttributes.getResourceId(0, -1);
        this.layout = obtainStyledAttributes.getResourceId(2, this.layout);
        obtainStyledAttributes.recycle();
        inflate(context, this.layout, this);
        this.mContext = context;
        AppMethodBeat.o(141938);
    }

    public MMFormVerifyCodeInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void onFinishInflate() {
        AppMethodBeat.i(141939);
        super.onFinishInflate();
        this.jVO = (TextView) findViewById(R.id.ipm);
        this.nBD = (EditText) findViewById(R.id.bxz);
        this.nBE = (TextView) findViewById(R.id.inq);
        this.klC = (Button) findViewById(R.id.hkp);
        if (this.jVO == null || this.nBD == null || this.nBE == null || this.klC == null) {
            Log.w("MicroMsg.MMFormVerifyCodeInputView", "titleTV : %s, contentET : %s, timerTv: %s, sendSmsBtn: %s", this.jVO, this.nBD, this.nBE, this.klC);
        } else {
            if (this.nBF != -1) {
                this.jVO.setText(this.nBF);
            }
            if (this.nBG != -1) {
                this.nBD.setHint(this.nBG);
            }
            if (this.nBH != -1) {
                this.klC.setText(this.nBH);
            }
        }
        if (this.nBD != null) {
            this.nBD.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                /* class com.tencent.mm.ui.base.MMFormVerifyCodeInputView.AnonymousClass1 */

                public final void onFocusChange(View view, boolean z) {
                    AppMethodBeat.i(141935);
                    if (view == MMFormVerifyCodeInputView.this.nBD) {
                        MMFormVerifyCodeInputView.b(MMFormVerifyCodeInputView.this);
                        if (z) {
                            MMFormVerifyCodeInputView.this.setBackgroundResource(R.drawable.ca2);
                        } else {
                            MMFormVerifyCodeInputView.this.setBackgroundResource(R.drawable.ca3);
                        }
                        MMFormVerifyCodeInputView.c(MMFormVerifyCodeInputView.this);
                    }
                    if (MMFormVerifyCodeInputView.this.heD != null) {
                        MMFormVerifyCodeInputView.this.heD.onFocusChange(view, z);
                    }
                    AppMethodBeat.o(141935);
                }
            });
        }
        if (this.klC != null) {
            this.klC.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.base.MMFormVerifyCodeInputView.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(141936);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMFormVerifyCodeInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (MMFormVerifyCodeInputView.this.nBL != null) {
                        MMFormVerifyCodeInputView.this.nBL.onClick(view);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMFormVerifyCodeInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(141936);
                }
            });
        }
        AppMethodBeat.o(141939);
    }

    public void setFocusListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.heD = onFocusChangeListener;
    }

    public void setSendSmsBtnClickListener(View.OnClickListener onClickListener) {
        this.nBL = onClickListener;
    }

    public void setTitle(String str) {
        AppMethodBeat.i(141940);
        if (this.jVO != null) {
            this.jVO.setText(str);
            AppMethodBeat.o(141940);
            return;
        }
        Log.e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
        AppMethodBeat.o(141940);
    }

    public void setHint(String str) {
        AppMethodBeat.i(141941);
        if (this.nBD != null) {
            this.nBD.setHint(str);
            AppMethodBeat.o(141941);
            return;
        }
        Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
        AppMethodBeat.o(141941);
    }

    public void setTitle(int i2) {
        AppMethodBeat.i(141942);
        if (this.jVO != null) {
            this.jVO.setText(i2);
            AppMethodBeat.o(141942);
            return;
        }
        Log.e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
        AppMethodBeat.o(141942);
    }

    public void setHint(int i2) {
        AppMethodBeat.i(141943);
        if (this.nBD != null) {
            this.nBD.setHint(i2);
            AppMethodBeat.o(141943);
            return;
        }
        Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
        AppMethodBeat.o(141943);
    }

    public void setText(String str) {
        AppMethodBeat.i(141944);
        if (this.nBD != null) {
            this.nBD.setText(str);
            AppMethodBeat.o(141944);
            return;
        }
        Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
        AppMethodBeat.o(141944);
    }

    public void setImeOption(int i2) {
        AppMethodBeat.i(141945);
        if (this.nBD != null) {
            this.nBD.setImeOptions(i2);
            AppMethodBeat.o(141945);
            return;
        }
        Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
        AppMethodBeat.o(141945);
    }

    public void setSmsBtnText(int i2) {
        AppMethodBeat.i(141946);
        if (this.klC != null) {
            this.klC.setText(i2);
            AppMethodBeat.o(141946);
            return;
        }
        Log.e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
        AppMethodBeat.o(141946);
    }

    public void setSmsBtnText(String str) {
        AppMethodBeat.i(141947);
        if (this.klC != null) {
            this.klC.setText(str);
            AppMethodBeat.o(141947);
            return;
        }
        Log.e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
        AppMethodBeat.o(141947);
    }

    public final void bTu() {
        AppMethodBeat.i(141948);
        this.klC.setVisibility(8);
        this.nBE.setVisibility(0);
        this.nBE.setText(getContext().getString(R.string.f1p, Integer.valueOf(this.nBI)));
        if (this.timerHandler != null) {
            this.timerHandler.stopTimer();
            this.timerHandler.startTimer(1000);
            AppMethodBeat.o(141948);
        } else if (getContext() != null) {
            this.timerHandler = new MTimerHandler(getContext().getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.mm.ui.base.MMFormVerifyCodeInputView.AnonymousClass3 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(141937);
                    MMFormVerifyCodeInputView.f(MMFormVerifyCodeInputView.this);
                    MMFormVerifyCodeInputView.this.nBE.setText(MMFormVerifyCodeInputView.this.getContext().getString(R.string.f1p, Integer.valueOf(MMFormVerifyCodeInputView.this.nBJ)));
                    if (MMFormVerifyCodeInputView.this.nBJ == 0) {
                        MMFormVerifyCodeInputView.this.timerHandler.stopTimer();
                        MMFormVerifyCodeInputView.this.nBJ = MMFormVerifyCodeInputView.this.nBI;
                        MMFormVerifyCodeInputView.this.klC.setVisibility(0);
                        MMFormVerifyCodeInputView.this.nBE.setVisibility(8);
                    }
                    AppMethodBeat.o(141937);
                    return true;
                }
            }, true);
            this.timerHandler.startTimer(1000);
            AppMethodBeat.o(141948);
        } else {
            if (this.timerHandler != null) {
                this.timerHandler.stopTimer();
            }
            AppMethodBeat.o(141948);
        }
    }

    public final void reset() {
        AppMethodBeat.i(141949);
        if (this.timerHandler != null) {
            this.timerHandler.stopTimer();
        }
        this.nBD.setText("");
        this.nBE.setVisibility(8);
        this.nBJ = this.nBI;
        this.klC.setVisibility(0);
        AppMethodBeat.o(141949);
    }

    public void setInputType(int i2) {
        AppMethodBeat.i(141950);
        if (this.nBD != null) {
            this.nBD.setInputType(i2);
            AppMethodBeat.o(141950);
            return;
        }
        Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
        AppMethodBeat.o(141950);
    }

    public final void addTextChangedListener(TextWatcher textWatcher) {
        AppMethodBeat.i(141951);
        if (this.nBD != null) {
            this.nBD.addTextChangedListener(textWatcher);
            AppMethodBeat.o(141951);
            return;
        }
        Log.w("MicroMsg.MMFormVerifyCodeInputView", "watcher : %s, contentET : %s", textWatcher, this.nBD);
        AppMethodBeat.o(141951);
    }

    public Editable getText() {
        AppMethodBeat.i(141952);
        if (this.nBD != null) {
            Editable text = this.nBD.getText();
            AppMethodBeat.o(141952);
            return text;
        }
        Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
        AppMethodBeat.o(141952);
        return null;
    }

    public EditText getContentEditText() {
        return this.nBD;
    }

    public TextView getTitleTextView() {
        return this.jVO;
    }

    static /* synthetic */ void b(MMFormVerifyCodeInputView mMFormVerifyCodeInputView) {
        AppMethodBeat.i(141953);
        mMFormVerifyCodeInputView.nBK = new int[]{mMFormVerifyCodeInputView.getPaddingLeft(), mMFormVerifyCodeInputView.getPaddingTop(), mMFormVerifyCodeInputView.getPaddingRight(), mMFormVerifyCodeInputView.getPaddingBottom()};
        AppMethodBeat.o(141953);
    }

    static /* synthetic */ void c(MMFormVerifyCodeInputView mMFormVerifyCodeInputView) {
        AppMethodBeat.i(141954);
        if (mMFormVerifyCodeInputView.nBK != null) {
            mMFormVerifyCodeInputView.setPadding(mMFormVerifyCodeInputView.nBK[0], mMFormVerifyCodeInputView.nBK[1], mMFormVerifyCodeInputView.nBK[2], mMFormVerifyCodeInputView.nBK[3]);
        }
        AppMethodBeat.o(141954);
    }
}
