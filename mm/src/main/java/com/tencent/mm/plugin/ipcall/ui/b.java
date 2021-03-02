package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.ipcall.model.h.c;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.ipcall.ui.DialPad;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ewj;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;

public final class b {
    MMActivity gte;
    TextView hXv;
    String iEB;
    private PhoneFormater kqv;
    a ysW;
    private DialPad ysX;
    TextView ysY;
    EditText ysZ;
    View yta;
    private ImageButton ytb;
    View ytc;
    TextView ytd;
    TextView yte;
    String ytf;
    String ytg;
    String yth = "";
    String yti;
    LinkedList<ewj> ytj;
    long ytk = 0;
    boolean ytl = false;
    private Runnable ytm = new Runnable() {
        /* class com.tencent.mm.plugin.ipcall.ui.b.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(25586);
            if (System.currentTimeMillis() - b.this.ytk >= 500) {
                b.this.yti = com.tencent.mm.plugin.ipcall.a.a.ba(b.this.gte, b.this.ytg + b.this.yth);
                final c aBV = i.eay().aBV(b.this.yti);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.ipcall.ui.b.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(25584);
                        if (aBV == null || aBV.systemRowid == -1) {
                            b.this.hXv.setText("");
                            AppMethodBeat.o(25584);
                            return;
                        }
                        b.this.hXv.setText(aBV.field_systemAddressBookUsername);
                        AppMethodBeat.o(25584);
                    }
                });
                AppMethodBeat.o(25586);
                return;
            }
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.ipcall.ui.b.AnonymousClass1.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(25585);
                    b.this.hXv.setText("");
                    b.this.yti = null;
                    b.this.iEB = null;
                    AppMethodBeat.o(25585);
                }
            });
            AppMethodBeat.o(25586);
        }
    };
    private MMHandler ytn = new MMHandler("IPCallDialQueryPhoneNumber");
    boolean yto = false;
    private TextWatcher ytp = new TextWatcher() {
        /* class com.tencent.mm.plugin.ipcall.ui.b.AnonymousClass2 */

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            boolean z;
            int measureText;
            AppMethodBeat.i(25587);
            if (b.this.ytc.getLayoutParams() != null) {
                TextPaint paint = b.this.ysY.getPaint();
                if ("+".equals(b.this.ysY.getText().toString())) {
                    b.this.yta.setVisibility(8);
                    b.this.ytd.setVisibility(8);
                    measureText = (int) paint.measureText(b.this.ysY.getText().toString());
                } else {
                    b.this.yta.setVisibility(0);
                    b.this.ytd.setVisibility(0);
                    measureText = (int) paint.measureText(((Object) b.this.ysY.getText()) + "+");
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) b.this.ytc.getLayoutParams();
                layoutParams.width = measureText;
                b.this.ytc.setLayoutParams(layoutParams);
            }
            String replace = b.this.ysY.getText().toString().replace("+", "");
            if (com.tencent.mm.plugin.ipcall.a.a.aCx(replace)) {
                b.this.ytd.setText(com.tencent.mm.plugin.ipcall.a.a.aCv(replace));
                if (b.this.ytj != null && b.this.ytj.size() > 0) {
                    String aCw = com.tencent.mm.plugin.ipcall.a.a.aCw(replace);
                    Iterator<ewj> it = b.this.ytj.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        ewj next = it.next();
                        if (next != null && next.keh.equals(aCw)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
            } else {
                b.this.ytd.setText(b.this.gte.getString(R.string.e6_));
                z = false;
            }
            if (z) {
                b.this.yte.setVisibility(0);
            } else {
                b.this.yte.setVisibility(8);
            }
            if (b.this.ysW != null) {
                b.this.ysW.aCf(replace);
            }
            AppMethodBeat.o(25587);
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(25588);
            String replace = b.this.ysY.getText().toString().replace("+", "");
            if (replace.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO) || replace.startsWith("*") || replace.startsWith("#")) {
                b.this.ysY.setText("+");
                b.this.ytg = "+";
            }
            AppMethodBeat.o(25588);
        }
    };
    String ytq = "";

    public interface a {
        void aCf(String str);

        void aCg(String str);

        void u(String str, String str2, String str3, String str4);
    }

