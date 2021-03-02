package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.phonenumber.widget.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddView;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddView;", "mContext", "Landroid/content/Context;", "mPhoneNumberAddLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;)V", "mContentView", "Landroid/view/View;", "mExistPhoneNum", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "mFinishBtn", "Landroid/widget/Button;", "mFormInputView", "Lcom/tencent/mm/plugin/appbrand/phonenumber/widget/MMFormVerifyCodeInputView;", "mFormVerifyCodeInputView", "Lcom/tencent/mm/ui/base/MMFormInputView;", "mSwitchBtn", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "containPhoneNum", "", "number", "", "count", "", "getView", "reset", "showReplicaNumDialog", "luggage-wechat-full-sdk_release"})
public final class t implements m {
    MMSwitchBtn jBx;
    private View mContentView = View.inflate(this.mContext, R.layout.eh, null);
    final Context mContext;
    Button nAa;
    List<PhoneItem> nAb;
    l nzV;
    MMFormVerifyCodeInputView nzY;
    MMFormInputView nzZ;

    public t(Context context, l lVar) {
        MMFormInputView mMFormInputView;
        MMSwitchBtn mMSwitchBtn;
        Button button;
        EditText contentEditText;
        EditText contentEditText2;
        p.h(context, "mContext");
        AppMethodBeat.i(148120);
        this.mContext = context;
        this.nzV = lVar;
        View view = this.mContentView;
        this.nzY = view != null ? (MMFormVerifyCodeInputView) view.findViewById(R.id.ps) : null;
        MMFormVerifyCodeInputView mMFormVerifyCodeInputView = this.nzY;
        if (!(mMFormVerifyCodeInputView == null || (contentEditText2 = mMFormVerifyCodeInputView.getContentEditText()) == null)) {
            contentEditText2.setTextColor(this.mContext.getResources().getColor(R.color.a2w));
        }
        View view2 = this.mContentView;
        if (view2 != null) {
            mMFormInputView = (MMFormInputView) view2.findViewById(R.id.pu);
        } else {
            mMFormInputView = null;
        }
        this.nzZ = mMFormInputView;
        MMFormInputView mMFormInputView2 = this.nzZ;
        if (!(mMFormInputView2 == null || (contentEditText = mMFormInputView2.getContentEditText()) == null)) {
            contentEditText.setTextColor(this.mContext.getResources().getColor(R.color.a2w));
        }
        View view3 = this.mContentView;
        if (view3 != null) {
            mMSwitchBtn = (MMSwitchBtn) view3.findViewById(R.id.pt);
        } else {
            mMSwitchBtn = null;
        }
        this.jBx = mMSwitchBtn;
        View view4 = this.mContentView;
        if (view4 != null) {
            button = (Button) view4.findViewById(R.id.pr);
        } else {
            button = null;
        }
        this.nAa = button;
        r rVar = r.nzC;
        this.nAb = r.bTy();
        MMFormVerifyCodeInputView mMFormVerifyCodeInputView2 = this.nzY;
        if (mMFormVerifyCodeInputView2 != null) {
            mMFormVerifyCodeInputView2.setInputType(3);
        }
        MMFormVerifyCodeInputView mMFormVerifyCodeInputView3 = this.nzY;
        if (mMFormVerifyCodeInputView3 != null) {
            mMFormVerifyCodeInputView3.setSendSmsBtnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.appbrand.phonenumber.t.AnonymousClass1 */
                final /* synthetic */ t nAc;

                {
                    this.nAc = r1;
                }

                /* JADX WARNING: Removed duplicated region for block: B:15:0x005d  */
                /* JADX WARNING: Removed duplicated region for block: B:20:0x008c  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void onClick(android.view.View r9) {
                    /*
                    // Method dump skipped, instructions count: 164
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.phonenumber.t.AnonymousClass1.onClick(android.view.View):void");
                }
            });
        }
        MMFormVerifyCodeInputView mMFormVerifyCodeInputView4 = this.nzY;
        if (mMFormVerifyCodeInputView4 != null) {
            mMFormVerifyCodeInputView4.addTextChangedListener(new TextWatcher(this) {
                /* class com.tencent.mm.plugin.appbrand.phonenumber.t.AnonymousClass2 */
                final /* synthetic */ t nAc;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.nAc = r1;
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    MMFormInputView mMFormInputView;
                    Editable text;
                    Editable text2;
                    AppMethodBeat.i(148113);
                    Button button = this.nAc.nAa;
                    if (button != null) {
                        MMFormVerifyCodeInputView mMFormVerifyCodeInputView = this.nAc.nzY;
                        button.setEnabled((mMFormVerifyCodeInputView == null || (text2 = mMFormVerifyCodeInputView.getText()) == null || text2.length() != 0) && ((mMFormInputView = this.nAc.nzZ) == null || (text = mMFormInputView.getText()) == null || text.length() != 0));
                        AppMethodBeat.o(148113);
                        return;
                    }
                    AppMethodBeat.o(148113);
                }

                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void afterTextChanged(Editable editable) {
                }
            });
        }
        MMFormInputView mMFormInputView3 = this.nzZ;
        if (mMFormInputView3 != null) {
            mMFormInputView3.setInputType(3);
        }
        MMFormInputView mMFormInputView4 = this.nzZ;
        if (mMFormInputView4 != null) {
            mMFormInputView4.addTextChangedListener(new TextWatcher(this) {
                /* class com.tencent.mm.plugin.appbrand.phonenumber.t.AnonymousClass3 */
                final /* synthetic */ t nAc;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.nAc = r1;
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    MMFormInputView mMFormInputView;
                    Editable text;
                    Editable text2;
                    AppMethodBeat.i(148114);
                    p.h(charSequence, "s");
                    Button button = this.nAc.nAa;
                    if (button != null) {
                        MMFormVerifyCodeInputView mMFormVerifyCodeInputView = this.nAc.nzY;
                        button.setEnabled((mMFormVerifyCodeInputView == null || (text2 = mMFormVerifyCodeInputView.getText()) == null || text2.length() != 0) && ((mMFormInputView = this.nAc.nzZ) == null || (text = mMFormInputView.getText()) == null || text.length() != 0));
                        AppMethodBeat.o(148114);
                        return;
                    }
                    AppMethodBeat.o(148114);
                }

                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    AppMethodBeat.i(148115);
                    p.h(charSequence, "s");
                    AppMethodBeat.o(148115);
                }

                public final void afterTextChanged(Editable editable) {
                    AppMethodBeat.i(148116);
                    p.h(editable, "s");
                    AppMethodBeat.o(148116);
                }
            });
        }
        Button button2 = this.nAa;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.appbrand.phonenumber.t.AnonymousClass4 */
                final /* synthetic */ t nAc;

                {
                    this.nAc = r1;
                }

                public final void onClick(View view) {
                    Boolean bool;
                    Editable editable = null;
                    AppMethodBeat.i(148117);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    l lVar = this.nAc.nzV;
                    if (lVar != null) {
                        MMSwitchBtn mMSwitchBtn = this.nAc.jBx;
                        if (mMSwitchBtn != null) {
                            bool = Boolean.valueOf(mMSwitchBtn.isCheck());
                        } else {
                            bool = null;
                        }
                        if (bool == null) {
                            p.hyc();
                        }
                        boolean booleanValue = bool.booleanValue();
                        MMFormVerifyCodeInputView mMFormVerifyCodeInputView = this.nAc.nzY;
                        String valueOf = String.valueOf(mMFormVerifyCodeInputView != null ? mMFormVerifyCodeInputView.getText() : null);
                        MMFormInputView mMFormInputView = this.nAc.nzZ;
                        if (mMFormInputView != null) {
                            editable = mMFormInputView.getText();
                        }
                        lVar.b(booleanValue, valueOf, String.valueOf(editable));
                    }
                    a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(148117);
                }
            });
            AppMethodBeat.o(148120);
            return;
        }
        AppMethodBeat.o(148120);
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.m
    public final void bTu() {
        AppMethodBeat.i(148118);
        MMFormVerifyCodeInputView mMFormVerifyCodeInputView = this.nzY;
        if (mMFormVerifyCodeInputView != null) {
            mMFormVerifyCodeInputView.bTu();
            AppMethodBeat.o(148118);
            return;
        }
        AppMethodBeat.o(148118);
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.m
    public final void reset() {
        AppMethodBeat.i(148119);
        MMFormVerifyCodeInputView mMFormVerifyCodeInputView = this.nzY;
        if (mMFormVerifyCodeInputView != null) {
            mMFormVerifyCodeInputView.reset();
            AppMethodBeat.o(148119);
            return;
        }
        AppMethodBeat.o(148119);
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.m
    public final View getView() {
        return this.mContentView;
    }
}
