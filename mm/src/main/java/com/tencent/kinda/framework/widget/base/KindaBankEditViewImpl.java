package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.FontStyle;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KBankEditView;
import com.tencent.kinda.gen.KBankEditViewOnSeletBankCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ai;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public class KindaBankEditViewImpl extends MMKView<EditText> implements KBankEditView {
    String TAG = "KindaBank.KindaBankEditViewImpl";
    private byte _hellAccFlag_;
    private IListener<ai> bankEditSelectedEventIListener = new IListener<ai>() {
        /* class com.tencent.kinda.framework.widget.base.KindaBankEditViewImpl.AnonymousClass1 */

        {
            AppMethodBeat.i(160760);
            this.__eventId = ai.class.getName().hashCode();
            AppMethodBeat.o(160760);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public /* bridge */ /* synthetic */ boolean callback(ai aiVar) {
            AppMethodBeat.i(18843);
            boolean callback = callback(aiVar);
            AppMethodBeat.o(18843);
            return callback;
        }

        public boolean callback(ai aiVar) {
            String str;
            AppMethodBeat.i(18842);
            if (KindaWrapBankEditActivity.FLAG_ACTIVITY_CLOSE.equals(aiVar.dDh.dDi)) {
                KindaBankEditViewImpl.this.bankEditSelectedEventIListener.dead();
            } else if (KindaWrapBankEditActivity.FLAG_ACTIVITY_BACK.equals(aiVar.dDh.dDi)) {
                KindaBankEditViewImpl.this.mCallBack.onSeletBank("");
            } else {
                if (!Util.isNullOrNil(KindaBankEditViewImpl.this.mBankTypeLiskBuffer)) {
                    str = aiVar.dDh.dDi + " " + aiVar.dDh.dDk;
                } else {
                    str = aiVar.dDh.dDi;
                }
                KindaBankEditViewImpl.this.mEditText.setText(str);
                if (KindaBankEditViewImpl.this.mCallBack != null) {
                    KindaBankEditViewImpl.this.mBankType = aiVar.dDh.dDj;
                    KindaBankEditViewImpl.this.mCallBack.onSeletBank(str);
                }
            }
            AppMethodBeat.o(18842);
            return false;
        }
    };
    private FontStyle fontStyle = FontStyle.REGULAR;
    private byte[] mBankLiskBuffer;
    private String mBankType;
    private byte[] mBankTypeLiskBuffer;
    private KBankEditViewOnSeletBankCallback mCallBack;
    private Context mContext;
    private EditText mEditText;
    private DynamicColor normalColor = new DynamicColor(-1, 0);

    public KindaBankEditViewImpl() {
        AppMethodBeat.i(18844);
        AppMethodBeat.o(18844);
    }

    @Override // com.tencent.kinda.framework.widget.base.MMKView
    public EditText createView(Context context) {
        AppMethodBeat.i(18845);
        this.mEditText = new EditText(context);
        this.mEditText.setInputType(0);
        this.mEditText.setFocusable(false);
        this.mEditText.setBackground(null);
        this.mEditText.setHint(R.string.imx);
        this.mEditText.setTextSize(0, MMKViewUtil.dpToPx(MMApplicationContext.getContext(), 17.0f));
        this.mEditText.setPadding(0, this.mEditText.getHeight() / 2, 0, this.mEditText.getHeight() / 2);
        this.mEditText.setGravity(16);
        this.mEditText.setInputType(131072);
        this.mEditText.setSingleLine(false);
        if (ColorUtil.ifCompatKindaDarkModeDefaultColor()) {
            this.mEditText.setHintTextColor(context.getResources().getColor(R.color.uj));
            this.mEditText.setTextColor(context.getResources().getColor(R.color.a2x));
        }
        this.mContext = context;
        Log.i(this.TAG, "BankEditSelected callback，注册监听，当前线程：" + Thread.currentThread().getId());
        EditText editText = this.mEditText;
        AppMethodBeat.o(18845);
        return editText;
    }

    @Override // com.tencent.kinda.gen.KBankEditView
    public void setData(ITransmitKvData iTransmitKvData) {
        AppMethodBeat.i(18846);
        this.mBankLiskBuffer = iTransmitKvData.getBinary("bank_list");
        this.mBankTypeLiskBuffer = iTransmitKvData.getBinary("bank_type_list");
        AppMethodBeat.o(18846);
    }

    @Override // com.tencent.kinda.gen.KBankEditView
    public void setSelected(String str) {
        AppMethodBeat.i(18847);
        this.mEditText.setText(str);
        AppMethodBeat.o(18847);
    }

    @Override // com.tencent.kinda.gen.KBankEditView
    public String getSelectedBankType() {
        return this.mBankType;
    }

    @Override // com.tencent.kinda.gen.KBankEditView
    public void setOnSeletBankCallback(KBankEditViewOnSeletBankCallback kBankEditViewOnSeletBankCallback) {
        this.mCallBack = kBankEditViewOnSeletBankCallback;
    }

    @Override // com.tencent.kinda.gen.KBankEditView
    public void setFocus(boolean z) {
        AppMethodBeat.i(18848);
        if (z) {
            this.bankEditSelectedEventIListener.alive();
            if (this.mContext instanceof BaseFrActivity) {
                ((BaseFrActivity) this.mContext).hideTenpayKB();
            }
            Intent intent = new Intent(this.mContext, KindaWrapBankEditActivity.class);
            intent.putExtra("bank_list", this.mBankLiskBuffer);
            intent.putExtra("bank_type_list", this.mBankTypeLiskBuffer);
            Context context = this.mContext;
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/kinda/framework/widget/base/KindaBankEditViewImpl", "setFocus", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/kinda/framework/widget/base/KindaBankEditViewImpl", "setFocus", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(18848);
    }

    @Override // com.tencent.kinda.gen.KBankEditView
    public boolean getFocus() {
        AppMethodBeat.i(18849);
        boolean isFocused = this.mEditText.isFocused();
        AppMethodBeat.o(18849);
        return isFocused;
    }

    @Override // com.tencent.kinda.gen.KBankEditView
    public void setTextColor(DynamicColor dynamicColor) {
        AppMethodBeat.i(18850);
        if (ColorUtil.getColorByModeNoCompat(this.normalColor) != ColorUtil.getColorByMode(dynamicColor)) {
            this.normalColor = dynamicColor;
        }
        this.mEditText.setTextColor((int) ColorUtil.getColorByModeNoCompat(this.normalColor));
        AppMethodBeat.o(18850);
    }

    @Override // com.tencent.kinda.gen.KBankEditView
    public DynamicColor getTextColor() {
        return this.normalColor;
    }

    @Override // com.tencent.kinda.gen.KBankEditView
    public void setTextSize(float f2) {
        AppMethodBeat.i(18851);
        this.mEditText.setTextSize(0, MMKViewUtil.dpToPx(MMApplicationContext.getContext(), f2));
        AppMethodBeat.o(18851);
    }

    @Override // com.tencent.kinda.gen.KBankEditView
    public float getTextSize() {
        AppMethodBeat.i(18852);
        float textSize = this.mEditText.getTextSize();
        AppMethodBeat.o(18852);
        return textSize;
    }

    @Override // com.tencent.kinda.gen.KBankEditView
    public void setFontStyle(FontStyle fontStyle2) {
        AppMethodBeat.i(18853);
        this.fontStyle = fontStyle2;
        if (this.fontStyle == FontStyle.BOLD) {
            this.mEditText.setTypeface(null, 1);
            AppMethodBeat.o(18853);
            return;
        }
        this.mEditText.setTypeface(null, 0);
        AppMethodBeat.o(18853);
    }

    @Override // com.tencent.kinda.gen.KBankEditView
    public FontStyle getFontStyle() {
        return this.fontStyle;
    }
}
