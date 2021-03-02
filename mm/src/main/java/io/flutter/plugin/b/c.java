package io.flutter.plugin.b;

import android.graphics.Rect;
import android.os.Build;
import android.provider.Settings;
import android.text.Editable;
import android.text.Selection;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import io.flutter.embedding.engine.c.m;
import io.flutter.plugin.platform.PlatformViewsController;
import java.util.HashMap;

public final class c {
    private final m SOi;
    final AutofillManager SSG;
    public a SSH = new a(a.EnumC2253a.NO_TARGET, 0);
    m.a SSI;
    SparseArray<m.a> SSJ;
    public boolean SSK;
    public InputConnection SSL;
    Rect SSM;
    private final boolean SSN;
    public boolean SSO;
    Editable SSv;
    public final InputMethodManager SSy;
    public final View mView;
    private PlatformViewsController platformViewsController;

    interface b {
        void w(double d2, double d3);
    }

    public c(View view, m mVar, PlatformViewsController platformViewsController2) {
        boolean z;
        AppMethodBeat.i(214901);
        this.mView = view;
        this.SSy = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (Build.VERSION.SDK_INT >= 26) {
            this.SSG = (AutofillManager) view.getContext().getSystemService(AutofillManager.class);
        } else {
            this.SSG = null;
        }
        this.SOi = mVar;
        mVar.SRo = new m.e() {
            /* class io.flutter.plugin.b.c.AnonymousClass1 */

            @Override // io.flutter.embedding.engine.c.m.e
            public final void show() {
                AppMethodBeat.i(9937);
                c cVar = c.this;
                View view = c.this.mView;
                view.requestFocus();
                cVar.SSy.showSoftInput(view, 0);
                AppMethodBeat.o(9937);
            }

            @Override // io.flutter.embedding.engine.c.m.e
            public final void hide() {
                AppMethodBeat.i(9938);
                c.this.hR(c.this.mView);
                AppMethodBeat.o(9938);
            }

            @Override // io.flutter.embedding.engine.c.m.e
            public final void hxk() {
                AppMethodBeat.i(214889);
                c cVar = c.this;
                if (Build.VERSION.SDK_INT < 26 || cVar.SSG == null || !cVar.hxo()) {
                    AppMethodBeat.o(214889);
                    return;
                }
                String str = cVar.SSI.SRy.SRA;
                int[] iArr = new int[2];
                cVar.mView.getLocationOnScreen(iArr);
                Rect rect = new Rect(cVar.SSM);
                rect.offset(iArr[0], iArr[1]);
                cVar.SSG.notifyViewEntered(cVar.mView, str.hashCode(), rect);
                AppMethodBeat.o(214889);
            }

            @Override // io.flutter.embedding.engine.c.m.e
            public final void a(int i2, m.a aVar) {
                AppMethodBeat.i(9939);
                c cVar = c.this;
                cVar.SSH = new a(a.EnumC2253a.FRAMEWORK_CLIENT, i2);
                cVar.hxn();
                cVar.SSI = aVar;
                m.a[] aVarArr = aVar.SRz;
                if (aVar.SRy == null) {
                    cVar.SSJ = null;
                } else {
                    cVar.SSJ = new SparseArray<>();
                    if (aVarArr == null) {
                        cVar.SSJ.put(aVar.SRy.SRA.hashCode(), aVar);
                    } else {
                        for (m.a aVar2 : aVarArr) {
                            m.a.C2249a aVar3 = aVar2.SRy;
                            if (aVar3 != null) {
                                cVar.SSJ.put(aVar3.SRA.hashCode(), aVar2);
                            }
                        }
                    }
                }
                cVar.SSv = Editable.Factory.getInstance().newEditable("");
                cVar.SSK = true;
                cVar.SSO = false;
                cVar.SSM = null;
                AppMethodBeat.o(9939);
            }

            @Override // io.flutter.embedding.engine.c.m.e
            public final void atw(int i2) {
                AppMethodBeat.i(9940);
                c cVar = c.this;
                cVar.mView.requestFocus();
                cVar.SSH = new a(a.EnumC2253a.PLATFORM_VIEW, i2);
                cVar.SSy.restartInput(cVar.mView);
                cVar.SSK = false;
                AppMethodBeat.o(9940);
            }

            @Override // io.flutter.embedding.engine.c.m.e
            public final void a(m.d dVar) {
                AppMethodBeat.i(9941);
                c.this.a(c.this.mView, dVar);
                AppMethodBeat.o(9941);
            }

            @Override // io.flutter.embedding.engine.c.m.e
            public final void a(double d2, double d3, double[] dArr) {
                AppMethodBeat.i(214890);
                c cVar = c.this;
                double[] dArr2 = new double[4];
                boolean z = dArr[3] == 0.0d && dArr[7] == 0.0d && dArr[15] == 1.0d;
                double d4 = dArr[12] / dArr[15];
                dArr2[1] = d4;
                dArr2[0] = d4;
                double d5 = dArr[13] / dArr[15];
                dArr2[3] = d5;
                dArr2[2] = d5;
                AnonymousClass2 r7 = new b(z, dArr, dArr2) {
                    /* class io.flutter.plugin.b.c.AnonymousClass2 */
                    final /* synthetic */ boolean SSQ;
                    final /* synthetic */ double[] SSR;
                    final /* synthetic */ double[] SSS;

                    {
                        this.SSQ = r2;
                        this.SSR = r3;
                        this.SSS = r4;
                    }

                    @Override // io.flutter.plugin.b.c.b
                    public final void w(double d2, double d3) {
                        double d4 = this.SSQ ? 1.0d : 1.0d / (((this.SSR[3] * d2) + (this.SSR[7] * d3)) + this.SSR[15]);
                        double d5 = ((this.SSR[0] * d2) + (this.SSR[4] * d3) + this.SSR[12]) * d4;
                        double d6 = d4 * ((this.SSR[1] * d2) + (this.SSR[5] * d3) + this.SSR[13]);
                        if (d5 < this.SSS[0]) {
                            this.SSS[0] = d5;
                        } else if (d5 > this.SSS[1]) {
                            this.SSS[1] = d5;
                        }
                        if (d6 < this.SSS[2]) {
                            this.SSS[2] = d6;
                        } else if (d6 > this.SSS[3]) {
                            this.SSS[3] = d6;
                        }
                    }
                };
                r7.w(d2, 0.0d);
                r7.w(d2, d3);
                r7.w(0.0d, d3);
                Float valueOf = Float.valueOf(cVar.mView.getContext().getResources().getDisplayMetrics().density);
                cVar.SSM = new Rect((int) (dArr2[0] * ((double) valueOf.floatValue())), (int) (dArr2[2] * ((double) valueOf.floatValue())), (int) Math.ceil(dArr2[1] * ((double) valueOf.floatValue())), (int) Math.ceil(dArr2[3] * ((double) valueOf.floatValue())));
                AppMethodBeat.o(214890);
            }

            @Override // io.flutter.embedding.engine.c.m.e
            public final void hxl() {
                AppMethodBeat.i(9942);
                c cVar = c.this;
                if (cVar.SSH.SST != a.EnumC2253a.PLATFORM_VIEW) {
                    cVar.SSH = new a(a.EnumC2253a.NO_TARGET, 0);
                    cVar.SSO = false;
                    cVar.hxn();
                    cVar.SSM = null;
                }
                AppMethodBeat.o(9942);
            }
        };
        mVar.bbv.a("TextInputClient.requestExistingInputState", null, null);
        this.platformViewsController = platformViewsController2;
        this.platformViewsController.SMp = this;
        if (this.SSy.getCurrentInputMethodSubtype() == null || Build.VERSION.SDK_INT < 21 || !Build.MANUFACTURER.equals("samsung")) {
            z = false;
        } else {
            z = Settings.Secure.getString(this.mView.getContext().getContentResolver(), "default_input_method").contains("Samsung");
        }
        this.SSN = z;
        AppMethodBeat.o(214901);
    }

