package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.kinda.framework.animate.KindaAnimatorViewProxy;
import com.tencent.kinda.gen.KMoneyInputText;
import com.tencent.kinda.gen.KMoneyInputTextOnTextChangedCallback;
import com.tencent.kinda.gen.KMoneyInputTextOnkeyBoardVisibleAnchorCallback;
import com.tencent.kinda.gen.KView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class MMMoneyInputText extends MMKView<LinearLayout> implements KMoneyInputText {
    private KMoneyInputTextOnkeyBoardVisibleAnchorCallback anchorCallback;
    private String content;
    private TenpaySecureEditText contentTv;
    private LinearLayout contentView;
    private KMoneyInputTextOnTextChangedCallback textChangedCallback;
    private String title;
    private TextView titleTv;

    @Override // com.tencent.kinda.framework.widget.base.MMKView
    public LinearLayout createView(final Context context) {
        AppMethodBeat.i(19289);
        this.contentView = (LinearLayout) View.inflate(context, R.layout.c9s, null);
        this.titleTv = (TextView) this.contentView.findViewById(R.id.jia);
        this.contentTv = (TenpaySecureEditText) this.contentView.findViewById(R.id.jf4);
        this.contentTv.setBackgroundResource(R.drawable.aij);
        this.contentTv.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.kinda.framework.widget.base.MMMoneyInputText.AnonymousClass1 */
            private byte _hellAccFlag_;

            public void onClick(View view) {
                AppMethodBeat.i(19286);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/kinda/framework/widget/base/MMMoneyInputText$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (context instanceof BaseFrActivity) {
                    ((BaseFrActivity) context).hideTenpayKB();
                }
                a.a(this, "com/tencent/kinda/framework/widget/base/MMMoneyInputText$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(19286);
            }
        });
        this.contentTv.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.kinda.framework.widget.base.MMMoneyInputText.AnonymousClass2 */

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void afterTextChanged(Editable editable) {
                AppMethodBeat.i(19287);
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 2) {
                    editable.delete(indexOf + 3, length);
                }
                if (MMMoneyInputText.this.textChangedCallback != null) {
                    MMMoneyInputText.this.textChangedCallback.onTextChanged(editable.toString());
                }
                AppMethodBeat.o(19287);
            }
        });
        if (context instanceof BaseFrActivity) {
            ((BaseFrActivity) context).setEditFocusListener(this.contentView, 2, false);
            ((BaseFrActivity) context).setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a() {
                /* class com.tencent.kinda.framework.widget.base.MMMoneyInputText.AnonymousClass3 */

                @Override // com.tencent.mm.wallet_core.ui.a
                public void onVisibleStateChange(boolean z) {
                    AppMethodBeat.i(19288);
                    View findParentScrollView = MMMoneyInputText.this.findParentScrollView(MMMoneyInputText.this.contentView);
                    if (MMMoneyInputText.this.anchorCallback != null) {
                        KView onkeyBoardVisibleAnchor = MMMoneyInputText.this.anchorCallback.onkeyBoardVisibleAnchor();
                        if (!z) {
                            ((BaseFrActivity) context).scrollTo(findParentScrollView, 0, 0);
                        } else if (onkeyBoardVisibleAnchor instanceof MMKView) {
                            ((BaseFrActivity) context).scrollToFormEditPosAfterShowTenPay(findParentScrollView, ((MMKView) onkeyBoardVisibleAnchor).getView(), 30);
                            AppMethodBeat.o(19288);
                            return;
                        } else {
                            Object unwrapProxyObject = KindaAnimatorViewProxy.unwrapProxyObject(onkeyBoardVisibleAnchor);
                            if (unwrapProxyObject instanceof MMKView) {
                                ((BaseFrActivity) context).scrollToFormEditPosAfterShowTenPay(findParentScrollView, ((MMKView) unwrapProxyObject).getView(), 30);
                            }
                            AppMethodBeat.o(19288);
                            return;
                        }
                    }
                    AppMethodBeat.o(19288);
                }
            });
        }
        LinearLayout linearLayout = this.contentView;
        AppMethodBeat.o(19289);
        return linearLayout;
    }

    /* access modifiers changed from: package-private */
    public View findParentScrollView(View view) {
        AppMethodBeat.i(19290);
        if (view == null) {
            AppMethodBeat.o(19290);
            return null;
        }
        ViewParent parent = view.getParent();
        if (parent == null) {
            AppMethodBeat.o(19290);
            return null;
        } else if (parent instanceof ScrollView) {
            View view2 = (View) parent;
            AppMethodBeat.o(19290);
            return view2;
        } else if (parent instanceof View) {
            View findParentScrollView = findParentScrollView((View) parent);
            AppMethodBeat.o(19290);
            return findParentScrollView;
        } else {
            AppMethodBeat.o(19290);
            return null;
        }
    }

    @Override // com.tencent.kinda.gen.KMoneyInputText
    public void setTitle(String str) {
        AppMethodBeat.i(19291);
        this.title = str;
        this.titleTv.setText(this.title);
        notifyChanged();
        AppMethodBeat.o(19291);
    }

    @Override // com.tencent.kinda.gen.KMoneyInputText
    public String getTitle() {
        AppMethodBeat.i(19292);
        String charSequence = this.titleTv.getText().toString();
        AppMethodBeat.o(19292);
        return charSequence;
    }

    @Override // com.tencent.kinda.gen.KMoneyInputText
    public void setInputText(String str) {
        AppMethodBeat.i(19293);
        this.content = str;
        this.contentTv.setText(this.content);
        notifyChanged();
        AppMethodBeat.o(19293);
    }

    @Override // com.tencent.kinda.gen.KMoneyInputText
    public String getInputText() {
        AppMethodBeat.i(19294);
        String obj = this.contentTv.getText().toString();
        AppMethodBeat.o(19294);
        return obj;
    }

    @Override // com.tencent.kinda.gen.KMoneyInputText
    public void setFocus(boolean z) {
    }

    @Override // com.tencent.kinda.gen.KMoneyInputText
    public boolean getFocus() {
        return false;
    }

    @Override // com.tencent.kinda.gen.KMoneyInputText
    public void setOnTextChangedCallback(KMoneyInputTextOnTextChangedCallback kMoneyInputTextOnTextChangedCallback) {
        this.textChangedCallback = kMoneyInputTextOnTextChangedCallback;
    }

    @Override // com.tencent.kinda.gen.KMoneyInputText
    public void setOnkeyBoardVisibleAnchorCallback(KMoneyInputTextOnkeyBoardVisibleAnchorCallback kMoneyInputTextOnkeyBoardVisibleAnchorCallback) {
        this.anchorCallback = kMoneyInputTextOnkeyBoardVisibleAnchorCallback;
    }
}
