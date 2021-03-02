package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public final class PluginEmptyTextPreference extends Preference {
    private Context context;
    private TextView gyt;
    private String text;

    public PluginEmptyTextPreference(Context context2) {
        this(context2, null, 0);
        AppMethodBeat.i(73906);
        this.text = context2.getString(R.string.gsn);
        AppMethodBeat.o(73906);
    }

    public PluginEmptyTextPreference(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(73907);
        this.gyt = null;
        this.context = context2;
        setLayoutResource(R.layout.bi9);
        AppMethodBeat.o(73907);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(73908);
        View onCreateView = super.onCreateView(viewGroup);
        View.inflate(this.context, R.layout.bi9, null);
        AppMethodBeat.o(73908);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(73909);
        super.onBindView(view);
        this.gyt = (TextView) view.findViewById(R.id.c3d);
        this.gyt.setText(this.text);
        AppMethodBeat.o(73909);
    }
}