    public b(MMActivity mMActivity, EditText editText, TextView textView, View view, DialPad dialPad, ImageButton imageButton, TextView textView2, View view2, TextView textView3, TextView textView4) {
        AppMethodBeat.i(25597);
        this.gte = mMActivity;
        this.ysZ = editText;
        this.ysY = textView;
        this.yta = view;
        this.ysX = dialPad;
        this.ytb = imageButton;
        this.hXv = textView2;
        this.ytc = view2;
        this.ytd = textView3;
        this.yte = textView4;
        this.kqv = new PhoneFormater();
        this.ytg = com.tencent.mm.plugin.ipcall.a.c.ebO();
        String string = MMApplicationContext.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryName", "");
        this.ytf = Util.isNullOrNil(string) ? com.tencent.mm.plugin.ipcall.a.a.aCv(com.tencent.mm.plugin.ipcall.a.a.ebK()) : string;
        this.ysY.addTextChangedListener(this.ytp);
        this.ysY.setText("+" + this.ytg);
        this.ysX.setDialButtonClickListener(new DialPad.a() {
            /* class com.tencent.mm.plugin.ipcall.ui.b.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.ipcall.ui.DialPad.a
            public final void aCc(String str) {
                AppMethodBeat.i(25589);
                b.this.yth = b.this.ysZ.getText().toString();
                if (b.this.ytl) {
                    b.this.ytg += str;
                    b.this.ysY.setText(b.this.ytg);
                    if (com.tencent.mm.plugin.ipcall.a.a.aCx(b.this.ytg.replace("+", "")) || b.this.ytg.replace("+", "").length() >= 4) {
                        h.INSTANCE.a(12061, 0, 0, 0, 0, 1, 0);
                        b.this.ytl = false;
                        b.this.ytf = com.tencent.mm.plugin.ipcall.a.a.aCv(b.this.ytg.replace("+", ""));
                        b.this.yth = b.this.im(b.this.ytg.replace("+", ""), b.this.yth);
                        b.this.es(b.this.yth, -1);
                        AppMethodBeat.o(25589);
                        return;
                    }
                } else {
                    String replace = b.this.ysY.getText().toString().replace("+", "");
                    if (b.this.yto) {
                        StringBuffer stringBuffer = new StringBuffer(b.this.yth);
                        stringBuffer.insert(b.this.ysZ.getSelectionStart(), str);
                        b.this.yth = stringBuffer.toString();
                    } else {
                        b.this.yth += str;
                    }
                    if (b.this.yth.equals("00")) {
                        b.this.ysY.setText("+");
                        b.this.ytl = true;
                        b.this.ytg = "+";
                        b.this.yth = "";
                    }
                    if (com.tencent.mm.plugin.ipcall.a.a.aCx(b.this.ytg.replace("+", "") + b.this.yth)) {
                        b.this.ysY.setText("+" + b.this.ytg.replace("+", "") + b.this.yth);
                        b.this.ytf = com.tencent.mm.plugin.ipcall.a.a.aCv(b.this.ytg.replace("+", ""));
                        b.this.ytl = false;
                        b.this.ytg = b.this.ytg.replace("+", "") + b.this.yth;
                        b.this.yth = "";
                    }
                    String str2 = b.this.yth;
                    b.this.yth = b.this.im(replace, b.this.yth);
                    if (!b.this.yto) {
                        b.this.es(b.this.yth, -1);
                    } else if (str2.length() < b.this.yth.length()) {
                        b.this.es(b.this.yth, b.this.ysZ.getSelectionEnd() + 2);
                    } else if (str2.length() == b.this.yth.length()) {
                        b.this.es(b.this.yth, b.this.ysZ.getSelectionEnd() + 1);
                    } else if (str2.length() > b.this.yth.length()) {
                        b.this.es(b.this.yth, (b.this.ysZ.getSelectionEnd() + 1) - (str2.length() - b.this.yth.length()));
                    }
                    b.this.ytk = System.currentTimeMillis();
                    if (b.this.yth.length() > com.tencent.mm.plugin.ipcall.a.a.yzU && !Util.isNullOrNil(b.this.ytg + b.this.yth)) {
                        b.this.ebd();
                    }
                }
                AppMethodBeat.o(25589);
            }

            @Override // com.tencent.mm.plugin.ipcall.ui.DialPad.a
            public final void aCd(String str) {
                AppMethodBeat.i(25590);
                if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    b.this.ysY.setText("+");
                    b.this.ytl = true;
                    b.this.ytg = "+";
                }
                AppMethodBeat.o(25590);
            }
        });
        this.yta.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.b.AnonymousClass4 */

            public final void onClick(View view) {
                String substring;
                AppMethodBeat.i(25591);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/DialPadController$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String obj = b.this.ysZ.getText().toString();
                if (Util.isNullOrNil(obj)) {
                    String charSequence = b.this.ysY.getText().toString();
                    if (!Util.isNullOrNil(charSequence)) {
                        String substring2 = charSequence.substring(0, charSequence.length() - 1);
                        if (Util.isNullOrNil(substring2) || substring2.equals("+")) {
                            b.this.ysY.setText("+");
                            b.this.ytg = "+";
                            b.this.ytl = true;
                        } else {
                            b.this.ysY.setText(substring2);
                            b.this.ytg = substring2;
                        }
                    }
                } else {
                    int selectionStart = b.this.ysZ.getSelectionStart();
                    if (!b.this.yto || selectionStart - 1 < 0) {
                        substring = obj.substring(0, obj.length() - 1);
                    } else {
                        Editable text = b.this.ysZ.getText();
                        text.delete(selectionStart - 1, selectionStart);
                        substring = text.toString();
                    }
                    if (!Util.isNullOrNil(substring)) {
                        String replace = b.this.ysY.getText().toString().replace("+", "");
                        if (b.this.yto) {
                            b.this.yth = b.this.im(replace, substring);
                            b.this.es(b.this.yth, (b.this.yth.length() - substring.length()) + (selectionStart - 1));
                        } else {
                            b.this.yth = b.this.im(replace, substring);
                            b.this.es(b.this.yth, -1);
                        }
                        b.this.ebd();
                    } else {
                        b.this.yth = "";
                        b.this.es("", -1);
                    }
                    b.this.yti = "";
                    b.this.hXv.setText("");
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/DialPadController$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25591);
            }
        });
        this.yta.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.b.AnonymousClass5 */

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(25592);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/DialPadController$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                if (b.this.ytl) {
                    b.this.ytg = "+";
                    b.this.ysY.setText(b.this.ytg);
                } else {
                    b.this.hXv.setText("");
                    b.this.yth = "";
                    b.this.es("", -1);
                }
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/ipcall/ui/DialPadController$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(25592);
                return true;
            }
        });
        this.ysY.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.b.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(25593);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/DialPadController$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h.INSTANCE.a(12061, 0, 0, 0, 1, 0, 0);
                String replace = b.this.ysY.getText().toString().replace("+", "");
                Intent intent = new Intent(b.this.gte, IPCallCountryCodeSelectUI.class);
                intent.putExtra("couttry_code", replace);
                intent.putExtra("CountryCodeUI_isShowCountryCode", true);
                b.this.gte.startActivityForResult(intent, 100);
                b.this.gte.overridePendingTransition(R.anim.dq, -1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/DialPadController$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25593);
            }
        });
        this.ytb.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.b.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(25594);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/DialPadController$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b bVar2 = b.this;
                bVar2.ytg = bVar2.ysY.getText().toString();
                bVar2.yth = bVar2.ysZ.getText().toString();
                if (Util.isNullOrNil(bVar2.ytg) || Util.isNullOrNil(bVar2.yth)) {
                    String string = MMApplicationContext.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputPhoneNumber", "");
                    if (!Util.isNullOrNil(string)) {
                        bVar2.yth = bVar2.im(bVar2.ysY.getText().toString().replace("+", ""), com.tencent.mm.plugin.ipcall.a.c.trimPhoneNumber(string));
                        bVar2.es(bVar2.yth, -1);
                        bVar2.ebd();
                    }
                } else {
                    bVar2.ytg = bVar2.ysY.getText().toString().replace("+", "");
                    bVar2.yti = com.tencent.mm.plugin.ipcall.a.a.ba(bVar2.gte, bVar2.ytg + bVar2.yth);
                    bVar2.iEB = com.tencent.mm.plugin.ipcall.a.a.bc(bVar2.gte, bVar2.yti);
                    String trimPhoneNumber = com.tencent.mm.plugin.ipcall.a.c.trimPhoneNumber(bVar2.yth);
                    SharedPreferences.Editor edit = MMApplicationContext.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
                    edit.putString("IPCall_LastInputPhoneNumber", trimPhoneNumber);
                    edit.apply();
                    String charSequence = bVar2.ysY.getText().toString();
                    String str = bVar2.ytf;
                    if (!Util.isNullOrNil(charSequence)) {
                        if (Util.isNullOrNil(str)) {
                            str = "";
                        }
                        SharedPreferences.Editor edit2 = MMApplicationContext.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
                        edit2.putString("IPCall_LastInputCountryCode", charSequence.replace("+", ""));
                        edit2.putString("IPCall_LastInputCountryName", str);
                        edit2.apply();
                    }
                    if (bVar2.ysW != null) {
                        bVar2.ysW.u(bVar2.ytg, com.tencent.mm.plugin.ipcall.a.c.trimPhoneNumber(bVar2.yth), bVar2.yti, bVar2.iEB);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/DialPadController$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25594);
            }
        });
        this.ysZ.setHorizontallyScrolling(true);
        this.ysZ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.b.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(25595);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/DialPadController$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.this.ysZ.setCursorVisible(true);
                b.this.gte.hideVKB();
                b.this.yto = true;
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/DialPadController$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25595);
            }
        });
        this.ysZ.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.ipcall.ui.b.AnonymousClass9 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(25596);
                String trimPhoneNumber = Util.trimPhoneNumber(charSequence.toString());
                if (trimPhoneNumber.contains(" ")) {
                    trimPhoneNumber = trimPhoneNumber.replace(" ", "");
                    b.this.ysZ.setText(Util.filterNumber(trimPhoneNumber));
                } else if ((!b.this.ytq.equals(trimPhoneNumber) || i4 > 0) && Util.isNullOrNil(trimPhoneNumber)) {
                    b.this.ytq = trimPhoneNumber;
                    b.this.ysZ.setText("");
                }
                if (com.tencent.mm.plugin.ipcall.a.a.aCy(trimPhoneNumber)) {
                    String extractCountryCode = com.tencent.mm.plugin.ipcall.a.a.extractCountryCode(trimPhoneNumber);
                    if (!Util.isNullOrNil(extractCountryCode)) {
                        b.this.ysY.setText("+".concat(String.valueOf(extractCountryCode)));
                        b.this.ysZ.setText(com.tencent.mm.plugin.ipcall.a.a.aCB(trimPhoneNumber));
                    }
                } else if (!trimPhoneNumber.equals(b.this.ytq)) {
                    b.this.ytq = trimPhoneNumber;
                    b.this.ysZ.setText(trimPhoneNumber);
                    if (Util.isNullOrNil(b.this.ysY.getText().toString())) {
                        b.this.ysY.setText("+" + com.tencent.mm.plugin.ipcall.a.a.ebK());
                    }
                }
                if (b.this.ysW != null) {
                    b.this.ysW.aCg(b.this.ysZ.getText().toString());
                }
                AppMethodBeat.o(25596);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        if (d.oD(16)) {
            this.ysY.setTypeface(Typeface.create("sans-serif-light", 0));
            this.ysZ.setTypeface(Typeface.create("sans-serif-light", 0));
            this.hXv.setTypeface(Typeface.create("sans-serif-light", 0));
        }
        AppMethodBeat.o(25597);
    }

    public final void aCe(String str) {
        AppMethodBeat.i(25598);
        this.ytg = str;
        if (this.ysY != null) {
            this.ysY.setText("+".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(25598);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bb(java.util.LinkedList<com.tencent.mm.protocal.protobuf.ewj> r6) {
        /*
        // Method dump skipped, instructions count: 103
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.ui.b.bb(java.util.LinkedList):void");
    }

    /* access modifiers changed from: package-private */
    public final String im(String str, String str2) {
        AppMethodBeat.i(25600);
        String formatNumber = this.kqv.formatNumber(str, com.tencent.mm.plugin.ipcall.a.c.trimPhoneNumber(str2));
        if (Util.isNullOrNil(formatNumber)) {
            AppMethodBeat.o(25600);
            return str2;
        }
        AppMethodBeat.o(25600);
        return formatNumber;
    }

    public final void es(String str, int i2) {
        AppMethodBeat.i(25601);
        this.ysZ.setText(str);
        if (!Util.isNullOrNil(str)) {
            if (i2 != -1) {
                if (this.yto) {
                    if (i2 > 0 && i2 <= this.ysZ.getText().length()) {
                        this.ysZ.setSelection(i2);
                    }
                }
            }
            this.ysZ.setSelection(this.ysZ.getText().length());
        }
        this.yth = str;
        AppMethodBeat.o(25601);
    }

    public final void ebd() {
        AppMethodBeat.i(25602);
        this.ytn.removeCallbacks(this.ytm);
        this.ytn.postDelayed(this.ytm, 500);
        AppMethodBeat.o(25602);
    }
}
