package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.y;
import com.tencent.mm.ui.widget.AutoMatchKeywordEditText;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;

public class ActionBarSearchView extends LinearLayout implements d {
    private TextWatcher KmA = new TextWatcher() {
        /* class com.tencent.mm.ui.tools.ActionBarSearchView.AnonymousClass1 */

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            EditText editText;
            AppMethodBeat.i(142986);
            ActionBarSearchView.a(ActionBarSearchView.this);
            y yVar = ActionBarSearchView.this.QoL;
            if (yVar.Qxp && (editText = yVar.Qxn.get()) != null) {
                if (((charSequence == null || charSequence.toString() == null || charSequence.toString().length() == 0) && (yVar.mText == null || yVar.mText.length() == 0)) || !(yVar.mText == null || charSequence == null || !yVar.mText.equals(charSequence.toString()))) {
                    Log.d("MicroMsg.WordsChecker", "text not change, new : %s, old : %s", charSequence, yVar.mText);
                } else {
                    yVar.mText = charSequence != null ? charSequence.toString() : "";
                    yVar.Qxm = y.o(yVar.mText, yVar.Qxo);
                    if (y.a(editText, yVar.Qxo)) {
                        Log.d("MicroMsg.WordsChecker", "decorate text succ.");
                    }
                }
            }
            if (ActionBarSearchView.this.QoM != null) {
                ActionBarSearchView.this.QoM.bey(charSequence == null ? "" : charSequence.toString());
            }
            AppMethodBeat.o(142986);
        }

