package com.tencent.mm.ui.base;

import android.content.Context;
import android.os.IBinder;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MMTagPanel extends FlowLayout {
    public boolean OTd = true;
    private boolean OTe = false;
    public boolean OTf = true;
    public boolean OTg = false;
    public boolean OTh = false;
    private int OTi = R.drawable.col;
    private int OTj = 0;
    private int OTk = R.drawable.ayb;
    private int OTl = R.color.ag2;
    private d OTm = null;
    private LinkedList<d> OTn = new LinkedList<>();
    private a OTo;
    private int OTp;
    private View OTq;
    MMEditText OTr;
    private boolean OTs = false;
    private View.OnClickListener OTt = new View.OnClickListener() {
        /* class com.tencent.mm.ui.base.MMTagPanel.AnonymousClass8 */

        public final void onClick(final View view) {
            AppMethodBeat.i(142179);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMTagPanel$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (((Integer) view.getTag()).intValue() == 0) {
                MMTagPanel.this.a((TextView) view, true, false);
                if (MMTagPanel.this.OTo != null) {
                    view.post(new Runnable() {
                        /* class com.tencent.mm.ui.base.MMTagPanel.AnonymousClass8.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(142176);
                            MMTagPanel.this.OTo.anc(((TextView) view).getText().toString());
                            AppMethodBeat.o(142176);
                        }
                    });
                }
            } else if (!MMTagPanel.this.OTe || MMTagPanel.this.OTg) {
                MMTagPanel.this.a((TextView) view, false, false);
                if (MMTagPanel.this.OTo != null) {
                    view.post(new Runnable() {
                        /* class com.tencent.mm.ui.base.MMTagPanel.AnonymousClass8.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(142177);
                            MMTagPanel.this.OTo.anb(((TextView) view).getText().toString());
                            AppMethodBeat.o(142177);
                        }
                    });
                }
            } else if (MMTagPanel.this.OTm == null) {
                MMTagPanel.this.OTm = MMTagPanel.a(MMTagPanel.this, ((TextView) view).getText().toString());
                if (MMTagPanel.this.OTm != null) {
                    MMTagPanel.this.a(MMTagPanel.this.OTm.OTG, false, true);
                }
            } else if (MMTagPanel.this.OTm.OTG == view) {
                MMTagPanel.this.OTm = null;
                MMTagPanel.this.a((TextView) view, false, false);
                if (MMTagPanel.this.OTo != null) {
                    view.post(new Runnable() {
                        /* class com.tencent.mm.ui.base.MMTagPanel.AnonymousClass8.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(142178);
                            MMTagPanel.this.OTo.anb(((TextView) view).getText().toString());
                            AppMethodBeat.o(142178);
                        }
                    });
                }
            } else {
                MMTagPanel.this.gLg();
                MMTagPanel.this.OTm = MMTagPanel.a(MMTagPanel.this, ((TextView) view).getText().toString());
                if (MMTagPanel.this.OTm != null) {
                    MMTagPanel.this.a(MMTagPanel.this.OTm.OTG, false, true);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMTagPanel$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(142179);
        }
    };
    public boolean mClickable = true;
    private boolean tfY = false;
    private int thx = R.color.a2x;
    private int thy = R.drawable.ayi;
    private LinkedList<d> xuO = new LinkedList<>();
    private int ywe = R.drawable.ay9;
    private int ywf = R.color.afp;

    public interface a {
        void E(boolean z, int i2);

        void anb(String str);

        void anc(String str);

        void and(String str);

        void ane(String str);

        void anf(String str);

        void cIk();
    }

    public static final class d {
        public String OTF;
        public TextView OTG;
    }

    public MMTagPanel(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(142187);
        init();
        AppMethodBeat.o(142187);
    }

    public MMTagPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(142188);
        init();
        AppMethodBeat.o(142188);
    }

    /* access modifiers changed from: protected */
    public void cWT() {
    }

    private void init() {
        AppMethodBeat.i(142189);
        this.OTp = getContext().getResources().getDimensionPixelSize(R.dimen.hc);
        this.OTq = LayoutInflater.from(getContext()).inflate(R.layout.bag, (ViewGroup) null);
        this.OTr = (MMEditText) this.OTq.findViewById(R.id.bxz);
        this.OTr.setOnKeyListener(new View.OnKeyListener() {
            /* class com.tencent.mm.ui.base.MMTagPanel.AnonymousClass1 */

            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(142169);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                bVar.pH(i2);
                bVar.bm(keyEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMTagPanel$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
                if (keyEvent.getAction() == 0 && 67 == i2) {
                    Log.d("MicroMsg.MMTagPanel", "on del click, selection[%d, %d]", Integer.valueOf(MMTagPanel.this.OTr.getSelectionStart()), Integer.valueOf(MMTagPanel.this.OTr.getSelectionEnd()));
                    if (!(MMTagPanel.this.OTr.getSelectionStart() == 0 && MMTagPanel.this.OTr.getSelectionStart() == MMTagPanel.this.OTr.getSelectionEnd())) {
                        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/base/MMTagPanel$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                        AppMethodBeat.o(142169);
                    } else {
                        MMTagPanel.this.cWT();
                        if (MMTagPanel.this.xuO == null || MMTagPanel.this.xuO.isEmpty()) {
                            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/base/MMTagPanel$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                            AppMethodBeat.o(142169);
                        } else if (!MMTagPanel.this.OTg && MMTagPanel.this.OTm == null) {
                            MMTagPanel.this.OTm = (d) MMTagPanel.this.xuO.getLast();
                            MMTagPanel.this.a(MMTagPanel.this.OTm.OTG, false, true);
                            MMTagPanel.this.OTr.setCursorVisible(false);
                        } else if (MMTagPanel.this.OTm == null || MMTagPanel.this.xuO == null || MMTagPanel.this.xuO.getLast() == null || Util.isNullOrNil(MMTagPanel.this.OTm.OTF) || Util.isNullOrNil(((d) MMTagPanel.this.xuO.getLast()).OTF) || MMTagPanel.this.OTm.OTF.equals(((d) MMTagPanel.this.xuO.getLast()).OTF)) {
                            String str = ((d) MMTagPanel.this.xuO.getLast()).OTF;
                            MMTagPanel.this.removeTag(str);
                            if (MMTagPanel.this.OTo != null) {
                                MMTagPanel.this.OTo.and(str);
                            }
                            MMTagPanel.this.gLg();
                        } else {
                            Log.i("MicroMsg.MMTagPanel", "change hight");
                            MMTagPanel.this.gLg();
                            MMTagPanel.this.OTm = (d) MMTagPanel.this.xuO.getLast();
                            MMTagPanel.this.a(MMTagPanel.this.OTm.OTG, false, true);
                            MMTagPanel.this.OTr.setCursorVisible(false);
                        }
                    }
                    return false;
                }
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/base/MMTagPanel$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(142169);
                return false;
            }
        });
        this.OTr.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.ui.base.MMTagPanel.AnonymousClass2 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(142170);
                String obj = editable.toString();
                if (MMTagPanel.this.OTo != null) {
                    MMTagPanel.this.OTo.ane(obj);
                }
                if (obj.length() > 0) {
                    MMTagPanel.this.gLg();
                }
                AppMethodBeat.o(142170);
            }
        });
        this.OTr.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.tencent.mm.ui.base.MMTagPanel.AnonymousClass3 */

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(142171);
                Log.d("MicroMsg.MMTagPanel", "on edittext focus changed %B", Boolean.valueOf(z));
                if (z && MMTagPanel.this.OTo != null) {
                    MMTagPanel.this.OTo.cIk();
                }
                AppMethodBeat.o(142171);
            }
        });
        this.OTr.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.base.MMTagPanel.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(142172);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMTagPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.MMTagPanel", "on edittext click");
                MMTagPanel.this.gLg();
                if (MMTagPanel.this.OTo != null) {
                    MMTagPanel.this.OTo.cIk();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMTagPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(142172);
            }
        });
        this.OTr.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.ui.base.MMTagPanel.AnonymousClass5 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(142173);
                Log.d("MicroMsg.MMTagPanel", "on action %d, %s", Integer.valueOf(i2), keyEvent);
                AppMethodBeat.o(142173);
                return false;
            }
        });
        final c cVar = new c();
        b bVar = new b();
        this.OTr.setFilters(new InputFilter[]{cVar, bVar});
        gLe();
        setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.base.MMTagPanel.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(142174);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMTagPanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.MMTagPanel", "on panel click, enableEditMode %B", Boolean.valueOf(MMTagPanel.this.OTe));
                if (MMTagPanel.this.OTe) {
                    MMTagPanel.this.gLg();
                    MMTagPanel.this.OTr.requestFocus();
                    MMTagPanel.this.OTr.setSelection(MMTagPanel.this.OTr.getText().length());
                    ((InputMethodManager) MMTagPanel.this.getContext().getSystemService("input_method")).showSoftInput(MMTagPanel.this.OTr, 0);
                    Log.d("MicroMsg.MMTagPanel", "on content click");
                    if (MMTagPanel.this.OTo != null) {
                        MMTagPanel.this.OTo.cIk();
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMTagPanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(142174);
            }
        });
        setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.base.MMTagPanel.AnonymousClass7 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                int bnR;
                AppMethodBeat.i(142175);
                if (MMTagPanel.this.OTh) {
                    String editText = MMTagPanel.this.getEditText();
                    if (!Util.isNullOrNil(editText)) {
                        if (cVar != null && f.bnP(editText) > cVar.OTB && (bnR = cVar.OTB - f.bnR(editText)) < editText.length()) {
                            editText = editText.substring(0, bnR);
                        }
                        MMTagPanel.this.dm(editText, true);
                        if (MMTagPanel.this.OTo != null) {
                            MMTagPanel.this.OTo.anf(editText);
                        }
                        MMTagPanel.this.gLc();
                    }
                }
                AppMethodBeat.o(142175);
                return false;
            }
        });
        AppMethodBeat.o(142189);
    }

    public class c implements InputFilter {
        int OTB = 36;
        private int OTC = 256;
        private int OTD;

        public c() {
        }

        public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            AppMethodBeat.i(142186);
            int bnP = f.bnP(spanned.toString()) + f.bnP(charSequence.toString());
            if (i5 > i4) {
                if (bnP - (i5 - i4) > this.OTB) {
                    MMTagPanel.this.tfY = true;
                    this.OTD = (bnP - (i5 - i4)) - this.OTB;
                } else {
                    MMTagPanel.this.tfY = false;
                }
            } else if (bnP > this.OTB) {
                MMTagPanel.this.tfY = true;
                this.OTD = bnP - this.OTB;
            } else {
                MMTagPanel.this.tfY = false;
            }
            if (MMTagPanel.this.OTs && 1 == this.OTD && charSequence.equals("\n")) {
                this.OTD = 0;
            }
            if (MMTagPanel.this.OTo != null) {
                MMTagPanel.this.post(new Runnable() {
                    /* class com.tencent.mm.ui.base.MMTagPanel.c.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(142185);
                        MMTagPanel.this.OTo.E(MMTagPanel.this.tfY, f.dp(c.this.OTD, ""));
                        AppMethodBeat.o(142185);
                    }
                });
            }
            if (bnP > this.OTC) {
                AppMethodBeat.o(142186);
                return "";
            }
            AppMethodBeat.o(142186);
            return charSequence;
        }
    }

    public class b implements InputFilter {
        List<String> OTx = new LinkedList();
        int mark;

        public b() {
            AppMethodBeat.i(142183);
            AppMethodBeat.o(142183);
        }

        public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            final String str;
            AppMethodBeat.i(142184);
            Log.d("MicroMsg.MMTagPanel", "on create tag filter, %s [%d, %d) %s [%d, %d), maxlength[%B]", charSequence, Integer.valueOf(i2), Integer.valueOf(i3), spanned, Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(MMTagPanel.this.tfY));
            this.mark = -1;
            this.OTx.clear();
            char[] cArr = new char[(i3 - i2)];
            TextUtils.getChars(charSequence, i2, i3, cArr, 0);
            if (!MMTagPanel.this.OTf) {
                boolean z = false;
                final StringBuilder sb = new StringBuilder();
                while (i2 < i3) {
                    if (cArr[i2] == '\n') {
                        z = true;
                    } else {
                        sb.append(cArr[i2]);
                    }
                    i2++;
                }
                if (z) {
                    String sb2 = sb.toString();
                    sb.insert(0, spanned.subSequence(0, i4));
                    sb.append(spanned.subSequence(i5, spanned.length()));
                    MMTagPanel.this.post(new Runnable() {
                        /* class com.tencent.mm.ui.base.MMTagPanel.b.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(142180);
                            MMTagPanel.this.OTo.anf(sb.toString());
                            AppMethodBeat.o(142180);
                        }
                    });
                    AppMethodBeat.o(142184);
                    return sb2;
                }
                AppMethodBeat.o(142184);
                return null;
            }
            for (int i6 = i2; i6 < i3; i6++) {
                if (cArr[i6] == '\n' || cArr[i6] == ',' || cArr[i6] == ';' || cArr[i6] == 12289 || cArr[i6] == 65292 || cArr[i6] == 65307) {
                    if (-1 == this.mark) {
                        this.OTx.add((spanned.subSequence(0, i4).toString() + ((Object) charSequence.subSequence(i2, i6))).trim());
                    } else {
                        this.OTx.add(charSequence.subSequence(this.mark, i6).toString().trim());
                    }
                    this.mark = i6 + 1;
                }
            }
            if (MMTagPanel.this.OTs) {
                int bnP = f.bnP(spanned.toString());
                if (MMTagPanel.this.tfY && charSequence.equals("\n") && 36 < bnP) {
                    this.OTx.clear();
                }
            }
            if (this.OTx.isEmpty()) {
                AppMethodBeat.o(142184);
                return null;
            }
            if (MMTagPanel.this.OTo != null) {
                for (final String str2 : this.OTx) {
                    if (str2.length() > 0) {
                        MMTagPanel.this.post(new Runnable() {
                            /* class com.tencent.mm.ui.base.MMTagPanel.b.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(142181);
                                MMTagPanel.this.OTo.anf(str2.trim());
                                AppMethodBeat.o(142181);
                            }
                        });
                    }
                }
            }
            if (this.mark >= i3) {
                spanned.length();
                str = spanned.subSequence(i5, spanned.length()).toString();
            } else {
                str = charSequence.subSequence(this.mark, i3).toString() + ((Object) spanned.subSequence(i5, spanned.length()));
            }
            MMTagPanel.this.post(new Runnable() {
                /* class com.tencent.mm.ui.base.MMTagPanel.b.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(142182);
                    MMTagPanel.this.OTr.setText("");
                    MMTagPanel.this.OTr.append(str);
                    AppMethodBeat.o(142182);
                }
            });
            AppMethodBeat.o(142184);
            return "";
        }
    }

    public void setTagEditTextBG(int i2) {
        AppMethodBeat.i(142190);
        this.OTj = i2;
        if (this.OTr != null) {
            com.tencent.mm.cb.a.fromDPToPix(getContext(), 6);
            getResources().getDimensionPixelSize(R.dimen.ir);
            this.OTr.setBackgroundResource(this.OTj);
        }
        AppMethodBeat.o(142190);
    }

    public void setTagTipsDrawable(int i2) {
        this.OTi = i2;
    }

    public void setTagNormalBG(int i2) {
        this.thy = i2;
    }

    public void setTagNormalTextColorRes(int i2) {
        this.thx = i2;
    }

    public void setTagSelectedBG(int i2) {
        this.ywe = i2;
    }

    public void setTagSelectedTextColorRes(int i2) {
        this.ywf = i2;
    }

    public void setTagHighlineBG(int i2) {
        this.OTk = i2;
    }

    public void setTaghighlineTextColorRes(int i2) {
        this.OTl = i2;
    }

    public void setEditTextColor(int i2) {
        AppMethodBeat.i(142191);
        if (this.OTr != null) {
            this.OTr.setTextColor(i2);
        }
        AppMethodBeat.o(142191);
    }

    public void setEditHint(String str) {
        AppMethodBeat.i(142192);
        if (this.OTr != null) {
            this.OTr.setHint(str);
        }
        AppMethodBeat.o(142192);
    }

    public String getEditText() {
        AppMethodBeat.i(142193);
        if (this.OTr != null) {
            String obj = this.OTr.getText().toString();
            AppMethodBeat.o(142193);
            return obj;
        }
        AppMethodBeat.o(142193);
        return "";
    }

    public final void gLc() {
        AppMethodBeat.i(142194);
        if (this.OTr != null) {
            this.OTr.setText("");
        }
        AppMethodBeat.o(142194);
    }

    public final void gLd() {
        AppMethodBeat.i(142195);
        if (this.OTr == null || this.OTr.isFocused()) {
            AppMethodBeat.o(142195);
            return;
        }
        this.OTr.requestFocus();
        AppMethodBeat.o(142195);
    }

    public final void gLe() {
        AppMethodBeat.i(142196);
        if (this.OTr != null && this.OTr.isFocused()) {
            Log.d("MicroMsg.MMTagPanel", "do clear edit focus");
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (inputMethodManager == null) {
                AppMethodBeat.o(142196);
                return;
            }
            IBinder windowToken = this.OTr.getWindowToken();
            if (windowToken == null) {
                AppMethodBeat.o(142196);
                return;
            } else {
                inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                this.OTr.clearFocus();
            }
        }
        AppMethodBeat.o(142196);
    }

    public final void Bz(boolean z) {
        AppMethodBeat.i(142197);
        if (z == this.OTe) {
            AppMethodBeat.o(142197);
            return;
        }
        this.OTe = z;
        removeView(this.OTq);
        if (this.OTe) {
            addView(this.OTq);
            gLe();
        }
        AppMethodBeat.o(142197);
    }

    public void setCallBack(a aVar) {
        this.OTo = aVar;
    }

    public Set<String> getTagSet() {
        AppMethodBeat.i(142198);
        TreeSet treeSet = new TreeSet();
        Iterator<d> it = this.xuO.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (!Util.isNullOrNil(next.OTF)) {
                treeSet.add(next.OTF);
            }
        }
        AppMethodBeat.o(142198);
        return treeSet;
    }

    public ArrayList<String> getTagList() {
        AppMethodBeat.i(142199);
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<d> it = this.xuO.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (!Util.isNullOrNil(next.OTF)) {
                arrayList.add(next.OTF);
            }
        }
        AppMethodBeat.o(142199);
        return arrayList;
    }

    public int getTagCount() {
        AppMethodBeat.i(142200);
        int size = this.xuO.size();
        AppMethodBeat.o(142200);
        return size;
    }

    public void gKV() {
        AppMethodBeat.i(142201);
        this.xuO.clear();
        removeAllViews();
        Iterator<d> it = this.xuO.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        AppMethodBeat.o(142201);
    }

    public final void a(Collection<String> collection, List<String> list) {
        AppMethodBeat.i(142202);
        gKV();
        if (this.OTe) {
            addView(this.OTq);
        }
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(142202);
            return;
        }
        for (String str : list) {
            dm(str, collection == null ? false : collection.contains(str));
        }
        AppMethodBeat.o(142202);
    }

    /* access modifiers changed from: protected */
    public final d gLf() {
        AppMethodBeat.i(142203);
        if (!this.OTn.isEmpty()) {
            d removeFirst = this.OTn.removeFirst();
            AppMethodBeat.o(142203);
            return removeFirst;
        }
        d dVar = new d();
        TextView textView = new TextView(getContext());
        textView.setBackgroundResource(this.thy);
        textView.setTextColor(getResources().getColor(this.thx));
        textView.setTag(0);
        textView.setGravity(17);
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.OTi, 0);
        textView.setOnClickListener(this.OTd ? this.OTt : null);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine();
        dVar.OTG = textView;
        AppMethodBeat.o(142203);
        return dVar;
    }

    private void a(d dVar) {
        AppMethodBeat.i(142204);
        dVar.OTG.setOnClickListener(null);
        if (this.OTn.size() >= 16) {
            AppMethodBeat.o(142204);
            return;
        }
        this.OTn.add(dVar);
        AppMethodBeat.o(142204);
    }

    /* access modifiers changed from: protected */
    public final void a(d dVar, String str, boolean z) {
        AppMethodBeat.i(142205);
        dVar.OTF = str;
        dVar.OTG.setText(com.tencent.mm.ui.g.c.b.a(getContext(), str, this.OTp));
        dVar.OTG.setOnClickListener(this.OTd ? this.OTt : null);
        a(dVar.OTG, z, false);
        AppMethodBeat.o(142205);
    }

    /* access modifiers changed from: protected */
    public final void gLg() {
        boolean z;
        AppMethodBeat.i(142206);
        if (this.OTr != null) {
            Log.d("MicroMsg.MMTagPanel", "do clear high light info, edittext is focus %B", Boolean.valueOf(this.OTr.isFocused()));
            this.OTr.setCursorVisible(true);
        }
        if (this.OTm == null) {
            AppMethodBeat.o(142206);
            return;
        }
        TextView textView = this.OTm.OTG;
        if (((Integer) this.OTm.OTG.getTag()).intValue() == 1) {
            z = true;
        } else {
            z = false;
        }
        a(textView, z, false);
        this.OTm = null;
        AppMethodBeat.o(142206);
    }

    public final void a(TextView textView, boolean z, boolean z2) {
        AppMethodBeat.i(142207);
        textView.setTextSize(0, getContext().getResources().getDimension(R.dimen.hc) * com.tencent.mm.cb.a.ez(getContext()));
        if (z2) {
            textView.setBackgroundResource(this.OTk);
            textView.setTextColor(getResources().getColor(this.OTl));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.OTi, 0);
            AppMethodBeat.o(142207);
        } else if (z) {
            textView.setTag(1);
            textView.setBackgroundResource(this.ywe);
            textView.setTextColor(getResources().getColor(this.ywf));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            AppMethodBeat.o(142207);
        } else {
            textView.setTag(0);
            textView.setBackgroundResource(this.thy);
            textView.setTextColor(getResources().getColor(this.thx));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            AppMethodBeat.o(142207);
        }
    }

    public final void dm(String str, boolean z) {
        AppMethodBeat.i(142208);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.MMTagPanel", "want to add tag, but it is null or empty");
            AppMethodBeat.o(142208);
            return;
        }
        String trim = str.trim();
        Log.d("MicroMsg.MMTagPanel", "want to add tag %s, do remove tag first", trim);
        removeTag(trim);
        Iterator<d> it = this.xuO.iterator();
        while (it.hasNext()) {
            if (trim.equals(it.next().OTF)) {
                Log.w("MicroMsg.MMTagPanel", "want to add tag %s, but it exsited!", trim);
                AppMethodBeat.o(142208);
                return;
            }
        }
        d gLf = gLf();
        a(gLf, trim, z);
        this.xuO.add(gLf);
        if (this.OTe) {
            addView(gLf.OTG, getChildCount() - 1);
        } else {
            addView(gLf.OTG);
        }
        gLg();
        AppMethodBeat.o(142208);
    }

    public final void removeTag(String str) {
        AppMethodBeat.i(142209);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.MMTagPanel", "want to remove tag, but it is null or empty");
            AppMethodBeat.o(142209);
            return;
        }
        Iterator<d> it = this.xuO.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (str.equals(next.OTF)) {
                this.xuO.remove(next);
                removeView(next.OTG);
                a(next);
                gLg();
                AppMethodBeat.o(142209);
                return;
            }
        }
        Log.w("MicroMsg.MMTagPanel", "want to remove tag %s, but it not exsited!", str);
        AppMethodBeat.o(142209);
    }

    public final void gLh() {
        AppMethodBeat.i(142210);
        Iterator<d> it = this.xuO.iterator();
        while (it.hasNext()) {
            d next = it.next();
            removeView(next.OTG);
            a(next);
        }
        this.xuO.clear();
        gLg();
        AppMethodBeat.o(142210);
    }

    public final void dn(String str, boolean z) {
        AppMethodBeat.i(142211);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.MMTagPanel", "want to update tag status, but it is null or empty");
            AppMethodBeat.o(142211);
            return;
        }
        Iterator<d> it = this.xuO.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (str.equals(next.OTF)) {
                a(next, str, z);
                gLg();
                AppMethodBeat.o(142211);
                return;
            }
        }
        Log.w("MicroMsg.MMTagPanel", "want to update tag %s status, but it not exsited!", str);
        AppMethodBeat.o(142211);
    }

    public void setPanelClickable(boolean z) {
        this.mClickable = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(142212);
        if (this.mClickable) {
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.o(142212);
            return onInterceptTouchEvent;
        }
        AppMethodBeat.o(142212);
        return true;
    }

    public void setEditTextHit(boolean z) {
        AppMethodBeat.i(142213);
        if (this.OTr != null) {
            if (z) {
                this.OTr.setHint(R.string.dm);
                AppMethodBeat.o(142213);
                return;
            }
            this.OTr.setHint("");
        }
        AppMethodBeat.o(142213);
    }

    public void setIsAllowEnterCharacter(boolean z) {
        this.OTs = z;
    }

    static /* synthetic */ d a(MMTagPanel mMTagPanel, String str) {
        AppMethodBeat.i(142214);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.MMTagPanel", "want to get tag info, but it is null or empty");
            AppMethodBeat.o(142214);
            return null;
        }
        Iterator<d> it = mMTagPanel.xuO.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (str.equals(next.OTF)) {
                AppMethodBeat.o(142214);
                return next;
            }
        }
        Log.w("MicroMsg.MMTagPanel", "want to get tag %s, but it not exsited!", str);
        AppMethodBeat.o(142214);
        return null;
    }
}
