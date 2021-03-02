package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.qqmail.d.k;
import com.tencent.mm.plugin.qqmail.d.l;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class MailAddrsViewControl extends RelativeLayout {
    private static final Pattern Bwg = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
    private GestureDetector Bvq;
    private LinkedList<l> Bwa = new LinkedList<>();
    AutoCompleteTextView Bwb;
    private b Bwc;
    private c Bwd;
    private View Bwe;
    private a Bwf = null;
    private GestureDetector.SimpleOnGestureListener Bwh = new GestureDetector.SimpleOnGestureListener() {
        /* class com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.AnonymousClass8 */

        public final boolean onContextClick(MotionEvent motionEvent) {
            AppMethodBeat.i(198716);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onContextClick = super.onContextClick(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(198716);
            return onContextClick;
        }

        private void eGX() {
            boolean z;
            AppMethodBeat.i(123071);
            l lVar = (l) MailAddrsViewControl.this.Bwe.getTag();
            if (MailAddrsViewControl.this.Bwd != null) {
                c unused = MailAddrsViewControl.this.Bwd;
                View unused2 = MailAddrsViewControl.this.Bwe;
            }
            Intent intent = new Intent(MailAddrsViewControl.this.getContext(), MailAddrProfileUI.class);
            intent.putExtra("name", lVar.name);
            intent.putExtra("addr", lVar.yFq);
            if (!MailAddrsViewControl.this.ktR) {
                z = true;
            } else {
                z = false;
            }
            intent.putExtra("can_compose", z);
            Context context = MailAddrsViewControl.this.getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "startActivity", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "startActivity", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(123071);
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.i(123072);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            if (!MailAddrsViewControl.this.ktR) {
                eGX();
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(123072);
            return true;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.i(123073);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
            if (!(MailAddrsViewControl.this.Bwd == null || MailAddrsViewControl.this.Bwe == null)) {
                c unused = MailAddrsViewControl.this.Bwd;
                View unused2 = MailAddrsViewControl.this.Bwe;
                MailAddrsViewControl.this.Bwe.getTag();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(123073);
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.i(123074);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            eGX();
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(123074);
            return true;
        }
    };
    private MMHandler handler = new MMHandler();
    private boolean ktR = false;

    public interface a {
        void b(MailAddrsViewControl mailAddrsViewControl);

        void eGH();
    }

    static /* synthetic */ void a(MailAddrsViewControl mailAddrsViewControl, String str, boolean z) {
        AppMethodBeat.i(123101);
        mailAddrsViewControl.bW(str, z);
        AppMethodBeat.o(123101);
    }

    public void setInvalidMailAddrListener(a aVar) {
        this.Bwf = aVar;
    }

    public final boolean eGS() {
        AppMethodBeat.i(123084);
        Editable text = this.Bwb.getText();
        if (text == null) {
            AppMethodBeat.o(123084);
            return true;
        } else if (text.toString().length() <= 0) {
            AppMethodBeat.o(123084);
            return true;
        } else {
            AppMethodBeat.o(123084);
            return false;
        }
    }

    public MailAddrsViewControl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(123085);
        this.Bvq = new GestureDetector(context, this.Bwh);
        AppMethodBeat.o(123085);
    }

    public void setEditable(boolean z) {
        AppMethodBeat.i(123086);
        this.ktR = z;
        if (z && this.Bwb == null) {
            int i2 = 0;
            while (true) {
                if (i2 >= getChildCount()) {
                    break;
                }
                View childAt = getChildAt(i2);
                if (childAt instanceof AutoCompleteTextView) {
                    this.Bwb = (AutoCompleteTextView) childAt;
                    break;
                }
                if (childAt instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) childAt;
                    for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                        View childAt2 = viewGroup.getChildAt(i3);
                        if (childAt2 instanceof AutoCompleteTextView) {
                            this.Bwb = (AutoCompleteTextView) childAt2;
                        }
                    }
                }
                if (this.Bwb != null) {
                    break;
                }
                i2++;
            }
            if (this.Bwb != null) {
                this.Bwb.setDropDownBackgroundResource(R.drawable.blb);
                setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(123063);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        MailAddrsViewControl.this.Bwb.requestFocus();
                        ((InputMethodManager) MailAddrsViewControl.this.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(123063);
                    }
                });
                this.Bwb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    /* class com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.AnonymousClass3 */

                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                        AppMethodBeat.i(123066);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(adapterView);
                        bVar.bm(view);
                        bVar.pH(i2);
                        bVar.zo(j2);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                        MailAddrsViewControl.this.b(MailAddrsViewControl.this.Bwc.Vi(i2));
                        MailAddrsViewControl.this.Bwb.setText("");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(123066);
                    }
                });
                this.Bwb.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    /* class com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.AnonymousClass4 */

                    public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                        String obj;
                        AppMethodBeat.i(123067);
                        if (i2 == 5 && (obj = MailAddrsViewControl.this.Bwb.getEditableText().toString()) != null && obj.length() > 0) {
                            MailAddrsViewControl.a(MailAddrsViewControl.this, obj, false);
                            MailAddrsViewControl.this.eGW();
                        }
                        AppMethodBeat.o(123067);
                        return true;
                    }
                });
                this.Bwb.setOnKeyListener(new View.OnKeyListener() {
                    /* class com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.AnonymousClass5 */

                    public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                        String obj;
                        AppMethodBeat.i(123068);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        bVar.pH(i2);
                        bVar.bm(keyEvent);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$5", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
                        if (i2 == 67 && keyEvent.getAction() == 0) {
                            String obj2 = MailAddrsViewControl.this.Bwb.getEditableText().toString();
                            if (obj2.length() == 0 && MailAddrsViewControl.this.Bwe != null && MailAddrsViewControl.this.Bwe.isSelected()) {
                                MailAddrsViewControl.this.c((l) MailAddrsViewControl.this.Bwe.getTag());
                                MailAddrsViewControl.this.Bwe = null;
                                MailAddrsViewControl.this.eGW();
                            } else if (obj2.length() == 0 && MailAddrsViewControl.this.Bwa.size() > 0) {
                                int size = MailAddrsViewControl.this.Bwa.size() - 1;
                                View childAt = MailAddrsViewControl.this.getChildAt(size);
                                if (!childAt.isSelected()) {
                                    childAt.setSelected(true);
                                } else {
                                    MailAddrsViewControl.this.c((l) MailAddrsViewControl.this.Bwa.get(size));
                                    MailAddrsViewControl.this.eGW();
                                }
                            }
                        } else if (i2 == 66 && keyEvent.getAction() == 0 && (obj = MailAddrsViewControl.this.Bwb.getEditableText().toString()) != null && obj.length() > 0) {
                            MailAddrsViewControl.a(MailAddrsViewControl.this, obj, true);
                            MailAddrsViewControl.this.eGW();
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$5", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                        AppMethodBeat.o(123068);
                        return false;
                    }
                });
                this.Bwb.addTextChangedListener(new TextWatcher() {
                    /* class com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.AnonymousClass6 */

                    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                        AppMethodBeat.i(123069);
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.endsWith("\n") || charSequence2.endsWith(" ")) {
                            MailAddrsViewControl.a(MailAddrsViewControl.this, charSequence2, true);
                        }
                        MailAddrsViewControl.this.eGW();
                        AppMethodBeat.o(123069);
                    }

                    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    }

                    public final void afterTextChanged(Editable editable) {
                    }
                });
                this.Bwb.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    /* class com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.AnonymousClass7 */

                    public final void onFocusChange(View view, boolean z) {
                        AppMethodBeat.i(123070);
                        if (MailAddrsViewControl.this.Bwd != null) {
                            MailAddrsViewControl.this.Bwd.sS(z);
                        }
                        String obj = MailAddrsViewControl.this.Bwb.getEditableText().toString();
                        if (!z && obj.trim().length() > 0) {
                            MailAddrsViewControl.a(MailAddrsViewControl.this, obj, false);
                        }
                        if (MailAddrsViewControl.this.Bwe != null && MailAddrsViewControl.this.Bwe.isSelected()) {
                            MailAddrsViewControl.this.Bwe.setSelected(z);
                            MailAddrsViewControl.this.Bwe = null;
                        }
                        MailAddrsViewControl.this.eGW();
                        AppMethodBeat.o(123070);
                    }
                });
                AppMethodBeat.o(123086);
                return;
            }
        } else if (!z && this.Bwb != null) {
            this.Bwb.setVisibility(8);
        }
        AppMethodBeat.o(123086);
    }

    public void setAddrsAdapter(b bVar) {
        AppMethodBeat.i(123087);
        if (!(this.Bwb == null || bVar == null)) {
            this.Bwc = bVar;
            this.Bwb.setAdapter(bVar);
        }
        AppMethodBeat.o(123087);
    }

    public void setOnActionListener(c cVar) {
        this.Bwd = cVar;
    }

    public LinkedList<l> getMailAddrs() {
        return this.Bwa;
    }

    public String[] getMailAddrStringArray() {
        AppMethodBeat.i(198717);
        String[] strArr = new String[this.Bwa.size()];
        for (int i2 = 0; i2 < this.Bwa.size(); i2++) {
            l lVar = this.Bwa.get(i2);
            strArr[i2] = lVar.name + " " + lVar.yFq;
        }
        AppMethodBeat.o(198717);
        return strArr;
    }

    public final boolean eGT() {
        AppMethodBeat.i(123089);
        String trim = this.Bwb.getEditableText().toString().trim();
        if (Util.isNullOrNil(trim) || !aKK(trim)) {
            AppMethodBeat.o(123089);
            return false;
        }
        AppMethodBeat.o(123089);
        return true;
    }

    public String getAddrsString() {
        AppMethodBeat.i(123090);
        if (eGT()) {
            bW(this.Bwb.getEditableText().toString(), false);
        }
        String str = "";
        for (int i2 = 0; i2 < this.Bwa.size(); i2++) {
            l lVar = this.Bwa.get(i2);
            if (i2 != 0) {
                str = str + ",";
            }
            str = str + lVar.yFq;
        }
        AppMethodBeat.o(123090);
        return str;
    }

    public int getSize() {
        AppMethodBeat.i(123091);
        int size = this.Bwa.size();
        AppMethodBeat.o(123091);
        return size;
    }

    public final void b(l lVar) {
        boolean z;
        AppMethodBeat.i(123092);
        if (lVar == null) {
            AppMethodBeat.o(123092);
            return;
        }
        Iterator<l> it = this.Bwa.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().yFq.equalsIgnoreCase(lVar.yFq)) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            ViewGroup viewGroup = (ViewGroup) View.inflate(getContext(), R.layout.bk0, null);
            final Button button = (Button) viewGroup.findViewById(R.id.gnv);
            viewGroup.removeView((View) button.getParent());
            button.setText(lVar.name);
            if (this.ktR) {
                button.setCompoundDrawables(null, null, null, null);
            }
            button.setTag(new StringBuilder().append(this.Bwa.size()).toString());
            View view = (View) button.getParent();
            button.setTag(lVar);
            view.setVisibility(4);
            view.setTag(lVar);
            addView(view, this.Bwa.size());
            this.Bwa.add(lVar);
            this.handler.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(123065);
                    button.invalidate();
                    button.setOnTouchListener(new View.OnTouchListener() {
                        /* class com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.AnonymousClass2.AnonymousClass1 */

                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            AppMethodBeat.i(123064);
                            if (!(MailAddrsViewControl.this.Bwe == null || MailAddrsViewControl.this.Bwe == view || !MailAddrsViewControl.this.Bwe.isSelected())) {
                                MailAddrsViewControl.this.Bwe.setSelected(false);
                                MailAddrsViewControl.this.Bwe = null;
                            }
                            MailAddrsViewControl.this.Bwe = view;
                            if (MailAddrsViewControl.this.Bwb != null && motionEvent.getAction() == 0) {
                                button.setSelected(!button.isSelected());
                                MailAddrsViewControl.this.Bwb.setVisibility(0);
                                MailAddrsViewControl.this.Bwb.requestFocus();
                                ((InputMethodManager) MailAddrsViewControl.this.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
                            }
                            GestureDetector gestureDetector = MailAddrsViewControl.this.Bvq;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
                            com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$2$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                            boolean a2 = com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$2$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                            AppMethodBeat.o(123064);
                            return a2;
                        }
                    });
                    MailAddrsViewControl.this.eGW();
                    MailAddrsViewControl.this.invalidate();
                    AppMethodBeat.o(123065);
                }
            }, 100);
        }
        AppMethodBeat.o(123092);
    }

    public final void j(List<l> list, boolean z) {
        AppMethodBeat.i(198718);
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(198718);
            return;
        }
        if (z) {
            eGU();
        }
        for (l lVar : list) {
            b(lVar);
        }
        AppMethodBeat.o(198718);
    }

    public void setMailAdds(List<l> list) {
        AppMethodBeat.i(123095);
        if (list == null) {
            AppMethodBeat.o(123095);
            return;
        }
        for (int i2 = 0; i2 < this.Bwa.size(); i2++) {
            l lVar = this.Bwa.get(i2);
            int i3 = 0;
            while (i3 < list.size() && !lVar.yFq.equalsIgnoreCase(list.get(i3).yFq)) {
                i3++;
            }
            if (i3 == list.size()) {
                c(lVar);
            }
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            l lVar2 = list.get(i4);
            int i5 = 0;
            while (i5 < this.Bwa.size() && !lVar2.yFq.equalsIgnoreCase(this.Bwa.get(i5).yFq)) {
                i5++;
            }
            if (i5 == this.Bwa.size()) {
                b(lVar2);
            }
        }
        AppMethodBeat.o(123095);
    }

    private void eGU() {
        AppMethodBeat.i(177331);
        removeAllViews();
        this.Bwa.clear();
        eGW();
        invalidate();
        AppMethodBeat.o(177331);
    }

    public final void c(l lVar) {
        AppMethodBeat.i(123096);
        for (int i2 = 0; i2 < this.Bwa.size(); i2++) {
            if (lVar.yFq.equalsIgnoreCase(this.Bwa.get(i2).yFq)) {
                removeViewAt(i2);
                this.Bwa.remove(i2);
                eGW();
                invalidate();
                AppMethodBeat.o(123096);
                return;
            }
        }
        AppMethodBeat.o(123096);
    }

    static {
        AppMethodBeat.i(123102);
        AppMethodBeat.o(123102);
    }

    private static boolean aKK(String str) {
        AppMethodBeat.i(123097);
        boolean matches = Bwg.matcher(str).matches();
        AppMethodBeat.o(123097);
        return matches;
    }

    public final boolean eGV() {
        AppMethodBeat.i(123098);
        Iterator<l> it = this.Bwa.iterator();
        while (it.hasNext()) {
            if (!aKK(it.next().yFq)) {
                AppMethodBeat.o(123098);
                return false;
            }
        }
        AppMethodBeat.o(123098);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void eGW() {
        AppMethodBeat.i(123099);
        int childCount = getChildCount();
        int measuredWidth = getMeasuredWidth();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8 || (childAt instanceof AutoCompleteTextView)) {
                int width = childAt.getWidth();
                int height = childAt.getHeight();
                if (width == 0) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
                    width = childAt.getMeasuredWidth();
                }
                int i5 = (this.Bwb == null || i4 != childCount - 1 || this.Bwb.isFocused()) ? width : 0;
                if (i3 + i5 > measuredWidth) {
                    i2 += height;
                    i3 = 0;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) childAt.getLayoutParams();
                layoutParams.setMargins(i3, i2, layoutParams.rightMargin, layoutParams.bottomMargin);
                childAt.setLayoutParams(layoutParams);
                i3 += i5;
                childAt.setVisibility(0);
            }
        }
        AppMethodBeat.o(123099);
    }

    private void bW(String str, boolean z) {
        AppMethodBeat.i(123100);
        String trim = str.trim();
        if (trim.length() == 0) {
            AppMethodBeat.o(123100);
            return;
        }
        List<l> aKD = ((k) g.ah(k.class)).getNormalMailAppService().BrU.aKD(trim);
        if (aKD.size() > 0) {
            b(aKD.get(0));
            this.Bwb.setText("");
            AppMethodBeat.o(123100);
        } else if (aKK(trim)) {
            l lVar = new l();
            lVar.name = trim;
            lVar.yFq = trim;
            lVar.Bry = 0;
            b(lVar);
            this.Bwb.setText("");
            AppMethodBeat.o(123100);
        } else if (z) {
            if (this.Bwf != null) {
                this.Bwf.eGH();
            } else {
                Toast.makeText(getContext(), (int) R.string.foa, 2000).show();
            }
            this.Bwb.setText(trim);
            this.Bwb.setSelection(trim.length());
            AppMethodBeat.o(123100);
        } else {
            if (this.Bwf != null) {
                this.Bwf.b(this);
            }
            AppMethodBeat.o(123100);
        }
    }

    public static abstract class c {
        public void sS(boolean z) {
        }
    }

    public static class b extends BaseAdapter implements Filterable {
        private boolean Bwl = true;
        private a Bwm;
        private List<l> kjY;
        private ArrayList<l> kjZ;
        private Context mContext;
        private final Object mLock = new Object();

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(123083);
            l Vi = Vi(i2);
            AppMethodBeat.o(123083);
            return Vi;
        }

        public b(Context context, List<l> list) {
            AppMethodBeat.i(123077);
            this.mContext = context;
            this.kjY = list;
            AppMethodBeat.o(123077);
        }

        public final void notifyDataSetChanged() {
            AppMethodBeat.i(123078);
            super.notifyDataSetChanged();
            this.Bwl = true;
            AppMethodBeat.o(123078);
        }

        public final int getCount() {
            AppMethodBeat.i(123079);
            int size = this.kjY.size();
            AppMethodBeat.o(123079);
            return size;
        }

        public final l Vi(int i2) {
            AppMethodBeat.i(123080);
            l lVar = this.kjY.get(i2);
            AppMethodBeat.o(123080);
            return lVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            View view2;
            AppMethodBeat.i(123081);
            if (view == null) {
                view2 = View.inflate(this.mContext, R.layout.bk2, null);
                C1614b bVar = new C1614b(this, (byte) 0);
                bVar.kgE = (TextView) view2.findViewById(R.id.gn8);
                bVar.BvW = (TextView) view2.findViewById(R.id.gn5);
                bVar.Bwo = (CheckBox) view2.findViewById(R.id.gn9);
                view2.setTag(bVar);
            } else {
                view2 = (ViewGroup) view;
            }
            l Vi = Vi(i2);
            C1614b bVar2 = (C1614b) view2.getTag();
            bVar2.kgE.setText(Vi.name);
            bVar2.BvW.setText(Vi.yFq);
            bVar2.Bwo.setVisibility(8);
            view2.setBackgroundColor(this.mContext.getResources().getColor(R.color.afz));
            AppMethodBeat.o(123081);
            return view2;
        }

        public final Filter getFilter() {
            AppMethodBeat.i(123082);
            if (this.Bwm == null) {
                this.Bwm = new a(this, (byte) 0);
            }
            a aVar = this.Bwm;
            AppMethodBeat.o(123082);
            return aVar;
        }

        class a extends Filter {
            private a() {
            }

            /* synthetic */ a(b bVar, byte b2) {
                this();
            }

            /* access modifiers changed from: protected */
            public final Filter.FilterResults performFiltering(CharSequence charSequence) {
                AppMethodBeat.i(123075);
                Filter.FilterResults filterResults = new Filter.FilterResults();
                if (b.this.kjZ == null) {
                    synchronized (b.this.mLock) {
                        try {
                            b.this.kjZ = new ArrayList(b.this.kjY);
                        } catch (Throwable th) {
                            AppMethodBeat.o(123075);
                            throw th;
                        }
                    }
                }
                if (charSequence == null || charSequence.length() == 0) {
                    synchronized (b.this.mLock) {
                        try {
                            ArrayList arrayList = new ArrayList(b.this.kjZ);
                            filterResults.values = arrayList;
                            filterResults.count = arrayList.size();
                        } finally {
                            AppMethodBeat.o(123075);
                        }
                    }
                } else {
                    String lowerCase = charSequence.toString().toLowerCase();
                    ArrayList arrayList2 = b.this.kjZ;
                    int size = arrayList2.size();
                    ArrayList arrayList3 = new ArrayList(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        l lVar = (l) arrayList2.get(i2);
                        if (lVar.name.toLowerCase().contains(lowerCase) || lVar.yFq.toLowerCase().contains(lowerCase)) {
                            arrayList3.add(lVar);
                        }
                    }
                    filterResults.values = arrayList3;
                    filterResults.count = arrayList3.size();
                }
                return filterResults;
            }

            /* access modifiers changed from: protected */
            public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                AppMethodBeat.i(123076);
                b.this.kjY = (List) filterResults.values;
                if (filterResults.count > 0) {
                    b.this.notifyDataSetChanged();
                    AppMethodBeat.o(123076);
                    return;
                }
                b.this.kjY = new ArrayList(b.this.kjZ);
                b.this.notifyDataSetInvalidated();
                AppMethodBeat.o(123076);
            }
        }

        /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl$b$b  reason: collision with other inner class name */
        class C1614b {
            TextView BvW;
            CheckBox Bwo;
            TextView kgE;

            private C1614b() {
            }

            /* synthetic */ C1614b(b bVar, byte b2) {
                this();
            }
        }
    }
}
