package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

public class ProfileEditPhoneNumberView extends ProfileItemView implements MMPhoneNumberEditText.a {
    public String KcI;
    public String KcJ;
    public String[] KcK;
    private LinearLayout KcL;
    private boolean KcM = false;
    public a KcN;

    public interface a {
        void goV();

        void onChange();
    }

    static /* synthetic */ void a(ProfileEditPhoneNumberView profileEditPhoneNumberView, MMPhoneNumberEditText mMPhoneNumberEditText) {
        AppMethodBeat.i(31224);
        profileEditPhoneNumberView.h(mMPhoneNumberEditText);
        AppMethodBeat.o(31224);
    }

    static /* synthetic */ void b(ProfileEditPhoneNumberView profileEditPhoneNumberView) {
        AppMethodBeat.i(31225);
        profileEditPhoneNumberView.cZ(null, false);
        AppMethodBeat.o(31225);
    }

    public ProfileEditPhoneNumberView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ProfileEditPhoneNumberView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.pluginsdk.ui.ProfileItemView
    public int getLayout() {
        return R.layout.bjh;
    }

    @Override // com.tencent.mm.pluginsdk.ui.ProfileItemView
    public final void init() {
        AppMethodBeat.i(31213);
        this.KcL = (LinearLayout) findViewById(R.id.f6c);
        AppMethodBeat.o(31213);
    }

    public void clearFocus() {
        AppMethodBeat.i(31214);
        for (int i2 = 1; i2 < this.KcL.getChildCount(); i2++) {
            this.KcL.getChildAt(i2).clearFocus();
        }
        AppMethodBeat.o(31214);
    }

    @Override // com.tencent.mm.pluginsdk.ui.ProfileItemView
    public final boolean aj(as asVar) {
        this.rjX = asVar;
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.ui.ProfileItemView
    public final boolean eEV() {
        int i2;
        int i3;
        AppMethodBeat.i(31215);
        if (!Util.isNullOrNil(this.KcI)) {
            cZ(this.KcI, true);
            i2 = 1;
            i3 = 1;
        } else {
            i2 = 0;
            i3 = 0;
        }
        if (!Util.isNullOrNil(this.KcJ)) {
            this.KcK = com.tencent.mm.contact.a.a(this.rjX, this.KcJ);
            if (this.KcK != null) {
                while (i3 < this.KcK.length + i2) {
                    cZ(this.KcK[i3 - i2].trim(), false);
                    i3++;
                }
            }
        }
        if (i3 < 5) {
            cZ(null, false);
            this.KcM = false;
        } else {
            this.KcM = true;
        }
        AppMethodBeat.o(31215);
        return false;
    }

    public ArrayList<String> getPhoneNumberList() {
        AppMethodBeat.i(31216);
        int childCount = this.KcL.getChildCount();
        if (childCount == 0) {
            AppMethodBeat.o(31216);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>(childCount);
        for (int i2 = 0; i2 < childCount; i2++) {
            String obj = ((MMPhoneNumberEditText) this.KcL.getChildAt(i2)).getText().toString();
            if (!Util.isNullOrNil(obj) && !obj.trim().equals("")) {
                arrayList.add(obj);
            }
        }
        if (!Util.isNullOrNil(this.KcI) && arrayList.size() > 0) {
            arrayList.remove(0);
        }
        AppMethodBeat.o(31216);
        return arrayList;
    }

    private void goU() {
        AppMethodBeat.i(31217);
        if (this.KcN != null) {
            this.KcN.onChange();
        }
        AppMethodBeat.o(31217);
    }

    @Override // com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText.a
    public final void f(final MMPhoneNumberEditText mMPhoneNumberEditText) {
        AppMethodBeat.i(31218);
        if (mMPhoneNumberEditText.Kcq) {
            h.a(getContext(), (int) R.string.e00, 0, (int) R.string.dzz, (int) R.string.dzy, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(31212);
                    ProfileEditPhoneNumberView.this.KcI = "";
                    ProfileEditPhoneNumberView.this.KcN.goV();
                    ProfileEditPhoneNumberView.a(ProfileEditPhoneNumberView.this, mMPhoneNumberEditText);
                    if (!ProfileEditPhoneNumberView.this.KcM) {
                        ProfileEditPhoneNumberView.b(ProfileEditPhoneNumberView.this);
                    }
                    AppMethodBeat.o(31212);
                }
            }, (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(31218);
            return;
        }
        h(mMPhoneNumberEditText);
        if (this.KcM) {
            cZ(null, false);
            this.KcM = false;
        }
        goU();
        AppMethodBeat.o(31218);
    }

    @Override // com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText.a
    public final void goP() {
        AppMethodBeat.i(31219);
        goU();
        AppMethodBeat.o(31219);
    }

    @Override // com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText.a
    public final void goO() {
        AppMethodBeat.i(31220);
        if (this.KcL.getChildCount() < 5) {
            cZ(null, false);
        } else {
            this.KcM = true;
        }
        goU();
        AppMethodBeat.o(31220);
    }

    @Override // com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText.a
    public final void g(MMPhoneNumberEditText mMPhoneNumberEditText) {
        AppMethodBeat.i(31221);
        if (this.KcL.getChildCount() - 1 == 1) {
            AppMethodBeat.o(31221);
            return;
        }
        h(mMPhoneNumberEditText);
        if (this.KcM) {
            cZ(null, false);
        }
        this.KcM = false;
        goU();
        AppMethodBeat.o(31221);
    }

    private void cZ(String str, boolean z) {
        AppMethodBeat.i(31222);
        MMPhoneNumberEditText mMPhoneNumberEditText = (MMPhoneNumberEditText) LayoutInflater.from(getContext()).inflate(R.layout.bjg, (ViewGroup) null);
        mMPhoneNumberEditText.setHint(MMApplicationContext.getResources().getString(R.string.dd));
        if (z) {
            mMPhoneNumberEditText.goK();
        }
        mMPhoneNumberEditText.setCallback(this);
        mMPhoneNumberEditText.setText(str);
        mMPhoneNumberEditText.setSelection(mMPhoneNumberEditText.getText().length());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(com.tencent.mm.cb.a.fromDPToPix(getContext(), 16), com.tencent.mm.cb.a.fromDPToPix(getContext(), 0), 0, 0);
        this.KcL.addView(mMPhoneNumberEditText, layoutParams);
        AppMethodBeat.o(31222);
    }

    private void h(MMPhoneNumberEditText mMPhoneNumberEditText) {
        AppMethodBeat.i(31223);
        this.KcL.removeView(mMPhoneNumberEditText);
        this.KcL.getChildAt(this.KcL.getChildCount() - 1).requestFocus();
        AppMethodBeat.o(31223);
    }
}
