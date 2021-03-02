package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.ui.base.preference.Preference;

public class GameRegionPreference extends Preference {
    a xVD;

    public static class a {
        public String fuO;
        public boolean isDefault;
        public boolean isSelected;
        public String xVE;
        public String xVF;
        public String xVG;
    }

    public GameRegionPreference(Context context) {
        this(context, null);
    }

    public GameRegionPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GameRegionPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(42353);
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(42353);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(42354);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.asd, viewGroup2);
        AppMethodBeat.o(42354);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(42355);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.id.gzm);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.i4u);
        if (!(textView == null || checkBox == null || this.xVD == null)) {
            textView.setText(e.a(this.xVD));
            checkBox.setChecked(this.xVD.isSelected);
        }
        AppMethodBeat.o(42355);
    }
}
