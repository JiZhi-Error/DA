package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class LuckyMoneyWishFooter extends BasePanelKeybordLayout {
    private MMActivity gte;
    private Button han;
    ChatFooterPanel rum;
    private int state = 0;
    private ImageButton ziQ;
    MMEditText ziR;
    boolean ziS = false;
    public boolean ziT = false;
    private boolean ziU = true;
    boolean ziV = true;
    private TextWatcher ziW = new TextWatcher() {
        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter.AnonymousClass3 */

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(65945);
            if (LuckyMoneyWishFooter.this.ziR.getText() == null) {
                AppMethodBeat.o(65945);
                return;
            }
            LuckyMoneyWishFooter.this.ziR.requestFocus();
            boolean z = editable.length() > 0 && editable.toString().trim().length() > 0;
            if (z && LuckyMoneyWishFooter.this.ziV) {
                LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this, true);
                LuckyMoneyWishFooter.this.ziV = false;
            }
            if (!z) {
                LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this, false);
                LuckyMoneyWishFooter.this.ziV = true;
            }
            AppMethodBeat.o(65945);
        }
    };
    private a ziX;
    private c ziY;

    /* access modifiers changed from: package-private */
    public interface a {
    }

    public interface b {
        void aDC(String str);
    }

    interface c {
    }

    static /* synthetic */ void a(LuckyMoneyWishFooter luckyMoneyWishFooter, boolean z) {
        AppMethodBeat.i(65964);
        luckyMoneyWishFooter.qT(z);
        AppMethodBeat.o(65964);
    }

    static /* synthetic */ void f(LuckyMoneyWishFooter luckyMoneyWishFooter) {
        AppMethodBeat.i(65965);
        luckyMoneyWishFooter.egH();
        AppMethodBeat.o(65965);
    }

    public void setModeClick(boolean z) {
        this.ziS = z;
    }

    public LuckyMoneyWishFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(65951);
        this.gte = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) inflate(this.gte, R.layout.b4g, this);
        this.han = (Button) viewGroup.findViewById(R.id.f5_);
        qT(false);
        this.ziQ = (ImageButton) viewGroup.findViewById(R.id.f59);
        this.ziQ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(65946);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyWishFooter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.SnsCommentFooter", "state onClick" + LuckyMoneyWishFooter.this.state);
                if (LuckyMoneyWishFooter.this.state == 0) {
                    LuckyMoneyWishFooter.this.setModeClick(true);
                    LuckyMoneyWishFooter.this.ziQ.setImageResource(R.raw.icons_outlined_emoji);
                    LuckyMoneyWishFooter.this.state = 1;
                    LuckyMoneyWishFooter.this.ziU = false;
                } else {
                    LuckyMoneyWishFooter.this.setModeClick(false);
                    LuckyMoneyWishFooter.this.ziU = false;
                    LuckyMoneyWishFooter.this.ziQ.setImageResource(R.raw.icons_outlined_emoji);
                    LuckyMoneyWishFooter.this.state = 0;
                }
                LuckyMoneyWishFooter.f(LuckyMoneyWishFooter.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyWishFooter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65946);
            }
        });
        this.ziR = (MMEditText) viewGroup.findViewById(R.id.f57);
        this.ziR.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter.AnonymousClass5 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(65947);
                LuckyMoneyWishFooter.this.ziU = false;
                LuckyMoneyWishFooter.this.rum.setVisibility(8);
                LuckyMoneyWishFooter.this.rum.onPause();
                LuckyMoneyWishFooter.this.ziQ.setImageResource(R.raw.icons_outlined_emoji);
                if (LuckyMoneyWishFooter.this.ziX != null) {
                    a unused = LuckyMoneyWishFooter.this.ziX;
                }
                LuckyMoneyWishFooter.this.state = 0;
                AppMethodBeat.o(65947);
                return false;
            }
        });
        if (e.Knc == null) {
            this.rum = new d(this.gte);
            AppMethodBeat.o(65951);
            return;
        }
        this.rum = e.Knc.eZ(getContext());
        this.rum.setEntranceScene(ChatFooterPanel.KbB);
        this.rum.setVisibility(8);
        ((LinearLayout) findViewById(R.id.h8v)).addView(this.rum, -1, 0);
        this.rum.goD();
        this.rum.onResume();
        this.rum.setOnTextOperationListener(new ChatFooterPanel.a() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter.AnonymousClass6 */

            @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
            public final void aHD() {
            }

            @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
            public final void eP(boolean z) {
            }

            @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
            public final void aHC() {
                AppMethodBeat.i(65948);
                LuckyMoneyWishFooter.this.ziR.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
                LuckyMoneyWishFooter.this.ziR.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
                AppMethodBeat.o(65948);
            }

            @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
            public final void append(String str) {
                AppMethodBeat.i(65949);
                try {
                    LuckyMoneyWishFooter.this.ziR.bol(str);
                    AppMethodBeat.o(65949);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.SnsCommentFooter", e2, "", new Object[0]);
                    AppMethodBeat.o(65949);
                }
            }
        });
        AppMethodBeat.o(65951);
    }

    public void setVisibility(int i2) {
        boolean z;
        AppMethodBeat.i(65952);
        this.state = 0;
        if (i2 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.rum != null) {
            Log.i("MicroMsg.SnsCommentFooter", "showState ".concat(String.valueOf(z)));
            if (!z) {
                Log.d("MicroMsg.SnsCommentFooter", new StringBuilder().append(Util.getStack()).toString());
                this.rum.setVisibility(8);
                this.ziQ.setImageResource(R.raw.icons_outlined_emoji);
                this.gte.hideVKB();
                setModeClick(true);
                requestLayout();
            } else {
                egH();
                this.ziU = false;
            }
        }
        super.setVisibility(i2);
        AppMethodBeat.o(65952);
    }

    private void egH() {
        AppMethodBeat.i(65953);
        if (this.state == 0) {
            this.ziR.requestFocus();
            this.gte.getWindow().setSoftInputMode(16);
            this.gte.showVKB();
            this.rum.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(65943);
                    LuckyMoneyWishFooter.this.rum.setVisibility(4);
                    AppMethodBeat.o(65943);
                }
            }, 200);
            AppMethodBeat.o(65953);
            return;
        }
        this.ziR.requestFocus();
        this.gte.getWindow().setSoftInputMode(32);
        this.gte.hideVKB();
        cbL();
        AppMethodBeat.o(65953);
    }

    private void cbL() {
        AppMethodBeat.i(65954);
        this.rum.onResume();
        this.rum.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(65944);
                LuckyMoneyWishFooter.this.rum.setVisibility(0);
                AppMethodBeat.o(65944);
            }
        }, 200);
        ViewGroup.LayoutParams layoutParams = this.rum.getLayoutParams();
        if ((layoutParams != null && layoutParams.height <= 0) || (layoutParams != null && i.isPortOrientation(getContext()) && this.ziU)) {
            layoutParams.height = i.getValidPanelHeight(getContext());
            this.rum.setLayoutParams(layoutParams);
            this.ziU = false;
        }
        AppMethodBeat.o(65954);
    }

    public void setMaxLength(int i2) {
        AppMethodBeat.i(65955);
        this.ziR.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
        AppMethodBeat.o(65955);
    }

    public void setText(String str) {
        AppMethodBeat.i(65957);
        if (this.ziR != null) {
            this.ziR.setText("");
            this.ziR.bol(str);
        }
        AppMethodBeat.o(65957);
    }

    public void setHint(String str) {
        AppMethodBeat.i(65958);
        this.ziR.setHint(str);
        AppMethodBeat.o(65958);
    }

    public void setOnEditTouchListener(a aVar) {
        this.ziX = aVar;
    }

    public void setOnSmileyShowListener(c cVar) {
        this.ziY = cVar;
    }

    public void setOnWishSendImp(final b bVar) {
        AppMethodBeat.i(65959);
        this.han.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(65950);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyWishFooter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                bVar.aDC(LuckyMoneyWishFooter.this.ziR.getText().toString());
                LuckyMoneyWishFooter.this.ziR.setText("");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyWishFooter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65950);
            }
        });
        AppMethodBeat.o(65959);
    }

    @Override // com.tencent.mm.ui.KeyboardLinearLayout
    public final void Ns(int i2) {
        AppMethodBeat.i(65960);
        super.Ns(i2);
        switch (i2) {
            case -3:
                this.ziT = true;
                AppMethodBeat.o(65960);
                return;
            default:
                this.ziT = false;
                AppMethodBeat.o(65960);
                return;
        }
    }

    private void qT(boolean z) {
        AppMethodBeat.i(65962);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.dd);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.di);
        loadAnimation.setDuration(150);
        loadAnimation2.setDuration(150);
        if (this.han == null) {
            AppMethodBeat.o(65962);
        } else if (z) {
            if (this.han.getVisibility() == 8 || this.han.getVisibility() == 4) {
                AppMethodBeat.o(65962);
                return;
            }
            this.han.startAnimation(loadAnimation2);
            this.han.setVisibility(8);
            AppMethodBeat.o(65962);
        } else if (this.han.getVisibility() == 0 || this.han.getVisibility() == 0) {
            AppMethodBeat.o(65962);
        } else {
            this.han.startAnimation(loadAnimation);
            this.han.setVisibility(0);
            AppMethodBeat.o(65962);
        }
    }

    @Override // com.tencent.mm.ui.BasePanelKeybordLayout
    public List<View> getPanelView() {
        AppMethodBeat.i(65963);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.rum);
        AppMethodBeat.o(65963);
        return arrayList;
    }
}