    public final void destroy() {
        this.platformViewsController.SMp = null;
        this.SOi.SRo = null;
    }

    private static int a(m.b bVar, boolean z, boolean z2, boolean z3, m.c cVar) {
        if (bVar.SRD == m.f.DATETIME) {
            return 4;
        }
        if (bVar.SRD == m.f.NUMBER) {
            int i2 = 2;
            if (bVar.SRE) {
                i2 = 4098;
            }
            if (bVar.SRF) {
                return i2 | 8192;
            }
            return i2;
        } else if (bVar.SRD == m.f.PHONE) {
            return 3;
        } else {
            int i3 = 1;
            if (bVar.SRD == m.f.MULTILINE) {
                i3 = 131073;
            } else if (bVar.SRD == m.f.EMAIL_ADDRESS) {
                i3 = 33;
            } else if (bVar.SRD == m.f.URL) {
                i3 = 17;
            } else if (bVar.SRD == m.f.VISIBLE_PASSWORD) {
                i3 = 145;
            } else if (bVar.SRD == m.f.NAME) {
                i3 = 97;
            } else if (bVar.SRD == m.f.POSTAL_ADDRESS) {
                i3 = 113;
            }
            if (z) {
                i3 = i3 | 524288 | 128;
            } else {
                if (z2) {
                    i3 |= 32768;
                }
                if (!z3) {
                    i3 |= 524288;
                }
            }
            if (cVar == m.c.CHARACTERS) {
                return i3 | 4096;
            }
            if (cVar == m.c.WORDS) {
                return i3 | 8192;
            }
            if (cVar == m.c.SENTENCES) {
                return i3 | 16384;
            }
            return i3;
        }
    }

