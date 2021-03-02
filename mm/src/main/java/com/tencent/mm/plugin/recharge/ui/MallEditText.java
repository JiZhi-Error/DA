package com.tencent.mm.plugin.recharge.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MallEditText extends LinearLayout implements View.OnFocusChangeListener {
    private b BDC;
    AutoCompleteTextView BDD;
    boolean BDE;
    private a BDF;
    private List<String[]> BDG;
    private com.tencent.mm.plugin.recharge.model.a BDH;
    private Runnable BDI;
    private boolean BDJ;
    private int BDK;
    private int gravity;
    private TextView hXv;
    private int imeOptions;
    private int inputType;
    private View.OnFocusChangeListener ktK;
    private ImageView ktM;
    private String ktN;
    private String ktO;
    private int ktP;
    public boolean ktR;
    private boolean ktT;
    private int ktU;
    private int ktV;
    private boolean maw;

    public interface b {
        void eHR();

        void onInputValidChange(boolean z);
    }

    static /* synthetic */ void c(MallEditText mallEditText) {
        AppMethodBeat.i(67153);
        mallEditText.eHP();
        AppMethodBeat.o(67153);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public MallEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        AppMethodBeat.i(67135);
        this.BDF = null;
        this.ktN = "";
        this.ktO = "";
        this.inputType = 1;
        this.maw = true;
        this.ktV = -1;
        this.ktU = 1;
        this.gravity = 19;
        this.ktP = -1;
        this.ktT = false;
        this.BDH = null;
        this.ktR = true;
        this.BDI = null;
        this.BDJ = false;
        this.BDK = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C2011a.MallEditText, i2, 0);
        int resourceId = obtainStyledAttributes.getResourceId(7, 0);
        if (resourceId != 0) {
            this.ktN = context.getString(resourceId);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(8, 0);
        if (resourceId2 != 0) {
            this.ktO = context.getString(resourceId2);
        }
        this.inputType = obtainStyledAttributes.getInteger(4, 1);
        this.ktR = obtainStyledAttributes.getBoolean(3, true);
        this.gravity = obtainStyledAttributes.getInt(0, 19);
        this.maw = obtainStyledAttributes.getBoolean(1, true);
        this.ktV = obtainStyledAttributes.getInteger(2, -1);
        this.ktP = obtainStyledAttributes.getInteger(6, 0);
        this.imeOptions = obtainStyledAttributes.getInteger(5, 5);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(R.layout.bl9, (ViewGroup) this, true);
        this.hXv = (TextView) inflate.findViewById(R.id.j1u);
        this.BDD = (AutoCompleteTextView) inflate.findViewById(R.id.dpf);
        if (com.tencent.mm.cb.a.jk(context)) {
            this.BDD.setTextSize(0, ((float) context.getResources().getDimensionPixelSize(R.dimen.is)) * com.tencent.mm.cb.a.iZ(getContext()));
        } else {
            this.BDD.setTextSize(0, (float) com.tencent.mm.cb.a.aG(context, R.dimen.is));
        }
        this.ktM = (ImageView) inflate.findViewById(R.id.dy5);
        Log.d("MicroMsg.MallEditText", "setFormat editType:" + this.ktP);
        this.BDD.setImeOptions(this.imeOptions);
        switch (this.ktP) {
            case 0:
                if (!this.ktR) {
                    this.ktM.setImageResource(R.drawable.aie);
                    this.ktM.setVisibility(0);
                }
                this.inputType = 1;
                break;
            case 1:
                this.ktU = 13;
                this.ktV = 13;
                this.inputType = 2;
                setInfoTvImageResource(R.drawable.aqm);
                this.ktM.setVisibility(0);
                break;
            default:
                this.inputType = 1;
                break;
        }
        this.BDD.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.recharge.ui.MallEditText.AnonymousClass1 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(67116);
                String charSequence2 = charSequence.toString();
                int selectionStart = MallEditText.this.BDD.getSelectionStart();
                String str = "";
                if (charSequence2 != null) {
                    StringBuilder sb = new StringBuilder(charSequence2.replaceAll(" ", ""));
                    int length = sb.length();
                    if (length >= 4) {
                        sb.insert(3, ' ');
                    }
                    if (length >= 8) {
                        sb.insert(8, ' ');
                    }
                    str = sb.toString();
                    int length2 = str.length();
                    if (length2 > MallEditText.this.BDK) {
                        if ((selectionStart == 4 || selectionStart == 9) && i4 == 1) {
                            selectionStart++;
                        } else if ((selectionStart == 4 || selectionStart == 9) && i4 > 1) {
                            selectionStart += i4;
                        }
                    } else if (length2 < MallEditText.this.BDK && (selectionStart == 4 || selectionStart == 9)) {
                        selectionStart--;
                    }
                    MallEditText.this.BDK = length2;
                }
                if (!charSequence2.equals(str)) {
                    MallEditText.this.BDD.setText(str);
                    if (selectionStart < MallEditText.this.BDK) {
                        MallEditText.this.BDD.setSelection(selectionStart);
                        AppMethodBeat.o(67116);
                        return;
                    }
                    MallEditText.this.BDD.setSelection(MallEditText.this.BDK);
                    AppMethodBeat.o(67116);
                    return;
                }
                MallEditText.c(MallEditText.this);
                AppMethodBeat.o(67116);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.BDD.setOnFocusChangeListener(this);
        if (!Util.isNullOrNil(this.ktN)) {
            this.BDD.setHint(this.ktN);
        }
        if (this.inputType == 2) {
            this.BDD.setKeyListener(new NumberKeyListener() {
                /* class com.tencent.mm.plugin.recharge.ui.MallEditText.AnonymousClass2 */

                public final int getInputType() {
                    return 3;
                }

                /* access modifiers changed from: protected */
                public final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ' '};
                }
            });
        } else {
            this.BDD.setInputType(this.inputType);
            this.BDD.setRawInputType(this.inputType);
        }
        this.BDD.setGravity(this.gravity);
        if (!this.maw) {
            this.BDD.setEnabled(false);
            this.BDD.setTextColor(getResources().getColor(R.color.a2x));
            this.BDD.setFocusable(false);
            this.BDD.setClickable(false);
        }
        if (!this.ktR) {
            this.ktT = true;
            this.BDD.setEnabled(false);
            this.BDD.setFocusable(false);
            this.BDD.setClickable(false);
        } else {
            this.ktT = false;
        }
        if (this.ktV != -1) {
            this.BDD.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.ktV)});
        }
        Log.d("MicroMsg.MallEditText", "initData editType:" + this.ktP);
        switch (this.ktP) {
            case 1:
                Log.d("MicroMsg.MallEditText", "setMobileEditTv");
                List<com.tencent.mm.plugin.recharge.model.a> eHM = com.tencent.mm.plugin.recharge.a.a.eHL().eHM();
                this.BDF = new a(this, (byte) 0);
                this.BDF.ga(eHM);
                if (eHM != null && eHM.size() > 0) {
                    this.BDH = eHM.get(0);
                    setInput(this.BDH);
                } else if (this.BDG == null) {
                    new Runnable() {
                        /* class com.tencent.mm.plugin.recharge.ui.MallEditText.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(67117);
                            try {
                                MallEditText.this.BDG = com.tencent.mm.pluginsdk.b.dO(MallEditText.this.getContext());
                                AppMethodBeat.o(67117);
                            } catch (Exception e2) {
                                Log.printErrStackTrace("MicroMsg.MallEditText", e2, "", new Object[0]);
                                AppMethodBeat.o(67117);
                            }
                        }
                    }.run();
                }
                if (eHM == null || eHM.size() == 0) {
                    g.aAi();
                    this.BDD.setText((String) g.aAh().azQ().get(6, (Object) null));
                    this.BDD.setSelection(this.BDD.getText().length());
                    eHP();
                }
                this.BDD.setAdapter(this.BDF);
                this.BDD.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    /* class com.tencent.mm.plugin.recharge.ui.MallEditText.AnonymousClass4 */

                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                        AppMethodBeat.i(67118);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(adapterView);
                        bVar.bm(view);
                        bVar.pH(i2);
                        bVar.zo(j2);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/MallEditText$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                        MallEditText.this.BDH = MallEditText.this.BDF.Vp(i2);
                        if (MallEditText.this.BDH != null) {
                            Log.d("MicroMsg.MallEditText", "onItemClick record.record " + MallEditText.this.BDH.BCX + ", record.name " + MallEditText.this.BDH.name);
                            MallEditText.this.setInput(MallEditText.this.BDH);
                        }
                        MallEditText.this.BDD.dismissDropDown();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/MallEditText$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(67118);
                    }
                });
                break;
        }
        AppMethodBeat.o(67135);
    }

    public MallEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setOnInputValidChangeListener(b bVar) {
        this.BDC = bVar;
    }

    public void setHintStr(String str) {
        AppMethodBeat.i(67136);
        this.BDD.setHint(str);
        AppMethodBeat.o(67136);
    }

    public void setInfoTvOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(67137);
        this.ktM.setOnClickListener(onClickListener);
        AppMethodBeat.o(67137);
    }

    public void setInfoTvImageResource(int i2) {
        AppMethodBeat.i(67138);
        this.BDE = i2 == R.drawable.a_5;
        this.ktM.setImageResource(i2);
        AppMethodBeat.o(67138);
    }

    public void setInput(com.tencent.mm.plugin.recharge.model.a aVar) {
        AppMethodBeat.i(67139);
        this.BDH = aVar;
        if (aVar != null) {
            this.BDD.setText(aVar.BCX);
            this.BDD.setSelection(this.BDD.getText().length());
            eHP();
            Log.d("MicroMsg.MallEditText", "editTv.setText " + aVar.BCX + ", name " + aVar.name + ", isInputValid " + this.ktT);
            if (Util.isNullOrNil(aVar.name) || !this.ktT) {
                this.hXv.setText("");
                this.hXv.setVisibility(8);
                AppMethodBeat.o(67139);
                return;
            }
            this.hXv.setText(aVar.name);
            this.hXv.setVisibility(0);
            AppMethodBeat.o(67139);
            return;
        }
        this.BDD.setText("");
        eHP();
        Log.d("MicroMsg.MallEditText", "editTv.setText null");
        this.hXv.setText("");
        this.hXv.setVisibility(8);
        AppMethodBeat.o(67139);
    }

    private void setInputForce(com.tencent.mm.plugin.recharge.model.a aVar) {
        AppMethodBeat.i(67140);
        this.BDH = aVar;
        if (aVar != null) {
            KeyListener keyListener = this.BDD.getKeyListener();
            this.BDD.setKeyListener(null);
            this.BDD.setText(aVar.BCX);
            this.BDD.setSelection(this.BDD.getText().length());
            this.BDD.setKeyListener(keyListener);
            eHP();
            Log.d("MicroMsg.MallEditText", "editTv.setText " + aVar.BCX + ", name " + aVar.name + ", isInputValid " + this.ktT);
            if (Util.isNullOrNil(aVar.name) || !this.ktT) {
                this.hXv.setText("");
                this.hXv.setVisibility(8);
                AppMethodBeat.o(67140);
                return;
            }
            this.hXv.setText(aVar.name);
            this.hXv.setVisibility(0);
            AppMethodBeat.o(67140);
            return;
        }
        this.BDD.setText("");
        eHP();
        Log.d("MicroMsg.MallEditText", "editTv.setText null");
        this.hXv.setText("");
        this.hXv.setVisibility(8);
        AppMethodBeat.o(67140);
    }

    private void eHP() {
        AppMethodBeat.i(67141);
        boolean bql = bql();
        if (bql != this.ktT) {
            Log.d("MicroMsg.MallEditText", "View:" + this.ktO + ", editType:" + this.ktP + " inputValid change to " + bql);
            this.ktT = bql;
            if (this.BDC != null) {
                this.BDC.onInputValidChange(this.ktT);
            }
            if (!bql) {
                if (this.hXv.getVisibility() == 0) {
                    this.hXv.setText("");
                    this.hXv.setVisibility(8);
                }
                this.BDH = null;
            }
        }
        if (this.BDC != null) {
            this.BDC.eHR();
        }
        AppMethodBeat.o(67141);
    }

    public String getText() {
        AppMethodBeat.i(67142);
        switch (this.ktP) {
            case 1:
                String nullAs = Util.nullAs(this.BDD.getText().toString(), "");
                AppMethodBeat.o(67142);
                return nullAs;
            default:
                String nullAs2 = Util.nullAs(this.BDD.getText().toString(), "");
                AppMethodBeat.o(67142);
                return nullAs2;
        }
    }

    public final boolean bql() {
        AppMethodBeat.i(67143);
        switch (this.ktP) {
            case 1:
                String obj = this.BDD.getText().toString();
                if (obj.length() < this.ktU || obj.length() > this.ktV || !PhoneNumberUtils.isGlobalPhoneNumber(com.tencent.mm.plugin.recharge.model.b.Ts(obj))) {
                    AppMethodBeat.o(67143);
                    return false;
                }
                AppMethodBeat.o(67143);
                return true;
            default:
                if (this.BDD.getText().length() >= this.ktU) {
                    AppMethodBeat.o(67143);
                    return true;
                }
                AppMethodBeat.o(67143);
                return false;
        }
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        AppMethodBeat.i(67144);
        this.BDD.setEllipsize(truncateAt);
        AppMethodBeat.o(67144);
    }

    public final boolean eHQ() {
        AppMethodBeat.i(67145);
        if (getVisibility() != 0) {
            AppMethodBeat.o(67145);
            return true;
        } else if (Util.isNullOrNil(getText())) {
            Log.d("MicroMsg.MallEditText", "View:" + this.ktO + ", editType:" + this.ktP + " checkInputValid : empty ");
            AppMethodBeat.o(67145);
            return false;
        } else if (this.ktT) {
            AppMethodBeat.o(67145);
            return true;
        } else {
            Log.d("MicroMsg.MallEditText", "View:" + this.ktO + ", editType:" + this.ktP + " checkInputValid : illegal ");
            AppMethodBeat.o(67145);
            return false;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.ktR) {
            return false;
        }
        return true;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(67146);
        super.setOnClickListener(onClickListener);
        this.BDD.setOnClickListener(onClickListener);
        AppMethodBeat.o(67146);
    }

    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        AppMethodBeat.i(67147);
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.ktK = onFocusChangeListener;
        AppMethodBeat.o(67147);
    }

    public void onFocusChange(View view, boolean z) {
        AppMethodBeat.i(67148);
        if (this.ktK != null) {
            this.ktK.onFocusChange(this, z);
        }
        if ((!this.BDJ) == z && !z && this.BDI != null) {
            this.BDI.run();
        }
        this.BDJ = z;
        Log.d("MicroMsg.MallEditText", "View:" + this.ktO + ", editType:" + this.ktP + " onFocusChange to " + z);
        if (this.BDC != null) {
            this.BDC.onInputValidChange(this.ktT);
        }
        AppMethodBeat.o(67148);
    }

    public void setImeOptions(int i2) {
        AppMethodBeat.i(67149);
        this.BDD.setImeOptions(i2);
        AppMethodBeat.o(67149);
    }

    public void setOnEditorActionListener(TextView.OnEditorActionListener onEditorActionListener) {
        AppMethodBeat.i(67150);
        this.BDD.setOnEditorActionListener(onEditorActionListener);
        AppMethodBeat.o(67150);
    }

    public com.tencent.mm.plugin.recharge.model.a getInputRecord() {
        AppMethodBeat.i(67151);
        if (this.BDH != null) {
            com.tencent.mm.plugin.recharge.model.a aVar = this.BDH;
            AppMethodBeat.o(67151);
            return aVar;
        }
        this.BDH = new com.tencent.mm.plugin.recharge.model.a(getText(), this.hXv.getText().toString(), 0);
        com.tencent.mm.plugin.recharge.model.a aVar2 = this.BDH;
        AppMethodBeat.o(67151);
        return aVar2;
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter implements Filterable {
        public List<com.tencent.mm.plugin.recharge.model.a> BDM;
        public boolean BDN;
        private List<com.tencent.mm.plugin.recharge.model.a> BDO;
        private C1627a BDP;
        private String BDQ;

        private a() {
            AppMethodBeat.i(67127);
            this.BDM = new ArrayList();
            this.BDN = false;
            AppMethodBeat.o(67127);
        }

        /* synthetic */ a(MallEditText mallEditText, byte b2) {
            this();
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(67134);
            com.tencent.mm.plugin.recharge.model.a Vp = Vp(i2);
            AppMethodBeat.o(67134);
            return Vp;
        }

        public final void ga(List<com.tencent.mm.plugin.recharge.model.a> list) {
            AppMethodBeat.i(67128);
            this.BDO = list;
            this.BDM.clear();
            this.BDN = false;
            AppMethodBeat.o(67128);
        }

        public final Filter getFilter() {
            AppMethodBeat.i(67129);
            Log.d("MicroMsg.MallEditText", "getFilter");
            if (this.BDP == null) {
                this.BDP = new C1627a(this, (byte) 0);
            }
            C1627a aVar = this.BDP;
            AppMethodBeat.o(67129);
            return aVar;
        }

        public final int getCount() {
            AppMethodBeat.i(67130);
            if (this.BDN) {
                int size = this.BDM.size() + 2;
                AppMethodBeat.o(67130);
                return size;
            } else if (this.BDM.size() > 0) {
                int size2 = this.BDM.size() + 1;
                AppMethodBeat.o(67130);
                return size2;
            } else {
                AppMethodBeat.o(67130);
                return 0;
            }
        }

        public final synchronized com.tencent.mm.plugin.recharge.model.a Vp(int i2) {
            com.tencent.mm.plugin.recharge.model.a aVar = null;
            synchronized (this) {
                AppMethodBeat.i(67131);
                if (this.BDN) {
                    if (i2 == 0) {
                        AppMethodBeat.o(67131);
                    } else if (i2 <= this.BDM.size()) {
                        aVar = this.BDM.get(i2 - 1);
                        AppMethodBeat.o(67131);
                    } else {
                        AppMethodBeat.o(67131);
                    }
                } else if (i2 < this.BDM.size()) {
                    aVar = this.BDM.get(i2);
                    AppMethodBeat.o(67131);
                } else {
                    AppMethodBeat.o(67131);
                }
            }
            return aVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            c cVar;
            AppMethodBeat.i(67132);
            switch (getItemViewType(i2)) {
                case 0:
                    if (view == null) {
                        view = View.inflate(MallEditText.this.getContext(), R.layout.blb, null);
                        c cVar2 = new c(MallEditText.this, (byte) 0);
                        cVar2.BDU = (TextView) view.findViewById(R.id.f7b);
                        cVar2.gxs = (TextView) view.findViewById(R.id.f7a);
                        view.setTag(cVar2);
                        cVar = cVar2;
                    } else {
                        cVar = (c) view.getTag();
                    }
                    com.tencent.mm.plugin.recharge.model.a Vp = Vp(i2);
                    if (!(Vp == null || cVar == null || cVar.BDU == null || cVar.gxs == null)) {
                        String aKR = com.tencent.mm.plugin.recharge.model.b.aKR(Vp.BCX);
                        Log.d("MicroMsg.MallEditText", "record.record " + aKR + ", record.name " + Vp.name);
                        if (!com.tencent.mm.plugin.recharge.model.a.BCV.equals(Vp.BCY)) {
                            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aKR);
                            int[] iArr = Vp.BCY;
                            for (int i3 : iArr) {
                                if (i3 >= 0) {
                                    if (i3 >= 7) {
                                        i3 += 2;
                                    } else if (i3 >= 3) {
                                        i3++;
                                    }
                                    spannableStringBuilder.setSpan(new ForegroundColorSpan(-65536), i3, i3 + 1, 34);
                                }
                            }
                            cVar.BDU.setText(spannableStringBuilder);
                        } else {
                            cVar.BDU.setText(aKR);
                        }
                        if (Vp.name == null || Util.isNullOrNil(Vp.name.trim())) {
                            cVar.gxs.setText("");
                        } else {
                            cVar.gxs.setText(MallEditText.this.getResources().getString(R.string.exx, Vp.name));
                        }
                        view.setBackgroundResource(R.drawable.qa);
                        break;
                    }
                    break;
                case 1:
                    view = View.inflate(MallEditText.this.getContext(), R.layout.blc, null);
                    view.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.recharge.ui.MallEditText.a.AnonymousClass2 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(67120);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/MallEditText$MobileHistoryAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            com.tencent.mm.plugin.recharge.a.a.eHL().ga(null);
                            MallEditText.this.setInput(null);
                            MallEditText.this.BDF.ga(new LinkedList());
                            MallEditText.this.BDF.notifyDataSetChanged();
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/MallEditText$MobileHistoryAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(67120);
                        }
                    });
                    break;
                case 2:
                    view = View.inflate(MallEditText.this.getContext(), R.layout.bla, null);
                    view.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.recharge.ui.MallEditText.a.AnonymousClass1 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(67119);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/MallEditText$MobileHistoryAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            MallEditText.this.BDD.dismissDropDown();
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/MallEditText$MobileHistoryAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(67119);
                        }
                    });
                    break;
                case 3:
                    View inflate = View.inflate(MallEditText.this.getContext(), R.layout.blc, null);
                    ((TextView) inflate).setText(R.string.exm);
                    inflate.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.recharge.ui.MallEditText.a.AnonymousClass3 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(67121);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/MallEditText$MobileHistoryAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            MallEditText.this.BDD.dismissDropDown();
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/MallEditText$MobileHistoryAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(67121);
                        }
                    });
                    view = inflate;
                    break;
            }
            AppMethodBeat.o(67132);
            return view;
        }

        public final int getItemViewType(int i2) {
            AppMethodBeat.i(67133);
            if (this.BDN) {
                if (i2 == 0) {
                    AppMethodBeat.o(67133);
                    return 2;
                } else if (i2 <= this.BDM.size()) {
                    AppMethodBeat.o(67133);
                    return 0;
                } else {
                    AppMethodBeat.o(67133);
                    return 3;
                }
            } else if (i2 < this.BDM.size()) {
                AppMethodBeat.o(67133);
                return 0;
            } else {
                AppMethodBeat.o(67133);
                return 1;
            }
        }

        public final int getViewTypeCount() {
            return 4;
        }

        /* renamed from: com.tencent.mm.plugin.recharge.ui.MallEditText$a$a  reason: collision with other inner class name */
        class C1627a extends Filter {
            private C1627a() {
            }

            /* synthetic */ C1627a(a aVar, byte b2) {
                this();
            }

            /* access modifiers changed from: protected */
            public final synchronized Filter.FilterResults performFiltering(CharSequence charSequence) {
                boolean z;
                boolean z2;
                Filter.FilterResults filterResults;
                AppMethodBeat.i(67125);
                Filter.FilterResults filterResults2 = new Filter.FilterResults();
                ArrayList arrayList = new ArrayList();
                String Ts = charSequence != null ? com.tencent.mm.plugin.recharge.model.b.Ts(charSequence.toString()) : "";
                if (Ts.equals(a.this.BDQ)) {
                    MallEditText.this.BDD.post(new Runnable() {
                        /* class com.tencent.mm.plugin.recharge.ui.MallEditText.a.C1627a.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(67122);
                            MallEditText.this.BDD.dismissDropDown();
                            AppMethodBeat.o(67122);
                        }
                    });
                    AppMethodBeat.o(67125);
                    filterResults = filterResults2;
                } else {
                    a.this.BDQ = Ts;
                    if (MallEditText.this.bql()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        Log.d("MicroMsg.MallEditText", "performFiltering ".concat(String.valueOf(charSequence)));
                        for (com.tencent.mm.plugin.recharge.model.a aVar : a.this.BDO) {
                            if (aVar.BCX.equals(a.this.BDQ)) {
                                aVar.BCY = com.tencent.mm.plugin.recharge.model.a.BCV;
                                arrayList.clear();
                                arrayList.add(aVar);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            if (MallEditText.this.BDG == null) {
                                try {
                                    MallEditText.this.BDG = com.tencent.mm.pluginsdk.b.dO(MallEditText.this.getContext());
                                } catch (Exception e2) {
                                    Log.printErrStackTrace("MicroMsg.MallEditText", e2, "", new Object[0]);
                                }
                            }
                            if (MallEditText.this.BDG != null) {
                                Iterator it = MallEditText.this.BDG.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    String[] strArr = (String[]) it.next();
                                    String Ts2 = com.tencent.mm.plugin.recharge.model.b.Ts(strArr[2]);
                                    int[] jy = jy(a.this.BDQ, Ts2);
                                    if (com.tencent.mm.plugin.recharge.model.a.BCV.equals(jy)) {
                                        com.tencent.mm.plugin.recharge.model.a aVar2 = new com.tencent.mm.plugin.recharge.model.a(Ts2, strArr[1], 1);
                                        aVar2.BCY = com.tencent.mm.plugin.recharge.model.a.BCV;
                                        arrayList.clear();
                                        arrayList.add(aVar2);
                                        break;
                                    } else if (!com.tencent.mm.plugin.recharge.model.a.BCW.equals(jy) && arrayList.size() < 5) {
                                        com.tencent.mm.plugin.recharge.model.a aVar3 = new com.tencent.mm.plugin.recharge.model.a(Ts2, strArr[1], 1);
                                        aVar3.BCY = jy;
                                        arrayList.add(aVar3);
                                    }
                                }
                            }
                        }
                        Log.d("MicroMsg.MallEditText", " search phone number cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
                        z = true;
                    } else if (!Util.isNullOrNil(a.this.BDQ)) {
                        Log.d("MicroMsg.MallEditText", "performFiltering ".concat(String.valueOf(charSequence)));
                        for (com.tencent.mm.plugin.recharge.model.a aVar4 : a.this.BDO) {
                            if (aVar4.BCX.startsWith(a.this.BDQ)) {
                                arrayList.add(aVar4);
                            }
                        }
                        z = false;
                    } else {
                        arrayList.addAll(a.this.BDO);
                        z = false;
                    }
                    if (arrayList.size() == 0) {
                        MallEditText.this.BDD.post(new Runnable() {
                            /* class com.tencent.mm.plugin.recharge.ui.MallEditText.a.C1627a.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(67123);
                                MallEditText.this.BDD.dismissDropDown();
                                AppMethodBeat.o(67123);
                            }
                        });
                        z2 = false;
                    } else {
                        if (arrayList.size() == 1 && MallEditText.this.bql()) {
                            final com.tencent.mm.plugin.recharge.model.a aVar5 = (com.tencent.mm.plugin.recharge.model.a) arrayList.get(0);
                            if (com.tencent.mm.plugin.recharge.model.a.BCV.equals(aVar5.BCY)) {
                                MallEditText.this.BDD.post(new Runnable() {
                                    /* class com.tencent.mm.plugin.recharge.ui.MallEditText.a.C1627a.AnonymousClass3 */

                                    public final void run() {
                                        AppMethodBeat.i(67124);
                                        MallEditText.this.BDH = aVar5;
                                        if (!Util.isNullOrNil(MallEditText.this.BDH.name)) {
                                            MallEditText.this.hXv.setText(MallEditText.this.BDH.name);
                                            MallEditText.this.hXv.setVisibility(0);
                                        } else {
                                            MallEditText.this.hXv.setText("");
                                            MallEditText.this.hXv.setVisibility(8);
                                        }
                                        MallEditText.this.BDD.dismissDropDown();
                                        AppMethodBeat.o(67124);
                                    }
                                });
                                z2 = false;
                            }
                        }
                        z2 = z;
                    }
                    List<com.tencent.mm.plugin.recharge.model.a> list = a.this.BDM;
                    a.this.BDM = arrayList;
                    a.this.BDN = z2;
                    filterResults2.count = a.this.BDM.size();
                    filterResults2.values = a.this.BDM;
                    Log.d("MicroMsg.MallEditText", "results.count " + filterResults2.count);
                    list.clear();
                    AppMethodBeat.o(67125);
                    filterResults = filterResults2;
                }
                return filterResults;
            }

            /* access modifiers changed from: protected */
            public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            }

            private static int[] jy(String str, String str2) {
                AppMethodBeat.i(67126);
                if (str.equals(str2)) {
                    int[] iArr = com.tencent.mm.plugin.recharge.model.a.BCV;
                    AppMethodBeat.o(67126);
                    return iArr;
                }
                if (str2 != null && str.length() == str2.length()) {
                    int i2 = 0;
                    int[] iArr2 = {-1, -1};
                    for (int length = str.length() - 1; length > 0; length--) {
                        if (str2.charAt(length) != str.charAt(length)) {
                            i2++;
                            if (i2 > 2) {
                                break;
                            }
                            iArr2[i2 - 1] = length;
                        }
                    }
                    if (i2 <= 2) {
                        AppMethodBeat.o(67126);
                        return iArr2;
                    }
                }
                int[] iArr3 = com.tencent.mm.plugin.recharge.model.a.BCW;
                AppMethodBeat.o(67126);
                return iArr3;
            }
        }
    }

    class c {
        TextView BDU;
        TextView gxs;

        private c() {
        }

        /* synthetic */ c(MallEditText mallEditText, byte b2) {
            this();
        }
    }

    public void getFocus() {
        AppMethodBeat.i(67152);
        this.BDD.findFocus();
        AppMethodBeat.o(67152);
    }
}
