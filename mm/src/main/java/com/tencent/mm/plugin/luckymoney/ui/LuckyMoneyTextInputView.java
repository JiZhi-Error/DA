package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.widget.MMEditText;

public class LuckyMoneyTextInputView extends LinearLayout implements d {
    private TextView mPa;
    private h yPY;
    private MMEditText yRw;
    LinearLayout ziF;
    ImageView ziG;
    BaseEmojiView ziH;
    private View.OnClickListener ziI;

    public LuckyMoneyTextInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(65933);
        View inflate = LayoutInflater.from(context).inflate(R.layout.b4e, (ViewGroup) this, true);
        this.yRw = (MMEditText) inflate.findViewById(R.id.f4t);
        this.mPa = (TextView) inflate.findViewById(R.id.f4u);
        this.ziF = (LinearLayout) inflate.findViewById(R.id.f08);
        this.ziG = (ImageView) inflate.findViewById(R.id.f09);
        this.ziH = (BaseEmojiView) inflate.findViewById(R.id.f07);
        this.yRw.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView.AnonymousClass1 */

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(65931);
                if (LuckyMoneyTextInputView.this.yPY != null) {
                    h hVar = LuckyMoneyTextInputView.this.yPY;
                    LuckyMoneyTextInputView.this.getInputViewId();
                    hVar.eeI();
                }
                AppMethodBeat.o(65931);
            }
        });
        this.ziF.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(65932);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyTextInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (LuckyMoneyTextInputView.this.ziI != null) {
                    LuckyMoneyTextInputView.this.ziI.onClick(view);
                }
                a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyTextInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65932);
            }
        });
        this.ziF.setVisibility(8);
        AppMethodBeat.o(65933);
    }

    public void setOnInputValidChangerListener(h hVar) {
        this.yPY = hVar;
    }

    public void setmOnEmojiSelectClickListener(View.OnClickListener onClickListener) {
        this.ziI = onClickListener;
    }

    public String getInput() {
        AppMethodBeat.i(65934);
        String obj = this.yRw.getText().toString();
        AppMethodBeat.o(65934);
        return obj;
    }

    public void setHintText(String str) {
        AppMethodBeat.i(65935);
        this.yRw.setHint(str);
        AppMethodBeat.o(65935);
    }

    public void setTitle(String str) {
        AppMethodBeat.i(65936);
        this.mPa.setText(str);
        AppMethodBeat.o(65936);
    }

    public final void qS(boolean z) {
        AppMethodBeat.i(65937);
        if (z) {
            this.ziF.setVisibility(8);
            AppMethodBeat.o(65937);
            return;
        }
        this.ziF.setVisibility(0);
        this.ziG.setVisibility(0);
        this.ziH.setVisibility(8);
        AppMethodBeat.o(65937);
    }

    public final void A(EmojiInfo emojiInfo) {
        AppMethodBeat.i(65938);
        this.ziF.setTag("delete");
        this.ziG.setVisibility(8);
        this.ziH.setVisibility(0);
        this.ziH.setEmojiInfo(emojiInfo);
        AppMethodBeat.o(65938);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.d
    public final int eeH() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.d
    public final void restore() {
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.d
    public final void onError() {
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.d
    public int getInputViewId() {
        AppMethodBeat.i(65939);
        int id = getId();
        AppMethodBeat.o(65939);
        return id;
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.d
    public final String PA(int i2) {
        return null;
    }
}