    public final InputConnection a(View view, EditorInfo editorInfo) {
        int intValue;
        AppMethodBeat.i(9956);
        if (this.SSH.SST == a.EnumC2253a.NO_TARGET) {
            this.SSL = null;
            AppMethodBeat.o(9956);
            return null;
        } else if (this.SSH.SST != a.EnumC2253a.PLATFORM_VIEW) {
            editorInfo.inputType = a(this.SSI.SRv, this.SSI.SRr, this.SSI.SRs, this.SSI.SRt, this.SSI.SRu);
            editorInfo.imeOptions = TPMediaCodecProfileLevel.HEVCHighTierLevel62;
            if (this.SSI.SRw == null) {
                intValue = (131072 & editorInfo.inputType) != 0 ? 1 : 6;
            } else {
                intValue = this.SSI.SRw.intValue();
            }
            if (this.SSI.SRx != null) {
                editorInfo.actionLabel = this.SSI.SRx;
                editorInfo.actionId = intValue;
            }
            editorInfo.imeOptions = intValue | editorInfo.imeOptions;
            b bVar = new b(view, this.SSH.id, this.SOi, this.SSv, editorInfo);
            editorInfo.initialSelStart = Selection.getSelectionStart(this.SSv);
            editorInfo.initialSelEnd = Selection.getSelectionEnd(this.SSv);
            this.SSL = bVar;
            InputConnection inputConnection = this.SSL;
            AppMethodBeat.o(9956);
            return inputConnection;
        } else if (this.SSO) {
            InputConnection inputConnection2 = this.SSL;
            AppMethodBeat.o(9956);
            return inputConnection2;
        } else {
            this.SSL = this.platformViewsController.r(Integer.valueOf(this.SSH.id)).onCreateInputConnection(editorInfo);
            InputConnection inputConnection3 = this.SSL;
            AppMethodBeat.o(9956);
            return inputConnection3;
        }
    }

    public final void hR(View view) {
        AppMethodBeat.i(9957);
        hxn();
        this.SSy.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
        AppMethodBeat.o(9957);
    }

    /* access modifiers changed from: package-private */
    public final void hxn() {
        AppMethodBeat.i(214902);
        if (Build.VERSION.SDK_INT < 26 || this.SSG == null || this.SSI == null || this.SSI.SRy == null) {
            AppMethodBeat.o(214902);
            return;
        }
        this.SSG.notifyViewExited(this.mView, this.SSI.SRy.SRA.hashCode());
        AppMethodBeat.o(214902);
    }

