package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.appbrand.wxawidget.a;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public class ConsolePanel extends FrameLayout implements a {
    MRecyclerView nWH;
    final List<LogInfo> oFB = new LinkedList();
    EditText oFH;
    Button[] oFI;
    Button oFJ;
    Button oFK;
    a oFL;
    int oFM;
    String oFN;

    public ConsolePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(121630);
        initialize();
        AppMethodBeat.o(121630);
    }

    public ConsolePanel(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(121631);
        initialize();
        AppMethodBeat.o(121631);
    }

    private void initialize() {
        AppMethodBeat.i(121632);
        LayoutInflater.from(getContext()).inflate(R.layout.w_, (ViewGroup) this, true);
        this.oFH = (EditText) findViewById(R.id.b_u);
        this.oFH.clearFocus();
        this.oFI = new Button[5];
        eP(0, R.id.er5);
        eP(1, R.id.er8);
        eP(2, R.id.er7);
        eP(3, R.id.era);
        eP(4, R.id.er6);
        this.oFI[0].setSelected(true);
        this.oFM = 0;
        this.oFJ = (Button) findViewById(R.id.b3i);
        this.oFK = (Button) findViewById(R.id.h_c);
        this.oFK.setEnabled(false);
        this.oFJ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(121622);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ConsolePanel.this.oFB.clear();
                ConsolePanel.this.oFL.oFB.clear();
                ConsolePanel.this.oFL.atj.notifyChanged();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(121622);
            }
        });
        this.oFK.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(121623);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(121623);
            }
        });
        this.oFH.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel.AnonymousClass3 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.oFH.setOnKeyListener(new View.OnKeyListener() {
            /* class com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel.AnonymousClass4 */

            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(121624);
                b bVar = new b();
                bVar.bm(view);
                bVar.pH(i2);
                bVar.bm(keyEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$4", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
                if (i2 == 66) {
                    ConsolePanel.this.oFN = ConsolePanel.this.oFH.getText().toString();
                    ConsolePanel.a(ConsolePanel.this);
                    f.dm(view);
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$4", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                    AppMethodBeat.o(121624);
                    return true;
                }
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$4", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(121624);
                return false;
            }
        });
        this.oFH.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel.AnonymousClass5 */

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(121625);
                if (!z) {
                    f.dm(view);
                }
                AppMethodBeat.o(121625);
            }
        });
        findViewById(R.id.bsr).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(121626);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ConsolePanel.this.oFN = ConsolePanel.this.oFH.getText().toString();
                ConsolePanel.a(ConsolePanel.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(121626);
            }
        });
        setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel.AnonymousClass7 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(121627);
                f.dm(view);
                AppMethodBeat.o(121627);
                return false;
            }
        });
        this.nWH = (MRecyclerView) findViewById(R.id.er_);
        this.oFL = new a(getContext());
        MRecyclerView mRecyclerView = this.nWH;
        getContext();
        mRecyclerView.setLayoutManager(new LinearLayoutManager());
        this.nWH.setItemAnimator(null);
        this.nWH.setAdapter(this.oFL);
        AppMethodBeat.o(121632);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r10) {
        /*
        // Method dump skipped, instructions count: 114
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    private void eP(int i2, int i3) {
        AppMethodBeat.i(121634);
        Button button = (Button) findViewById(i3);
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(121628);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                for (int i2 = 0; i2 < ConsolePanel.this.oFI.length; i2++) {
                    Button button = ConsolePanel.this.oFI[i2];
                    boolean z = button == view;
                    button.setSelected(z);
                    if (z && ConsolePanel.this.oFM != i2) {
                        ConsolePanel.this.oFM = i2;
                        ConsolePanel.a(ConsolePanel.this);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(121628);
            }
        });
        this.oFI[i2] = button;
        AppMethodBeat.o(121634);
    }

    @Override // com.tencent.mm.plugin.appbrand.wxawidget.a
    public final void bY(List<LogInfo> list) {
        AppMethodBeat.i(121635);
        if (list == null) {
            AppMethodBeat.o(121635);
            return;
        }
        final LinkedList linkedList = new LinkedList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            LogInfo logInfo = list.get(i2);
            this.oFB.add(logInfo);
            if ((logInfo.level == this.oFM || this.oFM == 0) && !agn(logInfo.message)) {
                linkedList.add(logInfo);
            }
        }
        if (!linkedList.isEmpty()) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(121629);
                    int itemCount = ConsolePanel.this.oFL.getItemCount();
                    ConsolePanel.this.oFL.oFB.addAll(linkedList);
                    ConsolePanel.this.oFL.as(itemCount, linkedList.size());
                    if (((LinearLayoutManager) ConsolePanel.this.nWH.getLayoutManager()).ku() == itemCount - 1) {
                        MRecyclerView mRecyclerView = ConsolePanel.this.nWH;
                        com.tencent.mm.hellhoundlib.b.a a2 = c.a(ConsolePanel.this.oFL.getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
                        com.tencent.mm.hellhoundlib.a.a.a(mRecyclerView, a2.axQ(), "com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$9", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                        mRecyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                        com.tencent.mm.hellhoundlib.a.a.a(mRecyclerView, "com/tencent/mm/plugin/appbrand/wxawidget/console/ConsolePanel$9", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                    }
                    AppMethodBeat.o(121629);
                }
            });
        }
        AppMethodBeat.o(121635);
    }

    private boolean agn(String str) {
        AppMethodBeat.i(121636);
        if (Util.isNullOrNil(this.oFN) || (str != null && str.toLowerCase().contains(this.oFN.toLowerCase()))) {
            AppMethodBeat.o(121636);
            return false;
        }
        AppMethodBeat.o(121636);
        return true;
    }

    static /* synthetic */ void a(ConsolePanel consolePanel) {
        AppMethodBeat.i(121637);
        consolePanel.oFL.oFB.clear();
        for (int i2 = 0; i2 < consolePanel.oFB.size(); i2++) {
            LogInfo logInfo = consolePanel.oFB.get(i2);
            if ((consolePanel.oFM <= 0 || logInfo.level == consolePanel.oFM) && !consolePanel.agn(logInfo.message)) {
                consolePanel.oFL.oFB.add(logInfo);
            }
        }
        consolePanel.oFL.atj.notifyChanged();
        AppMethodBeat.o(121637);
    }
}