        public final void afterTextChanged(Editable editable) {
        }
    };
    private boolean OxS = false;
    private View QoG;
    protected ActionBarEditText QoH;
    private ImageButton QoI;
    private c QoJ = c.CLEAR;
    private boolean QoK = false;
    private y QoL;
    private b QoM;
    private a QoN;
    private View.OnFocusChangeListener QoO = new View.OnFocusChangeListener() {
        /* class com.tencent.mm.ui.tools.ActionBarSearchView.AnonymousClass2 */

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.i(142987);
            Log.v("MicroMsg.ActionBarSearchView", "on edittext focus changed, hasFocus %B", Boolean.valueOf(z));
            if (ActionBarSearchView.this.QoP != null) {
                ActionBarSearchView.this.QoP.onFocusChange(view, z);
            }
            AppMethodBeat.o(142987);
        }
    };
    private View.OnFocusChangeListener QoP;
    private View.OnClickListener QoQ = new View.OnClickListener() {
        /* class com.tencent.mm.ui.tools.ActionBarSearchView.AnonymousClass3 */

        public final void onClick(View view) {
            AppMethodBeat.i(142988);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/ActionBarSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (c.CLEAR == ActionBarSearchView.this.QoJ) {
                Log.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is clear");
                ActionBarSearchView.this.CH(true);
                if (ActionBarSearchView.this.QoM != null) {
                    ActionBarSearchView.this.QoM.bnA();
                }
            } else {
                Log.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is voice search");
                if (ActionBarSearchView.this.QoM != null) {
                    ActionBarSearchView.this.QoM.gXt();
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/ActionBarSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(142988);
        }
    };
    private View.OnClickListener QoR = new View.OnClickListener() {
        /* class com.tencent.mm.ui.tools.ActionBarSearchView.AnonymousClass4 */

        public final void onClick(View view) {
            AppMethodBeat.i(142989);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/ActionBarSearchView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (ActionBarSearchView.this.QoN != null) {
                ActionBarSearchView.this.QoN.gXr();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/ActionBarSearchView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(142989);
        }
    };

    public interface a {
        void gXr();
    }

    public interface b {
        void bey(String str);

        void bnA();

        void gXs();

        void gXt();
    }

    static /* synthetic */ void a(ActionBarSearchView actionBarSearchView) {
        AppMethodBeat.i(143022);
        actionBarSearchView.gXn();
        AppMethodBeat.o(143022);
    }

    /* access modifiers changed from: package-private */
    public enum c {
        CLEAR,
        VOICE_SEARCH;

        public static c valueOf(String str) {
            AppMethodBeat.i(142995);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(142995);
            return cVar;
        }

        static {
            AppMethodBeat.i(142996);
            AppMethodBeat.o(142996);
        }
    }

    @Override // com.tencent.mm.ui.tools.d
    public void setFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.QoP = onFocusChangeListener;
    }

    public ActionBarSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(143000);
        init();
        AppMethodBeat.o(143000);
    }

    public ActionBarSearchView(Context context) {
        super(context);
        AppMethodBeat.i(143001);
        init();
        AppMethodBeat.o(143001);
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.bf;
    }

    private void init() {
        AppMethodBeat.i(143002);
        this.OxS = ao.isDarkMode();
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(getLayoutId(), (ViewGroup) this, true);
        this.QoG = findViewById(R.id.aib);
        this.QoG.setOnClickListener(this.QoR);
        this.QoH = (ActionBarEditText) findViewById(R.id.bxz);
        this.QoL = new y(this.QoH);
        this.QoH.setSearchView(this);
        this.QoH.post(new Runnable() {
            /* class com.tencent.mm.ui.tools.ActionBarSearchView.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(142990);
                ActionBarSearchView.this.QoH.setText("");
                if (ActionBarSearchView.this.QoM != null) {
                    ActionBarSearchView.this.QoM.gXs();
                }
                AppMethodBeat.o(142990);
            }
        });
        this.QoI = (ImageButton) findViewById(R.id.i59);
        this.QoH.addTextChangedListener(this.KmA);
        this.QoH.setOnKeyListener(new View.OnKeyListener() {
            /* class com.tencent.mm.ui.tools.ActionBarSearchView.AnonymousClass6 */

            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                boolean z;
                EditText editText;
                y.b aoo;
                AppMethodBeat.i(142991);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                bVar.pH(i2);
                bVar.bm(keyEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/ActionBarSearchView$6", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
                if (i2 == 67) {
                    Log.d("MicroMsg.ActionBarSearchView", "on back key click.");
                    y yVar = ActionBarSearchView.this.QoL;
                    if (!yVar.Qxp || (editText = yVar.Qxn.get()) == null || yVar.Qxm == null) {
                        z = false;
                    } else {
                        Editable text = editText.getText();
                        int selectionStart = editText.getSelectionStart();
                        if (selectionStart != editText.getSelectionEnd() || (aoo = yVar.aoo(selectionStart)) == null || !aoo.Qxs) {
                            z = false;
                        } else {
                            text.delete(aoo.start, aoo.start + aoo.length);
                            editText.setTextKeepState(text);
                            editText.setSelection(aoo.start);
                            z = true;
                        }
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(z, this, "com/tencent/mm/ui/tools/ActionBarSearchView$6", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                    AppMethodBeat.o(142991);
                    return z;
                }
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/tools/ActionBarSearchView$6", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(142991);
                return false;
            }
        });
        this.QoH.setOnSelectionChangeListener(new AutoMatchKeywordEditText.a() {
            /* class com.tencent.mm.ui.tools.ActionBarSearchView.AnonymousClass7 */

            @Override // com.tencent.mm.ui.widget.AutoMatchKeywordEditText.a
            public final void b(EditText editText, int i2, int i3) {
                EditText editText2;
                AppMethodBeat.i(142992);
                Log.d("MicroMsg.ActionBarSearchView", "start : %d, stop : %d", Integer.valueOf(i2), Integer.valueOf(i3));
                y yVar = ActionBarSearchView.this.QoL;
                if (!yVar.Qxp || (editText2 = yVar.Qxn.get()) == null || editText != editText2) {
                    AppMethodBeat.o(142992);
                    return;
                }
                Editable text = editText2.getText();
                int selectionStart = editText2.getSelectionStart();
                int selectionEnd = editText2.getSelectionEnd();
                if (selectionStart < 0 || selectionEnd < selectionStart) {
                    AppMethodBeat.o(142992);
                } else if (selectionStart == selectionEnd) {
                    y.b aoo = yVar.aoo(selectionStart);
                    if (aoo != null && aoo.Qxs) {
                        editText2.setTextKeepState(text);
                        editText2.setSelection(aoo.length + aoo.start);
                    }
                    AppMethodBeat.o(142992);
                } else {
                    y.b aoo2 = yVar.aoo(selectionStart);
                    if (aoo2 != null && aoo2.Qxs) {
                        selectionStart = aoo2.start + aoo2.length;
                    }
                    if (selectionStart >= selectionEnd) {
                        editText2.setTextKeepState(text);
                        editText2.setSelection(selectionStart);
                        AppMethodBeat.o(142992);
                        return;
                    }
                    y.b aoo3 = yVar.aoo(selectionEnd);
                    if (aoo3 != null && aoo3.Qxs) {
                        int i4 = aoo3.start;
                        editText2.setTextKeepState(text);
                        editText2.setSelection(selectionStart, i4);
                    }
                    AppMethodBeat.o(142992);
                }
            }
        });
        this.QoH.setOnFocusChangeListener(this.QoO);
        com.tencent.mm.ui.tools.b.c.f(this.QoH).aoq(100).a((c.a) null);
        this.QoI.setOnClickListener(this.QoQ);
        if (this.QoI.getDrawable() != null) {
            this.QoI.getDrawable().setColorFilter(getResources().getColor(R.color.FG_0), PorterDuff.Mode.SRC_ATOP);
        }
        AppMethodBeat.o(143002);
    }

    public final void hYb() {
        AppMethodBeat.i(259387);
        findViewById(R.id.jsx).setBackgroundColor(getResources().getColor(R.color.w));
        findViewById(R.id.hej).setBackgroundResource(R.drawable.ctf);
        ((TextView) this.QoG).setTextColor(Color.parseColor("#7D90A9"));
        ((WeImageView) findViewById(R.id.he6)).setIconColor(Color.parseColor("#6B6B6B"));
        this.QoH.setTextColor(Color.parseColor("#CCFFFFFF"));
        this.QoH.setHintTextColor(Color.parseColor("#4DFFFFFF"));
        AppMethodBeat.o(259387);
    }

    @Override // com.tencent.mm.ui.tools.d
    public String getSearchContent() {
        AppMethodBeat.i(143003);
        if (this.QoH.getEditableText() != null) {
            String obj = this.QoH.getEditableText().toString();
            AppMethodBeat.o(143003);
            return obj;
        }
        AppMethodBeat.o(143003);
        return "";
    }

    @Override // com.tencent.mm.ui.tools.d
    public void setCallBack(b bVar) {
        this.QoM = bVar;
    }

    @Override // com.tencent.mm.ui.tools.d
    public void setBackClickCallback(a aVar) {
        this.QoN = aVar;
    }

    @Override // com.tencent.mm.ui.tools.d
    public void setSearchContent(String str) {
        AppMethodBeat.i(143004);
        if (str == null) {
            str = "";
        }
        this.QoH.setText(str);
        this.QoH.setSelection(str.length());
        AppMethodBeat.o(143004);
    }

    @Override // com.tencent.mm.ui.tools.d
    public void setHint(CharSequence charSequence) {
        AppMethodBeat.i(143005);
        this.QoH.setHint(charSequence);
        AppMethodBeat.o(143005);
    }

    @Override // com.tencent.mm.ui.tools.d
    public final void CG(boolean z) {
        AppMethodBeat.i(143006);
        this.QoK = z;
        gXn();
        AppMethodBeat.o(143006);
    }

    @Override // com.tencent.mm.ui.tools.d
    public void setEditTextEnabled(boolean z) {
        AppMethodBeat.i(143007);
        this.QoH.setEnabled(z);
        AppMethodBeat.o(143007);
    }

    @Override // com.tencent.mm.ui.tools.d
    public void setStatusBtnEnabled(boolean z) {
        AppMethodBeat.i(143008);
        this.QoI.setEnabled(z);
        AppMethodBeat.o(143008);
    }

    private void lq(int i2, int i3) {
        AppMethodBeat.i(143009);
        this.QoI.setImageResource(i2);
        this.QoI.setBackgroundResource(0);
        if (i2 == R.drawable.b2s) {
            this.QoI.setContentDescription(getContext().getString(R.string.hyu));
        } else {
            this.QoI.setContentDescription(getContext().getString(R.string.b5m));
        }
        ViewGroup.LayoutParams layoutParams = this.QoI.getLayoutParams();
        layoutParams.width = i3;
        this.QoI.setLayoutParams(layoutParams);
        AppMethodBeat.o(143009);
    }

    private void gXn() {
        AppMethodBeat.i(143010);
        if (this.QoH.getEditableText() != null && !Util.isNullOrNil(this.QoH.getEditableText().toString())) {
            lq(R.drawable.as6, getResources().getDimensionPixelSize(R.dimen.ip));
            this.QoJ = c.CLEAR;
            AppMethodBeat.o(143010);
        } else if (this.QoK) {
            lq(R.drawable.b2s, getResources().getDimensionPixelSize(R.dimen.ip));
            this.QoJ = c.VOICE_SEARCH;
            AppMethodBeat.o(143010);
        } else {
            lq(0, 0);
            this.QoJ = c.CLEAR;
            AppMethodBeat.o(143010);
        }
    }

    @Override // com.tencent.mm.ui.tools.d
    public void setOnEditorActionListener(TextView.OnEditorActionListener onEditorActionListener) {
        AppMethodBeat.i(143011);
        this.QoH.setOnEditorActionListener(onEditorActionListener);
        AppMethodBeat.o(143011);
    }

    @Override // com.tencent.mm.ui.tools.d
    public final void CH(boolean z) {
        AppMethodBeat.i(143012);
        if (!z) {
            this.QoH.removeTextChangedListener(this.KmA);
            this.QoH.setText("");
            this.QoH.addTextChangedListener(this.KmA);
            AppMethodBeat.o(143012);
            return;
        }
        this.QoH.setText("");
        AppMethodBeat.o(143012);
    }

    @Override // com.tencent.mm.ui.tools.d
    public final void gXo() {
        AppMethodBeat.i(143013);
        this.QoH.clearFocus();
        AppMethodBeat.o(143013);
    }

    public static class ActionBarEditText extends AutoMatchKeywordEditText {
        private ActionBarSearchView QoT;

        public ActionBarEditText(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
        }

        public ActionBarEditText(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void setSearchView(ActionBarSearchView actionBarSearchView) {
            this.QoT = actionBarSearchView;
        }

        @Override // com.tencent.mm.ui.widget.MMEditText
        public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
            AppMethodBeat.i(142993);
            Log.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme");
            if (i2 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    Log.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action down");
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    AppMethodBeat.o(142993);
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    Log.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up");
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        Log.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up is tracking");
                        this.QoT.clearFocus();
                        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
                        if (inputMethodManager != null) {
                            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                        }
                        AppMethodBeat.o(142993);
                        return true;
                    }
                }
            }
            boolean onKeyPreIme = super.onKeyPreIme(i2, keyEvent);
            AppMethodBeat.o(142993);
            return onKeyPreIme;
        }
    }

    @Override // com.tencent.mm.ui.tools.d
    public void setNotRealCallBack(SearchViewNotRealTimeHelper.a aVar) {
    }

    @Override // com.tencent.mm.ui.tools.d
    public final boolean gXp() {
        AppMethodBeat.i(143014);
        if (this.QoH != null) {
            boolean hasFocus = this.QoH.hasFocus();
            AppMethodBeat.o(143014);
            return hasFocus;
        }
        AppMethodBeat.o(143014);
        return false;
    }

    @Override // com.tencent.mm.ui.tools.d
    public final boolean gXq() {
        AppMethodBeat.i(143015);
        if (this.QoH != null) {
            boolean requestFocus = this.QoH.requestFocus();
            AppMethodBeat.o(143015);
            return requestFocus;
        }
        AppMethodBeat.o(143015);
        return false;
    }

    public void setEditTextClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(143016);
        if (this.QoH != null) {
            this.QoH.setFocusable(false);
            this.QoH.setOnClickListener(onClickListener);
        }
        AppMethodBeat.o(143016);
    }

    @Override // com.tencent.mm.ui.tools.d
    public void setKeywords(ArrayList<String> arrayList) {
        EditText editText;
        AppMethodBeat.i(143017);
        if (this.QoL != null) {
            y yVar = this.QoL;
            yVar.Qxo = arrayList;
            if (yVar.Qxp && (editText = yVar.Qxn.get()) != null) {
                y.a(editText, yVar.Qxo);
            }
        }
        AppMethodBeat.o(143017);
    }

    @Override // com.tencent.mm.ui.tools.d
    public void setAutoMatchKeywords(boolean z) {
        if (this.QoL != null) {
            this.QoL.Qxp = z;
        }
    }

    @Override // com.tencent.mm.ui.tools.d
    public void setSearchTipIcon(int i2) {
        AppMethodBeat.i(143018);
        if (this.QoH != null) {
            this.QoH.setCompoundDrawables(MMApplicationContext.getResources().getDrawable(i2), null, null, null);
        }
        AppMethodBeat.o(143018);
    }

    @Override // com.tencent.mm.ui.tools.d
    public void setSelectedTag(String str) {
        AppMethodBeat.i(143019);
        if (this.QoH != null) {
            this.QoH.setCompoundDrawables(new d(this.QoH, str), null, null, null);
            this.QoH.setHint("");
        }
        AppMethodBeat.o(143019);
    }

    public int getSelectionStart() {
        AppMethodBeat.i(143020);
        if (this.QoH != null) {
            int selectionStart = this.QoH.getSelectionStart();
            AppMethodBeat.o(143020);
            return selectionStart;
        }
        AppMethodBeat.o(143020);
        return -1;
    }

    public int getSelectionEnd() {
        AppMethodBeat.i(143021);
        if (this.QoH != null) {
            int selectionEnd = this.QoH.getSelectionEnd();
            AppMethodBeat.o(143021);
            return selectionEnd;
        }
        AppMethodBeat.o(143021);
        return -1;
    }

    class d extends Drawable {
        private RectF JkS;
        private int QoX = BackwardSupportUtil.BitmapFactory.fromDPToPix(MMApplicationContext.getContext(), 2.0f);
        private float QoY;
        private float QoZ;
        private String mText;
        private Paint zbt;

        d(EditText editText, String str) {
            AppMethodBeat.i(142997);
            this.zbt = new Paint(editText.getPaint());
            this.mText = str;
            this.zbt.setColor(MMApplicationContext.getResources().getColor(R.color.g7));
            this.QoY = this.zbt.measureText(this.mText);
            Paint.FontMetrics fontMetrics = this.zbt.getFontMetrics();
            this.QoZ = (float) Math.ceil((double) (fontMetrics.bottom - fontMetrics.top));
            setBounds(0, 0, (int) (this.QoY + ((float) (this.QoX * 2)) + ((float) (this.QoX * 2)) + 2.0f), (int) this.QoZ);
            AppMethodBeat.o(142997);
        }

        public final void draw(Canvas canvas) {
            AppMethodBeat.i(142998);
            Paint.FontMetricsInt fontMetricsInt = this.zbt.getFontMetricsInt();
            Rect bounds = getBounds();
            int i2 = bounds.right;
            int i3 = bounds.left;
            float f2 = this.JkS.right;
            float f3 = this.JkS.left;
            canvas.drawText(this.mText, (float) (bounds.left + 2), (float) ((bounds.top + ((((bounds.bottom - bounds.top) - fontMetricsInt.bottom) + fontMetricsInt.top) / 2)) - fontMetricsInt.top), this.zbt);
            AppMethodBeat.o(142998);
        }

        public final void setBounds(int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(142999);
            super.setBounds(i2, i3, i4, i5);
            Paint.FontMetrics fontMetrics = this.zbt.getFontMetrics();
            this.JkS = new RectF((float) (this.QoX + i2), (fontMetrics.ascent - fontMetrics.top) + ((float) i3), (float) (i4 - this.QoX), (float) i5);
            invalidateSelf();
            AppMethodBeat.o(142999);
        }

        public final void setAlpha(int i2) {
        }

        public final void setColorFilter(ColorFilter colorFilter) {
        }

        public final int getOpacity() {
            return -3;
        }
    }
}