    /* access modifiers changed from: package-private */
    public final void a(View view, m.d dVar) {
        AppMethodBeat.i(214903);
        if (!dVar.text.equals(this.SSv.toString())) {
            this.SSv.replace(0, this.SSv.length(), dVar.text);
        }
        String obj = this.SSv.toString();
        if (Build.VERSION.SDK_INT >= 26 && this.SSG != null && hxo()) {
            this.SSG.notifyValueChanged(this.mView, this.SSI.SRy.SRA.hashCode(), AutofillValue.forText(obj));
        }
        int i2 = dVar.selectionStart;
        int i3 = dVar.selectionEnd;
        if (i2 < 0 || i2 > this.SSv.length() || i3 < 0 || i3 > this.SSv.length()) {
            Selection.removeSelection(this.SSv);
        } else {
            Selection.setSelection(this.SSv, i2, i3);
        }
        InputConnection inputConnection = this.SSL;
        if (inputConnection != null && (inputConnection instanceof b)) {
            ((b) inputConnection).SSB = false;
        }
        if (this.SSN || this.SSK) {
            this.SSy.restartInput(view);
            this.SSK = false;
            AppMethodBeat.o(214903);
            return;
        }
        this.SSy.updateSelection(this.mView, Math.max(Selection.getSelectionStart(this.SSv), 0), Math.max(Selection.getSelectionEnd(this.SSv), 0), BaseInputConnection.getComposingSpanStart(this.SSv), BaseInputConnection.getComposingSpanEnd(this.SSv));
        AppMethodBeat.o(214903);
    }

    /* access modifiers changed from: package-private */
    public final boolean hxo() {
        return this.SSJ != null;
    }

    public final void a(ViewStructure viewStructure) {
        AppMethodBeat.i(214904);
        if (Build.VERSION.SDK_INT < 26 || !hxo()) {
            AppMethodBeat.o(214904);
            return;
        }
        String str = this.SSI.SRy.SRA;
        AutofillId autofillId = viewStructure.getAutofillId();
        for (int i2 = 0; i2 < this.SSJ.size(); i2++) {
            int keyAt = this.SSJ.keyAt(i2);
            m.a.C2249a aVar = this.SSJ.valueAt(i2).SRy;
            if (aVar != null) {
                viewStructure.addChildCount(1);
                ViewStructure newChild = viewStructure.newChild(i2);
                newChild.setAutofillId(autofillId, keyAt);
                newChild.setAutofillValue(AutofillValue.forText(aVar.SRC.text));
                newChild.setAutofillHints(aVar.SRB);
                newChild.setAutofillType(1);
                newChild.setVisibility(0);
                if (str.hashCode() != keyAt || this.SSM == null) {
                    newChild.setDimens(0, 0, 0, 0, 1, 1);
                } else {
                    newChild.setDimens(this.SSM.left, this.SSM.top, 0, 0, this.SSM.width(), this.SSM.height());
                }
            }
        }
        AppMethodBeat.o(214904);
    }

    public final void autofill(SparseArray<AutofillValue> sparseArray) {
        AppMethodBeat.i(214905);
        if (Build.VERSION.SDK_INT < 26) {
            AppMethodBeat.o(214905);
            return;
        }
        m.a.C2249a aVar = this.SSI.SRy;
        if (aVar == null) {
            AppMethodBeat.o(214905);
            return;
        }
        HashMap<String, m.d> hashMap = new HashMap<>();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            m.a aVar2 = this.SSJ.get(sparseArray.keyAt(i2));
            if (!(aVar2 == null || aVar2.SRy == null)) {
                m.a.C2249a aVar3 = aVar2.SRy;
                String charSequence = sparseArray.valueAt(i2).getTextValue().toString();
                m.d dVar = new m.d(charSequence, charSequence.length(), charSequence.length());
                if (aVar3.SRA.equals(aVar.SRA)) {
                    a(this.mView, dVar);
                }
                hashMap.put(aVar3.SRA, dVar);
            }
        }
        this.SOi.a(this.SSH.id, hashMap);
        AppMethodBeat.o(214905);
    }

    public static class a {
        public EnumC2253a SST;
        public int id;

        /* renamed from: io.flutter.plugin.b.c$a$a  reason: collision with other inner class name */
        public enum EnumC2253a {
            NO_TARGET,
            FRAMEWORK_CLIENT,
            PLATFORM_VIEW;

            public static EnumC2253a valueOf(String str) {
                AppMethodBeat.i(9935);
                EnumC2253a aVar = (EnumC2253a) Enum.valueOf(EnumC2253a.class, str);
                AppMethodBeat.o(9935);
                return aVar;
            }

            static {
                AppMethodBeat.i(9936);
                AppMethodBeat.o(9936);
            }
        }

        public a(EnumC2253a aVar, int i2) {
            this.SST = aVar;
            this.id = i2;
        }
    }
}
