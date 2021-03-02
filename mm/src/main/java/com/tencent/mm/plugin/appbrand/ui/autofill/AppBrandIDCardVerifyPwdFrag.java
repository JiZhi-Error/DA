package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI;
import com.tencent.mm.plugin.appbrand.widget.b;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.protocal.protobuf.hv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.a;
import com.tencent.mm.ui.a.d;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.lang.reflect.Method;
import java.util.Iterator;

public class AppBrandIDCardVerifyPwdFrag extends MMFragment {
    private LinearLayout gCh;
    private TextView hPW;
    private MMFormVerifyCodeInputView kmk;
    private a mActionBarHelper;
    private MyKeyboardWindow mKeyboard;
    private hv nZB;
    private hu nZO;
    private TextView nZP;
    AppBrandIDCardUI.a nZf;
    private View nZg;
    private Button nZi;
    private TextView nzh;

    @Override // com.tencent.mm.ui.MMFragment
    public void dealContentView(View view) {
        AppMethodBeat.i(48977);
        if (this.nZf == null || this.nZf.bXV() == null) {
            Log.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "idCardUILogic or idCardUILogic.getIDCardShowInfo() is null, err");
            AppMethodBeat.o(48977);
        } else if (this.nZf.bXV().KLJ == null || this.nZf.bXV().KLJ.size() <= 0) {
            Log.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "sms.get(0) is null, err, return");
            AppMethodBeat.o(48977);
        } else {
            this.gCh = (LinearLayout) view.findViewById(R.id.p0);
            this.hPW = (TextView) view.findViewById(R.id.ox);
            this.nzh = (TextView) view.findViewById(R.id.p1);
            this.nZP = (TextView) view.findViewById(R.id.p2);
            this.nZi = (Button) view.findViewById(R.id.om);
            this.kmk = (MMFormVerifyCodeInputView) view.findViewById(R.id.oy);
            this.mKeyboard = (MyKeyboardWindow) view.findViewById(R.id.oz);
            this.nZg = aa.jQ(getContext()).inflate(R.layout.bb, (ViewGroup) null);
            this.nZg.setBackgroundColor(getResources().getColor(R.color.a2r));
            this.mActionBarHelper = new a(this.nZg);
            this.gCh.addView(this.nZg, 0, new LinearLayout.LayoutParams(-1, b.eu(getActivity())));
            this.nZB = this.nZf.bXV();
            this.mActionBarHelper.setTitle(this.nZB.title);
            this.mActionBarHelper.setClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(48968);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (AppBrandIDCardVerifyPwdFrag.this.nZf != null) {
                        AppBrandIDCardVerifyPwdFrag.this.nZf.back();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(48968);
                }
            });
            this.hPW.setText(this.nZB.desc);
            this.nZO = this.nZB.KLJ.get(0);
            this.nzh.setText(this.nZB.KLJ.get(0).KLI);
            if (this.nZB.KLJ.size() > 1) {
                this.nZP.setVisibility(0);
                this.nZP.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag.AnonymousClass2 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(48971);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (AppBrandIDCardVerifyPwdFrag.this.nZf != null) {
                            AppBrandIDCardVerifyPwdFrag.this.nZf.bXT();
                        }
                        e eVar = new e((Context) AppBrandIDCardVerifyPwdFrag.this.getContext(), 1, false);
                        eVar.HLX = new o.f() {
                            /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag.AnonymousClass2.AnonymousClass1 */

                            @Override // com.tencent.mm.ui.base.o.f
                            public final void onCreateMMMenu(m mVar) {
                                AppMethodBeat.i(48969);
                                Log.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "phone_list.size %d", Integer.valueOf(AppBrandIDCardVerifyPwdFrag.this.nZB.KLJ.size()));
                                Iterator<hu> it = AppBrandIDCardVerifyPwdFrag.this.nZB.KLJ.iterator();
                                while (it.hasNext()) {
                                    hu next = it.next();
                                    if (Util.isNullOrNil(next.KLH) || Util.isNullOrNil(next.KLI)) {
                                        Log.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "phone_id or show_phone is empty, continue");
                                    } else {
                                        mVar.d(AppBrandIDCardVerifyPwdFrag.this.nZB.KLJ.indexOf(next), next.KLI);
                                    }
                                }
                                AppMethodBeat.o(48969);
                            }
                        };
                        eVar.HLY = new o.g() {
                            /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag.AnonymousClass2.AnonymousClass2 */

                            @Override // com.tencent.mm.ui.base.o.g
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                                AppMethodBeat.i(48970);
                                hu huVar = AppBrandIDCardVerifyPwdFrag.this.nZB.KLJ.get(menuItem.getItemId());
                                if (huVar == null) {
                                    Log.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "not find phone_id, menuItem id :%d", Integer.valueOf(menuItem.getItemId()));
                                    AppMethodBeat.o(48970);
                                    return;
                                }
                                Log.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "select menuItem id:%d, phone_id:%s, show_phone:%s, bank_type:%s", Integer.valueOf(menuItem.getItemId()), huVar.KLH, huVar.KLI, huVar.dDj);
                                AppBrandIDCardVerifyPwdFrag.this.nZO = huVar;
                                AppBrandIDCardVerifyPwdFrag.this.nzh.setText(huVar.KLI);
                                AppMethodBeat.o(48970);
                            }
                        };
                        eVar.dGm();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(48971);
                    }
                });
            } else {
                this.nZP.setVisibility(8);
            }
            this.kmk.setVisibility(0);
            this.kmk.setSendSmsBtnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(48974);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    h.a((Context) AppBrandIDCardVerifyPwdFrag.this.getContext(), AppBrandIDCardVerifyPwdFrag.this.getString(R.string.mh) + AppBrandIDCardVerifyPwdFrag.this.nZO.KLI, AppBrandIDCardVerifyPwdFrag.this.getString(R.string.mc), AppBrandIDCardVerifyPwdFrag.this.getString(R.string.x_), AppBrandIDCardVerifyPwdFrag.this.getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag.AnonymousClass3.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(48972);
                            AppBrandIDCardVerifyPwdFrag.this.kmk.bTu();
                            Log.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "sendSms click");
                            if (AppBrandIDCardVerifyPwdFrag.this.nZf != null) {
                                AppBrandIDCardVerifyPwdFrag.this.nZf.a(AppBrandIDCardVerifyPwdFrag.this.nZO);
                            }
                            AppMethodBeat.o(48972);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag.AnonymousClass3.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(48973);
                            AppBrandIDCardVerifyPwdFrag.this.kmk.reset();
                            AppMethodBeat.o(48973);
                        }
                    });
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(48974);
                }
            });
            this.kmk.addTextChangedListener(new TextWatcher() {
                /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag.AnonymousClass4 */

                public final void afterTextChanged(Editable editable) {
                    AppMethodBeat.i(48975);
                    if (AppBrandIDCardVerifyPwdFrag.this.kmk.getText().toString().length() > 0) {
                        AppBrandIDCardVerifyPwdFrag.this.nZi.setEnabled(true);
                        AppMethodBeat.o(48975);
                        return;
                    }
                    AppBrandIDCardVerifyPwdFrag.this.nZi.setEnabled(false);
                    AppMethodBeat.o(48975);
                }

                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }
            });
            EditText contentEditText = this.kmk.getContentEditText();
            if (contentEditText != null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    contentEditText.setShowSoftInputOnFocus(false);
                } else {
                    try {
                        Method method = EditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE);
                        method.setAccessible(true);
                        method.invoke(contentEditText, Boolean.FALSE);
                        method.setAccessible(false);
                    } catch (NoSuchMethodException e2) {
                        Log.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, setShowSoftInputOnFocus no such method, api level = %d", Integer.valueOf(Build.VERSION.SDK_INT));
                        try {
                            Method method2 = EditText.class.getMethod("setSoftInputShownOnFocus", Boolean.TYPE);
                            method2.setAccessible(true);
                            method2.invoke(contentEditText, Boolean.FALSE);
                            method2.setAccessible(false);
                        } catch (Exception e3) {
                            Log.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, reflect method [setSoftInputShownOnFocus], exp = %s", Util.stackTraceToString(e3));
                            if (contentEditText.getContext() != null && (contentEditText.getContext() instanceof MMActivity)) {
                                ((MMActivity) contentEditText.getContext()).hideVKB(contentEditText);
                            }
                        }
                    } catch (Exception e4) {
                        Log.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, reflect method [setShowSoftInputOnFocus], exp = %s", Util.stackTraceToString(e4));
                    }
                }
            }
            if (this.kmk.getText() == null || this.kmk.getText().toString().length() <= 0) {
                this.nZi.setEnabled(false);
            } else {
                this.nZi.setEnabled(true);
            }
            this.nZi.setVisibility(0);
            this.nZi.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag.AnonymousClass5 */

                public final void onClick(View view) {
                    AppMethodBeat.i(48976);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "verify sms click");
                    if (AppBrandIDCardVerifyPwdFrag.this.nZf != null) {
                        AppBrandIDCardVerifyPwdFrag.this.nZf.a(AppBrandIDCardVerifyPwdFrag.this.kmk.getText().toString(), AppBrandIDCardVerifyPwdFrag.this.nZO);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(48976);
                }
            });
            this.mKeyboard.setXMode(0);
            this.mKeyboard.setInputEditText(this.kmk.getContentEditText());
            if (Build.VERSION.SDK_INT >= 14) {
                this.mKeyboard.setAccessibilityDelegate(new d());
            }
            AppMethodBeat.o(48977);
        }
    }

    @Override // com.tencent.mm.ui.MMFragment
    public int getLayoutId() {
        return R.layout.e4;
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onResume() {
        AppMethodBeat.i(48978);
        super.onResume();
        if (isSupportNavigationSwipeBack()) {
            getContentView().setVisibility(0);
            getSwipeBackLayout().setEnableGesture(true);
        }
        AppMethodBeat.o(48978);
    }

    @Override // com.tencent.mm.ui.MMFragment
    public boolean noActionBar() {
        return true;
    }

    @Override // com.tencent.mm.ui.MMFragment
    public void onSwipeBack() {
        AppMethodBeat.i(48979);
        if (this.nZf != null) {
            this.nZf.onSwipeBack();
            getContentView().setVisibility(8);
            if (isSupportNavigationSwipeBack()) {
                getSwipeBackLayout().setEnableGesture(false);
            }
        }
        AppMethodBeat.o(48979);
    }
}
