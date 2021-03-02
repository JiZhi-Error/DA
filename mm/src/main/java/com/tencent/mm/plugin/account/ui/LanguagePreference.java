package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class LanguagePreference extends Preference {
    public a kln;

    public static class a {
        public boolean isSelected;
        String klo;
        private String klp;
        public String klq;

        public a(String str, String str2, String str3, boolean z) {
            this.klo = str;
            this.klp = str2;
            this.klq = str3;
            this.isSelected = z;
        }
    }

    public LanguagePreference(Context context) {
        this(context, null);
    }

    public LanguagePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LanguagePreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(128055);
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(128055);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(128056);
        if (aVar == null || Util.isNullOrNil(aVar.klq)) {
            Log.e("MicroMsg.LanguagePreference", "setInfo info error");
            AppMethodBeat.o(128056);
            return;
        }
        this.kln = aVar;
        setKey(aVar.klq);
        AppMethodBeat.o(128056);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(128057);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.b9d, viewGroup2);
        AppMethodBeat.o(128057);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        int i2;
        boolean z = true;
        AppMethodBeat.i(128058);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.id.e7n);
        WeImageView weImageView = (WeImageView) view.findViewById(R.id.i4u);
        boolean z2 = textView != null;
        if (weImageView == null) {
            z = false;
        }
        if (z && z2) {
            textView.setText(this.kln.klo);
            if (this.kln.isSelected) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            weImageView.setVisibility(i2);
        }
        alO(8);
        AppMethodBeat.o(128058);
    }
}
